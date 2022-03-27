package com.kuang.controller;

import com.kuang.pojo.*;
import com.kuang.service.CacheService;
import com.kuang.service.LogService;
import com.kuang.service.VinMainControllerService;
import com.kuang.service.VinService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/dump")
public class DumpController {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    @Resource
    private ThreadPoolTaskExecutor taskExecutor;

    @Resource
    private CacheService cacheService;

    @Resource
    private LogService logService;

    @Resource
    private VinMainControllerService vinMainControllerService;

    @RequestMapping("/todumpItem")
    public String toDumpItem(Model model, HttpSession session, @RequestParam String id, @RequestParam String location, @RequestParam String category){
        User user = (User)session.getAttribute("user");
        if(vinService.ifAccess(user,location)){
            System.out.println(location + "," + category);
            VinItem vinItem = vinService.getVinItem(location,category,id);
            String logid = vinService.getUUID();
            String time = vinService.getDateTime();
            Dumplist dumplist = new Dumplist(vinItem);
            int countLimit = vinItem.getItemCount();
            dumplist.setLocation(location);
            dumplist.setCategory(category);
            dumplist.setLogid(logid);
            dumplist.setDumptime(time);
            dumplist.setIf_pass(false);
            dumplist.setStatus("inprocess");
            model.addAttribute("dumpList", dumplist);
            model.addAttribute("warehouse", "報廢");
            model.addAttribute("countLimit", countLimit);
            model.addAttribute("function","apply");
            return "dumpItem";
        }else {
            model.addAttribute("msg","哭哭！沒有權限！");
            return "login";
        }

    }

    @RequestMapping("/dumpvinItem")
    public String dumpVinItem(Dumplist dumplist){
        String location = dumplist.getLocation();
        System.out.println(dumplist);
        vinService.addDumpItem(dumplist);

        return "redirect:/warehouse/allItem?location="+location;
    }

    @RequestMapping("/expiredDumpVinItem")
    public String expiredDumpVinItem(@RequestParam String logid, @RequestParam String location){
        Expired expired = vinService.queryExpiredbyID(Integer.parseInt(logid));
        String time = vinService.getDateTime();

        Dumplist dumplist = new Dumplist(logid,1,expired.getTime(),"","過期",time,"丟掉", location, "food", "系統創建報廢", false, "inprocess");
        String itemID = expired.getItemID();
//        String itemName = vinService.queryAllItembyID(itemID).getItemName();
//        dumplist.setItemName(itemName);
        String brand = vinService.getVinItem(location,"food",itemID).getBrand();
        dumplist.setId(itemID);
        dumplist.setBrand(brand);
        System.out.println(dumplist);
        vinService.addDumpItem(dumplist);
        //更新Expire狀態
        vinService.updateExpiredDate(expired.getTime(),Integer.parseInt(logid),true);

        //更新ExpiredItemCache
        cacheService.reloadExpiredandExpiredSoonCache(location);

        return "redirect:/receive/showExpiredList?location="+location;

    }



    @RequestMapping("/showdumplog")
    public String showdumpLog(Model model, HttpSession session, @RequestParam String location, @RequestParam String function){
        User user = (User) session.getAttribute("user");
        int userLevel = user.getLevel();
        boolean ifAccess = false;
        if(userLevel == 1000){
            ifAccess = true;
        }else if(userLevel < 1000){
            ifAccess = false;
        }
        if(vinService.ifAccess(user,location)){
            boolean if_pass = false;
            if(function.equals("passed")){
                if_pass = true;
            }
            List<Dumplist> dumpListtool = vinService.queryDumpItemwithLocationandCategory(location, "tool", if_pass);
            List<Dumplist> dumpListsmalltool = vinService.queryDumpItemwithLocationandCategory(location, "smalltool", if_pass);
            List<Dumplist> dumpListfood = vinService.queryDumpItemwithLocationandCategory(location, "food", if_pass);
            List<Dumplist> dumpListcommercial = vinService.queryDumpItemwithLocationandCategory(location, "commercial", if_pass);
            List<Dumplist> dumpListother = vinService.queryDumpItemwithLocationandCategory(location, "other", if_pass);
            model.addAttribute("dumpListtool",dumpListtool);
            model.addAttribute("dumpListsmalltool",dumpListsmalltool);
            model.addAttribute("dumpListfood",dumpListfood);
            model.addAttribute("dumpListcommercial",dumpListcommercial);
            model.addAttribute("dumpListother",dumpListother);
            model.addAttribute("mainWarehouse","dump");
            model.addAttribute("showdumplog","showdumplog?location="+location);
            model.addAttribute("ifAccess", ifAccess);
            model.addAttribute("logLocation", "showdumplog?location="+location+"&function="+function);
            String realname = vinService.queryRealWarehouseName(location).getRealname();
            if(function.equals("notpass")){
                model.addAttribute("warehouse",realname+"報廢審核（未審核）");
                model.addAttribute("function", "notpass");
            }else if(function.equals("passed")){
                model.addAttribute("warehouse",realname+"報廢審核（已審核）");
                model.addAttribute("function", "passed");

            }
            return "dumpLog";
        }else {
            model.addAttribute("msg","哭哭！沒有權限！");
            return "login";
        }


    }

