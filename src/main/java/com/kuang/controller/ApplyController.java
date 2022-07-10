package com.kuang.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.kuang.pojo.*;
import com.kuang.service.ApplyControllerService;
import com.kuang.service.CacheService;
import com.kuang.service.ConfirmControllerService;
import com.kuang.service.VinService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j
@Controller
@RequestMapping("/apply")
public class ApplyController {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    @Resource
    private ThreadPoolTaskExecutor taskExecutor;

    @Resource
    private ApplyControllerService applyControllerService;

    @Resource
    private CacheService cacheService;

    @Resource
    private ConfirmControllerService confirmControllerService;


    @RequestMapping("/toApplyItem")
    public String toApplyItem(Model model, HttpSession session, @RequestParam String location, @RequestParam String category) {
        User user = (User) session.getAttribute("user");
        if (vinService.ifAccess(user, location)) {
            String realWarehouseName = vinService.queryRealWarehouseName(location).getRealname();
//            List<Item> itemList = vinService.queryAllItembyCategory(category);
            List<Item> itemList = cacheService.getItemByCategory(category);

            model.addAttribute("itemList", itemList);
            model.addAttribute("location", location);
            model.addAttribute("realWarehouseName", realWarehouseName);
            model.addAttribute("warehouse",realWarehouseName + "報貨表");
            model.addAttribute("mainWarehouse","apply");
            model.addAttribute("logLocation","toApplyItem");
            model.addAttribute("category", category);
            model.addAttribute("categoryMap",vinService.getCategoryMap());

            return "applyItem";
        }else {
            model.addAttribute("msg", "哭哭！沒有權限！");
            return "login";
        }
    }

    @Transactional
    public void addApplyItem(ApplyItem applyItem, ApplyItemConfirm applyItemConfirm){
        log.warn("Transaction Start!!!!!");
        vinService.addApplyItem(applyItem);
        vinService.addApplyItemConfirm(applyItemConfirm);
        log.warn("Transaction End!!!!!");
    }

    @RequestMapping("/applyItem")
    public String applyItem(@RequestParam("items[]") String items, @RequestParam String location, @RequestParam String category, HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        if (vinService.ifAccess(user, location)) {
            if(!items.equals("[]")){
                System.out.println(items);
                System.out.println(location);
                System.out.println(category);

                JSONArray allApplyItemArray = JSON.parseArray(items);
                System.out.println(allApplyItemArray);
                for (Object applyItemArray : allApplyItemArray) {
                    JSONArray applyItemJSON = JSON.parseArray(applyItemArray.toString());
                    String itemName = (String) applyItemJSON.get(0);
                    String itemID = (String) applyItemJSON.get(1);
                    int itemCount = Integer.parseInt((String) applyItemJSON.get(2));
                    System.out.println(itemName);
                    System.out.println(itemID);
                    System.out.println(itemCount);
                    String logID = vinService.getUUID();
                    ApplyItem applyItem = new ApplyItem(logID, vinService.getDateTime(),
                            location ,itemID, itemName, itemCount, user.getUname(), vinService.getMonth());
                    ApplyItemConfirm applyItemConfirm = new ApplyItemConfirm(logID, null, null, null, null, null, null);
                    addApplyItem(applyItem, applyItemConfirm);
                }
            }else {
                log.warn("No Item!!!");
            }
            return "";
        }else {
            model.addAttribute("msg", "哭哭！沒有權限！");
            return "login";
        }

    }

    @RequestMapping("/toApplyOtherItem")
    public String toApplyOtherItem(Model model, HttpSession session, @RequestParam String location) {
        User user = (User) session.getAttribute("user");
        if (vinService.ifAccess(user, location)) {
            model.addAttribute("location", location);
            model.addAttribute("warehouse", vinService.queryRealWarehouseName(location).getRealname());
            model.addAttribute("applyTime", vinService.getDate());
            model.addAttribute("month",vinService.getMonth());
            model.addAttribute("applyName", user.getUname());
            model.addAttribute("warehouseMap", vinService.getWarehouseMap());
            return "applyOtherItem";
        } else {
            model.addAttribute("msg", "哭哭！沒有權限！");
            return "login";
        }
    }
    @RequestMapping("/applyOtherItem")
    public String applyOtherItem(ApplyItem applyItem, HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        String location = applyItem.getLocation();
        if (vinService.ifAccess(user, location)) {
            /*進資料庫*/
            applyItem.setLogID(vinService.getUUID());
//            applyItem.setStatus("NOT_SHIP");
//            applyItem.setConfirm(false);(notice!!!!!!!!!!)
            System.out.println(applyItem);
            vinService.addApplyItem(applyItem);
            return "redirect:/warehouse/allItem?location="+location;
        } else {
            model.addAttribute("msg", "哭哭！沒有權限！");
            return "login";
        }
    }


