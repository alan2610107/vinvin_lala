package com.kuang.controller;

import com.alibaba.fastjson.JSONArray;
import com.kuang.pojo.*;
import com.kuang.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/confirm")
public class ConfirmController {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    @Resource
    private CacheService cacheService;

    @Resource
    private LogService logService;

    @Resource
    private UserpageControllerService userpageControllerService;

    @Resource
    private VinMainControllerService vinMainControllerService;

    public HashMap<String, List<VinLog>> getConfirm(String location){
        List<VinLog> confirmListTool = null;
        List<VinLog> confirmListSmallTool = null;
        List<VinLog> confirmListFood = null;
        List<VinLog> confirmListCommercial = null;
        List<VinLog> confirmListOther = null;
        HashMap<String, List<VinLog>> confirmMap = new HashMap<>();
        switch (location){
            case "main0":
                confirmListTool = vinService.queryCategoryConfirminMain0("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminMain0("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminMain0("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminMain0("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminMain0("other", "newinput", "input");
                break;
            case "main1":
                confirmListTool = vinService.queryCategoryConfirminMain1("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminMain1("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminMain1("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminMain1("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminMain1("other", "newinput", "input");
                break;
            case "main2":
                confirmListTool = vinService.queryCategoryConfirminMain2("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminMain2("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminMain2("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminMain2("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminMain2("other", "newinput", "input");
                break;
            case "shop1":
                confirmListTool = vinService.queryCategoryConfirminShop1("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminShop1("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminShop1("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminShop1("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminShop1("other", "newinput", "input");
                break;
            case "shop2":
                confirmListTool = vinService.queryCategoryConfirminShop2("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminShop2("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminShop2("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminShop2("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminShop2("other", "newinput", "input");
                break;
            case "shop3":
                confirmListTool = vinService.queryCategoryConfirminShop3("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminShop3("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminShop3("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminShop3("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminShop3("other", "newinput", "input");
                break;
            case "shop4":
                confirmListTool = vinService.queryCategoryConfirminShop4("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminShop4("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminShop4("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminShop4("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminShop4("other", "newinput", "input");
                break;
            case "shop5":
                confirmListTool = vinService.queryCategoryConfirminShop5("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminShop5("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminShop5("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminShop5("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminShop5("other", "newinput", "input");
                break;
            case "shop6":
                confirmListTool = vinService.queryCategoryConfirminShop6("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminShop6("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminShop6("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminShop6("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminShop6("other", "newinput", "input");
                break;
            case "shop7":
                confirmListTool = vinService.queryCategoryConfirminShop7("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminShop7("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminShop7("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminShop7("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminShop7("other", "newinput", "input");
                break;
            case "shop8":
                confirmListTool = vinService.queryCategoryConfirminShop8("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminShop8("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminShop8("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminShop8("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminShop8("other", "newinput", "input");
                break;
            case "shop9":
                confirmListTool = vinService.queryCategoryConfirminShop9("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminShop9("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminShop9("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminShop9("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminShop9("other", "newinput", "input");
                break;
            case "shop10":
                confirmListTool = vinService.queryCategoryConfirminShop10("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminShop10("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminShop10("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminShop10("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminShop10("other", "newinput", "input");
                break;
            case "shop11":
                confirmListTool = vinService.queryCategoryConfirminShop11("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminShop11("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminShop11("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminShop11("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminShop11("other", "newinput", "input");
                break;
            case "shop12":
                confirmListTool = vinService.queryCategoryConfirminShop12("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminShop12("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminShop12("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminShop12("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminShop12("other", "newinput", "input");
                break;
        }
        confirmMap.put("confirmListTool", confirmListTool);
        confirmMap.put("confirmListSmallTool", confirmListSmallTool);
        confirmMap.put("confirmListFood", confirmListFood);
        confirmMap.put("confirmListCommercial", confirmListCommercial);
        confirmMap.put("confirmListOther", confirmListOther);

        return confirmMap;
    }
    public Map<String,String> getFilePathMap(List<VinLog> vinLogList){
        Map<String,String> filePathMap = new HashMap<>();
        for (VinLog vinLog : vinLogList) {
            String itemID = vinLog.getId();
            String filePath = null;
            int ifExit = 0;
            ifExit = vinService.ifExistFileTypebyID(itemID);
            if(ifExit>0){
                filePath = vinService.queryFileTypebyid(itemID).getFilepath();
            }
            filePathMap.put(itemID,filePath);
        }
        return filePathMap;
    }

    @RequestMapping("/listnotpass")
    public String listNotpassConfirm(Model model, HttpSession session, @RequestParam String location){
        User user = (User) session.getAttribute("user");
        if(user.getLevel() == 1000){
            HashMap<String, List<VinLog>> confirmMap = getConfirm(location);
            List<VinLog> confirmListTool = confirmMap.get("confirmListTool");
            List<VinLog> confirmListFood = confirmMap.get("confirmListFood");
            List<VinLog> confirmListSmallTool = confirmMap.get("confirmListSmallTool");
            List<VinLog> confirmListCommercial = confirmMap.get("confirmListCommercial");
            List<VinLog> confirmListOther = confirmMap.get("confirmListOther");

            Map<String,String> ToolFilePathMap = getFilePathMap(confirmListTool);
            Map<String,String> FoodFilePathMap = getFilePathMap(confirmListFood);
            Map<String,String> SmallToolFilePathMap = getFilePathMap(confirmListSmallTool);
            Map<String,String> CommercialFilePathMap = getFilePathMap(confirmListCommercial);
            Map<String,String> OtherFilePathMap = getFilePathMap(confirmListOther);
            System.out.println(ToolFilePathMap);
            model.addAttribute("ToolFilePathMap",ToolFilePathMap);
            model.addAttribute("FoodFilePathMap",FoodFilePathMap);
            model.addAttribute("SmallToolFilePathMap",SmallToolFilePathMap);
            model.addAttribute("CommercialFilePathMap",CommercialFilePathMap);
            model.addAttribute("OtherFilePathMap",OtherFilePathMap);
            model.addAttribute("listItem", confirmListTool);
            model.addAttribute("listFood", confirmListFood);
            model.addAttribute("listSmallItem", confirmListSmallTool);
            model.addAttribute("listCommercialthing", confirmListCommercial);
            model.addAttribute("listOther", confirmListOther);
            Warehouse warehouse = vinService.queryRealWarehouseName(location);
            String realname = warehouse.getRealname();
            model.addAttribute("warehouse", realname+"審核");
            model.addAttribute("logLocation", location);
            model.addAttribute("function", "notpass");
            model.addAttribute("categoryTool", "tool");
            model.addAttribute("categorySmallTool", "smalltool");
            model.addAttribute("categoryFood", "food");
            model.addAttribute("categoryCommercial", "commercial");
            model.addAttribute("categoryOther", "other");
            model.addAttribute("warehouseMap", vinService.getWarehouseMap());
            model.addAttribute("actionMap", vinService.getActionMap());
            return "allconfirm";

        }else {
            model.addAttribute("msg", "哭哭！沒有權限！");
            return "login";
        }

    }


    @RequestMapping("agree")
    public String agree(@RequestParam("confirmInput[]") String confirmInput, String location, String itemtype) throws InterruptedException {
        System.out.println(location);
        System.out.println(itemtype);

        JSONArray jsonarray = JSONArray.parseArray(confirmInput);
        System.out.println(jsonarray);
        String logid = jsonarray.getString(0);
        if(cacheService.ifDobyLogid(logid, "confirm")){
            log.warn("=====Allow to do=====");
            int confirmLogCount = Integer.parseInt(jsonarray.getString(1)); //實際通過的
            VinLog originVinLog = logService.getLogbylogid(location, logid);
            int originLogCount = originVinLog.getItemCount();//原本申請的
            VinLog updateVinLog = new VinLog(originVinLog);//要更新的vinLog
            String from = originVinLog.getFrom();

//            System.out.println(originVinLog);
//            System.out.println(originVinLog.getFrom());

            //如果Confirm的數量跟原本不一樣
            if(originLogCount != confirmLogCount){
                updateVinLog.setItemCount(confirmLogCount);
                updateVinLog.setTotalPrice(Math.round(confirmLogCount * originVinLog.getSinglePrice() * 100.0) / 100.0);

                VinItem inputVinItem = vinService.getVinItem(from,itemtype,originVinLog.getId());
                inputVinItem.setItemCount(originLogCount - confirmLogCount);
                inputVinItem.setSinglePrice(originVinLog.getSinglePrice());
                inputVinItem.setTotalPrice(Math.round(inputVinItem.getSinglePrice() * inputVinItem.getItemCount() * 100.0) / 100.0);

                //還回from
                vinMainControllerService.doInputVinItem(inputVinItem, from, itemtype);

                //更改from的紀錄
                VinLog fromVinLog = logService.getLogbylogid(from,logid);
                fromVinLog.setItemCount(updateVinLog.getItemCount());
                fromVinLog.setTotalPrice(updateVinLog.getTotalPrice());
                logService.updateLogbylogid(from, fromVinLog);
            }
            updateVinLog.setIfConfirm(true);
            logService.updateLogbylogid(location, updateVinLog);
            userpageControllerService.confirmCountFunction(true,location);


        }else {
            log.warn("=====Not allow to do=====");
        }



        return "redirect:/confirm/listnotpass?location="+location;
    }

    @RequestMapping("/reject")
    public String reject(@RequestParam String location, @RequestParam String logid, @RequestParam String itemtype) throws InterruptedException {
        //更新To的Log
        if(cacheService.ifDobyLogid(logid, "confirm")){
            log.warn("=====Allow to do=====");
            log.warn("=====update the log from ToLocation=====");
            VinLog toLog = logService.getLogbylogid(location, logid);
            String toAction = toLog.getAction();
            toLog.setIfConfirm(true);
            toLog.setIfComplete(true);
            toLog.setAction("reject");
            logService.updateLogbylogid(location,toLog);
            userpageControllerService.confirmCountFunction(false, location);

            if(toAction.equals("input")){
                //更新From的Log
                log.warn("=====update the log from FromLocation=====");
                String fromLocation = toLog.getFrom();
                VinLog fromLog = logService.getLogbylogid(fromLocation,logid);
                fromLog.setIfConfirm(true);
                fromLog.setIfComplete(true);
                fromLog.setAction("reject");
                logService.updateLogbylogid(fromLocation, fromLog);

                //更新From的VinItem
                log.warn("=====update the vinItem from FromLocation=====");
                VinItem inputVinItem = new VinItem(fromLog);
                vinMainControllerService.doInputVinItem(inputVinItem,fromLocation,itemtype);
            }
        }else {
            log.warn("=====Not allow to do=====");
        }


        return "redirect:/confirm/listnotpass?location="+location;

    }





}
