package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FruitInvoice {
    private String invoiceid;
    private String time;
    private String memo;
    private String location;
    private String supplier;
    private String invoiceTime;
    private double price;
    private String month;

    public FruitInvoice(FruitInvoice invoice) {
        this.invoiceid = invoice.getInvoiceid();
        this.time = invoice.getTime();
        this.memo =invoice.getMemo();
        this.location = invoice.getLocation();
        this.supplier = invoice.getSupplier();
        this.invoiceTime = invoice.getInvoiceTime();
        this.price = invoice.getPrice();
        this.month = invoice.getMonth();
    }

}
