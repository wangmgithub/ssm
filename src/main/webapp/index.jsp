<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'index.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>
<script>
    function tiao(){
        window.location.href="${pageContext.request.contextPath }/jsp/regist.jsp";

    }
    function kan(){
        window.location.href="${pageContext.request.contextPath }/user/listCategory.action";

    }
    function find(){
        window.location.href="${pageContext.request.contextPath }/jsp/find.jsp";

    }

</script>
<body>
<form action="${pageContext.request.contextPath }/user/login.action">
    <table border="1">
        <tr>
            <td>用户名</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td colspan=2">
                <!--     <div class="row cl">
    <div class="formControls col-xs-8 col-xs-offset-3">
         <input id="checks" class="input-text size-L" type="text" value="验证码:" style="width:150px;" />
         <img id="imgVerify" src="" alt="点击更换验证码" /><a href="" rel="nofollow">看不清，换一张</a>
     </div>-->
                <input type="submit" value="登录">
                </div>
                <input type="button" value="查看用户列表" onclick=kan() />
                <input type="button" value="注册" onclick=tiao() />
                <input type="button" value="查询" onclick=find() />
            </td>
        </tr>
    </table>
</form>
</body>
<script>


    //对应后台的提示
    if('${result}' != ''){
        if('${result}'==0)
            alert('账号密码有误!')
        if('${result}'==1)
            alert('密码错误!')

        if ('${result}' != 2) {
        } else {
            alert('登录成功,跳转列表界面!!!')
            location.href = '${pageContext.request.contextPath }/user/listCategory.action'
        }
    }
    /*
     $(document.body).ready(function () {
          //首次获取验证码
          $("#imgVerify").attr("src","/user/getVerify?"+Math.random());
      });
      //获取验证码
      function getVerify(){
          var src1=document.getElementById('imgVerify')
          src1.src = "/user/getVerify?"+Math.random();
      }
      //校验验证码
      function checkSum(){
          var html1=document.getElementById('loginingForm');
          var inputStr = $("#checks").val();
          if(inputStr!=null && inputStr!="" && inputStr!="验证码:"){
              inputStr = inputStr.toUpperCase();//将输入的字母全部转换成大写
              html1.action="/user/login?inputStr="+inputStr;//提交表单
          }else{
              alert("验证码不能为空!");
          }
      }
    */

</script>
<a href="${pageContext.request.contextPath}\jsonTest\getOne.jsp">json测试getOneCategory</a>
<br>
<a href="${pageContext.request.contextPath}\jsonTest\getMany.jsp">json测试getManyCategory</a>
<br>
<a href="${pageContext.request.contextPath}\jsonTest\submit.jsp">json测试submit</a>



</html>
