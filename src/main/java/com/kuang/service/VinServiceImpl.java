package com.kuang.service;

import com.alibaba.fastjson.JSON;
import com.kuang.dao.VinMapper;
import com.kuang.pojo.*;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.FilenameUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class VinServiceImpl implements VinService{

    private VinMapper vinMapper;
    @Autowired
    private KafkaTemplate<String, VinItemwithLocationandCategory> kafkaTemplateVinItem;

    @Autowired
    private KafkaTemplate<String, VinCheckwithLocation> kafkaTemplateVinCheck;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisTemplate distributionRedisTemplate;

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private CacheService cacheService;


    public void setVinMapper(VinMapper vinMapper) {
        this.vinMapper = vinMapper;
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'IteminMain1List'")
    public int addIteminMain1(VinItem items) {
        return vinMapper.addIteminMain1(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'IteminMain2List'")
    public int addIteminMain2(VinItem items) {
        return vinMapper.addIteminMain2(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'IteminShop1List'")
    public int addIteminShop1(VinItem items) {
        return vinMapper.addIteminShop1(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'IteminShop2List'")
    public int addIteminShop2(VinItem items) {
        return vinMapper.addIteminShop2(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'IteminShop3List'")
    public int addIteminShop3(VinItem items) {
        return vinMapper.addIteminShop3(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'IteminShop4List'")
    public int addIteminShop4(VinItem items) {
        return vinMapper.addIteminShop4(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'IteminShop5List'")
    public int addIteminShop5(VinItem items) {
        return vinMapper.addIteminShop5(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'IteminShop6List'")
    public int addIteminShop6(VinItem items) {
        return vinMapper.addIteminShop6(items);
    }

    @Override
    public int addIteminShop7(VinItem items) {
        return vinMapper.addIteminShop7(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'FoodinMain1List'")
    public int addFoodinMain1(VinItem items) {
        return vinMapper.addFoodinMain1(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'FoodinMain2List'")
    public int addFoodinMain2(VinItem items) {
        return vinMapper.addFoodinMain2(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'FoodinShop1List'")
    public int addFoodinShop1(VinItem items) {
        return vinMapper.addFoodinShop1(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'FoodinShop2List'")
    public int addFoodinShop2(VinItem items) {
        return vinMapper.addFoodinShop2(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'FoodinShop3List'")
    public int addFoodinShop3(VinItem items) {
        return vinMapper.addFoodinShop3(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'FoodinShop4List'")
    public int addFoodinShop4(VinItem items) {
        return vinMapper.addFoodinShop4(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'FoodinShop5List'")
    public int addFoodinShop5(VinItem items) {
        return vinMapper.addFoodinShop5(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'FoodinShop6List'")
    public int addFoodinShop6(VinItem items) {
        return vinMapper.addFoodinShop6(items);
    }

    @Override
    public int addFoodinShop7(VinItem items) {
        return vinMapper.addFoodinShop7(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'commercialIteminMain1List'")
    public int addcommercialIteminMain1(VinItem items) {
        return vinMapper.addcommercialIteminMain1(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'commercialIteminMain2List'")
    public int addcommercialIteminMain2(VinItem items) {
        return vinMapper.addcommercialIteminMain2(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'commercialIteminShop1List'")
    public int addcommercialIteminShop1(VinItem items) {
        return vinMapper.addcommercialIteminShop1(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'commercialIteminShop2List'")
    public int addcommercialIteminShop2(VinItem items) {
        return vinMapper.addcommercialIteminShop2(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'commercialIteminShop3List'")
    public int addcommercialIteminShop3(VinItem items) {
        return vinMapper.addcommercialIteminShop3(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'commercialIteminShop4List'")
    public int addcommercialIteminShop4(VinItem items) {
        return vinMapper.addcommercialIteminShop4(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'commercialIteminShop5List'")
    public int addcommercialIteminShop5(VinItem items) {
        return vinMapper.addcommercialIteminShop5(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'commercialIteminShop6List'")
    public int addcommercialIteminShop6(VinItem items) {
        return vinMapper.addcommercialIteminShop6(items);
    }

    @Override
    public int addcommercialIteminShop7(VinItem items) {
        return vinMapper.addcommercialIteminShop7(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'othersinMain1List'")
    public int addothersinMain1(VinItem items) {
        return vinMapper.addothersinMain1(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'othersinMain2List'")
    public int addothersinMain2(VinItem items) {
        return vinMapper.addothersinMain2(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'othersinShop1List'")
    public int addothersinShop1(VinItem items) {
        return vinMapper.addothersinShop1(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'othersinShop2List'")
    public int addothersinShop2(VinItem items) {
        return vinMapper.addothersinShop2(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'othersinShop3List'")
    public int addothersinShop3(VinItem items) {
        return vinMapper.addothersinShop3(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'othersinShop4List'")
    public int addothersinShop4(VinItem items) {
        return vinMapper.addothersinShop4(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'othersinShop5List'")
    public int addothersinShop5(VinItem items) {
        return vinMapper.addothersinShop5(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'othersinShop6List'")
    public int addothersinShop6(VinItem items) {
        return vinMapper.addothersinShop6(items);
    }

    @Override
    public int addothersinShop7(VinItem items) {
        return vinMapper.addothersinShop7(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'SmallIteminMain1List'")
    public int addSmallIteminMain1(VinItem items) {
        return vinMapper.addSmallIteminMain1(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'SmallIteminMain2List'")
    public int addSmallIteminMain2(VinItem items) {
        return vinMapper.addSmallIteminMain2(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'SmallIteminShop1List'")
    public int addSmallIteminShop1(VinItem items) {
        return vinMapper.addSmallIteminShop1(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'SmallIteminShop2List'")
    public int addSmallIteminShop2(VinItem items) {
        return vinMapper.addSmallIteminShop2(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'SmallIteminShop3List'")
    public int addSmallIteminShop3(VinItem items) {
        return vinMapper.addSmallIteminShop3(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'SmallIteminShop4List'")
    public int addSmallIteminShop4(VinItem items) {
        return vinMapper.addSmallIteminShop4(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'SmallIteminShop5List'")
    public int addSmallIteminShop5(VinItem items) {
        return vinMapper.addSmallIteminShop5(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'SmallIteminShop6List'")
    public int addSmallIteminShop6(VinItem items) {
        return vinMapper.addSmallIteminShop6(items);
    }

    @Override
    public int addSmallIteminShop7(VinItem items) {
        return vinMapper.addSmallIteminShop7(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'IteminMain1List'")
    public int deleteIteminMain1byId(String id) {
        return vinMapper.deleteIteminMain1byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'IteminMain2List'")
    public int deleteIteminMain2byId(String id) {
        return vinMapper.deleteIteminMain2byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'IteminShop1List'")
    public int deleteIteminShop1byId(String id) {
        return vinMapper.deleteIteminShop1byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'IteminShop2List'")
    public int deleteIteminShop2byId(String id) {
        return vinMapper.deleteIteminShop2byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'IteminShop3List'")
    public int deleteIteminShop3byId(String id) {
        return vinMapper.deleteIteminShop3byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'IteminShop4List'")
    public int deleteIteminShop4byId(String id) {
        return vinMapper.deleteIteminShop4byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'IteminShop5List'")
    public int deleteIteminShop5byId(String id) {
        return vinMapper.deleteIteminShop5byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'IteminShop6List'")
    public int deleteIteminShop6byId(String id) {
        return vinMapper.deleteIteminShop6byId(id);
    }

    @Override
    public int deleteIteminShop7byId(String id) {
        return vinMapper.deleteIteminShop7byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'SmallIteminMain1List'")
    public int deleteSmallIteminMain1byId(String id) {
        return vinMapper.deleteSmallIteminMain1byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'SmallIteminMain2List'")
    public int deleteSmallIteminMain2byId(String id) {
        return vinMapper.deleteSmallIteminMain2byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'SmallIteminShop1List'")
    public int deleteSmallIteminShop1byId(String id) {
        return vinMapper.deleteSmallIteminShop1byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'SmallIteminShop2List'")
    public int deleteSmallIteminShop2byId(String id) {
        return vinMapper.deleteSmallIteminShop2byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'SmallIteminShop3List'")
    public int deleteSmallIteminShop3byId(String id) {
        return vinMapper.deleteSmallIteminShop3byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'SmallIteminShop4List'")
    public int deleteSmallIteminShop4byId(String id) {
        return vinMapper.deleteSmallIteminShop4byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'SmallIteminShop5List'")
    public int deleteSmallIteminShop5byId(String id) {
        return vinMapper.deleteSmallIteminShop5byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'SmallIteminShop6List'")
    public int deleteSmallIteminShop6byId(String id) {
        return vinMapper.deleteSmallIteminShop6byId(id);
    }

    @Override
    public int deleteSmallIteminShop7byId(String id) {
        return vinMapper.deleteSmallIteminShop7byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'FoodinMain1List'")
    public int deleteFoodinMain1byId(String id) {
        return vinMapper.deleteFoodinMain1byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'FoodinMain2List'")
    public int deleteFoodinMain2byId(String id) {
        return vinMapper.deleteFoodinMain2byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'FoodinShop1List'")
    public int deleteFoodinShop1byId(String id) {
        return vinMapper.deleteFoodinShop1byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'FoodinShop2List'")
    public int deleteFoodinShop2byId(String id) {
        return vinMapper.deleteFoodinShop2byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'FoodinShop3List'")
    public int deleteFoodinShop3byId(String id) {
        return vinMapper.deleteFoodinShop3byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'FoodinShop4List'")
    public int deleteFoodinShop4byId(String id) {
        return vinMapper.deleteFoodinShop4byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'FoodinShop5List'")
    public int deleteFoodinShop5byId(String id) {
        return vinMapper.deleteFoodinShop5byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'FoodinShop6List'")
    public int deleteFoodinShop6byId(String id) {
        return vinMapper.deleteFoodinShop6byId(id);
    }

    @Override
    public int deleteFoodinShop7byId(String id) {
        return vinMapper.deleteFoodinShop7byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'commercialIteminMain1List'")
    public int deletecommercialIteminMain1byId(String id) {
        return vinMapper.deletecommercialIteminMain1byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'commercialIteminMain2List'")
    public int deletecommercialIteminMain2byId(String id) {
        return vinMapper.deletecommercialIteminMain2byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'commercialIteminShop1List'")
    public int deletecommercialIteminShop1byId(String id) {
        return vinMapper.deletecommercialIteminShop1byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'commercialIteminShop2List'")
    public int deletecommercialIteminShop2byId(String id) {
        return vinMapper.deletecommercialIteminShop2byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'commercialIteminShop3List'")
    public int deletecommercialIteminShop3byId(String id) {
        return vinMapper.deletecommercialIteminShop3byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'commercialIteminShop4List'")
    public int deletecommercialIteminShop4byId(String id) {
        return vinMapper.deletecommercialIteminShop4byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'commercialIteminShop5List'")
    public int deletecommercialIteminShop5byId(String id) {
        return vinMapper.deletecommercialIteminShop5byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'commercialIteminShop6List'")
    public int deletecommercialIteminShop6byId(String id) {
        return vinMapper.deletecommercialIteminShop6byId(id);
    }

    @Override
    public int deletecommercialIteminShop7byId(String id) {
        return vinMapper.deletecommercialIteminShop7byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'othersinMain1List'")
    public int deleteothersinMain1byId(String id) {
        return vinMapper.deleteothersinMain1byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'othersinMain2List'")
    public int deleteothersinMain2byId(String id) {
        return vinMapper.deleteothersinMain2byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'othersinShop1List'")
    public int deleteothersinShop1byId(String id) {
        return vinMapper.deleteothersinShop1byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'othersinShop2List'")
    public int deleteothersinShop2byId(String id) {
        return vinMapper.deleteothersinShop2byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'othersinShop3List'")
    public int deleteothersinShop3byId(String id) {
        return vinMapper.deleteothersinShop3byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'othersinShop4List'")
    public int deleteothersinShop4byId(String id) {
        return vinMapper.deleteothersinShop4byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'othersinShop5List'")
    public int deleteothersinShop5byId(String id) {
        return vinMapper.deleteothersinShop5byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'othersinShop6List'")
    public int deleteothersinShop6byId(String id) {
        return vinMapper.deleteothersinShop6byId(id);
    }

    @Override
    public int deleteothersinShop7byId(String id) {
        return vinMapper.deleteothersinShop7byId(id);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'IteminMain1List'")
    public int updateIteminMain1(VinItem items) {
        return vinMapper.updateIteminMain1(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'IteminMain2List'")
    public int updateIteminMain2(VinItem items) {
        return vinMapper.updateIteminMain2(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'IteminShop1List'")
    public int updateIteminShop1(VinItem items) {
        return vinMapper.updateIteminShop1(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'IteminShop2List'")
    public int updateIteminShop2(VinItem items) {
        return vinMapper.updateIteminShop2(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'IteminShop3List'")
    public int updateIteminShop3(VinItem items) {
        return vinMapper.updateIteminShop3(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'IteminShop4List'")
    public int updateIteminShop4(VinItem items) {
        return vinMapper.updateIteminShop4(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'IteminShop5List'")
    public int updateIteminShop5(VinItem items) {
        return vinMapper.updateIteminShop5(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'IteminShop6List'")
    public int updateIteminShop6(VinItem items) {
        return vinMapper.updateIteminShop6(items);
    }

    @Override
    public int updateIteminShop7(VinItem items) {
        return vinMapper.updateIteminShop7(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'SmallIteminMain1List'")
    public int updateSmallIteminMain1(VinItem items) {
        return vinMapper.updateSmallIteminMain1(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'SmallIteminMain2List'")
    public int updateSmallIteminMain2(VinItem items) {
        return vinMapper.updateSmallIteminMain2(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'SmallIteminShop1List'")
    public int updateSmallIteminShop1(VinItem items) {
        return vinMapper.updateSmallIteminShop1(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'SmallIteminShop2List'")
    public int updateSmallIteminShop2(VinItem items) {
        return vinMapper.updateSmallIteminShop2(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'SmallIteminShop3List'")
    public int updateSmallIteminShop3(VinItem items) {
        return vinMapper.updateSmallIteminShop3(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'SmallIteminShop4List'")
    public int updateSmallIteminShop4(VinItem items) {
        return vinMapper.updateSmallIteminShop4(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'SmallIteminShop5List'")
    public int updateSmallIteminShop5(VinItem items) {
        return vinMapper.updateSmallIteminShop5(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'SmallIteminShop6List'")
    public int updateSmallIteminShop6(VinItem items) {
        return vinMapper.updateSmallIteminShop6(items);
    }

    @Override
    public int updateSmallIteminShop7(VinItem items) {
        return vinMapper.updateSmallIteminShop7(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'FoodinMain1List'")
    public int updateFoodinMain1(VinItem items) {
        return vinMapper.updateFoodinMain1(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'FoodinMain2List'")
    public int updateFoodinMain2(VinItem items) {
        return vinMapper.updateFoodinMain2(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'FoodinShop1List'")
    public int updateFoodinShop1(VinItem items) {
        return vinMapper.updateFoodinShop1(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'FoodinShop2List'")
    public int updateFoodinShop2(VinItem items) {
        return vinMapper.updateFoodinShop2(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'FoodinShop3List'")
    public int updateFoodinShop3(VinItem items) {
        return vinMapper.updateFoodinShop3(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'FoodinShop4List'")
    public int updateFoodinShop4(VinItem items) {
        return vinMapper.updateFoodinShop4(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'FoodinShop5List'")
    public int updateFoodinShop5(VinItem items) {
        return vinMapper.updateFoodinShop5(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'FoodinShop6List'")
    public int updateFoodinShop6(VinItem items) {
        return vinMapper.updateFoodinShop6(items);
    }

    @Override
    public int updateFoodinShop7(VinItem items) {
        return vinMapper.updateFoodinShop7(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'commercialIteminMain1List'")
    public int updatecommercialIteminMain1(VinItem items) {
        return vinMapper.updatecommercialIteminMain1(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'commercialIteminMain2List'")
    public int updatecommercialIteminMain2(VinItem items) {
        return vinMapper.updatecommercialIteminMain2(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'commercialIteminShop1List'")
    public int updatecommercialIteminShop1(VinItem items) {
        return vinMapper.updatecommercialIteminShop1(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'commercialIteminShop2List'")
    public int updatecommercialIteminShop2(VinItem items) {
        return vinMapper.updatecommercialIteminShop2(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'commercialIteminShop3List'")
    public int updatecommercialIteminShop3(VinItem items) {
        return vinMapper.updatecommercialIteminShop3(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'commercialIteminShop4List'")
    public int updatecommercialIteminShop4(VinItem items) {
        return vinMapper.updatecommercialIteminShop4(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'commercialIteminShop5List'")
    public int updatecommercialIteminShop5(VinItem items) {
        return vinMapper.updatecommercialIteminShop5(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'commercialIteminShop6List'")
    public int updatecommercialIteminShop6(VinItem items) {
        return vinMapper.updatecommercialIteminShop6(items);
    }

    @Override
    public int updatecommercialIteminShop7(VinItem items) {
        return vinMapper.updatecommercialIteminShop7(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'othersinMain1List'")
    public int updateothersinMain1(VinItem items) {
        return vinMapper.updateothersinMain1(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'othersinMain2List'")
    public int updateothersinMain2(VinItem items) {
        return vinMapper.updateothersinMain2(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'othersinShop1List'")
    public int updateothersinShop1(VinItem items) {
        return vinMapper.updateothersinShop1(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'othersinShop2List'")
    public int updateothersinShop2(VinItem items) {
        return vinMapper.updateothersinShop2(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'othersinShop3List'")
    public int updateothersinShop3(VinItem items) {
        return vinMapper.updateothersinShop3(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'othersinShop4List'")
    public int updateothersinShop4(VinItem items) {
        return vinMapper.updateothersinShop4(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'othersinShop5List'")
    public int updateothersinShop5(VinItem items) {
        return vinMapper.updateothersinShop5(items);
    }

    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'othersinShop6List'")
    public int updateothersinShop6(VinItem items) {
        return vinMapper.updateothersinShop6(items);
    }

    @Override
    public int updateothersinShop7(VinItem items) {
        return vinMapper.updateothersinShop7(items);
    }

    @Override
    public int sendIteminMain1(VinItem items) {
        return vinMapper.sendIteminMain1(items);
    }

    @Override
    public int sendIteminMain2(VinItem items) {
        return vinMapper.sendIteminMain2(items);
    }

    @Override
    public int sendIteminShop1(VinItem items) {
        return vinMapper.sendIteminShop1(items);
    }

    @Override
    public int sendIteminShop2(VinItem items) {
        return vinMapper.sendIteminShop2(items);
    }

    @Override
    public int sendIteminShop3(VinItem items) {
        return vinMapper.sendIteminShop3(items);
    }

    @Override
    public int sendIteminShop4(VinItem items) {
        return vinMapper.sendIteminShop4(items);
    }

    @Override
    public int sendIteminShop5(VinItem items) {
        return vinMapper.sendIteminShop5(items);
    }

    @Override
    public int sendIteminShop6(VinItem items) {
        return vinMapper.sendIteminShop6(items);
    }

    @Override
    public int sendIteminShop7(VinItem items) {
        return vinMapper.sendIteminShop7(items);
    }

    @Override
    public int sendSmallIteminMain1(VinItem items) {
        return vinMapper.sendSmallIteminMain1(items);
    }

    @Override
    public int sendSmallIteminMain2(VinItem items) {
        return vinMapper.sendSmallIteminMain2(items);
    }

    @Override
    public int sendSmallIteminShop1(VinItem items) {
        return vinMapper.sendSmallIteminShop1(items);
    }

    @Override
    public int sendSmallIteminShop2(VinItem items) {
        return vinMapper.sendSmallIteminShop2(items);
    }

    @Override
    public int sendSmallIteminShop3(VinItem items) {
        return vinMapper.sendSmallIteminShop3(items);
    }

    @Override
    public int sendSmallIteminShop4(VinItem items) {
        return vinMapper.sendSmallIteminShop4(items);
    }

    @Override
    public int sendSmallIteminShop5(VinItem items) {
        return vinMapper.sendSmallIteminShop5(items);
    }

    @Override
    public int sendSmallIteminShop6(VinItem items) {
        return vinMapper.sendSmallIteminShop6(items);
    }

    @Override
    public int sendSmallIteminShop7(VinItem items) {
        return vinMapper.sendSmallIteminShop7(items);
    }

    @Override
    public int sendFoodinMain1(VinItem items) {
        return vinMapper.sendFoodinMain1(items);
    }

    @Override
    public int sendFoodinMain2(VinItem items) {
        return vinMapper.sendFoodinMain2(items);
    }

    @Override
    public int sendFoodinShop1(VinItem items) {
        return vinMapper.sendFoodinShop1(items);
    }

    @Override
    public int sendFoodinShop2(VinItem items) {
        return vinMapper.sendFoodinShop2(items);
    }

    @Override
    public int sendFoodinShop3(VinItem items) {
        return vinMapper.sendFoodinShop3(items);
    }

    @Override
    public int sendFoodinShop4(VinItem items) {
        return vinMapper.sendFoodinShop4(items);
    }

    @Override
    public int sendFoodinShop5(VinItem items) {
        return vinMapper.sendFoodinShop5(items);
    }

    @Override
    public int sendFoodinShop6(VinItem items) {
        return vinMapper.sendFoodinShop6(items);
    }

    @Override
    public int sendFoodinShop7(VinItem items) {
        return vinMapper.sendFoodinShop7(items);
    }

    @Override
    public int sendcommercialIteminMain1(VinItem items) {
        return vinMapper.sendcommercialIteminMain1(items);
    }

    @Override
    public int sendcommercialIteminMain2(VinItem items) {
        return vinMapper.sendcommercialIteminMain2(items);
    }

    @Override
    public int sendcommercialIteminShop1(VinItem items) {
        return vinMapper.sendcommercialIteminShop1(items);
    }

    @Override
    public int sendcommercialIteminShop2(VinItem items) {
        return vinMapper.sendcommercialIteminShop2(items);
    }

    @Override
    public int sendcommercialIteminShop3(VinItem items) {
        return vinMapper.sendcommercialIteminShop3(items);
    }

    @Override
    public int sendcommercialIteminShop4(VinItem items) {
        return vinMapper.sendcommercialIteminShop4(items);
    }

    @Override
    public int sendcommercialIteminShop5(VinItem items) {
        return vinMapper.sendcommercialIteminShop5(items);
    }

    @Override
    public int sendcommercialIteminShop6(VinItem items) {
        return vinMapper.sendcommercialIteminShop6(items);
    }

    @Override
    public int sendcommercialIteminShop7(VinItem items) {
        return vinMapper.sendcommercialIteminShop7(items);
    }

    @Override
    public int sendothersinMain1(VinItem items) {
        return vinMapper.sendothersinMain1(items);
    }

    @Override
    public int sendothersinMain2(VinItem items) {
        return vinMapper.sendothersinMain2(items);
    }

    @Override
    public int sendothersinShop1(VinItem items) {
        return vinMapper.sendothersinShop1(items);
    }

    @Override
    public int sendothersinShop2(VinItem items) {
        return vinMapper.sendothersinShop2(items);
    }

    @Override
    public int sendothersinShop3(VinItem items) {
        return vinMapper.sendothersinShop3(items);
    }

    @Override
    public int sendothersinShop4(VinItem items) {
        return vinMapper.sendothersinShop4(items);
    }

    @Override
    public int sendothersinShop5(VinItem items) {
        return vinMapper.sendothersinShop5(items);
    }

    @Override
    public int sendothersinShop6(VinItem items) {
        return vinMapper.sendothersinShop6(items);
    }

    @Override
    public int sendothersinShop7(VinItem items) {
        return vinMapper.sendothersinShop7(items);
    }

    @Override
    public int addAllItem(Item items) {
        return vinMapper.addAllItem(items);
    }

    @Override
    public String checkAllItem(String itemName) {
        return vinMapper.checkAllItem(itemName);
    }

    @Override
    public int ifExistinAllItem(String itemName) {
        return vinMapper.ifExistinAllItem(itemName);
    }

    @Override
    public int ifExistIDinItem(String itemID) {
        return vinMapper.ifExistIDinItem(itemID);
    }

    @Override
    public List<Item> queryAllItem() {
        return vinMapper.queryAllItem();
    }

    @Override
    public List<Item> queryAllItembyCategory(String category) {
        return vinMapper.queryAllItembyCategory(category);
    }

    @Override
    public Item queryAllItembyID(String id) {
        return vinMapper.queryAllItembyID(id);
    }

    @Override
    public int updateAllItem(Item item) {
        return vinMapper.updateAllItem(item);
    }

    @Override
    public Supplier querySupplierbyID(String supplierID) {
        return vinMapper.querySupplierbyID(supplierID);
    }

    @Override
    public Supplier querySupplierbyName(String supplierName) {
        return vinMapper.querySupplierbyName(supplierName);
    }

    @Override
    public int ifExistIDinSupplier(String supplierID) {
        return vinMapper.ifExistIDinSupplier(supplierID);
    }

    @Override
    public int ifExistNameinSupplier(String supplierName) {
        return vinMapper.ifExistNameinSupplier(supplierName);
    }

    @Override
    public int addSupplier(Supplier supplier) {
        return vinMapper.addSupplier(supplier);
    }

    @Override
    public VinItem queryIteminMain1byId(String id) {
        return vinMapper.queryIteminMain1byId(id);
    }

    @Override
    public VinItem queryIteminMain2byId(String id) {
        return vinMapper.queryIteminMain2byId(id);
    }

    @Override
    public VinItem queryIteminShop1byId(String id) {
        return vinMapper.queryIteminShop1byId(id);
    }

    @Override
    public VinItem queryIteminShop2byId(String id) {
        return vinMapper.queryIteminShop2byId(id);
    }

    @Override
    public VinItem queryIteminShop3byId(String id) {
        return vinMapper.queryIteminShop3byId(id);
    }

    @Override
    public VinItem queryIteminShop4byId(String id) {
        return vinMapper.queryIteminShop4byId(id);
    }

    @Override
    public VinItem queryIteminShop5byId(String id) {
        return vinMapper.queryIteminShop5byId(id);
    }

    @Override
    public VinItem queryIteminShop6byId(String id) {
        return vinMapper.queryIteminShop6byId(id);
    }

    @Override
    public VinItem queryIteminShop7byId(String id) {
        return vinMapper.queryIteminShop7byId(id);
    }

    @Override
    public VinItem querySmallIteminMain1byId(String id) {
        return vinMapper.querySmallIteminMain1byId(id);
    }

    @Override
    public VinItem querySmallIteminMain2byId(String id) {
        return vinMapper.querySmallIteminMain2byId(id);
    }

    @Override
    public VinItem querySmallIteminShop1byId(String id) {
        return vinMapper.querySmallIteminShop1byId(id);
    }

    @Override
    public VinItem querySmallIteminShop2byId(String id) {
        return vinMapper.querySmallIteminShop2byId(id);
    }

    @Override
    public VinItem querySmallIteminShop3byId(String id) {
        return vinMapper.querySmallIteminShop3byId(id);
    }

    @Override
    public VinItem querySmallIteminShop4byId(String id) {
        return vinMapper.querySmallIteminShop4byId(id);
    }

    @Override
    public VinItem querySmallIteminShop5byId(String id) {
        return vinMapper.querySmallIteminShop5byId(id);
    }

    @Override
    public VinItem querySmallIteminShop6byId(String id) {
        return vinMapper.querySmallIteminShop6byId(id);
    }

    @Override
    public VinItem querySmallIteminShop7byId(String id) {
        return vinMapper.querySmallIteminShop7byId(id);
    }

    @Override
    public VinItem queryFoodinMain1byId(String id) {
        return vinMapper.queryFoodinMain1byId(id);
    }

    @Override
    public VinItem queryFoodinMain2byId(String id) {
        return vinMapper.queryFoodinMain2byId(id);
    }

    @Override
    public VinItem queryFoodinShop1byId(String id) {
        return vinMapper.queryFoodinShop1byId(id);
    }

    @Override
    public VinItem queryFoodinShop2byId(String id) {
        return vinMapper.queryFoodinShop2byId(id);
    }

    @Override
    public VinItem queryFoodinShop3byId(String id) {
        return vinMapper.queryFoodinShop3byId(id);
    }

    @Override
    public VinItem queryFoodinShop4byId(String id) {
        return vinMapper.queryFoodinShop4byId(id);
    }

    @Override
    public VinItem queryFoodinShop5byId(String id) {
        return vinMapper.queryFoodinShop5byId(id);
    }

    @Override
    public VinItem queryFoodinShop6byId(String id) {
        return vinMapper.queryFoodinShop6byId(id);
    }

    @Override
    public VinItem queryFoodinShop7byId(String id) {
        return vinMapper.queryFoodinShop7byId(id);
    }

    @Override
    public VinItem querycommercialIteminMain1byId(String id) {
        return vinMapper.querycommercialIteminMain1byId(id);
    }

    @Override
    public VinItem querycommercialIteminMain2byId(String id) {
        return vinMapper.querycommercialIteminMain2byId(id);
    }

    @Override
    public VinItem querycommercialIteminShop1byId(String id) {
        return vinMapper.querycommercialIteminShop1byId(id);
    }

    @Override
    public VinItem querycommercialIteminShop2byId(String id) {
        return vinMapper.querycommercialIteminShop2byId(id);
    }

    @Override
    public VinItem querycommercialIteminShop3byId(String id) {
        return vinMapper.querycommercialIteminShop3byId(id);
    }

    @Override
    public VinItem querycommercialIteminShop4byId(String id) {
        return vinMapper.querycommercialIteminShop4byId(id);
    }

    @Override
    public VinItem querycommercialIteminShop5byId(String id) {
        return vinMapper.querycommercialIteminShop5byId(id);
    }

    @Override
    public VinItem querycommercialIteminShop6byId(String id) {
        return vinMapper.querycommercialIteminShop6byId(id);
    }

    @Override
    public VinItem querycommercialIteminShop7byId(String id) {
        return vinMapper.querycommercialIteminShop7byId(id);
    }

    @Override
    public VinItem queryothersinMain1byId(String id) {
        return vinMapper.queryothersinMain1byId(id);
    }

    @Override
    public VinItem queryothersinMain2byId(String id) {
        return vinMapper.queryothersinMain2byId(id);
    }

    @Override
    public VinItem queryothersinShop1byId(String id) {
        return vinMapper.queryothersinShop1byId(id);
    }

    @Override
    public VinItem queryothersinShop2byId(String id) {
        return vinMapper.queryothersinShop2byId(id);
    }

    @Override
    public VinItem queryothersinShop3byId(String id) {
        return vinMapper.queryothersinShop3byId(id);
    }

    @Override
    public VinItem queryothersinShop4byId(String id) {
        return vinMapper.queryothersinShop4byId(id);
    }

    @Override
    public VinItem queryothersinShop5byId(String id) {
        return vinMapper.queryothersinShop5byId(id);
    }

    @Override
    public VinItem queryothersinShop6byId(String id) {
        return vinMapper.queryothersinShop6byId(id);
    }

    @Override
    public VinItem queryothersinShop7byId(String id) {
        return vinMapper.queryothersinShop7byId(id);
    }

    @Override
    public int queryItemNuminMain1byId(String id) {
        return vinMapper.queryItemNuminMain1byId(id);
    }

    @Override
    public int queryItemNuminMain2byId(String id) {
        return vinMapper.queryItemNuminMain2byId(id);
    }

    @Override
    public int queryItemNuminShop1byId(String id) {
        return vinMapper.queryItemNuminShop1byId(id);
    }

    @Override
    public int queryItemNuminShop2byId(String id) {
        return vinMapper.queryItemNuminShop2byId(id);
    }

    @Override
    public int queryItemNuminShop3byId(String id) {
        return vinMapper.queryItemNuminShop3byId(id);
    }

    @Override
    public int queryItemNuminShop4byId(String id) {
        return vinMapper.queryItemNuminShop4byId(id);
    }

    @Override
    public int queryItemNuminShop5byId(String id) {
        return vinMapper.queryItemNuminShop5byId(id);
    }

    @Override
    public int queryItemNuminShop6byId(String id) {
        return vinMapper.queryItemNuminShop6byId(id);
    }

    @Override
    public int queryItemNuminShop7byId(String id) {
        return vinMapper.queryItemNuminShop7byId(id);
    }

    @Override
    public int querySmallItemNuminMain1byId(String id) {
        return vinMapper.querySmallItemNuminMain1byId(id);
    }

    @Override
    public int querySmallItemNuminMain2byId(String id) {
        return vinMapper.querySmallItemNuminMain2byId(id);
    }

    @Override
    public int querySmallItemNuminShop1byId(String id) {
        return vinMapper.querySmallItemNuminShop1byId(id);
    }

    @Override
    public int querySmallItemNuminShop2byId(String id) {
        return vinMapper.querySmallItemNuminShop2byId(id);
    }

    @Override
    public int querySmallItemNuminShop3byId(String id) {
        return vinMapper.querySmallItemNuminShop3byId(id);
    }

    @Override
    public int querySmallItemNuminShop4byId(String id) {
        return vinMapper.querySmallItemNuminShop4byId(id);
    }

    @Override
    public int querySmallItemNuminShop5byId(String id) {
        return vinMapper.querySmallItemNuminShop5byId(id);
    }

    @Override
    public int querySmallItemNuminShop6byId(String id) {
        return vinMapper.querySmallItemNuminShop6byId(id);
    }

    @Override
    public int querySmallItemNuminShop7byId(String id) {
        return vinMapper.querySmallItemNuminShop7byId(id);
    }

    @Override
    public int queryFoodNuminMain1byId(String id) {
        return vinMapper.queryFoodNuminMain1byId(id);
    }

    @Override
    public int queryFoodNuminMain2byId(String id) {
        return vinMapper.queryFoodNuminMain2byId(id);
    }

    @Override
    public int queryFoodNuminShop1byId(String id) {
        return vinMapper.queryFoodNuminShop1byId(id);
    }

    @Override
    public int queryFoodNuminShop2byId(String id) {
        return vinMapper.queryFoodNuminShop2byId(id);
    }

    @Override
    public int queryFoodNuminShop3byId(String id) {
        return vinMapper.queryFoodNuminShop3byId(id);
    }

    @Override
    public int queryFoodNuminShop4byId(String id) {
        return vinMapper.queryFoodNuminShop4byId(id);
    }

    @Override
    public int queryFoodNuminShop5byId(String id) {
        return vinMapper.queryFoodNuminShop5byId(id);
    }

    @Override
    public int queryFoodNuminShop6byId(String id) {
        return vinMapper.queryFoodNuminShop6byId(id);
    }

    @Override
    public int queryFoodNuminShop7byId(String id) {
        return vinMapper.queryFoodNuminShop7byId(id);
    }

    @Override
    public int querycommercialItemNuminMain1byId(String id) {
        return vinMapper.querycommercialItemNuminMain1byId(id);
    }

    @Override
    public int querycommercialItemNuminMain2byId(String id) {
        return vinMapper.querycommercialItemNuminMain2byId(id);
    }

    @Override
    public int querycommercialItemNuminShop1byId(String id) {
        return vinMapper.querycommercialItemNuminShop1byId(id);
    }

    @Override
    public int querycommercialItemNuminShop2byId(String id) {
        return vinMapper.querycommercialItemNuminShop2byId(id);
    }

    @Override
    public int querycommercialItemNuminShop3byId(String id) {
        return vinMapper.querycommercialItemNuminShop3byId(id);
    }

    @Override
    public int querycommercialItemNuminShop4byId(String id) {
        return vinMapper.querycommercialItemNuminShop4byId(id);
    }

    @Override
    public int querycommercialItemNuminShop5byId(String id) {
        return vinMapper.querycommercialItemNuminShop5byId(id);
    }

    @Override
    public int querycommercialItemNuminShop6byId(String id) {
        return vinMapper.querycommercialItemNuminShop6byId(id);
    }

    @Override
    public int querycommercialItemNuminShop7byId(String id) {
        return vinMapper.querycommercialItemNuminShop7byId(id);
    }

    @Override
    public int queryothersNuminMain1byId(String id) {
        return vinMapper.queryothersNuminMain1byId(id);
    }

    @Override
    public int queryothersNuminMain2byId(String id) {
        return vinMapper.queryothersNuminMain2byId(id);
    }

    @Override
    public int queryothersNuminShop1byId(String id) {
        return vinMapper.queryothersNuminShop1byId(id);
    }

    @Override
    public int queryothersNuminShop2byId(String id) {
        return vinMapper.queryothersNuminShop2byId(id);
    }

    @Override
    public int queryothersNuminShop3byId(String id) {
        return vinMapper.queryothersNuminShop3byId(id);
    }

    @Override
    public int queryothersNuminShop4byId(String id) {
        return vinMapper.queryothersNuminShop4byId(id);
    }

    @Override
    public int queryothersNuminShop5byId(String id) {
        return vinMapper.queryothersNuminShop5byId(id);
    }

    @Override
    public int queryothersNuminShop6byId(String id) {
        return vinMapper.queryothersNuminShop6byId(id);
    }

    @Override
    public int queryothersNuminShop7byId(String id) {
        return vinMapper.queryothersNuminShop7byId(id);
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'IteminMain1List'")
    public List<VinItem> queryAllIteminMain1() {
        return vinMapper.queryAllIteminMain1();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'IteminMain2List'")
    public List<VinItem> queryAllIteminMain2() {
        return vinMapper.queryAllIteminMain2();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'IteminShop1List'")
    public List<VinItem> queryAllIteminShop1() {
        log.warn("not in cache");
        return vinMapper.queryAllIteminShop1();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'IteminShop2List'")
    public List<VinItem> queryAllIteminShop2() {
        List<VinItem> vinItems = vinMapper.queryAllIteminShop2();
        return vinItems;
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'IteminShop3List'")
    public List<VinItem> queryAllIteminShop3() {
        return vinMapper.queryAllIteminShop3();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'IteminShop4List'")
    public List<VinItem> queryAllIteminShop4() {
        return vinMapper.queryAllIteminShop4();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'IteminShop5List'")
    public List<VinItem> queryAllIteminShop5() {
        return vinMapper.queryAllIteminShop5();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'IteminShop6List'")
    public List<VinItem> queryAllIteminShop6() {
        return vinMapper.queryAllIteminShop6();
    }

    @Override
    public List<VinItem> queryAllIteminShop7() {
        return vinMapper.queryAllIteminShop7();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'SmallIteminMain1List'")
    public List<VinItem> queryAllSmallIteminMain1() {
        return vinMapper.queryAllSmallIteminMain1();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'SmallIteminMain2List'")
    public List<VinItem> queryAllSmallIteminMain2() {
        return vinMapper.queryAllSmallIteminMain2();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'SmallIteminShop1List'")
    public List<VinItem> queryAllSmallIteminShop1() {
        return vinMapper.queryAllSmallIteminShop1();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'SmallIteminShop2List'")
    public List<VinItem> queryAllSmallIteminShop2() {
        return vinMapper.queryAllSmallIteminShop2();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'SmallIteminShop3List'")
    public List<VinItem> queryAllSmallIteminShop3() {
        return vinMapper.queryAllSmallIteminShop3();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'SmallIteminShop4List'")
    public List<VinItem> queryAllSmallIteminShop4() {
        return vinMapper.queryAllSmallIteminShop4();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'SmallIteminShop5List'")
    public List<VinItem> queryAllSmallIteminShop5() {
        return vinMapper.queryAllSmallIteminShop5();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'SmallIteminShop6List'")
    public List<VinItem> queryAllSmallIteminShop6() {
        return vinMapper.queryAllSmallIteminShop6();
    }

    @Override
    public List<VinItem> queryAllSmallIteminShop7() {
        return vinMapper.queryAllSmallIteminShop7();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'FoodinMain1List'")
    public List<VinItem> queryAllFoodinMain1() {
        return vinMapper.queryAllFoodinMain1();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'FoodinMain2List'")
    public List<VinItem> queryAllFoodinMain2() {
        return vinMapper.queryAllFoodinMain2();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'FoodinShop1List'")
    public List<VinItem> queryAllFoodinShop1() {
//        log.warn();("一級緩存測試一"+vinMapper.queryAllFoodinShop1());//能用到一級緩存
//        log.warn();("一級緩存測試二"+vinMapper.queryAllFoodinShop1());//能用到一級緩存
        return vinMapper.queryAllFoodinShop1();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'FoodinShop2List'")
    public List<VinItem> queryAllFoodinShop2() {
        return vinMapper.queryAllFoodinShop2();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'FoodinShop3List'")
    public List<VinItem> queryAllFoodinShop3() {
        return vinMapper.queryAllFoodinShop3();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'FoodinShop4List'")
    public List<VinItem> queryAllFoodinShop4() {
        return vinMapper.queryAllFoodinShop4();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'FoodinShop5List'")
    public List<VinItem> queryAllFoodinShop5() {
        return vinMapper.queryAllFoodinShop5();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'FoodinShop6List'")
    public List<VinItem> queryAllFoodinShop6() {
        return vinMapper.queryAllFoodinShop6();
    }

    @Override
    public List<VinItem> queryAllFoodinShop7() {
        return vinMapper.queryAllFoodinShop7();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'commercialIteminMain1List'")
    public List<VinItem> queryAllcommercialIteminMain1() {
        return vinMapper.queryAllcommercialIteminMain1();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'commercialIteminMain2List'")
    public List<VinItem> queryAllcommercialIteminMain2() {
        return vinMapper.queryAllcommercialIteminMain2();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'commercialIteminShop1List'")
    public List<VinItem> queryAllcommercialIteminShop1() {
        return vinMapper.queryAllcommercialIteminShop1();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'commercialIteminShop2List'")
    public List<VinItem> queryAllcommercialIteminShop2() {
        return vinMapper.queryAllcommercialIteminShop2();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'commercialIteminShop3List'")
    public List<VinItem> queryAllcommercialIteminShop3() {
        return vinMapper.queryAllcommercialIteminShop3();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'commercialIteminShop4List'")
    public List<VinItem> queryAllcommercialIteminShop4() {
        return vinMapper.queryAllcommercialIteminShop4();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'commercialIteminShop5List'")
    public List<VinItem> queryAllcommercialIteminShop5() {
        return vinMapper.queryAllcommercialIteminShop5();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'commercialIteminShop6List'")
    public List<VinItem> queryAllcommercialIteminShop6() {
        return vinMapper.queryAllcommercialIteminShop6();
    }

    @Override
    public List<VinItem> queryAllcommercialIteminShop7() {
        return vinMapper.queryAllcommercialIteminShop7();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'othersinMain1List'")
    public List<VinItem> queryAllothersinMain1() {
        return vinMapper.queryAllothersinMain1();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'othersinMain2List'")
    public List<VinItem> queryAllothersinMain2() {
        return vinMapper.queryAllothersinMain2();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'othersinShop1List'")
    public List<VinItem> queryAllothersinShop1() {
        return vinMapper.queryAllothersinShop1();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'othersinShop2List'")
    public List<VinItem> queryAllothersinShop2() {
        return vinMapper.queryAllothersinShop2();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'othersinShop3List'")
    public List<VinItem> queryAllothersinShop3() {
        return vinMapper.queryAllothersinShop3();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'othersinShop4List'")
    public List<VinItem> queryAllothersinShop4() {
        return vinMapper.queryAllothersinShop4();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'othersinShop5List'")
    public List<VinItem> queryAllothersinShop5() {
        return vinMapper.queryAllothersinShop5();
    }

    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'othersinShop6List'")
    public List<VinItem> queryAllothersinShop6() {
        return vinMapper.queryAllothersinShop6();
    }

    @Override
    public List<VinItem> queryAllothersinShop7() {
        return vinMapper.queryAllothersinShop7();
    }

//    @Override
//    public VinItem queryIteminMain1ByName(String itemName) {
//        return vinMapper.queryIteminMain1ByName(itemName);
//    }
//
//    @Override
//    public VinItem queryIteminMain2ByName(String itemName) {
//        return vinMapper.queryIteminMain2ByName(itemName);
//    }
//
//    @Override
//    public VinItem queryIteminShop1ByName(String itemName) {
//        return vinMapper.queryIteminShop1ByName(itemName);
//    }
//
//    @Override
//    public VinItem queryIteminShop2ByName(String itemName) {
//        return vinMapper.queryIteminShop2ByName(itemName);
//    }
//
//    @Override
//    public VinItem queryIteminShop3ByName(String itemName) {
//        return vinMapper.queryIteminShop3ByName(itemName);
//    }
//
//    @Override
//    public VinItem queryIteminShop4ByName(String itemName) {
//        return vinMapper.queryIteminShop4ByName(itemName);
//    }
//
//    @Override
//    public VinItem queryIteminShop5ByName(String itemName) {
//        return vinMapper.queryIteminShop5ByName(itemName);
//    }
//
//    @Override
//    public VinItem queryIteminShop6ByName(String itemName) {
//        return vinMapper.queryIteminShop6ByName(itemName);
//    }
//
//    @Override
//    public VinItem queryIteminShop7ByName(String itemName) {
//        return vinMapper.queryIteminShop7ByName(itemName);
//    }
//
//    @Override
//    public VinItem querySmallIteminMain1ByName(String itemName) {
//        return vinMapper.querySmallIteminMain1ByName(itemName);
//    }
//
//    @Override
//    public VinItem querySmallIteminMain2ByName(String itemName) {
//        return vinMapper.querySmallIteminMain2ByName(itemName);
//    }
//
//    @Override
//    public VinItem querySmallIteminShop1ByName(String itemName) {
//        return vinMapper.querySmallIteminShop1ByName(itemName);
//    }
//
//    @Override
//    public VinItem querySmallIteminShop2ByName(String itemName) {
//        return vinMapper.querySmallIteminShop2ByName(itemName);
//    }
//
//    @Override
//    public VinItem querySmallIteminShop3ByName(String itemName) {
//        return vinMapper.querySmallIteminShop3ByName(itemName);
//    }
//
//    @Override
//    public VinItem querySmallIteminShop4ByName(String itemName) {
//        return vinMapper.querySmallIteminShop4ByName(itemName);
//    }
//
//    @Override
//    public VinItem querySmallIteminShop5ByName(String itemName) {
//        return vinMapper.querySmallIteminShop5ByName(itemName);
//    }
//
//    @Override
//    public VinItem querySmallIteminShop6ByName(String itemName) {
//        return vinMapper.querySmallIteminShop6ByName(itemName);
//    }
//
//    @Override
//    public VinItem querySmallIteminShop7ByName(String itemName) {
//        return vinMapper.querySmallIteminShop7ByName(itemName);
//    }
//
//    @Override
//    public VinItem queryFoodinMain1ByName(String itemName) {
//        return vinMapper.queryFoodinMain1ByName(itemName);
//    }
//
//    @Override
//    public VinItem queryFoodinMain2ByName(String itemName) {
//        return vinMapper.queryFoodinMain2ByName(itemName);
//    }
//
//    @Override
//    public VinItem queryFoodinShop1ByName(String itemName) {
//        return vinMapper.queryFoodinShop1ByName(itemName);
//    }
//
//    @Override
//    public VinItem queryFoodinShop2ByName(String itemName) {
//        return vinMapper.queryFoodinShop2ByName(itemName);
//    }
//
//    @Override
//    public VinItem queryFoodinShop3ByName(String itemName) {
//        return vinMapper.queryFoodinShop3ByName(itemName);
//    }
//
//    @Override
//    public VinItem queryFoodinShop4ByName(String itemName) {
//        return vinMapper.queryFoodinShop4ByName(itemName);
//    }
//
//    @Override
//    public VinItem queryFoodinShop5ByName(String itemName) {
//        return vinMapper.queryFoodinShop5ByName(itemName);
//    }
//
//    @Override
//    public VinItem queryFoodinShop6ByName(String itemName) {
//        return vinMapper.queryFoodinShop6ByName(itemName);
//    }
//
//    @Override
//    public VinItem queryFoodinShop7ByName(String itemName) {
//        return vinMapper.queryFoodinShop7ByName(itemName);
//    }
//
//    @Override
//    public VinItem querycommercialIteminMain1ByName(String itemName) {
//        return vinMapper.querycommercialIteminMain1ByName(itemName);
//    }
//
//    @Override
//    public VinItem querycommercialIteminMain2ByName(String itemName) {
//        return vinMapper.querycommercialIteminMain2ByName(itemName);
//    }
//
//    @Override
//    public VinItem querycommercialIteminShop1ByName(String itemName) {
//        return vinMapper.querycommercialIteminShop1ByName(itemName);
//    }
//
//    @Override
//    public VinItem querycommercialIteminShop2ByName(String itemName) {
//        return vinMapper.querycommercialIteminShop2ByName(itemName);
//    }
//
//    @Override
//    public VinItem querycommercialIteminShop3ByName(String itemName) {
//        return vinMapper.querycommercialIteminShop3ByName(itemName);
//    }
//
//    @Override
//    public VinItem querycommercialIteminShop4ByName(String itemName) {
//        return vinMapper.querycommercialIteminShop4ByName(itemName);
//    }
//
//    @Override
//    public VinItem querycommercialIteminShop5ByName(String itemName) {
//        return vinMapper.querycommercialIteminShop5ByName(itemName);
//    }
//
//    @Override
//    public VinItem querycommercialIteminShop6ByName(String itemName) {
//        return vinMapper.querycommercialIteminShop6ByName(itemName);
//    }
//
//    @Override
//    public VinItem querycommercialIteminShop7ByName(String itemName) {
//        return vinMapper.querycommercialIteminShop7ByName(itemName);
//    }
//
//    @Override
//    public VinItem queryothersinMain1ByName(String itemName) {
//        return vinMapper.queryothersinMain1ByName(itemName);
//    }
//
//    @Override
//    public VinItem queryothersinMain2ByName(String itemName) {
//        return vinMapper.queryothersinMain2ByName(itemName);
//    }
//
//    @Override
//    public VinItem queryothersinShop1ByName(String itemName) {
//        return vinMapper.queryothersinShop1ByName(itemName);
//    }
//
//    @Override
//    public VinItem queryothersinShop2ByName(String itemName) {
//        return vinMapper.queryothersinShop2ByName(itemName);
//    }
//
//    @Override
//    public VinItem queryothersinShop3ByName(String itemName) {
//        return vinMapper.queryothersinShop3ByName(itemName);
//    }
//
//    @Override
//    public VinItem queryothersinShop4ByName(String itemName) {
//        return vinMapper.queryothersinShop4ByName(itemName);
//    }
//
//    @Override
//    public VinItem queryothersinShop5ByName(String itemName) {
//        return vinMapper.queryothersinShop5ByName(itemName);
//    }
//
//    @Override
//    public VinItem queryothersinShop6ByName(String itemName) {
//        return vinMapper.queryothersinShop6ByName(itemName);
//    }
//
//    @Override
//    public VinItem queryothersinShop7ByName(String itemName) {
//        return vinMapper.queryothersinShop7ByName(itemName);
//    }

//    @Override
//    public VinItem queryItemNuminMain1byID(String id) {
//        return vinMapper.queryItemNuminMain1byID(id);
//    }
//
//    @Override
//    public VinItem queryItemNuminMain2byID(String id) {
//        return vinMapper.queryItemNuminMain2byID(id);
//    }
//
//    @Override
//    public VinItem queryItemNuminShop1byID(String id) {
//        return vinMapper.queryItemNuminShop1byID(id);
//    }
//
//    @Override
//    public VinItem queryItemNuminShop2byID(String id) {
//        return vinMapper.queryItemNuminShop2byID(id);
//    }
//
//    @Override
//    public VinItem queryItemNuminShop3byID(String id) {
//        return vinMapper.queryItemNuminShop3byID(id);
//    }
//
//    @Override
//    public VinItem queryItemNuminShop4byID(String id) {
//        return vinMapper.queryItemNuminShop4byID(id);
//    }
//
//    @Override
//    public VinItem queryItemNuminShop5byID(String id) {
//        return vinMapper.queryItemNuminShop5byID(id);
//    }
//
//    @Override
//    public VinItem queryItemNuminShop6byID(String id) {
//        return vinMapper.queryItemNuminShop6byID(id);
//    }
//
//    @Override
//    public VinItem queryItemNuminShop7byID(String id) {
//        return vinMapper.queryItemNuminShop7byID(id);
//    }
//
//    @Override
//    public VinItem querySmallItemNuminMain1byID(String id) {
//        return vinMapper.querySmallItemNuminMain1byID(id);
//    }
//
//    @Override
//    public VinItem querySmallItemNuminMain2byID(String id) {
//        return vinMapper.querySmallItemNuminMain2byID(id);
//    }
//
//    @Override
//    public VinItem querySmallItemNuminShop1byID(String id) {
//        return vinMapper.querySmallItemNuminShop1byID(id);
//    }
//
//    @Override
//    public VinItem querySmallItemNuminShop2byID(String id) {
//        return vinMapper.querySmallItemNuminShop2byID(id);
//    }
//
//    @Override
//    public VinItem querySmallItemNuminShop3byID(String id) {
//        return vinMapper.querySmallItemNuminShop3byID(id);
//    }
//
//    @Override
//    public VinItem querySmallItemNuminShop4byID(String id) {
//        return vinMapper.querySmallItemNuminShop4byID(id);
//    }
//
//    @Override
//    public VinItem querySmallItemNuminShop5byID(String id) {
//        return vinMapper.querySmallItemNuminShop5byID(id);
//    }
//
//    @Override
//    public VinItem querySmallItemNuminShop6byID(String id) {
//        return vinMapper.querySmallItemNuminShop6byID(id);
//    }
//
//    @Override
//    public VinItem querySmallItemNuminShop7byID(String id) {
//        return vinMapper.querySmallItemNuminShop7byID(id);
//    }
//
//    @Override
//    public VinItem queryFoodNuminMain1byID(String id) {
//        return vinMapper.queryFoodNuminMain1byID(id);
//    }
//
//    @Override
//    public VinItem queryFoodNuminMain2byID(String id) {
//        return vinMapper.queryFoodNuminMain2byID(id);
//    }
//
//    @Override
//    public VinItem queryFoodNuminShop1byID(String id) {
//        return vinMapper.queryFoodNuminShop1byID(id);
//    }
//
//    @Override
//    public VinItem queryFoodNuminShop2byID(String id) {
//        return vinMapper.queryFoodNuminShop2byID(id);
//    }
//
//    @Override
//    public VinItem queryFoodNuminShop3byID(String id) {
//        return vinMapper.queryFoodNuminShop3byID(id);
//    }
//
//    @Override
//    public VinItem queryFoodNuminShop4byID(String id) {
//        return vinMapper.queryFoodNuminShop4byID(id);
//    }
//
//    @Override
//    public VinItem queryFoodNuminShop5byID(String id) {
//        return vinMapper.queryFoodNuminShop5byID(id);
//    }
//
//    @Override
//    public VinItem queryFoodNuminShop6byID(String id) {
//        return vinMapper.queryFoodNuminShop6byID(id);
//    }
//
//    @Override
//    public VinItem queryFoodNuminShop7byID(String id) {
//        return vinMapper.queryFoodNuminShop7byID(id);
//    }
//
//    @Override
//    public VinItem querycommercialItemNuminMain1byID(String id) {
//        return vinMapper.querycommercialItemNuminMain1byID(id);
//    }
//
//    @Override
//    public VinItem querycommercialItemNuminMain2byID(String id) {
//        return vinMapper.querycommercialItemNuminMain2byID(id);
//    }
//
//    @Override
//    public VinItem querycommercialItemNuminShop1byID(String id) {
//        return vinMapper.querycommercialItemNuminShop1byID(id);
//    }
//
//    @Override
//    public VinItem querycommercialItemNuminShop2byID(String id) {
//        return vinMapper.querycommercialItemNuminShop2byID(id);
//    }
//
//    @Override
//    public VinItem querycommercialItemNuminShop3byID(String id) {
//        return vinMapper.querycommercialItemNuminShop3byID(id);
//    }
//
//    @Override
//    public VinItem querycommercialItemNuminShop4byID(String id) {
//        return vinMapper.querycommercialItemNuminShop4byID(id);
//    }
//
//    @Override
//    public VinItem querycommercialItemNuminShop5byID(String id) {
//        return vinMapper.querycommercialItemNuminShop5byID(id);
//    }
//
//    @Override
//    public VinItem querycommercialItemNuminShop6byID(String id) {
//        return vinMapper.querycommercialItemNuminShop6byID(id);
//    }
//
//    @Override
//    public VinItem querycommercialItemNuminShop7byID(String id) {
//        return vinMapper.querycommercialItemNuminShop7byID(id);
//    }
//
//    @Override
//    public VinItem queryothersNuminMain1byID(String id) {
//        return vinMapper.queryothersNuminMain1byID(id);
//    }
//
//    @Override
//    public VinItem queryothersNuminMain2byID(String id) {
//        return vinMapper.queryothersNuminMain2byID(id);
//    }
//
//    @Override
//    public VinItem queryothersNuminShop1byID(String id) {
//        return vinMapper.queryothersNuminShop1byID(id);
//    }
//
//    @Override
//    public VinItem queryothersNuminShop2byID(String id) {
//        return vinMapper.queryothersNuminShop2byID(id);
//    }
//
//    @Override
//    public VinItem queryothersNuminShop3byID(String id) {
//        return vinMapper.queryothersNuminShop3byID(id);
//    }
//
//    @Override
//    public VinItem queryothersNuminShop4byID(String id) {
//        return vinMapper.queryothersNuminShop4byID(id);
//    }
//
//    @Override
//    public VinItem queryothersNuminShop5byID(String id) {
//        return vinMapper.queryothersNuminShop5byID(id);
//    }
//
//    @Override
//    public VinItem queryothersNuminShop6byID(String id) {
//        return vinMapper.queryothersNuminShop6byID(id);
//    }
//
//    @Override
//    public VinItem queryothersNuminShop7byID(String id) {
//        return vinMapper.queryothersNuminShop7byID(id);
//    }

    @Override
    public int ifItemExistinMain1(String id) {
        return vinMapper.ifItemExistinMain1(id);
    }

    @Override
    public int ifItemExistinMain2(String id) {
        return vinMapper.ifItemExistinMain2(id);
    }

    @Override
    public int ifItemExistinShop1(String id) {
        return vinMapper.ifItemExistinShop1(id);
    }

    @Override
    public int ifItemExistinShop2(String id) {
        return vinMapper.ifItemExistinShop2(id);
    }

    @Override
    public int ifItemExistinShop3(String id) {
        return vinMapper.ifItemExistinShop3(id);
    }

    @Override
    public int ifItemExistinShop4(String id) {
        return vinMapper.ifItemExistinShop4(id);
    }

    @Override
    public int ifItemExistinShop5(String id) {
        return vinMapper.ifItemExistinShop5(id);
    }

    @Override
    public int ifItemExistinShop6(String id) {
        return vinMapper.ifItemExistinShop6(id);
    }

    @Override
    public int ifItemExistinShop7(String id) {
        return vinMapper.ifItemExistinShop7(id);
    }

    @Override
    public int ifSmallItemExistinMain1(String id) {
        return vinMapper.ifSmallItemExistinMain1(id);
    }

    @Override
    public int ifSmallItemExistinMain2(String id) {
        return vinMapper.ifSmallItemExistinMain2(id);
    }

    @Override
    public int ifSmallItemExistinShop1(String id) {
        return vinMapper.ifSmallItemExistinShop1(id);
    }

    @Override
    public int ifSmallItemExistinShop2(String id) {
        return vinMapper.ifSmallItemExistinShop2(id);
    }

    @Override
    public int ifSmallItemExistinShop3(String id) {
        return vinMapper.ifSmallItemExistinShop3(id);
    }

    @Override
    public int ifSmallItemExistinShop4(String id) {
        return vinMapper.ifSmallItemExistinShop4(id);
    }

    @Override
    public int ifSmallItemExistinShop5(String id) {
        return vinMapper.ifSmallItemExistinShop5(id);
    }

    @Override
    public int ifSmallItemExistinShop6(String id) {
        return vinMapper.ifSmallItemExistinShop6(id);
    }

    @Override
    public int ifSmallItemExistinShop7(String id) {
        return vinMapper.ifSmallItemExistinShop7(id);
    }

    @Override
    public int ifFoodExistinMain1(String id) {
        return vinMapper.ifFoodExistinMain1(id);
    }

    @Override
    public int ifFoodExistinMain2(String id) {
        return vinMapper.ifFoodExistinMain2(id);
    }

    @Override
    public int ifFoodExistinShop1(String id) {
        return vinMapper.ifFoodExistinShop1(id);
    }

    @Override
    public int ifFoodExistinShop2(String id) {
        return vinMapper.ifFoodExistinShop2(id);
    }

    @Override
    public int ifFoodExistinShop3(String id) {
        return vinMapper.ifFoodExistinShop3(id);
    }

    @Override
    public int ifFoodExistinShop4(String id) {
        return vinMapper.ifFoodExistinShop4(id);
    }

    @Override
    public int ifFoodExistinShop5(String id) {
        return vinMapper.ifFoodExistinShop5(id);
    }

    @Override
    public int ifFoodExistinShop6(String id) {
        return vinMapper.ifFoodExistinShop6(id);
    }

    @Override
    public int ifFoodExistinShop7(String id) {
        return vinMapper.ifFoodExistinShop7(id);
    }

    @Override
    public int ifcommercialItemExistinMain1(String id) {
        return vinMapper.ifcommercialItemExistinMain1(id);
    }

    @Override
    public int ifcommercialItemExistinMain2(String id) {
        return vinMapper.ifcommercialItemExistinMain2(id);
    }

    @Override
    public int ifcommercialItemExistinShop1(String id) {
        return vinMapper.ifcommercialItemExistinShop1(id);
    }

    @Override
    public int ifcommercialItemExistinShop2(String id) {
        return vinMapper.ifcommercialItemExistinShop2(id);
    }

    @Override
    public int ifcommercialItemExistinShop3(String id) {
        return vinMapper.ifcommercialItemExistinShop3(id);
    }

    @Override
    public int ifcommercialItemExistinShop4(String id) {
        return vinMapper.ifcommercialItemExistinShop4(id);
    }

    @Override
    public int ifcommercialItemExistinShop5(String id) {
        return vinMapper.ifcommercialItemExistinShop5(id);
    }

    @Override
    public int ifcommercialItemExistinShop6(String id) {
        return vinMapper.ifcommercialItemExistinShop6(id);
    }

    @Override
    public int ifcommercialItemExistinShop7(String id) {
        return vinMapper.ifcommercialItemExistinShop7(id);
    }

    @Override
    public int ifothersExistinMain1(String id) {
        return vinMapper.ifothersExistinMain1(id);
    }

    @Override
    public int ifothersExistinMain2(String id) {
        return vinMapper.ifothersExistinMain2(id);
    }

    @Override
    public int ifothersExistinShop1(String id) {
        return vinMapper.ifothersExistinShop1(id);
    }

    @Override
    public int ifothersExistinShop2(String id) {
        return vinMapper.ifothersExistinShop2(id);
    }

    @Override
    public int ifothersExistinShop3(String id) {
        return vinMapper.ifothersExistinShop3(id);
    }

    @Override
    public int ifothersExistinShop4(String id) {
        return vinMapper.ifothersExistinShop4(id);
    }

    @Override
    public int ifothersExistinShop5(String id) {
        return vinMapper.ifothersExistinShop5(id);
    }

    @Override
    public int ifothersExistinShop6(String id) {
        return vinMapper.ifothersExistinShop6(id);
    }

    @Override
    public int ifothersExistinShop7(String id) {
        return vinMapper.ifothersExistinShop7(id);
    }

    @Override
    public int updateItembySendfromMain1(VinItem items) {
        return vinMapper.updateItembySendfromMain1(items);
    }

    @Override
    public int updateItembySendfromMain2(VinItem items) {
        return vinMapper.updateItembySendfromMain2(items);
    }

    @Override
    public int updateItembySendfromShop1(VinItem items) {
        return vinMapper.updateItembySendfromShop1(items);
    }

    @Override
    public int updateItembySendfromShop2(VinItem items) {
        return vinMapper.updateItembySendfromShop2(items);
    }

    @Override
    public int updateItembySendfromShop3(VinItem items) {
        return vinMapper.updateItembySendfromShop3(items);
    }

    @Override
    public int updateItembySendfromShop4(VinItem items) {
        return vinMapper.updateItembySendfromShop4(items);
    }

    @Override
    public int updateItembySendfromShop5(VinItem items) {
        return vinMapper.updateItembySendfromShop5(items);
    }

    @Override
    public int updateItembySendfromShop6(VinItem items) {
        return vinMapper.updateItembySendfromShop6(items);
    }

    @Override
    public int updateItembySendfromShop7(VinItem items) {
        return vinMapper.updateItembySendfromShop7(items);
    }

    @Override
    public int updateSmallItembySendfromMain1(VinItem items) {
        return vinMapper.updateSmallItembySendfromMain1(items);
    }

    @Override
    public int updateSmallItembySendfromMain2(VinItem items) {
        return vinMapper.updateSmallItembySendfromMain2(items);
    }

    @Override
    public int updateSmallItembySendfromShop1(VinItem items) {
        return vinMapper.updateSmallItembySendfromShop1(items);
    }

    @Override
    public int updateSmallItembySendfromShop2(VinItem items) {
        return vinMapper.updateSmallItembySendfromShop2(items);
    }

    @Override
    public int updateSmallItembySendfromShop3(VinItem items) {
        return vinMapper.updateSmallItembySendfromShop3(items);
    }

    @Override
    public int updateSmallItembySendfromShop4(VinItem items) {
        return vinMapper.updateSmallItembySendfromShop4(items);
    }

    @Override
    public int updateSmallItembySendfromShop5(VinItem items) {
        return vinMapper.updateSmallItembySendfromShop5(items);
    }

    @Override
    public int updateSmallItembySendfromShop6(VinItem items) {
        return vinMapper.updateSmallItembySendfromShop6(items);
    }

    @Override
    public int updateSmallItembySendfromShop7(VinItem items) {
        return vinMapper.updateSmallItembySendfromShop7(items);
    }

    @Override
    public int updateFoodbySendfromMain1(VinItem items) {
        return vinMapper.updateFoodbySendfromMain1(items);
    }

    @Override
    public int updateFoodbySendfromMain2(VinItem items) {
        return vinMapper.updateFoodbySendfromMain2(items);
    }

    @Override
    public int updateFoodbySendfromShop1(VinItem items) {
        return vinMapper.updateFoodbySendfromShop1(items);
    }

    @Override
    public int updateFoodbySendfromShop2(VinItem items) {
        return vinMapper.updateFoodbySendfromShop2(items);
    }

    @Override
    public int updateFoodbySendfromShop3(VinItem items) {
        return vinMapper.updateFoodbySendfromShop3(items);
    }

    @Override
    public int updateFoodbySendfromShop4(VinItem items) {
        return vinMapper.updateFoodbySendfromShop4(items);
    }

    @Override
    public int updateFoodbySendfromShop5(VinItem items) {
        return vinMapper.updateFoodbySendfromShop5(items);
    }

    @Override
    public int updateFoodbySendfromShop6(VinItem items) {
        return vinMapper.updateFoodbySendfromShop6(items);
    }

    @Override
    public int updateFoodbySendfromShop7(VinItem items) {
        return vinMapper.updateFoodbySendfromShop7(items);
    }

    @Override
    public int updatecommercialItembySendfromMain1(VinItem items) {
        return vinMapper.updatecommercialItembySendfromMain1(items);
    }

    @Override
    public int updatecommercialItembySendfromMain2(VinItem items) {
        return vinMapper.updatecommercialItembySendfromMain2(items);
    }

    @Override
    public int updatecommercialItembySendfromShop1(VinItem items) {
        return vinMapper.updatecommercialItembySendfromShop1(items);
    }

    @Override
    public int updatecommercialItembySendfromShop2(VinItem items) {
        return vinMapper.updatecommercialItembySendfromShop2(items);
    }

    @Override
    public int updatecommercialItembySendfromShop3(VinItem items) {
        return vinMapper.updatecommercialItembySendfromShop3(items);
    }

    @Override
    public int updatecommercialItembySendfromShop4(VinItem items) {
        return vinMapper.updatecommercialItembySendfromShop4(items);
    }

    @Override
    public int updatecommercialItembySendfromShop5(VinItem items) {
        return vinMapper.updatecommercialItembySendfromShop5(items);
    }

    @Override
    public int updatecommercialItembySendfromShop6(VinItem items) {
        return vinMapper.updatecommercialItembySendfromShop6(items);
    }

    @Override
    public int updatecommercialItembySendfromShop7(VinItem items) {
        return vinMapper.updatecommercialItembySendfromShop7(items);
    }

    @Override
    public int updateothersbySendfromMain1(VinItem items) {
        return vinMapper.updateothersbySendfromMain1(items);
    }

    @Override
    public int updateothersbySendfromMain2(VinItem items) {
        return vinMapper.updateothersbySendfromMain2(items);
    }

    @Override
    public int updateothersbySendfromShop1(VinItem items) {
        return vinMapper.updateothersbySendfromShop1(items);
    }

    @Override
    public int updateothersbySendfromShop2(VinItem items) {
        return vinMapper.updateothersbySendfromShop2(items);
    }

    @Override
    public int updateothersbySendfromShop3(VinItem items) {
        return vinMapper.updateothersbySendfromShop3(items);
    }

    @Override
    public int updateothersbySendfromShop4(VinItem items) {
        return vinMapper.updateothersbySendfromShop4(items);
    }

    @Override
    public int updateothersbySendfromShop5(VinItem items) {
        return vinMapper.updateothersbySendfromShop5(items);
    }

    @Override
    public int updateothersbySendfromShop6(VinItem items) {
        return vinMapper.updateothersbySendfromShop6(items);
    }

    @Override
    public int updateothersbySendfromShop7(VinItem items) {
        return vinMapper.updateothersbySendfromShop7(items);
    }

    @Override
    @Cacheable(value = { "cutelittlepiggyCache" },key="#uname", condition="#uname!=null", unless = "#result==null")
    public User queryUserInformation(String uname) {
        return vinMapper.queryUserInformation(uname);
    }

    @Override
    public int addloginMain1(VinLog log) {
        return vinMapper.addloginMain1(log);
    }

    @Override
    public int addloginMain2(VinLog log) {
        return vinMapper.addloginMain2(log);
    }

    @Override
    public int addloginShop1(VinLog log) {
        return vinMapper.addloginShop1(log);
    }

    @Override
    public int addloginShop2(VinLog log) {
        return vinMapper.addloginShop2(log);
    }

    @Override
    public int addloginShop3(VinLog log) {
        return vinMapper.addloginShop3(log);
    }

    @Override
    public int addloginShop4(VinLog log) {
        return vinMapper.addloginShop4(log);
    }

    @Override
    public int addloginShop5(VinLog log) {
        return vinMapper.addloginShop5(log);
    }

    @Override
    public int addloginShop6(VinLog log) {
        return vinMapper.addloginShop6(log);
    }

    @Override
    public int addloginShop7(VinLog log) {
        return vinMapper.addloginShop7(log);
    }

    @Override
    public List<VinLog> queryCategoryLoginMain1(String category) {
        return vinMapper.queryCategoryLoginMain1(category);
    }

    @Override
    public List<VinLog> queryCategoryLoginMain2(String category) {
        return vinMapper.queryCategoryLoginMain2(category);
    }

    @Override
    public List<VinLog> queryCategoryLoginShop1(String category) {
        return vinMapper.queryCategoryLoginShop1(category);
    }

    @Override
    public List<VinLog> queryCategoryLoginShop2(String category) {
        return vinMapper.queryCategoryLoginShop2(category);
    }

    @Override
    public List<VinLog> queryCategoryLoginShop3(String category) {
        return vinMapper.queryCategoryLoginShop3(category);
    }

    @Override
    public List<VinLog> queryCategoryLoginShop4(String category) {
        return vinMapper.queryCategoryLoginShop4(category);
    }

    @Override
    public List<VinLog> queryCategoryLoginShop5(String category) {
        return vinMapper.queryCategoryLoginShop5(category);
    }

    @Override
    public List<VinLog> queryCategoryLoginShop6(String category) {
        return vinMapper.queryCategoryLoginShop6(category);
    }

    @Override
    public List<VinLog> queryCategoryLoginShop7(String category) {
        return vinMapper.queryCategoryLoginShop7(category);
    }

    @Override
    public List<VinLog> queryCategoryandIfCompleteLoginMain1(String category, boolean ifComplete) {
        return vinMapper.queryCategoryandIfCompleteLoginMain1(category,ifComplete);
    }

    @Override
    public List<VinLog> queryCategoryandIfCompleteLoginMain2(String category, boolean ifComplete) {
        return vinMapper.queryCategoryandIfCompleteLoginMain2(category,ifComplete);
    }

    @Override
    public List<VinLog> queryCategoryandIfCompleteLoginShop1(String category, boolean ifComplete) {
        return vinMapper.queryCategoryandIfCompleteLoginShop1(category,ifComplete);
    }

    @Override
    public List<VinLog> queryCategoryandIfCompleteLoginShop2(String category, boolean ifComplete) {
        return vinMapper.queryCategoryandIfCompleteLoginShop2(category,ifComplete);
    }

    @Override
    public List<VinLog> queryCategoryandIfCompleteLoginShop3(String category, boolean ifComplete) {
        return vinMapper.queryCategoryandIfCompleteLoginShop3(category,ifComplete);
    }

    @Override
    public List<VinLog> queryCategoryandIfCompleteLoginShop4(String category, boolean ifComplete) {
        return vinMapper.queryCategoryandIfCompleteLoginShop4(category,ifComplete);
    }

    @Override
    public List<VinLog> queryCategoryandIfCompleteLoginShop5(String category, boolean ifComplete) {
        return vinMapper.queryCategoryandIfCompleteLoginShop5(category,ifComplete);
    }

    @Override
    public List<VinLog> queryCategoryandIfCompleteLoginShop6(String category, boolean ifComplete) {
        return vinMapper.queryCategoryandIfCompleteLoginShop6(category,ifComplete);
    }

    @Override
    public List<VinLog> queryCategoryandIfCompleteLoginShop7(String category, boolean ifComplete) {
        return vinMapper.queryCategoryandIfCompleteLoginShop7(category,ifComplete);
    }

    @Override
    public List<VinLog> queryCategoryReceiveinMain1(String category) {
        return vinMapper.queryCategoryReceiveinMain1(category);
    }

    @Override
    public List<VinLog> queryCategoryReceiveinMain2(String category) {
        return vinMapper.queryCategoryReceiveinMain2(category);
    }

    @Override
    public List<VinLog> queryCategoryReceiveinShop1(String category) {
        return vinMapper.queryCategoryReceiveinShop1(category);
    }

    @Override
    public List<VinLog> queryCategoryReceiveinShop2(String category) {
        return vinMapper.queryCategoryReceiveinShop2(category);
    }

    @Override
    public List<VinLog> queryCategoryReceiveinShop3(String category) {
        return vinMapper.queryCategoryReceiveinShop3(category);
    }

    @Override
    public List<VinLog> queryCategoryReceiveinShop4(String category) {
        return vinMapper.queryCategoryReceiveinShop4(category);
    }

    @Override
    public List<VinLog> queryCategoryReceiveinShop5(String category) {
        return vinMapper.queryCategoryReceiveinShop5(category);
    }

    @Override
    public List<VinLog> queryCategoryReceiveinShop6(String category) {
        return vinMapper.queryCategoryReceiveinShop6(category);
    }

    @Override
    public List<VinLog> queryCategoryReceiveinShop7(String category) {
        return vinMapper.queryCategoryReceiveinShop7(category);
    }

    @Override
    public int countCategoryReceiveinMain1(String category) {
        return vinMapper.countCategoryReceiveinMain1(category);
    }

    @Override
    public int countCategoryReceiveinMain2(String category) {
        return vinMapper.countCategoryReceiveinMain2(category);
    }

    @Override
    public int countCategoryReceiveinShop1(String category) {
        return vinMapper.countCategoryReceiveinShop1(category);
    }

    @Override
    public int countCategoryReceiveinShop2(String category) {
        return vinMapper.countCategoryReceiveinShop2(category);
    }

    @Override
    public int countCategoryReceiveinShop3(String category) {
        return vinMapper.countCategoryReceiveinShop3(category);
    }

    @Override
    public int countCategoryReceiveinShop4(String category) {
        return vinMapper.countCategoryReceiveinShop4(category);
    }

    @Override
    public int countCategoryReceiveinShop5(String category) {
        return vinMapper.countCategoryReceiveinShop5(category);
    }

    @Override
    public int countCategoryReceiveinShop6(String category) {
        return vinMapper.countCategoryReceiveinShop6(category);
    }

    @Override
    public int countCategoryReceiveinShop7(String category) {
        return vinMapper.countCategoryReceiveinShop7(category);
    }

    @Override
    public List<VinLog> queryCategoryConfirminMain1(String category, String action, String action2) {
        return vinMapper.queryCategoryConfirminMain1(category,action,action2);
    }

    @Override
    public List<VinLog> queryCategoryConfirminMain2(String category, String action, String action2) {
        return vinMapper.queryCategoryConfirminMain2(category,action,action2);
    }

    @Override
    public List<VinLog> queryCategoryConfirminShop1(String category, String action, String action2) {
        return vinMapper.queryCategoryConfirminShop1(category,action,action2);
    }

    @Override
    public List<VinLog> queryCategoryConfirminShop2(String category, String action, String action2) {
        return vinMapper.queryCategoryConfirminShop2(category,action,action2);
    }

    @Override
    public List<VinLog> queryCategoryConfirminShop3(String category, String action, String action2) {
        return vinMapper.queryCategoryConfirminShop3(category,action,action2);
    }

    @Override
    public List<VinLog> queryCategoryConfirminShop4(String category, String action, String action2) {
        return vinMapper.queryCategoryConfirminShop4(category,action,action2);
    }

    @Override
    public List<VinLog> queryCategoryConfirminShop5(String category, String action, String action2) {
        return vinMapper.queryCategoryConfirminShop5(category,action,action2);
    }

    @Override
    public List<VinLog> queryCategoryConfirminShop6(String category, String action, String action2) {
        return vinMapper.queryCategoryConfirminShop6(category,action,action2);
    }

    @Override
    public List<VinLog> queryCategoryConfirminShop7(String category, String action, String action2) {
        return vinMapper.queryCategoryConfirminShop7(category,action,action2);
    }

    @Override
    public int countCategoryConfirminMain1(String category, String action, String action2) {
        return vinMapper.countCategoryConfirminMain1(category,action,action2);
    }

    @Override
    public int countCategoryConfirminMain2(String category, String action, String action2) {
        return vinMapper.countCategoryConfirminMain2(category,action,action2);
    }

    @Override
    public int countCategoryConfirminShop1(String category, String action, String action2) {
        return vinMapper.countCategoryConfirminShop1(category,action,action2);
    }

    @Override
    public int countCategoryConfirminShop2(String category, String action, String action2) {
        return vinMapper.countCategoryConfirminShop2(category,action,action2);
    }

    @Override
    public int countCategoryConfirminShop3(String category, String action, String action2) {
        return vinMapper.countCategoryConfirminShop3(category,action,action2);
    }

    @Override
    public int countCategoryConfirminShop4(String category, String action, String action2) {
        return vinMapper.countCategoryConfirminShop4(category,action,action2);
    }

    @Override
    public int countCategoryConfirminShop5(String category, String action, String action2) {
        return vinMapper.countCategoryConfirminShop5(category,action,action2);
    }

    @Override
    public int countCategoryConfirminShop6(String category, String action, String action2) {
        return vinMapper.countCategoryConfirminShop6(category,action,action2);
    }

    @Override
    public int countCategoryConfirminShop7(String category, String action, String action2) {
        return vinMapper.countCategoryConfirminShop7(category,action,action2);
    }

    @Override
    public VinLog queryLoginmain1byid(String logid) {
        return vinMapper.queryLoginmain1byid(logid);
    }

    @Override
    public VinLog queryLoginmain2byid(String logid) {
        return vinMapper.queryLoginmain2byid(logid);
    }

    @Override
    public VinLog queryLoginshop1byid(String logid) {
        return vinMapper.queryLoginshop1byid(logid);
    }

    @Override
    public VinLog queryLoginshop2byid(String logid) {
        return vinMapper.queryLoginshop2byid(logid);
    }

    @Override
    public VinLog queryLoginshop3byid(String logid) {
        return vinMapper.queryLoginshop3byid(logid);
    }

    @Override
    public VinLog queryLoginshop4byid(String logid) {
        return vinMapper.queryLoginshop4byid(logid);
    }

    @Override
    public VinLog queryLoginshop5byid(String logid) {
        return vinMapper.queryLoginshop5byid(logid);
    }

    @Override
    public VinLog queryLoginshop6byid(String logid) {
        return vinMapper.queryLoginshop6byid(logid);
    }

    @Override
    public VinLog queryLoginshop7byid(String logid) {
        return vinMapper.queryLoginshop7byid(logid);
    }

    @Override
    public int updateLoginmain1byid(VinLog vinLog) {
        return vinMapper.updateLoginmain1byid(vinLog);
    }

    @Override
    public int updateLoginmain2byid(VinLog vinLog) {
        return vinMapper.updateLoginmain2byid(vinLog);
    }

    @Override
    public int updateLoginshop1byid(VinLog vinLog) {
        return vinMapper.updateLoginshop1byid(vinLog);
    }

    @Override
    public int updateLoginshop2byid(VinLog vinLog) {
        return vinMapper.updateLoginshop2byid(vinLog);
    }

    @Override
    public int updateLoginshop3byid(VinLog vinLog) {
        return vinMapper.updateLoginshop3byid(vinLog);
    }

    @Override
    public int updateLoginshop4byid(VinLog vinLog) {
        return vinMapper.updateLoginshop4byid(vinLog);
    }

    @Override
    public int updateLoginshop5byid(VinLog vinLog) {
        return vinMapper.updateLoginshop5byid(vinLog);
    }

    @Override
    public int updateLoginshop6byid(VinLog vinLog) {
        return vinMapper.updateLoginshop6byid(vinLog);
    }

    @Override
    public int updateLoginshop7byid(VinLog vinLog) {
        return vinMapper.updateLoginshop7byid(vinLog);
    }

    @Override
    public int deleteLoginMain1byLogid(String logid) {
        return vinMapper.deleteLoginMain1byLogid(logid);
    }

    @Override
    public int deleteLoginMain2byLogid(String logid) {
        return vinMapper.deleteLoginMain2byLogid(logid);
    }

    @Override
    public int deleteLoginShop1byLogid(String logid) {
        return vinMapper.deleteLoginShop1byLogid(logid);
    }

    @Override
    public int deleteLoginShop2byLogid(String logid) {
        return vinMapper.deleteLoginShop2byLogid(logid);
    }

    @Override
    public int deleteLoginShop3byLogid(String logid) {
        return vinMapper.deleteLoginShop3byLogid(logid);
    }

    @Override
    public int deleteLoginShop4byLogid(String logid) {
        return vinMapper.deleteLoginShop4byLogid(logid);
    }

    @Override
    public int deleteLoginShop5byLogid(String logid) {
        return vinMapper.deleteLoginShop5byLogid(logid);
    }

    @Override
    public int deleteLoginShop6byLogid(String logid) {
        return vinMapper.deleteLoginShop6byLogid(logid);
    }

    @Override
    public int deleteLoginShop7byLogid(String logid) {
        return vinMapper.deleteLoginShop7byLogid(logid);
    }

    @Override
    @Cacheable(value = { "cutelittlepiggyCache" },key="'queryRealWarehouseName_'+#nickname")
    public Warehouse queryRealWarehouseName(String nickname) {
        return vinMapper.queryRealWarehouseName(nickname);
    }

    @Override
    public List<Warehouse> queryAllRealWarehouseName() {
        return vinMapper.queryAllRealWarehouseName();
    }

    @Override
    public int addCheckinMain1(VinCheck vinCheck) {
        return vinMapper.addCheckinMain1(vinCheck);
    }

    @Override
    public int addCheckinMain2(VinCheck vinCheck) {
        return vinMapper.addCheckinMain2(vinCheck);
    }

    @Override
    public int addCheckinShop1(VinCheck vinCheck) {
        return vinMapper.addCheckinShop1(vinCheck);
    }

    @Override
    public int addCheckinShop2(VinCheck vinCheck) {
        return vinMapper.addCheckinShop2(vinCheck);
    }

    @Override
    public int addCheckinShop3(VinCheck vinCheck) {
        return vinMapper.addCheckinShop3(vinCheck);
    }

    @Override
    public int addCheckinShop4(VinCheck vinCheck) {
        return vinMapper.addCheckinShop4(vinCheck);
    }

    @Override
    public int addCheckinShop5(VinCheck vinCheck) {
        return vinMapper.addCheckinShop5(vinCheck);
    }

    @Override
    public int addCheckinShop6(VinCheck vinCheck) {
        return vinMapper.addCheckinShop6(vinCheck);
    }

    @Override
    public int addCheckinShop7(VinCheck vinCheck) {
        return vinMapper.addCheckinShop7(vinCheck);
    }

    @Override
    public List<VinCheck> queryCheckinMain1(String category) {
        return vinMapper.queryCheckinMain1(category);
    }

    @Override
    public List<VinCheck> queryCheckinMain2(String category) {
        return vinMapper.queryCheckinMain2(category);
    }

    @Override
    public List<VinCheck> queryCheckinShop1(String category) {
        return vinMapper.queryCheckinShop1(category);
    }

    @Override
    public List<VinCheck> queryCheckinShop2(String category) {
        return vinMapper.queryCheckinShop2(category);
    }

    @Override
    public List<VinCheck> queryCheckinShop3(String category) {
        return vinMapper.queryCheckinShop3(category);
    }

    @Override
    public List<VinCheck> queryCheckinShop4(String category) {
        return vinMapper.queryCheckinShop4(category);
    }

    @Override
    public List<VinCheck> queryCheckinShop5(String category) {
        return vinMapper.queryCheckinShop5(category);
    }

    @Override
    public List<VinCheck> queryCheckinShop6(String category) {
        return vinMapper.queryCheckinShop6(category);
    }

    @Override
    public List<VinCheck> queryCheckinShop7(String category) {
        return vinMapper.queryCheckinShop7(category);
    }

    @Override
    public List<VinCheck> queryCheckwithTimeinMain1(String category, String time) {
        return vinMapper.queryCheckwithTimeinMain1(category,time);
    }

    @Override
    public List<VinCheck> queryCheckwithTimeinMain2(String category, String time) {
        return vinMapper.queryCheckwithTimeinMain2(category,time);
    }

    @Override
    public List<VinCheck> queryCheckwithTimeinShop1(String category, String time) {
        return vinMapper.queryCheckwithTimeinShop1(category,time);
    }

    @Override
    public List<VinCheck> queryCheckwithTimeinShop2(String category, String time) {
        return vinMapper.queryCheckwithTimeinShop2(category,time);
    }

    @Override
    public List<VinCheck> queryCheckwithTimeinShop3(String category, String time) {
        return vinMapper.queryCheckwithTimeinShop3(category,time);
    }

    @Override
    public List<VinCheck> queryCheckwithTimeinShop4(String category, String time) {
        return vinMapper.queryCheckwithTimeinShop4(category,time);
    }

    @Override
    public List<VinCheck> queryCheckwithTimeinShop5(String category, String time) {
        return vinMapper.queryCheckwithTimeinShop5(category,time);
    }

    @Override
    public List<VinCheck> queryCheckwithTimeinShop6(String category, String time) {
        return vinMapper.queryCheckwithTimeinShop6(category,time);
    }

    @Override
    public List<VinCheck> queryCheckwithTimeinShop7(String category, String time) {
        return vinMapper.queryCheckwithTimeinShop7(category,time);
    }

    @Override
    public List<VinCheck> queryCheckwithTimeandIdinMain1(String category, String time, String id) {
        return vinMapper.queryCheckwithTimeandIdinMain1(category,time,id);
    }

    @Override
    public List<VinCheck> queryCheckwithTimeandIdinMain2(String category, String time, String id) {
        return vinMapper.queryCheckwithTimeandIdinMain2(category,time,id);
    }

    @Override
    public List<VinCheck> queryCheckwithTimeandIdinShop1(String category, String time, String id) {
        return vinMapper.queryCheckwithTimeandIdinShop1(category,time,id);
    }

    @Override
    public List<VinCheck> queryCheckwithTimeandIdinShop2(String category, String time, String id) {
        return vinMapper.queryCheckwithTimeandIdinShop2(category,time,id);
    }

    @Override
    public List<VinCheck> queryCheckwithTimeandIdinShop3(String category, String time, String id) {
        return vinMapper.queryCheckwithTimeandIdinShop3(category,time,id);
    }

    @Override
    public List<VinCheck> queryCheckwithTimeandIdinShop4(String category, String time, String id) {
        return vinMapper.queryCheckwithTimeandIdinShop4(category,time,id);
    }

    @Override
    public List<VinCheck> queryCheckwithTimeandIdinShop5(String category, String time, String id) {
        return vinMapper.queryCheckwithTimeandIdinShop5(category,time,id);
    }

    @Override
    public List<VinCheck> queryCheckwithTimeandIdinShop6(String category, String time, String id) {
        return vinMapper.queryCheckwithTimeandIdinShop6(category,time,id);
    }

    @Override
    public List<VinCheck> queryCheckwithTimeandIdinShop7(String category, String time, String id) {
        return vinMapper.queryCheckwithTimeandIdinShop7(category,time,id);
    }

    @Override
    public int updateCheckinMain1byid(VinCheck vinCheck) {
        return vinMapper.updateCheckinMain1byid(vinCheck);
    }

    @Override
    public int updateCheckinMain2byid(VinCheck vinCheck) {
        return vinMapper.updateCheckinMain2byid(vinCheck);
    }

    @Override
    public int updateCheckinShop1byid(VinCheck vinCheck) {
        return vinMapper.updateCheckinShop1byid(vinCheck);
    }

    @Override
    public int updateCheckinShop2byid(VinCheck vinCheck) {
        return vinMapper.updateCheckinShop2byid(vinCheck);
    }

    @Override
    public int updateCheckinShop3byid(VinCheck vinCheck) {
        return vinMapper.updateCheckinShop3byid(vinCheck);
    }

    @Override
    public int updateCheckinShop4byid(VinCheck vinCheck) {
        return vinMapper.updateCheckinShop4byid(vinCheck);
    }

    @Override
    public int updateCheckinShop5byid(VinCheck vinCheck) {
        return vinMapper.updateCheckinShop5byid(vinCheck);
    }

    @Override
    public int updateCheckinShop6byid(VinCheck vinCheck) {
        return vinMapper.updateCheckinShop6byid(vinCheck);
    }

    @Override
    public int updateCheckinShop7byid(VinCheck vinCheck) {
        return vinMapper.updateCheckinShop7byid(vinCheck);
    }

    @Override
    public List<VinCheck> queryCheckinMain1byID(String id) {
        return vinMapper.queryCheckinMain1byID(id);
    }

    @Override
    public List<VinCheck> queryCheckinMain2byID(String id) {
        return vinMapper.queryCheckinMain2byID(id);
    }

    @Override
    public List<VinCheck> queryCheckinShop1byID(String id) {
        return vinMapper.queryCheckinShop1byID(id);
    }

    @Override
    public List<VinCheck> queryCheckinShop2byID(String id) {
        return vinMapper.queryCheckinShop2byID(id);
    }

    @Override
    public List<VinCheck> queryCheckinShop3byID(String id) {
        return vinMapper.queryCheckinShop3byID(id);
    }

    @Override
    public List<VinCheck> queryCheckinShop4byID(String id) {
        return vinMapper.queryCheckinShop4byID(id);
    }

    @Override
    public List<VinCheck> queryCheckinShop5byID(String id) {
        return vinMapper.queryCheckinShop5byID(id);
    }

    @Override
    public List<VinCheck> queryCheckinShop6byID(String id) {
        return vinMapper.queryCheckinShop6byID(id);
    }

    @Override
    public List<VinCheck> queryCheckinShop7byID(String id) {
        return vinMapper.queryCheckinShop7byID(id);
    }

    @Override
    public List<VinItemSimple> querySumitemCountbytimeinMain1(String time) {
        return vinMapper.querySumitemCountbytimeinMain1(time);
    }

    @Override
    public List<VinItemSimple> querySumitemCountbytimeinMain2(String time) {
        return vinMapper.querySumitemCountbytimeinMain2(time);
    }

    @Override
    public List<VinItemSimple> querySumitemCountbytimeinShop1(String time) {
        return vinMapper.querySumitemCountbytimeinShop1(time);
    }

    @Override
    public List<VinItemSimple> querySumitemCountbytimeinShop2(String time) {
        return vinMapper.querySumitemCountbytimeinShop2(time);
    }

    @Override
    public List<VinItemSimple> querySumitemCountbytimeinShop3(String time) {
        return vinMapper.querySumitemCountbytimeinShop3(time);
    }

    @Override
    public List<VinItemSimple> querySumitemCountbytimeinShop4(String time) {
        return vinMapper.querySumitemCountbytimeinShop4(time);
    }

    @Override
    public List<VinItemSimple> querySumitemCountbytimeinShop5(String time) {
        return vinMapper.querySumitemCountbytimeinShop5(time);
    }

    @Override
    public List<VinItemSimple> querySumitemCountbytimeinShop6(String time) {
        return vinMapper.querySumitemCountbytimeinShop6(time);
    }

    @Override
    public List<VinItemSimple> querySumitemCountbytimeinShop7(String time) {
        return vinMapper.querySumitemCountbytimeinShop7(time);
    }

    @Override
    @CacheEvict(value = { "cutelittlepiggyCache" },key="'ifAlertinMain1List'")
    public int addSumitemCountinMain1(VinAlert vinAlert) {
        return vinMapper.addSumitemCountinMain1(vinAlert);
    }

    @Override
    @CacheEvict(value = { "cutelittlepiggyCache" },key="'ifAlertinMain2List'")
    public int addSumitemCountinMain2(VinAlert vinAlert) {
        return vinMapper.addSumitemCountinMain2(vinAlert);
    }

    @Override
    @CacheEvict(value = { "cutelittlepiggyCache" },key="'ifAlertinShop1List'")
    public int addSumitemCountinShop1(VinAlert vinAlert) {
        return vinMapper.addSumitemCountinShop1(vinAlert);
    }

    @Override
    @CacheEvict(value = { "cutelittlepiggyCache" },key="'ifAlertinShop2List'")
    public int addSumitemCountinShop2(VinAlert vinAlert) {
        return vinMapper.addSumitemCountinShop2(vinAlert);
    }

    @Override
    @CacheEvict(value = { "cutelittlepiggyCache" },key="'ifAlertinShop3List'")
    public int addSumitemCountinShop3(VinAlert vinAlert) {
        return vinMapper.addSumitemCountinShop3(vinAlert);
    }

    @Override
    @CacheEvict(value = { "cutelittlepiggyCache" },key="'ifAlertinShop4List'")
    public int addSumitemCountinShop4(VinAlert vinAlert) {
        return vinMapper.addSumitemCountinShop4(vinAlert);
    }

    @Override
    @CacheEvict(value = { "cutelittlepiggyCache" },key="'ifAlertinShop5List'")
    public int addSumitemCountinShop5(VinAlert vinAlert) {
        return vinMapper.addSumitemCountinShop5(vinAlert);
    }

    @Override
    @CacheEvict(value = { "cutelittlepiggyCache" },key="'ifAlertinShop6List'")
    public int addSumitemCountinShop6(VinAlert vinAlert) {
        return vinMapper.addSumitemCountinShop6(vinAlert);
    }

    @Override
    @CacheEvict(value = { "cutelittlepiggyCache" },key="'ifAlertinShop7List'")
    public int addSumitemCountinShop7(VinAlert vinAlert) {
        return vinMapper.addSumitemCountinShop7(vinAlert);
    }

    @Override
    public List<VinAlert> queryifAlertinMain1(String time) {
        return vinMapper.queryifAlertinMain1(time);
    }

    @Override
    public List<VinAlert> queryifAlertinMain2(String time) {
        return vinMapper.queryifAlertinMain2(time);
    }

    @Override
    public List<VinAlert> queryifAlertinShop1(String time) {
        return vinMapper.queryifAlertinShop1(time);
    }

    @Override
    public List<VinAlert> queryifAlertinShop2(String time) {
        return vinMapper.queryifAlertinShop2(time);
    }

    @Override
    public List<VinAlert> queryifAlertinShop3(String time) {
        return vinMapper.queryifAlertinShop3(time);
    }

    @Override
    public List<VinAlert> queryifAlertinShop4(String time) {
        return vinMapper.queryifAlertinShop4(time);
    }

    @Override
    public List<VinAlert> queryifAlertinShop5(String time) {
        return vinMapper.queryifAlertinShop5(time);
    }

    @Override
    public List<VinAlert> queryifAlertinShop6(String time) {
        return vinMapper.queryifAlertinShop6(time);
    }

    @Override
    public List<VinAlert> queryifAlertinShop7(String time) {
        return vinMapper.queryifAlertinShop7(time);
    }

    @Override
    public VinLog queryLoginmain1byItemid(String id) {
        return vinMapper.queryLoginmain1byItemid(id);
    }

    @Override
    public VinLog queryLoginmain2byItemid(String id) {
        return vinMapper.queryLoginmain2byItemid(id);
    }

    @Override
    public VinLog queryLoginshop1byItemid(String id) {
        return vinMapper.queryLoginshop1byItemid(id);
    }

    @Override
    public VinLog queryLoginshop2byItemid(String id) {
        return vinMapper.queryLoginshop2byItemid(id);
    }

    @Override
    public VinLog queryLoginshop3byItemid(String id) {
        return vinMapper.queryLoginshop3byItemid(id);
    }

    @Override
    public VinLog queryLoginshop4byItemid(String id) {
        return vinMapper.queryLoginshop4byItemid(id);
    }

    @Override
    public VinLog queryLoginshop5byItemid(String id) {
        return vinMapper.queryLoginshop5byItemid(id);
    }

    @Override
    public VinLog queryLoginshop6byItemid(String id) {
        return vinMapper.queryLoginshop6byItemid(id);
    }

    @Override
    public VinLog queryLoginshop7byItemid(String id) {
        return vinMapper.queryLoginshop7byItemid(id);
    }

    @Override
    public List<VinLog> queryAllLoginmain1byItemid(String id) {
        return vinMapper.queryAllLoginmain1byItemid(id);
    }

    @Override
    public List<VinLog> queryAllLoginmain2byItemid(String id) {
        return vinMapper.queryAllLoginmain2byItemid(id);
    }

    @Override
    public List<VinLog> queryAllLoginshop1byItemid(String id) {
        return vinMapper.queryAllLoginshop1byItemid(id);
    }

    @Override
    public List<VinLog> queryAllLoginshop2byItemid(String id) {
        return vinMapper.queryAllLoginshop2byItemid(id);
    }

    @Override
    public List<VinLog> queryAllLoginshop3byItemid(String id) {
        return vinMapper.queryAllLoginshop3byItemid(id);
    }

    @Override
    public List<VinLog> queryAllLoginshop4byItemid(String id) {
        return vinMapper.queryAllLoginshop4byItemid(id);
    }

    @Override
    public List<VinLog> queryAllLoginshop5byItemid(String id) {
        return vinMapper.queryAllLoginshop5byItemid(id);
    }

    @Override
    public List<VinLog> queryAllLoginshop6byItemid(String id) {
        return vinMapper.queryAllLoginshop6byItemid(id);
    }

    @Override
    public List<VinLog> queryAllLoginshop7byItemid(String id) {
        return vinMapper.queryAllLoginshop7byItemid(id);
    }

    @Override
    public int updateItemNameAllLogbyidinMain1(VinLog vinLog) {
        return vinMapper.updateItemNameAllLogbyidinMain1(vinLog);
    }

    @Override
    public int updateItemNameAllLogbyidinMain2(VinLog vinLog) {
        return vinMapper.updateItemNameAllLogbyidinMain2(vinLog);
    }

    @Override
    public int updateItemNameAllLogbyidinShop1(VinLog vinLog) {
        return vinMapper.updateItemNameAllLogbyidinShop1(vinLog);
    }

    @Override
    public int updateItemNameAllLogbyidinShop2(VinLog vinLog) {
        return vinMapper.updateItemNameAllLogbyidinShop2(vinLog);
    }

    @Override
    public int updateItemNameAllLogbyidinShop3(VinLog vinLog) {
        return vinMapper.updateItemNameAllLogbyidinShop3(vinLog);
    }

    @Override
    public int updateItemNameAllLogbyidinShop4(VinLog vinLog) {
        return vinMapper.updateItemNameAllLogbyidinShop4(vinLog);
    }

    @Override
    public int updateItemNameAllLogbyidinShop5(VinLog vinLog) {
        return vinMapper.updateItemNameAllLogbyidinShop5(vinLog);
    }

    @Override
    public int updateItemNameAllLogbyidinShop6(VinLog vinLog) {
        return vinMapper.updateItemNameAllLogbyidinShop6(vinLog);
    }

    @Override
    public int updateItemNameAllLogbyidinShop7(VinLog vinLog) {
        return vinMapper.updateItemNameAllLogbyidinShop7(vinLog);
    }

    //main0
    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'IteminMain0List'")
    public int addIteminMain0(VinItem items) {
        return vinMapper.addIteminMain0(items);
    }
    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'FoodinMain0List'")
    public int addFoodinMain0(VinItem items) {
        return vinMapper.addFoodinMain0(items);
    }
    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'commercialIteminMain0List'")
    public int addcommercialIteminMain0(VinItem items) {
        return vinMapper.addcommercialIteminMain0(items);
    }
    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'othersinMain0List'")
    public int addothersinMain0(VinItem items) {
        return vinMapper.addothersinMain0(items);
    }
    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'SmallIteminMain0List'")
    public int addSmallIteminMain0(VinItem items) {
        return vinMapper.addSmallIteminMain0(items);
    }
    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'IteminMain0List'")
    public int deleteIteminMain0byId(String id) {
        return vinMapper.deleteIteminMain0byId(id);
    }
    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'SmallIteminMain0List'")
    public int deleteSmallIteminMain0byId(String id) {
        return vinMapper.deleteSmallIteminMain0byId(id);
    }
    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'FoodinMain0List'")
    public int deleteFoodinMain0byId(String id) {
        return vinMapper.deleteFoodinMain0byId(id);
    }
    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'commercialIteminMain0List'")
    public int deletecommercialIteminMain0byId(String id) {
        return vinMapper.deletecommercialIteminMain0byId(id);
    }
    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'othersinMain0List'")
    public int deleteothersinMain0byId(String id) {
        return vinMapper.deleteothersinMain0byId(id);
    }
    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'IteminMain0List'")
    public int updateIteminMain0(VinItem items) {
        return vinMapper.updateIteminMain0(items);
    }
    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'SmallIteminMain0List'")
    public int updateSmallIteminMain0(VinItem items) {
        return vinMapper.updateSmallIteminMain0(items);
    }
    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'FoodinMain0List'")
    public int updateFoodinMain0(VinItem items) {
        return vinMapper.updateFoodinMain0(items);
    }
    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'commercialIteminMain0List'")
    public int updatecommercialIteminMain0(VinItem items) {
        return vinMapper.updatecommercialIteminMain0(items);
    }
    @Override
//    @CacheEvict(value = { "cutelittlepiggyCache" },key="'othersinMain0List'")
    public int updateothersinMain0(VinItem items) {
        return vinMapper.updateothersinMain0(items);
    }
    @Override
    public int sendIteminMain0(VinItem items) {
        return vinMapper.sendIteminMain0(items);
    }
    @Override
    public int sendSmallIteminMain0(VinItem items) {
        return vinMapper.sendSmallIteminMain0(items);
    }
    @Override
    public int sendFoodinMain0(VinItem items) {
        return vinMapper.sendFoodinMain0(items);
    }
    @Override
    public int sendcommercialIteminMain0(VinItem items) {
        return vinMapper.sendcommercialIteminMain0(items);
    }
    @Override
    public int sendothersinMain0(VinItem items) {
        return vinMapper.sendothersinMain0(items);
    }
    @Override
    public VinItem queryIteminMain0byId(String id) {
        return vinMapper.queryIteminMain0byId(id);
    }
    @Override
    public VinItem querySmallIteminMain0byId(String id) {
        return vinMapper.querySmallIteminMain0byId(id);
    }
    @Override
    public VinItem queryFoodinMain0byId(String id) {
        return vinMapper.queryFoodinMain0byId(id);
    }
    @Override
    public VinItem querycommercialIteminMain0byId(String id) {
        return vinMapper.querycommercialIteminMain0byId(id);
    }
    @Override
    public VinItem queryothersinMain0byId(String id) {
        return vinMapper.queryothersinMain0byId(id);
    }
    @Override
    public int queryItemNuminMain0byId(String id) {
        return vinMapper.queryItemNuminMain0byId(id);
    }
    @Override
    public int querySmallItemNuminMain0byId(String id) {
        return vinMapper.querySmallItemNuminMain0byId(id);
    }
    @Override
    public int queryFoodNuminMain0byId(String id) {
        return vinMapper.queryFoodNuminMain0byId(id);
    }
    @Override
    public int querycommercialItemNuminMain0byId(String id) {
        return vinMapper.querycommercialItemNuminMain0byId(id);
    }
    @Override
    public int queryothersNuminMain0byId(String id) {
        return vinMapper.queryothersNuminMain0byId(id);
    }
    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'IteminMain0List'")
    public List<VinItem> queryAllIteminMain0() {
        return vinMapper.queryAllIteminMain0();
    }
    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'SmallIteminMain0List'")
    public List<VinItem> queryAllSmallIteminMain0() {
        return vinMapper.queryAllSmallIteminMain0();
    }
    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'FoodinMain0List'")
    public List<VinItem> queryAllFoodinMain0() {
        return vinMapper.queryAllFoodinMain0();
    }
    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'commercialIteminMain0List'")
    public List<VinItem> queryAllcommercialIteminMain0() {
        return vinMapper.queryAllcommercialIteminMain0();
    }
    @Override
//    @Cacheable(value = { "cutelittlepiggyCache" },key="'othersinMain0List'")
    public List<VinItem> queryAllothersinMain0() {
        return vinMapper.queryAllothersinMain0();
    }
//    @Override
//    public VinItem queryIteminMain0ByName(String itemName) {
//        return vinMapper.queryIteminMain0ByName(itemName);
//    }
//    @Override
//    public VinItem querySmallIteminMain0ByName(String itemName) {
//        return vinMapper.querySmallIteminMain0ByName(itemName);
//    }
//    @Override
//    public VinItem queryFoodinMain0ByName(String itemName) {
//        return vinMapper.queryFoodinMain0ByName(itemName);
//    }
//    @Override
//    public VinItem querycommercialIteminMain0ByName(String itemName) {
//        return vinMapper.querycommercialIteminMain0ByName(itemName);
//    }
//    @Override
//    public VinItem queryothersinMain0ByName(String itemName) {
//        return vinMapper.queryothersinMain0ByName(itemName);
//    }
////    @Override
////    public VinItem queryItemNuminMain0byID(String id) {
////        return vinMapper.queryItemNuminMain0byID(id);
////    }
//    @Override
//    public VinItem querySmallItemNuminMain0byID(String id) {
//        return vinMapper.querySmallItemNuminMain0byID(id);
//    }
//    @Override
//    public VinItem queryFoodNuminMain0byID(String id) {
//        return vinMapper.queryFoodNuminMain0byID(id);
//    }
//    @Override
//    public VinItem querycommercialItemNuminMain0byID(String id) {
//        return vinMapper.querycommercialItemNuminMain0byID(id);
//    }
//    @Override
//    public VinItem queryothersNuminMain0byID(String id) {
//        return vinMapper.queryothersNuminMain0byID(id);
//    }
    @Override
    public int ifItemExistinMain0(String id) {
        return vinMapper.ifItemExistinMain0(id);
    }
    @Override
    public int ifSmallItemExistinMain0(String id) {
        return vinMapper.ifSmallItemExistinMain0(id);
    }
    @Override
    public int ifFoodExistinMain0(String id) {
        return vinMapper.ifFoodExistinMain0(id);
    }
    @Override
    public int ifcommercialItemExistinMain0(String id) {
        return vinMapper.ifcommercialItemExistinMain0(id);
    }
    @Override
    public int ifothersExistinMain0(String id) {
        return vinMapper.ifothersExistinMain0(id);
    }
    @Override
    public int updateItembySendfromMain0(VinItem items) {
        return vinMapper.updateItembySendfromMain0(items);
    }
    @Override
    public int updateSmallItembySendfromMain0(VinItem items) {
        return vinMapper.updateSmallItembySendfromMain0(items);
    }
    @Override
    public int updateFoodbySendfromMain0(VinItem items) {
        return vinMapper.updateFoodbySendfromMain0(items);
    }
    @Override
    public int updatecommercialItembySendfromMain0(VinItem items) {
        return vinMapper.updatecommercialItembySendfromMain0(items);
    }
    @Override
    public int updateothersbySendfromMain0(VinItem items) {
        return vinMapper.updateothersbySendfromMain0(items);
    }
    @Override
    public int addloginMain0(VinLog log) {
        return vinMapper.addloginMain0(log);
    }
    @Override
    public List<VinLog> queryCategoryLoginMain0(String category) {
        return vinMapper.queryCategoryLoginMain0(category);
    }
    @Override
    public List<VinLog> queryCategoryandIfCompleteLoginMain0(String category, boolean ifComplete) {
        return vinMapper.queryCategoryandIfCompleteLoginMain0(category,ifComplete);
    }
    @Override
    public List<VinLog> queryCategoryReceiveinMain0(String category) {
        return vinMapper.queryCategoryReceiveinMain0(category);
    }
    @Override
    public int countCategoryReceiveinMain0(String category) {
        return vinMapper.countCategoryReceiveinMain0(category);
    }
    @Override
    public List<VinLog> queryCategoryConfirminMain0(String category, String action, String action2) {
        return vinMapper.queryCategoryConfirminMain0(category,action,action2);
    }
    @Override
    public int countCategoryConfirminMain0(String category, String action, String action2) {
        return vinMapper.countCategoryConfirminMain0(category,action,action2);
    }
    @Override
    public VinLog queryLoginmain0byid(String logid) {
        return vinMapper.queryLoginmain0byid(logid);
    }
    @Override
    public int updateLoginmain0byid(VinLog vinLog) {
        return vinMapper.updateLoginmain0byid(vinLog);
    }
    @Override
    public int deleteLoginMain0byLogid(String logid) {
        return vinMapper.deleteLoginMain0byLogid(logid);
    }
    @Override
    public int addCheckinMain0(VinCheck vinCheck) {
        return vinMapper.addCheckinMain0(vinCheck);
    }
    @Override
    public List<VinCheck> queryCheckinMain0(String category) {
        return vinMapper.queryCheckinMain0(category);
    }
    @Override
    public List<VinCheck> queryCheckwithTimeinMain0(String category, String time) {
        return vinMapper.queryCheckwithTimeinMain0(category,time);
    }
    @Override
    public List<VinCheck> queryCheckwithTimeandIdinMain0(String category, String time, String id) {
        return vinMapper.queryCheckwithTimeandIdinMain0(category,time,id);
    }
    @Override
    public int updateCheckinMain0byid(VinCheck vinCheck) {
        return vinMapper.updateCheckinMain0byid(vinCheck);
    }
    @Override
    public List<VinCheck> queryCheckinMain0byID(String id) {
        return vinMapper.queryCheckinMain0byID(id);
    }
    @Override
    public List<VinItemSimple> querySumitemCountbytimeinMain0(String time) {
        return vinMapper.querySumitemCountbytimeinMain0(time);
    }
    @Override
    @CacheEvict(value = { "cutelittlepiggyCache" },key="'ifAlertinMain0List'")
    public int addSumitemCountinMain0(VinAlert vinAlert) {
        return vinMapper.addSumitemCountinMain0(vinAlert);
    }
    @Override
    public List<VinAlert> queryifAlertinMain0(String time) {
        return vinMapper.queryifAlertinMain0(time);
    }
    @Override
    public VinLog queryLoginmain0byItemid(String id) {
        return vinMapper.queryLoginmain0byItemid(id);
    }
    @Override
    public List<VinLog> queryAllLoginmain0byItemid(String id) {
        return vinMapper.queryAllLoginmain0byItemid(id);
    }
    @Override
    public int updateItemNameAllLogbyidinMain0(VinLog vinLog) {
        return vinMapper.updateItemNameAllLogbyidinMain0(vinLog);
    }

    //shop8
    @Override
    public int addIteminShop8(VinItem items) {
        return vinMapper.addIteminShop8(items);
    }
    @Override
    public int addFoodinShop8(VinItem items) {
        return vinMapper.addFoodinShop8(items);
    }
    @Override
    public int addcommercialIteminShop8(VinItem items) {
        return vinMapper.addcommercialIteminShop8(items);
    }
    @Override
    public int addothersinShop8(VinItem items) {
        return vinMapper.addothersinShop8(items);
    }
    @Override
    public int addSmallIteminShop8(VinItem items) {
        return vinMapper.addSmallIteminShop8(items);
    }
    @Override
    public int deleteIteminShop8byId(String id) {
        return vinMapper.deleteIteminShop8byId(id);
    }
    @Override
    public int deleteSmallIteminShop8byId(String id) {
        return vinMapper.deleteSmallIteminShop8byId(id);
    }
    @Override
    public int deleteFoodinShop8byId(String id) {
        return vinMapper.deleteFoodinShop8byId(id);
    }
    @Override
    public int deletecommercialIteminShop8byId(String id) {
        return vinMapper.deletecommercialIteminShop8byId(id);
    }
    @Override
    public int deleteothersinShop8byId(String id) {
        return vinMapper.deleteothersinShop8byId(id);
    }
    @Override
    public int updateIteminShop8(VinItem items) {
        return vinMapper.updateIteminShop8(items);
    }
    @Override
    public int updateSmallIteminShop8(VinItem items) {
        return vinMapper.updateSmallIteminShop8(items);
    }
    @Override
    public int updateFoodinShop8(VinItem items) {
        return vinMapper.updateFoodinShop8(items);
    }
    @Override
    public int updatecommercialIteminShop8(VinItem items) {
        return vinMapper.updatecommercialIteminShop8(items);
    }
    @Override
    public int updateothersinShop8(VinItem items) {
        return vinMapper.updateothersinShop8(items);
    }
    @Override
    public int sendIteminShop8(VinItem items) {
        return vinMapper.sendIteminShop8(items);
    }
    @Override
    public int sendSmallIteminShop8(VinItem items) {
        return vinMapper.sendSmallIteminShop8(items);
    }
    @Override
    public int sendFoodinShop8(VinItem items) {
        return vinMapper.sendFoodinShop8(items);
    }
    @Override
    public int sendcommercialIteminShop8(VinItem items) {
        return vinMapper.sendcommercialIteminShop8(items);
    }
    @Override
    public int sendothersinShop8(VinItem items) {
        return vinMapper.sendothersinShop8(items);
    }
    @Override
    public VinItem queryIteminShop8byId(String id) {
        return vinMapper.queryIteminShop8byId(id);
    }
    @Override
    public VinItem querySmallIteminShop8byId(String id) {
        return vinMapper.querySmallIteminShop8byId(id);
    }
    @Override
    public VinItem queryFoodinShop8byId(String id) {
        return vinMapper.queryFoodinShop8byId(id);
    }
    @Override
    public VinItem querycommercialIteminShop8byId(String id) {
        return vinMapper.querycommercialIteminShop8byId(id);
    }
    @Override
    public VinItem queryothersinShop8byId(String id) {
        return vinMapper.queryothersinShop8byId(id);
    }
    @Override
    public int queryItemNuminShop8byId(String id) {
        return vinMapper.queryItemNuminShop8byId(id);
    }
    @Override
    public int querySmallItemNuminShop8byId(String id) {
        return vinMapper.querySmallItemNuminShop8byId(id);
    }
    @Override
    public int queryFoodNuminShop8byId(String id) {
        return vinMapper.queryFoodNuminShop8byId(id);
    }
    @Override
    public int querycommercialItemNuminShop8byId(String id) {
        return vinMapper.querycommercialItemNuminShop8byId(id);
    }
    @Override
    public int queryothersNuminShop8byId(String id) {
        return vinMapper.queryothersNuminShop8byId(id);
    }
    @Override
    public List<VinItem> queryAllIteminShop8() {
        return vinMapper.queryAllIteminShop8();
    }
    @Override
    public List<VinItem> queryAllSmallIteminShop8() {
        return vinMapper.queryAllSmallIteminShop8();
    }
    @Override
    public List<VinItem> queryAllFoodinShop8() {
        return vinMapper.queryAllFoodinShop8();
    }
    @Override
    public List<VinItem> queryAllcommercialIteminShop8() {
        return vinMapper.queryAllcommercialIteminShop8();
    }
    @Override
    public List<VinItem> queryAllothersinShop8() {
        return vinMapper.queryAllothersinShop8();
    }
//    @Override
//    public VinItem queryIteminShop8ByName(String itemName) {
//        return vinMapper.queryIteminShop8ByName(itemName);
//    }
//    @Override
//    public VinItem querySmallIteminShop8ByName(String itemName) {
//        return vinMapper.querySmallIteminShop8ByName(itemName);
//    }
//    @Override
//    public VinItem queryFoodinShop8ByName(String itemName) {
//        return vinMapper.queryFoodinShop8ByName(itemName);
//    }
//    @Override
//    public VinItem querycommercialIteminShop8ByName(String itemName) {
//        return vinMapper.querycommercialIteminShop8ByName(itemName);
//    }
//    @Override
//    public VinItem queryothersinShop8ByName(String itemName) {
//        return vinMapper.queryothersinShop8ByName(itemName);
//    }
//    @Override
//    public VinItem queryItemNuminShop8byID(String id) {
//        return vinMapper.queryItemNuminShop8byID(id);
//    }
//    @Override
//    public VinItem querySmallItemNuminShop8byID(String id) {
//        return vinMapper.querySmallItemNuminShop8byID(id);
//    }
//    @Override
//    public VinItem queryFoodNuminShop8byID(String id) {
//        return vinMapper.queryFoodNuminShop8byID(id);
//    }
//    @Override
//    public VinItem querycommercialItemNuminShop8byID(String id) {
//        return vinMapper.querycommercialItemNuminShop8byID(id);
//    }
//    @Override
//    public VinItem queryothersNuminShop8byID(String id) {
//        return vinMapper.queryothersNuminShop8byID(id);
//    }
    @Override
    public int ifItemExistinShop8(String id) {
        return vinMapper.ifItemExistinShop8(id);
    }
    @Override
    public int ifSmallItemExistinShop8(String id) {
        return vinMapper.ifSmallItemExistinShop8(id);
    }
    @Override
    public int ifFoodExistinShop8(String id) {
        return vinMapper.ifFoodExistinShop8(id);
    }
    @Override
    public int ifcommercialItemExistinShop8(String id) {
        return vinMapper.ifcommercialItemExistinShop8(id);
    }
    @Override
    public int ifothersExistinShop8(String id) {
        return vinMapper.ifothersExistinShop8(id);
    }
    @Override
    public int updateItembySendfromShop8(VinItem items) {
        return vinMapper.updateItembySendfromShop8(items);
    }
    @Override
    public int updateSmallItembySendfromShop8(VinItem items) {
        return vinMapper.updateSmallItembySendfromShop8(items);
    }
    @Override
    public int updateFoodbySendfromShop8(VinItem items) {
        return vinMapper.updateFoodbySendfromShop8(items);
    }
    @Override
    public int updatecommercialItembySendfromShop8(VinItem items) {
        return vinMapper.updatecommercialItembySendfromShop8(items);
    }
    @Override
    public int updateothersbySendfromShop8(VinItem items) {
        return vinMapper.updateothersbySendfromShop8(items);
    }
    @Override
    public int addloginShop8(VinLog log) {
        return vinMapper.addloginShop8(log);
    }
    @Override
    public List<VinLog> queryCategoryLoginShop8(String category) {
        return vinMapper.queryCategoryLoginShop8(category);
    }
    @Override
    public List<VinLog> queryCategoryandIfCompleteLoginShop8(String category, boolean ifComplete) {
        return vinMapper.queryCategoryandIfCompleteLoginShop8(category,ifComplete);
    }
    @Override
    public List<VinLog> queryCategoryReceiveinShop8(String category) {
        return vinMapper.queryCategoryReceiveinShop8(category);
    }
    @Override
    public int countCategoryReceiveinShop8(String category) {
        return vinMapper.countCategoryReceiveinShop8(category);
    }
    @Override
    public List<VinLog> queryCategoryConfirminShop8(String category, String action, String action2) {
        return vinMapper.queryCategoryConfirminShop8(category,action,action2);
    }
    @Override
    public int countCategoryConfirminShop8(String category, String action, String action2) {
        return vinMapper.countCategoryConfirminShop8(category,action,action2);
    }
    @Override
    public VinLog queryLoginshop8byid(String logid) {
        return vinMapper.queryLoginshop8byid(logid);
    }
    @Override
    public int updateLoginshop8byid(VinLog vinLog) {
        return vinMapper.updateLoginshop8byid(vinLog);
    }
    @Override
    public int deleteLoginShop8byLogid(String logid) {
        return vinMapper.deleteLoginShop8byLogid(logid);
    }
    @Override
    public int addCheckinShop8(VinCheck vinCheck) {
        return vinMapper.addCheckinShop8(vinCheck);
    }
    @Override
    public List<VinCheck> queryCheckinShop8(String category) {
        return vinMapper.queryCheckinShop8(category);
    }
    @Override
    public List<VinCheck> queryCheckwithTimeinShop8(String category, String time) {
        return vinMapper.queryCheckwithTimeinShop8(category,time);
    }
    @Override
    public List<VinCheck> queryCheckwithTimeandIdinShop8(String category, String time, String id) {
        return vinMapper.queryCheckwithTimeandIdinShop8(category,time,id);
    }
    @Override
    public int updateCheckinShop8byid(VinCheck vinCheck) {
        return vinMapper.updateCheckinShop8byid(vinCheck);
    }
    @Override
    public List<VinCheck> queryCheckinShop8byID(String id) {
        return vinMapper.queryCheckinShop8byID(id);
    }
    @Override
    public List<VinItemSimple> querySumitemCountbytimeinShop8(String time) {
        return vinMapper.querySumitemCountbytimeinShop8(time);
    }
    @Override
    @CacheEvict(value = { "cutelittlepiggyCache" },key="'ifAlertinShop8List'")
    public int addSumitemCountinShop8(VinAlert vinAlert) {
        return vinMapper.addSumitemCountinShop8(vinAlert);
    }
    @Override
    public List<VinAlert> queryifAlertinShop8(String time) {
        return vinMapper.queryifAlertinShop8(time);
    }
    @Override
    public VinLog queryLoginshop8byItemid(String id) {
        return vinMapper.queryLoginshop8byItemid(id);
    }
    @Override
    public List<VinLog> queryAllLoginshop8byItemid(String id) {
        return vinMapper.queryAllLoginshop8byItemid(id);
    }
    @Override
    public int updateItemNameAllLogbyidinShop8(VinLog vinLog) {
        return vinMapper.updateItemNameAllLogbyidinShop8(vinLog);
    }




    //shop9
    @Override
    public int addIteminShop9(VinItem items) {
        return vinMapper.addIteminShop9(items);
    }
    @Override
    public int addFoodinShop9(VinItem items) {
        return vinMapper.addFoodinShop9(items);
    }
    @Override
    public int addcommercialIteminShop9(VinItem items) {
        return vinMapper.addcommercialIteminShop9(items);
    }
    @Override
    public int addothersinShop9(VinItem items) {
        return vinMapper.addothersinShop9(items);
    }
    @Override
    public int addSmallIteminShop9(VinItem items) {
        return vinMapper.addSmallIteminShop9(items);
    }
    @Override
    public int deleteIteminShop9byId(String id) {
        return vinMapper.deleteIteminShop9byId(id);
    }
    @Override
    public int deleteSmallIteminShop9byId(String id) {
        return vinMapper.deleteSmallIteminShop9byId(id);
    }
    @Override
    public int deleteFoodinShop9byId(String id) {
        return vinMapper.deleteFoodinShop9byId(id);
    }
    @Override
    public int deletecommercialIteminShop9byId(String id) {
        return vinMapper.deletecommercialIteminShop9byId(id);
    }
    @Override
    public int deleteothersinShop9byId(String id) {
        return vinMapper.deleteothersinShop9byId(id);
    }
    @Override
    public int updateIteminShop9(VinItem items) {
        return vinMapper.updateIteminShop9(items);
    }
    @Override
    public int updateSmallIteminShop9(VinItem items) {
        return vinMapper.updateSmallIteminShop9(items);
    }
    @Override
    public int updateFoodinShop9(VinItem items) {
        return vinMapper.updateFoodinShop9(items);
    }
    @Override
    public int updatecommercialIteminShop9(VinItem items) {
        return vinMapper.updatecommercialIteminShop9(items);
    }
    @Override
    public int updateothersinShop9(VinItem items) {
        return vinMapper.updateothersinShop9(items);
    }
    @Override
    public int sendIteminShop9(VinItem items) {
        return vinMapper.sendIteminShop9(items);
    }
    @Override
    public int sendSmallIteminShop9(VinItem items) {
        return vinMapper.sendSmallIteminShop9(items);
    }
    @Override
    public int sendFoodinShop9(VinItem items) {
        return vinMapper.sendFoodinShop9(items);
    }
    @Override
    public int sendcommercialIteminShop9(VinItem items) {
        return vinMapper.sendcommercialIteminShop9(items);
    }
    @Override
    public int sendothersinShop9(VinItem items) {
        return vinMapper.sendothersinShop9(items);
    }
    @Override
    public VinItem queryIteminShop9byId(String id) {
        return vinMapper.queryIteminShop9byId(id);
    }
    @Override
    public VinItem querySmallIteminShop9byId(String id) {
        return vinMapper.querySmallIteminShop9byId(id);
    }
    @Override
    public VinItem queryFoodinShop9byId(String id) {
        return vinMapper.queryFoodinShop9byId(id);
    }
    @Override
    public VinItem querycommercialIteminShop9byId(String id) {
        return vinMapper.querycommercialIteminShop9byId(id);
    }
    @Override
    public VinItem queryothersinShop9byId(String id) {
        return vinMapper.queryothersinShop9byId(id);
    }
    @Override
    public int queryItemNuminShop9byId(String id) {
        return vinMapper.queryItemNuminShop9byId(id);
    }
    @Override
    public int querySmallItemNuminShop9byId(String id) {
        return vinMapper.querySmallItemNuminShop9byId(id);
    }
    @Override
    public int queryFoodNuminShop9byId(String id) {
        return vinMapper.queryFoodNuminShop9byId(id);
    }
    @Override
    public int querycommercialItemNuminShop9byId(String id) {
        return vinMapper.querycommercialItemNuminShop9byId(id);
    }
    @Override
    public int queryothersNuminShop9byId(String id) {
        return vinMapper.queryothersNuminShop9byId(id);
    }
    @Override
    public List<VinItem> queryAllIteminShop9() {
        return vinMapper.queryAllIteminShop9();
    }
    @Override
    public List<VinItem> queryAllSmallIteminShop9() {
        return vinMapper.queryAllSmallIteminShop9();
    }
    @Override
    public List<VinItem> queryAllFoodinShop9() {
        return vinMapper.queryAllFoodinShop9();
    }
    @Override
    public List<VinItem> queryAllcommercialIteminShop9() {
        return vinMapper.queryAllcommercialIteminShop9();
    }
    @Override
    public List<VinItem> queryAllothersinShop9() {
        return vinMapper.queryAllothersinShop9();
    }
//    @Override
//    public VinItem queryIteminShop9ByName(String itemName) {
//        return vinMapper.queryIteminShop9ByName(itemName);
//    }
//    @Override
//    public VinItem querySmallIteminShop9ByName(String itemName) {
//        return vinMapper.querySmallIteminShop9ByName(itemName);
//    }
//    @Override
//    public VinItem queryFoodinShop9ByName(String itemName) {
//        return vinMapper.queryFoodinShop9ByName(itemName);
//    }
//    @Override
//    public VinItem querycommercialIteminShop9ByName(String itemName) {
//        return vinMapper.querycommercialIteminShop9ByName(itemName);
//    }
//    @Override
//    public VinItem queryothersinShop9ByName(String itemName) {
//        return vinMapper.queryothersinShop9ByName(itemName);
//    }
//    @Override
//    public VinItem queryItemNuminShop9byID(String id) {
//        return vinMapper.queryItemNuminShop9byID(id);
//    }
//    @Override
//    public VinItem querySmallItemNuminShop9byID(String id) {
//        return vinMapper.querySmallItemNuminShop9byID(id);
//    }
//    @Override
//    public VinItem queryFoodNuminShop9byID(String id) {
//        return vinMapper.queryFoodNuminShop9byID(id);
//    }
//    @Override
//    public VinItem querycommercialItemNuminShop9byID(String id) {
//        return vinMapper.querycommercialItemNuminShop9byID(id);
//    }
//    @Override
//    public VinItem queryothersNuminShop9byID(String id) {
//        return vinMapper.queryothersNuminShop9byID(id);
//    }
    @Override
    public int ifItemExistinShop9(String id) {
        return vinMapper.ifItemExistinShop9(id);
    }
    @Override
    public int ifSmallItemExistinShop9(String id) {
        return vinMapper.ifSmallItemExistinShop9(id);
    }
    @Override
    public int ifFoodExistinShop9(String id) {
        return vinMapper.ifFoodExistinShop9(id);
    }
    @Override
    public int ifcommercialItemExistinShop9(String id) {
        return vinMapper.ifcommercialItemExistinShop9(id);
    }
    @Override
    public int ifothersExistinShop9(String id) {
        return vinMapper.ifothersExistinShop9(id);
    }
    @Override
    public int updateItembySendfromShop9(VinItem items) {
        return vinMapper.updateItembySendfromShop9(items);
    }
    @Override
    public int updateSmallItembySendfromShop9(VinItem items) {
        return vinMapper.updateSmallItembySendfromShop9(items);
    }
    @Override
    public int updateFoodbySendfromShop9(VinItem items) {
        return vinMapper.updateFoodbySendfromShop9(items);
    }
    @Override
    public int updatecommercialItembySendfromShop9(VinItem items) {
        return vinMapper.updatecommercialItembySendfromShop9(items);
    }
    @Override
    public int updateothersbySendfromShop9(VinItem items) {
        return vinMapper.updateothersbySendfromShop9(items);
    }
    @Override
    public int addloginShop9(VinLog log) {
        return vinMapper.addloginShop9(log);
    }
    @Override
    public List<VinLog> queryCategoryLoginShop9(String category) {
        return vinMapper.queryCategoryLoginShop9(category);
    }
    @Override
    public List<VinLog> queryCategoryandIfCompleteLoginShop9(String category, boolean ifComplete) {
        return vinMapper.queryCategoryandIfCompleteLoginShop9(category,ifComplete);
    }
    @Override
    public List<VinLog> queryCategoryReceiveinShop9(String category) {
        return vinMapper.queryCategoryReceiveinShop9(category);
    }
    @Override
    public int countCategoryReceiveinShop9(String category) {
        return vinMapper.countCategoryReceiveinShop9(category);
    }
    @Override
    public List<VinLog> queryCategoryConfirminShop9(String category, String action, String action2) {
        return vinMapper.queryCategoryConfirminShop9(category,action,action2);
    }
    @Override
    public int countCategoryConfirminShop9(String category, String action, String action2) {
        return vinMapper.countCategoryConfirminShop9(category,action,action2);
    }
    @Override
    public VinLog queryLoginshop9byid(String logid) {
        return vinMapper.queryLoginshop9byid(logid);
    }
    @Override
    public int updateLoginshop9byid(VinLog vinLog) {
        return vinMapper.updateLoginshop9byid(vinLog);
    }
    @Override
    public int deleteLoginShop9byLogid(String logid) {
        return vinMapper.deleteLoginShop9byLogid(logid);
    }
    @Override
    public int addCheckinShop9(VinCheck vinCheck) {
        return vinMapper.addCheckinShop9(vinCheck);
    }
    @Override
    public List<VinCheck> queryCheckinShop9(String category) {
        return vinMapper.queryCheckinShop9(category);
    }
    @Override
    public List<VinCheck> queryCheckwithTimeinShop9(String category, String time) {
        return vinMapper.queryCheckwithTimeinShop9(category,time);
    }
    @Override
    public List<VinCheck> queryCheckwithTimeandIdinShop9(String category, String time, String id) {
        return vinMapper.queryCheckwithTimeandIdinShop9(category,time,id);
    }
    @Override
    public int updateCheckinShop9byid(VinCheck vinCheck) {
        return vinMapper.updateCheckinShop9byid(vinCheck);
    }
    @Override
    public List<VinCheck> queryCheckinShop9byID(String id) {
        return vinMapper.queryCheckinShop9byID(id);
    }
    @Override
    public List<VinItemSimple> querySumitemCountbytimeinShop9(String time) {
        return vinMapper.querySumitemCountbytimeinShop9(time);
    }
    @Override
    @CacheEvict(value = { "cutelittlepiggyCache" },key="'ifAlertinShop9List'")
    public int addSumitemCountinShop9(VinAlert vinAlert) {
        return vinMapper.addSumitemCountinShop9(vinAlert);
    }
    @Override
    public List<VinAlert> queryifAlertinShop9(String time) {
        return vinMapper.queryifAlertinShop9(time);
    }
    @Override
    public VinLog queryLoginshop9byItemid(String id) {
        return vinMapper.queryLoginshop9byItemid(id);
    }
    @Override
    public List<VinLog> queryAllLoginshop9byItemid(String id) {
        return vinMapper.queryAllLoginshop9byItemid(id);
    }
    @Override
    public int updateItemNameAllLogbyidinShop9(VinLog vinLog) {
        return vinMapper.updateItemNameAllLogbyidinShop9(vinLog);
    }

    //shop10
    @Override
    public int addIteminShop10(VinItem items) {
        return vinMapper.addIteminShop10(items);
    }
    @Override
    public int addFoodinShop10(VinItem items) {
        return vinMapper.addFoodinShop10(items);
    }
    @Override
    public int addcommercialIteminShop10(VinItem items) {
        return vinMapper.addcommercialIteminShop10(items);
    }
    @Override
    public int addothersinShop10(VinItem items) {
        return vinMapper.addothersinShop10(items);
    }
    @Override
    public int addSmallIteminShop10(VinItem items) {
        return vinMapper.addSmallIteminShop10(items);
    }
    @Override
    public int deleteIteminShop10byId(String id) {
        return vinMapper.deleteIteminShop10byId(id);
    }
    @Override
    public int deleteSmallIteminShop10byId(String id) {
        return vinMapper.deleteSmallIteminShop10byId(id);
    }
    @Override
    public int deleteFoodinShop10byId(String id) {
        return vinMapper.deleteFoodinShop10byId(id);
    }
    @Override
    public int deletecommercialIteminShop10byId(String id) {
        return vinMapper.deletecommercialIteminShop10byId(id);
    }
    @Override
    public int deleteothersinShop10byId(String id) {
        return vinMapper.deleteothersinShop10byId(id);
    }
    @Override
    public int updateIteminShop10(VinItem items) {
        return vinMapper.updateIteminShop10(items);
    }
    @Override
    public int updateSmallIteminShop10(VinItem items) {
        return vinMapper.updateSmallIteminShop10(items);
    }
    @Override
    public int updateFoodinShop10(VinItem items) {
        return vinMapper.updateFoodinShop10(items);
    }
    @Override
    public int updatecommercialIteminShop10(VinItem items) {
        return vinMapper.updatecommercialIteminShop10(items);
    }
    @Override
    public int updateothersinShop10(VinItem items) {
        return vinMapper.updateothersinShop10(items);
    }
    @Override
    public int sendIteminShop10(VinItem items) {
        return vinMapper.sendIteminShop10(items);
    }
    @Override
    public int sendSmallIteminShop10(VinItem items) {
        return vinMapper.sendSmallIteminShop10(items);
    }
    @Override
    public int sendFoodinShop10(VinItem items) {
        return vinMapper.sendFoodinShop10(items);
    }
    @Override
    public int sendcommercialIteminShop10(VinItem items) {
        return vinMapper.sendcommercialIteminShop10(items);
    }
    @Override
    public int sendothersinShop10(VinItem items) {
        return vinMapper.sendothersinShop10(items);
    }
    @Override
    public VinItem queryIteminShop10byId(String id) {
        return vinMapper.queryIteminShop10byId(id);
    }
    @Override
    public VinItem querySmallIteminShop10byId(String id) {
        return vinMapper.querySmallIteminShop10byId(id);
    }
    @Override
    public VinItem queryFoodinShop10byId(String id) {
        return vinMapper.queryFoodinShop10byId(id);
    }
    @Override
    public VinItem querycommercialIteminShop10byId(String id) {
        return vinMapper.querycommercialIteminShop10byId(id);
    }
    @Override
    public VinItem queryothersinShop10byId(String id) {
        return vinMapper.queryothersinShop10byId(id);
    }
    @Override
    public int queryItemNuminShop10byId(String id) {
        return vinMapper.queryItemNuminShop10byId(id);
    }
    @Override
    public int querySmallItemNuminShop10byId(String id) {
        return vinMapper.querySmallItemNuminShop10byId(id);
    }
    @Override
    public int queryFoodNuminShop10byId(String id) {
        return vinMapper.queryFoodNuminShop10byId(id);
    }
    @Override
    public int querycommercialItemNuminShop10byId(String id) {
        return vinMapper.querycommercialItemNuminShop10byId(id);
    }
    @Override
    public int queryothersNuminShop10byId(String id) {
        return vinMapper.queryothersNuminShop10byId(id);
    }
    @Override
    public List<VinItem> queryAllIteminShop10() {
        return vinMapper.queryAllIteminShop10();
    }
    @Override
    public List<VinItem> queryAllSmallIteminShop10() {
        return vinMapper.queryAllSmallIteminShop10();
    }
    @Override
    public List<VinItem> queryAllFoodinShop10() {
        return vinMapper.queryAllFoodinShop10();
    }
    @Override
    public List<VinItem> queryAllcommercialIteminShop10() {
        return vinMapper.queryAllcommercialIteminShop10();
    }
    @Override
    public List<VinItem> queryAllothersinShop10() {
        return vinMapper.queryAllothersinShop10();
    }
//    @Override
//    public VinItem queryIteminShop10ByName(String itemName) {
//        return vinMapper.queryIteminShop10ByName(itemName);
//    }
//    @Override
//    public VinItem querySmallIteminShop10ByName(String itemName) {
//        return vinMapper.querySmallIteminShop10ByName(itemName);
//    }
//    @Override
//    public VinItem queryFoodinShop10ByName(String itemName) {
//        return vinMapper.queryFoodinShop10ByName(itemName);
//    }
//    @Override
//    public VinItem querycommercialIteminShop10ByName(String itemName) {
//        return vinMapper.querycommercialIteminShop10ByName(itemName);
//    }
//    @Override
//    public VinItem queryothersinShop10ByName(String itemName) {
//        return vinMapper.queryothersinShop10ByName(itemName);
//    }
//    @Override
//    public VinItem queryItemNuminShop10byID(String id) {
//        return vinMapper.queryItemNuminShop10byID(id);
//    }
//    @Override
//    public VinItem querySmallItemNuminShop10byID(String id) {
//        return vinMapper.querySmallItemNuminShop10byID(id);
//    }
//    @Override
//    public VinItem queryFoodNuminShop10byID(String id) {
//        return vinMapper.queryFoodNuminShop10byID(id);
//    }
//    @Override
//    public VinItem querycommercialItemNuminShop10byID(String id) {
//        return vinMapper.querycommercialItemNuminShop10byID(id);
//    }
//    @Override
//    public VinItem queryothersNuminShop10byID(String id) {
//        return vinMapper.queryothersNuminShop10byID(id);
//    }
    @Override
    public int ifItemExistinShop10(String id) {
        return vinMapper.ifItemExistinShop10(id);
    }
    @Override
    public int ifSmallItemExistinShop10(String id) {
        return vinMapper.ifSmallItemExistinShop10(id);
    }
    @Override
    public int ifFoodExistinShop10(String id) {
        return vinMapper.ifFoodExistinShop10(id);
    }
    @Override
    public int ifcommercialItemExistinShop10(String id) {
        return vinMapper.ifcommercialItemExistinShop10(id);
    }
    @Override
    public int ifothersExistinShop10(String id) {
        return vinMapper.ifothersExistinShop10(id);
    }
    @Override
    public int updateItembySendfromShop10(VinItem items) {
        return vinMapper.updateItembySendfromShop10(items);
    }
    @Override
    public int updateSmallItembySendfromShop10(VinItem items) {
        return vinMapper.updateSmallItembySendfromShop10(items);
    }
    @Override
    public int updateFoodbySendfromShop10(VinItem items) {
        return vinMapper.updateFoodbySendfromShop10(items);
    }
    @Override
    public int updatecommercialItembySendfromShop10(VinItem items) {
        return vinMapper.updatecommercialItembySendfromShop10(items);
    }
    @Override
    public int updateothersbySendfromShop10(VinItem items) {
        return vinMapper.updateothersbySendfromShop10(items);
    }
    @Override
    public int addloginShop10(VinLog log) {
        return vinMapper.addloginShop10(log);
    }
    @Override
    public List<VinLog> queryCategoryLoginShop10(String category) {
        return vinMapper.queryCategoryLoginShop10(category);
    }
    @Override
    public List<VinLog> queryCategoryandIfCompleteLoginShop10(String category, boolean ifComplete) {
        return vinMapper.queryCategoryandIfCompleteLoginShop10(category,ifComplete);
    }
    @Override
    public List<VinLog> queryCategoryReceiveinShop10(String category) {
        return vinMapper.queryCategoryReceiveinShop10(category);
    }
    @Override
    public int countCategoryReceiveinShop10(String category) {
        return vinMapper.countCategoryReceiveinShop10(category);
    }
    @Override
    public List<VinLog> queryCategoryConfirminShop10(String category, String action, String action2) {
        return vinMapper.queryCategoryConfirminShop10(category,action,action2);
    }
    @Override
    public int countCategoryConfirminShop10(String category, String action, String action2) {
        return vinMapper.countCategoryConfirminShop10(category,action,action2);
    }
    @Override
    public VinLog queryLoginshop10byid(String logid) {
        return vinMapper.queryLoginshop10byid(logid);
    }
    @Override
    public int updateLoginshop10byid(VinLog vinLog) {
        return vinMapper.updateLoginshop10byid(vinLog);
    }
    @Override
    public int deleteLoginShop10byLogid(String logid) {
        return vinMapper.deleteLoginShop10byLogid(logid);
    }
    @Override
    public int addCheckinShop10(VinCheck vinCheck) {
        return vinMapper.addCheckinShop10(vinCheck);
    }
    @Override
    public List<VinCheck> queryCheckinShop10(String category) {
        return vinMapper.queryCheckinShop10(category);
    }
    @Override
    public List<VinCheck> queryCheckwithTimeinShop10(String category, String time) {
        return vinMapper.queryCheckwithTimeinShop10(category,time);
    }
    @Override
    public List<VinCheck> queryCheckwithTimeandIdinShop10(String category, String time, String id) {
        return vinMapper.queryCheckwithTimeandIdinShop10(category,time,id);
    }
    @Override
    public int updateCheckinShop10byid(VinCheck vinCheck) {
        return vinMapper.updateCheckinShop10byid(vinCheck);
    }
    @Override
    public List<VinCheck> queryCheckinShop10byID(String id) {
        return vinMapper.queryCheckinShop10byID(id);
    }
    @Override
    public List<VinItemSimple> querySumitemCountbytimeinShop10(String time) {
        return vinMapper.querySumitemCountbytimeinShop10(time);
    }

    @Override
    @CacheEvict(value = { "cutelittlepiggyCache" },key="'ifAlertinShop10List'")
    public int addSumitemCountinShop10(VinAlert vinAlert) {
        return vinMapper.addSumitemCountinShop10(vinAlert);
    }

    @Override
    public List<VinAlert> queryifAlertinShop10(String time) {
        return vinMapper.queryifAlertinShop10(time);
    }
    @Override
    public VinLog queryLoginshop10byItemid(String id) {
        return vinMapper.queryLoginshop10byItemid(id);
    }
    @Override
    public List<VinLog> queryAllLoginshop10byItemid(String id) {
        return vinMapper.queryAllLoginshop10byItemid(id);
    }
    @Override
    public int updateItemNameAllLogbyidinShop10(VinLog vinLog) {
        return vinMapper.updateItemNameAllLogbyidinShop10(vinLog);
    }


    //shop11
    @Override
    public int addIteminShop11(VinItem items) {
        return vinMapper.addIteminShop11(items);
    }
    @Override
    public int addFoodinShop11(VinItem items) {
        return vinMapper.addFoodinShop11(items);
    }
    @Override
    public int addcommercialIteminShop11(VinItem items) {
        return vinMapper.addcommercialIteminShop11(items);
    }
    @Override
    public int addothersinShop11(VinItem items) {
        return vinMapper.addothersinShop11(items);
    }
    @Override
    public int addSmallIteminShop11(VinItem items) {
        return vinMapper.addSmallIteminShop11(items);
    }
    @Override
    public int deleteIteminShop11byId(String id) {
        return vinMapper.deleteIteminShop11byId(id);
    }
    @Override
    public int deleteSmallIteminShop11byId(String id) {
        return vinMapper.deleteSmallIteminShop11byId(id);
    }
    @Override
    public int deleteFoodinShop11byId(String id) {
        return vinMapper.deleteFoodinShop11byId(id);
    }
    @Override
    public int deletecommercialIteminShop11byId(String id) {
        return vinMapper.deletecommercialIteminShop11byId(id);
    }
    @Override
    public int deleteothersinShop11byId(String id) {
        return vinMapper.deleteothersinShop11byId(id);
    }
    @Override
    public int updateIteminShop11(VinItem items) {
        return vinMapper.updateIteminShop11(items);
    }
    @Override
    public int updateSmallIteminShop11(VinItem items) {
        return vinMapper.updateSmallIteminShop11(items);
    }
    @Override
    public int updateFoodinShop11(VinItem items) {
        return vinMapper.updateFoodinShop11(items);
    }
    @Override
    public int updatecommercialIteminShop11(VinItem items) {
        return vinMapper.updatecommercialIteminShop11(items);
    }
    @Override
    public int updateothersinShop11(VinItem items) {
        return vinMapper.updateothersinShop11(items);
    }
    @Override
    public int sendIteminShop11(VinItem items) {
        return vinMapper.sendIteminShop11(items);
    }
    @Override
    public int sendSmallIteminShop11(VinItem items) {
        return vinMapper.sendSmallIteminShop11(items);
    }
    @Override
    public int sendFoodinShop11(VinItem items) {
        return vinMapper.sendFoodinShop11(items);
    }
    @Override
    public int sendcommercialIteminShop11(VinItem items) {
        return vinMapper.sendcommercialIteminShop11(items);
    }
    @Override
    public int sendothersinShop11(VinItem items) {
        return vinMapper.sendothersinShop11(items);
    }
    @Override
    public VinItem queryIteminShop11byId(String id) {
        return vinMapper.queryIteminShop11byId(id);
    }
    @Override
    public VinItem querySmallIteminShop11byId(String id) {
        return vinMapper.querySmallIteminShop11byId(id);
    }
    @Override
    public VinItem queryFoodinShop11byId(String id) {
        return vinMapper.queryFoodinShop11byId(id);
    }
    @Override
    public VinItem querycommercialIteminShop11byId(String id) {
        return vinMapper.querycommercialIteminShop11byId(id);
    }
    @Override
    public VinItem queryothersinShop11byId(String id) {
        return vinMapper.queryothersinShop11byId(id);
    }
    @Override
    public int queryItemNuminShop11byId(String id) {
        return vinMapper.queryItemNuminShop11byId(id);
    }
    @Override
    public int querySmallItemNuminShop11byId(String id) {
        return vinMapper.querySmallItemNuminShop11byId(id);
    }
    @Override
    public int queryFoodNuminShop11byId(String id) {
        return vinMapper.queryFoodNuminShop11byId(id);
    }
    @Override
    public int querycommercialItemNuminShop11byId(String id) {
        return vinMapper.querycommercialItemNuminShop11byId(id);
    }
    @Override
    public int queryothersNuminShop11byId(String id) {
        return vinMapper.queryothersNuminShop11byId(id);
    }
    @Override
    public List<VinItem> queryAllIteminShop11() {
        return vinMapper.queryAllIteminShop11();
    }
    @Override
    public List<VinItem> queryAllSmallIteminShop11() {
        return vinMapper.queryAllSmallIteminShop11();
    }
    @Override
    public List<VinItem> queryAllFoodinShop11() {
        return vinMapper.queryAllFoodinShop11();
    }
    @Override
    public List<VinItem> queryAllcommercialIteminShop11() {
        return vinMapper.queryAllcommercialIteminShop11();
    }
    @Override
    public List<VinItem> queryAllothersinShop11() {
        return vinMapper.queryAllothersinShop11();
    }
    //    @Override
//    public VinItem queryIteminShop11ByName(String itemName) {
//        return vinMapper.queryIteminShop11ByName(itemName);
//    }
//    @Override
//    public VinItem querySmallIteminShop11ByName(String itemName) {
//        return vinMapper.querySmallIteminShop11ByName(itemName);
//    }
//    @Override
//    public VinItem queryFoodinShop11ByName(String itemName) {
//        return vinMapper.queryFoodinShop11ByName(itemName);
//    }
//    @Override
//    public VinItem querycommercialIteminShop11ByName(String itemName) {
//        return vinMapper.querycommercialIteminShop11ByName(itemName);
//    }
//    @Override
//    public VinItem queryothersinShop11ByName(String itemName) {
//        return vinMapper.queryothersinShop11ByName(itemName);
//    }
//    @Override
//    public VinItem queryItemNuminShop11byID(String id) {
//        return vinMapper.queryItemNuminShop11byID(id);
//    }
//    @Override
//    public VinItem querySmallItemNuminShop11byID(String id) {
//        return vinMapper.querySmallItemNuminShop11byID(id);
//    }
//    @Override
//    public VinItem queryFoodNuminShop11byID(String id) {
//        return vinMapper.queryFoodNuminShop11byID(id);
//    }
//    @Override
//    public VinItem querycommercialItemNuminShop11byID(String id) {
//        return vinMapper.querycommercialItemNuminShop11byID(id);
//    }
//    @Override
//    public VinItem queryothersNuminShop11byID(String id) {
//        return vinMapper.queryothersNuminShop11byID(id);
//    }
    @Override
    public int ifItemExistinShop11(String id) {
        return vinMapper.ifItemExistinShop11(id);
    }
    @Override
    public int ifSmallItemExistinShop11(String id) {
        return vinMapper.ifSmallItemExistinShop11(id);
    }
    @Override
    public int ifFoodExistinShop11(String id) {
        return vinMapper.ifFoodExistinShop11(id);
    }
    @Override
    public int ifcommercialItemExistinShop11(String id) {
        return vinMapper.ifcommercialItemExistinShop11(id);
    }
    @Override
    public int ifothersExistinShop11(String id) {
        return vinMapper.ifothersExistinShop11(id);
    }
    @Override
    public int updateItembySendfromShop11(VinItem items) {
        return vinMapper.updateItembySendfromShop11(items);
    }
    @Override
    public int updateSmallItembySendfromShop11(VinItem items) {
        return vinMapper.updateSmallItembySendfromShop11(items);
    }
    @Override
    public int updateFoodbySendfromShop11(VinItem items) {
        return vinMapper.updateFoodbySendfromShop11(items);
    }
    @Override
    public int updatecommercialItembySendfromShop11(VinItem items) {
        return vinMapper.updatecommercialItembySendfromShop11(items);
    }
    @Override
    public int updateothersbySendfromShop11(VinItem items) {
        return vinMapper.updateothersbySendfromShop11(items);
    }
    @Override
    public int addloginShop11(VinLog log) {
        return vinMapper.addloginShop11(log);
    }
    @Override
    public List<VinLog> queryCategoryLoginShop11(String category) {
        return vinMapper.queryCategoryLoginShop11(category);
    }
    @Override
    public List<VinLog> queryCategoryandIfCompleteLoginShop11(String category, boolean ifComplete) {
        return vinMapper.queryCategoryandIfCompleteLoginShop11(category,ifComplete);
    }
    @Override
    public List<VinLog> queryCategoryReceiveinShop11(String category) {
        return vinMapper.queryCategoryReceiveinShop11(category);
    }
    @Override
    public int countCategoryReceiveinShop11(String category) {
        return vinMapper.countCategoryReceiveinShop11(category);
    }
    @Override
    public List<VinLog> queryCategoryConfirminShop11(String category, String action, String action2) {
        return vinMapper.queryCategoryConfirminShop11(category,action,action2);
    }
    @Override
    public int countCategoryConfirminShop11(String category, String action, String action2) {
        return vinMapper.countCategoryConfirminShop11(category,action,action2);
    }
    @Override
    public VinLog queryLoginshop11byid(String logid) {
        return vinMapper.queryLoginshop11byid(logid);
    }
    @Override
    public int updateLoginshop11byid(VinLog vinLog) {
        return vinMapper.updateLoginshop11byid(vinLog);
    }
    @Override
    public int deleteLoginShop11byLogid(String logid) {
        return vinMapper.deleteLoginShop11byLogid(logid);
    }
    @Override
    public int addCheckinShop11(VinCheck vinCheck) {
        return vinMapper.addCheckinShop11(vinCheck);
    }
    @Override
    public List<VinCheck> queryCheckinShop11(String category) {
        return vinMapper.queryCheckinShop11(category);
    }
    @Override
    public List<VinCheck> queryCheckwithTimeinShop11(String category, String time) {
        return vinMapper.queryCheckwithTimeinShop11(category,time);
    }
    @Override
    public List<VinCheck> queryCheckwithTimeandIdinShop11(String category, String time, String id) {
        return vinMapper.queryCheckwithTimeandIdinShop11(category,time,id);
    }
    @Override
    public int updateCheckinShop11byid(VinCheck vinCheck) {
        return vinMapper.updateCheckinShop11byid(vinCheck);
    }
    @Override
    public List<VinCheck> queryCheckinShop11byID(String id) {
        return vinMapper.queryCheckinShop11byID(id);
    }
    @Override
    public List<VinItemSimple> querySumitemCountbytimeinShop11(String time) {
        return vinMapper.querySumitemCountbytimeinShop11(time);
    }

    @Override
    @CacheEvict(value = { "cutelittlepiggyCache" },key="'ifAlertinShop11List'")
    public int addSumitemCountinShop11(VinAlert vinAlert) {
        return vinMapper.addSumitemCountinShop11(vinAlert);
    }

    @Override
    public List<VinAlert> queryifAlertinShop11(String time) {
        return vinMapper.queryifAlertinShop11(time);
    }
    @Override
    public VinLog queryLoginshop11byItemid(String id) {
        return vinMapper.queryLoginshop11byItemid(id);
    }
    @Override
    public List<VinLog> queryAllLoginshop11byItemid(String id) {
        return vinMapper.queryAllLoginshop11byItemid(id);
    }
    @Override
    public int updateItemNameAllLogbyidinShop11(VinLog vinLog) {
        return vinMapper.updateItemNameAllLogbyidinShop11(vinLog);
    }


    //shop12
    @Override
    public int addIteminShop12(VinItem items) {
        return vinMapper.addIteminShop12(items);
    }
    @Override
    public int addFoodinShop12(VinItem items) {
        return vinMapper.addFoodinShop12(items);
    }
    @Override
    public int addcommercialIteminShop12(VinItem items) {
        return vinMapper.addcommercialIteminShop12(items);
    }
    @Override
    public int addothersinShop12(VinItem items) {
        return vinMapper.addothersinShop12(items);
    }
    @Override
    public int addSmallIteminShop12(VinItem items) {
        return vinMapper.addSmallIteminShop12(items);
    }
    @Override
    public int deleteIteminShop12byId(String id) {
        return vinMapper.deleteIteminShop12byId(id);
    }
    @Override
    public int deleteSmallIteminShop12byId(String id) {
        return vinMapper.deleteSmallIteminShop12byId(id);
    }
    @Override
    public int deleteFoodinShop12byId(String id) {
        return vinMapper.deleteFoodinShop12byId(id);
    }
    @Override
    public int deletecommercialIteminShop12byId(String id) {
        return vinMapper.deletecommercialIteminShop12byId(id);
    }
    @Override
    public int deleteothersinShop12byId(String id) {
        return vinMapper.deleteothersinShop12byId(id);
    }
    @Override
    public int updateIteminShop12(VinItem items) {
        return vinMapper.updateIteminShop12(items);
    }
    @Override
    public int updateSmallIteminShop12(VinItem items) {
        return vinMapper.updateSmallIteminShop12(items);
    }
    @Override
    public int updateFoodinShop12(VinItem items) {
        return vinMapper.updateFoodinShop12(items);
    }
    @Override
    public int updatecommercialIteminShop12(VinItem items) {
        return vinMapper.updatecommercialIteminShop12(items);
    }
    @Override
    public int updateothersinShop12(VinItem items) {
        return vinMapper.updateothersinShop12(items);
    }
    @Override
    public int sendIteminShop12(VinItem items) {
        return vinMapper.sendIteminShop12(items);
    }
    @Override
    public int sendSmallIteminShop12(VinItem items) {
        return vinMapper.sendSmallIteminShop12(items);
    }
    @Override
    public int sendFoodinShop12(VinItem items) {
        return vinMapper.sendFoodinShop12(items);
    }
    @Override
    public int sendcommercialIteminShop12(VinItem items) {
        return vinMapper.sendcommercialIteminShop12(items);
    }
    @Override
    public int sendothersinShop12(VinItem items) {
        return vinMapper.sendothersinShop12(items);
    }
    @Override
    public VinItem queryIteminShop12byId(String id) {
        return vinMapper.queryIteminShop12byId(id);
    }
    @Override
    public VinItem querySmallIteminShop12byId(String id) {
        return vinMapper.querySmallIteminShop12byId(id);
    }
    @Override
    public VinItem queryFoodinShop12byId(String id) {
        return vinMapper.queryFoodinShop12byId(id);
    }
    @Override
    public VinItem querycommercialIteminShop12byId(String id) {
        return vinMapper.querycommercialIteminShop12byId(id);
    }
    @Override
    public VinItem queryothersinShop12byId(String id) {
        return vinMapper.queryothersinShop12byId(id);
    }
    @Override
    public int queryItemNuminShop12byId(String id) {
        return vinMapper.queryItemNuminShop12byId(id);
    }
    @Override
    public int querySmallItemNuminShop12byId(String id) {
        return vinMapper.querySmallItemNuminShop12byId(id);
    }
    @Override
    public int queryFoodNuminShop12byId(String id) {
        return vinMapper.queryFoodNuminShop12byId(id);
    }
    @Override
    public int querycommercialItemNuminShop12byId(String id) {
        return vinMapper.querycommercialItemNuminShop12byId(id);
    }
    @Override
    public int queryothersNuminShop12byId(String id) {
        return vinMapper.queryothersNuminShop12byId(id);
    }
    @Override
    public List<VinItem> queryAllIteminShop12() {
        return vinMapper.queryAllIteminShop12();
    }
    @Override
    public List<VinItem> queryAllSmallIteminShop12() {
        return vinMapper.queryAllSmallIteminShop12();
    }
    @Override
    public List<VinItem> queryAllFoodinShop12() {
        return vinMapper.queryAllFoodinShop12();
    }
    @Override
    public List<VinItem> queryAllcommercialIteminShop12() {
        return vinMapper.queryAllcommercialIteminShop12();
    }
    @Override
    public List<VinItem> queryAllothersinShop12() {
        return vinMapper.queryAllothersinShop12();
    }
    //    @Override
//    public VinItem queryIteminShop12ByName(String itemName) {
//        return vinMapper.queryIteminShop12ByName(itemName);
//    }
//    @Override
//    public VinItem querySmallIteminShop12ByName(String itemName) {
//        return vinMapper.querySmallIteminShop12ByName(itemName);
//    }
//    @Override
//    public VinItem queryFoodinShop12ByName(String itemName) {
//        return vinMapper.queryFoodinShop12ByName(itemName);
//    }
//    @Override
//    public VinItem querycommercialIteminShop12ByName(String itemName) {
//        return vinMapper.querycommercialIteminShop12ByName(itemName);
//    }
//    @Override
//    public VinItem queryothersinShop12ByName(String itemName) {
//        return vinMapper.queryothersinShop12ByName(itemName);
//    }
//    @Override
//    public VinItem queryItemNuminShop12byID(String id) {
//        return vinMapper.queryItemNuminShop12byID(id);
//    }
//    @Override
//    public VinItem querySmallItemNuminShop12byID(String id) {
//        return vinMapper.querySmallItemNuminShop12byID(id);
//    }
//    @Override
//    public VinItem queryFoodNuminShop12byID(String id) {
//        return vinMapper.queryFoodNuminShop12byID(id);
//    }
//    @Override
//    public VinItem querycommercialItemNuminShop12byID(String id) {
//        return vinMapper.querycommercialItemNuminShop12byID(id);
//    }
//    @Override
//    public VinItem queryothersNuminShop12byID(String id) {
//        return vinMapper.queryothersNuminShop12byID(id);
//    }
    @Override
    public int ifItemExistinShop12(String id) {
        return vinMapper.ifItemExistinShop12(id);
    }
    @Override
    public int ifSmallItemExistinShop12(String id) {
        return vinMapper.ifSmallItemExistinShop12(id);
    }
    @Override
    public int ifFoodExistinShop12(String id) {
        return vinMapper.ifFoodExistinShop12(id);
    }
    @Override
    public int ifcommercialItemExistinShop12(String id) {
        return vinMapper.ifcommercialItemExistinShop12(id);
    }
    @Override
    public int ifothersExistinShop12(String id) {
        return vinMapper.ifothersExistinShop12(id);
    }
    @Override
    public int updateItembySendfromShop12(VinItem items) {
        return vinMapper.updateItembySendfromShop12(items);
    }
    @Override
    public int updateSmallItembySendfromShop12(VinItem items) {
        return vinMapper.updateSmallItembySendfromShop12(items);
    }
    @Override
    public int updateFoodbySendfromShop12(VinItem items) {
        return vinMapper.updateFoodbySendfromShop12(items);
    }
    @Override
    public int updatecommercialItembySendfromShop12(VinItem items) {
        return vinMapper.updatecommercialItembySendfromShop12(items);
    }
    @Override
    public int updateothersbySendfromShop12(VinItem items) {
        return vinMapper.updateothersbySendfromShop12(items);
    }
    @Override
    public int addloginShop12(VinLog log) {
        return vinMapper.addloginShop12(log);
    }
    @Override
    public List<VinLog> queryCategoryLoginShop12(String category) {
        return vinMapper.queryCategoryLoginShop12(category);
    }
    @Override
    public List<VinLog> queryCategoryandIfCompleteLoginShop12(String category, boolean ifComplete) {
        return vinMapper.queryCategoryandIfCompleteLoginShop12(category,ifComplete);
    }
    @Override
    public List<VinLog> queryCategoryReceiveinShop12(String category) {
        return vinMapper.queryCategoryReceiveinShop12(category);
    }
    @Override
    public int countCategoryReceiveinShop12(String category) {
        return vinMapper.countCategoryReceiveinShop12(category);
    }
    @Override
    public List<VinLog> queryCategoryConfirminShop12(String category, String action, String action2) {
        return vinMapper.queryCategoryConfirminShop12(category,action,action2);
    }
    @Override
    public int countCategoryConfirminShop12(String category, String action, String action2) {
        return vinMapper.countCategoryConfirminShop12(category,action,action2);
    }
    @Override
    public VinLog queryLoginshop12byid(String logid) {
        return vinMapper.queryLoginshop12byid(logid);
    }
    @Override
    public int updateLoginshop12byid(VinLog vinLog) {
        return vinMapper.updateLoginshop12byid(vinLog);
    }
    @Override
    public int deleteLoginShop12byLogid(String logid) {
        return vinMapper.deleteLoginShop12byLogid(logid);
    }
    @Override
    public int addCheckinShop12(VinCheck vinCheck) {
        return vinMapper.addCheckinShop12(vinCheck);
    }
    @Override
    public List<VinCheck> queryCheckinShop12(String category) {
        return vinMapper.queryCheckinShop12(category);
    }
    @Override
    public List<VinCheck> queryCheckwithTimeinShop12(String category, String time) {
        return vinMapper.queryCheckwithTimeinShop12(category,time);
    }
    @Override
    public List<VinCheck> queryCheckwithTimeandIdinShop12(String category, String time, String id) {
        return vinMapper.queryCheckwithTimeandIdinShop12(category,time,id);
    }
    @Override
    public int updateCheckinShop12byid(VinCheck vinCheck) {
        return vinMapper.updateCheckinShop12byid(vinCheck);
    }
    @Override
    public List<VinCheck> queryCheckinShop12byID(String id) {
        return vinMapper.queryCheckinShop12byID(id);
    }
    @Override
    public List<VinItemSimple> querySumitemCountbytimeinShop12(String time) {
        return vinMapper.querySumitemCountbytimeinShop12(time);
    }

    @Override
    @CacheEvict(value = { "cutelittlepiggyCache" },key="'ifAlertinShop12List'")
    public int addSumitemCountinShop12(VinAlert vinAlert) {
        return vinMapper.addSumitemCountinShop12(vinAlert);
    }

    @Override
    public List<VinAlert> queryifAlertinShop12(String time) {
        return vinMapper.queryifAlertinShop12(time);
    }
    @Override
    public VinLog queryLoginshop12byItemid(String id) {
        return vinMapper.queryLoginshop12byItemid(id);
    }
    @Override
    public List<VinLog> queryAllLoginshop12byItemid(String id) {
        return vinMapper.queryAllLoginshop12byItemid(id);
    }
    @Override
    public int updateItemNameAllLogbyidinShop12(VinLog vinLog) {
        return vinMapper.updateItemNameAllLogbyidinShop12(vinLog);
    }


    @Override
    public int addDumpItem(Dumplist dumplist) {
        return vinMapper.addDumpItem(dumplist);
    }

    @Override
    public List<Dumplist> queryDumpItemwithLocationandCategory(String location, String category, boolean if_pass) {
        return vinMapper.queryDumpItemwithLocationandCategory(location, category, if_pass);
    }

    @Override
    public int updateDumpStatusbyLogId(String logid,String status) {
        return vinMapper.updateDumpStatusbyLogId(logid,status);
    }

    @Override
    public int queryDumpLogCountbyLogId(String logid) {
        return vinMapper.queryDumpLogCountbyLogId(logid);
    }

    @Override
    public Dumplist queryDumpLogbyLogId(String logid) {
        return vinMapper.queryDumpLogbyLogId(logid);
    }

    @Override
    public int updateDumpbyLogId(Dumplist dumplist) {
        return vinMapper.updateDumpbyLogId(dumplist);
    }

    @Override
    public int iflogidExistindumplist(String logid) {
        return vinMapper.iflogidExistindumplist(logid);
    }

    @Override
    public int addReceiveError(ReceiveError receiveError) {
        return vinMapper.addReceiveError(receiveError);
    }

    @Override
    public List<ReceiveError> queryReceiveError(String location, String categoty) {
        return vinMapper.queryReceiveError(location, categoty);
    }

    @Override
    public List<ReceiveError> queryReceiveErrorbyComplete(String location, String categoty, boolean ifComplete) {
        return vinMapper.queryReceiveErrorbyComplete(location, categoty, ifComplete);
    }

    @Override
    public int updateReceiveErrorifComplete(String logid, boolean ifComplete) {
        return vinMapper.updateReceiveErrorifComplete(logid,ifComplete);
    }

    @Override
    public int addFruitInvoice(FruitInvoice fruitInvoice) {
        return vinMapper.addFruitInvoice(fruitInvoice);
    }

    @Override
    public int updateFruitInvoice(FruitInvoice fruitInvoice) {
        return vinMapper.updateFruitInvoice(fruitInvoice);
    }

    @Override
    public FruitInvoice queryFruitInvoicebyInvoiceid(String invoiceid) {
        return vinMapper.queryFruitInvoicebyInvoiceid(invoiceid);
    }

    @Override
    public List<FruitInvoice> queryFruitInvoice(String location) {
        return vinMapper.queryFruitInvoice(location);
    }

    @Override
    public int deleteFruitInvoicebyInvoiceID(String invoiceid) {
        return vinMapper.deleteFruitInvoicebyInvoiceID(invoiceid);
    }

    @Override
    public int addFruitInvoiceSec(FruitInvoiceSec fruitInvoiceSec) {
        return vinMapper.addFruitInvoiceSec(fruitInvoiceSec);
    }

    @Override
    public int updateFruitInvoiceSec(FruitInvoiceSec fruitInvoiceSec) {
        return vinMapper.updateFruitInvoiceSec(fruitInvoiceSec);
    }

    @Override
    public FruitInvoiceSec queryFruitInvoiceSecbyID(String id) {
        return vinMapper.queryFruitInvoiceSecbyID(id);
    }

    @Override
    public List<FruitInvoiceSec> queryFruitInvoiceSecbyMonth(String month) {
        return vinMapper.queryFruitInvoiceSecbyMonth(month);
    }

    @Override
    public int ifExistFruitInvoiceSecID(String id) {
        return vinMapper.ifExistFruitInvoiceSecID(id);
    }

    @Override
    @Caching(evict = {@CacheEvict(value = { "cutelittlepiggyCache" },key="'vinItemPhoto_'+#filePath.id"),
        @CacheEvict(value = { "cutelittlepiggyCache" },key="'ifExistFileType_'+#filePath.id")})
    public int updateFileType(FilePath filePath) {
        return vinMapper.updateFileType(filePath);
    }

    @Override
    @Caching(evict = {@CacheEvict(value = { "cutelittlepiggyCache" },key="'vinItemPhoto_'+#filePath.id"),
        @CacheEvict(value = { "cutelittlepiggyCache" },key="'ifExistFileType_'+#filePath.id")})
    public int addFileType(FilePath filePath) {
        return vinMapper.addFileType(filePath);
    }

    @Override
    @Cacheable(value = { "cutelittlepiggyCache" },key="'vinItemPhoto_'+#id", condition="#id!=null", unless = "#result==null")
    public FilePath queryFileTypebyid(String id) {
        return vinMapper.queryFileTypebyid(id);
    }

    @Override
    @Cacheable(value = { "cutelittlepiggyCache" },key="'ifExistFileType_'+#id", condition="#id!=null", unless = "#result==null")
    public int ifExistFileTypebyID(String id) {
        return vinMapper.ifExistFileTypebyID(id);
    }

    @Override
    public int addExpiredDate(Expired expired) {
        return vinMapper.addExpiredDate(expired);
    }

    @Override
    public List<Expired> queryAllExpiredDatebyLocation(String location) {
        return vinMapper.queryAllExpiredDatebyLocation(location);
    }

    @Override
    public List<Expired> queryExpiredDatebyLocationTime(String location, String time) {
        return vinMapper.queryExpiredDatebyLocationTime(location, time);
    }

    @Override
    public List<Expired> queryExpiredItembyLocationTime(String location, String time) {
        return vinMapper.queryExpiredItembyLocationTime(location, time);
    }

    @Override
    public List<Expired> queryExpiredSoonItembyLocationTime(String location, String time1, String time2) {
        return vinMapper.queryExpiredSoonItembyLocationTime(location, time1, time2);
    }

    @Override
    public int updateExpiredDate(String time, int id, boolean ifDump) {
        return vinMapper.updateExpiredDate(time, id, ifDump);
    }

    @Override
    public Expired queryExpiredbyID(int id) {
        return vinMapper.queryExpiredbyID(id);
    }

    @Override
    public int queryNotInputDateinExpireCount(String location) {
        return vinMapper.queryNotInputDateinExpireCount(location);
    }

    @Override
    public int addKryOrder(KryOrder kryOrder) {
        return vinMapper.addKryOrder(kryOrder);
    }

    @Override
    public int addKryOrderDetail(KryDishInfo kryDishInfo) {
        return vinMapper.addKryOrderDetail(kryDishInfo);
    }

    @Override
    public int addApplyItem(ApplyItem applyItem) {
        return vinMapper.addApplyItem(applyItem);
    }

    @Override
    public List<ApplyItem> queryApplyItembyLocation(String location) {
        return vinMapper.queryApplyItembyLocation(location);
    }

    @Override
    public ApplyItem queryApplyItembyLogID(String logID) {
        return vinMapper.queryApplyItembyLogID(logID);
    }

    @Override
    public int deleteApplyItem(String logID) {
        return vinMapper.deleteApplyItem(logID);
    }

    @Override
    public int updateApplyItem(ApplyItem applyItem) {
        return vinMapper.updateApplyItem(applyItem);
    }

    @Override
    public List<ApplyItemSec> queryApplyItemSecbyMonth(String month) {
        return vinMapper.queryApplyItemSecbyMonth(month);
    }

    @Override
    public ApplyItemSec queryApplyItemSecbyID(String id) {
        return vinMapper.queryApplyItemSecbyID(id);
    }

    @Override
    public int addApplyItemSec(ApplyItemSec applyItemSec) {
        return vinMapper.addApplyItemSec(applyItemSec);
    }

    @Override
    public int updateApplyItemSec(ApplyItemSec applyItemSec) {
        return vinMapper.updateApplyItemSec(applyItemSec);
    }

    @Override
    public int ifExistApplyItemSec(String id) {
        return vinMapper.ifExistApplyItemSec(id);
    }


    //////////////////////////工具類!////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean ifAccess(@NotNull User user,@NotNull String location){
        boolean condition1 = user.getLevel() == 1000 ||
                user.getLevel() == 1 && location.equals("shop1") ||
                user.getLevel() == 2 && location.equals("shop2") ||
                user.getLevel() == 3 && location.equals("shop3") ||
                user.getLevel() == 4 && location.equals("shop4") ||
                user.getLevel() == 5 && location.equals("shop5") ||
                user.getLevel() == 6 && location.equals("shop6") ||
                user.getLevel() == 7 && location.equals("shop7") ||
                user.getLevel() == 8 && location.equals("shop8") ||
                user.getLevel() == 9 && location.equals("shop9") ||
                user.getLevel() == 10 && location.equals("shop10") ||
                user.getLevel() == 11 && location.equals("shop11") ||
                user.getLevel() == 12 && location.equals("shop12");
        boolean condition2 = user.getLevel() == 500 && (location.equals("main2") || location.equals("shop1") || location.equals("shop2") || location.equals("shop3") || location.equals("shop8") || location.equals("shop9") || location.equals("shop10") || location.equals("shop11"))
                || user.getLevel() == 501 && (location.equals("main1") || location.equals("shop4") || location.equals("shop5") || location.equals("shop6") || location.equals("shop7") || location.equals("shop3") || location.equals("shop12"));
        return condition1 || condition2;
    }

    @Override
    public String getUUID(){
        String logid = UUID.randomUUID().toString().replace("-","");
        return logid;
    }

    @Override
    public HashMap<String, String> getWarehouseMap(){
        HashMap<String, String> warehouseMap = new HashMap<>();
        List<Warehouse> warehouses = queryAllRealWarehouseName();
        for (Warehouse warehouse : warehouses) {
            warehouseMap.put(warehouse.getNickname(), warehouse.getRealname());
        }
        warehouseMap.put("outside", "外面");
        warehouseMap.put("trashcan", "垃圾桶");
        return warehouseMap;
    }

    //日期
    @Override
    public String getDateTime(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);
        return time;
    }

    @Override
    public String getDate(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time = simpleDateFormat.format(date);
        return time;
    }

    @Override
    public String getMonth(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        String time = simpleDateFormat.format(date);
        return time;
    }

    //存入水果運單
    @Override
    public void addFruitInvoiceandFile(FruitInvoice invoice, CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        addFruitInvoice(invoice);
        fileUploadService.fileUpload(file,request,invoice.getInvoiceid(),"/fruitInvoice");
    }

    @Override
    public int ifExist(String location, String category, String id) {
        int ifexist=0;
        switch (category){
            case "tool":
                switch (location){
                    case "main0":
                        ifexist = ifItemExistinMain0(id);
                        break;
                    case "main1":
                        ifexist = ifItemExistinMain1(id);
                        break;
                    case "main2":
                        ifexist = ifItemExistinMain2(id);
                        break;
                    case "shop1":
                        ifexist = ifItemExistinShop1(id);
                        break;
                    case "shop2":
                        ifexist = ifItemExistinShop2(id);
                        break;
                    case "shop3":
                        ifexist = ifItemExistinShop3(id);
                        break;
                    case "shop4":
                        ifexist = ifItemExistinShop4(id);
                        break;
                    case "shop5":
                        ifexist = ifItemExistinShop5(id);
                        break;
                    case "shop6":
                        ifexist = ifItemExistinShop6(id);
                        break;
                    case "shop7":
                        ifexist = ifItemExistinShop7(id);
                        break;
                    case "shop8":
                        ifexist = ifItemExistinShop8(id);
                        break;
                    case "shop9":
                        ifexist = ifItemExistinShop9(id);
                        break;
                    case "shop10":
                        ifexist = ifItemExistinShop10(id);
                        break;
                    case "shop11":
                        ifexist = ifItemExistinShop11(id);
                        break;
                    case "shop12":
                        ifexist = ifItemExistinShop12(id);
                        break;
                }
                break;
            case "smalltool":
                switch (location){
                    case "main0":
                        ifexist = ifSmallItemExistinMain0(id);
                        break;
                    case "main1":
                        ifexist = ifSmallItemExistinMain1(id);
                        break;
                    case "main2":
                        ifexist = ifSmallItemExistinMain2(id);
                        break;
                    case "shop1":
                        ifexist = ifSmallItemExistinShop1(id);
                        break;
                    case "shop2":
                        ifexist = ifSmallItemExistinShop2(id);
                        break;
                    case "shop3":
                        ifexist = ifSmallItemExistinShop3(id);
                        break;
                    case "shop4":
                        ifexist = ifSmallItemExistinShop4(id);
                        break;
                    case "shop5":
                        ifexist = ifSmallItemExistinShop5(id);
                        break;
                    case "shop6":
                        ifexist = ifSmallItemExistinShop6(id);
                        break;
                    case "shop7":
                        ifexist = ifSmallItemExistinShop7(id);
                        break;
                    case "shop8":
                        ifexist = ifSmallItemExistinShop8(id);
                        break;
                    case "shop9":
                        ifexist = ifSmallItemExistinShop9(id);
                        break;
                    case "shop10":
                        ifexist = ifSmallItemExistinShop10(id);
                        break;
                    case "shop11":
                        ifexist = ifSmallItemExistinShop11(id);
                        break;
                    case "shop12":
                        ifexist = ifSmallItemExistinShop12(id);
                        break;
                }
                break;
            case "food":
                switch (location){
                    case "main0":
                        ifexist = ifFoodExistinMain0(id);
                        break;
                    case "main1":
                        ifexist = ifFoodExistinMain1(id);
                        break;
                    case "main2":
                        ifexist = ifFoodExistinMain2(id);
                        break;
                    case "shop1":
                        ifexist = ifFoodExistinShop1(id);
                        break;
                    case "shop2":
                        ifexist = ifFoodExistinShop2(id);
                        break;
                    case "shop3":
                        ifexist = ifFoodExistinShop3(id);
                        break;
                    case "shop4":
                        ifexist = ifFoodExistinShop4(id);
                        break;
                    case "shop5":
                        ifexist = ifFoodExistinShop5(id);
                        break;
                    case "shop6":
                        ifexist = ifFoodExistinShop6(id);
                        break;
                    case "shop7":
                        ifexist = ifFoodExistinShop7(id);
                        break;
                    case "shop8":
                        ifexist = ifFoodExistinShop8(id);
                        break;
                    case "shop9":
                        ifexist = ifFoodExistinShop9(id);
                        break;
                    case "shop10":
                        ifexist = ifFoodExistinShop10(id);
                        break;
                    case "shop11":
                        ifexist = ifFoodExistinShop11(id);
                        break;
                    case "shop12":
                        ifexist = ifFoodExistinShop12(id);
                        break;
                }
                break;
            case "commercialthing":
                switch (location){
                    case "main0":
                        ifexist = ifcommercialItemExistinMain0(id);
                        break;
                    case "main1":
                        ifexist = ifcommercialItemExistinMain1(id);
                        break;
                    case "main2":
                        ifexist = ifcommercialItemExistinMain2(id);
                        break;
                    case "shop1":
                        ifexist = ifcommercialItemExistinShop1(id);
                        break;
                    case "shop2":
                        ifexist = ifcommercialItemExistinShop2(id);
                        break;
                    case "shop3":
                        ifexist = ifcommercialItemExistinShop3(id);
                        break;
                    case "shop4":
                        ifexist = ifcommercialItemExistinShop4(id);
                        break;
                    case "shop5":
                        ifexist = ifcommercialItemExistinShop5(id);
                        break;
                    case "shop6":
                        ifexist = ifcommercialItemExistinShop6(id);
                        break;
                    case "shop7":
                        ifexist = ifcommercialItemExistinShop7(id);
                        break;
                    case "shop8":
                        ifexist = ifcommercialItemExistinShop8(id);
                        break;
                    case "shop9":
                        ifexist = ifcommercialItemExistinShop9(id);
                        break;
                    case "shop10":
                        ifexist = ifcommercialItemExistinShop10(id);
                        break;
                    case "shop11":
                        ifexist = ifcommercialItemExistinShop11(id);
                        break;
                    case "shop12":
                        ifexist = ifcommercialItemExistinShop12(id);
                        break;
                }
                break;
            case "other":
                switch (location){
                    case "main0":
                        ifexist = ifothersExistinMain0(id);
                        break;
                    case "main1":
                        ifexist = ifothersExistinMain1(id);
                        break;
                    case "main2":
                        ifexist = ifothersExistinMain2(id);
                        break;
                    case "shop1":
                        ifexist = ifothersExistinShop1(id);
                        break;
                    case "shop2":
                        ifexist = ifothersExistinShop2(id);
                        break;
                    case "shop3":
                        ifexist = ifothersExistinShop3(id);
                        break;
                    case "shop4":
                        ifexist = ifothersExistinShop4(id);
                        break;
                    case "shop5":
                        ifexist = ifothersExistinShop5(id);
                        break;
                    case "shop6":
                        ifexist = ifothersExistinShop6(id);
                        break;
                    case "shop7":
                        ifexist = ifothersExistinShop7(id);
                        break;
                    case "shop8":
                        ifexist = ifothersExistinShop8(id);
                        break;
                    case "shop9":
                        ifexist = ifothersExistinShop9(id);
                        break;
                    case "shop10":
                        ifexist = ifothersExistinShop10(id);
                        break;
                    case "shop11":
                        ifexist = ifothersExistinShop11(id);
                        break;
                    case "shop12":
                        ifexist = ifothersExistinShop12(id);
                        break;
                }
                break;

        }
        return ifexist;
    }



    @Override
    public void addVinItem(String location, String category, VinItem vinItem) {

        switch (category){
            case "tool":
                switch (location){
                    case "main0":
                        addIteminMain0(vinItem);
                        break;
                    case "main1":
                        addIteminMain1(vinItem);
                        break;
                    case "main2":
                        addIteminMain2(vinItem);
                        break;
                    case "shop1":
                        addIteminShop1(vinItem);
                        break;
                    case "shop2":
                        addIteminShop2(vinItem);
                        break;
                    case "shop3":
                        addIteminShop3(vinItem);
                        break;
                    case "shop4":
                        addIteminShop4(vinItem);
                        break;
                    case "shop5":
                        addIteminShop5(vinItem);
                        break;
                    case "shop6":
                        addIteminShop6(vinItem);
                        break;
                    case "shop7":
                        addIteminShop7(vinItem);
                        break;
                    case "shop8":
                        addIteminShop8(vinItem);
                        break;
                    case "shop9":
                        addIteminShop9(vinItem);
                        break;
                    case "shop10":
                        addIteminShop10(vinItem);
                        break;
                    case "shop11":
                        addIteminShop11(vinItem);
                        break;
                    case "shop12":
                        addIteminShop12(vinItem);
                        break;
                }
                break;
            case "smalltool":
                switch (location){
                    case "main0":
                        addSmallIteminMain0(vinItem);
                        break;
                    case "main1":
                        addSmallIteminMain1(vinItem);
                        break;
                    case "main2":
                        addSmallIteminMain2(vinItem);
                        break;
                    case "shop1":
                        addSmallIteminShop1(vinItem);
                        break;
                    case "shop2":
                        addSmallIteminShop2(vinItem);
                        break;
                    case "shop3":
                        addSmallIteminShop3(vinItem);
                        break;
                    case "shop4":
                        addSmallIteminShop4(vinItem);
                        break;
                    case "shop5":
                        addSmallIteminShop5(vinItem);
                        break;
                    case "shop6":
                        addSmallIteminShop6(vinItem);
                        break;
                    case "shop7":
                        addSmallIteminShop7(vinItem);
                        break;
                    case "shop8":
                        addSmallIteminShop8(vinItem);
                        break;
                    case "shop9":
                        addSmallIteminShop9(vinItem);
                        break;
                    case "shop10":
                        addSmallIteminShop10(vinItem);
                        break;
                    case "shop11":
                        addSmallIteminShop11(vinItem);
                        break;
                    case "shop12":
                        addSmallIteminShop12(vinItem);
                        break;

                }
                break;
            case "food":
                switch (location){
                    case "main0":
                        addFoodinMain0(vinItem);
                        break;
                    case "main1":
                        addFoodinMain1(vinItem);
                        break;
                    case "main2":
                        addFoodinMain2(vinItem);
                        break;
                    case "shop1":
                        addFoodinShop1(vinItem);
                        break;
                    case "shop2":
                        addFoodinShop2(vinItem);
                        break;
                    case "shop3":
                        addFoodinShop3(vinItem);
                        break;
                    case "shop4":
                        addFoodinShop4(vinItem);
                        break;
                    case "shop5":
                        addFoodinShop5(vinItem);
                        break;
                    case "shop6":
                        addFoodinShop6(vinItem);
                        break;
                    case "shop7":
                        addFoodinShop7(vinItem);
                        break;
                    case "shop8":
                        addFoodinShop8(vinItem);
                        break;
                    case "shop9":
                        addFoodinShop9(vinItem);
                        break;
                    case "shop10":
                        addFoodinShop10(vinItem);
                        break;
                    case "shop11":
                        addFoodinShop11(vinItem);
                        break;
                    case "shop12":
                        addFoodinShop12(vinItem);
                        break;

                }
                break;
            case "commercialthing":
                switch (location){
                    case "main0":
                        addcommercialIteminMain0(vinItem);
                        break;
                    case "main1":
                        addcommercialIteminMain1(vinItem);
                        break;
                    case "main2":
                        addcommercialIteminMain2(vinItem);
                        break;
                    case "shop1":
                        addcommercialIteminShop1(vinItem);
                        break;
                    case "shop2":
                        addcommercialIteminShop2(vinItem);
                        break;
                    case "shop3":
                        addcommercialIteminShop3(vinItem);
                        break;
                    case "shop4":
                        addcommercialIteminShop4(vinItem);
                        break;
                    case "shop5":
                        addcommercialIteminShop5(vinItem);
                        break;
                    case "shop6":
                        addcommercialIteminShop6(vinItem);
                        break;
                    case "shop7":
                        addcommercialIteminShop7(vinItem);
                        break;
                    case "shop8":
                        addcommercialIteminShop8(vinItem);
                        break;
                    case "shop9":
                        addcommercialIteminShop9(vinItem);
                        break;
                    case "shop10":
                        addcommercialIteminShop10(vinItem);
                        break;
                    case "shop11":
                        addcommercialIteminShop11(vinItem);
                        break;
                    case "shop12":
                        addcommercialIteminShop12(vinItem);
                        break;

                }
                break;
            case "commercial":
                switch (location){
                    case "main0":
                        addcommercialIteminMain0(vinItem);
                        break;
                    case "main1":
                        addcommercialIteminMain1(vinItem);
                        break;
                    case "main2":
                        addcommercialIteminMain2(vinItem);
                        break;
                    case "shop1":
                        addcommercialIteminShop1(vinItem);
                        break;
                    case "shop2":
                        addcommercialIteminShop2(vinItem);
                        break;
                    case "shop3":
                        addcommercialIteminShop3(vinItem);
                        break;
                    case "shop4":
                        addcommercialIteminShop4(vinItem);
                        break;
                    case "shop5":
                        addcommercialIteminShop5(vinItem);
                        break;
                    case "shop6":
                        addcommercialIteminShop6(vinItem);
                        break;
                    case "shop7":
                        addcommercialIteminShop7(vinItem);
                        break;
                    case "shop8":
                        addcommercialIteminShop8(vinItem);
                        break;
                    case "shop9":
                        addcommercialIteminShop9(vinItem);
                        break;
                    case "shop10":
                        addcommercialIteminShop10(vinItem);
                        break;
                    case "shop11":
                        addcommercialIteminShop11(vinItem);
                        break;
                    case "shop12":
                        addcommercialIteminShop12(vinItem);
                        break;
                }
                break;
            case "other":
                switch (location){
                    case "main0":
                        addothersinMain0(vinItem);
                        break;
                    case "main1":
                        addothersinMain1(vinItem);
                        break;
                    case "main2":
                        addothersinMain2(vinItem);
                        break;
                    case "shop1":
                        addothersinShop1(vinItem);
                        break;
                    case "shop2":
                        addothersinShop2(vinItem);
                        break;
                    case "shop3":
                        addothersinShop3(vinItem);
                        break;
                    case "shop4":
                        addothersinShop4(vinItem);
                        break;
                    case "shop5":
                        addothersinShop5(vinItem);
                        break;
                    case "shop6":
                        addothersinShop6(vinItem);
                        break;
                    case "shop7":
                        addothersinShop7(vinItem);
                        break;
                    case "shop8":
                        addothersinShop8(vinItem);
                        break;
                    case "shop9":
                        addothersinShop9(vinItem);
                        break;
                    case "shop10":
                        addothersinShop10(vinItem);
                        break;
                    case "shop11":
                        addothersinShop11(vinItem);
                        break;
                    case "shop12":
                        addothersinShop12(vinItem);
                        break;
                }
                break;
        }
    }

    @Override
    public int getConfirmCount(String location, String category, String action1, String action2){
        int count = 0;
        switch (location){
            case "main0":
                count = countCategoryConfirminMain0(category,action1,action2);
                break;
            case "main1":
                count = countCategoryConfirminMain1(category,action1,action2);
                break;
            case "main2":
                count = countCategoryConfirminMain2(category,action1,action2);
                break;
            case "shop1":
                count = countCategoryConfirminShop1(category,action1,action2);
                break;
            case "shop2":
                count = countCategoryConfirminShop2(category,action1,action2);
                break;
            case "shop3":
                count = countCategoryConfirminShop3(category,action1,action2);
                break;
            case "shop4":
                count = countCategoryConfirminShop4(category,action1,action2);
                break;
            case "shop5":
                count = countCategoryConfirminShop5(category,action1,action2);
                break;
            case "shop6":
                count = countCategoryConfirminShop6(category,action1,action2);
                break;
            case "shop7":
                count = countCategoryConfirminShop7(category,action1,action2);
                break;
            case "shop8":
                count = countCategoryConfirminShop8(category,action1,action2);
                break;
            case "shop9":
                count = countCategoryConfirminShop9(category,action1,action2);
                break;
            case "shop10":
                count = countCategoryConfirminShop10(category,action1,action2);
                break;
            case "shop11":
                count = countCategoryConfirminShop11(category,action1,action2);
                break;
            case "shop12":
                count = countCategoryConfirminShop12(category,action1,action2);
                break;

        }
        return count;

    }

    @Override
    public int getReceiveCount(String location, String category){
        int count = 0;
        switch (location){
            case "main0":
                count = countCategoryReceiveinMain0(category);
                break;
            case "main1":
                count = countCategoryReceiveinMain1(category);
                break;
            case "main2":
                count = countCategoryReceiveinMain2(category);
                break;
            case "shop1":
                count = countCategoryReceiveinShop1(category);
                break;
            case "shop2":
                count = countCategoryReceiveinShop2(category);
                break;
            case "shop3":
                count = countCategoryReceiveinShop3(category);
                break;
            case "shop4":
                count = countCategoryReceiveinShop4(category);
                break;
            case "shop5":
                count = countCategoryReceiveinShop5(category);
                break;
            case "shop6":
                count = countCategoryReceiveinShop6(category);
                break;
            case "shop7":
                count = countCategoryReceiveinShop7(category);
                break;
            case "shop8":
                count = countCategoryReceiveinShop8(category);
                break;
            case "shop9":
                count = countCategoryReceiveinShop9(category);
                break;
            case "shop10":
                count = countCategoryReceiveinShop10(category);
                break;
            case "shop11":
                count = countCategoryReceiveinShop11(category);
                break;
            case "shop12":
                count = countCategoryReceiveinShop12(category);
                break;

        }
        return count;

    }

    //檢查唯一id有沒有重複，沒有就創建新的，有就給予
    public void checkIfExistandAddinAllItem(VinItem vinItem){
        String itemName = vinItem.getItemName();
        String[] s = itemName.split("领用标准");
        int ifExist = ifExistinAllItem(s[0]);
        int ifExistNameinSupplier = ifExistNameinSupplier(vinItem.getBrand());
        log.warn("ifExist==>"+ifExist);
        String ID = "";
        if(ifExist > 0){
            ID = checkAllItem(s[0]);
            vinItem.setId(ID);
        }else {
            ID = UUID.randomUUID().toString().replace("-","");
            vinItem.setId(ID);
            Item item = new Item();
            item.setItemID(ID);
            item.setItemName(vinItem.getItemName());
            item.setCategory(vinItem.getCategory());
            item.setSingleprice(0);
            if(ifExistNameinSupplier == 0){
                log.warn("add supplier");
                String supplierID = UUID.randomUUID().toString().replace("-","");
                Supplier supplier = new Supplier(supplierID,vinItem.getBrand(),null,null,null);
                addSupplier(supplier);
                item.setSupplierID(supplierID);
            }else {
                Supplier supplier = querySupplierbyName(vinItem.getBrand());
                item.setSupplierID(supplier.getSupplierID());
            }
            addAllItem(item);
        }



    }


    //新增頁面的頁面設置
    public void toaddItem(String nickname, String mainWarehouse, String action, String type, Model model, String category){
        if(category != null){

            model.addAttribute("category", category);
        }

        Warehouse warehouse = queryRealWarehouseName(nickname);
        String realname = warehouse.getRealname();
        model.addAttribute("warehouse",realname);
        model.addAttribute("location", nickname);
        model.addAttribute("mainWarehouse",mainWarehouse);
        model.addAttribute("action",action);
        model.addAttribute("type",type);
        model.addAttribute("way","新增");

    }

    //修改頁面的頁面設置
    public void toupdateItem(String nickname, String mainWarehouse, String action, String type, Model model, VinItem vinItem, int userLevel, String category){
        Warehouse warehouse = queryRealWarehouseName(nickname);
        String realname = warehouse.getRealname();
        model.addAttribute("warehouse",realname);
        model.addAttribute("mainWarehouse",mainWarehouse);
        model.addAttribute("action",action);
        model.addAttribute("type",type);
        model.addAttribute("vinItem",vinItem);
        model.addAttribute("way","修改");
        model.addAttribute("userLevel",userLevel);
        model.addAttribute("location", nickname);
        model.addAttribute("category", category);
    }

    //kafka更新VinItem
    @Override
    public void kafkaDoUpdate(VinItem vinItem, String category, String location) {
        VinItemwithLocationandCategory vinItemwithLocationandCategory = new VinItemwithLocationandCategory(vinItem);
        vinItemwithLocationandCategory.setCategory(category);
        vinItemwithLocationandCategory.setLocation(location);
        kafkaTemplateVinItem.send("updateVinItem",vinItemwithLocationandCategory.getId(),vinItemwithLocationandCategory);
    }

    @Override
    public void kafkaAddDailyCheck(VinCheck vinCheck, String location) {
        VinCheckwithLocation vinCheckwithLocation = new VinCheckwithLocation(vinCheck, location);
//        log.warn();("kafkaDoAddDailyCheck start...");
        kafkaTemplateVinCheck.send("addDailyCheck",vinCheckwithLocation.getId(), vinCheckwithLocation);
    }

    @Override
    public VinItem getVinItem(String location, String category, String id) {
        VinItem vinItem = null;
        switch (category) {
            case "tool":
                switch (location) {
                    case "main0":
                        vinItem = vinMapper.queryIteminMain0byId(id);
                        break;
                    case "main1":
                        vinItem = vinMapper.queryIteminMain1byId(id);
                        break;
                    case "main2":
                        vinItem = vinMapper.queryIteminMain2byId(id);
                        break;
                    case "shop1":
                        vinItem = vinMapper.queryIteminShop1byId(id);
                        break;
                    case "shop2":
                        vinItem = vinMapper.queryIteminShop2byId(id);
                        break;
                    case "shop3":
                        vinItem = vinMapper.queryIteminShop3byId(id);
                        break;
                    case "shop4":
                        vinItem = vinMapper.queryIteminShop4byId(id);
                        break;
                    case "shop5":
                        vinItem = vinMapper.queryIteminShop5byId(id);
                        break;
                    case "shop6":
                        vinItem = vinMapper.queryIteminShop6byId(id);
                        break;
                    case "shop7":
                        vinItem = vinMapper.queryIteminShop7byId(id);
                        break;
                    case "shop8":
                        vinItem = vinMapper.queryIteminShop8byId(id);
                        break;
                    case "shop9":
                        vinItem = vinMapper.queryIteminShop9byId(id);
                        break;
                    case "shop10":
                        vinItem = vinMapper.queryIteminShop10byId(id);
                        break;
                    case "shop11":
                        vinItem = vinMapper.queryIteminShop11byId(id);
                        break;
                    case "shop12":
                        vinItem = vinMapper.queryIteminShop12byId(id);
                        break;

                }

                break;
            case "smalltool":
                switch (location) {
                    case "main0":
                        vinItem = vinMapper.querySmallIteminMain0byId(id);
                        break;
                    case "main1":
                        vinItem = vinMapper.querySmallIteminMain1byId(id);
                        break;
                    case "main2":
                        vinItem = vinMapper.querySmallIteminMain2byId(id);
                        break;
                    case "shop1":
                        vinItem = vinMapper.querySmallIteminShop1byId(id);
                        break;
                    case "shop2":
                        vinItem = vinMapper.querySmallIteminShop2byId(id);
                        break;
                    case "shop3":
                        vinItem = vinMapper.querySmallIteminShop3byId(id);
                        break;
                    case "shop4":
                        vinItem = vinMapper.querySmallIteminShop4byId(id);
                        break;
                    case "shop5":
                        vinItem = vinMapper.querySmallIteminShop5byId(id);
                        break;
                    case "shop6":
                        vinItem = vinMapper.querySmallIteminShop6byId(id);
                        break;
                    case "shop7":
                        vinItem = vinMapper.querySmallIteminShop7byId(id);
                        break;
                    case "shop8":
                        vinItem = vinMapper.querySmallIteminShop8byId(id);
                        break;
                    case "shop9":
                        vinItem = vinMapper.querySmallIteminShop9byId(id);
                        break;
                    case "shop10":
                        vinItem = vinMapper.querySmallIteminShop10byId(id);
                        break;
                    case "shop11":
                        vinItem = vinMapper.querySmallIteminShop11byId(id);
                        break;
                    case "shop12":
                        vinItem = vinMapper.querySmallIteminShop12byId(id);
                        break;

                }

                break;
            case "food":
                switch (location) {
                    case "main0":
                        vinItem = vinMapper.queryFoodinMain0byId(id);
                        break;
                    case "main1":
                        vinItem = vinMapper.queryFoodinMain1byId(id);
                        break;
                    case "main2":
                        vinItem = vinMapper.queryFoodinMain2byId(id);
                        break;
                    case "shop1":
                        vinItem = vinMapper.queryFoodinShop1byId(id);
                        break;
                    case "shop2":
                        vinItem = vinMapper.queryFoodinShop2byId(id);
                        break;
                    case "shop3":
                        vinItem = vinMapper.queryFoodinShop3byId(id);
                        break;
                    case "shop4":
                        vinItem = vinMapper.queryFoodinShop4byId(id);
                        break;
                    case "shop5":
                        vinItem = vinMapper.queryFoodinShop5byId(id);
                        break;
                    case "shop6":
                        vinItem = vinMapper.queryFoodinShop6byId(id);
                        break;
                    case "shop7":
                        vinItem = vinMapper.queryFoodinShop7byId(id);
                        break;
                    case "shop8":
                        vinItem = vinMapper.queryFoodinShop8byId(id);
                        break;
                    case "shop9":
                        vinItem = vinMapper.queryFoodinShop9byId(id);
                        break;
                    case "shop10":
                        vinItem = vinMapper.queryFoodinShop10byId(id);
                        break;
                    case "shop11":
                        vinItem = vinMapper.queryFoodinShop11byId(id);
                        break;
                    case "shop12":
                        vinItem = vinMapper.queryFoodinShop12byId(id);
                        break;
                }

                break;
            case "commercial":
                switch (location) {
                    case "main0":
                        vinItem = vinMapper.querycommercialIteminMain0byId(id);
                        break;
                    case "main1":
                        vinItem = vinMapper.querycommercialIteminMain1byId(id);
                        break;
                    case "main2":
                        vinItem = vinMapper.querycommercialIteminMain2byId(id);
                        break;
                    case "shop1":
                        vinItem = vinMapper.querycommercialIteminShop1byId(id);
                        break;
                    case "shop2":
                        vinItem = vinMapper.querycommercialIteminShop2byId(id);
                        break;
                    case "shop3":
                        vinItem = vinMapper.querycommercialIteminShop3byId(id);
                        break;
                    case "shop4":
                        vinItem = vinMapper.querycommercialIteminShop4byId(id);
                        break;
                    case "shop5":
                        vinItem = vinMapper.querycommercialIteminShop5byId(id);
                        break;
                    case "shop6":
                        vinItem = vinMapper.querycommercialIteminShop6byId(id);
                        break;
                    case "shop7":
                        vinItem = vinMapper.querycommercialIteminShop7byId(id);
                        break;
                    case "shop8":
                        vinItem = vinMapper.querycommercialIteminShop8byId(id);
                        break;
                    case "shop9":
                        vinItem = vinMapper.querycommercialIteminShop9byId(id);
                        break;
                    case "shop10":
                        vinItem = vinMapper.querycommercialIteminShop10byId(id);
                        break;
                    case "shop11":
                        vinItem = vinMapper.querycommercialIteminShop11byId(id);
                        break;
                    case "shop12":
                        vinItem = vinMapper.querycommercialIteminShop12byId(id);
                        break;

                }

                break;
            case "other":
                switch (location) {
                    case "main0":
                        vinItem = vinMapper.queryothersinMain0byId(id);
                        break;
                    case "main1":
                        vinItem = vinMapper.queryothersinMain1byId(id);
                        break;
                    case "main2":
                        vinItem = vinMapper.queryothersinMain2byId(id);
                        break;
                    case "shop1":
                        vinItem = vinMapper.queryothersinShop1byId(id);
                        break;
                    case "shop2":
                        vinItem = vinMapper.queryothersinShop2byId(id);
                        break;
                    case "shop3":
                        vinItem = vinMapper.queryothersinShop3byId(id);
                        break;
                    case "shop4":
                        vinItem = vinMapper.queryothersinShop4byId(id);
                        break;
                    case "shop5":
                        vinItem = vinMapper.queryothersinShop5byId(id);
                        break;
                    case "shop6":
                        vinItem = vinMapper.queryothersinShop6byId(id);
                        break;
                    case "shop7":
                        vinItem = vinMapper.queryothersinShop7byId(id);
                        break;
                    case "shop8":
                        vinItem = vinMapper.queryothersinShop8byId(id);
                        break;
                    case "shop9":
                        vinItem = vinMapper.queryothersinShop9byId(id);
                        break;
                    case "shop10":
                        vinItem = vinMapper.queryothersinShop10byId(id);
                        break;
                    case "shop11":
                        vinItem = vinMapper.queryothersinShop11byId(id);
                        break;
                    case "shop12":
                        vinItem = vinMapper.queryothersinShop12byId(id);
                        break;
                }

                break;
        }
        if(vinItem != null){
            Item item = queryAllItembyID(id);
            Supplier supplier = querySupplierbyID(item.getSupplierID());
            vinItem.setItemName(item.getItemName());
            if(supplier != null){
                vinItem.setBrand(supplier.getSupplierName());
            }

        }
        return vinItem;
    }

    @Override
    public List<VinItem> getVinItemList(String location, String category) {
        List<VinItem> vinItemList = new ArrayList<>();
        switch (location) {
            case "main0":
                log.warn("=====main0=====");
                switch (category) {
                    case "tool":
                        log.warn("=====tool=====");
                        vinItemList = vinMapper.queryAllIteminMain0();
                        break;

                    case "smalltool":
                        log.warn("=====smalltool=====");
                        vinItemList = vinMapper.queryAllSmallIteminMain0();
                        break;
                    case "food":
                        log.warn("=====food=====");
                        vinItemList = vinMapper.queryAllFoodinMain0();
                        break;
                    case "commercialthing":
                        log.warn("=====commercialthing=====");
                        vinItemList = vinMapper.queryAllcommercialIteminMain0();
                        break;
                    case "other":
                        log.warn("=====other=====");
                        vinItemList = vinMapper.queryAllothersinMain0();
                        break;
                }

                break;
            case "main1":
                log.warn("=====main1=====");
                switch (category) {
                    case "tool":
                        log.warn("=====tool=====");
                        vinItemList = vinMapper.queryAllIteminMain1();
                        break;

                    case "smalltool":
                        log.warn("=====smalltool=====");
                        vinItemList = vinMapper.queryAllSmallIteminMain1();
                        break;
                    case "food":
                        log.warn("=====food=====");
                        vinItemList = vinMapper.queryAllFoodinMain1();
                        break;
                    case "commercialthing":
                        log.warn("=====commercialthing=====");
                        vinItemList = vinMapper.queryAllcommercialIteminMain1();
                        break;
                    case "other":
                        log.warn("=====other=====");
                        vinItemList = vinMapper.queryAllothersinMain1();
                        break;
                }

                break;
            case "main2":
                switch (category) {
                    case "tool":
                        vinItemList = vinMapper.queryAllIteminMain2();
                        break;
                    case "smalltool":
                        vinItemList = vinMapper.queryAllSmallIteminMain2();
                        break;
                    case "food":
                        vinItemList = vinMapper.queryAllFoodinMain2();
                        break;
                    case "commercialthing":
                        vinItemList = vinMapper.queryAllcommercialIteminMain2();
                        break;
                    case "other":
                        vinItemList = vinMapper.queryAllothersinMain2();
                        break;
                }

                break;
            case "shop1":
                switch (category) {
                    case "tool":
                        vinItemList = vinMapper.queryAllIteminShop1();
                        break;
                    case "smalltool":
                        vinItemList = vinMapper.queryAllSmallIteminShop1();
                        break;
                    case "food":
                        vinItemList = vinMapper.queryAllFoodinShop1();
                        break;
                    case "commercialthing":
                        vinItemList = vinMapper.queryAllcommercialIteminShop1();
                        break;
                    case "other":
                        vinItemList = vinMapper.queryAllothersinShop1();
                        break;
                }

                break;
            case "shop2":
                switch (category) {
                    case "tool":
                        vinItemList = vinMapper.queryAllIteminShop2();
                        break;
                    case "smalltool":
                        vinItemList = vinMapper.queryAllSmallIteminShop2();
                        break;
                    case "food":
                        vinItemList = vinMapper.queryAllFoodinShop2();
                        break;
                    case "commercialthing":
                        vinItemList = vinMapper.queryAllcommercialIteminShop2();
                        break;
                    case "other":
                        vinItemList = vinMapper.queryAllothersinShop2();
                        break;
                }

                break;
            case "shop3":
                switch (category) {
                    case "tool":
                        vinItemList = vinMapper.queryAllIteminShop3();
                        break;
                    case "smalltool":
                        vinItemList = vinMapper.queryAllSmallIteminShop3();
                        break;
                    case "food":
                        vinItemList = vinMapper.queryAllFoodinShop3();
                        break;
                    case "commercialthing":
                        vinItemList = vinMapper.queryAllcommercialIteminShop3();
                        break;
                    case "other":
                        vinItemList = vinMapper.queryAllothersinShop3();
                        break;
                }

                break;
            case "shop4":
                switch (category) {
                    case "tool":
                        vinItemList = vinMapper.queryAllIteminShop4();
                        break;
                    case "smalltool":
                        vinItemList = vinMapper.queryAllSmallIteminShop4();
                        break;
                    case "food":
                        vinItemList = vinMapper.queryAllFoodinShop4();
                        break;
                    case "commercialthing":
                        vinItemList = vinMapper.queryAllcommercialIteminShop4();
                        break;
                    case "other":
                        vinItemList = vinMapper.queryAllothersinShop4();
                        break;
                }

                break;
            case "shop5":
                switch (category) {
                    case "tool":
                        vinItemList = vinMapper.queryAllIteminShop5();
                        break;
                    case "smalltool":
                        vinItemList = vinMapper.queryAllSmallIteminShop5();
                        break;
                    case "food":
                        vinItemList = vinMapper.queryAllFoodinShop5();
                        break;
                    case "commercialthing":
                        vinItemList = vinMapper.queryAllcommercialIteminShop5();
                        break;
                    case "other":
                        vinItemList = vinMapper.queryAllothersinShop5();
                        break;
                }

                break;
            case "shop6":
                switch (category) {
                    case "tool":
                        vinItemList = vinMapper.queryAllIteminShop6();
                        break;
                    case "smalltool":
                        vinItemList = vinMapper.queryAllSmallIteminShop6();
                        break;
                    case "food":
                        vinItemList = vinMapper.queryAllFoodinShop6();
                        break;
                    case "commercialthing":
                        vinItemList = vinMapper.queryAllcommercialIteminShop6();
                        break;
                    case "other":
                        vinItemList = vinMapper.queryAllothersinShop6();
                        break;
                }

                break;
            case "shop7":
                switch (category) {
                    case "tool":
                        vinItemList = vinMapper.queryAllIteminShop7();
                        break;
                    case "smalltool":
                        vinItemList = vinMapper.queryAllSmallIteminShop7();
                        break;
                    case "food":
                        vinItemList = vinMapper.queryAllFoodinShop7();
                        break;
                    case "commercialthing":
                        vinItemList = vinMapper.queryAllcommercialIteminShop7();
                        break;
                    case "other":
                        vinItemList = vinMapper.queryAllothersinShop7();
                        break;
                }

                break;
            case "shop8":
                switch (category) {
                    case "tool":
                        vinItemList = vinMapper.queryAllIteminShop8();
                        break;
                    case "smalltool":
                        vinItemList = vinMapper.queryAllSmallIteminShop8();
                        break;
                    case "food":
                        vinItemList = vinMapper.queryAllFoodinShop8();
                        break;
                    case "commercialthing":
                        vinItemList = vinMapper.queryAllcommercialIteminShop8();
                        break;
                    case "other":
                        vinItemList = vinMapper.queryAllothersinShop8();
                        break;
                }

                break;
            case "shop9":
                switch (category) {
                    case "tool":
                        vinItemList = vinMapper.queryAllIteminShop9();
                        break;
                    case "smalltool":
                        vinItemList = vinMapper.queryAllSmallIteminShop9();
                        break;
                    case "food":
                        vinItemList = vinMapper.queryAllFoodinShop9();
                        break;
                    case "commercialthing":
                        vinItemList = vinMapper.queryAllcommercialIteminShop9();
                        break;
                    case "other":
                        vinItemList = vinMapper.queryAllothersinShop9();
                        break;
                }

                break;
            case "shop10":
                switch (category) {
                    case "tool":
                        vinItemList = vinMapper.queryAllIteminShop10();
                        break;
                    case "smalltool":
                        vinItemList = vinMapper.queryAllSmallIteminShop10();
                        break;
                    case "food":
                        vinItemList = vinMapper.queryAllFoodinShop10();
                        break;
                    case "commercialthing":
                        vinItemList = vinMapper.queryAllcommercialIteminShop10();
                        break;
                    case "other":
                        vinItemList = vinMapper.queryAllothersinShop10();
                        break;
                }
                break;
            case "shop11":
                switch (category) {
                    case "tool":
                        vinItemList = vinMapper.queryAllIteminShop11();
                        break;
                    case "smalltool":
                        vinItemList = vinMapper.queryAllSmallIteminShop11();
                        break;
                    case "food":
                        vinItemList = vinMapper.queryAllFoodinShop11();
                        break;
                    case "commercialthing":
                        vinItemList = vinMapper.queryAllcommercialIteminShop11();
                        break;
                    case "other":
                        vinItemList = vinMapper.queryAllothersinShop11();
                        break;
                }
                break;
            case "shop12":
                switch (category) {
                    case "tool":
                        vinItemList = vinMapper.queryAllIteminShop12();
                        break;
                    case "smalltool":
                        vinItemList = vinMapper.queryAllSmallIteminShop12();
                        break;
                    case "food":
                        vinItemList = vinMapper.queryAllFoodinShop12();
                        break;
                    case "commercialthing":
                        vinItemList = vinMapper.queryAllcommercialIteminShop12();
                        break;
                    case "other":
                        vinItemList = vinMapper.queryAllothersinShop12();
                        break;
                }
                break;
        }

        return vinItemList;
    }

    @Override
    public List<VinAlert> getifAlert(String location, String date){
        List<VinAlert> vinAlertList = new ArrayList<>();
        switch (location){
            case "main0":
                vinAlertList = queryifAlertinMain0(date);
                break;
            case "main1":
                vinAlertList = queryifAlertinMain1(date);
                break;
            case "main2":
                vinAlertList = queryifAlertinMain2(date);
                break;
            case "shop1":
                vinAlertList = queryifAlertinShop1(date);
                break;
            case "shop2":
                vinAlertList = queryifAlertinShop2(date);
                break;
            case "shop3":
                vinAlertList = queryifAlertinShop3(date);
                break;
            case "shop4":
                vinAlertList = queryifAlertinShop4(date);
                break;
            case "shop5":
                vinAlertList = queryifAlertinShop5(date);
                break;
            case "shop6":
                vinAlertList = queryifAlertinShop6(date);
                break;
            case "shop7":
                vinAlertList = queryifAlertinShop7(date);
                break;
            case "shop8":
                vinAlertList = queryifAlertinShop8(date);
                break;
            case "shop9":
                vinAlertList = queryifAlertinShop9(date);
                break;
            case "shop10":
                vinAlertList = queryifAlertinShop10(date);
                break;
            case "shop11":
                vinAlertList = queryifAlertinShop11(date);
                break;
            case "shop12":
                vinAlertList = queryifAlertinShop12(date);
                break;
        }
        return vinAlertList;
    }

    @Override
    public String getMonthfromTime(String time){
        String[] split = time.split("-");
        return split[0] + "-" + split[1];
    }

//    @Override
//    public boolean ifDobyLogid(String logid, String prefix){
//        String cacheID = prefix + logid;
//        if(redisTemplate.hasKey(cacheID)){
//            return false;
//        }else {
//            redisTemplate.opsForValue().set(cacheID,logid,5, TimeUnit.MINUTES);
//            return true;
//        }
//    }

    @Override
    public HashMap<String, String> getActionMap(){
        HashMap<String, String> actionMap = new HashMap<>();
        actionMap.put("input","入庫");
        actionMap.put("output","出庫");
        actionMap.put("send","轉移");
        actionMap.put("edit","編輯");
        actionMap.put("edit","編輯");
        actionMap.put("reject","沒過審核");
        actionMap.put("delete","刪除");
        actionMap.put("dump","報廢");
        actionMap.put("newinput","新增");
//        actionMap.put("Receive more than expect","收貨時多收的");

        return actionMap;
    }

    @Override
    public int queryVinItemCount(String location, String category, String id) {
        int itemCount = 0;
        switch (location) {
            case "main0":
                switch (category) {
                    case "tool":
                        itemCount = queryItemNuminMain0byId(id);
                        break;
                    case "smalltool":
                        itemCount = querySmallItemNuminMain0byId(id);
                        break;
                    case "food":
                        itemCount = queryFoodNuminMain0byId(id);
                        break;
                    case "commercial":
                        itemCount = querycommercialItemNuminMain0byId(id);
                        break;
                    case "other":
                        itemCount = queryothersNuminMain0byId(id);
                        break;
                }
                break;
            case "main1":
                switch (category) {
                    case "tool":
                        itemCount = queryItemNuminMain1byId(id);
                        break;
                    case "smalltool":
                        itemCount = querySmallItemNuminMain1byId(id);
                        break;
                    case "food":
                        itemCount = queryFoodNuminMain1byId(id);
                        break;
                    case "commercial":
                        itemCount = querycommercialItemNuminMain1byId(id);
                        break;
                    case "other":
                        itemCount = queryothersNuminMain1byId(id);
                        break;
                }
                break;
            case "main2":
                switch (category) {
                    case "tool":
                        itemCount = queryItemNuminMain2byId(id);
                        break;
                    case "smalltool":
                        itemCount = querySmallItemNuminMain2byId(id);
                        break;
                    case "food":
                        itemCount = queryFoodNuminMain2byId(id);
                        break;
                    case "commercial":
                        itemCount = querycommercialItemNuminMain2byId(id);
                        break;
                    case "other":
                        itemCount = queryothersNuminMain2byId(id);
                        break;
                }
                break;
            case "shop1":
                switch (category) {
                    case "tool":
                        itemCount = queryItemNuminShop1byId(id);
                        break;
                    case "smalltool":
                        itemCount = querySmallItemNuminShop1byId(id);
                        break;
                    case "food":
                        itemCount = queryFoodNuminShop1byId(id);
                        break;
                    case "commercial":
                        itemCount = querycommercialItemNuminShop1byId(id);
                        break;
                    case "other":
                        itemCount = queryothersNuminShop1byId(id);
                        break;
                }
                break;
            case "shop2":
                switch (category) {
                    case "tool":
                        itemCount = queryItemNuminShop2byId(id);
                        break;
                    case "smalltool":
                        itemCount = querySmallItemNuminShop2byId(id);
                        break;
                    case "food":
                        itemCount = queryFoodNuminShop2byId(id);
                        break;
                    case "commercial":
                        itemCount = querycommercialItemNuminShop2byId(id);
                        break;
                    case "other":
                        itemCount = queryothersNuminShop2byId(id);
                        break;
                }
                break;
            case "shop3":
                switch (category) {
                    case "tool":
                        itemCount = queryItemNuminShop3byId(id);
                        break;
                    case "smalltool":
                        itemCount = querySmallItemNuminShop3byId(id);
                        break;
                    case "food":
                        itemCount = queryFoodNuminShop3byId(id);
                        break;
                    case "commercial":
                        itemCount = querycommercialItemNuminShop3byId(id);
                        break;
                    case "other":
                        itemCount = queryothersNuminShop3byId(id);
                        break;
                }
                break;
            case "shop4":
                switch (category) {
                    case "tool":
                        itemCount = queryItemNuminShop4byId(id);
                        break;
                    case "smalltool":
                        itemCount = querySmallItemNuminShop4byId(id);
                        break;
                    case "food":
                        itemCount = queryFoodNuminShop4byId(id);
                        break;
                    case "commercial":
                        itemCount = querycommercialItemNuminShop4byId(id);
                        break;
                    case "other":
                        itemCount = queryothersNuminShop4byId(id);
                        break;
                }
                break;
            case "shop5":
                switch (category) {
                    case "tool":
                        itemCount = queryItemNuminShop5byId(id);
                        break;
                    case "smalltool":
                        itemCount = querySmallItemNuminShop5byId(id);
                        break;
                    case "food":
                        itemCount = queryFoodNuminShop5byId(id);
                        break;
                    case "commercial":
                        itemCount = querycommercialItemNuminShop5byId(id);
                        break;
                    case "other":
                        itemCount = queryothersNuminShop5byId(id);
                        break;
                }
                break;
            case "shop6":
                switch (category) {
                    case "tool":
                        itemCount = queryItemNuminShop6byId(id);
                        break;
                    case "smalltool":
                        itemCount = querySmallItemNuminShop6byId(id);
                        break;
                    case "food":
                        itemCount = queryFoodNuminShop6byId(id);
                        break;
                    case "commercial":
                        itemCount = querycommercialItemNuminShop6byId(id);
                        break;
                    case "other":
                        itemCount = queryothersNuminShop6byId(id);
                        break;
                }
                break;
            case "shop7":
                switch (category) {
                    case "tool":
                        itemCount = queryItemNuminShop7byId(id);
                        break;
                    case "smalltool":
                        itemCount = querySmallItemNuminShop7byId(id);
                        break;
                    case "food":
                        itemCount = queryFoodNuminShop7byId(id);
                        break;
                    case "commercial":
                        itemCount = querycommercialItemNuminShop7byId(id);
                        break;
                    case "other":
                        itemCount = queryothersNuminShop7byId(id);
                        break;
                }
                break;
            case "shop8":
                switch (category) {
                    case "tool":
                        itemCount = queryItemNuminShop8byId(id);
                        break;
                    case "smalltool":
                        itemCount = querySmallItemNuminShop8byId(id);
                        break;
                    case "food":
                        itemCount = queryFoodNuminShop8byId(id);
                        break;
                    case "commercial":
                        itemCount = querycommercialItemNuminShop8byId(id);
                        break;
                    case "other":
                        itemCount = queryothersNuminShop8byId(id);
                        break;
                }
                break;
            case "shop9":
                switch (category) {
                    case "tool":
                        itemCount = queryItemNuminShop9byId(id);
                        break;
                    case "smalltool":
                        itemCount = querySmallItemNuminShop9byId(id);
                        break;
                    case "food":
                        itemCount = queryFoodNuminShop9byId(id);
                        break;
                    case "commercial":
                        itemCount = querycommercialItemNuminShop9byId(id);
                        break;
                    case "other":
                        itemCount = queryothersNuminShop9byId(id);
                        break;
                }
                break;
            case "shop10":
                switch (category) {
                    case "tool":
                        itemCount = queryItemNuminShop10byId(id);
                        break;
                    case "smalltool":
                        itemCount = querySmallItemNuminShop10byId(id);
                        break;
                    case "food":
                        itemCount = queryFoodNuminShop10byId(id);
                        break;
                    case "commercial":
                        itemCount = querycommercialItemNuminShop10byId(id);
                        break;
                    case "other":
                        itemCount = queryothersNuminShop10byId(id);
                        break;
                }
                break;
            case "shop11":
                switch (category) {
                    case "tool":
                        itemCount = queryItemNuminShop11byId(id);
                        break;
                    case "smalltool":
                        itemCount = querySmallItemNuminShop11byId(id);
                        break;
                    case "food":
                        itemCount = queryFoodNuminShop11byId(id);
                        break;
                    case "commercial":
                        itemCount = querycommercialItemNuminShop11byId(id);
                        break;
                    case "other":
                        itemCount = queryothersNuminShop11byId(id);
                        break;
                }
                break;
            case "shop12":
                switch (category) {
                    case "tool":
                        itemCount = queryItemNuminShop12byId(id);
                        break;
                    case "smalltool":
                        itemCount = querySmallItemNuminShop12byId(id);
                        break;
                    case "food":
                        itemCount = queryFoodNuminShop12byId(id);
                        break;
                    case "commercial":
                        itemCount = querycommercialItemNuminShop12byId(id);
                        break;
                    case "other":
                        itemCount = queryothersNuminShop12byId(id);
                        break;
                }
                break;
        }
        return itemCount;
    }


}
