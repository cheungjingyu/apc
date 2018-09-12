<%@page import="java.util.*"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String path = request.getContextPath(); %>
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
<script type="text/javascript" src="<%=path %>/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/common.js"></script>
<script type="text/javascript">
$(function(){
	
	$('.del').click(function(){
		if(confirm("你确定要删除？"))
	    {
	        return true;
	    }
	    else
	    {
	        return false;
	    }
	})
	
});
</script>
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
								<td class="line_table" align="center" colspan="11" height="20"><span
									class="left_bt2">菜单信息列表</span></td>
							</tr>
							<tr>
								<td class="line_table" align="center"><span
									class="left_bt2">菜单名称</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">展示图片</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">原料</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">类型</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">说明</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">市场价格</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">市场价销售数量</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">会员单价</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">会员价销售数量</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">&nbsp;</span></td>
								<td class="line_table" align="center"><span
									class="left_bt2">&nbsp;</span></td>
							</tr>

							<c:forEach items="${pageInfo.list}" var="menu">
								<tr>
									<td class="line_table" align="center"><span>${menu.name}</span></td>
									<td class="line_table" align="center"><a
										href="${pageContext.request.contextPath}/${menu.imgpath}"><img src="${pageContext.request.contextPath}/${menu.imgpath}"
											width="30" heigth="30"></a></td>
									<td class="line_table" align="center"><span
										class="left_txt">${menu.burden}</span></td>
									<td class="line_table" align="center">
									<span
										class="left_txt">${menu.type.name}</span>
										</td>
									<td class="line_table" align="center"><span
										class="left_txt">${menu.brief}</span></td>
									<td class="line_table" align="center"><span
										class="left_txt">${menu.price}</span></td>
									<td class="line_table" align="center"><span
										class="left_txt">${menu.sums}</span></td>
									<td class="line_table" align="center"><span
										class="left_txt">${menu.price1}</span></td>
									<td class="line_table" align="center"><span
										class="left_txt">${menu.sums1}</span></td>
									<td class="line_table" align="center"><a
										href="<%=path %>/menu/update.do?id=${menu.id}">修改</a></td>
									<td class="line_table" align="center">
									<a href="javascript:void(0);" onclick="ajaxDelete('<%=path%>/menu/delete.do','id=${menu.id}')">删除</a></td>
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
											<a href="${pageContext.request.contextPath}/menu/list.do?pageNum=1">[首页]</a>
										</c:otherwise>
									</c:choose> 
									<c:choose>
										<c:when test="${pageInfo.isLastPage}">[尾页]</c:when>
										<c:otherwise>
											<a href="${pageContext.request.contextPath}/menu/list.do?pageNum=${pageInfo.lastPage }">[尾页]</a>
										</c:otherwise>
									</c:choose> 
									<c:choose>
										<c:when test="${pageInfo.isFirstPage}">[上一页]</c:when>
										<c:otherwise>
											<a href="${pageContext.request.contextPath}/menu/list.do?pageNum=${pageInfo.pageNum-1 }">[上一页]</a>
										</c:otherwise>
									</c:choose> 
									<c:choose>
										<c:when test="${pageInfo.isLastPage}">[下一页]</c:when>
										<c:otherwise>
											<a href="${pageContext.request.contextPath}/menu/list.do?pageNum=${pageInfo.pageNum+1 }">[下一页]</a>
										</c:otherwise>
									</c:choose>

								</td>
							</tr>
					</table>
				</div>
			</td>
		</tr>
	</table>
	<div>
	</div>
</body>
</html>