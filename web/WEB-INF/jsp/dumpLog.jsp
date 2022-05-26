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
            <br><br><br>
            <div class="row">
                <div class="col-md-4 column">

                </div>
                <div class="col-md-4 column">
                    <div style="width: 149px;margin: 0 auto;">
                        <div class="btn-group">
                            <a href="${pageContext.request.contextPath}/dump/${showdumplog}&function=notpass" class="btn btn-danger" aria-current="page">未審核</a>
                            <a href="${pageContext.request.contextPath}/dump/${showdumplog}&function=passed" class="btn btn-primary">已審核</a>
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

            <div role="region" style="overflow:scroll;height:50vh;" class="rowheaders">
                <table class="table table-borderless table-hover">
                    <thead class="table-customize">
                    <tr>
                        <%--                        <th hidden></th>--%>
                        <%--                        <th hidden>编号</th>--%>
                        <th>名稱</th>
                        <th>品牌</th>
                        <th>数量</th>
                        <th>過期日</th>
                        <th>過多長</th>
                        <th>原因</th>
                        <th>報廢日</th>
                        <th>報廢方式</th>
                        <th>详情</th>
                        <th></th>
                        <th></th>
                        <th></th>

                    </tr>
                    </thead>

                    <tbody >
                    <c:set var="headCount" value="0"/>
                    <c:forEach var="dumpListtool" items="${dumpListtool}">
                        <c:set var="headCount" value="${headCount + 1}"/>
                        <c:set var="id" value="${dumpListtool.id}"/>

                        <tr>
                                <%--                        <td class="table-customize2" hidden>${headCount}</td>--%>
                                <%--                        <td class="table-customize2" hidden>${dumpListtool.id}</td>--%>
                            <th class="table-customize" scope="row">${headCount}. ${dumpListtool.itemName}</th>
                            <td class="table-customize2">${dumpListtool.brand}</td>
                            <td class="table-customize2">${dumpListtool.itemCount}</td>
                            <td class="table-customize2">${dumpListtool.expiredDate}</td>
                            <td class="table-customize2">${dumpListtool.howLong}</td>
                            <td class="table-customize2">${dumpListtool.reason}</td>
                            <td class="table-customize2">${dumpListtool.dumptime}</td>
                            <td class="table-customize2">${dumpListtool.action}</td>
                            <td class="table-customize2">${dumpListtool.memo}</td>
                            <c:if test="${function.equals('notpass') && ifAccess}">
                                <td class="table-customize2">
                                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/dump/pass?logid=${dumpListtool.logid}&location=${dumpListtool.location}&id=${dumpListtool.id}&category=${dumpListtool.category}" style="padding: 1px !important;">通過</a>
                                </td>
                                <td class="table-customize2">
                                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/dump/toeditdumplist?logid=${dumpListtool.logid}" style="padding: 1px !important;">編輯</a>
                                </td>
                                <td class="table-customize2">
                                    <a class="btn btn-danger" href="${pageContext.request.contextPath}/dump/reject?logid=${dumpListtool.logid}&location=${dumpListtool.location}" style="padding: 1px !important;">拒絕</a>
                                </td>
                            </c:if>
                            <c:if test="${function.equals('notpass') && !ifAccess}">
                                <td class="table-customize2">
                                    <a class="btn btn-secondary disabled" tabindex="-1" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/dump/pass?logid=${dumpListtool.logid}&location=${dumpListtool.location}&id=${dumpListtool.id}&category=${dumpListtool.category}" style="padding: 1px !important;">通過</a>
                                </td>
                                <td class="table-customize2">
                                    <a class="btn btn-secondary disabled" tabindex="-1" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/dump/toeditdumplist?logid=${dumpListtool.logid}" style="padding: 1px !important;">編輯</a>
                                </td>
                                <td class="table-customize2">
                                    <a class="btn btn-secondary disabled" tabindex="-1" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/dump/reject?logid=${dumpListtool.logid}&location=${dumpListtool.location}" style="padding: 1px !important;">拒絕</a>
                                </td>
                            </c:if>
                            <c:if test="${function.equals('passed')}">
                                <c:if test="${dumpListtool.status.equals('reject')}">
                                    <td class="table-customize2" style="color: red">已拒絕</td>
                                </c:if>
                                <c:if test="${dumpListtool.status.equals('pass')}">
                                    <td class="table-customize2">已通過</td>
                                </c:if>

                                <td class="table-customize2">
                                    <a class="btn btn-secondary disabled" tabindex="-1" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/dump/toeditdumplist?logid=${dumpListtool.logid}" style="padding: 1px !important;" >編輯</a>
                                </td>
                                <td class="table-customize2">
                                    <a class="btn btn-secondary disabled" tabindex="-1" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/dump/reject?logid=${dumpListtool.logid}&location=${dumpListtool.location}" style="padding: 1px !important;">拒絕</a>
                                </td>
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
                    <h4>材料</h4>
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
                        <th>過期日</th>
                        <th>過多長</th>
                        <th>原因</th>
                        <th>報廢日</th>
                        <th>報廢方式</th>
                        <th>详情</th>
                        <th></th>
                        <th></th>
                        <th></th>

                    </tr>
                    </thead>

                    <tbody >
                    <c:set var="headCount" value="0"/>
                    <c:forEach var="dumpListfood" items="${dumpListfood}">
                        <c:set var="headCount" value="${headCount + 1}"/>
                        <c:set var="id" value="${dumpListfood.id}"/>

                        <tr>
                                <%--                        <td class="table-customize2" hidden>${headCount}</td>--%>
                                <%--                        <td class="table-customize2" hidden>${dumpListfood.id}</td>--%>
                            <th class="table-customize" scope="row">${headCount}. ${dumpListfood.itemName}</th>
                            <td class="table-customize2">${dumpListfood.brand}</td>
                            <td class="table-customize2">${dumpListfood.itemCount}</td>
                            <td class="table-customize2">${dumpListfood.expiredDate}</td>
                            <td class="table-customize2">${dumpListfood.howLong}</td>
                            <td class="table-customize2">${dumpListfood.reason}</td>
                            <td class="table-customize2">${dumpListfood.dumptime}</td>
                            <td class="table-customize2">${dumpListfood.action}</td>
                            <td class="table-customize2">${dumpListfood.memo}</td>
                            <c:if test="${function.equals('notpass') && ifAccess}">
                                <td class="table-customize2">
                                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/dump/pass?logid=${dumpListfood.logid}&location=${dumpListfood.location}&id=${dumpListfood.id}&category=${dumpListfood.category}" style="padding: 1px !important;">通過</a>
                                </td>
                                <td class="table-customize2">
                                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/dump/toeditdumplist?logid=${dumpListfood.logid}" style="padding: 1px !important;">編輯</a>
                                </td>
                                <td class="table-customize2">
                                    <a class="btn btn-danger" href="${pageContext.request.contextPath}/dump/reject?logid=${dumpListfood.logid}&location=${dumpListfood.location}" style="padding: 1px !important;">拒絕</a>
                                </td>
                            </c:if>
                            <c:if test="${function.equals('notpass') && !ifAccess}">
                                <td class="table-customize2">
                                    <a class="btn btn-secondary disabled" tabindex="-1" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/dump/pass?logid=${dumpListfood.logid}&location=${dumpListfood.location}&id=${dumpListfood.id}&category=${dumpListfood.category}" style="padding: 1px !important;">通過</a>
                                </td>
                                <td class="table-customize2">
                                    <a class="btn btn-secondary disabled" tabindex="-1" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/dump/toeditdumplist?logid=${dumpListfood.logid}" style="padding: 1px !important;">編輯</a>
                                </td>
                                <td class="table-customize2">
                                    <a class="btn btn-secondary disabled" tabindex="-1" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/dump/reject?logid=${dumpListfood.logid}&location=${dumpListfood.location}" style="padding: 1px !important;">拒絕</a>
                                </td>
                            </c:if>

                            <c:if test="${function.equals('passed')}">
                                <c:if test="${dumpListfood.status.equals('reject')}">
                                    <td class="table-customize2" style="color: red">已拒絕</td>
                                </c:if>
                                <c:if test="${dumpListfood.status.equals('pass')}">
                                    <td class="table-customize2">已通過</td>
                                </c:if>

                                <td class="table-customize2">
                                    <a class="btn btn-secondary disabled" tabindex="-1" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/dump/toeditdumplist?logid=${dumpListfood.logid}" style="padding: 1px !important;" >編輯</a>
                                </td>
                                <td class="table-customize2">
                                    <a class="btn btn-secondary disabled" tabindex="-1" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/dump/reject?logid=${dumpListfood.logid}&location=${dumpListfood.location}" style="padding: 1px !important;">拒絕</a>
                                </td>
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
                    <h4>小器具</h4>
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
                        <th>過期日</th>
                        <th>過多長</th>
                        <th>原因</th>
                        <th>報廢日</th>
                        <th>報廢方式</th>
                        <th>详情</th>
                        <th></th>
                        <th></th>
                        <th></th>

                    </tr>
                    </thead>

                    <tbody >
                    <c:set var="headCount" value="0"/>
                    <c:forEach var="dumpListsmalltool" items="${dumpListsmalltool}">
                        <c:set var="headCount" value="${headCount + 1}"/>
                        <c:set var="id" value="${dumpListsmalltool.id}"/>

                        <tr>
                                <%--                        <td class="table-customize2" hidden>${headCount}</td>--%>
                                <%--                        <td class="table-customize2" hidden>${dumpListsmalltool.id}</td>--%>
                            <th class="table-customize" scope="row">${headCount}. ${dumpListsmalltool.itemName}</th>
                            <td class="table-customize2">${dumpListsmalltool.brand}</td>
                            <td class="table-customize2">${dumpListsmalltool.itemCount}</td>
                            <td class="table-customize2">${dumpListsmalltool.expiredDate}</td>
                            <td class="table-customize2">${dumpListsmalltool.howLong}</td>
                            <td class="table-customize2">${dumpListsmalltool.reason}</td>
                            <td class="table-customize2">${dumpListsmalltool.dumptime}</td>
                            <td class="table-customize2">${dumpListsmalltool.action}</td>
                            <td class="table-customize2">${dumpListsmalltool.memo}</td>
                            <c:if test="${function.equals('notpass') && ifAccess}">
                                <td class="table-customize2">
                                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/dump/pass?logid=${dumpListsmalltool.logid}&location=${dumpListsmalltool.location}&id=${dumpListsmalltool.id}&category=${dumpListsmalltool.category}" style="padding: 1px !important;">通過</a>
                                </td>
                                <td class="table-customize2">
                                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/dump/toeditdumplist?logid=${dumpListsmalltool.logid}" style="padding: 1px !important;">編輯</a>
                                </td>
                                <td class="table-customize2">
                                    <a class="btn btn-danger" href="${pageContext.request.contextPath}/dump/reject?logid=${dumpListsmalltool.logid}&location=${dumpListsmalltool.location}" style="padding: 1px !important;">拒絕</a>
                                </td>
                            </c:if>
                            <c:if test="${function.equals('notpass') && !ifAccess}">
                                <td class="table-customize2">
                                    <a class="btn btn-secondary disabled" tabindex="-1" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/dump/pass?logid=${dumpListsmalltool.logid}&location=${dumpListsmalltool.location}&id=${dumpListsmalltool.id}&category=${dumpListsmalltool.category}" style="padding: 1px !important;">通過</a>
                                </td>
                                <td class="table-customize2">
                                    <a class="btn btn-secondary disabled" tabindex="-1" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/dump/toeditdumplist?logid=${dumpListsmalltool.logid}" style="padding: 1px !important;">編輯</a>
                                </td>
                                <td class="table-customize2">
                                    <a class="btn btn-secondary disabled" tabindex="-1" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/dump/reject?logid=${dumpListsmalltool.logid}&location=${dumpListsmalltool.location}" style="padding: 1px !important;">拒絕</a>
                                </td>
                            </c:if>
                            <c:if test="${function.equals('passed')}">
                                <c:if test="${dumpListsmalltool.status.equals('reject')}">
                                    <td class="table-customize2" style="color: red">已拒絕</td>
                                </c:if>
                                <c:if test="${dumpListsmalltool.status.equals('pass')}">
                                    <td class="table-customize2">已通過</td>
                                </c:if>

                                <td class="table-customize2">
                                    <a class="btn btn-secondary disabled" tabindex="-1" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/dump/toeditdumplist?logid=${dumpListsmalltool.logid}" style="padding: 1px !important;" >編輯</a>
                                </td>
                                <td class="table-customize2">
                                    <a class="btn btn-secondary disabled" tabindex="-1" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/dump/reject?logid=${dumpListsmalltool.logid}&location=${dumpListsmalltool.location}" style="padding: 1px !important;">拒絕</a>
                                </td>
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
                    <h4>宣传物料</h4>
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
                        <th>過期日</th>
                        <th>過多長</th>
                        <th>原因</th>
                        <th>報廢日</th>
                        <th>報廢方式</th>
                        <th>详情</th>
                        <th></th>
                        <th></th>
                        <th></th>

                    </tr>
                    </thead>

                    <tbody >
                    <c:set var="headCount" value="0"/>
                    <c:forEach var="dumpListcommercial" items="${dumpListcommercial}">
                        <c:set var="headCount" value="${headCount + 1}"/>
                        <c:set var="id" value="${dumpListcommercial.id}"/>

                        <tr>
                                <%--                        <td class="table-customize2" hidden>${headCount}</td>--%>
                                <%--                        <td class="table-customize2" hidden>${dumpListcommercial.id}</td>--%>
                            <th class="table-customize" scope="row">${headCount}. ${dumpListcommercial.itemName}</th>
                            <td class="table-customize2">${dumpListcommercial.brand}</td>
                            <td class="table-customize2">${dumpListcommercial.itemCount}</td>
                            <td class="table-customize2">${dumpListcommercial.expiredDate}</td>
                            <td class="table-customize2">${dumpListcommercial.howLong}</td>
                            <td class="table-customize2">${dumpListcommercial.reason}</td>
                            <td class="table-customize2">${dumpListcommercial.dumptime}</td>
                            <td class="table-customize2">${dumpListcommercial.action}</td>
                            <td class="table-customize2">${dumpListcommercial.memo}</td>
                            <c:if test="${function.equals('notpass') && ifAccess}">
                                <td class="table-customize2">
                                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/dump/pass?logid=${dumpListcommercial.logid}&location=${dumpListcommercial.location}&id=${dumpListcommercial.id}&category=${dumpListcommercial.category}" style="padding: 1px !important;">通過</a>
                                </td>
                                <td class="table-customize2">
                                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/dump/toeditdumplist?logid=${dumpListcommercial.logid}" style="padding: 1px !important;">編輯</a>
                                </td>
                                <td class="table-customize2">
                                    <a class="btn btn-danger" href="${pageContext.request.contextPath}/dump/reject?logid=${dumpListcommercial.logid}&location=${dumpListcommercial.location}" style="padding: 1px !important;">拒絕</a>
                                </td>
                            </c:if>
                            <c:if test="${function.equals('notpass') && !ifAccess}">
                                <td class="table-customize2">
                                    <a class="btn btn-secondary disabled" tabindex="-1" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/dump/pass?logid=${dumpListcommercial.logid}&location=${dumpListcommercial.location}&id=${dumpListcommercial.id}&category=${dumpListcommercial.category}" style="padding: 1px !important;">通過</a>
                                </td>
                                <td class="table-customize2">
                                    <a class="btn btn-secondary disabled" tabindex="-1" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/dump/toeditdumplist?logid=${dumpListcommercial.logid}" style="padding: 1px !important;">編輯</a>
                                </td>
                                <td class="table-customize2">
                                    <a class="btn btn-secondary disabled" tabindex="-1" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/dump/reject?logid=${dumpListcommercial.logid}&location=${dumpListcommercial.location}" style="padding: 1px !important;">拒絕</a>
                                </td>
                            </c:if>
                            <c:if test="${function.equals('passed')}">
                                <c:if test="${dumpListcommercial.status.equals('reject')}">
                                    <td class="table-customize2" style="color: red">已拒絕</td>
                                </c:if>
                                <c:if test="${dumpListcommercial.status.equals('pass')}">
                                    <td class="table-customize2">已通過</td>
                                </c:if>

                                <td class="table-customize2">
                                    <a class="btn btn-secondary disabled" tabindex="-1" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/dump/toeditdumplist?logid=${dumpListcommercial.logid}" style="padding: 1px !important;" >編輯</a>
                                </td>
                                <td class="table-customize2">
                                    <a class="btn btn-secondary disabled" tabindex="-1" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/dump/reject?logid=${dumpListcommercial.logid}&location=${dumpListcommercial.location}" style="padding: 1px !important;">拒絕</a>
                                </td>
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
                    <h4>其他</h4>
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
                        <th>過期日</th>
                        <th>過多長</th>
                        <th>原因</th>
                        <th>報廢日</th>
                        <th>報廢方式</th>
                        <th>详情</th>
                        <th></th>
                        <th></th>
                        <th></th>

                    </tr>
                    </thead>

                    <tbody >
                    <c:set var="headCount" value="0"/>
                    <c:forEach var="dumpListother" items="${dumpListother}">
                        <c:set var="headCount" value="${headCount + 1}"/>
                        <c:set var="id" value="${dumpListother.id}"/>

                        <tr>
                                <%--                        <td class="table-customize2" hidden>${headCount}</td>--%>
                                <%--                        <td class="table-customize2" hidden>${dumpListother.id}</td>--%>
                            <th class="table-customize" scope="row">${headCount}. ${dumpListother.itemName}</th>
                            <td class="table-customize2">${dumpListother.brand}</td>
                            <td class="table-customize2">${dumpListother.itemCount}</td>
                            <td class="table-customize2">${dumpListother.expiredDate}</td>
                            <td class="table-customize2">${dumpListother.howLong}</td>
                            <td class="table-customize2">${dumpListother.reason}</td>
                            <td class="table-customize2">${dumpListother.dumptime}</td>
                            <td class="table-customize2">${dumpListother.action}</td>
                            <td class="table-customize2">${dumpListother.memo}</td>
                            <c:if test="${function.equals('notpass') && ifAccess}">
                                <td class="table-customize2">
                                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/dump/pass?logid=${dumpListother.logid}&location=${dumpListother.location}&id=${dumpListother.id}&category=${dumpListother.category}" style="padding: 1px !important;">通過</a>
                                </td>
                                <td class="table-customize2">
                                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/dump/toeditdumplist?logid=${dumpListother.logid}" style="padding: 1px !important;">編輯</a>
                                </td>
                                <td class="table-customize2">
                                    <a class="btn btn-danger" href="${pageContext.request.contextPath}/dump/reject?logid=${dumpListother.logid}&location=${dumpListother.location}" style="padding: 1px !important;">拒絕</a>
                                </td>
                            </c:if>
                            <c:if test="${function.equals('notpass') && !ifAccess}">
                                <td class="table-customize2">
                                    <a class="btn btn-secondary disabled" tabindex="-1" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/dump/pass?logid=${dumpListother.logid}&location=${dumpListother.location}&id=${dumpListother.id}&category=${dumpListother.category}" style="padding: 1px !important;">通過</a>
                                </td>
                                <td class="table-customize2">
                                    <a class="btn btn-secondary disabled" tabindex="-1" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/dump/toeditdumplist?logid=${dumpListother.logid}" style="padding: 1px !important;">編輯</a>
                                </td>
                                <td class="table-customize2">
                                    <a class="btn btn-secondary disabled" tabindex="-1" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/dump/reject?logid=${dumpListother.logid}&location=${dumpListother.location}" style="padding: 1px !important;">拒絕</a>
                                </td>
                            </c:if>
                            <c:if test="${function.equals('passed')}">
                                <c:if test="${dumpListother.status.equals('reject')}">
                                    <td class="table-customize2" style="color: red">已拒絕</td>
                                </c:if>
                                <c:if test="${dumpListother.status.equals('pass')}">
                                    <td class="table-customize2">已通過</td>
                                </c:if>
                                <td class="table-customize2">
                                    <a class="btn btn-secondary disabled" tabindex="-1" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/dump/toeditdumplist?logid=${dumpListother.logid}" style="padding: 1px !important;" >編輯</a>
                                </td>
                                <td class="table-customize2">
                                    <a class="btn btn-secondary disabled" tabindex="-1" role="button" aria-disabled="true" href="${pageContext.request.contextPath}/dump/reject?logid=${dumpListother.logid}&location=${dumpListother.location}" style="padding: 1px !important;">拒絕</a>
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
<script>
    // $(document).ready(function (){
    //     var alert_sentence="庫存警告";
    //     alert(alert_sentence);
    // });
</script>

<script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"--%>
<%--        integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"--%>
<%--        crossorigin="anonymous"></script>--%>
</body>
</html>
