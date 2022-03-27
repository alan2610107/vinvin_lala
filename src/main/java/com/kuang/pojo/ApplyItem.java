package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplyItem {
    private String logID;
    private String applyTime; //申請日期
    private String location; //店名
    private String itemName; //物料名稱
    private int count; //數量
    private String applyName; //申請人
    private String status; //采购处理状态：未配送，已配送
    private String shipID; //運單號
    private double singlePrice; //單價
    private double totalPrice; //總價
    private String purchaseTime; //採購日期
    private boolean confirm; //区代审核
    private String confirmResult; //審核結果
    private String month; //月份

    public ApplyItem(ApplyItem applyItem) {
        this.logID = applyItem.getLogID();
        this.applyTime = applyItem.getApplyTime();
        this.location = applyItem.getLocation();
        this.itemName = applyItem.getItemName();
        this.count = applyItem.getCount();
        this.applyName = applyItem.getApplyName();
        this.status = applyItem.getStatus();
        this.shipID = applyItem.getShipID();
        this.singlePrice = applyItem.getSinglePrice();
        this.totalPrice = applyItem.getTotalPrice();
        this.purchaseTime = applyItem.getPurchaseTime();
        this.confirm = applyItem.confirm;
        this.confirmResult = applyItem.getConfirmResult();
        this.month = applyItem.getMonth();
    }

}
