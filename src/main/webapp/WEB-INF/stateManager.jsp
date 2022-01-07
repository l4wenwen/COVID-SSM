<%--
  Created by IntelliJ IDEA.
  User: Fish_Brother
  Date: 2021-06-30
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生请假记录</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ include file="template/import.jsp" %>
</head>
<body>
<jsp:include page="template/navigate.jsp">
    <jsp:param name="type" value="${sessionScope.user.userType}"/>
</jsp:include>
<div class="container">
    <jsp:include page="template/header.jsp" >
        <jsp:param name="position" value="风险地区管理"/>
        <jsp:param name="userName" value="${sessionScope.user.userName}"/>
    </jsp:include>
    <div class="content">
        <c:if test="${sessionScope.user.userType == 0}">
            <div class="search-area">
                <button id="modal-button" class="submit-button inline-block">添加地区</button>
            </div>
            <div class="modal">
                <!-- Modal content -->
                <div class="modal-content">
                    <div class="modal-header">
                        <span class="close">x</span>
                        <h2>添加风险地区</h2>
                    </div>
                    <div class="modal-body">
                        <form action="${pageContext.request.contextPath}/state/addArea" method="post" class="info-form">
                            <label>地区名字：<input type="text" name="areaName" required="required" class="text-box" maxlength="20"/></label>
                            <input type="submit" value="提交" class="submit-button inline-block"/>
                        </form>
                    </div>
                    <div class="modal-footer">
                    </div>
                </div>
            </div>

        </c:if>
        <table class="chart">
            <tr class="title">
                <th>编号</th>
                <th>地区名称</th>
                <th>操作</th>
            </tr>

            <c:if test="${not empty requestScope.riskArea}">
                <c:forEach var="area" items="${requestScope.riskArea}" >
                    <tr class="item">
                        <td>${area.areaNum}</td>
                        <td>${area.areaName}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/state/delArea?areaNum=${area.areaNum}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
    </div>
</div>
</body>
</html>
