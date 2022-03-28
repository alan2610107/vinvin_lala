package com.kuang.controller;

import com.kuang.pojo.ApplyItem;
import com.kuang.pojo.ApplyItemSec;
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
@RequestMapping("/apply")
public class ApplyController {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    @Resource
    private ThreadPoolTaskExecutor taskExecutor;

    @Resource
    private ApplyControllerService applyControllerService;


    @RequestMapping("/toApplyItem")
    public String toApplyItem(Model model, HttpSession session, @RequestParam String location) {
        User user = (User) session.getAttribute("user");
        if (vinService.ifAccess(user, location)) {

            model.addAttribute("location", location);
            model.addAttribute("warehouse", vinService.queryRealWarehouseName(location).getRealname());
            model.addAttribute("applyTime", vinService.getDate());
            model.addAttribute("month",vinService.getMonth());
            model.addAttribute("applyName", user.getUname());
            model.addAttribute("warehouseMap", vinService.getWarehouseMap());
            return "addApplyItem";
        } else {
            model.addAttribute("msg", "哭哭！沒有權限！");
            return "login";
        }
    }
    @RequestMapping("/applyItem")
    public String applyItem(ApplyItem applyItem, HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        String location = applyItem.getLocation();
        if (vinService.ifAccess(user, location)) {
            /*進資料庫*/
            applyItem.setLogID(vinService.getUUID());
            applyItem.setStatus("NOT_SHIP");
            applyItem.setConfirm(false);
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
            List<ApplyItem> applyItemList = vinService.queryApplyItembyLocation(location);
            String warehouse = vinService.queryRealWarehouseName(location).getRealname();
            System.out.println(applyItemList);
            model.addAttribute("applyItemList", applyItemList);
            model.addAttribute("mainWarehouse", "apply");
            model.addAttribute("logLocation", "showApplyItem?location="+location);
            model.addAttribute("warehouse", warehouse + "物料申請清單");
            model.addAttribute("statusMap", applyControllerService.getStatusMap());
            model.addAttribute("confirmResultMap", applyControllerService.getConfirmResultMap());

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
    public String confirmApplyItem(@RequestParam String logID, HttpSession session, @RequestParam String location, @RequestParam String confirm, Model model){
        ApplyItem applyItem = vinService.queryApplyItembyLogID(logID);
        applyItem.setConfirm(true);
        applyItem.setConfirmResult(confirm);
        vinService.updateApplyItem(applyItem);
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

    @RequestMapping("/toBuyApplyItem")
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



    @RequestMapping("/buyApplyItem")
    public String buyApplyItem(ApplyItem applyItem,HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        String location = applyItem.getLocation();
        if (vinService.ifAccess(user, location)) {
            applyItem.setTotalPrice(applyItem.getCount() * applyItem.getSinglePrice());
            if(applyItem.getPurchaseTime() == null || applyItem.getPurchaseTime().isEmpty()){
                applyItem.setPurchaseTime(vinService.getDate());
            }
            ApplyItem OriginalApplyItem = vinService.queryApplyItembyLogID(applyItem.getLogID());
            ApplyItem toApplyItemSec = new ApplyItem(applyItem);
            toApplyItemSec.setTotalPrice(applyItem.getTotalPrice() - OriginalApplyItem.getTotalPrice());
            applyControllerService.autoAddApplyItemSec(toApplyItemSec);


            vinService.updateApplyItem(applyItem);
            return "redirect:/apply/showApplyItem?location="+location;
        } else {
            model.addAttribute("msg", "哭哭！沒有權限！");
            return "login";
        }
    }

}
