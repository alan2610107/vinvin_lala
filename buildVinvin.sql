#------------------vinvin---------------------
CREATE DATABASE IF NOT EXISTS `vinvin`;
use vinvin;

create table WarehouseDailyChecklogmain0
(
    logid          varchar(100) null,
    id             varchar(100) null,
    itemName       varchar(100) null,
    brand          varchar(100) null,
    checkitemCount int          null,
    realitemCount  int          null,
    ifmatch        varchar(10)  null,
    time           varchar(100) null,
    category       varchar(100) null,
    difference     int          null
);

create index WarehouseDailyChecklogmain0_category_time_index
    on WarehouseDailyChecklogmain0 (category asc, time desc);

create index WarehouseDailyChecklogmain0_id_index
    on WarehouseDailyChecklogmain0 (id);

create index WarehouseDailyChecklogmain0_ifmatch_index
    on WarehouseDailyChecklogmain0 (ifmatch);

create index WarehouseDailyChecklogmain0_logid_index
    on WarehouseDailyChecklogmain0 (logid);

create index WarehouseDailyChecklogmain0_time_index
    on WarehouseDailyChecklogmain0 (time desc);

create table WarehouseDailyChecklogmain1
(
    logid          varchar(100) null,
    id             varchar(100) null,
    itemName       varchar(100) null,
    brand          varchar(100) null,
    checkitemCount int          null,
    realitemCount  int          null,
    ifmatch        varchar(10)  null,
    time           varchar(100) null,
    category       varchar(100) null,
    difference     int          null
);

create index WarehouseDailyChecklogmain1_category_time_index
    on WarehouseDailyChecklogmain1 (category asc, time desc);

create index WarehouseDailyChecklogmain1_id_index
    on WarehouseDailyChecklogmain1 (id);

create index WarehouseDailyChecklogmain1_ifmatch_index
    on WarehouseDailyChecklogmain1 (ifmatch);

create index WarehouseDailyChecklogmain1_logid_index
    on WarehouseDailyChecklogmain1 (logid);

create index WarehouseDailyChecklogmain1_time_index
    on WarehouseDailyChecklogmain1 (time desc);

create table WarehouseDailyChecklogmain2
(
    logid          varchar(100) null,
    id             varchar(100) null,
    itemName       varchar(100) null,
    brand          varchar(100) null,
    checkitemCount int          null,
    realitemCount  int          null,
    ifmatch        varchar(10)  null,
    time           varchar(100) null,
    category       varchar(100) null,
    difference     int          null
);

create index WarehouseDailyChecklogmain2_category_time_index
    on WarehouseDailyChecklogmain2 (category asc, time desc);

create index WarehouseDailyChecklogmain2_id_index
    on WarehouseDailyChecklogmain2 (id);

create index WarehouseDailyChecklogmain2_ifmatch_index
    on WarehouseDailyChecklogmain2 (ifmatch);

create index WarehouseDailyChecklogmain2_logid_index
    on WarehouseDailyChecklogmain2 (logid);

create index WarehouseDailyChecklogmain2_time_index
    on WarehouseDailyChecklogmain2 (time desc);

create table WarehouseDailyChecklogshop1
(
    logid          varchar(100) null,
    id             varchar(100) null,
    itemName       varchar(100) null,
    brand          varchar(100) null,
    checkitemCount int          null,
    realitemCount  int          null,
    ifmatch        varchar(10)  null,
    time           varchar(100) null,
    category       varchar(100) null,
    difference     int          null
);

create index WarehouseDailyChecklogshop1_category_time_index
    on WarehouseDailyChecklogshop1 (category asc, time desc);

create index WarehouseDailyChecklogshop1_id_index
    on WarehouseDailyChecklogshop1 (id);

create index WarehouseDailyChecklogshop1_ifmatch_index
    on WarehouseDailyChecklogshop1 (ifmatch);

create index WarehouseDailyChecklogshop1_logid_index
    on WarehouseDailyChecklogshop1 (logid);

create index WarehouseDailyChecklogshop1_time_index
    on WarehouseDailyChecklogshop1 (time desc);

create table WarehouseDailyChecklogshop10
(
    logid          varchar(100) null,
    id             varchar(100) null,
    itemName       varchar(100) null,
    brand          varchar(100) null,
    checkitemCount int          null,
    realitemCount  int          null,
    ifmatch        varchar(10)  null,
    time           varchar(100) null,
    category       varchar(100) null,
    difference     int          null
);

create index WarehouseDailyChecklogshop10_category_time_index
    on WarehouseDailyChecklogshop10 (category asc, time desc);

create index WarehouseDailyChecklogshop10_id_index
    on WarehouseDailyChecklogshop10 (id);

create index WarehouseDailyChecklogshop10_ifmatch_index
    on WarehouseDailyChecklogshop10 (ifmatch);

create index WarehouseDailyChecklogshop10_logid_index
    on WarehouseDailyChecklogshop10 (logid);

create index WarehouseDailyChecklogshop10_time_index
    on WarehouseDailyChecklogshop10 (time desc);

create table WarehouseDailyChecklogshop11
(
    logid          varchar(100) null,
    id             varchar(100) null,
    itemName       varchar(100) null,
    brand          varchar(100) null,
    checkitemCount int          null,
    realitemCount  int          null,
    ifmatch        varchar(10)  null,
    time           varchar(100) null,
    category       varchar(100) null,
    difference     int          null
);

create index WarehouseDailyChecklogshop11_category_time_index
    on WarehouseDailyChecklogshop11 (category asc, time desc);

create index WarehouseDailyChecklogshop11_id_index
    on WarehouseDailyChecklogshop11 (id);

create index WarehouseDailyChecklogshop11_ifmatch_index
    on WarehouseDailyChecklogshop11 (ifmatch);

create index WarehouseDailyChecklogshop11_logid_index
    on WarehouseDailyChecklogshop11 (logid);

create index WarehouseDailyChecklogshop11_time_index
    on WarehouseDailyChecklogshop11 (time desc);

create table WarehouseDailyChecklogshop12
(
    logid          varchar(100) null,
    id             varchar(100) null,
    itemName       varchar(100) null,
    brand          varchar(100) null,
    checkitemCount int          null,
    realitemCount  int          null,
    ifmatch        varchar(10)  null,
    time           varchar(100) null,
    category       varchar(100) null,
    difference     int          null
);

create index WarehouseDailyChecklogshop12_category_time_index
    on WarehouseDailyChecklogshop12 (category asc, time desc);

create index WarehouseDailyChecklogshop12_id_index
    on WarehouseDailyChecklogshop12 (id);

create index WarehouseDailyChecklogshop12_ifmatch_index
    on WarehouseDailyChecklogshop12 (ifmatch);

create index WarehouseDailyChecklogshop12_logid_index
    on WarehouseDailyChecklogshop12 (logid);

create index WarehouseDailyChecklogshop12_time_index
    on WarehouseDailyChecklogshop12 (time desc);

create table WarehouseDailyChecklogshop13
(
    logid          varchar(100) null,
    id             varchar(100) null,
    itemName       varchar(100) null,
    brand          varchar(100) null,
    checkitemCount int          null,
    realitemCount  int          null,
    ifmatch        varchar(10)  null,
    time           varchar(100) null,
    category       varchar(100) null,
    difference     int          null
);

create index WarehouseDailyChecklogshop13_category_time_index
    on WarehouseDailyChecklogshop13 (category asc, time desc);

create index WarehouseDailyChecklogshop13_id_index
    on WarehouseDailyChecklogshop13 (id);

create index WarehouseDailyChecklogshop13_ifmatch_index
    on WarehouseDailyChecklogshop13 (ifmatch);

create index WarehouseDailyChecklogshop13_logid_index
    on WarehouseDailyChecklogshop13 (logid);

create index WarehouseDailyChecklogshop13_time_index
    on WarehouseDailyChecklogshop13 (time desc);

create table WarehouseDailyChecklogshop14
(
    logid          varchar(100) null,
    id             varchar(100) null,
    itemName       varchar(100) null,
    brand          varchar(100) null,
    checkitemCount int          null,
    realitemCount  int          null,
    ifmatch        varchar(10)  null,
    time           varchar(100) null,
    category       varchar(100) null,
    difference     int          null
);

create index WarehouseDailyChecklogshop14_category_time_index
    on WarehouseDailyChecklogshop14 (category asc, time desc);

create index WarehouseDailyChecklogshop14_id_index
    on WarehouseDailyChecklogshop14 (id);

create index WarehouseDailyChecklogshop14_ifmatch_index
    on WarehouseDailyChecklogshop14 (ifmatch);

create index WarehouseDailyChecklogshop14_logid_index
    on WarehouseDailyChecklogshop14 (logid);

create index WarehouseDailyChecklogshop14_time_index
    on WarehouseDailyChecklogshop14 (time desc);

create table WarehouseDailyChecklogshop2
(
    logid          varchar(100) null,
    id             varchar(100) null,
    itemName       varchar(100) null,
    brand          varchar(100) null,
    checkitemCount int          null,
    realitemCount  int          null,
    ifmatch        varchar(10)  null,
    time           varchar(100) null,
    category       varchar(100) null,
    difference     int          null
);

create index WarehouseDailyChecklogshop2_category_time_index
    on WarehouseDailyChecklogshop2 (category asc, time desc);

create index WarehouseDailyChecklogshop2_id_index
    on WarehouseDailyChecklogshop2 (id);

create index WarehouseDailyChecklogshop2_ifmatch_index
    on WarehouseDailyChecklogshop2 (ifmatch);

create index WarehouseDailyChecklogshop2_logid_index
    on WarehouseDailyChecklogshop2 (logid);

create index WarehouseDailyChecklogshop2_time_index
    on WarehouseDailyChecklogshop2 (time desc);

create table WarehouseDailyChecklogshop3
(
    logid          varchar(100) null,
    id             varchar(100) null,
    itemName       varchar(100) null,
    brand          varchar(100) null,
    checkitemCount int          null,
    realitemCount  int          null,
    ifmatch        varchar(10)  null,
    time           varchar(100) null,
    category       varchar(100) null,
    difference     int          null
);

create index WarehouseDailyChecklogshop3_category_time_index
    on WarehouseDailyChecklogshop3 (category asc, time desc);

create index WarehouseDailyChecklogshop3_id_index
    on WarehouseDailyChecklogshop3 (id);

create index WarehouseDailyChecklogshop3_ifmatch_index
    on WarehouseDailyChecklogshop3 (ifmatch);

create index WarehouseDailyChecklogshop3_logid_index
    on WarehouseDailyChecklogshop3 (logid);

create index WarehouseDailyChecklogshop3_time_index
    on WarehouseDailyChecklogshop3 (time desc);

create table WarehouseDailyChecklogshop4
(
    logid          varchar(100) null,
    id             varchar(100) null,
    itemName       varchar(100) null,
    brand          varchar(100) null,
    checkitemCount int          null,
    realitemCount  int          null,
    ifmatch        varchar(10)  null,
    time           varchar(100) null,
    category       varchar(100) null,
    difference     int          null
);

create index WarehouseDailyChecklogshop4_category_time_index
    on WarehouseDailyChecklogshop4 (category asc, time desc);

create index WarehouseDailyChecklogshop4_id_index
    on WarehouseDailyChecklogshop4 (id);

create index WarehouseDailyChecklogshop4_ifmatch_index
    on WarehouseDailyChecklogshop4 (ifmatch);

create index WarehouseDailyChecklogshop4_logid_index
    on WarehouseDailyChecklogshop4 (logid);

create index WarehouseDailyChecklogshop4_time_index
    on WarehouseDailyChecklogshop4 (time desc);

create table WarehouseDailyChecklogshop5
(
    logid          varchar(100) null,
    id             varchar(100) null,
    itemName       varchar(100) null,
    brand          varchar(100) null,
    checkitemCount int          null,
    realitemCount  int          null,
    ifmatch        varchar(10)  null,
    time           varchar(100) null,
    category       varchar(100) null,
    difference     int          null
);

create index WarehouseDailyChecklogshop5_category_time_index
    on WarehouseDailyChecklogshop5 (category asc, time desc);

create index WarehouseDailyChecklogshop5_id_index
    on WarehouseDailyChecklogshop5 (id);

create index WarehouseDailyChecklogshop5_ifmatch_index
    on WarehouseDailyChecklogshop5 (ifmatch);

create index WarehouseDailyChecklogshop5_logid_index
    on WarehouseDailyChecklogshop5 (logid);

create index WarehouseDailyChecklogshop5_time_index
    on WarehouseDailyChecklogshop5 (time desc);

create table WarehouseDailyChecklogshop6
(
    logid          varchar(100) null,
    id             varchar(100) null,
    itemName       varchar(100) null,
    brand          varchar(100) null,
    checkitemCount int          null,
    realitemCount  int          null,
    ifmatch        varchar(10)  null,
    time           varchar(100) null,
    category       varchar(100) null,
    difference     int          null
);

create index WarehouseDailyChecklogshop6_category_time_index
    on WarehouseDailyChecklogshop6 (category asc, time desc);

create index WarehouseDailyChecklogshop6_id_index
    on WarehouseDailyChecklogshop6 (id);

create index WarehouseDailyChecklogshop6_ifmatch_index
    on WarehouseDailyChecklogshop6 (ifmatch);

create index WarehouseDailyChecklogshop6_logid_index
    on WarehouseDailyChecklogshop6 (logid);

create index WarehouseDailyChecklogshop6_time_index
    on WarehouseDailyChecklogshop6 (time desc);

create table WarehouseDailyChecklogshop7
(
    logid          varchar(100) null,
    id             varchar(100) null,
    itemName       varchar(100) null,
    brand          varchar(100) null,
    checkitemCount int          null,
    realitemCount  int          null,
    ifmatch        varchar(10)  null,
    time           varchar(100) null,
    category       varchar(100) null,
    difference     int          null
);

create index WarehouseDailyChecklogshop7_category_time_index
    on WarehouseDailyChecklogshop7 (category asc, time desc);

create index WarehouseDailyChecklogshop7_id_index
    on WarehouseDailyChecklogshop7 (id);

create index WarehouseDailyChecklogshop7_ifmatch_index
    on WarehouseDailyChecklogshop7 (ifmatch);

create index WarehouseDailyChecklogshop7_logid_index
    on WarehouseDailyChecklogshop7 (logid);

create index WarehouseDailyChecklogshop7_time_index
    on WarehouseDailyChecklogshop7 (time desc);

create table WarehouseDailyChecklogshop8
(
    logid          varchar(100) null,
    id             varchar(100) null,
    itemName       varchar(100) null,
    brand          varchar(100) null,
    checkitemCount int          null,
    realitemCount  int          null,
    ifmatch        varchar(10)  null,
    time           varchar(100) null,
    category       varchar(100) null,
    difference     int          null
);

create index WarehouseDailyChecklogshop8_category_time_index
    on WarehouseDailyChecklogshop8 (category asc, time desc);

create index WarehouseDailyChecklogshop8_id_index
    on WarehouseDailyChecklogshop8 (id);

create index WarehouseDailyChecklogshop8_ifmatch_index
    on WarehouseDailyChecklogshop8 (ifmatch);

create index WarehouseDailyChecklogshop8_logid_index
    on WarehouseDailyChecklogshop8 (logid);

create index WarehouseDailyChecklogshop8_time_index
    on WarehouseDailyChecklogshop8 (time desc);

create table WarehouseDailyChecklogshop9
(
    logid          varchar(100) null,
    id             varchar(100) null,
    itemName       varchar(100) null,
    brand          varchar(100) null,
    checkitemCount int          null,
    realitemCount  int          null,
    ifmatch        varchar(10)  null,
    time           varchar(100) null,
    category       varchar(100) null,
    difference     int          null
);

create index WarehouseDailyChecklogshop9_category_time_index
    on WarehouseDailyChecklogshop9 (category asc, time desc);

create index WarehouseDailyChecklogshop9_id_index
    on WarehouseDailyChecklogshop9 (id);

create index WarehouseDailyChecklogshop9_ifmatch_index
    on WarehouseDailyChecklogshop9 (ifmatch);

create index WarehouseDailyChecklogshop9_logid_index
    on WarehouseDailyChecklogshop9 (logid);

create index WarehouseDailyChecklogshop9_time_index
    on WarehouseDailyChecklogshop9 (time desc);

create table applyFinanceConfirm
(
    logID         varchar(100) not null
        primary key,
    confirmResult tinyint(1)   null,
    constraint applyFinanceConfirm_logID_uindex
        unique (logID)
);

create table applyItem
(
    logID     varchar(100) not null
        primary key,
    applyTime varchar(10)  null,
    location  varchar(10)  null,
    itemID    varchar(100) null,
    itemName  varchar(100) null,
    count     int          null,
    applyName varchar(100) null,
    month     varchar(10)  null,
    constraint applyItem_logID_uindex
        unique (logID)
);

create index applyItem_location_index
    on applyItem (location);

create index applyItem_month_index
    on applyItem (month);

create table applyItemConfirm
(
    logID                varchar(100) not null
        primary key,
    confirm_area         tinyint(1)   null,
    confirm_area_date    varchar(20)  null,
    confirm_center       tinyint(1)   null,
    confirm_center_date  varchar(20)  null,
    purchase_check       tinyint(1)   null,
    purchase_check_date  varchar(20)  null,
    confirm_finance      tinyint(1)   null,
    confirm_finance_date varchar(20)  null,
    purchase             tinyint(1)   null,
    purchase_date        varchar(20)  null,
    constraint applyItemConfirm_logID_uindex
        unique (logID)
);

create table applyItemSec
(
    id         varchar(100) not null
        primary key,
    month      varchar(10)  null,
    store      varchar(10)  null,
    totalPrice double       null,
    constraint applyItemSec_id_uindex
        unique (id)
);

create index applyItemSec_month_store_index
    on applyItemSec (month, store);

create table confirmStatusTrans
(
    statusEN varchar(30) not null
        primary key,
    statusCH varchar(30) not null,
    constraint confirmStatusTrans_statusCH_uindex
        unique (statusCH),
    constraint confirmStatusTrans_statusEN_uindex
        unique (statusEN)
);

create table dailyMoneyReport
(
    reportLog       varchar(100) not null
        primary key,
    orderSum        double       null,
    orderCount      int          null,
    orderAvgPrice   double       null,
    sellCount       int          null,
    categorySumData text         null,
    warehouse       varchar(100) null,
    time            varchar(100) null,
    constraint dailyMoneyReport_reportLog_uindex
        unique (reportLog)
);

create index dailyMoneyReport_reportLog_index
    on dailyMoneyReport (reportLog);

create index dailyMoneyReport_time_warehouse_index
    on dailyMoneyReport (time, warehouse);

create table dumpItem
(
    logid       varchar(100) null,
    id          varchar(100) null,
    brand       varchar(10)  null,
    itemCount   int          null,
    expiredDate varchar(10)  null,
    howLong     varchar(100) null,
    reason      varchar(100) null,
    dumptime    varchar(100) null,
    action      varchar(10)  null,
    location    varchar(10)  null,
    category    varchar(10)  null,
    memo        varchar(100) null,
    if_pass     tinyint(1)   null,
    status      varchar(20)  null,
    constraint dumpItem_logid_uindex
        unique (logid)
);

create index dumpItem_id_index
    on dumpItem (id);

create index dumpItem_location_category_index
    on dumpItem (location, category);

create table filetype
(
    id       varchar(100) null,
    filepath varchar(100) null,
    constraint filetype_id_uindex
        unique (id)
);

create table fruitInvoice
(
    invoiceid   varchar(100) null,
    time        varchar(10)  null,
    location    varchar(10)  null,
    supplier    varchar(100) null,
    invoiceTime varchar(100) null,
    price       double       null,
    memo        varchar(100) null,
    month       varchar(10)  not null,
    constraint fruitInvoice_invoiceid_uindex
        unique (invoiceid)
);

create index fruitInvoice_location_index
    on fruitInvoice (location);

create index fruitInvoice_month_index
    on fruitInvoice (month);

create table fruitInvoiceSec
(
    id         varchar(100) not null
        primary key,
    month      varchar(10)  not null,
    store      varchar(100) not null,
    supplier   varchar(100) not null,
    totalPrice double       not null,
    constraint fruitInvoiceSec_id_uindex
        unique (id)
);

create index fruitInvoiceSec_month_index
    on fruitInvoiceSec (month);

create table item
(
    itemID      varchar(100) not null
        primary key,
    itemName    varchar(100) null,
    category    varchar(100) null,
    singleprice double       null,
    supplierID  varchar(100) null
);

create index item_category_index
    on item (category);

create index item_itemName_index
    on item (itemName);

create index item_location_itemID_index
    on item (itemID);

create table itemCommercialSet
(
    id     int auto_increment
        primary key,
    itemID varchar(100) not null,
    constraint itemCommercialSet_id_uindex
        unique (id),
    constraint itemCommercialSet_itemID_uindex
        unique (itemID)
);

create table itemDetail
(
    itemDetailID  varchar(100) not null,
    itemID        varchar(100) not null,
    itemName      varchar(100) null,
    category      varchar(100) null,
    singleprice   double       null,
    supplierID    varchar(100) null,
    time          varchar(100) not null,
    itemUnit      varchar(10)  null,
    grossByUnit   double       null,
    priceEachUnit double       null,
    constraint itemDetail_category_time_uindex
        unique (category, time),
    constraint itemDetail_itemDetailID_uindex
        unique (itemDetailID),
    constraint itemDetail_location_itemID_index
        unique (itemID, time),
    constraint itemDetail_time_uindex
        unique (time)
);

create index itemDetail_itemName_index
    on itemDetail (itemName);

create table itemExpireDate
(
    id          int auto_increment
        primary key,
    itemID      varchar(100) null,
    time        varchar(100) null,
    produceDate varchar(100) null,
    location    varchar(100) null,
    ifDump      tinyint(1)   null,
    constraint itemExpireDate_id_uindex
        unique (id)
);

create index itemExpireDate_itemID_index
    on itemExpireDate (itemID);

create index itemExpireDate_location_time_ifDump_index
    on itemExpireDate (location, time, ifDump);

create table itemFoodSet
(
    id     int auto_increment
        primary key,
    itemID varchar(100) not null,
    constraint itemFoodSet_id_uindex
        unique (id),
    constraint itemFoodSet_itemID_uindex
        unique (itemID)
);

create table itemOthersSet
(
    id     int auto_increment
        primary key,
    itemID varchar(100) not null,
    constraint itemOthersSet_id_uindex
        unique (id),
    constraint itemOthersSet_itemID_uindex
        unique (itemID)
);

create table itemSmallToolSet
(
    id     int auto_increment
        primary key,
    itemID varchar(100) not null,
    constraint itemSmallToolSet_id_uindex
        unique (id),
    constraint itemSmallToolSet_itemID_uindex
        unique (itemID)
);

create table itemToolSet
(
    id     int auto_increment
        primary key,
    itemID varchar(100) not null,
    constraint itemToolSet_id_uindex
        unique (id),
    constraint itemToolSet_itemID_uindex
        unique (itemID)
);

create table kryOrderDetail
(
    orderId          varchar(100)  null,
    uuid             varchar(100)  null,
    dishCode         varchar(100)  null,
    dishId           varchar(100)  null,
    dishName         varchar(100)  null,
    price            varchar(100)  null,
    quantity         varchar(100)  null,
    unitName         varchar(100)  null,
    amount           varchar(100)  null,
    dishProperties   varchar(100)  null,
    dishPropertyName varchar(100)  null,
    dishCookingWay   varchar(1000) null,
    childNodes       varchar(1000) null,
    itemId           varchar(100)  null,
    addDishWaiter    varchar(100)  null,
    giveDishWaiter   varchar(100)  null,
    category         varchar(100)  null,
    warehouse        varchar(100)  null,
    orderTime        varchar(100)  null
);

create index kryOrderDetail_category_index
    on kryOrderDetail (category);

create index kryOrderDetail_orderId_index
    on kryOrderDetail (orderId);

create index kryOrderDetail_orderTime_warehouse_index
    on kryOrderDetail (orderTime, warehouse);

create table kryOrders
(
    tradeNo         varchar(100) null,
    orderId         varchar(100) not null
        primary key,
    bizDate         varchar(100) null,
    source          varchar(100) null,
    receivedAmount  varchar(100) null,
    tradeAmount     varchar(100) null,
    privilegeAmount varchar(100) null,
    orderTime       varchar(100) null,
    checkOutTime    varchar(100) null,
    tradeStatus     varchar(100) null,
    sourceName      varchar(100) null,
    custRealPay     varchar(100) null,
    tradeType       varchar(100) null,
    warehouse       varchar(100) null,
    constraint kryOrders_orderId_uindex
        unique (orderId)
);

create index kryOrders_warehouse_orderTime_index
    on kryOrders (warehouse, orderTime);

create table main0WarehouseInputlog
(
    logid       varchar(100) null,
    id          varchar(100) null,
    itemName    varchar(100) null,
    brand       varchar(100) null,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    time        varchar(100) null,
    category    varchar(100) null,
    action      varchar(100) null,
    `from`      varchar(100) null,
    `to`        varchar(100) null,
    ifComplete  tinyint(1)   null,
    ifConfirm   tinyint(1)   null
);

create index main0WarehouseInputlog_action_index
    on main0WarehouseInputlog (action);

create index main0WarehouseInputlog_id_index
    on main0WarehouseInputlog (id);

create index main0WarehouseInputlog_itemName_index
    on main0WarehouseInputlog (itemName);

create index main0WarehouseInputlog_logid_index
    on main0WarehouseInputlog (logid);

create index main0WarehouseInputlog_time_index
    on main0WarehouseInputlog (time);

create table main0WarehouseOutputSum
(
    logid         varchar(100) null,
    id            varchar(100) null,
    count_week    int          null,
    count_month   int          null,
    ifalert_week  tinyint(1)   null,
    ifalert_month tinyint(1)   null,
    time          varchar(100) null,
    category      varchar(100) null
);

create index main0WarehouseOutputSum_id_index
    on main0WarehouseOutputSum (id);

create index main0WarehouseOutputSum_logid_index
    on main0WarehouseOutputSum (logid);

create index main0WarehouseOutputSum_time_index
    on main0WarehouseOutputSum (time);

create table main1WarehouseInputlog
(
    logid       varchar(100) null,
    id          varchar(100) null,
    itemName    varchar(100) null,
    brand       varchar(100) null,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    time        varchar(100) null,
    category    varchar(100) null,
    action      varchar(100) null,
    `from`      varchar(100) null,
    `to`        varchar(100) null,
    ifComplete  tinyint(1)   null,
    ifConfirm   tinyint(1)   null
);

create index main1WarehouseInputlog_action_index
    on main1WarehouseInputlog (action);

create index main1WarehouseInputlog_id_index
    on main1WarehouseInputlog (id);

create index main1WarehouseInputlog_itemName_index
    on main1WarehouseInputlog (itemName);

create index main1WarehouseInputlog_logid_index
    on main1WarehouseInputlog (logid);

create index main1WarehouseInputlog_time_index
    on main1WarehouseInputlog (time);

create table main1WarehouseOutputSum
(
    logid         varchar(100) null,
    id            varchar(100) null,
    count_week    int          null,
    count_month   int          null,
    ifalert_week  tinyint(1)   null,
    ifalert_month tinyint(1)   null,
    time          varchar(100) null,
    category      varchar(100) null
);

create index main1WarehouseOutputSum_id_index
    on main1WarehouseOutputSum (id);

create index main1WarehouseOutputSum_logid_index
    on main1WarehouseOutputSum (logid);

create index main1WarehouseOutputSum_time_index
    on main1WarehouseOutputSum (time);

create table main2WarehouseInputlog
(
    logid       varchar(100) null,
    id          varchar(100) null,
    itemName    varchar(100) null,
    brand       varchar(100) null,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    time        varchar(100) null,
    category    varchar(100) null,
    action      varchar(100) null,
    `from`      varchar(100) null,
    `to`        varchar(100) null,
    ifComplete  tinyint(1)   null,
    ifConfirm   tinyint(1)   null
);

create index main2WarehouseInputlog_action_index
    on main2WarehouseInputlog (action);

create index main2WarehouseInputlog_id_index
    on main2WarehouseInputlog (id);

create index main2WarehouseInputlog_itemName_index
    on main2WarehouseInputlog (itemName);

create index main2WarehouseInputlog_logid_index
    on main2WarehouseInputlog (logid);

create index main2WarehouseInputlog_time_index
    on main2WarehouseInputlog (time);

create table main2WarehouseOutputSum
(
    logid         varchar(100) null,
    id            varchar(100) null,
    count_week    int          null,
    count_month   int          null,
    ifalert_week  tinyint(1)   null,
    ifalert_month tinyint(1)   null,
    time          varchar(100) null,
    category      varchar(100) null
);

create index main2WarehouseOutputSum_id_index
    on main2WarehouseOutputSum (id);

create index main2WarehouseOutputSum_logid_index
    on main2WarehouseOutputSum (logid);

create index main2WarehouseOutputSum_time_index
    on main2WarehouseOutputSum (time);

create table mainWarehouse0_commercialItem
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint mainWarehouse0_commercialItem_id_uindex
        unique (id)
);

create table mainWarehouse0_food
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint mainWarehouse0_food_id_uindex
        unique (id)
);

create table mainWarehouse0_others
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint mainWarehouse0_others_id_uindex
        unique (id)
);

create table mainWarehouse0_smallTool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint mainWarehouse0_smallTool_id_uindex
        unique (id)
);

create table mainWarehouse0_tool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint mainWarehouse0_tool_id_uindex
        unique (id)
);

create table mainWarehouse1_commercialItem
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint mainWarehouse1_commercialItem_id_uindex
        unique (id)
);

create table mainWarehouse1_food
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint mainWarehouse1_food_id_uindex
        unique (id)
);

create table mainWarehouse1_others
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint mainWarehouse1_others_id_uindex
        unique (id)
);

