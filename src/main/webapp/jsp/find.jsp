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
  
 <title>用户查询</title></head><body>	<form action="${pageContext.request.contextPath }/user/find.action">	
 	<table border="1">	
 	
 	<tr>				
 	<td>用户ID</td>
 	<td><input type="text" name="id">
 	</td>
 	</tr>
 	
 	<tr><td><input type="submit" value="查询"></td>			
 	</tr>		
 	</table>	
 	</form></body>


</html>
