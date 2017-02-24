package com.zero.handsup.service.impl.common;

import org.apache.shiro.authc.UsernamePasswordToken;


/**
 * 拓展用户名密码验证 token, 增加验证码验证
 * @author leo.zeng
 */
public class CaptchaUsernamePasswordToken extends UsernamePasswordToken {
	/**
	 * 
	 */
	private static final long serialVersionUID = 23L;

	private String captcha;
	
	/**
	 * 带有验证码的初始 token对象
	 * @param username
	 * @param password
	 * @param rememberMe
	 * @param host
	 * @param captcha
	 */
	public CaptchaUsernamePasswordToken(String username, String password, boolean rememberMe, String host, String captcha) {
		super(username, password, rememberMe, host);
		this.captcha = captcha;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
}
