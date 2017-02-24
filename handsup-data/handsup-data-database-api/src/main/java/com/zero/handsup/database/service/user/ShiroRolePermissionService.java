package com.zero.handsup.database.service.user;

import java.util.List;

import com.zero.handsup.database.entity.user.ShiroRolePermission;

public interface ShiroRolePermissionService{
	
	public int create(ShiroRolePermission shiroRolePermissionModel);
	
	public int createSelective(ShiroRolePermission shiroRolePermissionModel);
	
	public ShiroRolePermission findByPrimaryKey(Integer id);
	
	public int updateByPrimaryKey(ShiroRolePermission shiroRolePermissionModel);
	
	public int updateByPrimaryKeySelective(ShiroRolePermission shiroRolePermissionModel);
	
	public int deleteByPrimaryKey(Integer id);
	

	public int selectCount(ShiroRolePermission shiroRolePermissionModel);

	public List<String> getPermissionByRole(String roleCode);
	
}