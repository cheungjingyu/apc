<%@page import="com.hpe.pojo.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<base href="${pageContext.request.contextPath}/admin/">
<link href="${pageContext.request.contextPath}/admin/images/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
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
									<span class="left_bt2">类别信息列表</span>
								</td>
							</tr>
							<tr>
								<td class="line_table" align="center" width="30%"><span
									class="left_bt2">类别ID</span></td>
								<td class="line_table" align="center" width="30%"><span
									class="left_bt2">类别名称</span></td>
								<td class="line_table" align="center" width="20%"></td>
								<td class="line_table" align="center" width="20%"></td>
							</tr>
							
							<c:forEach items="${typeList}" var="itm">
							<tr>
								<td class="line_table" align="center" width="30%"><span
									class="left_txt">${itm.id}</span></td>
								<td class="line_table" align="center" width="30%"><span
									class="left_txt">${itm.name}</span></td>
								<td class="line_table" align="center" width="20%"><a
									href="${pageContext.request.contextPath}/type/update.do?id=${itm.id}" target="main">修改</a></td>
								<td class="line_table" align="center" width="20%"><a
								href="javascript:void(0);" onclick="ajaxDelete('${pageContext.request.contextPath}/type/delete.do','id=${itm.id}')"
									target="main">删除</a></td>
							</tr>
							</c:forEach>
					</table>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>