package com.zero.handsup.service.impl.common;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.code.kaptcha.Constants;
import com.zero.handsup.service.user.exception.IncorrectCaptchaException;

/**
 * 拓展用户名密码登陆表单验证, 表单信息增加验证码校验
 * @author leo.zeng
 *
 */
public class CaptchaFormAuthenticationFilter extends FormAuthenticationFilter {
	private final Logger logger = LoggerFactory.getLogger(CaptchaFormAuthenticationFilter.class);
	
	public static final String DEFAULT_CAPTCHA_PARAM = "captcha";
	
	private String captchaParam = DEFAULT_CAPTCHA_PARAM;
	
	public void setCaptchaParam(String captchaParam) {
		this.captchaParam = captchaParam;
	}
	
	public String getCaptchaParam() {
		return this.captchaParam;
	}
	
	/**
	 * 获取请求中的验证码代码
	 * @param request
	 * @return
	 */
	public String getCaptcha(ServletRequest request) {
		return WebUtils.getCleanParam(request, captchaParam);
	}
	
	/***
	 * 创建带有验证码的 token
	 * @param request
	 * @param response
	 * @return
	 */
	protected CaptchaUsernamePasswordToken createToken(ServletRequest request, ServletResponse response) {
		String username = getUsername(request);
		String password = getPassword(request);
		String captcha = getCaptcha(request);
		boolean rememberMe = isRememberMe(request);
		logger.info("do login with user[{}], captcha[{}], rememberMe[{}]", username, captcha, rememberMe);
		String host = getHost(request);
		return new CaptchaUsernamePasswordToken(username, password, rememberMe, host, captcha);
	}
	
	/**
	 * 验证码校验
	 * @param request
	 * @param token
	 */
	protected void doCaptchaValidate(HttpServletRequest request, CaptchaUsernamePasswordToken token) {
		String captcha = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if(StringUtils.isNotBlank(captcha) && !captcha.equals(token.getCaptcha())) {
			throw new IncorrectCaptchaException("验证码错误！");
		}
	}
	
	/**
	 * 登录校验
	 * @param request
	 * @param response
	 */
	protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
		CaptchaUsernamePasswordToken token = createToken(request, response);
		
		try {
			doCaptchaValidate((HttpServletRequest) request, token);
			Subject subject = getSubject(request, response);
			subject.login(token);
			
			// if 已有登陆
			// throw LoginDoubleException <extends AuthenticationException> 
			return onLoginSuccess(token, subject, request, response);
		} catch (AuthenticationException e) {
			// 验证码输入错误
			logger.info("Host:[{}], username:[{}], 验证码[{}]输入错误!", token.getHost(), token.getUsername(), token.getCaptcha());
			return onLoginFailure(token, e, request, response);
		}
		
	}
}
