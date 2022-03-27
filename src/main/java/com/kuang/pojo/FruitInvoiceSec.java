package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FruitInvoiceSec {
    private String id;
    private String supplier;
    private String store;
    private double totalPrice;
    private String month;
}