    //通過
    @RequestMapping("/pass")
    public String pass(@RequestParam String logid, @RequestParam String location, @RequestParam String id, @RequestParam String category, HttpSession session, Model model) throws InterruptedException {
        User user = (User) session.getAttribute("user");
        int userLevel = user.getLevel();
        if(userLevel == 1000){
            //更新庫存
            vinService.queryDumpLogbyLogId(logid);
            int dumpCount = vinService.queryDumpLogCountbyLogId(logid);
            VinItem vinItem = vinService.getVinItem(location,category,id);
            VinItem vinItemLog = new VinItem(vinItem);
            //紀錄
            taskExecutor.submit(() -> {
//                System.out.println("===寫紀錄===");
                vinItemLog.setItemCount(dumpCount);
//                System.out.println(vinItemLog);
                try {
                    logService.addLog("dump",vinItemLog,category,location,"trashcan", null,null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            vinMainControllerService.doOutputVinItem(dumpCount,location,category,id);

//            int itemCount = vinItem.getItemCount();
//            vinItem.setItemCount(itemCount - dumpCount);
//            vinItem.setTotalPrice(vinItem.getItemCount() * vinItem.getSinglePrice());//////
//            System.out.println("updatetool=>"+vinItem);
//            String key = null;
//            String cacheKey = null;
//            if(category.equals("commercial")){
//                key = location + "," + "commercialthing" + "," + vinItem.getId();
//                cacheKey = "vinItem" + "commercialthing" + "in" + location;
//            }else {
//                key = location + "," + category + "," + vinItem.getId();
//                cacheKey = "vinItem" + category + "in" + location;
//            }
//
//            boolean ifSetLock = cacheService.setRedisLock(key, vinItem);
//            if(category.equals("commercial")){
//                if(ifSetLock){
//                    vinService.updateCache(cacheKey,vinItem, location, category);
//                    vinService.kafkaDoUpdate(vinItem, category, location);
//                }
//            }else {
//                if(ifSetLock){
//                    vinService.updateCache(cacheKey,vinItem, location, category);
//                    vinService.kafkaDoUpdate(vinItem, category, location);
//                }
//            }
//            cacheService.waitRedisLock(key);

            //更新dumplog狀態
            vinService.updateDumpStatusbyLogId(logid,"pass");
            return "redirect:/dump/showdumplog?location="+location+"&function=notpass";
        }else {
            model.addAttribute("msg","哭哭！沒有權限！");
            return "login";
        }


    }


    //編輯已提交的報廢表
    @RequestMapping("/toeditdumplist")
    public String toeditDumplist(@RequestParam String logid, Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        int userLevel = user.getLevel();
        if(userLevel == 1000){
            Dumplist dumpList = vinService.queryDumpLogbyLogId(logid);
            System.out.println(dumpList);
            String location = dumpList.getLocation();
            String category = dumpList.getCategory();
            String id = dumpList.getId();
            int countLimit = vinService.queryVinItemCount(location,category,id);
            model.addAttribute("dumpList", dumpList);
            model.addAttribute("function","edit");
            model.addAttribute("warehouse", "編輯報廢單");
            model.addAttribute("countLimit", countLimit);
            return "dumpItem";
        }else {
            model.addAttribute("msg","哭哭！沒有權限！");
            return "login";
        }
    }

    @RequestMapping("/editdumplist")
    public String editDumplist(Dumplist dumplist, HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        int userLevel = user.getLevel();
        if (userLevel == 1000){
            vinService.updateDumpbyLogId(dumplist);
            String location = dumplist.getLocation();
            return "redirect:/dump/showdumplog?location="+location+"&function=notpass";

        }else {
            model.addAttribute("msg","哭哭！沒有權限！");
            return "login";
        }
    }

    @RequestMapping("reject")
    public String rejectDump(HttpSession session, Model model, @RequestParam String logid, @RequestParam String location){
        User user = (User)session.getAttribute("user");
        int userLevel = user.getLevel();
        if(userLevel == 1000){
            vinService.updateDumpStatusbyLogId(logid,"reject");
        }else {
            model.addAttribute("msg","哭哭！沒有權限！");
            return "login";
        }

        return "redirect:/dump/showdumplog?location="+location+"&function=notpass";
    }

}
