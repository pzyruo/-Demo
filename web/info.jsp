<%--
  Created by IntelliJ IDEA.
  User: 我的电脑
  Date: 2020/7/7
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
        <%
            String result = (String) request.getAttribute("info");
        %>
        <font style="color: red" size="40px">

            <%=result%>
        </font>
    </center>
</body>
</html>
