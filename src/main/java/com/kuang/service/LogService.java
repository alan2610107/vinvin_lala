package com.kuang.service;

import com.kuang.pojo.VinItem;
import com.kuang.pojo.VinLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class LogService {
    @Autowired
    @Qualifier("VinServiceImpl")
    VinService vinService;

    @Resource
    CacheService cacheService;

    @Resource
    FileUploadService fileUploadService;

    public VinLog getLogbylogid(String location, String logid) {
        VinLog vinLog = null;
        switch (location){
            case "main0":
                vinLog = vinService.queryLoginmain0byid(logid);
                break;
            case "main1":
                vinLog = vinService.queryLoginmain1byid(logid);
                break;
            case "main2":
                vinLog = vinService.queryLoginmain2byid(logid);
                break;
            case "shop1":
                vinLog = vinService.queryLoginshop1byid(logid);
                break;
            case "shop2":
                vinLog = vinService.queryLoginshop2byid(logid);
                break;
            case "shop3":
                vinLog = vinService.queryLoginshop3byid(logid);
                break;
            case "shop4":
                vinLog = vinService.queryLoginshop4byid(logid);
                break;
            case "shop5":
                vinLog = vinService.queryLoginshop5byid(logid);
                break;
            case "shop6":
                vinLog = vinService.queryLoginshop6byid(logid);
                break;
            case "shop7":
                vinLog = vinService.queryLoginshop7byid(logid);
                break;
            case "shop8":
                vinLog = vinService.queryLoginshop8byid(logid);
                break;
            case "shop9":
                vinLog = vinService.queryLoginshop9byid(logid);
                break;
            case "shop10":
                vinLog = vinService.queryLoginshop10byid(logid);
                break;
            case "shop11":
                vinLog = vinService.queryLoginshop11byid(logid);
                break;
            case "shop12":
                vinLog = vinService.queryLoginshop12byid(logid);
                break;
            case "shop13":
                vinLog = vinService.queryLoginshop13byid(logid);
                break;
            case "shop14":
                vinLog = vinService.queryLoginshop14byid(logid);
                break;
        }

        return vinLog;

    }


    public void updateLogbylogid(String location, VinLog vinLog) {
        switch (location){
            case "main0":
                vinService.updateLoginmain0byid(vinLog);
                break;
            case "main1":
                vinService.updateLoginmain1byid(vinLog);
                break;
            case "main2":
                vinService.updateLoginmain2byid(vinLog);
                break;
            case "shop1":
                vinService.updateLoginshop1byid(vinLog);
                break;
            case "shop2":
                vinService.updateLoginshop2byid(vinLog);
                break;
            case "shop3":
                vinService.updateLoginshop3byid(vinLog);
                break;
            case "shop4":
                vinService.updateLoginshop4byid(vinLog);
                break;
            case "shop5":
                vinService.updateLoginshop5byid(vinLog);
                break;
            case "shop6":
                vinService.updateLoginshop6byid(vinLog);
                break;
            case "shop7":
                vinService.updateLoginshop7byid(vinLog);
                break;
            case "shop8":
                vinService.updateLoginshop8byid(vinLog);
                break;
            case "shop9":
                vinService.updateLoginshop9byid(vinLog);
                break;
            case "shop10":
                vinService.updateLoginshop10byid(vinLog);
                break;
            case "shop11":
                vinService.updateLoginshop11byid(vinLog);
                break;
            case "shop12":
                vinService.updateLoginshop12byid(vinLog);
                break;
            case "shop13":
                vinService.updateLoginshop13byid(vinLog);
                break;
            case "shop14":
                vinService.updateLoginshop14byid(vinLog);
                break;
        }
    }

    //存入紀錄
    public void addLog(String action, VinItem vinItem, String category, String from, String to, CommonsMultipartFile file, HttpServletRequest request) throws IOException {//(入庫出庫轉移),項目,(設備器材小設備)
        String logid = UUID.randomUUID().toString().replace("-","");
        log.warn("addlog.logid==>"+logid);
        log.warn("addlog.action==>"+action);

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);
        VinLog vinLog = new VinLog();
        vinLog.setLogid(logid);
        vinLog.setId(vinItem.getId());
        vinLog.setItemName(vinItem.getItemName());
        vinLog.setBrand(vinItem.getBrand());
        vinLog.setItemCount(vinItem.getItemCount());
        vinLog.setSinglePrice(vinItem.getSinglePrice());
        vinLog.setTotalPrice(Math.round(vinItem.getSinglePrice() * vinItem.getItemCount() * 100.0)/100.0);
        vinLog.setMemo(vinItem.getMemo());
        vinLog.setTime(time);
        vinLog.setCategory(category);
        vinLog.setAction(action);
        vinLog.setFrom(from);
        vinLog.setTo(to);
        vinLog.setIfComplete(true);
        vinLog.setIfConfirm(true);
        String target = "";
        String inputLocation = "";
        if(action.equals("input") || action.equals("output") || action.equals("newinput") || action.equals("delete") || action.equals("edit") || action.equals("dump")){
            if(action.equals("input") || action.equals("newinput")){
                target = to;
                if(action.equals("newinput")){
                    vinLog.setIfComplete(false);
                    vinLog.setIfConfirm(false);
                    cacheService.increaseNotConfirmCount(target);
                }
            }else if(action.equals("output") || action.equals("delete") || action.equals("edit") || action.equals("dump")){
                target = from;
                if(action.equals("edit")){
                    vinLog.setTo(from);
                }
            }

        }else if(action.equals("send")) {
            target = from;
            inputLocation = to;
            VinLog vinLogInput = new VinLog();//接收者
            vinLogInput.setLogid(logid);
            vinLogInput.setId(vinItem.getId());
            vinLogInput.setItemName(vinItem.getItemName());
            vinLogInput.setBrand(vinItem.getBrand());
            vinLogInput.setItemCount(vinItem.getItemCount());
            vinLogInput.setSinglePrice(vinItem.getSinglePrice());
            vinLogInput.setTotalPrice(Math.round(vinItem.getSinglePrice() * vinItem.getItemCount() * 100.0)/100.0);
            vinLogInput.setMemo(vinItem.getMemo());
            vinLogInput.setTime(time);
            vinLogInput.setCategory(category);
            vinLogInput.setAction("input");
            vinLogInput.setFrom(from);
            vinLogInput.setTo(to);
            vinLogInput.setIfComplete(false);
            vinLogInput.setIfConfirm(false);
            cacheService.increaseNotConfirmCount(inputLocation);
//            switch (inputLocation) {
//                case "main0":
////                    log.warn(vinLogInput);
//                    vinService.addloginMain0(vinLogInput);
//                    break;
//                case "main1":
////                    log.warn(vinLogInput);
//                    vinService.addloginMain1(vinLogInput);
//                    break;
//                case "main2":
//                    vinService.addloginMain2(vinLogInput);
//                    break;
//                case "shop1":
//                    vinService.addloginShop1(vinLogInput);
//                    break;
//                case "shop2":
//                    vinService.addloginShop2(vinLogInput);
//                    break;
//                case "shop3":
//                    vinService.addloginShop3(vinLogInput);
//                    break;
//                case "shop4":
//                    vinService.addloginShop4(vinLogInput);
//                    break;
//                case "shop5":
//                    vinService.addloginShop5(vinLogInput);
//                    break;
//                case "shop6":
//                    vinService.addloginShop6(vinLogInput);
//                    break;
//                case "shop7":
//                    vinService.addloginShop7(vinLogInput);
//                    break;
//                case "shop8":
//                    vinService.addloginShop8(vinLogInput);
//                    break;
//                case "shop9":
//                    vinService.addloginShop9(vinLogInput);
//                    break;
//                case "shop10":
//                    vinService.addloginShop10(vinLogInput);
//                    break;
//            }
            addLog(vinLogInput,inputLocation);

        }
        log.warn("target=>"+target);
//        switch (target) {
//            case "main0":
//                vinService.addloginMain0(vinLog);
//                break;
//            case "main1":
//                vinService.addloginMain1(vinLog);
//                break;
//            case "main2":
//                vinService.addloginMain2(vinLog);
//                break;
//            case "shop1":
//                log.warn("12321");
//                vinService.addloginShop1(vinLog);
//                break;
//            case "shop2":
//                vinService.addloginShop2(vinLog);
//                break;
//            case "shop3":
//                vinService.addloginShop3(vinLog);
//                break;
//            case "shop4":
//                vinService.addloginShop4(vinLog);
//                break;
//            case "shop5":
//                vinService.addloginShop5(vinLog);
//                break;
//            case "shop6":
//                vinService.addloginShop6(vinLog);
//                break;
//            case "shop7":
//                vinService.addloginShop7(vinLog);
//                break;
//            case "shop8":
//                vinService.addloginShop8(vinLog);
//                break;
//            case "shop9":
//                vinService.addloginShop9(vinLog);
//                break;
//            case "shop10":
//                vinService.addloginShop10(vinLog);
//                break;
//        }
        addLog(vinLog, target);

        log.warn("addLog==>" + vinLog);
        if(file != null){
            log.warn("uploadfile==>"+file);
            fileUploadService.fileUpload(file, request, vinItem.getId(),"/fruitInvoice");
        }



    }

    /**
     *
     * @param newVinLog
     * @param location
     */
    public void addLog(VinLog newVinLog, String location){
        switch (location) {
            case "main0":
                vinService.addloginMain0(newVinLog);
                break;
            case "main1":
                vinService.addloginMain1(newVinLog);
                break;
            case "main2":
                vinService.addloginMain2(newVinLog);
                break;
            case "shop1":
                vinService.addloginShop1(newVinLog);
                break;
            case "shop2":
                vinService.addloginShop2(newVinLog);
                break;
            case "shop3":
                vinService.addloginShop3(newVinLog);
                break;
            case "shop4":
                vinService.addloginShop4(newVinLog);
                break;
            case "shop5":
                vinService.addloginShop5(newVinLog);
                break;
            case "shop6":
                vinService.addloginShop6(newVinLog);
                break;
            case "shop7":
                vinService.addloginShop7(newVinLog);
                break;
            case "shop8":
                vinService.addloginShop8(newVinLog);
                break;
            case "shop9":
                vinService.addloginShop9(newVinLog);
                break;
            case "shop10":
                vinService.addloginShop10(newVinLog);
                break;
            case "shop11":
                vinService.addloginShop11(newVinLog);
                break;
            case "shop12":
                vinService.addloginShop12(newVinLog);
                break;
            case "shop13":
                vinService.addloginShop13(newVinLog);
                break;
            case "shop14":
                vinService.addloginShop14(newVinLog);
                break;
        }
    }

    /**
     *
     * @param id
     * @param location
     * @return
     */
    public List<VinLog> queryVinLog(String id, String location){
        List<VinLog> vinLogList = null;
        switch (location){
            case "main0":
                vinLogList = vinService.queryAllLoginmain0byItemid(id);
                break;
            case "main1":
                vinLogList = vinService.queryAllLoginmain1byItemid(id);
                break;
            case "main2":
                vinLogList = vinService.queryAllLoginmain2byItemid(id);
                break;
            case "shop1":
                vinLogList = vinService.queryAllLoginshop1byItemid(id);
                break;
            case "shop2":
                vinLogList = vinService.queryAllLoginshop2byItemid(id);
                break;
            case "shop3":
                vinLogList = vinService.queryAllLoginshop3byItemid(id);
                break;
            case "shop4":
                vinLogList = vinService.queryAllLoginshop4byItemid(id);
                break;
            case "shop5":
                vinLogList = vinService.queryAllLoginshop5byItemid(id);
                break;
            case "shop6":
                vinLogList = vinService.queryAllLoginshop6byItemid(id);
                break;
            case "shop7":
                vinLogList = vinService.queryAllLoginshop7byItemid(id);
                break;
            case "shop8":
                vinLogList = vinService.queryAllLoginshop8byItemid(id);
                break;
            case "shop9":
                vinLogList = vinService.queryAllLoginshop9byItemid(id);
                break;
            case "shop10":
                vinLogList = vinService.queryAllLoginshop10byItemid(id);
                break;
            case "shop11":
                vinLogList = vinService.queryAllLoginshop11byItemid(id);
                break;
            case "shop12":
                vinLogList = vinService.queryAllLoginshop12byItemid(id);
                break;
            case "shop13":
                vinLogList = vinService.queryAllLoginshop13byItemid(id);
                break;
            case "shop14":
                vinLogList = vinService.queryAllLoginshop14byItemid(id);
                break;
        }
        return vinLogList;
    }

    /**
     *
     * @param location
     * @param logid
     */
    public void deleteLog(String location, String logid) {
        switch (location) {
            case "main0":
                vinService.deleteLoginMain0byLogid(logid);
                break;
            case "main1":
                vinService.deleteLoginMain1byLogid(logid);
                break;
            case "main2":
                vinService.deleteLoginMain2byLogid(logid);
                break;
            case "shop1":
                vinService.deleteLoginShop1byLogid(logid);
                break;
            case "shop2":
                vinService.deleteLoginShop2byLogid(logid);
                break;
            case "shop3":
                vinService.deleteLoginShop3byLogid(logid);
                break;
            case "shop4":
                vinService.deleteLoginShop4byLogid(logid);
                break;
            case "shop5":
                vinService.deleteLoginShop5byLogid(logid);
                break;
            case "shop6":
                vinService.deleteLoginShop6byLogid(logid);
                break;
            case "shop7":
                vinService.deleteLoginShop7byLogid(logid);
                break;
            case "shop8":
                vinService.deleteLoginShop8byLogid(logid);
                break;
            case "shop9":
                vinService.deleteLoginShop9byLogid(logid);
                break;
            case "shop10":
                vinService.deleteLoginShop10byLogid(logid);
                break;
            case "shop11":
                vinService.deleteLoginShop11byLogid(logid);
                break;
            case "shop12":
                vinService.deleteLoginShop12byLogid(logid);
                break;
            case "shop13":
                vinService.deleteLoginShop13byLogid(logid);
                break;
            case "shop14":
                vinService.deleteLoginShop14byLogid(logid);
                break;
        }
    }
}
