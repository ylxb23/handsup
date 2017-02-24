package com.zero.handsup.database.service.user;

import com.zero.handsup.database.entity.user.ShiroUser;

public interface ShiroUserService{
	
	public int create(ShiroUser shiroUserModel);
	
	public int createSelective(ShiroUser shiroUserModel);
	
	public ShiroUser findByPrimaryKey(Long id);
	
	public int updateByPrimaryKey(ShiroUser shiroUserModel);
	
	public int updateByPrimaryKeySelective(ShiroUser shiroUserModel);
	
	public int deleteByPrimaryKey(Long id);
	

	public int selectCount(ShiroUser shiroUserModel);
	
	public ShiroUser queryShiroUserByUserLoginName(String username);
	
}