package com.kuang.service;

import com.kuang.pojo.Expired;
import com.kuang.pojo.VinItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;


@Service
@Slf4j
public class ReceiveControllerService {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    @Resource
    private CacheService cacheService;

    @Resource
    private ThreadPoolTaskExecutor taskExecutor;

    @Resource
    private VinMainControllerService vinMainControllerService;

    /**
     * @apiNote Do Input VinItem for Receive
     * @param vinItem
     * @param location
     * @param category
     */
//    public void doReceiveInputVinItem(VinItem vinItem, String location, String category){
//        log.warn("Do Receive Input");
//        int ifExist = vinService.ifExist(location, category, vinItem.getId());
//        if(ifExist > 0){
//            VinItem updateVinItem = vinMainControllerService.input(vinItem,location,category);
//            vinMainControllerService.update(updateVinItem,location,category);
//        }else {
//            vinMainControllerService.add(vinItem,location,category);
//        }
//
//    }

    /**
     * @apiNote Add Expired Date Item
     * @param inputVinItem
     * @param category
     * @param location
     */
    public void addExpiredDateItem(VinItem inputVinItem, String category, String location){
        if (category.equals("food") && inputVinItem.getItemName().contains("牛奶")) {
            taskExecutor.submit(() -> {
                for (int i = 0; i < inputVinItem.getItemCount(); i++) {
                    Expired expiredDate = new Expired(inputVinItem.getId(), "123", location);
                    vinService.addExpiredDate(expiredDate);
                }
            });
        }
    }


}
