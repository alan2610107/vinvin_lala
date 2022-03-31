package com.kuang.controller;

import com.alibaba.fastjson.JSONArray;
import com.kuang.pojo.*;
import com.kuang.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
@Slf4j
@Controller
@RequestMapping("/receive")
public class RecieveController extends HttpServlet {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    @Resource
    private ThreadPoolTaskExecutor taskExecutor;

    @Resource
    private CacheService cacheService;

    @Resource
    private VinMainControllerService vinMainControllerService;

    @Resource
    private ReceiveControllerService receiveControllerService;

    @Resource
    private LogService logService;

    public List<VinLog> getRecieveList(String location, String category) {
        List<VinLog> receiveList = new ArrayList<>();

        switch (location) {
            case "main0":
                receiveList = vinService.queryCategoryReceiveinMain0(category);
                break;
            case "main1":
                receiveList = vinService.queryCategoryReceiveinMain1(category);
                break;
            case "main2":
                receiveList = vinService.queryCategoryReceiveinMain2(category);
                break;
            case "shop1":
                receiveList = vinService.queryCategoryReceiveinShop1(category);
                break;
            case "shop2":
                receiveList = vinService.queryCategoryReceiveinShop2(category);
                break;
            case "shop3":
                receiveList = vinService.queryCategoryReceiveinShop3(category);
                break;
            case "shop4":
                receiveList = vinService.queryCategoryReceiveinShop4(category);
                break;
            case "shop5":
                receiveList = vinService.queryCategoryReceiveinShop5(category);
                break;
            case "shop6":
                receiveList = vinService.queryCategoryReceiveinShop6(category);
                break;
            case "shop7":
                receiveList = vinService.queryCategoryReceiveinShop7(category);
                break;
            case "shop8":
                receiveList = vinService.queryCategoryReceiveinShop8(category);
                break;
            case "shop9":
                receiveList = vinService.queryCategoryReceiveinShop9(category);
                break;
            case "shop10":
                receiveList = vinService.queryCategoryReceiveinShop10(category);
                break;
            case "shop11":
                receiveList = vinService.queryCategoryReceiveinShop11(category);
                break;
            case "shop12":
                receiveList = vinService.queryCategoryReceiveinShop12(category);
                break;
        }

        return receiveList;


    }

