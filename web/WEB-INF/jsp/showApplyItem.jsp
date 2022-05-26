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
    <title>物料申請清單</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="theme-color" content="#f8f9fa">
    <meta name="apple-mobile-web-app-title" content="vinvinERP">
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"--%>
<%--          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">--%>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
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
<jsp:include page="navwithSearch.jsp"/>

<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
<%--            <br><br><br>--%>
<%--            <a class="btn btn-success" role="button" href="${pageContext.request.contextPath}/invoice/toAdd?location=${location}">上傳水果運單</a>--%>
        </div>

        <div class="col-md-12 column">
            <br><br><br>
            <div class="row">


            </div>

            <div role="region" style="overflow:scroll;height:70vh;" class="rowheaders">
                <table class="table table-borderless table-hover">
                    <thead class="table-customize">
                    <tr>
                        <th>物料名稱</th>
                        <th>數量</th>
                        <th>申請人</th>
                        <th>申請日期</th>
                        <th>區代審核</th>
                        <th>單價</th>
                        <th>總價</th>
                        <th>採購日期</th>
                        <th>採購處理狀態</th>
                        <th>運單號</th>
                        <th></th>
                        <th></th>
                        <c:if test="${user.level == 500 || user.level == 501}">
                            <th>審核</th>
                            <th>審核</th>
                        </c:if>
                        <c:if test="${user.level == 1000}">
                            <th></th>
                        </c:if>



                    </tr>
                    </thead>

                    <tbody >
                    <c:set var="headCount" value="0"/>
                    <c:forEach var="applyItem" items="${applyItemList}">
                        <c:set var="headCount" value="${headCount + 1}"/>
                        <tr>
                            <th class="table-customize" scope="row">${headCount}. ${applyItem.itemName}</th>
                            <td class="table-customize2">${applyItem.count}</td>
                            <td class="table-customize2">${applyItem.applyName}</td>
                            <td class="table-customize2">${applyItem.applyTime}</td>
                            <c:if test="${!applyItem.confirmResult.equals('')}">
                                <td class="table-customize2">${confirmResultMap[applyItem.confirmResult]}</td>
                            </c:if>
                            <c:if test="${applyItem.confirmResult.equals('')}">
                                <td class="table-customize2">待審核</td>
                            </c:if>
                            <td class="table-customize2">${applyItem.singlePrice}</td>
                            <td class="table-customize2">${applyItem.totalPrice}</td>
                            <td class="table-customize2">${applyItem.purchaseTime}</td>

                            <c:if test="${applyItem.confirm == true}">
                                <td class="table-customize2">${statusMap[applyItem.status]}</td>
                            </c:if>
                            <c:if test="${applyItem.confirm == false}">
                                <td class="table-customize2"></td>
                            </c:if>
                            <td class="table-customize2">${applyItem.shipID}</td>
                            <td class="table-customize2">
                                <c:if test="${applyItem.confirm == true}">
                                    <a class="btn btn-success disabled" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/apply/toeditApplyItem?logID=${applyItem.logID}&location=${applyItem.location}" style="padding: 1px !important;" >編輯</a>
                                </c:if>
                                <c:if test="${applyItem.confirm == false}">
                                    <a class="btn btn-success active" role="button" aria-pressed="true" href="${pageContext.request.contextPath}/apply/toeditApplyItem?logID=${applyItem.logID}&location=${applyItem.location}" style="padding: 1px !important;" >編輯</a>
                                </c:if>
                            </td>
                            <td class="table-customize2">
                                <c:if test="${applyItem.confirm == true}">
                                    <a class="btn btn-danger disabled" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/apply/deleteApplyItem?logID=${applyItem.logID}&location=${applyItem.location}" style="padding: 1px !important;" >刪除</a>
                                </c:if>
                                <c:if test="${applyItem.confirm == false}">
                                    <a class="btn btn-danger active" role="button" aria-pressed="true" href="${pageContext.request.contextPath}/apply/deleteApplyItem?logID=${applyItem.logID}&location=${applyItem.location}" style="padding: 1px !important;" >刪除</a>
                                </c:if>
                            </td>
                            <c:if test="${user.level == 500 || user.level == 501}">
                                <td class="table-customize2">
                                    <c:if test="${applyItem.confirm == true}">
                                        <a class="btn btn-primary disabled" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/apply/confirmApplyItem?logID=${applyItem.logID}&location=${applyItem.location}&confirm=confirmed" style="padding: 1px !important;" >通過</a>
                                    </c:if>
                                    <c:if test="${applyItem.confirm == false}">
                                        <a class="btn btn-primary active" role="button" aria-pressed="true" href="${pageContext.request.contextPath}/apply/confirmApplyItem?logID=${applyItem.logID}&location=${applyItem.location}&confirm=confirmed" style="padding: 1px !important;" >通過</a>
                                    </c:if>
                                        <%--                                <a class="btn btn-primary" href="${pageContext.request.contextPath}/apply/confirmApplyItem?logID=${applyItem.logID}&location=${applyItem.location}&confirm=confirmed" style="padding: 1px !important;">通過</a>--%>
                                </td>
                                <td class="table-customize2">
                                    <c:if test="${applyItem.confirm == true}">
                                        <a class="btn btn-warning disabled" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/apply/confirmApplyItem?logID=${applyItem.logID}&location=${applyItem.location}&confirm=refuse" style="padding: 1px !important;" >不通過</a>
                                    </c:if>
                                    <c:if test="${applyItem.confirm == false}">
                                        <a class="btn btn-warning active" role="button" aria-pressed="true" href="${pageContext.request.contextPath}/apply/confirmApplyItem?logID=${applyItem.logID}&location=${applyItem.location}&confirm=refuse" style="padding: 1px !important;" >不通過</a>
                                    </c:if>
                                        <%--                                <a class="btn btn-warning" href="${pageContext.request.contextPath}/apply/confirmApplyItem?logID=${applyItem.logID}&location=${applyItem.location}&confirm=refuse" style="padding: 1px !important;">不通過</a>--%>
                                </td>
                            </c:if>
                            <c:if test="${user.level == 1000}">
                                <td class="table-customize2">
                                    <c:if test="${applyItem.confirm == false || applyItem.confirmResult.equals('refuse') || applyItem.status.equals('ARRIVE')}">
                                        <a class="btn btn-info disabled" role="button" aria-disabled="true" href="#" style="padding: 1px !important;" >採購</a>
                                    </c:if>
                                    <c:if test="${applyItem.confirm == true && applyItem.confirmResult.equals('confirmed') && !applyItem.status.equals('ARRIVE')}">
                                        <a class="btn btn-info active" role="button" aria-pressed="true" href="${pageContext.request.contextPath}/apply/toBuyApplyItem?logID=${applyItem.logID}&location=${applyItem.location}" style="padding: 1px !important;" >採購</a>
                                    </c:if>
                                        <%--                                <a class="btn btn-warning" href="${pageContext.request.contextPath}/apply/confirmApplyItem?logID=${applyItem.logID}&location=${applyItem.location}&confirm=refuse" style="padding: 1px !important;">不通過</a>--%>
                                </td>
                            </c:if>




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

<script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"--%>
<%--        integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"--%>
<%--        crossorigin="anonymous"></script>--%>
</body>
</html>
