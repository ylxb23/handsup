<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户登录</title>
	<%@include file="views/common/tags.jsp" %>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/apps/common/login.js"></script>
</head>
<body>
	<div class="loginmain">
		<div class="loginform" ng-controller="loginController">
			<h1>唯分期运营后台</h1>
			<form class="ui form form-horizontal" action="<%=request.getContextPath()%>/dologin" method="POST">
				<div class="form-group row">
					<label class="col-sm-2 control-label">账号</label>
					<div class="col-sm-8">
						<input class="form-control" type="text" placeholder="请输入登录账号" name="username" value="" >
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 control-label">密码</label>
					<div class="col-sm-8">
						<input class="form-control" type="password" placeholder="请输入登录密码" name="password" >
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 control-label">验证码</label>
					<div class="col-sm-8">
						<div class="span6c">
							<input class="form-control" type="text" placeholder="请输入验证码" name="cpatchacode" >
						</div>
						<div class="span4c">
							<a class="reloadKaptchaimg" >
								<img class="kaptchaimg" alt="点击重新获取验证码" title="点击重新获取验证码" src="<%=request.getContextPath() %>/kaptcha/verificationcode.jpg">
							</a>
						</div>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 control-label"></label>
					<div class="col-sm-8">
						<input class="form-control ui button spancenter loginbtn" type="submit" value="登录" />
					</div>
				</div>
				<div class="righttext">
					<a href="<%=request.getContextPath() %>/frontend/findback01.jsp" >修改密码</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>