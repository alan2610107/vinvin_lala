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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <style>
        .btn-customize {
            background-color: #b35c44;
        }
        /*thead{*/
        /*    background-color: rgb(187, 205, 197);*/
        /*}*/
        #lookinto{
            padding: 1px;
        }
        .table-customize {
            --bs-table-bg: #b35c44;
            --bs-table-striped-bg: #b35c44;
            --bs-table-striped-color: #000;
            --bs-table-active-bg: #b35c44;
            --bs-table-active-color: #000;
            --bs-table-hover-bg: #b35c44;
            --bs-table-hover-color: #000;
            color: white;
            /*border-color:#b35c44*/
        }
        .table-customize2 {
            --bs-table-bg: #c2ccd0;
            --bs-table-striped-bg: #c2ccd0;
            --bs-table-striped-color: #000;
            --bs-table-active-bg: #c2ccd0;
            --bs-table-active-color: #000;
            --bs-table-hover-bg: #c2ccd0;
            --bs-table-hover-color: #000;
            color: black;

        }
        /*.table>:not(:last-child)>:last-child>* {*/
        /*    border-bottom-color: #b35c44;*/
        /*}*/

        /*tbody{*/
        /*    !*background: linear-gradient(90deg, #bbcdc5 0%, #bbcdc5 calc(100% - .05em), #ccc calc(100% - .05em), #ccc 100%);*!*/
        /*    background-color: #c2ccd0;*/
        /*}*/


        /* Fixed Headers */

        th {
            position: -webkit-sticky;
            position: sticky;
            top: 0;
            z-index: 2;

        }

        th[scope=row] {
            position: -webkit-sticky;
            position: sticky;
            left: 0;
            z-index: 1;
        }

        th[scope=row] {
            vertical-align: top;
            color: white;
            /*background-color: #b35c44;*/
            /*border-color:#b35c44;*/
            /*border-color: rgb(33, 37, 41);*/
            /*background: linear-gradient(90deg, transparent 0%, transparent calc(100% - .05em), #d6d6d6 calc(100% - .05em), #d6d6d6 100%);*/
        }

        th:not([scope=row]):first-child {
            left: 0;
            z-index: 3;
            /*border-color:#b35c44;*/
            /*background: linear-gradient(90deg, #b35c44 0%, #b35c44 calc(100% - .05em), #b35c44 calc(100% - .05em), #b35c44 100%);*/

        }


        /* Scrolling wrapper */

        div[tabindex="0"][aria-labelledby][role="region"] {
            overflow: auto;
        }

        div[tabindex="0"][aria-labelledby][role="region"]:focus {
            box-shadow: 0 0 .5em rgba(0,0,0,.5);
            outline: .1em solid rgba(0,0,0,.1);
        }

        div[tabindex="0"][aria-labelledby][role="region"] table {
            margin: 0;
        }

        div[tabindex="0"][aria-labelledby][role="region"].rowheaders {
            background:
                    linear-gradient(to right, transparent 30%, rgba(255,255,255,0)),
                    linear-gradient(to right, rgba(255,255,255,0), white 70%) 0 100%,
                    radial-gradient(farthest-side at 0% 50%, rgba(0,0,0,0.2), rgba(0,0,0,0)),
                    radial-gradient(farthest-side at 100% 50%, rgba(0,0,0,0.2), rgba(0,0,0,0)) 0 100%;
            background-repeat: no-repeat;
            background-color: #fff;
            background-size: 4em 100%, 4em 100%, 1.4em 100%, 1.4em 100%;
            background-position: 0 0, 100%, 0 0, 100%;
            background-attachment: local, local, scroll, scroll;
        }

        div[tabindex="0"][aria-labelledby][role="region"].colheaders {
            background:
                    linear-gradient(white 30%, rgba(255,255,255,0)),
                    linear-gradient(rgba(255,255,255,0), white 70%) 0 100%,
                    radial-gradient(farthest-side at 50% 0, rgba(0,0,0,.2), rgba(0,0,0,0)),
                    radial-gradient(farthest-side at 50% 100%, rgba(0,0,0,.2), rgba(0,0,0,0)) 0 100%;
            background-repeat: no-repeat;
            background-color: #fff;
            background-size: 100% 4em, 100% 4em, 100% 1.4em, 100% 1.4em;
            background-attachment: local, local, scroll, scroll;
        }

        /* Strictly for making the scrolling happen. */

        th[scope=row] {
            min-width: 40vw;
        }

        @media all and (min-width: 30em) {
            th[scope=row] {
                min-width: 20em;
            }
        }

        /*th[scope=row] + td {*/
        /*    min-width: 10em;*/
        /*}*/

        /*div[tabindex="0"][aria-labelledby][role="region"]:nth-child(3) {*/
        /*    max-height: 18em;*/
        /*}*/

        /*div[tabindex="0"][aria-labelledby][role="region"]:nth-child(7) {*/
        /*    max-height: 15em;*/
        /*    margin: 0 1em;*/
        /*}*/



    </style>
