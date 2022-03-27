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
                <div class="col-md-2 column">

                </div>
                <div class="col-md-4 column">
                    <h4>設備</h4>
                </div>

            </div>
            <div class="row">
                <div class="col-md-2">

                </div>
                <div class="col-md-8" style="overflow:scroll;height:50vh;">
                    <table class="table table-borderless table-hover" id="tooltable">
                        <thead class="table-customize">
                        <tr>

                            <th>名稱</th>
                            <th>品牌</th>
                            <th>数量</th>
                            <th hidden>單價</th>
                            <th hidden>總價</th>
                            <th>详情</th>


                        </tr>
                        </thead>

                        <tbody>
                        <c:set var="headCount" value="0"/>
                        <c:forEach var="listItem" items="${listItem}">
                            <c:set var="headCount" value="${headCount + 1}"/>
                            <tr>
                                    <%--                                <td>${headCount}</td>--%>
                                <td id="id" hidden>${listItem.id}</td>
                                <th class="table-customize" scope="row">${listItem.itemName}</th>
                                <td class="table-customize2">${listItem.brand}</td>
                                <td class="table-customize2"><input type="number" pattern="\d*" name="itemCount" class="form-control" required style="padding: 0px 0px 0px 5px !important;width: 67px"></td>
                                <td class="table-customize2">${listItem.memo}</td>


                            </tr>
                            <%--                        </form>--%>
                        </c:forEach>
                        </tbody>
                    </table>
                    <button type="submit" id="btnTool" class="btn btn-primary">提交</button>
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
                <div class="col-md-8" style="overflow:scroll;height:50vh;">
                    <table class="table table-borderless table-hover" id="foodtable">
                        <thead class="table-customize">
                        <tr>
                            <%--                            <th></th>--%>
                            <%--                            <th hidden>编号</th>--%>
                            <th>名稱</th>
                            <th>品牌</th>
                            <th>数量</th>
                            <th hidden>單價</th>
                            <th hidden>總價</th>
                            <th>详情</th>
                            <th>已過期</th>
                            <th>兩天後過期</th>




                        </tr>
                        </thead>

                        <tbody>
                        <c:set var="headCount" value="0"/>
                        <c:forEach var="listFood" items="${listFood}">
                            <c:set var="headCount" value="${headCount + 1}"/>
                            <c:set var="itemId" value="${listFood.id}"/>
                            <tr>
                                    <%--                                <td>${headCount}</td>--%>
                                <td hidden>${listFood.id}</td>
                                <th class="table-customize" scope="row">${listFood.itemName}</th>
                                <td class="table-customize2">${listFood.brand}</td>
                                <td class="table-customize2"><input type="number" pattern="\d*" name="itemCount" class="form-control" required style="padding: 0px 0px 0px 5px !important;width: 67px"></td>
                                <td class="table-customize2">${listFood.memo}</td>
                                <td class="table-customize2"><a style="color: red" href="${pageContext.request.contextPath}/receive/showExpiredList?location=${logLocation}" target="_blank">${expiredItemMap[itemId]}</a></td>
                                <td class="table-customize2"><a style="color: red" href="${pageContext.request.contextPath}/receive/showExpiredList?location=${logLocation}" target="_blank">${expiredSoonItemMap[itemId]}</a></td>


                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <button type="submit" id="btnFood" class="btn btn-primary">提交</button>
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
                <div class="col-md-8" style="overflow:scroll;height:50vh;">
                    <table class="table table-borderless table-hover" id="smalltooltable">
                        <thead class="table-customize">
                        <tr>
                            <%--                            <th></th>--%>
                            <%--                            <th hidden>编号</th>--%>
                            <th>名稱</th>
                            <th>品牌</th>
                            <th>数量</th>
                            <th hidden>單價</th>
                            <th hidden>總價</th>
                            <th>详情</th>




                        </tr>
                        </thead>

                        <tbody>
                        <c:set var="headCount" value="0"/>
                        <c:forEach var="listSmallItem" items="${listSmallItem}">
                            <c:set var="headCount" value="${headCount + 1}"/>

                            <tr>
                                    <%--                                <td>${headCount}</td>--%>
                                <td hidden>${listSmallItem.id}</td>
                                <th class="table-customize" scope="row">${listSmallItem.itemName}</th>
                                <td class="table-customize2">${listSmallItem.brand}</td>
                                <td class="table-customize2"><input type="number" pattern="\d*" name="itemCount" class="form-control" required style="padding: 0px 0px 0px 5px !important;width: 67px"></td>
                                <td class="table-customize2">${listSmallItem.memo}</td>
                            </tr>

                        </c:forEach>
                        </tbody>
                    </table>
                    <button type="submit" id="btnSmallTool" class="btn btn-primary">提交</button>
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
                <div class="col-md-8" style="overflow:scroll;height:50vh;">
                    <table class="table table-borderless table-hover" id="commercialtable">
                        <thead class="table-customize">
                        <tr>
                            <%--                            <th></th>--%>
                            <%--                            <th hidden>编号</th>--%>
                            <th>名稱</th>
                            <th>品牌</th>
                            <th>数量</th>
                            <th hidden>單價</th>
                            <th hidden>總價</th>
                            <th>详情</th>



                        </tr>
                        </thead>

                        <tbody>
                        <c:set var="headCount" value="0"/>
                        <c:forEach var="listCommercialthing" items="${listCommercialthing}">
                            <c:set var="headCount" value="${headCount + 1}"/>
                            <tr>
                                    <%--                                <td>${headCount}</td>--%>
                                <td hidden>${listCommercialthing.id}</td>
                                <th class="table-customize" scope="row">${listCommercialthing.itemName}</th>
                                <td class="table-customize2">${listCommercialthing.brand}</td>
                                <td class="table-customize2"><input type="number" pattern="\d*" name="itemCount" class="form-control" required style="padding: 0px 0px 0px 5px !important;width: 67px"></td>
                                <td class="table-customize2">${listCommercialthing.memo}</td>
                            </tr>
                            </form>
                        </c:forEach>
                        </tbody>
                    </table>
                    <button type="submit" id="btnCommercial" class="btn btn-primary">提交</button>
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
                <div class="col-md-8" style="overflow:scroll;height:50vh;">
                    <table class="table table-borderless table-hover" id="othertable">
                        <thead class="table-customize">
                        <tr>
                            <%--                            <th></th>--%>
                            <%--                            <th hidden>编号</th>--%>
                            <th>名稱</th>
                            <th>品牌</th>
                            <th>数量</th>
                            <th hidden>單價</th>
                            <th hidden>總價</th>
                            <th>详情</th>

                        </tr>
                        </thead>

                        <tbody>
                        <c:set var="headCount" value="0"/>
                        <c:forEach var="listOther" items="${listOther}">
                            <c:set var="headCount" value="${headCount + 1}"/>
                            <tr>
                                    <%--                                <td>${headCount}</td>--%>
                                <td hidden>${listOther.id}</td>
                                <th class="table-customize" scope="row">${listOther.itemName}</th>
                                <td class="table-customize2">${listOther.brand}</td>
                                <td class="table-customize2"><input type="number" pattern="\d*" name="itemCount" class="form-control" required style="padding: 0px 0px 0px 5px !important;width: 67px"></td>
                                <td class="table-customize2">${listOther.memo}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <button type="submit" id="btnOther" class="btn btn-primary">通過</button>
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
<script>
    $("#btnTool").on("click",function () {
        var result = $("#tooltable tbody tr")
        console.log(result);
        var tableval = result.map(function () {
            return [$(this).children().map(function () {
                return $(this).text().trim()
            }).get()]
        }).get();
        var inputval = result.map(function () {
            return [$(this).children().map(function (){
                return $(this).find("input").get().map(function(input) {

                    return input.value
                })
            }).get()]
        }).get();
        let flag = 0;
        for (let i = 0; i < tableval.length; i++) {
            if(inputval[i][0] == ""){
                flag = 1;
                break
            }
        }
        if(flag == 1){
            alert("所有空格都要填！！");
        }else {
            for (let i = 0; i < tableval.length; i++) {
                tableval[i][3] = inputval[i][0];
            }
            console.log(tableval);
            var json = JSON.stringify(tableval,0,"\t");
            console.log(json);
        }

        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/dailycheck/agree?location=${logLocation}&itemtype=tool",
            dataType:"json",

            data: {"items[]":json},


            success:function (data) {
                console.log("succeed");

            },

            error:function () {
            }
        })
        var redirect = "${pageContext.request.contextPath}/dailycheck/toDailyCheck?location=${logLocation}"
        setTimeout(function(){
            location.href = redirect
        }, 500);
    });
    $("#btnFood").on("click",function () {
        var result = $("#foodtable tbody tr")
        console.log(result);
        var tableval = result.map(function () {
            return [$(this).children().map(function () {
                return $(this).text().trim()
            }).get()]
        }).get();
        var inputval = result.map(function () {
            return [$(this).children().map(function (){
                return $(this).find("input").get().map(function(input) {

                    return input.value
                })
            }).get()]
        }).get();
        let flag = 0;
        for (let i = 0; i < tableval.length; i++) {
            if(inputval[i][0] == ""){
                flag = 1;
                break
            }
        }
        if(flag == 1){
            alert("所有空格都要填！！");
        }else {
            for (let i = 0; i < tableval.length; i++) {
                tableval[i][3] = inputval[i][0];
            }
            console.log(tableval);
            var json = JSON.stringify(tableval,0,"\t");
            console.log(json);
        }

        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/dailycheck/agree?location=${logLocation}&itemtype=food",
            dataType:"json",

            data: {"items[]":json},


            success:function (data) {
                console.log("succeed");

            },

            error:function () {
            }
        })
        var redirect = "${pageContext.request.contextPath}/dailycheck/toDailyCheck?location=${logLocation}"
        setTimeout(function(){
            location.href = redirect
        }, 500);
    });
    $("#btnSmallTool").on("click",function () {
        var result = $("#smalltooltable tbody tr")
        console.log(result);
        var tableval = result.map(function () {
            return [$(this).children().map(function () {
                return $(this).text().trim()
            }).get()]
        }).get();
        var inputval = result.map(function () {
            return [$(this).children().map(function (){
                return $(this).find("input").get().map(function(input) {

                    return input.value
                })
            }).get()]
        }).get();
        let flag = 0;
        for (let i = 0; i < tableval.length; i++) {
            if(inputval[i][0] == ""){
                flag = 1;
                break
            }
        }
        if(flag == 1){
            alert("所有空格都要填！！");
        }else {
            for (let i = 0; i < tableval.length; i++) {
                tableval[i][3] = inputval[i][0];
            }
            console.log(tableval);
            var json = JSON.stringify(tableval,0,"\t");
            console.log(json);
        }

        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/dailycheck/agree?location=${logLocation}&itemtype=smalltool",
            dataType:"json",

            data: {"items[]":json},


            success:function (data) {

            },

            error:function () {
            }
        })
        var redirect = "${pageContext.request.contextPath}/dailycheck/toDailyCheck?location=${logLocation}"
        setTimeout(function(){
            location.href = redirect
        }, 500);
    });
    $("#btnCommercial").on("click",function () {
        var result = $("#commercialtable tbody tr")
        console.log(result);
        var tableval = result.map(function () {
            return [$(this).children().map(function () {
                return $(this).text().trim()
            }).get()]
        }).get();
        var inputval = result.map(function () {
            return [$(this).children().map(function (){
                return $(this).find("input").get().map(function(input) {

                    return input.value
                })
            }).get()]
        }).get();
        let flag = 0;
        for (let i = 0; i < tableval.length; i++) {
            if(inputval[i][0] == ""){
                flag = 1;
                break
            }
        }
        if(flag == 1){
            alert("所有空格都要填！！");
        }else {
            for (let i = 0; i < tableval.length; i++) {
                tableval[i][3] = inputval[i][0];
            }
            console.log(tableval);
            var json = JSON.stringify(tableval,0,"\t");
            console.log(json);
        }

        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/dailycheck/agree?location=${logLocation}&itemtype=commercialthing",
            dataType:"json",

            data: {"items[]":json},


            success:function (data) {
                console.log("succeed");

            },

            error:function () {
            }
        })
        var redirect = "${pageContext.request.contextPath}/dailycheck/toDailyCheck?location=${logLocation}"
        setTimeout(function(){
            location.href = redirect
        }, 500);
    });
    $("#btnOther").on("click",function () {
        var result = $("#othertable tbody tr")
        console.log(result);
        var tableval = result.map(function () {
            return [$(this).children().map(function () {
                return $(this).text().trim()
            }).get()]
        }).get();
        var inputval = result.map(function () {
            return [$(this).children().map(function (){
                return $(this).find("input").get().map(function(input) {

                    return input.value
                })
            }).get()]
        }).get();
        let flag = 0;
        for (let i = 0; i < tableval.length; i++) {
            if(inputval[i][0] == ""){
                flag = 1;
                break
            }
        }
        if(flag == 1){
            alert("所有空格都要填！！");
        }else {
            for (let i = 0; i < tableval.length; i++) {
                tableval[i][3] = inputval[i][0];
            }
            console.log(tableval);
            var json = JSON.stringify(tableval,0,"\t");
            console.log(json);
        }

        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/dailycheck/agree?location=${logLocation}&itemtype=other",
            dataType:"json",

            data: {"items[]":json},


            success:function (data) {
                console.log("succeed");

            },

            error:function () {
            }
        })
        var redirect = "${pageContext.request.contextPath}/dailycheck/toDailyCheck?location=${logLocation}"
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
