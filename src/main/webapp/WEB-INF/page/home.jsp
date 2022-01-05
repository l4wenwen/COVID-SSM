<%--
  Created by IntelliJ IDEA.
  User: evenny
  Date: 2022/1/5
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <th>账号</th>
    <th>名字</th>
    <c:forEach var="user" items="${requestScope.userList}">
        <tr>
            <td><c:out value="${user.id}" /></td>
            <td><c:out value="${user.name}" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
