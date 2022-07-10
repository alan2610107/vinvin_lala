package com.kuang.service;

import com.kuang.pojo.ApplyItem;
import com.kuang.pojo.ApplyItemSec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

@Service
@Slf4j
public class ApplyControllerService {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    @Resource
    private ThreadPoolTaskExecutor taskExecutor;

    public HashMap<String,String> getStatusMap(){
        HashMap<String,String> statusMap = new HashMap<>();
        statusMap.put("PROCESSING","處理中");
        statusMap.put("BUY","已採購");
        statusMap.put("SHIP","已配送");
        statusMap.put("ARRIVE","已送達");
        statusMap.put("REFUSE","沒過審核或其他狀況");
        return statusMap;
    }
    public HashMap<String,String> getConfirmResultMap(){
        HashMap<String,String> confirmResultMap = new HashMap<>();
        confirmResultMap.put("confirmed","已通過");
        confirmResultMap.put("refuse","未通過");

        return confirmResultMap;
    }

//    public void autoAddApplyItemSec(ApplyItem applyItem){
//        taskExecutor.submit(() -> {
//            String month = applyItem.getMonth();
//            String store = applyItem.getLocation();
//            String id = store + "_" + month;
//            int ifExist = 0;
//            ifExist = vinService.ifExistApplyItemSec(id);
//            if(ifExist > 0){
//                ApplyItemSec applyItemSec = vinService.queryApplyItemSecbyID(id);
//                applyItemSec.setTotalPrice(applyItemSec.getTotalPrice() + applyItem.getTotalPrice());
//                vinService.updateApplyItemSec(applyItemSec);
//            }else {
//                ApplyItemSec applyItemSec = new ApplyItemSec();
//                applyItemSec.setId(id);
//                applyItemSec.setMonth(month);
//                applyItemSec.setStore(store);
//                applyItemSec.setTotalPrice(applyItem.getTotalPrice());
//                vinService.addApplyItemSec(applyItemSec);
//            }
//
//        });
//    }
}
