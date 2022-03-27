package com.kuang.KryType;

import lombok.Getter;


public enum KryAPI {
    GET_SHOP_TOKEN("4.2", "获取门店token", "/open/v1/token/get"),
    AUTH_SHOP_LIST("6.1", "授权门店列表", "/open/v1/shop/shoplist"),
    PAY_WAY_QUERY("6.7", "获取门店支付类型", "/open/v1/pay/payWay/query"),
    ORDER_DETAIL("7.2", "订单详情", "/open/v1/data/order/exportDetail"),
    ORDERS("7.2", "订单列表", "/open/v1/data/order/export2"),
    SNACK_ORDER_CREATE("9.2.1", "快餐下单", "/open/v1/snack/order/create"),
    TAKEOUT_ORDER_CREATE("10.2.1", "外卖下单", "/open/v1/takeout/order/create"),
    STANDARD_LASTED_APP("s_1", "最新应用", "/open/standard/lastedApp"),
    DISH_DETAIL("s_1", "最新应用", "/open/v1/cater/dish/dishMenuByIds");

    private String docNum;
    private String description;
    @Getter
    private String uri;

    KryAPI(String docNum, String description, String uri) {
        this.docNum = docNum;
        this.description = description;
        this.uri = uri;
    }
}
