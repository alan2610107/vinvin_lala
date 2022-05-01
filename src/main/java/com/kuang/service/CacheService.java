package com.kuang.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kuang.pojo.Expired;
import com.kuang.pojo.Item;
import com.kuang.pojo.ItemSet;
import com.kuang.pojo.VinItem;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Chi-Lin Wu
 * @apiNote To manage Cache
 */
@Service
@Slf4j
public class CacheService {


    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private RedisTemplate distributionRedisTemplate;

    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;


    public String getVinItemLocationSetCacheKey(String category, String location) {
        return "vinItem" + category + "in" + location + "Set";
    }

    public String getVinItemCategorySetCacheKey(String category) {
        return "itemSet_" + category;
    }

    public String getVinItemCategoryCacheKey(String category) {
        return "item_" + category;
    }

    public String getVinItemLocationCacheKey(String category, String location) {
        return "vinItem" + category + "in" + location;
    }


    /**
     *
     * @param location
     */
    public void setTodoReceiveCount(String location) {
        String receiveCountKey = location + "notreceiveCount";
        if(!redisTemplate.hasKey(receiveCountKey)){
            int notReceiveNum = vinService.getReceiveCount(location, "tool") +
                    vinService.getReceiveCount(location, "food") +
                    vinService.getReceiveCount(location, "smalltool") +
                    vinService.getReceiveCount(location, "commercialthing") +
                    vinService.getReceiveCount(location, "other");
            redisTemplate.opsForValue().set(receiveCountKey, notReceiveNum);
        }
    }

    /**
     *
     * @param location
     */
    public void setTodoConfirmCount(String location) {
        String confrimCountKey = location + "notconfirmCount";
        if (!redisTemplate.hasKey(confrimCountKey)) {
            int notCinfirmNum = vinService.getConfirmCount(location, "tool", "newinput", "input") +
                    vinService.getConfirmCount(location, "food", "newinput", "input") +
                    vinService.getConfirmCount(location, "smalltool", "newinput", "input") +
                    vinService.getConfirmCount(location, "commercialthing", "newinput", "input") +
                    vinService.getConfirmCount(location, "other", "newinput", "input");
            redisTemplate.opsForValue().set(confrimCountKey, notCinfirmNum);
        }
    }

    /**
     *
     * @param location
     */
    public void setNotInputDateinExpiredCount(String location){
        String notInputDateinExpiredCountKey = location + "notInputDateinExpiredCount";
        if(!redisTemplate.hasKey(notInputDateinExpiredCountKey)){
            int notInputDateinExpiredCount = vinService.queryNotInputDateinExpireCount(location);
            redisTemplate.opsForValue().set(notInputDateinExpiredCountKey, notInputDateinExpiredCount);
        }
    }

    /**
     *
     * @param location
     */
    public void decreaseNotReceiveCount(String location) {
        try {
//            lock.lock();
            String receiveCountKey = location + "notreceiveCount";
            setTodoReceiveCount(location);
            redisTemplate.opsForValue().decrement(receiveCountKey);
            log.warn("Decrease " + location + " NotReceive Count");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            lock.unlock();
        }


    }

    /**
     *
     * @param location
     */
    public void decreaseNotConfirmCount(String location) {
        try {
//            lock.lock();
            String confrimCountKey = location + "notconfirmCount";
            setTodoConfirmCount(location);
            redisTemplate.opsForValue().decrement(confrimCountKey);
            log.warn("Decrease " + location + " NotConfirm Count");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            lock.unlock();
        }

    }

    /**
     *
     * @param location
     */
    public void increaseNotReceiveCount(String location) {
        try {
//            lock.lock();
            String receiveCountKey = location + "notreceiveCount";
            setTodoReceiveCount(location);
            redisTemplate.opsForValue().increment(receiveCountKey);
            log.warn("Increase " + location + " NotReceive Count");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            lock.unlock();
        }

    }

    /**
     *
     * @param location
     */
    public void increaseNotConfirmCount(String location) {
        try {
//            lock.lock();
            String confrimCountKey = location + "notconfirmCount";
            setTodoConfirmCount(location);
            redisTemplate.opsForValue().increment(confrimCountKey);
            log.warn("Increase " + location + " NotConfirm Count");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            lock.unlock();
        }

    }

