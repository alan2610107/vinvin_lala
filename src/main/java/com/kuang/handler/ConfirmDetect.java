package com.kuang.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConfirmDetect {
    /**
     *
     * @param confirm
     * @param status
     * @param next
     * @return String
     */
    public String confirmDetect(Boolean confirm, String status, ConfirmAbstractHandler next) {
        String result = null;
        if(confirm!= null && confirm){//通過了
            if(next != null){
                return next.handler();
            }else {
                result = "All_Finished";
                log.warn(result);
                return result;
            }
        }else if(confirm!= null && !confirm){//沒通過
            result = "No_Pass";
            log.warn(result);
            return result;
        }else{//還沒到
            result = status;
            log.warn(result);
            return result;
        }
    }
}
