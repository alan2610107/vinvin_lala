<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wujilin
  Date: 2021/3/31
  Time: 12:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>書籍展示</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍列表 —— 显示所有书籍3</small>
                    <h2 style="float: right">${user.uname}</h2>
                </h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 column">
                <a class="btn btn-danger" href="${pageContext.request.contextPath }/logout">退出</a>
                &nbsp;&nbsp;&nbsp;
                <%--toAddBook--%>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book3/toAddBook">新增書籍</a>

                    &nbsp;&nbsp;
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/allBook">書籍1</a>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/book2/allBook">書籍2</a>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/book3/allBook">書籍3</a>
            </div>

            <div class="col-md-8 column">
                <%--查詢書籍--%>
                <form class="form-inline" action="${pageContext.request.contextPath}/book3/queryBook" method="post" style="float: right">
                    <span style="color: #ff0000;font-weight:bold ">${error}</span>
                    <input type="text" name="queryBookName" class="form-control" placeholder="請輸入要查詢的書籍名稱">
                    <input type="submit" value="查詢" class="btn btn-primary">


                </form>
            </div>
        </div>
    </div>



    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th></th>
                    <th>书籍名字</th>
                    <th>书籍编号</th>
                    <th>书籍数量</th>
                    <th>书籍详情</th>
                    <th>操作</th>

                </tr>
                </thead>

                <tbody>
                <c:set var="headCount" value="0"/>
                <c:forEach var="book" items="${list}">
                    <c:set var="headCount" value="${headCount + 1}"/>
                    <tr>
                        <td>${headCount}</td>
                        <td>${book.bookName}</td>
                        <td>${book.bookID}</td>
                        <td>${book.bookCounts}</td>
                        <td>${book.detail}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/book3/toUpdate?id=${book.bookID}">修改</a>
                            &nbsp; | &nbsp;
                            <a href="${pageContext.request.contextPath}/book3/deleteBook/${book.bookID}">刪除</a>
                            &nbsp; |  &nbsp;
                            <a href="${pageContext.request.contextPath}/book3/toInputBook?id=${book.bookID}">入庫</a>
                            &nbsp; |  &nbsp;
                            <a href="${pageContext.request.contextPath}/book3/toSend?id=${book.bookID}">轉移</a>
                        </td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
