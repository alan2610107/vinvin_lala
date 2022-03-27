package com.kuang.controller;

import com.kuang.pojo.User;
import com.kuang.pojo.UserPage;
import com.kuang.pojo.Warehouse;
import com.kuang.service.CacheService;
import com.kuang.service.VinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserPageController {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private CacheService cacheService;

    @RequestMapping("/show")
    public String show(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        int userLevel = user.getLevel();
        model.addAttribute("userLevel", userLevel);
        List<UserPage> userpageList = new ArrayList<>();
        String realname;
        List<Warehouse> warehouseList = vinService.queryAllRealWarehouseName();

        for (Warehouse warehouse : warehouseList) {
            String location = warehouse.getNickname();
            String confrimCountKey = location + "notconfirmCount";
            String receiveCountKey = location + "notreceiveCount";
            String keyNotInputDateinExpiredCount = location + "notInputDateinExpiredCount";
            boolean ConfrimCountKeyExist = redisTemplate.hasKey(confrimCountKey);
            boolean ReceiveCountKeyExist = redisTemplate.hasKey(receiveCountKey);
            boolean keyNotInputDateinExpiredCountExist = redisTemplate.hasKey(keyNotInputDateinExpiredCount);
            int notReceiveNum = 0;
            int notConfirmNum = 0;
            int expiredCount = 0;
            int expiredSoonCount = 0;
            int noticeExpiredCount = 0;
            int notInputDateinExpiredCount = 0;

            cacheService.setNotInputDateinExpiredCount(location);
            notInputDateinExpiredCount = (int) redisTemplate.opsForValue().get(keyNotInputDateinExpiredCount);
//            if (keyNotInputDateinExpiredCountExist) {
//                notInputDateinExpiredCount = (int) redisTemplate.opsForValue().get(keyNotInputDateinExpiredCount);
//            } else {
//                notInputDateinExpiredCount = vinService.queryNotInputDateinExpireCount(location);
//                redisTemplate.opsForValue().set(keyNotInputDateinExpiredCount, notInputDateinExpiredCount);
//            }
            cacheService.setTodoConfirmCount(location);
            notConfirmNum = (int) redisTemplate.opsForValue().get(confrimCountKey);
//            if(ConfrimCountKeyExist){
//                notCinfirmNum = (int)redisTemplate.opsForValue().get(confrimCountKey);
//            }else {
//                notCinfirmNum = cacheService.getConfirmCount(location,"tool","newinput", "input") +
//                        cacheService.getConfirmCount(location,"food","newinput", "input") +
//                        cacheService.getConfirmCount(location,"smalltool","newinput", "input") +
//                        cacheService.getConfirmCount(location,"commercialthing","newinput", "input") +
//                        cacheService.getConfirmCount(location,"other","newinput", "input");
//                redisTemplate.opsForValue().set(confrimCountKey,notCinfirmNum);
//            }
            cacheService.setTodoReceiveCount(location);
            notReceiveNum = (int) redisTemplate.opsForValue().get(receiveCountKey);
//            if(ReceiveCountKeyExist){
//                notReceiveNum = (int)redisTemplate.opsForValue().get(receiveCountKey);
//            }else {
//                notReceiveNum = cacheService.getReceiveCount(location,"tool") +
//                        cacheService.getReceiveCount(location,"food") +
//                        cacheService.getReceiveCount(location,"smalltool") +
//                        cacheService.getReceiveCount(location,"commercialthing") +
//                        cacheService.getReceiveCount(location,"other");
//                redisTemplate.opsForValue().set(receiveCountKey,notReceiveNum);
//
//            }
            expiredCount = Integer.parseInt(cacheService.getExpiredItemCountCache(location));
            expiredSoonCount = Integer.parseInt(cacheService.getExpiredSoonItemCountCache(location));
            noticeExpiredCount = expiredCount + expiredSoonCount;


            realname = vinService.queryRealWarehouseName(location).getRealname();
            userpageList.add(new UserPage(location, "receive/list?location=" + location, "confirm/listnotpass?location=" + location, "log/warehouseifComplete?location=" + location + "&ifComplete=false", notReceiveNum, notConfirmNum, realname, noticeExpiredCount, notInputDateinExpiredCount));
        }
        model.addAttribute("userpageList", userpageList);
        model.addAttribute("mainWarehouse", "user");
        model.addAttribute("logLocation", "show");
        model.addAttribute("warehouse", "Todo-List");


//        if(userLevel == 1000){
//
//        }else {
//
//        }
        return "userpage";

    }


}
