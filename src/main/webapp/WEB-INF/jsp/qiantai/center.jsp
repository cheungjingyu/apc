<%@ page language="java" import="java.util.*,java.text.*"
	pageEncoding="utf-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/qiantai/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户中心</title>
<meta content="" name=keywords />
<meta content="" name=description />
<link href="<%=path %>/qiantai/css/common.css" rel="stylesheet" type="text/css" />

</head>



<script language="JavaScript">
	function check11(form, isReloadParent,url) {

		if (document.form1.name.value == "") {
			alert("用户名不能为空!");
			document.form1.name.focus();
			return false;
		}
		if (document.form1.realname.value == "") {
			alert("真实姓名不能为空!");
			document.form1.realname.focus();
			return false;
		}
		if (document.form1.age.value == "") {
			alert("年龄不能为空!");
			document.form1.age.focus();
			return false;
		}
		if (document.form1.card.value == "") {
			alert("身份证不能为空!");
			document.form1.card.focus();
			return false;
		}
		if (document.form1.address.value == "") {
			alert("家庭住址不能为空!");
			document.form1.address.focus();
			return false;
		}
		if (document.form1.phone.value == "") {
			alert("电话号码不能为空!");
			document.form1.phone.focus();
			return false;
		}
		if (document.form1.email.value == "") {
			alert("电子邮箱不能为空!");
			document.form1.email.focus();
			return false;
		}
		if (document.form1.code.value == "") {
			alert("邮政编码不能为空!");
			document.form1.code.focus();
			return false;
		}
		$.post(form.action, $(form).serialize(), function(ajaxResult) {
	        alert(ajaxResult.data);
	        if (ajaxResult.status == 'success') {
	            if (isReloadParent) {
	                parent.location.reload();
	            } else {
	                location.href=url;
	            }
	        }
	    }, 'json');
	    event.preventDefault();
	}
</script>



<body style='background: transparent'>
	<table width="900" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td align="left" valign="top"><jsp:include flush="fasle"
					page="top.jsp" /></td>
		</tr>
		<tr>
			<td height="20"></td>

		</tr>

		<tr>
			<td align="center" valign="center" height="450">

				<form action="${pageContext.request.contextPath }/user/update.do" name="form1" method="post"
					onSubmit="return check11(this,true,'${pageContext.request.contextPath}/qiantai/login.do')">

					<div align="center">
						<br>
						<table border="1" cellspacing="0" bordercolorlight="#C0C0C0"
							bordercolordark="#C0C0C0" width="700">
							<tr>
								<td colspan="3" align="center" bordercolorlight="#C0C0C0"
									bordercolordark="#C0C0C0" height="25"><font
									color="#666666">请填写用户信息(带<font color="red">*</font>为必填项)
								</font></td>
							</tr>
							<tr>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="25" align="right"><font color="#996633">用 户
										名：</font></td>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="25" align="left"><font color="red">${user.name}</font>
								</td>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="25" align="left"><font color="red">&nbsp;*
								</font>您用来登录的用户名</td>
							</tr>
							
							<tr>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="25" align="right"><font color="#996633">真实姓名：</font>
								</td>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="25" align="left"><input class="input7" type="text"
									name="realname" value="${user.realname }" /></td>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="25" align="left"><font color="red">&nbsp;*
								</font>填写您的真实的姓名</td>
							</tr>
							<tr>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="25" align="right"><font color="#996633">性&nbsp;
										&nbsp;&nbsp;别：</font></td>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="25" align="left">
									<font color="red">${user.sex }</font> 
								</td>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="25" align="left"><font color="red">&nbsp;*
								</font>请填写您的真实信息</td>
							</tr>
							<tr>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="25" align="right"><font color="#996633">年&nbsp;&nbsp;
										&nbsp;龄：</font></td>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="25" align="left"><input class="input7" type="text"
									name="age" value="${user.age }" /></td>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="25" align="left"><font color="red">&nbsp;*
								</font>请输入您的真实年龄</td>
							</tr>
							<tr>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="25" align="right"><font color="#996633">身份证号：</font>
								</td>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="25" align="left"><input class="input7" type="text"
									name="card" value="${user.card }" /></td>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="25" align="left"><font color="red">&nbsp;*
								</font>请填写您的真实信息</td>
							</tr>
							<tr>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="25" align="right"><font color="#996633">家庭住址：</font>
								</td>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="25" align="left"><input class="input7" type="text"
									name="address" value="${user.address }" /></td>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="25" align="left"><font color="red">&nbsp;*
								</font>请填写您的真实信息</td>
							</tr>
							<tr>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="25" align="right"><font color="#996633">电话号码：</font>
								</td>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="25" align="left"><input class="input7" type="text"
									name="phone" value="${user.phone }" /></td>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="25" align="left"><font color="red">&nbsp;*
								</font>请填写您的真实信息(格式为02411111111或13911111111)</td>
							</tr>
							<tr>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="25" align="right"><font color="#996633">电子邮箱：</font>
								</td>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="25" align="left"><input class="input7" type="text"
									name="email" value="${user.email }" /></td>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="25" align="left"><font color="red">&nbsp;*
								</font>请填写您有效的邮件地址，以便于我们为您提供有效的服务。</td>
							</tr>
							<tr>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="25" align="right"><font color="#996633">邮政编码：</font>
								</td>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="25" align="left"><input class="input7" type="text"
									name="code" value="${user.code }" /></td>
								<td bordercolorlight="#C0C0C0" bordercolordark="#C0C0C0"
									height="25" align="left"><font color="red">&nbsp;*
								</font>请填写您的真实信息(格式为111111)</td>
							</tr>
							<tr>
								<input type="hidden" name="id" value="${user.id }">
								<td colspan="3" align="center" bordercolorlight="#C0C0C0"
									bordercolordark="#C0C0C0" height="25"><input type="submit"
									value="修改" /></td>
							</tr>
						</table>
					</div>
				</form>
			</td>
		</tr>
		<tr>
			<td height="10">&nbsp;</td>
		</tr>
		<tr>
			<td height="50" align="center" valign="middle">&nbsp; <jsp:include
					flush="fasle" page="copyright.jsp" />
			</td>
		</tr>

	</table>



</body>
</html>
