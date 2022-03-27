<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wujilin
  Date: 2021/3/31
  Time: 12:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>${warehouse}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="theme-color" content="#f8f9fa">
    <meta name="apple-mobile-web-app-title" content="vinvinERP">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <style>
        /*thead{*/
        /*    background-color: rgb(187, 205, 197);*/
        /*}*/

        .table-customize {
            --bs-table-bg: #b35c44;
            --bs-table-striped-bg: #b35c44;
            --bs-table-striped-color: #000;
            --bs-table-active-bg: #b35c44;
            --bs-table-active-color: #000;
            --bs-table-hover-bg: #b35c44;
            --bs-table-hover-color: #000;
            color: white;
            /*border-color:#b35c44*/
        }
        .table-customize2 {
            --bs-table-bg: #c2ccd0;
            --bs-table-striped-bg: #c2ccd0;
            --bs-table-striped-color: #000;
            --bs-table-active-bg: #c2ccd0;
            --bs-table-active-color: #000;
            --bs-table-hover-bg: #c2ccd0;
            --bs-table-hover-color: #000;
            color: black;

        }
        /*.table>:not(:last-child)>:last-child>* {*/
        /*    border-bottom-color: #b35c44;*/
        /*}*/

        /*tbody{*/
        /*    !*background: linear-gradient(90deg, #bbcdc5 0%, #bbcdc5 calc(100% - .05em), #ccc calc(100% - .05em), #ccc 100%);*!*/
        /*    background-color: #c2ccd0;*/
        /*}*/


        /* Fixed Headers */

        th {
            position: -webkit-sticky;
            position: sticky;
            top: 0;
            z-index: 2;

        }

        th[scope=row] {
            position: -webkit-sticky;
            position: sticky;
            left: 0;
            z-index: 1;
        }

        th[scope=row] {
            vertical-align: top;
            color: white;
            /*background-color: #b35c44;*/
            /*border-color:#b35c44;*/
            /*border-color: rgb(33, 37, 41);*/
            /*background: linear-gradient(90deg, transparent 0%, transparent calc(100% - .05em), #d6d6d6 calc(100% - .05em), #d6d6d6 100%);*/
        }

        th:not([scope=row]):first-child {
            left: 0;
            z-index: 3;
            /*border-color:#b35c44;*/
            /*background: linear-gradient(90deg, #b35c44 0%, #b35c44 calc(100% - .05em), #b35c44 calc(100% - .05em), #b35c44 100%);*/

        }



        /* Scrolling wrapper */

        div[tabindex="0"][aria-labelledby][role="region"] {
            overflow: auto;
        }

        div[tabindex="0"][aria-labelledby][role="region"]:focus {
            box-shadow: 0 0 .5em rgba(0,0,0,.5);
            outline: .1em solid rgba(0,0,0,.1);
        }

        div[tabindex="0"][aria-labelledby][role="region"] table {
            margin: 0;
        }

        div[tabindex="0"][aria-labelledby][role="region"].rowheaders {
            background:
                    linear-gradient(to right, transparent 30%, rgba(255,255,255,0)),
                    linear-gradient(to right, rgba(255,255,255,0), white 70%) 0 100%,
                    radial-gradient(farthest-side at 0% 50%, rgba(0,0,0,0.2), rgba(0,0,0,0)),
                    radial-gradient(farthest-side at 100% 50%, rgba(0,0,0,0.2), rgba(0,0,0,0)) 0 100%;
            background-repeat: no-repeat;
            background-color: #fff;
            background-size: 4em 100%, 4em 100%, 1.4em 100%, 1.4em 100%;
            background-position: 0 0, 100%, 0 0, 100%;
            background-attachment: local, local, scroll, scroll;
        }

        div[tabindex="0"][aria-labelledby][role="region"].colheaders {
            background:
                    linear-gradient(white 30%, rgba(255,255,255,0)),
                    linear-gradient(rgba(255,255,255,0), white 70%) 0 100%,
                    radial-gradient(farthest-side at 50% 0, rgba(0,0,0,.2), rgba(0,0,0,0)),
                    radial-gradient(farthest-side at 50% 100%, rgba(0,0,0,.2), rgba(0,0,0,0)) 0 100%;
            background-repeat: no-repeat;
            background-color: #fff;
            background-size: 100% 4em, 100% 4em, 100% 1.4em, 100% 1.4em;
            background-attachment: local, local, scroll, scroll;
        }

        /* Strictly for making the scrolling happen. */

        th[scope=row] {
            min-width: 40vw;
        }

        @media all and (min-width: 30em) {
            th[scope=row] {
                min-width: 20em;
            }
        }



        /*th[scope=row] + td {*/
        /*    min-width: 10em;*/
        /*}*/

        /*div[tabindex="0"][aria-labelledby][role="region"]:nth-child(3) {*/
        /*    max-height: 18em;*/
        /*}*/

        /*div[tabindex="0"][aria-labelledby][role="region"]:nth-child(7) {*/
        /*    max-height: 15em;*/
        /*    margin: 0 1em;*/
        /*}*/



    </style>
</head>
<body>
<%--<div class="alert alert-danger" style="padding-top: 5px !important; padding-bottom: 5px !important; margin-bottom: 0px !important;" role="alert">--%>
<%--    確認庫存警戒！！！--%>
<%--</div>--%>
<jsp:include page="navMain.jsp"/>

