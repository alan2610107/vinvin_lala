<%--
  Created by IntelliJ IDEA.
  User: wujilin
  Date: 2021/10/29
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新日誌</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<jsp:include page="navwithSearch.jsp"/>
<div class="container">
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/11/16</h5>
        <ul>
            <li>日盤提示物料過期</li>
            <li>userpage過期物料個數提醒</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/11/15</h5>
        <ul>
            <li>待入庫清單清點完可以寫過期日</li>
            <li>可以直接做過期報廢（如果是報廢原因是過期最好從過期報廢點選），然後會進入報廢審核等待審核</li>
            <li>過期日清單</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/11/11</h5>
        <ul>
            <li>刪除時再確認一次</li>
            <li>日盤跳轉頁面修正</li>
            <li>新增使用者頁面，裡面會總結未完成任務個數並引導執行，依據權限顯示資訊(測試版)</li>
            <li>Bug fix : 待入庫清單權限修正</li>
            <li>水果運單改成水果運單紀錄</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/11/09</h5>
        <ul>
            <li>新增琥珀台</li>
            <li>Bug fix : Setting KafkaDoUpdate redis key for all controller</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/11/07</h5>
        <ul>
            <li>緩存精細控制，提升效能(測試版)</li>
            <li>東莞天安改成东莞总部</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/11/01</h5>
        <ul>
            <li>紀錄模塊新增已完成和未完成的標籤</li>
            <li>修復鸭屎香茶叶的id問題</li>
            <li>Adjust nav bar collapse</li>
            <li>調整工具列順序</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/10/29</h5>
        <ul>
            <li>紀錄模塊向大家開放（但依然有做權限控制）</li>
            <li>紀錄模塊中的調閱可以找出該物品在該倉庫中的所有紀錄</li>
            <li>紀錄模塊中現在新增兩種狀態：審核中、注意收貨</li>
            <li>注意收貨點擊可以直接跳轉待入庫清單</li>
            <li>新增水果運單模塊（測試版）</li>
        </ul>
    </div>

</div>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
        crossorigin="anonymous"></script>
</body>
</html>
