<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>注册</title>

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
		img.src="/Login/VerifyCodeServlet?a="+new Date().getTime();
	}
</script>
<body>
	<%
		String status = (String)request.getAttribute("status");
		if (status == null) {
			status = "";
		}

		String username = "";
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("username")) {
					username = c.getValue();
				}
			}
		}
	%>
	<form action="/Login/LoginServlet" method="post">
		username:<input type="text" name="username" value="<%=username%>"><br>
		verifycode:<input type="text" name="code">
		 <img id="verifyImg" src="/Login/VerifyCodeServlet">
		 <a href="javascript:change()">change</a><%=status%><br> 
		<input type="submit" value="submit">
	</form>
</body>
</html>
