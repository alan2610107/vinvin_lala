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
    <title>編輯${type}</title>
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
            <h3>編輯${type}</h3>
            <br><br>
            <form action="${pageContext.request.contextPath}/invoice/edit?invoiceid=${fruitInvoice.invoiceid}" onsubmit="return doSubmit()" method="post" enctype="multipart/form-data">
<%--                <input type="text" name="invoiceid" value="${fruitInvoice.invoiceid}" hidden>--%>
                <input type="text" name="time" value="${fruitInvoice.time}" hidden>
                <input type="text" name="location" value="${fruitInvoice.location}" hidden>
                <div class="mb-3">
                    <label for="supplier" class="form-label">供應商：</label>
                    <input type="text" class="form-control" id="supplier" name="supplier" value="${fruitInvoice.supplier}" required>
                </div>
                <div class="mb-3">
                    <label for="invoiceTime" class="form-label">下單時間：</label>
                    <input type="date" class="form-control" id="invoiceTime" name="invoiceTime" value="${fruitInvoice.invoiceTime}" required>
                </div>
                <div class="mb-3">
                    <label for="price" class="form-label">價錢：</label>
                    <input type="number" pattern="\d*" step="0.01" class="form-control" id="price" name="price" value="${fruitInvoice.price}" required>
                </div>
                <div class="mb-3">
                    <label for="Inputitemmemo" class="form-label">描述：</label>
                    <input type="text" class="form-control" id="Inputitemmemo" name="memo" value="${fruitInvoice.memo}" required>
                </div>
                <div class="mb-3">
                    <label for="Inputitemfile" class="form-label">更新截圖：</label>
                    <input type="file" class="form-control" id="Inputitemfile" name="file">
                </div>
                <div class="mb-3">
                    <label for="originalfile" class="form-label">原圖：</label>
                    <img class="form-control" src="${pageContext.request.contextPath}${filepath}" id="originalfile">
                </div>



                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
        <div class="col-md-4">

        </div>


    </div>






</div>
<br><br>
<script src="${pageContext.request.contextPath}/js/debounce.js"></script>
<script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"--%>
<%--        integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"--%>
<%--        crossorigin="anonymous"></script>--%>

</body>
</html>
