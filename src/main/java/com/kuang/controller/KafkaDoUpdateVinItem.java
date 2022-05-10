package com.kuang.controller;

import com.kuang.pojo.VinItem;
import com.kuang.pojo.VinItemwithLocationandCategory;
import com.kuang.service.CacheService;
import com.kuang.service.VinService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;
@Slf4j
@Controller
public class KafkaDoUpdateVinItem {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    @Resource
    private CacheService cacheService;

    @KafkaListener(topics = "updateVinItem",concurrency = "2")
    public void doUpdate(List<ConsumerRecord<String, VinItemwithLocationandCategory>> records, Acknowledgment ack) {
        log.warn("有"+records.size()+"被消費了");
        for (int i = 0; i < records.size(); i++) {
            ConsumerRecord<String, VinItemwithLocationandCategory> record = records.get(i);
            VinItemwithLocationandCategory vinItemwithLocationandCategory = record.value();
            log.warn("=========onMessage===========" + vinItemwithLocationandCategory);
            String type = vinItemwithLocationandCategory.getCategory();
            String location = vinItemwithLocationandCategory.getLocation();
            VinItem vinItem = new VinItem(vinItemwithLocationandCategory);
            String key;
            if(type.equals("commercial")){
                key = location + "," + "commercialthing" + "," + vinItem.getId();
            }else {
                key = location + "," + type + "," + vinItem.getId();
            }

            try{
                vinService.updateItemInWarehouse(location, type, vinItem);
                cacheService.deleteRedisLock(key);
            }catch (Exception e){
                log.error("======SomeError======"+vinItem);
            }finally {
                ack.acknowledge();
            }


        }






    }


}
