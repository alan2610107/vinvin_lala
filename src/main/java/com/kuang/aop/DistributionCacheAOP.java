package com.kuang.aop;

import com.kuang.pojo.VinItem;
import com.kuang.service.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.protocol.types.Field;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

@Component
@Aspect
@Slf4j
public class DistributionCacheAOP {
    @Resource
    private RedisTemplate distributionRedisTemplate;

    @Resource
    private CacheService cacheService;

    @Autowired
    AOPTool aopTool;


    @Before("execution(* *..VinMainControllerService.do*(..))")
    public void vinItemLockUp(JoinPoint joinPoint) throws Throwable {
        String distributionCacheKey = aopTool.setDistributionCacheKey(aopTool.getParameterNames(joinPoint));
//        log.warn("Lock Up : " + distributionCacheKey);
        cacheService.setRedisLock(distributionCacheKey, new VinItem());
    }
    @After("execution(* *..VinMainControllerService.do*(..))")
    public void waitForVinItemUnlock(JoinPoint joinPoint) throws InterruptedException {
        String distributionCacheKey = aopTool.setDistributionCacheKey(aopTool.getParameterNames(joinPoint));
//        log.warn("Wait for Unlock " + distributionCacheKey);
        cacheService.waitRedisLock(distributionCacheKey);
    }

//    @Before("execution(* *..VinMainControllerService.to*(..))")
//    public void checkNoOneUsing(JoinPoint joinPoint) throws InterruptedException {
//        String distributionCacheKey = aopTool.setDistributionCacheKey(aopTool.getParameterNames(joinPoint));
////        log.warn("Wait for Unlock " + distributionCacheKey);
//        cacheService.waitRedisLock(distributionCacheKey);
//    }



}
