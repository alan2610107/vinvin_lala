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
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="theme-color" content="#f8f9fa">
    <meta name="apple-mobile-web-app-title" content="vinvinERP">
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"--%>
<%--          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">--%>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<jsp:include page="navwithSearch.jsp"/>
<div class="container">
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/05/14</h5>
        <ul>
            <li>顯示物料圖片</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/05/11</h5>
        <ul>
            <li>新增深圳光明富森</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/05/09</h5>
        <ul>
            <li>Fix : 刪除一個倉的物料會刪除所有倉的該物料的問題（緩存問題）</li>
            <li>Make code cleaner</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/05/08</h5>
        <ul>
            <li>優化物料按定義排序</li>
            <li>新增調整物料順序模塊</li>
            <li>新增刪除物料模塊</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/05/01</h5>
        <ul>
            <li>Fix : 物料按定義排序</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/04/29</h5>
        <ul>
            <li>Fix : 新增庫存物料重複項問題(insert ignore)</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/04/15</h5>
        <ul>
            <li>Fix : 自己轉移給自己的問題</li>
            <li>Fix : 查詢庫存時id可能為空的問題</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/04/08</h5>
        <ul>
            <li>加入东莞广发金融和深圳豪方天际到庫存警戒</li>
            <li>深圳豪方天际庫存錄入</li>
            <li>Fix : 下拉選單超過螢幕問題</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/04/01</h5>
        <ul>
            <li>加入防抖機制</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/03/30</h5>
        <ul>
            <li>新增东莞广发金融客如雲</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/03/26</h5>
        <ul>
            <li>新增东莞广发金融</li>
            <li>新增深圳豪方天际</li>
            <li>东莞广发金融庫存錄入</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/03/24</h5>
        <ul>
            <li>簡化新增轉移審核模塊代碼</li>
            <li>Fix : Todo-List數字不精確</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/03/22</h5>
        <ul>
            <li>簡化待入庫清單模塊代碼</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/03/20</h5>
        <ul>
            <li>Spring AOP 分布式鎖</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/03/17</h5>
        <ul>
            <li>Fix : Todo-List數字不精確</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/03/16</h5>
        <ul>
            <li>Fix : 待入庫例外無法顯示問題</li>
            <li>Fix : 物料審核採購無法顯示問題</li>
            <li>Fix : 物料審核採購無法顯示問題</li>
            <li>Fix : Todo-List數字不精確</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/03/14</h5>
        <ul>
            <li>權限控制模塊化</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/03/11</h5>
        <ul>
            <li>系統優化</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/03/09</h5>
        <ul>
            <li>優化庫存頁面的截圖顯示效率</li>
            <li>新增：日盤下載的格式改成Excel格式</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/03/07</h5>
        <ul>
            <li>Fix cache big</li>
            <li>新增：上傳圖片自動壓縮</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/03/06</h5>
        <ul>
            <li>放棄Jedis，改用Lettuce</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/03/04</h5>
        <ul>
            <li>新增物料圖片</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/03/03</h5>
        <ul>
            <li>庫存數量為0停用出庫、轉移、報廢</li>
            <li>庫存不能自己轉移給自己</li>
            <li>優化修正Todo-List數字變負的問題</li>
            <li>加大日盤材料頁面</li>
            <li>審核頁面中文化</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/03/02</h5>
        <ul>
            <li>修正Todo-List數字變負的問題</li>
            <li>待入庫清單中文化</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/02/17</h5>
        <ul>
            <li>物料審核採購上線</li>
            <li>缺區代帳號密碼</li>
            <li>修正空白物料名bug(CK重複建物料的問題)</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/01/04</h5>
        <ul>
            <li>優化庫存警戒處理速度</li>
            <li>優化水果運單頁面</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/01/03</h5>
        <ul>
            <li>日盤結果模塊高併發</li>
            <li>倉庫名緩存</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/12/29</h5>
        <ul>
            <li>修正登入可能會跳出錯誤的問題</li>
            <li>水果運單改版：新增欄位和權限</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/12/29</h5>
        <ul>
            <li>修改名稱後會消除別的系統的緩存</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/12/28</h5>
        <ul>
            <li>上線新的數據庫架構，有問題回報</li>
            <li>修正改名字沒反應的問題</li>
            <li>修正改名字列表分類</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/12/24</h5>
        <ul>
            <li>調整數據庫結構發現Ck建了一堆重複item，修改中，影響部分item的出入庫和某些門店日盤</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/12/21</h5>
        <ul>
            <li>Item基礎數據表完善且共用</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/12/18</h5>
        <ul>
            <li>修正userpage數字不準確問題</li>
            <li>修正審核和待入庫按到兩次的問題</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/12/06</h5>
        <ul>
            <li>增加安全性：數據處理服務器只能接受特定ip的連線</li>
            <li>kafka放到數據處理服務器</li>
            <li>匯入榮德時代庫存資料</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/12/04</h5>
        <ul>
            <li>上線數據處理服務器</li>
            <li>分布式redis放到數據處理服務器</li>
            <li>MySQL放到數據處理服務器</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/11/25</h5>
        <ul>
            <li>0點,6點,12點,18點執行數據庫備份</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/11/24</h5>
        <ul>
            <li>水果運單新增編輯資料的功能</li>
            <li>暫停功能性更新，準備12月的多服務器規劃及中間件的鑽研</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/11/22</h5>
        <ul>
            <li>新增*总仓*</li>
            <li>新增深圳动漫大厦及帳號</li>
            <li>新增深圳荣德时代及帳號</li>
            <li>新增深圳正中时代及帳號</li>
            <li>Bug fix : 修正vinItem緩存可能為空，造成更新和新增後數據顯示不完整</li>
            <li>Bug fix : Todo list 左上圖標鏈結問題</li>
            <li>系統規劃：<img src="${pageContext.request.contextPath}/picture/vinvinSystem1.jpeg"></li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/11/19</h5>
        <ul>
            <li>調整nav bar，把一些模塊移掉</li>
            <li>放了vinvin icon</li>
            <li>Bug fix : 修正琥珀台入庫沒有實際入庫</li>
            <li>Todo list 數字可能不精確，收集資料中，出事回報一下</li>
        </ul>
    </div>
    <div class="col-md-12 column">
        <br><br>
        <h5>2021/11/17</h5>
        <ul>
            <li>修正過期報廢日期顯示為123問題（123為input default）</li>
            <li>jdk升級到jdk17</li>
            <li>kafka升級到kafka-3.0.0</li>
            <li>tomcat升級到tomcat-9.0.55</li>
        </ul>
    </div>
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
    <div class="col-md-12 column">
        <br><br>
    </div>

</div>

<script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>

<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"--%>
<%--        integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"--%>
<%--        crossorigin="anonymous"></script>--%>
</body>
</html>
