package com.kuang.service;

import com.kuang.pojo.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

@Service
@Slf4j
public class QueryItemService {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;
    @Resource
    ThreadPoolTaskExecutor taskExecutor;

    @Resource
    private CacheService cacheService;

    /**
     *
     * @param category
     * @return
     */
    public Future<List<Item>> getItemByCategory(String category){
        return taskExecutor.submit(() ->{
            List<Item> itemList = cacheService.getItemByCategory(category);
            return itemList;
        });
    }
}
