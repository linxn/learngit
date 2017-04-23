<%--
  Created by IntelliJ IDEA.
  User: linxn
  Date: 2017/4/19
  Time: 1:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%-- /strutsDemo/login.do strutsDemo是在配置中的路径 --%>
    <form action="/strutsDemo/login.do" method="post">
        user: <input type="text" name="username"><br />
        pwd: <input type="password" name="userpwd"><br/>
        <input type="submit" value="login">
    </form>
</body>
</html>