    @RequestMapping("/list")
    public String list(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response, @RequestParam String location) throws ServletException, IOException {
        User user = (User) session.getAttribute("user");
        System.out.println(user.getUname());
        if (vinService.ifAccess(user, location)) {
            List<VinLog> listItem = getRecieveList(location, "tool");
            List<VinLog> listFood = getRecieveList(location, "food");
            List<VinLog> listSmallItem = getRecieveList(location, "smalltool");
            List<VinLog> listCommercialItem = getRecieveList(location, "commercialthing");
            List<VinLog> listOtherItem = getRecieveList(location, "other");
            HashMap<String, String> statusMap = new HashMap<>();
            statusMap.put("false", "未送達");
            statusMap.put("true", "已送達");
            model.addAttribute("listItem", listItem);
            model.addAttribute("listFood", listFood);
            model.addAttribute("listSmallItem", listSmallItem);
            model.addAttribute("listCommercialItem", listCommercialItem);
            model.addAttribute("listOtherItem", listOtherItem);
            Warehouse warehouse = vinService.queryRealWarehouseName(location);
            String realname = warehouse.getRealname();
            model.addAttribute("warehouse", realname + "待入庫清單");
            model.addAttribute("logLocation", location);
            model.addAttribute("updatelogmain", "doreceive");
            model.addAttribute("warehouseMap", vinService.getWarehouseMap());
            model.addAttribute("actionMap", vinService.getActionMap());
            model.addAttribute("statusMap", statusMap);
//            model.addAttribute("mainWarehouse", "receive");
//            model.addAttribute("mainWarehouse","mainWarehouse1");
            return "receiveItem";
        } else {
            model.addAttribute("msg", "哭哭！沒有權限！");
            return "login";
        }

    }


//    public void calculateVinItem(VinItem targetItem, VinItem vinItem) {
//        int num = targetItem.getItemCount();//原本的庫存
//        System.out.println("num==>" + num);
//        System.out.println("getItemCount==>" + vinItem.getItemCount());
//        targetItem.setItemCount(vinItem.getItemCount() + num);
//        double newTotalPrice = vinItem.getItemCount() * vinItem.getSinglePrice() + targetItem.getTotalPrice();//有可能只收到部分貨品
//        newTotalPrice = Math.round(newTotalPrice * 100.0) / 100.0;
//        targetItem.setTotalPrice(newTotalPrice);
//        if (vinItem.getSinglePrice() != targetItem.getSinglePrice() && targetItem.getItemCount() > 0) {
//            double singleprice = targetItem.getTotalPrice() / targetItem.getItemCount();
//            singleprice = Math.round(singleprice * 100.0) / 100.0;
//            targetItem.setSinglePrice(singleprice);
//        }
//
//    }


//    public void addExpiredDateItem(VinItem inputVinItem, String category, String location){
//        if (category.equals("food") && inputVinItem.getItemName().contains("牛奶")) {
//            taskExecutor.submit(() -> {
//                for (int i = 0; i < inputVinItem.getItemCount(); i++) {
//                    Expired expiredDate = new Expired(inputVinItem.getId(), "123", location);
//                    vinService.addExpiredDate(expiredDate);
//                }
//            });
//        }
//    }

//    public void input(VinLog vinLog, String itemtype, String location) throws InterruptedException {
//        VinItem inputVinItem = new VinItem(vinLog);
//
//
////        inputVinItem.setItemName(vinLog.getItemName());//
////        inputVinItem.setId(vinLog.getId());//
////        inputVinItem.setItemCount(vinLog.getItemCount());//
////        inputVinItem.setBrand(vinLog.getBrand());//
////        inputVinItem.setSinglePrice(vinLog.getSinglePrice());//
////        inputVinItem.setTotalPrice(vinLog.getTotalPrice());//
////        inputVinItem.setMemo(vinLog.getMemo());//
//        String key = location + "," + itemtype + "," + inputVinItem.getId();
//        boolean ifSetLock = cacheService.setRedisLock(key, inputVinItem);
//        System.out.println("========input=======");
//        System.out.println(location);
//        System.out.println(itemtype);
//
//        if (ifSetLock) {
//            //過期日期
//            if (itemtype.equals("food") && inputVinItem.getItemName().contains("牛奶")) {
//                taskExecutor.submit(() -> {
//                    for (int i = 0; i < inputVinItem.getItemCount(); i++) {
//                        Expired expiredDate = new Expired(inputVinItem.getId(), "123", location);
//                        vinService.addExpiredDate(expiredDate);
//                    }
//                });
//            }
//
//
//            //入庫
//            int ifexist = vinService.ifExist(location, itemtype, inputVinItem.getId());
////            String cacheKey = "vinItem" + itemtype + "in" + location;
//            if (ifexist > 0) {
////                VinItem targetItem = null;
////                if (itemtype.equals("commercialthing")) {
////                    targetItem = vinService.getVinItem(location, "commercial", vinItem.getId());//原本的資料
////                } else {
////                    targetItem = vinService.getVinItem(location, itemtype, vinItem.getId());//原本的資料
////                }
////
////                calculateVinItem(targetItem, vinItem);//targetItem是入庫資料
//                VinItem updateVinItem = vinMainControllerService.input(inputVinItem, location, itemtype);
//
//                vinMainControllerService.update(updateVinItem,location,itemtype);
////                vinService.updateCache(cacheKey, updateVinItem, location, itemtype);
////                if (itemtype.equals("commercialthing")) {
////                    vinService.kafkaDoUpdate(updateVinItem, "commercial", location);
////                } else {
////                    vinService.kafkaDoUpdate(updateVinItem, itemtype, location);
////                }
//            } else {
//                vinMainControllerService.add(inputVinItem,location,itemtype);
////                String distributionCacheKey = location + "," + itemtype + "," + inputVinItem.getId();
////                vinService.addCache(cacheKey, inputVinItem, location, itemtype);
////                vinService.addVinItem(location, itemtype, inputVinItem);
////                cacheService.deleteRedisLock(distributionCacheKey);
//            }
//        }
//
//
//    }

