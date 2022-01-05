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
        <form action="${pageContext.request.contextPath}/state/request" method="post" class="form-horizontal">
            <fieldset class="check-in-box">
                <!-- Form Name -->
                <legend>疫情打卡</legend>
                <!-- Multiple Radios (inline) -->
                <div class="control-group">
                    <label class="control-label" for="">体温是否异常？</label>
                    <div class="controls">
                        <label class="radio inline" for="isTemperature-0">
                            <input type="radio" name="isTemperature" id="isTemperature-0" value="false" checked required>
                            否
                        </label>
                        <label class="radio inline" for="isTemperature-1">
                            <input type="radio" name="isTemperature" id="isTemperature-1" value="true" required>
                            是
                        </label>
                    </div>
                </div>
                <!-- Multiple Radios (inline) -->
                <div class="control-group">
                    <label class="control-label" for="">是否确诊为新冠？</label>
                    <div class="controls">
                        <label class="radio inline" for="isCovid-0">
                            <input type="radio" name="isCovid" id="isCovid-0" value="false" checked required>
                            否
                        </label>
                        <label class="radio inline" for="isCovid-1">
                            <input type="radio" name="isCovid" id="isCovid-1" value="true" required>
                            是
                        </label>
                    </div>
                </div>
                <!-- Multiple Radios (inline) -->
                <div class="control-group">
                    <label class="control-label" for="">是否疑似为新冠？</label>
                    <div class="controls">
                        <label class="radio inline" for="isLikeCovid-0">
                            <input type="radio" name="isLikeCovid" id="isLikeCovid-0" value="false" checked required>
                            否
                        </label>
                        <label class="radio inline" for="isLikeCovid-1">
                            <input type="radio" name="isLikeCovid" id="isLikeCovid-1" value="true" required>
                            是
                        </label>
                    </div>
                </div>
                <!-- Multiple Radios (inline) -->
                <div class="control-group">
                    <label class="control-label" for="">当前的隔离状态？</label>
                    <div class="controls">
                        <label class="radio inline" for="quarantine-0">
                            <input type="radio" name="quarantine" id="quarantine-0" value="0" checked required>
                            未曾隔离
                        </label>
                        <label class="radio inline" for="quarantine-1">
                            <input type="radio" name="quarantine" id="quarantine-1" value="1" required>
                            曾隔离，已解除
                        </label>
                        <label class="radio inline" for="quarantine-2">
                            <input type="radio" name="quarantine" id="quarantine-2" value="2" required>
                            正在居家隔离
                        </label>
                        <label class="radio inline" for="quarantine-3">
                            <input type="radio" name="quarantine" id="quarantine-3" value="3" required>
                            正在集中隔离
                        </label>
                    </div>
                </div>
                <!-- Multiple Radios (inline) -->
                <div class="control-group">
                    <label class="control-label" for="">本人同住亲友近14天内是否途径或停留疫情中高风险地区？</label>
                    <div class="controls">
                        <label class="radio inline" for="isRecentArea-0">
                            <input type="radio" name="isRecentArea" id="isRecentArea-0" value="false" checked required>
                            否
                        </label>
                        <label class="radio inline" for="isRecentArea-1">
                            <input type="radio" name="isRecentArea" id="isRecentArea-1" value="true" required>
                            是
                        </label>
                    </div>
                </div>
                <!-- Multiple Radios (inline) -->
                <div class="control-group">
                    <label class="control-label" for="">近14天是否曾在国(境)外旅行、居住？</label>
                    <div class="controls">
                        <label class="radio inline" for="isRecentCountry-0">
                            <input type="radio" name="isRecentCountry" id="isRecentCountry-0" value="false" checked required>
                            否
                        </label>
                        <label class="radio inline" for="isRecentCountry-1">
                            <input type="radio" name="isRecentCountry" id="isRecentCountry-1" value="true" required>
                            是
                        </label>
                    </div>
                </div>
                <!-- Multiple Radios (inline) -->
                <div class="control-group">
                    <label class="control-label" for="">近14天是否曾接触过确诊或疑似新冠病例？</label>
                    <div class="controls">
                        <label class="radio inline" for="isRecentPeople-0">
                            <input type="radio" name="isRecentPeople" id="isRecentPeople-0" value="false" checked required>
                            否
                        </label>
                        <label class="radio inline" for="isRecentPeople-1">
                            <input type="radio" name="isRecentPeople" id="isRecentPeople-1" value="true" required>
                            是
                        </label>
                    </div>
                </div>
                <!-- Multiple Radios (inline) -->
                <div class="control-group">
                    <label class="control-label" for="">今日是否有以下相关症状(乏力、干咳 、鼻塞、流涕、咽痛、腹泻)？</label>
                    <div class="controls">
                        <label class="radio inline" for="isSymptom-0">
                            <input type="radio" name="isSymptom" id="isSymptom-0" value="false" checked required>
                            否
                        </label>
                        <label class="radio inline" for="isSymptom-1">
                            <input type="radio" name="isSymptom" id="isSymptom-1" value="true" required>
                            是
                        </label>
                    </div>
                </div>
                <!-- Multiple Radios (inline) -->
                <div class="control-group">
                    <label class="control-label" for="">今日是否存在其他个人健康异常情况？</label>
                    <div class="controls">
                        <label class="radio inline" for="isAbnormal-0">
                            <input type="radio" name="isAbnormal" id="isAbnormal-0" value="false" checked required>
                            否
                        </label>
                        <label class="radio inline" for="isAbnormal-1">
                            <input type="radio" name="isAbnormal" id="isAbnormal-1" value="true" required>
                            是
                        </label>
                    </div>
                </div>
                <!-- Multiple Radios (inline) -->
                <div class="control-group">
                    <label class="control-label" for="">今日健康码颜色？</label>
                    <div class="controls">
                        <label class="radio inline" for="healthCodeType-0">
                            <input type="radio" name="healthCodeType" id="healthCodeType-0" value="0" checked required>
                            绿色
                        </label>
                        <label class="radio inline" for="healthCodeType-1">
                            <input type="radio" name="healthCodeType" id="healthCodeType-1" value="1" required>
                            黄色
                        </label>
                        <label class="radio inline" for="healthCodeType-2">
                            <input type="radio" name="healthCodeType" id="healthCodeType-2" value="2" required>
                            红色
                        </label>
                    </div>
                </div>
                <!-- Multiple Radios (inline) -->
                <div class="control-group">
                    <label class="control-label" for="">今日是否出校？</label>
                    <div class="controls">
                        <label class="radio inline" for="isOutSchool-0">
                            <input type="radio" name="isOutSchool" id="isOutSchool-0" value="false" checked required>
                            否
                        </label>
                        <label class="radio inline" for="isOutSchool-1">
                            <input type="radio" name="isOutSchool" id="isOutSchool-1" value="true" required>
                            是
                        </label>
                    </div>
                </div>
                <!-- Multiple Radios (inline) -->
                <div class="control-group">
                    <label class="control-label" for="">今日是否出城？</label>
                    <div class="controls">
                        <label class="radio inline" for="isOutCity-0">
                            <input type="radio" name="isOutCity" id="isOutCity-0" value="false" checked required>
                            否
                        </label>
                        <label class="radio inline" for="isOutCity-1">
                            <input type="radio" name="isOutCity" id="isOutCity-1" value="true" required>
                            是
                        </label>
                    </div>
                </div>
                <input type="submit" value="提交" class="submit-button">
            </fieldset>
        </form>
    </div>
</div>
</body>

</html>