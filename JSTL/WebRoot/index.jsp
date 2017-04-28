<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  	
  <body>
  	<c:out value="hehehda"></c:out><br>
  	<c:set var="hehe" value="dadada" scope="request"></c:set>
  	<c:out value="${hehe }"></c:out><br>
  	<c:remove var="hehe"/>
  	<c:out value="${hehe }"></c:out><br>
  	<c:url value="/AServlet"></c:url><br>
  	<c:url value="/BServlet">
  		<c:param name="username" value="sxj"></c:param>
  		<c:param name="password" value="pwd"></c:param>
  	</c:url>
  	<br>
  	<c:set var="a" value="0"></c:set>
  	<c:if test="${a == 0 }">
  		<c:out value="a为0"></c:out>
  	</c:if>
  	
  </body>
</html>
