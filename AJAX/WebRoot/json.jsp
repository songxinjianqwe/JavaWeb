<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'json.jsp' starting page</title>

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
  	window.onload = function(){
  		var btn = document.getElementById("btn");
  	  	btn.onclick = function(){
  	  		var xmlHttp = new XMLHttpRequest();
  	  		xmlHttp.open("GET", "<c:url value="/JsonServlet"/>");
  	  		xmlHttp.send(null);
  	  		xmlHttp.onreadystatechange = function(){
  	  			if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
  	  				var json = xmlHttp.responseText;
  	  				var user = eval("("+json+")");
  	  				var h1 = document.getElementById("h1");
  	  				h1.innerHTML = user.id+","+user.username;
  	  			}
  	  		}
  	  	}
  	}
  	
  </script>
<body>
	<button id="btn">Click here</button>
	<h1 id="h1"></h1>
</body>
</html>
