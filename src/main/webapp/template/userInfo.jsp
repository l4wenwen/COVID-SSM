<%--
  Created by IntelliJ IDEA.
  User: Fish_Brother
  Date: 2021-07-02
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="state">
    <jsp:include page="wrapper.jsp" >
        <jsp:param name="bgcolor" value="bgcolor-blue"/>
        <jsp:param name="bgcolor_dark" value="bgcolor-darkblue"/>
        <jsp:param name="title" value="学生总人数"/>
        <jsp:param name="number" value="${requestScope.studentNum}"/>
        <jsp:param name="url" value="/user/userinfo"/>
    </jsp:include>

    <jsp:include page="wrapper.jsp" >
        <jsp:param name="bgcolor" value="bgcolor-green"/>
        <jsp:param name="bgcolor_dark" value="bgcolor-darkgreen"/>
        <jsp:param name="title" value="教师总人数"/>
        <jsp:param name="number" value="${requestScope.teacherNum}"/>
        <jsp:param name="url" value="/user/teacherlist"/>
    </jsp:include>
</div>