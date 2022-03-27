<%--
  Created by IntelliJ IDEA.
  User: wujilin
  Date: 2021/8/22
  Time: 11:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .btn-customize {
        /*color: white;*/
        background-color: #b35c44;
    }
    .btn-customize2 {
        /*color: white;*/
        background-color: #c2ccd0;
    }
</style>
<nav class="navbar navbar-expand-xxl navbar-light bg-light sticky-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/${mainWarehouse}/${logLocation}">
            VinVIn ERP -- ${warehouse}
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        倉庫
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/warehouse/allItem?location=main1">东莞总部</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/warehouse/allItem?location=main2">深圳自贸中心</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/warehouse/allItem?location=shop1">深圳南山尚美科技</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/warehouse/allItem?location=shop2">深圳罗湖鼎丰</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/warehouse/allItem?location=shop3">深圳罗湖振业</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/warehouse/allItem?location=shop4">东莞南城ucc</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/warehouse/allItem?location=shop5">东莞南城天安</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/warehouse/allItem?location=shop6">东莞南城保利</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/warehouse/allItem?location=shop7">琥珀台</a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        紀錄
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/log/warehouse?location=main1">东莞总部</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/log/warehouse?location=main2">深圳自贸中心</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/log/warehouse?location=shop1">深圳南山尚美科技</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/log/warehouse?location=shop2">深圳罗湖鼎丰</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/log/warehouse?location=shop3">深圳罗湖振业</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/log/warehouse?location=shop4">东莞南城ucc</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/log/warehouse?location=shop5">东莞南城天安</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/log/warehouse?location=shop6">莞南城保利</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/log/warehouse?location=shop7">琥珀台</a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item dropdown">

                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        待入庫清單
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/receive/list?location=main1">东莞总部</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/receive/list?location=main2">深圳自贸中心</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/receive/list?location=shop1">深圳南山尚美科技</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/receive/list?location=shop2">深圳罗湖鼎丰</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/receive/list?location=shop3">深圳罗湖振业</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/receive/list?location=shop4">东莞南城ucc</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/receive/list?location=shop5">东莞南城天安</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/receive/list?location=shop6">东莞南城保利</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/receive/list?location=shop7">琥珀台</a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item dropdown">

                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        待入庫例外
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/receive/error?location=main1">东莞总部</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/receive/error?location=main2">深圳自贸中心</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/receive/error?location=shop1">深圳南山尚美科技</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/receive/error?location=shop2">深圳罗湖鼎丰</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/receive/error?location=shop3">深圳罗湖振业</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/receive/error?location=shop4">东莞南城ucc</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/receive/error?location=shop5">东莞南城天安</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/receive/error?location=shop6">莞南城保利</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/receive/error?location=shop7">琥珀台</a>
                        </li>

                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        審核清單
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/confirm/listnotpass?location=main1">东莞总部</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/confirm/listnotpass?location=main2">深圳自贸中心</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/confirm/listnotpass?location=shop1">深圳南山尚美科技</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/confirm/listnotpass?location=shop2">深圳罗湖鼎丰</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/confirm/listnotpass?location=shop3">深圳罗湖振业</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/confirm/listnotpass?location=shop4">东莞南城ucc</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/confirm/listnotpass?location=shop5">东莞南城天安</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/confirm/listnotpass?location=shop6">莞南城保利</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/confirm/listnotpass?location=shop7">琥珀台</a>
                        </li>

                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        日盤
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/dailycheck/toDailyCheck?location=main1">东莞总部</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/dailycheck/toDailyCheck?location=main2">深圳自贸中心</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/dailycheck/toDailyCheck?location=shop1">深圳南山尚美科技</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/dailycheck/toDailyCheck?location=shop2">深圳罗湖鼎丰</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/dailycheck/toDailyCheck?location=shop3">深圳罗湖振业</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/dailycheck/toDailyCheck?location=shop4">东莞南城ucc</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/dailycheck/toDailyCheck?location=shop5">东莞南城天安</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/dailycheck/toDailyCheck?location=shop6">莞南城保利</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/dailycheck/toDailyCheck?location=shop7">琥珀台</a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        日盤結果
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/dailycheck/result?location=main1">东莞总部</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/dailycheck/result?location=main2">深圳自贸中心</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/dailycheck/result?location=shop1">深圳南山尚美科技</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/dailycheck/result?location=shop2">深圳罗湖鼎丰</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/dailycheck/result?location=shop3">深圳罗湖振业</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/dailycheck/result?location=shop4">东莞南城ucc</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/dailycheck/result?location=shop5">东莞南城天安</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/dailycheck/result?location=shop6">东莞南城保利</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/dailycheck/result?location=shop7">琥珀台</a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        庫存警戒
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/alert/main1">东莞总部</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/alert/main2">深圳自贸中心</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/alert/shop1">深圳南山尚美科技</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/alert/shop2">深圳罗湖鼎丰</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/alert/shop3">深圳罗湖振业</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/alert/shop4">东莞南城ucc</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/alert/shop5">东莞南城天安</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/alert/shop6">东莞南城保利</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/alert/shop7">琥珀台</a>
                        </li>
                    </ul>
                </li>
