<%@page import="com.hpe.pojo.*"%>
<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/admin/";
%>
<html>
<head>
<base href="${pageContext.request.contextPath}/admin/">
<link href="${pageContext.request.contextPath}/admin/images/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>

<link href="${pageContext.request.contextPath}/admin/images/common.css" rel="stylesheet" type="text/css" />

<script src="${pageContext.request.contextPath}/admin/js/date.js" type="text/javascript"></script>

<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
-->
</style>
</head>

<body>
	<table width="100%" height="1" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td valign="top" bgcolor="#F7F8F9">
				<div align="center">
					<table id="table2" class="line_table"
						style="width: 100%; margin: 0; padding: 0" cellSpacing="0"
						cellPadding="0">
						<tbody style="margin: 0; padding: 0">
							<tr>
								<td class="line_table" align="center" colspan="8" height="20">
									<span class="left_bt2">本日销售额统计</span>
								</td>
							</tr>
							<tr>
								<td class="line_table" align="center" width="25%"><span
									class="left_bt2">菜品名称</span></td>
								<td class="line_table" align="center" width="25%"><span
									class="left_bt2">订购数量</span></td>
								<td class="line_table" align="center" width="25%"><span
									class="left_bt2">单价</span></td>
								<td class="line_table" align="center" width="25%"><span
									class="left_bt2">合计</span></td>
							</tr>

							<c:set value="0" var="pagesum" />
							
							<c:forEach var="money" items="${pageInfo.list}">
							   <tr>
								<td class="line_table" align="center">
									<span class="left_txt">
										<c:out value="${money.name }"/>
									</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">
										<c:out value="${money.num }"/>
									</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">
									<c:if test="${money.type }">
										<c:out value="${money.price1 }"/>
									</c:if>
									<c:if test="${!money.type }">
										<c:out value="${money.price }"/>
									</c:if>
									</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">
										<c:out value="${money.sum }"/>
										<c:set value="${pagesum+money.sum}" var="pagesum" />
									</span></td>
							</tr>
							</c:forEach>
							
							
							<tr>
								<td class="line_table" align="center" colspan="8"><span
									class="left_bt2">
									本页总额：${pagesum}元 &nbsp;&nbsp;&nbsp;&nbsp;
									本日销售总额：${dayMoney}元
								</span></td>
							</tr>
							
							<tr>
								<td class="line_table" align="center" colspan="11" height="20">
									<span class="left_bt2">
									第<c:out value="${pageInfo.pageNum}" />页&nbsp;&nbsp;
									共<c:out value="${pageInfo.pages}" />页
									</span>&nbsp;&nbsp; 
									<c:choose>
										<c:when test="${pageInfo.isFirstPage}">[首页]</c:when>
										<c:otherwise>
											<a href="${pageContext.request.contextPath}/order/statistic.do?pageNum=1">[首页]</a>
										</c:otherwise>
									</c:choose> 
									<c:choose>
										<c:when test="${pageInfo.isLastPage}">[尾页]</c:when>
										<c:otherwise>
											<a href="${pageContext.request.contextPath}/order/statistic.do?pageNum=${pageInfo.lastPage }">[尾页]</a>
										</c:otherwise>
									</c:choose> 
									<c:choose>
										<c:when test="${pageInfo.isFirstPage}">[上一页]</c:when>
										<c:otherwise>
											<a href="${pageContext.request.contextPath}/order/statistic.do?pageNum=${pageInfo.pageNum-1 }">[上一页]</a>
										</c:otherwise>
									</c:choose> 
									<c:choose>
										<c:when test="${pageInfo.isLastPage}">[下一页]</c:when>
										<c:otherwise>
											<a href="${pageContext.request.contextPath}/order/statistic.do?pageNum=${pageInfo.pageNum+1 }">[下一页]</a>
										</c:otherwise>
									</c:choose>

								</td>
							</tr>
						
					</table>
				</div>

			</td>

		</tr>
	</table>
</body>
</html>
