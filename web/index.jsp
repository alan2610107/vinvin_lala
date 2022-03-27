<%--
  Created by IntelliJ IDEA.
  User: wujilin
  Date: 2021/3/30
  Time: 11:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首頁</title>
    <style>
      a{
        text-decoration: none;
        color: black;
      }
      h3{
        width: 180px;
        height: 38px;
        margin: 100px auto;
        text-align: center;
        line-height: 38px;
        background-color: cadetblue;
        border-radius: 5px;


      }
    </style>
  </head>
  <body>
  <h3>
    <a href="${pageContext.request.contextPath}/book/allBook">進入書籍頁面</a>
  </h3>
  </body>
</html>