    public VinLog addNewLog(VinLog newvinlog, String location, int originItemCount, int receiveItemCount) {
        String newlogid = vinService.getUUID();
        String time = vinService.getDateTime();
        int newInput = originItemCount - receiveItemCount;
        newvinlog.setItemCount(newInput);
        newvinlog.setTotalPrice(Math.round(newInput * newvinlog.getSinglePrice() * 100.0) / 100.0);
        newvinlog.setLogid(newlogid);
        newvinlog.setTime(time);
        newvinlog.setMemo("收貨時多收的");
        logService.addLog(newvinlog,location);

        return newvinlog;

    }

    @RequestMapping("/doreceive")
    public String doReceive(@RequestParam("items[]") String items, @RequestParam String itemtype, @RequestParam String location) throws InterruptedException {
        log.warn("Receive Category : " + itemtype);
        log.warn("Receive Location : " + location);
        log.warn("Receive Items : " + items);
//        List<String> logidsList = new ArrayList<>();
//        List<String> receiveItemCountsList = new ArrayList<>();
        Map<String,String> receiveMap = new HashMap<>();
        JSONArray jsonarray = JSONArray.parseArray(items);

        for (int i = 0; i < jsonarray.size(); i++) {
            String logid = JSONArray.parseArray(jsonarray.getString(i).toLowerCase(Locale.ROOT)).get(1).toString();
            String receiveItemCount = JSONArray.parseArray(jsonarray.getString(i).toLowerCase(Locale.ROOT)).get(5).toString();
            receiveMap.put(logid,receiveItemCount);
//            logidsList.add(JSONArray.parseArray(jsonarray.getString(i).toLowerCase(Locale.ROOT)).get(1).toString());
//            receiveItemCountsList.add(JSONArray.parseArray(jsonarray.getString(i).toLowerCase(Locale.ROOT)).get(5).toString());
        }

        for (String logid : receiveMap.keySet()) {
            if (cacheService.ifDobyLogid(logid, "receive")) {
                log.warn("=====Allow to do=====");
                int recieveItemCount = Integer.parseInt(receiveMap.get(logid));//收到的數
                System.out.println("recieveItemCount==>" + recieveItemCount);
                VinLog originVinLog = logService.getLogbylogid(location, logid);//原始紀錄
                VinLog vinLogInput = new VinLog(originVinLog);

                if (originVinLog.getItemCount() == recieveItemCount) {
                    originVinLog.setIfComplete(true);
                    cacheService.decreaseNotReceiveCount(location);
//                    cacheService.deleteRedisLock(distributionKeyLog);
//                    cacheService.waitRedisLock(distributionKeyLog);
//                    String distributionKeyLog = location + "," + itemtype + "," + vinLog.getLogid();
//                    if (cacheService.setRedisLock(distributionKeyLog, new VinItem())) {
//
//                    }
                } else if (originVinLog.getItemCount() > recieveItemCount) {
                    vinLogInput.setItemCount(recieveItemCount);
                    VinLog newVinlog = new VinLog(originVinLog);
                    int totalItemCount = originVinLog.getItemCount();
                    originVinLog.setItemCount(recieveItemCount);
                    originVinLog.setIfComplete(true);
                    originVinLog.setTotalPrice(Math.round(recieveItemCount * originVinLog.getSinglePrice() * 100.0) / 100.0);
                    addNewLog(newVinlog, location, totalItemCount, recieveItemCount);
                } else {
                    VinLog newvinlog = new VinLog(originVinLog);
                    int totalItemCount = originVinLog.getItemCount();
                    VinLog newVinLog = addNewLog(newvinlog, location, totalItemCount, recieveItemCount);
                    originVinLog.setIfComplete(true);
                    ReceiveError receiveError = new ReceiveError(newVinLog);
                    receiveError.setItemCount(recieveItemCount - originVinLog.getItemCount());
                    receiveError.setLocation(location);
                    receiveError.setLogid(newvinlog.getLogid());
                    vinService.addReceiveError(receiveError);
                }
                VinItem inputVinItem = new VinItem(vinLogInput);
                vinMainControllerService.doInputVinItem(inputVinItem,location,itemtype);
                receiveControllerService.addExpiredDateItem(inputVinItem,itemtype,location);
//                input(vinLogInput, itemtype, location);//入庫
                logService.updateLogbylogid(location, originVinLog);//更新紀錄
//                String distributionCacheKey = location + "," + itemtype + "," + vinLogInput.getId();
//                cacheService.waitRedisLock(distributionCacheKey);
            } else {
                log.warn("=====Not allow to do=====");
            }
        }

//        for (int i = 0; i < logidsList.size(); i++) {
//            String logid = logidsList.get(i);
//            if (vinService.ifDobyLogid(logid, "receive")) {
//                log.warn("=====Allow to do=====");
//                int itemCount = Integer.parseInt(receiveItemCountsList.get(i));//收到的數
//                System.out.println("itemCount==>" + itemCount);
//                VinLog vinLog = vinService.getLogbylogid(location, logid);//原始紀錄
//                VinLog vinLogInput = new VinLog(vinLog);
//
//                if (vinLog.getItemCount() == itemCount) {
//                    String distributionKeyLog = location + "," + itemtype + "," + vinLog.getId();
//                    if(cacheService.setRedisLock(distributionKeyLog, new VinItem())){
//                        vinLog.setIfComplete(true);
//                        cacheService.decreaseNotReceiveCount(location);
//                        cacheService.deleteRedisLock(distributionKeyLog);
//                        cacheService.waitRedisLock(distributionKeyLog);
//                    }
//                } else if (vinLog.getItemCount() > itemCount) {
//                    vinLogInput.setItemCount(itemCount);
//                    VinLog newvinlog = new VinLog(vinLog);
//                    int totalItemCount = vinLog.getItemCount();
//                    vinLog.setItemCount(itemCount);
//                    vinLog.setIfComplete(true);
//
//                    vinLog.setTotalPrice(Math.round(itemCount * vinLog.getSinglePrice() * 100.0) / 100.0);
//                    addNewLog(newvinlog, location, totalItemCount, itemCount);
//                } else {
//                    VinLog newvinlog = new VinLog(vinLog);
//                    int totalItemCount = vinLog.getItemCount();
//                    addNewLog(newvinlog, location, totalItemCount, itemCount);
//                    vinLog.setIfComplete(true);
//                    ReceiveError receiveError = new ReceiveError(vinLog);
//                    receiveError.setItemCount(itemCount - vinLog.getItemCount());
//                    receiveError.setLocation(location);
//                    receiveError.setLogid(newvinlog.getLogid());
//                    vinService.addReceiveError(receiveError);
//                }
//                input(vinLogInput, itemtype, location);//入庫
//                vinService.updateLogbylogid(location, vinLog);//更新紀錄
//                String key = location + "," + itemtype + "," + vinLogInput.getId();
//                cacheService.waitRedisLock(key);
//            } else {
//                log.warn("=====Not allow to do=====");
//            }
//        }

        return "redirect:/receive/list?location=" + location;
    }

