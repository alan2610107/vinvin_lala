package com.kuang.service;

import com.kuang.pojo.VinItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.Future;

/**
 * @author Chi-Lin Wu
 * @apiNote Get All inventory by muti-thread
 */
@Service
@Slf4j
public class QueryInventoryService {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    @Resource
    ThreadPoolTaskExecutor taskExecutor;

    @Resource
    RedisTemplate redisTemplate;

    @Resource
    CacheService cacheService;


    public Future<List<VinItem>> get(String location, String category){
        return taskExecutor.submit(() -> {
            List<VinItem> vinItemList = new ArrayList<>();

            log.warn("QueryAllThreadService==>" + location);
            String key = "vinItem" + category + "in" + location;
            log.warn("=========Startkey=>" + key);
            Boolean keyExist = redisTemplate.hasKey(key);

            if (!keyExist) {
                log.warn("=====No cache, Start to add cache and print the page=====");
//                vinItemList = vinService.getVinItemList(location, category);
                List<VinItem> finalVinItemList = vinService.getVinItemList(location, category);

                cacheService.cacheable(finalVinItemList, category, location);
            }
            log.warn("=====Print the page from cache=====");
            vinItemList = cacheService.getVinItemCache(category, location);
            log.warn("=========Endkey=>" + key);

            return vinItemList;
        });
    }


//    @Override
//    public List<VinItem> call() throws Exception {
//
//        List<VinItem> vinItemList = new ArrayList<>();
//
//        log.warn("QueryAllThreadService==>" + location);
//        String key = "vinItem" + category + "in" + location;
//        log.warn("=========Startkey=>" + key);
//        Boolean ifKeyExist = redisTemplate.hasKey(key);
//
//        if (!ifKeyExist) {
//            log.warn("=====No cach, Strat to add cache and print the page=====");
//            vinItemList = vinService.getVinItemList(location,category);
//            vinService.cacheable(key, vinItemList);
//
//        } else {
//            log.warn("=====Print the page from cache=====");
//            vinItemList = vinService.getVinItemCache(key);
//
//        }
//        log.warn("=========Endkey=>" + key);
//
//        return vinItemList;
//
//
//    }




}
