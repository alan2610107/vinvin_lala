package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceiveError extends VinLog{
//    private String logid;
//    private String id;
//    private String itemName;
//    private int itemCount;
    private boolean ifComplete;
    private String location;
//    private String category;

//    public ReceiveError(ReceiveError receiveError){
//        this.logid = receiveError.getLogid();
//        this.id = receiveError.getId();
//        this.itemName = receiveError.getItemName();
//        this.itemCount = receiveError.getItemCount();
//        this.ifComplete = receiveError.ifComplete;
//        this.location = receiveError.getLocation();
//        this.category = receiveError.getCategory();
//    }
    public ReceiveError(VinLog vinLog){
        super(vinLog.getId(),vinLog.getLogid(), vinLog.getItemName(), vinLog.getBrand(), vinLog.getItemCount(), vinLog.getCategory());
//        this.logid = vinLog.getLogid();
//        this.id = vinLog.getId();
//        this.itemName = vinLog.getItemName();
//        this.itemCount = vinLog.getItemCount();
        this.ifComplete = false;/////不確定
//        this.category = vinLog.getCategory();
    }
}

