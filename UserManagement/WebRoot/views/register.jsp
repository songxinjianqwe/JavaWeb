<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>注册页</title>

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
	function change(){
		var img = document.getElementById("verifyImg");
		img.src="/UserManagement/VerifyCodeServlet?a="+new Date().getTime();
	}
</script>


<body>
	<form action="<c:url value="/RegisterServlet"/>" method="post">
		用户名：<input type="text" name="username"><br> 
		密    码：<input type="password" name="password"><br> 
		验证码：<input type="text" name="verifyCode"> 
		<img id="verifyImg" src="<c:url value="/VerifyCodeServlet"/>"> 
		${requestScope.status}  <br>
		 <a href="javascript:change()">change</a><br>
		<input type="submit" value="submit">
	</form>
</body>
</html>
