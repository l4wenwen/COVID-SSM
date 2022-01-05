<%--
  Created by IntelliJ IDEA.
  User: Fish_Brother
  Date: 2021-07-02
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="state">
    <jsp:include page="wrapper.jsp" >
        <jsp:param name="bgcolor" value="bgcolor-blue"/>
        <jsp:param name="bgcolor_dark" value="bgcolor-darkblue"/>
        <jsp:param name="title" value="总检测人数"/>
        <jsp:param name="number" value="${requestScope.statistic.totalNum}"/>
        <jsp:param name="url" value="/user/userinfo"/>
    </jsp:include>

    <jsp:include page="wrapper.jsp" >
        <jsp:param name="bgcolor" value="bgcolor-green"/>
        <jsp:param name="bgcolor_dark" value="bgcolor-darkgreen"/>
        <jsp:param name="title" value="已填报人数"/>
        <jsp:param name="number" value="${requestScope.statistic.filledNum}"/>
        <jsp:param name="url" value="/statistic/filled"/>
    </jsp:include>

    <jsp:include page="wrapper.jsp" >
        <jsp:param name="bgcolor" value="bgcolor-red"/>
        <jsp:param name="bgcolor_dark" value="bgcolor-darkred"/>
        <jsp:param name="title" value="今日高危人数"/>
        <jsp:param name="number" value="${requestScope.statistic.highRiskNum}"/>
        <jsp:param name="url" value="/statistic/highrisk"/>
    </jsp:include>

    <jsp:include page="wrapper.jsp" >
        <jsp:param name="bgcolor" value="bgcolor-yellow"/>
        <jsp:param name="bgcolor_dark" value="bgcolor-darkyellow"/>
        <jsp:param name="title" value="今日经过高危地区人数"/>
        <jsp:param name="number" value="${requestScope.statistic.passRiskAreaNum}"/>
        <jsp:param name="url" value="/statistic/riskarea"/>
    </jsp:include>
</div>