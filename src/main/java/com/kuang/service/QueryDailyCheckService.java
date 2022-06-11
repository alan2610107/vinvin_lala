package com.kuang.service;

import com.kuang.pojo.VinCheck;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
/**
 * @author Chi-Lin Wu
 * @apiNote Get All DailyCheck by muti-thread
 */
@Service
public class QueryDailyCheckService{
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    @Autowired
    ThreadPoolTaskExecutor taskExecutor;


//    private VinService vinService = SpringUtil.getApplicationContext().getBean(VinService.class);

//    private String location;
//    private String category;
//
//    public QueryDailyCheckService(String location, String category) {
//        this.location = location;
//        this.category = category;
//    }
//
    public Future<List<VinCheck>> get(String location, String category){
        return taskExecutor.submit(()->{
            List<VinCheck> dailyCheck = new ArrayList<>();
            switch (location){
                case "main0":
                    dailyCheck = vinService.queryCheckinMain0(category);
                    break;
                case "main1":
                    dailyCheck = vinService.queryCheckinMain1(category);
                    break;
                case "main2":
                    dailyCheck = vinService.queryCheckinMain2(category);
                    break;
                case "shop1":
                    dailyCheck = vinService.queryCheckinShop1(category);
                    break;
                case "shop2":
                    dailyCheck = vinService.queryCheckinShop2(category);
                    break;
                case "shop3":
                    dailyCheck = vinService.queryCheckinShop3(category);
                    break;
                case "shop4":
                    dailyCheck = vinService.queryCheckinShop4(category);
                    break;
                case "shop5":
                    dailyCheck = vinService.queryCheckinShop5(category);
                    break;
                case "shop6":
                    dailyCheck = vinService.queryCheckinShop6(category);
                    break;
                case "shop7":
                    dailyCheck = vinService.queryCheckinShop7(category);
                    break;
                case "shop8":
                    dailyCheck = vinService.queryCheckinShop8(category);
                    break;
                case "shop9":
                    dailyCheck = vinService.queryCheckinShop9(category);
                    break;
                case "shop10":
                    dailyCheck = vinService.queryCheckinShop10(category);
                    break;
                case "shop11":
                    dailyCheck = vinService.queryCheckinShop11(category);
                    break;
                case "shop12":
                    dailyCheck = vinService.queryCheckinShop12(category);
                    break;
                case "shop13":
                    dailyCheck = vinService.queryCheckinShop13(category);
                    break;
                case "shop14":
                    dailyCheck = vinService.queryCheckinShop14(category);
                    break;
            }
            return dailyCheck;
        });
    }


//    @Override
//    public List<VinCheck> call() throws Exception {
//        List<VinCheck> dailyCheck = new ArrayList<>();
//        switch (location){
//            case "main0":
//                dailyCheck = vinService.queryCheckinMain0(category);
//                break;
//            case "main1":
//                dailyCheck = vinService.queryCheckinMain1(category);
//                break;
//            case "main2":
//                dailyCheck = vinService.queryCheckinMain2(category);
//                break;
//            case "shop1":
//                dailyCheck = vinService.queryCheckinShop1(category);
//                break;
//            case "shop2":
//                dailyCheck = vinService.queryCheckinShop2(category);
//                break;
//            case "shop3":
//                dailyCheck = vinService.queryCheckinShop3(category);
//                break;
//            case "shop4":
//                dailyCheck = vinService.queryCheckinShop4(category);
//                break;
//            case "shop5":
//                dailyCheck = vinService.queryCheckinShop5(category);
//                break;
//            case "shop6":
//                dailyCheck = vinService.queryCheckinShop6(category);
//                break;
//            case "shop7":
//                dailyCheck = vinService.queryCheckinShop7(category);
//                break;
//            case "shop8":
//                dailyCheck = vinService.queryCheckinShop8(category);
//                break;
//            case "shop9":
//                dailyCheck = vinService.queryCheckinShop9(category);
//                break;
//            case "shop10":
//                dailyCheck = vinService.queryCheckinShop10(category);
//                break;
//        }
//        return dailyCheck;
//    }
}
