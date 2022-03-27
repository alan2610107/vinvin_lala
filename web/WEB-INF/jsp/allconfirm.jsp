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
        .btn{
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
            <br>
            <tag style="color: red">*如果按下「通過」按鈕該物品還在，重整一下頁面看還在不在</tag>
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
<%--                        <th></th>--%>
<%--                        <th hidden>编号</th>--%>
                        <th>名字</th>
                        <th>品牌</th>
                        <th>数量</th>
                        <th>單價</th>
                        <th>總價</th>
                        <th>详情</th>
                        <th>時間</th>
                        <th>動作</th>
                        <th>從</th>
                        <th>到</th>
                        <th>審核狀態</th>
                        <th>截圖</th>
                        <th>審核</th>
                        <th></th>

                        <%--                    <th>操作</th>--%>

                    </tr>
                    </thead>

                    <tbody>
                    <c:set var="headCount" value="0"/>
                    <c:forEach var="listItem" items="${listItem}">
                        <c:set var="headCount" value="${headCount + 1}"/>
                        <tr>
                            <th class="table-customize" scope="row">${headCount}. ${listItem.itemName}</th>
                            <td class="table-customize2">${listItem.brand}</td>
                            <td class="table-customize2"><input type="number" pattern="\d*" value="${listItem.itemCount}" style="width: 56px !important;" min="1" max="${listItem.itemCount}"></td>
                            <td class="table-customize2">${listItem.singlePrice}</td>
                            <td class="table-customize2">${listItem.totalPrice}</td>
                            <td class="table-customize2">${listItem.memo}</td>
                            <td class="table-customize2">${listItem.time}</td>
                            <td class="table-customize2">${actionMap[listItem.action]}</td>
                            <td class="table-customize2">${warehouseMap[listItem.from]}</td>
                            <td class="table-customize2">${warehouseMap[listItem.to]}</td>
                            <td class="table-customize2" style="color: red">未審核</td>
                            <td class="table-customize2"><a href="${pageContext.request.contextPath}${ToolFilePathMap[listItem.id]}" target="_blank">截圖</a></td>
                            <c:if test="${function.equals('notpass')}">
                                <td class="table-customize2">
                                    <button class="btn btn-primary" onclick="this.disabled=true">通過</button>
                                </td>
                            </c:if>
                                <td class="table-customize2">
                                    <a class="btn btn-danger" href="${pageContext.request.contextPath}/confirm/reject?location=${logLocation}&itemtype=${categoryTool}&logid=${listItem.logid}" style="padding: 1px !important;">拒絕</a>
                                </td>

                            <td id="logid" hidden>${listItem.logid}</td>
                            <td id="category" hidden>${categoryTool}</td>


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
<%--                        <th></th>--%>
<%--                        <th hidden>编号</th>--%>
                        <th>名字</th>
                        <th>品牌</th>
                        <th>数量</th>
                        <th>單價</th>
                        <th>總價</th>
                        <th>详情</th>
                        <th>時間</th>
                        <th>動作</th>
                        <th>從</th>
                        <th>到</th>
                        <th>審核狀態</th>
                        <th>截圖</th>
                        <th>審核</th>
                        <th></th>

                        <%--                    <th>操作</th>--%>

                    </tr>
                    </thead>

                    <tbody>
                    <c:set var="headCount" value="0"/>
                    <c:forEach var="listFood" items="${listFood}">
                        <c:set var="headCount" value="${headCount + 1}"/>
                        <tr>
                                <%--                        <td class="table-customize2" hidden>${headCount}</td>--%>
                                <%--                        <td class="table-customize2" hidden>${listFood.id}</td>--%>
                            <th class="table-customize" scope="row">${headCount}. ${listFood.itemName}</th>
                            <td class="table-customize2">${listFood.brand}</td>
                            <td class="table-customize2"><input type="number" pattern="\d*" value="${listFood.itemCount}" style="width: 56px !important;" min="1" max="${listFood.itemCount}"></td>
                            <td class="table-customize2">${listFood.singlePrice}</td>
                            <td class="table-customize2">${listFood.totalPrice}</td>
                            <td class="table-customize2">${listFood.memo}</td>
                            <td class="table-customize2">${listFood.time}</td>
                            <td class="table-customize2">${actionMap[listFood.action]}</td>
                            <td class="table-customize2">${warehouseMap[listFood.from]}</td>
                            <td class="table-customize2">${warehouseMap[listFood.to]}</td>
                            <td class="table-customize2" style="color: red">未審核</td>

                            <td class="table-customize2"><a href="${pageContext.request.contextPath}${FoodFilePathMap[listFood.id]}" target="_blank">截圖</a></td>
                            <c:if test="${function.equals('notpass')}">
                                <td class="table-customize2">
                                    <button class="btn btn-primary" onclick="this.disabled=true">通過</button>
                                </td>
                            </c:if>
                            <td class="table-customize2">
                                <a class="btn btn-danger" href="${pageContext.request.contextPath}/confirm/reject?location=${logLocation}&itemtype=${categoryFood}&logid=${listFood.logid}" style="padding: 1px !important;">拒絕</a>
                            </td>

                            <td id="logid" hidden>${listFood.logid}</td>
                            <td id="category" hidden>${categoryFood}</td>



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
<%--                        <th></th>--%>
<%--                        <th hidden>编号</th>--%>
                        <th>名字</th>
                        <th>品牌</th>
                        <th>数量</th>
                        <th>單價</th>
                        <th>總價</th>
                        <th>详情</th>
                        <th>時間</th>
                        <th>動作</th>
                        <th>從</th>
                        <th>到</th>
                        <th>審核狀態</th>
                        <th>截圖</th>
                        <th>審核</th>
                        <th></th>

                        <%--                    <th>操作</th>--%>

                    </tr>
                    </thead>

                    <tbody>
                    <c:set var="headCount" value="0"/>
                    <c:forEach var="listSmallItem" items="${listSmallItem}">
                        <c:set var="headCount" value="${headCount + 1}"/>
                        <tr>
                                <%--                        <td class="table-customize2" hidden>${headCount}</td>--%>
                                <%--                        <td class="table-customize2" hidden>${listSmallItem.id}</td>--%>
                            <th class="table-customize" scope="row">${headCount}. ${listSmallItem.itemName}</th>
                            <td class="table-customize2">${listSmallItem.brand}</td>
                            <td class="table-customize2"><input type="number" pattern="\d*" value="${listSmallItem.itemCount}" style="width: 56px !important;" min="1" max="${listSmallItem.itemCount}"></td>
                            <td class="table-customize2">${listSmallItem.singlePrice}</td>
                            <td class="table-customize2">${listSmallItem.totalPrice}</td>
                            <td class="table-customize2">${listSmallItem.memo}</td>
                            <td class="table-customize2">${listSmallItem.time}</td>
                            <td class="table-customize2">${actionMap[listSmallItem.action]}</td>
                            <td class="table-customize2">${warehouseMap[listSmallItem.from]}</td>
                            <td class="table-customize2">${warehouseMap[listSmallItem.to]}</td>
                            <td class="table-customize2" style="color: red">未審核</td>
                            <td class="table-customize2"><a href="${pageContext.request.contextPath}${SmallToolFilePathMap[listSmallItem.id]}" target="_blank">截圖</a></td>
                            <c:if test="${function.equals('notpass')}">
                                <td class="table-customize2">
                                    <button class="btn btn-primary" onclick="this.disabled=true">通過</button>
                                </td>
                            </c:if>
                            <td class="table-customize2">
                                <a class="btn btn-danger" href="${pageContext.request.contextPath}/confirm/reject?location=${logLocation}&itemtype=${categorySmallTool}&logid=${listSmallItem.logid}" style="padding: 1px !important;">拒絕</a>
                            </td>

                            <td id="logid" hidden>${listSmallItem.logid}</td>
                            <td id="category" hidden>${categorySmallTool}</td>

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
<%--                        <th></th>--%>
<%--                        <th hidden>编号</th>--%>
                        <th>名字</th>
                        <th>品牌</th>
                        <th>数量</th>
                        <th>單價</th>
                        <th>總價</th>
                        <th>详情</th>
                        <th>時間</th>
                        <th>動作</th>
                        <th>從</th>
                        <th>到</th>
                        <th>審核狀態</th>
                        <th>截圖</th>
                        <th>審核</th>
                        <th></th>

                        <%--                    <th>操作</th>--%>

                    </tr>
                    </thead>

                    <tbody>
                    <c:set var="headCount" value="0"/>
                    <c:forEach var="listCommercialthing" items="${listCommercialthing}">
                        <c:set var="headCount" value="${headCount + 1}"/>
                        <tr>
                                <%--                        <td class="table-customize2" hidden>${headCount}</td>--%>
                                <%--                        <td class="table-customize2" hidden>${listCommercialthing.id}</td>--%>
                            <th class="table-customize" scope="row">${headCount}. ${listCommercialthing.itemName}</th>
                            <td class="table-customize2">${listCommercialthing.brand}</td>
                            <td class="table-customize2"><input type="number" pattern="\d*" value="${listCommercialthing.itemCount}" style="width: 56px !important;" min="1" max="${listCommercialthing.itemCount}"></td>
                            <td class="table-customize2">${listCommercialthing.singlePrice}</td>
                            <td class="table-customize2">${listCommercialthing.totalPrice}</td>
                            <td class="table-customize2">${listCommercialthing.memo}</td>
                            <td class="table-customize2">${listCommercialthing.time}</td>
                            <td class="table-customize2">${actionMap[listCommercialthing.action]}</td>
                            <td class="table-customize2">${warehouseMap[listCommercialthing.from]}</td>
                            <td class="table-customize2">${warehouseMap[listCommercialthing.to]}</td>
                            <td class="table-customize2" style="color: red">未審核</td>
                            <td class="table-customize2"><a href="${pageContext.request.contextPath}${CommercialFilePathMap[listCommercialthing.id]}" target="_blank">截圖</a></td>
                            <c:if test="${function.equals('notpass')}">
                                <td class="table-customize2">
                                    <button class="btn btn-primary" onclick="this.disabled=true">通過</button>
                                </td>
                            </c:if>
                            <td class="table-customize2">
                                <a class="btn btn-danger" href="${pageContext.request.contextPath}/confirm/reject?location=${logLocation}&itemtype=${categoryCommercial}&logid=${listCommercialthing.logid}" style="padding: 1px !important;">拒絕</a>
                            </td>

                            <td id="logid" hidden>${listCommercialthing.logid}</td>
                            <td id="category" hidden>${categoryCommercial}</td>


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
<%--                        <th></th>--%>
<%--                        <th hidden>编号</th>--%>
                        <th>名字</th>
                        <th>品牌</th>
                        <th>数量</th>
                        <th>單價</th>
                        <th>總價</th>
                        <th>详情</th>
                        <th>時間</th>
                        <th>動作</th>
                        <th>從</th>
                        <th>到</th>
                        <th>審核狀態</th>
                        <th>截圖</th>
                        <th>審核</th>
                        <th></th>

                        <%--                    <th>操作</th>--%>

                    </tr>
                    </thead>

                    <tbody>
                    <c:set var="headCount" value="0"/>
                    <c:forEach var="listOther" items="${listOther}">
                        <c:set var="headCount" value="${headCount + 1}"/>
                        <tr>
                                <%--                        <td class="table-customize2" hidden>${headCount}</td>--%>
                                <%--                        <td class="table-customize2" hidden>${listOther.id}</td>--%>
                            <th class="table-customize" scope="row">${headCount}. ${listOther.itemName}</th>
                            <td class="table-customize2">${listOther.brand}</td>
                            <td class="table-customize2"><input type="number" pattern="\d*" value="${listOther.itemCount}" style="width: 56px !important;" min="1" max="${listOther.itemCount}"></td>
                            <td class="table-customize2">${listOther.singlePrice}</td>
                            <td class="table-customize2">${listOther.totalPrice}</td>
                            <td class="table-customize2">${listOther.memo}</td>
                            <td class="table-customize2">${listOther.time}</td>
                            <td class="table-customize2">${actionMap[listOther.action]}</td>
                            <td class="table-customize2">${warehouseMap[listOther.from]}</td>
                            <td class="table-customize2">${warehouseMap[listOther.to]}</td>
                            <td class="table-customize2" style="color: red">未審核</td>
                            <td class="table-customize2"><a href="${pageContext.request.contextPath}${OtherFilePathMap[listOther.id]}" target="_blank">截圖</a></td>
                            <c:if test="${function.equals('notpass')}">
                                <td class="table-customize2">
                                    <button class="btn btn-primary" onclick="this.disabled=true">通過</button>
                                </td>
                            </c:if>
                            <td class="table-customize2">
                                <a class="btn btn-danger" href="${pageContext.request.contextPath}/confirm/reject?location=${logLocation}&itemtype=${categoryOther}&logid=${listOther.logid}" style="padding: 1px !important;">拒絕</a>
                            </td>

                            <td id="logid" hidden>${listOther.logid}</td>
                            <td id="category" hidden>${categoryOther}</td>


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
    $('td button').click(function(){
        const confirmitemCount = $(this).closest('tr').find("input").val();
        const logid = $(this).closest('tr').find("#logid").text();
        const category = $(this).closest('tr').find("#category").text();
        let confirmInput = [];
        confirmInput.push(logid, confirmitemCount);
        console.log(confirmInput);
        const confirmInputJson = JSON.stringify(confirmInput,0,"\t");
        console.log(confirmInputJson);
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/confirm/agree?location=${logLocation}&itemtype="+category,
            dataType:"json",

            data: {"confirmInput[]":confirmInputJson},


            success:function (data) {
                console.log("succeed");
            },

            error:function () {
            }
        })
        var redirect = "${pageContext.request.contextPath}/confirm/listnotpass?location=${logLocation}"
        setTimeout(function(){
            location.href = redirect
        }, 1000);

        // alert($(this).closest('tr').attr('id'));
        // alert($(this).closest('tr').find('td:first').attr('id'));
    });
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
        crossorigin="anonymous"></script>
</body>
</html>
