<%--
  Created by IntelliJ IDEA.
  User: set
  Date: 2019/2/28 0028
  Time: 下午 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="../static/jquery.min.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="button" value="通过AJAX获取多个Hero对象111" id="sender">

<div id="messageDiv"></div>

<script>
$('#sender').click(function () {
    var url="${pageContext.request.contextPath }/getManyCategory";
    $.post(
        url,
        function (data) {
            console.log(data);
            var categorys=$.parseJSON(data);
            console.log(categorys.length);
            for(i in categorys){
                var old=$("#messageDiv").html();
                var category=categorys[i];
                $("#messageDiv").html(old+"<br>"+category.id+"========"+category.name);
            }
        }
    )
})


</script>
</body>
</html>
