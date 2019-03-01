<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/5 0005
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件测试</title>

</head>
<body>
<form action="${pageContext.request.contextPath }/user/upload" method="post" enctype="multipart/form-data">
    <input type="text" name="name"/>
    <input type="file" name="file" />
    <input type="submit"/>


</form>

</body>
</html>
