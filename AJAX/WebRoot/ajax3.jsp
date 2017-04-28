<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ajax3.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
	<script type="text/javascript">
		function ajax(){
			var userText = document.getElementById("username");
			var username = userText.value;
			var xmlHttp = new XMLHttpRequest();
			xmlHttp.open("GET", "<c:url value="/ValidateUserNameServlet"/>?username="+username );
			xmlHttp.send(null);
			xmlHttp.onreadystatechange = function(){
				if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
					var span = document.getElementById("span1");
					if(xmlHttp.responseText == "true"){
						span.innerHTML = "用户名可用";
					}else{
						span.innerHTML = "用户名已被注册";
					}
				}
			}
		}
	</script>  
  <body>
  <form action="" method="post">
  	用户名：<input type="text"id = "username" name="username" onblur="ajax()"><span id="span1"></span><br>
  	<input type="submit" >
  </form>
  </body>
</html>
