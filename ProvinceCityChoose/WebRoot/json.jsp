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
		var province = document.getElementById("province");
		
		
		
		province.onblur = function(){
			var xmlHttp = new XMLHttpRequest();
			xmlHttp.open("POST", "<c:url value="/ProvinceServlet"/>");
			xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			xmlHttp.send(null);
			xmlHttp.onreadystatechange = function(){
				if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
					var provinces = eval("("+xmlHttp.responseText+")");
					for(var i = 0; i < provinces.length;++i){
						var option = document.createElement("option");
						option.value = provinces[i].provinceid;
						var text = document.createTextNode(provinces[i].province);
						option.appendChild(text);
						province.appendChild(option);
					}
				}
			}
		}
		
		province.onchange = function(){
			var city = document.getElementById("city");
			var options = city.getElementsByTagName("option");
			for(var i = 0; i < options.length;++i ){
				city.removeChild(options[i]);
				i--;
			}
			var option = document.createElement("option");
			var text = document.createTextNode("==请选择市==");
			option.appendChild(text);
			city.appendChild(option);
			
			var xmlHttp = new XMLHttpRequest();
	 		xmlHttp.open("POST", "<c:url value="/CityServlet"/>");
			xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	 		xmlHttp.send("province="+this.value);
	 		xmlHttp.onreadystatechange = function(){
	 			if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
	 				var cities = eval("("+xmlHttp.responseText+")");
	 				for(var i = 0; i < cities.length;++i){
	 					var option = document.createElement("option");
	 					option.value = cities[i].cityid;
	 					var text = document.createTextNode(cities[i].city);
	 					option.appendChild(text);
	 					city.appendChild(option);
	 				}
	 			}
	 		}
		}
		
		city.onchange = function(){
			var area = document.getElementById("area");
			var options = area.getElementsByTagName("option");
			for(var i = 0; i < options.length;++i ){
				area.removeChild(options[i]);
				i--;
			}
			var option = document.createElement("option");
			var text = document.createTextNode("==请选择地区==");
			option.appendChild(text);
			area.appendChild(option);
			
			var xmlHttp = new XMLHttpRequest();
	 		xmlHttp.open("POST", "<c:url value="/AreaServlet"/>");
			xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	 		xmlHttp.send("city="+this.value);
	 		xmlHttp.onreadystatechange = function(){
	 			if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
	 				var areas = eval("("+xmlHttp.responseText+")");
	 				for(var i = 0; i < areas.length;++i){
	 					var option = document.createElement("option");
	 					var text = document.createTextNode(areas[i].area);
	 					option.appendChild(text);
	 					area.appendChild(option);
	 				}
	 			}
	 		}
		}
	}
 	
 </script>

<body>
	<h1>省市联动</h1>
	<select id="province">
		<option>==请选择省==</option>
	</select>
	<select id="city">
		<option>==请选择市==</option>
	</select>
	<select id="area">
		<option>==请选择地区==</option>
	</select>
</body>
</html>
