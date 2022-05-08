<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wujilin
  Date: 2021/10/13
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改物品名稱</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="theme-color" content="#f8f9fa">
    <meta name="apple-mobile-web-app-title" content="vinvinERP">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
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
            min-width: 1em;
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
<body>
<jsp:include page="navwithSearch.jsp"/>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <br><br>
        </div>
        <div class="row">

            <div class="col-md-2">

            </div>
            <div class="col-md-8">
                <ul>
                    <li style="color: red">在想要調整的物料填上打勾並填上順序(純數字)</li>
                </ul>
            </div>
            <div class="col-md-2">

            </div>
        </div>
        <div class="col-md-12 column">
            <br>
            <div class="row">
                <div class="col-md-2 column">

                </div>
                <div class="col-md-4 column">
                    <h4>${categoryCN}</h4>
                </div>

            </div>
            <div class="row">
                <div class="col-md-2">

                </div>
                <div class="col-md-8">
                    <div style="overflow:scroll;height:70vh;">
                        <table class="table table-borderless table-hover" id="itemSetTable">
                            <thead class="table-customize">
                            <tr>
                                <%--                                <th></th>--%>
                                <th></th>
                                <th>原始<br>順序</th>
                                <th>名稱</th>
                                <th hidden>ID</th>
                                <th></th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:set var="headCount" value="0"/>
                            <c:forEach var="itemSet" items="${itemSetList}">
                                <c:set var="headCount" value="${headCount + 1}"/>
                                <tr>
                                    <th class="table-customize" scope="row"><input type="checkbox"/></th>
                                    <td class="table-customize2">${headCount}</td>
                                    <td class="table-customize2">${itemSet.itemName}</td>
                                    <td class="table-customize2" hidden>${itemSet.itemID}</td>
                                    <td class="table-customize2">
                                        <input type="number" pattern="\d*" name="itemCount" class="form-control" style="padding: 0px 5px !important; border-top-width: 0px !important; border-bottom-width: 0px !important; width: 63px !important; border-right-width: 2px !important;">
                                    </td>
<%--                                    <td class="table-customize2" style="width: 80px">--%>
<%--                                        <a class="btn btn-primary" href="${pageContext.request.contextPath}/change/toChangeItemName?id=${itemTool.itemID}" style="padding-bottom: 0px !important; padding-top: 0px !important;">修改</a>--%>
<%--                                    </td>--%>
<%--                                    <td class="table-customize2" style="width: 80px">--%>
<%--                                        <a class="btn btn-danger" href="${pageContext.request.contextPath}/change/delete?itemID=${itemTool.itemID}&category=${itemTool.category}" style="padding-bottom: 0px !important; padding-top: 0px !important;">刪除</a>--%>
<%--                                    </td>--%>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <br>
                    <input name="btnItemSet" id="btnItemSet" class="btn btn-primary" type="button"
                           value="送出" onclick="this.disabled=true">
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
<script>
    $("#btnItemSet").on("click", function () {
        const result = $("#itemSetTable tbody tr:has(:checked)");
        console.log(result);

        const tableval = result.map(function () {
            return [$(this).children().slice(2).map(function () {
                return $(this).text().trim()
            }).get()]
        }).get();
        const inputval = result.map(function () {
            return [$(this).children().slice(1).map(function () {
                return $(this).find("input").get().map(function (input) {
                    return input.value
                })
            }).get()]
        }).get();
        for (let i = 0; i < tableval.length; i++) {
            tableval[i][2] = inputval[i][0];
        }
        console.log(tableval);
        const json = JSON.stringify(tableval, 0, "\t");
        console.log(json);
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/item/setItemSetOrder?category=${category}",
            dataType:"json",

            data: {"items[]":json},

            success:function (data) {
                console.log("succeed");
            },

            error:function () {
            }
        })
        const redirect = "${pageContext.request.contextPath}/item/showItemSet?category=${category}";
        setTimeout(function(){
            location.href = redirect
        }, 2000);
    });
</script>
</html>
