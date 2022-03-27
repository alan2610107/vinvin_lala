package com.kuang.service;

import com.kuang.pojo.VinItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Chi-Lin Wu
 * @apiNote In order to use AOP in VinMainController
 */
@Service
@Slf4j
@EnableAspectJAutoProxy(proxyTargetClass = true,exposeProxy = true) //使用cglib作文代理
public class VinMainControllerService {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    @Resource
    private CacheService cacheService;

    @Resource
    private ThreadPoolTaskExecutor taskExecutor;

    @Resource
    private LogService logService;

    /**
     * @apiNote Output VinItem Method with VinItem
     * @param vinItem
     * @param location
     * @param category
     * @return VinItem vinItem
     */
    public VinItem output(VinItem vinItem, String location, String category){
        VinItem vinItemOld;
        if (category.equals("commercialthing")){
            vinItemOld = vinService.getVinItem(location, "commercial", vinItem.getId());
        }else {
            vinItemOld = vinService.getVinItem(location, category, vinItem.getId());
        }
        int oldNum = vinItemOld.getItemCount();
        vinItem.setItemCount(oldNum - vinItem.getItemCount());
        vinItem.setTotalPrice(Math.round(vinItem.getItemCount() * vinItem.getSinglePrice() * 100.0) / 100.0);
        return vinItem;
    }

    /**
     * @apiNote Output VinItem Method with itemID
     * @param outputCount
     * @param location
     * @param category
     * @param itemID
     * @return
     */
    public VinItem output(int outputCount, String location, String category, String itemID){
        VinItem originVinItem;
        if (category.equals("commercialthing")){
            originVinItem = vinService.getVinItem(location, "commercial", itemID);
        }else {
            originVinItem = vinService.getVinItem(location, category, itemID);
        }
        VinItem vinItem = new VinItem(originVinItem);
        int originNum = originVinItem.getItemCount();
        vinItem.setItemCount(originNum - outputCount);
        vinItem.setTotalPrice(Math.round(vinItem.getItemCount() * vinItem.getSinglePrice() * 100.0) / 100.0);
        return vinItem;
    }

    /**
     * @apiNote Input VinItem Method with Vinitem
     * @param vinItem
     * @param location
     * @param category
     * @return VinItem vinItem
     */
    public VinItem input(VinItem vinItem, String location, String category){
        VinItem vinItemOld;
        if (category.equals("commercialthing")){
            vinItemOld = vinService.getVinItem(location, "commercial", vinItem.getId());
        }else {
            vinItemOld = vinService.getVinItem(location, category, vinItem.getId());
        }
        int oldNum = vinItemOld.getItemCount();
        double oldSingleprice = vinItemOld.getSinglePrice();
        int inputCount = vinItem.getItemCount();
        vinItem.setItemCount(oldNum + inputCount);
        if(oldSingleprice == vinItem.getSinglePrice()){
            vinItem.setTotalPrice(Math.round(vinItem.getItemCount() * vinItem.getSinglePrice() * 100.0) / 100.0);
        }else {
            double totalPrice = inputCount * vinItem.getSinglePrice() + vinItemOld.getTotalPrice();
            totalPrice = Math.round(totalPrice*100.0)/100.0;
            vinItem.setTotalPrice(totalPrice);
            double singlePrice = totalPrice / (vinItem.getItemCount());
            singlePrice = Math.round(singlePrice*100.0)/100.0;
            vinItem.setSinglePrice(singlePrice);
        }

        return vinItem;
    }

