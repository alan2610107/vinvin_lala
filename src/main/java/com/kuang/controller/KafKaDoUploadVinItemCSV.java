package com.kuang.controller;

import com.kuang.pojo.VinItem;
import com.kuang.pojo.VinItemwithLocationandCategory;
import com.kuang.service.VinService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Controller;

import java.util.List;

@Slf4j
@Controller
public class KafKaDoUploadVinItemCSV {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;
//    producer會自動根據分區的數量和concurrency的數量自動分配
    @KafkaListener(topics = "test3",concurrency = "2")
    public void onMessage(List<ConsumerRecord<String,VinItemwithLocationandCategory>> records, Acknowledgment ack) {
        log.warn("有"+records.size()+"被消費了");
        for (int i = 0; i < records.size(); i++) {
            ConsumerRecord<String, VinItemwithLocationandCategory> record = records.get(i);
            VinItemwithLocationandCategory vinItemwithLocationandCategory = record.value();
            log.warn("=========onMessage===========" + vinItemwithLocationandCategory);
            String type = vinItemwithLocationandCategory.getCategory();
            String location = vinItemwithLocationandCategory.getLocation();
            VinItem vinItem = new VinItem(vinItemwithLocationandCategory);
            vinItem.getItemName();
            log.warn(type);
            log.warn(location);


            try{
                vinService.addVinItem(location,type,vinItem);
            }catch (Exception e){
                log.error("======SomeError======"+vinItem);
            }finally {
                ack.acknowledge();
            }


        }






    }




}

