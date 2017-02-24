package com.zero.handsup.database.service.user;

import java.util.List;

import com.zero.handsup.database.entity.user.ShiroUserRole;

public interface ShiroUserRoleService{
	
	public int create(ShiroUserRole shiroUserRoleModel);
	
	public int createSelective(ShiroUserRole shiroUserRoleModel);
	
	public ShiroUserRole findByPrimaryKey(Integer id);
	
	public int updateByPrimaryKey(ShiroUserRole shiroUserRoleModel);
	
	public int updateByPrimaryKeySelective(ShiroUserRole shiroUserRoleModel);
	
	public int deleteByPrimaryKey(Integer id);
	

	public int selectCount(ShiroUserRole shiroUserRoleModel);

	public List<ShiroUserRole> queryRolesByUserId(Long id);
	
}