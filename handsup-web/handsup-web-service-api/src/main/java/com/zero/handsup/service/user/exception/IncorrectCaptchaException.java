package com.zero.handsup.service.user.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 验证码错误异常
 * @author leo.zeng
 */
public class IncorrectCaptchaException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 23L;

	public IncorrectCaptchaException() {
		super();
	}
	
	public IncorrectCaptchaException(String message) {
		super(message);
	}
	
	public IncorrectCaptchaException(Throwable cause) {
		super(cause);
	}
	
	public IncorrectCaptchaException(String message, Throwable cause) {
		super(message, cause);
	}
}
