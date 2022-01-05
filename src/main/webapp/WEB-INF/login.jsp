<%--
  Created by IntelliJ IDEA.
  User: Fish_Brother
  Date: 2021-06-30
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh" dir="ltr">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <title>登陆</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login-style.css">
    <link href="https://cdn.bootcdn.net/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
</head>

<body>
<div class="bg-img">
    <div class="content">
        <header>云战役</header>
        <form action="${pageContext.request.contextPath}/user/login" method="post">
            <div class="field">
                <span class="fa fa-user"></span>
                <input type="text" name="userNum" required placeholder="学号" maxlength="8">
            </div>
            <div class="field space">
                <span class="fa fa-lock"></span>
                <input type="password" name="password" class="pass-key" required placeholder="密码" maxlength="20">
                <span class="show">显示</span>
            </div>
            <div class="pass">
                <a href="#">忘记密码?</a>
                <span style="color: red">${requestScope.error}</span>
            </div>
            <div class="field">
                <input type="submit" value="登录">
            </div>
        </form>
        <div class="login">其他方式登录</div>
        <div class="links">
            <div class="facebook">
                <i class="fab fa-brands fa-weixin"><span>Wechat</span></i>
            </div>
            <div class="instagram">
                <i class="fab fa-brands fa-qq"><span>QQ</span></i>
            </div>
        </div>
        <div class="signup">没有账号？
            <a href="javascript: alert('不开放注册');">注册</a>
        </div>
    </div>
</div>
<script>
    const pass_field = document.querySelector('.pass-key');
    const showBtn = document.querySelector('.show');
    showBtn.addEventListener('click', function () {
        if (pass_field.type === "password") {
            pass_field.type = "text";
            showBtn.textContent = "隐藏";
            showBtn.style.color = "#3498db";
        } else {
            pass_field.type = "password";
            showBtn.textContent = "显示";
            showBtn.style.color = "#222";
        }
    });
</script>
</body>

</html>