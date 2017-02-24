package com.zero.handsup.service.impl.common;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;
import com.zero.handsup.service.entity.user.LoginAccountEntity;
import com.zero.handsup.service.user.UserBusinessManagerService;

/**
 * JDBC Realm, required by applicationContext-shiro.xml#securityManager
 * @author leo.zeng
 */
@Component(value="handsupAuthrozingRealm")
public class HandsupAuthrozingRealm extends AuthorizingRealm {
	private final Logger logger = LoggerFactory.getLogger(HandsupAuthrozingRealm.class);
	
	@Autowired
	private UserBusinessManagerService userBusinessManagerService;
	
	public HandsupAuthrozingRealm() {
		super();
	}

	/**
	 * 获取授权信息
	 * @param principals 
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.fromRealm(getName()).iterator().next();
		if(StringUtils.isNotBlank(username)) {
			Collection<String> pers = userBusinessManagerService.queryPermissions(username);
			if(!CollectionUtils.isEmpty(pers)) {
				SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
				pers.forEach(each -> {
					info.addStringPermission(each);
				});
				return info;
			}
		}
		logger.info("Shiro doGetAuthorizationInfo get nothing...");
		return null;
	}

	/**
	 * 获取认证信息
	 * @param authcToken
	 * @return 
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken cumToken = (UsernamePasswordToken) authcToken;
		String username = cumToken.getUsername();
		if(StringUtils.isNoneBlank(username)) {
			LoginAccountEntity account = userBusinessManagerService.getUserLoginAccountByUsername(username);
			if(account != null) {
				logger.info("Shiro doGetAuthenticationInfo - username[{}]: {}", username, JSONObject.toJSONString(account));
				return new SimpleAuthenticationInfo(account.getUserLoginname(), account.getPassword(), getName());
			}
		}
		return null;
	}

}
