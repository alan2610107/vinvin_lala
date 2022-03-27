<%--
  Created by IntelliJ IDEA.
  User: wujilin
  Date: 2021/3/31
  Time: 5:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>${warehouseMap[location]}申請物料</title>
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
            <h3>${warehouseMap[location]}申請物料</h3>
            <br><br>
            <form action="${pageContext.request.contextPath}/apply/applyItem" method="post" enctype="multipart/form-data">
                <input type="text" name="location" value="${location}" hidden>
                <input type="text" name="applyTime" value="${applyTime}" hidden>
                <input type="text" name="applyName" value="${applyName}" hidden>
                <input type="text" name="month" value="${month}" hidden>
                <div class="mb-3">
                    <label for="Inputitemname" class="form-label">物料名稱：</label>
                    <input type="text" class="form-control" id="Inputitemname" name="itemName" required>
                </div>
                <div class="mb-3">
                    <label for="count" class="form-label">數量：</label>
                    <input type="number" class="form-control" id="count" name="count" required>
                </div>

                <button type="submit" class="btn btn-primary">申請</button>
            </form>
        </div>
        <div class="col-md-4">

        </div>


    </div>






</div>
<br><br>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
        crossorigin="anonymous"></script>

</body>
</html>
