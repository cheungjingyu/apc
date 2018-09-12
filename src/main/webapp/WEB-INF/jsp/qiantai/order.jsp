<%@page import="com.hpe.pojo.*"%>
<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/qiantai/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<base href="<%=basePath%>">
<title>我的订单</title>
<meta content="" name=keywords />
<meta content="" name=description />
<link href="<%=path %>/qiantai/css/common.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/qiantai/css/skin.css" rel="stylesheet" type="text/css" />
<script src="<%=path %>/qiantai/js/date.js" type="text/javascript"></script>
</head>

<body style='background: transparent'>
	<table width="900" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td align="left" valign="top"><jsp:include flush="fasle"
					page="top.jsp" /></td>
		</tr>
		<tr>
			<td height="50px"></td>

		</tr>

		<tr>
			<td align="center" valign="top" height="420px">

				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td align="left" valign="top">

							<div align="center" width="120">
								<form action="${pageContext.request.contextPath}/qtorder/myOrder.do" name="form1" method="post">
									<table id="table1" class="line_table"
										style="width: 500px; margin: 0; padding: 0" cellSpacing="0"
										cellPadding="0">
										<tbody style="margin: 0; padding: 0">
											<tr>
												<td class="line_table" align="right" width="40%"><span
													class="left_bt2">按菜品名称查询</span></td>
												<td class="line_table" align="left" width="60%"><input
													type="text" name="menuName" size="20" value="${param.menuName}"> </td>
											<tr>
												<td class="line_table" align="right" width="40%"><span
													class="left_bt2">按销售日期查询</span></td>
												<td class="line_table" align="left" width="60%"><input
													type="text" name="times" size="20" readOnly
													onClick="setDay(this);" value="${param.times }"> <input type="submit"
													value="查询"></td>
											</tr>
											<tr>
												<td class="line_table" align="center" colspan="3">
													<a href="<%=path %>/qtorder/myOrder.do">我的所有订单</a>&nbsp;&nbsp;&nbsp;&nbsp; 
													<a href="<%=path %>/qtorder/myOrder.do?delivery=0">未已派送订单</a>&nbsp;&nbsp;&nbsp;&nbsp;
													<a href="<%=path %>/qtorder/myOrder.do?delivery=1">已派送订单</a>&nbsp;&nbsp;&nbsp;&nbsp;</td>
											</tr>
									</table>
								</form>
							</div>
						</td>
					</tr>
					<tr>
						<td align="left" valign="top" height="20px"></td>
					</tr>
					<tr>
						<td align="left" valign="top">


							<div align="center">
								<table id="table2" class="line_table"
									style="width: 900px; margin: 0; padding: 0" cellSpacing="0"
									cellPadding="0">
									<tbody style="margin: 0; padding: 0">
										<tr>
											<td class="line_table" align="center" colspan="9"><span
												class="left_bt2">订单查询结果信息列表</span></td>
										</tr>
										<tr>
											<td class="line_table" align="center"><span
												class="left_bt2">菜品名称</span></td>
											<td class="line_table" align="center"><span
												class="left_bt2">真实姓名</span></td>
											<td class="line_table" align="center"><span
												class="left_bt2">订购电话</span></td>
											<td class="line_table" align="center"><span
												class="left_bt2">派送地址</span></td>
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
											<a href="${pageContext.request.contextPath}/qtorder/myOrder.do?pageNum=1">[首页]</a>
										</c:otherwise>
									</c:choose> 
									<c:choose>
										<c:when test="${pageInfo.isLastPage}">[尾页]</c:when>
										<c:otherwise>
											<a href="${pageContext.request.contextPath}/qtorder/myOrder.do?pageNum=${pageInfo.lastPage }">[尾页]</a>
										</c:otherwise>
									</c:choose> 
									<c:choose>
										<c:when test="${pageInfo.isFirstPage}">[上一页]</c:when>
										<c:otherwise>
											<a href="${pageContext.request.contextPath}/qtorder/myOrder.do?pageNum=${pageInfo.pageNum-1 }">[上一页]</a>
										</c:otherwise>
									</c:choose> 
									<c:choose>
										<c:when test="${pageInfo.isLastPage}">[下一页]</c:when>
										<c:otherwise>
											<a href="${pageContext.request.contextPath}/qtorder/myOrder.do?pageNum=${pageInfo.pageNum+1 }">[下一页]</a>
										</c:otherwise>
									</c:choose>

								</td>
							</tr>
								</table>
								
								
							</div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td height="10px">&nbsp;</td>
		</tr>
		<tr>
			<td height="50px" align="center" valign="middle"><jsp:include
					flush="fasle" page="copyright.jsp" /></td>
		</tr>
	</table>
</body>
</html>
