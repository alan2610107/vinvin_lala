package com.kuang.controller;

import com.kuang.pojo.*;
import com.kuang.service.FileUploadService;
import com.kuang.service.VinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/change")
public class ChangeItemNameController {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private ThreadPoolTaskExecutor taskExecutor;

    @Resource
    private FileUploadService fileUploadService;

    @RequestMapping("/showAllItem")
    public String showAllItem(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        int userLevel = user.getLevel();
        if(userLevel == 1000){
            List<Item> itemTool = vinService.queryAllItembyCategory("tool");
            List<Item> itemSmallTool = vinService.queryAllItembyCategory("smalltool");
            List<Item> itemFood = vinService.queryAllItembyCategory("food");
            List<Item> itemCommercial = vinService.queryAllItembyCategory("commercial");
            List<Item> itemOther = vinService.queryAllItembyCategory("other");

            model.addAttribute("itemTool",itemTool);
            model.addAttribute("itemSmallTool",itemSmallTool);
            model.addAttribute("itemFood",itemFood);
            model.addAttribute("itemCommercial",itemCommercial);
            model.addAttribute("itemOther",itemOther);
            model.addAttribute("warehouse","修改物品名稱");
            model.addAttribute("mainWarehouse","change");
            model.addAttribute("logLocation","showAllItem");

            return "showAllItem";
        }else {
            model.addAttribute("msg","哭哭！沒有權限！");
            return "login";
        }

    }

    @RequestMapping("/toChangeItemName")
    public String toChangeItemName(Model model, HttpSession session, String id){
        Item item = vinService.queryAllItembyID(id);
        String filepath = "/no_filepath";
        int ifExist = vinService.ifExistFileTypebyID(id);
        if(ifExist > 0){
            filepath = vinService.queryFileTypebyid(item.getItemID()).getFilepath();
        }

        model.addAttribute("item", item);
        model.addAttribute("filepath", filepath);
        return "changeItemName";
    }

    @RequestMapping("/changeItemName")
    public String changeItemName(Item item, HttpServletRequest request, @RequestParam String category, @RequestParam("file") CommonsMultipartFile file) throws IOException {
        System.out.println(item);
        System.out.println(category);

        String id = item.getItemID();
        String newItemName = item.getItemName();

        if(!file.isEmpty()){
            fileUploadService.fileUpload(file, request, id,"/fruitInvoice");
        }

        //更新item數據庫
        Item targetAllItem = vinService.queryAllItembyID(id);
        targetAllItem.setItemName(newItemName);
        vinService.updateAllItem(targetAllItem);

        //清空vinItem緩存
        List<Warehouse> warehouses = vinService.queryAllRealWarehouseName();

        for (Warehouse warehouse : warehouses) {
            System.out.println(warehouse);
            String keyERP = "vinItem" + category + "in" + warehouse.getNickname();
//            System.out.println(key);
            redisTemplate.delete(keyERP);
        }
        String keyFinance = "FinanceitemFor" + category;
        redisTemplate.delete(keyFinance);


        return "redirect:/change/showAllItem";
    }
}
