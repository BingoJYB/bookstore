<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <% String basePath=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() +
        request.getContextPath() + "/" ; %>
        <base href="<%=basePath%>" />
        <link type="text/css" rel="stylesheet" href="static/css/style.css" />
        <script type="text/javascript" src="static/js/jquery-3.4.1.js"></script>