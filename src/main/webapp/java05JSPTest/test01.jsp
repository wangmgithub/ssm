
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*"
isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%=new Date().toLocaleString()%>
<c:set var="name" value="${'game'}" scope="request"/>
pageContext.setAttribute("weapon", null);
pageContext.setAttribute("lastwords", "");
pageContext.setAttribute("items", new ArrayList());
%>

<c:if test="${empty weapon}">
    <p>没有装备武器</p>
</c:if>
<c:if test="${empty lastwords}">
    <p>挂了也没有遗言</p>
</c:if>
<c:if test="${empty items}">
    <p>物品栏为空</p>
</c:if>

</body>
</html>