    //設定過期日
    @RequestMapping("/setExpiredDate")
    public String showExpiredForm(Model model, HttpSession session, @RequestParam String location) {
        User user = (User) session.getAttribute("user");
        if (vinService.ifAccess(user, location)) {
            List<Expired> expiredList = vinService.queryExpiredDatebyLocationTime(location, "123");
            model.addAttribute("expiredList", expiredList);
            Warehouse warehouse = vinService.queryRealWarehouseName(location);
            String realname = warehouse.getRealname();
            model.addAttribute("warehouse", realname + "設定過期日");
            model.addAttribute("mainWarehouse", "receive");
            model.addAttribute("logLocation", "setExpiredDate?location=" + location);
            model.addAttribute("location", location);
            model.addAttribute("function", "form");
            return "expiredform";
        } else {
            model.addAttribute("msg", "哭哭！沒有權限！");
            return "login";
        }

    }

    //寫入過期日
    @RequestMapping("/updateExpiredDate")
    public String updateExpiredDate(@RequestParam("items[]") String items, @RequestParam String location, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (vinService.ifAccess(user, location)) {
            List<String> idList = new ArrayList<>();
            List<String> timeList = new ArrayList<>();
            JSONArray jsonarray = JSONArray.parseArray(items);

            for (int i = 0; i < jsonarray.size(); i++) {
                idList.add(JSONArray.parseArray(jsonarray.getString(i).toLowerCase(Locale.ROOT)).get(1).toString());
                timeList.add(JSONArray.parseArray(jsonarray.getString(i).toLowerCase(Locale.ROOT)).get(0).toString());
            }
            System.out.println(idList);
            System.out.println(timeList);
            for (int i = 0; i < idList.size(); i++) {
                String time = timeList.get(i);
                if (time != null && !time.equals("")) {
                    System.out.println("id=" + Integer.parseInt(idList.get(i)));
                    vinService.updateExpiredDate(time, Integer.parseInt(idList.get(i)), false);
                }
            }
            return "redirect:/receive/setExpiredDate?location=" + location;
        } else {
            model.addAttribute("msg", "哭哭！沒有權限！");
            return "login";
        }

    }

