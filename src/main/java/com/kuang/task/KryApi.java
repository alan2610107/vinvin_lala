package com.kuang.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kuang.KryType.AuthType;
import com.kuang.KryType.KryAPI;
import com.kuang.config.KryApiParamConfig;
import com.kuang.pojo.*;
import com.kuang.service.KryCallService;
import com.kuang.service.VinService;
import okhttp3.OkHttpClient;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class KryApi {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;
    @Autowired
    private OkHttpClient okHttpClient;
    @Autowired
    private final KryApiParamConfig kryApiParamConfig = new KryApiParamConfig();


    public String getCategory(Long shopId, Long dishId){
        OkHttpClient okHttpClient = new OkHttpClient();
        KryApiParamConfig kryApiParamConfig = new KryApiParamConfig();
        kryApiParamConfig.setAppKey("54e3ffc62fea15205a3e7bebcaa11d6e");
        kryApiParamConfig.setAppSecret("12dfcc0ddcddf91face61b2ba7253961");
        kryApiParamConfig.setProjectName("vinvin");
        kryApiParamConfig.setUrl("https://openapi.keruyun.com");
        kryApiParamConfig.setProjectVersion("2.0");
        final KryCallService kryCallService = new KryCallService(okHttpClient, kryApiParamConfig);
        String token = kryCallService.getToken(AuthType.SHOP, shopId);
        List<Long> ids = new ArrayList<>();
        ids.add(dishId);
//        ids.add(533825239315081216L);
        DishDetail dishDetail = new DishDetail(shopId,ids);
        String apicall = kryCallService.postCall(KryAPI.DISH_DETAIL, AuthType.SHOP, shopId, token, dishDetail);

        String kryResult = JSONObject.parseObject(apicall, KryResult.class).getResult();
//        System.out.println(kryResult);
        if(!kryResult.equals("[]")){
            List<KryDishCategorys> kryDishCategoryList = JSONArray.parseArray(kryResult, KryDishCategorys.class);
            KryDishCategoryName kryDishCategoryName = null;
            for (KryDishCategorys kryDishCategorys: kryDishCategoryList) {
                String categorys = kryDishCategorys.getCategorys();
//            System.out.println(categorys.substring(1,categorys.length()-1));
                kryDishCategoryName = JSONObject.parseObject(categorys.substring(1, categorys.length() - 1), KryDishCategoryName.class);
                System.out.println(kryDishCategoryName.getCategoryName());
            }
            return kryDishCategoryName.getCategoryName();
        }else {
            return null;
        }

    }



    public void getOrders(Long shopId, String warehouse, long startTime, long endTime){
        Long page = 1L;
        int totalRows=0;
        do {
//            OkHttpClient okHttpClient = new OkHttpClient();
//            KryApiParamConfig kryApiParamConfig = new KryApiParamConfig();
            kryApiParamConfig.setAppKey("54e3ffc62fea15205a3e7bebcaa11d6e");
            kryApiParamConfig.setAppSecret("12dfcc0ddcddf91face61b2ba7253961");
            kryApiParamConfig.setProjectName("vinvin");
            kryApiParamConfig.setUrl("https://openapi.keruyun.com");
            kryApiParamConfig.setProjectVersion("1.0");
            final KryCallService kryCallService = new KryCallService(okHttpClient, kryApiParamConfig);
//            Long shopId = 870085652L;
            String token = kryCallService.getToken(AuthType.SHOP, shopId);
            KryOrders kryOrders = new KryOrders();
            kryOrders.setShopIdenty(shopId);
            kryOrders.setStartTime(startTime);
            kryOrders.setEndTime(endTime);
            kryOrders.setPageNo(page);
            String apicall = kryCallService.postCall(KryAPI.ORDERS, AuthType.SHOP, shopId, token, kryOrders);
            System.out.println(apicall);
            String kryResult = JSONObject.parseObject(apicall, KryResult.class).getResult();
            KryPage kryPage = JSONObject.parseObject(kryResult, KryPage.class);
//            System.out.println(kryPage);
            totalRows = Integer.parseInt(kryPage.getTotalRows());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            List<KryOrder> kryOrdersList = JSON.parseArray(kryPage.getItems(), KryOrder.class);
            for (int i = 0; i < kryOrdersList.size(); i++) {
                KryOrder kryOrder = kryOrdersList.get(i);
                kryOrder.setOrderTime(formatter.format(new Timestamp(Long.parseLong(kryOrder.getOrderTime()))));
                kryOrder.setCheckOutTime(formatter.format(new Timestamp(Long.parseLong(kryOrder.getCheckOutTime()))));
                kryOrder.setWarehouse(warehouse);
//                System.out.println(kryOrder);
                vinService.addKryOrder(kryOrder);
                getOrderDetail(Long.parseLong(kryOrder.getOrderId()), shopId, warehouse, kryOrder.getOrderTime());
            }
            page++;
//            System.out.println(totalRows);

        }while (totalRows>=100);
    }

    public void getOrderDetail(Long orderId, Long shopId, String warehouse, String orderTime){
        OkHttpClient okHttpClient = new OkHttpClient();
        KryApiParamConfig kryApiParamConfig = new KryApiParamConfig();
        kryApiParamConfig.setAppKey("54e3ffc62fea15205a3e7bebcaa11d6e");
        kryApiParamConfig.setAppSecret("12dfcc0ddcddf91face61b2ba7253961");
        kryApiParamConfig.setProjectName("vinvin");
        kryApiParamConfig.setUrl("https://openapi.keruyun.com");
        kryApiParamConfig.setProjectVersion("1.0");
        final KryCallService kryCallService = new KryCallService(okHttpClient, kryApiParamConfig);
//        Long shopId = 870085652L;
        String token = kryCallService.getToken(AuthType.SHOP, shopId);
        KryOrderDetail orderDetailDTO = new KryOrderDetail();
        orderDetailDTO.setShopIdenty(shopId);
        List<Long> orderIds = new ArrayList<>();
//        orderIds.add(560864684765873152L);
        orderIds.add(orderId);
        orderDetailDTO.setIds(orderIds);
        String apicall = kryCallService.postCall(KryAPI.ORDER_DETAIL, AuthType.SHOP, shopId, token, orderDetailDTO);
        System.out.println(apicall);
        String kryResult = JSONObject.parseObject(apicall, KryResult.class).getResult();
        System.out.println(kryResult);
        List<KryOrderDetailInfo> kryOrderDetailInfos = JSON.parseArray(kryResult, KryOrderDetailInfo.class);
        for (int i = 0; i < kryOrderDetailInfos.size(); i++) {
            KryOrderDetailInfo kryOrderDetailInfo = kryOrderDetailInfos.get(i);
            System.out.println(kryOrderDetailInfo);
            List<KryDishInfo> kryDishInfos = JSON.parseArray(kryOrderDetailInfo.getDishInfos(), KryDishInfo.class);
            for (int j = 0; j < kryDishInfos.size(); j++) {
                KryDishInfo kryDishInfo = kryDishInfos.get(j);
                List<KryDishProperties> kryDishProperties = new ArrayList<>();
                if(!kryDishInfo.getChildNodes().equals("[]")){
                    List<KryDishInfo> kryDishInfosChild = JSON.parseArray(kryDishInfo.getChildNodes(), KryDishInfo.class);
                    System.out.println("kryDishInfosChild.size=>"+kryDishInfosChild.size());
                    for (int k = 0; k < kryDishInfosChild.size(); k++) {
                        System.out.println(k);
                        KryDishInfo kryDishInfoChild = kryDishInfosChild.get(k);
                        kryDishProperties = JSON.parseArray(kryDishInfoChild.getDishProperties(), KryDishProperties.class);
                        for (int s = 0; s < kryDishProperties.size(); s++) {
                            kryDishInfoChild.setDishPropertyName(kryDishProperties.get(s).getDishPropertyName());
                        }
                        kryDishInfoChild.setOrderId(String.valueOf(orderId));
                        kryDishInfoChild.setCategory(getCategory(shopId,Long.parseLong(kryDishInfoChild.getDishId())));
                        kryDishInfoChild.setWarehouse(warehouse);
                        kryDishInfoChild.setOrderTime(orderTime);
                        vinService.addKryOrderDetail(kryDishInfoChild);
                        System.out.println(kryDishInfoChild);
                    }
                }else {
                    kryDishProperties = JSON.parseArray(kryDishInfo.getDishProperties(), KryDishProperties.class);
                    for (int k = 0; k < kryDishProperties.size(); k++) {
                        kryDishInfo.setDishPropertyName(kryDishProperties.get(k).getDishPropertyName());
                    }
                    kryDishInfo.setOrderId(String.valueOf(orderId));
                    kryDishInfo.setCategory(getCategory(shopId,Long.parseLong(kryDishInfo.getDishId())));
                    kryDishInfo.setWarehouse(warehouse);
                    kryDishInfo.setOrderTime(orderTime);
                    vinService.addKryOrderDetail(kryDishInfo);
                    System.out.println(kryDishInfo);
                }

            }
        }
    }

    @Scheduled(cron = "0 0 0-23/1 * * ?") //每小時執行
//    @Scheduled(cron = "0 32 18 * * ?") //每天凌晨一點執行
    public void getKryData(){
        System.out.println("============getKryData===========");
        Map<String, Long> KRYMap = new HashMap<>();
        KRYMap.put("shop1", 870305696L);
        KRYMap.put("shop2", 870305697L);
        KRYMap.put("shop3", 870331916L);
        KRYMap.put("shop4", 870270864L);
        KRYMap.put("shop5", 870085652L);
        KRYMap.put("shop6", 870365186L);
        KRYMap.put("shop7", 870387574L);
        KRYMap.put("shop8", 870387578L);
        KRYMap.put("shop9", 870387582L);
        KRYMap.put("shop10", 870387577L);
        KRYMap.put("shop11", 870387585L);
        KRYMap.put("shop12", 870387576L);
        KRYMap.put("shop13", 870387583L);
//        List<String> warehouseList = new ArrayList<>();
//        List<Long> shopIdList = new ArrayList<>();
//        warehouseList.add("shop1");
//        warehouseList.add("shop2");
//        warehouseList.add("shop3");
//        warehouseList.add("shop4");
//        warehouseList.add("shop5");
//        warehouseList.add("shop6");
//        warehouseList.add("shop7");
//        warehouseList.add("shop8");
//        warehouseList.add("shop9");
//        warehouseList.add("shop10");
//        warehouseList.add("shop11");
//        warehouseList.add("shop12");
//        warehouseList.add("shop13");
//        shopIdList.add(870305696L);
//        shopIdList.add(870305697L);
//        shopIdList.add(870331916L);
//        shopIdList.add(870270864L);
//        shopIdList.add(870085652L);
//        shopIdList.add(870365186L);
//        shopIdList.add(870387574L);
//        shopIdList.add(870387578L);
//        shopIdList.add(870387582L);
//        shopIdList.add(870387577L);
//        shopIdList.add(870387585L);
//        shopIdList.add(870387576L);
//        shopIdList.add(870387583L);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date now=new Date();
        long endTime = now.getTime();
        long startTime = endTime - 3600000L + 1000L;
//        long startTime = endTime - 86400000L + 1000L;
        System.out.println("startTime==>"+formatter.format(startTime));
        System.out.println("endTime==>"+formatter.format(endTime));
        for (String warehouse : KRYMap.keySet()) {
            getOrders(KRYMap.get(warehouse),warehouse,startTime,endTime);
        }
//        for (int i = 0; i < warehouseList.size(); i++) {
//            String warehouse = warehouseList.get(i);
//            Long shopId = shopIdList.get(i);
//            getOrders(shopId,warehouse,startTime,endTime);
//        }



    }
}
