package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dumplist extends VinItem{
    private String logid;
    //    private String id;
//    private String itemName;
//    private String brand;
    private int itemCount;
    private String expiredDate;
    private String howLong;
    private String reason;
    private String dumptime;
    private String action;
    private String location;
    private String category;
    private String memo;
    private boolean if_pass;
    private String status;
    public Dumplist(@NotNull VinItem vinItem){
        super(vinItem.getId(), vinItem.getItemName(), vinItem.getBrand());
    }



}
