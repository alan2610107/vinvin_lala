package com.kuang.handler;

import com.kuang.pojo.ApplyItemConfirm;
import com.kuang.service.VinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class ConfirmAreaHandler extends ConfirmAbstractHandler{
    @Autowired
    @Qualifier("VinServiceImpl")
    VinService vinService;

    @Resource
    ConfirmDetect confirmDetect;

    private Boolean getIfConfirm(String logID){
        ApplyItemConfirm applyItemConfirm = vinService.queryApplyItemConfirmByLogID(logID);
        return applyItemConfirm.getConfirm_area();
    }

    @Override
    public String handler() {
        String status = "CONFIRM_AREA";
        log.warn(status);
        Boolean confirm = getIfConfirm(logID);
        return confirmDetect.confirmDetect(confirm, status, next);
//        String result = null;
//        if(confirm!= null && confirm){//通過了
//            if(next != null){
//                return next.handler();
//            }else {
//                result = "All finished";
//                log.warn(result);
//                return result;
//            }
//        }else if(confirm!= null && !confirm){//沒通過
//            result = "No pass";
//            log.warn(result);
//            return result;
//        }else{//還沒到
//            result = status;
//            log.warn(result);
//            return result;
//        }

    }
}
