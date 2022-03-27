package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VinAlert{
    private String logid;
    private String id;
    private int count_week;
    private int count_month;
    private boolean ifalert_week;
    private boolean ifalert_month;
    private String time;
    private String category;
    private String itemName;
    private String brand;
    private int itemCount;


}
