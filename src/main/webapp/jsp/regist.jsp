<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'regist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
 <title>用户注册</title></head><body>	
 <form action="${pageContext.request.contextPath }/user/add.action" method="post" enctype="multipart/form-data">	
 	<table border="1">	
 	
 	<tr>				
 	<td>用户名</td>
 	<td><input type="text" name="name">
 	</td>
 	</tr>
 	<tr>
 	<td>密码</td>
 	<td><input type="text" name="password"></td>			
 	</tr>	
 	<tr>
		<td><input type="submit" value="注册"></td>
 	</tr>	
 		<tr>
 		<td colspan="2">
			<label>上传头像：</label><input type="file" name="file">
		</td>
 		</tr>
		<tr>
		</tr>

 	</table>
 	</form>
 	</body>

<script>
//对应后台的提示
if('${result}' != ''){
if('${result}'==1){
alert('注册成功,将跳转登录界面!')
location.href='index.jsp'
}
if('${result}'==0){
alert('未知错误,注册失败!')
}
if('${result}'==2){
alert('该账号已有人注册!')
}
}



</script>




</html>
