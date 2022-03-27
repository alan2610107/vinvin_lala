package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KryOrders {
    private Long shopIdenty;
    private Long startTime;
    private Long endTime;
    private Long pageNo;

}
