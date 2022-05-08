package com.kuang.controller;

import com.alibaba.fastjson.JSONArray;
import com.kuang.pojo.ItemSet;
import com.kuang.pojo.ItemSetWithItemName;
import com.kuang.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.*;

@RequestMapping("/item")
@Controller
public class ItemController {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    @Resource
    private ThreadPoolTaskExecutor taskExecutor;

    @Resource
    private CacheService cacheService;

    @Resource
    private ItemControllerService itemControllerService;

    @RequestMapping("/showItemSet")
    public String showItemSet(@RequestParam String category, Model model){
        List<ItemSetWithItemName> itemSetList = vinService.queryItemSetByCategory(category);
        Map<String, String> categoryMap = vinService.getCategoryMap();
        model.addAttribute("itemSetList", itemSetList);
        model.addAttribute("warehouse","調整物廖順序");
        model.addAttribute("mainWarehouse","item");
        model.addAttribute("logLocation","showItemSet");
        model.addAttribute("categoryCN", categoryMap.get(category));
        model.addAttribute("category", category);

        return "showItemSet";
    }


    @RequestMapping("/setItemSetOrder")
    public void setItemSetOrder(@RequestParam String category, @RequestParam("items[]") String items){
        List<ItemSet> itemSetList = new ArrayList<>();
        JSONArray jsonarray = JSONArray.parseArray(items);
        for (int i = 0; i < jsonarray.size(); i++) {
            String itemID = JSONArray.parseArray(jsonarray.getString(i).toLowerCase(Locale.ROOT)).get(1).toString();
            String order = JSONArray.parseArray(jsonarray.getString(i).toLowerCase(Locale.ROOT)).get(2).toString();
            itemSetList.add(new ItemSet(Integer.parseInt(order), itemID));
        }
        for (ItemSet itemSet: itemSetList) {
            itemControllerService.addItemSetByCategory(itemSet, category);
        }
        cacheService.deleteItemSetCache(category);
    }
}
