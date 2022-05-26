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
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"--%>
<%--          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">--%>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
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
<jsp:include page="navwithSearch.jsp"/>

<div class="container-fluid">

    <div class="row clearfix">

        <div class="col-md-12 column">
            <br><br><br>
            <div class="row">
                <div class="col-md-4 column">
                    <h4>${location}</h4>
                </div>
            </div>

            <div role="region" style="overflow:scroll;height:55vh;" class="rowheaders">
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

                        <%--                    <th>操作</th>--%>

                    </tr>
                    </thead>

                    <tbody>
                    <c:set var="headCount" value="0"/>
                    <c:forEach var="vinLog" items="${vinLogList}">
                        <c:set var="headCount" value="${headCount + 1}"/>

                        <c:if test="${vinLog.action.equals('input')}">
                            <c:set var="actionCN" value="入庫"/>
                        </c:if>
                        <c:if test="${vinLog.action.equals('output')}">
                            <c:set var="actionCN" value="出庫"/>
                        </c:if>
                        <c:if test="${vinLog.action.equals('send')}">
                            <c:set var="actionCN" value="轉移"/>
                        </c:if>
                        <c:if test="${vinLog.action.equals('edit')}">
                            <c:set var="actionCN" value="編輯"/>
                        </c:if>
                        <c:if test="${vinLog.action.equals('newinput')}">
                            <c:set var="actionCN" value="新增"/>
                        </c:if>
                        <c:if test="${vinLog.action.equals('dump')}">
                            <c:set var="actionCN" value="報廢"/>
                        </c:if>
                        <c:set var="from" value="${vinLog.from}"/>
                        <c:set var="to" value="${vinLog.to}"/>
                        <c:set var="locationFrom" value="${locationHashMap[from]}"/>
                        <c:set var="locationTo" value="${locationHashMap[to]}"/>



                        <tr>

                                <%--                            <td class="table-customize2">${headCount}</td>--%>
                                <%--                            <td class="table-customize2">${vinLog.id}</td>--%>
                            <th class="table-customize" scope="row">${headCount}. ${vinLog.itemName}</th>
                            <td class="table-customize2">${vinLog.brand}</td>
                            <td class="table-customize2">${vinLog.itemCount}</td>
                            <c:if test="${userLevel==1000}">
                                <td class="table-customize2">${vinLog.singlePrice}</td>
                                <td class="table-customize2">${vinLog.totalPrice}</td>
                            </c:if>
                            <td class="table-customize2">${vinLog.memo}</td>
                            <td class="table-customize2">${vinLog.time}</td>
                            <td class="table-customize2">${actionCN}</td>
                            <td class="table-customize2">${locationFrom}</td>
                            <td class="table-customize2">${locationTo}</td>
                            <c:if test="${vinLog.ifComplete.equals(false) && vinLog.ifConfirm.equals(false)}">
                                <td class="table-customize2" style="color: #404e53;font-weight:bold">審核中...</td>
                            </c:if>
                            <c:if test="${vinLog.ifComplete.equals(false) && vinLog.ifConfirm.equals(true)}">
                                <td class="table-customize2" style="color: #d0c6c2;font-weight:bold"><a href="${pageContext.request.contextPath}/receive/list?location=${logLocation}">注意收貨</a></td>
                            </c:if>
                            <c:if test="${vinLog.ifComplete.equals(true)}">
                                <td class="table-customize2">已完成</td>
                            </c:if>



                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>




        </div>
        <div class="col-md-12 column">
            <br><br><br>
            <div class="row">
                <div class="col-md-4 column">
                    <h4>目前狀態</h4>
                </div>
            </div>

            <div role="region" style="overflow:scroll;" class="rowheaders">
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
<%--                        <th>操作</th>--%>

                    </tr>
                    </thead>

                    <tbody>
                        <tr>
                            <%--                        <td class="table-customize2" hidden>${headCount}</td>--%>
                            <%--                        <td class="table-customize2" hidden>${vinItem.id}</td>--%>
                            <th class="table-customize" scope="row">${vinItem.itemName}</th>
                            <td class="table-customize2">${vinItem.brand}</td>
                            <td class="table-customize2">${vinItem.itemCount}</td>
                            <c:if test="${userLevel==1000}">
                                <td class="table-customize2">${vinItem.singlePrice}</td>
                                <td class="table-customize2">${vinItem.totalPrice}</td>
                            </c:if>

                            <td class="table-customize2">${vinItem.memo}</td>
<%--                            <td class="table-customize2">--%>
<%--                                <div class="dropdown">--%>
<%--                                    <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButtontool" data-bs-toggle="dropdown" aria-expanded="false" style="padding-top: 0px !important;padding-bottom: 0px !important;padding-right: 1px;padding-left: 1px;">--%>
<%--                                        ...--%>
<%--                                    </button>--%>
<%--                                    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButtontool">--%>
<%--                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toUpdate?id=${vinItem.id}&location=${mainWarehouseEN}&category=tool">修改</a></li>--%>
<%--                                        <c:if test="${userLevel==1000}">--%>
<%--                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toInput?id=${vinItem.id}&location=${mainWarehouseEN}&category=tool">入庫</a></li>--%>
<%--                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/delete/${vinItem.id}/${mainWarehouseEN}/tool">刪除</a></li>--%>
<%--                                        </c:if>--%>
<%--                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toOutput?id=${vinItem.id}&location=${mainWarehouseEN}&category=tool">出庫</a></li>--%>
<%--                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${mainWarehouse}/toSend?id=${vinItem.id}&location=${mainWarehouseEN}&category=tool">轉移</a></li>--%>
<%--                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/dump/todumpItem?id=${vinItem.id}&location=${mainWarehouseEN}&category=tool">報廢</a></li>--%>
<%--    --%>
<%--                                    </ul>--%>
<%--                                </div>--%>
<%--                            </td>--%>

                        </tr>
                    </tbody>
                </table>
            </div>




        </div>
        <div class="col-md-12 column">
            <br><br>
        </div>
    </div>
</div>

<script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"--%>
<%--        integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"--%>
<%--        crossorigin="anonymous"></script>--%>
</body>
</html>
