<%--
��վ: <a href="http://www.crazyit.org">���Java����</a>
author  yeeku.H.lee kongyeeku@163.com
version  1.0
Copyright (C), 2001-2016, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>����ͼ��</title>
</head>
<body>
<h3>����ͼ��</h3>
<s:form action="addUser">
	<s:textfield name="user.username" label="�û���"/>
	<s:textfield name="user.password" label="����"/>
	
	<tr align="center">
		<td colspan="2">
		<s:submit value="����" theme="simple"/>
		<s:reset value="����" theme="simple"/>
		</td>
	</tr>
</s:form>
</body>
</html>