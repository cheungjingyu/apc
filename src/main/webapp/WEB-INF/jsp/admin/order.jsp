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
								<td class="line_table" align="center" colspan="12"><span
									class="left_bt2">销售订单查询结果信息列表</span></td>
							</tr>
							<tr>
								<td class="line_table" align="center"><span
									class="left_bt2">用户ID</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">真实姓名</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">联系方式</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">家庭住址</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">菜品名称</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">订购数量</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">单价(元)</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">合计(元)</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">订购时间</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">是否派送</span></td>
								<td class="line_table" align="center" colspan="2"><span
									class="left_bt2">确认订单</span></td>
							</tr>
							
							<c:forEach var="order" items="${pageInfo.list}">
							   <tr>
								<td class="line_table" align="center">
									<span class="left_txt">
										<c:out value="${order.userid }"/>
									</span></td>
								<td class="line_table" align="center">
									<span class="left_txt">
										<c:out value="${order.user.realname }"/>
									</span></td>
								
								<td class="line_table" align="center"><span
									class="left_txt">
										<c:out value="${order.user.phone }"/>
									</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">
										<c:out value="${order.user.address }"/>
									</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">
										<c:out value="${order.menu.name }"/>
									</span></td>
									<td class="line_table" align="center"><span
									class="left_txt">
										<c:out value="${order.menusum }"/>
									</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">
									<c:if test="${order.user.type=='1' }">
										<c:out value="${order.menu.price1 }"/>
									</c:if>
									<c:if test="${order.user.type=='0' }">
										<c:out value="${order.menu.price }"/>
									</c:if>
									</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">
									<c:if test="${order.user.type=='1' }">
										<c:out value="${order.menusum*order.menu.price1 }"/>
									</c:if>
									<c:if test="${order.user.type=='0' }">
										<c:out value="${order.menusum*order.menu.price }"/>
									</c:if>
									</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">
										<c:out value="${order.times }"/>
									</span></td>
								<td class="line_table" align="center"><span
									class="left_txt">
										<c:out value="${order.delivery eq 0 ? '否' : '是'}" />
									</span></td>
								
								<c:if test="${order.delivery eq 0 }">
								<td class="line_table" align="center"><a
									href="javascript:void(0);" onclick="ajaxDelete('${pageContext.request.contextPath}/order/orderY.do','id=${order.id}')">确认</a></td>
								<td class="line_table" align="center"><a
									href="javascript:void(0);" onclick="ajaxDelete('${pageContext.request.contextPath}/order/orderN.do','id=${order.id}')">取消</a></td>
								</c:if>
							</tr>
							</c:forEach>
							
							<tr>
								<td class="line_table" align="center" colspan="11" height="20">
									<span class="left_bt2">
									第<c:out value="${pageInfo.pageNum}" />页&nbsp;&nbsp;
									共<c:out value="${pageInfo.pages}" />页
									</span>&nbsp;&nbsp; 
									<c:choose>
										<c:when test="${pageInfo.isFirstPage}">[首页]</c:when>
										<c:otherwise>
											<a href="${pageContext.request.contextPath}/order/list.do?pageNum=1">[首页]</a>
										</c:otherwise>
									</c:choose> 
									<c:choose>
										<c:when test="${pageInfo.isLastPage}">[尾页]</c:when>
										<c:otherwise>
											<a href="${pageContext.request.contextPath}/order/list.do?pageNum=${pageInfo.lastPage }">[尾页]</a>
										</c:otherwise>
									</c:choose> 
									<c:choose>
										<c:when test="${pageInfo.isFirstPage}">[上一页]</c:when>
										<c:otherwise>
											<a href="${pageContext.request.contextPath}/order/list.do?pageNum=${pageInfo.pageNum-1 }">[上一页]</a>
										</c:otherwise>
									</c:choose> 
									<c:choose>
										<c:when test="${pageInfo.isLastPage}">[下一页]</c:when>
										<c:otherwise>
											<a href="${pageContext.request.contextPath}/order/list.do?pageNum=${pageInfo.pageNum+1 }">[下一页]</a>
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