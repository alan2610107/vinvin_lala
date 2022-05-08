package com.kuang.dao;

import com.kuang.pojo.*;
import org.apache.ibatis.annotations.Param;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

import java.util.List;

public interface VinMapper {
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
    String checkAllItem(@Param("itemName")String itemName);
    int ifExistinAllItem(@Param("itemName")String itemName);
    int ifExistIDinItem(@Param("itemID")String itemID);
    List<Item> queryAllItem();
    List<Item> queryAllItembyCategory(@Param("category") String category);
    Item queryAllItembyID(@Param("itemID") String id);
    int updateAllItem(Item item);
    int deleteItem(String itemID);

    //供應商
    Supplier querySupplierbyID(@Param("supplierID") String supplierID);
    Supplier querySupplierbyName(@Param("supplierName") String supplierName);
    int ifExistIDinSupplier(@Param("supplierID") String supplierID);
    int ifExistNameinSupplier(@Param("supplierName") String supplierName);
    int addSupplier(Supplier supplier);

    //查詢一項目
    VinItem queryIteminMain1byId(@Param("id")String id);
    VinItem queryIteminMain2byId(@Param("id")String id);
    VinItem queryIteminShop1byId(@Param("id")String id);
    VinItem queryIteminShop2byId(@Param("id")String id);
    VinItem queryIteminShop3byId(@Param("id")String id);
    VinItem queryIteminShop4byId(@Param("id")String id);
    VinItem queryIteminShop5byId(@Param("id")String id);
    VinItem queryIteminShop6byId(@Param("id")String id);
    VinItem queryIteminShop7byId(@Param("id")String id);

    VinItem querySmallIteminMain1byId(@Param("id")String id);
    VinItem querySmallIteminMain2byId(@Param("id")String id);
    VinItem querySmallIteminShop1byId(@Param("id")String id);
    VinItem querySmallIteminShop2byId(@Param("id")String id);
    VinItem querySmallIteminShop3byId(@Param("id")String id);
    VinItem querySmallIteminShop4byId(@Param("id")String id);
    VinItem querySmallIteminShop5byId(@Param("id")String id);
    VinItem querySmallIteminShop6byId(@Param("id")String id);
    VinItem querySmallIteminShop7byId(@Param("id")String id);

    VinItem queryFoodinMain1byId(@Param("id")String id);
    VinItem queryFoodinMain2byId(@Param("id")String id);
    VinItem queryFoodinShop1byId(@Param("id")String id);
    VinItem queryFoodinShop2byId(@Param("id")String id);
    VinItem queryFoodinShop3byId(@Param("id")String id);
    VinItem queryFoodinShop4byId(@Param("id")String id);
    VinItem queryFoodinShop5byId(@Param("id")String id);
    VinItem queryFoodinShop6byId(@Param("id")String id);
    VinItem queryFoodinShop7byId(@Param("id")String id);

    VinItem querycommercialIteminMain1byId(@Param("id")String id);
    VinItem querycommercialIteminMain2byId(@Param("id")String id);
    VinItem querycommercialIteminShop1byId(@Param("id")String id);
    VinItem querycommercialIteminShop2byId(@Param("id")String id);
    VinItem querycommercialIteminShop3byId(@Param("id")String id);
    VinItem querycommercialIteminShop4byId(@Param("id")String id);
    VinItem querycommercialIteminShop5byId(@Param("id")String id);
    VinItem querycommercialIteminShop6byId(@Param("id")String id);
    VinItem querycommercialIteminShop7byId(@Param("id")String id);

    VinItem queryothersinMain1byId(@Param("id")String id);
    VinItem queryothersinMain2byId(@Param("id")String id);
    VinItem queryothersinShop1byId(@Param("id")String id);
    VinItem queryothersinShop2byId(@Param("id")String id);
    VinItem queryothersinShop3byId(@Param("id")String id);
    VinItem queryothersinShop4byId(@Param("id")String id);
    VinItem queryothersinShop5byId(@Param("id")String id);
    VinItem queryothersinShop6byId(@Param("id")String id);
    VinItem queryothersinShop7byId(@Param("id")String id);


    //查詢一個項目的數目
    int queryItemNuminMain1byId(@Param("id")String id);
    int queryItemNuminMain2byId(@Param("id")String id);
    int queryItemNuminShop1byId(@Param("id")String id);
    int queryItemNuminShop2byId(@Param("id")String id);
    int queryItemNuminShop3byId(@Param("id")String id);
    int queryItemNuminShop4byId(@Param("id")String id);
    int queryItemNuminShop5byId(@Param("id")String id);
    int queryItemNuminShop6byId(@Param("id")String id);
    int queryItemNuminShop7byId(@Param("id")String id);

    int querySmallItemNuminMain1byId(@Param("id")String id);
    int querySmallItemNuminMain2byId(@Param("id")String id);
    int querySmallItemNuminShop1byId(@Param("id")String id);
    int querySmallItemNuminShop2byId(@Param("id")String id);
    int querySmallItemNuminShop3byId(@Param("id")String id);
    int querySmallItemNuminShop4byId(@Param("id")String id);
    int querySmallItemNuminShop5byId(@Param("id")String id);
    int querySmallItemNuminShop6byId(@Param("id")String id);
    int querySmallItemNuminShop7byId(@Param("id")String id);

    int queryFoodNuminMain1byId(@Param("id")String id);
    int queryFoodNuminMain2byId(@Param("id")String id);
    int queryFoodNuminShop1byId(@Param("id")String id);
    int queryFoodNuminShop2byId(@Param("id")String id);
    int queryFoodNuminShop3byId(@Param("id")String id);
    int queryFoodNuminShop4byId(@Param("id")String id);
    int queryFoodNuminShop5byId(@Param("id")String id);
    int queryFoodNuminShop6byId(@Param("id")String id);
    int queryFoodNuminShop7byId(@Param("id")String id);

    int querycommercialItemNuminMain1byId(@Param("id")String id);
    int querycommercialItemNuminMain2byId(@Param("id")String id);
    int querycommercialItemNuminShop1byId(@Param("id")String id);
    int querycommercialItemNuminShop2byId(@Param("id")String id);
    int querycommercialItemNuminShop3byId(@Param("id")String id);
    int querycommercialItemNuminShop4byId(@Param("id")String id);
    int querycommercialItemNuminShop5byId(@Param("id")String id);
    int querycommercialItemNuminShop6byId(@Param("id")String id);
    int querycommercialItemNuminShop7byId(@Param("id")String id);

