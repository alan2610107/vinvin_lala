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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <style>
        /*thead{*/
        /*    background-color: rgb(187, 205, 197);*/
        /*}*/
        #lookinto{
            padding: 1px;
        }
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
<jsp:include page="navwithSearch.jsp"/>

<div class="container-fluid">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <br><br><br>
            <div class="row">
                <div class="col-md-4 column">

                </div>
                <div class="col-md-4 column">
                    <div style="width: 149px;margin: 0 auto;">
                        <div class="btn-group">
                            <a href="${pageContext.request.contextPath}/log/warehouseifComplete?location=${location}&ifComplete=false" class="btn btn-danger" aria-current="page">未完成</a>
                            <a href="${pageContext.request.contextPath}/log/warehouseifComplete?location=${location}&ifComplete=true" class="btn btn-primary">已完成</a>
                        </div>
                    </div>

                </div>
                <div class="col-md-4 column">

                </div>

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

            <div style="overflow:scroll;height:50vh;">
                <table class="table table-hover table-borderless">
                    <thead class="table-customize">
                    <tr>
                        <%--                        <th></th>--%>
                        <%--                        <th>编号</th>--%>
                        <th>名字</th>
                        <th>品牌</th>
                        <th>数量</th>
                        <c:if test="${userLevel==1000}">
                            <th>單價</th>
                            <th>總價</th>
                        </c:if>

                        <th>详情</th>
                        <th>時間</th>
                        <th>動作</th>
                        <th>從</th>
                        <th>到</th>
                        <th>狀態</th>
                        <th>調閱</th>

                        <%--                    <th>操作</th>--%>

                    </tr>
                    </thead>

                    <tbody>
                    <c:set var="headCount" value="0"/>
                    <c:forEach var="listItem" items="${listItem}">
                        <c:set var="headCount" value="${headCount + 1}"/>

                        <c:if test="${listItem.action.equals('input')}">
                            <c:set var="actionCN" value="入庫"/>
                        </c:if>
                        <c:if test="${listItem.action.equals('output')}">
                            <c:set var="actionCN" value="出庫"/>
                        </c:if>
                        <c:if test="${listItem.action.equals('send')}">
                            <c:set var="actionCN" value="轉移"/>
                        </c:if>
                        <c:if test="${listItem.action.equals('edit')}">
                            <c:set var="actionCN" value="編輯"/>
                        </c:if>
                        <c:if test="${listItem.action.equals('reject')}">
                            <c:set var="actionCN" value="沒過審核"/>
                        </c:if>
                        <c:if test="${listItem.action.equals('delete')}">
                            <c:set var="actionCN" value="刪除"/>
                        </c:if>
                        <c:if test="${listItem.action.equals('dump')}">
                            <c:set var="actionCN" value="報廢"/>
                        </c:if>
                        <c:if test="${listItem.action.equals('newinput')}">
                            <c:set var="actionCN" value="新增"/>
                        </c:if>
                        <c:set var="from" value="${listItem.from}"/>
                        <c:set var="to" value="${listItem.to}"/>
                        <c:set var="locationFrom" value="${locationHashMap[from]}"/>
                        <c:set var="locationTo" value="${locationHashMap[to]}"/>



                        <tr>

                                <%--                            <td class="table-customize2">${headCount}</td>--%>
                                <%--                            <td class="table-customize2">${listItem.id}</td>--%>
                            <th class="table-customize" scope="row">${headCount}. ${listItem.itemName}</th>
                            <td class="table-customize2">${listItem.brand}</td>
                            <td class="table-customize2">${listItem.itemCount}</td>
                            <c:if test="${userLevel==1000}">
                                <td class="table-customize2">${listItem.singlePrice}</td>
                                <td class="table-customize2">${listItem.totalPrice}</td>
                            </c:if>
                            <td class="table-customize2">${listItem.memo}</td>
                            <td class="table-customize2">${listItem.time}</td>
                            <td class="table-customize2">${actionCN}</td>
                            <td class="table-customize2">${locationFrom}</td>
                            <td class="table-customize2">${locationTo}</td>
                            <c:if test="${listItem.ifComplete.equals(false) && listItem.ifConfirm.equals(false)}">
                                <td class="table-customize2" style="color: #404e53;font-weight:bold">審核中...</td>
                            </c:if>
                            <c:if test="${listItem.ifComplete.equals(false) && listItem.ifConfirm.equals(true)}">
                                <td class="table-customize2" style="color: #d0c6c2;font-weight:bold"><a href="${pageContext.request.contextPath}/receive/list?location=${location}">注意收貨</a></td>
                            </c:if>
                            <c:if test="${listItem.ifComplete.equals(true)}">
                                <td class="table-customize2">已完成</td>
                            </c:if>
                            <td class="table-customize2">
                                <a id="lookinto" class="btn btn-primary" href="${pageContext.request.contextPath}/${mainWarehouse}/lookupsingleItem?location=${location}&id=${listItem.id}&category=${categoryTool}">
                                    調閱
                                </a>
                            </td>


                        </tr>
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

            <div style="overflow:scroll;height:50vh;">
                <table class="table table-hover table-borderless">
                    <thead class="table-customize">
                    <tr>
                        <%--                        <th></th>--%>
                        <%--                        <th>编号</th>--%>
                        <th>名字</th>
                        <th>品牌</th>
                        <th>数量</th>
                        <c:if test="${userLevel==1000}">
                            <th>單價</th>
                            <th>總價</th>
                        </c:if>
                        <th>详情</th>
                        <th>時間</th>
                        <th>動作</th>
                        <th>從</th>
                        <th>到</th>
                        <th>狀態</th>
                        <th>調閱</th>
                        <%--                    <th>操作</th>--%>

                    </tr>
                    </thead>

                    <tbody>
                    <c:set var="headCount" value="0"/>
                    <c:forEach var="listFood" items="${listFood}">
                        <c:set var="headCount" value="${headCount + 1}"/>
                        <c:if test="${listFood.action.equals('input')}">
                            <c:set var="actionCN" value="入庫"/>
                        </c:if>
                        <c:if test="${listFood.action.equals('output')}">
                            <c:set var="actionCN" value="出庫"/>
                        </c:if>
                        <c:if test="${listFood.action.equals('send')}">
                            <c:set var="actionCN" value="轉移"/>
                        </c:if>
                        <c:if test="${listFood.action.equals('edit')}">
                            <c:set var="actionCN" value="編輯"/>
                        </c:if>
                        <c:if test="${listFood.action.equals('reject')}">
                            <c:set var="actionCN" value="沒過審核"/>
                        </c:if>
                        <c:if test="${listFood.action.equals('delete')}">
                            <c:set var="actionCN" value="刪除"/>
                        </c:if>
                        <c:if test="${listFood.action.equals('dump')}">
                            <c:set var="actionCN" value="報廢"/>
                        </c:if>
                        <c:if test="${listFood.action.equals('newinput')}">
                            <c:set var="actionCN" value="新增"/>
                        </c:if>
                        <c:set var="from" value="${listFood.from}"/>
                        <c:set var="to" value="${listFood.to}"/>
                        <c:set var="locationFrom" value="${locationHashMap[from]}"/>
                        <c:set var="locationTo" value="${locationHashMap[to]}"/>
                        <tr>
                                <%--                            <td class="table-customize2">${headCount}</td>--%>
                                <%--                            <td class="table-customize2">${listFood.id}</td>--%>
                            <th class="table-customize" scope="row">${headCount}. ${listFood.itemName}</th>
                            <td class="table-customize2">${listFood.brand}</td>
                            <td class="table-customize2">${listFood.itemCount}</td>
                            <c:if test="${userLevel==1000}">
                                <td class="table-customize2">${listFood.singlePrice}</td>
                                <td class="table-customize2">${listFood.totalPrice}</td>
                            </c:if>
                            <td class="table-customize2">${listFood.memo}</td>
                            <td class="table-customize2">${listFood.time}</td>
                            <td class="table-customize2">${actionCN}</td>
                            <td class="table-customize2">${locationFrom}</td>
                            <td class="table-customize2">${locationTo}</td>
                            <c:if test="${listFood.ifComplete.equals(false) && listFood.ifConfirm.equals(false)}">
                                <td class="table-customize2" style="color: #404e53;font-weight:bold">審核中...</td>
                            </c:if>
                            <c:if test="${listFood.ifComplete.equals(false) && listFood.ifConfirm.equals(true)}">
                                <td class="table-customize2" style="color: #d0c6c2;font-weight:bold"><a href="${pageContext.request.contextPath}/receive/list?location=${location}">注意收貨</a></td>
                            </c:if>
                            <c:if test="${listFood.ifComplete.equals(true)}">
                                <td class="table-customize2">已完成</td>
                            </c:if>
                            <td class="table-customize2">
                                <a id="lookinto" class="btn btn-primary" href="${pageContext.request.contextPath}/${mainWarehouse}/lookupsingleItem?location=${location}&id=${listFood.id}&category=${categoryFood}">
                                    調閱
                                </a>
                            </td>


                        </tr>
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
            <div style="overflow:scroll;height:50vh;">
                <table class="table table-hover table-borderless">
                    <thead class="table-customize">
                    <tr>

                        <%--                        <th></th>--%>
                        <%--                        <th>编号</th>--%>
                        <th>名字</th>
                        <th>品牌</th>
                        <th>数量</th>
                        <c:if test="${userLevel==1000}">
                            <th>單價</th>
                            <th>總價</th>
                        </c:if>
                        <th>详情</th>
                        <th>時間</th>
                        <th>動作</th>
                        <th>從</th>
                        <th>到</th>
                        <th>狀態</th>
                        <th>調閱</th>
                        <%--                    <th>操作</th>--%>

                    </tr>
                    </thead>

                    <tbody>
                    <c:set var="headCount" value="0"/>
                    <c:forEach var="listSmallItem" items="${listSmallItem}">
                        <c:set var="headCount" value="${headCount + 1}"/>
                        <c:if test="${listSmallItem.action.equals('input')}">
                            <c:set var="actionCN" value="入庫"/>
                        </c:if>
                        <c:if test="${listSmallItem.action.equals('output')}">
                            <c:set var="actionCN" value="出庫"/>
                        </c:if>
                        <c:if test="${listSmallItem.action.equals('send')}">
                            <c:set var="actionCN" value="轉移"/>
                        </c:if>
                        <c:if test="${listSmallItem.action.equals('edit')}">
                            <c:set var="actionCN" value="編輯"/>
                        </c:if>
                        <c:if test="${listSmallItem.action.equals('reject')}">
                            <c:set var="actionCN" value="沒過審核"/>
                        </c:if>
                        <c:if test="${listSmallItem.action.equals('delete')}">
                            <c:set var="actionCN" value="刪除"/>
                        </c:if>
                        <c:if test="${listSmallItem.action.equals('dump')}">
                            <c:set var="actionCN" value="報廢"/>
                        </c:if>
                        <c:if test="${listSmallItem.action.equals('newinput')}">
                            <c:set var="actionCN" value="新增"/>
                        </c:if>
                        <c:set var="from" value="${listSmallItem.from}"/>
                        <c:set var="to" value="${listSmallItem.to}"/>
                        <c:set var="locationFrom" value="${locationHashMap[from]}"/>
                        <c:set var="locationTo" value="${locationHashMap[to]}"/>
                        <tr>
                                <%--                            <td class="table-customize2">${headCount}</td>--%>
                                <%--                            <td class="table-customize2">${listSmallItem.id}</td>--%>
                            <th class="table-customize" scope="row">${headCount}. ${listSmallItem.itemName}</th>
                            <td class="table-customize2">${listSmallItem.brand}</td>
                            <td class="table-customize2">${listSmallItem.itemCount}</td>
                            <c:if test="${userLevel==1000}">
                                <td class="table-customize2">${listSmallItem.singlePrice}</td>
                                <td class="table-customize2">${listSmallItem.totalPrice}</td>
                            </c:if>
                            <td class="table-customize2">${listSmallItem.memo}</td>
                            <td class="table-customize2">${listSmallItem.time}</td>
                            <td class="table-customize2">${actionCN}</td>
                            <td class="table-customize2">${locationFrom}</td>
                            <td class="table-customize2">${locationTo}</td>
                            <c:if test="${listSmallItem.ifComplete.equals(false) && listSmallItem.ifConfirm.equals(false)}">
                                <td class="table-customize2" style="color: #404e53;font-weight:bold">審核中...</td>
                            </c:if>
                            <c:if test="${listSmallItem.ifComplete.equals(false) && listSmallItem.ifConfirm.equals(true)}">
                                <td class="table-customize2" style="color: #d0c6c2;font-weight:bold"><a href="${pageContext.request.contextPath}/receive/list?location=${location}">注意收貨</a></td>
                            </c:if>
                            <c:if test="${listSmallItem.ifComplete.equals(true)}">
                                <td class="table-customize2">已完成</td>
                            </c:if>
                            <td class="table-customize2">
                                <a id="lookinto" class="btn btn-primary" href="${pageContext.request.contextPath}/${mainWarehouse}/lookupsingleItem?location=${location}&id=${listSmallItem.id}&category=${categorySmallTool}">
                                    調閱
                                </a>
                            </td>
                        </tr>
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
            <div style="overflow:scroll;height:50vh;">
                <table class="table table-hover table-borderless">
                    <thead class="table-customize">
                    <tr>

                        <%--                        <th></th>--%>
                        <%--                        <th>编号</th>--%>
                        <th>名字</th>
                        <th>品牌</th>
                        <th>数量</th>
                        <c:if test="${userLevel==1000}">
                            <th>單價</th>
                            <th>總價</th>
                        </c:if>
                        <th>详情</th>
                        <th>時間</th>
                        <th>動作</th>
                        <th>從</th>
                        <th>到</th>
                        <th>狀態</th>
                        <th>調閱</th>
                        <%--                    <th>操作</th>--%>

                    </tr>
                    </thead>

                    <tbody>
                    <c:set var="headCount" value="0"/>
                    <c:forEach var="listCommercialthing" items="${listCommercialthing}">
                        <c:set var="headCount" value="${headCount + 1}"/>
                        <c:if test="${listCommercialthing.action.equals('input')}">
                            <c:set var="actionCN" value="入庫"/>
                        </c:if>
                        <c:if test="${listCommercialthing.action.equals('output')}">
                            <c:set var="actionCN" value="出庫"/>
                        </c:if>
                        <c:if test="${listCommercialthing.action.equals('send')}">
                            <c:set var="actionCN" value="轉移"/>
                        </c:if>
                        <c:if test="${listCommercialthing.action.equals('edit')}">
                            <c:set var="actionCN" value="編輯"/>
                        </c:if>
                        <c:if test="${listCommercialthing.action.equals('reject')}">
                            <c:set var="actionCN" value="沒過審核"/>
                        </c:if>
                        <c:if test="${listCommercialthing.action.equals('delete')}">
                            <c:set var="actionCN" value="刪除"/>
                        </c:if>
                        <c:if test="${listCommercialthing.action.equals('dump')}">
                            <c:set var="actionCN" value="報廢"/>
                        </c:if>
                        <c:if test="${listCommercialthing.action.equals('newinput')}">
                            <c:set var="actionCN" value="新增"/>
                        </c:if>
                        <c:set var="from" value="${listCommercialthing.from}"/>
                        <c:set var="to" value="${listCommercialthing.to}"/>
                        <c:set var="locationFrom" value="${locationHashMap[from]}"/>
                        <c:set var="locationTo" value="${locationHashMap[to]}"/>
                        <tr>
                                <%--                            <td class="table-customize2">${headCount}</td>--%>
                                <%--                            <td class="table-customize2">${listCommercialthing.id}</td>--%>
                            <th class="table-customize" scope="row">${headCount}. ${listCommercialthing.itemName}</th>
                            <td class="table-customize2">${listCommercialthing.brand}</td>
                            <td class="table-customize2">${listCommercialthing.itemCount}</td>
                            <c:if test="${userLevel==1000}">
                                <td class="table-customize2">${listCommercialthing.singlePrice}</td>
                                <td class="table-customize2">${listCommercialthing.totalPrice}</td>
                            </c:if>
                            <td class="table-customize2">${listCommercialthing.memo}</td>
                            <td class="table-customize2">${listCommercialthing.time}</td>
                            <td class="table-customize2">${actionCN}</td>
                            <td class="table-customize2">${locationFrom}</td>
                            <td class="table-customize2">${locationTo}</td>
                            <c:if test="${listCommercialthing.ifComplete.equals(false) && listCommercialthing.ifConfirm.equals(false)}">
                                <td class="table-customize2" style="color: #404e53;font-weight:bold">審核中...</td>
                            </c:if>
                            <c:if test="${listCommercialthing.ifComplete.equals(false) && listCommercialthing.ifConfirm.equals(true)}">
                                <td class="table-customize2" style="color: #d0c6c2;font-weight:bold"><a href="${pageContext.request.contextPath}/receive/list?location=${location}">注意收貨</a></td>
                            </c:if>
                            <c:if test="${listCommercialthing.ifComplete.equals(true)}">
                                <td class="table-customize2">已完成</td>
                            </c:if>
                            <td class="table-customize2">
                                <a id="lookinto" class="btn btn-primary" href="${pageContext.request.contextPath}/${mainWarehouse}/lookupsingleItem?location=${location}&id=${listCommercialthing.id}&category=${categoryCommercial}">
                                    調閱
                                </a>
                            </td>

                        </tr>
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
                <table class="table table-hover table-borderless">
                    <thead class="table-customize">
                    <tr>

                        <%--                        <th></th>--%>
                        <%--                        <th>编号</th>--%>
                        <th>名字</th>
                        <th>品牌</th>
                        <th>数量</th>
                        <c:if test="${userLevel==1000}">
                            <th>單價</th>
                            <th>總價</th>
                        </c:if>
                        <th>详情</th>
                        <th>時間</th>
                        <th>動作</th>
                        <th>從</th>
                        <th>到</th>
                        <th>狀態</th>
                        <th>調閱</th>
                        <%--                    <th>操作</th>--%>

                    </tr>
                    </thead>

                    <tbody>
                    <c:set var="headCount" value="0"/>
                    <c:forEach var="listOther" items="${listOther}">
                        <c:set var="headCount" value="${headCount + 1}"/>
                        <c:if test="${listOther.action.equals('input')}">
                            <c:set var="actionCN" value="入庫"/>
                        </c:if>
                        <c:if test="${listOther.action.equals('output')}">
                            <c:set var="actionCN" value="出庫"/>
                        </c:if>
                        <c:if test="${listOther.action.equals('send')}">
                            <c:set var="actionCN" value="轉移"/>
                        </c:if>
                        <c:if test="${listOther.action.equals('edit')}">
                            <c:set var="actionCN" value="編輯"/>
                        </c:if>
                        <c:if test="${listOther.action.equals('reject')}">
                            <c:set var="actionCN" value="沒過審核"/>
                        </c:if>
                        <c:if test="${listOther.action.equals('delete')}">
                            <c:set var="actionCN" value="刪除"/>
                        </c:if>
                        <c:if test="${listOther.action.equals('dump')}">
                            <c:set var="actionCN" value="報廢"/>
                        </c:if>
                        <c:if test="${listOther.action.equals('newinput')}">
                            <c:set var="actionCN" value="新增"/>
                        </c:if>
                        <c:set var="from" value="${listOther.from}"/>
                        <c:set var="to" value="${listOther.to}"/>
                        <c:set var="locationFrom" value="${locationHashMap[from]}"/>
                        <c:set var="locationTo" value="${locationHashMap[to]}"/>
                        <tr>
                                <%--                            <td class="table-customize2">${headCount}</td>--%>
                                <%--                            <td class="table-customize2">${listOther.id}</td>--%>
                            <th class="table-customize" scope="row">${headCount}. ${listOther.itemName}</th>
                            <td class="table-customize2">${listOther.brand}</td>
                            <td class="table-customize2">${listOther.itemCount}</td>
                            <c:if test="${userLevel==1000}">
                                <td class="table-customize2">${listOther.singlePrice}</td>
                                <td class="table-customize2">${listOther.totalPrice}</td>
                            </c:if>
                            <td class="table-customize2">${listOther.memo}</td>
                            <td class="table-customize2">${listOther.time}</td>
                            <td class="table-customize2">${actionCN}</td>
                            <td class="table-customize2">${locationFrom}</td>
                            <td class="table-customize2">${locationTo}</td>
                            <c:if test="${listOther.ifComplete.equals(false) && listOther.ifConfirm.equals(false)}">
                                <td class="table-customize2" style="color: #404e53;font-weight:bold">審核中...</td>
                            </c:if>
                            <c:if test="${listOther.ifComplete.equals(false) && listOther.ifConfirm.equals(true)}">
                                <td class="table-customize2" style="color: #d0c6c2;font-weight:bold"><a href="${pageContext.request.contextPath}/receive/list?location=${location}">注意收貨</a></td>
                            </c:if>
                            <c:if test="${listOther.ifComplete.equals(true)}">
                                <td class="table-customize2">已完成</td>
                            </c:if>
                            <td class="table-customize2">
                                <a id="lookinto" class="btn btn-primary" href="${pageContext.request.contextPath}/${mainWarehouse}/lookupsingleItem?location=${location}&id=${listOther.id}&category=${categoryOther}">
                                    調閱
                                </a>
                            </td>

                        </tr>
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


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
        crossorigin="anonymous"></script>
</body>
</html>