    @RequestMapping("/showApplyItem")
    public String showApplyItem(@RequestParam String location, Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        if (vinService.ifAccess(user, location)) {
            Map<String, String> itemConfirmStatusMap = new HashMap<>();
            List<ApplyItemShow> applyItemList = vinService.queryApplyItembyLocation(location);
            String warehouse = vinService.queryRealWarehouseName(location).getRealname();
//            System.out.println(applyItemList);
            for (ApplyItem applyItem : applyItemList) {
                String logID = applyItem.getLogID();
                String itemConfirmStatus = confirmControllerService.getItemConfirm(logID);
                itemConfirmStatusMap.put(logID, itemConfirmStatus);
            }
            Map<String, String> confirmStatusMap = confirmControllerService.getConfirmStatusMap();
            model.addAttribute("applyItemList", applyItemList);
            model.addAttribute("itemConfirmStatusMap", itemConfirmStatusMap);
            model.addAttribute("confirmStatusMap", confirmStatusMap);
            model.addAttribute("mainWarehouse", "apply");
            model.addAttribute("logLocation", "showApplyItem?location="+location);
            model.addAttribute("warehouse", warehouse + "物料申請清單");
            model.addAttribute("statusMap", applyControllerService.getStatusMap());
            model.addAttribute("confirmResultMap", applyControllerService.getConfirmResultMap());
            model.addAttribute("location", location);

            return "showApplyItem";
        } else {
            model.addAttribute("msg", "哭哭！沒有權限！");
            return "login";
        }
    }

    @RequestMapping("/deleteApplyItem")
    public String deleteApplyItem(@RequestParam String logID, HttpSession session, @RequestParam String location, Model model){
        User user = (User) session.getAttribute("user");
        if (vinService.ifAccess(user, location)) {
            vinService.deleteApplyItem(logID);
            return "redirect:/apply/showApplyItem?location="+location;
        } else {
            model.addAttribute("msg", "哭哭！沒有權限！");
            return "login";
        }
    }

    @RequestMapping("/confirmApplyItem")
    public String confirmApplyItem(@RequestParam String logID, @RequestParam String location, @RequestParam String confirm, Model model){
        ApplyItem applyItem = vinService.queryApplyItembyLogID(logID);
//        applyItem.setConfirm(true);(notice!!!!!!!!!!)
//        applyItem.setConfirmResult(confirm);
        vinService.updateApplyItem(applyItem);
        taskExecutor.submit(() -> {
            if(confirm.equals("confirmed")){
                vinService.addApplyItemConfirmLogID(logID);
            }
        });
        return "redirect:/apply/showApplyItem?location="+location;
    }

    @RequestMapping("/toeditApplyItem")
    public String toeditApplyItem(@RequestParam String logID, HttpSession session, @RequestParam String location, Model model){
        User user = (User) session.getAttribute("user");
        if (vinService.ifAccess(user, location)) {
            model.addAttribute("applyItem", vinService.queryApplyItembyLogID(logID));
            model.addAttribute("warehouseMap", vinService.getWarehouseMap());
//            model.addAttribute("role", "edit");
//            model.addAttribute("role", "buy");

            return "editApplyItem";
        } else {
            model.addAttribute("msg", "哭哭！沒有權限！");
            return "login";
        }
    }

    @RequestMapping("/editApplyItem")
    public String editApplyItem(ApplyItem applyItem,HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        String location = applyItem.getLocation();
        if (vinService.ifAccess(user, location)) {
            vinService.updateApplyItem(applyItem);
            return "redirect:/apply/showApplyItem?location="+location;
        } else {
            model.addAttribute("msg", "哭哭！沒有權限！");
            return "login";
        }
    }


}
