package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
    private String supplierID;
    private String supplierName;
    private String supply_area;
    private String payCheck_way;
    private String pay_way;
}