    @RequestMapping("/showAllExpiredList")
    public String showAllExpiredList(Model model, HttpSession session, @RequestParam String location) {
        User user = (User) session.getAttribute("user");
        if (vinService.ifAccess(user, location)) {
            List<Expired> expiredList = vinService.queryAllExpiredDatebyLocation(location);
            System.out.println(expiredList);
            model.addAttribute("expiredList", expiredList);
            Warehouse warehouse = vinService.queryRealWarehouseName(location);
            String realname = warehouse.getRealname();
            model.addAttribute("warehouse", realname + "過期日清單");
            model.addAttribute("mainWarehouse", "receive");
            model.addAttribute("logLocation", "setExpiredDate?location=" + location);
            model.addAttribute("location", location);
            model.addAttribute("function", "show");
            return "expiredform";
        } else {
            model.addAttribute("msg", "哭哭！沒有權限！");
            return "login";
        }

    }

    //顯示已過期或兩天後到期的東西
    @RequestMapping("/showExpiredList")
    public String showExpiredList(Model model, HttpSession session, @RequestParam String location) {
        User user = (User) session.getAttribute("user");
        if (vinService.ifAccess(user, location)) {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String today = simpleDateFormat.format(date);
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(date);
            rightNow.add(Calendar.DAY_OF_YEAR, 2);
            Date twoDaysAfterDate = rightNow.getTime();
            String twoDaysAfter = simpleDateFormat.format(twoDaysAfterDate);
            System.out.println("twoDaysAfter=>" + twoDaysAfter);
            System.out.println("today=>" + today);
            List<Expired> expiredList = vinService.queryExpiredItembyLocationTime(location, today);
            List<Expired> expiredSoonList = vinService.queryExpiredSoonItembyLocationTime(location, twoDaysAfter, today);
            model.addAttribute("expiredList", expiredList);
            model.addAttribute("expiredSoonList", expiredSoonList);
            Warehouse warehouse = vinService.queryRealWarehouseName(location);
            String realname = warehouse.getRealname();
            model.addAttribute("warehouse", realname + "過期報廢");
            model.addAttribute("mainWarehouse", "receive");
            model.addAttribute("logLocation", "setExpiredDate?location=" + location);
            model.addAttribute("location", location);
            return "expiredDump";
        } else {
            model.addAttribute("msg", "哭哭！沒有權限！");
            return "login";
        }

    }