    int queryothersNuminMain1byId(@Param("id")String id);
    int queryothersNuminMain2byId(@Param("id")String id);
    int queryothersNuminShop1byId(@Param("id")String id);
    int queryothersNuminShop2byId(@Param("id")String id);
    int queryothersNuminShop3byId(@Param("id")String id);
    int queryothersNuminShop4byId(@Param("id")String id);
    int queryothersNuminShop5byId(@Param("id")String id);
    int queryothersNuminShop6byId(@Param("id")String id);
    int queryothersNuminShop7byId(@Param("id")String id);

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
//    VinItem queryIteminMain1ByName(@Param("itemName")String itemName);
//    VinItem queryIteminMain2ByName(@Param("itemName")String itemName);
//    VinItem queryIteminShop1ByName(@Param("itemName")String itemName);
//    VinItem queryIteminShop2ByName(@Param("itemName")String itemName);
//    VinItem queryIteminShop3ByName(@Param("itemName")String itemName);
//    VinItem queryIteminShop4ByName(@Param("itemName")String itemName);
//    VinItem queryIteminShop5ByName(@Param("itemName")String itemName);
//    VinItem queryIteminShop6ByName(@Param("itemName")String itemName);
//    VinItem queryIteminShop7ByName(@Param("itemName")String itemName);
//
//    VinItem querySmallIteminMain1ByName(@Param("itemName")String itemName);
//    VinItem querySmallIteminMain2ByName(@Param("itemName")String itemName);
//    VinItem querySmallIteminShop1ByName(@Param("itemName")String itemName);
//    VinItem querySmallIteminShop2ByName(@Param("itemName")String itemName);
//    VinItem querySmallIteminShop3ByName(@Param("itemName")String itemName);
//    VinItem querySmallIteminShop4ByName(@Param("itemName")String itemName);
//    VinItem querySmallIteminShop5ByName(@Param("itemName")String itemName);
//    VinItem querySmallIteminShop6ByName(@Param("itemName")String itemName);
//    VinItem querySmallIteminShop7ByName(@Param("itemName")String itemName);
//
//    VinItem queryFoodinMain1ByName(@Param("itemName")String itemName);
//    VinItem queryFoodinMain2ByName(@Param("itemName")String itemName);
//    VinItem queryFoodinShop1ByName(@Param("itemName")String itemName);
//    VinItem queryFoodinShop2ByName(@Param("itemName")String itemName);
//    VinItem queryFoodinShop3ByName(@Param("itemName")String itemName);
//    VinItem queryFoodinShop4ByName(@Param("itemName")String itemName);
//    VinItem queryFoodinShop5ByName(@Param("itemName")String itemName);
//    VinItem queryFoodinShop6ByName(@Param("itemName")String itemName);
//    VinItem queryFoodinShop7ByName(@Param("itemName")String itemName);
//
//    VinItem querycommercialIteminMain1ByName(@Param("itemName")String itemName);
//    VinItem querycommercialIteminMain2ByName(@Param("itemName")String itemName);
//    VinItem querycommercialIteminShop1ByName(@Param("itemName")String itemName);
//    VinItem querycommercialIteminShop2ByName(@Param("itemName")String itemName);
//    VinItem querycommercialIteminShop3ByName(@Param("itemName")String itemName);
//    VinItem querycommercialIteminShop4ByName(@Param("itemName")String itemName);
//    VinItem querycommercialIteminShop5ByName(@Param("itemName")String itemName);
//    VinItem querycommercialIteminShop6ByName(@Param("itemName")String itemName);
//    VinItem querycommercialIteminShop7ByName(@Param("itemName")String itemName);
//
//    VinItem queryothersinMain1ByName(@Param("itemName")String itemName);
//    VinItem queryothersinMain2ByName(@Param("itemName")String itemName);
//    VinItem queryothersinShop1ByName(@Param("itemName")String itemName);
//    VinItem queryothersinShop2ByName(@Param("itemName")String itemName);
//    VinItem queryothersinShop3ByName(@Param("itemName")String itemName);
//    VinItem queryothersinShop4ByName(@Param("itemName")String itemName);
//    VinItem queryothersinShop5ByName(@Param("itemName")String itemName);
//    VinItem queryothersinShop6ByName(@Param("itemName")String itemName);
//    VinItem queryothersinShop7ByName(@Param("itemName")String itemName);

    //這個跟上面重複！！！！！！！
//    VinItem queryItemNuminMain1byID(@Param("id")String id);
//    VinItem queryItemNuminMain2byID(@Param("id")String id);
//    VinItem queryItemNuminShop1byID(@Param("id")String id);
//    VinItem queryItemNuminShop2byID(@Param("id")String id);
//    VinItem queryItemNuminShop3byID(@Param("id")String id);
//    VinItem queryItemNuminShop4byID(@Param("id")String id);
//    VinItem queryItemNuminShop5byID(@Param("id")String id);
//    VinItem queryItemNuminShop6byID(@Param("id")String id);
//    VinItem queryItemNuminShop7byID(@Param("id")String id);
//
//    VinItem querySmallItemNuminMain1byID(@Param("id")String id);
//    VinItem querySmallItemNuminMain2byID(@Param("id")String id);
//    VinItem querySmallItemNuminShop1byID(@Param("id")String id);
//    VinItem querySmallItemNuminShop2byID(@Param("id")String id);
//    VinItem querySmallItemNuminShop3byID(@Param("id")String id);
//    VinItem querySmallItemNuminShop4byID(@Param("id")String id);
//    VinItem querySmallItemNuminShop5byID(@Param("id")String id);
//    VinItem querySmallItemNuminShop6byID(@Param("id")String id);
//    VinItem querySmallItemNuminShop7byID(@Param("id")String id);
//
//    VinItem queryFoodNuminMain1byID(@Param("id")String id);
//    VinItem queryFoodNuminMain2byID(@Param("id")String id);
//    VinItem queryFoodNuminShop1byID(@Param("id")String id);
//    VinItem queryFoodNuminShop2byID(@Param("id")String id);
//    VinItem queryFoodNuminShop3byID(@Param("id")String id);
//    VinItem queryFoodNuminShop4byID(@Param("id")String id);
//    VinItem queryFoodNuminShop5byID(@Param("id")String id);
//    VinItem queryFoodNuminShop6byID(@Param("id")String id);
//    VinItem queryFoodNuminShop7byID(@Param("id")String id);
//
//    VinItem querycommercialItemNuminMain1byID(@Param("id")String id);
//    VinItem querycommercialItemNuminMain2byID(@Param("id")String id);
//    VinItem querycommercialItemNuminShop1byID(@Param("id")String id);
//    VinItem querycommercialItemNuminShop2byID(@Param("id")String id);
//    VinItem querycommercialItemNuminShop3byID(@Param("id")String id);
//    VinItem querycommercialItemNuminShop4byID(@Param("id")String id);
//    VinItem querycommercialItemNuminShop5byID(@Param("id")String id);
//    VinItem querycommercialItemNuminShop6byID(@Param("id")String id);
//    VinItem querycommercialItemNuminShop7byID(@Param("id")String id);
//
//    VinItem queryothersNuminMain1byID(@Param("id")String id);
//    VinItem queryothersNuminMain2byID(@Param("id")String id);
//    VinItem queryothersNuminShop1byID(@Param("id")String id);
//    VinItem queryothersNuminShop2byID(@Param("id")String id);
//    VinItem queryothersNuminShop3byID(@Param("id")String id);
//    VinItem queryothersNuminShop4byID(@Param("id")String id);
//    VinItem queryothersNuminShop5byID(@Param("id")String id);
//    VinItem queryothersNuminShop6byID(@Param("id")String id);
//    VinItem queryothersNuminShop7byID(@Param("id")String id);



    //檢查有沒有存在
    int ifItemExistinMain1(@Param("id") String id);
    int ifItemExistinMain2(@Param("id") String id);
    int ifItemExistinShop1(@Param("id") String id);
    int ifItemExistinShop2(@Param("id") String id);
    int ifItemExistinShop3(@Param("id") String id);
    int ifItemExistinShop4(@Param("id") String id);
    int ifItemExistinShop5(@Param("id") String id);
    int ifItemExistinShop6(@Param("id") String id);
    int ifItemExistinShop7(@Param("id") String id);

    int ifSmallItemExistinMain1(@Param("id") String id);
    int ifSmallItemExistinMain2(@Param("id") String id);
    int ifSmallItemExistinShop1(@Param("id") String id);
    int ifSmallItemExistinShop2(@Param("id") String id);
    int ifSmallItemExistinShop3(@Param("id") String id);
    int ifSmallItemExistinShop4(@Param("id") String id);
    int ifSmallItemExistinShop5(@Param("id") String id);
    int ifSmallItemExistinShop6(@Param("id") String id);
    int ifSmallItemExistinShop7(@Param("id") String id);

