<%--
  Created by IntelliJ IDEA.
  User: Fish_Brother
  Date: 2021-07-02
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="search-warpper">
    <div class="search-form">
        <input type="text" class="search-data" placeholder="Search" name="userName"/>
        <button type="submit" class="btn fas fa-search">
            <span style="display: none" class="url">/user/search</span>
        </button>
    </div>
    <div class="loader"><i class="fa fa-spinner fa-spin"></i></div>
</div>