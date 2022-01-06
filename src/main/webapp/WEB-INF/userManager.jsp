<%--
  Created by IntelliJ IDEA.
  User: Fish_Brother
  Date: 2021-07-02
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <jsp:include page="template/import.jsp" />
</head>
<body>
<%--<c:if test="${requestScope.studentNum == null || requestScope.teacherNum == null}">--%>
<%--    <c:redirect url="/user/userInfo" />--%>
<%--</c:if>--%>
<jsp:include page="template/navigate.jsp">
    <jsp:param name="type" value="${sessionScope.user.userType}"/>
</jsp:include>
<div class="container">
    <jsp:include page="template/header.jsp" >
        <jsp:param name="position" value="用户管理"/>
        <jsp:param name="userName" value="${sessionScope.user.userName}"/>
    </jsp:include>
    <div class="context">
        <div class="content">
            <c:if test="${sessionScope.user.userType == 0}">
                <jsp:include page="template/userInfo.jsp" />
            </c:if>
            <div class="search-area">
                <button id="modal-button" class="submit-button inline-block">添加用户</button>
            </div>
            <div class="modal">
                <!-- Modal content -->
                <div class="modal-content">
                    <div class="modal-header">
                        <span class="close">x</span>
                        <h2>添加用户</h2>
                    </div>
                    <div class="modal-body">
                        <form action="#" method="post" class="info-form">
                            <label>用户学号：<input type="text" name="num" required class="text-box" maxlength="8"/></label>
                            <label>用户姓名：<input type="text" name="name" required class="text-box" maxlength="6"></label>
                            <label>用户性别：<select class="text-box" name="sex" required>
                                <option value="0" >女</option>
                                <option value="1" selected>男</option>
                            </select></label>
                            <label>用户类型：<select class="text-box" name="type" required>
                                <option value="0" selected>管理员</option>
                                <option value="1">老师</option>
                                <option value="2">学生</option>
                            </select></label>
                            <label id="college" style="display: none">
                                所在学院：<select class="text-box" name="college" required>
                                    <option disabled selected>--请选择--</option>
                                </select>
                            </label>
                            <label id="major" style="display: none">
                                所在专业：<select class="text-box" name="major" required>
                                <option disabled selected>--请选择--</option>
                            </select>
                            </label>
                            <button class="submit-button inline-block" id="add">添加</button>
                        </form>
                    </div>
                    <div class="modal-footer">
                    </div>
                </div>
            </div>
            <jsp:include page="template/userChart.jsp" />
        </div>
    </div>
</div>
<script>
    $("[name='type']").change(
        function () {
            let prop = ["none","none"];
            let required = [false, false];
            if ($(this).val() == 1) {
                prop[0] = "block";
                required[0] = true;
            } else if ($(this).val() == 2) {
                prop[0] = "block";
                prop[1] = "block";
                required[0] = true;
                required[1] = true;
            }
            $("#college").css("display", prop[0]);
            $("#major").css("display", prop[1]);
            $("#college").attr("required", required[0]);
            $("#major").attr("required", required[0]);

            $.ajax({
               url: "/statistic/college",
               dataType: "text",
               type: "POST",
               success: function (res) {
                   $("#college .text-box").append(res);
               },
               error: function (error) {
                   console.log(error);
               },
               beforeSend: function () {
                   $("#major .text-box").html("<option disabled selected>--请选择--</option>");
                   $("#college .text-box").html("<option disabled selected>--请选择--</option>");
               }
            });
        }
    );

    $("[name='college']").change(
        function () {
            $.ajax({
               url: "/statistic/major?collegeNum=" + $("#college .text-box").val(),
               dataType: "text",
               type: "POST",
               success: function (res) {
                   $("#major .text-box").append(res);
               },
               error: function (error) {
                   console.log(error);
               },
               beforeSend: function () {
                   $("#major .text-box").html("<option disabled selected>--请选择--</option>");
               }
            });
        }
    );

    $("#add").click(
        function () {
            $.ajax({
                url: "/user/add",
                data: {
                    userNum: $("[name='num']").val(),
                    userName: $("[name='name']").val(),
                    sex: $("[name='sex']").val(),
                    userType: $("[name='type']").val(),
                    collegeNum: $("[name='college']").val(),
                    majorNum: $("[name='major']").val(),
                },
                type: "POST",
                dataType: "text",
                success: function (res) {
                    alert(res)
                    if (res.toString() === "添加成功") {
                        window.location.reload();
                    }
                },
                error: function (error) {
                    alert("网络错误");
                    console.log(error);
                }
            })
            return false;
        }
    );


</script>
</body>
</html>