<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>找回密码</title>
	<%@include file="views/common/tags.jsp" %>
</head>
<body>
	<div class="loginmain">
		<div class="loginform">
			<form class="ui form form-horizontal" action="dologin" method="post">
				<h1>找回密码</h1>
				<div class="form-group row">
					<label class="col-sm-2 control-label">登陆账号</label>
					<div class="col-sm-8">
						<input class="form-control" type="text" placeholder="请输入登陆账号" name="username" >
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 control-label">验证码</label>
					<div class="col-sm-8">
						<div class="span6c">
							<input class="form-control" type="text" placeholder="请输入验证码" name="cpatchacode" >
						</div>
						<div class="span4c">
							<a class="" >
								<img class="kaptchaimg" alt="点击重新获取验证码" src="<%=request.getContextPath() %>/kaptcha/verificationcode.jpg">
							</a>
						</div>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 control-label"></label>
					<div class="col-sm-8">
						<input class="form-control ui button spancenter" type="submit" value="下一步" />
					</div>
				</div>
				<a href="<%=request.getContextPath() %>/frontend/findback02.jsp"> 下一步 </a>
			</form>
		</div>
	</div>
</body>
</html>