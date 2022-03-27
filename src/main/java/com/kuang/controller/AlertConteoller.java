package com.kuang.controller;

import com.alibaba.fastjson.JSONObject;
import com.kuang.pojo.*;
import com.kuang.service.VinService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/alert")
public class AlertConteoller {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/showAlert")
    public String alertMain0(Model model, HttpSession session, @RequestParam String location){
        User user = (User) session.getAttribute("user");
        if (user.getLevel()==1000){
            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String today = df.format(day);
            List<VinAlert> vinAlerts = vinService.getifAlert(location,today);
            HashMap<String, Integer> vinItemCountMap = new HashMap<>();
            for (VinAlert vinAlert : vinAlerts) {
                VinItem vinItem = null;
                String vinItemCacheKey = "vinItem"+vinAlert.getCategory()+"in"+location;
                String vinItemJSON = (String) redisTemplate.opsForHash().get(vinItemCacheKey,vinAlert.getId());
                vinItem = JSONObject.parseObject(vinItemJSON,VinItem.class);

                if(vinItem != null){
                    vinItemCountMap.put(vinItem.getId(), vinItem.getItemCount());
                }else {
                    System.out.println("Null vinItem ==>"+vinAlert.getId());
                }

            }
            System.out.println("vinAlerts==>"+vinAlerts);
            model.addAttribute("vinAlerts",vinAlerts);
            model.addAttribute("vinItemCountMap",vinItemCountMap);
            Warehouse warehouse = vinService.queryRealWarehouseName(location);
            String realname = warehouse.getRealname();
            model.addAttribute("warehouse",realname);
            model.addAttribute("mainWarehouse","alert");
            model.addAttribute("logLocation","showAlert?location="+location);

            return "alert";

        }else {
            model.addAttribute("msg","哭哭！沒有權限！");
            return "login";
        }


    }


}
