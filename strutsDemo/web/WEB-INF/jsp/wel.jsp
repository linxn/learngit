<%--
  Created by IntelliJ IDEA.
  User: linxn
  Date: 2017/4/19
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>wel, <%= request.getAttribute("username").toString()%></h1>
<a HREF="/strutsDemo">返回登录</a>
</body>
</html>
