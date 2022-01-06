<%--
  Created by IntelliJ IDEA.
  User: sunyin
  Date: 2021/6/30
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<html>

<head>
    <title>每日打卡</title>
    <%@ include file="template/import.jsp" %>
    <style>
        .check-in-box {
            border: 1px solid #393E46;
            height: 80%;
            padding: 1rem;
            display: flex;
            flex-flow: column;
            justify-content: space-between;
        }

        .controls {
            padding-left: 1rem;
        }

        .control-label {
            font-size: 1.05rem;
            font-weight: 400;
        }
    </style>
</head>
<%request.setCharacterEncoding("UTF-8");%>

<body>
<jsp:include page="template/navigate.jsp">
    <jsp:param name="type" value="${sessionScope.user.userType}" />
</jsp:include>
<div class="container">
    <jsp:include page="template/header.jsp">
        <jsp:param name="position" value="每日打卡" />
        <jsp:param name="userName" value="${sessionScope.user.userName}" />
    </jsp:include>
    <div class="content">
        今日打卡成功！
    </div>
</div>
</body>

</html>