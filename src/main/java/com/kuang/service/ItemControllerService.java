package com.kuang.service;

import com.kuang.pojo.Item;
import com.kuang.pojo.ItemSet;
import com.kuang.pojo.VinItem;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ItemControllerService {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private CacheService cacheService;

    public void addItemSetByCategory(ItemSet itemSet, String category){
        switch (category){
            case "tool":
                vinService.deleteItemToolSet(itemSet.getItemID());
                vinService.updateItemToolSet(itemSet);
                vinService.addItemToolSet(itemSet);
                break;
            case "smalltool":
                vinService.deleteItemSmallToolSet(itemSet.getItemID());
                vinService.updateItemSmallToolSet(itemSet);
                vinService.addItemSmallToolSet(itemSet);
                break;
            case "food":
                vinService.deleteItemFoodSet(itemSet.getItemID());
                vinService.updateItemFoodSet(itemSet);
                vinService.addItemFoodSet(itemSet);
                break;
            case "commercial":
            case "commercialthing":
                vinService.deleteItemCommercialSet(itemSet.getItemID());
                vinService.updateItemCommercialSet(itemSet);
                vinService.addItemCommercialSet(itemSet);
                break;
            case "other":
                vinService.deleteItemOthersSet(itemSet.getItemID());
                vinService.updateItemOthersSet(itemSet);
                vinService.addItemOthersSet(itemSet);
                break;
        }
    }

    public List<Item> getVinItemByCategory(String category){
        return cacheService.getItemByCategory(category);
    }


}
