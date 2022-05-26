<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>登入</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="theme-color" content="#f8f9fa">
    <meta name="apple-mobile-web-app-title" content="vinvinERP">
    <!-- 引入 Bootstrap -->
    <%--    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"--%>
<%--          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">--%>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="navLogin.jsp"/>

<div class="container" valign="center">
    <div class="row clearfix">
        <div class="col-md-4">

        </div>

        <%--        <div class="col-md-offset-4 col-md-4" style="position:absolute; height:210px;--%>
        <%--    top:0; bottom:0; left:0; right:0; margin:auto;">--%>
        <div class="col-md-offset-4 col-md-4">
            <br><br><br>
            <form action="${pageContext.request.contextPath}/login" onsubmit="return doSubmit()" method="post">
                <div class="mb-3">
                    <label for="InputAccount" class="form-label">用户名</label>
                    <input type="text" name="uname" class="form-control" id="InputAccount">
                </div>
                <div class="mb-3">
                    <label for="InputPassword" class="form-label">密碼</label>
                    <input type="password" name="upwd" class="form-control" id="InputPassword">
                </div>

                <button type="submit" class="btn btn-primary">登入</button>
                <label style="color: red">${msg}</label>
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