    @RequestMapping("/error")
    public String receiveError(Model model, HttpSession session, @RequestParam String location) {
        User user = (User) session.getAttribute("user");
        if (vinService.ifAccess(user, location)) {
            List<ReceiveError> receiveErrorToolList = vinService.queryReceiveErrorbyComplete(location, "tool", false);
            List<ReceiveError> receiveErrorSmallToolList = vinService.queryReceiveErrorbyComplete(location, "smalltool", false);
            List<ReceiveError> receiveErrorFoodList = vinService.queryReceiveErrorbyComplete(location, "food", false);
            List<ReceiveError> receiveErrorCommercialList = vinService.queryReceiveErrorbyComplete(location, "commercialthing", false);
            List<ReceiveError> receiveErrorotherList = vinService.queryReceiveErrorbyComplete(location, "other", false);
            model.addAttribute("receiveErrorToolList", receiveErrorToolList);
            model.addAttribute("receiveErrorSmallToolList", receiveErrorSmallToolList);
            model.addAttribute("receiveErrorFoodList", receiveErrorFoodList);
            model.addAttribute("receiveErrorCommercialList", receiveErrorCommercialList);
            model.addAttribute("receiveErrorotherList", receiveErrorotherList);
            model.addAttribute("function", "notpass");
            Warehouse warehouse = vinService.queryRealWarehouseName(location);
            String realname = warehouse.getRealname();
            model.addAttribute("warehouse", realname + "待入庫例外（未處理）");
            model.addAttribute("mainWarehouse", "receive");
            model.addAttribute("logLocation", "error?location=" + location);
            model.addAttribute("notpass", "error?location=" + location);
            model.addAttribute("passed", "errorpass?location=" + location);

            return "receiveError";
        } else {
            model.addAttribute("msg", "哭哭！沒有權限！");
            return "login";
        }
    }

    @RequestMapping("/errorpass")
    public String receiveErrorPass(Model model, HttpSession session, @RequestParam String location) {
        User user = (User) session.getAttribute("user");
        int userLevel = user.getLevel();
        if (vinService.ifAccess(user, location)) {
            List<ReceiveError> receiveErrorToolList = vinService.queryReceiveErrorbyComplete(location, "tool", true);
            List<ReceiveError> receiveErrorSmallToolList = vinService.queryReceiveErrorbyComplete(location, "smalltool", true);
            List<ReceiveError> receiveErrorFoodList = vinService.queryReceiveErrorbyComplete(location, "food", true);
            List<ReceiveError> receiveErrorCommercialList = vinService.queryReceiveErrorbyComplete(location, "commercialthing", true);
            List<ReceiveError> receiveErrorotherList = vinService.queryReceiveErrorbyComplete(location, "other", true);
            model.addAttribute("receiveErrorToolList", receiveErrorToolList);
            model.addAttribute("receiveErrorSmallToolList", receiveErrorSmallToolList);
            model.addAttribute("receiveErrorFoodList", receiveErrorFoodList);
            model.addAttribute("receiveErrorCommercialList", receiveErrorCommercialList);
            model.addAttribute("receiveErrorotherList", receiveErrorotherList);
            model.addAttribute("function", "passed");
            Warehouse warehouse = vinService.queryRealWarehouseName(location);
            String realname = warehouse.getRealname();
            model.addAttribute("warehouse", realname + "待入庫例外（已處理）");
            model.addAttribute("mainWarehouse", "receive");
            model.addAttribute("logLocation", "error?location=" + location);
            model.addAttribute("notpass", "error?location=" + location);
            model.addAttribute("passed", "errorpass?location=" + location);

            return "receiveError";
        } else {
            model.addAttribute("msg", "哭哭！沒有權限！");
            return "login";
        }
    }

