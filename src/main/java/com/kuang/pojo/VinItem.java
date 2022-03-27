package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VinItem{
    private String id;
    private String itemName;
    private String brand;
    private int itemCount;
    private double singlePrice;
    private double totalPrice;
    private String memo;
    private String category;


    public VinItem(VinItem vinItem) {
        this.id = vinItem.getId();
        this.itemName = vinItem.getItemName();
        this.brand = vinItem.getBrand();
        this.itemCount = vinItem.getItemCount();
        this.singlePrice = vinItem.getSinglePrice();
        this.totalPrice = vinItem.getTotalPrice();
        this.memo = vinItem.getMemo();
    }
    public VinItem(VinItemwithLocationandCategory vinItemwithLocationandCategory){
        this.id = vinItemwithLocationandCategory.getId();
        this.itemName = vinItemwithLocationandCategory.getItemName();
        this.brand = vinItemwithLocationandCategory.getBrand();
        this.itemCount = vinItemwithLocationandCategory.getItemCount();
        this.singlePrice = vinItemwithLocationandCategory.getSinglePrice();
        this.totalPrice = vinItemwithLocationandCategory.getTotalPrice();
        this.memo = vinItemwithLocationandCategory.getMemo();
    }

    public VinItem(String id, String itemName, String brand) {
        this.id = id;
        this.itemName = itemName;
        this.brand = brand;
    }

    public VinItem(VinLog vinLog) {
        this.id = vinLog.getId();
        this.itemName = vinLog.getItemName();
        this.brand = vinLog.getBrand();
        this.itemCount = vinLog.getItemCount();
        this.singlePrice = vinLog.getSinglePrice();
        this.totalPrice = vinLog.getTotalPrice();
        this.memo = vinLog.getMemo();
        this.category = vinLog.getCategory();
    }
}
