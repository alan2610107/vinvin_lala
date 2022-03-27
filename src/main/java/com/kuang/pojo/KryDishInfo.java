package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KryDishInfo {
    private String orderId;
    private String uuid;
    private String dishCode;
    private String dishId;
    private String dishName;
    private String price;
    private String quantity;
    private String unitName;
    private String amount;
    private String dishProperties;
    private String dishPropertyName;
    private String dishCookingWay;
    private String childNodes;
    private String itemId;
    private String addDishWaiter;
    private String giveDishWaiter;
    private String category;
    private String warehouse;
    private String orderTime;
}