<div class="container">

    <div class="row clearfix">
        <div class="row">
            <div class="col-md-6 column">
                <br><br><br>
                <a class="btn btn-danger" role="button" href="${pageContext.request.contextPath}/receive/showExpiredList?location=${mainWarehouseEN}">過期報廢</a>
                <a class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/change/showAllItem">修改物料</a>
                <a class="btn btn-success" role="button" href="${pageContext.request.contextPath}/alert/showAlert?location=${mainWarehouseEN}">庫存警戒</a>
                <c:if test="${userLevel == 1000}">
                    <div class="btn-group">
                        <button type="button" class="btn btn-warning dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                            新增
                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item"
                                   href="${pageContext.request.contextPath}/${mainWarehouse}/toAdd?location=${mainWarehouseEN}&category=tool">新增設備</a>
                            </li>
                            <li><a class="dropdown-item"
                                   href="${pageContext.request.contextPath}/${mainWarehouse}/toAdd?location=${mainWarehouseEN}&category=food">新增材料</a>
                            </li>
                            <li><a class="dropdown-item"
                                   href="${pageContext.request.contextPath}/${mainWarehouse}/toAdd?location=${mainWarehouseEN}&category=smalltool">新增小器具</a>
                            </li>
                            <li><a class="dropdown-item"
                                   href="${pageContext.request.contextPath}/${mainWarehouse}/toAdd?location=${mainWarehouseEN}&category=commercialthing">新增宣传物料</a>
                            </li>
                            <li><a class="dropdown-item"
                                   href="${pageContext.request.contextPath}/${mainWarehouse}/toAdd?location=${mainWarehouseEN}&category=other">新增其他</a>
                            </li>
                        </ul>
                    </div>
                </c:if>
                <div class="btn-group">
                    <button type="button" class="btn btn-info dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                        物料
                    </button>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/apply/toApplyItem?location=${mainWarehouseEN}">物料申請</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/apply/showApplyItem?location=${mainWarehouseEN}">申請查詢</a>

                        </li>

                    </ul>
                </div>
