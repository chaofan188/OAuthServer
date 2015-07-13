<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Oauth Approval</title>
</head>
<body><h1>OAuth Approval</h1>

<p>Do you authorize '${authorizationRequest.clientId}' to access your protected resources?</p>

<form id='confirmationForm' name='confirmationForm' action='${pageContext.request.contextPath}/oauth/authorize'
      method='post'>
      同意应用访问您的摄像头：<input type="radio" name="camera" value="true"/><br/>
    <input name='user_oauth_approval' value='true' type='hidden'/>
    <label> <input name='authorize' value='Authorize' type='submit'></label>
</form>
<form id='denialForm' name='denialForm' action='${pageContext.request.contextPath}/oauth/authorize' method='post'>
    <input name='user_oauth_approval' value='false' type='hidden'/>
    <label><input name='deny' value='Deny' type='submit'></label>
</form>
</body>
</html>