    public void deleteLog(String location, String logid) {
        switch (location) {
            case "main0":
                vinService.deleteLoginMain0byLogid(logid);
                break;
            case "main1":
                vinService.deleteLoginMain1byLogid(logid);
                break;
            case "main2":
                vinService.deleteLoginMain2byLogid(logid);
                break;
            case "shop1":
                vinService.deleteLoginShop1byLogid(logid);
                break;
            case "shop2":
                vinService.deleteLoginShop2byLogid(logid);
                break;
            case "shop3":
                vinService.deleteLoginShop3byLogid(logid);
                break;
            case "shop4":
                vinService.deleteLoginShop4byLogid(logid);
                break;
            case "shop5":
                vinService.deleteLoginShop5byLogid(logid);
                break;
            case "shop6":
                vinService.deleteLoginShop6byLogid(logid);
                break;
            case "shop7":
                vinService.deleteLoginShop7byLogid(logid);
                break;
            case "shop8":
                vinService.deleteLoginShop8byLogid(logid);
                break;
            case "shop9":
                vinService.deleteLoginShop9byLogid(logid);
                break;
            case "shop10":
                vinService.deleteLoginShop10byLogid(logid);
                break;
            case "shop11":
                vinService.deleteLoginShop11byLogid(logid);
                break;
            case "shop12":
                vinService.deleteLoginShop12byLogid(logid);
                break;
        }
    }

    @RequestMapping("/inputVinItem")
    public String inputVinItem(@RequestParam String logid, @RequestParam String location, @RequestParam String id, @RequestParam String category) throws InterruptedException {
        //更新ReceiveError
        vinService.updateReceiveErrorifComplete(logid, true);

        //更新log
        VinLog vinLog = logService.getLogbylogid(location, logid);
        vinLog.setItemCount(vinLog.getItemCount() * -1);
        vinLog.setTotalPrice(vinLog.getTotalPrice() * -1);
        vinLog.setIfComplete(true);
        logService.updateLogbylogid(location, vinLog);
        cacheService.decreaseNotReceiveCount(location);

        VinItem inputVinItem = new VinItem(vinLog);
        vinMainControllerService.doInputVinItem(inputVinItem,location,category);


        //入庫
//        VinItem vinItemOld = null;
//        if (category.equals("commercialthing")) {
//            vinItemOld = vinService.getVinItem(location, "commercial", id);
//        } else {
//            vinItemOld = vinService.getVinItem(location, category, id);
//        }
//
//        VinItem vinItem = new VinItem(vinItemOld);
//        int oldNum = vinItemOld.getItemCount();
//        double oldSingleprice = vinItemOld.getSinglePrice();
//        int inputCount = vinLog.getItemCount();
//        vinItem.setItemCount(oldNum + inputCount);
//        if (oldSingleprice == vinLog.getSinglePrice()) {
//            vinItem.setTotalPrice(Math.round(vinItem.getItemCount() * vinItem.getSinglePrice() * 100.0) / 100.0);
//        } else {
//            double totalPrice = inputCount * vinLog.getSinglePrice() + vinItemOld.getTotalPrice();
//            totalPrice = Math.round(totalPrice * 100.0) / 100.0;
//            vinItem.setTotalPrice(totalPrice);
//            double singlePrice = totalPrice / (vinItem.getItemCount());
//            singlePrice = Math.round(singlePrice * 100.0) / 100.0;
//            vinItem.setSinglePrice(singlePrice);
//        }
//        System.out.println("inputtool=>" + vinItem);
//        String cacheKey = "vinItem" + category + "in" + location;
//        String key = location + "," + category + "," + vinItem.getId();
//        boolean ifSetLock = cacheService.setRedisLock(key, vinItem);
//        if (ifSetLock) {
//            vinService.updateCache(cacheKey, vinItem, location, category);
//            if (category.equals("commercialthing")) {
//                vinService.kafkaDoUpdate(vinItem, "commercial", location);
//            } else {
//                vinService.kafkaDoUpdate(vinItem, category, location);
//            }
//        }
//
//        cacheService.waitRedisLock(key);
        return "redirect:/receive/error?location=" + location;

    }

    @RequestMapping("/dump")
    public String dumpReceiveError(@RequestParam String logid, @RequestParam String location) {
        //更新ReceiveError
        vinService.updateReceiveErrorifComplete(logid, true);

        //刪除log
        deleteLog(location, logid);
        cacheService.decreaseNotReceiveCount(location);

        return "redirect:/receive/error?location=" + location;
    }


}