create table mainWarehouse1_smallTool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint mainWarehouse1_smallTool_id_uindex
        unique (id)
);

create table mainWarehouse1_tool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint mainWarehouse1_tool_id_uindex
        unique (id)
);

create table mainWarehouse2_commercialItem
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint mainWarehouse2_commercialItem_id_uindex
        unique (id)
);

create table mainWarehouse2_food
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint mainWarehouse2_food_id_uindex
        unique (id)
);

create table mainWarehouse2_others
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint mainWarehouse2_others_id_uindex
        unique (id)
);

create table mainWarehouse2_smallTool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint mainWarehouse2_smallTool_id_uindex
        unique (id)
);

create table mainWarehouse2_tool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint mainWarehouse2_tool_id_uindex
        unique (id)
);

create table purchaseItem
(
    logID          varchar(100) not null
        primary key,
    purchaseStatus varchar(30)  not null,
    shipID         varchar(100) null,
    purchaseTime   varchar(20)  null,
    purchaseMonth  varchar(10)  null,
    singlePrice    double       null,
    totalPrice     double       null,
    constraint purchaseItem_logID_uindex
        unique (logID)
);

create table realOfficeName
(
    nickname    varchar(100) null,
    realname    varchar(100) null,
    warehouseid varchar(10)  null,
    area        varchar(10)  null
);

create index realOfficeName_area_index
    on realOfficeName (area);

create index realOfficeName_nickname_index
    on realOfficeName (nickname);

create table realWarehouseName
(
    nickname    varchar(100) not null
        primary key,
    realname    varchar(100) null,
    warehouseid varchar(10)  null,
    area        varchar(10)  null,
    constraint realWarehouseName_nickname_uindex
        unique (nickname)
);

create index realWarehouseName_area_index
    on realWarehouseName (area);

create table receiveError
(
    logid      varchar(100) null,
    id         varchar(100) null,
    brand      varchar(100) null,
    itemCount  int          null,
    ifComplete tinyint(1)   null,
    category   varchar(100) null,
    location   varchar(10)  null,
    constraint receiveError_pk
        unique (logid),
    constraint receiveError_pk_2
        unique (id, logid),
    constraint receiveError_pk_3
        unique (location, category, ifComplete, logid)
);

create table shop10WarehouseInputlog
(
    logid       varchar(100) null,
    id          varchar(100) null,
    itemName    varchar(100) null,
    brand       varchar(100) null,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    time        varchar(100) null,
    category    varchar(100) null,
    action      varchar(100) null,
    `from`      varchar(100) null,
    `to`        varchar(100) null,
    ifComplete  tinyint(1)   null,
    ifConfirm   tinyint(1)   null
);

create index shop10WarehouseInputlog_action_index
    on shop10WarehouseInputlog (action);

create index shop10WarehouseInputlog_id_index
    on shop10WarehouseInputlog (id);

create index shop10WarehouseInputlog_itemName_index
    on shop10WarehouseInputlog (itemName);

create index shop10WarehouseInputlog_logid_index
    on shop10WarehouseInputlog (logid);

create index shop10WarehouseInputlog_time_index
    on shop10WarehouseInputlog (time);

create table shop10WarehouseOutputSum
(
    logid         varchar(100) null,
    id            varchar(100) null,
    count_week    int          null,
    count_month   int          null,
    ifalert_week  tinyint(1)   null,
    ifalert_month tinyint(1)   null,
    time          varchar(100) null,
    category      varchar(100) null
);

create index shop10WarehouseOutputSum_id_index
    on shop10WarehouseOutputSum (id);

create index shop10WarehouseOutputSum_logid_index
    on shop10WarehouseOutputSum (logid);

create index shop10WarehouseOutputSum_time_index
    on shop10WarehouseOutputSum (time);

create table shop11WarehouseInputlog
(
    logid       varchar(100) null,
    id          varchar(100) null,
    itemName    varchar(100) null,
    brand       varchar(100) null,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    time        varchar(100) null,
    category    varchar(100) null,
    action      varchar(100) null,
    `from`      varchar(100) null,
    `to`        varchar(100) null,
    ifComplete  tinyint(1)   null,
    ifConfirm   tinyint(1)   null
);

create index shop11WarehouseInputlog_action_index
    on shop11WarehouseInputlog (action);

create index shop11WarehouseInputlog_id_index
    on shop11WarehouseInputlog (id);

create index shop11WarehouseInputlog_itemName_index
    on shop11WarehouseInputlog (itemName);

create index shop11WarehouseInputlog_logid_index
    on shop11WarehouseInputlog (logid);

create index shop11WarehouseInputlog_time_index
    on shop11WarehouseInputlog (time);

create table shop11WarehouseOutputSum
(
    logid         varchar(100) null,
    id            varchar(100) null,
    count_week    int          null,
    count_month   int          null,
    ifalert_week  tinyint(1)   null,
    ifalert_month tinyint(1)   null,
    time          varchar(100) null,
    category      varchar(100) null
);

create index shop11WarehouseOutputSum_id_index
    on shop11WarehouseOutputSum (id);

create index shop11WarehouseOutputSum_logid_index
    on shop11WarehouseOutputSum (logid);

create index shop11WarehouseOutputSum_time_index
    on shop11WarehouseOutputSum (time);

create table shop12WarehouseInputlog
(
    logid       varchar(100) null,
    id          varchar(100) null,
    itemName    varchar(100) null,
    brand       varchar(100) null,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    time        varchar(100) null,
    category    varchar(100) null,
    action      varchar(100) null,
    `from`      varchar(100) null,
    `to`        varchar(100) null,
    ifComplete  tinyint(1)   null,
    ifConfirm   tinyint(1)   null
);

create index shop12WarehouseInputlog_action_index
    on shop12WarehouseInputlog (action);

create index shop12WarehouseInputlog_id_index
    on shop12WarehouseInputlog (id);

create index shop12WarehouseInputlog_itemName_index
    on shop12WarehouseInputlog (itemName);

create index shop12WarehouseInputlog_logid_index
    on shop12WarehouseInputlog (logid);

create index shop12WarehouseInputlog_time_index
    on shop12WarehouseInputlog (time);

create table shop12WarehouseOutputSum
(
    logid         varchar(100) null,
    id            varchar(100) null,
    count_week    int          null,
    count_month   int          null,
    ifalert_week  tinyint(1)   null,
    ifalert_month tinyint(1)   null,
    time          varchar(100) null,
    category      varchar(100) null
);

create index shop12WarehouseOutputSum_id_index
    on shop12WarehouseOutputSum (id);

create index shop12WarehouseOutputSum_logid_index
    on shop12WarehouseOutputSum (logid);

create index shop12WarehouseOutputSum_time_index
    on shop12WarehouseOutputSum (time);

create table shop13WarehouseInputlog
(
    logid       varchar(100) null,
    id          varchar(100) null,
    itemName    varchar(100) null,
    brand       varchar(100) null,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    time        varchar(100) null,
    category    varchar(100) null,
    action      varchar(100) null,
    `from`      varchar(100) null,
    `to`        varchar(100) null,
    ifComplete  tinyint(1)   null,
    ifConfirm   tinyint(1)   null
);

create index shop13WarehouseInputlog_action_index
    on shop13WarehouseInputlog (action);

create index shop13WarehouseInputlog_id_index
    on shop13WarehouseInputlog (id);

create index shop13WarehouseInputlog_itemName_index
    on shop13WarehouseInputlog (itemName);

create index shop13WarehouseInputlog_logid_index
    on shop13WarehouseInputlog (logid);

create index shop13WarehouseInputlog_time_index
    on shop13WarehouseInputlog (time);

create table shop13WarehouseOutputSum
(
    logid         varchar(100) null,
    id            varchar(100) null,
    count_week    int          null,
    count_month   int          null,
    ifalert_week  tinyint(1)   null,
    ifalert_month tinyint(1)   null,
    time          varchar(100) null,
    category      varchar(100) null
);

create index shop13WarehouseOutputSum_id_index
    on shop13WarehouseOutputSum (id);

create index shop13WarehouseOutputSum_logid_index
    on shop13WarehouseOutputSum (logid);

create index shop13WarehouseOutputSum_time_index
    on shop13WarehouseOutputSum (time);

create table shop14WarehouseInputlog
(
    logid       varchar(100) null,
    id          varchar(100) null,
    itemName    varchar(100) null,
    brand       varchar(100) null,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    time        varchar(100) null,
    category    varchar(100) null,
    action      varchar(100) null,
    `from`      varchar(100) null,
    `to`        varchar(100) null,
    ifComplete  tinyint(1)   null,
    ifConfirm   tinyint(1)   null
);

create index shop14WarehouseInputlog_action_index
    on shop14WarehouseInputlog (action);

create index shop14WarehouseInputlog_id_index
    on shop14WarehouseInputlog (id);

create index shop14WarehouseInputlog_itemName_index
    on shop14WarehouseInputlog (itemName);

create index shop14WarehouseInputlog_logid_index
    on shop14WarehouseInputlog (logid);

create index shop14WarehouseInputlog_time_index
    on shop14WarehouseInputlog (time);

create table shop14WarehouseOutputSum
(
    logid         varchar(100) null,
    id            varchar(100) null,
    count_week    int          null,
    count_month   int          null,
    ifalert_week  tinyint(1)   null,
    ifalert_month tinyint(1)   null,
    time          varchar(100) null,
    category      varchar(100) null
);

create index shop14WarehouseOutputSum_id_index
    on shop14WarehouseOutputSum (id);

create index shop14WarehouseOutputSum_logid_index
    on shop14WarehouseOutputSum (logid);

create index shop14WarehouseOutputSum_time_index
    on shop14WarehouseOutputSum (time);

create table shop1WarehouseInputlog
(
    logid       varchar(100) null,
    id          varchar(100) null,
    itemName    varchar(100) null,
    brand       varchar(100) null,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    time        varchar(100) null,
    category    varchar(100) null,
    action      varchar(100) null,
    `from`      varchar(100) null,
    `to`        varchar(100) null,
    ifComplete  tinyint(1)   null,
    ifConfirm   tinyint(1)   null
);

create index shop1WarehouseInputlog_action_index
    on shop1WarehouseInputlog (action);

create index shop1WarehouseInputlog_id_index
    on shop1WarehouseInputlog (id);

create index shop1WarehouseInputlog_itemName_index
    on shop1WarehouseInputlog (itemName);

create index shop1WarehouseInputlog_logid_index
    on shop1WarehouseInputlog (logid);

create index shop1WarehouseInputlog_time_index
    on shop1WarehouseInputlog (time);

create table shop1WarehouseOutputSum
(
    logid         varchar(100) null,
    id            varchar(100) null,
    count_week    int          null,
    count_month   int          null,
    ifalert_week  tinyint(1)   null,
    ifalert_month tinyint(1)   null,
    time          varchar(100) null,
    category      varchar(100) null
);

create index shop1WarehouseOutputSum_id_index
    on shop1WarehouseOutputSum (id);

create index shop1WarehouseOutputSum_logid_index
    on shop1WarehouseOutputSum (logid);

create index shop1WarehouseOutputSum_time_index
    on shop1WarehouseOutputSum (time);

create table shop2WarehouseInputlog
(
    logid       varchar(100) null,
    id          varchar(100) null,
    itemName    varchar(100) null,
    brand       varchar(100) null,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    time        varchar(100) null,
    category    varchar(100) null,
    action      varchar(100) null,
    `from`      varchar(100) null,
    `to`        varchar(100) null,
    ifComplete  tinyint(1)   null,
    ifConfirm   tinyint(1)   null
);

create index shop2WarehouseInputlog_action_index
    on shop2WarehouseInputlog (action);

create index shop2WarehouseInputlog_id_index
    on shop2WarehouseInputlog (id);

create index shop2WarehouseInputlog_itemName_index
    on shop2WarehouseInputlog (itemName);

create index shop2WarehouseInputlog_logid_index
    on shop2WarehouseInputlog (logid);

create index shop2WarehouseInputlog_time_index
    on shop2WarehouseInputlog (time);

create table shop2WarehouseOutputSum
(
    logid         varchar(100) null,
    id            varchar(100) null,
    count_week    int          null,
    count_month   int          null,
    ifalert_week  tinyint(1)   null,
    ifalert_month tinyint(1)   null,
    time          varchar(100) null,
    category      varchar(100) null
);

create index shop2WarehouseOutputSum_id_index
    on shop2WarehouseOutputSum (id);

create index shop2WarehouseOutputSum_logid_index
    on shop2WarehouseOutputSum (logid);

create index shop2WarehouseOutputSum_time_index
    on shop2WarehouseOutputSum (time);

create table shop3WarehouseInputlog
(
    logid       varchar(100) null,
    id          varchar(100) null,
    itemName    varchar(100) null,
    brand       varchar(100) null,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    time        varchar(100) null,
    category    varchar(100) null,
    action      varchar(100) null,
    `from`      varchar(100) null,
    `to`        varchar(100) null,
    ifComplete  tinyint(1)   null,
    ifConfirm   tinyint(1)   null
);

create index shop3WarehouseInputlog_action_index
    on shop3WarehouseInputlog (action);

create index shop3WarehouseInputlog_id_index
    on shop3WarehouseInputlog (id);

create index shop3WarehouseInputlog_itemName_index
    on shop3WarehouseInputlog (itemName);

create index shop3WarehouseInputlog_logid_index
    on shop3WarehouseInputlog (logid);

create index shop3WarehouseInputlog_time_index
    on shop3WarehouseInputlog (time);

create table shop3WarehouseOutputSum
(
    logid         varchar(100) null,
    id            varchar(100) null,
    count_week    int          null,
    count_month   int          null,
    ifalert_week  tinyint(1)   null,
    ifalert_month tinyint(1)   null,
    time          varchar(100) null,
    category      varchar(100) null
);

create index shop3WarehouseOutputSum_id_index
    on shop3WarehouseOutputSum (id);

create index shop3WarehouseOutputSum_logid_index
    on shop3WarehouseOutputSum (logid);

create index shop3WarehouseOutputSum_time_index
    on shop3WarehouseOutputSum (time);

create table shop4WarehouseInputlog
(
    logid       varchar(100) null,
    id          varchar(100) null,
    itemName    varchar(100) null,
    brand       varchar(100) null,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    time        varchar(100) null,
    category    varchar(100) null,
    action      varchar(100) null,
    `from`      varchar(100) null,
    `to`        varchar(100) null,
    ifComplete  tinyint(1)   null,
    ifConfirm   tinyint(1)   null
);

create index shop4WarehouseInputlog_action_index
    on shop4WarehouseInputlog (action);

create index shop4WarehouseInputlog_id_index
    on shop4WarehouseInputlog (id);

create index shop4WarehouseInputlog_itemName_index
    on shop4WarehouseInputlog (itemName);

create index shop4WarehouseInputlog_logid_index
    on shop4WarehouseInputlog (logid);

create index shop4WarehouseInputlog_time_index
    on shop4WarehouseInputlog (time);

create table shop4WarehouseOutputSum
(
    logid         varchar(100) null,
    id            varchar(100) null,
    count_week    int          null,
    count_month   int          null,
    ifalert_week  tinyint(1)   null,
    ifalert_month tinyint(1)   null,
    time          varchar(100) null,
    category      varchar(100) null
);

create index shop4WarehouseOutputSum_id_index
    on shop4WarehouseOutputSum (id);

create index shop4WarehouseOutputSum_logid_index
    on shop4WarehouseOutputSum (logid);

create index shop4WarehouseOutputSum_time_index
    on shop4WarehouseOutputSum (time);

create table shop5WarehouseInputlog
(
    logid       varchar(100) null,
    id          varchar(100) null,
    itemName    varchar(100) null,
    brand       varchar(100) null,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    time        varchar(100) null,
    category    varchar(100) null,
    action      varchar(100) null,
    `from`      varchar(100) null,
    `to`        varchar(100) null,
    ifComplete  tinyint(1)   null,
    ifConfirm   tinyint(1)   null
);

create index shop5WarehouseInputlog_action_index
    on shop5WarehouseInputlog (action);

create index shop5WarehouseInputlog_id_index
    on shop5WarehouseInputlog (id);

create index shop5WarehouseInputlog_itemName_index
    on shop5WarehouseInputlog (itemName);

create index shop5WarehouseInputlog_logid_index
    on shop5WarehouseInputlog (logid);

create index shop5WarehouseInputlog_time_index
    on shop5WarehouseInputlog (time);

create table shop5WarehouseOutputSum
(
    logid         varchar(100) null,
    id            varchar(100) null,
    count_week    int          null,
    count_month   int          null,
    ifalert_week  tinyint(1)   null,
    ifalert_month tinyint(1)   null,
    time          varchar(100) null,
    category      varchar(100) null
);

create index shop5WarehouseOutputSum_id_index
    on shop5WarehouseOutputSum (id);

create index shop5WarehouseOutputSum_logid_index
    on shop5WarehouseOutputSum (logid);

create index shop5WarehouseOutputSum_time_index
    on shop5WarehouseOutputSum (time);

create table shop6WarehouseInputlog
(
    logid       varchar(100) null,
    id          varchar(100) null,
    itemName    varchar(100) null,
    brand       varchar(100) null,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    time        varchar(100) null,
    category    varchar(100) null,
    action      varchar(100) null,
    `from`      varchar(100) null,
    `to`        varchar(100) null,
    ifComplete  tinyint(1)   null,
    ifConfirm   tinyint(1)   null
);

create index shop6WarehouseInputlog_action_index
    on shop6WarehouseInputlog (action);

create index shop6WarehouseInputlog_id_index
    on shop6WarehouseInputlog (id);

create index shop6WarehouseInputlog_itemName_index
    on shop6WarehouseInputlog (itemName);

create index shop6WarehouseInputlog_logid_index
    on shop6WarehouseInputlog (logid);

create index shop6WarehouseInputlog_time_index
    on shop6WarehouseInputlog (time);

create table shop6WarehouseOutputSum
(
    logid         varchar(100) null,
    id            varchar(100) null,
    count_week    int          null,
    count_month   int          null,
    ifalert_week  tinyint(1)   null,
    ifalert_month tinyint(1)   null,
    time          varchar(100) null,
    category      varchar(100) null
);

create index shop6WarehouseOutputSum_id_index
    on shop6WarehouseOutputSum (id);

create index shop6WarehouseOutputSum_logid_index
    on shop6WarehouseOutputSum (logid);

create index shop6WarehouseOutputSum_time_index
    on shop6WarehouseOutputSum (time);

create table shop7WarehouseInputlog
(
    logid       varchar(100) null,
    id          varchar(100) null,
    itemName    varchar(100) null,
    brand       varchar(100) null,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    time        varchar(100) null,
    category    varchar(100) null,
    action      varchar(100) null,
    `from`      varchar(100) null,
    `to`        varchar(100) null,
    ifComplete  tinyint(1)   null,
    ifConfirm   tinyint(1)   null
);

create index shop7WarehouseInputlog_action_index
    on shop7WarehouseInputlog (action);

create index shop7WarehouseInputlog_id_index
    on shop7WarehouseInputlog (id);

create index shop7WarehouseInputlog_itemName_index
    on shop7WarehouseInputlog (itemName);

create index shop7WarehouseInputlog_logid_index
    on shop7WarehouseInputlog (logid);

create index shop7WarehouseInputlog_time_index
    on shop7WarehouseInputlog (time);

create table shop7WarehouseOutputSum
(
    logid         varchar(100) null,
    id            varchar(100) null,
    count_week    int          null,
    count_month   int          null,
    ifalert_week  tinyint(1)   null,
    ifalert_month tinyint(1)   null,
    time          varchar(100) null,
    category      varchar(100) null
);

create index shop7WarehouseOutputSum_id_index
    on shop7WarehouseOutputSum (id);

create index shop7WarehouseOutputSum_logid_index
    on shop7WarehouseOutputSum (logid);

create index shop7WarehouseOutputSum_time_index
    on shop7WarehouseOutputSum (time);

create table shop8WarehouseInputlog
(
    logid       varchar(100) null,
    id          varchar(100) null,
    itemName    varchar(100) null,
    brand       varchar(100) null,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    time        varchar(100) null,
    category    varchar(100) null,
    action      varchar(100) null,
    `from`      varchar(100) null,
    `to`        varchar(100) null,
    ifComplete  tinyint(1)   null,
    ifConfirm   tinyint(1)   null
);

create index shop8WarehouseInputlog_action_index
    on shop8WarehouseInputlog (action);

create index shop8WarehouseInputlog_id_index
    on shop8WarehouseInputlog (id);

create index shop8WarehouseInputlog_itemName_index
    on shop8WarehouseInputlog (itemName);

create index shop8WarehouseInputlog_logid_index
    on shop8WarehouseInputlog (logid);

create index shop8WarehouseInputlog_time_index
    on shop8WarehouseInputlog (time);

create table shop8WarehouseOutputSum
(
    logid         varchar(100) null,
    id            varchar(100) null,
    count_week    int          null,
    count_month   int          null,
    ifalert_week  tinyint(1)   null,
    ifalert_month tinyint(1)   null,
    time          varchar(100) null,
    category      varchar(100) null
);

create index shop8WarehouseOutputSum_id_index
    on shop8WarehouseOutputSum (id);

create index shop8WarehouseOutputSum_logid_index
    on shop8WarehouseOutputSum (logid);

create index shop8WarehouseOutputSum_time_index
    on shop8WarehouseOutputSum (time);

create table shop9WarehouseInputlog
(
    logid       varchar(100) null,
    id          varchar(100) null,
    itemName    varchar(100) null,
    brand       varchar(100) null,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    time        varchar(100) null,
    category    varchar(100) null,
    action      varchar(100) null,
    `from`      varchar(100) null,
    `to`        varchar(100) null,
    ifComplete  tinyint(1)   null,
    ifConfirm   tinyint(1)   null
);

create index shop9WarehouseInputlog_action_index
    on shop9WarehouseInputlog (action);

create index shop9WarehouseInputlog_id_index
    on shop9WarehouseInputlog (id);

create index shop9WarehouseInputlog_itemName_index
    on shop9WarehouseInputlog (itemName);

create index shop9WarehouseInputlog_logid_index
    on shop9WarehouseInputlog (logid);

create index shop9WarehouseInputlog_time_index
    on shop9WarehouseInputlog (time);

create table shop9WarehouseOutputSum
(
    logid         varchar(100) null,
    id            varchar(100) null,
    count_week    int          null,
    count_month   int          null,
    ifalert_week  tinyint(1)   null,
    ifalert_month tinyint(1)   null,
    time          varchar(100) null,
    category      varchar(100) null
);

create index shop9WarehouseOutputSum_id_index
    on shop9WarehouseOutputSum (id);

create index shop9WarehouseOutputSum_logid_index
    on shop9WarehouseOutputSum (logid);

create index shop9WarehouseOutputSum_time_index
    on shop9WarehouseOutputSum (time);

create table shopWarehouse10_commercialItem
(
    id          varchar(100) null,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null
);

create index shopWarehouse10_commercialItem_id_index
    on shopWarehouse10_commercialItem (id);

create table shopWarehouse10_food
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse10_food_id_uindex
        unique (id)
);

create table shopWarehouse10_others
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse10_others_id_uindex
        unique (id)
);

create table shopWarehouse10_smallTool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse10_smallTool_id_uindex
        unique (id)
);

create table shopWarehouse10_tool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse10_tool_id_uindex
        unique (id)
);

create table shopWarehouse11_commercialItem
(
    id          varchar(100) null,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null
);

create index shopWarehouse11_commercialItem_id_index
    on shopWarehouse11_commercialItem (id);

create table shopWarehouse11_food
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse11_food_id_uindex
        unique (id)
);

create table shopWarehouse11_others
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse11_others_id_uindex
        unique (id)
);

create table shopWarehouse11_smallTool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse11_smallTool_id_uindex
        unique (id)
);

create table shopWarehouse11_tool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse11_tool_id_uindex
        unique (id)
);

create table shopWarehouse12_commercialItem
(
    id          varchar(100) null,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null
);

create index shopWarehouse12_commercialItem_id_index
    on shopWarehouse12_commercialItem (id);

create table shopWarehouse12_food
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse12_food_id_uindex
        unique (id)
);

create table shopWarehouse12_others
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse12_others_id_uindex
        unique (id)
);

create table shopWarehouse12_smallTool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse12_smallTool_id_uindex
        unique (id)
);

create table shopWarehouse12_tool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse12_tool_id_uindex
        unique (id)
);

create table shopWarehouse13_commercialItem
(
    id          varchar(100) null,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null
);

create index shopWarehouse13_commercialItem_id_index
    on shopWarehouse13_commercialItem (id);

create table shopWarehouse13_food
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse13_food_id_uindex
        unique (id)
);

create table shopWarehouse13_others
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse13_others_id_uindex
        unique (id)
);

create table shopWarehouse13_smallTool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse13_smallTool_id_uindex
        unique (id)
);

create table shopWarehouse13_tool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse13_tool_id_uindex
        unique (id)
);

create table shopWarehouse14_commercialItem
(
    id          varchar(100) null,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null
);

create index shopWarehouse14_commercialItem_id_index
    on shopWarehouse14_commercialItem (id);

create table shopWarehouse14_food
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse14_food_id_uindex
        unique (id)
);

create table shopWarehouse14_others
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse14_others_id_uindex
        unique (id)
);

create table shopWarehouse14_smallTool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse14_smallTool_id_uindex
        unique (id)
);

create table shopWarehouse14_tool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse14_tool_id_uindex
        unique (id)
);

create table shopWarehouse1_commercialItem
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse1_commercialItem_id_uindex
        unique (id)
);

create table shopWarehouse1_food
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse1_food_id_uindex
        unique (id)
);

create table shopWarehouse1_others
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse1_others_id_uindex
        unique (id)
);

create table shopWarehouse1_smallTool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse1_smallTool_id_uindex
        unique (id)
);

create table shopWarehouse1_tool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse1_tool_id_uindex
        unique (id)
);

create table shopWarehouse2_commercialItem
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse2_commercialItem_id_uindex
        unique (id)
);

create table shopWarehouse2_food
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse2_food_id_uindex
        unique (id)
);

create table shopWarehouse2_others
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse2_others_id_uindex
        unique (id)
);

create table shopWarehouse2_smallTool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse2_smallTool_id_uindex
        unique (id)
);

create table shopWarehouse2_tool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse2_tool_id_uindex
        unique (id)
);

create table shopWarehouse3_commercialItem
(
    id          varchar(100) null,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null
);

create index shopWarehouse3_commercialItem_id_index
    on shopWarehouse3_commercialItem (id);

create table shopWarehouse3_food
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse3_food_id_uindex
        unique (id)
);

create table shopWarehouse3_others
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse3_others_id_uindex
        unique (id)
);

create table shopWarehouse3_smallTool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse3_smallTool_id_uindex
        unique (id)
);

create table shopWarehouse3_tool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse3_tool_id_uindex
        unique (id)
);

create table shopWarehouse4_commercialItem
(
    id          varchar(100) null,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null
);

create index shopWarehouse4_commercialItem_id_index
    on shopWarehouse4_commercialItem (id);

create table shopWarehouse4_food
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse4_food_id_uindex
        unique (id)
);

create table shopWarehouse4_others
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse4_others_id_uindex
        unique (id)
);

create table shopWarehouse4_smallTool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse4_smallTool_id_uindex
        unique (id)
);

create table shopWarehouse4_tool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse4_tool_id_uindex
        unique (id)
);

create table shopWarehouse5_commercialItem
(
    id          varchar(100) null,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null
);

create index shopWarehouse5_commercialItem_id_index
    on shopWarehouse5_commercialItem (id);

create table shopWarehouse5_food
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse5_food_id_uindex
        unique (id)
);

create table shopWarehouse5_others
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse5_others_id_uindex
        unique (id)
);

create table shopWarehouse5_smallTool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse5_smallTool_id_uindex
        unique (id)
);

create table shopWarehouse5_tool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse5_tool_id_uindex
        unique (id)
);

create table shopWarehouse6_commercialItem
(
    id          varchar(100) null,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null
);

create index shopWarehouse6_commercialItem_id_index
    on shopWarehouse6_commercialItem (id);

create table shopWarehouse6_food
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse6_food_id_uindex
        unique (id)
);

create table shopWarehouse6_others
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse6_others_id_uindex
        unique (id)
);

create table shopWarehouse6_smallTool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse6_smallTool_id_uindex
        unique (id)
);

create table shopWarehouse6_tool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse6_tool_id_uindex
        unique (id)
);

create table shopWarehouse7_commercialItem
(
    id          varchar(100) null,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null
);

create index shopWarehouse7_commercialItem_id_index
    on shopWarehouse7_commercialItem (id);

create table shopWarehouse7_food
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse7_food_id_uindex
        unique (id)
);

create table shopWarehouse7_others
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse7_others_id_uindex
        unique (id)
);

create table shopWarehouse7_smallTool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse7_smallTool_id_uindex
        unique (id)
);

create table shopWarehouse7_tool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse7_tool_id_uindex
        unique (id)
);

create table shopWarehouse8_commercialItem
(
    id          varchar(100) null,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null
);

create index shopWarehouse8_commercialItem_id_index
    on shopWarehouse8_commercialItem (id);

create table shopWarehouse8_food
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse8_food_id_uindex
        unique (id)
);

create table shopWarehouse8_others
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse8_others_id_uindex
        unique (id)
);

create table shopWarehouse8_smallTool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse8_smallTool_id_uindex
        unique (id)
);

create table shopWarehouse8_tool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse8_tool_id_uindex
        unique (id)
);

create table shopWarehouse9_commercialItem
(
    id          varchar(100) null,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null
);

create index shopWarehouse9_commercialItem_id_index
    on shopWarehouse9_commercialItem (id);

create table shopWarehouse9_food
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse9_food_id_uindex
        unique (id)
);

create table shopWarehouse9_others
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse9_others_id_uindex
        unique (id)
);

create table shopWarehouse9_smallTool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse9_smallTool_id_uindex
        unique (id)
);

