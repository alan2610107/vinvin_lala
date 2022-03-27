package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KryOrderDetailInfo {
    private String baseInfo;
    private String payInfos;
    private String dishInfos;
    private String extraCharges;
    private String orderInfo;
    private String privilegeInfos;
    private String deliveryInfo;
    private String tableInfos;
    private String tradeCustomerInfos;
//    private String code;
//    private String message;
//    private String messageUuid;
//    private String apiMessage;

}
