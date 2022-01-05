<%--
  Created by IntelliJ IDEA.
  User: Fish_Brother
  Date: 2021-06-30
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Error</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link href="https://cdn.bootcdn.net/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <style type="text/css">
        body {
            background-color: #EEE;
        }

        .container {
            min-height: 40vh;
            display: flex;
            flex-flow: column nowrap;
            justify-content: center;
            align-items: center;
            letter-spacing: 0.2rem;
        }

        .container h1 {
            font-size: 2.5rem;
            font-weight: 500;
        }

        .search-box {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: #2f3640;
            height: 4rem;
            border-radius: 4rem;
            padding: 1rem;
        }

        .search-text {
            border: none;
            background: none;
            outline: none;
            width: 0;
            padding: 0;
            transition: .4s;
            line-height: 4rem;
            font-size: 1.5rem;
            color: wheat;
        }

        .search-button {
            color: #e94118;
            float: right;
            text-decoration: none;
            width: 4rem;
            height: 4rem;
            border-radius: 50%;
            background-color: #2f3640;
            display: flex;
            justify-content: center;
            align-items: center;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="container" id="watch">
    <h1>出错了！</h1>
</div>
<div class="search-box">
    <input type="text" class="search-text" id="text">
    <a class="search-button" href="javascript: history.back();">
        <li class="fa fa-chevron-left fa-2x"></li>
    </a>
</div>
</body>
</html>