    /**
     *
     * @param key
     * @param value
     * @return boolean
     * @throws InterruptedException
     * @apiNote Set Distribution Lock
     */
    public boolean setRedisLock(String key, VinItem value) throws InterruptedException {
        boolean ifSetLock = distributionRedisTemplate.opsForValue().setIfAbsent(key, value, 3, TimeUnit.HOURS);
        while (!ifSetLock) {
            try {
                Thread.sleep(100);
                ifSetLock = distributionRedisTemplate.opsForValue().setIfAbsent(key, value, 3, TimeUnit.HOURS);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.warn("Creat redis done! Everything is locked under this id : " + key);
        return true;

    }

    /**
     *
     * @param key
     * @apiNote Delete Distribution Lock
     */
    public void deleteRedisLock(String key){
        distributionRedisTemplate.delete(key);
        log.warn("Delete redis done! Unlock under this id : " + key);
    }

    /**
     *
     * @param key
     * @return
     * @throws InterruptedException
     * @apiNote Wait for delete complete
     */
    public boolean waitRedisLock(String key) throws InterruptedException {
        Object value = distributionRedisTemplate.opsForValue().get(key);
        while (value != null) {
            log.warn("Waiting For Being Unlocked : " + key);
            Thread.sleep(100);
            value = distributionRedisTemplate.opsForValue().get(key);
        }
        return true;
    }

    /**
     *
     * @param category
     */
    public void buildItemSetCache(@NotNull String category){
//        setVinItemCategorySetCacheKey(category);
//        setCategory(category);
//        String key = "itemSet_"+category;
        String vinItemCategorySetCacheKey = getVinItemCategorySetCacheKey(category);
        log.warn("buildItemSetCache: " + vinItemCategorySetCacheKey);
        Boolean keyExist = redisTemplate.hasKey(vinItemCategorySetCacheKey);
        if(!keyExist){
            List<ItemSet> itemSetList = null;
            switch (category){
                case "tool":
                    log.warn("=====tool=====");
                    itemSetList = vinService.queryAllItemToolSet();
                    break;
                case "smalltool":
                    log.warn("=====smalltool=====");
                    itemSetList = vinService.queryAllItemSmallToolSet();
                    break;
                case "food":
                    log.warn("=====food=====");
                    itemSetList = vinService.queryAllItemFoodSet();
                    break;
                case "commercialthing":
                    log.warn("=====commercialthing=====");
                    itemSetList = vinService.queryAllItemCommercialSet();
                    break;
                case "other":
                    log.warn("=====other=====");
                    itemSetList = vinService.queryAllItemOthersSet();
                    break;
            }

//            System.out.println("itemSetList: "+itemSetList);
            if(itemSetList != null && itemSetList.size() > 0){
                log.warn("Set up itemSetList cache");
                for (ItemSet itemSet : itemSetList) {
                    redisTemplate.opsForZSet().add(vinItemCategorySetCacheKey, itemSet.getItemID(), itemSetList.indexOf(itemSet));
                }
            }else {
                log.warn("No itemSet List!!!!");
            }
        }

    }

    /**
     *
     * @param category
     * @return
     */
    public Set<String> getItemSet(String category){
//        setCategory(category);
//        setVinItemCategorySetCacheKey(category);
//        String key = "itemSet_"+category;
        String vinItemCategorySetCacheKey = getVinItemCategorySetCacheKey(category);
        boolean exist = redisTemplate.hasKey(vinItemCategorySetCacheKey);
        if(!exist){
            buildItemSetCache(category);
        }
        if(exist){
            Set<String> itemSet = redisTemplate.opsForZSet().range(vinItemCategorySetCacheKey, 0, -1);
            return itemSet;
        }

        return null;
    }

    /**
     *
     * @param vinItemList
     * @param category
     * @param location
     */
    public void cacheable(List<VinItem> vinItemList, String category, String location) {
//        setLocation(location);
//        setCategory(category);
//        setVinItemLocationSetCacheKey(category, location);
//        setVinItemLocationCacheKey(category, location);
        String vinItemLocationSetCacheKey = getVinItemLocationSetCacheKey(category, location);
        String vinItemLocationCacheKey = getVinItemLocationCacheKey(category, location);
        String vinItemCategorySetCacheKey = getVinItemCategorySetCacheKey(category);
        buildItemSetCache(category);
//        String itemSetKey = "itemSet_"+category;
        boolean existVinItemCategorySet = redisTemplate.hasKey(vinItemCategorySetCacheKey);
        for (int i = 0; i < vinItemList.size(); i++) {
            VinItem vinItem = vinItemList.get(i);
//            log.warn();(vinItem);
            String jsonString = JSON.toJSONString(vinItem);
//            log.warn();("add "+key+" to cache");
            redisTemplate.opsForHash().put(vinItemLocationCacheKey, vinItem.getId(), jsonString);
            if(!existVinItemCategorySet){
                redisTemplate.opsForZSet().add(vinItemLocationSetCacheKey, vinItem.getId(), i);
            }

        }
    }

    /**
     *
     * @param location
     * @param category
     * @return
     */
    public List<VinItem> getVinItemCache(String category, String location) {
//        setCategory(category);
//        setLocation(location);
//        String itemSetKey = "itemSet_"+category;
        String vinItemCategorySetCacheKey = getVinItemCategorySetCacheKey(category);
        String vinItemLocationSetCacheKey = getVinItemLocationSetCacheKey(category, location);
        String vinItemLocationCacheKey = getVinItemLocationCacheKey(category, location);
        Set<String> hashKeyList = null;
        boolean existVinItemSet = redisTemplate.hasKey(vinItemCategorySetCacheKey);
        if(existVinItemSet){
            hashKeyList = redisTemplate.opsForZSet().range(vinItemCategorySetCacheKey, 0, -1);
        }else {
            hashKeyList = redisTemplate.opsForZSet().range(vinItemLocationSetCacheKey, 0, -1);
        }

        Map<String,String> vinItemMap = redisTemplate.opsForHash().entries(vinItemLocationCacheKey);

        log.warn("=====Get vinItemCache=====");
        VinItem vinItemOutput = null;
        List<VinItem> vinItemList = new ArrayList<>();
        for (String hashKey : hashKeyList) {

//            System.out.println(JSON.parseObject(vinItemMap.get(hashKey), VinItem.class));
//            log.warn();(hashkey);
            if(vinItemMap.containsKey(hashKey)){
                vinItemOutput = JSON.parseObject(vinItemMap.get(hashKey), VinItem.class);
//            log.warn();(vinItemOutput);
                vinItemList.add(vinItemOutput);
            }
        }
        return vinItemList;
    }

    /**
     *
     * @param vinItem
     * @param location
     * @param category
     */
    public void updateCache(VinItem vinItem, String location, String category) {
//        setCategory(category);
//        setLocation(location);
//        String vinItemCategorySetCacheKey = getVinItemCategorySetCacheKey(category);
        String vinItemLocationSetCacheKey = getVinItemLocationSetCacheKey(category, location);
        String vinItemLocationCacheKey = getVinItemLocationCacheKey(category, location);
        boolean existVinItemLocationCache = redisTemplate.hasKey(vinItemLocationCacheKey);
        boolean existVinItemLocationSetCache = redisTemplate.hasKey(vinItemLocationSetCacheKey);
        if(!existVinItemLocationCache){
            List<VinItem> vinItemList = vinService.getVinItemList(location, category);
            cacheable(vinItemList, category, location);
        }
        String jsonString = JSON.toJSONString(vinItem);
        redisTemplate.opsForHash().put(vinItemLocationCacheKey, vinItem.getId(), jsonString);
        if(existVinItemLocationSetCache){
            Long count = redisTemplate.opsForZSet().count(vinItemLocationSetCacheKey, 0, -1);
            redisTemplate.opsForZSet().add(vinItemLocationSetCacheKey, vinItem.getId(), count);
        }

    }

    /**
     *
     * @param vinItem
     * @param location
     * @param category
     */
    public void addCache(VinItem vinItem, String location, String category) {
//        setCategory(category);
//        setLocation(location);
//        String vinItemLocationSetCacheKey = vinItemLocationCacheKey + "Set";
//        String vinItemSetCache = "itemSet_" + category;
        String vinItemCategorySetCacheKey = getVinItemCategorySetCacheKey(category);
        String vinItemLocationSetCacheKey = getVinItemLocationSetCacheKey(category, location);
        String vinItemLocationCacheKey = getVinItemLocationCacheKey(category, location);
        boolean existVinItemLocationCache = redisTemplate.hasKey(vinItemLocationCacheKey);
        boolean existVinItemLocationSetCache = redisTemplate.hasKey(vinItemLocationSetCacheKey);
        boolean existVinItemSetCache = redisTemplate.hasKey(vinItemCategorySetCacheKey);
        if(!existVinItemLocationCache){
            List<VinItem> vinItemList = vinService.getVinItemList(location, category);
            cacheable(vinItemList, category, location);
        }
        String jsonString = JSON.toJSONString(vinItem);
        redisTemplate.opsForHash().put(vinItemLocationCacheKey, vinItem.getId(), jsonString);

        if(existVinItemLocationSetCache){
            Long count = redisTemplate.opsForZSet().count(vinItemLocationSetCacheKey, 0, Double.MAX_VALUE);
            redisTemplate.opsForZSet().add(vinItemLocationSetCacheKey, vinItem.getId(), count);
        }
        if(existVinItemSetCache){
            Long count = redisTemplate.opsForZSet().count(vinItemCategorySetCacheKey, 0, Double.MAX_VALUE);
            redisTemplate.opsForZSet().add(vinItemCategorySetCacheKey, vinItem.getId(), count);
        }




//        String keyFinance = "FinanceitemFor" + vinItem.getCategory();
//        if(redisTemplate.hasKey(keyFinance)){
//            Item item = vinService.queryAllItembyID(vinItem.getId());
//            String itemJsonString = JSON.toJSONString(item);
//            Long countFinance = redisTemplate.opsForZSet().count(keyFinance + "Set", 0, Double.MAX_VALUE);
//            redisTemplate.opsForHash().put(keyFinance, item.getItemID(), itemJsonString);
//            redisTemplate.opsForZSet().add(keyFinance + "Set", item.getItemID(), countFinance);
//
//        }

    }

    /**
     *
     * @param id
     * @param location
     * @param category
     */
    public void deleteCache(String id, String location, String category){
//        setLocation(location);
//        setCategory(category);
        String vinItemCategorySetCacheKey = getVinItemCategorySetCacheKey(category);
        String vinItemLocationSetCacheKey = getVinItemLocationSetCacheKey(category, location);
        String vinItemLocationCacheKey = getVinItemLocationCacheKey(category, location);
        boolean existVinItemLocationCache = redisTemplate.hasKey(vinItemLocationCacheKey);
        boolean existVinItemLocationSetCache = redisTemplate.hasKey(vinItemLocationSetCacheKey);
        boolean existVinItemSetCache = redisTemplate.hasKey(vinItemCategorySetCacheKey);
        if (existVinItemLocationCache){
            redisTemplate.opsForHash().delete(vinItemLocationCacheKey, id);
        }
        if (existVinItemLocationSetCache){
            redisTemplate.opsForZSet().remove(vinItemLocationSetCacheKey, id);
        }
        if (existVinItemSetCache){
            redisTemplate.opsForZSet().remove(vinItemCategorySetCacheKey, id);
        }

    }


    /**
     *
     * @param location
     * @return
     */
    public Map<String, String> getExpiredItemCache(String location) {
        String keyExpired = location + "ExpiredItemCache";
        String keyExpiredCount = location + "ExpiredItemCountCache";
        String keyExpiredSoon = location + "ExpiredSoonItemCache";
        String keyExpiredSoonCount = location + "ExpiredSoonItemCountCache";
        if(!redisTemplate.hasKey(keyExpired)){
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String today = simpleDateFormat.format(date);
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(date);
            rightNow.add(Calendar.DAY_OF_YEAR, 2);
            Date twoDaysAfterDate = rightNow.getTime();
            String twoDaysAfter = simpleDateFormat.format(twoDaysAfterDate);
            log.warn("twoDaysAfter=>"+twoDaysAfter);
            log.warn("today=>"+today);
            List<Expired> expiredList = vinService.queryExpiredItembyLocationTime(location,today);
            List<Expired> expiredSoonList = vinService.queryExpiredSoonItembyLocationTime(location,twoDaysAfter,today);

            int expiredItemCount = expiredList.size();
            int expiredSoonItemCount = expiredSoonList.size();
            if(expiredItemCount == 0){
                redisTemplate.opsForHash().put(keyExpired,"null",null);
            }
            if(expiredSoonItemCount == 0){
                redisTemplate.opsForHash().put(keyExpiredSoon,"null",null);
            }
            for (int i = 0; i < expiredItemCount; i++) {
                String itemID = expiredList.get(i).getItemID();
                int id = expiredList.get(i).getId();
                if(redisTemplate.opsForHash().hasKey(keyExpired,itemID)){
                    String tmp = (String) redisTemplate.opsForHash().get(keyExpired,itemID);
                    tmp = tmp + ", 材料_"+id;
                    redisTemplate.opsForHash().put(keyExpired,itemID,tmp);
                }else {
                    redisTemplate.opsForHash().put(keyExpired,itemID,"材料_"+id);
                }

            }
            for (int i = 0; i < expiredSoonItemCount; i++) {
                String itemID = expiredSoonList.get(i).getItemID();
                int id = expiredSoonList.get(i).getId();
                if(redisTemplate.opsForHash().hasKey(keyExpiredSoon,itemID)){
                    String tmp = (String) redisTemplate.opsForHash().get(keyExpiredSoon,itemID);
                    tmp = tmp + ", 材料_"+id;
                    redisTemplate.opsForHash().put(keyExpiredSoon,itemID,tmp);
                }else {
                    redisTemplate.opsForHash().put(keyExpiredSoon,itemID,"材料_"+id);
                }
            }

            redisTemplate.opsForValue().set(keyExpiredCount, expiredItemCount);
            redisTemplate.opsForValue().set(keyExpiredSoonCount, expiredSoonItemCount);

            Map<String,String> expiredMap = redisTemplate.opsForHash().entries(keyExpired);
            return expiredMap;


        }else{
            Map<String,String> expiredMap = redisTemplate.opsForHash().entries(keyExpired);
            return expiredMap;
        }
    }

    /**
     *
     * @param location
     * @return
     */
    public Map<String,String> getExpiredSoonItemCache(String location) {
        String keyExpired = location + "ExpiredItemCache";
        String keyExpiredCount = location + "ExpiredItemCountCache";
        String keyExpiredSoon = location + "ExpiredSoonItemCache";
        String keyExpiredSoonCount = location + "ExpiredSoonItemCountCache";
        if(!redisTemplate.hasKey(keyExpired)){
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String today = simpleDateFormat.format(date);
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(date);
            rightNow.add(Calendar.DAY_OF_YEAR, 2);
            Date twoDaysAfterDate = rightNow.getTime();
            String twoDaysAfter = simpleDateFormat.format(twoDaysAfterDate);
            log.warn("twoDaysAfter=>"+twoDaysAfter);
            log.warn("today=>"+today);
            List<Expired> expiredList = vinService.queryExpiredItembyLocationTime(location,today);
            List<Expired> expiredSoonList = vinService.queryExpiredSoonItembyLocationTime(location,twoDaysAfter,today);

            int expiredItemCount = expiredList.size();
            int expiredSoonItemCount = expiredSoonList.size();
            if(expiredItemCount == 0){
                redisTemplate.opsForHash().put(keyExpired,"null",null);
            }
            if(expiredSoonItemCount == 0){
                redisTemplate.opsForHash().put(keyExpiredSoon,"null",null);
            }
            for (int i = 0; i < expiredItemCount; i++) {
                String itemID = expiredList.get(i).getItemID();
                int id = expiredList.get(i).getId();
                if(redisTemplate.opsForHash().hasKey(keyExpired,itemID)){
                    String tmp = (String) redisTemplate.opsForHash().get(keyExpired,itemID);
                    tmp = tmp + ", 材料_"+id;
                    redisTemplate.opsForHash().put(keyExpired,itemID,tmp);
                }else {
                    redisTemplate.opsForHash().put(keyExpired,itemID,"材料_"+id);
                }

            }
            for (int i = 0; i < expiredSoonItemCount; i++) {
                String itemID = expiredSoonList.get(i).getItemID();
                int id = expiredSoonList.get(i).getId();
                if(redisTemplate.opsForHash().hasKey(keyExpiredSoon,itemID)){
                    String tmp = (String) redisTemplate.opsForHash().get(keyExpiredSoon,itemID);
                    tmp = tmp + ", 材料_"+id;
                    redisTemplate.opsForHash().put(keyExpiredSoon,itemID,tmp);
                }else {
                    redisTemplate.opsForHash().put(keyExpiredSoon,itemID,"材料_"+id);
                }
            }
            redisTemplate.opsForValue().set(keyExpiredCount, expiredItemCount);
            redisTemplate.opsForValue().set(keyExpiredSoonCount, expiredSoonItemCount);
            Map<String,String> expiredSoonMap = redisTemplate.opsForHash().entries(keyExpiredSoon);
            return expiredSoonMap;


        }else{
            Map<String,String> expiredSoonMap = redisTemplate.opsForHash().entries(keyExpiredSoon);
            return expiredSoonMap;
        }
    }

    /**
     *
     * @param location
     * @return
     */
    public String getExpiredItemCountCache(String location) {
        String keyExpired = location + "ExpiredItemCache";
        String keyExpiredCount = location + "ExpiredItemCountCache";
        String keyExpiredSoon = location + "ExpiredSoonItemCache";
        String keyExpiredSoonCount = location + "ExpiredSoonItemCountCache";
        if(!redisTemplate.hasKey(keyExpired)){
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String today = simpleDateFormat.format(date);
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(date);
            rightNow.add(Calendar.DAY_OF_YEAR, 2);
            Date twoDaysAfterDate = rightNow.getTime();
            String twoDaysAfter = simpleDateFormat.format(twoDaysAfterDate);
            log.warn("twoDaysAfter=>"+twoDaysAfter);
            log.warn("today=>"+today);
            List<Expired> expiredList = vinService.queryExpiredItembyLocationTime(location,today);
            List<Expired> expiredSoonList = vinService.queryExpiredSoonItembyLocationTime(location,twoDaysAfter,today);

            int expiredItemCount = expiredList.size();
            int expiredSoonItemCount = expiredSoonList.size();
            if(expiredItemCount == 0){
                redisTemplate.opsForHash().put(keyExpired,"null",null);
            }
            if(expiredSoonItemCount == 0){
                redisTemplate.opsForHash().put(keyExpiredSoon,"null",null);
            }
            for (int i = 0; i < expiredItemCount; i++) {
                String itemID = expiredList.get(i).getItemID();
                int id = expiredList.get(i).getId();
                if(redisTemplate.opsForHash().hasKey(keyExpired,itemID)){
                    String tmp = (String) redisTemplate.opsForHash().get(keyExpired,itemID);
                    tmp = tmp + ", 材料_"+id;
                    redisTemplate.opsForHash().put(keyExpired,itemID,tmp);
                }else {
                    redisTemplate.opsForHash().put(keyExpired,itemID,"材料_"+id);
                }

            }
            for (int i = 0; i < expiredSoonItemCount; i++) {
                String itemID = expiredSoonList.get(i).getItemID();
                int id = expiredSoonList.get(i).getId();
                if(redisTemplate.opsForHash().hasKey(keyExpiredSoon,itemID)){
                    String tmp = (String) redisTemplate.opsForHash().get(keyExpiredSoon,itemID);
                    tmp = tmp + ", 材料_"+id;
                    redisTemplate.opsForHash().put(keyExpiredSoon,itemID,tmp);
                }else {
                    redisTemplate.opsForHash().put(keyExpiredSoon,itemID,"材料_"+id);
                }
            }
            redisTemplate.opsForValue().set(keyExpiredCount, expiredItemCount);
            redisTemplate.opsForValue().set(keyExpiredSoonCount, expiredSoonItemCount);
            return String.valueOf(expiredItemCount);


        }else{
            return String.valueOf(redisTemplate.opsForValue().get(keyExpiredCount));
        }
    }


    /**
     *
     * @param location
     * @return
     */
    public String getExpiredSoonItemCountCache(String location) {
        String keyExpired = location + "ExpiredItemCache";
        String keyExpiredCount = location + "ExpiredItemCountCache";
        String keyExpiredSoon = location + "ExpiredSoonItemCache";
        String keyExpiredSoonCount = location + "ExpiredSoonItemCountCache";
        if(!redisTemplate.hasKey(keyExpired)){
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String today = simpleDateFormat.format(date);
            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(date);
            rightNow.add(Calendar.DAY_OF_YEAR, 2);
            Date twoDaysAfterDate = rightNow.getTime();
            String twoDaysAfter = simpleDateFormat.format(twoDaysAfterDate);
            log.warn("twoDaysAfter=>"+twoDaysAfter);
            log.warn("today=>"+today);
            List<Expired> expiredList = vinService.queryExpiredItembyLocationTime(location,today);
            List<Expired> expiredSoonList = vinService.queryExpiredSoonItembyLocationTime(location,twoDaysAfter,today);

            int expiredItemCount = expiredList.size();
            int expiredSoonItemCount = expiredSoonList.size();
            if(expiredItemCount == 0){
                redisTemplate.opsForHash().put(keyExpired,"null",null);
            }
            if(expiredSoonItemCount == 0){
                redisTemplate.opsForHash().put(keyExpiredSoon,"null",null);
            }
            for (int i = 0; i < expiredItemCount; i++) {
                String itemID = expiredList.get(i).getItemID();
                int id = expiredList.get(i).getId();
                if(redisTemplate.opsForHash().hasKey(keyExpired,itemID)){
                    String tmp = (String) redisTemplate.opsForHash().get(keyExpired,itemID);
                    tmp = tmp + ", 材料_"+id;
                    redisTemplate.opsForHash().put(keyExpired,itemID,tmp);
                }else {
                    redisTemplate.opsForHash().put(keyExpired,itemID,"材料_"+id);
                }

            }

            for (int i = 0; i < expiredSoonItemCount; i++) {
                String itemID = expiredSoonList.get(i).getItemID();
                int id = expiredSoonList.get(i).getId();
                if(redisTemplate.opsForHash().hasKey(keyExpiredSoon,itemID)){
                    String tmp = (String) redisTemplate.opsForHash().get(keyExpiredSoon,itemID);
                    tmp = tmp + ", 材料_"+id;
                    redisTemplate.opsForHash().put(keyExpiredSoon,itemID,tmp);
                }else {
                    redisTemplate.opsForHash().put(keyExpiredSoon,itemID,"材料_"+id);
                }
            }
            redisTemplate.opsForValue().set(keyExpiredCount, expiredItemCount);
            redisTemplate.opsForValue().set(keyExpiredSoonCount, expiredSoonItemCount);
            return String.valueOf(expiredSoonItemCount);
        }else{
            return String.valueOf(redisTemplate.opsForValue().get(keyExpiredSoonCount));
        }
    }

    /**
     *
     * @param location
     */
    public void reloadExpiredandExpiredSoonCache(String location) {
        String keyExpired = location + "ExpiredItemCache";
        String keyExpiredCount = location + "ExpiredItemCountCache";
        String keyExpiredSoon = location + "ExpiredSoonItemCache";
        String keyExpiredSoonCount = location + "ExpiredSoonItemCountCache";
        if(redisTemplate.hasKey(keyExpired)){
            redisTemplate.delete(keyExpired);
        }
        if(redisTemplate.hasKey(keyExpiredCount)){
            redisTemplate.delete(keyExpiredCount);
        }
        if(redisTemplate.hasKey(keyExpiredSoon)){
            redisTemplate.delete(keyExpiredSoon);
        }
        if(redisTemplate.hasKey(keyExpiredSoonCount)){
            redisTemplate.delete(keyExpiredSoonCount);
        }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = simpleDateFormat.format(date);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.DAY_OF_YEAR, 2);
        Date twoDaysAfterDate = rightNow.getTime();
        String twoDaysAfter = simpleDateFormat.format(twoDaysAfterDate);
        log.warn("twoDaysAfter=>"+twoDaysAfter);
        log.warn("today=>"+today);
        List<Expired> expiredList = vinService.queryExpiredItembyLocationTime(location,today);
        List<Expired> expiredSoonList = vinService.queryExpiredSoonItembyLocationTime(location,twoDaysAfter,today);

        int expiredItemCount = expiredList.size();
        int expiredSoonItemCount = expiredSoonList.size();
        if(expiredItemCount == 0){
            redisTemplate.opsForHash().put(keyExpired,"null",null);
        }
        if(expiredSoonItemCount == 0){
            redisTemplate.opsForHash().put(keyExpiredSoon,"null",null);
        }
        for (int i = 0; i < expiredItemCount; i++) {
            String itemID = expiredList.get(i).getItemID();
            int id = expiredList.get(i).getId();
            if(redisTemplate.opsForHash().hasKey(keyExpired,itemID)){
                String tmp = (String) redisTemplate.opsForHash().get(keyExpired,itemID);
                tmp = tmp + ", 材料_"+id;
                redisTemplate.opsForHash().put(keyExpired,itemID,tmp);
            }else {
                redisTemplate.opsForHash().put(keyExpired,itemID,"材料_"+id);
            }

        }
        for (int i = 0; i < expiredSoonItemCount; i++) {
            String itemID = expiredSoonList.get(i).getItemID();
            int id = expiredSoonList.get(i).getId();
            if(redisTemplate.opsForHash().hasKey(keyExpiredSoon,itemID)){
                String tmp = (String) redisTemplate.opsForHash().get(keyExpiredSoon,itemID);
                tmp = tmp + ", 材料_"+id;
                redisTemplate.opsForHash().put(keyExpiredSoon,itemID,tmp);
            }else {
                redisTemplate.opsForHash().put(keyExpiredSoon,itemID,"材料_"+id);
            }
        }

        redisTemplate.opsForValue().set(keyExpiredCount, expiredItemCount);
        redisTemplate.opsForValue().set(keyExpiredSoonCount, expiredSoonItemCount);
    }

    /**
     * @apiNote In case click two times
     * @param logid
     * @param prefix
     * @return boolean
     */
    public boolean ifDobyLogid(String logid, String prefix){
        String cacheID = prefix + logid;
        if(redisTemplate.hasKey(cacheID)){
            return false;
        }else {
            redisTemplate.opsForValue().set(cacheID,logid,5, TimeUnit.MINUTES);
            return true;
        }
    }

    public List<Item> getItemByCategory(String category){
        String vinItemCategoryCacheKey = getVinItemCategoryCacheKey(category);
        if (category.equals("commercial")){
            category = "commercialthing";
        }
//        setCategory(category);
//        String key = "item_" + category;
//        String itemSetKey = "itemSet_"+category;
        boolean exist = redisTemplate.hasKey(vinItemCategoryCacheKey);
        List<Item> output = new ArrayList<>();
        if(!exist){
            List<Item> itemList = null;
            if(category.equals("commercialthing")){
                itemList = vinService.queryAllItembyCategory("commercial");
            }else {
                itemList = vinService.queryAllItembyCategory(category);
            }
            if(itemList != null && itemList.size() > 0){
                for (Item item : itemList) {
                    redisTemplate.opsForHash().put(vinItemCategoryCacheKey, item.getItemID(), JSON.toJSONString(item));
                }
            }
        }

        Map<String, String> itemMap = redisTemplate.opsForHash().entries(vinItemCategoryCacheKey);
        Set<String> itemSet = getItemSet(category);
        if(itemSet != null){
            for (String itemID : itemSet) {
                output.add(JSONObject.parseObject(itemMap.get(itemID), Item.class));
            }
        }else {
            for (String itemID : itemMap.keySet()) {
                output.add(JSONObject.parseObject(itemMap.get(itemID), Item.class));
            }
        }
        return output;
    }


}
