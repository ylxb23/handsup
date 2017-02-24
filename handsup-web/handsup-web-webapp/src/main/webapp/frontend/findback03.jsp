<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>找回密码</title>
	<%@include file="views/common/tags.jsp" %>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/apps/common/login.js"></script>
</head>
<body>
	<div class="loginmain">
		<div class="loginform">
			<h1>找回密码</h1>
			<form class="ui form form-horizontal" action="dologin" method="post">
				<div class="form-group row">
					<label class="col-sm-2 control-label">新密码</label>
					<div class="col-sm-8">
						<input class="form-control tiphere" type="password" placeholder="请输入新密码" name="password" />
					</div>
					<div class="passwordruletip">
						<div class="tipicon">
							<i class="warning circle icon"></i>
						</div>
						<div class="tiprule">
							<div class="title">密码规则</div>
							<div class="content">
								<ul>
									<li>长度为 6-14 个字符 </li>
									<li>支持数字、大小写字母和英文标点符号 </li>
									<li>不允许有空格</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 control-label">确认新密码</label>
					<div class="col-sm-8">
						<input class="form-control" type="password" placeholder="确认新密码" name="confirmpassword" />
					</div>
				</div>
				<div class="form-group row">
					<label class="col-sm-2 control-label"></label>
					<div class="col-sm-8">
						<input class="form-control ui button spancenter" type="submit" value="下一步" />
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>