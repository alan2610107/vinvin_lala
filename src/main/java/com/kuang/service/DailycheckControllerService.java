package com.kuang.service;

import com.kuang.pojo.VinCheck;
import com.kuang.pojo.VinItem;
import com.kuang.pojo.Warehouse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
@Slf4j
public class DailycheckControllerService {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    @Resource
    private QueryDailyCheckService queryDailyCheckService;

    @Resource
    QueryInventoryService queryInventoryService;

    /**
     * @apiNote Get Daily Check Result
     * @param location
     * @param category
     * @param downloadDate
     * @return
     */
    public List<VinCheck> getDailyCheckList(String location, String category, String downloadDate) {
        List<VinCheck> vinCheck = null;
        switch (location) {
            case "main0":
                vinCheck = vinService.queryCheckwithTimeinMain0(category, downloadDate);
                break;
            case "main1":
                vinCheck = vinService.queryCheckwithTimeinMain1(category, downloadDate);
                break;
            case "main2":
                vinCheck = vinService.queryCheckwithTimeinMain2(category, downloadDate);
                break;
            case "shop1":
                vinCheck = vinService.queryCheckwithTimeinShop1(category, downloadDate);
                break;
            case "shop2":
                vinCheck = vinService.queryCheckwithTimeinShop2(category, downloadDate);
                break;
            case "shop3":
                vinCheck = vinService.queryCheckwithTimeinShop3(category, downloadDate);
                break;
            case "shop4":
                vinCheck = vinService.queryCheckwithTimeinShop4(category, downloadDate);
                break;
            case "shop5":
                vinCheck = vinService.queryCheckwithTimeinShop5(category, downloadDate);
                break;
            case "shop6":
                vinCheck = vinService.queryCheckwithTimeinShop6(category, downloadDate);
                break;
            case "shop7":
                vinCheck = vinService.queryCheckwithTimeinShop7(category, downloadDate);
                break;
            case "shop8":
                vinCheck = vinService.queryCheckwithTimeinShop8(category, downloadDate);
                break;
            case "shop9":
                vinCheck = vinService.queryCheckwithTimeinShop9(category, downloadDate);
                break;
            case "shop10":
                vinCheck = vinService.queryCheckwithTimeinShop10(category, downloadDate);
                break;
            case "shop11":
                vinCheck = vinService.queryCheckwithTimeinShop11(category, downloadDate);
                break;
            case "shop12":
                vinCheck = vinService.queryCheckwithTimeinShop12(category, downloadDate);
                break;
            case "shop13":
                vinCheck = vinService.queryCheckwithTimeinShop13(category, downloadDate);
                break;
        }

        return vinCheck;
    }

    /**
     *
     * @param model
     * @param location
     */
    public void toDailyCheck(Model model, String location) throws ExecutionException, InterruptedException {
        Future<List<VinItem>> futureTool = queryInventoryService.get(location, "tool");
        Future<List<VinItem>> futureSmallTool = queryInventoryService.get(location, "smalltool");
        Future<List<VinItem>> futureFood = queryInventoryService.get(location, "food");
        Future<List<VinItem>> futureCommercial = queryInventoryService.get(location, "commercialthing");
        Future<List<VinItem>> futureOther = queryInventoryService.get(location, "other");
        if(!futureTool.isDone() && !futureSmallTool.isDone() && !futureFood.isDone() && !futureCommercial.isDone() && !futureOther.isDone()){
            log.warn("task has not finished, please wait!");
        }

        List<VinItem> listItem = null;
        List<VinItem> listSmallItem = null;
        List<VinItem> listFood = null;
        List<VinItem> listCommercialthing = null;
        List<VinItem> listOther = null;

        listItem = futureTool.get();
        listFood = futureFood.get();
        listSmallItem = futureSmallTool.get();
        listCommercialthing = futureCommercial.get();
        listOther = futureOther.get();

        model.addAttribute("listItem", listItem);
        model.addAttribute("listSmallItem", listSmallItem);
        model.addAttribute("listFood", listFood);
        model.addAttribute("listCommercialthing", listCommercialthing);
        model.addAttribute("listOther", listOther);
        Warehouse warehouse = vinService.queryRealWarehouseName(location);
        String realname = warehouse.getRealname();
        model.addAttribute("warehouse", realname + "日盤");
        model.addAttribute("logLocation", location);
        model.addAttribute("mainWarehouse", "dailycheck");
//        System.out.println("model" + model);
        System.out.println("映射完畢");



    }

    /**
     *
     * @param model
     * @param location
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void showDailyCheckResult(Model model, String location) throws ExecutionException, InterruptedException {
        List<VinCheck> listItem = null;
        List<VinCheck> listFood = null;
        List<VinCheck> listSmallItem = null;
        List<VinCheck> listCommercialthing = null;
        List<VinCheck> listOther = null;

        Future<List<VinCheck>> futureListItem = queryDailyCheckService.get(location,"tool");
        Future<List<VinCheck>> futureListFood = queryDailyCheckService.get(location,"food");
        Future<List<VinCheck>> futureListSmallItem = queryDailyCheckService.get(location,"smalltool");
        Future<List<VinCheck>> futureListCommercial = queryDailyCheckService.get(location,"commercialthing");
        Future<List<VinCheck>> futureListOther = queryDailyCheckService.get(location,"other");
        if(!futureListItem.isDone() && !futureListFood.isDone() && !futureListSmallItem.isDone() && !futureListCommercial.isDone() && !futureListOther.isDone()){
            System.out.println("task has not finished, please wait!");
        }

        listItem = futureListItem.get();
        listFood = futureListFood.get();
        listSmallItem = futureListSmallItem.get();
        listCommercialthing = futureListCommercial.get();
        listOther = futureListOther.get();

        model.addAttribute("listItem", listItem);
        model.addAttribute("listSmallItem", listSmallItem);
        model.addAttribute("listFood", listFood);
        model.addAttribute("listCommercialthing", listCommercialthing);
        model.addAttribute("listOther", listOther);
        Warehouse warehouse = vinService.queryRealWarehouseName(location);
        String realname = warehouse.getRealname();
        model.addAttribute("warehouse", realname + "日盤結果");
        model.addAttribute("logLocation", "dailycheckresult" + location);
        model.addAttribute("mainWarehouse", "dailycheck");
        model.addAttribute("location", location);

        System.out.println("映射完畢");


    }
}
