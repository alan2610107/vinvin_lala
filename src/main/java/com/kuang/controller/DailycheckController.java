package com.kuang.controller;

import com.alibaba.fastjson.JSONArray;
import com.kuang.pojo.User;
import com.kuang.pojo.VinCheck;
import com.kuang.pojo.VinItem;
import com.kuang.pojo.Warehouse;
import com.kuang.service.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
@Slf4j
@Controller
@RequestMapping("/dailycheck")
public class DailycheckController {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Resource
    QueryDailyCheckService queryDailyCheckService;

    @Resource
    GenerateAndDownloadCSVService generateAndDownloadCSVService;

    @Resource
    GenerateAndDownloadExcelFileService generateAndDownloadExcelFileService;

    @Resource
    DailycheckControllerService dailycheckControllerService;

    @Resource
    CacheService cacheService;



    //  日盤頁面
    @RequestMapping("/toDailyCheck")
    public String toDailyCheck(Model model, HttpSession session, @RequestParam String location) throws ExecutionException, InterruptedException {
        User user = (User) session.getAttribute("user");
        if (vinService.ifAccess(user,location)) {
            dailycheckControllerService.toDailyCheck(model, location);
            Map<String, String> expiredItemMap = cacheService.getExpiredItemCache(location);
            Map<String, String> expiredSoonItemMap = cacheService.getExpiredSoonItemCache(location);
            model.addAttribute("expiredItemMap", expiredItemMap);
            model.addAttribute("expiredSoonItemMap", expiredSoonItemMap);

            return "alldailycheck";
        } else {
            model.addAttribute("msg", "哭哭！沒有權限！");
            return "login";
        }
    }


    //  提交日盤
    @RequestMapping("/agree")
    public String agreeFunction(@RequestParam("items[]") String items, String location, String itemtype, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (vinService.ifAccess(user,location)){
            List<String> idsList = new ArrayList<>();
            List<String> itemNamesList = new ArrayList<>();
            List<String> itemBrandsList = new ArrayList<>();
            List<String> itemCountsList = new ArrayList<>();
            System.out.println(itemtype);
            System.out.println(location);
//        List<String> memosList = new ArrayList<>();
            JSONArray jsonarray = JSONArray.parseArray(items);
            for (int i = 0; i < jsonarray.size(); i++) {
                idsList.add(JSONArray.parseArray(jsonarray.getString(i).toLowerCase(Locale.ROOT)).get(0).toString());
                itemNamesList.add(JSONArray.parseArray(jsonarray.getString(i).toLowerCase(Locale.ROOT)).get(1).toString());
                itemBrandsList.add(JSONArray.parseArray(jsonarray.getString(i).toLowerCase(Locale.ROOT)).get(2).toString());
                itemCountsList.add(JSONArray.parseArray(jsonarray.getString(i).toLowerCase(Locale.ROOT)).get(3).toString());
//            memosList.add(JSONArray.parseArray(jsonarray.getString(i).toLowerCase(Locale.ROOT)).get(4).toString());
            }
            System.out.println(idsList);
            System.out.println(itemNamesList);
            System.out.println(itemBrandsList);
            System.out.println(itemCountsList);
//        System.out.println(memosList);

            String id;
            String itemName;
            String brand;
            int checkcount;
            int realcount;
            String memo;
            for (int i = 0; i < jsonarray.size(); i++) {
                id = idsList.get(i);
                itemName = itemNamesList.get(i);
                brand = itemBrandsList.get(i);
                checkcount = Integer.parseInt(itemCountsList.get(i));
                realcount = vinService.queryVinItemCount(location,itemtype,id);
                String logid = vinService.getUUID();

                String time = vinService.getDate();
                VinCheck vinCheck = new VinCheck();
                vinCheck.setLogid(logid);
                vinCheck.setId(id);
                vinCheck.setItemName(itemName);
                vinCheck.setBrand(brand);
                vinCheck.setCheckitemCount(checkcount);
                vinCheck.setRealitemCount(realcount);
                if (realcount == checkcount) {
                    vinCheck.setIfmatch("same");
                    vinCheck.setDifference(0);
                } else if (realcount < checkcount) {
                    vinCheck.setIfmatch("more");
                    int difference = checkcount - realcount;
                    vinCheck.setDifference(difference);
                } else {
                    vinCheck.setIfmatch("less");
                    int difference = realcount - checkcount;
                    vinCheck.setDifference(difference);
                }
                vinCheck.setTime(time);
                vinCheck.setCategory(itemtype);
                System.out.println(vinCheck);
                vinService.kafkaAddDailyCheck(vinCheck, location);


            }
            return "redirect:/dailycheck/toDailyCheck?location=" + location;
        }else {
            model.addAttribute("msg", "哭哭！沒有權限！");
            return "login";
        }

    }

