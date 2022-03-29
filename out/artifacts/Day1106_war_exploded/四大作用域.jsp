<%--
  Created by IntelliJ IDEA.
  User: Robin
  Date: 2021-11-09
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    // 存放数据
    pageContext.setAttribute("pageMsg","page域中的数据");
    // request域
    request.setAttribute("requestMsg","request域中的数据");

    // session域中
    request.getSession().setAttribute("sessionMsg","session域中的数据");
    // application域
    application.setAttribute("applicationMsg","application域中的数据");
%>
<jsp:forward page="index.jsp"></jsp:forward>
</body>
</html>