    /**
     * @apiNote Input VinItem Method with itemID
     * @param inputCount
     * @param location
     * @param category
     * @param itemID
     * @param inputSinglePrice
     * @return
     */
    public VinItem input(int inputCount, String location, String category, String itemID, double inputSinglePrice){
        VinItem originVinItem;
        if (category.equals("commercialthing")){
            originVinItem = vinService.getVinItem(location, "commercial", itemID);
        }else {
            originVinItem = vinService.getVinItem(location, category, itemID);
        }
        VinItem vinItem = new VinItem(originVinItem);
        int originNum = originVinItem.getItemCount();
        double originSingleprice = originVinItem.getSinglePrice();
        vinItem.setItemCount(originNum + inputCount);
        if(originSingleprice == inputSinglePrice){
            vinItem.setTotalPrice(Math.round(vinItem.getItemCount() * inputSinglePrice * 100.0) / 100.0);
        }else {
            double totalPrice = Math.round((inputCount * inputSinglePrice + originVinItem.getTotalPrice()) * 100.0) / 100.0;
//            totalPrice = Math.round(totalPrice*100.0)/100.0;
            vinItem.setTotalPrice(totalPrice);
            double singlePrice = Math.round((totalPrice / (vinItem.getItemCount())) * 100.0) / 100.0;
//            singlePrice = Math.round(singlePrice*100.0)/100.0;
            vinItem.setSinglePrice(singlePrice);
        }

        return vinItem;
    }

    /**
     *
     * @apiNote Update Database and Cache
     * @param updateVinItem
     * @param location
     * @param category
     */
    public void update(VinItem updateVinItem, String location, String category){
        String cacheKey = "vinItem" + category + "in" + location;
        cacheService.updateCache(cacheKey,updateVinItem,location,category);
        if (category.equals("commercialthing")){
            vinService.kafkaDoUpdate(updateVinItem, "commercial", location);
        }else {
            vinService.kafkaDoUpdate(updateVinItem, category, location);
        }
    }

    /**
     * @apiNote Add to Database and Cache
     * @param addVinItem
     * @param location
     * @param category
     */
    public void add(VinItem addVinItem, String location, String category){
        String cacheKey = "vinItem" + category + "in" + location;
        String distributionCacheKey = location + "," + category + "," + addVinItem.getId();
        cacheService.addCache(cacheKey, addVinItem, location, category);
        vinService.addVinItem(location, category, addVinItem);
        cacheService.deleteRedisLock(distributionCacheKey);
    }

