<%--
  Created by IntelliJ IDEA.
  User: set
  Date: 2019/2/28 0028
  Time: 下午 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="../static/jquery.min.js"></script>
<html>

<head>
    <title>Title</title>
</head>
<body>
<input type="button" value="通过AJAX获取一个Hero对象---" id="sender">

<div id="messageDiv"></div>

<script>
    $('#sender').click(function(){
        var url="${pageContext.request.contextPath }/getOneCategory";
        $.post(
            url,
            function(data) {
                var json=JSON.parse(data);
                var name =json.category.name;
                var id = json.category.id;
                $("#messageDiv").html("分类id："+ id + "<br>分类名称:" +name );

            });
    });
</script>
</body>
</html>
