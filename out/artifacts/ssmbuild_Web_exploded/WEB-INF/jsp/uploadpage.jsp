<%--
  Created by IntelliJ IDEA.
  User: wujilin
  Date: 2021/4/5
  Time: 12:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>UploadCSV</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>
<div class="container">

    <div class="row">
        <div class="col-md-4">

        </div>
        <div class="col-md-4">

            <form action="${pageContext.request.contextPath}/rest/kafka/uploadkafka1321" enctype="multipart/form-data" method="post">

                <div class="mb-3">
                    <label for="Sendlocation" class="form-label">倉庫：</label>
                    <select name="Warehouse" class="form-select" id="Sendlocation" aria-label="Default select example" required>
                        <option value="">請選擇座標</option>
                        <option value="main1">东莞总部</option>
                        <option value="main2">深圳自贸中心</option>
                        <option value="shop1">深圳南山尚美科技</option>
                        <option value="shop2">深圳罗湖鼎丰</option>
                        <option value="shop3">深圳罗湖振业</option>
                        <option value="shop4">东莞南城ucc</option>
                        <option value="shop5">东莞南城天安</option>
                        <option value="shop6">东莞南城保利</option>
                        <option value="shop7">琥珀台</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="Type" class="form-label">種類：</label>
                    <select name="Type" class="form-select" id="Type" aria-label="Default select example" required>
                        <option value="">請選擇種類</option>
                        <option value="tool">設備</option>
                        <option value="smalltool">小器具</option>
                        <option value="food">材料</option>
                        <option value="commercial">宣传物料</option>
                        <option value="other">其他</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="file" class="form-label">描述：</label>
                    <input type="file" class="form-control" name="file" id="file">
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
            <h1>${state}</h1>
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
