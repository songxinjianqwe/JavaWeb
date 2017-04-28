<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>客户列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function _change() {
		var select = document.getElementById("select");
		location = "<c:url value='/CustomerServlet?${pageBean.url }'/>&currPageCode=" + select.value;
	}
</script>
</head>

<body>
	<h3 align="center">客户列表</h3>
	<table border="1" width="70%" align="center">
		<tr>
			<th>客户姓名</th>
			<th>性别</th>
			<th>生日</th>
			<th>手机</th>
			<th>邮箱</th>
			<th>描述</th>
			<th>操作</th>
		</tr>

		<%-- 循环遍历所有客户信息　 --%>
		<c:forEach items="${pageBean.datas }" var="customer">
			<tr>
				<td>${customer.cname }</td>
				<td>${customer.gender }</td>
				<td>${customer.birthday }</td>
				<td>${customer.cellphone }</td>
				<td>${customer.email }</td>
				<td>${customer.description }</td>
				<td><a
					href="<c:url value='/CustomerServlet?method=findByID&cid=${customer.cid }'/>">编辑</a>
					<a
					href="<c:url value='/CustomerServlet?method=delete&cid=${customer.cid }'/>">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>




	<p style="text-align: center;">
		第${pageBean.currPageCode }页/共${pageBean.totalPage }页 
		<a href="<c:url value='/CustomerServlet?${pageBean.url }&currPageCode=1'/>">首页</a>
		<c:if test="${pageBean.currPageCode > 1 }">
			<a href="<c:url value='/CustomerServlet?${pageBean.url }&currPageCode=${pageBean.currPageCode-1 }'/>">上一页</a>
		</c:if>

		<%-- 页码列表（显示多少个页码）的长度自己定，这里定为10个 --%>
		<c:choose>
			<%-- 第一条：如果总页数<=10，那么页码列表为1 ~ tp --%>
			<c:when test="${pageBean.totalPage <= 10}">
				<c:set var="begin" value="1" />
				<c:set var="end" value="${pageBean.totalPage }" />
			</c:when>
			<c:otherwise>
				<%-- 第二条：按公式计算，让列表的头为当前页-4；列表的尾为当前页+5 --%>
				<c:set var="begin" value="${pageBean.currPageCode-4 }" />
				<c:set var="end" value="${pageBean.currPageCode+5 }" />

				<%-- 第三条：第二条只适合在中间，而两端会出问题。这里处理begin出界！ --%>
				<%-- 如果begin<1，那么让begin=1，相应end=10 --%>
				<c:if test="${begin<1 }">
					<c:set var="begin" value="1" />
					<c:set var="end" value="10" />
				</c:if>
				<%-- 第四条：处理end出界。如果end>tp，那么让end=tp，相应begin=tp-9 --%>
				<c:if test="${end>pageBean.totalPage }">
					<c:set var="begin" value="${pageBean.totalPage-9 }" />
					<c:set var="end" value="${pageBean.totalPage }" />
				</c:if>
			</c:otherwise>
		</c:choose>
		
		<%-- 循环显示页码列表 --%>
		<c:forEach begin="${begin }" end="${end }" var="i">
			<c:choose>
				<c:when test="${i eq pageBean.currPageCode }">${i }</c:when>
				<c:otherwise>
					<a href="<c:url value='/CustomerServlet?${pageBean.url }&currPageCode=${i}'/>">[${i }]</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>



		<%--显示下一页和尾页 --%>
		<c:if test="${pageBean.currPageCode < pageBean.totalPage }">
			<a href="<c:url value='/CustomerServlet?${pageBean.url }&currPageCode=${pageBean.currPageCode+1 }'/>">下一页</a>
		</c:if>

		<a href="<c:url value='/CustomerServlet?${pageBean.url }&currPageCode=${pageBean.totalPage }'/>">尾页</a>
		
		<%--列表显示可选页码 --%>
		<select name="currPageCode" onchange="_change()" id="select">
			<c:forEach begin="1" end="${pageBean.totalPage }" var="i">
				<option value="${i }"
					<c:if test="${i eq pageBean.currPageCode }">selected="selected"</c:if>>${i }</option>
			</c:forEach>
		</select>
		
	</p>
</body>
</html>
