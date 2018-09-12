<%@page
	import="java.util.*,com.hpe.dao.*,com.hpe.pojo.*,com.hpe.service.*,com.hpe.service.impl.*,java.text.*"%>

<%@page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% String path = request.getContextPath(); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>-ZW私房菜</title>
<meta content="" name=keywords />
<meta content="" name=description />
<link href="<%=path%>/qiantai/css/common.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path%>/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/common.js"></script>
<script type="text/javascript" src="<%=path%>/qiantai/js/form.js"></script>

</head>

<body style='background: transparent'>
	<table width="900" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td align="left" valign="top"><jsp:include flush="fasle"
					page="top.jsp" /></td>
		</tr>
		<tr>
			<td height="30"></td>

		</tr>

		<tr>
			<td align="left" valign="top"><table width="100%" border="0"
					cellspacing="0" cellpadding="0">
					<tr>
						<td width="59%" align="left" valign="top"><c:if
								test="${empty pageInfo}">
							</c:if>
							<div id='pdv_3606' class='pdv_class' title=''
								style='width: 648px; top: 0px; left: 0px; z-index: 12'>
								<div id='spdv_3606' class='pdv_content'
									style='overflow: visible; width: 100%;'>
									<div class="pdv_border"
										style="margin: 0; padding: 0; height: 100%; border: 0px solid; background:;">
										<!-- <div style="height:25px;margin:1px;display:none;background:;">
                <div style="float:left;margin-left:12px;line-height:25px;font-weight:bold;color:"></div>
                <div style="float:right;margin-right:10px;display:none"> <a href="-1" style="line-height:25px;color:">更多</a> </div>
              </div>-->
										<div style="padding: 0px">
											<link href="<%=path %>/qiantai/css/dingcanall.css" rel="stylesheet"
												type="text/css" />
											<div id="dingcanall2">
												<div style="margin-top: 0px; padding: 0px;">
													<div id="mm_01" class="dingcanall_connow">
														<c:forEach items="${pageInfo.list }" var="menu">
															<div
																style="margin-top: 10px; margin-left: 30px; float: left;">
																<table>
																	<tr>
																		<td rowspan="5" class="bookPic"><img
																			src="<%=path%>/${menu.imgpath}" width="160px" height="140px"
																			 /></td>
																		<td><span>菜名:</span></td>
																		<td><span><strong>${menu.name}</strong></span></td>
																	</tr>
																	<tr>
																		<td><span>市场价格:</span></td>
																		<td><span>${menu.price}</span></td>
																	</tr>
																	<tr>
																		<td><span>会员价格:</span></td>
																		<td><span><strong style="color: red;">${menu.price1}</strong></span></td>
																	</tr>
																	<tr>
																		<td><span>配料:</span></td>
																		<td><span>${menu.burden}</span></td>
																	</tr>
																	<tr>
																		<td><span>菜品类型:</span></td>
																		<td><span>${menu.type.name}</span></td>
																	</tr>
																	<tr>
																		<td colspan="2" style="height: 40px;"><a href="javascript:void(0);" onclick="ajaxSubmit('${pageContext.request.contextPath}/qtcart/add.do','id=${menu.id }')">加入餐车</a></td>
																		<td></td>
																	</tr>
																</table>
															</div>
														</c:forEach>
														
														<div style="clear: both;text-align: center;">
															<span class="left_bt2"> 第<c:out
																	value="${pageInfo.pageNum}" />页&nbsp;&nbsp; 共<c:out
																	value="${pageInfo.pages}" />页
															</span>&nbsp;&nbsp;
															<c:choose>
																<c:when test="${pageInfo.isFirstPage}">[首页]</c:when>
																<c:otherwise>
																	<a href="<%=path %>/qiantai/index.do?pageNum=1">[首页]</a>
																</c:otherwise>
															</c:choose>
															<c:choose>
																<c:when test="${pageInfo.isLastPage}">[尾页]</c:when>
																<c:otherwise>
																	<a
																		href="<%=path %>/qiantai/index.do?pageNum=${pageInfo.lastPage }">[尾页]</a>
																</c:otherwise>
															</c:choose>
															<c:choose>
																<c:when test="${pageInfo.isFirstPage}">[上一页]</c:when>
																<c:otherwise>
																	<a
																		href="<%=path %>/qiantai/index.do?pageNum=${pageInfo.pageNum-1 }">[上一页]</a>
																</c:otherwise>
															</c:choose>
															<c:choose>
																<c:when test="${pageInfo.isLastPage}">[下一页]</c:when>
																<c:otherwise>
																	<a
																		href="<%=path %>/qiantai/index.do?pageNum=${pageInfo.pageNum+1 }">[下一页]</a>
																</c:otherwise>
															</c:choose>
														</div>
													</div>
												</div>

											</div>
										</div>

										<div id="dingcanall_bottom_left">&nbsp;</div>
										<div id="dingcanall_bottom_right">&nbsp;</div>
										<input type="hidden" name="picw" id="picw" value="150" /> <input
											type="hidden" name="pich" id="pich" value="140" /> <input
											type="hidden" name="fittype" id="fittype" value="auto" />
									</div>
								</div>
							</div>
							</div></td>
						<td width="41%" align="right" valign="top"><table width="243"
								border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td></td>
								</tr>
								<tr>
									<td valign="top"><div id='pdv_' class='pdv_class'
											title='网站公告'
											style='width: 243px; top: 0px; left: 0px; z-index: 3'>
											<div id='spdv_3603' class='pdv_content'
												style='overflow: hidden; width: 100%; height: 100%'>
												<div class="pdv_border"
													style="border: 0px; height: 100%; padding: 0; margin: 0; background: url(<%=path %>/qiantai/images/left.jpg) repeat-y">
													<div
														style="height: 100%; background: url() right repeat-y">

														<div
															style="height: 43px; background: url(<%=path %>/qiantai/images/bg.jpg) 0px 0px no-repeat">

															<div
																style="float: left; font: bold 16px/43px 'Microsoft YaHei', 'SimSun', Arial, Sans-Serif; text-align: left; padding-left: 50px; color: #feab43;">
																餐厅公告</div>
															<div
																style="float: right; width: 60px; height: 43px; text-align: right; background: url(<%=path %>/qiantai/images/bg.jpg) -840px 0px no-repeat">
																<a href="#"
																	style="font: 12px/43px simsun; color: #505050; margin-right: 12px; display: inline"></a>
															</div>
														</div>
														
														<div style="margin: 0px 3px; padding: 10px;" align="left">
															<link href="<%=path %>/qiantai/css/newslist_time2.css" rel="stylesheet"
																type="text/css" />
															<ul class="newslist_time2">
																<c:forEach begin="0" end="5" step="1"
																	items="${noticeList }" var="notice" varStatus="i">
																	<li class="newslist_time2"><div class="time">${notice.times.substring(0, 10)}</div>
																		<a
																		href="<%=path %>/qtnotice/show.do?id=${notice.id}"
																		class="newslist_time2">${notice.name}</li>

																</c:forEach>
															</ul>
														</div>
													</div>
												</div>
												<div
													style="margin-top: -10px; height: 10px; line-height: 10px; background: url(<%=path %>/qiantai/images/bg.jpg) 0px -220px no-repeat">&nbsp;</div>
												<div
													style="float: right; margin-top: -10px; width: 10px; height: 10px; line-height: 10px; background: url(<%=path %>/qiantai/images/bg.jpg) -890px -220px no-repeat">&nbsp;</div>
											</div>
										</div></td>
								</tr>
								<tr>
									<td height="10">&nbsp;</td>
								</tr>
								<tr>
									<td valign="top">
										<div id='pdv_3614' class='pdv_class' title='我的餐车'
											style='width: 243px; top: 0px; left: 0px; z-index: 2'>
											<div id='spdv_3614' class='pdv_content'
												style='overflow: visible; width: 100%;'>
												<div class="pdv_border"
													style="margin: 0; padding: 0; height: 100%; border: 0px solid; background:;">
													<div
														style="height: 25px; margin: 1px; display: none; background:;">
														<div
															style="float: left; margin-left: 12px; line-height: 25px; font-weight: bold; color:">
															我的餐车</div>
														<div
															style="float: right; margin-right: 10px; display: none">
															<a href="-1" style="line-height: 25px; color:">更多</a>
														</div>
													</div>
													<div style="padding: 0px">
														<link href="<%=path %>/qiantai/css/dingcanche.css" rel="stylesheet"
															type="text/css" />
														<script src="<%=path %>/qiantai/js/dingcansubmit.js" type="text/javascript"></script>
														<div id="dingcanche">
															<div id="dingcanche2">
																<div id="dingcanche_top">
																	<div id="dingcanche_top_left">我的餐车</div>
																	<div id="dingcanche_top_right">&nbsp;</div>
																</div>


																<div id="dcinfo" style="margin: 0px 3px 1px 3px;"></div>
																<table width="100%" border="0" cellspacing="0"
																	style="background: #fef0d3;">
																	<tr>
																		<td align="center">菜单名称</td>
																		<td align="center">单价</td>
																		<td align="center">数量</td>
																		<td align="center"></td>
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
																	
																</table>



																
																<div style="height: 30px; margin: 5px 3px 1px 3px;">
																	<table width="100%" border="0" cellspacing="0">
																		<tr>
																			<td align="center" width="40%"></td>
																			<td align="center" width="40%"><a
																				href="javascript:void(0);"
																				onclick="ajaxSubmitCart('<%=path %>/qtcart/submit.do','<%=path %>/qtorder/myOrder.do')"
																				><img
																					src="<%=path %>/qiantai/images/canche_submit.gif" border="0" /></a></td>
																			<td align="center" width="40%"><a
																				href="javascript:void(0);" onclick="ajaxSubmit('<%=path%>/qtcart/deleteAll.do','')"><img
																					src="<%=path %>/qiantai/images/quxiao2.gif" border="0" /></a></td>
																		</tr>
																	</table>

																</div>
															</div>
														</div>
													</div>
													<div id="dingcanche_bottom_left">&nbsp;</div>
													<div id="dingcanche_bottom_right">&nbsp;</div>
													<input type="hidden" name="modnums_b" id="modnums_b"
														value="" />
													<script type="text/javascript">
														$("div.cpline_d:even")
																.addClass(
																		"cpline_s");
													</script>
												</div>
											</div>
										</div>
										</div>

									</td>
								</tr>
								<tr>
									<td height="10">&nbsp;</td>
								</tr>
								<tr>
									<td valign="top"><div id='pdv_3613' class='pdv_class'
											title='本周菜单'
											style='width: 243px; top: 0px; left: 0px; z-index: 5'>
											<div id='spdv_3613' class='pdv_content'
												style='overflow: hidden; width: 100%; height: 100%'>
												<div class="pdv_border"
													style="margin: 0; padding: 0; height: 100%; border: 0px solid; background:;">
													<div
														style="height: 25px; margin: 1px; display: none; background:;">
														<div
															style="float: left; margin-left: 12px; line-height: 25px; font-weight: bold; color:">
															本周菜单</div>
														<div
															style="float: right; margin-right: 10px; display: none">
															<a href="-1" style="line-height: 25px; color:">更多</a>
														</div>
													</div>
													<div style="padding: 0px">
														<link href="<%=path %>/qiantai/css/dingcanweekmenu.css" rel="stylesheet"
															type="text/css" />
														<div id="dingcanweekmenu">
															<div id="dingcanweekmenu2">
																<div id="dingcanweekmenu_top">
																	<div id="dingcanweekmenu_top_left">销售排行榜</div>
																	<div id="dingcanweekmenu_top_right">&nbsp;</div>
																</div>
																<div style="padding: px;">
																	<div class="dingcanweekmenuinfo" align="left">
																		<link href="<%=path %>/qiantai/css/newslist_time2.css" rel="stylesheet"
																			type="text/css" />
	
																		<c:forEach items="${menuList }" var="menu">
																		<li class="newslist_time2"><div class="time">已销售${menu.sums }次</div>
																			<a href="<%=path %>/qtmenu/show.do?id=${menu.id}" class="newslist_time2">${menu.name }</a></li>
																		</c:forEach>
																	</div>
																</div>
															</div>
														</div>
														<!--<div id="dingcanweekmenu_bottom_left"></div>
                    <div id="dingcanweekmenu_bottom_right">&nbsp;</div>-->
													</div>
												</div>
												<!-- </div>-->
											</div></td>
								</tr>
							</table></td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td height="10">&nbsp;</td>
		</tr>
		<tr>
			<td height="50" align="center" valign="middle"><jsp:include
					flush="fasle" page="copyright.jsp" /></td>
		</tr>

	</table>



</body>
</html>
