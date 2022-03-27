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
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>
<body>

<jsp:include page="navwithSearch.jsp"/>


<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <br><br><br>
            <a class="btn btn-customize" role="button" style="color: white;" href="${pageContext.request.contextPath}/receive/setExpiredDate?location=${logLocation}">設定過期日</a>
            <a class="btn btn-customize2" role="button" href="${pageContext.request.contextPath}/receive/showAllExpiredList?location=${logLocation}">過期日清單</a>
            <a class="btn btn-danger" role="button" href="${pageContext.request.contextPath}/receive/showExpiredList?location=${logLocation}">過期報廢</a>
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
                <table id="tooltable" class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th></th>
                        <th></th>
                        <th hidden>编号</th>
                        <th>名字</th>
                        <th>品牌</th>
                        <th>数量</th>
                        <th hidden>單價</th>
                        <th hidden>總價</th>
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
                    <c:forEach var="listItem" items="${listItem}">
                        <c:set var="headCount" value="${headCount + 1}"/>
                        <tr>
                            <td><input type="checkbox"/></td>
                            <td>${headCount}</td>
                            <td hidden>${listItem.logid}</td>
                            <td hidden>${listItem.id}</td>
                            <td>${listItem.itemName}</td>
                            <td>${listItem.brand}</td>
                            <td><input type="text" name="itemCount" class="form-control" value="${listItem.itemCount}" style="padding: 0px 5px !important; border-top-width: 0px !important; border-bottom-width: 0px !important; width: 63px !important; border-right-width: 2px !important;" required></td>
                            <td hidden>${listItem.singlePrice}</td>
                            <td hidden>${listItem.totalPrice}</td>
                            <td>${listItem.memo}</td>
                            <td>${listItem.time}</td>
                            <td>${listItem.action}</td>
                            <td>${listItem.from}</td>
                            <td>${listItem.to}</td>
                            <c:if test="${listItem.ifComplete.equals(true)}">
                                <td>${listItem.ifComplete}</td>
                            </c:if>
                            <c:if test="${listItem.ifComplete.equals(false)}">
                                <td style="color: #ff0000;font-weight:bold">${listItem.ifComplete}</td>
                            </c:if>


                                <%--                        <td>--%>
                                <%--                            <a href="${pageContext.request.contextPath}/${mainWarehouse}/toUpdatetool?id=${listItem.id}">修改</a>--%>
                                <%--                            &nbsp; | &nbsp;--%>
                                <%--                            <a href="${pageContext.request.contextPath}/${mainWarehouse}/deletetool/${listItem.id}">刪除</a>--%>
                                <%--                            &nbsp; | &nbsp;--%>
                                <%--                            <a href="${pageContext.request.contextPath}/${mainWarehouse}/toInputtool?id=${listItem.id}">入庫</a>--%>
                                <%--                            &nbsp; | &nbsp;--%>
                                <%--                            <a href="${pageContext.request.contextPath}/${mainWarehouse}/toOutputtool?id=${listItem.id}">出庫</a>--%>
                                <%--                            &nbsp; | &nbsp;--%>
                                <%--                            <a href="${pageContext.request.contextPath}/${mainWarehouse}/toSendtool?id=${listItem.id}">轉移</a>--%>
                                <%--                        </td>--%>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <input name="btnTool" id="btnTool" class="btn btn-primary" type="button"
                       value="送出">


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
                <table id="foodtable" class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th></th>
                        <th></th>
                        <th hidden>编号</th>
                        <th>名字</th>
                        <th>品牌</th>
                        <th>数量</th>
                        <th hidden>單價</th>
                        <th hidden>總價</th>
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
                    <c:forEach var="listFood" items="${listFood}">
                        <c:set var="headCount" value="${headCount + 1}"/>
                        <tr>
                            <td><input type="checkbox"/></td>
                            <td>${headCount}</td>
                            <td hidden>${listFood.logid}</td>
                            <td hidden>${listFood.id}</td>
                            <td>${listFood.itemName}</td>
                            <td>${listFood.brand}</td>
                            <td><input type="text" name="itemCount" class="form-control" value="${listFood.itemCount}" style="padding: 0px 5px !important; border-top-width: 0px !important; border-bottom-width: 0px !important; width: 63px !important; border-right-width: 2px !important;" required></td>
                            <td hidden>${listFood.singlePrice}</td>
                            <td hidden>${listFood.totalPrice}</td>
                            <td>${listFood.memo}</td>
                            <td>${listFood.time}</td>
                            <td>${listFood.action}</td>
                            <td>${listFood.from}</td>
                            <td>${listFood.to}</td>
                            <c:if test="${listFood.ifComplete.equals(true)}">
                                <td>${listFood.ifComplete}</td>
                            </c:if>
                            <c:if test="${listFood.ifComplete.equals(false)}">
                                <td style="color: #ff0000;font-weight:bold">${listFood.ifComplete}</td>
                            </c:if>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <input name="btnFood" id="btnFood" class="btn btn-primary" type="button"
                       value="送出">
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
                <table id="smalltooltable" class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th></th>
                        <th></th>
                        <th hidden>编号</th>
                        <th>名字</th>
                        <th>品牌</th>
                        <th>数量</th>
                        <th hidden>單價</th>
                        <th hidden>總價</th>
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
                    <c:forEach var="listSmallItem" items="${listSmallItem}">
                        <c:set var="headCount" value="${headCount + 1}"/>
                        <tr>
                            <td><input type="checkbox"/></td>
                            <td>${headCount}</td>
                            <td hidden>${listSmallItem.logid}</td>
                            <td hidden>${listSmallItem.id}</td>
                            <td>${listSmallItem.itemName}</td>
                            <td>${listSmallItem.brand}</td>
                            <td><input type="text" name="itemCount" class="form-control" value="${listSmallItem.itemCount}" style="padding: 0px 5px !important; border-top-width: 0px !important; border-bottom-width: 0px !important; width: 63px !important; border-right-width: 2px !important;" required></td>
                            <td hidden>${listSmallItem.singlePrice}</td>
                            <td hidden>${listSmallItem.totalPrice}</td>
                            <td>${listSmallItem.memo}</td>
                            <td>${listSmallItem.time}</td>
                            <td>${listSmallItem.action}</td>
                            <td>${listSmallItem.from}</td>
                            <td>${listSmallItem.to}</td>
                            <c:if test="${listSmallItem.ifComplete.equals(true)}">
                                <td>${listSmallItem.ifComplete}</td>
                            </c:if>
                            <c:if test="${listSmallItem.ifComplete.equals(false)}">
                                <td style="color: #ff0000;font-weight:bold">${listSmallItem.ifComplete}</td>
                            </c:if>
                                <%--                        <td>--%>
                                <%--                            <a href="${pageContext.request.contextPath}/${mainWarehouse}/toUpdatesmalltool?id=${listSmallItem.id}">修改</a>--%>
                                <%--                            &nbsp; | &nbsp;--%>
                                <%--                            <a href="${pageContext.request.contextPath}/${mainWarehouse}/deletesmalltool/${listSmallItem.id}">刪除</a>--%>
                                <%--                            &nbsp; | &nbsp;--%>
                                <%--                            <a href="${pageContext.request.contextPath}/${mainWarehouse}/toInputsmalltool?id=${listSmallItem.id}">入庫</a>--%>
                                <%--                            &nbsp; | &nbsp;--%>
                                <%--                            <a href="${pageContext.request.contextPath}/${mainWarehouse}/toOutputsmalltool?id=${listSmallItem.id}">出庫</a>--%>
                                <%--                            &nbsp; | &nbsp;--%>
                                <%--                            <a href="${pageContext.request.contextPath}/${mainWarehouse}/toSendsmalltool?id=${listSmallItem.id}">轉移</a>--%>
                                <%--                        </td>--%>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <input name="btnSmallTool" id="btnSmallTool" class="btn btn-primary" type="button"
                       value="送出">
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
                <table id="commercialtable" class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th></th>
                        <th></th>
                        <th hidden>编号</th>
                        <th>名字</th>
                        <th>品牌</th>
                        <th>数量</th>
                        <th hidden>單價</th>
                        <th hidden>總價</th>
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
                    <c:forEach var="listCommercialItem" items="${listCommercialItem}">
                        <c:set var="headCount" value="${headCount + 1}"/>
                        <tr>
                            <td><input type="checkbox"/></td>
                            <td>${headCount}</td>
                            <td hidden>${listCommercialItem.logid}</td>
                            <td hidden>${listCommercialItem.id}</td>
                            <td>${listCommercialItem.itemName}</td>
                            <td>${listCommercialItem.brand}</td>
                            <td><input type="text" name="itemCount" class="form-control" value="${listCommercialItem.itemCount}" style="padding: 0px 5px !important; border-top-width: 0px !important; border-bottom-width: 0px !important; width: 63px !important; border-right-width: 2px !important;" required></td>
                            <td hidden>${listCommercialItem.singlePrice}</td>
                            <td hidden>${listCommercialItem.totalPrice}</td>
                            <td>${listCommercialItem.memo}</td>
                            <td>${listCommercialItem.time}</td>
                            <td>${listCommercialItem.action}</td>
                            <td>${listCommercialItem.from}</td>
                            <td>${listCommercialItem.to}</td>
                            <c:if test="${listCommercialItem.ifComplete.equals(true)}">
                                <td>${listCommercialItem.ifComplete}</td>
                            </c:if>
                            <c:if test="${listCommercialItem.ifComplete.equals(false)}">
                                <td style="color: #ff0000;font-weight:bold">${listCommercialItem.ifComplete}</td>
                            </c:if>
                                <%--                        <td>--%>
                                <%--                            <a href="${pageContext.request.contextPath}/${mainWarehouse}/toUpdatesmalltool?id=${listSmallItem.id}">修改</a>--%>
                                <%--                            &nbsp; | &nbsp;--%>
                                <%--                            <a href="${pageContext.request.contextPath}/${mainWarehouse}/deletesmalltool/${listSmallItem.id}">刪除</a>--%>
                                <%--                            &nbsp; | &nbsp;--%>
                                <%--                            <a href="${pageContext.request.contextPath}/${mainWarehouse}/toInputsmalltool?id=${listSmallItem.id}">入庫</a>--%>
                                <%--                            &nbsp; | &nbsp;--%>
                                <%--                            <a href="${pageContext.request.contextPath}/${mainWarehouse}/toOutputsmalltool?id=${listSmallItem.id}">出庫</a>--%>
                                <%--                            &nbsp; | &nbsp;--%>
                                <%--                            <a href="${pageContext.request.contextPath}/${mainWarehouse}/toSendsmalltool?id=${listSmallItem.id}">轉移</a>--%>
                                <%--                        </td>--%>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <input name="btnCommercial" id="btnCommercial" class="btn btn-primary" type="button"
                       value="送出">
            </div>

        </div>
        <div class="col-md-12 column">
            <div class="row">
                <div class="col-md-4 column">
                    <br><br><br>
                    <h4>其它</h4>
                </div>
                <div class="col-md-3 column">

                </div>

            </div>
            <div style="overflow:scroll;height:50vh;">
                <table id="othertable" class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th></th>
                        <th></th>
                        <th hidden>编号</th>
                        <th>名字</th>
                        <th>品牌</th>
                        <th>数量</th>
                        <th hidden>單價</th>
                        <th hidden>總價</th>
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
                    <c:forEach var="listOtherItem" items="${listOtherItem}">
                        <c:set var="headCount" value="${headCount + 1}"/>
                        <tr>
                            <td><input type="checkbox"/></td>
                            <td>${headCount}</td>
                            <td hidden>${listOtherItem.logid}</td>
                            <td hidden>${listOtherItem.id}</td>
                            <td>${listOtherItem.itemName}</td>
                            <td>${listOtherItem.brand}</td>
                            <td><input type="text" name="itemCount" class="form-control" value="${listOtherItem.itemCount}" style="padding: 0px 5px !important; border-top-width: 0px !important; border-bottom-width: 0px !important; width: 63px !important; border-right-width: 2px !important;" required></td>
                            <td hidden>${listOtherItem.singlePrice}</td>
                            <td hidden>${listOtherItem.totalPrice}</td>
                            <td>${listOtherItem.memo}</td>
                            <td>${listOtherItem.time}</td>
                            <td>${listOtherItem.action}</td>
                            <td>${listOtherItem.from}</td>
                            <td>${listOtherItem.to}</td>
                            <c:if test="${listOtherItem.ifComplete.equals(true)}">
                                <td>${listOtherItem.ifComplete}</td>
                            </c:if>
                            <c:if test="${listOtherItem.ifComplete.equals(false)}">
                                <td style="color: #ff0000;font-weight:bold">${listOtherItem.ifComplete}</td>
                            </c:if>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <input name="btnOther" id="btnOther" class="btn btn-primary" type="button"
                       value="送出">
            </div>

        </div>
        <div class="col-md-12 column">
            <br><br>
        </div>
    </div>