    int ifFoodExistinMain1(@Param("id") String id);
    int ifFoodExistinMain2(@Param("id") String id);
    int ifFoodExistinShop1(@Param("id") String id);
    int ifFoodExistinShop2(@Param("id") String id);
    int ifFoodExistinShop3(@Param("id") String id);
    int ifFoodExistinShop4(@Param("id") String id);
    int ifFoodExistinShop5(@Param("id") String id);
    int ifFoodExistinShop6(@Param("id") String id);
    int ifFoodExistinShop7(@Param("id") String id);

    int ifcommercialItemExistinMain1(@Param("id") String id);
    int ifcommercialItemExistinMain2(@Param("id") String id);
    int ifcommercialItemExistinShop1(@Param("id") String id);
    int ifcommercialItemExistinShop2(@Param("id") String id);
    int ifcommercialItemExistinShop3(@Param("id") String id);
    int ifcommercialItemExistinShop4(@Param("id") String id);
    int ifcommercialItemExistinShop5(@Param("id") String id);
    int ifcommercialItemExistinShop6(@Param("id") String id);
    int ifcommercialItemExistinShop7(@Param("id") String id);

    int ifothersExistinMain1(@Param("id") String id);
    int ifothersExistinMain2(@Param("id") String id);
    int ifothersExistinShop1(@Param("id") String id);
    int ifothersExistinShop2(@Param("id") String id);
    int ifothersExistinShop3(@Param("id") String id);
    int ifothersExistinShop4(@Param("id") String id);
    int ifothersExistinShop5(@Param("id") String id);
    int ifothersExistinShop6(@Param("id") String id);
    int ifothersExistinShop7(@Param("id") String id);



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

    User queryUserInformation(@Param("uname") String uname);

    int addloginMain1(VinLog log);
    int addloginMain2(VinLog log);
    int addloginShop1(VinLog log);
    int addloginShop2(VinLog log);
    int addloginShop3(VinLog log);
    int addloginShop4(VinLog log);
    int addloginShop5(VinLog log);
    int addloginShop6(VinLog log);
    int addloginShop7(VinLog log);

    List<VinLog> queryCategoryLoginMain1(@Param("category") String category);
    List<VinLog> queryCategoryLoginMain2(@Param("category") String category);
    List<VinLog> queryCategoryLoginShop1(@Param("category") String category);
    List<VinLog> queryCategoryLoginShop2(@Param("category") String category);
    List<VinLog> queryCategoryLoginShop3(@Param("category") String category);
    List<VinLog> queryCategoryLoginShop4(@Param("category") String category);
    List<VinLog> queryCategoryLoginShop5(@Param("category") String category);
    List<VinLog> queryCategoryLoginShop6(@Param("category") String category);
    List<VinLog> queryCategoryLoginShop7(@Param("category") String category);

    List<VinLog> queryCategoryandIfCompleteLoginMain1(@Param("category") String category, @Param("ifComplete") boolean ifComplete);
    List<VinLog> queryCategoryandIfCompleteLoginMain2(@Param("category") String category, @Param("ifComplete") boolean ifComplete);
    List<VinLog> queryCategoryandIfCompleteLoginShop1(@Param("category") String category, @Param("ifComplete") boolean ifComplete);
    List<VinLog> queryCategoryandIfCompleteLoginShop2(@Param("category") String category, @Param("ifComplete") boolean ifComplete);
    List<VinLog> queryCategoryandIfCompleteLoginShop3(@Param("category") String category, @Param("ifComplete") boolean ifComplete);
    List<VinLog> queryCategoryandIfCompleteLoginShop4(@Param("category") String category, @Param("ifComplete") boolean ifComplete);
    List<VinLog> queryCategoryandIfCompleteLoginShop5(@Param("category") String category, @Param("ifComplete") boolean ifComplete);
    List<VinLog> queryCategoryandIfCompleteLoginShop6(@Param("category") String category, @Param("ifComplete") boolean ifComplete);
    List<VinLog> queryCategoryandIfCompleteLoginShop7(@Param("category") String category, @Param("ifComplete") boolean ifComplete);



    List<VinLog> queryCategoryReceiveinMain1(@Param("category") String category);
    List<VinLog> queryCategoryReceiveinMain2(@Param("category") String category);
    List<VinLog> queryCategoryReceiveinShop1(@Param("category") String category);
    List<VinLog> queryCategoryReceiveinShop2(@Param("category") String category);
    List<VinLog> queryCategoryReceiveinShop3(@Param("category") String category);
    List<VinLog> queryCategoryReceiveinShop4(@Param("category") String category);
    List<VinLog> queryCategoryReceiveinShop5(@Param("category") String category);
    List<VinLog> queryCategoryReceiveinShop6(@Param("category") String category);
    List<VinLog> queryCategoryReceiveinShop7(@Param("category") String category);

   int countCategoryReceiveinMain1(@Param("category") String category);
   int countCategoryReceiveinMain2(@Param("category") String category);
   int countCategoryReceiveinShop1(@Param("category") String category);
   int countCategoryReceiveinShop2(@Param("category") String category);
   int countCategoryReceiveinShop3(@Param("category") String category);
   int countCategoryReceiveinShop4(@Param("category") String category);
   int countCategoryReceiveinShop5(@Param("category") String category);
   int countCategoryReceiveinShop6(@Param("category") String category);
   int countCategoryReceiveinShop7(@Param("category") String category);


    List<VinLog> queryCategoryConfirminMain1(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);
    List<VinLog> queryCategoryConfirminMain2(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);
    List<VinLog> queryCategoryConfirminShop1(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);
    List<VinLog> queryCategoryConfirminShop2(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);
    List<VinLog> queryCategoryConfirminShop3(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);
    List<VinLog> queryCategoryConfirminShop4(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);
    List<VinLog> queryCategoryConfirminShop5(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);
    List<VinLog> queryCategoryConfirminShop6(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);
    List<VinLog> queryCategoryConfirminShop7(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);

    int countCategoryConfirminMain1(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);
    int countCategoryConfirminMain2(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);
    int countCategoryConfirminShop1(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);
    int countCategoryConfirminShop2(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);
    int countCategoryConfirminShop3(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);
    int countCategoryConfirminShop4(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);
    int countCategoryConfirminShop5(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);
    int countCategoryConfirminShop6(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);
    int countCategoryConfirminShop7(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);



    VinLog queryLoginmain1byid(@Param("logid") String logid);
    VinLog queryLoginmain2byid(@Param("logid") String logid);
    VinLog queryLoginshop1byid(@Param("logid") String logid);
    VinLog queryLoginshop2byid(@Param("logid") String logid);
    VinLog queryLoginshop3byid(@Param("logid") String logid);
    VinLog queryLoginshop4byid(@Param("logid") String logid);
    VinLog queryLoginshop5byid(@Param("logid") String logid);
    VinLog queryLoginshop6byid(@Param("logid") String logid);
    VinLog queryLoginshop7byid(@Param("logid") String logid);

    int updateLoginmain1byid(VinLog vinLog);
    int updateLoginmain2byid(VinLog vinLog);
    int updateLoginshop1byid(VinLog vinLog);
    int updateLoginshop2byid(VinLog vinLog);
    int updateLoginshop3byid(VinLog vinLog);
    int updateLoginshop4byid(VinLog vinLog);
    int updateLoginshop5byid(VinLog vinLog);
    int updateLoginshop6byid(VinLog vinLog);
    int updateLoginshop7byid(VinLog vinLog);

