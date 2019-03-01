<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>头像</td>
        <td>id</td>
        <td>name</td>
        <td>password</td>
    </tr>
    <tr>
            <td><img src="${basePath}${cs.image}"></td>
            <td>${cs.id}</td>
            <td>${cs.name}</td>
            <td>${cs.password}</td>
              </tr>
      
</table>