<%--                <a class="btn btn-info" role="button" href="${pageContext.request.contextPath}/apply/toApplyItem?location=${mainWarehouseEN}" style="color: white">物料申請</a>--%>

            </div>
            <div class="col-md-6 column">
                <br><br>
                <ul>
                    <li>黄色表示现有库存量小于过去30天的总出库量，店长需考虑入货！</li>
                    <li>红色表示现有库存量小于过去7天的总出库量，店长记得必须入货！</li>
                    <li style="color: #b35c44">查看庫存警戒獲取完整訊息!!!!!</li>
                </ul>
            </div>
        </div>


        <div class="col-md-12 column">
            <br><br><br>
            <div class="row">
                <div class="col-md-4 column">
                    <h4>設備</h4>
                </div>
                <div class="col-md-3 column">

                </div>


            </div>

            <div role="region" style="overflow:scroll;height:50vh;" class="rowheaders">
                <table class="table table-borderless table-hover">
                    <thead class="table-customize">
                    <tr>
                        <%--                        <th hidden></th>--%>
                        <%--                        <th hidden>编号</th>--%>
                        <th>名稱</th>
                        <th>品牌</th>
                        <th>数量</th>
                        <c:if test="${userLevel==1000}">
                            <th>單價</th>
                            <th>總價</th>
                        </c:if>
                        <th>详情</th>
                        <th></th>
                        <th>操作</th>

                    </tr>
                    </thead>

                    <tbody>
                    <c:set var="headCount" value="0"/>
                    <c:forEach var="listItem" items="${listItem}">
                        <c:set var="headCount" value="${headCount + 1}"/>
                        <c:set var="id" value="${listItem.id}"/>
                        <c:set var="vinAlert" value="0"/>
                        <c:set var="vinAlert" value="${vinAlertMap[id]}"/>

                        <c:if test="${!vinAlert.equals(null) && vinAlert.ifalert_week.equals(true) && (vinAlert.ifalert_month.equals(true) || vinAlert.ifalert_month.equals(false))}">
                            <tr class="table-danger" style="color: black">
                                    <%--                        <td hidden>${headCount}</td>--%>
                                    <%--                        <td hidden>${listItem.id}</td>--%>
                                <th scope="row">${headCount}. ${listItem.itemName}</th>
                                <td>${listItem.brand}</td>
                                <td>${listItem.itemCount}</td>
                                <c:if test="${userLevel==1000}">
                                    <td>${listItem.singlePrice}</td>
                                    <td>${listItem.totalPrice}</td>
                                </c:if>

                                <td>${listItem.memo}</td>
                                <td>
                                    <a class="btn btn-success" href="${pageContext.request.contextPath}${ToolFilePathMap[listItem.id]}" role="button"  style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;" target="_blank">截圖</a>
                                </td>
                                <td>
                                    <div class="dropdown">
                                        <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButtontool" data-bs-toggle="dropdown" aria-expanded="false" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;">
                                            ...
                                        </button>
                                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButtontool">
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toUpdate?id=${listItem.id}&location=${mainWarehouseEN}&category=tool">修改</a></li>
                                            <c:if test="${userLevel==1000}">
                                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toInput?id=${listItem.id}&location=${mainWarehouseEN}&category=tool">入庫</a></li>
                                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/delete/${listItem.id}/${mainWarehouseEN}/tool" onclick="return del()">刪除</a></li>
                                            </c:if>
                                            <c:if test="${listItem.itemCount!=0}">
                                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toOutput?id=${listItem.id}&location=${mainWarehouseEN}&category=tool">出庫</a></li>
                                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toSend?id=${listItem.id}&location=${mainWarehouseEN}&category=tool">轉移</a></li>
                                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/dump/todumpItem?id=${listItem.id}&location=${mainWarehouseEN}&category=tool">報廢</a></li>
                                            </c:if>
                                            <c:if test="${listItem.itemCount==0}">
                                                <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">出庫</a></li>
                                                <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">轉移</a></li>
                                                <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">報廢</a></li>
                                            </c:if>


                                        </ul>
                                    </div>
                                </td>

                            </tr>
                        </c:if>
                        <c:if test="${!vinAlert.equals(null) && vinAlert.ifalert_week.equals(false) && vinAlert.ifalert_month.equals(true)}">
                            <tr class="table-warning">
                                    <%--                        <td hidden>${headCount}</td>--%>
                                    <%--                        <td hidden>${listItem.id}</td>--%>
                                <th scope="row" style="color: black">${headCount}. ${listItem.itemName}</th>
                                <td>${listItem.brand}</td>
                                <td>${listItem.itemCount}</td>
                                <c:if test="${userLevel==1000}">
                                    <td>${listItem.singlePrice}</td>
                                    <td>${listItem.totalPrice}</td>
                                </c:if>

                                <td>${listItem.memo}</td>
                                <td>
                                    <a class="btn btn-success" href="${pageContext.request.contextPath}${ToolFilePathMap[listItem.id]}" role="button" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;" target="_blank">截圖</a>
                                </td>
                                <td>
                                    <div class="dropdown">
                                        <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButtontool" data-bs-toggle="dropdown" aria-expanded="false" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;">
                                            ...
                                        </button>
                                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButtontool">
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toUpdate?id=${listItem.id}&location=${mainWarehouseEN}&category=tool">修改</a></li>
                                            <c:if test="${userLevel==1000}">
                                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toInput?id=${listItem.id}&location=${mainWarehouseEN}&category=tool">入庫</a></li>
                                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/delete/${listItem.id}/${mainWarehouseEN}/tool" onclick="return del()">刪除</a></li>
                                            </c:if>
                                            <c:if test="${listItem.itemCount!=0}">
                                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toOutput?id=${listItem.id}&location=${mainWarehouseEN}&category=tool">出庫</a></li>
                                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toSend?id=${listItem.id}&location=${mainWarehouseEN}&category=tool">轉移</a></li>
                                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/dump/todumpItem?id=${listItem.id}&location=${mainWarehouseEN}&category=tool">報廢</a></li>
                                            </c:if>
                                            <c:if test="${listItem.itemCount==0}">
                                                <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">出庫</a></li>
                                                <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">轉移</a></li>
                                                <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">報廢</a></li>
                                            </c:if>
                                        </ul>
                                    </div>
                                </td>

                            </tr>
                        </c:if>
                        <%--                        <c:if test="${!vinAlert.equals(null) && vinAlert.ifalert_week.equals(false) && vinAlert.ifalert_month.equals(false) || vinAlert.equals(null)}">--%>
                        <c:if test="${!vinAlert.equals(null) && vinAlert.ifalert_week.equals(false) && vinAlert.ifalert_month.equals(false) || !vinAlert.id.equals(listItem.id)}">
                            <tr>
                                    <%--                        <td class="table-customize2" hidden>${headCount}</td>--%>
                                    <%--                        <td class="table-customize2" hidden>${listItem.id}</td>--%>
                                <th class="table-customize" scope="row">${headCount}. ${listItem.itemName}</th>
                                <td class="table-customize2">${listItem.brand}</td>
                                <td class="table-customize2">${listItem.itemCount}</td>
                                <c:if test="${userLevel==1000}">
                                    <td class="table-customize2">${listItem.singlePrice}</td>
                                    <td class="table-customize2">${listItem.totalPrice}</td>
                                </c:if>

                                <td class="table-customize2">${listItem.memo}</td>
                                <td class="table-customize2">
                                    <a class="btn btn-success" href="${pageContext.request.contextPath}${ToolFilePathMap[listItem.id]}" role="button" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;" target="_blank">截圖</a>
                                </td>
                                <td class="table-customize2">
                                    <div class="dropdown">
                                        <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButtontool" data-bs-toggle="dropdown" aria-expanded="false" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;">
                                            ...
                                        </button>
                                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButtontool">
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toUpdate?id=${listItem.id}&location=${mainWarehouseEN}&category=tool">修改</a></li>
                                            <c:if test="${userLevel==1000}">
                                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toInput?id=${listItem.id}&location=${mainWarehouseEN}&category=tool">入庫</a></li>
                                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/delete/${listItem.id}/${mainWarehouseEN}/tool" onclick="return del()">刪除</a></li>
                                            </c:if>
                                            <c:if test="${listItem.itemCount!=0}">
                                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toOutput?id=${listItem.id}&location=${mainWarehouseEN}&category=tool">出庫</a></li>
                                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toSend?id=${listItem.id}&location=${mainWarehouseEN}&category=tool">轉移</a></li>
                                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/dump/todumpItem?id=${listItem.id}&location=${mainWarehouseEN}&category=tool">報廢</a></li>
                                            </c:if>
                                            <c:if test="${listItem.itemCount==0}">
                                                <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">出庫</a></li>
                                                <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">轉移</a></li>
                                                <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">報廢</a></li>
                                            </c:if>

                                        </ul>
                                    </div>
                                </td>

                            </tr>
                        </c:if>




                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-md-12 column">
            <div class="row">
                <div class="col-md-4 column">
                    <br><br><br>
                    <h4>材料</h4>
                </div>
                <div class="col-md-3 column">

                </div>


            </div>

            <div role="region" style="overflow:scroll;height:50vh;" class="rowheaders">
                <table class="table table-borderless table-hover">
                    <thead class="table-customize">
                    <tr>
                        <%--                        <th></th>--%>
                        <%--                        <th hidden>编号</th>--%>
                        <th>名稱</th>
                        <th>品牌</th>
                        <th>数量</th>
                        <c:if test="${userLevel==1000}">
                            <th>單價</th>
                            <th>總價</th>
                        </c:if>
                        <th>详情</th>
                        <th></th>
                        <th>操作</th>

                    </tr>
                    </thead>

                    <tbody>
                    <c:set var="headCount" value="0"/>
                    <c:forEach var="listFood" items="${listFood}">
                        <c:set var="headCount" value="${headCount + 1}"/>
                        <c:set var="id" value="${listFood.id}"/>
                        <c:set var="vinAlert" value="${vinAlertMap[id]}"/>

                        <c:if test="${!vinAlert.equals(null) && vinAlert.ifalert_week.equals(true) && (vinAlert.ifalert_month.equals(true) || vinAlert.ifalert_month.equals(false))}">
                            <tr class="table-danger">
                                    <%--                        <td>${headCount}</td>--%>
                                    <%--                        <td hidden>${listFood.id}</td>--%>
                                <th scope="row">${headCount}. ${listFood.itemName}</th>
                                <td>${listFood.brand}</td>
                                <td>${listFood.itemCount}</td>
                                <c:if test="${userLevel==1000}">
                                    <td>${listFood.singlePrice}</td>
                                    <td>${listFood.totalPrice}</td>
                                </c:if>
                                <td>${listFood.memo}</td>
                                <td>
                                    <a class="btn btn-success" href="${pageContext.request.contextPath}${FoodFilePathMap[listFood.id]}" role="button" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;" target="_blank">截圖</a>
                                </td>
                                <td>
                                    <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButtonfood" data-bs-toggle="dropdown" aria-expanded="false" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;">
                                        ...
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButtonfood">
                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toUpdate?id=${listFood.id}&location=${mainWarehouseEN}&category=food">修改</a></li>
                                        <c:if test="${userLevel==1000}">
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toInput?id=${listFood.id}&location=${mainWarehouseEN}&category=food">入庫</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/delete/${listFood.id}/${mainWarehouseEN}/food" onclick="return del()">刪除</a></li>
                                        </c:if>
                                        <c:if test="${listFood.itemCount!=0}">
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toOutput?id=${listFood.id}&location=${mainWarehouseEN}&category=food">出庫</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toSend?id=${listFood.id}&location=${mainWarehouseEN}&category=food">轉移</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/dump/todumpItem?id=${listFood.id}&location=${mainWarehouseEN}&category=food">報廢</a></li>
                                        </c:if>
                                        <c:if test="${listFood.itemCount==0}">
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">出庫</a></li>
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">轉移</a></li>
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">報廢</a></li>
                                        </c:if>


                                    </ul>

                                </td>

                            </tr>
                        </c:if>
                        <c:if test="${!vinAlert.equals(null) && vinAlert.ifalert_week.equals(false) && vinAlert.ifalert_month.equals(true)}">
                            <tr class="table-warning">
                                    <%--                        <td>${headCount}</td>--%>
                                    <%--                        <td hidden>${listFood.id}</td>--%>
                                <th scope="row" style="color: black">${headCount}. ${listFood.itemName}</th>
                                <td>${listFood.brand}</td>
                                <td>${listFood.itemCount}</td>
                                <c:if test="${userLevel==1000}">
                                    <td>${listFood.singlePrice}</td>
                                    <td>${listFood.totalPrice}</td>
                                </c:if>
                                <td>${listFood.memo}</td>
                                <td>
                                    <a class="btn btn-success" href="${pageContext.request.contextPath}${FoodFilePathMap[listFood.id]}" role="button" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;" target="_blank">截圖</a>
                                </td>
                                <td>
                                    <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButtonfood" data-bs-toggle="dropdown" aria-expanded="false" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;">
                                        ...
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButtonfood">
                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toUpdate?id=${listFood.id}&location=${mainWarehouseEN}&category=food">修改</a></li>
                                        <c:if test="${userLevel==1000}">
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toInput?id=${listFood.id}&location=${mainWarehouseEN}&category=food">入庫</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/delete/${listFood.id}/${mainWarehouseEN}/food" onclick="return del()">刪除</a></li>
                                        </c:if>
                                        <c:if test="${listFood.itemCount!=0}">
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toOutput?id=${listFood.id}&location=${mainWarehouseEN}&category=food">出庫</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toSend?id=${listFood.id}&location=${mainWarehouseEN}&category=food">轉移</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/dump/todumpItem?id=${listFood.id}&location=${mainWarehouseEN}&category=food">報廢</a></li>
                                        </c:if>
                                        <c:if test="${listFood.itemCount==0}">
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">出庫</a></li>
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">轉移</a></li>
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">報廢</a></li>
                                        </c:if>

                                    </ul>

                                </td>

                            </tr>
                        </c:if>
                        <c:if test="${!vinAlert.equals(null) && vinAlert.ifalert_week.equals(false) && vinAlert.ifalert_month.equals(false) || !vinAlert.id.equals(listFood.id)}">
                            <tr>
                                    <%--                        <td class="table-customize2">${headCount}</td>--%>
                                    <%--                        <td class="table-customize2" hidden>${listFood.id}</td>--%>
                                <th class="table-customize" scope="row">${headCount}. ${listFood.itemName}</th>
                                <td class="table-customize2">${listFood.brand}</td>
                                <td class="table-customize2">${listFood.itemCount}</td>
                                <c:if test="${userLevel==1000}">
                                    <td class="table-customize2">${listFood.singlePrice}</td>
                                    <td class="table-customize2">${listFood.totalPrice}</td>
                                </c:if>
                                <td class="table-customize2">${listFood.memo}</td>
                                <td class="table-customize2">
                                    <a class="btn btn-success" href="${pageContext.request.contextPath}${FoodFilePathMap[listFood.id]}" role="button" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;" target="_blank">截圖</a>
                                </td>
                                <td class="table-customize2">
                                    <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButtonfood" data-bs-toggle="dropdown" aria-expanded="false" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;">
                                        ...
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButtonfood">
                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toUpdate?id=${listFood.id}&location=${mainWarehouseEN}&category=food">修改</a></li>
                                        <c:if test="${userLevel==1000}">
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toInput?id=${listFood.id}&location=${mainWarehouseEN}&category=food">入庫</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/delete/${listFood.id}/${mainWarehouseEN}/food" onclick="return del()">刪除</a></li>
                                        </c:if>
                                        <c:if test="${listFood.itemCount!=0}">
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toOutput?id=${listFood.id}&location=${mainWarehouseEN}&category=food">出庫</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toSend?id=${listFood.id}&location=${mainWarehouseEN}&category=food">轉移</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/dump/todumpItem?id=${listFood.id}&location=${mainWarehouseEN}&category=food">報廢</a></li>
                                        </c:if>
                                        <c:if test="${listFood.itemCount==0}">
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">出庫</a></li>
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">轉移</a></li>
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">報廢</a></li>
                                        </c:if>

                                    </ul>

                                </td>

                            </tr>
                        </c:if>


                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-md-12 column">
            <div class="row">
                <div class="col-md-4 column">
                    <br><br><br>
                    <h4>小器具</h4>
                </div>
                <div class="col-md-3 column">

                </div>

            </div>
            <div role="region" style="overflow:scroll;height:50vh;" class="rowheaders">
                <table class="table table-borderless table-hover">
                    <thead class="table-customize">
                    <tr>
                        <%--                        <th></th>--%>
                        <%--                        <th hidden>编号</th>--%>
                        <th>名稱</th>
                        <th>品牌</th>
                        <th>数量</th>
                        <c:if test="${userLevel==1000}">
                            <th>單價</th>
                            <th>總價</th>
                        </c:if>
                        <th>详情</th>
                        <th></th>
                        <th>操作</th>

                    </tr>
                    </thead>

                    <tbody>
                    <c:set var="headCount" value="0"/>
                    <c:forEach var="listSmallItem" items="${listSmallItem}">
                        <c:set var="headCount" value="${headCount + 1}"/>
                        <c:set var="id" value="${listSmallItem.id}"/>
                        <c:set var="vinAlert" value="${vinAlertMap[id]}"/>

                        <c:if test="${!vinAlert.equals(null) && vinAlert.ifalert_week.equals(true) && (vinAlert.ifalert_month.equals(true) || vinAlert.ifalert_month.equals(false))}">
                            <tr class="table-danger">
                                    <%--                        <td>${headCount}</td>--%>
                                    <%--                        <td hidden>${listSmallItem.id}</td>--%>
                                <th scope="row">${headCount}. ${listSmallItem.itemName}</th>
                                <td>${listSmallItem.brand}</td>
                                <td>${listSmallItem.itemCount}</td>
                                <c:if test="${userLevel==1000}">
                                    <td>${listSmallItem.singlePrice}</td>
                                    <td>${listSmallItem.totalPrice}</td>
                                </c:if>
                                <td>${listSmallItem.memo}</td>
                                <td>
                                    <a class="btn btn-success" href="${pageContext.request.contextPath}${SmallItemFilePathMap[listSmallItem.id]}" role="button" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;" target="_blank">截圖</a>
                                </td>
                                <td>
                                    <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButtonsmalltool" data-bs-toggle="dropdown" aria-expanded="false" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;">
                                        ...
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButtonsmalltool">
                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toUpdate?id=${listSmallItem.id}&location=${mainWarehouseEN}&category=smalltool">修改</a></li>
                                        <c:if test="${userLevel==1000}">
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toInput?id=${listSmallItem.id}&location=${mainWarehouseEN}&category=smalltool">入庫</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/delete/${listSmallItem.id}/${mainWarehouseEN}/smalltool" onclick="return del()">刪除</a></li>
                                        </c:if>
                                        <c:if test="${listSmallItem.itemCount!=0}">
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toOutput?id=${listSmallItem.id}&location=${mainWarehouseEN}&category=smalltool">出庫</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toSend?id=${listSmallItem.id}&location=${mainWarehouseEN}&category=smalltool">轉移</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/dump/todumpItem?id=${listSmallItem.id}&location=${mainWarehouseEN}&category=smalltool">報廢</a></li>
                                        </c:if>
                                        <c:if test="${listSmallItem.itemCount==0}">
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">出庫</a></li>
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">轉移</a></li>
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">報廢</a></li>
                                        </c:if>


                                    </ul>

                                </td>

                            </tr>
                        </c:if>
                        <c:if test="${!vinAlert.equals(null) && vinAlert.ifalert_week.equals(false) && vinAlert.ifalert_month.equals(true)}">
                            <tr class="table-warning">
                                    <%--                        <td>${headCount}</td>--%>
                                    <%--                        <td hidden>${listSmallItem.id}</td>--%>
                                <th scope="row" style="color: black">${headCount}. ${listSmallItem.itemName}</th>
                                <td>${listSmallItem.brand}</td>
                                <td>${listSmallItem.itemCount}</td>
                                <c:if test="${userLevel==1000}">
                                    <td>${listSmallItem.singlePrice}</td>
                                    <td>${listSmallItem.totalPrice}</td>
                                </c:if>
                                <td>${listSmallItem.memo}</td>
                                <td>
                                    <a class="btn btn-success" href="${pageContext.request.contextPath}${SmallItemFilePathMap[listSmallItem.id]}" role="button" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;" target="_blank">截圖</a>
                                </td>
                                <td>
                                    <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButtonsmalltool" data-bs-toggle="dropdown" aria-expanded="false" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;">
                                        ...
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButtonsmalltool">
                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toUpdate?id=${listSmallItem.id}&location=${mainWarehouseEN}&category=smalltool">修改</a></li>
                                        <c:if test="${userLevel==1000}">
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toInput?id=${listSmallItem.id}&location=${mainWarehouseEN}&category=smalltool">入庫</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/delete/${listSmallItem.id}/${mainWarehouseEN}/smalltool" onclick="return del()">刪除</a></li>
                                        </c:if>
                                        <c:if test="${listSmallItem.itemCount!=0}">
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toOutput?id=${listSmallItem.id}&location=${mainWarehouseEN}&category=smalltool">出庫</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toSend?id=${listSmallItem.id}&location=${mainWarehouseEN}&category=smalltool">轉移</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/dump/todumpItem?id=${listSmallItem.id}&location=${mainWarehouseEN}&category=smalltool">報廢</a></li>
                                        </c:if>
                                        <c:if test="${listSmallItem.itemCount==0}">
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">出庫</a></li>
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">轉移</a></li>
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">報廢</a></li>
                                        </c:if>
                                    </ul>

                                </td>

                            </tr>
                        </c:if>
                        <c:if test="${!vinAlert.equals(null) && vinAlert.ifalert_week.equals(false) && vinAlert.ifalert_month.equals(false) || !vinAlert.id.equals(listSmallItem.id)}">
                            <tr>
                                    <%--                        <td class="table-customize2">${headCount}</td>--%>
                                    <%--                        <td class="table-customize2" hidden>${listSmallItem.id}</td>--%>
                                <th class="table-customize" scope="row">${headCount}. ${listSmallItem.itemName}</th>
                                <td class="table-customize2">${listSmallItem.brand}</td>
                                <td class="table-customize2">${listSmallItem.itemCount}</td>
                                <c:if test="${userLevel==1000}">
                                    <td class="table-customize2">${listSmallItem.singlePrice}</td>
                                    <td class="table-customize2">${listSmallItem.totalPrice}</td>
                                </c:if>
                                <td class="table-customize2">${listSmallItem.memo}</td>
                                <td class="table-customize2">
                                    <a class="btn btn-success" href="${pageContext.request.contextPath}${SmallItemFilePathMap[listSmallItem.id]}" role="button" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;" target="_blank">截圖</a>
                                </td>
                                <td class="table-customize2">
                                    <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButtonsmalltool" data-bs-toggle="dropdown" aria-expanded="false" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;">
                                        ...
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButtonsmalltool">
                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toUpdate?id=${listSmallItem.id}&location=${mainWarehouseEN}&category=smalltool">修改</a></li>
                                        <c:if test="${userLevel==1000}">
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toInput?id=${listSmallItem.id}&location=${mainWarehouseEN}&category=smalltool">入庫</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/delete/${listSmallItem.id}/${mainWarehouseEN}/smalltool" onclick="return del()">刪除</a></li>
                                        </c:if>
                                        <c:if test="${listSmallItem.itemCount!=0}">
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toOutput?id=${listSmallItem.id}&location=${mainWarehouseEN}&category=smalltool">出庫</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toSend?id=${listSmallItem.id}&location=${mainWarehouseEN}&category=smalltool">轉移</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/dump/todumpItem?id=${listSmallItem.id}&location=${mainWarehouseEN}&category=smalltool">報廢</a></li>
                                        </c:if>
                                        <c:if test="${listSmallItem.itemCount==0}">
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">出庫</a></li>
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">轉移</a></li>
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">報廢</a></li>
                                        </c:if>
                                    </ul>

                                </td>

                            </tr>
                        </c:if>


                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-md-12 column">
            <div class="row">
                <div class="col-md-4 column">
                    <br><br><br>
                    <h4>宣传物料</h4>
                </div>
                <div class="col-md-3 column">

                </div>
            </div>
            <div role="region" style="overflow:scroll;height:50vh;" class="rowheaders">
                <table class="table table-borderless table-hover">
                    <thead class="table-customize">
                    <tr>
                        <%--                        <th></th>--%>
                        <%--                        <th hidden>编号</th>--%>
                        <th>名稱</th>
                        <th>品牌</th>
                        <th>数量</th>
                        <c:if test="${userLevel==1000}">
                            <th>單價</th>
                            <th>總價</th>
                        </c:if>
                        <th>详情</th>
                        <th></th>
                        <th>操作</th>

                    </tr>
                    </thead>

                    <tbody>
                    <c:set var="headCount" value="0"/>
                    <c:forEach var="listCommercialItem" items="${listCommercialItem}">
                        <c:set var="headCount" value="${headCount + 1}"/>
                        <c:set var="id" value="${listCommercialItem.id}"/>
                        <c:set var="vinAlert" value="${vinAlertMap[id]}"/>

                        <c:if test="${!vinAlert.equals(null) && vinAlert.ifalert_week.equals(true) && (vinAlert.ifalert_month.equals(true) || vinAlert.ifalert_month.equals(false))}">
                            <tr class="table-danger">
                                    <%--                        <td>${headCount}</td>--%>
                                    <%--                        <td hidden>${listCommercialItem.id}</td>--%>
                                <th scope="row">${headCount}. ${listCommercialItem.itemName}</th>
                                <td>${listCommercialItem.brand}</td>
                                <td>${listCommercialItem.itemCount}</td>
                                <c:if test="${userLevel==1000}">
                                    <td>${listCommercialItem.singlePrice}</td>
                                    <td>${listCommercialItem.totalPrice}</td>
                                </c:if>
                                <td>${listCommercialItem.memo}</td>
                                <td>
                                    <a class="btn btn-success" href="${pageContext.request.contextPath}${CommercialFilePathMap[listCommercialItem.id]}" role="button" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;" target="_blank">截圖</a>
                                </td>
                                <td>
                                    <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButtoncommercial" data-bs-toggle="dropdown" aria-expanded="false" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;">
                                        ...
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButtoncommercial">
                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toUpdate?id=${listCommercialItem.id}&location=${mainWarehouseEN}&category=commercialthing">修改</a></li>
                                        <c:if test="${userLevel==1000}">
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toInput?id=${listCommercialItem.id}&location=${mainWarehouseEN}&category=commercialthing">入庫</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/delete/${listCommercialItem.id}/${mainWarehouseEN}/commercialthing" onclick="return del()">刪除</a></li>
                                        </c:if>
                                        <c:if test="${listCommercialItem.itemCount!=0}">
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toOutput?id=${listCommercialItem.id}&location=${mainWarehouseEN}&category=commercialthing">出庫</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toSend?id=${listCommercialItem.id}&location=${mainWarehouseEN}&category=commercialthing">轉移</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/dump/todumpItem?id=${listCommercialItem.id}&location=${mainWarehouseEN}&category=commercial">報廢</a></li>
                                        </c:if>
                                        <c:if test="${listCommercialItem.itemCount==0}">
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">出庫</a></li>
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">轉移</a></li>
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">報廢</a></li>
                                        </c:if>

                                    </ul>

                                </td>

                            </tr>
                        </c:if>
                        <c:if test="${!vinAlert.equals(null) && vinAlert.ifalert_week.equals(false) && vinAlert.ifalert_month.equals(true)}">
                            <tr class="table-warning">
                                    <%--                        <td>${headCount}</td>--%>
                                    <%--                        <td hidden>${listCommercialItem.id}</td>--%>
                                <th scope="row" style="color: black">${headCount}. ${listCommercialItem.itemName}</th>
                                <td>${listCommercialItem.brand}</td>
                                <td>${listCommercialItem.itemCount}</td>
                                <c:if test="${userLevel==1000}">
                                    <td>${listCommercialItem.singlePrice}</td>
                                    <td>${listCommercialItem.totalPrice}</td>
                                </c:if>
                                <td>${listCommercialItem.memo}</td>
                                <td>
                                    <a class="btn btn-success" href="${pageContext.request.contextPath}${CommercialFilePathMap[listCommercialItem.id]}" role="button" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;" target="_blank">截圖</a>
                                </td>
                                <td>
                                    <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButtoncommercial" data-bs-toggle="dropdown" aria-expanded="false" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;">
                                        ...
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButtoncommercial">
                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toUpdate?id=${listCommercialItem.id}&location=${mainWarehouseEN}&category=commercialthing">修改</a></li>
                                        <c:if test="${userLevel==1000}">
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toInput?id=${listCommercialItem.id}&location=${mainWarehouseEN}&category=commercialthing">入庫</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/delete/${listCommercialItem.id}/${mainWarehouseEN}/commercialthing" onclick="return del()">刪除</a></li>
                                        </c:if>
                                        <c:if test="${listCommercialItem.itemCount!=0}">
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toOutput?id=${listCommercialItem.id}&location=${mainWarehouseEN}&category=commercialthing">出庫</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toSend?id=${listCommercialItem.id}&location=${mainWarehouseEN}&category=commercialthing">轉移</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/dump/todumpItem?id=${listCommercialItem.id}&location=${mainWarehouseEN}&category=commercial">報廢</a></li>
                                        </c:if>
                                        <c:if test="${listCommercialItem.itemCount==0}">
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">出庫</a></li>
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">轉移</a></li>
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">報廢</a></li>
                                        </c:if>
                                    </ul>

                                </td>

                            </tr>
                        </c:if>
                        <c:if test="${!vinAlert.equals(null) && vinAlert.ifalert_week.equals(false) && vinAlert.ifalert_month.equals(false) || !vinAlert.id.equals(listCommercialItem.id)}">
                            <tr>
                                    <%--                        <td class="table-customize2">${headCount}</td>--%>
                                    <%--                        <td class="table-customize2" hidden>${listCommercialItem.id}</td>--%>
                                <th class="table-customize" scope="row">${headCount}. ${listCommercialItem.itemName}</th>
                                <td class="table-customize2">${listCommercialItem.brand}</td>
                                <td class="table-customize2">${listCommercialItem.itemCount}</td>
                                <c:if test="${userLevel==1000}">
                                    <td class="table-customize2">${listCommercialItem.singlePrice}</td>
                                    <td class="table-customize2">${listCommercialItem.totalPrice}</td>
                                </c:if>
                                <td class="table-customize2">${listCommercialItem.memo}</td>
                                <td class="table-customize2">
                                    <a class="btn btn-success" href="${pageContext.request.contextPath}${CommercialFilePathMap[listCommercialItem.id]}" role="button" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;" target="_blank">截圖</a>
                                </td>
                                <td class="table-customize2">
                                    <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButtoncommercial" data-bs-toggle="dropdown" aria-expanded="false" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;">
                                        ...
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButtoncommercial">
                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toUpdate?id=${listCommercialItem.id}&location=${mainWarehouseEN}&category=commercialthing">修改</a></li>
                                        <c:if test="${userLevel==1000}">
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toInput?id=${listCommercialItem.id}&location=${mainWarehouseEN}&category=commercialthing">入庫</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/delete/${listCommercialItem.id}/${mainWarehouseEN}/commercialthing" onclick="return del()">刪除</a></li>
                                        </c:if>
                                        <c:if test="${listCommercialItem.itemCount!=0}">
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toOutput?id=${listCommercialItem.id}&location=${mainWarehouseEN}&category=commercialthing">出庫</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toSend?id=${listCommercialItem.id}&location=${mainWarehouseEN}&category=commercialthing">轉移</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/dump/todumpItem?id=${listCommercialItem.id}&location=${mainWarehouseEN}&category=commercial">報廢</a></li>
                                        </c:if>
                                        <c:if test="${listCommercialItem.itemCount==0}">
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">出庫</a></li>
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">轉移</a></li>
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">報廢</a></li>
                                        </c:if>
                                    </ul>

                                </td>

                            </tr>
                        </c:if>


                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-md-12 column">
            <div class="row">
                <div class="col-md-4 column">
                    <br><br><br>
                    <h4>其他</h4>
                </div>
                <div class="col-md-3 column">

                </div>

            </div>
            <div style="overflow:scroll;height:50vh;">
                <table class="table table-borderless table-hover">
                    <thead class="table-customize">
                    <tr>
                        <%--                        <th></th>--%>
                        <%--                        <th hidden>编号</th>--%>
                        <th>名稱</th>
                        <th>品牌</th>
                        <th>数量</th>
                        <c:if test="${userLevel==1000}">
                            <th>單價</th>
                            <th>總價</th>
                        </c:if>
                        <th>详情</th>
                        <th></th>
                        <th>操作</th>

                    </tr>
                    </thead>

                    <tbody>
                    <c:set var="headCount" value="0"/>
                    <c:forEach var="listothers" items="${listothers}">
                        <c:set var="headCount" value="${headCount + 1}"/>
                        <c:set var="id" value="${listothers.id}"/>
                        <c:set var="vinAlert" value="${vinAlertMap[id]}"/>

                        <c:if test="${!vinAlert.equals(null) && vinAlert.ifalert_week.equals(true) && (vinAlert.ifalert_month.equals(true) || vinAlert.ifalert_month.equals(false))}">
                            <tr class="table-danger">
                                    <%--                        <td>${headCount}</td>--%>
                                    <%--                        <td hidden>${listothers.id}</td>--%>
                                <th scope="row">${headCount}. ${listothers.itemName}</th>
                                <td>${listothers.brand}</td>
                                <td>${listothers.itemCount}</td>
                                <c:if test="${userLevel==1000}">
                                    <td>${listothers.singlePrice}</td>
                                    <td>${listothers.totalPrice}</td>
                                </c:if>
                                <td>${listothers.memo}</td>
                                <td>
                                    <a class="btn btn-success" href="${pageContext.request.contextPath}${OthersFilePathMap[listothers.id]}" role="button" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;" target="_blank">截圖</a>
                                </td>
                                <td>
                                    <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButtonother" data-bs-toggle="dropdown" aria-expanded="false" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;">
                                        ...
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButtonother">
                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toUpdate?id=${listothers.id}&location=${mainWarehouseEN}&category=other">修改</a></li>
                                        <c:if test="${userLevel==1000}">
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toInput?id=${listothers.id}&location=${mainWarehouseEN}&category=other">入庫</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/delete/${listothers.id}/${mainWarehouseEN}/other" onclick="return del()">刪除</a></li>
                                        </c:if>
                                        <c:if test="${listothers.itemCount!=0}">
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toOutput?id=${listothers.id}&location=${mainWarehouseEN}&category=other">出庫</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toSend?id=${listothers.id}&location=${mainWarehouseEN}&category=other">轉移</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/dump/todumpItem?id=${listothers.id}&location=${mainWarehouseEN}&category=other">報廢</a></li>
                                        </c:if>
                                        <c:if test="${listothers.itemCount==0}">
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">出庫</a></li>
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">轉移</a></li>
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">報廢</a></li>
                                        </c:if>

                                    </ul>

                                </td>

                            </tr>
                        </c:if>
                        <c:if test="${!vinAlert.equals(null) && vinAlert.ifalert_week.equals(false) && vinAlert.ifalert_month.equals(true)}">
                            <tr class="table-warning">
                                    <%--                        <td>${headCount}</td>--%>
                                    <%--                        <td hidden>${listothers.id}</td>--%>
                                <th scope="row" style="color: black">${headCount}. ${listothers.itemName}</th>
                                <td>${listothers.brand}</td>
                                <td>${listothers.itemCount}</td>
                                <c:if test="${userLevel==1000}">
                                    <td>${listothers.singlePrice}</td>
                                    <td>${listothers.totalPrice}</td>
                                </c:if>
                                <td>${listothers.memo}</td>
                                <td>
                                    <a class="btn btn-success" href="${pageContext.request.contextPath}${OthersFilePathMap[listothers.id]}" role="button" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;" target="_blank">截圖</a>
                                </td>
                                <td>
                                    <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButtonother" data-bs-toggle="dropdown" aria-expanded="false" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;">
                                        ...
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButtonother">
                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toUpdate?id=${listothers.id}&location=${mainWarehouseEN}&category=other">修改</a></li>
                                        <c:if test="${userLevel==1000}">
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toInput?id=${listothers.id}&location=${mainWarehouseEN}&category=other">入庫</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/delete/${listothers.id}/${mainWarehouseEN}/other" onclick="return del()">刪除</a></li>
                                        </c:if>
                                        <c:if test="${listothers.itemCount!=0}">
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toOutput?id=${listothers.id}&location=${mainWarehouseEN}&category=other">出庫</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toSend?id=${listothers.id}&location=${mainWarehouseEN}&category=other">轉移</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/dump/todumpItem?id=${listothers.id}&location=${mainWarehouseEN}&category=other">報廢</a></li>
                                        </c:if>
                                        <c:if test="${listothers.itemCount==0}">
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">出庫</a></li>
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">轉移</a></li>
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">報廢</a></li>
                                        </c:if>
                                    </ul>

                                </td>

                            </tr>
                        </c:if>
                        <c:if test="${!vinAlert.equals(null) && vinAlert.ifalert_week.equals(false) && vinAlert.ifalert_month.equals(false) || !vinAlert.id.equals(listothers.id)}">
                            <tr>
                                    <%--                        <td class="table-customize2">${headCount}</td>--%>
                                    <%--                        <td class="table-customize2" hidden>${listothers.id}</td>--%>
                                <th class="table-customize" scope="row">${headCount}. ${listothers.itemName}</th>
                                <td class="table-customize2">${listothers.brand}</td>
                                <td class="table-customize2">${listothers.itemCount}</td>
                                <c:if test="${userLevel==1000}">
                                    <td class="table-customize2">${listothers.singlePrice}</td>
                                    <td class="table-customize2">${listothers.totalPrice}</td>
                                </c:if>
                                <td class="table-customize2">${listothers.memo}</td>
                                <td class="table-customize2">
                                    <a class="btn btn-success" href="${pageContext.request.contextPath}${OthersFilePathMap[listothers.id]}" role="button" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;" target="_blank">截圖</a>
                                </td>
                                <td class="table-customize2">
                                    <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButtonother" data-bs-toggle="dropdown" aria-expanded="false" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;">
                                        ...
                                    </button>
                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButtonother">
                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toUpdate?id=${listothers.id}&location=${mainWarehouseEN}&category=other">修改</a></li>
                                        <c:if test="${userLevel==1000}">
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toInput?id=${listothers.id}&location=${mainWarehouseEN}&category=other">入庫</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/delete/${listothers.id}/${mainWarehouseEN}/other" onclick="return del()">刪除</a></li>
                                        </c:if>
                                        <c:if test="${listothers.itemCount!=0}">
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toOutput?id=${listothers.id}&location=${mainWarehouseEN}&category=other">出庫</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toSend?id=${listothers.id}&location=${mainWarehouseEN}&category=other">轉移</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/dump/todumpItem?id=${listothers.id}&location=${mainWarehouseEN}&category=other">報廢</a></li>
                                        </c:if>
                                        <c:if test="${listothers.itemCount==0}">
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">出庫</a></li>
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">轉移</a></li>
                                            <li><a class="dropdown-item disabled" href="#" tabindex="-1" aria-disabled="true">報廢</a></li>
                                        </c:if>
                                    </ul>

                                </td>

                            </tr>
                        </c:if>


                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-md-12 column">
            <br><br>
        </div>
    </div>
</div>
<script>
    function del() {
        var msg = "哦？刪除？\n\n你確定？";
        console.log("del");
        if (confirm(msg)==true){

            return true;
        }else{
            return false;
        }
    }
    // $(document).ready(function (){
    //     var alert_sentence="庫存警告";
    //     alert(alert_sentence);
    // });
</script>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
        crossorigin="anonymous"></script>
</body>
</html>
