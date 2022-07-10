package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplyItemConfirm extends ApplyItem{
    private String logID;
    private Boolean confirm_area;
    private Boolean confirm_center;
    private Boolean confirm_finance;
    private String confirm_area_date;
    private String confirm_center_date;
    private String confirm_finance_date;
}
