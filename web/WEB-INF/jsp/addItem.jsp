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
    <title>新增${type}到${warehouse}</title>
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
            <h3>新增${type}到${warehouse}</h3>
            <br><br>
            <form action="${pageContext.request.contextPath}/${mainWarehouse}/${action}?location=${location}&category=${category}" onsubmit="return doSubmit()" method="post" enctype="multipart/form-data">
                <div class="mb-3">
                    <label for="Inputitemname" class="form-label">名稱：</label>
                    <input type="text" class="form-control" id="Inputitemname" name="itemName" required>
                </div>
                <div class="mb-3">
                    <label for="Inputitembrand" class="form-label">品牌：</label>
                    <input type="text" class="form-control" id="Inputitembrand" name="brand" required>
                </div>
                <div class="mb-3">
                    <label for="Inputitemcount" class="form-label">數量：</label>
                    <input type="text" class="form-control" id="Inputitemcount" name="itemCount" required>
                </div>
                <div class="mb-3">
                    <label for="Inputitemsingleprice" class="form-label">單價：</label>
                    <input type="text" class="form-control" id="Inputitemsingleprice" name="singlePrice" required>
                </div>
                <div class="mb-3">
                    <label for="Inputitemtotalprice" class="form-label">總價：</label>
                    <input type="text" class="form-control" id="Inputitemtotalprice" name="totalPrice" required>
                </div>
                <div class="mb-3">
                    <label for="Inputitemmemo" class="form-label">描述：</label>
                    <input type="text" class="form-control" id="Inputitemmemo" name="memo" required>
                </div>
                <div class="mb-3">
                    <label for="Inputitemfile" class="form-label">上傳截圖：</label>
                    <input type="file" class="form-control" id="Inputitemfile" name="file">
                </div>


                <%--                <div class="form-group">--%>
                <%--                    <label>名稱：</label>--%>
                <%--                    <input type="text" name="itemName" class="form-control" required>--%>
                <%--                </div>--%>
                <%--                <div class="form-group">--%>
                <%--                    <label>品牌：</label>--%>
                <%--                    <input type="text" name="brand" class="form-control" required>--%>
                <%--                </div>--%>
                <%--                <div class="form-group">--%>
                <%--                    <label>數量：</label>--%>
                <%--                    <input type="text" name="itemCount" class="form-control" required>--%>
                <%--                </div>--%>
                <%--                <div class="form-group">--%>
                <%--                    <label>單價：</label>--%>
                <%--                    <input type="text" name="singlePrice" class="form-control" required>--%>
                <%--                </div>--%>
                <%--                <div class="form-group">--%>
                <%--                    <label>總價：</label>--%>
                <%--                    <input type="text" name="totalPrice" class="form-control" required>--%>
                <%--                </div>--%>
                <%--                <div class="form-group">--%>
                <%--                    <label>描述：</label>--%>
                <%--                    <input type="text" name="memo" class="form-control" required>--%>
                <%--                </div>--%>
                <%--                <div class="form-group">--%>
                <%--                    <lebel>上傳截圖：</lebel>--%>
                <%--                    <input type="file" name="file">--%>
                <%--                </div>--%>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
        <div class="col-md-4">

        </div>


    </div>






</div>
<br><br>
<script src="${pageContext.request.contextPath}/js/debounce.js"></script>

<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"--%>
<%--        integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"--%>
<%--        crossorigin="anonymous"></script>--%>
<script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>

</body>
</html>
