package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class VinLog{
    private String logid;
    private String id;
    private String itemName;
    private String brand;
    private int itemCount;
    private double singlePrice;
    private double totalPrice;
    private String memo;
    private String time;
    private String category;
    private String action;
    private String from;
    private String to;
    private boolean ifComplete;
    private boolean ifConfirm;


    public VinLog(VinLog vinLog) {
        this.logid = vinLog.getLogid();
        this.id = vinLog.getId();
        this.itemName = vinLog.getItemName();
        this.brand = vinLog.getBrand();
        this.itemCount = vinLog.getItemCount();
        this.singlePrice = vinLog.getSinglePrice();
        this.totalPrice = vinLog.getTotalPrice();
        this.memo = vinLog.getMemo();
        this.time = vinLog.getTime();
        this.category = vinLog.getCategory();
        this.action = vinLog.getAction();
        this.from = vinLog.getFrom();
        this.to = vinLog.getTo();
        this.ifComplete = vinLog.ifComplete;
        this.ifConfirm = vinLog.ifConfirm;
    }

    public VinLog(String id, String logid, String itemName, String brand, int itemCount, String category) {
        this.logid = logid;
        this.id = id;
        this.itemName = itemName;
        this.brand = brand;
        this.itemCount = itemCount;
        this.category = category;

    }
}
