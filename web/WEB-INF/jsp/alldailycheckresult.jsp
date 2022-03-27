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
</head>
<body>
<style>
    .accordion-button {
        background-color: rgb(231, 241, 255);
        color: rgb(12, 99, 228);
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
<jsp:include page="navwithSearch.jsp"/>


<div class="container-fluid">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="row">
                <div class="col-md-2 column">

                </div>
                <div class="col-md-8 column">
                    <br><br>
                    <div class="accordion" id="accordionExample">
                        <div class="accordion-item">
                            <h2 class="accordion-header" id="headingOne">
                                <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                    導出Excel
                                </button>
                            </h2>
                            <div id="collapseOne" class="accordion-collapse collapse" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                                <div class="accordion-body">
                                    <form action="${pageContext.request.contextPath}/${mainWarehouse}/downloadExcel?category=tool" method="post" class="row g-3" >
                                        <%--                        <div class="col-auto">--%>
                                        <%--                            <label for="inputdate" class="col-form-label">輸出日期:</label>--%>
                                        <%--                        </div>--%>
                                        <div class="col-auto">
                                            <input type="hidden" name="location" value="${location}">
                                            <input type="date" class="form-control" name="downloadDate" id="inputdate" style="width: 200px" required>
                                        </div>
                                        <div class="col-auto">
                                            <button type="submit" class="btn btn-primary mb-3">下載設備</button>
                                        </div>
                                        <div class="col-auto">
                                            <button type="submit" formaction="${pageContext.request.contextPath}/${mainWarehouse}/downloadExcel?category=smalltool" class="btn btn-primary mb-3">下載小器具</button>
                                        </div>
                                        <div class="col-auto">
                                            <button type="submit" formaction="${pageContext.request.contextPath}/${mainWarehouse}/downloadExcel?category=food" class="btn btn-primary mb-3">下載材料</button>
                                        </div>
                                        <div class="col-auto">
                                            <button type="submit" formaction="${pageContext.request.contextPath}/${mainWarehouse}/downloadExcel?category=commercialthing" class="btn btn-primary mb-3">下載宣傳物料</button>
                                        </div>
                                        <div class="col-auto">
                                            <button type="submit" formaction="${pageContext.request.contextPath}/${mainWarehouse}/downloadExcel?category=other" class="btn btn-primary mb-3">下載其他</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>


                </div>
            </div>


        </div>

        <div class="col-md-12 column">
            <br><br><br>
            <div class="row">
                <div class="col-md-2 column">

                </div>
                <div class="col-md-4 column">
                    <h4>設備</h4>
                </div>

            </div>
            <div class="row">
                <div class="col-md-2">

                </div>
                <div class="col-md-8">
                    <div style="overflow:scroll;height:50vh;">
                        <table class="table table-borderless table-hover">
                            <thead class="table-customize">
                            <tr>
<%--                                <th></th>--%>
                                <th>名字</th>
                                <th>品牌</th>
                                <th>日盤数量</th>
                                <th>實際数量</th>
                                <th>時間</th>
                                <th>狀態</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:set var="headCount" value="0"/>
                            <c:forEach var="listItem" items="${listItem}">
                                <c:set var="headCount" value="${headCount + 1}"/>
                                <tr>
<%--                                    <td class="table-customize2">${headCount}</td>--%>
<%--                                    <td class="table-customize2" hidden>${listItem.logid}</td>--%>
<%--                                    <td class="table-customize2" hidden>${listItem.id}</td>--%>
                                    <th class="table-customize" scope="row">${headCount}. ${listItem.itemName}</th>
                                    <td class="table-customize2">${listItem.brand}</td>
                                    <td class="table-customize2">${listItem.checkitemCount}</td>
                                    <td class="table-customize2">${listItem.realitemCount}</td>
                                    <td class="table-customize2">${listItem.time}</td>
                                    <c:if test="${listItem.ifmatch.equals('same')}">
                                        <td class="table-customize2">一樣</td>
                                    </c:if>
                                    <c:if test="${listItem.ifmatch.equals('less')}">
                                        <td class="table-customize2" style="color: #ff0000;font-weight:bold">少了${listItem.difference}</td>
                                    </c:if>
                                    <c:if test="${listItem.ifmatch.equals('more')}">
                                        <td class="table-customize2" style="color: #0abab5;font-weight:bold">多了${listItem.difference}</td>
                                    </c:if>


                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col-md-2">

                </div>
            </div>





        </div>
        <div class="col-md-12 column">
            <div class="row">
                <div class="col-md-2 column">

                </div>
                <div class="col-md-4 column">
                    <br><br><br>
                    <h4>材料</h4>
                </div>

            </div>
            <div class="row">
                <div class="col-md-2">

                </div>
                <div class="col-md-8">
                    <div style="overflow:scroll;height:50vh;">
                        <table class="table table-borderless table-hover">
                            <thead class="table-customize">
                            <tr>
<%--                                <th></th>--%>
                                <th>名字</th>
                                <th>品牌</th>
                                <th>日盤数量</th>
                                <th>實際数量</th>
                                <th>時間</th>
                                <th>狀態</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:set var="headCount" value="0"/>
                            <c:forEach var="listFood" items="${listFood}">
                                <c:set var="headCount" value="${headCount + 1}"/>
                                <tr>
<%--                                    <td class="table-customize2">${headCount}</td>--%>
<%--                                    <td class="table-customize2" hidden>${listFood.logid}</td>--%>
<%--                                    <td class="table-customize2" hidden>${listFood.id}</td>--%>
                                    <th class="table-customize" scope="row">${headCount}. ${listFood.itemName}</th>
                                    <td class="table-customize2">${listFood.brand}</td>
                                    <td class="table-customize2">${listFood.checkitemCount}</td>
                                    <td class="table-customize2">${listFood.realitemCount}</td>
                                    <td class="table-customize2">${listFood.time}</td>
                                    <c:if test="${listFood.ifmatch.equals('same')}">
                                        <td class="table-customize2">一樣</td>
                                    </c:if>
                                    <c:if test="${listFood.ifmatch.equals('less')}">
                                        <td class="table-customize2" style="color: #ff0000;font-weight:bold">少了${listFood.difference}</td>
                                    </c:if>
                                    <c:if test="${listFood.ifmatch.equals('more')}">
                                        <td class="table-customize2" style="color: #0abab5;font-weight:bold">多了${listFood.difference}</td>
                                    </c:if>



                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col-md-2">

                </div>
            </div>

        </div>
        <div class="col-md-12 column">
            <div class="row">
                <div class="col-md-2 column">

                </div>
                <div class="col-md-4 column">
                    <br><br><br>
                    <h4>小器具</h4>
                </div>

            </div>
            <div class="row">
                <div class="col-md-2">

                </div>
                <div class="col-md-8">
                    <div style="overflow:scroll;height:50vh;">
                        <table class="table table-borderless table-hover">
                            <thead class="table-customize">
                            <tr>
<%--                                <th></th>--%>
                                <th>名字</th>
                                <th>品牌</th>
                                <th>日盤数量</th>
                                <th>實際数量</th>
                                <th>時間</th>
                                <th>狀態</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:set var="headCount" value="0"/>
                            <c:forEach var="listSmallItem" items="${listSmallItem}">
                                <c:set var="headCount" value="${headCount + 1}"/>
                                <tr>
<%--                                    <td class="table-customize2">${headCount}</td>--%>
<%--                                    <td class="table-customize2" hidden>${listSmallItem.logid}</td>--%>
<%--                                    <td class="table-customize2" hidden>${listSmallItem.id}</td>--%>
                                    <th class="table-customize" scope="row">${headCount}. ${listSmallItem.itemName}</th>
                                    <td class="table-customize2">${listSmallItem.brand}</td>
                                    <td class="table-customize2">${listSmallItem.checkitemCount}</td>
                                    <td class="table-customize2">${listSmallItem.realitemCount}</td>
                                    <td class="table-customize2">${listSmallItem.time}</td>
                                    <c:if test="${listSmallItem.ifmatch.equals('same')}">
                                        <td class="table-customize2">一樣</td>
                                    </c:if>
                                    <c:if test="${listSmallItem.ifmatch.equals('less')}">
                                        <td class="table-customize2" style="color: #ff0000;font-weight:bold">少了${listSmallItem.difference}</td>
                                    </c:if>
                                    <c:if test="${listSmallItem.ifmatch.equals('more')}">
                                        <td class="table-customize2" style="color: #0abab5;font-weight:bold">多了${listSmallItem.difference}</td>
                                    </c:if>

                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col-md-2">

                </div>
            </div>


        </div>
        <div class="col-md-12 column">
            <div class="row">
                <div class="col-md-2 column">

                </div>
                <div class="col-md-4 column">
                    <br><br><br>
                    <h4>宣传物料</h4>
                </div>

            </div>
            <div class="row">
                <div class="col-md-2">

                </div>
                <div class="col-md-8">
                    <div style="overflow:scroll;height:50vh;">
                        <table class="table table-borderless table-hover">
                            <thead class="table-customize">
                            <tr>
<%--                                <th></th>--%>
                                <th>名字</th>
                                <th>品牌</th>
                                <th>日盤数量</th>
                                <th>實際数量</th>
                                <th>時間</th>
                                <th>狀態</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:set var="headCount" value="0"/>
                            <c:forEach var="listCommercialthing" items="${listCommercialthing}">
                                <c:set var="headCount" value="${headCount + 1}"/>
                                <tr>
<%--                                    <td class="table-customize2">${headCount}</td>--%>
<%--                                    <td class="table-customize2" hidden>${listCommercialthing.logid}</td>--%>
<%--                                    <td class="table-customize2" hidden>${listCommercialthing.id}</td>--%>
                                    <th class="table-customize" scope="row">${headCount}. ${listCommercialthing.itemName}</th>
                                    <td class="table-customize2">${listCommercialthing.brand}</td>
                                    <td class="table-customize2">${listCommercialthing.checkitemCount}</td>
                                    <td class="table-customize2">${listCommercialthing.realitemCount}</td>
                                    <td class="table-customize2">${listCommercialthing.time}</td>
                                    <c:if test="${listCommercialthing.ifmatch.equals('same')}">
                                        <td class="table-customize2">一樣</td>
                                    </c:if>
                                    <c:if test="${listCommercialthing.ifmatch.equals('less')}">
                                        <td class="table-customize2" style="color: #ff0000;font-weight:bold">少了${listCommercialthing.difference}</td>
                                    </c:if>
                                    <c:if test="${listCommercialthing.ifmatch.equals('more')}">
                                        <td class="table-customize2" style="color: #0abab5;font-weight:bold">多了${listCommercialthing.difference}</td>
                                    </c:if>


                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col-md-2">

                </div>
            </div>


        </div>
        <div class="col-md-12 column">
            <div class="row">
                <div class="col-md-2 column">

                </div>
                <div class="col-md-4 column">
                    <br><br><br>
                    <h4>其他</h4>
                </div>

            </div>
            <div class="row">
                <div class="col-md-2">

                </div>
                <div class="col-md-8">
                    <div style="overflow:scroll;height:50vh;">
                        <table class="table table-borderless table-hover">
                            <thead class="table-customize">
                            <tr>
<%--                                <th></th>--%>
                                <th>名字</th>
                                <th>品牌</th>
                                <th>日盤数量</th>
                                <th>實際数量</th>
                                <th>時間</th>
                                <th>狀態</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:set var="headCount" value="0"/>
                            <c:forEach var="listOther" items="${listOther}">
                                <c:set var="headCount" value="${headCount + 1}"/>
                                <tr>
<%--                                    <td class="table-customize2">${headCount}</td>--%>
<%--                                    <td class="table-customize2" hidden>${listOther.logid}</td>--%>
<%--                                    <td class="table-customize2" hidden>${listOther.id}</td>--%>
                                    <th class="table-customize" scope="row">${headCount}. ${listOther.itemName}</th>
                                    <td class="table-customize2">${listOther.brand}</td>
                                    <td class="table-customize2">${listOther.checkitemCount}</td>
                                    <td class="table-customize2">${listOther.realitemCount}</td>
                                    <td class="table-customize2">${listOther.time}</td>
                                    <c:if test="${listOther.ifmatch.equals('same')}">
                                        <td class="table-customize2">一樣</td>
                                    </c:if>
                                    <c:if test="${listOther.ifmatch.equals('less')}">
                                        <td class="table-customize2" style="color: #ff0000;font-weight:bold">少了${listOther.difference}</td>
                                    </c:if>
                                    <c:if test="${listOther.ifmatch.equals('more')}">
                                        <td class="table-customize2" style="color: #0abab5;font-weight:bold">多了${listOther.difference}</td>
                                    </c:if>


                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col-md-2">

                </div>
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