</head>
<body>
<jsp:include page="navwithSearch.jsp"/>

<div class="container-fluid">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <br><br><br>
            <div class="row">
                <div class="col-md-1 column">

                </div>
                <div class="col-md-10 column">
                    <ul class="nav nav-pills justify-content-center">
                        <c:forEach var="userpage" items="${userpageList}"><c:if test="${userLevel == 1000 || userLevel == 1 && userpage.location.equals('shop1')
                             || userLevel == 2 && userpage.location.equals('shop2')
                              || userLevel == 3 && userpage.location.equals('shop3')
                               || userLevel == 4 && userpage.location.equals('shop4')
                                || userLevel == 5 && userpage.location.equals('shop5')
                                 || userLevel == 6 && userpage.location.equals('shop6')
                                  || userLevel == 7 && userpage.location.equals('shop7')}">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">${userpage.realname}</a>
                                <ul class="dropdown-menu">
                                    <c:if test="${userLevel == 1000}">
                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${userpage.notConfirmLink}" target="_blank">審核清單 ${userpage.notConfirmNum}</a></li>
                                    </c:if>
                                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${userpage.notReceiveLink}" target="_blank">待入庫清單 ${userpage.notReceiveNum}</a></li>
                                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${userpage.notDoneLogLink}" target="_blank">詳情</a></li>
                                    <li><hr class="dropdown-divider"></li>
                                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/receive/showExpiredList?location=${userpage.location}" target="_blank">注意過期物料 ${userpage.noticeExpiredCount}</a></li>

                                </ul>
                            </li>



                        </c:if>



                        </c:forEach>

                    </ul>

                    <%--                    <div>--%>
                    <%--                        <div class="btn-group">--%>
                    <%--                            <c:forEach var="userpage" items="${userpageList}">--%>
                    <%--                                <c:if test="${userLevel == 1000 || userLevel == 1 && userpage.location.equals('shop1')--%>
                    <%--                                 || userLevel == 2 && userpage.location.equals('shop2')--%>
                    <%--                                  || userLevel == 3 && userpage.location.equals('shop3')--%>
                    <%--                                   || userLevel == 4 && userpage.location.equals('shop4')--%>
                    <%--                                    || userLevel == 5 && userpage.location.equals('shop5')--%>
                    <%--                                     || userLevel == 6 && userpage.location.equals('shop6')--%>
                    <%--                                      || userLevel == 7 && userpage.location.equals('shop7')}">--%>
                    <%--                                    <div class="btn-group" role="group">--%>
                    <%--                                        <button id="warehouse" type="button" class="btn btn-customize dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false" style="color: white">--%>
                    <%--                                                ${userpage.realname}--%>
                    <%--                                        </button>--%>
                    <%--                                        <ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">--%>
                    <%--                                            <c:if test="${userLevel == 1000}">--%>
                    <%--                                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${userpage.notConfirmLink}" target="_blank">審核清單 ${userpage.notConfirmNum}</a></li>--%>
                    <%--                                            </c:if>--%>
                    <%--                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${userpage.notReceiveLink}" target="_blank">待入庫清單 ${userpage.notReceiveNum}</a></li>--%>
                    <%--                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/${userpage.notDoneLogLink}" target="_blank">詳情</a></li>--%>
                    <%--                                        </ul>--%>
                    <%--                                    </div>--%>
                    <%--                                </c:if>--%>

                    <%--                            </c:forEach>--%>

                    <%--                        </div>--%>




                </div>
                <div class="col-md-1 column">

                </div>

            </div>
        </div>

        <div class="col-md-12 column">
            <br><br>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
        crossorigin="anonymous"></script>
</body>
</html>
