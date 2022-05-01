package com.kuang.controller;

import com.kuang.pojo.*;

import com.kuang.service.*;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Future;
@Slf4j
@Controller
@RequestMapping("/warehouse")
public class VinMainController extends HttpServlet{
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    @Resource
    private ThreadPoolTaskExecutor taskExecutor;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private FilePathMapService filePathMapService;

    @Resource
    private QueryInventoryService queryInventoryService;

    @Resource
    private CacheService cacheService;

    @Resource
    private VinMainControllerService vinMainControllerService;

    @Resource
    private LogService logService;


    boolean HAS_ALERT_MODE =  true;



    public List<VinAlert> getVinAlert(String location, String date){
        List<VinAlert> vinAlerts = null;
        switch (location){
            case "main0":
                vinAlerts = vinService.queryifAlertinMain0(date);
                break;
            case "main1":
                vinAlerts = vinService.queryifAlertinMain1(date);
                break;
            case "main2":
                vinAlerts = vinService.queryifAlertinMain2(date);
                break;
            case "shop1":
                vinAlerts = vinService.queryifAlertinShop1(date);
                break;
            case "shop2":
                vinAlerts = vinService.queryifAlertinShop2(date);
                break;
            case "shop3":
                vinAlerts = vinService.queryifAlertinShop3(date);
                break;
            case "shop4":
                vinAlerts = vinService.queryifAlertinShop4(date);
                break;
            case "shop5":
                vinAlerts = vinService.queryifAlertinShop5(date);
                break;
            case "shop6":
                vinAlerts = vinService.queryifAlertinShop6(date);
                break;
            case "shop7":
                vinAlerts = vinService.queryifAlertinShop7(date);
                break;
            case "shop8":
                vinAlerts = vinService.queryifAlertinShop8(date);
                break;
            case "shop9":
                vinAlerts = vinService.queryifAlertinShop9(date);
                break;
            case "shop10":
                vinAlerts = vinService.queryifAlertinShop10(date);
                break;
            case "shop11":
                vinAlerts = vinService.queryifAlertinShop11(date);
                break;
            case "shop12":
                vinAlerts = vinService.queryifAlertinShop12(date);
                break;
        }

        return vinAlerts;
    }


    //顯示所有庫存

    @RequestMapping("/allItem")
    public String list(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response, @RequestParam String location) throws Exception {
        log.warn("==="+location+"===");
        User user = (User)session.getAttribute("user");
        log.warn(user.getUname());
        if(vinService.ifAccess(user, location)){
            HashMap<String,VinAlert> vinAlertMap = null;
            int userLevel = user.getLevel();
            if(HAS_ALERT_MODE){
                Date day=new Date();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String today = df.format(day);
                List<VinAlert> vinAlerts = getVinAlert(location, today);
                vinAlertMap = new HashMap<>();
                for (int i = 0; i < vinAlerts.size(); i++) {
                    VinAlert vinAlert = vinAlerts.get(i);
                    vinAlertMap.put(vinAlert.getId(),vinAlert);
                }
            }
            model.addAttribute("vinAlertMap",vinAlertMap);
            //高併發編程！
            Future<List<VinItem>> futureTool = queryInventoryService.get(location, "tool");
            Future<List<VinItem>> futureSmallTool = queryInventoryService.get(location, "smalltool");
            Future<List<VinItem>> futureFood = queryInventoryService.get(location, "food");
            Future<List<VinItem>> futureCommercial = queryInventoryService.get(location, "commercialthing");
            Future<List<VinItem>> futureOther = queryInventoryService.get(location, "other");
            if(!futureTool.isDone() && !futureSmallTool.isDone() && !futureFood.isDone() && !futureCommercial.isDone() && !futureOther.isDone()){
                log.warn("task has not finished, please wait!");
            }
            List<VinItem> listItem;
            List<VinItem> listFood;
            List<VinItem> listSmallItem;
            List<VinItem> listCommercialItem;
            List<VinItem> listothers;

            listItem = futureTool.get();
            listFood = futureFood.get();
            listSmallItem = futureSmallTool.get();
            listCommercialItem = futureCommercial.get();
            listothers = futureOther.get();

            Future<Map<String, String>> FutureToolFilePathMap = filePathMapService.get(listItem);
            Future<Map<String, String>> FutureFoodFilePathMap = filePathMapService.get(listFood);
            Future<Map<String, String>> FutureSmallItemFilePathMap = filePathMapService.get(listSmallItem);
            Future<Map<String, String>> FutureCommercialFilePathMap = filePathMapService.get(listCommercialItem);
            Future<Map<String, String>> FutureOthersFilePathMap = filePathMapService.get(listothers);

            Map<String, String> ToolFilePathMap = FutureToolFilePathMap.get();
            Map<String, String> FoodFilePathMap = FutureFoodFilePathMap.get();
            Map<String, String> SmallItemFilePathMap = FutureSmallItemFilePathMap.get();
            Map<String, String> CommercialFilePathMap = FutureCommercialFilePathMap.get();
            Map<String, String> OthersFilePathMap = FutureOthersFilePathMap.get();

            log.warn("ThreadOut.listItem => "+listItem);
            log.warn("ThreadOut.listSmallItem => "+listSmallItem);
            log.warn("ThreadOut.listFood => "+listFood);
            log.warn("ThreadOut.listCommercialItem => "+listCommercialItem);
            log.warn("ThreadOut.listothers => "+listothers);

            model.addAttribute("listItem",listItem);
            model.addAttribute("listFood",listFood);
            model.addAttribute("listSmallItem",listSmallItem);
            model.addAttribute("listCommercialItem",listCommercialItem);
            model.addAttribute("listothers",listothers);
            Warehouse warehouse = vinService.queryRealWarehouseName(location);
            String realname = warehouse.getRealname();
            String warehouseid = warehouse.getWarehouseid();
            model.addAttribute("warehouse",realname);
            model.addAttribute("mainWarehouse","warehouse");
            model.addAttribute("mainWarehouseEN",location);
            model.addAttribute("logLocation","allItem?location="+location);
            model.addAttribute("userLevel",userLevel);
            model.addAttribute("warehouseid",warehouseid);
            model.addAttribute("ToolFilePathMap",ToolFilePathMap);
            model.addAttribute("FoodFilePathMap",FoodFilePathMap);
            model.addAttribute("SmallItemFilePathMap",SmallItemFilePathMap);
            model.addAttribute("CommercialFilePathMap",CommercialFilePathMap);
            model.addAttribute("OthersFilePathMap",OthersFilePathMap);
            return "allIteminMain1";
        }else {
            model.addAttribute("msg","哭哭！沒有權限！");
            return "login";
        }

    }


