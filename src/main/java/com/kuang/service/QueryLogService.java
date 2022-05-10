package com.kuang.service;

import com.kuang.pojo.VinLog;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @author Chi-Lin Wu
 * @apiNote Get log by muti-thread
 */
@Service
@Slf4j
public class QueryLogService{
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    @Resource
    ThreadPoolTaskExecutor taskExecutor;

    /**
     *
     * @param location
     * @param category
     * @param ifComplete
     * @return
     *
     */
    public Future<List<VinLog>> get(String location, String category, String ifComplete){
        return taskExecutor.submit(()->{
            if(ifComplete==null){
                switch (location) {
                    case "main0":
                        return vinService.queryCategoryLoginMain0(category);
                    case "main1":
                        return vinService.queryCategoryLoginMain1(category);
                    case "main2":
                        return vinService.queryCategoryLoginMain2(category);
                    case "shop1":
                        return vinService.queryCategoryLoginShop1(category);
                    case "shop2":
                        return vinService.queryCategoryLoginShop2(category);
                    case "shop3":
                        return vinService.queryCategoryLoginShop3(category);
                    case "shop4":
                        return vinService.queryCategoryLoginShop4(category);
                    case "shop5":
                        return vinService.queryCategoryLoginShop5(category);
                    case "shop6":
                        return vinService.queryCategoryLoginShop6(category);
                    case "shop7":
                        return vinService.queryCategoryLoginShop7(category);
                    case "shop8":
                        return vinService.queryCategoryLoginShop8(category);
                    case "shop9":
                        return vinService.queryCategoryLoginShop9(category);
                    case "shop10":
                        return vinService.queryCategoryLoginShop10(category);
                    case "shop11":
                        return vinService.queryCategoryLoginShop11(category);
                    case "shop12":
                        return vinService.queryCategoryLoginShop12(category);
                    case "shop13":
                        return vinService.queryCategoryLoginShop13(category);
                }
                return null;
            }else if(ifComplete.equals("false")){
                switch (location) {
                    case "main0":
                        return vinService.queryCategoryandIfCompleteLoginMain0(category,false);
                    case "main1":
                        return vinService.queryCategoryandIfCompleteLoginMain1(category,false);
                    case "main2":
                        return vinService.queryCategoryandIfCompleteLoginMain2(category,false);
                    case "shop1":
                        return vinService.queryCategoryandIfCompleteLoginShop1(category,false);
                    case "shop2":
                        return vinService.queryCategoryandIfCompleteLoginShop2(category,false);
                    case "shop3":
                        return vinService.queryCategoryandIfCompleteLoginShop3(category,false);
                    case "shop4":
                        return vinService.queryCategoryandIfCompleteLoginShop4(category,false);
                    case "shop5":
                        return vinService.queryCategoryandIfCompleteLoginShop5(category,false);
                    case "shop6":
                        return vinService.queryCategoryandIfCompleteLoginShop6(category,false);
                    case "shop7":
                        return vinService.queryCategoryandIfCompleteLoginShop7(category,false);
                    case "shop8":
                        return vinService.queryCategoryandIfCompleteLoginShop8(category,false);
                    case "shop9":
                        return vinService.queryCategoryandIfCompleteLoginShop9(category,false);
                    case "shop10":
                        return vinService.queryCategoryandIfCompleteLoginShop10(category,false);
                    case "shop11":
                        return vinService.queryCategoryandIfCompleteLoginShop11(category,false);
                    case "shop12":
                        return vinService.queryCategoryandIfCompleteLoginShop12(category,false);
                    case "shop13":
                        return vinService.queryCategoryandIfCompleteLoginShop13(category,false);
                }
                return null;
            }else if(ifComplete.equals("true")){
                switch (location) {
                    case "main0":
                        return vinService.queryCategoryandIfCompleteLoginMain0(category,true);
                    case "main1":
                        return vinService.queryCategoryandIfCompleteLoginMain1(category,true);
                    case "main2":
                        return vinService.queryCategoryandIfCompleteLoginMain2(category,true);
                    case "shop1":
                        return vinService.queryCategoryandIfCompleteLoginShop1(category,true);
                    case "shop2":
                        return vinService.queryCategoryandIfCompleteLoginShop2(category,true);
                    case "shop3":
                        return vinService.queryCategoryandIfCompleteLoginShop3(category,true);
                    case "shop4":
                        return vinService.queryCategoryandIfCompleteLoginShop4(category,true);
                    case "shop5":
                        return vinService.queryCategoryandIfCompleteLoginShop5(category,true);
                    case "shop6":
                        return vinService.queryCategoryandIfCompleteLoginShop6(category,true);
                    case "shop7":
                        return vinService.queryCategoryandIfCompleteLoginShop7(category,true);
                    case "shop8":
                        return vinService.queryCategoryandIfCompleteLoginShop8(category,true);
                    case "shop9":
                        return vinService.queryCategoryandIfCompleteLoginShop9(category,true);
                    case "shop10":
                        return vinService.queryCategoryandIfCompleteLoginShop10(category,true);
                    case "shop11":
                        return vinService.queryCategoryandIfCompleteLoginShop11(category,true);
                    case "shop12":
                        return vinService.queryCategoryandIfCompleteLoginShop12(category,true);
                    case "shop13":
                        return vinService.queryCategoryandIfCompleteLoginShop13(category,true);
                }
                return null;
            }else {
                return null;
            }
        });

    }





}