    int deleteLoginMain1byLogid(@Param("logid") String logid);
    int deleteLoginMain2byLogid(@Param("logid") String logid);
    int deleteLoginShop1byLogid(@Param("logid") String logid);
    int deleteLoginShop2byLogid(@Param("logid") String logid);
    int deleteLoginShop3byLogid(@Param("logid") String logid);
    int deleteLoginShop4byLogid(@Param("logid") String logid);
    int deleteLoginShop5byLogid(@Param("logid") String logid);
    int deleteLoginShop6byLogid(@Param("logid") String logid);
    int deleteLoginShop7byLogid(@Param("logid") String logid);

    Warehouse queryRealWarehouseName(@Param("nickname") String nickname);

    @Cacheable(value = { "cutelittlepiggyCache" },key="'queryAllRealWarehouseName'")
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

    List<VinCheck> queryCheckinMain1(@Param("category") String category);
    List<VinCheck> queryCheckinMain2(@Param("category") String category);
    List<VinCheck> queryCheckinShop1(@Param("category") String category);
    List<VinCheck> queryCheckinShop2(@Param("category") String category);
    List<VinCheck> queryCheckinShop3(@Param("category") String category);
    List<VinCheck> queryCheckinShop4(@Param("category") String category);
    List<VinCheck> queryCheckinShop5(@Param("category") String category);
    List<VinCheck> queryCheckinShop6(@Param("category") String category);
    List<VinCheck> queryCheckinShop7(@Param("category") String category);


    List<VinCheck> queryCheckwithTimeinMain1(@Param("category") String category, @Param("time") String time);
    List<VinCheck> queryCheckwithTimeinMain2(@Param("category") String category, @Param("time") String time);
    List<VinCheck> queryCheckwithTimeinShop1(@Param("category") String category, @Param("time") String time);
    List<VinCheck> queryCheckwithTimeinShop2(@Param("category") String category, @Param("time") String time);
    List<VinCheck> queryCheckwithTimeinShop3(@Param("category") String category, @Param("time") String time);
    List<VinCheck> queryCheckwithTimeinShop4(@Param("category") String category, @Param("time") String time);
    List<VinCheck> queryCheckwithTimeinShop5(@Param("category") String category, @Param("time") String time);
    List<VinCheck> queryCheckwithTimeinShop6(@Param("category") String category, @Param("time") String time);
    List<VinCheck> queryCheckwithTimeinShop7(@Param("category") String category, @Param("time") String time);


    List<VinCheck> queryCheckwithTimeandIdinMain1(@Param("category") String category, @Param("time") String time, @Param("id") String id);
    List<VinCheck> queryCheckwithTimeandIdinMain2(@Param("category") String category, @Param("time") String time, @Param("id") String id);
    List<VinCheck> queryCheckwithTimeandIdinShop1(@Param("category") String category, @Param("time") String time, @Param("id") String id);
    List<VinCheck> queryCheckwithTimeandIdinShop2(@Param("category") String category, @Param("time") String time, @Param("id") String id);
    List<VinCheck> queryCheckwithTimeandIdinShop3(@Param("category") String category, @Param("time") String time, @Param("id") String id);
    List<VinCheck> queryCheckwithTimeandIdinShop4(@Param("category") String category, @Param("time") String time, @Param("id") String id);
    List<VinCheck> queryCheckwithTimeandIdinShop5(@Param("category") String category, @Param("time") String time, @Param("id") String id);
    List<VinCheck> queryCheckwithTimeandIdinShop6(@Param("category") String category, @Param("time") String time, @Param("id") String id);
    List<VinCheck> queryCheckwithTimeandIdinShop7(@Param("category") String category, @Param("time") String time, @Param("id") String id);

    int updateCheckinMain1byid(VinCheck vinCheck);
    int updateCheckinMain2byid(VinCheck vinCheck);
    int updateCheckinShop1byid(VinCheck vinCheck);
    int updateCheckinShop2byid(VinCheck vinCheck);
    int updateCheckinShop3byid(VinCheck vinCheck);
    int updateCheckinShop4byid(VinCheck vinCheck);
    int updateCheckinShop5byid(VinCheck vinCheck);
    int updateCheckinShop6byid(VinCheck vinCheck);
    int updateCheckinShop7byid(VinCheck vinCheck);

    List<VinCheck> queryCheckinMain1byID(@Param("id") String id);
    List<VinCheck> queryCheckinMain2byID(@Param("id") String id);
    List<VinCheck> queryCheckinShop1byID(@Param("id") String id);
    List<VinCheck> queryCheckinShop2byID(@Param("id") String id);
    List<VinCheck> queryCheckinShop3byID(@Param("id") String id);
    List<VinCheck> queryCheckinShop4byID(@Param("id") String id);
    List<VinCheck> queryCheckinShop5byID(@Param("id") String id);
    List<VinCheck> queryCheckinShop6byID(@Param("id") String id);
    List<VinCheck> queryCheckinShop7byID(@Param("id") String id);


    List<VinItemSimple> querySumitemCountbytimeinMain1(@Param("time") String time);
    List<VinItemSimple> querySumitemCountbytimeinMain2(@Param("time") String time);
    List<VinItemSimple> querySumitemCountbytimeinShop1(@Param("time") String time);
    List<VinItemSimple> querySumitemCountbytimeinShop2(@Param("time") String time);
    List<VinItemSimple> querySumitemCountbytimeinShop3(@Param("time") String time);
    List<VinItemSimple> querySumitemCountbytimeinShop4(@Param("time") String time);
    List<VinItemSimple> querySumitemCountbytimeinShop5(@Param("time") String time);
    List<VinItemSimple> querySumitemCountbytimeinShop6(@Param("time") String time);
    List<VinItemSimple> querySumitemCountbytimeinShop7(@Param("time") String time);

    int addSumitemCountinMain1(VinAlert vinAlert);
    int addSumitemCountinMain2(VinAlert vinAlert);
    int addSumitemCountinShop1(VinAlert vinAlert);
    int addSumitemCountinShop2(VinAlert vinAlert);
    int addSumitemCountinShop3(VinAlert vinAlert);
    int addSumitemCountinShop4(VinAlert vinAlert);
    int addSumitemCountinShop5(VinAlert vinAlert);
    int addSumitemCountinShop6(VinAlert vinAlert);
    int addSumitemCountinShop7(VinAlert vinAlert);

    @Cacheable(value = { "cutelittlepiggyCache" },key="'ifAlertinMain1List'")
    List<VinAlert> queryifAlertinMain1(@Param("time") String time);

    @Cacheable(value = { "cutelittlepiggyCache" },key="'ifAlertinMain2List'")
    List<VinAlert> queryifAlertinMain2(@Param("time") String time);

    @Cacheable(value = { "cutelittlepiggyCache" },key="'ifAlertinShop1List'")
    List<VinAlert> queryifAlertinShop1(@Param("time") String time);

    @Cacheable(value = { "cutelittlepiggyCache" },key="'ifAlertinShop2List'")
    List<VinAlert> queryifAlertinShop2(@Param("time") String time);

    @Cacheable(value = { "cutelittlepiggyCache" },key="'ifAlertinShop3List'")
    List<VinAlert> queryifAlertinShop3(@Param("time") String time);

    @Cacheable(value = { "cutelittlepiggyCache" },key="'ifAlertinShop4List'")
    List<VinAlert> queryifAlertinShop4(@Param("time") String time);