    //  日盤結果
    @RequestMapping("/result")
    public String dailyCheckResult(Model model, HttpSession httpSession, @RequestParam String location) throws ExecutionException, InterruptedException {
        User user = (User) httpSession.getAttribute("user");
        if (vinService.ifAccess(user,location)) {
            dailycheckControllerService.showDailyCheckResult(model, location);
        } else {
            model.addAttribute("msg", "哭哭！沒有權限！");
            return "login";
        }
        return "alldailycheckresult";
    }

    //Download
    @RequestMapping("/download")
    public String downloadDailyCheckCSV(HttpServletRequest request, HttpServletResponse response, String location, String downloadDate) throws IOException, InterruptedException {
        System.out.println(location + "," + downloadDate);
        List<VinCheck> listTool = dailycheckControllerService.getDailyCheckList(location, "tool", downloadDate);
        List<VinCheck> listSmallTool = dailycheckControllerService.getDailyCheckList(location, "smalltool", downloadDate);
        List<VinCheck> listFood = dailycheckControllerService.getDailyCheckList(location, "food", downloadDate);
        List<VinCheck> listCommercial = dailycheckControllerService.getDailyCheckList(location, "commercialthing", downloadDate);
        List<VinCheck> listOther = dailycheckControllerService.getDailyCheckList(location, "other", downloadDate);
        String reportNameTool = location + "-" + "設備-" + downloadDate + ".csv";
        String reportNameSmallTool = location + "-" + "smalltool-" + downloadDate + ".csv";
        String reportNameFood = location + "-" + "food-" + downloadDate + ".csv";
        String reportNameCommercial = location + "-" + "commercial-" + downloadDate + ".csv";
        String reportNameOther = location + "-" + "other-" + downloadDate + ".csv";

        System.out.println("===tool===");
        generateAndDownloadCSVService.downloadCSV(response, reportNameTool, listTool);
        System.out.println("===smalltool===");
        generateAndDownloadCSVService.downloadCSV(response, reportNameSmallTool, listSmallTool);
        System.out.println("===food===");
        generateAndDownloadCSVService.downloadCSV(response, reportNameFood, listFood);
        System.out.println("===commercial===");
        generateAndDownloadCSVService.downloadCSV(response, reportNameCommercial, listCommercial);
        System.out.println("===other===");
        generateAndDownloadCSVService.downloadCSV(response, reportNameOther, listOther);
        return "redirect:/dailycheck/dailycheckresult" + location;
    }


    @RequestMapping("/downloadExcel")
    public void downloadDailyCheckTool(HttpServletRequest request, HttpServletResponse response, String location, String downloadDate, HttpSession httpSession, @RequestParam String category) throws IOException, InterruptedException {
        User user = (User) httpSession.getAttribute("user");
        if(vinService.ifAccess(user,location)){
            System.out.println(location + "," + downloadDate);
            if (location!=null && downloadDate != null){
                List<VinCheck> listTool = dailycheckControllerService.getDailyCheckList(location, category, downloadDate);
                Map<String,List<VinCheck>> vinCheckMap = new HashMap<>();
                String sheetName = null;
                switch (category){
                    case "tool":
                        sheetName = "設備";
                        break;
                    case "smalltool":
                        sheetName = "小器具";
                        break;
                    case "food":
                        sheetName = "物料";
                        break;
                    case "commercialthing":
                        sheetName = "宣傳物料";
                        break;
                    case "other":
                        sheetName = "其他";
                        break;
                    default:
                        log.error("Wrong name of category!!!!");
                }
                vinCheckMap.put(sheetName, listTool);
                String reportName = location + "-" + category + "-" + downloadDate + ".xlsx";
                String[] headers = {"名字", "品牌", "日盤数量", "實際数量", "時間", "狀態"};
                generateAndDownloadExcelFileService.downloadExcel(response, reportName ,vinCheckMap, headers);
            }
        }


    }

}
