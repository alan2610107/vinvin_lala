package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VinItemwithLocationandCategory {
    private String id;
    private String itemName;
    private String brand;
    private int itemCount;
    private double singlePrice;
    private double totalPrice;
    private String memo;
    private String location;
    private String category;


    public VinItemwithLocationandCategory(VinItemwithLocationandCategory vinItemwithLocationandCategory) {
        this.id = vinItemwithLocationandCategory.getId();
        this.itemName = vinItemwithLocationandCategory.getItemName();
        this.brand = vinItemwithLocationandCategory.getBrand();
        this.itemCount = vinItemwithLocationandCategory.getItemCount();
        this.singlePrice = vinItemwithLocationandCategory.getSinglePrice();
        this.totalPrice = vinItemwithLocationandCategory.getTotalPrice();
        this.memo = vinItemwithLocationandCategory.getMemo();
        this.location = vinItemwithLocationandCategory.getLocation();
        this.category = vinItemwithLocationandCategory.getCategory();
    }
    public VinItemwithLocationandCategory(VinItem vinItem) {
        this.id = vinItem.getId();
        this.itemName = vinItem.getItemName();
        this.brand = vinItem.getBrand();
        this.itemCount = vinItem.getItemCount();
        this.singlePrice = vinItem.getSinglePrice();
        this.totalPrice = vinItem.getTotalPrice();
        this.memo = vinItem.getMemo();
//        this.location = vinItem.getLocation();
//        this.category = vinItem.getCategory();
    }
}
