package com.kuang.serializer;

import com.alibaba.fastjson.JSON;
import com.kuang.pojo.VinItem;
import com.kuang.pojo.VinItemwithLocationandCategory;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;
@Slf4j
public class VinItemDeserializer implements Deserializer {
    @Override
    public void configure(Map configs, boolean isKey) {
//        Deserializer.super.configure(configs, isKey);
        log.warn("自定義的反序列化組件VinItemDeserializer--configure");
    }

    @Override
    public Object deserialize(String s, byte[] bytes) {
        log.warn("自定義的反序列化組件VinItemDeserializer--deserialize");
        return JSON.parseObject(bytes, VinItemwithLocationandCategory.class);
    }


    @Override
    public void close() {
//        Deserializer.super.close();
    }
}
