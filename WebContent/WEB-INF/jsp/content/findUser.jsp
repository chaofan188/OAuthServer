<%--
网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
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
	<title>添加图书</title>
</head>
<body>
<h3>查找用户</h3>
<s:form action="find">
	<s:textfield name="username" label="用户名"/>
	
	<tr align="center">
		<td colspan="2">
		<s:submit value="查找" theme="simple"/>
		</td>
	</tr>
</s:form>
</body>
</html>