    @Cacheable(value = { "cutelittlepiggyCache" },key="'ifAlertinShop5List'")
    List<VinAlert> queryifAlertinShop5(@Param("time") String time);

    @Cacheable(value = { "cutelittlepiggyCache" },key="'ifAlertinShop6List'")
    List<VinAlert> queryifAlertinShop6(@Param("time") String time);

    @Cacheable(value = { "cutelittlepiggyCache" },key="'ifAlertinShop7List'")
    List<VinAlert> queryifAlertinShop7(@Param("time") String time);

    VinLog queryLoginmain1byItemid(@Param("id") String id);
    VinLog queryLoginmain2byItemid(@Param("id") String id);
    VinLog queryLoginshop1byItemid(@Param("id") String id);
    VinLog queryLoginshop2byItemid(@Param("id") String id);
    VinLog queryLoginshop3byItemid(@Param("id") String id);
    VinLog queryLoginshop4byItemid(@Param("id") String id);
    VinLog queryLoginshop5byItemid(@Param("id") String id);
    VinLog queryLoginshop6byItemid(@Param("id") String id);
    VinLog queryLoginshop7byItemid(@Param("id") String id);

    List<VinLog> queryAllLoginmain1byItemid(@Param("id") String id);
    List<VinLog> queryAllLoginmain2byItemid(@Param("id") String id);
    List<VinLog> queryAllLoginshop1byItemid(@Param("id") String id);
    List<VinLog> queryAllLoginshop2byItemid(@Param("id") String id);
    List<VinLog> queryAllLoginshop3byItemid(@Param("id") String id);
    List<VinLog> queryAllLoginshop4byItemid(@Param("id") String id);
    List<VinLog> queryAllLoginshop5byItemid(@Param("id") String id);
    List<VinLog> queryAllLoginshop6byItemid(@Param("id") String id);
    List<VinLog> queryAllLoginshop7byItemid(@Param("id") String id);

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
    VinItem queryIteminMain0byId(@Param("id")String id);
    VinItem querySmallIteminMain0byId(@Param("id")String id);
    VinItem queryFoodinMain0byId(@Param("id")String id);
    VinItem querycommercialIteminMain0byId(@Param("id")String id);
    VinItem queryothersinMain0byId(@Param("id")String id);
    int queryItemNuminMain0byId(@Param("id")String id);
    int querySmallItemNuminMain0byId(@Param("id")String id);
    int queryFoodNuminMain0byId(@Param("id")String id);
    int querycommercialItemNuminMain0byId(@Param("id")String id);
    int queryothersNuminMain0byId(@Param("id")String id);
    List<VinItem> queryAllIteminMain0();
    List<VinItem> queryAllSmallIteminMain0();
    List<VinItem> queryAllFoodinMain0();
    List<VinItem> queryAllcommercialIteminMain0();
    List<VinItem> queryAllothersinMain0();
//    VinItem queryIteminMain0ByName(@Param("itemName")String itemName);
//    VinItem querySmallIteminMain0ByName(@Param("itemName")String itemName);
//    VinItem queryFoodinMain0ByName(@Param("itemName")String itemName);
//    VinItem querycommercialIteminMain0ByName(@Param("itemName")String itemName);
//    VinItem queryothersinMain0ByName(@Param("itemName")String itemName);
//    VinItem queryItemNuminMain0byID(@Param("id")String id);
//    VinItem querySmallItemNuminMain0byID(@Param("id")String id);
//    VinItem queryFoodNuminMain0byID(@Param("id")String id);
//    VinItem querycommercialItemNuminMain0byID(@Param("id")String id);
//    VinItem queryothersNuminMain0byID(@Param("id")String id);
    int ifItemExistinMain0(@Param("id") String id);
    int ifSmallItemExistinMain0(@Param("id") String id);
    int ifFoodExistinMain0(@Param("id") String id);
    int ifcommercialItemExistinMain0(@Param("id") String id);
    int ifothersExistinMain0(@Param("id") String id);
    int updateItembySendfromMain0(VinItem items);
    int updateSmallItembySendfromMain0(VinItem items);
    int updateFoodbySendfromMain0(VinItem items);
    int updatecommercialItembySendfromMain0(VinItem items);
    int updateothersbySendfromMain0(VinItem items);
    int addloginMain0(VinLog log);
    List<VinLog> queryCategoryLoginMain0(@Param("category") String category);
    List<VinLog> queryCategoryandIfCompleteLoginMain0(@Param("category") String category, @Param("ifComplete") boolean ifComplete);
    List<VinLog> queryCategoryReceiveinMain0(@Param("category") String category);
    int countCategoryReceiveinMain0(@Param("category") String category);
    List<VinLog> queryCategoryConfirminMain0(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);
    int countCategoryConfirminMain0(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);
    VinLog queryLoginmain0byid(@Param("logid") String logid);
    int updateLoginmain0byid(VinLog vinLog);
    int deleteLoginMain0byLogid(@Param("logid") String logid);
    int addCheckinMain0(VinCheck vinCheck);
    List<VinCheck> queryCheckinMain0(@Param("category") String category);
    List<VinCheck> queryCheckwithTimeinMain0(@Param("category") String category, @Param("time") String time);
    List<VinCheck> queryCheckwithTimeandIdinMain0(@Param("category") String category, @Param("time") String time, @Param("id") String id);
    int updateCheckinMain0byid(VinCheck vinCheck);
    List<VinCheck> queryCheckinMain0byID(@Param("id") String id);
    List<VinItemSimple> querySumitemCountbytimeinMain0(@Param("time") String time);
    int addSumitemCountinMain0(VinAlert vinAlert);

    @Cacheable(value = { "cutelittlepiggyCache" },key="'ifAlertinMain0List'")
    List<VinAlert> queryifAlertinMain0(@Param("time") String time);

