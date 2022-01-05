<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="wrapper ${param.bgcolor}">
    <div class="info-box">
        <div class="sub-title">
            <h1>${param.number}</h1>
            ${param.title}
        </div>
    </div>
    <div class="bottom-link ${param.bgcolor_dark}">
        <a href="#" class="btn">
            <span style="display: none" class="url">${param.url}</span>
            More info <i class="fa fa-arrow-right"></i>
        </a>
    </div>
</div>