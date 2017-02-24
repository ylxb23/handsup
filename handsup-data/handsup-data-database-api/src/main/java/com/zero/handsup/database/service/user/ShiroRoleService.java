package com.zero.handsup.database.service.user;

import com.zero.handsup.database.entity.user.ShiroRole;

public interface ShiroRoleService{
	
	public int create(ShiroRole shiroRoleModel);
	
	public int createSelective(ShiroRole shiroRoleModel);
	
	public ShiroRole findByPrimaryKey(Integer id);
	
	public int updateByPrimaryKey(ShiroRole shiroRoleModel);
	
	public int updateByPrimaryKeySelective(ShiroRole shiroRoleModel);
	
	public int deleteByPrimaryKey(Integer id);
	

	public int selectCount(ShiroRole shiroRoleModel);
	
}