    VinLog queryLoginmain0byItemid(@Param("id") String id);
    List<VinLog> queryAllLoginmain0byItemid(@Param("id") String id);
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
    VinItem queryIteminShop8byId(@Param("id")String id);
    VinItem querySmallIteminShop8byId(@Param("id")String id);
    VinItem queryFoodinShop8byId(@Param("id")String id);
    VinItem querycommercialIteminShop8byId(@Param("id")String id);
    VinItem queryothersinShop8byId(@Param("id")String id);
    int queryItemNuminShop8byId(@Param("id")String id);
    int querySmallItemNuminShop8byId(@Param("id")String id);
    int queryFoodNuminShop8byId(@Param("id")String id);
    int querycommercialItemNuminShop8byId(@Param("id")String id);
    int queryothersNuminShop8byId(@Param("id")String id);
    List<VinItem> queryAllIteminShop8();
    List<VinItem> queryAllSmallIteminShop8();
    List<VinItem> queryAllFoodinShop8();
    List<VinItem> queryAllcommercialIteminShop8();
    List<VinItem> queryAllothersinShop8();
//    VinItem queryIteminShop8ByName(@Param("itemName")String itemName);
//    VinItem querySmallIteminShop8ByName(@Param("itemName")String itemName);
//    VinItem queryFoodinShop8ByName(@Param("itemName")String itemName);
//    VinItem querycommercialIteminShop8ByName(@Param("itemName")String itemName);
//    VinItem queryothersinShop8ByName(@Param("itemName")String itemName);
//    VinItem queryItemNuminShop8byID(@Param("id")String id);
//    VinItem querySmallItemNuminShop8byID(@Param("id")String id);
//    VinItem queryFoodNuminShop8byID(@Param("id")String id);
//    VinItem querycommercialItemNuminShop8byID(@Param("id")String id);
//    VinItem queryothersNuminShop8byID(@Param("id")String id);
    int ifItemExistinShop8(@Param("id") String id);
    int ifSmallItemExistinShop8(@Param("id") String id);
    int ifFoodExistinShop8(@Param("id") String id);
    int ifcommercialItemExistinShop8(@Param("id") String id);
    int ifothersExistinShop8(@Param("id") String id);
    int updateItembySendfromShop8(VinItem items);
    int updateSmallItembySendfromShop8(VinItem items);
    int updateFoodbySendfromShop8(VinItem items);
    int updatecommercialItembySendfromShop8(VinItem items);
    int updateothersbySendfromShop8(VinItem items);
    int addloginShop8(VinLog log);
    List<VinLog> queryCategoryLoginShop8(@Param("category") String category);
    List<VinLog> queryCategoryandIfCompleteLoginShop8(@Param("category") String category, @Param("ifComplete") boolean ifComplete);
    List<VinLog> queryCategoryReceiveinShop8(@Param("category") String category);
    int countCategoryReceiveinShop8(@Param("category") String category);
    List<VinLog> queryCategoryConfirminShop8(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);
    int countCategoryConfirminShop8(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);
    VinLog queryLoginshop8byid(@Param("logid") String logid);
    int updateLoginshop8byid(VinLog vinLog);
    int deleteLoginShop8byLogid(@Param("logid") String logid);
    int addCheckinShop8(VinCheck vinCheck);
    List<VinCheck> queryCheckinShop8(@Param("category") String category);
    List<VinCheck> queryCheckwithTimeinShop8(@Param("category") String category, @Param("time") String time);
    List<VinCheck> queryCheckwithTimeandIdinShop8(@Param("category") String category, @Param("time") String time, @Param("id") String id);
    int updateCheckinShop8byid(VinCheck vinCheck);
    List<VinCheck> queryCheckinShop8byID(@Param("id") String id);
    List<VinItemSimple> querySumitemCountbytimeinShop8(@Param("time") String time);
    int addSumitemCountinShop8(VinAlert vinAlert);

    @Cacheable(value = { "cutelittlepiggyCache" },key="'ifAlertinShop8List'")
    List<VinAlert> queryifAlertinShop8(@Param("time") String time);

    VinLog queryLoginshop8byItemid(@Param("id") String id);
    List<VinLog> queryAllLoginshop8byItemid(@Param("id") String id);
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
    VinItem queryIteminShop9byId(@Param("id")String id);
    VinItem querySmallIteminShop9byId(@Param("id")String id);
    VinItem queryFoodinShop9byId(@Param("id")String id);
    VinItem querycommercialIteminShop9byId(@Param("id")String id);
    VinItem queryothersinShop9byId(@Param("id")String id);
    int queryItemNuminShop9byId(@Param("id")String id);
    int querySmallItemNuminShop9byId(@Param("id")String id);
    int queryFoodNuminShop9byId(@Param("id")String id);
    int querycommercialItemNuminShop9byId(@Param("id")String id);
    int queryothersNuminShop9byId(@Param("id")String id);
    List<VinItem> queryAllIteminShop9();
    List<VinItem> queryAllSmallIteminShop9();
    List<VinItem> queryAllFoodinShop9();
    List<VinItem> queryAllcommercialIteminShop9();
    List<VinItem> queryAllothersinShop9();
//    VinItem queryIteminShop9ByName(@Param("itemName")String itemName);
//    VinItem querySmallIteminShop9ByName(@Param("itemName")String itemName);
//    VinItem queryFoodinShop9ByName(@Param("itemName")String itemName);
//    VinItem querycommercialIteminShop9ByName(@Param("itemName")String itemName);
//    VinItem queryothersinShop9ByName(@Param("itemName")String itemName);
//    VinItem queryItemNuminShop9byID(@Param("id")String id);
//    VinItem querySmallItemNuminShop9byID(@Param("id")String id);
//    VinItem queryFoodNuminShop9byID(@Param("id")String id);
//    VinItem querycommercialItemNuminShop9byID(@Param("id")String id);
//    VinItem queryothersNuminShop9byID(@Param("id")String id);
    int ifItemExistinShop9(@Param("id") String id);
    int ifSmallItemExistinShop9(@Param("id") String id);
    int ifFoodExistinShop9(@Param("id") String id);
    int ifcommercialItemExistinShop9(@Param("id") String id);
    int ifothersExistinShop9(@Param("id") String id);
    int updateItembySendfromShop9(VinItem items);
    int updateSmallItembySendfromShop9(VinItem items);
    int updateFoodbySendfromShop9(VinItem items);
    int updatecommercialItembySendfromShop9(VinItem items);
    int updateothersbySendfromShop9(VinItem items);
    int addloginShop9(VinLog log);
    List<VinLog> queryCategoryLoginShop9(@Param("category") String category);
    List<VinLog> queryCategoryandIfCompleteLoginShop9(@Param("category") String category, @Param("ifComplete") boolean ifComplete);
    List<VinLog> queryCategoryReceiveinShop9(@Param("category") String category);
    int countCategoryReceiveinShop9(@Param("category") String category);
    List<VinLog> queryCategoryConfirminShop9(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);
    int countCategoryConfirminShop9(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);
    VinLog queryLoginshop9byid(@Param("logid") String logid);
    int updateLoginshop9byid(VinLog vinLog);
    int deleteLoginShop9byLogid(@Param("logid") String logid);
    int addCheckinShop9(VinCheck vinCheck);
    List<VinCheck> queryCheckinShop9(@Param("category") String category);
    List<VinCheck> queryCheckwithTimeinShop9(@Param("category") String category, @Param("time") String time);
    List<VinCheck> queryCheckwithTimeandIdinShop9(@Param("category") String category, @Param("time") String time, @Param("id") String id);
    int updateCheckinShop9byid(VinCheck vinCheck);
    List<VinCheck> queryCheckinShop9byID(@Param("id") String id);
    List<VinItemSimple> querySumitemCountbytimeinShop9(@Param("time") String time);
    int addSumitemCountinShop9(VinAlert vinAlert);

    @Cacheable(value = { "cutelittlepiggyCache" },key="'ifAlertinShop9List'")
    List<VinAlert> queryifAlertinShop9(@Param("time") String time);

