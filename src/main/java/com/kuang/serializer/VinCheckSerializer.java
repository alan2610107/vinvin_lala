package com.kuang.serializer;

import com.alibaba.fastjson.JSON;
import com.kuang.pojo.VinCheckwithLocation;
import com.kuang.pojo.VinItemwithLocationandCategory;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;
@Slf4j
public class VinCheckSerializer implements Serializer<VinCheckwithLocation> {
//    private static Gson gson; static { gson = new GsonBuilder().create(); }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
//        Serializer.super.configure(configs, isKey);
        log.warn("自定義的序列化組件VinCheckSerializer--configure");
    }

    @Override
    public byte[] serialize(String s, VinCheckwithLocation vinCheckwithLocation) {
//        return new byte[0];
        return JSON.toJSONBytes(vinCheckwithLocation);

    }


    @Override
    public void close() {
//        Serializer.super.close();
        log.warn("自定義的序列化組件VinCheckSerializer--close");
    }
}
