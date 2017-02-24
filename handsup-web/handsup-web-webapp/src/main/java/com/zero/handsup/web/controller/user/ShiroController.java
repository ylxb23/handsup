package com.zero.handsup.web.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShiroController {
	
	private final Logger logger = LoggerFactory.getLogger(ShiroController.class);
	
	
	@RequestMapping(value="login", method={RequestMethod.POST})
	public String shiroDoLogin(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		logger.info("用户登录, 用户名[{}], 密码[{}].");
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		token.setRememberMe(true);
		
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			
		} catch(Exception e) {
			logger.error(e.getMessage(), e);
		}
		
		return "login";
	}
	
	
}
