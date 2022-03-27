package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

//implements Serializable
public class VinCheck{
    private String logid;
    private String id;
    private String itemName;
    private String brand;
    private int checkitemCount;
    private int realitemCount;
    private int difference;
    private String ifmatch;
    private String time;
    private String category;

    public VinCheck(VinCheckwithLocation vinCheckwithLocation){
        this.logid = vinCheckwithLocation.getLogid();
        this.id = vinCheckwithLocation.getId();
        this.itemName = vinCheckwithLocation.getItemName();
        this.brand = vinCheckwithLocation.getBrand();
        this.checkitemCount = vinCheckwithLocation.getCheckitemCount();
        this.realitemCount = vinCheckwithLocation.getRealitemCount();
        this.difference = vinCheckwithLocation.getDifference();
        this.ifmatch = vinCheckwithLocation.getIfmatch();
        this.time = vinCheckwithLocation.getTime();
        this.category = vinCheckwithLocation.getCategory();

    }



}