<%--                <li class="nav-item dropdown">--%>
<%--                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">--%>
<%--                        修改--%>
<%--                    </a>--%>
<%--                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">--%>
<%--                        <li><a class="dropdown-item"--%>
<%--                               href="${pageContext.request.contextPath}/change/showAllItem">修改名稱</a>--%>
<%--                        </li>--%>
<%--                    </ul>--%>
<%--                </li>--%>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        報廢審核
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/dump/showdumplog?location=main1&function=notpass">东莞总部</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/dump/showdumplog?location=main2&function=notpass">深圳自贸中心</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/dump/showdumplog?location=shop1&function=notpass">深圳南山尚美科技</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/dump/showdumplog?location=shop2&function=notpass">深圳罗湖鼎丰</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/dump/showdumplog?location=shop3&function=notpass">深圳罗湖振业</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/dump/showdumplog?location=shop4&function=notpass">东莞南城ucc</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/dump/showdumplog?location=shop5&function=notpass">东莞南城天安</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/dump/showdumplog?location=shop6&function=notpass">东莞南城保利</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/dump/showdumplog?location=shop7&function=notpass">琥珀台</a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        上傳水果運單
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/invoice/toAdd?location=main1">东莞总部</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/invoice/toAdd?location=main2">深圳自贸中心</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/invoice/toAdd?location=shop1">深圳南山尚美科技</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/invoice/toAdd?location=shop2">深圳罗湖鼎丰</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/invoice/toAdd?location=shop3">深圳罗湖振业</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/invoice/toAdd?location=shop4">东莞南城ucc</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/invoice/toAdd?location=shop5">东莞南城天安</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/invoice/toAdd?location=shop6">东莞南城保利</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/invoice/toAdd?location=shop7">琥珀台</a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        水果運單紀錄
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/invoice/show?location=main1">东莞总部</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/invoice/show?location=main2">深圳自贸中心</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/invoice/show?location=shop1">深圳南山尚美科技</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/invoice/show?location=shop2">深圳罗湖鼎丰</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/invoice/show?location=shop3">深圳罗湖振业</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/invoice/show?location=shop4">东莞南城ucc</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/invoice/show?location=shop5">东莞南城天安</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/invoice/show?location=shop6">东莞南城保利</a>
                        </li>
                        <li><a class="dropdown-item"
                               href="${pageContext.request.contextPath}/invoice/show?location=shop7">琥珀台</a>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/change/showAllItem">修改名稱</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/updatedetail">更新日誌</a>
                </li>


<%--                <form class="d-flex" action="${pageContext.request.contextPath}/${mainWarehouse}/querytool"--%>
<%--                      method="post" style="margin-bottom: 0px !important;">--%>

<%--                    <span style="color: #ff0000;font-weight:bold ">${errortool}</span>--%>

<%--                    <input class="form-control me-2" type="search" name="queryItemName" placeholder="請輸入要查詢的名稱"--%>
<%--                           aria-label="請輸入要查詢的設備名稱">--%>

<%--                    <input type="submit" value="查詢" class="btn btn-outline-success">--%>


<%--                </form>--%>


            </ul>

            <span class="navbar-text">
                <a href="${pageContext.request.contextPath }/user/show">${user.uname}</a>
                <a class="btn btn-customize" style="color: white" href="${pageContext.request.contextPath }/logout">退出</a>
            </span>

        </div>
    </div>
</nav>