</div>
<script>
    $("#btnTool").on("click", function () {
        var result = $("#tooltable tbody tr:has(:checked)")
        console.log(result);

        var tableval = result.map(function () {
            return [$(this).children().slice(1).map(function () {
                return $(this).text().trim()
            }).get()]
        }).get();
        var inputval = result.map(function () {
            return [$(this).children().slice(1).map(function (){
                return $(this).find("input").get().map(function(input) {
                    return input.value
                })
            }).get()]
        }).get();
        for (let i = 0; i < tableval.length; i++) {
            tableval[i][5] = inputval[i][0];
        }
        console.log(tableval);
        var json = JSON.stringify(tableval,0,"\t");
        console.log(json);
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/receive/${updatelogmain}?itemtype=tool&location=${logLocation}",
            dataType:"json",

            data: {"items[]":json},


            success:function (data) {
                console.log("succeed");
                var redirect = "${pageContext.request.contextPath}/receive/list?location=${logLocation}"
                location.href = redirect
            },

            error:function () {
            }
        })
        var redirect = "${pageContext.request.contextPath}/receive/list?location=${logLocation}"
        setTimeout(function(){
            location.href = redirect
        }, 500);
    });
    $("#btnSmallTool").on("click", function () {
        var result = $("#smalltooltable tbody tr:has(:checked)")
        console.log(result);

        var tableval = result.map(function () {
            return [$(this).children().slice(1).map(function () {
                return $(this).text().trim()
            }).get()]
        }).get();
        var inputval = result.map(function () {
            return [$(this).children().slice(1).map(function (){
                return $(this).find("input").get().map(function(input) {
                    return input.value
                })
            }).get()]
        }).get();
        for (let i = 0; i < tableval.length; i++) {
            tableval[i][5] = inputval[i][0];
        }
        console.log(tableval);
        var json = JSON.stringify(tableval,0,"\t");
        console.log(json);
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/receive/${updatelogmain}?itemtype=smalltool&location=${logLocation}",
            dataType:"json",

            data: {"items[]":json},


            success:function (data) {
                console.log("succeed");
                var redirect = "${pageContext.request.contextPath}/receive/list?location=${logLocation}"
                location.href = redirect
            },

            error:function () {
            }
        })
        var redirect = "${pageContext.request.contextPath}/receive/list?location=${logLocation}"
        setTimeout(function(){
            location.href = redirect
        }, 500);
    });
    $("#btnFood").on("click", function () {
        var result = $("#foodtable tbody tr:has(:checked)")
        console.log(result);

        var tableval = result.map(function () {
            return [$(this).children().slice(1).map(function () {
                return $(this).text().trim()
            }).get()]
        }).get();
        var inputval = result.map(function () {
            return [$(this).children().slice(1).map(function (){
                return $(this).find("input").get().map(function(input) {
                    return input.value
                })
            }).get()]
        }).get();
        for (let i = 0; i < tableval.length; i++) {
            tableval[i][5] = inputval[i][0];
        }
        console.log(tableval);
        var json = JSON.stringify(tableval,0,"\t");
        console.log(json);
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/receive/${updatelogmain}?itemtype=food&location=${logLocation}",
            dataType:"json",

            data: {"items[]":json},


            success:function (data) {
                console.log("succeed");
                var redirect = "${pageContext.request.contextPath}/receive/list?location=${logLocation}"
                location.href = redirect
            },

            error:function () {
            }
        })
        var redirect = "${pageContext.request.contextPath}/receive/list?location=${logLocation}"
        setTimeout(function(){
            location.href = redirect
        }, 500);
    });
    $("#btnCommercial").on("click", function () {
        var result = $("#commercialtable tbody tr:has(:checked)")
        console.log(result);

        var tableval = result.map(function () {
            return [$(this).children().slice(1).map(function () {
                return $(this).text().trim()
            }).get()]
        }).get();
        var inputval = result.map(function () {
            return [$(this).children().slice(1).map(function (){
                return $(this).find("input").get().map(function(input) {
                    return input.value
                })
            }).get()]
        }).get();
        for (let i = 0; i < tableval.length; i++) {
            tableval[i][5] = inputval[i][0];
        }
        console.log(tableval);
        var json = JSON.stringify(tableval,0,"\t");
        console.log(json);
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/receive/${updatelogmain}?itemtype=commercialthing&location=${logLocation}",
            dataType:"json",

            data: {"items[]":json},


            success:function (data) {
                console.log("succeed");
                var redirect = "${pageContext.request.contextPath}/receive/list?location=${logLocation}"
                location.href = redirect
            },

            error:function () {
            }
        })
        var redirect = "${pageContext.request.contextPath}/receive/list?location=${logLocation}"
        setTimeout(function(){
            location.href = redirect
        }, 500);
    });
    $("#btnOther").on("click", function () {
        var result = $("#othertable tbody tr:has(:checked)")
        console.log(result);

        var tableval = result.map(function () {
            return [$(this).children().slice(1).map(function () {
                return $(this).text().trim()
            }).get()]
        }).get();
        var inputval = result.map(function () {
            return [$(this).children().slice(1).map(function (){
                return $(this).find("input").get().map(function(input) {
                    return input.value
                })
            }).get()]
        }).get();
        for (let i = 0; i < tableval.length; i++) {
            tableval[i][5] = inputval[i][0];
        }
        console.log(tableval);
        var json = JSON.stringify(tableval,0,"\t");
        console.log(json);
        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/receive/${updatelogmain}?itemtype=other&location=${logLocation}",
            dataType:"json",

            data: {"items[]":json},


            success:function (data) {
                console.log("succeed");
                var redirect = "${pageContext.request.contextPath}/receive/list?location=${logLocation}"
                location.href = redirect
            },

            error:function () {
            }
        })
        var redirect = "${pageContext.request.contextPath}/receive/list?location=${logLocation}"
        setTimeout(function(){
            location.href = redirect
        }, 500);
    });
</script>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
        crossorigin="anonymous"></script>
</body>
</html>