    VinLog queryLoginshop9byItemid(@Param("id") String id);
    List<VinLog> queryAllLoginshop9byItemid(@Param("id") String id);
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
    VinItem queryIteminShop10byId(@Param("id")String id);
    VinItem querySmallIteminShop10byId(@Param("id")String id);
    VinItem queryFoodinShop10byId(@Param("id")String id);
    VinItem querycommercialIteminShop10byId(@Param("id")String id);
    VinItem queryothersinShop10byId(@Param("id")String id);
    int queryItemNuminShop10byId(@Param("id")String id);
    int querySmallItemNuminShop10byId(@Param("id")String id);
    int queryFoodNuminShop10byId(@Param("id")String id);
    int querycommercialItemNuminShop10byId(@Param("id")String id);
    int queryothersNuminShop10byId(@Param("id")String id);
    List<VinItem> queryAllIteminShop10();
    List<VinItem> queryAllSmallIteminShop10();
    List<VinItem> queryAllFoodinShop10();
    List<VinItem> queryAllcommercialIteminShop10();
    List<VinItem> queryAllothersinShop10();
//    VinItem queryIteminShop10ByName(@Param("itemName")String itemName);
//    VinItem querySmallIteminShop10ByName(@Param("itemName")String itemName);
//    VinItem queryFoodinShop10ByName(@Param("itemName")String itemName);
//    VinItem querycommercialIteminShop10ByName(@Param("itemName")String itemName);
//    VinItem queryothersinShop10ByName(@Param("itemName")String itemName);
//    VinItem queryItemNuminShop10byID(@Param("id")String id);
//    VinItem querySmallItemNuminShop10byID(@Param("id")String id);
//    VinItem queryFoodNuminShop10byID(@Param("id")String id);
//    VinItem querycommercialItemNuminShop10byID(@Param("id")String id);
//    VinItem queryothersNuminShop10byID(@Param("id")String id);
    int ifItemExistinShop10(@Param("id") String id);
    int ifSmallItemExistinShop10(@Param("id") String id);
    int ifFoodExistinShop10(@Param("id") String id);
    int ifcommercialItemExistinShop10(@Param("id") String id);
    int ifothersExistinShop10(@Param("id") String id);
    int updateItembySendfromShop10(VinItem items);
    int updateSmallItembySendfromShop10(VinItem items);
    int updateFoodbySendfromShop10(VinItem items);
    int updatecommercialItembySendfromShop10(VinItem items);
    int updateothersbySendfromShop10(VinItem items);
    int addloginShop10(VinLog log);
    List<VinLog> queryCategoryLoginShop10(@Param("category") String category);
    List<VinLog> queryCategoryandIfCompleteLoginShop10(@Param("category") String category, @Param("ifComplete") boolean ifComplete);
    List<VinLog> queryCategoryReceiveinShop10(@Param("category") String category);
    int countCategoryReceiveinShop10(@Param("category") String category);
    List<VinLog> queryCategoryConfirminShop10(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);
    int countCategoryConfirminShop10(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);
    VinLog queryLoginshop10byid(@Param("logid") String logid);
    int updateLoginshop10byid(VinLog vinLog);
    int deleteLoginShop10byLogid(@Param("logid") String logid);
    int addCheckinShop10(VinCheck vinCheck);
    List<VinCheck> queryCheckinShop10(@Param("category") String category);
    List<VinCheck> queryCheckwithTimeinShop10(@Param("category") String category, @Param("time") String time);
    List<VinCheck> queryCheckwithTimeandIdinShop10(@Param("category") String category, @Param("time") String time, @Param("id") String id);
    int updateCheckinShop10byid(VinCheck vinCheck);
    List<VinCheck> queryCheckinShop10byID(@Param("id") String id);
    List<VinItemSimple> querySumitemCountbytimeinShop10(@Param("time") String time);
    int addSumitemCountinShop10(VinAlert vinAlert);

    @Cacheable(value = { "cutelittlepiggyCache" },key="'ifAlertinShop10List'")
    List<VinAlert> queryifAlertinShop10(@Param("time") String time);
    VinLog queryLoginshop10byItemid(@Param("id") String id);
    List<VinLog> queryAllLoginshop10byItemid(@Param("id") String id);
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
    VinItem queryIteminShop11byId(@Param("id")String id);
    VinItem querySmallIteminShop11byId(@Param("id")String id);
    VinItem queryFoodinShop11byId(@Param("id")String id);
    VinItem querycommercialIteminShop11byId(@Param("id")String id);
    VinItem queryothersinShop11byId(@Param("id")String id);
    int queryItemNuminShop11byId(@Param("id")String id);
    int querySmallItemNuminShop11byId(@Param("id")String id);
    int queryFoodNuminShop11byId(@Param("id")String id);
    int querycommercialItemNuminShop11byId(@Param("id")String id);
    int queryothersNuminShop11byId(@Param("id")String id);
    List<VinItem> queryAllIteminShop11();
    List<VinItem> queryAllSmallIteminShop11();
    List<VinItem> queryAllFoodinShop11();
    List<VinItem> queryAllcommercialIteminShop11();
    List<VinItem> queryAllothersinShop11();
    //    VinItem queryIteminShop11ByName(@Param("itemName")String itemName);
//    VinItem querySmallIteminShop11ByName(@Param("itemName")String itemName);
//    VinItem queryFoodinShop11ByName(@Param("itemName")String itemName);
//    VinItem querycommercialIteminShop11ByName(@Param("itemName")String itemName);
//    VinItem queryothersinShop11ByName(@Param("itemName")String itemName);
//    VinItem queryItemNuminShop11byID(@Param("id")String id);
//    VinItem querySmallItemNuminShop11byID(@Param("id")String id);
//    VinItem queryFoodNuminShop11byID(@Param("id")String id);
//    VinItem querycommercialItemNuminShop11byID(@Param("id")String id);
//    VinItem queryothersNuminShop11byID(@Param("id")String id);
    int ifItemExistinShop11(@Param("id") String id);
    int ifSmallItemExistinShop11(@Param("id") String id);
    int ifFoodExistinShop11(@Param("id") String id);
    int ifcommercialItemExistinShop11(@Param("id") String id);
    int ifothersExistinShop11(@Param("id") String id);
    int updateItembySendfromShop11(VinItem items);
    int updateSmallItembySendfromShop11(VinItem items);
    int updateFoodbySendfromShop11(VinItem items);
    int updatecommercialItembySendfromShop11(VinItem items);
    int updateothersbySendfromShop11(VinItem items);
    int addloginShop11(VinLog log);
    List<VinLog> queryCategoryLoginShop11(@Param("category") String category);
    List<VinLog> queryCategoryandIfCompleteLoginShop11(@Param("category") String category, @Param("ifComplete") boolean ifComplete);
    List<VinLog> queryCategoryReceiveinShop11(@Param("category") String category);
    int countCategoryReceiveinShop11(@Param("category") String category);
    List<VinLog> queryCategoryConfirminShop11(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);
    int countCategoryConfirminShop11(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);
    VinLog queryLoginshop11byid(@Param("logid") String logid);
    int updateLoginshop11byid(VinLog vinLog);
    int deleteLoginShop11byLogid(@Param("logid") String logid);
    int addCheckinShop11(VinCheck vinCheck);
    List<VinCheck> queryCheckinShop11(@Param("category") String category);
    List<VinCheck> queryCheckwithTimeinShop11(@Param("category") String category, @Param("time") String time);
    List<VinCheck> queryCheckwithTimeandIdinShop11(@Param("category") String category, @Param("time") String time, @Param("id") String id);
    int updateCheckinShop11byid(VinCheck vinCheck);
    List<VinCheck> queryCheckinShop11byID(@Param("id") String id);
    List<VinItemSimple> querySumitemCountbytimeinShop11(@Param("time") String time);
    int addSumitemCountinShop11(VinAlert vinAlert);
    @Cacheable(value = { "cutelittlepiggyCache" },key="'ifAlertinShop11List'")
    List<VinAlert> queryifAlertinShop11(@Param("time") String time);
    VinLog queryLoginshop11byItemid(@Param("id") String id);
    List<VinLog> queryAllLoginshop11byItemid(@Param("id") String id);
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
    VinItem queryIteminShop12byId(@Param("id")String id);
    VinItem querySmallIteminShop12byId(@Param("id")String id);
    VinItem queryFoodinShop12byId(@Param("id")String id);
    VinItem querycommercialIteminShop12byId(@Param("id")String id);
    VinItem queryothersinShop12byId(@Param("id")String id);
    int queryItemNuminShop12byId(@Param("id")String id);
    int querySmallItemNuminShop12byId(@Param("id")String id);
    int queryFoodNuminShop12byId(@Param("id")String id);
    int querycommercialItemNuminShop12byId(@Param("id")String id);
    int queryothersNuminShop12byId(@Param("id")String id);
    List<VinItem> queryAllIteminShop12();
    List<VinItem> queryAllSmallIteminShop12();
    List<VinItem> queryAllFoodinShop12();
    List<VinItem> queryAllcommercialIteminShop12();
    List<VinItem> queryAllothersinShop12();
    //    VinItem queryIteminShop12ByName(@Param("itemName")String itemName);
//    VinItem querySmallIteminShop12ByName(@Param("itemName")String itemName);
//    VinItem queryFoodinShop12ByName(@Param("itemName")String itemName);
//    VinItem querycommercialIteminShop12ByName(@Param("itemName")String itemName);
//    VinItem queryothersinShop12ByName(@Param("itemName")String itemName);
//    VinItem queryItemNuminShop12byID(@Param("id")String id);
//    VinItem querySmallItemNuminShop12byID(@Param("id")String id);
//    VinItem queryFoodNuminShop12byID(@Param("id")String id);
//    VinItem querycommercialItemNuminShop12byID(@Param("id")String id);
//    VinItem queryothersNuminShop12byID(@Param("id")String id);
    int ifItemExistinShop12(@Param("id") String id);
    int ifSmallItemExistinShop12(@Param("id") String id);
    int ifFoodExistinShop12(@Param("id") String id);
    int ifcommercialItemExistinShop12(@Param("id") String id);
    int ifothersExistinShop12(@Param("id") String id);
    int updateItembySendfromShop12(VinItem items);
    int updateSmallItembySendfromShop12(VinItem items);
    int updateFoodbySendfromShop12(VinItem items);
    int updatecommercialItembySendfromShop12(VinItem items);
    int updateothersbySendfromShop12(VinItem items);
    int addloginShop12(VinLog log);
    List<VinLog> queryCategoryLoginShop12(@Param("category") String category);
    List<VinLog> queryCategoryandIfCompleteLoginShop12(@Param("category") String category, @Param("ifComplete") boolean ifComplete);
    List<VinLog> queryCategoryReceiveinShop12(@Param("category") String category);
    int countCategoryReceiveinShop12(@Param("category") String category);
    List<VinLog> queryCategoryConfirminShop12(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);
    int countCategoryConfirminShop12(@Param("category") String category, @Param("action") String action, @Param("action2") String action2);
    VinLog queryLoginshop12byid(@Param("logid") String logid);
    int updateLoginshop12byid(VinLog vinLog);
    int deleteLoginShop12byLogid(@Param("logid") String logid);
    int addCheckinShop12(VinCheck vinCheck);
    List<VinCheck> queryCheckinShop12(@Param("category") String category);
    List<VinCheck> queryCheckwithTimeinShop12(@Param("category") String category, @Param("time") String time);
    List<VinCheck> queryCheckwithTimeandIdinShop12(@Param("category") String category, @Param("time") String time, @Param("id") String id);
    int updateCheckinShop12byid(VinCheck vinCheck);
    List<VinCheck> queryCheckinShop12byID(@Param("id") String id);
    List<VinItemSimple> querySumitemCountbytimeinShop12(@Param("time") String time);
    int addSumitemCountinShop12(VinAlert vinAlert);

