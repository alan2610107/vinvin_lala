package com.kuang.controller;

import com.kuang.pojo.VinCheck;
import com.kuang.pojo.VinCheckwithLocation;
import com.kuang.service.VinService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
public class KafkaDoAddDailyCheck {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;
    @KafkaListener(topics = "addDailyCheck",concurrency = "2",containerFactory = "kafkaListenerContainerFactoryVinCheck")
    //containerFactory:自己定義Listener是誰，預設是kafkaListenerContainerFactory
    public void doAdd(List<ConsumerRecord<String, VinCheckwithLocation>> records, Acknowledgment ack) {
        log.warn("有"+records.size()+"被消費了");
        for (int i = 0; i < records.size(); i++) {
            ConsumerRecord<String, VinCheckwithLocation> record = records.get(i);
            VinCheckwithLocation vinItemwithLocationandCategory = record.value();
            log.warn("=========onMessageAddDailyCheck===========" + vinItemwithLocationandCategory);
            String location = vinItemwithLocationandCategory.getLocation();
            VinCheck vinCheck = new VinCheck(vinItemwithLocationandCategory);

            try{
                switch (location) {
                    case "main0": {
                        List<VinCheck> vinCheckfromDatabase = null;
                        vinCheckfromDatabase = vinService.queryCheckwithTimeandIdinMain0(vinCheck.getCategory(), vinCheck.getTime(), vinCheck.getId());

                        if (vinCheckfromDatabase.size() == 0) {
                            vinService.addCheckinMain0(vinCheck);
                        } else {
                            vinService.updateCheckinMain0byid(vinCheck);
                        }

                        break;
                    }
                    case "main1": {
                        List<VinCheck> vinCheckfromDatabase = null;
                        vinCheckfromDatabase = vinService.queryCheckwithTimeandIdinMain1(vinCheck.getCategory(), vinCheck.getTime(), vinCheck.getId());

                        if (vinCheckfromDatabase.size() == 0) {
                            vinService.addCheckinMain1(vinCheck);
                        } else {
                            vinService.updateCheckinMain1byid(vinCheck);
                        }

                        break;
                    }
                    case "main2": {
                        List<VinCheck> vinCheckfromDatabase = null;
                        vinCheckfromDatabase = vinService.queryCheckwithTimeandIdinMain2(vinCheck.getCategory(), vinCheck.getTime(), vinCheck.getId());
                        if (vinCheckfromDatabase.size() == 0) {
                            vinService.addCheckinMain2(vinCheck);
                        } else {
                            vinService.updateCheckinMain2byid(vinCheck);
                        }
                        break;
                    }
                    case "shop1": {
                        List<VinCheck> vinCheckfromDatabase = null;
                        vinCheckfromDatabase = vinService.queryCheckwithTimeandIdinShop1(vinCheck.getCategory(), vinCheck.getTime(), vinCheck.getId());

                        if (vinCheckfromDatabase.size() == 0) {
                            vinService.addCheckinShop1(vinCheck);
                        } else {
                            vinService.updateCheckinShop1byid(vinCheck);
                        }
                        break;
                    }
                    case "shop2": {
                        List<VinCheck> vinCheckfromDatabase = null;
                        vinCheckfromDatabase = vinService.queryCheckwithTimeandIdinShop2(vinCheck.getCategory(), vinCheck.getTime(), vinCheck.getId());
                        if (vinCheckfromDatabase.size() == 0) {
                            vinService.addCheckinShop2(vinCheck);
                        } else {
                            vinService.updateCheckinShop2byid(vinCheck);
                        }
                        break;
                    }
                    case "shop3": {
                        List<VinCheck> vinCheckfromDatabase = null;
                        vinCheckfromDatabase = vinService.queryCheckwithTimeandIdinShop3(vinCheck.getCategory(), vinCheck.getTime(), vinCheck.getId());
                        if (vinCheckfromDatabase.size() == 0) {
                            vinService.addCheckinShop3(vinCheck);
                        } else {
                            vinService.updateCheckinShop3byid(vinCheck);
                        }
                        break;
                    }
                    case "shop4": {
                        List<VinCheck> vinCheckfromDatabase = null;
                        vinCheckfromDatabase = vinService.queryCheckwithTimeandIdinShop4(vinCheck.getCategory(), vinCheck.getTime(), vinCheck.getId());
                        if (vinCheckfromDatabase.size() == 0) {
                            vinService.addCheckinShop4(vinCheck);
                        } else {
                            vinService.updateCheckinShop4byid(vinCheck);
                        }
                        break;
                    }
                    case "shop5": {
                        List<VinCheck> vinCheckfromDatabase = null;
                        vinCheckfromDatabase = vinService.queryCheckwithTimeandIdinShop5(vinCheck.getCategory(), vinCheck.getTime(), vinCheck.getId());
                        if (vinCheckfromDatabase.size() == 0) {
                            vinService.addCheckinShop5(vinCheck);
                        } else {
                            vinService.updateCheckinShop5byid(vinCheck);
                        }
                        break;
                    }
                    case "shop6": {
                        List<VinCheck> vinCheckfromDatabase = null;
                        vinCheckfromDatabase = vinService.queryCheckwithTimeandIdinShop6(vinCheck.getCategory(), vinCheck.getTime(), vinCheck.getId());
                        if (vinCheckfromDatabase.size() == 0) {
                            vinService.addCheckinShop6(vinCheck);
                        } else {
                            vinService.updateCheckinShop6byid(vinCheck);
                        }
                        break;
                    }
                    case "shop7": {
                        List<VinCheck> vinCheckfromDatabase = null;
                        vinCheckfromDatabase = vinService.queryCheckwithTimeandIdinShop7(vinCheck.getCategory(), vinCheck.getTime(), vinCheck.getId());
                        if (vinCheckfromDatabase.size() == 0) {
                            vinService.addCheckinShop7(vinCheck);
                        } else {
                            vinService.updateCheckinShop7byid(vinCheck);
                        }
                        break;
                    }
                    case "shop8": {
                        List<VinCheck> vinCheckfromDatabase = null;
                        vinCheckfromDatabase = vinService.queryCheckwithTimeandIdinShop8(vinCheck.getCategory(), vinCheck.getTime(), vinCheck.getId());
                        if (vinCheckfromDatabase.size() == 0) {
                            vinService.addCheckinShop8(vinCheck);
                        } else {
                            vinService.updateCheckinShop8byid(vinCheck);
                        }
                        break;
                    }
                    case "shop9": {
                        List<VinCheck> vinCheckfromDatabase = null;
                        vinCheckfromDatabase = vinService.queryCheckwithTimeandIdinShop9(vinCheck.getCategory(), vinCheck.getTime(), vinCheck.getId());
                        if (vinCheckfromDatabase.size() == 0) {
                            vinService.addCheckinShop9(vinCheck);
                        } else {
                            vinService.updateCheckinShop9byid(vinCheck);
                        }
                        break;
                    }
                    case "shop10": {
                        List<VinCheck> vinCheckfromDatabase = null;
                        vinCheckfromDatabase = vinService.queryCheckwithTimeandIdinShop10(vinCheck.getCategory(), vinCheck.getTime(), vinCheck.getId());
                        if (vinCheckfromDatabase.size() == 0) {
                            vinService.addCheckinShop10(vinCheck);
                        } else {
                            vinService.updateCheckinShop10byid(vinCheck);
                        }
                        break;
                    }
                    case "shop11": {
                        List<VinCheck> vinCheckfromDatabase = null;
                        vinCheckfromDatabase = vinService.queryCheckwithTimeandIdinShop11(vinCheck.getCategory(), vinCheck.getTime(), vinCheck.getId());
                        if (vinCheckfromDatabase.size() == 0) {
                            vinService.addCheckinShop11(vinCheck);
                        } else {
                            vinService.updateCheckinShop11byid(vinCheck);
                        }
                        break;
                    }
                    case "shop12": {
                        List<VinCheck> vinCheckfromDatabase = null;
                        vinCheckfromDatabase = vinService.queryCheckwithTimeandIdinShop12(vinCheck.getCategory(), vinCheck.getTime(), vinCheck.getId());
                        if (vinCheckfromDatabase.size() == 0) {
                            vinService.addCheckinShop12(vinCheck);
                        } else {
                            vinService.updateCheckinShop12byid(vinCheck);
                        }
                        break;
                    }
                    case "shop13": {
                        List<VinCheck> vinCheckfromDatabase = null;
                        vinCheckfromDatabase = vinService.queryCheckwithTimeandIdinShop13(vinCheck.getCategory(), vinCheck.getTime(), vinCheck.getId());
                        if (vinCheckfromDatabase.size() == 0) {
                            vinService.addCheckinShop13(vinCheck);
                        } else {
                            vinService.updateCheckinShop13byid(vinCheck);
                        }
                        break;
                    }
                }
            }catch (Exception e){
                log.error("======SomeError======"+vinCheck);
            }finally {
                ack.acknowledge();
            }


        }






    }


}
