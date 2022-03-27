package com.kuang.aop;

import com.kuang.pojo.VinItem;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import scala.concurrent.impl.Promise;

import java.util.*;

@Component

public class AOPTool {

    /**
     * @apiNote Value is in position 0, type is in position 1
     * @param joinPoint
     * @return Map<String, Object> valueMap
     */
    public Map<String,Object> getParameterNames(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        String[] parameterNames = methodSignature.getParameterNames();
        Object[] parameterValues = joinPoint.getArgs();
//        Object[] parameterTypes = methodSignature.getMethod().getParameterTypes();
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> valueMap = new HashMap<>();
//        Map<String,Object> typeMap = new HashMap<>();
        for (int i = 0; i < parameterNames.length; i++) {
            valueMap.put(parameterNames[i],parameterValues[i]);
//            typeMap.put(parameterNames[i],parameterTypes[i]);
        }
//        list.add(valueMap);
//        list.add(typeMap);
        return valueMap;
    }

    /**
     *
     * @param valueMap
     * @return String distributionCacheKey
     */
    public String setDistributionCacheKey(Map<String, Object> valueMap){
        String location = (String) valueMap.get("location");
        String category = (String) valueMap.get("category");
        VinItem vinItem = (VinItem) valueMap.get("vinItem");
        String itemID = (String) valueMap.get("itemID");
        if(vinItem != null){
            return location + "," + category + "," + vinItem.getId();
        }else {
            return location + "," + category + "," + itemID;
        }


    }
}