    @Cacheable(value = { "cutelittlepiggyCache" },key="'ifAlertinShop12List'")
    List<VinAlert> queryifAlertinShop12(@Param("time") String time);
    VinLog queryLoginshop12byItemid(@Param("id") String id);
    List<VinLog> queryAllLoginshop12byItemid(@Param("id") String id);
    int updateItemNameAllLogbyidinShop12(VinLog vinLog);










    int addDumpItem(Dumplist dumplist);
    List<Dumplist> queryDumpItemwithLocationandCategory(@Param("location") String location, @Param("category") String category, @Param("if_pass") boolean if_pass);
    int updateDumpStatusbyLogId(@Param("logid") String logid, @Param("status") String status);
    int queryDumpLogCountbyLogId(@Param("logid") String logid);
    Dumplist queryDumpLogbyLogId(@Param("logid") String logid);
    int updateDumpbyLogId(Dumplist dumplist);
    int iflogidExistindumplist(@Param("logid") String logid);

    int addReceiveError(ReceiveError receiveError);
    List<ReceiveError> queryReceiveError(@Param("location") String location, @Param("category") String categoty);
    List<ReceiveError> queryReceiveErrorbyComplete(@Param("location") String location, @Param("category") String categoty, @Param("ifComplete") boolean ifComplete);
    int updateReceiveErrorifComplete(@Param("logid") String logid, @Param("ifComplete") boolean ifComplete);

    int addFruitInvoice(FruitInvoice fruitInvoice);
    int updateFruitInvoice(FruitInvoice fruitInvoice);
    FruitInvoice queryFruitInvoicebyInvoiceid(@Param("invoiceid") String invoiceid);
    List<FruitInvoice> queryFruitInvoice(@Param("location") String location);
    int deleteFruitInvoicebyInvoiceID(@Param("invoiceid") String invoiceid);

    int addFruitInvoiceSec(FruitInvoiceSec fruitInvoiceSec);
    int updateFruitInvoiceSec(FruitInvoiceSec fruitInvoiceSec);
    FruitInvoiceSec queryFruitInvoiceSecbyID(String id);
    List<FruitInvoiceSec> queryFruitInvoiceSecbyMonth(String month);
    int ifExistFruitInvoiceSecID(String id);
    int updateFileType(FilePath filePath);
    int addFileType(FilePath filePath);

    FilePath queryFileTypebyid(@Param("id") String id);
    int ifExistFileTypebyID(String id);

    int addExpiredDate(Expired expired);
    List<Expired> queryAllExpiredDatebyLocation(String location);
    List<Expired> queryExpiredDatebyLocationTime(@Param("location") String location, @Param("time") String time);
    List<Expired> queryExpiredItembyLocationTime(@Param("location") String location, @Param("time") String time);
    List<Expired> queryExpiredSoonItembyLocationTime(@Param("location") String location, @Param("time1") String time1, @Param("time2") String time2);
    int updateExpiredDate(@Param("time") String time, @Param("id") int id, @Param("ifDump") boolean ifDump);
    Expired queryExpiredbyID(@Param("id") int id);
    int queryNotInputDateinExpireCount(@Param("location") String location);

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

    int updateItemCommercialSet(ItemSet itemSet);
    int updateItemFoodSet(ItemSet itemSet);
    int updateItemOthersSet(ItemSet itemSet);
    int updateItemSmallToolSet(ItemSet itemSet);
    int updateItemToolSet(ItemSet itemSet);
    int addItemCommercialSet(ItemSet itemSet);
    int addItemFoodSet(ItemSet itemSet);
    int addItemOthersSet(ItemSet itemSet);
    int addItemSmallToolSet(ItemSet itemSet);
    int addItemToolSet(ItemSet itemSet);


    int addItemCommercialSetSimple(ItemSet itemSet);
    int addItemFoodSetSimple(ItemSet itemSet);
    int addItemOthersSetSimple(ItemSet itemSet);
    int addItemSmallToolSetSimple(ItemSet itemSet);
    int addItemToolSetSimple(ItemSet itemSet);

    List<ItemSetWithItemName> queryAllItemCommercialSet();
    List<ItemSetWithItemName> queryAllItemFoodSet();
    List<ItemSetWithItemName> queryAllItemOthersSet();
    List<ItemSetWithItemName> queryAllItemSmallToolSet();
    List<ItemSetWithItemName> queryAllItemToolSet();

    int deleteItemCommercialSet(String itemID);
    int deleteItemFoodSet(String itemID);
    int deleteItemOthersSet(String itemID);
    int deleteItemSmallToolSet(String itemID);
    int deleteItemToolSet(String itemID);





}
