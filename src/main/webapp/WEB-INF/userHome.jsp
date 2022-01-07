<%--
  Created by IntelliJ IDEA.
  User: sunyin
  Date: 2021/6/30
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>主页</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="template/import.jsp" />
</head>
<body>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:include page="template/navigate.jsp">
    <jsp:param name="type" value="${sessionScope.user.userType}"/>
</jsp:include>
<div class="container">
    <jsp:include page="template/header.jsp" >
        <jsp:param name="position" value="${sessionScope.user.userType == 2 ? '健康码':'主页'}"/>
        <jsp:param name="userName" value="${sessionScope.user.userName}"/>
    </jsp:include>
    <div class="content">
        <c:if test="${sessionScope.user.userType != 2}">
            <jsp:include page="template/state.jsp" />
            <jsp:include page="template/userChart.jsp" />
        </c:if>
        <c:if test="${sessionScope.user.userType == 2}">
            <div class="health-code">
                <div class="health-info">
                    <p>姓名：${sessionScope.user.userName}</p>
                    <p>状态：${requestScope.state == 3 ? '未填写' : (requestScope.state == 1 ? '高危' : '正常')}</p>
                </div>
                <h1><div id="time"></div></h1>
                <div id="qrcode" style="border-color: ${requestScope.state == 3 ? '#777777' : (requestScope.state == 1 ? '#FF4646' : '#83A95C')}"></div>
            </div>
            <script type="text/javascript">
                var qrcode = new QRCode(document.getElementById("qrcode"), {
                    width : 265,
                    height : 265,
                    colorDark : "${requestScope.state == 3 ? "#777777" : (requestScope.state == 1 ? "#FF4646" : "#83A95C")}",
                    colorLight : "#FFF",
                    correctLevel : QRCode.CorrectLevel.H
                });
                qrcode.makeCode("${sessionScope.user.userNum}, ${requestScope.state}, Function not yet perfect.");

                function fix(s) {
                    s = s.toString();
                    while(s.length < 2) s = '0' + s;
                    return s;
                }

                function time(){
                    var date =  new Date();
                    month = date.getMonth() + 1;
                    day = date.getDate();
                    hours = fix(date.getHours());
                    minutes = fix(date.getMinutes());
                    seconds = fix(date.getSeconds());
                    document.getElementById("time").innerHTML = month + "月" + day + "日" + "\t" + hours + ":" + minutes +":" + seconds + "\t";
                };
                time();
                setInterval("time()",1000);
            </script>
        </c:if>
    </div>
</div>
</body>
</html>