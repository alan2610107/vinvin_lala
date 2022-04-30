package com.kuang.service;

import com.kuang.pojo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.ui.Model;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface VinService {
    //增加一個項目
    int addIteminMain1(VinItem items);

    int addIteminMain2(VinItem items);

    int addIteminShop1(VinItem items);

    int addIteminShop2(VinItem items);

    int addIteminShop3(VinItem items);

    int addIteminShop4(VinItem items);

    int addIteminShop5(VinItem items);

    int addIteminShop6(VinItem items);
    int addIteminShop7(VinItem items);

    int addFoodinMain1(VinItem items);

    int addFoodinMain2(VinItem items);

    int addFoodinShop1(VinItem items);

    int addFoodinShop2(VinItem items);

    int addFoodinShop3(VinItem items);

    int addFoodinShop4(VinItem items);

    int addFoodinShop5(VinItem items);

    int addFoodinShop6(VinItem items);
    int addFoodinShop7(VinItem items);

    int addcommercialIteminMain1(VinItem items);

    int addcommercialIteminMain2(VinItem items);

    int addcommercialIteminShop1(VinItem items);

    int addcommercialIteminShop2(VinItem items);

    int addcommercialIteminShop3(VinItem items);

    int addcommercialIteminShop4(VinItem items);

    int addcommercialIteminShop5(VinItem items);

    int addcommercialIteminShop6(VinItem items);
    int addcommercialIteminShop7(VinItem items);

    int addothersinMain1(VinItem items);

    int addothersinMain2(VinItem items);

    int addothersinShop1(VinItem items);

    int addothersinShop2(VinItem items);

    int addothersinShop3(VinItem items);

    int addothersinShop4(VinItem items);

    int addothersinShop5(VinItem items);

    int addothersinShop6(VinItem items);
    int addothersinShop7(VinItem items);

    int addSmallIteminMain1(VinItem items);

    int addSmallIteminMain2(VinItem items);

    int addSmallIteminShop1(VinItem items);

    int addSmallIteminShop2(VinItem items);

    int addSmallIteminShop3(VinItem items);

    int addSmallIteminShop4(VinItem items);

    int addSmallIteminShop5(VinItem items);

    int addSmallIteminShop6(VinItem items);
    int addSmallIteminShop7(VinItem items);

    //刪除一個項目
    int deleteIteminMain1byId(String id);

    int deleteIteminMain2byId(String id);

    int deleteIteminShop1byId(String id);

    int deleteIteminShop2byId(String id);

    int deleteIteminShop3byId(String id);

    int deleteIteminShop4byId(String id);

    int deleteIteminShop5byId(String id);

    int deleteIteminShop6byId(String id);
    int deleteIteminShop7byId(String id);

    int deleteSmallIteminMain1byId(String id);

    int deleteSmallIteminMain2byId(String id);

    int deleteSmallIteminShop1byId(String id);

    int deleteSmallIteminShop2byId(String id);

    int deleteSmallIteminShop3byId(String id);

    int deleteSmallIteminShop4byId(String id);

    int deleteSmallIteminShop5byId(String id);

    int deleteSmallIteminShop6byId(String id);
    int deleteSmallIteminShop7byId(String id);

    int deleteFoodinMain1byId(String id);

    int deleteFoodinMain2byId(String id);

    int deleteFoodinShop1byId(String id);

    int deleteFoodinShop2byId(String id);

    int deleteFoodinShop3byId(String id);

    int deleteFoodinShop4byId(String id);

    int deleteFoodinShop5byId(String id);

    int deleteFoodinShop6byId(String id);
    int deleteFoodinShop7byId(String id);

    int deletecommercialIteminMain1byId(String id);

    int deletecommercialIteminMain2byId(String id);

    int deletecommercialIteminShop1byId(String id);

    int deletecommercialIteminShop2byId(String id);

    int deletecommercialIteminShop3byId(String id);

    int deletecommercialIteminShop4byId(String id);

    int deletecommercialIteminShop5byId(String id);

    int deletecommercialIteminShop6byId(String id);
    int deletecommercialIteminShop7byId(String id);

    int deleteothersinMain1byId(String id);

    int deleteothersinMain2byId(String id);

    int deleteothersinShop1byId(String id);

    int deleteothersinShop2byId(String id);

    int deleteothersinShop3byId(String id);

    int deleteothersinShop4byId(String id);

    int deleteothersinShop5byId(String id);

    int deleteothersinShop6byId(String id);
    int deleteothersinShop7byId(String id);


    //更新一個項目
    int updateIteminMain1(VinItem items);

    int updateIteminMain2(VinItem items);

    int updateIteminShop1(VinItem items);

    int updateIteminShop2(VinItem items);

    int updateIteminShop3(VinItem items);

    int updateIteminShop4(VinItem items);

    int updateIteminShop5(VinItem items);

    int updateIteminShop6(VinItem items);
    int updateIteminShop7(VinItem items);

    int updateSmallIteminMain1(VinItem items);

    int updateSmallIteminMain2(VinItem items);

    int updateSmallIteminShop1(VinItem items);

    int updateSmallIteminShop2(VinItem items);

    int updateSmallIteminShop3(VinItem items);

    int updateSmallIteminShop4(VinItem items);

    int updateSmallIteminShop5(VinItem items);

    int updateSmallIteminShop6(VinItem items);
    int updateSmallIteminShop7(VinItem items);

    int updateFoodinMain1(VinItem items);

    int updateFoodinMain2(VinItem items);

    int updateFoodinShop1(VinItem items);

    int updateFoodinShop2(VinItem items);

    int updateFoodinShop3(VinItem items);

    int updateFoodinShop4(VinItem items);

    int updateFoodinShop5(VinItem items);

    int updateFoodinShop6(VinItem items);
    int updateFoodinShop7(VinItem items);

    int updatecommercialIteminMain1(VinItem items);

    int updatecommercialIteminMain2(VinItem items);

    int updatecommercialIteminShop1(VinItem items);

    int updatecommercialIteminShop2(VinItem items);

    int updatecommercialIteminShop3(VinItem items);

    int updatecommercialIteminShop4(VinItem items);

    int updatecommercialIteminShop5(VinItem items);

    int updatecommercialIteminShop6(VinItem items);
    int updatecommercialIteminShop7(VinItem items);

    int updateothersinMain1(VinItem items);

    int updateothersinMain2(VinItem items);

    int updateothersinShop1(VinItem items);

    int updateothersinShop2(VinItem items);

    int updateothersinShop3(VinItem items);

    int updateothersinShop4(VinItem items);

    int updateothersinShop5(VinItem items);

    int updateothersinShop6(VinItem items);
    int updateothersinShop7(VinItem items);


    //轉移一個項目
    int sendIteminMain1(VinItem items);

    int sendIteminMain2(VinItem items);

    int sendIteminShop1(VinItem items);

    int sendIteminShop2(VinItem items);

    int sendIteminShop3(VinItem items);

    int sendIteminShop4(VinItem items);

    int sendIteminShop5(VinItem items);

    int sendIteminShop6(VinItem items);
    int sendIteminShop7(VinItem items);

    int sendSmallIteminMain1(VinItem items);

    int sendSmallIteminMain2(VinItem items);

    int sendSmallIteminShop1(VinItem items);

    int sendSmallIteminShop2(VinItem items);

    int sendSmallIteminShop3(VinItem items);

    int sendSmallIteminShop4(VinItem items);

    int sendSmallIteminShop5(VinItem items);

    int sendSmallIteminShop6(VinItem items);
    int sendSmallIteminShop7(VinItem items);

    int sendFoodinMain1(VinItem items);

    int sendFoodinMain2(VinItem items);

    int sendFoodinShop1(VinItem items);

    int sendFoodinShop2(VinItem items);

    int sendFoodinShop3(VinItem items);

    int sendFoodinShop4(VinItem items);

    int sendFoodinShop5(VinItem items);

    int sendFoodinShop6(VinItem items);
    int sendFoodinShop7(VinItem items);

    int sendcommercialIteminMain1(VinItem items);

    int sendcommercialIteminMain2(VinItem items);

    int sendcommercialIteminShop1(VinItem items);

    int sendcommercialIteminShop2(VinItem items);

    int sendcommercialIteminShop3(VinItem items);

    int sendcommercialIteminShop4(VinItem items);

    int sendcommercialIteminShop5(VinItem items);

    int sendcommercialIteminShop6(VinItem items);
    int sendcommercialIteminShop7(VinItem items);

    int sendothersinMain1(VinItem items);

    int sendothersinMain2(VinItem items);

    int sendothersinShop1(VinItem items);

    int sendothersinShop2(VinItem items);

    int sendothersinShop3(VinItem items);

    int sendothersinShop4(VinItem items);

    int sendothersinShop5(VinItem items);

    int sendothersinShop6(VinItem items);
    int sendothersinShop7(VinItem items);


    //確認是否為新東西
    int addAllItem(Item items);

    String checkAllItem(String itemName);

    int ifExistinAllItem(String itemName);

    int ifExistIDinItem(String itemID);

    List<Item> queryAllItem();
    List<Item> queryAllItembyCategory(String category);

    Item queryAllItembyID(String id);

    int updateAllItem(Item item);


    //供應商
    Supplier querySupplierbyID(String supplierID);
    Supplier querySupplierbyName(String supplierName);
    int ifExistIDinSupplier(String supplierID);
    int ifExistNameinSupplier(String supplierName);
    int addSupplier(Supplier supplier);

    //查詢一項目
    VinItem queryIteminMain1byId(String id);

    VinItem queryIteminMain2byId(String id);

    VinItem queryIteminShop1byId(String id);

    VinItem queryIteminShop2byId(String id);

    VinItem queryIteminShop3byId(String id);

    VinItem queryIteminShop4byId(String id);

    VinItem queryIteminShop5byId(String id);

    VinItem queryIteminShop6byId(String id);
    VinItem queryIteminShop7byId(String id);

    VinItem querySmallIteminMain1byId(String id);

    VinItem querySmallIteminMain2byId(String id);

    VinItem querySmallIteminShop1byId(String id);

    VinItem querySmallIteminShop2byId(String id);

    VinItem querySmallIteminShop3byId(String id);

    VinItem querySmallIteminShop4byId(String id);

    VinItem querySmallIteminShop5byId(String id);

    VinItem querySmallIteminShop6byId(String id);
    VinItem querySmallIteminShop7byId(String id);

    VinItem queryFoodinMain1byId(String id);

    VinItem queryFoodinMain2byId(String id);

    VinItem queryFoodinShop1byId(String id);

    VinItem queryFoodinShop2byId(String id);

    VinItem queryFoodinShop3byId(String id);

    VinItem queryFoodinShop4byId(String id);

    VinItem queryFoodinShop5byId(String id);

    VinItem queryFoodinShop6byId(String id);
    VinItem queryFoodinShop7byId(String id);

    VinItem querycommercialIteminMain1byId(String id);

    VinItem querycommercialIteminMain2byId(String id);

    VinItem querycommercialIteminShop1byId(String id);

    VinItem querycommercialIteminShop2byId(String id);

    VinItem querycommercialIteminShop3byId(String id);

    VinItem querycommercialIteminShop4byId(String id);

    VinItem querycommercialIteminShop5byId(String id);

    VinItem querycommercialIteminShop6byId(String id);
    VinItem querycommercialIteminShop7byId(String id);

    VinItem queryothersinMain1byId(String id);

    VinItem queryothersinMain2byId(String id);

    VinItem queryothersinShop1byId(String id);

    VinItem queryothersinShop2byId(String id);

    VinItem queryothersinShop3byId(String id);

    VinItem queryothersinShop4byId(String id);

    VinItem queryothersinShop5byId(String id);

    VinItem queryothersinShop6byId(String id);
    VinItem queryothersinShop7byId(String id);


    //查詢一個項目的數目
    int queryItemNuminMain1byId(String id);

    int queryItemNuminMain2byId(String id);

    int queryItemNuminShop1byId(String id);

    int queryItemNuminShop2byId(String id);

    int queryItemNuminShop3byId(String id);

    int queryItemNuminShop4byId(String id);

    int queryItemNuminShop5byId(String id);

    int queryItemNuminShop6byId(String id);
    int queryItemNuminShop7byId(String id);

    int querySmallItemNuminMain1byId(String id);

    int querySmallItemNuminMain2byId(String id);

    int querySmallItemNuminShop1byId(String id);

    int querySmallItemNuminShop2byId(String id);

    int querySmallItemNuminShop3byId(String id);

    int querySmallItemNuminShop4byId(String id);

    int querySmallItemNuminShop5byId(String id);

    int querySmallItemNuminShop6byId(String id);
    int querySmallItemNuminShop7byId(String id);

    int queryFoodNuminMain1byId(String id);

    int queryFoodNuminMain2byId(String id);

    int queryFoodNuminShop1byId(String id);

    int queryFoodNuminShop2byId(String id);

    int queryFoodNuminShop3byId(String id);

    int queryFoodNuminShop4byId(String id);

    int queryFoodNuminShop5byId(String id);

    int queryFoodNuminShop6byId(String id);
    int queryFoodNuminShop7byId(String id);

    int querycommercialItemNuminMain1byId(String id);

    int querycommercialItemNuminMain2byId(String id);

    int querycommercialItemNuminShop1byId(String id);

    int querycommercialItemNuminShop2byId(String id);

    int querycommercialItemNuminShop3byId(String id);

    int querycommercialItemNuminShop4byId(String id);

    int querycommercialItemNuminShop5byId(String id);

    int querycommercialItemNuminShop6byId(String id);
    int querycommercialItemNuminShop7byId(String id);

    int queryothersNuminMain1byId(String id);

    int queryothersNuminMain2byId(String id);

    int queryothersNuminShop1byId(String id);

    int queryothersNuminShop2byId(String id);

    int queryothersNuminShop3byId(String id);

    int queryothersNuminShop4byId(String id);

    int queryothersNuminShop5byId(String id);

    int queryothersNuminShop6byId(String id);
    int queryothersNuminShop7byId(String id);

    //查詢全部的項目
    List<VinItem> queryAllIteminMain1();

    List<VinItem> queryAllIteminMain2();

    List<VinItem> queryAllIteminShop1();

    List<VinItem> queryAllIteminShop2();

    List<VinItem> queryAllIteminShop3();

    List<VinItem> queryAllIteminShop4();

    List<VinItem> queryAllIteminShop5();

    List<VinItem> queryAllIteminShop6();
    List<VinItem> queryAllIteminShop7();

    List<VinItem> queryAllSmallIteminMain1();

    List<VinItem> queryAllSmallIteminMain2();

    List<VinItem> queryAllSmallIteminShop1();

    List<VinItem> queryAllSmallIteminShop2();

    List<VinItem> queryAllSmallIteminShop3();

    List<VinItem> queryAllSmallIteminShop4();

    List<VinItem> queryAllSmallIteminShop5();

    List<VinItem> queryAllSmallIteminShop6();
    List<VinItem> queryAllSmallIteminShop7();

    List<VinItem> queryAllFoodinMain1();

    List<VinItem> queryAllFoodinMain2();

    List<VinItem> queryAllFoodinShop1();

    List<VinItem> queryAllFoodinShop2();

    List<VinItem> queryAllFoodinShop3();

    List<VinItem> queryAllFoodinShop4();

    List<VinItem> queryAllFoodinShop5();

    List<VinItem> queryAllFoodinShop6();
    List<VinItem> queryAllFoodinShop7();

    List<VinItem> queryAllcommercialIteminMain1();

    List<VinItem> queryAllcommercialIteminMain2();

    List<VinItem> queryAllcommercialIteminShop1();

    List<VinItem> queryAllcommercialIteminShop2();

    List<VinItem> queryAllcommercialIteminShop3();

    List<VinItem> queryAllcommercialIteminShop4();

    List<VinItem> queryAllcommercialIteminShop5();

    List<VinItem> queryAllcommercialIteminShop6();
    List<VinItem> queryAllcommercialIteminShop7();

    List<VinItem> queryAllothersinMain1();

    List<VinItem> queryAllothersinMain2();

    List<VinItem> queryAllothersinShop1();

    List<VinItem> queryAllothersinShop2();

    List<VinItem> queryAllothersinShop3();

    List<VinItem> queryAllothersinShop4();

    List<VinItem> queryAllothersinShop5();

    List<VinItem> queryAllothersinShop6();
    List<VinItem> queryAllothersinShop7();

    //根據名字查一個項目資料
//    VinItem queryIteminMain1ByName(String itemName);
//
//    VinItem queryIteminMain2ByName(String itemName);
//
//    VinItem queryIteminShop1ByName(String itemName);
//
//    VinItem queryIteminShop2ByName(String itemName);
//
//    VinItem queryIteminShop3ByName(String itemName);
//
//    VinItem queryIteminShop4ByName(String itemName);
//
//    VinItem queryIteminShop5ByName(String itemName);
//
//    VinItem queryIteminShop6ByName(String itemName);
//    VinItem queryIteminShop7ByName(String itemName);
//
//    VinItem querySmallIteminMain1ByName(String itemName);
//
//    VinItem querySmallIteminMain2ByName(String itemName);
//
//    VinItem querySmallIteminShop1ByName(String itemName);
//
//    VinItem querySmallIteminShop2ByName(String itemName);
//
//    VinItem querySmallIteminShop3ByName(String itemName);
//
//    VinItem querySmallIteminShop4ByName(String itemName);
//
//    VinItem querySmallIteminShop5ByName(String itemName);
//
//    VinItem querySmallIteminShop6ByName(String itemName);
//    VinItem querySmallIteminShop7ByName(String itemName);
//
//    VinItem queryFoodinMain1ByName(String itemName);
//
//    VinItem queryFoodinMain2ByName(String itemName);
//
//    VinItem queryFoodinShop1ByName(String itemName);
//
//    VinItem queryFoodinShop2ByName(String itemName);
//
//    VinItem queryFoodinShop3ByName(String itemName);
//
//    VinItem queryFoodinShop4ByName(String itemName);
//
//    VinItem queryFoodinShop5ByName(String itemName);
//
//    VinItem queryFoodinShop6ByName(String itemName);
//    VinItem queryFoodinShop7ByName(String itemName);
//
//    VinItem querycommercialIteminMain1ByName(String itemName);
//
//    VinItem querycommercialIteminMain2ByName(String itemName);
//
//    VinItem querycommercialIteminShop1ByName(String itemName);
//
//    VinItem querycommercialIteminShop2ByName(String itemName);
//
//    VinItem querycommercialIteminShop3ByName(String itemName);
//
//    VinItem querycommercialIteminShop4ByName(String itemName);
//
//    VinItem querycommercialIteminShop5ByName(String itemName);
//
//    VinItem querycommercialIteminShop6ByName(String itemName);
//    VinItem querycommercialIteminShop7ByName(String itemName);
//
//    VinItem queryothersinMain1ByName(String itemName);
//
//    VinItem queryothersinMain2ByName(String itemName);
//
//    VinItem queryothersinShop1ByName(String itemName);
//
//    VinItem queryothersinShop2ByName(String itemName);
//
//    VinItem queryothersinShop3ByName(String itemName);
//
//    VinItem queryothersinShop4ByName(String itemName);
//
//    VinItem queryothersinShop5ByName(String itemName);
//
//    VinItem queryothersinShop6ByName(String itemName);
//    VinItem queryothersinShop7ByName(String itemName);

    //這個跟上面重複！！！！！！！
//    VinItem queryItemNuminMain1byID(String id);
//
//    VinItem queryItemNuminMain2byID(String id);
//
//    VinItem queryItemNuminShop1byID(String id);
//
//    VinItem queryItemNuminShop2byID(String id);
//
//    VinItem queryItemNuminShop3byID(String id);
//
//    VinItem queryItemNuminShop4byID(String id);
//
//    VinItem queryItemNuminShop5byID(String id);
//
//    VinItem queryItemNuminShop6byID(String id);
//    VinItem queryItemNuminShop7byID(String id);
//
//    VinItem querySmallItemNuminMain1byID(String id);
//
//    VinItem querySmallItemNuminMain2byID(String id);
//
//    VinItem querySmallItemNuminShop1byID(String id);
//
//    VinItem querySmallItemNuminShop2byID(String id);
//
//    VinItem querySmallItemNuminShop3byID(String id);
//
//    VinItem querySmallItemNuminShop4byID(String id);
//
//    VinItem querySmallItemNuminShop5byID(String id);
//
//    VinItem querySmallItemNuminShop6byID(String id);
//    VinItem querySmallItemNuminShop7byID(String id);
//
//    VinItem queryFoodNuminMain1byID(String id);
//
//    VinItem queryFoodNuminMain2byID(String id);
//
//    VinItem queryFoodNuminShop1byID(String id);
//
//    VinItem queryFoodNuminShop2byID(String id);
//
//    VinItem queryFoodNuminShop3byID(String id);
//
//    VinItem queryFoodNuminShop4byID(String id);
//
//    VinItem queryFoodNuminShop5byID(String id);
//
//    VinItem queryFoodNuminShop6byID(String id);
//    VinItem queryFoodNuminShop7byID(String id);
//
//    VinItem querycommercialItemNuminMain1byID(String id);
//
//    VinItem querycommercialItemNuminMain2byID(String id);
//
//    VinItem querycommercialItemNuminShop1byID(String id);
//
//    VinItem querycommercialItemNuminShop2byID(String id);
//
//    VinItem querycommercialItemNuminShop3byID(String id);
//
//    VinItem querycommercialItemNuminShop4byID(String id);
//
//    VinItem querycommercialItemNuminShop5byID(String id);
//
//    VinItem querycommercialItemNuminShop6byID(String id);
//    VinItem querycommercialItemNuminShop7byID(String id);
//
//    VinItem queryothersNuminMain1byID(String id);
//
//    VinItem queryothersNuminMain2byID(String id);
//
//    VinItem queryothersNuminShop1byID(String id);
//
//    VinItem queryothersNuminShop2byID(String id);
//
//    VinItem queryothersNuminShop3byID(String id);
//
//    VinItem queryothersNuminShop4byID(String id);
//
//    VinItem queryothersNuminShop5byID(String id);
//
//    VinItem queryothersNuminShop6byID(String id);
//    VinItem queryothersNuminShop7byID(String id);


    //檢查有沒有存在
    int ifItemExistinMain1(String id);

    int ifItemExistinMain2(String id);

    int ifItemExistinShop1(String id);

    int ifItemExistinShop2(String id);

    int ifItemExistinShop3(String id);

    int ifItemExistinShop4(String id);

    int ifItemExistinShop5(String id);

    int ifItemExistinShop6(String id);
    int ifItemExistinShop7(String id);

    int ifSmallItemExistinMain1(String id);

    int ifSmallItemExistinMain2(String id);

    int ifSmallItemExistinShop1(String id);

    int ifSmallItemExistinShop2(String id);

    int ifSmallItemExistinShop3(String id);

    int ifSmallItemExistinShop4(String id);

    int ifSmallItemExistinShop5(String id);

    int ifSmallItemExistinShop6(String id);
    int ifSmallItemExistinShop7(String id);

    int ifFoodExistinMain1(String id);

    int ifFoodExistinMain2(String id);

    int ifFoodExistinShop1(String id);

    int ifFoodExistinShop2(String id);

    int ifFoodExistinShop3(String id);

    int ifFoodExistinShop4(String id);

    int ifFoodExistinShop5(String id);

    int ifFoodExistinShop6(String id);
    int ifFoodExistinShop7(String id);

    int ifcommercialItemExistinMain1(String id);

    int ifcommercialItemExistinMain2(String id);

    int ifcommercialItemExistinShop1(String id);

    int ifcommercialItemExistinShop2(String id);

    int ifcommercialItemExistinShop3(String id);

    int ifcommercialItemExistinShop4(String id);

    int ifcommercialItemExistinShop5(String id);

    int ifcommercialItemExistinShop6(String id);
    int ifcommercialItemExistinShop7(String id);

    int ifothersExistinMain1(String id);

    int ifothersExistinMain2(String id);

    int ifothersExistinShop1(String id);

    int ifothersExistinShop2(String id);

    int ifothersExistinShop3(String id);

    int ifothersExistinShop4(String id);

    int ifothersExistinShop5(String id);

    int ifothersExistinShop6(String id);
    int ifothersExistinShop7(String id);


    //從別的地方接收項目
    int updateItembySendfromMain1(VinItem items);

    int updateItembySendfromMain2(VinItem items);

    int updateItembySendfromShop1(VinItem items);

    int updateItembySendfromShop2(VinItem items);

    int updateItembySendfromShop3(VinItem items);

    int updateItembySendfromShop4(VinItem items);

    int updateItembySendfromShop5(VinItem items);

    int updateItembySendfromShop6(VinItem items);
    int updateItembySendfromShop7(VinItem items);

    int updateSmallItembySendfromMain1(VinItem items);

    int updateSmallItembySendfromMain2(VinItem items);

    int updateSmallItembySendfromShop1(VinItem items);

    int updateSmallItembySendfromShop2(VinItem items);

    int updateSmallItembySendfromShop3(VinItem items);

    int updateSmallItembySendfromShop4(VinItem items);

    int updateSmallItembySendfromShop5(VinItem items);

    int updateSmallItembySendfromShop6(VinItem items);
    int updateSmallItembySendfromShop7(VinItem items);

    int updateFoodbySendfromMain1(VinItem items);

    int updateFoodbySendfromMain2(VinItem items);

    int updateFoodbySendfromShop1(VinItem items);

    int updateFoodbySendfromShop2(VinItem items);

    int updateFoodbySendfromShop3(VinItem items);

    int updateFoodbySendfromShop4(VinItem items);

    int updateFoodbySendfromShop5(VinItem items);

    int updateFoodbySendfromShop6(VinItem items);
    int updateFoodbySendfromShop7(VinItem items);

    int updatecommercialItembySendfromMain1(VinItem items);

    int updatecommercialItembySendfromMain2(VinItem items);

    int updatecommercialItembySendfromShop1(VinItem items);

    int updatecommercialItembySendfromShop2(VinItem items);

    int updatecommercialItembySendfromShop3(VinItem items);

    int updatecommercialItembySendfromShop4(VinItem items);

    int updatecommercialItembySendfromShop5(VinItem items);

    int updatecommercialItembySendfromShop6(VinItem items);
    int updatecommercialItembySendfromShop7(VinItem items);

    int updateothersbySendfromMain1(VinItem items);

    int updateothersbySendfromMain2(VinItem items);

    int updateothersbySendfromShop1(VinItem items);

    int updateothersbySendfromShop2(VinItem items);

    int updateothersbySendfromShop3(VinItem items);

    int updateothersbySendfromShop4(VinItem items);

    int updateothersbySendfromShop5(VinItem items);

    int updateothersbySendfromShop6(VinItem items);
    int updateothersbySendfromShop7(VinItem items);

    User queryUserInformation(String uname);

    int addloginMain1(VinLog log);

    int addloginMain2(VinLog log);

    int addloginShop1(VinLog log);

    int addloginShop2(VinLog log);

    int addloginShop3(VinLog log);

    int addloginShop4(VinLog log);

    int addloginShop5(VinLog log);

    int addloginShop6(VinLog log);
    int addloginShop7(VinLog log);

    List<VinLog> queryCategoryLoginMain1(String category);

    List<VinLog> queryCategoryLoginMain2(String category);

    List<VinLog> queryCategoryLoginShop1(String category);

    List<VinLog> queryCategoryLoginShop2(String category);

    List<VinLog> queryCategoryLoginShop3(String category);

    List<VinLog> queryCategoryLoginShop4(String category);

    List<VinLog> queryCategoryLoginShop5(String category);

    List<VinLog> queryCategoryLoginShop6(String category);
    List<VinLog> queryCategoryLoginShop7(String category);

    List<VinLog> queryCategoryandIfCompleteLoginMain1(String category, boolean ifComplete);

    List<VinLog> queryCategoryandIfCompleteLoginMain2(String category, boolean ifComplete);

    List<VinLog> queryCategoryandIfCompleteLoginShop1(String category, boolean ifComplete);

    List<VinLog> queryCategoryandIfCompleteLoginShop2(String category, boolean ifComplete);

    List<VinLog> queryCategoryandIfCompleteLoginShop3(String category, boolean ifComplete);

    List<VinLog> queryCategoryandIfCompleteLoginShop4(String category, boolean ifComplete);

    List<VinLog> queryCategoryandIfCompleteLoginShop5(String category, boolean ifComplete);

    List<VinLog> queryCategoryandIfCompleteLoginShop6(String category, boolean ifComplete);
    List<VinLog> queryCategoryandIfCompleteLoginShop7(String category, boolean ifComplete);


    List<VinLog> queryCategoryReceiveinMain1(String category);

    List<VinLog> queryCategoryReceiveinMain2(String category);

    List<VinLog> queryCategoryReceiveinShop1(String category);

    List<VinLog> queryCategoryReceiveinShop2(String category);

    List<VinLog> queryCategoryReceiveinShop3(String category);

    List<VinLog> queryCategoryReceiveinShop4(String category);

    List<VinLog> queryCategoryReceiveinShop5(String category);

    List<VinLog> queryCategoryReceiveinShop6(String category);
    List<VinLog> queryCategoryReceiveinShop7(String category);

    int countCategoryReceiveinMain1(String category);
    int countCategoryReceiveinMain2(String category);
    int countCategoryReceiveinShop1(String category);
    int countCategoryReceiveinShop2(String category);
    int countCategoryReceiveinShop3(String category);
    int countCategoryReceiveinShop4(String category);
    int countCategoryReceiveinShop5(String category);
    int countCategoryReceiveinShop6(String category);
    int countCategoryReceiveinShop7(String category);

    List<VinLog> queryCategoryConfirminMain1(String category, String action, String action2);

    List<VinLog> queryCategoryConfirminMain2(String category, String action, String action2);

    List<VinLog> queryCategoryConfirminShop1(String category, String action, String action2);

    List<VinLog> queryCategoryConfirminShop2(String category, String action, String action2);

    List<VinLog> queryCategoryConfirminShop3(String category, String action, String action2);

    List<VinLog> queryCategoryConfirminShop4(String category, String action, String action2);

    List<VinLog> queryCategoryConfirminShop5(String category, String action, String action2);

    List<VinLog> queryCategoryConfirminShop6(String category, String action, String action2);
    List<VinLog> queryCategoryConfirminShop7(String category, String action, String action2);

    int countCategoryConfirminMain1(String category, String action, String action2);
    int countCategoryConfirminMain2(String category, String action, String action2);
    int countCategoryConfirminShop1(String category, String action, String action2);
    int countCategoryConfirminShop2(String category, String action, String action2);
    int countCategoryConfirminShop3(String category, String action, String action2);
    int countCategoryConfirminShop4(String category, String action, String action2);
    int countCategoryConfirminShop5(String category, String action, String action2);
    int countCategoryConfirminShop6(String category, String action, String action2);
    int countCategoryConfirminShop7(String category, String action, String action2);

    VinLog queryLoginmain1byid(String logid);

    VinLog queryLoginmain2byid(String logid);

    VinLog queryLoginshop1byid(String logid);

    VinLog queryLoginshop2byid(String logid);

    VinLog queryLoginshop3byid(String logid);

    VinLog queryLoginshop4byid(String logid);

    VinLog queryLoginshop5byid(String logid);

    VinLog queryLoginshop6byid(String logid);
    VinLog queryLoginshop7byid(String logid);

    int updateLoginmain1byid(VinLog vinLog);

    int updateLoginmain2byid(VinLog vinLog);

    int updateLoginshop1byid(VinLog vinLog);

    int updateLoginshop2byid(VinLog vinLog);

    int updateLoginshop3byid(VinLog vinLog);

    int updateLoginshop4byid(VinLog vinLog);

    int updateLoginshop5byid(VinLog vinLog);

    int updateLoginshop6byid(VinLog vinLog);
    int updateLoginshop7byid(VinLog vinLog);

    int deleteLoginMain1byLogid(String logid);

    int deleteLoginMain2byLogid(String logid);

    int deleteLoginShop1byLogid(String logid);

    int deleteLoginShop2byLogid(String logid);

    int deleteLoginShop3byLogid(String logid);

    int deleteLoginShop4byLogid(String logid);

    int deleteLoginShop5byLogid(String logid);

    int deleteLoginShop6byLogid(String logid);
    int deleteLoginShop7byLogid(String logid);

    Warehouse queryRealWarehouseName(String nickname);
    List<Warehouse> queryAllRealWarehouseName();

    int addCheckinMain1(VinCheck vinCheck);

    int addCheckinMain2(VinCheck vinCheck);

    int addCheckinShop1(VinCheck vinCheck);

    int addCheckinShop2(VinCheck vinCheck);

    int addCheckinShop3(VinCheck vinCheck);

    int addCheckinShop4(VinCheck vinCheck);

    int addCheckinShop5(VinCheck vinCheck);

    int addCheckinShop6(VinCheck vinCheck);
    int addCheckinShop7(VinCheck vinCheck);

    List<VinCheck> queryCheckinMain1(String category);

    List<VinCheck> queryCheckinMain2(String category);

    List<VinCheck> queryCheckinShop1(String category);

    List<VinCheck> queryCheckinShop2(String category);

    List<VinCheck> queryCheckinShop3(String category);

    List<VinCheck> queryCheckinShop4(String category);

    List<VinCheck> queryCheckinShop5(String category);

    List<VinCheck> queryCheckinShop6(String category);
    List<VinCheck> queryCheckinShop7(String category);

    List<VinCheck> queryCheckwithTimeinMain1(String category, String time);

    List<VinCheck> queryCheckwithTimeinMain2(String category, String time);

    List<VinCheck> queryCheckwithTimeinShop1(String category, String time);

    List<VinCheck> queryCheckwithTimeinShop2(String category, String time);

    List<VinCheck> queryCheckwithTimeinShop3(String category, String time);

    List<VinCheck> queryCheckwithTimeinShop4(String category, String time);

    List<VinCheck> queryCheckwithTimeinShop5(String category, String time);

    List<VinCheck> queryCheckwithTimeinShop6(String category, String time);
    List<VinCheck> queryCheckwithTimeinShop7(String category, String time);

    List<VinCheck> queryCheckwithTimeandIdinMain1(String category, String time, String id);

    List<VinCheck> queryCheckwithTimeandIdinMain2(String category, String time, String id);

    List<VinCheck> queryCheckwithTimeandIdinShop1(String category, String time, String id);

    List<VinCheck> queryCheckwithTimeandIdinShop2(String category, String time, String id);

    List<VinCheck> queryCheckwithTimeandIdinShop3(String category, String time, String id);

    List<VinCheck> queryCheckwithTimeandIdinShop4(String category, String time, String id);

    List<VinCheck> queryCheckwithTimeandIdinShop5(String category, String time, String id);

    List<VinCheck> queryCheckwithTimeandIdinShop6(String category, String time, String id);
    List<VinCheck> queryCheckwithTimeandIdinShop7(String category, String time, String id);

    int updateCheckinMain1byid(VinCheck vinCheck);

    int updateCheckinMain2byid(VinCheck vinCheck);

    int updateCheckinShop1byid(VinCheck vinCheck);

    int updateCheckinShop2byid(VinCheck vinCheck);

    int updateCheckinShop3byid(VinCheck vinCheck);

    int updateCheckinShop4byid(VinCheck vinCheck);

    int updateCheckinShop5byid(VinCheck vinCheck);

    int updateCheckinShop6byid(VinCheck vinCheck);
    int updateCheckinShop7byid(VinCheck vinCheck);

    List<VinCheck> queryCheckinMain1byID(String id);

    List<VinCheck> queryCheckinMain2byID(String id);

    List<VinCheck> queryCheckinShop1byID(String id);

    List<VinCheck> queryCheckinShop2byID(String id);

    List<VinCheck> queryCheckinShop3byID(String id);

    List<VinCheck> queryCheckinShop4byID(String id);

    List<VinCheck> queryCheckinShop5byID(String id);

    List<VinCheck> queryCheckinShop6byID(String id);
    List<VinCheck> queryCheckinShop7byID(String id);

    List<VinItemSimple> querySumitemCountbytimeinMain1(String time);

    List<VinItemSimple> querySumitemCountbytimeinMain2(String time);

    List<VinItemSimple> querySumitemCountbytimeinShop1(String time);

    List<VinItemSimple> querySumitemCountbytimeinShop2(String time);

    List<VinItemSimple> querySumitemCountbytimeinShop3(String time);

    List<VinItemSimple> querySumitemCountbytimeinShop4(String time);

    List<VinItemSimple> querySumitemCountbytimeinShop5(String time);

    List<VinItemSimple> querySumitemCountbytimeinShop6(String time);
    List<VinItemSimple> querySumitemCountbytimeinShop7(String time);

    int addSumitemCountinMain1(VinAlert vinAlert);

    int addSumitemCountinMain2(VinAlert vinAlert);

    int addSumitemCountinShop1(VinAlert vinAlert);

    int addSumitemCountinShop2(VinAlert vinAlert);

    int addSumitemCountinShop3(VinAlert vinAlert);

    int addSumitemCountinShop4(VinAlert vinAlert);

    int addSumitemCountinShop5(VinAlert vinAlert);

    int addSumitemCountinShop6(VinAlert vinAlert);
    int addSumitemCountinShop7(VinAlert vinAlert);


    List<VinAlert> queryifAlertinMain1(String time);
    List<VinAlert> queryifAlertinMain2(String time);
    List<VinAlert> queryifAlertinShop1(String time);
    List<VinAlert> queryifAlertinShop2(String time);

    List<VinAlert> queryifAlertinShop3(String time);

    List<VinAlert> queryifAlertinShop4(String time);

    List<VinAlert> queryifAlertinShop5(String time);

    List<VinAlert> queryifAlertinShop6(String time);

    List<VinAlert> queryifAlertinShop7(String time);

    VinLog queryLoginmain1byItemid(String id);

    VinLog queryLoginmain2byItemid(String id);

    VinLog queryLoginshop1byItemid(String id);

    VinLog queryLoginshop2byItemid(String id);

    VinLog queryLoginshop3byItemid(String id);

    VinLog queryLoginshop4byItemid(String id);

    VinLog queryLoginshop5byItemid(String id);

    VinLog queryLoginshop6byItemid(String id);
    VinLog queryLoginshop7byItemid(String id);

    List<VinLog> queryAllLoginmain1byItemid(String id);

    List<VinLog> queryAllLoginmain2byItemid(String id);

    List<VinLog> queryAllLoginshop1byItemid(String id);

    List<VinLog> queryAllLoginshop2byItemid(String id);

    List<VinLog> queryAllLoginshop3byItemid(String id);

    List<VinLog> queryAllLoginshop4byItemid(String id);

    List<VinLog> queryAllLoginshop5byItemid(String id);

    List<VinLog> queryAllLoginshop6byItemid(String id);
    List<VinLog> queryAllLoginshop7byItemid(String id);

    int updateItemNameAllLogbyidinMain1(VinLog vinLog);

    int updateItemNameAllLogbyidinMain2(VinLog vinLog);

    int updateItemNameAllLogbyidinShop1(VinLog vinLog);

    int updateItemNameAllLogbyidinShop2(VinLog vinLog);

    int updateItemNameAllLogbyidinShop3(VinLog vinLog);

    int updateItemNameAllLogbyidinShop4(VinLog vinLog);

    int updateItemNameAllLogbyidinShop5(VinLog vinLog);

    int updateItemNameAllLogbyidinShop6(VinLog vinLog);
    int updateItemNameAllLogbyidinShop7(VinLog vinLog);

    //main0
    int addIteminMain0(VinItem items);
    int addFoodinMain0(VinItem items);
    int addcommercialIteminMain0(VinItem items);
    int addothersinMain0(VinItem items);
    int addSmallIteminMain0(VinItem items);
    int deleteIteminMain0byId(String id);
    int deleteSmallIteminMain0byId(String id);
    int deleteFoodinMain0byId(String id);
    int deletecommercialIteminMain0byId(String id);
    int deleteothersinMain0byId(String id);
    int updateIteminMain0(VinItem items);
    int updateSmallIteminMain0(VinItem items);
    int updateFoodinMain0(VinItem items);
    int updatecommercialIteminMain0(VinItem items);
    int updateothersinMain0(VinItem items);
    int sendIteminMain0(VinItem items);
    int sendSmallIteminMain0(VinItem items);
    int sendFoodinMain0(VinItem items);
    int sendcommercialIteminMain0(VinItem items);
    int sendothersinMain0(VinItem items);
    VinItem queryIteminMain0byId(String id);
    VinItem querySmallIteminMain0byId(String id);
    VinItem queryFoodinMain0byId(String id);
    VinItem querycommercialIteminMain0byId(String id);
    VinItem queryothersinMain0byId(String id);
    int queryItemNuminMain0byId(String id);
    int querySmallItemNuminMain0byId(String id);
    int queryFoodNuminMain0byId(String id);
    int querycommercialItemNuminMain0byId(String id);
    int queryothersNuminMain0byId(String id);
    List<VinItem> queryAllIteminMain0();
    List<VinItem> queryAllSmallIteminMain0();
    List<VinItem> queryAllFoodinMain0();
    List<VinItem> queryAllcommercialIteminMain0();
    List<VinItem> queryAllothersinMain0();
//    VinItem queryIteminMain0ByName(String itemName);
//    VinItem querySmallIteminMain0ByName(String itemName);
//    VinItem queryFoodinMain0ByName(String itemName);
//    VinItem querycommercialIteminMain0ByName(String itemName);
//    VinItem queryothersinMain0ByName(String itemName);
//    VinItem queryItemNuminMain0byID(String id);
//    VinItem querySmallItemNuminMain0byID(String id);
//    VinItem queryFoodNuminMain0byID(String id);
//    VinItem querycommercialItemNuminMain0byID(String id);
//    VinItem queryothersNuminMain0byID(String id);
    int ifItemExistinMain0(String id);
    int ifSmallItemExistinMain0(String id);
    int ifFoodExistinMain0(String id);
    int ifcommercialItemExistinMain0(String id);
    int ifothersExistinMain0(String id);
    int updateItembySendfromMain0(VinItem items);
    int updateSmallItembySendfromMain0(VinItem items);
    int updateFoodbySendfromMain0(VinItem items);
    int updatecommercialItembySendfromMain0(VinItem items);
    int updateothersbySendfromMain0(VinItem items);
    int addloginMain0(VinLog log);
    List<VinLog> queryCategoryLoginMain0(String category);
    List<VinLog> queryCategoryandIfCompleteLoginMain0(String category, boolean ifComplete);
    List<VinLog> queryCategoryReceiveinMain0(String category);
    int countCategoryReceiveinMain0(String category);
    List<VinLog> queryCategoryConfirminMain0(String category, String action, String action2);
    int countCategoryConfirminMain0(String category, String action, String action2);
    VinLog queryLoginmain0byid(String logid);
    int updateLoginmain0byid(VinLog vinLog);
    int deleteLoginMain0byLogid(String logid);
    int addCheckinMain0(VinCheck vinCheck);
    List<VinCheck> queryCheckinMain0(String category);
    List<VinCheck> queryCheckwithTimeinMain0(String category, String time);
    List<VinCheck> queryCheckwithTimeandIdinMain0(String category, String time, String id);
    int updateCheckinMain0byid(VinCheck vinCheck);
    List<VinCheck> queryCheckinMain0byID(String id);
    List<VinItemSimple> querySumitemCountbytimeinMain0(String time);
    int addSumitemCountinMain0(VinAlert vinAlert);


    List<VinAlert> queryifAlertinMain0(String time);


    VinLog queryLoginmain0byItemid(String id);
    List<VinLog> queryAllLoginmain0byItemid(String id);
    int updateItemNameAllLogbyidinMain0(VinLog vinLog);


    //shop8
    int addIteminShop8(VinItem items);
    int addFoodinShop8(VinItem items);
    int addcommercialIteminShop8(VinItem items);
    int addothersinShop8(VinItem items);
    int addSmallIteminShop8(VinItem items);
    int deleteIteminShop8byId(String id);
    int deleteSmallIteminShop8byId(String id);
    int deleteFoodinShop8byId(String id);
    int deletecommercialIteminShop8byId(String id);
    int deleteothersinShop8byId(String id);
    int updateIteminShop8(VinItem items);
    int updateSmallIteminShop8(VinItem items);
    int updateFoodinShop8(VinItem items);
    int updatecommercialIteminShop8(VinItem items);
    int updateothersinShop8(VinItem items);
    int sendIteminShop8(VinItem items);
    int sendSmallIteminShop8(VinItem items);
    int sendFoodinShop8(VinItem items);
    int sendcommercialIteminShop8(VinItem items);
    int sendothersinShop8(VinItem items);
    VinItem queryIteminShop8byId(String id);
    VinItem querySmallIteminShop8byId(String id);
    VinItem queryFoodinShop8byId(String id);
    VinItem querycommercialIteminShop8byId(String id);
    VinItem queryothersinShop8byId(String id);
    int queryItemNuminShop8byId(String id);
    int querySmallItemNuminShop8byId(String id);
    int queryFoodNuminShop8byId(String id);
    int querycommercialItemNuminShop8byId(String id);
    int queryothersNuminShop8byId(String id);
    List<VinItem> queryAllIteminShop8();
    List<VinItem> queryAllSmallIteminShop8();
    List<VinItem> queryAllFoodinShop8();
    List<VinItem> queryAllcommercialIteminShop8();
    List<VinItem> queryAllothersinShop8();
//    VinItem queryIteminShop8ByName(String itemName);
//    VinItem querySmallIteminShop8ByName(String itemName);
//    VinItem queryFoodinShop8ByName(String itemName);
//    VinItem querycommercialIteminShop8ByName(String itemName);
//    VinItem queryothersinShop8ByName(String itemName);
//    VinItem queryItemNuminShop8byID(String id);
//    VinItem querySmallItemNuminShop8byID(String id);
//    VinItem queryFoodNuminShop8byID(String id);
//    VinItem querycommercialItemNuminShop8byID(String id);
//    VinItem queryothersNuminShop8byID(String id);
    int ifItemExistinShop8(String id);
    int ifSmallItemExistinShop8(String id);
    int ifFoodExistinShop8(String id);
    int ifcommercialItemExistinShop8(String id);
    int ifothersExistinShop8(String id);
    int updateItembySendfromShop8(VinItem items);
    int updateSmallItembySendfromShop8(VinItem items);
    int updateFoodbySendfromShop8(VinItem items);
    int updatecommercialItembySendfromShop8(VinItem items);
    int updateothersbySendfromShop8(VinItem items);
    int addloginShop8(VinLog log);
    List<VinLog> queryCategoryLoginShop8(String category);
    List<VinLog> queryCategoryandIfCompleteLoginShop8(String category, boolean ifComplete);
    List<VinLog> queryCategoryReceiveinShop8(String category);
    int countCategoryReceiveinShop8(String category);
    List<VinLog> queryCategoryConfirminShop8(String category, String action, String action2);
    int countCategoryConfirminShop8(String category, String action, String action2);
    VinLog queryLoginshop8byid(String logid);
    int updateLoginshop8byid(VinLog vinLog);
    int deleteLoginShop8byLogid(String logid);
    int addCheckinShop8(VinCheck vinCheck);
    List<VinCheck> queryCheckinShop8(String category);
    List<VinCheck> queryCheckwithTimeinShop8(String category, String time);
    List<VinCheck> queryCheckwithTimeandIdinShop8(String category, String time, String id);
    int updateCheckinShop8byid(VinCheck vinCheck);
    List<VinCheck> queryCheckinShop8byID(String id);
    List<VinItemSimple> querySumitemCountbytimeinShop8(String time);
    int addSumitemCountinShop8(VinAlert vinAlert);


    List<VinAlert> queryifAlertinShop8(String time);

    VinLog queryLoginshop8byItemid(String id);
    List<VinLog> queryAllLoginshop8byItemid(String id);
    int updateItemNameAllLogbyidinShop8(VinLog vinLog);


    //shop9
    int addIteminShop9(VinItem items);
    int addFoodinShop9(VinItem items);
    int addcommercialIteminShop9(VinItem items);
    int addothersinShop9(VinItem items);
    int addSmallIteminShop9(VinItem items);
    int deleteIteminShop9byId(String id);
    int deleteSmallIteminShop9byId(String id);
    int deleteFoodinShop9byId(String id);
    int deletecommercialIteminShop9byId(String id);
    int deleteothersinShop9byId(String id);
    int updateIteminShop9(VinItem items);
    int updateSmallIteminShop9(VinItem items);
    int updateFoodinShop9(VinItem items);
    int updatecommercialIteminShop9(VinItem items);
    int updateothersinShop9(VinItem items);
    int sendIteminShop9(VinItem items);
    int sendSmallIteminShop9(VinItem items);
    int sendFoodinShop9(VinItem items);
    int sendcommercialIteminShop9(VinItem items);
    int sendothersinShop9(VinItem items);
    VinItem queryIteminShop9byId(String id);
    VinItem querySmallIteminShop9byId(String id);
    VinItem queryFoodinShop9byId(String id);
    VinItem querycommercialIteminShop9byId(String id);
    VinItem queryothersinShop9byId(String id);
    int queryItemNuminShop9byId(String id);
    int querySmallItemNuminShop9byId(String id);
    int queryFoodNuminShop9byId(String id);
    int querycommercialItemNuminShop9byId(String id);
    int queryothersNuminShop9byId(String id);
    List<VinItem> queryAllIteminShop9();
    List<VinItem> queryAllSmallIteminShop9();
    List<VinItem> queryAllFoodinShop9();
    List<VinItem> queryAllcommercialIteminShop9();
    List<VinItem> queryAllothersinShop9();
//    VinItem queryIteminShop9ByName(String itemName);
//    VinItem querySmallIteminShop9ByName(String itemName);
//    VinItem queryFoodinShop9ByName(String itemName);
//    VinItem querycommercialIteminShop9ByName(String itemName);
//    VinItem queryothersinShop9ByName(String itemName);
//    VinItem queryItemNuminShop9byID(String id);
//    VinItem querySmallItemNuminShop9byID(String id);
//    VinItem queryFoodNuminShop9byID(String id);
//    VinItem querycommercialItemNuminShop9byID(String id);
//    VinItem queryothersNuminShop9byID(String id);
    int ifItemExistinShop9(String id);
    int ifSmallItemExistinShop9(String id);
    int ifFoodExistinShop9(String id);
    int ifcommercialItemExistinShop9(String id);
    int ifothersExistinShop9(String id);
    int updateItembySendfromShop9(VinItem items);
    int updateSmallItembySendfromShop9(VinItem items);
    int updateFoodbySendfromShop9(VinItem items);
    int updatecommercialItembySendfromShop9(VinItem items);
    int updateothersbySendfromShop9(VinItem items);
    int addloginShop9(VinLog log);
    List<VinLog> queryCategoryLoginShop9(String category);
    List<VinLog> queryCategoryandIfCompleteLoginShop9(String category, boolean ifComplete);
    List<VinLog> queryCategoryReceiveinShop9(String category);
    int countCategoryReceiveinShop9(String category);
    List<VinLog> queryCategoryConfirminShop9(String category, String action, String action2);
    int countCategoryConfirminShop9(String category, String action, String action2);
    VinLog queryLoginshop9byid(String logid);
    int updateLoginshop9byid(VinLog vinLog);
    int deleteLoginShop9byLogid(String logid);
    int addCheckinShop9(VinCheck vinCheck);
    List<VinCheck> queryCheckinShop9(String category);
    List<VinCheck> queryCheckwithTimeinShop9(String category, String time);
    List<VinCheck> queryCheckwithTimeandIdinShop9(String category, String time, String id);
    int updateCheckinShop9byid(VinCheck vinCheck);
    List<VinCheck> queryCheckinShop9byID(String id);
    List<VinItemSimple> querySumitemCountbytimeinShop9(String time);
    int addSumitemCountinShop9(VinAlert vinAlert);

    List<VinAlert> queryifAlertinShop9(String time);

    VinLog queryLoginshop9byItemid(String id);
    List<VinLog> queryAllLoginshop9byItemid(String id);
    int updateItemNameAllLogbyidinShop9(VinLog vinLog);



    //shop10
    int addIteminShop10(VinItem items);
    int addFoodinShop10(VinItem items);
    int addcommercialIteminShop10(VinItem items);
    int addothersinShop10(VinItem items);
    int addSmallIteminShop10(VinItem items);
    int deleteIteminShop10byId(String id);
    int deleteSmallIteminShop10byId(String id);
    int deleteFoodinShop10byId(String id);
    int deletecommercialIteminShop10byId(String id);
    int deleteothersinShop10byId(String id);
    int updateIteminShop10(VinItem items);
    int updateSmallIteminShop10(VinItem items);
    int updateFoodinShop10(VinItem items);
    int updatecommercialIteminShop10(VinItem items);
    int updateothersinShop10(VinItem items);
    int sendIteminShop10(VinItem items);
    int sendSmallIteminShop10(VinItem items);
    int sendFoodinShop10(VinItem items);
    int sendcommercialIteminShop10(VinItem items);
    int sendothersinShop10(VinItem items);
    VinItem queryIteminShop10byId(String id);
    VinItem querySmallIteminShop10byId(String id);
    VinItem queryFoodinShop10byId(String id);
    VinItem querycommercialIteminShop10byId(String id);
    VinItem queryothersinShop10byId(String id);
    int queryItemNuminShop10byId(String id);
    int querySmallItemNuminShop10byId(String id);
    int queryFoodNuminShop10byId(String id);
    int querycommercialItemNuminShop10byId(String id);
    int queryothersNuminShop10byId(String id);
    List<VinItem> queryAllIteminShop10();
    List<VinItem> queryAllSmallIteminShop10();
    List<VinItem> queryAllFoodinShop10();
    List<VinItem> queryAllcommercialIteminShop10();
    List<VinItem> queryAllothersinShop10();
//    VinItem queryIteminShop10ByName(String itemName);
//    VinItem querySmallIteminShop10ByName(String itemName);
//    VinItem queryFoodinShop10ByName(String itemName);
//    VinItem querycommercialIteminShop10ByName(String itemName);
//    VinItem queryothersinShop10ByName(String itemName);
//    VinItem queryItemNuminShop10byID(String id);
//    VinItem querySmallItemNuminShop10byID(String id);
//    VinItem queryFoodNuminShop10byID(String id);
//    VinItem querycommercialItemNuminShop10byID(String id);
//    VinItem queryothersNuminShop10byID(String id);
    int ifItemExistinShop10(String id);
    int ifSmallItemExistinShop10(String id);
    int ifFoodExistinShop10(String id);
    int ifcommercialItemExistinShop10(String id);
    int ifothersExistinShop10(String id);
    int updateItembySendfromShop10(VinItem items);
    int updateSmallItembySendfromShop10(VinItem items);
    int updateFoodbySendfromShop10(VinItem items);
    int updatecommercialItembySendfromShop10(VinItem items);
    int updateothersbySendfromShop10(VinItem items);
    int addloginShop10(VinLog log);
    List<VinLog> queryCategoryLoginShop10(String category);
    List<VinLog> queryCategoryandIfCompleteLoginShop10(String category, boolean ifComplete);
    List<VinLog> queryCategoryReceiveinShop10(String category);
    int countCategoryReceiveinShop10(String category);
    List<VinLog> queryCategoryConfirminShop10(String category, String action, String action2);
    int countCategoryConfirminShop10(String category, String action, String action2);
    VinLog queryLoginshop10byid(String logid);
    int updateLoginshop10byid(VinLog vinLog);
    int deleteLoginShop10byLogid(String logid);
    int addCheckinShop10(VinCheck vinCheck);
    List<VinCheck> queryCheckinShop10(String category);
    List<VinCheck> queryCheckwithTimeinShop10(String category, String time);
    List<VinCheck> queryCheckwithTimeandIdinShop10(String category, String time, String id);
    int updateCheckinShop10byid(VinCheck vinCheck);
    List<VinCheck> queryCheckinShop10byID(String id);
    List<VinItemSimple> querySumitemCountbytimeinShop10(String time);
    int addSumitemCountinShop10(VinAlert vinAlert);
    List<VinAlert> queryifAlertinShop10(String time);
    VinLog queryLoginshop10byItemid(String id);
    List<VinLog> queryAllLoginshop10byItemid(String id);
    int updateItemNameAllLogbyidinShop10(VinLog vinLog);

    //shop11
    int addIteminShop11(VinItem items);
    int addFoodinShop11(VinItem items);
    int addcommercialIteminShop11(VinItem items);
    int addothersinShop11(VinItem items);
    int addSmallIteminShop11(VinItem items);
    int deleteIteminShop11byId(String id);
    int deleteSmallIteminShop11byId(String id);
    int deleteFoodinShop11byId(String id);
    int deletecommercialIteminShop11byId(String id);
    int deleteothersinShop11byId(String id);
    int updateIteminShop11(VinItem items);
    int updateSmallIteminShop11(VinItem items);
    int updateFoodinShop11(VinItem items);
    int updatecommercialIteminShop11(VinItem items);
    int updateothersinShop11(VinItem items);
    int sendIteminShop11(VinItem items);
    int sendSmallIteminShop11(VinItem items);
    int sendFoodinShop11(VinItem items);
    int sendcommercialIteminShop11(VinItem items);
    int sendothersinShop11(VinItem items);
    VinItem queryIteminShop11byId(String id);
    VinItem querySmallIteminShop11byId(String id);
    VinItem queryFoodinShop11byId(String id);
    VinItem querycommercialIteminShop11byId(String id);
    VinItem queryothersinShop11byId(String id);
    int queryItemNuminShop11byId(String id);
    int querySmallItemNuminShop11byId(String id);
    int queryFoodNuminShop11byId(String id);
    int querycommercialItemNuminShop11byId(String id);
    int queryothersNuminShop11byId(String id);
    List<VinItem> queryAllIteminShop11();
    List<VinItem> queryAllSmallIteminShop11();
    List<VinItem> queryAllFoodinShop11();
    List<VinItem> queryAllcommercialIteminShop11();
    List<VinItem> queryAllothersinShop11();
    //    VinItem queryIteminShop11ByName(String itemName);
//    VinItem querySmallIteminShop11ByName(String itemName);
//    VinItem queryFoodinShop11ByName(String itemName);
//    VinItem querycommercialIteminShop11ByName(String itemName);
//    VinItem queryothersinShop11ByName(String itemName);
//    VinItem queryItemNuminShop11byID(String id);
//    VinItem querySmallItemNuminShop11byID(String id);
//    VinItem queryFoodNuminShop11byID(String id);
//    VinItem querycommercialItemNuminShop11byID(String id);
//    VinItem queryothersNuminShop11byID(String id);
    int ifItemExistinShop11(String id);
    int ifSmallItemExistinShop11(String id);
    int ifFoodExistinShop11(String id);
    int ifcommercialItemExistinShop11(String id);
    int ifothersExistinShop11(String id);
    int updateItembySendfromShop11(VinItem items);
    int updateSmallItembySendfromShop11(VinItem items);
    int updateFoodbySendfromShop11(VinItem items);
    int updatecommercialItembySendfromShop11(VinItem items);
    int updateothersbySendfromShop11(VinItem items);
    int addloginShop11(VinLog log);
    List<VinLog> queryCategoryLoginShop11(String category);
    List<VinLog> queryCategoryandIfCompleteLoginShop11(String category, boolean ifComplete);
    List<VinLog> queryCategoryReceiveinShop11(String category);
    int countCategoryReceiveinShop11(String category);
    List<VinLog> queryCategoryConfirminShop11(String category, String action, String action2);
    int countCategoryConfirminShop11(String category, String action, String action2);
    VinLog queryLoginshop11byid(String logid);
    int updateLoginshop11byid(VinLog vinLog);
    int deleteLoginShop11byLogid(String logid);
    int addCheckinShop11(VinCheck vinCheck);
    List<VinCheck> queryCheckinShop11(String category);
    List<VinCheck> queryCheckwithTimeinShop11(String category, String time);
    List<VinCheck> queryCheckwithTimeandIdinShop11(String category, String time, String id);
    int updateCheckinShop11byid(VinCheck vinCheck);
    List<VinCheck> queryCheckinShop11byID(String id);
    List<VinItemSimple> querySumitemCountbytimeinShop11(String time);
    int addSumitemCountinShop11(VinAlert vinAlert);
    List<VinAlert> queryifAlertinShop11(String time);
    VinLog queryLoginshop11byItemid(String id);
    List<VinLog> queryAllLoginshop11byItemid(String id);
    int updateItemNameAllLogbyidinShop11(VinLog vinLog);

    //shop12
    int addIteminShop12(VinItem items);
    int addFoodinShop12(VinItem items);
    int addcommercialIteminShop12(VinItem items);
    int addothersinShop12(VinItem items);
    int addSmallIteminShop12(VinItem items);
    int deleteIteminShop12byId(String id);
    int deleteSmallIteminShop12byId(String id);
    int deleteFoodinShop12byId(String id);
    int deletecommercialIteminShop12byId(String id);
    int deleteothersinShop12byId(String id);
    int updateIteminShop12(VinItem items);
    int updateSmallIteminShop12(VinItem items);
    int updateFoodinShop12(VinItem items);
    int updatecommercialIteminShop12(VinItem items);
    int updateothersinShop12(VinItem items);
    int sendIteminShop12(VinItem items);
    int sendSmallIteminShop12(VinItem items);
    int sendFoodinShop12(VinItem items);
    int sendcommercialIteminShop12(VinItem items);
    int sendothersinShop12(VinItem items);
    VinItem queryIteminShop12byId(String id);
    VinItem querySmallIteminShop12byId(String id);
    VinItem queryFoodinShop12byId(String id);
    VinItem querycommercialIteminShop12byId(String id);
    VinItem queryothersinShop12byId(String id);
    int queryItemNuminShop12byId(String id);
    int querySmallItemNuminShop12byId(String id);
    int queryFoodNuminShop12byId(String id);
    int querycommercialItemNuminShop12byId(String id);
    int queryothersNuminShop12byId(String id);
    List<VinItem> queryAllIteminShop12();
    List<VinItem> queryAllSmallIteminShop12();
    List<VinItem> queryAllFoodinShop12();
    List<VinItem> queryAllcommercialIteminShop12();
    List<VinItem> queryAllothersinShop12();
    //    VinItem queryIteminShop12ByName(String itemName);
//    VinItem querySmallIteminShop12ByName(String itemName);
//    VinItem queryFoodinShop12ByName(String itemName);
//    VinItem querycommercialIteminShop12ByName(String itemName);
//    VinItem queryothersinShop12ByName(String itemName);
//    VinItem queryItemNuminShop12byID(String id);
//    VinItem querySmallItemNuminShop12byID(String id);
//    VinItem queryFoodNuminShop12byID(String id);
//    VinItem querycommercialItemNuminShop12byID(String id);
//    VinItem queryothersNuminShop12byID(String id);
    int ifItemExistinShop12(String id);
    int ifSmallItemExistinShop12(String id);
    int ifFoodExistinShop12(String id);
    int ifcommercialItemExistinShop12(String id);
    int ifothersExistinShop12(String id);
    int updateItembySendfromShop12(VinItem items);
    int updateSmallItembySendfromShop12(VinItem items);
    int updateFoodbySendfromShop12(VinItem items);
    int updatecommercialItembySendfromShop12(VinItem items);
    int updateothersbySendfromShop12(VinItem items);
    int addloginShop12(VinLog log);
    List<VinLog> queryCategoryLoginShop12(String category);
    List<VinLog> queryCategoryandIfCompleteLoginShop12(String category, boolean ifComplete);
    List<VinLog> queryCategoryReceiveinShop12(String category);
    int countCategoryReceiveinShop12(String category);
    List<VinLog> queryCategoryConfirminShop12(String category, String action, String action2);
    int countCategoryConfirminShop12(String category, String action, String action2);
    VinLog queryLoginshop12byid(String logid);
    int updateLoginshop12byid(VinLog vinLog);
    int deleteLoginShop12byLogid(String logid);
    int addCheckinShop12(VinCheck vinCheck);
    List<VinCheck> queryCheckinShop12(String category);
    List<VinCheck> queryCheckwithTimeinShop12(String category, String time);
    List<VinCheck> queryCheckwithTimeandIdinShop12(String category, String time, String id);
    int updateCheckinShop12byid(VinCheck vinCheck);
    List<VinCheck> queryCheckinShop12byID(String id);
    List<VinItemSimple> querySumitemCountbytimeinShop12(String time);
    int addSumitemCountinShop12(VinAlert vinAlert);
    List<VinAlert> queryifAlertinShop12(String time);
    VinLog queryLoginshop12byItemid(String id);
    List<VinLog> queryAllLoginshop12byItemid(String id);
    int updateItemNameAllLogbyidinShop12(VinLog vinLog);









    int addDumpItem(Dumplist dumplist);

    List<Dumplist> queryDumpItemwithLocationandCategory(String location, String category, boolean if_pass);

    int updateDumpStatusbyLogId(String logid, String status);

    int queryDumpLogCountbyLogId(String logid);

    Dumplist queryDumpLogbyLogId(String logid);

    int updateDumpbyLogId(Dumplist dumplist);

    int iflogidExistindumplist(String logid);

    int addReceiveError(ReceiveError receiveError);

    List<ReceiveError> queryReceiveError(String location, String categoty);

    List<ReceiveError> queryReceiveErrorbyComplete(String location, String categoty, boolean ifComplete);

    int updateReceiveErrorifComplete(String logid, boolean ifComplete);

    int addFruitInvoice(FruitInvoice fruitInvoice);

    int updateFruitInvoice(FruitInvoice fruitInvoice);


    FruitInvoice queryFruitInvoicebyInvoiceid(String invoiceid);

    List<FruitInvoice> queryFruitInvoice(String location);
    int deleteFruitInvoicebyInvoiceID(String invoiceid);

    int addFruitInvoiceSec(FruitInvoiceSec fruitInvoiceSec);
    int updateFruitInvoiceSec(FruitInvoiceSec fruitInvoiceSec);
    FruitInvoiceSec queryFruitInvoiceSecbyID(String id);
    List<FruitInvoiceSec> queryFruitInvoiceSecbyMonth(String month);
    int ifExistFruitInvoiceSecID(String id);
    int updateFileType(FilePath filePath);
    int addFileType(FilePath filePath);
    FilePath queryFileTypebyid(String id);
    int ifExistFileTypebyID(String id);

    int addExpiredDate(Expired expired);
    List<Expired> queryAllExpiredDatebyLocation(String location);
    List<Expired> queryExpiredDatebyLocationTime(String location, String time);
    List<Expired> queryExpiredItembyLocationTime(String location, String time);
    List<Expired> queryExpiredSoonItembyLocationTime(String location, String time1, String time2);
    int updateExpiredDate(String time, int id, boolean ifDump);
    Expired queryExpiredbyID(int id);
    int queryNotInputDateinExpireCount(String location);

    int addKryOrder(KryOrder kryOrder);
    int addKryOrderDetail(KryDishInfo kryDishInfo);

    int addApplyItem(ApplyItem applyItem);
    List<ApplyItem> queryApplyItembyLocation(String location);
    ApplyItem queryApplyItembyLogID(String logID);
    int deleteApplyItem(String logID);
    int updateApplyItem(ApplyItem applyItem);

    List<ApplyItemSec> queryApplyItemSecbyMonth(String month);
    ApplyItemSec queryApplyItemSecbyID(String id);
    int addApplyItemSec(ApplyItemSec applyItemSec);
    int updateApplyItemSec(ApplyItemSec applyItemSec);
    int ifExistApplyItemSec(String id);


    int addItemCommercialSet(ItemSet itemSet);
    int addItemFoodSet(ItemSet itemSet);
    int addItemOthersSet(ItemSet itemSet);
    int addItemSmallToolSet(ItemSet itemSet);
    int addItemToolSet(ItemSet itemSet);

    List<ItemSet> queryAllItemCommercialSet();
    List<ItemSet> queryAllItemFoodSet();
    List<ItemSet> queryAllItemOthersSet();
    List<ItemSet> queryAllItemSmallToolSet();
    List<ItemSet> queryAllItemToolSet();


    //////////////////////////工具類!////////////////////////////////////////////////////////////////////////////////////////////////
    boolean ifAccess(User user, String location);

    String getUUID();

    HashMap<String, String> getWarehouseMap();

    String getDate();

    String getDateTime();

    String getMonth();

//    void addLog(String action, VinItem vinItem, String category, String from, String to, CommonsMultipartFile file, HttpServletRequest request) throws IOException;

    void checkIfExistandAddinAllItem(VinItem vinItem);

    void toaddItem(String nickname, String mainWarehouse, String action, String type, Model model, String category);

    void toupdateItem(String nickname, String mainWarehouse, String action, String type, Model model, VinItem vinItem, int userLevel, String category);

    void kafkaDoUpdate(VinItem vinItem, String category, String location);

    void kafkaAddDailyCheck(VinCheck vinCheck, String location);

    VinItem getVinItem(String location, String category, String id);

    List<VinItem> getVinItemList(String location, String category);

    void addFruitInvoiceandFile(FruitInvoice invoice, CommonsMultipartFile file, HttpServletRequest request) throws IOException;
//    void deleteVinItem(String location, String category, VinItem id);

//    boolean setRedisLock(String key, VinItem value) throws InterruptedException;
//    void deleteRedisLock(String key);
//    boolean waitRedisLock(String key) throws InterruptedException;

//    void cacheable(String key, List<VinItem> vinItemList);
//    List<VinItem> getVinItemCache(String key);
//    void updateCache(String key, VinItem vinItem, String location, String category);
//    void addCache(String key, VinItem vinItem, String location, String category);
//    void deleteCache(String key, String id);

//    VinLog getLogbylogid(String location, String logid);
//    void updateLogbylogid(String location, VinLog vinLog);
    int ifExist(String location, String category, String id);
    void addVinItem(String location, String category, VinItem vinItem);

    int getConfirmCount(String location, String category, String action1, String action2);
    int getReceiveCount(String location, String category);
//
//    void decreaseNotReceiveCount(String location);
//    void decreaseNotConfirmCount(String location);
//    void increaseNotReceiveCount(String location);
//    void increaseNotConfirmCount(String location);


//    Map<String,String> getExpiredItemCache(String location);
//    Map<String,String> getExpiredSoonItemCache(String location);
//    String getExpiredItemCountCache(String location);
//    String getExpiredSoonItemCountCache(String location);
//    void reloadExpiredandExpiredSoonCache(String location);
    List<VinAlert> getifAlert(String location, String date);

    String getMonthfromTime(String time);

//    /**
//     *
//     * @param logid
//     * @param prefix
//     * @apiNote In case click two times
//     * @return boolean
//     */
//    boolean ifDobyLogid(String logid, String prefix);

    HashMap<String, String> getActionMap();

    int queryVinItemCount(String location, String category, String id);

    Map<String,String> getCategoryMap();






}
