<%--
  Created by IntelliJ IDEA.
  User: wujilin
  Date: 2021/3/31
  Time: 5:56 PM
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
                    <small>新增小器具到${warehouse}</small>
                </h1>
            </div>
        </div>

    </div>
    <form action="${pageContext.request.contextPath}/${mainWarehouse}/addsmalltool" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label>名稱：</label>
            <input type="text" name="itemName" class="form-control" required>
        </div>
        <div class="form-group">
            <label>品牌：</label>
            <input type="text" name="brand" class="form-control" required>
        </div>
        <div class="form-group">
            <label>數量：</label>
            <input type="text" name="itemCount" class="form-control" required>
        </div>
        <div class="form-group">
            <label>單價：</label>
            <input type="text" name="singlePrice" class="form-control" required>
        </div>
        <div class="form-group">
            <label>總價：</label>
            <input type="text" name="totalPrice" class="form-control" required>
        </div>
        <div class="form-group">
            <label>描述：</label>
            <input type="text" name="memo" class="form-control" required>
        </div>
        <div class="form-group">
            <lebel>上傳截圖：</lebel>
            <input type="file" name="file">
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>




</div>

</body>
</html>
