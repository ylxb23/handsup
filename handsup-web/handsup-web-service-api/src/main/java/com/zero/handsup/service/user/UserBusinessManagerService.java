package com.zero.handsup.service.user;

import java.util.Collection;

import com.zero.handsup.service.entity.user.LoginAccountEntity;

public interface UserBusinessManagerService {

	/**
	 * 根据用户名获取用户拥有的权限, 获取用户角色, 通过角色累加所有权限
	 * @param username
	 * @return
	 */
	Collection<String> queryPermissions(String username);

	/**
	 * 根据用户登录名获取用户账号信息
	 * @param username
	 * @return
	 */
	LoginAccountEntity getUserLoginAccountByUsername(String username);
	
}
