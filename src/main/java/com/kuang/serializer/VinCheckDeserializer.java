package com.kuang.serializer;

import com.alibaba.fastjson.JSON;
import com.kuang.pojo.VinCheckwithLocation;
import com.kuang.pojo.VinItemwithLocationandCategory;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;
@Slf4j
public class VinCheckDeserializer implements Deserializer {
    @Override
    public void configure(Map configs, boolean isKey) {
//        Deserializer.super.configure(configs, isKey);
        log.warn("自定義的反序列化組件VinCheckDeserializer--configure");
    }

    @Override
    public Object deserialize(String s, byte[] bytes) {
        log.warn("自定義的反序列化組件VinCheckDeserializer--deserialize");
        return JSON.parseObject(bytes, VinCheckwithLocation.class);
    }


    @Override
    public void close() {
//        Deserializer.super.close();
    }
}
