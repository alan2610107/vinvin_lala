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
    <title>${inorout}${warehouse}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="theme-color" content="#f8f9fa">
    <meta name="apple-mobile-web-app-title" content="vinvinERP">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>
<jsp:include page="navForm.jsp"/>
<br><br><br>
<div class="container">
    <div class="row">
        <div class="col-md-4">

        </div>
        <div class="col-md-4">
            <h3>${vinItem.itemName}${inorout}${warehouse}</h3>
            <br><br>

            <form action="${pageContext.request.contextPath}/${mainWarehouse}/${inputlocaltion}?location=${location}&category=${category}" method="post">
                <%--出現問題：我們提交了修改SQL請求，但是修改失敗，初次考慮是事務問題，配置完畢依舊失敗！--%>
                <%--看一下SQL語句，能否執行成功：修改未完成--%>
                <%--前端傳遞隱藏域--%>
                <input type="hidden" name="id" value="${vinItem.id}">
                <input type="hidden" name="brand" value="${vinItem.brand}">
                <%--                <input type="hidden" name="singlePrice" value="${vinItem.singlePrice}">--%>
                <input type="hidden" name="totalPrice" value="${vinItem.totalPrice}">

                <div class="mb-3">
                    <label for="Inputitemname" class="form-label">名稱：</label>
                    <input type="text" class="form-control" id="Inputitemname" name="itemName" value="${vinItem.itemName}" readonly>
                </div>
                <div class="mb-3">
                    <label for="Inputitemcount" class="form-label">${inorout}數量：</label>
                    <c:if test="${inorout.equals('出庫')}">
                        <input type="number" pattern="\d*" class="form-control" id="Inputitemcount" name="itemCount" value="" min="0" max="${vinItem.itemCount}" required>
                    </c:if>
                    <c:if test="${inorout.equals('入庫')}">
                        <input type="number" pattern="\d*" class="form-control" id="Inputitemcount" name="itemCount" value="" required>
                    </c:if>
                </div>
                <div class="mb-3">
                    <c:if test="${inorout.equals('入庫')}">
                        <label for="singlePrice" class="form-label">${inorout}單價：</label>
                        <input type="number" pattern="\d*" step="0.01" class="form-control" id="singlePrice" name="singlePrice" value="${vinItem.singlePrice}" required>
                    </c:if>
                    <c:if test="${inorout.equals('出庫')}">
                        <input type="hidden" name="singlePrice" value="${vinItem.singlePrice}">
                    </c:if>

                </div>
                <div class="mb-3">
                    <label for="Inputmemo" class="form-label">描述：</label>
                    <c:if test="${userLevel==1000}">
                        <input type="text"  id="Inputmemo" name="memo" class="form-control" value="${vinItem.memo}">
                    </c:if>

                    <c:if test="${userLevel<1000}">
                        <input type="text"  id="Inputmemo" name="memo" class="form-control" value="${vinItem.memo}" readonly>
                    </c:if>


                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>

        </div>
        <div class="col-md-4">

        </div>


    </div>





</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
        crossorigin="anonymous"></script>
</body>
</html>
