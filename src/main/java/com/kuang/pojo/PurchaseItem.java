package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseItem extends ApplyItem {
    private String logID;
    private String purchaseStatus; //采购处理状态： 處理中，已採購，已配送，已送達，已取消
    private String shipID;
    private String purchaseTime;
    private String purchaseMonth;
    private Double singlePrice;
    private Double totalPrice;

}
