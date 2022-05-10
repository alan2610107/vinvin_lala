package com.kuang.task;

import com.kuang.pojo.VinAlert;
import com.kuang.pojo.VinItem;
import com.kuang.pojo.VinItemSimple;
import com.kuang.service.VinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class InventoryAlert {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;
    public void addSumitemCount(List<VinItemSimple> listvinItemWeek, List<VinItemSimple> listvinItemMonth, String location, String today){
        HashMap<String,VinItemSimple> vinItemWeekMap;
        HashMap<String,VinItemSimple> vinItemMonthMap;
        int vinItemMonthSize = 0;
        int vinItemWeekSize = 0;
        switch (location){
            case "main0":
                System.out.println("=====addSumitemCount.main0=====");
                vinItemWeekMap = new HashMap<>();
                vinItemMonthMap = new HashMap<>();
                vinItemMonthSize = listvinItemMonth.size();
                vinItemWeekSize = listvinItemWeek.size();
                for (int i = 0; i < vinItemMonthSize; i++) {
                    vinItemMonthMap.put(listvinItemMonth.get(i).getId(), listvinItemMonth.get(i));
                }
                for (int i = 0; i < vinItemWeekSize; i++) {
                    vinItemWeekMap.put(listvinItemWeek.get(i).getId(), listvinItemWeek.get(i));
                }
                for (String id : vinItemMonthMap.keySet()) {
                    VinAlert vinAlert = new VinAlert();
                    String logid = UUID.randomUUID().toString().replace("-","");
                    vinAlert.setLogid(logid);
                    vinAlert.setId(id);
                    vinAlert.setTime(today);
                    VinItemSimple vinItemMonth = vinItemMonthMap.get(id);
                    vinAlert.setCount_month(vinItemMonth.getItemCount());

                    String category = vinItemMonth.getCategory();
                    vinAlert.setCategory(category);
                    int numinWarehouse = 0;
                    int ifExist = 0;
                    switch (category){
                        case "tool":
                            ifExist = vinService.ifItemExistinMain0(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.queryItemNuminMain0byId(id);
                            }
                            break;
                        case "smalltool":
                            ifExist = vinService.ifSmallItemExistinMain0(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.querySmallItemNuminMain0byId(id);
                            }
                            break;
                        case "food":
                            ifExist = vinService.ifFoodExistinMain0(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryFoodNuminMain0byId(id);
                            }
                            break;
                        case "commercialthing":
                            System.out.println("=====commercialthing=====");
                            ifExist = vinService.ifcommercialItemExistinMain0(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.querycommercialItemNuminMain0byId(id);
                            }
                            break;
                        case "other":
                            ifExist = vinService.ifothersExistinMain0(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryothersNuminMain0byId(id);
                            }
                            break;
                    }

                    if(vinItemWeekMap.containsKey(id)){
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                        }

                    }else {
                        vinAlert.setCount_week(0);
                        vinAlert.setIfalert_week(false);//不一定，要看看
                    }

                    if(numinWarehouse <= vinItemMonth.getItemCount()){
                        vinAlert.setIfalert_month(true);
                    }else {
                        vinAlert.setIfalert_month(false);
                    }

                    vinService.addSumitemCountinMain0(vinAlert);

                }

                for (String id : vinItemWeekMap.keySet()) {
                    if(!vinItemMonthMap.containsKey(id)){
                        VinAlert vinAlert = new VinAlert();
                        String logid = UUID.randomUUID().toString().replace("-","");
                        vinAlert.setLogid(logid);
                        vinAlert.setId(id);
                        vinAlert.setTime(today);
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        vinAlert.setCount_month(0);
                        String category = vinItemWeek.getCategory();
                        vinAlert.setCategory(category);
                        int numinWarehouse = 0;
                        int ifExist = 0;
                        switch (category){
                            case "tool":
                                ifExist = vinService.ifItemExistinMain0(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.queryItemNuminMain0byId(id);
                                }
                                break;
                            case "smalltool":
                                ifExist = vinService.ifSmallItemExistinMain0(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.querySmallItemNuminMain0byId(id);
                                }
                                break;
                            case "food":
                                ifExist = vinService.ifFoodExistinMain0(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryFoodNuminMain0byId(id);
                                }
                                break;
                            case "commercialthing":
                                System.out.println("=====commercialthing=====");
                                ifExist = vinService.ifcommercialItemExistinMain0(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.querycommercialItemNuminMain0byId(id);
                                }
                                break;
                            case "other":
                                ifExist = vinService.ifothersExistinMain0(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryothersNuminMain0byId(id);
                                }
                                break;
                        }
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                            vinAlert.setIfalert_month(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                            vinAlert.setIfalert_month(false);
                        }
                        vinService.addSumitemCountinMain0(vinAlert);
                    }

                }
                break;
            case "main1":
                System.out.println("=====addSumitemCount.main1=====");
                vinItemWeekMap = new HashMap<>();
                vinItemMonthMap = new HashMap<>();
                vinItemMonthSize = listvinItemMonth.size();
                vinItemWeekSize = listvinItemWeek.size();
                for (int i = 0; i < vinItemMonthSize; i++) {
                    vinItemMonthMap.put(listvinItemMonth.get(i).getId(), listvinItemMonth.get(i));
                }
                for (int i = 0; i < vinItemWeekSize; i++) {
                    vinItemWeekMap.put(listvinItemWeek.get(i).getId(), listvinItemWeek.get(i));
                }
                for (String id : vinItemMonthMap.keySet()) {
                    VinAlert vinAlert = new VinAlert();
                    String logid = UUID.randomUUID().toString().replace("-","");
                    vinAlert.setLogid(logid);
                    vinAlert.setId(id);
                    vinAlert.setTime(today);
                    VinItemSimple vinItemMonth = vinItemMonthMap.get(id);
                    vinAlert.setCount_month(vinItemMonth.getItemCount());

                    String category = vinItemMonth.getCategory();
                    vinAlert.setCategory(category);
                    int numinWarehouse = 0;
                    int ifExist = 0;
                    switch (category){
                        case "tool":
                            ifExist = vinService.ifItemExistinMain1(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.queryItemNuminMain1byId(id);
                            }
                            break;
                        case "smalltool":
                            ifExist = vinService.ifSmallItemExistinMain1(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.querySmallItemNuminMain1byId(id);
                            }
                            break;
                        case "food":
                            ifExist = vinService.ifFoodExistinMain1(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryFoodNuminMain1byId(id);
                            }
                            break;
                        case "commercialthing":
                            System.out.println("=====commercialthing=====");
                            ifExist = vinService.ifcommercialItemExistinMain1(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.querycommercialItemNuminMain1byId(id);
                            }
                            break;
                        case "other":
                            ifExist = vinService.ifothersExistinMain1(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryothersNuminMain1byId(id);
                            }
                            break;
                    }

                    if(vinItemWeekMap.containsKey(id)){
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                        }

                    }else {
                        vinAlert.setCount_week(0);
                        vinAlert.setIfalert_week(false);//不一定，要看看
                    }

                    if(numinWarehouse <= vinItemMonth.getItemCount()){
                        vinAlert.setIfalert_month(true);
                    }else {
                        vinAlert.setIfalert_month(false);
                    }

                    vinService.addSumitemCountinMain1(vinAlert);

                }

                for (String id : vinItemWeekMap.keySet()) {
                    if(!vinItemMonthMap.containsKey(id)){
                        VinAlert vinAlert = new VinAlert();
                        String logid = UUID.randomUUID().toString().replace("-","");
                        vinAlert.setLogid(logid);
                        vinAlert.setId(id);
                        vinAlert.setTime(today);
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        vinAlert.setCount_month(0);
                        String category = vinItemWeek.getCategory();
                        vinAlert.setCategory(category);
                        int numinWarehouse = 0;
                        int ifExist = 0;
                        switch (category){
                            case "tool":
                                ifExist = vinService.ifItemExistinMain1(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.queryItemNuminMain1byId(id);
                                }
                                break;
                            case "smalltool":
                                ifExist = vinService.ifSmallItemExistinMain1(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.querySmallItemNuminMain1byId(id);
                                }
                                break;
                            case "food":
                                ifExist = vinService.ifFoodExistinMain1(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryFoodNuminMain1byId(id);
                                }
                                break;
                            case "commercialthing":
                                System.out.println("=====commercialthing=====");
                                ifExist = vinService.ifcommercialItemExistinMain1(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.querycommercialItemNuminMain1byId(id);
                                }
                                break;
                            case "other":
                                ifExist = vinService.ifothersExistinMain1(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryothersNuminMain1byId(id);
                                }
                                break;
                        }
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                            vinAlert.setIfalert_month(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                            vinAlert.setIfalert_month(false);
                        }
                        vinService.addSumitemCountinMain1(vinAlert);
                    }

                }
                break;
            case "main2":
                System.out.println("=====addSumitemCount.main2=====");
                vinItemWeekMap = new HashMap<>();
                vinItemMonthMap = new HashMap<>();
                vinItemMonthSize = listvinItemMonth.size();
                vinItemWeekSize = listvinItemWeek.size();
                for (int i = 0; i < vinItemMonthSize; i++) {
                    vinItemMonthMap.put(listvinItemMonth.get(i).getId(), listvinItemMonth.get(i));
                }
                for (int i = 0; i < vinItemWeekSize; i++) {
                    vinItemWeekMap.put(listvinItemWeek.get(i).getId(), listvinItemWeek.get(i));
                }
                for (String id : vinItemMonthMap.keySet()) {
                    VinAlert vinAlert = new VinAlert();
                    String logid = UUID.randomUUID().toString().replace("-","");
                    vinAlert.setLogid(logid);
                    vinAlert.setId(id);
                    vinAlert.setTime(today);
                    VinItemSimple vinItemMonth = vinItemMonthMap.get(id);
                    vinAlert.setCount_month(vinItemMonth.getItemCount());

                    String category = vinItemMonth.getCategory();
                    vinAlert.setCategory(category);
                    int numinWarehouse = 0;
                    int ifExist = 0;
                    switch (category){
                        case "tool":
                            ifExist = vinService.ifItemExistinMain2(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.queryItemNuminMain2byId(id);
                            }
                            break;
                        case "smalltool":
                            ifExist = vinService.ifSmallItemExistinMain2(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.querySmallItemNuminMain2byId(id);
                            }
                            break;
                        case "food":
                            ifExist = vinService.ifFoodExistinMain2(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryFoodNuminMain2byId(id);
                            }
                            break;
                        case "commercialthing":
                            System.out.println("=====commercialthing=====");
                            ifExist = vinService.ifcommercialItemExistinMain2(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.querycommercialItemNuminMain2byId(id);
                            }
                            break;
                        case "other":
                            ifExist = vinService.ifothersExistinMain2(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryothersNuminMain2byId(id);
                            }
                            break;
                    }

                    if(vinItemWeekMap.containsKey(id)){
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                        }

                    }else {
                        vinAlert.setCount_week(0);
                        vinAlert.setIfalert_week(false);//不一定，要看看
                    }

                    if(numinWarehouse <= vinItemMonth.getItemCount()){
                        vinAlert.setIfalert_month(true);
                    }else {
                        vinAlert.setIfalert_month(false);
                    }

                    vinService.addSumitemCountinMain2(vinAlert);

                }

                for (String id : vinItemWeekMap.keySet()) {
                    if(!vinItemMonthMap.containsKey(id)){
                        VinAlert vinAlert = new VinAlert();
                        String logid = UUID.randomUUID().toString().replace("-","");
                        vinAlert.setLogid(logid);
                        vinAlert.setId(id);
                        vinAlert.setTime(today);
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        vinAlert.setCount_month(0);
                        String category = vinItemWeek.getCategory();
                        vinAlert.setCategory(category);
                        int numinWarehouse = 0;
                        int ifExist = 0;
                        switch (category){
                            case "tool":
                                ifExist = vinService.ifItemExistinMain2(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.queryItemNuminMain2byId(id);
                                }
                                break;
                            case "smalltool":
                                ifExist = vinService.ifSmallItemExistinMain2(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.querySmallItemNuminMain2byId(id);
                                }
                                break;
                            case "food":
                                ifExist = vinService.ifFoodExistinMain2(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryFoodNuminMain2byId(id);
                                }
                                break;
                            case "commercialthing":
                                System.out.println("=====commercialthing=====");
                                ifExist = vinService.ifcommercialItemExistinMain2(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.querycommercialItemNuminMain2byId(id);
                                }
                                break;
                            case "other":
                                ifExist = vinService.ifothersExistinMain2(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryothersNuminMain2byId(id);
                                }
                                break;
                        }
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                            vinAlert.setIfalert_month(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                            vinAlert.setIfalert_month(false);
                        }
                        vinService.addSumitemCountinMain2(vinAlert);
                    }

                }
                break;

            case "shop1":
                System.out.println("=====addSumitemCount.shop1=====");
                vinItemWeekMap = new HashMap<>();
                vinItemMonthMap = new HashMap<>();
                vinItemMonthSize = listvinItemMonth.size();
                vinItemWeekSize = listvinItemWeek.size();
                for (int i = 0; i < vinItemMonthSize; i++) {
                    vinItemMonthMap.put(listvinItemMonth.get(i).getId(), listvinItemMonth.get(i));
                }
                for (int i = 0; i < vinItemWeekSize; i++) {
                    vinItemWeekMap.put(listvinItemWeek.get(i).getId(), listvinItemWeek.get(i));
                }
                for (String id : vinItemMonthMap.keySet()) {
                    VinAlert vinAlert = new VinAlert();
                    String logid = UUID.randomUUID().toString().replace("-","");
                    vinAlert.setLogid(logid);
                    vinAlert.setId(id);
                    vinAlert.setTime(today);
                    VinItemSimple vinItemMonth = vinItemMonthMap.get(id);
                    vinAlert.setCount_month(vinItemMonth.getItemCount());

                    String category = vinItemMonth.getCategory();
                    vinAlert.setCategory(category);
                    int numinWarehouse = 0;
                    int ifExist = 0;
                    switch (category){
                        case "tool":
                            ifExist = vinService.ifItemExistinShop1(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.queryItemNuminShop1byId(id);
                            }
                            break;
                        case "smalltool":
                            ifExist = vinService.ifSmallItemExistinShop1(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.querySmallItemNuminShop1byId(id);
                            }
                            break;
                        case "food":
                            ifExist = vinService.ifFoodExistinShop1(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryFoodNuminShop1byId(id);
                            }
                            break;
                        case "commercialthing":
                            System.out.println("=====commercialthing=====");
                            ifExist = vinService.ifcommercialItemExistinShop1(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.querycommercialItemNuminShop1byId(id);
                            }
                            break;
                        case "other":
                            ifExist = vinService.ifothersExistinShop1(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryothersNuminShop1byId(id);
                            }
                            break;
                    }

                    if(vinItemWeekMap.containsKey(id)){
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                        }

                    }else {
                        vinAlert.setCount_week(0);
                        vinAlert.setIfalert_week(false);//不一定，要看看
                    }

                    if(numinWarehouse <= vinItemMonth.getItemCount()){
                        vinAlert.setIfalert_month(true);
                    }else {
                        vinAlert.setIfalert_month(false);
                    }

                    vinService.addSumitemCountinShop1(vinAlert);

                }

                for (String id : vinItemWeekMap.keySet()) {
                    if(!vinItemMonthMap.containsKey(id)){
                        VinAlert vinAlert = new VinAlert();
                        String logid = UUID.randomUUID().toString().replace("-","");
                        vinAlert.setLogid(logid);
                        vinAlert.setId(id);
                        vinAlert.setTime(today);
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        vinAlert.setCount_month(0);
                        String category = vinItemWeek.getCategory();
                        vinAlert.setCategory(category);
                        int numinWarehouse = 0;
                        int ifExist = 0;
                        switch (category){
                            case "tool":
                                ifExist = vinService.ifItemExistinShop1(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.queryItemNuminShop1byId(id);
                                }
                                break;
                            case "smalltool":
                                ifExist = vinService.ifSmallItemExistinShop1(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.querySmallItemNuminShop1byId(id);
                                }
                                break;
                            case "food":
                                ifExist = vinService.ifFoodExistinShop1(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryFoodNuminShop1byId(id);
                                }
                                break;
                            case "commercialthing":
                                System.out.println("=====commercialthing=====");
                                ifExist = vinService.ifcommercialItemExistinShop1(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.querycommercialItemNuminShop1byId(id);
                                }
                                break;
                            case "other":
                                ifExist = vinService.ifothersExistinShop1(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryothersNuminShop1byId(id);
                                }
                                break;
                        }
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                            vinAlert.setIfalert_month(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                            vinAlert.setIfalert_month(false);
                        }
                        vinService.addSumitemCountinShop1(vinAlert);
                    }

                }
                break;

            case "shop2":
                System.out.println("=====addSumitemCount.shop2=====");
                vinItemWeekMap = new HashMap<>();
                vinItemMonthMap = new HashMap<>();
                vinItemMonthSize = listvinItemMonth.size();
                vinItemWeekSize = listvinItemWeek.size();
                for (int i = 0; i < vinItemMonthSize; i++) {
                    vinItemMonthMap.put(listvinItemMonth.get(i).getId(), listvinItemMonth.get(i));
                }
                for (int i = 0; i < vinItemWeekSize; i++) {
                    vinItemWeekMap.put(listvinItemWeek.get(i).getId(), listvinItemWeek.get(i));
                }
                for (String id : vinItemMonthMap.keySet()) {
                    VinAlert vinAlert = new VinAlert();
                    String logid = UUID.randomUUID().toString().replace("-","");
                    vinAlert.setLogid(logid);
                    vinAlert.setId(id);
                    vinAlert.setTime(today);
                    VinItemSimple vinItemMonth = vinItemMonthMap.get(id);
                    vinAlert.setCount_month(vinItemMonth.getItemCount());

                    String category = vinItemMonth.getCategory();
                    vinAlert.setCategory(category);
                    int numinWarehouse = 0;
                    int ifExist = 0;
                    switch (category){
                        case "tool":
                            ifExist = vinService.ifItemExistinShop2(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.queryItemNuminShop2byId(id);
                            }
                            break;
                        case "smalltool":
                            ifExist = vinService.ifSmallItemExistinShop2(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.querySmallItemNuminShop2byId(id);
                            }
                            break;
                        case "food":
                            ifExist = vinService.ifFoodExistinShop2(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryFoodNuminShop2byId(id);
                            }
                            break;
                        case "commercialthing":
                            System.out.println("=====commercialthing=====");
                            ifExist = vinService.ifcommercialItemExistinShop2(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.querycommercialItemNuminShop2byId(id);
                            }
                            break;
                        case "other":
                            ifExist = vinService.ifothersExistinShop2(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryothersNuminShop2byId(id);
                            }
                            break;
                    }

                    if(vinItemWeekMap.containsKey(id)){
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                        }

                    }else {
                        vinAlert.setCount_week(0);
                        vinAlert.setIfalert_week(false);//不一定，要看看
                    }

                    if(numinWarehouse <= vinItemMonth.getItemCount()){
                        vinAlert.setIfalert_month(true);
                    }else {
                        vinAlert.setIfalert_month(false);
                    }

                    vinService.addSumitemCountinShop2(vinAlert);

                }

                for (String id : vinItemWeekMap.keySet()) {
                    if(!vinItemMonthMap.containsKey(id)){
                        VinAlert vinAlert = new VinAlert();
                        String logid = UUID.randomUUID().toString().replace("-","");
                        vinAlert.setLogid(logid);
                        vinAlert.setId(id);
                        vinAlert.setTime(today);
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        vinAlert.setCount_month(0);
                        String category = vinItemWeek.getCategory();
                        vinAlert.setCategory(category);
                        int numinWarehouse = 0;
                        int ifExist = 0;
                        switch (category){
                            case "tool":
                                ifExist = vinService.ifItemExistinShop2(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.queryItemNuminShop2byId(id);
                                }
                                break;
                            case "smalltool":
                                ifExist = vinService.ifSmallItemExistinShop2(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.querySmallItemNuminShop2byId(id);
                                }
                                break;
                            case "food":
                                ifExist = vinService.ifFoodExistinShop2(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryFoodNuminShop2byId(id);
                                }
                                break;
                            case "commercialthing":
                                System.out.println("=====commercialthing=====");
                                ifExist = vinService.ifcommercialItemExistinShop2(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.querycommercialItemNuminShop2byId(id);
                                }
                                break;
                            case "other":
                                ifExist = vinService.ifothersExistinShop2(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryothersNuminShop2byId(id);
                                }
                                break;
                        }
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                            vinAlert.setIfalert_month(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                            vinAlert.setIfalert_month(false);
                        }
                        vinService.addSumitemCountinShop2(vinAlert);
                    }

                }
                break;

            case "shop3":
                System.out.println("=====addSumitemCount.shop3=====");
                vinItemWeekMap = new HashMap<>();
                vinItemMonthMap = new HashMap<>();
                vinItemMonthSize = listvinItemMonth.size();
                vinItemWeekSize = listvinItemWeek.size();
                for (int i = 0; i < vinItemMonthSize; i++) {
                    vinItemMonthMap.put(listvinItemMonth.get(i).getId(), listvinItemMonth.get(i));
                }
                for (int i = 0; i < vinItemWeekSize; i++) {
                    vinItemWeekMap.put(listvinItemWeek.get(i).getId(), listvinItemWeek.get(i));
                }
                for (String id : vinItemMonthMap.keySet()) {
                    VinAlert vinAlert = new VinAlert();
                    String logid = UUID.randomUUID().toString().replace("-","");
                    vinAlert.setLogid(logid);
                    vinAlert.setId(id);
                    vinAlert.setTime(today);
                    VinItemSimple vinItemMonth = vinItemMonthMap.get(id);
                    vinAlert.setCount_month(vinItemMonth.getItemCount());

                    String category = vinItemMonth.getCategory();
                    vinAlert.setCategory(category);
                    int numinWarehouse = 0;
                    int ifExist = 0;
                    switch (category){
                        case "tool":
                            ifExist = vinService.ifItemExistinShop3(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.queryItemNuminShop3byId(id);
                            }
                            break;
                        case "smalltool":
                            ifExist = vinService.ifSmallItemExistinShop3(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.querySmallItemNuminShop3byId(id);
                            }
                            break;
                        case "food":
                            ifExist = vinService.ifFoodExistinShop3(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryFoodNuminShop3byId(id);
                            }
                            break;
                        case "commercialthing":
                            System.out.println("=====commercialthing=====");
                            ifExist = vinService.ifcommercialItemExistinShop3(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.querycommercialItemNuminShop3byId(id);
                            }
                            break;
                        case "other":
                            ifExist = vinService.ifothersExistinShop3(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryothersNuminShop3byId(id);
                            }
                            break;
                    }

                    if(vinItemWeekMap.containsKey(id)){
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                        }

                    }else {
                        vinAlert.setCount_week(0);
                        vinAlert.setIfalert_week(false);//不一定，要看看
                    }

                    if(numinWarehouse <= vinItemMonth.getItemCount()){
                        vinAlert.setIfalert_month(true);
                    }else {
                        vinAlert.setIfalert_month(false);
                    }

                    vinService.addSumitemCountinShop3(vinAlert);

                }

                for (String id : vinItemWeekMap.keySet()) {
                    if(!vinItemMonthMap.containsKey(id)){
                        VinAlert vinAlert = new VinAlert();
                        String logid = UUID.randomUUID().toString().replace("-","");
                        vinAlert.setLogid(logid);
                        vinAlert.setId(id);
                        vinAlert.setTime(today);
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        vinAlert.setCount_month(0);
                        String category = vinItemWeek.getCategory();
                        vinAlert.setCategory(category);
                        int numinWarehouse = 0;
                        int ifExist = 0;
                        switch (category){
                            case "tool":
                                ifExist = vinService.ifItemExistinShop3(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.queryItemNuminShop3byId(id);
                                }
                                break;
                            case "smalltool":
                                ifExist = vinService.ifSmallItemExistinShop3(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.querySmallItemNuminShop3byId(id);
                                }
                                break;
                            case "food":
                                ifExist = vinService.ifFoodExistinShop3(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryFoodNuminShop3byId(id);
                                }
                                break;
                            case "commercialthing":
                                System.out.println("=====commercialthing=====");
                                ifExist = vinService.ifcommercialItemExistinShop3(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.querycommercialItemNuminShop3byId(id);
                                }
                                break;
                            case "other":
                                ifExist = vinService.ifothersExistinShop3(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryothersNuminShop3byId(id);
                                }
                                break;
                        }
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                            vinAlert.setIfalert_month(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                            vinAlert.setIfalert_month(false);
                        }
                        vinService.addSumitemCountinShop3(vinAlert);
                    }

                }
                break;

            case "shop4":
                System.out.println("=====addSumitemCount.shop4=====");
                vinItemWeekMap = new HashMap<>();
                vinItemMonthMap = new HashMap<>();
                vinItemMonthSize = listvinItemMonth.size();
                vinItemWeekSize = listvinItemWeek.size();
                for (int i = 0; i < vinItemMonthSize; i++) {
                    vinItemMonthMap.put(listvinItemMonth.get(i).getId(), listvinItemMonth.get(i));
                }
                for (int i = 0; i < vinItemWeekSize; i++) {
                    vinItemWeekMap.put(listvinItemWeek.get(i).getId(), listvinItemWeek.get(i));
                }
                for (String id : vinItemMonthMap.keySet()) {
                    VinAlert vinAlert = new VinAlert();
                    String logid = UUID.randomUUID().toString().replace("-","");
                    vinAlert.setLogid(logid);
                    vinAlert.setId(id);
                    vinAlert.setTime(today);
                    VinItemSimple vinItemMonth = vinItemMonthMap.get(id);
                    vinAlert.setCount_month(vinItemMonth.getItemCount());

                    String category = vinItemMonth.getCategory();
                    vinAlert.setCategory(category);
                    int numinWarehouse = 0;
                    int ifExist = 0;
                    switch (category){
                        case "tool":
                            ifExist = vinService.ifItemExistinShop4(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.queryItemNuminShop4byId(id);
                            }
                            break;
                        case "smalltool":
                            ifExist = vinService.ifSmallItemExistinShop4(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.querySmallItemNuminShop4byId(id);
                            }
                            break;
                        case "food":
                            ifExist = vinService.ifFoodExistinShop4(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryFoodNuminShop4byId(id);
                            }
                            break;
                        case "commercialthing":
                            System.out.println("=====commercialthing=====");
                            ifExist = vinService.ifcommercialItemExistinShop4(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.querycommercialItemNuminShop4byId(id);
                            }
                            break;
                        case "other":
                            ifExist = vinService.ifothersExistinShop4(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryothersNuminShop4byId(id);
                            }
                            break;
                    }

                    if(vinItemWeekMap.containsKey(id)){
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                        }

                    }else {
                        vinAlert.setCount_week(0);
                        vinAlert.setIfalert_week(false);//不一定，要看看
                    }

                    if(numinWarehouse <= vinItemMonth.getItemCount()){
                        vinAlert.setIfalert_month(true);
                    }else {
                        vinAlert.setIfalert_month(false);
                    }

                    vinService.addSumitemCountinShop4(vinAlert);

                }

                for (String id : vinItemWeekMap.keySet()) {
                    if(!vinItemMonthMap.containsKey(id)){
                        VinAlert vinAlert = new VinAlert();
                        String logid = UUID.randomUUID().toString().replace("-","");
                        vinAlert.setLogid(logid);
                        vinAlert.setId(id);
                        vinAlert.setTime(today);
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        vinAlert.setCount_month(0);
                        String category = vinItemWeek.getCategory();
                        vinAlert.setCategory(category);
                        int numinWarehouse = 0;
                        int ifExist = 0;
                        switch (category){
                            case "tool":
                                ifExist = vinService.ifItemExistinShop4(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.queryItemNuminShop4byId(id);
                                }
                                break;
                            case "smalltool":
                                ifExist = vinService.ifSmallItemExistinShop4(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.querySmallItemNuminShop4byId(id);
                                }
                                break;
                            case "food":
                                ifExist = vinService.ifFoodExistinShop4(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryFoodNuminShop4byId(id);
                                }
                                break;
                            case "commercialthing":
                                System.out.println("=====commercialthing=====");
                                ifExist = vinService.ifcommercialItemExistinShop4(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.querycommercialItemNuminShop4byId(id);
                                }
                                break;
                            case "other":
                                ifExist = vinService.ifothersExistinShop4(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryothersNuminShop4byId(id);
                                }
                                break;
                        }
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                            vinAlert.setIfalert_month(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                            vinAlert.setIfalert_month(false);
                        }
                        vinService.addSumitemCountinShop4(vinAlert);
                    }

                }
                break;

            case "shop5":
                System.out.println("=====addSumitemCount.shop5=====");
                vinItemWeekMap = new HashMap<>();
                vinItemMonthMap = new HashMap<>();
                vinItemMonthSize = listvinItemMonth.size();
                vinItemWeekSize = listvinItemWeek.size();
                for (int i = 0; i < vinItemMonthSize; i++) {
                    vinItemMonthMap.put(listvinItemMonth.get(i).getId(), listvinItemMonth.get(i));
                }
                for (int i = 0; i < vinItemWeekSize; i++) {
                    vinItemWeekMap.put(listvinItemWeek.get(i).getId(), listvinItemWeek.get(i));
                }
                for (String id : vinItemMonthMap.keySet()) {
                    VinAlert vinAlert = new VinAlert();
                    String logid = UUID.randomUUID().toString().replace("-","");
                    vinAlert.setLogid(logid);
                    vinAlert.setId(id);
                    vinAlert.setTime(today);
                    VinItemSimple vinItemMonth = vinItemMonthMap.get(id);
                    vinAlert.setCount_month(vinItemMonth.getItemCount());

                    String category = vinItemMonth.getCategory();
                    vinAlert.setCategory(category);
                    int numinWarehouse = 0;
                    int ifExist = 0;
                    switch (category){
                        case "tool":
                            ifExist = vinService.ifItemExistinShop5(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.queryItemNuminShop5byId(id);
                            }
                            break;
                        case "smalltool":
                            ifExist = vinService.ifSmallItemExistinShop5(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.querySmallItemNuminShop5byId(id);
                            }
                            break;
                        case "food":
                            ifExist = vinService.ifFoodExistinShop5(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryFoodNuminShop5byId(id);
                            }
                            break;
                        case "commercialthing":
                            System.out.println("=====commercialthing=====");
                            ifExist = vinService.ifcommercialItemExistinShop5(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.querycommercialItemNuminShop5byId(id);
                            }
                            break;
                        case "other":
                            ifExist = vinService.ifothersExistinShop5(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryothersNuminShop5byId(id);
                            }
                            break;
                    }

                    if(vinItemWeekMap.containsKey(id)){
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                        }

                    }else {
                        vinAlert.setCount_week(0);
                        vinAlert.setIfalert_week(false);//不一定，要看看
                    }

                    if(numinWarehouse <= vinItemMonth.getItemCount()){
                        vinAlert.setIfalert_month(true);
                    }else {
                        vinAlert.setIfalert_month(false);
                    }

                    vinService.addSumitemCountinShop5(vinAlert);

                }

                for (String id : vinItemWeekMap.keySet()) {
                    if(!vinItemMonthMap.containsKey(id)){
                        VinAlert vinAlert = new VinAlert();
                        String logid = UUID.randomUUID().toString().replace("-","");
                        vinAlert.setLogid(logid);
                        vinAlert.setId(id);
                        vinAlert.setTime(today);
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        vinAlert.setCount_month(0);
                        String category = vinItemWeek.getCategory();
                        vinAlert.setCategory(category);
                        int numinWarehouse = 0;
                        int ifExist = 0;
                        switch (category){
                            case "tool":
                                ifExist = vinService.ifItemExistinShop5(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.queryItemNuminShop5byId(id);
                                }
                                break;
                            case "smalltool":
                                ifExist = vinService.ifSmallItemExistinShop5(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.querySmallItemNuminShop5byId(id);
                                }
                                break;
                            case "food":
                                ifExist = vinService.ifFoodExistinShop5(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryFoodNuminShop5byId(id);
                                }
                                break;
                            case "commercialthing":
                                System.out.println("=====commercialthing=====");
                                ifExist = vinService.ifcommercialItemExistinShop5(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.querycommercialItemNuminShop5byId(id);
                                }
                                break;
                            case "other":
                                ifExist = vinService.ifothersExistinShop5(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryothersNuminShop5byId(id);
                                }
                                break;
                        }
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                            vinAlert.setIfalert_month(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                            vinAlert.setIfalert_month(false);
                        }
                        vinService.addSumitemCountinShop5(vinAlert);
                    }

                }
                break;
            case "shop6":
                System.out.println("=====addSumitemCount.shop6=====");
                vinItemWeekMap = new HashMap<>();
                vinItemMonthMap = new HashMap<>();
                vinItemMonthSize = listvinItemMonth.size();
                vinItemWeekSize = listvinItemWeek.size();
                for (int i = 0; i < vinItemMonthSize; i++) {
                    vinItemMonthMap.put(listvinItemMonth.get(i).getId(), listvinItemMonth.get(i));
                }
                for (int i = 0; i < vinItemWeekSize; i++) {
                    vinItemWeekMap.put(listvinItemWeek.get(i).getId(), listvinItemWeek.get(i));
                }
                for (String id : vinItemMonthMap.keySet()) {
                    VinAlert vinAlert = new VinAlert();
                    String logid = UUID.randomUUID().toString().replace("-","");
                    vinAlert.setLogid(logid);
                    vinAlert.setId(id);
                    vinAlert.setTime(today);
                    VinItemSimple vinItemMonth = vinItemMonthMap.get(id);
                    vinAlert.setCount_month(vinItemMonth.getItemCount());

                    String category = vinItemMonth.getCategory();
                    vinAlert.setCategory(category);
                    int numinWarehouse = 0;
                    int ifExist = 0;
                    switch (category){
                        case "tool":
                            ifExist = vinService.ifItemExistinShop6(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.queryItemNuminShop6byId(id);
                            }
                            break;
                        case "smalltool":
                            ifExist = vinService.ifSmallItemExistinShop6(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.querySmallItemNuminShop6byId(id);
                            }
                            break;
                        case "food":
                            ifExist = vinService.ifFoodExistinShop6(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryFoodNuminShop6byId(id);
                            }
                            break;
                        case "commercialthing":
                            System.out.println("=====commercialthing=====");
                            ifExist = vinService.ifcommercialItemExistinShop6(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.querycommercialItemNuminShop6byId(id);
                            }
                            break;
                        case "other":
                            ifExist = vinService.ifothersExistinShop6(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryothersNuminShop6byId(id);
                            }
                            break;
                    }

                    if(vinItemWeekMap.containsKey(id)){
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                        }

                    }else {
                        vinAlert.setCount_week(0);
                        vinAlert.setIfalert_week(false);//不一定，要看看
                    }

                    if(numinWarehouse <= vinItemMonth.getItemCount()){
                        vinAlert.setIfalert_month(true);
                    }else {
                        vinAlert.setIfalert_month(false);
                    }

                    vinService.addSumitemCountinShop6(vinAlert);

                }

                for (String id : vinItemWeekMap.keySet()) {
                    if(!vinItemMonthMap.containsKey(id)){
                        VinAlert vinAlert = new VinAlert();
                        String logid = UUID.randomUUID().toString().replace("-","");
                        vinAlert.setLogid(logid);
                        vinAlert.setId(id);
                        vinAlert.setTime(today);
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        vinAlert.setCount_month(0);
                        String category = vinItemWeek.getCategory();
                        vinAlert.setCategory(category);
                        int numinWarehouse = 0;
                        int ifExist = 0;
                        switch (category){
                            case "tool":
                                ifExist = vinService.ifItemExistinShop6(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.queryItemNuminShop6byId(id);
                                }
                                break;
                            case "smalltool":
                                ifExist = vinService.ifSmallItemExistinShop6(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.querySmallItemNuminShop6byId(id);
                                }
                                break;
                            case "food":
                                ifExist = vinService.ifFoodExistinShop6(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryFoodNuminShop6byId(id);
                                }
                                break;
                            case "commercialthing":
                                System.out.println("=====commercialthing=====");
                                ifExist = vinService.ifcommercialItemExistinShop6(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.querycommercialItemNuminShop6byId(id);
                                }
                                break;
                            case "other":
                                ifExist = vinService.ifothersExistinShop6(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryothersNuminShop6byId(id);
                                }
                                break;
                        }
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                            vinAlert.setIfalert_month(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                            vinAlert.setIfalert_month(false);
                        }
                        vinService.addSumitemCountinShop6(vinAlert);
                    }

                }
                break;
            case "shop7":
                System.out.println("=====addSumitemCount.shop7=====");
                vinItemWeekMap = new HashMap<>();
                vinItemMonthMap = new HashMap<>();
                vinItemMonthSize = listvinItemMonth.size();
                vinItemWeekSize = listvinItemWeek.size();
                for (int i = 0; i < vinItemMonthSize; i++) {
                    vinItemMonthMap.put(listvinItemMonth.get(i).getId(), listvinItemMonth.get(i));
                }
                for (int i = 0; i < vinItemWeekSize; i++) {
                    vinItemWeekMap.put(listvinItemWeek.get(i).getId(), listvinItemWeek.get(i));
                }
                for (String id : vinItemMonthMap.keySet()) {
                    VinAlert vinAlert = new VinAlert();
                    String logid = UUID.randomUUID().toString().replace("-","");
                    vinAlert.setLogid(logid);
                    vinAlert.setId(id);
                    vinAlert.setTime(today);
                    VinItemSimple vinItemMonth = vinItemMonthMap.get(id);
                    vinAlert.setCount_month(vinItemMonth.getItemCount());

                    String category = vinItemMonth.getCategory();
                    vinAlert.setCategory(category);
                    int numinWarehouse = 0;
                    int ifExist = 0;
                    switch (category){
                        case "tool":
                            ifExist = vinService.ifItemExistinShop7(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.queryItemNuminShop7byId(id);
                            }
                            break;
                        case "smalltool":
                            ifExist = vinService.ifSmallItemExistinShop7(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.querySmallItemNuminShop7byId(id);
                            }
                            break;
                        case "food":
                            ifExist = vinService.ifFoodExistinShop7(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryFoodNuminShop7byId(id);
                            }
                            break;
                        case "commercialthing":
                            System.out.println("=====commercialthing=====");
                            ifExist = vinService.ifcommercialItemExistinShop7(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.querycommercialItemNuminShop7byId(id);
                            }
                            break;
                        case "other":
                            ifExist = vinService.ifothersExistinShop7(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryothersNuminShop7byId(id);
                            }
                            break;
                    }

                    if(vinItemWeekMap.containsKey(id)){
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                        }

                    }else {
                        vinAlert.setCount_week(0);
                        vinAlert.setIfalert_week(false);//不一定，要看看
                    }

                    if(numinWarehouse <= vinItemMonth.getItemCount()){
                        vinAlert.setIfalert_month(true);
                    }else {
                        vinAlert.setIfalert_month(false);
                    }

                    vinService.addSumitemCountinShop7(vinAlert);

                }

                for (String id : vinItemWeekMap.keySet()) {
                    if(!vinItemMonthMap.containsKey(id)){
                        VinAlert vinAlert = new VinAlert();
                        String logid = UUID.randomUUID().toString().replace("-","");
                        vinAlert.setLogid(logid);
                        vinAlert.setId(id);
                        vinAlert.setTime(today);
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        vinAlert.setCount_month(0);
                        String category = vinItemWeek.getCategory();
                        vinAlert.setCategory(category);
                        int numinWarehouse = 0;
                        int ifExist = 0;
                        switch (category){
                            case "tool":
                                ifExist = vinService.ifItemExistinShop7(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.queryItemNuminShop7byId(id);
                                }
                                break;
                            case "smalltool":
                                ifExist = vinService.ifSmallItemExistinShop7(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.querySmallItemNuminShop7byId(id);
                                }
                                break;
                            case "food":
                                ifExist = vinService.ifFoodExistinShop7(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryFoodNuminShop7byId(id);
                                }
                                break;
                            case "commercialthing":
                                System.out.println("=====commercialthing=====");
                                ifExist = vinService.ifcommercialItemExistinShop7(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.querycommercialItemNuminShop7byId(id);
                                }
                                break;
                            case "other":
                                ifExist = vinService.ifothersExistinShop7(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryothersNuminShop7byId(id);
                                }
                                break;
                        }
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                            vinAlert.setIfalert_month(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                            vinAlert.setIfalert_month(false);
                        }
                        vinService.addSumitemCountinShop7(vinAlert);
                    }

                }
                break;
            case "shop8":
                System.out.println("=====addSumitemCount.shop8=====");
                vinItemWeekMap = new HashMap<>();
                vinItemMonthMap = new HashMap<>();
                vinItemMonthSize = listvinItemMonth.size();
                vinItemWeekSize = listvinItemWeek.size();
                for (int i = 0; i < vinItemMonthSize; i++) {
                    vinItemMonthMap.put(listvinItemMonth.get(i).getId(), listvinItemMonth.get(i));
                }
                for (int i = 0; i < vinItemWeekSize; i++) {
                    vinItemWeekMap.put(listvinItemWeek.get(i).getId(), listvinItemWeek.get(i));
                }
                for (String id : vinItemMonthMap.keySet()) {
                    VinAlert vinAlert = new VinAlert();
                    String logid = UUID.randomUUID().toString().replace("-","");
                    vinAlert.setLogid(logid);
                    vinAlert.setId(id);
                    vinAlert.setTime(today);
                    VinItemSimple vinItemMonth = vinItemMonthMap.get(id);
                    vinAlert.setCount_month(vinItemMonth.getItemCount());

                    String category = vinItemMonth.getCategory();
                    vinAlert.setCategory(category);
                    int numinWarehouse = 0;
                    int ifExist = 0;
                    switch (category){
                        case "tool":
                            ifExist = vinService.ifItemExistinShop8(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.queryItemNuminShop8byId(id);
                            }
                            break;
                        case "smalltool":
                            ifExist = vinService.ifSmallItemExistinShop8(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.querySmallItemNuminShop8byId(id);
                            }
                            break;
                        case "food":
                            ifExist = vinService.ifFoodExistinShop8(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryFoodNuminShop8byId(id);
                            }
                            break;
                        case "commercialthing":
                            System.out.println("=====commercialthing=====");
                            ifExist = vinService.ifcommercialItemExistinShop8(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.querycommercialItemNuminShop8byId(id);
                            }
                            break;
                        case "other":
                            ifExist = vinService.ifothersExistinShop8(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryothersNuminShop8byId(id);
                            }
                            break;
                    }

                    if(vinItemWeekMap.containsKey(id)){
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                        }

                    }else {
                        vinAlert.setCount_week(0);
                        vinAlert.setIfalert_week(false);//不一定，要看看
                    }

                    if(numinWarehouse <= vinItemMonth.getItemCount()){
                        vinAlert.setIfalert_month(true);
                    }else {
                        vinAlert.setIfalert_month(false);
                    }

                    vinService.addSumitemCountinShop8(vinAlert);

                }

                for (String id : vinItemWeekMap.keySet()) {
                    if(!vinItemMonthMap.containsKey(id)){
                        VinAlert vinAlert = new VinAlert();
                        String logid = UUID.randomUUID().toString().replace("-","");
                        vinAlert.setLogid(logid);
                        vinAlert.setId(id);
                        vinAlert.setTime(today);
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        vinAlert.setCount_month(0);
                        String category = vinItemWeek.getCategory();
                        vinAlert.setCategory(category);
                        int numinWarehouse = 0;
                        int ifExist = 0;
                        switch (category){
                            case "tool":
                                ifExist = vinService.ifItemExistinShop8(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.queryItemNuminShop8byId(id);
                                }
                                break;
                            case "smalltool":
                                ifExist = vinService.ifSmallItemExistinShop8(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.querySmallItemNuminShop8byId(id);
                                }
                                break;
                            case "food":
                                ifExist = vinService.ifFoodExistinShop8(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryFoodNuminShop8byId(id);
                                }
                                break;
                            case "commercialthing":
                                System.out.println("=====commercialthing=====");
                                ifExist = vinService.ifcommercialItemExistinShop8(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.querycommercialItemNuminShop8byId(id);
                                }
                                break;
                            case "other":
                                ifExist = vinService.ifothersExistinShop8(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryothersNuminShop8byId(id);
                                }
                                break;
                        }
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                            vinAlert.setIfalert_month(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                            vinAlert.setIfalert_month(false);
                        }
                        vinService.addSumitemCountinShop8(vinAlert);
                    }

                }
                break;
            case "shop9":
                System.out.println("=====addSumitemCount.shop9=====");
                vinItemWeekMap = new HashMap<>();
                vinItemMonthMap = new HashMap<>();
                vinItemMonthSize = listvinItemMonth.size();
                vinItemWeekSize = listvinItemWeek.size();
                for (int i = 0; i < vinItemMonthSize; i++) {
                    vinItemMonthMap.put(listvinItemMonth.get(i).getId(), listvinItemMonth.get(i));
                }
                for (int i = 0; i < vinItemWeekSize; i++) {
                    vinItemWeekMap.put(listvinItemWeek.get(i).getId(), listvinItemWeek.get(i));
                }
                for (String id : vinItemMonthMap.keySet()) {
                    VinAlert vinAlert = new VinAlert();
                    String logid = UUID.randomUUID().toString().replace("-","");
                    vinAlert.setLogid(logid);
                    vinAlert.setId(id);
                    vinAlert.setTime(today);
                    VinItemSimple vinItemMonth = vinItemMonthMap.get(id);
                    vinAlert.setCount_month(vinItemMonth.getItemCount());

                    String category = vinItemMonth.getCategory();
                    vinAlert.setCategory(category);
                    int numinWarehouse = 0;
                    int ifExist = 0;
                    switch (category){
                        case "tool":
                            ifExist = vinService.ifItemExistinShop9(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.queryItemNuminShop9byId(id);
                            }
                            break;
                        case "smalltool":
                            ifExist = vinService.ifSmallItemExistinShop9(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.querySmallItemNuminShop9byId(id);
                            }
                            break;
                        case "food":
                            ifExist = vinService.ifFoodExistinShop9(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryFoodNuminShop9byId(id);
                            }
                            break;
                        case "commercialthing":
                            System.out.println("=====commercialthing=====");
                            ifExist = vinService.ifcommercialItemExistinShop9(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.querycommercialItemNuminShop9byId(id);
                            }
                            break;
                        case "other":
                            ifExist = vinService.ifothersExistinShop9(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryothersNuminShop9byId(id);
                            }
                            break;
                    }

                    if(vinItemWeekMap.containsKey(id)){
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                        }

                    }else {
                        vinAlert.setCount_week(0);
                        vinAlert.setIfalert_week(false);//不一定，要看看
                    }

                    if(numinWarehouse <= vinItemMonth.getItemCount()){
                        vinAlert.setIfalert_month(true);
                    }else {
                        vinAlert.setIfalert_month(false);
                    }

                    vinService.addSumitemCountinShop9(vinAlert);

                }

                for (String id : vinItemWeekMap.keySet()) {
                    if(!vinItemMonthMap.containsKey(id)){
                        VinAlert vinAlert = new VinAlert();
                        String logid = UUID.randomUUID().toString().replace("-","");
                        vinAlert.setLogid(logid);
                        vinAlert.setId(id);
                        vinAlert.setTime(today);
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        vinAlert.setCount_month(0);
                        String category = vinItemWeek.getCategory();
                        vinAlert.setCategory(category);
                        int numinWarehouse = 0;
                        int ifExist = 0;
                        switch (category){
                            case "tool":
                                ifExist = vinService.ifItemExistinShop9(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.queryItemNuminShop9byId(id);
                                }
                                break;
                            case "smalltool":
                                ifExist = vinService.ifSmallItemExistinShop9(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.querySmallItemNuminShop9byId(id);
                                }
                                break;
                            case "food":
                                ifExist = vinService.ifFoodExistinShop9(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryFoodNuminShop9byId(id);
                                }
                                break;
                            case "commercialthing":
                                System.out.println("=====commercialthing=====");
                                ifExist = vinService.ifcommercialItemExistinShop9(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.querycommercialItemNuminShop9byId(id);
                                }
                                break;
                            case "other":
                                ifExist = vinService.ifothersExistinShop9(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryothersNuminShop9byId(id);
                                }
                                break;
                        }
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                            vinAlert.setIfalert_month(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                            vinAlert.setIfalert_month(false);
                        }
                        vinService.addSumitemCountinShop9(vinAlert);
                    }

                }
                break;
            case "shop10":
                System.out.println("=====addSumitemCount.shop10=====");
                vinItemWeekMap = new HashMap<>();
                vinItemMonthMap = new HashMap<>();
                vinItemMonthSize = listvinItemMonth.size();
                vinItemWeekSize = listvinItemWeek.size();
                for (int i = 0; i < vinItemMonthSize; i++) {
                    vinItemMonthMap.put(listvinItemMonth.get(i).getId(), listvinItemMonth.get(i));
                }
                for (int i = 0; i < vinItemWeekSize; i++) {
                    vinItemWeekMap.put(listvinItemWeek.get(i).getId(), listvinItemWeek.get(i));
                }
                for (String id : vinItemMonthMap.keySet()) {
                    VinAlert vinAlert = new VinAlert();
                    String logid = UUID.randomUUID().toString().replace("-","");
                    vinAlert.setLogid(logid);
                    vinAlert.setId(id);
                    vinAlert.setTime(today);
                    VinItemSimple vinItemMonth = vinItemMonthMap.get(id);
                    vinAlert.setCount_month(vinItemMonth.getItemCount());

                    String category = vinItemMonth.getCategory();
                    vinAlert.setCategory(category);
                    int numinWarehouse = 0;
                    int ifExist = 0;
                    switch (category){
                        case "tool":
                            ifExist = vinService.ifItemExistinShop10(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.queryItemNuminShop10byId(id);
                            }
                            break;
                        case "smalltool":
                            ifExist = vinService.ifSmallItemExistinShop10(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.querySmallItemNuminShop10byId(id);
                            }
                            break;
                        case "food":
                            ifExist = vinService.ifFoodExistinShop10(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryFoodNuminShop10byId(id);
                            }
                            break;
                        case "commercialthing":
                            System.out.println("=====commercialthing=====");
                            ifExist = vinService.ifcommercialItemExistinShop10(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.querycommercialItemNuminShop10byId(id);
                            }
                            break;
                        case "other":
                            ifExist = vinService.ifothersExistinShop10(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryothersNuminShop10byId(id);
                            }
                            break;
                    }

                    if(vinItemWeekMap.containsKey(id)){
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                        }

                    }else {
                        vinAlert.setCount_week(0);
                        vinAlert.setIfalert_week(false);//不一定，要看看
                    }

                    if(numinWarehouse <= vinItemMonth.getItemCount()){
                        vinAlert.setIfalert_month(true);
                    }else {
                        vinAlert.setIfalert_month(false);
                    }

                    vinService.addSumitemCountinShop10(vinAlert);

                }

                for (String id : vinItemWeekMap.keySet()) {
                    if(!vinItemMonthMap.containsKey(id)){
                        VinAlert vinAlert = new VinAlert();
                        String logid = UUID.randomUUID().toString().replace("-","");
                        vinAlert.setLogid(logid);
                        vinAlert.setId(id);
                        vinAlert.setTime(today);
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        vinAlert.setCount_month(0);
                        String category = vinItemWeek.getCategory();
                        vinAlert.setCategory(category);
                        int numinWarehouse = 0;
                        int ifExist = 0;
                        switch (category){
                            case "tool":
                                ifExist = vinService.ifItemExistinShop10(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.queryItemNuminShop10byId(id);
                                }
                                break;
                            case "smalltool":
                                ifExist = vinService.ifSmallItemExistinShop10(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.querySmallItemNuminShop10byId(id);
                                }
                                break;
                            case "food":
                                ifExist = vinService.ifFoodExistinShop10(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryFoodNuminShop10byId(id);
                                }
                                break;
                            case "commercialthing":
                                System.out.println("=====commercialthing=====");
                                ifExist = vinService.ifcommercialItemExistinShop10(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.querycommercialItemNuminShop10byId(id);
                                }
                                break;
                            case "other":
                                ifExist = vinService.ifothersExistinShop10(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryothersNuminShop10byId(id);
                                }
                                break;
                        }
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                            vinAlert.setIfalert_month(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                            vinAlert.setIfalert_month(false);
                        }
                        vinService.addSumitemCountinShop10(vinAlert);
                    }

                }
                break;
            case "shop11":
                System.out.println("=====addSumitemCount.shop11=====");
                vinItemWeekMap = new HashMap<>();
                vinItemMonthMap = new HashMap<>();
                vinItemMonthSize = listvinItemMonth.size();
                vinItemWeekSize = listvinItemWeek.size();
                for (int i = 0; i < vinItemMonthSize; i++) {
                    vinItemMonthMap.put(listvinItemMonth.get(i).getId(), listvinItemMonth.get(i));
                }
                for (int i = 0; i < vinItemWeekSize; i++) {
                    vinItemWeekMap.put(listvinItemWeek.get(i).getId(), listvinItemWeek.get(i));
                }
                for (String id : vinItemMonthMap.keySet()) {
                    VinAlert vinAlert = new VinAlert();
                    String logid = UUID.randomUUID().toString().replace("-","");
                    vinAlert.setLogid(logid);
                    vinAlert.setId(id);
                    vinAlert.setTime(today);
                    VinItemSimple vinItemMonth = vinItemMonthMap.get(id);
                    vinAlert.setCount_month(vinItemMonth.getItemCount());

                    String category = vinItemMonth.getCategory();
                    vinAlert.setCategory(category);
                    int numinWarehouse = 0;
                    int ifExist = 0;
                    switch (category){
                        case "tool":
                            ifExist = vinService.ifItemExistinShop11(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.queryItemNuminShop11byId(id);
                            }
                            break;
                        case "smalltool":
                            ifExist = vinService.ifSmallItemExistinShop11(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.querySmallItemNuminShop11byId(id);
                            }
                            break;
                        case "food":
                            ifExist = vinService.ifFoodExistinShop11(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryFoodNuminShop11byId(id);
                            }
                            break;
                        case "commercialthing":
                            System.out.println("=====commercialthing=====");
                            ifExist = vinService.ifcommercialItemExistinShop11(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.querycommercialItemNuminShop11byId(id);
                            }
                            break;
                        case "other":
                            ifExist = vinService.ifothersExistinShop11(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryothersNuminShop11byId(id);
                            }
                            break;
                    }

                    if(vinItemWeekMap.containsKey(id)){
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                        }

                    }else {
                        vinAlert.setCount_week(0);
                        vinAlert.setIfalert_week(false);//不一定，要看看
                    }

                    if(numinWarehouse <= vinItemMonth.getItemCount()){
                        vinAlert.setIfalert_month(true);
                    }else {
                        vinAlert.setIfalert_month(false);
                    }

                    vinService.addSumitemCountinShop11(vinAlert);

                }

                for (String id : vinItemWeekMap.keySet()) {
                    if(!vinItemMonthMap.containsKey(id)){
                        VinAlert vinAlert = new VinAlert();
                        String logid = UUID.randomUUID().toString().replace("-","");
                        vinAlert.setLogid(logid);
                        vinAlert.setId(id);
                        vinAlert.setTime(today);
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        vinAlert.setCount_month(0);
                        String category = vinItemWeek.getCategory();
                        vinAlert.setCategory(category);
                        int numinWarehouse = 0;
                        int ifExist = 0;
                        switch (category){
                            case "tool":
                                ifExist = vinService.ifItemExistinShop11(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.queryItemNuminShop11byId(id);
                                }
                                break;
                            case "smalltool":
                                ifExist = vinService.ifSmallItemExistinShop11(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.querySmallItemNuminShop11byId(id);
                                }
                                break;
                            case "food":
                                ifExist = vinService.ifFoodExistinShop11(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryFoodNuminShop11byId(id);
                                }
                                break;
                            case "commercialthing":
                                System.out.println("=====commercialthing=====");
                                ifExist = vinService.ifcommercialItemExistinShop11(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.querycommercialItemNuminShop11byId(id);
                                }
                                break;
                            case "other":
                                ifExist = vinService.ifothersExistinShop11(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryothersNuminShop11byId(id);
                                }
                                break;
                        }
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                            vinAlert.setIfalert_month(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                            vinAlert.setIfalert_month(false);
                        }
                        vinService.addSumitemCountinShop11(vinAlert);
                    }

                }
                break;
            case "shop12":
                System.out.println("=====addSumitemCount.shop12=====");
                vinItemWeekMap = new HashMap<>();
                vinItemMonthMap = new HashMap<>();
                vinItemMonthSize = listvinItemMonth.size();
                vinItemWeekSize = listvinItemWeek.size();
                for (int i = 0; i < vinItemMonthSize; i++) {
                    vinItemMonthMap.put(listvinItemMonth.get(i).getId(), listvinItemMonth.get(i));
                }
                for (int i = 0; i < vinItemWeekSize; i++) {
                    vinItemWeekMap.put(listvinItemWeek.get(i).getId(), listvinItemWeek.get(i));
                }
                for (String id : vinItemMonthMap.keySet()) {
                    VinAlert vinAlert = new VinAlert();
                    String logid = UUID.randomUUID().toString().replace("-","");
                    vinAlert.setLogid(logid);
                    vinAlert.setId(id);
                    vinAlert.setTime(today);
                    VinItemSimple vinItemMonth = vinItemMonthMap.get(id);
                    vinAlert.setCount_month(vinItemMonth.getItemCount());

                    String category = vinItemMonth.getCategory();
                    vinAlert.setCategory(category);
                    int numinWarehouse = 0;
                    int ifExist = 0;
                    switch (category){
                        case "tool":
                            ifExist = vinService.ifItemExistinShop12(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.queryItemNuminShop12byId(id);
                            }
                            break;
                        case "smalltool":
                            ifExist = vinService.ifSmallItemExistinShop12(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.querySmallItemNuminShop12byId(id);
                            }
                            break;
                        case "food":
                            ifExist = vinService.ifFoodExistinShop12(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryFoodNuminShop12byId(id);
                            }
                            break;
                        case "commercialthing":
                            System.out.println("=====commercialthing=====");
                            ifExist = vinService.ifcommercialItemExistinShop12(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.querycommercialItemNuminShop12byId(id);
                            }
                            break;
                        case "other":
                            ifExist = vinService.ifothersExistinShop12(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryothersNuminShop12byId(id);
                            }
                            break;
                    }

                    if(vinItemWeekMap.containsKey(id)){
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                        }

                    }else {
                        vinAlert.setCount_week(0);
                        vinAlert.setIfalert_week(false);//不一定，要看看
                    }

                    if(numinWarehouse <= vinItemMonth.getItemCount()){
                        vinAlert.setIfalert_month(true);
                    }else {
                        vinAlert.setIfalert_month(false);
                    }

                    vinService.addSumitemCountinShop12(vinAlert);

                }

                for (String id : vinItemWeekMap.keySet()) {
                    if(!vinItemMonthMap.containsKey(id)){
                        VinAlert vinAlert = new VinAlert();
                        String logid = UUID.randomUUID().toString().replace("-","");
                        vinAlert.setLogid(logid);
                        vinAlert.setId(id);
                        vinAlert.setTime(today);
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        vinAlert.setCount_month(0);
                        String category = vinItemWeek.getCategory();
                        vinAlert.setCategory(category);
                        int numinWarehouse = 0;
                        int ifExist = 0;
                        switch (category){
                            case "tool":
                                ifExist = vinService.ifItemExistinShop12(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.queryItemNuminShop12byId(id);
                                }
                                break;
                            case "smalltool":
                                ifExist = vinService.ifSmallItemExistinShop12(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.querySmallItemNuminShop12byId(id);
                                }
                                break;
                            case "food":
                                ifExist = vinService.ifFoodExistinShop12(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryFoodNuminShop12byId(id);
                                }
                                break;
                            case "commercialthing":
                                System.out.println("=====commercialthing=====");
                                ifExist = vinService.ifcommercialItemExistinShop12(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.querycommercialItemNuminShop12byId(id);
                                }
                                break;
                            case "other":
                                ifExist = vinService.ifothersExistinShop12(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryothersNuminShop12byId(id);
                                }
                                break;
                        }
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                            vinAlert.setIfalert_month(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                            vinAlert.setIfalert_month(false);
                        }
                        vinService.addSumitemCountinShop12(vinAlert);
                    }

                }
                break;
            case "shop13":
                System.out.println("=====addSumitemCount.shop13=====");
                vinItemWeekMap = new HashMap<>();
                vinItemMonthMap = new HashMap<>();
                vinItemMonthSize = listvinItemMonth.size();
                vinItemWeekSize = listvinItemWeek.size();
                for (int i = 0; i < vinItemMonthSize; i++) {
                    vinItemMonthMap.put(listvinItemMonth.get(i).getId(), listvinItemMonth.get(i));
                }
                for (int i = 0; i < vinItemWeekSize; i++) {
                    vinItemWeekMap.put(listvinItemWeek.get(i).getId(), listvinItemWeek.get(i));
                }
                for (String id : vinItemMonthMap.keySet()) {
                    VinAlert vinAlert = new VinAlert();
                    String logid = UUID.randomUUID().toString().replace("-","");
                    vinAlert.setLogid(logid);
                    vinAlert.setId(id);
                    vinAlert.setTime(today);
                    VinItemSimple vinItemMonth = vinItemMonthMap.get(id);
                    vinAlert.setCount_month(vinItemMonth.getItemCount());

                    String category = vinItemMonth.getCategory();
                    vinAlert.setCategory(category);
                    int numinWarehouse = 0;
                    int ifExist = 0;
                    switch (category){
                        case "tool":
                            ifExist = vinService.ifItemExistinShop13(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.queryItemNuminShop13byId(id);
                            }
                            break;
                        case "smalltool":
                            ifExist = vinService.ifSmallItemExistinShop13(id);
                            if(ifExist>0){
                                numinWarehouse = vinService.querySmallItemNuminShop13byId(id);
                            }
                            break;
                        case "food":
                            ifExist = vinService.ifFoodExistinShop13(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryFoodNuminShop13byId(id);
                            }
                            break;
                        case "commercialthing":
                            System.out.println("=====commercialthing=====");
                            ifExist = vinService.ifcommercialItemExistinShop13(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.querycommercialItemNuminShop13byId(id);
                            }
                            break;
                        case "other":
                            ifExist = vinService.ifothersExistinShop13(id);
                            if(ifExist>0) {
                                numinWarehouse = vinService.queryothersNuminShop13byId(id);
                            }
                            break;
                    }

                    if(vinItemWeekMap.containsKey(id)){
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                        }

                    }else {
                        vinAlert.setCount_week(0);
                        vinAlert.setIfalert_week(false);//不一定，要看看
                    }

                    if(numinWarehouse <= vinItemMonth.getItemCount()){
                        vinAlert.setIfalert_month(true);
                    }else {
                        vinAlert.setIfalert_month(false);
                    }

                    vinService.addSumitemCountinShop13(vinAlert);

                }

                for (String id : vinItemWeekMap.keySet()) {
                    if(!vinItemMonthMap.containsKey(id)){
                        VinAlert vinAlert = new VinAlert();
                        String logid = UUID.randomUUID().toString().replace("-","");
                        vinAlert.setLogid(logid);
                        vinAlert.setId(id);
                        vinAlert.setTime(today);
                        VinItemSimple vinItemWeek = vinItemWeekMap.get(id);
                        vinAlert.setCount_week(vinItemWeek.getItemCount());
                        vinAlert.setCount_month(0);
                        String category = vinItemWeek.getCategory();
                        vinAlert.setCategory(category);
                        int numinWarehouse = 0;
                        int ifExist = 0;
                        switch (category){
                            case "tool":
                                ifExist = vinService.ifItemExistinShop13(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.queryItemNuminShop13byId(id);
                                }
                                break;
                            case "smalltool":
                                ifExist = vinService.ifSmallItemExistinShop13(id);
                                if(ifExist>0){
                                    numinWarehouse = vinService.querySmallItemNuminShop13byId(id);
                                }
                                break;
                            case "food":
                                ifExist = vinService.ifFoodExistinShop13(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryFoodNuminShop13byId(id);
                                }
                                break;
                            case "commercialthing":
                                System.out.println("=====commercialthing=====");
                                ifExist = vinService.ifcommercialItemExistinShop13(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.querycommercialItemNuminShop13byId(id);
                                }
                                break;
                            case "other":
                                ifExist = vinService.ifothersExistinShop13(id);
                                if(ifExist>0) {
                                    numinWarehouse = vinService.queryothersNuminShop13byId(id);
                                }
                                break;
                        }
                        if(numinWarehouse <= vinItemWeek.getItemCount()){
                            vinAlert.setIfalert_week(true);
                            vinAlert.setIfalert_month(true);
                        }else {
                            vinAlert.setIfalert_week(false);
                            vinAlert.setIfalert_month(false);
                        }
                        vinService.addSumitemCountinShop13(vinAlert);
                    }

                }
                break;

        }

    }
    public void querySumitemCountbytime(String location, String lastweek, String lastmonth, String today){
        System.out.println(location);
        switch (location){
            case "main0":
                System.out.println("=====main0=====");
                List<VinItemSimple> vinItemWeekmain0 = vinService.querySumitemCountbytimeinMain0(lastweek);
                List<VinItemSimple> vinItemMonthmain0 = vinService.querySumitemCountbytimeinMain0(lastmonth);
                addSumitemCount(vinItemWeekmain0,vinItemMonthmain0,"main0",today);
                break;
            case "main1":
                System.out.println("=====main1=====");
                List<VinItemSimple> vinItemWeekmain1 = vinService.querySumitemCountbytimeinMain1(lastweek);
                List<VinItemSimple> vinItemMonthmain1 = vinService.querySumitemCountbytimeinMain1(lastmonth);
                addSumitemCount(vinItemWeekmain1,vinItemMonthmain1,"main1",today);
                break;

            case "main2":
                System.out.println("=====main2=====");
                List<VinItemSimple> vinItemWeekmain2 = vinService.querySumitemCountbytimeinMain2(lastweek);
                List<VinItemSimple> vinItemMonthmain2 = vinService.querySumitemCountbytimeinMain2(lastmonth);
                addSumitemCount(vinItemWeekmain2,vinItemMonthmain2,"main2",today);
                break;
            case "shop1":
                System.out.println("=====shop1=====");
                List<VinItemSimple> vinItemWeekshop1 = vinService.querySumitemCountbytimeinShop1(lastweek);
                List<VinItemSimple> vinItemMonthshop1 = vinService.querySumitemCountbytimeinShop1(lastmonth);
                addSumitemCount(vinItemWeekshop1,vinItemMonthshop1,"shop1",today);
                break;
            case "shop2":
                System.out.println("=====shop2=====");
                List<VinItemSimple> vinItemWeekshop2 = vinService.querySumitemCountbytimeinShop2(lastweek);
                List<VinItemSimple> vinItemMonthshop2 = vinService.querySumitemCountbytimeinShop2(lastmonth);
                addSumitemCount(vinItemWeekshop2,vinItemMonthshop2,"shop2",today);
                break;
            case "shop3":
                System.out.println("=====shop3=====");
                List<VinItemSimple> vinItemWeekshop3 = vinService.querySumitemCountbytimeinShop3(lastweek);
                List<VinItemSimple> vinItemMonthshop3 = vinService.querySumitemCountbytimeinShop3(lastmonth);
                addSumitemCount(vinItemWeekshop3,vinItemMonthshop3,"shop3",today);
                break;
            case "shop4":
                System.out.println("=====shop4=====");
                List<VinItemSimple> vinItemWeekshop4 = vinService.querySumitemCountbytimeinShop4(lastweek);
                List<VinItemSimple> vinItemMonthshop4 = vinService.querySumitemCountbytimeinShop4(lastmonth);
                addSumitemCount(vinItemWeekshop4,vinItemMonthshop4,"shop4",today);
                break;
            case "shop5":
                System.out.println("=====shop5=====");
                List<VinItemSimple> vinItemWeekshop5 = vinService.querySumitemCountbytimeinShop5(lastweek);
                List<VinItemSimple> vinItemMonthshop5 = vinService.querySumitemCountbytimeinShop5(lastmonth);
                addSumitemCount(vinItemWeekshop5,vinItemMonthshop5,"shop5",today);
                break;
            case "shop6":
                System.out.println("=====shop6=====");
                List<VinItemSimple> vinItemWeekshop6 = vinService.querySumitemCountbytimeinShop6(lastweek);
                List<VinItemSimple> vinItemMonthshop6 = vinService.querySumitemCountbytimeinShop6(lastmonth);
                addSumitemCount(vinItemWeekshop6,vinItemMonthshop6,"shop6",today);
                break;
            case "shop7":
                System.out.println("=====shop7=====");
                List<VinItemSimple> vinItemWeekshop7 = vinService.querySumitemCountbytimeinShop7(lastweek);
                List<VinItemSimple> vinItemMonthshop7 = vinService.querySumitemCountbytimeinShop7(lastmonth);
                addSumitemCount(vinItemWeekshop7,vinItemMonthshop7,"shop7",today);
                break;
            case "shop8":
                System.out.println("=====shop8=====");
                List<VinItemSimple> vinItemWeekshop8 = vinService.querySumitemCountbytimeinShop8(lastweek);
                List<VinItemSimple> vinItemMonthshop8 = vinService.querySumitemCountbytimeinShop8(lastmonth);
                addSumitemCount(vinItemWeekshop8,vinItemMonthshop8,"shop8",today);
                break;
            case "shop9":
                System.out.println("=====shop9=====");
                List<VinItemSimple> vinItemWeekshop9 = vinService.querySumitemCountbytimeinShop9(lastweek);
                List<VinItemSimple> vinItemMonthshop9 = vinService.querySumitemCountbytimeinShop9(lastmonth);
                addSumitemCount(vinItemWeekshop9,vinItemMonthshop9,"shop9",today);
                break;
            case "shop10":
                System.out.println("=====shop10=====");
                List<VinItemSimple> vinItemWeekshop10 = vinService.querySumitemCountbytimeinShop10(lastweek);
                List<VinItemSimple> vinItemMonthshop10 = vinService.querySumitemCountbytimeinShop10(lastmonth);
                addSumitemCount(vinItemWeekshop10,vinItemMonthshop10,"shop10",today);
                break;
            case "shop11":
                System.out.println("=====shop11=====");
                List<VinItemSimple> vinItemWeekshop11 = vinService.querySumitemCountbytimeinShop11(lastweek);
                List<VinItemSimple> vinItemMonthshop11 = vinService.querySumitemCountbytimeinShop11(lastmonth);
                addSumitemCount(vinItemWeekshop11,vinItemMonthshop11,"shop11",today);
                break;
            case "shop12":
                System.out.println("=====shop12=====");
                List<VinItemSimple> vinItemWeekshop12 = vinService.querySumitemCountbytimeinShop12(lastweek);
                List<VinItemSimple> vinItemMonthshop12 = vinService.querySumitemCountbytimeinShop12(lastmonth);
                addSumitemCount(vinItemWeekshop12,vinItemMonthshop12,"shop12",today);
                break;
            case "shop13":
                System.out.println("=====shop13=====");
                List<VinItemSimple> vinItemWeekshop13 = vinService.querySumitemCountbytimeinShop13(lastweek);
                List<VinItemSimple> vinItemMonthshop13 = vinService.querySumitemCountbytimeinShop13(lastmonth);
                addSumitemCount(vinItemWeekshop13,vinItemMonthshop13,"shop13",today);
                break;
        }
    }

    //@Scheduled(cron="0/60 * * * * ? ") //间隔1秒执行
    @Scheduled(cron = "0 0 1 * * ?") //每天凌晨一點執行
    public void alert(){
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String today = df.format(day);
        System.out.println("========觸發InventoryAlert成功=======" + today);

        Calendar calendarWeek = Calendar.getInstance();
        Calendar calendarMonth = Calendar.getInstance();
        calendarWeek.set(Calendar.DAY_OF_YEAR, calendarWeek.get(Calendar.DAY_OF_YEAR) - 7);
        calendarMonth.set(Calendar.DAY_OF_YEAR, calendarMonth.get(Calendar.DAY_OF_YEAR) - 30);
        Date dayWeek = calendarWeek.getTime();
        Date dayMonth = calendarMonth.getTime();
        String lastweek = df.format(dayWeek) + " " + "00:00:00";
        String lastmonth = df.format(dayMonth) + " " + "00:00:00";
        System.out.println(lastweek);
        System.out.println(lastmonth);
        System.out.println("=====querySumitemCountbytime.main0=====");
        querySumitemCountbytime("main0",lastweek,lastmonth,today);

        System.out.println("=====querySumitemCountbytime.main1=====");
        querySumitemCountbytime("main1",lastweek,lastmonth,today);

        System.out.println("=====querySumitemCountbytime.main2=====");
        querySumitemCountbytime("main2",lastweek,lastmonth,today);

        System.out.println("=====querySumitemCountbytime.shop1=====");
        querySumitemCountbytime("shop1",lastweek,lastmonth,today);

        System.out.println("=====querySumitemCountbytime.shop2=====");
        querySumitemCountbytime("shop2",lastweek,lastmonth,today);

        System.out.println("=====querySumitemCountbytime.shop3=====");
        querySumitemCountbytime("shop3",lastweek,lastmonth,today);

        System.out.println("=====querySumitemCountbytime.shop4=====");
        querySumitemCountbytime("shop4",lastweek,lastmonth,today);

        System.out.println("=====querySumitemCountbytime.shop5=====");
        querySumitemCountbytime("shop5",lastweek,lastmonth,today);

        System.out.println("=====querySumitemCountbytime.shop6=====");
        querySumitemCountbytime("shop6",lastweek,lastmonth,today);

        System.out.println("=====querySumitemCountbytime.shop7=====");
        querySumitemCountbytime("shop7",lastweek,lastmonth,today);

        System.out.println("=====querySumitemCountbytime.shop8=====");
        querySumitemCountbytime("shop8",lastweek,lastmonth,today);

        System.out.println("=====querySumitemCountbytime.shop9=====");
        querySumitemCountbytime("shop9",lastweek,lastmonth,today);

        System.out.println("=====querySumitemCountbytime.shop10=====");
        querySumitemCountbytime("shop10",lastweek,lastmonth,today);

        System.out.println("=====querySumitemCountbytime.shop11=====");
        querySumitemCountbytime("shop11",lastweek,lastmonth,today);

        System.out.println("=====querySumitemCountbytime.shop12=====");
        querySumitemCountbytime("shop12",lastweek,lastmonth,today);

        System.out.println("=====querySumitemCountbytime.shop13=====");
        querySumitemCountbytime("shop13",lastweek,lastmonth,today);

        System.out.println("========觸發InventoryAlert結束=======" + today);

    }
}
