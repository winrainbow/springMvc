<%--
  Created by IntelliJ IDEA.
  User: hanguojing
  Date: 2019/7/4
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>list</title>
</head>
<body>
account list
<c:forEach items="${list}" var="account">
    ${account.name}
</c:forEach>
${list}
</body>
</html>
