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
                switch (type) {
                    case "tool":
                        switch (location) {
                            case "main0":
                                vinService.updateIteminMain0(vinItem);
                                break;
                            case "main1":
                                vinService.updateIteminMain1(vinItem);
                                break;
                            case "main2":
                                vinService.updateIteminMain2(vinItem);
                                break;
                            case "shop1":
                                vinService.updateIteminShop1(vinItem);
                                break;
                            case "shop2":
                                vinService.updateIteminShop2(vinItem);
                                break;
                            case "shop3":
                                vinService.updateIteminShop3(vinItem);
                                break;
                            case "shop4":
                                vinService.updateIteminShop4(vinItem);
                                break;
                            case "shop5":
                                vinService.updateIteminShop5(vinItem);
                                break;
                            case "shop6":
                                vinService.updateIteminShop6(vinItem);
                                break;
                            case "shop7":
                                vinService.updateIteminShop7(vinItem);
                                break;
                            case "shop8":
                                vinService.updateIteminShop8(vinItem);
                                break;
                            case "shop9":
                                vinService.updateIteminShop9(vinItem);
                                break;
                            case "shop10":
                                vinService.updateIteminShop10(vinItem);
                                break;
                            case "shop11":
                                vinService.updateIteminShop11(vinItem);
                                break;
                            case "shop12":
                                vinService.updateIteminShop12(vinItem);
                                break;
                        }

                        break;
                    case "smalltool":
                        switch (location) {
                            case "main0":
                                vinService.updateSmallIteminMain0(vinItem);
                                break;
                            case "main1":
                                vinService.updateSmallIteminMain1(vinItem);
                                break;
                            case "main2":
                                vinService.updateSmallIteminMain2(vinItem);
                                break;
                            case "shop1":
                                vinService.updateSmallIteminShop1(vinItem);
                                break;
                            case "shop2":
                                vinService.updateSmallIteminShop2(vinItem);
                                break;
                            case "shop3":
                                vinService.updateSmallIteminShop3(vinItem);
                                break;
                            case "shop4":
                                vinService.updateSmallIteminShop4(vinItem);
                                break;
                            case "shop5":
                                vinService.updateSmallIteminShop5(vinItem);
                                break;
                            case "shop6":
                                vinService.updateSmallIteminShop6(vinItem);
                                break;
                            case "shop7":
                                vinService.updateSmallIteminShop7(vinItem);
                                break;
                            case "shop8":
                                vinService.updateSmallIteminShop8(vinItem);
                                break;
                            case "shop9":
                                vinService.updateSmallIteminShop9(vinItem);
                                break;
                            case "shop10":
                                vinService.updateSmallIteminShop10(vinItem);
                                break;
                            case "shop11":
                                vinService.updateSmallIteminShop11(vinItem);
                                break;
                            case "shop12":
                                vinService.updateSmallIteminShop12(vinItem);
                                break;
                        }

                        break;
                    case "food":
                        switch (location) {
                            case "main0":
                                vinService.updateFoodinMain0(vinItem);
                                break;
                            case "main1":
                                vinService.updateFoodinMain1(vinItem);
                                break;
                            case "main2":
                                vinService.updateFoodinMain2(vinItem);
                                break;
                            case "shop1":
                                vinService.updateFoodinShop1(vinItem);
                                break;
                            case "shop2":
                                vinService.updateFoodinShop2(vinItem);
                                break;
                            case "shop3":
                                vinService.updateFoodinShop3(vinItem);
                                break;
                            case "shop4":
                                vinService.updateFoodinShop4(vinItem);
                                break;
                            case "shop5":
                                vinService.updateFoodinShop5(vinItem);
                                break;
                            case "shop6":
                                vinService.updateFoodinShop6(vinItem);
                                break;
                            case "shop7":
                                vinService.updateFoodinShop7(vinItem);
                                break;
                            case "shop8":
                                vinService.updateFoodinShop8(vinItem);
                                break;
                            case "shop9":
                                vinService.updateFoodinShop9(vinItem);
                                break;
                            case "shop10":
                                vinService.updateFoodinShop10(vinItem);
                                break;
                            case "shop11":
                                vinService.updateFoodinShop11(vinItem);
                                break;
                            case "shop12":
                                vinService.updateFoodinShop12(vinItem);
                                break;
                        }

                        break;
                    case "commercial":
                        switch (location) {
                            case "main0":
                                vinService.updatecommercialIteminMain0(vinItem);
                                break;
                            case "main1":
                                vinService.updatecommercialIteminMain1(vinItem);
                                break;
                            case "main2":
                                vinService.updatecommercialIteminMain2(vinItem);
                                break;
                            case "shop1":
                                vinService.updatecommercialIteminShop1(vinItem);
                                break;
                            case "shop2":
                                vinService.updatecommercialIteminShop2(vinItem);
                                break;
                            case "shop3":
                                vinService.updatecommercialIteminShop3(vinItem);
                                break;
                            case "shop4":
                                vinService.updatecommercialIteminShop4(vinItem);
                                break;
                            case "shop5":
                                vinService.updatecommercialIteminShop5(vinItem);
                                break;
                            case "shop6":
                                vinService.updatecommercialIteminShop6(vinItem);
                                break;
                            case "shop7":
                                vinService.updatecommercialIteminShop7(vinItem);
                                break;
                            case "shop8":
                                vinService.updatecommercialIteminShop8(vinItem);
                                break;
                            case "shop9":
                                vinService.updatecommercialIteminShop9(vinItem);
                                break;
                            case "shop10":
                                vinService.updatecommercialIteminShop10(vinItem);
                                break;
                            case "shop11":
                                vinService.updatecommercialIteminShop11(vinItem);
                                break;
                            case "shop12":
                                vinService.updatecommercialIteminShop12(vinItem);
                                break;
                        }

                        break;
                    case "other":
                        switch (location) {
                            case "main0":
                                vinService.updateothersinMain0(vinItem);
                                break;
                            case "main1":
                                vinService.updateothersinMain1(vinItem);
                                break;
                            case "main2":
                                vinService.updateothersinMain2(vinItem);
                                break;
                            case "shop1":
                                vinService.updateothersinShop1(vinItem);
                                break;
                            case "shop2":
                                vinService.updateothersinShop2(vinItem);
                                break;
                            case "shop3":
                                vinService.updateothersinShop3(vinItem);
                                break;
                            case "shop4":
                                vinService.updateothersinShop4(vinItem);
                                break;
                            case "shop5":
                                vinService.updateothersinShop5(vinItem);
                                break;
                            case "shop6":
                                vinService.updateothersinShop6(vinItem);
                                break;
                            case "shop7":
                                vinService.updateothersinShop7(vinItem);
                                break;
                            case "shop8":
                                vinService.updateothersinShop8(vinItem);
                                break;
                            case "shop9":
                                vinService.updateothersinShop9(vinItem);
                                break;
                            case "shop10":
                                vinService.updateothersinShop10(vinItem);
                                break;
                            case "shop11":
                                vinService.updateothersinShop11(vinItem);
                                break;
                            case "shop12":
                                vinService.updateothersinShop12(vinItem);
                                break;
                        }

                        break;
                }
                cacheService.deleteRedisLock(key);
            }catch (Exception e){
                log.error("======SomeError======"+vinItem);
            }finally {
                ack.acknowledge();
            }


        }






    }


}
