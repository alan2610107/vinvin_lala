package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KryOrder {
    private String tradeNo;
    private String orderId;
    private String bizDate;
    private String source;
    private String receivedAmount;
    private String tradeAmount;
    private String privilegeAmount;
    private String orderTime;
    private String checkOutTime;
    private String tradeStatus;
    private String sourceName;
    private String custRealPay;
    private String tradeType;
    private String warehouse;

}
