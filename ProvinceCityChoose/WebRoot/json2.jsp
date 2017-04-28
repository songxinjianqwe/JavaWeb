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
<script type="text/javascript" src="jquery-3.1.1.js"></script>
<script type="text/javascript">
    $(function(){
        $("#province").blur(function(){
            $.post("/ProvinceCityChoose/ProvinceServlet",function(provinces){
                $.each($.parseJSON(provinces),function(i,prov){
                    $("<option>"+prov.province+"</option>").val(prov.provinceid).appendTo("#province");
                });
            });
        });
        $("#province").change(function(){
           $("#city").empty();
           $("#city").append("<option>==请选择市==</option>");
           $.post("/ProvinceCityChoose/CityServlet",{"province":$(this).val()},function(cities){
               $.each($.parseJSON(cities),function(i,c){
                   $("<option>"+c.city+"</option>").val(c.cityid).appendTo("#city");
               });
           });
        });
        $("#city").change(function(){
            $("#area").empty();
            $("#area").append("<option>==请选择地区==</option>");
            $.post("/ProvinceCityChoose/AreaServlet",{"city":$(this).val()},function(areas){
                $.each($.parseJSON(areas),function(i,a){
                    $("<option>"+a.area+"</option>").appendTo("#area");
                });
            });
        });
    });
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