create table shopWarehouse9_tool
(
    id          varchar(100) not null
        primary key,
    itemCount   int          null,
    singlePrice double       null,
    totalPrice  double       null,
    memo        varchar(100) null,
    constraint shopWarehouse9_tool_id_uindex
        unique (id)
);

create table supplier
(
    supplierID   varchar(100) not null
        primary key,
    supplierName varchar(100) null,
    supply_area  varchar(100) null,
    payCheck_way varchar(100) null,
    pay_way      varchar(100) null,
    constraint supplier_id_uindex
        unique (supplierID)
);

create index supplier_supplierName_index
    on supplier (supplierName);

create index supplier_supply_area_index
    on supplier (supply_area);

create table ticket
(
    id        varchar(100) not null
        primary key,
    ifConfirm tinyint(1)   not null,
    store     varchar(10)  null,
    constraint id
        unique (id)
);

create index ticket_store_ifConfirm_index
    on ticket (store, ifConfirm);

create table user
(
    uname varchar(100) null,
    upwd  varchar(100) null,
    level int          null
);

create index user_uname_index
    on user (uname);













-- MySQL dump 10.13  Distrib 8.1.0, for macos13 (arm64)
--
-- Host: 127.0.0.1    Database: vinvin
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `applyFinanceConfirm`
--

DROP TABLE IF EXISTS `applyFinanceConfirm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `applyFinanceConfirm` (
                                       `logID` varchar(100) NOT NULL,
                                       `confirmResult` tinyint(1) DEFAULT NULL,
                                       PRIMARY KEY (`logID`),
                                       UNIQUE KEY `applyFinanceConfirm_logID_uindex` (`logID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applyFinanceConfirm`
--

LOCK TABLES `applyFinanceConfirm` WRITE;
/*!40000 ALTER TABLE `applyFinanceConfirm` DISABLE KEYS */;
/*!40000 ALTER TABLE `applyFinanceConfirm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `applyItem`
--

DROP TABLE IF EXISTS `applyItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `applyItem` (
                             `logID` varchar(100) NOT NULL,
                             `applyTime` varchar(10) DEFAULT NULL,
                             `location` varchar(10) DEFAULT NULL,
                             `itemID` varchar(100) DEFAULT NULL,
                             `itemName` varchar(100) DEFAULT NULL,
                             `count` int DEFAULT NULL,
                             `applyName` varchar(100) DEFAULT NULL,
                             `month` varchar(10) DEFAULT NULL,
                             PRIMARY KEY (`logID`),
                             UNIQUE KEY `applyItem_logID_uindex` (`logID`),
                             KEY `applyItem_location_index` (`location`),
                             KEY `applyItem_month_index` (`month`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applyItem`
--

