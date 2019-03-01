<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/4 0004
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form class="form-horizontal" >
    <label  class="col-sm-2 control-label">用户ID</label>
    <div class="col-sm-10">
        <input type="text" class="form-control" id="user_id" placeholder="请输入用户ID">
    </div>
    <div class="col-sm-offset-2 col-sm-10">
        <button type="button" id="select" class="btn btn-default">查找</button>
    </div>

</form>
<div class="panel-body">
    <h2 class="text-danger text-center">
        <!-- 用来显示查找结果 -->
        <span class="glyphicon" id="select-box"></span>
    </h2>
</div>
<script>
$(function(){
$("#select").click(function() {
$.ajax({
url : "${pageContext.request.contextPath }/user/peopleSelect",
type : "POST",
dataType:"json",
contentType : "application/json;charset=UTF-8",
<!-- 向后端传输的数据 -->
data : JSON.stringify({
id : $("#user_id").val()
}),
success:function(result) {
<!-- 处理后端返回的数据 -->
var message= JSON.stringify(result);
$("#select-box").html("查询成功" + message);
},
error:function(result){
$("#select-box").html("查询失败");
}
});
});
});
</script>
</body>
</html>
