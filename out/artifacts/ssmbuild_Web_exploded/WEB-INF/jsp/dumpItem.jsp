<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wujilin
  Date: 2021/4/1
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>報廢${dumpList.itemName}</title>
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
            <h3>報廢${dumpList.itemName}</h3>
            <br><br>
            <c:if test="${function.equals('apply')}">
                <form action="${pageContext.request.contextPath}/dump/dumpvinItem" method="post">
            </c:if>
            <c:if test="${function.equals('edit')}">
                <form action="${pageContext.request.contextPath}/dump/editdumplist" method="post">
            </c:if>
                <%--出現問題：我們提交了修改SQL請求，但是修改失敗，初次考慮是事務問題，配置完畢依舊失敗！--%>
                <%--看一下SQL語句，能否執行成功：修改未完成--%>
                <%--前端傳遞隱藏域--%>

                <input type="hidden" name="id" value="${dumpList.id}">
                <input type="hidden" name="brand" value="${dumpList.brand}">
                <input type="hidden" name="logid" value="${dumpList.logid}">
                <input type="hidden" name="dumptime" value="${dumpList.dumptime}">
                <input type="hidden" name="location" value="${dumpList.location}">
                <input type="hidden" name="category" value="${dumpList.category}">
                <input type="hidden" name="if_pass" value="${dumpList.if_pass}">
                <input type="hidden" name="if_pass" value="${dumpList.status}">

                <div class="mb-3">
                    <label for="Inputitemname" class="form-label">名稱：</label>
                    <input type="text" class="form-control" id="Inputitemname" name="itemName" value="${dumpList.itemName}" readonly>
                </div>
                <div class="mb-3">
                    <label for="Inputitemnum" class="form-label">報廢數量：</label>
                    <c:if test="${function.equals('apply')}">
                        <input type="number" pattern="\d*" class="form-control" id="Inputitemnum" name="itemCount" value="" min="1" max="${countLimit}" required>
                    </c:if>
                    <c:if test="${function.equals('edit')}">
                        <input type="number" pattern="\d*" class="form-control" id="Inputitemnum" name="itemCount" value="${dumpList.itemCount}" min="1" max="${countLimit}" required>
                    </c:if>
                </div>
                <div class="mb-3">
                    <label for="expiredDate" class="form-label">過期日：</label>
                    <c:if test="${function.equals('apply')}">
                        <input type="date" class="form-control" id="expiredDate" name="expiredDate" value="" required>
                    </c:if>
                    <c:if test="${function.equals('edit')}">
                        <input type="date" class="form-control" id="expiredDate" name="expiredDate" value="${dumpList.expiredDate}" required>
                    </c:if>
                </div>
                <div class="mb-3">
                    <label for="howLong" class="form-label">用了多久：</label>
                    <c:if test="${function.equals('apply')}">
                        <input type="text" class="form-control" id="howLong" name="howLong" value="" required>
                    </c:if>
                    <c:if test="${function.equals('edit')}">
                        <input type="text" class="form-control" id="howLong" name="howLong" value="${dumpList.howLong}" required>
                    </c:if>
                </div>
                <div class="mb-3">
                    <label for="action" class="form-label">報廢方式：</label>
                    <c:if test="${function.equals('apply')}">
                        <select name="action" class="form-select" id="action" aria-label="Default select example" required>
                            <option value="">選擇報廢方式</option>
                            <option value="丟掉">廢棄扔掉</option>
                            <option value="回收到總部">回收到總部</option>
                        </select>
                    </c:if>
                    <c:if test="${function.equals('edit')}">
                        <select name="action" class="form-select" id="action" aria-label="Default select example" required>
                            <c:if test="${dumpList.action.equals('丟掉')}">
                                <option value="">選擇報廢方式</option>
                                <option value="丟掉" selected>廢棄扔掉</option>
                                <option value="回收到總部">回收到總部</option>
                            </c:if>
                            <c:if test="${dumpList.action.equals('回收到總部')}">
                                <option value="">選擇報廢方式</option>
                                <option value="丟掉">廢棄扔掉</option>
                                <option value="回收到總部" selected>回收到總部</option>
                            </c:if>
                        </select>
                    </c:if>
                </div>
                <div class="mb-3">
                    <label for="reason" class="form-label">報廢原因：</label>
                    <c:if test="${function.equals('apply')}">
                        <input type="text" class="form-control" id="reason" name="reason" value="" required>
                    </c:if>
                    <c:if test="${function.equals('edit')}">
                        <input type="text" class="form-control" id="reason" name="reason" value="${dumpList.reason}" required>
                    </c:if>
                </div>
                <div class="mb-3">
                    <label for="Inputitemmemo" class="form-label">描述：</label>
                    <c:if test="${function.equals('apply')}">
                        <input type="text" class="form-control" id="Inputitemmemo" name="memo" value="">
                    </c:if>
                    <c:if test="${function.equals('edit')}">
                        <input type="text" class="form-control" id="Inputitemmemo" name="memo" value="${dumpList.memo}">
                    </c:if>

                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
            <br><br>
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
