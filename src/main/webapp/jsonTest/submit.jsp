<%--
  Created by IntelliJ IDEA.
  User: set
  Date: 2019/2/28 0028
  Time: 下午 2:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="../static/jquery.min.js"></script>
<html>
<head>
    <title>用AJAX以JSON方式提交数据</title>
</head>
<body>
<form >
    id：<input type="text" id="id"  /><br/>
    名称：<input type="text" id="name" /><br/>
    <input type="button" value="注册提交" id="sender">
</form>
<div id="messageDiv"></div>

<script>
    $('#sender').click(function(){
        var id=document.getElementById('id').value;
        var name=document.getElementById('name').value;
        var category={"name":name,"id":id};
        var jsonData = JSON.stringify(category);
        var page="${pageContext.request.contextPath }/submitCategory";

        $.ajax({
            type:"post",
            url: page,
            data:jsonData,
            dataType:"json",
            contentType : "application/json;charset=UTF-8",
            success: function(result){
                console.log(result);
                console.log(result.length);
                alert(result.msg);
                 alert("返回结果:"+msg1.msg);
                 $("#messageDiv").html("返回结果："+msg1.msg);
            }
        });
        alert("提交成功，请在Tomcat控制台查看服务端接收到的数据");

    });
</script>
</body>
</html>
