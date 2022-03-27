package com.kuang.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class UserpageControllerService {
    @Autowired
    @Qualifier("VinServiceImpl")
    private VinService vinService;

    @Resource
    private CacheService cacheService;

    /**
     * @apiNote Increase NotReceiveCount and Decrease NotConfirmCount by Confirm
     * @param agree
     * @param location
     */
    public void confirmCountFunction(boolean agree, String location){
        if(agree){
            cacheService.increaseNotReceiveCount(location);
        }
        cacheService.decreaseNotConfirmCount(location);
    }
}

