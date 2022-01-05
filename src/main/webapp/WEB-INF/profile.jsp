<%--
  Created by IntelliJ IDEA.
  User: Fish_Brother
  Date: 2021-07-01
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人资料</title>
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
        <jsp:param name="position" value="个人资料"/>
        <jsp:param name="userName" value="${sessionScope.user.userName}"/>
    </jsp:include>
    <div class="context">
        <div class="content">
            <div class="info">
                姓名：${requestScope.userProfile.userName}<br/>
                学号：${requestScope.userProfile.userNum}<br/>
                性别：${requestScope.userProfile.sex}<br/>
                <c:if test="${sessionScope.user.userType != 0}">
                    学院：${requestScope.userProfile.collegeName}<br/>
                </c:if>
                <c:if test="${sessionScope.user.userType == 2}">
                    专业：${requestScope.userProfile.majorName}<br/>
                </c:if>
                类型：${requestScope.userProfile.userType}<br/>
                <form action="${pageContext.request.contextPath}/user/update" method="post" class="info-form-row">
                    手机号码：<input type="text" value="${requestScope.userProfile.telephone}" id="telephone" name="telephone" class="text-box" pattern="^[1][3,4,5,7,8][0-9]{9}$" maxlength="11" required disabled>
                    <button class="submit-button inline-block" id="btn-tel-require" >申请修改</button>
                    <input type="submit" value="提交" class="submit-button inline-block" id="btn-tel" style="display: none"/>
                </form>

                密码：<button id="modal-button" class="submit-button inline-block">修改密码</button>
                <div class="modal">
                    <!-- Modal content -->
                    <div class="modal-content">
                        <div class="modal-header">
                            <span class="close">x</span>
                            <h2>修改密码</h2>
                        </div>
                        <div class="modal-body">
                            <form action="javascript: void(0)" class="info-form">
                                <label>更改密码：<input type="password" id="password" class="text-box" maxlength="20" required/></label><br/>
                                <label>确认密码：<input type="password" id="repassword" class="text-box" maxlength="20" required/></label><br/>
                                <input type="submit" id="changePwd" value="更改密码" class="submit-button"/><br/>
                            </form>
                            <span style="color: red">${requestScope.error}</span>
                        </div>
                        <div class="modal-footer">
                        </div>
                    </div>
                </div>


            </div>
        </div>
    </div>
</div>
<script>
    $("#btn-tel-require").click(
        function () {
            if ($("#telephone").prop("disabled")) {
                $(this).css("display", "none");
                $("#telephone").prop("disabled", false);
                $("#btn-tel").css("display", "block");
                return false;
            }
        }
    );

    $("#changePwd").click(
        function () {
            $.ajax({
                url: "/user/changePassword",
                type: "POST",
                dateType: "json",
                data: {
                    password: $("#password").val(),
                    repassword: $("#repassword").val()
                },
                success: function (res) {
                    if (res.success == true) {
                        alert("修改成功");
                    } else {
                        alert("修改失败");
                    }
                },
                error: function (error) {
                    console.log("error");
                    console.log(error);
                    alert("修改失败");
                },
                complete: function () {
                    $("#password").val("");
                    $("#repassword").val("");
                    $("#hide").css("display", "block");
                }
            });
        }
    );
</script>
</body>
</html>