LOCK TABLES `applyItem` WRITE;
/*!40000 ALTER TABLE `applyItem` DISABLE KEYS */;
INSERT INTO `applyItem` VALUES ('5711bbf969c04eea9d8795f8b6730750','2023-10-26','main0','e041930b1dbe4883b1fd0df5aaa1ca31','qqq',1,'vinvin1','2023-10');
/*!40000 ALTER TABLE `applyItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `applyItemConfirm`
--

DROP TABLE IF EXISTS `applyItemConfirm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `applyItemConfirm` (
                                    `logID` varchar(100) NOT NULL,
                                    `confirm_area` tinyint(1) DEFAULT NULL,
                                    `confirm_area_date` varchar(20) DEFAULT NULL,
                                    `confirm_center` tinyint(1) DEFAULT NULL,
                                    `confirm_center_date` varchar(20) DEFAULT NULL,
                                    `purchase_check` tinyint(1) DEFAULT NULL,
                                    `purchase_check_date` varchar(20) DEFAULT NULL,
                                    `confirm_finance` tinyint(1) DEFAULT NULL,
                                    `confirm_finance_date` varchar(20) DEFAULT NULL,
                                    `purchase` tinyint(1) DEFAULT NULL,
                                    `purchase_date` varchar(20) DEFAULT NULL,
                                    PRIMARY KEY (`logID`),
                                    UNIQUE KEY `applyItemConfirm_logID_uindex` (`logID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applyItemConfirm`
--

LOCK TABLES `applyItemConfirm` WRITE;
/*!40000 ALTER TABLE `applyItemConfirm` DISABLE KEYS */;
INSERT INTO `applyItemConfirm` VALUES ('5711bbf969c04eea9d8795f8b6730750',1,'2023-10-26 17:45:24',1,'2023-10-26 17:45:33',NULL,NULL,1,'2023-10-26 17:45:36',NULL,NULL);
/*!40000 ALTER TABLE `applyItemConfirm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `applyItemSec`
--

DROP TABLE IF EXISTS `applyItemSec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `applyItemSec` (
                                `id` varchar(100) NOT NULL,
                                `month` varchar(10) DEFAULT NULL,
                                `store` varchar(10) DEFAULT NULL,
                                `totalPrice` double DEFAULT NULL,
                                PRIMARY KEY (`id`),
                                UNIQUE KEY `applyItemSec_id_uindex` (`id`),
                                KEY `applyItemSec_month_store_index` (`month`,`store`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applyItemSec`
--

LOCK TABLES `applyItemSec` WRITE;
/*!40000 ALTER TABLE `applyItemSec` DISABLE KEYS */;
/*!40000 ALTER TABLE `applyItemSec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `confirmStatusTrans`
--

DROP TABLE IF EXISTS `confirmStatusTrans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `confirmStatusTrans` (
                                      `statusEN` varchar(30) NOT NULL,
                                      `statusCH` varchar(30) NOT NULL,
                                      PRIMARY KEY (`statusEN`),
                                      UNIQUE KEY `confirmStatusTrans_statusCH_uindex` (`statusCH`),
                                      UNIQUE KEY `confirmStatusTrans_statusEN_uindex` (`statusEN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `confirmStatusTrans`
--

LOCK TABLES `confirmStatusTrans` WRITE;
/*!40000 ALTER TABLE `confirmStatusTrans` DISABLE KEYS */;
/*!40000 ALTER TABLE `confirmStatusTrans` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dailyMoneyReport`
--

DROP TABLE IF EXISTS `dailyMoneyReport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dailyMoneyReport` (
                                    `reportLog` varchar(100) NOT NULL,
                                    `orderSum` double DEFAULT NULL,
                                    `orderCount` int DEFAULT NULL,
                                    `orderAvgPrice` double DEFAULT NULL,
                                    `sellCount` int DEFAULT NULL,
                                    `categorySumData` text,
                                    `warehouse` varchar(100) DEFAULT NULL,
                                    `time` varchar(100) DEFAULT NULL,
                                    PRIMARY KEY (`reportLog`),
                                    UNIQUE KEY `dailyMoneyReport_reportLog_uindex` (`reportLog`),
                                    KEY `dailyMoneyReport_reportLog_index` (`reportLog`),
                                    KEY `dailyMoneyReport_time_warehouse_index` (`time`,`warehouse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dailyMoneyReport`
--

LOCK TABLES `dailyMoneyReport` WRITE;
/*!40000 ALTER TABLE `dailyMoneyReport` DISABLE KEYS */;
/*!40000 ALTER TABLE `dailyMoneyReport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dumpItem`
--

DROP TABLE IF EXISTS `dumpItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dumpItem` (
                            `logid` varchar(100) DEFAULT NULL,
                            `id` varchar(100) DEFAULT NULL,
                            `brand` varchar(10) DEFAULT NULL,
                            `itemCount` int DEFAULT NULL,
                            `expiredDate` varchar(10) DEFAULT NULL,
                            `howLong` varchar(100) DEFAULT NULL,
                            `reason` varchar(100) DEFAULT NULL,
                            `dumptime` varchar(100) DEFAULT NULL,
                            `action` varchar(10) DEFAULT NULL,
                            `location` varchar(10) DEFAULT NULL,
                            `category` varchar(10) DEFAULT NULL,
                            `memo` varchar(100) DEFAULT NULL,
                            `if_pass` tinyint(1) DEFAULT NULL,
                            `status` varchar(20) DEFAULT NULL,
                            UNIQUE KEY `dumpItem_logid_uindex` (`logid`),
                            KEY `dumpItem_id_index` (`id`),
                            KEY `dumpItem_location_category_index` (`location`,`category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dumpItem`
--

LOCK TABLES `dumpItem` WRITE;
/*!40000 ALTER TABLE `dumpItem` DISABLE KEYS */;
/*!40000 ALTER TABLE `dumpItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `filetype`
--

DROP TABLE IF EXISTS `filetype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `filetype` (
                            `id` varchar(100) DEFAULT NULL,
                            `filepath` varchar(100) DEFAULT NULL,
                            UNIQUE KEY `filetype_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filetype`
--

LOCK TABLES `filetype` WRITE;
/*!40000 ALTER TABLE `filetype` DISABLE KEYS */;
/*!40000 ALTER TABLE `filetype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fruitInvoice`
--

DROP TABLE IF EXISTS `fruitInvoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fruitInvoice` (
                                `invoiceid` varchar(100) DEFAULT NULL,
                                `time` varchar(10) DEFAULT NULL,
                                `location` varchar(10) DEFAULT NULL,
                                `supplier` varchar(100) DEFAULT NULL,
                                `invoiceTime` varchar(100) DEFAULT NULL,
                                `price` double DEFAULT NULL,
                                `memo` varchar(100) DEFAULT NULL,
                                `month` varchar(10) NOT NULL,
                                UNIQUE KEY `fruitInvoice_invoiceid_uindex` (`invoiceid`),
                                KEY `fruitInvoice_location_index` (`location`),
                                KEY `fruitInvoice_month_index` (`month`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fruitInvoice`
--

LOCK TABLES `fruitInvoice` WRITE;
/*!40000 ALTER TABLE `fruitInvoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `fruitInvoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fruitInvoiceSec`
--

DROP TABLE IF EXISTS `fruitInvoiceSec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fruitInvoiceSec` (
                                   `id` varchar(100) NOT NULL,
                                   `month` varchar(10) NOT NULL,
                                   `store` varchar(100) NOT NULL,
                                   `supplier` varchar(100) NOT NULL,
                                   `totalPrice` double NOT NULL,
                                   PRIMARY KEY (`id`),
                                   UNIQUE KEY `fruitInvoiceSec_id_uindex` (`id`),
                                   KEY `fruitInvoiceSec_month_index` (`month`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fruitInvoiceSec`
--

LOCK TABLES `fruitInvoiceSec` WRITE;
/*!40000 ALTER TABLE `fruitInvoiceSec` DISABLE KEYS */;
/*!40000 ALTER TABLE `fruitInvoiceSec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
                        `itemID` varchar(100) NOT NULL,
                        `itemName` varchar(100) DEFAULT NULL,
                        `category` varchar(100) DEFAULT NULL,
                        `singleprice` double DEFAULT NULL,
                        `supplierID` varchar(100) DEFAULT NULL,
                        PRIMARY KEY (`itemID`),
                        KEY `item_category_index` (`category`),
                        KEY `item_itemName_index` (`itemName`),
                        KEY `item_location_itemID_index` (`itemID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES ('8eb8386bf62a46f5a797ff33062a2d9f','www','food',0,'f7484930ad7c461caa708e01b6557ada'),('e041930b1dbe4883b1fd0df5aaa1ca31','qqq','food',101,'f7ad8ebff86f46e18a5b912fe596c80f');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemCommercialSet`
--

DROP TABLE IF EXISTS `itemCommercialSet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itemCommercialSet` (
                                     `id` int NOT NULL AUTO_INCREMENT,
                                     `itemID` varchar(100) NOT NULL,
                                     PRIMARY KEY (`id`),
                                     UNIQUE KEY `itemCommercialSet_id_uindex` (`id`),
                                     UNIQUE KEY `itemCommercialSet_itemID_uindex` (`itemID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemCommercialSet`
--

LOCK TABLES `itemCommercialSet` WRITE;
/*!40000 ALTER TABLE `itemCommercialSet` DISABLE KEYS */;
/*!40000 ALTER TABLE `itemCommercialSet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemDetail`
--

DROP TABLE IF EXISTS `itemDetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itemDetail` (
                              `itemDetailID` varchar(100) NOT NULL,
                              `itemID` varchar(100) NOT NULL,
                              `itemName` varchar(100) DEFAULT NULL,
                              `category` varchar(100) DEFAULT NULL,
                              `singleprice` double DEFAULT NULL,
                              `supplierID` varchar(100) DEFAULT NULL,
                              `time` varchar(100) NOT NULL,
                              `itemUnit` varchar(10) DEFAULT NULL,
                              `grossByUnit` double DEFAULT NULL,
                              `priceEachUnit` double DEFAULT NULL,
                              UNIQUE KEY `itemDetail_itemDetailID_uindex` (`itemDetailID`),
                              UNIQUE KEY `itemDetail_location_itemID_index` (`itemID`,`time`),
                              UNIQUE KEY `itemDetail_time_uindex` (`time`),
                              UNIQUE KEY `itemDetail_category_time_uindex` (`category`,`time`),
                              KEY `itemDetail_itemName_index` (`itemName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemDetail`
--

LOCK TABLES `itemDetail` WRITE;
/*!40000 ALTER TABLE `itemDetail` DISABLE KEYS */;
INSERT INTO `itemDetail` VALUES ('eee9b3f88d124c97a18374b3ba12bdc3','e041930b1dbe4883b1fd0df5aaa1ca31','qqq','food',101,'f7ad8ebff86f46e18a5b912fe596c80f','2023-10-26 14:43:31','g',1000,0.1);
/*!40000 ALTER TABLE `itemDetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemExpireDate`
--

DROP TABLE IF EXISTS `itemExpireDate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itemExpireDate` (
                                  `id` int NOT NULL AUTO_INCREMENT,
                                  `itemID` varchar(100) DEFAULT NULL,
                                  `time` varchar(100) DEFAULT NULL,
                                  `produceDate` varchar(100) DEFAULT NULL,
                                  `location` varchar(100) DEFAULT NULL,
                                  `ifDump` tinyint(1) DEFAULT NULL,
                                  PRIMARY KEY (`id`),
                                  UNIQUE KEY `itemExpireDate_id_uindex` (`id`),
                                  KEY `itemExpireDate_itemID_index` (`itemID`),
                                  KEY `itemExpireDate_location_time_ifDump_index` (`location`,`time`,`ifDump`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemExpireDate`
--

LOCK TABLES `itemExpireDate` WRITE;
/*!40000 ALTER TABLE `itemExpireDate` DISABLE KEYS */;
/*!40000 ALTER TABLE `itemExpireDate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemFoodSet`
--

DROP TABLE IF EXISTS `itemFoodSet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itemFoodSet` (
                               `id` int NOT NULL AUTO_INCREMENT,
                               `itemID` varchar(100) NOT NULL,
                               PRIMARY KEY (`id`),
                               UNIQUE KEY `itemFoodSet_id_uindex` (`id`),
                               UNIQUE KEY `itemFoodSet_itemID_uindex` (`itemID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemFoodSet`
--

LOCK TABLES `itemFoodSet` WRITE;
/*!40000 ALTER TABLE `itemFoodSet` DISABLE KEYS */;
INSERT INTO `itemFoodSet` VALUES (1,'8eb8386bf62a46f5a797ff33062a2d9f'),(2,'e041930b1dbe4883b1fd0df5aaa1ca31');
/*!40000 ALTER TABLE `itemFoodSet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemOthersSet`
--

DROP TABLE IF EXISTS `itemOthersSet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itemOthersSet` (
                                 `id` int NOT NULL AUTO_INCREMENT,
                                 `itemID` varchar(100) NOT NULL,
                                 PRIMARY KEY (`id`),
                                 UNIQUE KEY `itemOthersSet_id_uindex` (`id`),
                                 UNIQUE KEY `itemOthersSet_itemID_uindex` (`itemID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemOthersSet`
--

LOCK TABLES `itemOthersSet` WRITE;
/*!40000 ALTER TABLE `itemOthersSet` DISABLE KEYS */;
/*!40000 ALTER TABLE `itemOthersSet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemSmallToolSet`
--

DROP TABLE IF EXISTS `itemSmallToolSet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itemSmallToolSet` (
                                    `id` int NOT NULL AUTO_INCREMENT,
                                    `itemID` varchar(100) NOT NULL,
                                    PRIMARY KEY (`id`),
                                    UNIQUE KEY `itemSmallToolSet_id_uindex` (`id`),
                                    UNIQUE KEY `itemSmallToolSet_itemID_uindex` (`itemID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemSmallToolSet`
--

LOCK TABLES `itemSmallToolSet` WRITE;
/*!40000 ALTER TABLE `itemSmallToolSet` DISABLE KEYS */;
/*!40000 ALTER TABLE `itemSmallToolSet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemToolSet`
--

DROP TABLE IF EXISTS `itemToolSet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itemToolSet` (
                               `id` int NOT NULL AUTO_INCREMENT,
                               `itemID` varchar(100) NOT NULL,
                               PRIMARY KEY (`id`),
                               UNIQUE KEY `itemToolSet_id_uindex` (`id`),
                               UNIQUE KEY `itemToolSet_itemID_uindex` (`itemID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemToolSet`
--

LOCK TABLES `itemToolSet` WRITE;
/*!40000 ALTER TABLE `itemToolSet` DISABLE KEYS */;
/*!40000 ALTER TABLE `itemToolSet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kryOrderDetail`
--

DROP TABLE IF EXISTS `kryOrderDetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kryOrderDetail` (
                                  `orderId` varchar(100) DEFAULT NULL,
                                  `uuid` varchar(100) DEFAULT NULL,
                                  `dishCode` varchar(100) DEFAULT NULL,
                                  `dishId` varchar(100) DEFAULT NULL,
                                  `dishName` varchar(100) DEFAULT NULL,
                                  `price` varchar(100) DEFAULT NULL,
                                  `quantity` varchar(100) DEFAULT NULL,
                                  `unitName` varchar(100) DEFAULT NULL,
                                  `amount` varchar(100) DEFAULT NULL,
                                  `dishProperties` varchar(100) DEFAULT NULL,
                                  `dishPropertyName` varchar(100) DEFAULT NULL,
                                  `dishCookingWay` varchar(1000) DEFAULT NULL,
                                  `childNodes` varchar(1000) DEFAULT NULL,
                                  `itemId` varchar(100) DEFAULT NULL,
                                  `addDishWaiter` varchar(100) DEFAULT NULL,
                                  `giveDishWaiter` varchar(100) DEFAULT NULL,
                                  `category` varchar(100) DEFAULT NULL,
                                  `warehouse` varchar(100) DEFAULT NULL,
                                  `orderTime` varchar(100) DEFAULT NULL,
                                  KEY `kryOrderDetail_category_index` (`category`),
                                  KEY `kryOrderDetail_orderId_index` (`orderId`),
                                  KEY `kryOrderDetail_orderTime_warehouse_index` (`orderTime`,`warehouse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kryOrderDetail`
--

LOCK TABLES `kryOrderDetail` WRITE;
/*!40000 ALTER TABLE `kryOrderDetail` DISABLE KEYS */;
INSERT INTO `kryOrderDetail` VALUES ('814181143825118208','bb59e698578e4b698ad26250ddabc687','SKU1159','769326856973680659','K拿铁','2000','1.0000','杯','2000','[{\"type\":444,\"dishPropertyName\":\"400ml\"}]','400ml','[{\"amount\":0,\"quantity\":1.00,\"price\":0,\"dishCookingWayName\":\"热饮\"}]','[]','814181144013861888','',NULL,'K咖啡系列','shop2','2023-10-26 17:05:11'),('814180814697986048','bb59e698578e4b698ad26250ddabc687','SKU1159','769326856973680659','K拿铁','2000','1.0000','杯','2000','[{\"type\":444,\"dishPropertyName\":\"400ml\"}]','400ml','[{\"amount\":0,\"quantity\":1.00,\"price\":0,\"dishCookingWayName\":\"热饮\"}]','[]','814180814882535424','',NULL,'K咖啡系列','shop2','2023-10-26 17:03:52');
/*!40000 ALTER TABLE `kryOrderDetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kryOrders`
--

DROP TABLE IF EXISTS `kryOrders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kryOrders` (
                             `tradeNo` varchar(100) DEFAULT NULL,
                             `orderId` varchar(100) NOT NULL,
                             `bizDate` varchar(100) DEFAULT NULL,
                             `source` varchar(100) DEFAULT NULL,
                             `receivedAmount` varchar(100) DEFAULT NULL,
                             `tradeAmount` varchar(100) DEFAULT NULL,
                             `privilegeAmount` varchar(100) DEFAULT NULL,
                             `orderTime` varchar(100) DEFAULT NULL,
                             `checkOutTime` varchar(100) DEFAULT NULL,
                             `tradeStatus` varchar(100) DEFAULT NULL,
                             `sourceName` varchar(100) DEFAULT NULL,
                             `custRealPay` varchar(100) DEFAULT NULL,
                             `tradeType` varchar(100) DEFAULT NULL,
                             `warehouse` varchar(100) DEFAULT NULL,
                             PRIMARY KEY (`orderId`),
                             UNIQUE KEY `kryOrders_orderId_uindex` (`orderId`),
                             KEY `kryOrders_warehouse_orderTime_index` (`warehouse`,`orderTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kryOrders`
--

LOCK TABLES `kryOrders` WRITE;
/*!40000 ALTER TABLE `kryOrders` DISABLE KEYS */;
INSERT INTO `kryOrders` VALUES ('303231026170352301616','814180814697986048','2023-10-26','2911','0','0','-2000','2023-10-26 17:03:52','2023-10-26 17:03:53','4','二代码微信小程序','0','1','shop2'),('303231026170511302322','814181143825118208','2023-10-26','2911','0','0','-2000','2023-10-26 17:05:11','2023-10-26 17:05:11','4','二代码微信小程序','0','1','shop2'),('303231026172336314368','814185777981429760','2023-10-26','2911','0','0','-1800','2023-10-26 17:23:36','2023-10-26 17:23:36','4','二代码微信小程序','0','1','shop12');
/*!40000 ALTER TABLE `kryOrders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `main0WarehouseInputlog`
--

DROP TABLE IF EXISTS `main0WarehouseInputlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `main0WarehouseInputlog` (
                                          `logid` varchar(100) DEFAULT NULL,
                                          `id` varchar(100) DEFAULT NULL,
                                          `itemName` varchar(100) DEFAULT NULL,
                                          `brand` varchar(100) DEFAULT NULL,
                                          `itemCount` int DEFAULT NULL,
                                          `singlePrice` double DEFAULT NULL,
                                          `totalPrice` double DEFAULT NULL,
                                          `memo` varchar(100) DEFAULT NULL,
                                          `time` varchar(100) DEFAULT NULL,
                                          `category` varchar(100) DEFAULT NULL,
                                          `action` varchar(100) DEFAULT NULL,
                                          `from` varchar(100) DEFAULT NULL,
                                          `to` varchar(100) DEFAULT NULL,
                                          `ifComplete` tinyint(1) DEFAULT NULL,
                                          `ifConfirm` tinyint(1) DEFAULT NULL,
                                          KEY `main0WarehouseInputlog_action_index` (`action`),
                                          KEY `main0WarehouseInputlog_id_index` (`id`),
                                          KEY `main0WarehouseInputlog_itemName_index` (`itemName`),
                                          KEY `main0WarehouseInputlog_logid_index` (`logid`),
                                          KEY `main0WarehouseInputlog_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `main0WarehouseInputlog`
--

LOCK TABLES `main0WarehouseInputlog` WRITE;
/*!40000 ALTER TABLE `main0WarehouseInputlog` DISABLE KEYS */;
INSERT INTO `main0WarehouseInputlog` VALUES ('6ef4df8fb47f4273a8163df7a54f265e','e041930b1dbe4883b1fd0df5aaa1ca31','qqq','sss',100,10,1000,'123123','2023-10-26 17:48:43','food','newinput','outside','main0',1,1),('2ca6435bfe7346edab418be390eb6b83','e041930b1dbe4883b1fd0df5aaa1ca31','qqq','Alan',1,10,10,'123123','2023-10-26 17:50:25','food','input','outside','main0',1,1),('5f3a97c12c8842a08116a9e57475900d','e041930b1dbe4883b1fd0df5aaa1ca31','qqq','Alan',2,10,20,'123123','2023-10-26 17:50:34','food','input','outside','main0',1,1),('80dff39f265944a38675668eaa8cd1d6','e041930b1dbe4883b1fd0df5aaa1ca31','qqq','Alan',1,10,10,'123123','2023-10-26 17:52:42','food','output','main0','outside',1,1),('6c8a3feb7afd4f139c69db1e217f736d','e041930b1dbe4883b1fd0df5aaa1ca31','qqq','Alan',1,10,10,'123123','2023-10-26 17:54:04','food','output','main0','outside',1,1),('286505d18fdc4bdd80bba80324f8679c','8eb8386bf62a46f5a797ff33062a2d9f','www','eee',100,1,100,'3333','2023-10-26 17:55:22','food','newinput','outside','main0',1,1),('84afc7c673fd4c0e9be0a57c4ff937bd','8eb8386bf62a46f5a797ff33062a2d9f','www','eee',1,1,1,'3333','2023-10-26 17:56:13','food','send','main0','shop7',1,1),('8cb49776e5cc4f74a10a691b08ef624f','e041930b1dbe4883b1fd0df5aaa1ca31','qqq','Alan',200,12,2400,'5555','2023-10-26 18:31:47','food','newinput','outside','main0',1,1),('dd24d8f5f3f742929f84d8245a04467c','8eb8386bf62a46f5a797ff33062a2d9f','www','eee',1,1,1,'3333','2023-10-26 18:42:25','food','send','main0','shop7',1,1);
/*!40000 ALTER TABLE `main0WarehouseInputlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `main0WarehouseOutputSum`
--

DROP TABLE IF EXISTS `main0WarehouseOutputSum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `main0WarehouseOutputSum` (
                                           `logid` varchar(100) DEFAULT NULL,
                                           `id` varchar(100) DEFAULT NULL,
                                           `count_week` int DEFAULT NULL,
                                           `count_month` int DEFAULT NULL,
                                           `ifalert_week` tinyint(1) DEFAULT NULL,
                                           `ifalert_month` tinyint(1) DEFAULT NULL,
                                           `time` varchar(100) DEFAULT NULL,
                                           `category` varchar(100) DEFAULT NULL,
                                           KEY `main0WarehouseOutputSum_id_index` (`id`),
                                           KEY `main0WarehouseOutputSum_logid_index` (`logid`),
                                           KEY `main0WarehouseOutputSum_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `main0WarehouseOutputSum`
--

LOCK TABLES `main0WarehouseOutputSum` WRITE;
/*!40000 ALTER TABLE `main0WarehouseOutputSum` DISABLE KEYS */;
/*!40000 ALTER TABLE `main0WarehouseOutputSum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `main1WarehouseInputlog`
--

DROP TABLE IF EXISTS `main1WarehouseInputlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `main1WarehouseInputlog` (
                                          `logid` varchar(100) DEFAULT NULL,
                                          `id` varchar(100) DEFAULT NULL,
                                          `itemName` varchar(100) DEFAULT NULL,
                                          `brand` varchar(100) DEFAULT NULL,
                                          `itemCount` int DEFAULT NULL,
                                          `singlePrice` double DEFAULT NULL,
                                          `totalPrice` double DEFAULT NULL,
                                          `memo` varchar(100) DEFAULT NULL,
                                          `time` varchar(100) DEFAULT NULL,
                                          `category` varchar(100) DEFAULT NULL,
                                          `action` varchar(100) DEFAULT NULL,
                                          `from` varchar(100) DEFAULT NULL,
                                          `to` varchar(100) DEFAULT NULL,
                                          `ifComplete` tinyint(1) DEFAULT NULL,
                                          `ifConfirm` tinyint(1) DEFAULT NULL,
                                          KEY `main1WarehouseInputlog_action_index` (`action`),
                                          KEY `main1WarehouseInputlog_id_index` (`id`),
                                          KEY `main1WarehouseInputlog_itemName_index` (`itemName`),
                                          KEY `main1WarehouseInputlog_logid_index` (`logid`),
                                          KEY `main1WarehouseInputlog_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `main1WarehouseInputlog`
--

LOCK TABLES `main1WarehouseInputlog` WRITE;
/*!40000 ALTER TABLE `main1WarehouseInputlog` DISABLE KEYS */;
/*!40000 ALTER TABLE `main1WarehouseInputlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `main1WarehouseOutputSum`
--

DROP TABLE IF EXISTS `main1WarehouseOutputSum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `main1WarehouseOutputSum` (
                                           `logid` varchar(100) DEFAULT NULL,
                                           `id` varchar(100) DEFAULT NULL,
                                           `count_week` int DEFAULT NULL,
                                           `count_month` int DEFAULT NULL,
                                           `ifalert_week` tinyint(1) DEFAULT NULL,
                                           `ifalert_month` tinyint(1) DEFAULT NULL,
                                           `time` varchar(100) DEFAULT NULL,
                                           `category` varchar(100) DEFAULT NULL,
                                           KEY `main1WarehouseOutputSum_id_index` (`id`),
                                           KEY `main1WarehouseOutputSum_logid_index` (`logid`),
                                           KEY `main1WarehouseOutputSum_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `main1WarehouseOutputSum`
--

LOCK TABLES `main1WarehouseOutputSum` WRITE;
/*!40000 ALTER TABLE `main1WarehouseOutputSum` DISABLE KEYS */;
/*!40000 ALTER TABLE `main1WarehouseOutputSum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `main2WarehouseInputlog`
--

DROP TABLE IF EXISTS `main2WarehouseInputlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `main2WarehouseInputlog` (
                                          `logid` varchar(100) DEFAULT NULL,
                                          `id` varchar(100) DEFAULT NULL,
                                          `itemName` varchar(100) DEFAULT NULL,
                                          `brand` varchar(100) DEFAULT NULL,
                                          `itemCount` int DEFAULT NULL,
                                          `singlePrice` double DEFAULT NULL,
                                          `totalPrice` double DEFAULT NULL,
                                          `memo` varchar(100) DEFAULT NULL,
                                          `time` varchar(100) DEFAULT NULL,
                                          `category` varchar(100) DEFAULT NULL,
                                          `action` varchar(100) DEFAULT NULL,
                                          `from` varchar(100) DEFAULT NULL,
                                          `to` varchar(100) DEFAULT NULL,
                                          `ifComplete` tinyint(1) DEFAULT NULL,
                                          `ifConfirm` tinyint(1) DEFAULT NULL,
                                          KEY `main2WarehouseInputlog_action_index` (`action`),
                                          KEY `main2WarehouseInputlog_id_index` (`id`),
                                          KEY `main2WarehouseInputlog_itemName_index` (`itemName`),
                                          KEY `main2WarehouseInputlog_logid_index` (`logid`),
                                          KEY `main2WarehouseInputlog_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `main2WarehouseInputlog`
--

LOCK TABLES `main2WarehouseInputlog` WRITE;
/*!40000 ALTER TABLE `main2WarehouseInputlog` DISABLE KEYS */;
/*!40000 ALTER TABLE `main2WarehouseInputlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `main2WarehouseOutputSum`
--

DROP TABLE IF EXISTS `main2WarehouseOutputSum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `main2WarehouseOutputSum` (
                                           `logid` varchar(100) DEFAULT NULL,
                                           `id` varchar(100) DEFAULT NULL,
                                           `count_week` int DEFAULT NULL,
                                           `count_month` int DEFAULT NULL,
                                           `ifalert_week` tinyint(1) DEFAULT NULL,
                                           `ifalert_month` tinyint(1) DEFAULT NULL,
                                           `time` varchar(100) DEFAULT NULL,
                                           `category` varchar(100) DEFAULT NULL,
                                           KEY `main2WarehouseOutputSum_id_index` (`id`),
                                           KEY `main2WarehouseOutputSum_logid_index` (`logid`),
                                           KEY `main2WarehouseOutputSum_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `main2WarehouseOutputSum`
--

LOCK TABLES `main2WarehouseOutputSum` WRITE;
/*!40000 ALTER TABLE `main2WarehouseOutputSum` DISABLE KEYS */;
/*!40000 ALTER TABLE `main2WarehouseOutputSum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mainWarehouse0_commercialItem`
--

DROP TABLE IF EXISTS `mainWarehouse0_commercialItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mainWarehouse0_commercialItem` (
                                                 `id` varchar(100) NOT NULL,
                                                 `itemCount` int DEFAULT NULL,
                                                 `singlePrice` double DEFAULT NULL,
                                                 `totalPrice` double DEFAULT NULL,
                                                 `memo` varchar(100) DEFAULT NULL,
                                                 PRIMARY KEY (`id`),
                                                 UNIQUE KEY `mainWarehouse0_commercialItem_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mainWarehouse0_commercialItem`
--

LOCK TABLES `mainWarehouse0_commercialItem` WRITE;
/*!40000 ALTER TABLE `mainWarehouse0_commercialItem` DISABLE KEYS */;
/*!40000 ALTER TABLE `mainWarehouse0_commercialItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mainWarehouse0_food`
--

DROP TABLE IF EXISTS `mainWarehouse0_food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mainWarehouse0_food` (
                                       `id` varchar(100) NOT NULL,
                                       `itemCount` int DEFAULT NULL,
                                       `singlePrice` double DEFAULT NULL,
                                       `totalPrice` double DEFAULT NULL,
                                       `memo` varchar(100) DEFAULT NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `mainWarehouse0_food_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mainWarehouse0_food`
--

LOCK TABLES `mainWarehouse0_food` WRITE;
/*!40000 ALTER TABLE `mainWarehouse0_food` DISABLE KEYS */;
INSERT INTO `mainWarehouse0_food` VALUES ('8eb8386bf62a46f5a797ff33062a2d9f',98,1,98,'3333'),('e041930b1dbe4883b1fd0df5aaa1ca31',200,12,2400,'5555');
/*!40000 ALTER TABLE `mainWarehouse0_food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mainWarehouse0_others`
--

DROP TABLE IF EXISTS `mainWarehouse0_others`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mainWarehouse0_others` (
                                         `id` varchar(100) NOT NULL,
                                         `itemCount` int DEFAULT NULL,
                                         `singlePrice` double DEFAULT NULL,
                                         `totalPrice` double DEFAULT NULL,
                                         `memo` varchar(100) DEFAULT NULL,
                                         PRIMARY KEY (`id`),
                                         UNIQUE KEY `mainWarehouse0_others_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mainWarehouse0_others`
--

LOCK TABLES `mainWarehouse0_others` WRITE;
/*!40000 ALTER TABLE `mainWarehouse0_others` DISABLE KEYS */;
/*!40000 ALTER TABLE `mainWarehouse0_others` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mainWarehouse0_smallTool`
--

DROP TABLE IF EXISTS `mainWarehouse0_smallTool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mainWarehouse0_smallTool` (
                                            `id` varchar(100) NOT NULL,
                                            `itemCount` int DEFAULT NULL,
                                            `singlePrice` double DEFAULT NULL,
                                            `totalPrice` double DEFAULT NULL,
                                            `memo` varchar(100) DEFAULT NULL,
                                            PRIMARY KEY (`id`),
                                            UNIQUE KEY `mainWarehouse0_smallTool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mainWarehouse0_smallTool`
--

LOCK TABLES `mainWarehouse0_smallTool` WRITE;
/*!40000 ALTER TABLE `mainWarehouse0_smallTool` DISABLE KEYS */;
/*!40000 ALTER TABLE `mainWarehouse0_smallTool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mainWarehouse0_tool`
--

DROP TABLE IF EXISTS `mainWarehouse0_tool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mainWarehouse0_tool` (
                                       `id` varchar(100) NOT NULL,
                                       `itemCount` int DEFAULT NULL,
                                       `singlePrice` double DEFAULT NULL,
                                       `totalPrice` double DEFAULT NULL,
                                       `memo` varchar(100) DEFAULT NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `mainWarehouse0_tool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mainWarehouse0_tool`
--

LOCK TABLES `mainWarehouse0_tool` WRITE;
/*!40000 ALTER TABLE `mainWarehouse0_tool` DISABLE KEYS */;
/*!40000 ALTER TABLE `mainWarehouse0_tool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mainWarehouse1_commercialItem`
--

DROP TABLE IF EXISTS `mainWarehouse1_commercialItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mainWarehouse1_commercialItem` (
                                                 `id` varchar(100) NOT NULL,
                                                 `itemCount` int DEFAULT NULL,
                                                 `singlePrice` double DEFAULT NULL,
                                                 `totalPrice` double DEFAULT NULL,
                                                 `memo` varchar(100) DEFAULT NULL,
                                                 PRIMARY KEY (`id`),
                                                 UNIQUE KEY `mainWarehouse1_commercialItem_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mainWarehouse1_commercialItem`
--

LOCK TABLES `mainWarehouse1_commercialItem` WRITE;
/*!40000 ALTER TABLE `mainWarehouse1_commercialItem` DISABLE KEYS */;
/*!40000 ALTER TABLE `mainWarehouse1_commercialItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mainWarehouse1_food`
--

DROP TABLE IF EXISTS `mainWarehouse1_food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mainWarehouse1_food` (
                                       `id` varchar(100) NOT NULL,
                                       `itemCount` int DEFAULT NULL,
                                       `singlePrice` double DEFAULT NULL,
                                       `totalPrice` double DEFAULT NULL,
                                       `memo` varchar(100) DEFAULT NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `mainWarehouse1_food_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mainWarehouse1_food`
--

LOCK TABLES `mainWarehouse1_food` WRITE;
/*!40000 ALTER TABLE `mainWarehouse1_food` DISABLE KEYS */;
/*!40000 ALTER TABLE `mainWarehouse1_food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mainWarehouse1_others`
--

DROP TABLE IF EXISTS `mainWarehouse1_others`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mainWarehouse1_others` (
                                         `id` varchar(100) NOT NULL,
                                         `itemCount` int DEFAULT NULL,
                                         `singlePrice` double DEFAULT NULL,
                                         `totalPrice` double DEFAULT NULL,
                                         `memo` varchar(100) DEFAULT NULL,
                                         PRIMARY KEY (`id`),
                                         UNIQUE KEY `mainWarehouse1_others_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mainWarehouse1_others`
--

LOCK TABLES `mainWarehouse1_others` WRITE;
/*!40000 ALTER TABLE `mainWarehouse1_others` DISABLE KEYS */;
/*!40000 ALTER TABLE `mainWarehouse1_others` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mainWarehouse1_smallTool`
--

DROP TABLE IF EXISTS `mainWarehouse1_smallTool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mainWarehouse1_smallTool` (
                                            `id` varchar(100) NOT NULL,
                                            `itemCount` int DEFAULT NULL,
                                            `singlePrice` double DEFAULT NULL,
                                            `totalPrice` double DEFAULT NULL,
                                            `memo` varchar(100) DEFAULT NULL,
                                            PRIMARY KEY (`id`),
                                            UNIQUE KEY `mainWarehouse1_smallTool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mainWarehouse1_smallTool`
--

LOCK TABLES `mainWarehouse1_smallTool` WRITE;
/*!40000 ALTER TABLE `mainWarehouse1_smallTool` DISABLE KEYS */;
/*!40000 ALTER TABLE `mainWarehouse1_smallTool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mainWarehouse1_tool`
--

DROP TABLE IF EXISTS `mainWarehouse1_tool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mainWarehouse1_tool` (
                                       `id` varchar(100) NOT NULL,
                                       `itemCount` int DEFAULT NULL,
                                       `singlePrice` double DEFAULT NULL,
                                       `totalPrice` double DEFAULT NULL,
                                       `memo` varchar(100) DEFAULT NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `mainWarehouse1_tool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mainWarehouse1_tool`
--

LOCK TABLES `mainWarehouse1_tool` WRITE;
/*!40000 ALTER TABLE `mainWarehouse1_tool` DISABLE KEYS */;
/*!40000 ALTER TABLE `mainWarehouse1_tool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mainWarehouse2_commercialItem`
--

DROP TABLE IF EXISTS `mainWarehouse2_commercialItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mainWarehouse2_commercialItem` (
                                                 `id` varchar(100) NOT NULL,
                                                 `itemCount` int DEFAULT NULL,
                                                 `singlePrice` double DEFAULT NULL,
                                                 `totalPrice` double DEFAULT NULL,
                                                 `memo` varchar(100) DEFAULT NULL,
                                                 PRIMARY KEY (`id`),
                                                 UNIQUE KEY `mainWarehouse2_commercialItem_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mainWarehouse2_commercialItem`
--

LOCK TABLES `mainWarehouse2_commercialItem` WRITE;
/*!40000 ALTER TABLE `mainWarehouse2_commercialItem` DISABLE KEYS */;
/*!40000 ALTER TABLE `mainWarehouse2_commercialItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mainWarehouse2_food`
--

DROP TABLE IF EXISTS `mainWarehouse2_food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mainWarehouse2_food` (
                                       `id` varchar(100) NOT NULL,
                                       `itemCount` int DEFAULT NULL,
                                       `singlePrice` double DEFAULT NULL,
                                       `totalPrice` double DEFAULT NULL,
                                       `memo` varchar(100) DEFAULT NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `mainWarehouse2_food_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mainWarehouse2_food`
--

LOCK TABLES `mainWarehouse2_food` WRITE;
/*!40000 ALTER TABLE `mainWarehouse2_food` DISABLE KEYS */;
/*!40000 ALTER TABLE `mainWarehouse2_food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mainWarehouse2_others`
--

DROP TABLE IF EXISTS `mainWarehouse2_others`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mainWarehouse2_others` (
                                         `id` varchar(100) NOT NULL,
                                         `itemCount` int DEFAULT NULL,
                                         `singlePrice` double DEFAULT NULL,
                                         `totalPrice` double DEFAULT NULL,
                                         `memo` varchar(100) DEFAULT NULL,
                                         PRIMARY KEY (`id`),
                                         UNIQUE KEY `mainWarehouse2_others_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mainWarehouse2_others`
--

LOCK TABLES `mainWarehouse2_others` WRITE;
/*!40000 ALTER TABLE `mainWarehouse2_others` DISABLE KEYS */;
/*!40000 ALTER TABLE `mainWarehouse2_others` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mainWarehouse2_smallTool`
--

DROP TABLE IF EXISTS `mainWarehouse2_smallTool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mainWarehouse2_smallTool` (
                                            `id` varchar(100) NOT NULL,
                                            `itemCount` int DEFAULT NULL,
                                            `singlePrice` double DEFAULT NULL,
                                            `totalPrice` double DEFAULT NULL,
                                            `memo` varchar(100) DEFAULT NULL,
                                            PRIMARY KEY (`id`),
                                            UNIQUE KEY `mainWarehouse2_smallTool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mainWarehouse2_smallTool`
--

LOCK TABLES `mainWarehouse2_smallTool` WRITE;
/*!40000 ALTER TABLE `mainWarehouse2_smallTool` DISABLE KEYS */;
/*!40000 ALTER TABLE `mainWarehouse2_smallTool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mainWarehouse2_tool`
--

DROP TABLE IF EXISTS `mainWarehouse2_tool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mainWarehouse2_tool` (
                                       `id` varchar(100) NOT NULL,
                                       `itemCount` int DEFAULT NULL,
                                       `singlePrice` double DEFAULT NULL,
                                       `totalPrice` double DEFAULT NULL,
                                       `memo` varchar(100) DEFAULT NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `mainWarehouse2_tool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mainWarehouse2_tool`
--

LOCK TABLES `mainWarehouse2_tool` WRITE;
/*!40000 ALTER TABLE `mainWarehouse2_tool` DISABLE KEYS */;
/*!40000 ALTER TABLE `mainWarehouse2_tool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchaseItem`
--

DROP TABLE IF EXISTS `purchaseItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchaseItem` (
                                `logID` varchar(100) NOT NULL,
                                `purchaseStatus` varchar(30) NOT NULL,
                                `shipID` varchar(100) DEFAULT NULL,
                                `purchaseTime` varchar(20) DEFAULT NULL,
                                `purchaseMonth` varchar(10) DEFAULT NULL,
                                `singlePrice` double DEFAULT NULL,
                                `totalPrice` double DEFAULT NULL,
                                PRIMARY KEY (`logID`),
                                UNIQUE KEY `purchaseItem_logID_uindex` (`logID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchaseItem`
--

LOCK TABLES `purchaseItem` WRITE;
/*!40000 ALTER TABLE `purchaseItem` DISABLE KEYS */;
INSERT INTO `purchaseItem` VALUES ('5711bbf969c04eea9d8795f8b6730750','ARRIVE','','2023-10-26 17:47:00','2023-10',101,101);
/*!40000 ALTER TABLE `purchaseItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `realOfficeName`
--

DROP TABLE IF EXISTS `realOfficeName`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `realOfficeName` (
                                  `nickname` varchar(100) DEFAULT NULL,
                                  `realname` varchar(100) DEFAULT NULL,
                                  `warehouseid` varchar(10) DEFAULT NULL,
                                  `area` varchar(10) DEFAULT NULL,
                                  KEY `realOfficeName_area_index` (`area`),
                                  KEY `realOfficeName_nickname_index` (`nickname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `realOfficeName`
--

LOCK TABLES `realOfficeName` WRITE;
/*!40000 ALTER TABLE `realOfficeName` DISABLE KEYS */;
INSERT INTO `realOfficeName` VALUES ('office1','深圳自贸中心',NULL,'深圳'),('office2','东莞天安1202',NULL,'东莞'),('office3','东莞腾龙商务中心',NULL,'东莞');
/*!40000 ALTER TABLE `realOfficeName` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `realWarehouseName`
--

DROP TABLE IF EXISTS `realWarehouseName`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `realWarehouseName` (
                                     `nickname` varchar(100) NOT NULL,
                                     `realname` varchar(100) DEFAULT NULL,
                                     `warehouseid` varchar(10) DEFAULT NULL,
                                     `area` varchar(10) DEFAULT NULL,
                                     PRIMARY KEY (`nickname`),
                                     UNIQUE KEY `realWarehouseName_nickname_uindex` (`nickname`),
                                     KEY `realWarehouseName_area_index` (`area`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `realWarehouseName`
--

LOCK TABLES `realWarehouseName` WRITE;
/*!40000 ALTER TABLE `realWarehouseName` DISABLE KEYS */;
INSERT INTO `realWarehouseName` VALUES ('main0','*总仓*',NULL,'SZ'),('main1','东莞总部',NULL,'DG'),('main2','深圳1',NULL,'SZ'),('shop1','深圳2','101尚美','SZ'),('shop10','深圳3',NULL,'SZ'),('shop11','东莞1',NULL,'DG'),('shop12','深圳4',NULL,'SZ'),('shop13','深圳5',NULL,'SZ'),('shop14','深圳6',NULL,'SZ'),('shop2','深圳7','102鼎丰','SZ'),('shop3','深圳8','103振业','SZ'),('shop4','东莞2','202ucc','DG'),('shop5','东莞3','201天安','DG'),('shop6','东莞4','203保利','DG'),('shop7','东莞5','204琥珀台','DG'),('shop8','深圳9',NULL,'SZ'),('shop9','深圳10',NULL,'SZ');
/*!40000 ALTER TABLE `realWarehouseName` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receiveError`
--

DROP TABLE IF EXISTS `receiveError`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receiveError` (
                                `logid` varchar(100) DEFAULT NULL,
                                `id` varchar(100) DEFAULT NULL,
                                `brand` varchar(100) DEFAULT NULL,
                                `itemCount` int DEFAULT NULL,
                                `ifComplete` tinyint(1) DEFAULT NULL,
                                `category` varchar(100) DEFAULT NULL,
                                `location` varchar(10) DEFAULT NULL,
                                UNIQUE KEY `receiveError_pk` (`logid`),
                                UNIQUE KEY `receiveError_pk_2` (`id`,`logid`),
                                UNIQUE KEY `receiveError_pk_3` (`location`,`category`,`ifComplete`,`logid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receiveError`
--

LOCK TABLES `receiveError` WRITE;
/*!40000 ALTER TABLE `receiveError` DISABLE KEYS */;
/*!40000 ALTER TABLE `receiveError` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop10WarehouseInputlog`
--

DROP TABLE IF EXISTS `shop10WarehouseInputlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop10WarehouseInputlog` (
                                           `logid` varchar(100) DEFAULT NULL,
                                           `id` varchar(100) DEFAULT NULL,
                                           `itemName` varchar(100) DEFAULT NULL,
                                           `brand` varchar(100) DEFAULT NULL,
                                           `itemCount` int DEFAULT NULL,
                                           `singlePrice` double DEFAULT NULL,
                                           `totalPrice` double DEFAULT NULL,
                                           `memo` varchar(100) DEFAULT NULL,
                                           `time` varchar(100) DEFAULT NULL,
                                           `category` varchar(100) DEFAULT NULL,
                                           `action` varchar(100) DEFAULT NULL,
                                           `from` varchar(100) DEFAULT NULL,
                                           `to` varchar(100) DEFAULT NULL,
                                           `ifComplete` tinyint(1) DEFAULT NULL,
                                           `ifConfirm` tinyint(1) DEFAULT NULL,
                                           KEY `shop10WarehouseInputlog_action_index` (`action`),
                                           KEY `shop10WarehouseInputlog_id_index` (`id`),
                                           KEY `shop10WarehouseInputlog_itemName_index` (`itemName`),
                                           KEY `shop10WarehouseInputlog_logid_index` (`logid`),
                                           KEY `shop10WarehouseInputlog_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop10WarehouseInputlog`
--

LOCK TABLES `shop10WarehouseInputlog` WRITE;
/*!40000 ALTER TABLE `shop10WarehouseInputlog` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop10WarehouseInputlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop10WarehouseOutputSum`
--

DROP TABLE IF EXISTS `shop10WarehouseOutputSum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop10WarehouseOutputSum` (
                                            `logid` varchar(100) DEFAULT NULL,
                                            `id` varchar(100) DEFAULT NULL,
                                            `count_week` int DEFAULT NULL,
                                            `count_month` int DEFAULT NULL,
                                            `ifalert_week` tinyint(1) DEFAULT NULL,
                                            `ifalert_month` tinyint(1) DEFAULT NULL,
                                            `time` varchar(100) DEFAULT NULL,
                                            `category` varchar(100) DEFAULT NULL,
                                            KEY `shop10WarehouseOutputSum_id_index` (`id`),
                                            KEY `shop10WarehouseOutputSum_logid_index` (`logid`),
                                            KEY `shop10WarehouseOutputSum_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop10WarehouseOutputSum`
--

LOCK TABLES `shop10WarehouseOutputSum` WRITE;
/*!40000 ALTER TABLE `shop10WarehouseOutputSum` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop10WarehouseOutputSum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop11WarehouseInputlog`
--

DROP TABLE IF EXISTS `shop11WarehouseInputlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop11WarehouseInputlog` (
                                           `logid` varchar(100) DEFAULT NULL,
                                           `id` varchar(100) DEFAULT NULL,
                                           `itemName` varchar(100) DEFAULT NULL,
                                           `brand` varchar(100) DEFAULT NULL,
                                           `itemCount` int DEFAULT NULL,
                                           `singlePrice` double DEFAULT NULL,
                                           `totalPrice` double DEFAULT NULL,
                                           `memo` varchar(100) DEFAULT NULL,
                                           `time` varchar(100) DEFAULT NULL,
                                           `category` varchar(100) DEFAULT NULL,
                                           `action` varchar(100) DEFAULT NULL,
                                           `from` varchar(100) DEFAULT NULL,
                                           `to` varchar(100) DEFAULT NULL,
                                           `ifComplete` tinyint(1) DEFAULT NULL,
                                           `ifConfirm` tinyint(1) DEFAULT NULL,
                                           KEY `shop11WarehouseInputlog_action_index` (`action`),
                                           KEY `shop11WarehouseInputlog_id_index` (`id`),
                                           KEY `shop11WarehouseInputlog_itemName_index` (`itemName`),
                                           KEY `shop11WarehouseInputlog_logid_index` (`logid`),
                                           KEY `shop11WarehouseInputlog_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop11WarehouseInputlog`
--

LOCK TABLES `shop11WarehouseInputlog` WRITE;
/*!40000 ALTER TABLE `shop11WarehouseInputlog` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop11WarehouseInputlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop11WarehouseOutputSum`
--

DROP TABLE IF EXISTS `shop11WarehouseOutputSum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop11WarehouseOutputSum` (
                                            `logid` varchar(100) DEFAULT NULL,
                                            `id` varchar(100) DEFAULT NULL,
                                            `count_week` int DEFAULT NULL,
                                            `count_month` int DEFAULT NULL,
                                            `ifalert_week` tinyint(1) DEFAULT NULL,
                                            `ifalert_month` tinyint(1) DEFAULT NULL,
                                            `time` varchar(100) DEFAULT NULL,
                                            `category` varchar(100) DEFAULT NULL,
                                            KEY `shop11WarehouseOutputSum_id_index` (`id`),
                                            KEY `shop11WarehouseOutputSum_logid_index` (`logid`),
                                            KEY `shop11WarehouseOutputSum_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop11WarehouseOutputSum`
--

LOCK TABLES `shop11WarehouseOutputSum` WRITE;
/*!40000 ALTER TABLE `shop11WarehouseOutputSum` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop11WarehouseOutputSum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop12WarehouseInputlog`
--

DROP TABLE IF EXISTS `shop12WarehouseInputlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop12WarehouseInputlog` (
                                           `logid` varchar(100) DEFAULT NULL,
                                           `id` varchar(100) DEFAULT NULL,
                                           `itemName` varchar(100) DEFAULT NULL,
                                           `brand` varchar(100) DEFAULT NULL,
                                           `itemCount` int DEFAULT NULL,
                                           `singlePrice` double DEFAULT NULL,
                                           `totalPrice` double DEFAULT NULL,
                                           `memo` varchar(100) DEFAULT NULL,
                                           `time` varchar(100) DEFAULT NULL,
                                           `category` varchar(100) DEFAULT NULL,
                                           `action` varchar(100) DEFAULT NULL,
                                           `from` varchar(100) DEFAULT NULL,
                                           `to` varchar(100) DEFAULT NULL,
                                           `ifComplete` tinyint(1) DEFAULT NULL,
                                           `ifConfirm` tinyint(1) DEFAULT NULL,
                                           KEY `shop12WarehouseInputlog_action_index` (`action`),
                                           KEY `shop12WarehouseInputlog_id_index` (`id`),
                                           KEY `shop12WarehouseInputlog_itemName_index` (`itemName`),
                                           KEY `shop12WarehouseInputlog_logid_index` (`logid`),
                                           KEY `shop12WarehouseInputlog_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop12WarehouseInputlog`
--

LOCK TABLES `shop12WarehouseInputlog` WRITE;
/*!40000 ALTER TABLE `shop12WarehouseInputlog` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop12WarehouseInputlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop12WarehouseOutputSum`
--

DROP TABLE IF EXISTS `shop12WarehouseOutputSum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop12WarehouseOutputSum` (
                                            `logid` varchar(100) DEFAULT NULL,
                                            `id` varchar(100) DEFAULT NULL,
                                            `count_week` int DEFAULT NULL,
                                            `count_month` int DEFAULT NULL,
                                            `ifalert_week` tinyint(1) DEFAULT NULL,
                                            `ifalert_month` tinyint(1) DEFAULT NULL,
                                            `time` varchar(100) DEFAULT NULL,
                                            `category` varchar(100) DEFAULT NULL,
                                            KEY `shop12WarehouseOutputSum_id_index` (`id`),
                                            KEY `shop12WarehouseOutputSum_logid_index` (`logid`),
                                            KEY `shop12WarehouseOutputSum_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop12WarehouseOutputSum`
--

LOCK TABLES `shop12WarehouseOutputSum` WRITE;
/*!40000 ALTER TABLE `shop12WarehouseOutputSum` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop12WarehouseOutputSum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop13WarehouseInputlog`
--

DROP TABLE IF EXISTS `shop13WarehouseInputlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop13WarehouseInputlog` (
                                           `logid` varchar(100) DEFAULT NULL,
                                           `id` varchar(100) DEFAULT NULL,
                                           `itemName` varchar(100) DEFAULT NULL,
                                           `brand` varchar(100) DEFAULT NULL,
                                           `itemCount` int DEFAULT NULL,
                                           `singlePrice` double DEFAULT NULL,
                                           `totalPrice` double DEFAULT NULL,
                                           `memo` varchar(100) DEFAULT NULL,
                                           `time` varchar(100) DEFAULT NULL,
                                           `category` varchar(100) DEFAULT NULL,
                                           `action` varchar(100) DEFAULT NULL,
                                           `from` varchar(100) DEFAULT NULL,
                                           `to` varchar(100) DEFAULT NULL,
                                           `ifComplete` tinyint(1) DEFAULT NULL,
                                           `ifConfirm` tinyint(1) DEFAULT NULL,
                                           KEY `shop13WarehouseInputlog_action_index` (`action`),
                                           KEY `shop13WarehouseInputlog_id_index` (`id`),
                                           KEY `shop13WarehouseInputlog_itemName_index` (`itemName`),
                                           KEY `shop13WarehouseInputlog_logid_index` (`logid`),
                                           KEY `shop13WarehouseInputlog_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop13WarehouseInputlog`
--

LOCK TABLES `shop13WarehouseInputlog` WRITE;
/*!40000 ALTER TABLE `shop13WarehouseInputlog` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop13WarehouseInputlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop13WarehouseOutputSum`
--

DROP TABLE IF EXISTS `shop13WarehouseOutputSum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop13WarehouseOutputSum` (
                                            `logid` varchar(100) DEFAULT NULL,
                                            `id` varchar(100) DEFAULT NULL,
                                            `count_week` int DEFAULT NULL,
                                            `count_month` int DEFAULT NULL,
                                            `ifalert_week` tinyint(1) DEFAULT NULL,
                                            `ifalert_month` tinyint(1) DEFAULT NULL,
                                            `time` varchar(100) DEFAULT NULL,
                                            `category` varchar(100) DEFAULT NULL,
                                            KEY `shop13WarehouseOutputSum_id_index` (`id`),
                                            KEY `shop13WarehouseOutputSum_logid_index` (`logid`),
                                            KEY `shop13WarehouseOutputSum_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop13WarehouseOutputSum`
--

LOCK TABLES `shop13WarehouseOutputSum` WRITE;
/*!40000 ALTER TABLE `shop13WarehouseOutputSum` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop13WarehouseOutputSum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop14WarehouseInputlog`
--

DROP TABLE IF EXISTS `shop14WarehouseInputlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop14WarehouseInputlog` (
                                           `logid` varchar(100) DEFAULT NULL,
                                           `id` varchar(100) DEFAULT NULL,
                                           `itemName` varchar(100) DEFAULT NULL,
                                           `brand` varchar(100) DEFAULT NULL,
                                           `itemCount` int DEFAULT NULL,
                                           `singlePrice` double DEFAULT NULL,
                                           `totalPrice` double DEFAULT NULL,
                                           `memo` varchar(100) DEFAULT NULL,
                                           `time` varchar(100) DEFAULT NULL,
                                           `category` varchar(100) DEFAULT NULL,
                                           `action` varchar(100) DEFAULT NULL,
                                           `from` varchar(100) DEFAULT NULL,
                                           `to` varchar(100) DEFAULT NULL,
                                           `ifComplete` tinyint(1) DEFAULT NULL,
                                           `ifConfirm` tinyint(1) DEFAULT NULL,
                                           KEY `shop14WarehouseInputlog_action_index` (`action`),
                                           KEY `shop14WarehouseInputlog_id_index` (`id`),
                                           KEY `shop14WarehouseInputlog_itemName_index` (`itemName`),
                                           KEY `shop14WarehouseInputlog_logid_index` (`logid`),
                                           KEY `shop14WarehouseInputlog_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop14WarehouseInputlog`
--

LOCK TABLES `shop14WarehouseInputlog` WRITE;
/*!40000 ALTER TABLE `shop14WarehouseInputlog` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop14WarehouseInputlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop14WarehouseOutputSum`
--

DROP TABLE IF EXISTS `shop14WarehouseOutputSum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop14WarehouseOutputSum` (
                                            `logid` varchar(100) DEFAULT NULL,
                                            `id` varchar(100) DEFAULT NULL,
                                            `count_week` int DEFAULT NULL,
                                            `count_month` int DEFAULT NULL,
                                            `ifalert_week` tinyint(1) DEFAULT NULL,
                                            `ifalert_month` tinyint(1) DEFAULT NULL,
                                            `time` varchar(100) DEFAULT NULL,
                                            `category` varchar(100) DEFAULT NULL,
                                            KEY `shop14WarehouseOutputSum_id_index` (`id`),
                                            KEY `shop14WarehouseOutputSum_logid_index` (`logid`),
                                            KEY `shop14WarehouseOutputSum_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop14WarehouseOutputSum`
--

LOCK TABLES `shop14WarehouseOutputSum` WRITE;
/*!40000 ALTER TABLE `shop14WarehouseOutputSum` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop14WarehouseOutputSum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop1WarehouseInputlog`
--

DROP TABLE IF EXISTS `shop1WarehouseInputlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop1WarehouseInputlog` (
                                          `logid` varchar(100) DEFAULT NULL,
                                          `id` varchar(100) DEFAULT NULL,
                                          `itemName` varchar(100) DEFAULT NULL,
                                          `brand` varchar(100) DEFAULT NULL,
                                          `itemCount` int DEFAULT NULL,
                                          `singlePrice` double DEFAULT NULL,
                                          `totalPrice` double DEFAULT NULL,
                                          `memo` varchar(100) DEFAULT NULL,
                                          `time` varchar(100) DEFAULT NULL,
                                          `category` varchar(100) DEFAULT NULL,
                                          `action` varchar(100) DEFAULT NULL,
                                          `from` varchar(100) DEFAULT NULL,
                                          `to` varchar(100) DEFAULT NULL,
                                          `ifComplete` tinyint(1) DEFAULT NULL,
                                          `ifConfirm` tinyint(1) DEFAULT NULL,
                                          KEY `shop1WarehouseInputlog_action_index` (`action`),
                                          KEY `shop1WarehouseInputlog_id_index` (`id`),
                                          KEY `shop1WarehouseInputlog_itemName_index` (`itemName`),
                                          KEY `shop1WarehouseInputlog_logid_index` (`logid`),
                                          KEY `shop1WarehouseInputlog_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop1WarehouseInputlog`
--

LOCK TABLES `shop1WarehouseInputlog` WRITE;
/*!40000 ALTER TABLE `shop1WarehouseInputlog` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop1WarehouseInputlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop1WarehouseOutputSum`
--

DROP TABLE IF EXISTS `shop1WarehouseOutputSum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop1WarehouseOutputSum` (
                                           `logid` varchar(100) DEFAULT NULL,
                                           `id` varchar(100) DEFAULT NULL,
                                           `count_week` int DEFAULT NULL,
                                           `count_month` int DEFAULT NULL,
                                           `ifalert_week` tinyint(1) DEFAULT NULL,
                                           `ifalert_month` tinyint(1) DEFAULT NULL,
                                           `time` varchar(100) DEFAULT NULL,
                                           `category` varchar(100) DEFAULT NULL,
                                           KEY `shop1WarehouseOutputSum_id_index` (`id`),
                                           KEY `shop1WarehouseOutputSum_logid_index` (`logid`),
                                           KEY `shop1WarehouseOutputSum_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop1WarehouseOutputSum`
--

LOCK TABLES `shop1WarehouseOutputSum` WRITE;
/*!40000 ALTER TABLE `shop1WarehouseOutputSum` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop1WarehouseOutputSum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop2WarehouseInputlog`
--

DROP TABLE IF EXISTS `shop2WarehouseInputlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop2WarehouseInputlog` (
                                          `logid` varchar(100) DEFAULT NULL,
                                          `id` varchar(100) DEFAULT NULL,
                                          `itemName` varchar(100) DEFAULT NULL,
                                          `brand` varchar(100) DEFAULT NULL,
                                          `itemCount` int DEFAULT NULL,
                                          `singlePrice` double DEFAULT NULL,
                                          `totalPrice` double DEFAULT NULL,
                                          `memo` varchar(100) DEFAULT NULL,
                                          `time` varchar(100) DEFAULT NULL,
                                          `category` varchar(100) DEFAULT NULL,
                                          `action` varchar(100) DEFAULT NULL,
                                          `from` varchar(100) DEFAULT NULL,
                                          `to` varchar(100) DEFAULT NULL,
                                          `ifComplete` tinyint(1) DEFAULT NULL,
                                          `ifConfirm` tinyint(1) DEFAULT NULL,
                                          KEY `shop2WarehouseInputlog_action_index` (`action`),
                                          KEY `shop2WarehouseInputlog_id_index` (`id`),
                                          KEY `shop2WarehouseInputlog_itemName_index` (`itemName`),
                                          KEY `shop2WarehouseInputlog_logid_index` (`logid`),
                                          KEY `shop2WarehouseInputlog_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop2WarehouseInputlog`
--

LOCK TABLES `shop2WarehouseInputlog` WRITE;
/*!40000 ALTER TABLE `shop2WarehouseInputlog` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop2WarehouseInputlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop2WarehouseOutputSum`
--

DROP TABLE IF EXISTS `shop2WarehouseOutputSum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop2WarehouseOutputSum` (
                                           `logid` varchar(100) DEFAULT NULL,
                                           `id` varchar(100) DEFAULT NULL,
                                           `count_week` int DEFAULT NULL,
                                           `count_month` int DEFAULT NULL,
                                           `ifalert_week` tinyint(1) DEFAULT NULL,
                                           `ifalert_month` tinyint(1) DEFAULT NULL,
                                           `time` varchar(100) DEFAULT NULL,
                                           `category` varchar(100) DEFAULT NULL,
                                           KEY `shop2WarehouseOutputSum_id_index` (`id`),
                                           KEY `shop2WarehouseOutputSum_logid_index` (`logid`),
                                           KEY `shop2WarehouseOutputSum_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop2WarehouseOutputSum`
--

LOCK TABLES `shop2WarehouseOutputSum` WRITE;
/*!40000 ALTER TABLE `shop2WarehouseOutputSum` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop2WarehouseOutputSum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop3WarehouseInputlog`
--

DROP TABLE IF EXISTS `shop3WarehouseInputlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop3WarehouseInputlog` (
                                          `logid` varchar(100) DEFAULT NULL,
                                          `id` varchar(100) DEFAULT NULL,
                                          `itemName` varchar(100) DEFAULT NULL,
                                          `brand` varchar(100) DEFAULT NULL,
                                          `itemCount` int DEFAULT NULL,
                                          `singlePrice` double DEFAULT NULL,
                                          `totalPrice` double DEFAULT NULL,
                                          `memo` varchar(100) DEFAULT NULL,
                                          `time` varchar(100) DEFAULT NULL,
                                          `category` varchar(100) DEFAULT NULL,
                                          `action` varchar(100) DEFAULT NULL,
                                          `from` varchar(100) DEFAULT NULL,
                                          `to` varchar(100) DEFAULT NULL,
                                          `ifComplete` tinyint(1) DEFAULT NULL,
                                          `ifConfirm` tinyint(1) DEFAULT NULL,
                                          KEY `shop3WarehouseInputlog_action_index` (`action`),
                                          KEY `shop3WarehouseInputlog_id_index` (`id`),
                                          KEY `shop3WarehouseInputlog_itemName_index` (`itemName`),
                                          KEY `shop3WarehouseInputlog_logid_index` (`logid`),
                                          KEY `shop3WarehouseInputlog_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop3WarehouseInputlog`
--

LOCK TABLES `shop3WarehouseInputlog` WRITE;
/*!40000 ALTER TABLE `shop3WarehouseInputlog` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop3WarehouseInputlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop3WarehouseOutputSum`
--

DROP TABLE IF EXISTS `shop3WarehouseOutputSum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop3WarehouseOutputSum` (
                                           `logid` varchar(100) DEFAULT NULL,
                                           `id` varchar(100) DEFAULT NULL,
                                           `count_week` int DEFAULT NULL,
                                           `count_month` int DEFAULT NULL,
                                           `ifalert_week` tinyint(1) DEFAULT NULL,
                                           `ifalert_month` tinyint(1) DEFAULT NULL,
                                           `time` varchar(100) DEFAULT NULL,
                                           `category` varchar(100) DEFAULT NULL,
                                           KEY `shop3WarehouseOutputSum_id_index` (`id`),
                                           KEY `shop3WarehouseOutputSum_logid_index` (`logid`),
                                           KEY `shop3WarehouseOutputSum_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop3WarehouseOutputSum`
--

LOCK TABLES `shop3WarehouseOutputSum` WRITE;
/*!40000 ALTER TABLE `shop3WarehouseOutputSum` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop3WarehouseOutputSum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop4WarehouseInputlog`
--

DROP TABLE IF EXISTS `shop4WarehouseInputlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop4WarehouseInputlog` (
                                          `logid` varchar(100) DEFAULT NULL,
                                          `id` varchar(100) DEFAULT NULL,
                                          `itemName` varchar(100) DEFAULT NULL,
                                          `brand` varchar(100) DEFAULT NULL,
                                          `itemCount` int DEFAULT NULL,
                                          `singlePrice` double DEFAULT NULL,
                                          `totalPrice` double DEFAULT NULL,
                                          `memo` varchar(100) DEFAULT NULL,
                                          `time` varchar(100) DEFAULT NULL,
                                          `category` varchar(100) DEFAULT NULL,
                                          `action` varchar(100) DEFAULT NULL,
                                          `from` varchar(100) DEFAULT NULL,
                                          `to` varchar(100) DEFAULT NULL,
                                          `ifComplete` tinyint(1) DEFAULT NULL,
                                          `ifConfirm` tinyint(1) DEFAULT NULL,
                                          KEY `shop4WarehouseInputlog_action_index` (`action`),
                                          KEY `shop4WarehouseInputlog_id_index` (`id`),
                                          KEY `shop4WarehouseInputlog_itemName_index` (`itemName`),
                                          KEY `shop4WarehouseInputlog_logid_index` (`logid`),
                                          KEY `shop4WarehouseInputlog_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop4WarehouseInputlog`
--

LOCK TABLES `shop4WarehouseInputlog` WRITE;
/*!40000 ALTER TABLE `shop4WarehouseInputlog` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop4WarehouseInputlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop4WarehouseOutputSum`
--

DROP TABLE IF EXISTS `shop4WarehouseOutputSum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop4WarehouseOutputSum` (
                                           `logid` varchar(100) DEFAULT NULL,
                                           `id` varchar(100) DEFAULT NULL,
                                           `count_week` int DEFAULT NULL,
                                           `count_month` int DEFAULT NULL,
                                           `ifalert_week` tinyint(1) DEFAULT NULL,
                                           `ifalert_month` tinyint(1) DEFAULT NULL,
                                           `time` varchar(100) DEFAULT NULL,
                                           `category` varchar(100) DEFAULT NULL,
                                           KEY `shop4WarehouseOutputSum_id_index` (`id`),
                                           KEY `shop4WarehouseOutputSum_logid_index` (`logid`),
                                           KEY `shop4WarehouseOutputSum_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop4WarehouseOutputSum`
--

LOCK TABLES `shop4WarehouseOutputSum` WRITE;
/*!40000 ALTER TABLE `shop4WarehouseOutputSum` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop4WarehouseOutputSum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop5WarehouseInputlog`
--

DROP TABLE IF EXISTS `shop5WarehouseInputlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop5WarehouseInputlog` (
                                          `logid` varchar(100) DEFAULT NULL,
                                          `id` varchar(100) DEFAULT NULL,
                                          `itemName` varchar(100) DEFAULT NULL,
                                          `brand` varchar(100) DEFAULT NULL,
                                          `itemCount` int DEFAULT NULL,
                                          `singlePrice` double DEFAULT NULL,
                                          `totalPrice` double DEFAULT NULL,
                                          `memo` varchar(100) DEFAULT NULL,
                                          `time` varchar(100) DEFAULT NULL,
                                          `category` varchar(100) DEFAULT NULL,
                                          `action` varchar(100) DEFAULT NULL,
                                          `from` varchar(100) DEFAULT NULL,
                                          `to` varchar(100) DEFAULT NULL,
                                          `ifComplete` tinyint(1) DEFAULT NULL,
                                          `ifConfirm` tinyint(1) DEFAULT NULL,
                                          KEY `shop5WarehouseInputlog_action_index` (`action`),
                                          KEY `shop5WarehouseInputlog_id_index` (`id`),
                                          KEY `shop5WarehouseInputlog_itemName_index` (`itemName`),
                                          KEY `shop5WarehouseInputlog_logid_index` (`logid`),
                                          KEY `shop5WarehouseInputlog_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop5WarehouseInputlog`
--

LOCK TABLES `shop5WarehouseInputlog` WRITE;
/*!40000 ALTER TABLE `shop5WarehouseInputlog` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop5WarehouseInputlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop5WarehouseOutputSum`
--

DROP TABLE IF EXISTS `shop5WarehouseOutputSum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop5WarehouseOutputSum` (
                                           `logid` varchar(100) DEFAULT NULL,
                                           `id` varchar(100) DEFAULT NULL,
                                           `count_week` int DEFAULT NULL,
                                           `count_month` int DEFAULT NULL,
                                           `ifalert_week` tinyint(1) DEFAULT NULL,
                                           `ifalert_month` tinyint(1) DEFAULT NULL,
                                           `time` varchar(100) DEFAULT NULL,
                                           `category` varchar(100) DEFAULT NULL,
                                           KEY `shop5WarehouseOutputSum_id_index` (`id`),
                                           KEY `shop5WarehouseOutputSum_logid_index` (`logid`),
                                           KEY `shop5WarehouseOutputSum_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop5WarehouseOutputSum`
--

LOCK TABLES `shop5WarehouseOutputSum` WRITE;
/*!40000 ALTER TABLE `shop5WarehouseOutputSum` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop5WarehouseOutputSum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop6WarehouseInputlog`
--

DROP TABLE IF EXISTS `shop6WarehouseInputlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop6WarehouseInputlog` (
                                          `logid` varchar(100) DEFAULT NULL,
                                          `id` varchar(100) DEFAULT NULL,
                                          `itemName` varchar(100) DEFAULT NULL,
                                          `brand` varchar(100) DEFAULT NULL,
                                          `itemCount` int DEFAULT NULL,
                                          `singlePrice` double DEFAULT NULL,
                                          `totalPrice` double DEFAULT NULL,
                                          `memo` varchar(100) DEFAULT NULL,
                                          `time` varchar(100) DEFAULT NULL,
                                          `category` varchar(100) DEFAULT NULL,
                                          `action` varchar(100) DEFAULT NULL,
                                          `from` varchar(100) DEFAULT NULL,
                                          `to` varchar(100) DEFAULT NULL,
                                          `ifComplete` tinyint(1) DEFAULT NULL,
                                          `ifConfirm` tinyint(1) DEFAULT NULL,
                                          KEY `shop6WarehouseInputlog_action_index` (`action`),
                                          KEY `shop6WarehouseInputlog_id_index` (`id`),
                                          KEY `shop6WarehouseInputlog_itemName_index` (`itemName`),
                                          KEY `shop6WarehouseInputlog_logid_index` (`logid`),
                                          KEY `shop6WarehouseInputlog_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop6WarehouseInputlog`
--

LOCK TABLES `shop6WarehouseInputlog` WRITE;
/*!40000 ALTER TABLE `shop6WarehouseInputlog` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop6WarehouseInputlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop6WarehouseOutputSum`
--

DROP TABLE IF EXISTS `shop6WarehouseOutputSum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop6WarehouseOutputSum` (
                                           `logid` varchar(100) DEFAULT NULL,
                                           `id` varchar(100) DEFAULT NULL,
                                           `count_week` int DEFAULT NULL,
                                           `count_month` int DEFAULT NULL,
                                           `ifalert_week` tinyint(1) DEFAULT NULL,
                                           `ifalert_month` tinyint(1) DEFAULT NULL,
                                           `time` varchar(100) DEFAULT NULL,
                                           `category` varchar(100) DEFAULT NULL,
                                           KEY `shop6WarehouseOutputSum_id_index` (`id`),
                                           KEY `shop6WarehouseOutputSum_logid_index` (`logid`),
                                           KEY `shop6WarehouseOutputSum_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop6WarehouseOutputSum`
--

LOCK TABLES `shop6WarehouseOutputSum` WRITE;
/*!40000 ALTER TABLE `shop6WarehouseOutputSum` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop6WarehouseOutputSum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop7WarehouseInputlog`
--

DROP TABLE IF EXISTS `shop7WarehouseInputlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop7WarehouseInputlog` (
                                          `logid` varchar(100) DEFAULT NULL,
                                          `id` varchar(100) DEFAULT NULL,
                                          `itemName` varchar(100) DEFAULT NULL,
                                          `brand` varchar(100) DEFAULT NULL,
                                          `itemCount` int DEFAULT NULL,
                                          `singlePrice` double DEFAULT NULL,
                                          `totalPrice` double DEFAULT NULL,
                                          `memo` varchar(100) DEFAULT NULL,
                                          `time` varchar(100) DEFAULT NULL,
                                          `category` varchar(100) DEFAULT NULL,
                                          `action` varchar(100) DEFAULT NULL,
                                          `from` varchar(100) DEFAULT NULL,
                                          `to` varchar(100) DEFAULT NULL,
                                          `ifComplete` tinyint(1) DEFAULT NULL,
                                          `ifConfirm` tinyint(1) DEFAULT NULL,
                                          KEY `shop7WarehouseInputlog_action_index` (`action`),
                                          KEY `shop7WarehouseInputlog_id_index` (`id`),
                                          KEY `shop7WarehouseInputlog_itemName_index` (`itemName`),
                                          KEY `shop7WarehouseInputlog_logid_index` (`logid`),
                                          KEY `shop7WarehouseInputlog_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop7WarehouseInputlog`
--

LOCK TABLES `shop7WarehouseInputlog` WRITE;
/*!40000 ALTER TABLE `shop7WarehouseInputlog` DISABLE KEYS */;
INSERT INTO `shop7WarehouseInputlog` VALUES ('84afc7c673fd4c0e9be0a57c4ff937bd','8eb8386bf62a46f5a797ff33062a2d9f','www','eee',1,1,1,'3333','2023-10-26 17:56:13','food','input','main0','shop7',1,1),('dd24d8f5f3f742929f84d8245a04467c','8eb8386bf62a46f5a797ff33062a2d9f','www','eee',1,1,1,'3333','2023-10-26 18:42:25','food','input','main0','shop7',1,1);
/*!40000 ALTER TABLE `shop7WarehouseInputlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop7WarehouseOutputSum`
--

DROP TABLE IF EXISTS `shop7WarehouseOutputSum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop7WarehouseOutputSum` (
                                           `logid` varchar(100) DEFAULT NULL,
                                           `id` varchar(100) DEFAULT NULL,
                                           `count_week` int DEFAULT NULL,
                                           `count_month` int DEFAULT NULL,
                                           `ifalert_week` tinyint(1) DEFAULT NULL,
                                           `ifalert_month` tinyint(1) DEFAULT NULL,
                                           `time` varchar(100) DEFAULT NULL,
                                           `category` varchar(100) DEFAULT NULL,
                                           KEY `shop7WarehouseOutputSum_id_index` (`id`),
                                           KEY `shop7WarehouseOutputSum_logid_index` (`logid`),
                                           KEY `shop7WarehouseOutputSum_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop7WarehouseOutputSum`
--

LOCK TABLES `shop7WarehouseOutputSum` WRITE;
/*!40000 ALTER TABLE `shop7WarehouseOutputSum` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop7WarehouseOutputSum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop8WarehouseInputlog`
--

DROP TABLE IF EXISTS `shop8WarehouseInputlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop8WarehouseInputlog` (
                                          `logid` varchar(100) DEFAULT NULL,
                                          `id` varchar(100) DEFAULT NULL,
                                          `itemName` varchar(100) DEFAULT NULL,
                                          `brand` varchar(100) DEFAULT NULL,
                                          `itemCount` int DEFAULT NULL,
                                          `singlePrice` double DEFAULT NULL,
                                          `totalPrice` double DEFAULT NULL,
                                          `memo` varchar(100) DEFAULT NULL,
                                          `time` varchar(100) DEFAULT NULL,
                                          `category` varchar(100) DEFAULT NULL,
                                          `action` varchar(100) DEFAULT NULL,
                                          `from` varchar(100) DEFAULT NULL,
                                          `to` varchar(100) DEFAULT NULL,
                                          `ifComplete` tinyint(1) DEFAULT NULL,
                                          `ifConfirm` tinyint(1) DEFAULT NULL,
                                          KEY `shop8WarehouseInputlog_action_index` (`action`),
                                          KEY `shop8WarehouseInputlog_id_index` (`id`),
                                          KEY `shop8WarehouseInputlog_itemName_index` (`itemName`),
                                          KEY `shop8WarehouseInputlog_logid_index` (`logid`),
                                          KEY `shop8WarehouseInputlog_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop8WarehouseInputlog`
--

LOCK TABLES `shop8WarehouseInputlog` WRITE;
/*!40000 ALTER TABLE `shop8WarehouseInputlog` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop8WarehouseInputlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop8WarehouseOutputSum`
--

DROP TABLE IF EXISTS `shop8WarehouseOutputSum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop8WarehouseOutputSum` (
                                           `logid` varchar(100) DEFAULT NULL,
                                           `id` varchar(100) DEFAULT NULL,
                                           `count_week` int DEFAULT NULL,
                                           `count_month` int DEFAULT NULL,
                                           `ifalert_week` tinyint(1) DEFAULT NULL,
                                           `ifalert_month` tinyint(1) DEFAULT NULL,
                                           `time` varchar(100) DEFAULT NULL,
                                           `category` varchar(100) DEFAULT NULL,
                                           KEY `shop8WarehouseOutputSum_id_index` (`id`),
                                           KEY `shop8WarehouseOutputSum_logid_index` (`logid`),
                                           KEY `shop8WarehouseOutputSum_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop8WarehouseOutputSum`
--

LOCK TABLES `shop8WarehouseOutputSum` WRITE;
/*!40000 ALTER TABLE `shop8WarehouseOutputSum` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop8WarehouseOutputSum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop9WarehouseInputlog`
--

DROP TABLE IF EXISTS `shop9WarehouseInputlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop9WarehouseInputlog` (
                                          `logid` varchar(100) DEFAULT NULL,
                                          `id` varchar(100) DEFAULT NULL,
                                          `itemName` varchar(100) DEFAULT NULL,
                                          `brand` varchar(100) DEFAULT NULL,
                                          `itemCount` int DEFAULT NULL,
                                          `singlePrice` double DEFAULT NULL,
                                          `totalPrice` double DEFAULT NULL,
                                          `memo` varchar(100) DEFAULT NULL,
                                          `time` varchar(100) DEFAULT NULL,
                                          `category` varchar(100) DEFAULT NULL,
                                          `action` varchar(100) DEFAULT NULL,
                                          `from` varchar(100) DEFAULT NULL,
                                          `to` varchar(100) DEFAULT NULL,
                                          `ifComplete` tinyint(1) DEFAULT NULL,
                                          `ifConfirm` tinyint(1) DEFAULT NULL,
                                          KEY `shop9WarehouseInputlog_action_index` (`action`),
                                          KEY `shop9WarehouseInputlog_id_index` (`id`),
                                          KEY `shop9WarehouseInputlog_itemName_index` (`itemName`),
                                          KEY `shop9WarehouseInputlog_logid_index` (`logid`),
                                          KEY `shop9WarehouseInputlog_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop9WarehouseInputlog`
--

LOCK TABLES `shop9WarehouseInputlog` WRITE;
/*!40000 ALTER TABLE `shop9WarehouseInputlog` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop9WarehouseInputlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop9WarehouseOutputSum`
--

DROP TABLE IF EXISTS `shop9WarehouseOutputSum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shop9WarehouseOutputSum` (
                                           `logid` varchar(100) DEFAULT NULL,
                                           `id` varchar(100) DEFAULT NULL,
                                           `count_week` int DEFAULT NULL,
                                           `count_month` int DEFAULT NULL,
                                           `ifalert_week` tinyint(1) DEFAULT NULL,
                                           `ifalert_month` tinyint(1) DEFAULT NULL,
                                           `time` varchar(100) DEFAULT NULL,
                                           `category` varchar(100) DEFAULT NULL,
                                           KEY `shop9WarehouseOutputSum_id_index` (`id`),
                                           KEY `shop9WarehouseOutputSum_logid_index` (`logid`),
                                           KEY `shop9WarehouseOutputSum_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop9WarehouseOutputSum`
--

LOCK TABLES `shop9WarehouseOutputSum` WRITE;
/*!40000 ALTER TABLE `shop9WarehouseOutputSum` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop9WarehouseOutputSum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse10_commercialItem`
--

DROP TABLE IF EXISTS `shopWarehouse10_commercialItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse10_commercialItem` (
                                                  `id` varchar(100) DEFAULT NULL,
                                                  `itemCount` int DEFAULT NULL,
                                                  `singlePrice` double DEFAULT NULL,
                                                  `totalPrice` double DEFAULT NULL,
                                                  `memo` varchar(100) DEFAULT NULL,
                                                  KEY `shopWarehouse10_commercialItem_id_index` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse10_commercialItem`
--

LOCK TABLES `shopWarehouse10_commercialItem` WRITE;
/*!40000 ALTER TABLE `shopWarehouse10_commercialItem` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse10_commercialItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse10_food`
--

DROP TABLE IF EXISTS `shopWarehouse10_food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse10_food` (
                                        `id` varchar(100) NOT NULL,
                                        `itemCount` int DEFAULT NULL,
                                        `singlePrice` double DEFAULT NULL,
                                        `totalPrice` double DEFAULT NULL,
                                        `memo` varchar(100) DEFAULT NULL,
                                        PRIMARY KEY (`id`),
                                        UNIQUE KEY `shopWarehouse10_food_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse10_food`
--

LOCK TABLES `shopWarehouse10_food` WRITE;
/*!40000 ALTER TABLE `shopWarehouse10_food` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse10_food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse10_others`
--

DROP TABLE IF EXISTS `shopWarehouse10_others`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse10_others` (
                                          `id` varchar(100) NOT NULL,
                                          `itemCount` int DEFAULT NULL,
                                          `singlePrice` double DEFAULT NULL,
                                          `totalPrice` double DEFAULT NULL,
                                          `memo` varchar(100) DEFAULT NULL,
                                          PRIMARY KEY (`id`),
                                          UNIQUE KEY `shopWarehouse10_others_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse10_others`
--

LOCK TABLES `shopWarehouse10_others` WRITE;
/*!40000 ALTER TABLE `shopWarehouse10_others` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse10_others` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse10_smallTool`
--

DROP TABLE IF EXISTS `shopWarehouse10_smallTool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse10_smallTool` (
                                             `id` varchar(100) NOT NULL,
                                             `itemCount` int DEFAULT NULL,
                                             `singlePrice` double DEFAULT NULL,
                                             `totalPrice` double DEFAULT NULL,
                                             `memo` varchar(100) DEFAULT NULL,
                                             PRIMARY KEY (`id`),
                                             UNIQUE KEY `shopWarehouse10_smallTool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse10_smallTool`
--

LOCK TABLES `shopWarehouse10_smallTool` WRITE;
/*!40000 ALTER TABLE `shopWarehouse10_smallTool` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse10_smallTool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse10_tool`
--

DROP TABLE IF EXISTS `shopWarehouse10_tool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse10_tool` (
                                        `id` varchar(100) NOT NULL,
                                        `itemCount` int DEFAULT NULL,
                                        `singlePrice` double DEFAULT NULL,
                                        `totalPrice` double DEFAULT NULL,
                                        `memo` varchar(100) DEFAULT NULL,
                                        PRIMARY KEY (`id`),
                                        UNIQUE KEY `shopWarehouse10_tool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse10_tool`
--

LOCK TABLES `shopWarehouse10_tool` WRITE;
/*!40000 ALTER TABLE `shopWarehouse10_tool` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse10_tool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse11_commercialItem`
--

DROP TABLE IF EXISTS `shopWarehouse11_commercialItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse11_commercialItem` (
                                                  `id` varchar(100) DEFAULT NULL,
                                                  `itemCount` int DEFAULT NULL,
                                                  `singlePrice` double DEFAULT NULL,
                                                  `totalPrice` double DEFAULT NULL,
                                                  `memo` varchar(100) DEFAULT NULL,
                                                  KEY `shopWarehouse11_commercialItem_id_index` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse11_commercialItem`
--

LOCK TABLES `shopWarehouse11_commercialItem` WRITE;
/*!40000 ALTER TABLE `shopWarehouse11_commercialItem` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse11_commercialItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse11_food`
--

DROP TABLE IF EXISTS `shopWarehouse11_food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse11_food` (
                                        `id` varchar(100) NOT NULL,
                                        `itemCount` int DEFAULT NULL,
                                        `singlePrice` double DEFAULT NULL,
                                        `totalPrice` double DEFAULT NULL,
                                        `memo` varchar(100) DEFAULT NULL,
                                        PRIMARY KEY (`id`),
                                        UNIQUE KEY `shopWarehouse11_food_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse11_food`
--

LOCK TABLES `shopWarehouse11_food` WRITE;
/*!40000 ALTER TABLE `shopWarehouse11_food` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse11_food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse11_others`
--

DROP TABLE IF EXISTS `shopWarehouse11_others`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse11_others` (
                                          `id` varchar(100) NOT NULL,
                                          `itemCount` int DEFAULT NULL,
                                          `singlePrice` double DEFAULT NULL,
                                          `totalPrice` double DEFAULT NULL,
                                          `memo` varchar(100) DEFAULT NULL,
                                          PRIMARY KEY (`id`),
                                          UNIQUE KEY `shopWarehouse11_others_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse11_others`
--

LOCK TABLES `shopWarehouse11_others` WRITE;
/*!40000 ALTER TABLE `shopWarehouse11_others` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse11_others` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse11_smallTool`
--

DROP TABLE IF EXISTS `shopWarehouse11_smallTool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse11_smallTool` (
                                             `id` varchar(100) NOT NULL,
                                             `itemCount` int DEFAULT NULL,
                                             `singlePrice` double DEFAULT NULL,
                                             `totalPrice` double DEFAULT NULL,
                                             `memo` varchar(100) DEFAULT NULL,
                                             PRIMARY KEY (`id`),
                                             UNIQUE KEY `shopWarehouse11_smallTool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse11_smallTool`
--

LOCK TABLES `shopWarehouse11_smallTool` WRITE;
/*!40000 ALTER TABLE `shopWarehouse11_smallTool` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse11_smallTool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse11_tool`
--

DROP TABLE IF EXISTS `shopWarehouse11_tool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse11_tool` (
                                        `id` varchar(100) NOT NULL,
                                        `itemCount` int DEFAULT NULL,
                                        `singlePrice` double DEFAULT NULL,
                                        `totalPrice` double DEFAULT NULL,
                                        `memo` varchar(100) DEFAULT NULL,
                                        PRIMARY KEY (`id`),
                                        UNIQUE KEY `shopWarehouse11_tool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse11_tool`
--

LOCK TABLES `shopWarehouse11_tool` WRITE;
/*!40000 ALTER TABLE `shopWarehouse11_tool` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse11_tool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse12_commercialItem`
--

DROP TABLE IF EXISTS `shopWarehouse12_commercialItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse12_commercialItem` (
                                                  `id` varchar(100) DEFAULT NULL,
                                                  `itemCount` int DEFAULT NULL,
                                                  `singlePrice` double DEFAULT NULL,
                                                  `totalPrice` double DEFAULT NULL,
                                                  `memo` varchar(100) DEFAULT NULL,
                                                  KEY `shopWarehouse12_commercialItem_id_index` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse12_commercialItem`
--

LOCK TABLES `shopWarehouse12_commercialItem` WRITE;
/*!40000 ALTER TABLE `shopWarehouse12_commercialItem` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse12_commercialItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse12_food`
--

DROP TABLE IF EXISTS `shopWarehouse12_food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse12_food` (
                                        `id` varchar(100) NOT NULL,
                                        `itemCount` int DEFAULT NULL,
                                        `singlePrice` double DEFAULT NULL,
                                        `totalPrice` double DEFAULT NULL,
                                        `memo` varchar(100) DEFAULT NULL,
                                        PRIMARY KEY (`id`),
                                        UNIQUE KEY `shopWarehouse12_food_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse12_food`
--

LOCK TABLES `shopWarehouse12_food` WRITE;
/*!40000 ALTER TABLE `shopWarehouse12_food` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse12_food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse12_others`
--

DROP TABLE IF EXISTS `shopWarehouse12_others`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse12_others` (
                                          `id` varchar(100) NOT NULL,
                                          `itemCount` int DEFAULT NULL,
                                          `singlePrice` double DEFAULT NULL,
                                          `totalPrice` double DEFAULT NULL,
                                          `memo` varchar(100) DEFAULT NULL,
                                          PRIMARY KEY (`id`),
                                          UNIQUE KEY `shopWarehouse12_others_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse12_others`
--

LOCK TABLES `shopWarehouse12_others` WRITE;
/*!40000 ALTER TABLE `shopWarehouse12_others` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse12_others` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse12_smallTool`
--

DROP TABLE IF EXISTS `shopWarehouse12_smallTool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse12_smallTool` (
                                             `id` varchar(100) NOT NULL,
                                             `itemCount` int DEFAULT NULL,
                                             `singlePrice` double DEFAULT NULL,
                                             `totalPrice` double DEFAULT NULL,
                                             `memo` varchar(100) DEFAULT NULL,
                                             PRIMARY KEY (`id`),
                                             UNIQUE KEY `shopWarehouse12_smallTool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse12_smallTool`
--

LOCK TABLES `shopWarehouse12_smallTool` WRITE;
/*!40000 ALTER TABLE `shopWarehouse12_smallTool` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse12_smallTool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse12_tool`
--

DROP TABLE IF EXISTS `shopWarehouse12_tool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse12_tool` (
                                        `id` varchar(100) NOT NULL,
                                        `itemCount` int DEFAULT NULL,
                                        `singlePrice` double DEFAULT NULL,
                                        `totalPrice` double DEFAULT NULL,
                                        `memo` varchar(100) DEFAULT NULL,
                                        PRIMARY KEY (`id`),
                                        UNIQUE KEY `shopWarehouse12_tool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse12_tool`
--

LOCK TABLES `shopWarehouse12_tool` WRITE;
/*!40000 ALTER TABLE `shopWarehouse12_tool` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse12_tool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse13_commercialItem`
--

DROP TABLE IF EXISTS `shopWarehouse13_commercialItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse13_commercialItem` (
                                                  `id` varchar(100) DEFAULT NULL,
                                                  `itemCount` int DEFAULT NULL,
                                                  `singlePrice` double DEFAULT NULL,
                                                  `totalPrice` double DEFAULT NULL,
                                                  `memo` varchar(100) DEFAULT NULL,
                                                  KEY `shopWarehouse13_commercialItem_id_index` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse13_commercialItem`
--

LOCK TABLES `shopWarehouse13_commercialItem` WRITE;
/*!40000 ALTER TABLE `shopWarehouse13_commercialItem` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse13_commercialItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse13_food`
--

DROP TABLE IF EXISTS `shopWarehouse13_food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse13_food` (
                                        `id` varchar(100) NOT NULL,
                                        `itemCount` int DEFAULT NULL,
                                        `singlePrice` double DEFAULT NULL,
                                        `totalPrice` double DEFAULT NULL,
                                        `memo` varchar(100) DEFAULT NULL,
                                        PRIMARY KEY (`id`),
                                        UNIQUE KEY `shopWarehouse13_food_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse13_food`
--

LOCK TABLES `shopWarehouse13_food` WRITE;
/*!40000 ALTER TABLE `shopWarehouse13_food` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse13_food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse13_others`
--

DROP TABLE IF EXISTS `shopWarehouse13_others`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse13_others` (
                                          `id` varchar(100) NOT NULL,
                                          `itemCount` int DEFAULT NULL,
                                          `singlePrice` double DEFAULT NULL,
                                          `totalPrice` double DEFAULT NULL,
                                          `memo` varchar(100) DEFAULT NULL,
                                          PRIMARY KEY (`id`),
                                          UNIQUE KEY `shopWarehouse13_others_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse13_others`
--

LOCK TABLES `shopWarehouse13_others` WRITE;
/*!40000 ALTER TABLE `shopWarehouse13_others` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse13_others` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse13_smallTool`
--

DROP TABLE IF EXISTS `shopWarehouse13_smallTool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse13_smallTool` (
                                             `id` varchar(100) NOT NULL,
                                             `itemCount` int DEFAULT NULL,
                                             `singlePrice` double DEFAULT NULL,
                                             `totalPrice` double DEFAULT NULL,
                                             `memo` varchar(100) DEFAULT NULL,
                                             PRIMARY KEY (`id`),
                                             UNIQUE KEY `shopWarehouse13_smallTool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse13_smallTool`
--

LOCK TABLES `shopWarehouse13_smallTool` WRITE;
/*!40000 ALTER TABLE `shopWarehouse13_smallTool` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse13_smallTool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse13_tool`
--

DROP TABLE IF EXISTS `shopWarehouse13_tool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse13_tool` (
                                        `id` varchar(100) NOT NULL,
                                        `itemCount` int DEFAULT NULL,
                                        `singlePrice` double DEFAULT NULL,
                                        `totalPrice` double DEFAULT NULL,
                                        `memo` varchar(100) DEFAULT NULL,
                                        PRIMARY KEY (`id`),
                                        UNIQUE KEY `shopWarehouse13_tool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse13_tool`
--

LOCK TABLES `shopWarehouse13_tool` WRITE;
/*!40000 ALTER TABLE `shopWarehouse13_tool` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse13_tool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse14_commercialItem`
--

DROP TABLE IF EXISTS `shopWarehouse14_commercialItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse14_commercialItem` (
                                                  `id` varchar(100) DEFAULT NULL,
                                                  `itemCount` int DEFAULT NULL,
                                                  `singlePrice` double DEFAULT NULL,
                                                  `totalPrice` double DEFAULT NULL,
                                                  `memo` varchar(100) DEFAULT NULL,
                                                  KEY `shopWarehouse14_commercialItem_id_index` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse14_commercialItem`
--

LOCK TABLES `shopWarehouse14_commercialItem` WRITE;
/*!40000 ALTER TABLE `shopWarehouse14_commercialItem` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse14_commercialItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse14_food`
--

DROP TABLE IF EXISTS `shopWarehouse14_food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse14_food` (
                                        `id` varchar(100) NOT NULL,
                                        `itemCount` int DEFAULT NULL,
                                        `singlePrice` double DEFAULT NULL,
                                        `totalPrice` double DEFAULT NULL,
                                        `memo` varchar(100) DEFAULT NULL,
                                        PRIMARY KEY (`id`),
                                        UNIQUE KEY `shopWarehouse14_food_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse14_food`
--

LOCK TABLES `shopWarehouse14_food` WRITE;
/*!40000 ALTER TABLE `shopWarehouse14_food` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse14_food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse14_others`
--

DROP TABLE IF EXISTS `shopWarehouse14_others`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse14_others` (
                                          `id` varchar(100) NOT NULL,
                                          `itemCount` int DEFAULT NULL,
                                          `singlePrice` double DEFAULT NULL,
                                          `totalPrice` double DEFAULT NULL,
                                          `memo` varchar(100) DEFAULT NULL,
                                          PRIMARY KEY (`id`),
                                          UNIQUE KEY `shopWarehouse14_others_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse14_others`
--

LOCK TABLES `shopWarehouse14_others` WRITE;
/*!40000 ALTER TABLE `shopWarehouse14_others` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse14_others` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse14_smallTool`
--

DROP TABLE IF EXISTS `shopWarehouse14_smallTool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse14_smallTool` (
                                             `id` varchar(100) NOT NULL,
                                             `itemCount` int DEFAULT NULL,
                                             `singlePrice` double DEFAULT NULL,
                                             `totalPrice` double DEFAULT NULL,
                                             `memo` varchar(100) DEFAULT NULL,
                                             PRIMARY KEY (`id`),
                                             UNIQUE KEY `shopWarehouse14_smallTool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse14_smallTool`
--

LOCK TABLES `shopWarehouse14_smallTool` WRITE;
/*!40000 ALTER TABLE `shopWarehouse14_smallTool` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse14_smallTool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse14_tool`
--

DROP TABLE IF EXISTS `shopWarehouse14_tool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse14_tool` (
                                        `id` varchar(100) NOT NULL,
                                        `itemCount` int DEFAULT NULL,
                                        `singlePrice` double DEFAULT NULL,
                                        `totalPrice` double DEFAULT NULL,
                                        `memo` varchar(100) DEFAULT NULL,
                                        PRIMARY KEY (`id`),
                                        UNIQUE KEY `shopWarehouse14_tool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse14_tool`
--

LOCK TABLES `shopWarehouse14_tool` WRITE;
/*!40000 ALTER TABLE `shopWarehouse14_tool` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse14_tool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse1_commercialItem`
--

DROP TABLE IF EXISTS `shopWarehouse1_commercialItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse1_commercialItem` (
                                                 `id` varchar(100) NOT NULL,
                                                 `itemCount` int DEFAULT NULL,
                                                 `singlePrice` double DEFAULT NULL,
                                                 `totalPrice` double DEFAULT NULL,
                                                 `memo` varchar(100) DEFAULT NULL,
                                                 PRIMARY KEY (`id`),
                                                 UNIQUE KEY `shopWarehouse1_commercialItem_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse1_commercialItem`
--

LOCK TABLES `shopWarehouse1_commercialItem` WRITE;
/*!40000 ALTER TABLE `shopWarehouse1_commercialItem` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse1_commercialItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse1_food`
--

DROP TABLE IF EXISTS `shopWarehouse1_food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse1_food` (
                                       `id` varchar(100) NOT NULL,
                                       `itemCount` int DEFAULT NULL,
                                       `singlePrice` double DEFAULT NULL,
                                       `totalPrice` double DEFAULT NULL,
                                       `memo` varchar(100) DEFAULT NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `shopWarehouse1_food_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse1_food`
--

LOCK TABLES `shopWarehouse1_food` WRITE;
/*!40000 ALTER TABLE `shopWarehouse1_food` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse1_food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse1_others`
--

DROP TABLE IF EXISTS `shopWarehouse1_others`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse1_others` (
                                         `id` varchar(100) NOT NULL,
                                         `itemCount` int DEFAULT NULL,
                                         `singlePrice` double DEFAULT NULL,
                                         `totalPrice` double DEFAULT NULL,
                                         `memo` varchar(100) DEFAULT NULL,
                                         PRIMARY KEY (`id`),
                                         UNIQUE KEY `shopWarehouse1_others_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse1_others`
--

LOCK TABLES `shopWarehouse1_others` WRITE;
/*!40000 ALTER TABLE `shopWarehouse1_others` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse1_others` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse1_smallTool`
--

DROP TABLE IF EXISTS `shopWarehouse1_smallTool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse1_smallTool` (
                                            `id` varchar(100) NOT NULL,
                                            `itemCount` int DEFAULT NULL,
                                            `singlePrice` double DEFAULT NULL,
                                            `totalPrice` double DEFAULT NULL,
                                            `memo` varchar(100) DEFAULT NULL,
                                            PRIMARY KEY (`id`),
                                            UNIQUE KEY `shopWarehouse1_smallTool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse1_smallTool`
--

LOCK TABLES `shopWarehouse1_smallTool` WRITE;
/*!40000 ALTER TABLE `shopWarehouse1_smallTool` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse1_smallTool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse1_tool`
--

DROP TABLE IF EXISTS `shopWarehouse1_tool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse1_tool` (
                                       `id` varchar(100) NOT NULL,
                                       `itemCount` int DEFAULT NULL,
                                       `singlePrice` double DEFAULT NULL,
                                       `totalPrice` double DEFAULT NULL,
                                       `memo` varchar(100) DEFAULT NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `shopWarehouse1_tool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse1_tool`
--

LOCK TABLES `shopWarehouse1_tool` WRITE;
/*!40000 ALTER TABLE `shopWarehouse1_tool` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse1_tool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse2_commercialItem`
--

DROP TABLE IF EXISTS `shopWarehouse2_commercialItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse2_commercialItem` (
                                                 `id` varchar(100) NOT NULL,
                                                 `itemCount` int DEFAULT NULL,
                                                 `singlePrice` double DEFAULT NULL,
                                                 `totalPrice` double DEFAULT NULL,
                                                 `memo` varchar(100) DEFAULT NULL,
                                                 PRIMARY KEY (`id`),
                                                 UNIQUE KEY `shopWarehouse2_commercialItem_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse2_commercialItem`
--

LOCK TABLES `shopWarehouse2_commercialItem` WRITE;
/*!40000 ALTER TABLE `shopWarehouse2_commercialItem` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse2_commercialItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse2_food`
--

DROP TABLE IF EXISTS `shopWarehouse2_food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse2_food` (
                                       `id` varchar(100) NOT NULL,
                                       `itemCount` int DEFAULT NULL,
                                       `singlePrice` double DEFAULT NULL,
                                       `totalPrice` double DEFAULT NULL,
                                       `memo` varchar(100) DEFAULT NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `shopWarehouse2_food_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse2_food`
--

LOCK TABLES `shopWarehouse2_food` WRITE;
/*!40000 ALTER TABLE `shopWarehouse2_food` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse2_food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse2_others`
--

DROP TABLE IF EXISTS `shopWarehouse2_others`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse2_others` (
                                         `id` varchar(100) NOT NULL,
                                         `itemCount` int DEFAULT NULL,
                                         `singlePrice` double DEFAULT NULL,
                                         `totalPrice` double DEFAULT NULL,
                                         `memo` varchar(100) DEFAULT NULL,
                                         PRIMARY KEY (`id`),
                                         UNIQUE KEY `shopWarehouse2_others_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse2_others`
--

LOCK TABLES `shopWarehouse2_others` WRITE;
/*!40000 ALTER TABLE `shopWarehouse2_others` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse2_others` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse2_smallTool`
--

DROP TABLE IF EXISTS `shopWarehouse2_smallTool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse2_smallTool` (
                                            `id` varchar(100) NOT NULL,
                                            `itemCount` int DEFAULT NULL,
                                            `singlePrice` double DEFAULT NULL,
                                            `totalPrice` double DEFAULT NULL,
                                            `memo` varchar(100) DEFAULT NULL,
                                            PRIMARY KEY (`id`),
                                            UNIQUE KEY `shopWarehouse2_smallTool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse2_smallTool`
--

LOCK TABLES `shopWarehouse2_smallTool` WRITE;
/*!40000 ALTER TABLE `shopWarehouse2_smallTool` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse2_smallTool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse2_tool`
--

DROP TABLE IF EXISTS `shopWarehouse2_tool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse2_tool` (
                                       `id` varchar(100) NOT NULL,
                                       `itemCount` int DEFAULT NULL,
                                       `singlePrice` double DEFAULT NULL,
                                       `totalPrice` double DEFAULT NULL,
                                       `memo` varchar(100) DEFAULT NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `shopWarehouse2_tool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse2_tool`
--

LOCK TABLES `shopWarehouse2_tool` WRITE;
/*!40000 ALTER TABLE `shopWarehouse2_tool` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse2_tool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse3_commercialItem`
--

DROP TABLE IF EXISTS `shopWarehouse3_commercialItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse3_commercialItem` (
                                                 `id` varchar(100) DEFAULT NULL,
                                                 `itemCount` int DEFAULT NULL,
                                                 `singlePrice` double DEFAULT NULL,
                                                 `totalPrice` double DEFAULT NULL,
                                                 `memo` varchar(100) DEFAULT NULL,
                                                 KEY `shopWarehouse3_commercialItem_id_index` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse3_commercialItem`
--

LOCK TABLES `shopWarehouse3_commercialItem` WRITE;
/*!40000 ALTER TABLE `shopWarehouse3_commercialItem` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse3_commercialItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse3_food`
--

DROP TABLE IF EXISTS `shopWarehouse3_food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse3_food` (
                                       `id` varchar(100) NOT NULL,
                                       `itemCount` int DEFAULT NULL,
                                       `singlePrice` double DEFAULT NULL,
                                       `totalPrice` double DEFAULT NULL,
                                       `memo` varchar(100) DEFAULT NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `shopWarehouse3_food_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse3_food`
--

LOCK TABLES `shopWarehouse3_food` WRITE;
/*!40000 ALTER TABLE `shopWarehouse3_food` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse3_food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse3_others`
--

DROP TABLE IF EXISTS `shopWarehouse3_others`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse3_others` (
                                         `id` varchar(100) NOT NULL,
                                         `itemCount` int DEFAULT NULL,
                                         `singlePrice` double DEFAULT NULL,
                                         `totalPrice` double DEFAULT NULL,
                                         `memo` varchar(100) DEFAULT NULL,
                                         PRIMARY KEY (`id`),
                                         UNIQUE KEY `shopWarehouse3_others_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse3_others`
--

LOCK TABLES `shopWarehouse3_others` WRITE;
/*!40000 ALTER TABLE `shopWarehouse3_others` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse3_others` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse3_smallTool`
--

DROP TABLE IF EXISTS `shopWarehouse3_smallTool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse3_smallTool` (
                                            `id` varchar(100) NOT NULL,
                                            `itemCount` int DEFAULT NULL,
                                            `singlePrice` double DEFAULT NULL,
                                            `totalPrice` double DEFAULT NULL,
                                            `memo` varchar(100) DEFAULT NULL,
                                            PRIMARY KEY (`id`),
                                            UNIQUE KEY `shopWarehouse3_smallTool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse3_smallTool`
--

LOCK TABLES `shopWarehouse3_smallTool` WRITE;
/*!40000 ALTER TABLE `shopWarehouse3_smallTool` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse3_smallTool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse3_tool`
--

DROP TABLE IF EXISTS `shopWarehouse3_tool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse3_tool` (
                                       `id` varchar(100) NOT NULL,
                                       `itemCount` int DEFAULT NULL,
                                       `singlePrice` double DEFAULT NULL,
                                       `totalPrice` double DEFAULT NULL,
                                       `memo` varchar(100) DEFAULT NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `shopWarehouse3_tool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse3_tool`
--

LOCK TABLES `shopWarehouse3_tool` WRITE;
/*!40000 ALTER TABLE `shopWarehouse3_tool` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse3_tool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse4_commercialItem`
--

DROP TABLE IF EXISTS `shopWarehouse4_commercialItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse4_commercialItem` (
                                                 `id` varchar(100) DEFAULT NULL,
                                                 `itemCount` int DEFAULT NULL,
                                                 `singlePrice` double DEFAULT NULL,
                                                 `totalPrice` double DEFAULT NULL,
                                                 `memo` varchar(100) DEFAULT NULL,
                                                 KEY `shopWarehouse4_commercialItem_id_index` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse4_commercialItem`
--

LOCK TABLES `shopWarehouse4_commercialItem` WRITE;
/*!40000 ALTER TABLE `shopWarehouse4_commercialItem` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse4_commercialItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse4_food`
--

DROP TABLE IF EXISTS `shopWarehouse4_food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse4_food` (
                                       `id` varchar(100) NOT NULL,
                                       `itemCount` int DEFAULT NULL,
                                       `singlePrice` double DEFAULT NULL,
                                       `totalPrice` double DEFAULT NULL,
                                       `memo` varchar(100) DEFAULT NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `shopWarehouse4_food_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse4_food`
--

LOCK TABLES `shopWarehouse4_food` WRITE;
/*!40000 ALTER TABLE `shopWarehouse4_food` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse4_food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse4_others`
--

DROP TABLE IF EXISTS `shopWarehouse4_others`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse4_others` (
                                         `id` varchar(100) NOT NULL,
                                         `itemCount` int DEFAULT NULL,
                                         `singlePrice` double DEFAULT NULL,
                                         `totalPrice` double DEFAULT NULL,
                                         `memo` varchar(100) DEFAULT NULL,
                                         PRIMARY KEY (`id`),
                                         UNIQUE KEY `shopWarehouse4_others_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse4_others`
--

LOCK TABLES `shopWarehouse4_others` WRITE;
/*!40000 ALTER TABLE `shopWarehouse4_others` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse4_others` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse4_smallTool`
--

DROP TABLE IF EXISTS `shopWarehouse4_smallTool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse4_smallTool` (
                                            `id` varchar(100) NOT NULL,
                                            `itemCount` int DEFAULT NULL,
                                            `singlePrice` double DEFAULT NULL,
                                            `totalPrice` double DEFAULT NULL,
                                            `memo` varchar(100) DEFAULT NULL,
                                            PRIMARY KEY (`id`),
                                            UNIQUE KEY `shopWarehouse4_smallTool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse4_smallTool`
--

LOCK TABLES `shopWarehouse4_smallTool` WRITE;
/*!40000 ALTER TABLE `shopWarehouse4_smallTool` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse4_smallTool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse4_tool`
--

DROP TABLE IF EXISTS `shopWarehouse4_tool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse4_tool` (
                                       `id` varchar(100) NOT NULL,
                                       `itemCount` int DEFAULT NULL,
                                       `singlePrice` double DEFAULT NULL,
                                       `totalPrice` double DEFAULT NULL,
                                       `memo` varchar(100) DEFAULT NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `shopWarehouse4_tool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse4_tool`
--

LOCK TABLES `shopWarehouse4_tool` WRITE;
/*!40000 ALTER TABLE `shopWarehouse4_tool` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse4_tool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse5_commercialItem`
--

DROP TABLE IF EXISTS `shopWarehouse5_commercialItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse5_commercialItem` (
                                                 `id` varchar(100) DEFAULT NULL,
                                                 `itemCount` int DEFAULT NULL,
                                                 `singlePrice` double DEFAULT NULL,
                                                 `totalPrice` double DEFAULT NULL,
                                                 `memo` varchar(100) DEFAULT NULL,
                                                 KEY `shopWarehouse5_commercialItem_id_index` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse5_commercialItem`
--

LOCK TABLES `shopWarehouse5_commercialItem` WRITE;
/*!40000 ALTER TABLE `shopWarehouse5_commercialItem` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse5_commercialItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse5_food`
--

DROP TABLE IF EXISTS `shopWarehouse5_food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse5_food` (
                                       `id` varchar(100) NOT NULL,
                                       `itemCount` int DEFAULT NULL,
                                       `singlePrice` double DEFAULT NULL,
                                       `totalPrice` double DEFAULT NULL,
                                       `memo` varchar(100) DEFAULT NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `shopWarehouse5_food_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse5_food`
--

LOCK TABLES `shopWarehouse5_food` WRITE;
/*!40000 ALTER TABLE `shopWarehouse5_food` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse5_food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse5_others`
--

DROP TABLE IF EXISTS `shopWarehouse5_others`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse5_others` (
                                         `id` varchar(100) NOT NULL,
                                         `itemCount` int DEFAULT NULL,
                                         `singlePrice` double DEFAULT NULL,
                                         `totalPrice` double DEFAULT NULL,
                                         `memo` varchar(100) DEFAULT NULL,
                                         PRIMARY KEY (`id`),
                                         UNIQUE KEY `shopWarehouse5_others_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse5_others`
--

LOCK TABLES `shopWarehouse5_others` WRITE;
/*!40000 ALTER TABLE `shopWarehouse5_others` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse5_others` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse5_smallTool`
--

DROP TABLE IF EXISTS `shopWarehouse5_smallTool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse5_smallTool` (
                                            `id` varchar(100) NOT NULL,
                                            `itemCount` int DEFAULT NULL,
                                            `singlePrice` double DEFAULT NULL,
                                            `totalPrice` double DEFAULT NULL,
                                            `memo` varchar(100) DEFAULT NULL,
                                            PRIMARY KEY (`id`),
                                            UNIQUE KEY `shopWarehouse5_smallTool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse5_smallTool`
--

LOCK TABLES `shopWarehouse5_smallTool` WRITE;
/*!40000 ALTER TABLE `shopWarehouse5_smallTool` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse5_smallTool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse5_tool`
--

DROP TABLE IF EXISTS `shopWarehouse5_tool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse5_tool` (
                                       `id` varchar(100) NOT NULL,
                                       `itemCount` int DEFAULT NULL,
                                       `singlePrice` double DEFAULT NULL,
                                       `totalPrice` double DEFAULT NULL,
                                       `memo` varchar(100) DEFAULT NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `shopWarehouse5_tool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse5_tool`
--

LOCK TABLES `shopWarehouse5_tool` WRITE;
/*!40000 ALTER TABLE `shopWarehouse5_tool` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse5_tool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse6_commercialItem`
--

DROP TABLE IF EXISTS `shopWarehouse6_commercialItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse6_commercialItem` (
                                                 `id` varchar(100) DEFAULT NULL,
                                                 `itemCount` int DEFAULT NULL,
                                                 `singlePrice` double DEFAULT NULL,
                                                 `totalPrice` double DEFAULT NULL,
                                                 `memo` varchar(100) DEFAULT NULL,
                                                 KEY `shopWarehouse6_commercialItem_id_index` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse6_commercialItem`
--

LOCK TABLES `shopWarehouse6_commercialItem` WRITE;
/*!40000 ALTER TABLE `shopWarehouse6_commercialItem` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse6_commercialItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse6_food`
--

DROP TABLE IF EXISTS `shopWarehouse6_food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse6_food` (
                                       `id` varchar(100) NOT NULL,
                                       `itemCount` int DEFAULT NULL,
                                       `singlePrice` double DEFAULT NULL,
                                       `totalPrice` double DEFAULT NULL,
                                       `memo` varchar(100) DEFAULT NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `shopWarehouse6_food_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse6_food`
--

LOCK TABLES `shopWarehouse6_food` WRITE;
/*!40000 ALTER TABLE `shopWarehouse6_food` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse6_food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse6_others`
--

DROP TABLE IF EXISTS `shopWarehouse6_others`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse6_others` (
                                         `id` varchar(100) NOT NULL,
                                         `itemCount` int DEFAULT NULL,
                                         `singlePrice` double DEFAULT NULL,
                                         `totalPrice` double DEFAULT NULL,
                                         `memo` varchar(100) DEFAULT NULL,
                                         PRIMARY KEY (`id`),
                                         UNIQUE KEY `shopWarehouse6_others_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse6_others`
--

LOCK TABLES `shopWarehouse6_others` WRITE;
/*!40000 ALTER TABLE `shopWarehouse6_others` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse6_others` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse6_smallTool`
--

DROP TABLE IF EXISTS `shopWarehouse6_smallTool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse6_smallTool` (
                                            `id` varchar(100) NOT NULL,
                                            `itemCount` int DEFAULT NULL,
                                            `singlePrice` double DEFAULT NULL,
                                            `totalPrice` double DEFAULT NULL,
                                            `memo` varchar(100) DEFAULT NULL,
                                            PRIMARY KEY (`id`),
                                            UNIQUE KEY `shopWarehouse6_smallTool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse6_smallTool`
--

LOCK TABLES `shopWarehouse6_smallTool` WRITE;
/*!40000 ALTER TABLE `shopWarehouse6_smallTool` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse6_smallTool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse6_tool`
--

DROP TABLE IF EXISTS `shopWarehouse6_tool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse6_tool` (
                                       `id` varchar(100) NOT NULL,
                                       `itemCount` int DEFAULT NULL,
                                       `singlePrice` double DEFAULT NULL,
                                       `totalPrice` double DEFAULT NULL,
                                       `memo` varchar(100) DEFAULT NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `shopWarehouse6_tool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse6_tool`
--

LOCK TABLES `shopWarehouse6_tool` WRITE;
/*!40000 ALTER TABLE `shopWarehouse6_tool` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse6_tool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse7_commercialItem`
--

DROP TABLE IF EXISTS `shopWarehouse7_commercialItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse7_commercialItem` (
                                                 `id` varchar(100) DEFAULT NULL,
                                                 `itemCount` int DEFAULT NULL,
                                                 `singlePrice` double DEFAULT NULL,
                                                 `totalPrice` double DEFAULT NULL,
                                                 `memo` varchar(100) DEFAULT NULL,
                                                 KEY `shopWarehouse7_commercialItem_id_index` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse7_commercialItem`
--

LOCK TABLES `shopWarehouse7_commercialItem` WRITE;
/*!40000 ALTER TABLE `shopWarehouse7_commercialItem` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse7_commercialItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse7_food`
--

DROP TABLE IF EXISTS `shopWarehouse7_food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse7_food` (
                                       `id` varchar(100) NOT NULL,
                                       `itemCount` int DEFAULT NULL,
                                       `singlePrice` double DEFAULT NULL,
                                       `totalPrice` double DEFAULT NULL,
                                       `memo` varchar(100) DEFAULT NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `shopWarehouse7_food_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse7_food`
--

LOCK TABLES `shopWarehouse7_food` WRITE;
/*!40000 ALTER TABLE `shopWarehouse7_food` DISABLE KEYS */;
INSERT INTO `shopWarehouse7_food` VALUES ('8eb8386bf62a46f5a797ff33062a2d9f',2,1,2,'3333');
/*!40000 ALTER TABLE `shopWarehouse7_food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse7_others`
--

DROP TABLE IF EXISTS `shopWarehouse7_others`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse7_others` (
                                         `id` varchar(100) NOT NULL,
                                         `itemCount` int DEFAULT NULL,
                                         `singlePrice` double DEFAULT NULL,
                                         `totalPrice` double DEFAULT NULL,
                                         `memo` varchar(100) DEFAULT NULL,
                                         PRIMARY KEY (`id`),
                                         UNIQUE KEY `shopWarehouse7_others_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse7_others`
--

LOCK TABLES `shopWarehouse7_others` WRITE;
/*!40000 ALTER TABLE `shopWarehouse7_others` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse7_others` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse7_smallTool`
--

DROP TABLE IF EXISTS `shopWarehouse7_smallTool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse7_smallTool` (
                                            `id` varchar(100) NOT NULL,
                                            `itemCount` int DEFAULT NULL,
                                            `singlePrice` double DEFAULT NULL,
                                            `totalPrice` double DEFAULT NULL,
                                            `memo` varchar(100) DEFAULT NULL,
                                            PRIMARY KEY (`id`),
                                            UNIQUE KEY `shopWarehouse7_smallTool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse7_smallTool`
--

LOCK TABLES `shopWarehouse7_smallTool` WRITE;
/*!40000 ALTER TABLE `shopWarehouse7_smallTool` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse7_smallTool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse7_tool`
--

DROP TABLE IF EXISTS `shopWarehouse7_tool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse7_tool` (
                                       `id` varchar(100) NOT NULL,
                                       `itemCount` int DEFAULT NULL,
                                       `singlePrice` double DEFAULT NULL,
                                       `totalPrice` double DEFAULT NULL,
                                       `memo` varchar(100) DEFAULT NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `shopWarehouse7_tool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse7_tool`
--

LOCK TABLES `shopWarehouse7_tool` WRITE;
/*!40000 ALTER TABLE `shopWarehouse7_tool` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse7_tool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse8_commercialItem`
--

DROP TABLE IF EXISTS `shopWarehouse8_commercialItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse8_commercialItem` (
                                                 `id` varchar(100) DEFAULT NULL,
                                                 `itemCount` int DEFAULT NULL,
                                                 `singlePrice` double DEFAULT NULL,
                                                 `totalPrice` double DEFAULT NULL,
                                                 `memo` varchar(100) DEFAULT NULL,
                                                 KEY `shopWarehouse8_commercialItem_id_index` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse8_commercialItem`
--

LOCK TABLES `shopWarehouse8_commercialItem` WRITE;
/*!40000 ALTER TABLE `shopWarehouse8_commercialItem` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse8_commercialItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse8_food`
--

DROP TABLE IF EXISTS `shopWarehouse8_food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse8_food` (
                                       `id` varchar(100) NOT NULL,
                                       `itemCount` int DEFAULT NULL,
                                       `singlePrice` double DEFAULT NULL,
                                       `totalPrice` double DEFAULT NULL,
                                       `memo` varchar(100) DEFAULT NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `shopWarehouse8_food_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse8_food`
--

LOCK TABLES `shopWarehouse8_food` WRITE;
/*!40000 ALTER TABLE `shopWarehouse8_food` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse8_food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse8_others`
--

DROP TABLE IF EXISTS `shopWarehouse8_others`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse8_others` (
                                         `id` varchar(100) NOT NULL,
                                         `itemCount` int DEFAULT NULL,
                                         `singlePrice` double DEFAULT NULL,
                                         `totalPrice` double DEFAULT NULL,
                                         `memo` varchar(100) DEFAULT NULL,
                                         PRIMARY KEY (`id`),
                                         UNIQUE KEY `shopWarehouse8_others_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse8_others`
--

LOCK TABLES `shopWarehouse8_others` WRITE;
/*!40000 ALTER TABLE `shopWarehouse8_others` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse8_others` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse8_smallTool`
--

DROP TABLE IF EXISTS `shopWarehouse8_smallTool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse8_smallTool` (
                                            `id` varchar(100) NOT NULL,
                                            `itemCount` int DEFAULT NULL,
                                            `singlePrice` double DEFAULT NULL,
                                            `totalPrice` double DEFAULT NULL,
                                            `memo` varchar(100) DEFAULT NULL,
                                            PRIMARY KEY (`id`),
                                            UNIQUE KEY `shopWarehouse8_smallTool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse8_smallTool`
--

LOCK TABLES `shopWarehouse8_smallTool` WRITE;
/*!40000 ALTER TABLE `shopWarehouse8_smallTool` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse8_smallTool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse8_tool`
--

DROP TABLE IF EXISTS `shopWarehouse8_tool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse8_tool` (
                                       `id` varchar(100) NOT NULL,
                                       `itemCount` int DEFAULT NULL,
                                       `singlePrice` double DEFAULT NULL,
                                       `totalPrice` double DEFAULT NULL,
                                       `memo` varchar(100) DEFAULT NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `shopWarehouse8_tool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse8_tool`
--

LOCK TABLES `shopWarehouse8_tool` WRITE;
/*!40000 ALTER TABLE `shopWarehouse8_tool` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse8_tool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse9_commercialItem`
--

DROP TABLE IF EXISTS `shopWarehouse9_commercialItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse9_commercialItem` (
                                                 `id` varchar(100) DEFAULT NULL,
                                                 `itemCount` int DEFAULT NULL,
                                                 `singlePrice` double DEFAULT NULL,
                                                 `totalPrice` double DEFAULT NULL,
                                                 `memo` varchar(100) DEFAULT NULL,
                                                 KEY `shopWarehouse9_commercialItem_id_index` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse9_commercialItem`
--

LOCK TABLES `shopWarehouse9_commercialItem` WRITE;
/*!40000 ALTER TABLE `shopWarehouse9_commercialItem` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse9_commercialItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse9_food`
--

DROP TABLE IF EXISTS `shopWarehouse9_food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse9_food` (
                                       `id` varchar(100) NOT NULL,
                                       `itemCount` int DEFAULT NULL,
                                       `singlePrice` double DEFAULT NULL,
                                       `totalPrice` double DEFAULT NULL,
                                       `memo` varchar(100) DEFAULT NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `shopWarehouse9_food_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse9_food`
--

LOCK TABLES `shopWarehouse9_food` WRITE;
/*!40000 ALTER TABLE `shopWarehouse9_food` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse9_food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse9_others`
--

DROP TABLE IF EXISTS `shopWarehouse9_others`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse9_others` (
                                         `id` varchar(100) NOT NULL,
                                         `itemCount` int DEFAULT NULL,
                                         `singlePrice` double DEFAULT NULL,
                                         `totalPrice` double DEFAULT NULL,
                                         `memo` varchar(100) DEFAULT NULL,
                                         PRIMARY KEY (`id`),
                                         UNIQUE KEY `shopWarehouse9_others_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse9_others`
--

LOCK TABLES `shopWarehouse9_others` WRITE;
/*!40000 ALTER TABLE `shopWarehouse9_others` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse9_others` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse9_smallTool`
--

DROP TABLE IF EXISTS `shopWarehouse9_smallTool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse9_smallTool` (
                                            `id` varchar(100) NOT NULL,
                                            `itemCount` int DEFAULT NULL,
                                            `singlePrice` double DEFAULT NULL,
                                            `totalPrice` double DEFAULT NULL,
                                            `memo` varchar(100) DEFAULT NULL,
                                            PRIMARY KEY (`id`),
                                            UNIQUE KEY `shopWarehouse9_smallTool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse9_smallTool`
--

LOCK TABLES `shopWarehouse9_smallTool` WRITE;
/*!40000 ALTER TABLE `shopWarehouse9_smallTool` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse9_smallTool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopWarehouse9_tool`
--

DROP TABLE IF EXISTS `shopWarehouse9_tool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopWarehouse9_tool` (
                                       `id` varchar(100) NOT NULL,
                                       `itemCount` int DEFAULT NULL,
                                       `singlePrice` double DEFAULT NULL,
                                       `totalPrice` double DEFAULT NULL,
                                       `memo` varchar(100) DEFAULT NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE KEY `shopWarehouse9_tool_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopWarehouse9_tool`
--

LOCK TABLES `shopWarehouse9_tool` WRITE;
/*!40000 ALTER TABLE `shopWarehouse9_tool` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopWarehouse9_tool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
                            `supplierID` varchar(100) NOT NULL,
                            `supplierName` varchar(100) DEFAULT NULL,
                            `supply_area` varchar(100) DEFAULT NULL,
                            `payCheck_way` varchar(100) DEFAULT NULL,
                            `pay_way` varchar(100) DEFAULT NULL,
                            PRIMARY KEY (`supplierID`),
                            UNIQUE KEY `supplier_id_uindex` (`supplierID`),
                            KEY `supplier_supplierName_index` (`supplierName`),
                            KEY `supplier_supply_area_index` (`supply_area`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES ('f7484930ad7c461caa708e01b6557ada','eee',NULL,NULL,NULL),('f7ad8ebff86f46e18a5b912fe596c80f','Alan','HK','微信','vinvin支付宝');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
                          `id` varchar(100) NOT NULL,
                          `ifConfirm` tinyint(1) NOT NULL,
                          `store` varchar(10) DEFAULT NULL,
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `id` (`id`),
                          KEY `ticket_store_ifConfirm_index` (`store`,`ifConfirm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
                        `uname` varchar(100) DEFAULT NULL,
                        `upwd` varchar(100) DEFAULT NULL,
                        `level` int DEFAULT NULL,
                        KEY `user_uname_index` (`uname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('vinvin1','vin2992',1000);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WarehouseDailyChecklogmain0`
--

DROP TABLE IF EXISTS `WarehouseDailyChecklogmain0`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `WarehouseDailyChecklogmain0` (
                                               `logid` varchar(100) DEFAULT NULL,
                                               `id` varchar(100) DEFAULT NULL,
                                               `itemName` varchar(100) DEFAULT NULL,
                                               `brand` varchar(100) DEFAULT NULL,
                                               `checkitemCount` int DEFAULT NULL,
                                               `realitemCount` int DEFAULT NULL,
                                               `ifmatch` varchar(10) DEFAULT NULL,
                                               `time` varchar(100) DEFAULT NULL,
                                               `category` varchar(100) DEFAULT NULL,
                                               `difference` int DEFAULT NULL,
                                               KEY `WarehouseDailyChecklogmain0_category_time_index` (`category`,`time` DESC),
                                               KEY `WarehouseDailyChecklogmain0_id_index` (`id`),
                                               KEY `WarehouseDailyChecklogmain0_ifmatch_index` (`ifmatch`),
                                               KEY `WarehouseDailyChecklogmain0_logid_index` (`logid`),
                                               KEY `WarehouseDailyChecklogmain0_time_index` (`time` DESC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WarehouseDailyChecklogmain0`
--

LOCK TABLES `WarehouseDailyChecklogmain0` WRITE;
/*!40000 ALTER TABLE `WarehouseDailyChecklogmain0` DISABLE KEYS */;
/*!40000 ALTER TABLE `WarehouseDailyChecklogmain0` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WarehouseDailyChecklogmain1`
--

DROP TABLE IF EXISTS `WarehouseDailyChecklogmain1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `WarehouseDailyChecklogmain1` (
                                               `logid` varchar(100) DEFAULT NULL,
                                               `id` varchar(100) DEFAULT NULL,
                                               `itemName` varchar(100) DEFAULT NULL,
                                               `brand` varchar(100) DEFAULT NULL,
                                               `checkitemCount` int DEFAULT NULL,
                                               `realitemCount` int DEFAULT NULL,
                                               `ifmatch` varchar(10) DEFAULT NULL,
                                               `time` varchar(100) DEFAULT NULL,
                                               `category` varchar(100) DEFAULT NULL,
                                               `difference` int DEFAULT NULL,
                                               KEY `WarehouseDailyChecklogmain1_category_time_index` (`category`,`time` DESC),
                                               KEY `WarehouseDailyChecklogmain1_id_index` (`id`),
                                               KEY `WarehouseDailyChecklogmain1_ifmatch_index` (`ifmatch`),
                                               KEY `WarehouseDailyChecklogmain1_logid_index` (`logid`),
                                               KEY `WarehouseDailyChecklogmain1_time_index` (`time` DESC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WarehouseDailyChecklogmain1`
--

LOCK TABLES `WarehouseDailyChecklogmain1` WRITE;
/*!40000 ALTER TABLE `WarehouseDailyChecklogmain1` DISABLE KEYS */;
/*!40000 ALTER TABLE `WarehouseDailyChecklogmain1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WarehouseDailyChecklogmain2`
--

DROP TABLE IF EXISTS `WarehouseDailyChecklogmain2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `WarehouseDailyChecklogmain2` (
                                               `logid` varchar(100) DEFAULT NULL,
                                               `id` varchar(100) DEFAULT NULL,
                                               `itemName` varchar(100) DEFAULT NULL,
                                               `brand` varchar(100) DEFAULT NULL,
                                               `checkitemCount` int DEFAULT NULL,
                                               `realitemCount` int DEFAULT NULL,
                                               `ifmatch` varchar(10) DEFAULT NULL,
                                               `time` varchar(100) DEFAULT NULL,
                                               `category` varchar(100) DEFAULT NULL,
                                               `difference` int DEFAULT NULL,
                                               KEY `WarehouseDailyChecklogmain2_category_time_index` (`category`,`time` DESC),
                                               KEY `WarehouseDailyChecklogmain2_id_index` (`id`),
                                               KEY `WarehouseDailyChecklogmain2_ifmatch_index` (`ifmatch`),
                                               KEY `WarehouseDailyChecklogmain2_logid_index` (`logid`),
                                               KEY `WarehouseDailyChecklogmain2_time_index` (`time` DESC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WarehouseDailyChecklogmain2`
--

LOCK TABLES `WarehouseDailyChecklogmain2` WRITE;
/*!40000 ALTER TABLE `WarehouseDailyChecklogmain2` DISABLE KEYS */;
/*!40000 ALTER TABLE `WarehouseDailyChecklogmain2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WarehouseDailyChecklogshop1`
--

DROP TABLE IF EXISTS `WarehouseDailyChecklogshop1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `WarehouseDailyChecklogshop1` (
                                               `logid` varchar(100) DEFAULT NULL,
                                               `id` varchar(100) DEFAULT NULL,
                                               `itemName` varchar(100) DEFAULT NULL,
                                               `brand` varchar(100) DEFAULT NULL,
                                               `checkitemCount` int DEFAULT NULL,
                                               `realitemCount` int DEFAULT NULL,
                                               `ifmatch` varchar(10) DEFAULT NULL,
                                               `time` varchar(100) DEFAULT NULL,
                                               `category` varchar(100) DEFAULT NULL,
                                               `difference` int DEFAULT NULL,
                                               KEY `WarehouseDailyChecklogshop1_category_time_index` (`category`,`time` DESC),
                                               KEY `WarehouseDailyChecklogshop1_id_index` (`id`),
                                               KEY `WarehouseDailyChecklogshop1_ifmatch_index` (`ifmatch`),
                                               KEY `WarehouseDailyChecklogshop1_logid_index` (`logid`),
                                               KEY `WarehouseDailyChecklogshop1_time_index` (`time` DESC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WarehouseDailyChecklogshop1`
--

LOCK TABLES `WarehouseDailyChecklogshop1` WRITE;
/*!40000 ALTER TABLE `WarehouseDailyChecklogshop1` DISABLE KEYS */;
/*!40000 ALTER TABLE `WarehouseDailyChecklogshop1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WarehouseDailyChecklogshop10`
--

DROP TABLE IF EXISTS `WarehouseDailyChecklogshop10`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `WarehouseDailyChecklogshop10` (
                                                `logid` varchar(100) DEFAULT NULL,
                                                `id` varchar(100) DEFAULT NULL,
                                                `itemName` varchar(100) DEFAULT NULL,
                                                `brand` varchar(100) DEFAULT NULL,
                                                `checkitemCount` int DEFAULT NULL,
                                                `realitemCount` int DEFAULT NULL,
                                                `ifmatch` varchar(10) DEFAULT NULL,
                                                `time` varchar(100) DEFAULT NULL,
                                                `category` varchar(100) DEFAULT NULL,
                                                `difference` int DEFAULT NULL,
                                                KEY `WarehouseDailyChecklogshop10_category_time_index` (`category`,`time` DESC),
                                                KEY `WarehouseDailyChecklogshop10_id_index` (`id`),
                                                KEY `WarehouseDailyChecklogshop10_ifmatch_index` (`ifmatch`),
                                                KEY `WarehouseDailyChecklogshop10_logid_index` (`logid`),
                                                KEY `WarehouseDailyChecklogshop10_time_index` (`time` DESC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WarehouseDailyChecklogshop10`
--

LOCK TABLES `WarehouseDailyChecklogshop10` WRITE;
/*!40000 ALTER TABLE `WarehouseDailyChecklogshop10` DISABLE KEYS */;
/*!40000 ALTER TABLE `WarehouseDailyChecklogshop10` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WarehouseDailyChecklogshop11`
--

DROP TABLE IF EXISTS `WarehouseDailyChecklogshop11`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `WarehouseDailyChecklogshop11` (
                                                `logid` varchar(100) DEFAULT NULL,
                                                `id` varchar(100) DEFAULT NULL,
                                                `itemName` varchar(100) DEFAULT NULL,
                                                `brand` varchar(100) DEFAULT NULL,
                                                `checkitemCount` int DEFAULT NULL,
                                                `realitemCount` int DEFAULT NULL,
                                                `ifmatch` varchar(10) DEFAULT NULL,
                                                `time` varchar(100) DEFAULT NULL,
                                                `category` varchar(100) DEFAULT NULL,
                                                `difference` int DEFAULT NULL,
                                                KEY `WarehouseDailyChecklogshop11_category_time_index` (`category`,`time` DESC),
                                                KEY `WarehouseDailyChecklogshop11_id_index` (`id`),
                                                KEY `WarehouseDailyChecklogshop11_ifmatch_index` (`ifmatch`),
                                                KEY `WarehouseDailyChecklogshop11_logid_index` (`logid`),
                                                KEY `WarehouseDailyChecklogshop11_time_index` (`time` DESC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WarehouseDailyChecklogshop11`
--

LOCK TABLES `WarehouseDailyChecklogshop11` WRITE;
/*!40000 ALTER TABLE `WarehouseDailyChecklogshop11` DISABLE KEYS */;
/*!40000 ALTER TABLE `WarehouseDailyChecklogshop11` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WarehouseDailyChecklogshop12`
--

DROP TABLE IF EXISTS `WarehouseDailyChecklogshop12`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `WarehouseDailyChecklogshop12` (
                                                `logid` varchar(100) DEFAULT NULL,
                                                `id` varchar(100) DEFAULT NULL,
                                                `itemName` varchar(100) DEFAULT NULL,
                                                `brand` varchar(100) DEFAULT NULL,
                                                `checkitemCount` int DEFAULT NULL,
                                                `realitemCount` int DEFAULT NULL,
                                                `ifmatch` varchar(10) DEFAULT NULL,
                                                `time` varchar(100) DEFAULT NULL,
                                                `category` varchar(100) DEFAULT NULL,
                                                `difference` int DEFAULT NULL,
                                                KEY `WarehouseDailyChecklogshop12_category_time_index` (`category`,`time` DESC),
                                                KEY `WarehouseDailyChecklogshop12_id_index` (`id`),
                                                KEY `WarehouseDailyChecklogshop12_ifmatch_index` (`ifmatch`),
                                                KEY `WarehouseDailyChecklogshop12_logid_index` (`logid`),
                                                KEY `WarehouseDailyChecklogshop12_time_index` (`time` DESC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WarehouseDailyChecklogshop12`
--

LOCK TABLES `WarehouseDailyChecklogshop12` WRITE;
/*!40000 ALTER TABLE `WarehouseDailyChecklogshop12` DISABLE KEYS */;
/*!40000 ALTER TABLE `WarehouseDailyChecklogshop12` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WarehouseDailyChecklogshop13`
--

DROP TABLE IF EXISTS `WarehouseDailyChecklogshop13`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `WarehouseDailyChecklogshop13` (
                                                `logid` varchar(100) DEFAULT NULL,
                                                `id` varchar(100) DEFAULT NULL,
                                                `itemName` varchar(100) DEFAULT NULL,
                                                `brand` varchar(100) DEFAULT NULL,
                                                `checkitemCount` int DEFAULT NULL,
                                                `realitemCount` int DEFAULT NULL,
                                                `ifmatch` varchar(10) DEFAULT NULL,
                                                `time` varchar(100) DEFAULT NULL,
                                                `category` varchar(100) DEFAULT NULL,
                                                `difference` int DEFAULT NULL,
                                                KEY `WarehouseDailyChecklogshop13_category_time_index` (`category`,`time` DESC),
                                                KEY `WarehouseDailyChecklogshop13_id_index` (`id`),
                                                KEY `WarehouseDailyChecklogshop13_ifmatch_index` (`ifmatch`),
                                                KEY `WarehouseDailyChecklogshop13_logid_index` (`logid`),
                                                KEY `WarehouseDailyChecklogshop13_time_index` (`time` DESC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WarehouseDailyChecklogshop13`
--

LOCK TABLES `WarehouseDailyChecklogshop13` WRITE;
/*!40000 ALTER TABLE `WarehouseDailyChecklogshop13` DISABLE KEYS */;
/*!40000 ALTER TABLE `WarehouseDailyChecklogshop13` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WarehouseDailyChecklogshop14`
--

DROP TABLE IF EXISTS `WarehouseDailyChecklogshop14`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `WarehouseDailyChecklogshop14` (
                                                `logid` varchar(100) DEFAULT NULL,
                                                `id` varchar(100) DEFAULT NULL,
                                                `itemName` varchar(100) DEFAULT NULL,
                                                `brand` varchar(100) DEFAULT NULL,
                                                `checkitemCount` int DEFAULT NULL,
                                                `realitemCount` int DEFAULT NULL,
                                                `ifmatch` varchar(10) DEFAULT NULL,
                                                `time` varchar(100) DEFAULT NULL,
                                                `category` varchar(100) DEFAULT NULL,
                                                `difference` int DEFAULT NULL,
                                                KEY `WarehouseDailyChecklogshop14_category_time_index` (`category`,`time` DESC),
                                                KEY `WarehouseDailyChecklogshop14_id_index` (`id`),
                                                KEY `WarehouseDailyChecklogshop14_ifmatch_index` (`ifmatch`),
                                                KEY `WarehouseDailyChecklogshop14_logid_index` (`logid`),
                                                KEY `WarehouseDailyChecklogshop14_time_index` (`time` DESC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WarehouseDailyChecklogshop14`
--

LOCK TABLES `WarehouseDailyChecklogshop14` WRITE;
/*!40000 ALTER TABLE `WarehouseDailyChecklogshop14` DISABLE KEYS */;
/*!40000 ALTER TABLE `WarehouseDailyChecklogshop14` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WarehouseDailyChecklogshop2`
--

DROP TABLE IF EXISTS `WarehouseDailyChecklogshop2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `WarehouseDailyChecklogshop2` (
                                               `logid` varchar(100) DEFAULT NULL,
                                               `id` varchar(100) DEFAULT NULL,
                                               `itemName` varchar(100) DEFAULT NULL,
                                               `brand` varchar(100) DEFAULT NULL,
                                               `checkitemCount` int DEFAULT NULL,
                                               `realitemCount` int DEFAULT NULL,
                                               `ifmatch` varchar(10) DEFAULT NULL,
                                               `time` varchar(100) DEFAULT NULL,
                                               `category` varchar(100) DEFAULT NULL,
                                               `difference` int DEFAULT NULL,
                                               KEY `WarehouseDailyChecklogshop2_category_time_index` (`category`,`time` DESC),
                                               KEY `WarehouseDailyChecklogshop2_id_index` (`id`),
                                               KEY `WarehouseDailyChecklogshop2_ifmatch_index` (`ifmatch`),
                                               KEY `WarehouseDailyChecklogshop2_logid_index` (`logid`),
                                               KEY `WarehouseDailyChecklogshop2_time_index` (`time` DESC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WarehouseDailyChecklogshop2`
--

LOCK TABLES `WarehouseDailyChecklogshop2` WRITE;
/*!40000 ALTER TABLE `WarehouseDailyChecklogshop2` DISABLE KEYS */;
/*!40000 ALTER TABLE `WarehouseDailyChecklogshop2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WarehouseDailyChecklogshop3`
--

DROP TABLE IF EXISTS `WarehouseDailyChecklogshop3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `WarehouseDailyChecklogshop3` (
                                               `logid` varchar(100) DEFAULT NULL,
                                               `id` varchar(100) DEFAULT NULL,
                                               `itemName` varchar(100) DEFAULT NULL,
                                               `brand` varchar(100) DEFAULT NULL,
                                               `checkitemCount` int DEFAULT NULL,
                                               `realitemCount` int DEFAULT NULL,
                                               `ifmatch` varchar(10) DEFAULT NULL,
                                               `time` varchar(100) DEFAULT NULL,
                                               `category` varchar(100) DEFAULT NULL,
                                               `difference` int DEFAULT NULL,
                                               KEY `WarehouseDailyChecklogshop3_category_time_index` (`category`,`time` DESC),
                                               KEY `WarehouseDailyChecklogshop3_id_index` (`id`),
                                               KEY `WarehouseDailyChecklogshop3_ifmatch_index` (`ifmatch`),
                                               KEY `WarehouseDailyChecklogshop3_logid_index` (`logid`),
                                               KEY `WarehouseDailyChecklogshop3_time_index` (`time` DESC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WarehouseDailyChecklogshop3`
--

LOCK TABLES `WarehouseDailyChecklogshop3` WRITE;
/*!40000 ALTER TABLE `WarehouseDailyChecklogshop3` DISABLE KEYS */;
/*!40000 ALTER TABLE `WarehouseDailyChecklogshop3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WarehouseDailyChecklogshop4`
--

DROP TABLE IF EXISTS `WarehouseDailyChecklogshop4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `WarehouseDailyChecklogshop4` (
                                               `logid` varchar(100) DEFAULT NULL,
                                               `id` varchar(100) DEFAULT NULL,
                                               `itemName` varchar(100) DEFAULT NULL,
                                               `brand` varchar(100) DEFAULT NULL,
                                               `checkitemCount` int DEFAULT NULL,
                                               `realitemCount` int DEFAULT NULL,
                                               `ifmatch` varchar(10) DEFAULT NULL,
                                               `time` varchar(100) DEFAULT NULL,
                                               `category` varchar(100) DEFAULT NULL,
                                               `difference` int DEFAULT NULL,
                                               KEY `WarehouseDailyChecklogshop4_category_time_index` (`category`,`time` DESC),
                                               KEY `WarehouseDailyChecklogshop4_id_index` (`id`),
                                               KEY `WarehouseDailyChecklogshop4_ifmatch_index` (`ifmatch`),
                                               KEY `WarehouseDailyChecklogshop4_logid_index` (`logid`),
                                               KEY `WarehouseDailyChecklogshop4_time_index` (`time` DESC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WarehouseDailyChecklogshop4`
--

LOCK TABLES `WarehouseDailyChecklogshop4` WRITE;
/*!40000 ALTER TABLE `WarehouseDailyChecklogshop4` DISABLE KEYS */;
/*!40000 ALTER TABLE `WarehouseDailyChecklogshop4` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WarehouseDailyChecklogshop5`
--

DROP TABLE IF EXISTS `WarehouseDailyChecklogshop5`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `WarehouseDailyChecklogshop5` (
                                               `logid` varchar(100) DEFAULT NULL,
                                               `id` varchar(100) DEFAULT NULL,
                                               `itemName` varchar(100) DEFAULT NULL,
                                               `brand` varchar(100) DEFAULT NULL,
                                               `checkitemCount` int DEFAULT NULL,
                                               `realitemCount` int DEFAULT NULL,
                                               `ifmatch` varchar(10) DEFAULT NULL,
                                               `time` varchar(100) DEFAULT NULL,
                                               `category` varchar(100) DEFAULT NULL,
                                               `difference` int DEFAULT NULL,
                                               KEY `WarehouseDailyChecklogshop5_category_time_index` (`category`,`time` DESC),
                                               KEY `WarehouseDailyChecklogshop5_id_index` (`id`),
                                               KEY `WarehouseDailyChecklogshop5_ifmatch_index` (`ifmatch`),
                                               KEY `WarehouseDailyChecklogshop5_logid_index` (`logid`),
                                               KEY `WarehouseDailyChecklogshop5_time_index` (`time` DESC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WarehouseDailyChecklogshop5`
--

LOCK TABLES `WarehouseDailyChecklogshop5` WRITE;
/*!40000 ALTER TABLE `WarehouseDailyChecklogshop5` DISABLE KEYS */;
/*!40000 ALTER TABLE `WarehouseDailyChecklogshop5` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WarehouseDailyChecklogshop6`
--

DROP TABLE IF EXISTS `WarehouseDailyChecklogshop6`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `WarehouseDailyChecklogshop6` (
                                               `logid` varchar(100) DEFAULT NULL,
                                               `id` varchar(100) DEFAULT NULL,
                                               `itemName` varchar(100) DEFAULT NULL,
                                               `brand` varchar(100) DEFAULT NULL,
                                               `checkitemCount` int DEFAULT NULL,
                                               `realitemCount` int DEFAULT NULL,
                                               `ifmatch` varchar(10) DEFAULT NULL,
                                               `time` varchar(100) DEFAULT NULL,
                                               `category` varchar(100) DEFAULT NULL,
                                               `difference` int DEFAULT NULL,
                                               KEY `WarehouseDailyChecklogshop6_category_time_index` (`category`,`time` DESC),
                                               KEY `WarehouseDailyChecklogshop6_id_index` (`id`),
                                               KEY `WarehouseDailyChecklogshop6_ifmatch_index` (`ifmatch`),
                                               KEY `WarehouseDailyChecklogshop6_logid_index` (`logid`),
                                               KEY `WarehouseDailyChecklogshop6_time_index` (`time` DESC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WarehouseDailyChecklogshop6`
--

LOCK TABLES `WarehouseDailyChecklogshop6` WRITE;
/*!40000 ALTER TABLE `WarehouseDailyChecklogshop6` DISABLE KEYS */;
/*!40000 ALTER TABLE `WarehouseDailyChecklogshop6` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WarehouseDailyChecklogshop7`
--

DROP TABLE IF EXISTS `WarehouseDailyChecklogshop7`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `WarehouseDailyChecklogshop7` (
                                               `logid` varchar(100) DEFAULT NULL,
                                               `id` varchar(100) DEFAULT NULL,
                                               `itemName` varchar(100) DEFAULT NULL,
                                               `brand` varchar(100) DEFAULT NULL,
                                               `checkitemCount` int DEFAULT NULL,
                                               `realitemCount` int DEFAULT NULL,
                                               `ifmatch` varchar(10) DEFAULT NULL,
                                               `time` varchar(100) DEFAULT NULL,
                                               `category` varchar(100) DEFAULT NULL,
                                               `difference` int DEFAULT NULL,
                                               KEY `WarehouseDailyChecklogshop7_category_time_index` (`category`,`time` DESC),
                                               KEY `WarehouseDailyChecklogshop7_id_index` (`id`),
                                               KEY `WarehouseDailyChecklogshop7_ifmatch_index` (`ifmatch`),
                                               KEY `WarehouseDailyChecklogshop7_logid_index` (`logid`),
                                               KEY `WarehouseDailyChecklogshop7_time_index` (`time` DESC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WarehouseDailyChecklogshop7`
--

LOCK TABLES `WarehouseDailyChecklogshop7` WRITE;
/*!40000 ALTER TABLE `WarehouseDailyChecklogshop7` DISABLE KEYS */;
/*!40000 ALTER TABLE `WarehouseDailyChecklogshop7` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WarehouseDailyChecklogshop8`
--

DROP TABLE IF EXISTS `WarehouseDailyChecklogshop8`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `WarehouseDailyChecklogshop8` (
                                               `logid` varchar(100) DEFAULT NULL,
                                               `id` varchar(100) DEFAULT NULL,
                                               `itemName` varchar(100) DEFAULT NULL,
                                               `brand` varchar(100) DEFAULT NULL,
                                               `checkitemCount` int DEFAULT NULL,
                                               `realitemCount` int DEFAULT NULL,
                                               `ifmatch` varchar(10) DEFAULT NULL,
                                               `time` varchar(100) DEFAULT NULL,
                                               `category` varchar(100) DEFAULT NULL,
                                               `difference` int DEFAULT NULL,
                                               KEY `WarehouseDailyChecklogshop8_category_time_index` (`category`,`time` DESC),
                                               KEY `WarehouseDailyChecklogshop8_id_index` (`id`),
                                               KEY `WarehouseDailyChecklogshop8_ifmatch_index` (`ifmatch`),
                                               KEY `WarehouseDailyChecklogshop8_logid_index` (`logid`),
                                               KEY `WarehouseDailyChecklogshop8_time_index` (`time` DESC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WarehouseDailyChecklogshop8`
--

LOCK TABLES `WarehouseDailyChecklogshop8` WRITE;
/*!40000 ALTER TABLE `WarehouseDailyChecklogshop8` DISABLE KEYS */;
/*!40000 ALTER TABLE `WarehouseDailyChecklogshop8` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `WarehouseDailyChecklogshop9`
--

DROP TABLE IF EXISTS `WarehouseDailyChecklogshop9`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `WarehouseDailyChecklogshop9` (
                                               `logid` varchar(100) DEFAULT NULL,
                                               `id` varchar(100) DEFAULT NULL,
                                               `itemName` varchar(100) DEFAULT NULL,
                                               `brand` varchar(100) DEFAULT NULL,
                                               `checkitemCount` int DEFAULT NULL,
                                               `realitemCount` int DEFAULT NULL,
                                               `ifmatch` varchar(10) DEFAULT NULL,
                                               `time` varchar(100) DEFAULT NULL,
                                               `category` varchar(100) DEFAULT NULL,
                                               `difference` int DEFAULT NULL,
                                               KEY `WarehouseDailyChecklogshop9_category_time_index` (`category`,`time` DESC),
                                               KEY `WarehouseDailyChecklogshop9_id_index` (`id`),
                                               KEY `WarehouseDailyChecklogshop9_ifmatch_index` (`ifmatch`),
                                               KEY `WarehouseDailyChecklogshop9_logid_index` (`logid`),
                                               KEY `WarehouseDailyChecklogshop9_time_index` (`time` DESC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `WarehouseDailyChecklogshop9`
--

LOCK TABLES `WarehouseDailyChecklogshop9` WRITE;
/*!40000 ALTER TABLE `WarehouseDailyChecklogshop9` DISABLE KEYS */;
/*!40000 ALTER TABLE `WarehouseDailyChecklogshop9` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-27 18:41:28










#------------------vinvinFinance---------------------
CREATE DATABASE IF NOT EXISTS `vinvinFinance`;
use vinvinFinance;

create table budgetMonthly
(
    budgetItemID varchar(100) not null
        primary key,
    budgetItem   varchar(100) null,
    bugetSum     double       null,
    detail       text         null,
    time         varchar(10)  null,
    constraint budgetMonthly_budgetLog_uindex
        unique (budgetItemID)
);

create index budgetMonthly_time_index
    on budgetMonthly (time);

create table category
(
    categoryEN varchar(100) not null
        primary key,
    categoryCN varchar(100) null,
    constraint category_categoryEN_uindex
        unique (categoryEN)
);

create table decorationCost
(
    budgetItemID         varchar(100) not null
        primary key,
    supplier             varchar(100) null,
    decoratedStore       varchar(100) null,
    price                double       null,
    expectPayandTimeList text         null,
    reason               text         null,
    realPrice            double       null,
    realPaymentTime      varchar(100) null,
    settlementWay        varchar(100) null,
    month                varchar(10)  null,
    constraint decorationCost_budgetItemID_uindex
        unique (budgetItemID)
);

create index decorationCost_month_decoratedStore_index
    on decorationCost (month, decoratedStore);

create table decorationCostSec
(
    itemID            varchar(100) not null
        primary key,
    item              varchar(100) null,
    month             varchar(10)  null,
    supplier          varchar(100) null,
    decoratedStore    varchar(10)  null,
    startTime         varchar(10)  null,
    expectEndTime     varchar(10)  null,
    realEndTime       varchar(10)  null,
    payItem           double       null,
    expectPrice       double       null,
    expectPayTime     varchar(10)  null,
    expectPriceLeft   double       null,
    expectPayTimeLeft varchar(10)  null,
    realPrice         double       null,
    realPayTime       varchar(10)  null,
    memo              text         null,
    constraint decorationCostSec_itemID_uindex
        unique (itemID)
);

create table filetype
(
    id       varchar(100) not null
        primary key,
    filepath varchar(100) null,
    constraint filetype_id_uindex
        unique (id)
);

create table log
(
    logID     varchar(100)  null,
    user      varchar(100)  null,
    action    varchar(100)  null,
    oldData   varchar(1000) null,
    newData   varchar(1000) null,
    className varchar(100)  null,
    time      varchar(100)  null
);

create index log_action_time_index
    on log (action, time);

create index log_className_time_index
    on log (className, time);

create index log_logID_index
    on log (logID);

create index log_user_time_index
    on log (user, time);

create table log_action
(
    actionEN varchar(100) null,
    actionCN varchar(100) null
);

create index log_action_actionCN_index
    on log_action (actionCN);

create index log_action_actionEN_index
    on log_action (actionEN);

create table product
(
    series            varchar(20)  not null,
    productID         varchar(100) not null
        primary key,
    productName       varchar(100) not null,
    availableLocation varchar(10)  not null,
    capacity          text         not null,
    source            varchar(20)  not null,
    sugarChoice       text         null,
    coldOrHot         text         null,
    priceSZ           text         not null,
    priceDG           text         not null,
    constraint product_productID_uindex
        unique (productID)
);

create index product_availableLocation_index
    on product (availableLocation);

create table productHistory
(
    time        varchar(20) not null
        primary key,
    productJSON text        null,
    recipeJSON  text        null,
    constraint productHistory_time_uindex
        unique (time desc)
);

create table productRecipe
(
    productID varchar(20) not null
        primary key,
    recipe    text        not null,
    constraint productRecipe_productID_uindex
        unique (productID)
);

create table productRecipeHistory
(
    time      varchar(20) not null,
    productID varchar(10) not null,
    recipe    text        not null
);

create index productRecipeHistory_time_index
    on productRecipeHistory (time desc);

create index productRecipe_productID_time_index
    on productRecipeHistory (productID);

create table productSetting
(
    productID       varchar(10) not null
        primary key,
    rateOfOperation double      null,
    marginSZ        double      null,
    marginDG        double      null,
    constraint productSetting_productID_uindex
        unique (productID)
);

create table productSettingHistory
(
    time        varchar(20) not null
        primary key,
    settingJSON text        null,
    constraint productSettingHistory_time_uindex
        unique (time)
);

create table productSugarChoice
(
    levelNum  int         not null
        primary key,
    levelWord varchar(10) not null,
    constraint productSugarChoice_levelNum_uindex
        unique (levelNum),
    constraint productSugarChoice_levelWord_uindex
        unique (levelWord)
);

create table rentCost
(
    budgetItemID      varchar(100) not null
        primary key,
    store             varchar(100) null,
    rent              double       null,
    manageFee         double       null,
    waterFee          double       null,
    decorationDeposit double       null,
    feeDeposit        double       null,
    rentDeposit       double       null,
    payTime           varchar(100) null,
    bePayedDays       int          null,
    month             varchar(10)  null,
    constraint rentCost_budgetItemID_uindex
        unique (budgetItemID)
);

create index rentCost_month_store_index
    on rentCost (month, store);

create table rentCostSec
(
    itemID         varchar(100) not null
        primary key,
    month          varchar(100) null,
    part           varchar(10)  null,
    store          varchar(100) null,
    item           varchar(100) null,
    expectPayPrice double       null,
    realPayPrice   double       null,
    expectPayTime  varchar(100) null,
    realPayTime    varchar(100) null,
    constraint rentCostThird_itemID_uindex
        unique (itemID)
);

create index rentCostThird_store_month_index
    on rentCostSec (store, month);

create table storeMenu
(
    menuID    varchar(100) not null
        primary key,
    store     varchar(10)  null,
    productID varchar(10)  null,
    constraint storeMenu_menuID_uindex
        unique (menuID)
);

create index storeMenu_store_index
    on storeMenu (store);

create table storeMenuHistory
(
    time     varchar(20) not null
        primary key,
    store    varchar(10) not null,
    menuJSON text        null,
    constraint storeMenuHistory_time_uindex
        unique (time)
);

create index storeMenuHistory_store_time_index
    on storeMenuHistory (store asc, time desc);

create table user
(
    id       int auto_increment
        primary key,
    username varchar(100)         null,
    password varchar(100)         null,
    level    int                  null,
    role     varchar(100)         null,
    enabled  tinyint(1) default 1 not null,
    constraint user_id_uindex
        unique (id)
);

create index user_uname_index
    on user (username);










-- MySQL dump 10.13  Distrib 8.1.0, for macos13 (arm64)
--
-- Host: 127.0.0.1    Database: vinvinFinance
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `budgetMonthly`
--

DROP TABLE IF EXISTS `budgetMonthly`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `budgetMonthly` (
                                 `budgetItemID` varchar(100) NOT NULL,
                                 `budgetItem` varchar(100) DEFAULT NULL,
                                 `bugetSum` double DEFAULT NULL,
                                 `detail` text,
                                 `time` varchar(10) DEFAULT NULL,
                                 PRIMARY KEY (`budgetItemID`),
                                 UNIQUE KEY `budgetMonthly_budgetLog_uindex` (`budgetItemID`),
                                 KEY `budgetMonthly_time_index` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `budgetMonthly`
--

LOCK TABLES `budgetMonthly` WRITE;
/*!40000 ALTER TABLE `budgetMonthly` DISABLE KEYS */;
/*!40000 ALTER TABLE `budgetMonthly` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
                            `categoryEN` varchar(100) NOT NULL,
                            `categoryCN` varchar(100) DEFAULT NULL,
                            PRIMARY KEY (`categoryEN`),
                            UNIQUE KEY `category_categoryEN_uindex` (`categoryEN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('commercial','宣传物料'),('food','物料'),('other','其他'),('smalltool','小器具'),('tool','設備');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `decorationCost`
--

DROP TABLE IF EXISTS `decorationCost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `decorationCost` (
                                  `budgetItemID` varchar(100) NOT NULL,
                                  `supplier` varchar(100) DEFAULT NULL,
                                  `decoratedStore` varchar(100) DEFAULT NULL,
                                  `price` double DEFAULT NULL,
                                  `expectPayandTimeList` text,
                                  `reason` text,
                                  `realPrice` double DEFAULT NULL,
                                  `realPaymentTime` varchar(100) DEFAULT NULL,
                                  `settlementWay` varchar(100) DEFAULT NULL,
                                  `month` varchar(10) DEFAULT NULL,
                                  PRIMARY KEY (`budgetItemID`),
                                  UNIQUE KEY `decorationCost_budgetItemID_uindex` (`budgetItemID`),
                                  KEY `decorationCost_month_decoratedStore_index` (`month`,`decoratedStore`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `decorationCost`
--

LOCK TABLES `decorationCost` WRITE;
/*!40000 ALTER TABLE `decorationCost` DISABLE KEYS */;
/*!40000 ALTER TABLE `decorationCost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `decorationCostSec`
--

DROP TABLE IF EXISTS `decorationCostSec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `decorationCostSec` (
                                     `itemID` varchar(100) NOT NULL,
                                     `item` varchar(100) DEFAULT NULL,
                                     `month` varchar(10) DEFAULT NULL,
                                     `supplier` varchar(100) DEFAULT NULL,
                                     `decoratedStore` varchar(10) DEFAULT NULL,
                                     `startTime` varchar(10) DEFAULT NULL,
                                     `expectEndTime` varchar(10) DEFAULT NULL,
                                     `realEndTime` varchar(10) DEFAULT NULL,
                                     `payItem` double DEFAULT NULL,
                                     `expectPrice` double DEFAULT NULL,
                                     `expectPayTime` varchar(10) DEFAULT NULL,
                                     `expectPriceLeft` double DEFAULT NULL,
                                     `expectPayTimeLeft` varchar(10) DEFAULT NULL,
                                     `realPrice` double DEFAULT NULL,
                                     `realPayTime` varchar(10) DEFAULT NULL,
                                     `memo` text,
                                     PRIMARY KEY (`itemID`),
                                     UNIQUE KEY `decorationCostSec_itemID_uindex` (`itemID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `decorationCostSec`
--

LOCK TABLES `decorationCostSec` WRITE;
/*!40000 ALTER TABLE `decorationCostSec` DISABLE KEYS */;
/*!40000 ALTER TABLE `decorationCostSec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `filetype`
--

DROP TABLE IF EXISTS `filetype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `filetype` (
                            `id` varchar(100) NOT NULL,
                            `filepath` varchar(100) DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `filetype_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filetype`
--

LOCK TABLES `filetype` WRITE;
/*!40000 ALTER TABLE `filetype` DISABLE KEYS */;
/*!40000 ALTER TABLE `filetype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log` (
                       `logID` varchar(100) DEFAULT NULL,
                       `user` varchar(100) DEFAULT NULL,
                       `action` varchar(100) DEFAULT NULL,
                       `oldData` varchar(1000) DEFAULT NULL,
                       `newData` varchar(1000) DEFAULT NULL,
                       `className` varchar(100) DEFAULT NULL,
                       `time` varchar(100) DEFAULT NULL,
                       KEY `log_action_time_index` (`action`,`time`),
                       KEY `log_className_time_index` (`className`,`time`),
                       KEY `log_logID_index` (`logID`),
                       KEY `log_user_time_index` (`user`,`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES ('3e62e912a88c43bfb26f59476cb1f1eb','alan','add',NULL,'{\"payCheck_way\":\"微信\",\"pay_way\":\"vinvin支付宝\",\"supplierID\":\"f7ad8ebff86f46e18a5b912fe596c80f\",\"supplierName\":\"Alan\",\"supply_area\":\"HK\"}','Supplier','2023-10-26 11:46:46'),('07014cc91fa54a1db9568d6528bc6771','alan','delete',NULL,'{\"category\":\"food\",\"itemID\":\"e041930b1dbe4883b1fd0df5aaa1ca31\",\"itemName\":\"qqq\",\"singleprice\":100,\"supplierID\":\"f7ad8ebff86f46e18a5b912fe596c80f\",\"supplierName\":\"Alan\"}','Item','2023-10-26 13:27:12'),('6707d9ef528d412eab037704635b11d3','alan','update','{\"category\":\"food\",\"itemID\":\"e041930b1dbe4883b1fd0df5aaa1ca31\",\"itemName\":\"qqq\",\"singleprice\":100,\"supplierID\":\"f7ad8ebff86f46e18a5b912fe596c80f\",\"supplierName\":\"Alan\"}','{\"category\":\"food\",\"itemID\":\"e041930b1dbe4883b1fd0df5aaa1ca31\",\"itemName\":\"qqq\",\"singleprice\":101,\"supplierID\":\"f7ad8ebff86f46e18a5b912fe596c80f\",\"supplierName\":\"Alan\"}','Item','2023-10-26 13:45:12');
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_action`
--

DROP TABLE IF EXISTS `log_action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log_action` (
                              `actionEN` varchar(100) DEFAULT NULL,
                              `actionCN` varchar(100) DEFAULT NULL,
                              KEY `log_action_actionCN_index` (`actionCN`),
                              KEY `log_action_actionEN_index` (`actionEN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_action`
--

LOCK TABLES `log_action` WRITE;
/*!40000 ALTER TABLE `log_action` DISABLE KEYS */;
INSERT INTO `log_action` VALUES ('update','編輯'),('add','添加'),('delete','刪除');
/*!40000 ALTER TABLE `log_action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
                           `series` varchar(20) NOT NULL,
                           `productID` varchar(100) NOT NULL,
                           `productName` varchar(100) NOT NULL,
                           `availableLocation` varchar(10) NOT NULL,
                           `capacity` text NOT NULL,
                           `source` varchar(20) NOT NULL,
                           `sugarChoice` text,
                           `coldOrHot` text,
                           `priceSZ` text NOT NULL,
                           `priceDG` text NOT NULL,
                           PRIMARY KEY (`productID`),
                           UNIQUE KEY `product_productID_uindex` (`productID`),
                           KEY `product_availableLocation_index` (`availableLocation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('coffee','COF1','拿鐵','SZDG','[\"300ml\",\"500ml\",\"700ml\"]','星巴克产品','[0,3,5,10]','[\"cold\",\"hot\"]','{\"500ml\":110,\"300ml\":90,\"700ml\":130}','{\"500ml\":110,\"300ml\":90,\"700ml\":130}'),('drink','JUI1','檸檬紅茶','SZDG','[\"600ml\",\"800ml\",\"1000ml\"]','vinvin产品','[0,3,5,10]','[\"cold\"]','{\"1000ml\":140,\"600ml\":100,\"800ml\":120}','{\"1000ml\":140,\"600ml\":100,\"800ml\":120}');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productHistory`
--

DROP TABLE IF EXISTS `productHistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productHistory` (
                                  `time` varchar(20) NOT NULL,
                                  `productJSON` text,
                                  `recipeJSON` text,
                                  PRIMARY KEY (`time`),
                                  UNIQUE KEY `productHistory_time_uindex` (`time` DESC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productHistory`
--

LOCK TABLES `productHistory` WRITE;
/*!40000 ALTER TABLE `productHistory` DISABLE KEYS */;
INSERT INTO `productHistory` VALUES ('2023-10-26 13:28:17','[]','{}');
/*!40000 ALTER TABLE `productHistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productRecipe`
--

DROP TABLE IF EXISTS `productRecipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productRecipe` (
                                 `productID` varchar(20) NOT NULL,
                                 `recipe` text NOT NULL,
                                 PRIMARY KEY (`productID`),
                                 UNIQUE KEY `productRecipe_productID_uindex` (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productRecipe`
--

LOCK TABLES `productRecipe` WRITE;
/*!40000 ALTER TABLE `productRecipe` DISABLE KEYS */;
INSERT INTO `productRecipe` VALUES ('COF1','{\"[\\\"500ml\\\",\\\"cold\\\",\\\"0\\\"]\":[{\"capacity\":2,\"itemID\":\"e041930b1dbe4883b1fd0df5aaa1ca31\",\"priceEachItem\":0,\"priceEachUnit\":0,\"unit\":\"g\"}]}'),('JUI1','{\"[\\\"600ml\\\",\\\"cold\\\",\\\"3\\\"]\":[{\"capacity\":1,\"itemID\":\"e041930b1dbe4883b1fd0df5aaa1ca31\",\"priceEachItem\":0,\"priceEachUnit\":0,\"unit\":\"\"}]}');
/*!40000 ALTER TABLE `productRecipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productRecipeHistory`
--

DROP TABLE IF EXISTS `productRecipeHistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productRecipeHistory` (
                                        `time` varchar(20) NOT NULL,
                                        `productID` varchar(10) NOT NULL,
                                        `recipe` text NOT NULL,
                                        KEY `productRecipeHistory_time_index` (`time` DESC),
                                        KEY `productRecipe_productID_time_index` (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productRecipeHistory`
--

LOCK TABLES `productRecipeHistory` WRITE;
/*!40000 ALTER TABLE `productRecipeHistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `productRecipeHistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productSetting`
--

DROP TABLE IF EXISTS `productSetting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productSetting` (
                                  `productID` varchar(10) NOT NULL,
                                  `rateOfOperation` double DEFAULT NULL,
                                  `marginSZ` double DEFAULT NULL,
                                  `marginDG` double DEFAULT NULL,
                                  PRIMARY KEY (`productID`),
                                  UNIQUE KEY `productSetting_productID_uindex` (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productSetting`
--

LOCK TABLES `productSetting` WRITE;
/*!40000 ALTER TABLE `productSetting` DISABLE KEYS */;
INSERT INTO `productSetting` VALUES ('COF1',0.5,0.3,0.3),('JUI1',0.5,0.3,0.3);
/*!40000 ALTER TABLE `productSetting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productSettingHistory`
--

DROP TABLE IF EXISTS `productSettingHistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productSettingHistory` (
                                         `time` varchar(20) NOT NULL,
                                         `settingJSON` text,
                                         PRIMARY KEY (`time`),
                                         UNIQUE KEY `productSettingHistory_time_uindex` (`time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productSettingHistory`
--

LOCK TABLES `productSettingHistory` WRITE;
/*!40000 ALTER TABLE `productSettingHistory` DISABLE KEYS */;
INSERT INTO `productSettingHistory` VALUES ('2023-10-26 13:28:17','[]');
/*!40000 ALTER TABLE `productSettingHistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productSugarChoice`
--

DROP TABLE IF EXISTS `productSugarChoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productSugarChoice` (
                                      `levelNum` int NOT NULL,
                                      `levelWord` varchar(10) NOT NULL,
                                      PRIMARY KEY (`levelNum`),
                                      UNIQUE KEY `productSugarChoice_levelNum_uindex` (`levelNum`),
                                      UNIQUE KEY `productSugarChoice_levelWord_uindex` (`levelWord`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productSugarChoice`
--

LOCK TABLES `productSugarChoice` WRITE;
/*!40000 ALTER TABLE `productSugarChoice` DISABLE KEYS */;
INSERT INTO `productSugarChoice` VALUES (3,'三分糖'),(5,'五分糖'),(10,'全糖'),(0,'無糖');
/*!40000 ALTER TABLE `productSugarChoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rentCost`
--

DROP TABLE IF EXISTS `rentCost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rentCost` (
                            `budgetItemID` varchar(100) NOT NULL,
                            `store` varchar(100) DEFAULT NULL,
                            `rent` double DEFAULT NULL,
                            `manageFee` double DEFAULT NULL,
                            `waterFee` double DEFAULT NULL,
                            `decorationDeposit` double DEFAULT NULL,
                            `feeDeposit` double DEFAULT NULL,
                            `rentDeposit` double DEFAULT NULL,
                            `payTime` varchar(100) DEFAULT NULL,
                            `bePayedDays` int DEFAULT NULL,
                            `month` varchar(10) DEFAULT NULL,
                            PRIMARY KEY (`budgetItemID`),
                            UNIQUE KEY `rentCost_budgetItemID_uindex` (`budgetItemID`),
                            KEY `rentCost_month_store_index` (`month`,`store`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rentCost`
--

LOCK TABLES `rentCost` WRITE;
/*!40000 ALTER TABLE `rentCost` DISABLE KEYS */;
/*!40000 ALTER TABLE `rentCost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rentCostSec`
--

DROP TABLE IF EXISTS `rentCostSec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rentCostSec` (
                               `itemID` varchar(100) NOT NULL,
                               `month` varchar(100) DEFAULT NULL,
                               `part` varchar(10) DEFAULT NULL,
                               `store` varchar(100) DEFAULT NULL,
                               `item` varchar(100) DEFAULT NULL,
                               `expectPayPrice` double DEFAULT NULL,
                               `realPayPrice` double DEFAULT NULL,
                               `expectPayTime` varchar(100) DEFAULT NULL,
                               `realPayTime` varchar(100) DEFAULT NULL,
                               PRIMARY KEY (`itemID`),
                               UNIQUE KEY `rentCostThird_itemID_uindex` (`itemID`),
                               KEY `rentCostThird_store_month_index` (`store`,`month`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rentCostSec`
--

LOCK TABLES `rentCostSec` WRITE;
/*!40000 ALTER TABLE `rentCostSec` DISABLE KEYS */;
/*!40000 ALTER TABLE `rentCostSec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storeMenu`
--

DROP TABLE IF EXISTS `storeMenu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `storeMenu` (
                             `menuID` varchar(100) NOT NULL,
                             `store` varchar(10) DEFAULT NULL,
                             `productID` varchar(10) DEFAULT NULL,
                             PRIMARY KEY (`menuID`),
                             UNIQUE KEY `storeMenu_menuID_uindex` (`menuID`),
                             KEY `storeMenu_store_index` (`store`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storeMenu`
--

LOCK TABLES `storeMenu` WRITE;
/*!40000 ALTER TABLE `storeMenu` DISABLE KEYS */;
INSERT INTO `storeMenu` VALUES ('shop1_JUI1','shop1','JUI1'),('shop2_JUI1','shop2','JUI1');
/*!40000 ALTER TABLE `storeMenu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storeMenuHistory`
--

DROP TABLE IF EXISTS `storeMenuHistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `storeMenuHistory` (
                                    `time` varchar(20) NOT NULL,
                                    `store` varchar(10) NOT NULL,
                                    `menuJSON` text,
                                    PRIMARY KEY (`time`),
                                    UNIQUE KEY `storeMenuHistory_time_uindex` (`time`),
                                    KEY `storeMenuHistory_store_time_index` (`store`,`time` DESC)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storeMenuHistory`
--

LOCK TABLES `storeMenuHistory` WRITE;
/*!40000 ALTER TABLE `storeMenuHistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `storeMenuHistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `username` varchar(100) DEFAULT NULL,
                        `password` varchar(100) DEFAULT NULL,
                        `level` int DEFAULT NULL,
                        `role` varchar(100) DEFAULT NULL,
                        `enabled` tinyint(1) NOT NULL DEFAULT '1',
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `user_id_uindex` (`id`),
                        KEY `user_uname_index` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'alan','821210',1000,'admin',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-27 18:42:28