<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wujilin
  Date: 2021/3/31
  Time: 12:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>${warehouse}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="theme-color" content="#f8f9fa">
    <meta name="apple-mobile-web-app-title" content="vinvinERP">
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"--%>
<%--          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">--%>
    <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<jsp:include page="navwithSearch.jsp"/>

<div class="container">

    <div class="row clearfix">

        <div class="col-md-12 column">
            <br><br>
            <div class="row">
                <div class="col-md-4 column">
                    <h4>庫存警戒</h4>
                </div>
                <div class="col-md-3 column">

                </div>


            </div>

            <div style="overflow:scroll;height:75vh;">
                <table class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <th></th>
                        <th hidden>编号</th>
                        <th>名字</th>
                        <th>品牌</th>
                        <th>種類</th>
                        <th>数量</th>
                        <th>一週出庫量</th>
                        <th>一月出庫量</th>


                    </tr>
                    </thead>

                    <tbody>
                    <c:set var="headCount" value="0"/>
                    <c:set var="vinItemCountMap" value="${vinItemCountMap}"/>
                    <c:forEach var="vinAlert" items="${vinAlerts}">
                        <c:set var="headCount" value="${headCount + 1}"/>
                        <c:if test="${!vinAlert.equals(null) && vinAlert.ifalert_week.equals(true) && (vinAlert.ifalert_month.equals(true) || vinAlert.ifalert_month.equals(false))}">
                            <tr class="table-danger">
                        </c:if>
                        <c:if test="${!vinAlert.equals(null) && vinAlert.ifalert_week.equals(false) && vinAlert.ifalert_month.equals(true)}">
                            <tr class="table-warning">
                        </c:if>
                        <c:if test="${!vinAlert.equals(null) && vinAlert.ifalert_week.equals(false) && vinAlert.ifalert_month.equals(false) || vinAlert.equals(null)}">
                            <tr>
                        </c:if>


                        <td>${headCount}</td>
                        <td>${vinAlert.itemName}</td>
                        <td>${vinAlert.brand}</td>
                        <td>${vinAlert.category}</td>
                        <td>${vinItemCountMap[vinAlert.id]}</td>
                        <td>${vinAlert.count_week}</td>
                        <td>${vinAlert.count_month}</td>


                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <br><br>
            </div>
        </div>

    </div>
</div>


<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"--%>
<%--        integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"--%>
<%--        crossorigin="anonymous"></script>--%>
<script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
