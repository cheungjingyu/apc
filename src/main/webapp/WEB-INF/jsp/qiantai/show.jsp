<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="gb2312"%>

<html>
<title>��Ʒչʾ</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />

<meta content="" name=keywords />
<meta content="" name=description />
<link href="${pageContext.request.contextPath }/qiantai/css/common.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/qiantai/css/skin.css" rel="stylesheet" type="text/css" />
</head>



<body style='background:transparent'>
<table width="900" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="left" valign="top">
  
    
  <jsp:include flush="fasle" page="top.jsp"/>
    
    </td>
  </tr>
  <tr >
  <td height="50"></td>
  
</tr>
  
  <tr>
    <td align="center" valign="center" height="450">
    

    <div align="center">
	

    <table id="table2"   class="line_table" style="width:100%;  margin: 0; padding: 0" cellSpacing="0" cellPadding="0">
   
		<tr>
			<td  class="line_table" height="25" align="right" width="20%"><span class="left_bt2">�˵����ƣ�</span></td>
			<td class="line_table" height="25"  width="70%">
			<input type="text" name="name" size="45" readonly value="${menu.name }"></td>
		</tr>
		<tr>
			<td  class="line_table" height="25"  align="right" width="20%"><span class="left_bt2">ԭ&nbsp;&nbsp;&nbsp; 
			�ϣ�</span></td>
			<td class="line_table" height="25" width="80%">
			<input type="text" name="burden" size="45" readonly value="${menu.burden }"></td>
		</tr>
		<tr>
			<td class="line_table" height="25"  align="right" width="20%"><span class="left_bt2">�г���
			�ۣ�</span></td>
			<td height="25"  width="80%">
			<input type="text" name="price" size="45" readonly value="${menu.price }"></td>
		</tr>
		<tr>
			<td class="line_table" height="25"  align="right" width="20%"><span class="left_bt2">��Ա��
			�ۣ�</span></td>
			<td height="25"  width="80%">
			<input type="text" name="price1" size="45" readonly value="${menu.price1 }"></td>
		</tr>
		<tr>
			<td class="line_table"  height="25"  align="right" width="20%"><span class="left_bt2">˵&nbsp;&nbsp;&nbsp; 
			����</span></td>
			<td class="line_table" height="25"  width="80%">
			<textarea rows="12" name="brief" cols="100" readonly>${menu.brief }</textarea></td>
		</tr>
		<tr>
			<td  class="line_table" height="25"  align="right" width="20%"><span class="left_bt2">��Ʒ���</span></td>
			<td  class="line_table"  height="25"  width="80%">
			<input type="text" name="type" size="45" readonly value="${menu.type.name }">
			</td>
		</tr>
		<tr>
			<td class="line_table" align="right" width="20%">
			<span class="left_bt2">չʾͼƬ</span>��</td>
			<td  class="line_table" width="80%" align="left"><img src="${pageContext.request.contextPath}/${menu.imgpath}"></td>
		</tr>

		<tr>
			<td  class="line_table" height="25"  align="center" colspan="2">
			<a href="${pageContext.request.contextPath}" target="_self"><input type="submit" value="����"></a>
			</td>
		</tr>
		
    
		</table>

  	</div>
    
    
    
     </td>
  </tr>
  <tr>
    <td height="10">&nbsp;</td>
  </tr>
  <tr>
    <td height="50" align="center" valign="middle">&nbsp; 
   
        <jsp:include flush="fasle" page="copyright.jsp"/>
    </td>
  </tr>
  
</table>


 
</body>
</html>
