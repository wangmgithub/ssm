<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <html>

<table align='center' border='1' cellspacing='0'>
    <tr align="center">
            <th>头像</th>
            <th>id</th>
            <th>Username</th>
            <th>Password</th>
            <th>&nbsp&nbspEdit&nbsp &nbsp </th>
            <th> Delete </th>
    </tr>
    <c:forEach items="${cs}" var="c" varStatus="st">
        <tr>
            <td><img src="${basePath}${c.image}"></td>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.password}</td>
            <td><a href="${pageContext.request.contextPath }/user/edit.action?id=${c.id}">编辑</a></td>
            <td><a href="${pageContext.request.contextPath }/user/delete.action?id=${c.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
<script>
if('${result}' != ''){
if('${result}'==0)
alert('修改成功!');
}
</script>



<div style="width:500px;margin:0px auto;text-align:center">
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <td>id</td>
            <td>name</td>
        </tr>
        <c:forEach items="${cs}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
            </tr>
        </c:forEach>
    </table>
    <div style="text-align:center">
        <a href="?start=0">首  页</a>
        <a href="?start=${page.start-page.count}">上一页</a>
        <a href="?start=${page.start+page.count}">下一页</a>
        <a href="?start=${page.last}">末  页</a>
    </div>
    <div style="text-align:center;margin-top:40px">

        <form method="post" action="addCategory">
            分类名称： <input name="name" value="" type="text"> <br><br>
            <input type="submit" value="增加分类">
        </form>

    </div>
</div>
</html>