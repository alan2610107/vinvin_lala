package com.kuang.service;

import com.alibaba.fastjson.JSON;
import com.kuang.pojo.Expired;
import com.kuang.pojo.Item;
import com.kuang.pojo.VinItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Chi-Lin Wu
 * @apiNote To meange Cache
 */
@Service
@Slf4j
public class CacheService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisTemplate distributionRedisTemplate;

    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

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
     * @param key
     * @param vinItemList
     */
    public void cacheable(String key, List<VinItem> vinItemList) {
        for (int i = 0; i < vinItemList.size(); i++) {
            VinItem vinItem = vinItemList.get(i);
//            log.warn();(vinItem);
            String jsonString = JSON.toJSONString(vinItem);
//            log.warn();("add "+key+" to cache");
            redisTemplate.opsForHash().put(key,vinItem.getId(),jsonString);
            redisTemplate.opsForZSet().add(key+"Set", vinItem.getId(), i);
        }
    }

    /**
     *
     * @param key
     * @return
     */
    public List<VinItem> getVinItemCache(String key) {
//        Set<String> hashkeys = redisTemplate.opsForHash().keys(key);
        Set<String> hashkeys = redisTemplate.opsForZSet().range(key + "Set", 0, -1);
        Map<String,String> vinItemMap = redisTemplate.opsForHash().entries(key);
        log.warn("=====Get vinItemCache=====");
        VinItem vinItemOutput = null;
        List<VinItem> vinItemList = new ArrayList<>();
        for (String hashkey: hashkeys) {
//            log.warn();(hashkey);
            vinItemOutput = JSON.parseObject(vinItemMap.get(hashkey), VinItem.class);
//            log.warn();(vinItemOutput);
            vinItemList.add(vinItemOutput);
        }
        return vinItemList;
    }

    /**
     *
     * @param key
     * @param vinItem
     * @param location
     * @param category
     */
    public void updateCache(String key, VinItem vinItem, String location, String category) {
        if(!redisTemplate.hasKey(key)){
            List<VinItem> vinItemList = vinService.getVinItemList(location, category);
            cacheable(key, vinItemList);
        }
        String jsonString = JSON.toJSONString(vinItem);
        redisTemplate.opsForHash().put(key,vinItem.getId(),jsonString);

//        Long count = redisTemplate.opsForZSet().count(key + "Set", 0, -1);
//        redisTemplate.opsForZSet().add(key+"Set", vinItem.getId(), count);
    }

    /**
     *
     * @param key
     * @param vinItem
     * @param location
     * @param category
     */
    public void addCache(String key, VinItem vinItem, String location, String category) {
        if(!redisTemplate.hasKey(key)){
            List<VinItem> vinItemList = vinService.getVinItemList(location, category);
            cacheable(key, vinItemList);
        }
        String jsonString = JSON.toJSONString(vinItem);
        redisTemplate.opsForHash().put(key,vinItem.getId(),jsonString);
        Long count = redisTemplate.opsForZSet().count(key + "Set", 0, Double.MAX_VALUE);
        redisTemplate.opsForZSet().add(key+"Set", vinItem.getId(), count);

        String keyFinance = "FinanceitemFor" + vinItem.getCategory();
        if(redisTemplate.hasKey(keyFinance)){
            Item item = vinService.queryAllItembyID(vinItem.getId());
            String itemJsonString = JSON.toJSONString(item);
            Long countFinance = redisTemplate.opsForZSet().count(keyFinance + "Set", 0, Double.MAX_VALUE);
            redisTemplate.opsForHash().put(keyFinance, item.getItemID(), itemJsonString);
            redisTemplate.opsForZSet().add(keyFinance + "Set", item.getItemID(), countFinance);

        }

    }

    /**
     *
     * @param key
     * @param id
     */
    public void deleteCache(String key, String id){
        redisTemplate.opsForHash().delete(key,id);
        redisTemplate.opsForZSet().remove(key+"Set",id);
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
}
