package com.zero.handsup.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;

/**
 * 用户信息打印
 *
 * @author leo.zeng
 */
public class IdentityLoggerInterceptor extends HandlerInterceptorAdapter {
	private final Logger logger = LoggerFactory.getLogger(IdentityLoggerInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.debug("handler: {}, requst: {}, response: {}", 
				JSONObject.toJSONString(handler), 
				JSONObject.toJSONString(request), 
				JSONObject.toJSONString(response));
		
		return super.preHandle(request, response, handler);
	}
	
}
