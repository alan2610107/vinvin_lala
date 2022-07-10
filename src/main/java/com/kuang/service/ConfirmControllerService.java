package com.kuang.service;

import com.kuang.handler.ConfirmAbstractHandler;
import com.kuang.pojo.ApplyItemConfirm;
import com.kuang.pojo.ConfirmStatusTrans;
import com.kuang.pojo.VinLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ConfirmControllerService {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    @Resource
    private ConfirmAbstractHandler confirmAreaHandler;
    @Resource
    private ConfirmAbstractHandler confirmCenterHandler;
    @Resource
    private ConfirmAbstractHandler confirmFinanceHandler;

    @Resource
    private PurchaseControllerService purchaseControllerService;

    public String getItemConfirm(String logID){
        confirmAreaHandler.setLogID(logID);
        confirmCenterHandler.setLogID(logID);
        confirmFinanceHandler.setLogID(logID);
        confirmAreaHandler.setNext(confirmCenterHandler);
        confirmCenterHandler.setNext(confirmFinanceHandler);
        return confirmAreaHandler.handler();
    }

    public Map<String, String> getConfirmStatusMap(){
        List<ConfirmStatusTrans> confirmStatusTransList = vinService.queryAllConfirmStatusTrans();
        Map<String, String> confirmStatusTransMap = new HashMap<>();
        for (ConfirmStatusTrans confirmStatusTrans: confirmStatusTransList) {
            confirmStatusTransMap.put(confirmStatusTrans.getStatusEN(), confirmStatusTrans.getStatusCH());
        }
        return confirmStatusTransMap;
    }


    public HashMap<String, List<VinLog>> getConfirm(String location){
        List<VinLog> confirmListTool = null;
        List<VinLog> confirmListSmallTool = null;
        List<VinLog> confirmListFood = null;
        List<VinLog> confirmListCommercial = null;
        List<VinLog> confirmListOther = null;
        HashMap<String, List<VinLog>> confirmMap = new HashMap<>();
        switch (location){
            case "main0":
                confirmListTool = vinService.queryCategoryConfirminMain0("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminMain0("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminMain0("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminMain0("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminMain0("other", "newinput", "input");
                break;
            case "main1":
                confirmListTool = vinService.queryCategoryConfirminMain1("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminMain1("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminMain1("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminMain1("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminMain1("other", "newinput", "input");
                break;
            case "main2":
                confirmListTool = vinService.queryCategoryConfirminMain2("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminMain2("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminMain2("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminMain2("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminMain2("other", "newinput", "input");
                break;
            case "shop1":
                confirmListTool = vinService.queryCategoryConfirminShop1("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminShop1("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminShop1("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminShop1("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminShop1("other", "newinput", "input");
                break;
            case "shop2":
                confirmListTool = vinService.queryCategoryConfirminShop2("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminShop2("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminShop2("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminShop2("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminShop2("other", "newinput", "input");
                break;
            case "shop3":
                confirmListTool = vinService.queryCategoryConfirminShop3("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminShop3("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminShop3("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminShop3("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminShop3("other", "newinput", "input");
                break;
            case "shop4":
                confirmListTool = vinService.queryCategoryConfirminShop4("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminShop4("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminShop4("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminShop4("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminShop4("other", "newinput", "input");
                break;
            case "shop5":
                confirmListTool = vinService.queryCategoryConfirminShop5("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminShop5("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminShop5("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminShop5("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminShop5("other", "newinput", "input");
                break;
            case "shop6":
                confirmListTool = vinService.queryCategoryConfirminShop6("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminShop6("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminShop6("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminShop6("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminShop6("other", "newinput", "input");
                break;
            case "shop7":
                confirmListTool = vinService.queryCategoryConfirminShop7("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminShop7("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminShop7("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminShop7("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminShop7("other", "newinput", "input");
                break;
            case "shop8":
                confirmListTool = vinService.queryCategoryConfirminShop8("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminShop8("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminShop8("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminShop8("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminShop8("other", "newinput", "input");
                break;
            case "shop9":
                confirmListTool = vinService.queryCategoryConfirminShop9("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminShop9("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminShop9("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminShop9("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminShop9("other", "newinput", "input");
                break;
            case "shop10":
                confirmListTool = vinService.queryCategoryConfirminShop10("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminShop10("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminShop10("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminShop10("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminShop10("other", "newinput", "input");
                break;
            case "shop11":
                confirmListTool = vinService.queryCategoryConfirminShop11("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminShop11("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminShop11("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminShop11("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminShop11("other", "newinput", "input");
                break;
            case "shop12":
                confirmListTool = vinService.queryCategoryConfirminShop12("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminShop12("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminShop12("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminShop12("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminShop12("other", "newinput", "input");
                break;
            case "shop13":
                confirmListTool = vinService.queryCategoryConfirminShop13("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminShop13("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminShop13("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminShop13("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminShop13("other", "newinput", "input");
                break;
            case "shop14":
                confirmListTool = vinService.queryCategoryConfirminShop14("tool", "newinput", "input");
                confirmListFood = vinService.queryCategoryConfirminShop14("food", "newinput", "input");
                confirmListSmallTool = vinService.queryCategoryConfirminShop14("smalltool", "newinput", "input");
                confirmListCommercial = vinService.queryCategoryConfirminShop14("commercialthing", "newinput", "input");
                confirmListOther = vinService.queryCategoryConfirminShop14("other", "newinput", "input");
                break;
        }
        confirmMap.put("confirmListTool", confirmListTool);
        confirmMap.put("confirmListSmallTool", confirmListSmallTool);
        confirmMap.put("confirmListFood", confirmListFood);
        confirmMap.put("confirmListCommercial", confirmListCommercial);
        confirmMap.put("confirmListOther", confirmListOther);

        return confirmMap;
    }



    @Transactional
    public void setApplyItemConfirm(boolean itemConfirmRes, String logID, String level){
        log.warn("Transactional Start!!!");
        ApplyItemConfirm applyItemConfirm = vinService.queryApplyItemConfirmByLogID(logID);
        if(applyItemConfirm != null){
            if(level.equals("CONFIRM_AREA")){
                applyItemConfirm.setConfirm_area(itemConfirmRes);
                applyItemConfirm.setConfirm_area_date(vinService.getDateTime());
                vinService.updateApplyItemConfirmAreaByLogID(applyItemConfirm);
                if(itemConfirmRes){
                    purchaseControllerService.insertPurchaseItem(logID);
                }
            }else if(level.equals("CONFIRM_CENTER")){
                applyItemConfirm.setConfirm_center(itemConfirmRes);
                applyItemConfirm.setConfirm_center_date(vinService.getDateTime());
                vinService.updateApplyItemConfirmCenterByLogID(applyItemConfirm);
            }else if(level.equals("CONFIRM_FINANCE")){
                applyItemConfirm.setConfirm_finance(itemConfirmRes);
                applyItemConfirm.setConfirm_finance_date(vinService.getDateTime());
                vinService.updateApplyItemConfirmFinanceByLogID(applyItemConfirm);
            }else {
                log.warn("No_Level");
            }
        }
        log.warn("Transactional End!!!");
    }
}
