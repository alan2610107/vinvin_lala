package com.kuang.service;

import com.kuang.pojo.Expired;
import com.kuang.pojo.VinItem;
import com.kuang.pojo.VinLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


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


    public List<VinLog> queryReceiveByCategory(String location, String category) {
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
            case "shop13":
                receiveList = vinService.queryCategoryReceiveinShop13(category);
                break;
            case "shop14":
                receiveList = vinService.queryCategoryReceiveinShop14(category);
                break;
        }
        return receiveList;
    }


}
