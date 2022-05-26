<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wujilin
  Date: 2021/4/1
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>轉移${vinItem.itemName}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="theme-color" content="#f8f9fa">
    <meta name="apple-mobile-web-app-title" content="vinvinERP">
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"--%>
<%--          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">--%>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="navForm.jsp"/>
<br><br><br>
<div class="container">

    <div class="row">
        <div class="col-md-4">

        </div>
        <div class="col-md-4">
            <h3>轉移${vinItem.itemName}</h3>
            <br><br>
            <form action="${pageContext.request.contextPath}/${mainWarehouse}/${sendlocation}?location=${location}&category=${category}" onsubmit="return doSubmit()" method="post">
                <%--出現問題：我們提交了修改SQL請求，但是修改失敗，初次考慮是事務問題，配置完畢依舊失敗！--%>
                <%--看一下SQL語句，能否執行成功：修改未完成--%>
                <%--前端傳遞隱藏域--%>
                <input type="hidden" name="id" value="${vinItem.id}">
                <input type="hidden" name="brand" value="${vinItem.brand}">
                <input type="hidden" name="singlePrice" value="${vinItem.singlePrice}">
                <input type="hidden" name="totalPrice" value="${vinItem.totalPrice}">
                <div class="mb-3">
                    <label for="Inputitemname" class="form-label">名稱：</label>
                    <input type="text" class="form-control" id="Inputitemname" name="itemName" value="${vinItem.itemName}" readonly>
                </div>
                <div class="mb-3">
                    <label for="Inputitemnum" class="form-label">數量：</label>
                    <input type="number" pattern="\d*" class="form-control" id="Inputitemnum" name="itemCount" value="" min="1" max="${vinItem.itemCount}" required>
                </div>
                <div class="mb-3">
                    <label for="Sendlocation" class="form-label">轉移到：</label>
                    <select name="Warehouse" class="form-select" id="Sendlocation" aria-label="Default select example" required>
                        <option value="">請選擇座標</option>
                        <c:forEach var="warehouseElement" items="${warehouseMap.keySet()}">
                            <c:if test="${!warehouseElement.equals(location)}">
                                <c:if test="${!warehouseElement.equals('outside') && !warehouseElement.equals('trashcan')}">
                                    <option value="${warehouseElement}">${warehouseMap[warehouseElement]}</option>
                                </c:if>
                            </c:if>

                        </c:forEach>
<%--                        <option value="main0">*总仓*</option>--%>
<%--                        <option value="main1">东莞总部</option>--%>
<%--                        <option value="main2">深圳自贸中心</option>--%>
<%--                        <option value="shop1">深圳南山尚美科技</option>--%>
<%--                        <option value="shop2">深圳罗湖鼎丰</option>--%>
<%--                        <option value="shop3">深圳罗湖振业</option>--%>
<%--                        <option value="shop4">东莞南城ucc</option>--%>
<%--                        <option value="shop5">东莞南城天安</option>--%>
<%--                        <option value="shop6">东莞南城保利</option>--%>
<%--                        <option value="shop7">琥珀台</option>--%>
<%--                        <option value="shop8">深圳动漫大厦</option>--%>
<%--                        <option value="shop9">深圳荣德时代</option>--%>
<%--                        <option value="shop10">深圳正中时代</option>--%>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="Inputitemmemo" class="form-label">描述：</label>
                    <input type="text" class="form-control" id="Inputitemmemo" name="memo" value="${vinItem.memo}" readonly>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
        <div class="col-md-4">

        </div>


    </div>



</div>
<script src="${pageContext.request.contextPath}/js/debounce.js"></script>
<script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"--%>
<%--        integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"--%>
<%--        crossorigin="anonymous"></script>--%>
</body>
</html>
