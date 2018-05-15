<!Doctype html>
<%@ page language="java" isThreadSafe="true" pageEncoding="utf8" %>  
<%@ page contentType="text/html; charset=utf-8"%>

<html xmlns=http://www.w3.org/1999/xhtml>
<head>                 
<meta http-equiv=Content-Type content="text/html;charset=utf-8">
<meta http-equiv=X-UA-Compatible content="IE=edge,chrome=1">
<meta content=always name=referrer>               

<title></title>
<link rel="stylesheet" href="./css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="./css/wcss.css" type="text/css" />
<style>
.form-control{
	line-height: 23px;
}

.form-signin{
  max-width: 330px;
  padding: 15px;
  margin: 0 auto;
}
</style>
<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js" ></script>
<script src="./js/bootstrap.min.js"></script>      
</head>
 
<body>
	<form class="form-signin" commandName="${commandName}" method="post" name="login_form">
		<div class="div_login">
			<div class="username"><input type="text" class="form-control"  name="username" placeholder="请输入用户名" required/></div>
			<div class="password"><input type="password" class="form-control" id="inputPassword" name="password"  placeholder="请输入密码" required/></div>
		</div>
		<div class="button"></div>
		<input type="hidden" name="lt" value="${loginTicket}" />
        <input type="hidden" name="execution" value="${flowExecutionKey}" />
        <input type="hidden" name="_eventId" value="submit" />
		<button tyle="submit" class="btn btn-lg btn-primary login_button">登录</button>
	</form>
<script src="./js/bootstrapValidator.js"></script>
</body>
</html>