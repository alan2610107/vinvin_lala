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
//                switch (type){
//                    case "tool":
//                        switch (location){
//                            case "main0":
//                                vinService.addIteminMain0(vinItem);
//                                break;
//                            case "main1":
//                                vinService.addIteminMain1(vinItem);
//                                break;
//                            case "main2":
//                                vinService.addIteminMain2(vinItem);
//                                break;
//                            case "shop1":
//                                vinService.addIteminShop1(vinItem);
//                                break;
//                            case "shop2":
//                                vinService.addIteminShop2(vinItem);
//                                break;
//                            case "shop3":
//                                vinService.addIteminShop3(vinItem);
//                                break;
//                            case "shop4":
//                                vinService.addIteminShop4(vinItem);
//                                break;
//                            case "shop5":
//                                vinService.addIteminShop5(vinItem);
//                                break;
//                            case "shop6":
//                                vinService.addIteminShop6(vinItem);
//                                break;
//                            case "shop7":
//                                vinService.addIteminShop7(vinItem);
//                                break;
//                            case "shop8":
//                                vinService.addIteminShop8(vinItem);
//                                break;
//                            case "shop9":
//                                vinService.addIteminShop9(vinItem);
//                                break;
//                            case "shop10":
//                                vinService.addIteminShop10(vinItem);
//                                break;
//                            case "shop11":
//                                vinService.addIteminShop11(vinItem);
//                                break;
//                            case "shop12":
//                                vinService.addIteminShop12(vinItem);
//                                break;
//                        }
//                        break;
//                    case "smalltool":
//                        switch (location){
//                            case "main0":
//                                vinService.addSmallIteminMain0(vinItem);
//                                break;
//                            case "main1":
//                                vinService.addSmallIteminMain1(vinItem);
//                                break;
//                            case "main2":
//                                vinService.addSmallIteminMain2(vinItem);
//                                break;
//                            case "shop1":
//                                vinService.addSmallIteminShop1(vinItem);
//                                break;
//                            case "shop2":
//                                vinService.addSmallIteminShop2(vinItem);
//                                break;
//                            case "shop3":
//                                vinService.addSmallIteminShop3(vinItem);
//                                break;
//                            case "shop4":
//                                vinService.addSmallIteminShop4(vinItem);
//                                break;
//                            case "shop5":
//                                vinService.addSmallIteminShop5(vinItem);
//                                break;
//                            case "shop6":
//                                vinService.addSmallIteminShop6(vinItem);
//                                break;
//                            case "shop7":
//                                vinService.addSmallIteminShop7(vinItem);
//                                break;
//                            case "shop8":
//                                vinService.addSmallIteminShop8(vinItem);
//                                break;
//                            case "shop9":
//                                vinService.addSmallIteminShop9(vinItem);
//                                break;
//                            case "shop10":
//                                vinService.addSmallIteminShop10(vinItem);
//                                break;
//                            case "shop11":
//                                vinService.addSmallIteminShop11(vinItem);
//                                break;
//                            case "shop12":
//                                vinService.addSmallIteminShop12(vinItem);
//                                break;
//
//                        }
//                        break;
//                    case "food":
//                        switch (location){
//                            case "main0":
//                                vinService.addFoodinMain0(vinItem);
//                                break;
//                            case "main1":
//                                vinService.addFoodinMain1(vinItem);
//                                break;
//                            case "main2":
//                                vinService.addFoodinMain2(vinItem);
//                                break;
//                            case "shop1":
//                                vinService.addFoodinShop1(vinItem);
//                                break;
//                            case "shop2":
//                                vinService.addFoodinShop2(vinItem);
//                                break;
//                            case "shop3":
//                                vinService.addFoodinShop3(vinItem);
//                                break;
//                            case "shop4":
//                                vinService.addFoodinShop4(vinItem);
//                                break;
//                            case "shop5":
//                                vinService.addFoodinShop5(vinItem);
//                                break;
//                            case "shop6":
//                                vinService.addFoodinShop6(vinItem);
//                                break;
//                            case "shop7":
//                                vinService.addFoodinShop7(vinItem);
//                                break;
//                            case "shop8":
//                                vinService.addFoodinShop8(vinItem);
//                                break;
//                            case "shop9":
//                                vinService.addFoodinShop9(vinItem);
//                                break;
//                            case "shop10":
//                                vinService.addFoodinShop10(vinItem);
//                                break;
//                            case "shop11":
//                                vinService.addFoodinShop11(vinItem);
//                                break;
//                            case "shop12":
//                                vinService.addFoodinShop12(vinItem);
//                                break;
//
//                        }
//                        break;
//                    case "commercial":
//                        switch (location){
//                            case "main0":
//                                vinService.addcommercialIteminMain0(vinItem);
//                                break;
//                            case "main1":
//                                vinService.addcommercialIteminMain1(vinItem);
//                                break;
//                            case "main2":
//                                vinService.addcommercialIteminMain2(vinItem);
//                                break;
//                            case "shop1":
//                                vinService.addcommercialIteminShop1(vinItem);
//                                break;
//                            case "shop2":
//                                vinService.addcommercialIteminShop2(vinItem);
//                                break;
//                            case "shop3":
//                                vinService.addcommercialIteminShop3(vinItem);
//                                break;
//                            case "shop4":
//                                vinService.addcommercialIteminShop4(vinItem);
//                                break;
//                            case "shop5":
//                                vinService.addcommercialIteminShop5(vinItem);
//                                break;
//                            case "shop6":
//                                vinService.addcommercialIteminShop6(vinItem);
//                                break;
//                            case "shop7":
//                                vinService.addcommercialIteminShop7(vinItem);
//                                break;
//                            case "shop8":
//                                vinService.addcommercialIteminShop8(vinItem);
//                                break;
//                            case "shop9":
//                                vinService.addcommercialIteminShop9(vinItem);
//                                break;
//                            case "shop10":
//                                vinService.addcommercialIteminShop10(vinItem);
//                                break;
//                            case "shop11":
//                                vinService.addcommercialIteminShop11(vinItem);
//                                break;
//                            case "shop12":
//                                vinService.addcommercialIteminShop12(vinItem);
//                                break;
//
//                        }
//                        break;
//                    case "other":
//                        switch (location){
//                            case "main0":
//                                vinService.addothersinMain0(vinItem);
//                                break;
//                            case "main1":
//                                vinService.addothersinMain1(vinItem);
//                                break;
//                            case "main2":
//                                vinService.addothersinMain2(vinItem);
//                                break;
//                            case "shop1":
//                                vinService.addothersinShop1(vinItem);
//                                break;
//                            case "shop2":
//                                vinService.addothersinShop2(vinItem);
//                                break;
//                            case "shop3":
//                                vinService.addothersinShop3(vinItem);
//                                break;
//                            case "shop4":
//                                vinService.addothersinShop4(vinItem);
//                                break;
//                            case "shop5":
//                                vinService.addothersinShop5(vinItem);
//                                break;
//                            case "shop6":
//                                vinService.addothersinShop6(vinItem);
//                                break;
//                            case "shop7":
//                                vinService.addothersinShop7(vinItem);
//                                break;
//                            case "shop8":
//                                vinService.addothersinShop8(vinItem);
//                                break;
//                            case "shop9":
//                                vinService.addothersinShop9(vinItem);
//                                break;
//                            case "shop10":
//                                vinService.addothersinShop10(vinItem);
//                                break;
//                            case "shop11":
//                                vinService.addothersinShop11(vinItem);
//                                break;
//                            case "shop12":
//                                vinService.addothersinShop12(vinItem);
//                                break;
//                        }
//                        break;
//                }
            }catch (Exception e){
                log.error("======SomeError======"+vinItem);
            }finally {
                ack.acknowledge();
            }


        }






    }




}