    //跳轉到新增頁面

    @RequestMapping("/toAdd")
    public String toAdd(Model model, @RequestParam String location, @RequestParam String category, HttpSession session){
        User user = (User) session.getAttribute("user");
        if(vinService.ifAccess(user,location)){
            String categoryCN = null;
            switch (category){
                case "tool":
                    categoryCN = "設備";
                    break;
                case "smalltool":
                    categoryCN = "小器具";
                    break;
                case "food":
                    categoryCN = "物料";
                    break;
                case "commercialthing":
                    categoryCN = "宣傳物料";
                    break;
                case "other":
                    categoryCN = "其他";
                    break;
            }
            vinService.toaddItem(location,"warehouse","add",categoryCN ,model, category);

            return "addItem";
        }else {
            model.addAttribute("msg","哭哭！沒有權限！");
            return "login";
        }


    }

    //insert庫存

    @RequestMapping("/add")
    public String add(VinItem items, @RequestParam("file") CommonsMultipartFile file, HttpServletRequest request, @RequestParam String location, @RequestParam String category, HttpSession session, Model model) throws IOException, InterruptedException {
        User user = (User) session.getAttribute("user");
        if(vinService.ifAccess(user,location)){
            if (items != null){
                //        System.out.println("addBook=>"+items);
                vinService.checkIfExistandAddinAllItem(items);

                taskExecutor.submit(() -> {
                    try {
                        logService.addLog("newinput", items, category, "outside", location, file, request);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }


//        vinService.addIteminMain1(items);
            return "redirect:/warehouse/allItem?location="+location;//重定向到我們的@RequestMapping("/allBook")請求
        }else {
            model.addAttribute("msg","哭哭！沒有權限！");
            return "login";
        }


    }


    //跳轉到修改頁面

    @RequestMapping("/toUpdate")
    public String toUpdate(String id, Model model, HttpSession session, @RequestParam String location, @RequestParam String category) throws InterruptedException {
        User user = (User)session.getAttribute("user");
        if(vinService.ifAccess(user,location)){
            int userLevel = user.getLevel();
            VinItem vinItem = null;
            String key = location + "," + category + "," + id;
            cacheService.waitRedisLock(key);
            if (category.equals("commercialthing")){
                vinItem = vinService.getVinItem(location, "commercial", id);
            }else {
                vinItem = vinService.getVinItem(location, category, id);
            }
            String itemName = vinItem.getItemName();
            System.out.println(vinItem);
            vinService.toupdateItem(location,"warehouse","update",itemName,model,vinItem,userLevel,category);
            return "updateItem";
        }else {
            model.addAttribute("msg","哭哭！沒有權限！");
            return "login";
        }

    }


    //修改項目
    @RequestMapping("/update")
    public String update(VinItem vinItem, @RequestParam String location, @RequestParam String category, HttpSession session, Model model) throws IOException, InterruptedException {
        User user = (User)session.getAttribute("user");
        if(vinService.ifAccess(user,location)){
            if (vinItem != null){
                vinMainControllerService.doUpdateVinItem(vinItem,location,category);
            }
//            //        System.out.println("updateItem=>"+vinItem);
//            VinItem vinItemOrigin;
//            String key;
//            if (category.equals("commercialthing")){
//                vinItemOrigin = vinService.getVinItem(location, "commercial", vinItem.getId());
//            }else {
//                vinItemOrigin = vinService.getVinItem(location, category, vinItem.getId());
//            }
//
//            taskExecutor.submit(new Runnable() {
//                @SneakyThrows
//                @Override
//                public void run() {
//                    vinService.addLog("edit", vinItemOrigin,category,location,location,null,null);
//                }
//            });
//            key = location + "," + category + "," + vinItem.getId();
//            String cacheKey = "vinItem" + category + "in" + location;
//            boolean ifSetLock = cacheService.setRedisLock(key, vinItem);
//            if(category.equals("commercialthing")){
//                if(ifSetLock){
//                    vinService.updateCache(cacheKey,vinItem,location,category);
//                    vinService.kafkaDoUpdate(vinItem,"commercial",location);
//                }
//
//            }else {
//                if(ifSetLock){
//                    vinService.updateCache(cacheKey,vinItem,location,category);
//                    vinService.kafkaDoUpdate(vinItem,category,location);
//                }
//
//            }
//            cacheService.waitRedisLock(key);




            return "redirect:/warehouse/allItem?location="+location;//重定向到我們的@RequestMapping("/allBook")請求
        }else {
            model.addAttribute("msg","哭哭！沒有權限！");
            return "login";
        }

    }


    @RequestMapping("/toInput")
    public String toInput(String id, Model model, HttpSession session, @RequestParam String location, @RequestParam String category) throws InterruptedException {
        User user = (User)session.getAttribute("user");
        if(vinService.ifAccess(user,location)){
            String key = location + "," + category + "," + id;
            cacheService.waitRedisLock(key);
            VinItem vinItem = null;
            if (category.equals("commercialthing")){
                vinItem = vinService.getVinItem(location, "commercial", id);
            }else {
                vinItem = vinService.getVinItem(location, category, id);
            }
            System.out.println(vinItem);
            model.addAttribute("vinItem",vinItem);
            Warehouse warehouse = vinService.queryRealWarehouseName(location);
            String realname = warehouse.getRealname();
//            User user = (User)session.getAttribute("user");
            int userLevel = user.getLevel();
            model.addAttribute("userLevel",userLevel);
            model.addAttribute("warehouse",realname);
            model.addAttribute("inputlocaltion","input");
            model.addAttribute("mainWarehouse","warehouse");
            model.addAttribute("inorout","入庫");
            model.addAttribute("location",location);
            model.addAttribute("category",category);

            return "inputItem";
        }else {
            model.addAttribute("msg","哭哭！沒有權限！");
            return "login";
        }

    }




    @RequestMapping("/input")
    public String input(VinItem vinItem, @RequestParam String location, @RequestParam String category, Model model, HttpSession session) throws IOException, InterruptedException {
        User user = (User)session.getAttribute("user");
        if(vinService.ifAccess(user,location)){
            if (vinItem != null){
                taskExecutor.submit(() -> {
                    try {
                        logService.addLog("input",vinItem,category,"outside",location, null, null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                vinMainControllerService.doInputVinItem(vinItem,location,category);
            }
//            String key = location + "," + category + "," + vinItem.getId();
//            boolean ifSetLock = cacheService.setRedisLock(key, vinItem);
//            VinItem vinItemOld = null;
//            if (category.equals("commercialthing")){
//                vinItemOld = vinService.getVinItem(location, "commercial", vinItem.getId());
//            }else {
//                vinItemOld = vinService.getVinItem(location, category, vinItem.getId());
//            }
//            int oldNum = vinItemOld.getItemCount();
//            double oldSingleprice = vinItemOld.getSinglePrice();
//            VinItem vinItem1 = new VinItem(vinItem);
//            System.out.println(oldNum);
//            taskExecutor.submit(new Runnable() {
//                @SneakyThrows
//                @Override
//                public void run() {
//                    vinService.addLog("input",vinItem1,category,"outside",location, null, null);
//                }
//            });
//            int inputCount = vinItem.getItemCount();
//            vinItem.setItemCount(oldNum + inputCount);
//            if(oldSingleprice == vinItem.getSinglePrice()){
//                vinItem.setTotalPrice(Math.round(vinItem.getItemCount() * vinItem.getSinglePrice() * 100.0) / 100.0);
//            }else {
//                double totalPrice = inputCount * vinItem.getSinglePrice() + vinItemOld.getTotalPrice();
//                totalPrice = Math.round(totalPrice*100.0)/100.0;
//                vinItem.setTotalPrice(totalPrice);
//                double singlePrice = totalPrice / (vinItem.getItemCount());
//                singlePrice = Math.round(singlePrice*100.0)/100.0;
//                vinItem.setSinglePrice(singlePrice);
//            }
//            System.out.println("updatetool=>"+vinItem);
//
//            String cacheKey = "vinItem" + category + "in" + location;
//
//            if (category.equals("commercialthing")){
//                if(ifSetLock) {
//                    vinService.updateCache(cacheKey,vinItem,location,category);
//                    vinService.kafkaDoUpdate(vinItem, "commercial", location);
//                }
//            }else {
//                if(ifSetLock) {
//                    vinService.updateCache(cacheKey,vinItem,location,category);
//                    vinService.kafkaDoUpdate(vinItem, category, location);
//                }
//            }
//
//            cacheService.waitRedisLock(key);


            return "redirect:/warehouse/allItem?location="+location;//重定向到我們的@RequestMapping("/allBook")請求
        }else {
            model.addAttribute("msg","哭哭！沒有權限！");
            return "login";
        }

    }

    //跳轉到出庫頁面

    @RequestMapping("/toOutput")
    public String toOutput(String id, Model model, HttpSession session, @RequestParam String location, @RequestParam String category) throws InterruptedException {
        User user = (User)session.getAttribute("user");
        if(vinService.ifAccess(user,location)){
            String key = location + "," + category + "," + id;
            cacheService.waitRedisLock(key);
            VinItem vinItem = null;
            if (category.equals("commercialthing")){
                vinItem = vinService.getVinItem(location, "commercial", id);
            }else {
                vinItem = vinService.getVinItem(location, category, id);
            }
            System.out.println(vinItem);
            model.addAttribute("vinItem",vinItem);
            Warehouse warehouse = vinService.queryRealWarehouseName(location);
            String realname = warehouse.getRealname();
//            User user = (User)session.getAttribute("user");
            int userLevel = user.getLevel();
            model.addAttribute("userLevel",userLevel);
            model.addAttribute("warehouse",realname);
            model.addAttribute("inputlocaltion","output");
            model.addAttribute("mainWarehouse","warehouse");
            model.addAttribute("inorout","出庫");
            model.addAttribute("location",location);
            model.addAttribute("category",category);

            return "inputItem";
        }else {
            model.addAttribute("msg","哭哭！沒有權限！");
            return "login";
        }
    }



    @RequestMapping("/output")
    public String output(VinItem vinItem, @RequestParam String location, @RequestParam String category, Model model, HttpSession session) throws IOException, InterruptedException {
        User user = (User)session.getAttribute("user");
        if(vinService.ifAccess(user,location)){
            if (vinItem != null){
                taskExecutor.submit(() -> {
                    try {
                        logService.addLog("output",vinItem,category,location,"outside", null, null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

                vinMainControllerService.doOutputVinItem(vinItem,location,category);
            }
//            String key = location + "," + category + "," + vinItem.getId();
//            boolean ifSetLock = cacheService.setRedisLock(key, vinItem);
//            VinItem vinItemOld = null;
//            if (category.equals("commercialthing")){
//                vinItemOld = vinService.getVinItem(location, "commercial", vinItem.getId());
//            }else {
//                vinItemOld = vinService.getVinItem(location, category, vinItem.getId());
//            }
//            int oldNum = vinItemOld.getItemCount();
//            VinItem vinItemLog = new VinItem(vinItem);//要改這邊
//            taskExecutor.submit(new Runnable() {
//                @SneakyThrows
//                @Override
//                public void run() {
//                    vinService.addLog("output",vinItemLog,category,location,"outside", null, null);
//                }
//            });
//
//            vinItem.setItemCount(oldNum - vinItem.getItemCount());
//            vinItem.setTotalPrice(Math.round(vinItem.getItemCount() * vinItem.getSinglePrice() * 100.0) / 100.0);//////
//            System.out.println("updatetool=>"+vinItem);
//
//            String cacheKey = "vinItem" + category + "in" + location;
//
//            if (category.equals("commercialthing")){
//                if(ifSetLock){
//                    vinService.updateCache(cacheKey,vinItem,location,category);
//                    vinService.kafkaDoUpdate(vinItem,"commercial",location);
//                }
//            }else {
//                if(ifSetLock) {
//                    vinService.updateCache(cacheKey,vinItem,location,category);
//                    vinService.kafkaDoUpdate(vinItem, category, location);
//                }
//            }
//            cacheService.waitRedisLock(key);


            return "redirect:/warehouse/allItem?location="+location;//重定向到我們的@RequestMapping("/allBook")請求
        }else {
            model.addAttribute("msg","哭哭！沒有權限！");
            return "login";
        }
    }


    //跳轉到轉移頁面

    @RequestMapping("/toSend")
    public String toSend(String id, @RequestParam String location, @RequestParam String category, Model model, HttpSession session) throws InterruptedException {
        User user = (User)session.getAttribute("user");
        if(vinService.ifAccess(user,location)){
            String key = location + "," + category + "," + id;
            cacheService.waitRedisLock(key);
            VinItem vinItem = null;
            if (category.equals("commercialthing")){
                vinItem = vinService.getVinItem(location, "commercial", id);
            }else {
                vinItem = vinService.getVinItem(location, category, id);
            }
            System.out.println(vinItem);
            model.addAttribute("vinItem",vinItem);
            Warehouse warehouse = vinService.queryRealWarehouseName(location);
            String realname = warehouse.getRealname();
            model.addAttribute("warehouse",realname);
            model.addAttribute("warehouseMap",vinService.getWarehouseMap());
            model.addAttribute("sendlocation","send");
            model.addAttribute("mainWarehouse","warehouse");
            model.addAttribute("pagename","轉移");
            model.addAttribute("location",location);
            model.addAttribute("category",category);

            return "sendItem";
        }else {
            model.addAttribute("msg","哭哭！沒有權限！");
            return "login";
        }
    }


    @RequestMapping("/send")
    public String send(VinItem vinItem, HttpServletRequest request, HttpServletResponse response, @RequestParam String location, @RequestParam String category, Model model, HttpSession session) throws IOException, InterruptedException {
        User user = (User)session.getAttribute("user");
        if(vinService.ifAccess(user,location)){
            if (vinItem != null){
                vinMainControllerService.doSendVinItem(vinItem, request, location, category);
            }
//            String key = location + "," + category + "," + vinItem.getId();
//            boolean ifSetLock = cacheService.setRedisLock(key, vinItem);
//            String target = request.getParameter("Warehouse");
//            taskExecutor.submit(new Runnable() {
//                @SneakyThrows
//                @Override
//                public void run() {
//                    vinService.addLog("send",vinItem,category,location,target,null, null);
//                }
//            });
//
//            System.out.println(target);
//            VinItem vinItemOld = null;
//            if (category.equals("commercialthing")){
//                vinItemOld = vinService.getVinItem(location, "commercial", vinItem.getId());
//            }else {
//                vinItemOld = vinService.getVinItem(location, category, vinItem.getId());
//            }
//            int oldNum = vinItemOld.getItemCount();
//            double oldtotalPrice = vinItemOld.getTotalPrice();
//            System.out.println(oldNum);
//            int num = vinItem.getItemCount();
//            double totalPrice = num * vinItem.getSinglePrice();
//            vinItem.setItemCount(oldNum - num);
//            double newTotalPrice = Math.round((oldtotalPrice - totalPrice)*100.0)/100.0;
//            vinItem.setTotalPrice(newTotalPrice);
//            System.out.println("updateTool=>"+vinItem);
//
//            String cacheKey = "vinItem" + category + "in" + location;
//
//            if (category.equals("commercialthing")){
//                if(ifSetLock) {
//                    vinService.updateCache(cacheKey,vinItem,location,category);
//                    vinService.kafkaDoUpdate(vinItem, "commercial", location);
//                }
//            }else {
//                if(ifSetLock) {
//                    vinService.updateCache(cacheKey,vinItem,location,category);
//                    vinService.kafkaDoUpdate(vinItem, category, location);
//                }
//            }
//            cacheService.waitRedisLock(key);


            return "redirect:/warehouse/allItem?location="+location;//重定向到我們的@RequestMapping("/allBook")請求
        }else {
            model.addAttribute("msg","哭哭！沒有權限！");
            return "login";
        }
    }



    //增刪改查的邏輯如果需要跟緩存配合就使能使用vinService，因為緩存的註解是寫在vinService

    public void deleteVinItem(@NotNull String location, @NotNull String category, @NotNull String id) {
        String key = location + "," + category + "," + id;;
        switch (category) {
            case "tool":
                switch (location) {
                    case "main0":
                        vinService.deleteIteminMain0byId(id);
                        break;
                    case "main1":
                        vinService.deleteIteminMain1byId(id);
                        break;
                    case "main2":
                        vinService.deleteIteminMain2byId(id);
                        break;
                    case "shop1":
                        vinService.deleteIteminShop1byId(id);
                        break;
                    case "shop2":
                        vinService.deleteIteminShop2byId(id);
                        break;
                    case "shop3":
                        vinService.deleteIteminShop3byId(id);
                        break;
                    case "shop4":
                        vinService.deleteIteminShop4byId(id);
                        break;
                    case "shop5":
                        vinService.deleteIteminShop5byId(id);
                        break;
                    case "shop6":
                        vinService.deleteIteminShop6byId(id);
                        break;
                    case "shop7":
                        vinService.deleteIteminShop7byId(id);
                        break;
                    case "shop8":
                        vinService.deleteIteminShop8byId(id);
                        break;
                    case "shop9":
                        vinService.deleteIteminShop9byId(id);
                        break;
                    case "shop10":
                        vinService.deleteIteminShop10byId(id);
                        break;
                    case "shop11":
                        vinService.deleteIteminShop11byId(id);
                        break;
                    case "shop12":
                        vinService.deleteIteminShop12byId(id);
                        break;
                }

                break;
            case "smalltool":
                switch (location) {
                    case "main0":
                        vinService.deleteSmallIteminMain0byId(id);
                        break;
                    case "main1":
                        vinService.deleteSmallIteminMain1byId(id);
                        break;
                    case "main2":
                        vinService.deleteSmallIteminMain2byId(id);
                        break;
                    case "shop1":
                        vinService.deleteSmallIteminShop1byId(id);
                        break;
                    case "shop2":
                        vinService.deleteSmallIteminShop2byId(id);
                        break;
                    case "shop3":
                        vinService.deleteSmallIteminShop3byId(id);
                        break;
                    case "shop4":
                        vinService.deleteSmallIteminShop4byId(id);
                        break;
                    case "shop5":
                        vinService.deleteSmallIteminShop5byId(id);
                        break;
                    case "shop6":
                        vinService.deleteSmallIteminShop6byId(id);
                        break;
                    case "shop7":
                        vinService.deleteSmallIteminShop7byId(id);
                        break;
                    case "shop8":
                        vinService.deleteSmallIteminShop8byId(id);
                        break;
                    case "shop9":
                        vinService.deleteSmallIteminShop9byId(id);
                        break;
                    case "shop10":
                        vinService.deleteSmallIteminShop10byId(id);
                        break;
                    case "shop11":
                        vinService.deleteSmallIteminShop11byId(id);
                        break;
                    case "shop12":
                        vinService.deleteSmallIteminShop12byId(id);
                        break;
                }

                break;
            case "food":
                switch (location) {
                    case "main0":
                        vinService.deleteFoodinMain0byId(id);
                        break;
                    case "main1":
                        vinService.deleteFoodinMain1byId(id);
                        break;
                    case "main2":
                        vinService.deleteFoodinMain2byId(id);
                        break;
                    case "shop1":
                        vinService.deleteFoodinShop1byId(id);
                        break;
                    case "shop2":
                        vinService.deleteFoodinShop2byId(id);
                        break;
                    case "shop3":
                        vinService.deleteFoodinShop3byId(id);
                        break;
                    case "shop4":
                        vinService.deleteFoodinShop4byId(id);
                        break;
                    case "shop5":
                        vinService.deleteFoodinShop5byId(id);
                        break;
                    case "shop6":
                        vinService.deleteFoodinShop6byId(id);
                        break;
                    case "shop7":
                        vinService.deleteFoodinShop7byId(id);
                        break;
                    case "shop8":
                        vinService.deleteFoodinShop8byId(id);
                        break;
                    case "shop9":
                        vinService.deleteFoodinShop9byId(id);
                        break;
                    case "shop10":
                        vinService.deleteFoodinShop10byId(id);
                        break;
                    case "shop11":
                        vinService.deleteFoodinShop11byId(id);
                        break;
                    case "shop12":
                        vinService.deleteFoodinShop12byId(id);
                        break;
                }

                break;
            case "commercialthing":
                switch (location) {
                    case "main0":
                        vinService.deletecommercialIteminMain0byId(id);
                        break;
                    case "main1":
                        vinService.deletecommercialIteminMain1byId(id);
                        break;
                    case "main2":
                        vinService.deletecommercialIteminMain2byId(id);
                        break;
                    case "shop1":
                        vinService.deletecommercialIteminShop1byId(id);
                        break;
                    case "shop2":
                        vinService.deletecommercialIteminShop2byId(id);
                        break;
                    case "shop3":
                        vinService.deletecommercialIteminShop3byId(id);
                        break;
                    case "shop4":
                        vinService.deletecommercialIteminShop4byId(id);
                        break;
                    case "shop5":
                        vinService.deletecommercialIteminShop5byId(id);
                        break;
                    case "shop6":
                        vinService.deletecommercialIteminShop6byId(id);
                        break;
                    case "shop7":
                        vinService.deletecommercialIteminShop7byId(id);
                        break;
                    case "shop8":
                        vinService.deletecommercialIteminShop8byId(id);
                        break;
                    case "shop9":
                        vinService.deletecommercialIteminShop9byId(id);
                        break;
                    case "shop10":
                        vinService.deletecommercialIteminShop10byId(id);
                        break;
                    case "shop11":
                        vinService.deletecommercialIteminShop11byId(id);
                        break;
                    case "shop12":
                        vinService.deletecommercialIteminShop12byId(id);
                        break;
                }

                break;
            case "other":
                switch (location) {
                    case "main0":
                        vinService.deleteothersinMain0byId(id);
                        break;
                    case "main1":
                        vinService.deleteothersinMain1byId(id);
                        break;
                    case "main2":
                        vinService.deleteothersinMain2byId(id);
                        break;
                    case "shop1":
                        vinService.deleteothersinShop1byId(id);
                        break;
                    case "shop2":
                        vinService.deleteothersinShop2byId(id);
                        break;
                    case "shop3":
                        vinService.deleteothersinShop3byId(id);
                        break;
                    case "shop4":
                        vinService.deleteothersinShop4byId(id);
                        break;
                    case "shop5":
                        vinService.deleteothersinShop5byId(id);
                        break;
                    case "shop6":
                        vinService.deleteothersinShop6byId(id);
                        break;
                    case "shop7":
                        vinService.deleteothersinShop7byId(id);
                        break;
                    case "shop8":
                        vinService.deleteothersinShop8byId(id);
                        break;
                    case "shop9":
                        vinService.deleteothersinShop9byId(id);
                        break;
                    case "shop10":
                        vinService.deleteothersinShop10byId(id);
                        break;
                    case "shop11":
                        vinService.deleteothersinShop11byId(id);
                        break;
                    case "shop12":
                        vinService.deleteothersinShop12byId(id);
                        break;
                }

                break;
        }
        cacheService.deleteRedisLock(key);

    }

    //刪除

    @RequestMapping("/delete/{id}/{location}/{category}")
    public String deleteTool(@PathVariable("id") String id, @PathVariable("location") String location, @PathVariable("category") String category, Model model, HttpSession session) throws IOException, InterruptedException {
        User user = (User)session.getAttribute("user");
        if(vinService.ifAccess(user,location)){
            VinItem vinItem;
            String key = location + "," + category + "," + id;
            String cacheKey = "vinItem" + category + "in" + location;
            if (category.equals("commercialthing")){
                vinItem = vinService.getVinItem(location, "commercial", id);
            }else {
                vinItem = vinService.getVinItem(location, category, id);
            }
            taskExecutor.submit(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    logService.addLog("delete",vinItem,category,location,"outside",null,null);
                }
            });
            boolean ifSetLock = cacheService.setRedisLock(key, vinItem);
            if(ifSetLock){
                deleteVinItem(location,category,id);
                cacheService.deleteCache(id, location, category);
            }
            cacheService.waitRedisLock(key);
            return "redirect:/warehouse/allItem?location="+location;//重定向到我們的@RequestMapping("/allBook")請求
        }else {
            model.addAttribute("msg","哭哭！沒有權限！");
            return "login";
        }
    }


    //查詢書籍
    //要跟前端的name一樣後端才能get

    @RequestMapping("/querytool")
    public String queryTool(String queryItemName, Model model, HttpSession session){
        String id = vinService.checkAllItem(queryItemName);
        if(id != ""){
            VinItem vinItem = vinService.queryIteminMain1byId(id);
            String location = "tool";
            if(vinItem == null){
                vinItem = vinService.querySmallIteminMain1byId(id);
                location = "smalltool";
            }
            if(vinItem == null){
                vinItem = vinService.queryFoodinMain1byId(id);
                location = "food";
            }
            if(vinItem == null){
                vinItem = vinService.querycommercialIteminMain1byId(id);
                location = "commercial";
            }
            if(vinItem == null){
                vinItem = vinService.queryothersinMain1byId(id);
                location = "other";
            }
            if(vinItem == null){
                location = "nowhere";
            }

            if(location.equals("nowhere")){
                model.addAttribute("errortool","未查到");
                return "redirect:/mainWarehouse1/allItem";
            }else {
                System.out.println(location);
                if(location.equals("tool")){
                    List<VinItem> listItem = new ArrayList<>();
                    listItem.add(vinItem);
                    model.addAttribute("listItem", listItem);
                    Warehouse warehouse = vinService.queryRealWarehouseName("main1");
                    String realname = warehouse.getRealname();
                    model.addAttribute("warehouse",realname);
//                model.addAttribute("warehouse","主倉ㄧ");
                    model.addAttribute("mainWarehouse","mainWarehouse1");

                }else if(location.equals("smalltool")){
                    List<VinItem> listSmallItem = new ArrayList<>();
                    listSmallItem.add(vinItem);
                    model.addAttribute("listSmallItem",listSmallItem);
                    Warehouse warehouse = vinService.queryRealWarehouseName("main1");
                    String realname = warehouse.getRealname();
                    model.addAttribute("warehouse",realname);
//                model.addAttribute("warehouse","主倉ㄧ");
                    model.addAttribute("mainWarehouse","mainWarehouse1");
                }else if(location.equals("food")){
                    List<VinItem> listFood = new ArrayList<>();
                    listFood.add(vinItem);
                    model.addAttribute("listFood",listFood);
                    Warehouse warehouse = vinService.queryRealWarehouseName("main1");
                    String realname = warehouse.getRealname();
                    model.addAttribute("warehouse",realname);
//                model.addAttribute("warehouse","主倉ㄧ");
                    model.addAttribute("mainWarehouse","mainWarehouse1");
                }else if(location.equals("commercial")){
                    List<VinItem> listCommercial = new ArrayList<>();
                    listCommercial.add(vinItem);
                    model.addAttribute("listCommercial",listCommercial);
                    Warehouse warehouse = vinService.queryRealWarehouseName("main1");
                    String realname = warehouse.getRealname();
                    model.addAttribute("warehouse",realname);
//                model.addAttribute("warehouse","主倉ㄧ");
                    model.addAttribute("mainWarehouse","mainWarehouse1");
                }else if(location.equals("other")){
                    List<VinItem> listOther = new ArrayList<>();
                    listOther.add(vinItem);
                    model.addAttribute("listOther",listOther);
                    Warehouse warehouse = vinService.queryRealWarehouseName("main1");
                    String realname = warehouse.getRealname();
                    model.addAttribute("warehouse",realname);
//                model.addAttribute("warehouse","主倉ㄧ");
                    model.addAttribute("mainWarehouse","mainWarehouse1");
                }
                return "allIteminMain1";
            }
        }else {
            model.addAttribute("errortool","未查到");
            return "redirect:/mainWarehouse1/allItem";
        }


    }
//    @RequestMapping("/querysmalltool")
//    public String querySmallTool(String queryItemName,Model model){
//        VinItem vinItem = vinService.querySmallIteminMain1ByName(queryItemName);
//        List<VinItem> listFood = vinService.queryAllFoodinMain1();
//        List<VinItem> listItem = vinService.queryAllSmallIteminMain1();
//        List<VinItem> listSmallItem = new ArrayList<>();
//        listSmallItem.add(vinItem);
//        if(vinItem == null){
//            listSmallItem = vinService.queryAllSmallIteminMain1();
//            model.addAttribute("smalltoolerror","未查到");
//        }
//        model.addAttribute("listItem",listItem);
//        model.addAttribute("listFood",listFood);
//        model.addAttribute("listSmallItem",listSmallItem);
//        return "allIteminMain1";
//
//    }
//    @RequestMapping("/queryfood")
//    public String queryFood(String queryItemName,Model model){
//        VinItem vinItem = vinService.queryFoodinMain1ByName(queryItemName);
//        List<VinItem> listItem = vinService.queryAllIteminMain1();
//        List<VinItem> listSmallItem = vinService.queryAllSmallIteminMain1();
//        List<VinItem> listFood = new ArrayList<>();
//        listFood.add(vinItem);
//        if(vinItem == null){
//            listFood = vinService.queryAllFoodinMain1();
//            model.addAttribute("fooderror","未查到");
//        }
//        model.addAttribute("listItem",listItem);
//        model.addAttribute("listFood",listFood);
//        model.addAttribute("listSmallItem",listSmallItem);
//        return "allIteminMain1";
//
//    }





}
