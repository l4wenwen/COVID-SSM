<%--
  Created by IntelliJ IDEA.
  User: sunyin
  Date: 2021/7/1
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>学生打卡记录</title>
    <%@ include file="template/import.jsp" %>
</head>
<%request.setCharacterEncoding("UTF-8");%>
<body>
    <jsp:include page="template/navigate.jsp">
        <jsp:param name="type" value="${sessionScope.user.userType}"/>
    </jsp:include>
    <div class="container">
        <jsp:include page="template/header.jsp" >
            <jsp:param name="position" value="打卡情况"/>
            <jsp:param name="userName" value="${sessionScope.user.userName}"/>
        </jsp:include>
        <div class="content">
            <div class="state">
                    <form action="${pageContext.request.contextPath}/state/list" method="post">
                        <label>开始日期：<input type="date" name="startTime" required class="text-box"/></label>
                        <label>结束日期：<input type="date" name="endTime" required class="text-box"/></label>
                        <input type="submit" value="查询" class="submit-button inline-block">
                    </form>
                <br />
            </div>
            <table class="chart">
                <tr class="title">
                    <th>打卡编号</th>
                    <th>用户编号</th>
                    <th>打卡时间</th>
                    <th>体温异常</th>
                    <th>确诊新冠</th>
                    <th>疑似新冠</th>
                    <th>隔离状态</th>
                    <th>途经疫情中高风险地区</th>
                    <th>近14天国(境)外出行</th>
                    <th>近14天接触新冠病例</th>
                    <th>相关症状</th>
                    <th>健康异常</th>
                    <th>健康码颜色</th>
                    <th>是否出校</th>
                    <th>是否出城</th>
                </tr>

                <c:if test="${not empty requestScope.states}">
                    <c:forEach items="${requestScope.states}" varStatus="i" var="state">
                        <tr>
                            <td>${state.stateNum}</td>
                            <td>${state.userNum}</td>
                            <td>${state.stateTime}</td>
                            <td>${state.temperature == false ? "否" : "是"}</td>
                            <td>${state.covid == false ? "否" : "是"}</td>
                            <td>${state.likeCovid == false ? "否" : "是"}</td>
                            <td>${state.quarantine == 0 ? "未曾隔离" : (state.quarantine == 1 ? "曾隔离，已解除" : (state.quarantine == 2 ? "正在居家隔离" : "正在集中隔离"))}</td>
                            <td>${state.recentArea == false ? "否" : "是"}</td>
                            <td>${state.recentCountry == false ? "否" : "是"}</td>
                            <td>${state.recentPeople == false ? "否" : "是"}</td>
                            <td>${state.symptom == false ? "否" : "是"}</td>
                            <td>${state.abnormal == false ? "否" : "是"}</td>
                            <td>${state.healthCodeType == 0 ? "绿色" : (state.healthCodeType == 1 ? "黄色" : "红色")}</td>
                            <td>${state.outSchool == false ? "否" : "是"}</td>
                            <td>${state.outCity == false ? "否" : "是"}</td>
                        </tr>
                    </c:forEach>
                </c:if>
            </table>
        </div>
    </div>
</body>
</html>
