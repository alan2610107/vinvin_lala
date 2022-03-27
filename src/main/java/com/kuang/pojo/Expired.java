package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expired {
    private String itemName;
//    private String brand;
    private int id;
    private String itemID;
    private String time;
    private String location;
    private String produceDate;
    private boolean ifDump;

    public Expired(String itemID, String time, String location) {
        this.itemID=itemID;
        this.time=time;
        this.location=location;
    }
}
