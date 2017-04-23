<%--
  Created by IntelliJ IDEA.
  User: Linxn
  Date: 2017/3/27
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<% String user=request.getParameter("username");%>
<h1>欢迎，<%= user%>!</h1>
</body>
</html>
