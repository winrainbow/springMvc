<%--
  Created by IntelliJ IDEA.
  User: hanguojing
  Date: 2019/7/3
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>uploadFile</title>
</head>
<body>
<form action="upload1" method="post" enctype="multipart/form-data" style="margin-top: 10px">
    <input type="file" name="upload1" style="margin-bottom: 30px"/><br/>
    <input type="submit" value="传统上传">
</form>
<form action="upload" method="post" enctype="multipart/form-data" style="margin-top: 10px">
    <input type="file" name="upload" style="margin-bottom: 30px"/><br/>
    <input type="submit" value="上传">
</form>
</body>
</html>
