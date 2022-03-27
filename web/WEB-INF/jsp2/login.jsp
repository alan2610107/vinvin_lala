<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>書籍登入</title>
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
                    <small>书籍登入</small>
                    <h2 style="float: right">${user.uname}</h2>
                </h1>

            </div>
        </div>

        <div class="col-md-4">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/allBook">書籍1</a>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book2/allBook">書籍2</a>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book3/allBook">書籍3</a>

        </div>





        <div class="col-md-4" style="position: absolute;left: 50%;right: 50%;margin-top:200px;margin-left: -230px">
            <form action="${pageContext.request.contextPath }/login" method="post">
                <div class="form-group">
                    <label>用户名</label>
                    <input type="text" class="form-control" name="uname" placeholder="請輸入用户名">
                </div>
                <div class="form-group">
                    <label>密碼</label>
                    <input type="password" class="form-control" name="upwd" placeholder="密碼">
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
                <label style="color: red">${msg}</label>
            </form>

        </div>



</div>
</div>

</body>
</html>
