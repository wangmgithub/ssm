<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <body>

 <table align='center' border='1' cellspacing='0' >
    <tr>
        <td>id</td>
        <td>name</td>
        <td>password</td>
    </tr>
    <tr>
            <td >${cs.id}</td>
            <td ><input type="text" id="name" value="${cs.name}"></td>
            <td ><input type="text" id="password" value="${cs.password}"></td>
     </tr>
      
      
</table>
<form action="${pageContext.request.contextPath }/user/update.action"  >
<table align='center' border='1' cellspacing='0' >
           <tr>
           <td>Id</td>	
            <td><input type="text" name="id" value="${cs.id}"></td>
           </tr>
           
                    <tr>
					<td>新用户名</td>				
					<td><input type="text" name="name"></td>			
					</tr>
								
					<tr>				
					<td>新密码</td>				
					<td><input type="text" name="password"></td>			
					</tr>	
              <tr>
              <td><input type="submit" value="确认修改"></td>
              </tr>
</table>
</form>
</body>