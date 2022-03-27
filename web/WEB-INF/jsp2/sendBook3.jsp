<%--
  Created by IntelliJ IDEA.
  User: wujilin
  Date: 2021/4/1
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
                    <small>轉移書籍</small>
                </h1>
            </div>
        </div>

    </div>
    <form action="${pageContext.request.contextPath}/book3/sendBook" method="post">
        <%--出現問題：我們提交了修改SQL請求，但是修改失敗，初次考慮是事務問題，配置完畢依舊失敗！--%>
        <%--看一下SQL語句，能否執行成功：修改未完成--%>
        <%--前端傳遞隱藏域--%>
        <input type="hidden" name="bookID" value="${QBook.bookID}">
        <div class="form-group">
            <label>書籍名稱：</label>
            <input type="text" name="bookName" class="form-control" value="${QBook.bookName}" readonly>
            <select name="Warehouse">
                <option value="">請選擇座標</option>
                <option value="books">books</option>
                <option value="books2">books2</option>
                <option value="books3">books3</option>
            </select>
        </div>
        <div class="form-group">
            <label>書籍數量：</label>
            <input type="text" name="bookCounts" class="form-control" value="" required>
        </div>
        <div class="form-group">
            <label>書籍描述：</label>
            <input type="text" name="detail" class="form-control" value="${QBook.detail}" readonly>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>




</div>

</body>
</html>