    /**
     * @apiNote Update VinItem
     * @param vinItem
     * @param location
     * @param category
     */
    public void doUpdateVinItem(VinItem vinItem, String location, String category){
        log.warn("Do Update " + location);
        VinItem vinItemOrigin;
        if (category.equals("commercialthing")){
            vinItemOrigin = vinService.getVinItem(location, "commercial", vinItem.getId());
        }else {
            vinItemOrigin = vinService.getVinItem(location, category, vinItem.getId());
        }

        taskExecutor.submit(() -> {
            try {
                logService.addLog("edit", vinItemOrigin,category,location,location,null,null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        update(vinItem,location,category);
//        vinService.updateCache(cacheKey,vinItem,location,category);
//        if(category.equals("commercialthing")){
//            vinService.kafkaDoUpdate(vinItem,"commercial",location);
//        }else {
//            vinService.kafkaDoUpdate(vinItem,category,location);
//        }

    }

    /**
     * @apiNote Input VinItem
     * @param vinItem
     * @param location
     * @param category
     */
    public void doInputVinItem(VinItem vinItem, String location, String category){
        log.warn("Do Input " + location);
//        VinItem vinItemOld;
//        if (category.equals("commercialthing")){
//            vinItemOld = vinService.getVinItem(location, "commercial", vinItem.getId());
//        }else {
//            vinItemOld = vinService.getVinItem(location, category, vinItem.getId());
//        }
//        int oldNum = vinItemOld.getItemCount();
//        double oldSingleprice = vinItemOld.getSinglePrice();
//        VinItem vinItemLog = new VinItem(vinItem);
//        taskExecutor.submit(() -> {
//            try {
//                logService.addLog("input",vinItemLog,category,"outside",location, null, null);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });

//        int inputCount = vinItem.getItemCount();
//        vinItem.setItemCount(oldNum + inputCount);
//        if(oldSingleprice == vinItem.getSinglePrice()){
//            vinItem.setTotalPrice(Math.round(vinItem.getItemCount() * vinItem.getSinglePrice() * 100.0) / 100.0);
//        }else {
//            double totalPrice = inputCount * vinItem.getSinglePrice() + vinItemOld.getTotalPrice();
//            totalPrice = Math.round(totalPrice*100.0)/100.0;
//            vinItem.setTotalPrice(totalPrice);
//            double singlePrice = totalPrice / (vinItem.getItemCount());
//            singlePrice = Math.round(singlePrice*100.0)/100.0;
//            vinItem.setSinglePrice(singlePrice);
//        }
        int ifexist = vinService.ifExist(location, category, vinItem.getId());
        if(ifexist > 0){
            VinItem updateVinItem = input(vinItem,location,category);
            update(updateVinItem,location,category);
        }else {
            add(vinItem,location,category);
        }

//        vinService.updateCache(cacheKey,updateVinItem,location,category);
//        if (category.equals("commercialthing")){
//            vinService.kafkaDoUpdate(updateVinItem, "commercial", location);
//        }else {
//            vinService.kafkaDoUpdate(updateVinItem, category, location);
//        }

    }








    /**
     * @apiNote Output VinItem with VinItem
     * @param vinItem
     * @param location
     * @param category
     */
    public void doOutputVinItem(VinItem vinItem, String location, String category){
        log.warn("Do Output " + location);
//        VinItem vinItemOld;
//        if (category.equals("commercialthing")){
//            vinItemOld = vinService.getVinItem(location, "commercial", vinItem.getId());
//        }else {
//            vinItemOld = vinService.getVinItem(location, category, vinItem.getId());
//        }
//        int oldNum = vinItemOld.getItemCount();
//        VinItem vinItemLog = new VinItem(vinItem);
//        taskExecutor.submit(() -> {
//            try {
//                logService.addLog("output",vinItemLog,category,location,"outside", null, null);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
        VinItem updateVinItem = output(vinItem,location,category);

//        vinItem.setItemCount(oldNum - vinItem.getItemCount());
//        vinItem.setTotalPrice(Math.round(vinItem.getItemCount() * vinItem.getSinglePrice() * 100.0) / 100.0);
        update(updateVinItem,location,category);
//        vinService.updateCache(cacheKey,updateVinItem,location,category);
//        if (category.equals("commercialthing")){
//            vinService.kafkaDoUpdate(updateVinItem,"commercial",location);
//        }else {
//            vinService.kafkaDoUpdate(updateVinItem, category, location);
//        }

    }

    /**
     * @apiNote Output VinItem with itemID
     * @param outputCount
     * @param location
     * @param category
     * @param itemID
     */
    public void doOutputVinItem(int outputCount, String location, String category, String itemID){
        log.warn("Do Output " + location);
        VinItem updateVinItem = output(outputCount,location,category,itemID);
        update(updateVinItem,location,category);
    }

    /**
     * @apiNote Send VinItem
     * @param vinItem
     * @param request
     * @param location
     * @param category
     */
    public void doSendVinItem(VinItem vinItem, HttpServletRequest request, String location, String category){
        log.warn("Do Send" );
        String target = request.getParameter("Warehouse");
        log.warn("From " + location + " To " + target);
        VinItem vinItemLog = new VinItem(vinItem);
        System.out.println("Target : " + target);
        taskExecutor.submit(() -> {
            try {
                logService.addLog("send", vinItemLog, category, location, target, null, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        VinItem updateVinItem = output(vinItem, location, category);
        update(updateVinItem,location,category);
//        vinService.updateCache(cacheKey, updateVinItem, location, category);
//        if (category.equals("commercialthing")) {
//            vinService.kafkaDoUpdate(updateVinItem, "commercial", location);
//        } else {
//            vinService.kafkaDoUpdate(updateVinItem, category, location);
//
//        }
    }



}
