package com.zero.handsup.database.service.user;

import com.zero.handsup.database.entity.user.ShiroPermission;

public interface ShiroPermissionService{
	
	public int create(ShiroPermission shiroPermissionModel);
	
	public int createSelective(ShiroPermission shiroPermissionModel);
	
	public ShiroPermission findByPrimaryKey(Integer id);
	
	public int updateByPrimaryKey(ShiroPermission shiroPermissionModel);
	
	public int updateByPrimaryKeySelective(ShiroPermission shiroPermissionModel);
	
	public int deleteByPrimaryKey(Integer id);
	
	public int selectCount(ShiroPermission shiroPermissionModel);

	public ShiroPermission getPermissionByPermissionCode(String permissionCode);
	
}