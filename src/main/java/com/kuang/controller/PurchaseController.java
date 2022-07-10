package com.kuang.controller;

import com.kuang.pojo.ApplyItem;
import com.kuang.pojo.ApplyItemConfirm;
import com.kuang.pojo.PurchaseItem;
import com.kuang.pojo.User;
import com.kuang.service.ApplyControllerService;
import com.kuang.service.VinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    @Resource
    private ThreadPoolTaskExecutor taskExecutor;

    @Resource
    private ApplyControllerService applyControllerService;

    private String redirectLink = "redirect:/purchase/showPurchaseItem?location=";


    @RequestMapping("/toPurchaseApplyItem")
    public String toBuyApplyItem(@RequestParam String logID, HttpSession session, @RequestParam String location, Model model){
        User user = (User) session.getAttribute("user");
        if (user.getLevel() == 1000) {
            String warehouse = vinService.queryRealWarehouseName(location).getRealname();
            model.addAttribute("applyItem", vinService.queryApplyItembyLogID(logID));
            model.addAttribute("warehouseMap", vinService.getWarehouseMap());
            model.addAttribute("statusMap", applyControllerService.getStatusMap());
            model.addAttribute("warehouse", warehouse + "物料採購");
            return "buyApplyItem";
        } else {
            model.addAttribute("msg", "哭哭！沒有權限！");
            return "login";
        }
    }



//    @RequestMapping("/buyApplyItem")
//    public String buyApplyItem(ApplyItem applyItem, HttpSession session, Model model){
//        User user = (User) session.getAttribute("user");
//        String location = applyItem.getLocation();
//        if (vinService.ifAccess(user, location)) {
//            applyItem.setTotalPrice(applyItem.getCount() * applyItem.getSinglePrice());
//            if(applyItem.getPurchaseTime() == null || applyItem.getPurchaseTime().isEmpty()){
//                applyItem.setPurchaseTime(vinService.getDate());
//            }
//            ApplyItem OriginalApplyItem = vinService.queryApplyItembyLogID(applyItem.getLogID());
//            ApplyItem toApplyItemSec = new ApplyItem(applyItem);
//            toApplyItemSec.setTotalPrice(applyItem.getTotalPrice() - OriginalApplyItem.getTotalPrice());
//            applyControllerService.autoAddApplyItemSec(toApplyItemSec);
//            vinService.updateApplyItem(applyItem);
//            return "redirect:/apply/showApplyItem?location="+location;
//        } else {
//            model.addAttribute("msg", "哭哭！沒有權限！");
//            return "login";
//        }
//    }

    @RequestMapping("/showPurchaseItem")
    public String showPurchaseItem(HttpSession session, Model model, @RequestParam String location){
        User user = (User) session.getAttribute("user");
        if(user.getLevel() == 1000){
            List<PurchaseItem> purchaseItemList = vinService.queryPurchaseItemByLocation(location);
            HashMap<String, String> warehouseMap = vinService.getWarehouseMap();
            model.addAttribute("purchaseItemList", purchaseItemList);
            model.addAttribute("warehouseMap", warehouseMap);
            model.addAttribute("statusMap", applyControllerService.getStatusMap());
            return "showPurchaseItem";
        }else {
            model.addAttribute("msg", "哭哭！沒有權限！");
            return "login";
        }
    }

    @RequestMapping("/toPurchaseApplyConfirmItem")
    public String toBuyApplyConfirmItem(@RequestParam String logID, HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        if(user.getLevel() == 1000){
            PurchaseItem purchaseItem = vinService.queryPurchaseItemByLogID(logID);
            HashMap<String, String> warehouseMap = vinService.getWarehouseMap();
            model.addAttribute("purchaseItem", purchaseItem);
            model.addAttribute("warehouseMap", warehouseMap);
            model.addAttribute("statusMap", applyControllerService.getStatusMap());
            return "purchaseApplyConfirmItem";
        }else {
            model.addAttribute("msg", "哭哭！沒有權限！");
            return "login";
        }
    }

    @RequestMapping("/purchaseApplyConfirmItem")
    public String purchaseApplyConfirmItem(HttpSession session, Model model, PurchaseItem purchaseItem){
        User user = (User) session.getAttribute("user");
        if(user.getLevel() == 1000){
            Double totalPrice = Math.round(purchaseItem.getSinglePrice() * purchaseItem.getCount() * 100.0 ) / 100.0;
            purchaseItem.setTotalPrice(totalPrice);
            purchaseItem.setPurchaseTime(vinService.getDateTime());
            purchaseItem.setPurchaseMonth(vinService.getMonth());
//            System.out.println(purchaseItem);
            vinService.updatePurchaseItemByLogID(purchaseItem);
            return redirectLink+purchaseItem.getLocation();
        }else {
            model.addAttribute("msg", "哭哭！沒有權限！");
            return "login";
        }
    }



}
