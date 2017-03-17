package com.zero.handsup.service.impl.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zero.handsup.database.entity.user.ShiroPermission;
import com.zero.handsup.database.entity.user.ShiroUser;
import com.zero.handsup.database.entity.user.ShiroUserRole;
import com.zero.handsup.database.service.user.ShiroPermissionService;
import com.zero.handsup.database.service.user.ShiroRolePermissionService;
import com.zero.handsup.database.service.user.ShiroUserRoleService;
import com.zero.handsup.database.service.user.ShiroUserService;
import com.zero.handsup.service.entity.user.LoginAccountEntity;
import com.zero.handsup.service.user.UserBusinessManagerService;
import com.zero.handsup.util.common.DateUtils;

@Service
public class UserBusinessManagerServiceImpl implements UserBusinessManagerService {
	private final Logger logger = LoggerFactory.getLogger(UserBusinessManagerServiceImpl.class);
	
	@Autowired
	private ShiroUserService userService;
	
	@Autowired
	private ShiroUserRoleService userRoleService;
	
	@Autowired
	private ShiroRolePermissionService rolePermissionService;
	
	@Autowired
	private ShiroPermissionService permissionService;
	
	
	/**
	 * 根据用户名获取用户拥有的权限, 获取用户角色, 通过角色累加所有权限
	 * @param username
	 * @return
	 */
	@Transactional(readOnly=true)
	@Override
	public Collection<String> queryPermissions(String username) {
		Set<String> permissions = new TreeSet<>();
		// 获取用户信息
		ShiroUser user = userService.queryShiroUserByUserLoginName(username);
		// 获取用户拥有的所有角色
		List<ShiroUserRole> roles = userRoleService.queryRolesByUserId(user.getId());
		// 获取角色对应的所有权限
		for(ShiroUserRole role : roles) {
			List<String> permissionCodes = rolePermissionService.getPermissionByRole(role.getRoleCode());
			for(String permissionCode : permissionCodes) {
				ShiroPermission permission = permissionService.getPermissionByPermissionCode(permissionCode);
				logger.info("用户[{}] 拥有权限 --->> {}", username, permission.getPermissionValue());
				permissions.add(permission.getPermissionValue());
			}
		}
		return permissions;
	}

	/**
	 * 根据用户登录名获取用户账号信息
	 * @param username
	 * @return
	 */
	@Override
	public LoginAccountEntity getUserLoginAccountByUsername(String username) {
		LoginAccountEntity account = new LoginAccountEntity();
		ShiroUser user = userService.queryShiroUserByUserLoginName(username);
		List<ShiroUserRole> roleList = userRoleService.queryRolesByUserId(user.getId());
		List<String> roles = new ArrayList<>();
		roleList.forEach(it -> {
			roles.add(it.getRoleCode());
		});
		account.setUsername(user.getUserName());
		account.setPassword(user.getUserPassword());
		account.setUserAlias(user.getUserAlias());
		account.setUserid(user.getId());
		account.setUserLastLoginip(user.getUserLastloginip());
		account.setUserLastLogintime(DateUtils.format(user.getUserLastlogintime(), DateUtils.NORMAL_DATE_FORMATTER));
		account.setUserLoginname(username);
		account.setRoles(roles);
		return account;
	}

}
