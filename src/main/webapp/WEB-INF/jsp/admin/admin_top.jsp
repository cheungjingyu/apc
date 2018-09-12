<%@page import="java.util.*"%>
<%@ page language="java"  pageEncoding="utf-8"%>
<%String path = request.getContextPath(); %>
<html>
<title>网上订餐后台- 管理页面</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<link href="<%=path %>/admin/images/skin.css" rel="stylesheet" type="text/css">
</head>
<body leftmargin="0" topmargin="0">

<table width="100%" height="64" border="0" cellpadding="0" cellspacing="0" class="admin_topbg">
  <tr>
    <td width="61%" height="64"></td>
    <td width="39%" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="74%" height="38" class="admin_txt">管理员：<b>${admin.name}</b> 您好,感谢登陆使用！</td>
        <td width="22%"><a href="javascrippt:void(0);" onclick="logout()" style="text-decoration: none;color: #fff;" target="main">系统退出</a></td>
      </tr>
      <tr>
        <td height="19" colspan="3">&nbsp;</td>
        </tr>
    </table>
    </td>
  </tr>
</table>
</body>
<script type="text/javascript">
function logout()
{
	if(confirm("是否退出"))
	{
		location.href="${pageContext.request.contextPath}/admin/logout.do";
	}
}
</script>
</html>