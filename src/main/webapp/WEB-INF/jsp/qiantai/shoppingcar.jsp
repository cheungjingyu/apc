<%@ page language="java" import="java.util.*,java.text.*"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String path = request.getContextPath(); %>
<html>
<head>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>-我的订餐车</title>
<meta content="" name=keywords />
<meta content="" name=description />
<link href="<%=path %>/qiantai/css/common.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/qiantai/css/skin.css" rel="stylesheet" type="text/css" />
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


							<div align="center">
								<table id="table2" class="line_table"
									style="width: 700px; margin: 0; padding: 0" cellSpacing="0"
									cellPadding="0">
									<tbody style="margin: 0; padding: 0">
										<tr>
											<td class="line_table" align="center" colspan="4"><span
												class="left_bt2">我的订餐信息列表</span></td>
										</tr>
										<tr>
											<td class="line_table" align="center" width="40%"><span
												class="left_bt2">菜品名称</span></td>
											<td class="line_table" align="center" width="20%"><span
												class="left_bt2">单价</span></td>
											<td class="line_table" align="center" width="20%"><span
												class="left_bt2">数量</span></td>
											<td class="line_table" align="center" width="20%"><span
												class="left_bt2">&nbsp;&nbsp;</span></td>
										</tr>
										
										<c:set var="countcar" value="0" />
										<c:set var="sumcar" value="0"/>
										<c:forEach var="carItem" items="${sessionScope.cart}">
																		<tr>
																			<td align="center">${carItem.menu.name }</td>
																			<c:if test="${user.type=='1' }">
																				<td align="center">${carItem.menu.price1 }</td>
																			</c:if>
																			<c:if test="${user.type=='0' }">
																				<td align="center">${carItem.menu.price }</td>
																			</c:if>
																			<td align="center">${carItem.menusum }</td>
																			<td align="center"><a href="javascript:void(0);" onclick="ajaxSubmit('<%=path%>/qtcart/delete.do','id=${carItem.menuid}')">取消</a></td>
																		</tr>
																		</c:forEach>

										

										<tr>
											<td class="line_table" align="center" colspan="4"
												valign="center"><a 
																				href="javascript:void(0);"
																				onclick="ajaxSubmitCart('<%=path %>/qtcart/submit.do','<%=path %>/qtorder/myOrder.do')"><img
													src="<%=path %>/qiantai/images/canche_submit.gif" border="0" /></a>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

												<a href="${pageContext.request.contextPath}/shoppingCartServlet?action=delAll"><img
													src="<%=path %>/qiantai/images/quxiao2.gif" border="0" /></a></td>

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
