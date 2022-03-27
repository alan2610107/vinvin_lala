<%--
  Created by IntelliJ IDEA.
  User: wujilin
  Date: 2021/10/13
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${inorout}${warehouse}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
            <h3>修改${vinItem.itemName}的名稱</h3>
            <br><br>

            <form action="${pageContext.request.contextPath}/change/changeItemName" method="post">
                <%--出現問題：我們提交了修改SQL請求，但是修改失敗，初次考慮是事務問題，配置完畢依舊失敗！--%>
                <%--看一下SQL語句，能否執行成功：修改未完成--%>
                <%--前端傳遞隱藏域--%>
                <input type="hidden" name="id" value="${vinItem.id}">

                <div class="mb-3">
                    <label for="Inputitemname" class="form-label">名稱：</label>
                    <input type="text" class="form-control" id="Inputitemname" name="itemName" value="${vinItem.itemName}" required>
                </div>
                <div class="mb-3">
                    <label for="selectCategory" class="form-label">分類：</label>
                    <select name="category" class="form-select" id="selectCategory" aria-label="Default select example" required>
                        <option value="">選擇分類</option>
                        <option value="tool">設備</option>
                        <option value="smalltool">小器具</option>
                        <option value="food">物料</option>
                        <option value="commercial">宣傳物料</option>
                        <option value="other">其他</option>
                    </select>
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
