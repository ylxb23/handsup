package com.zero.handsup.database.repository.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.zero.handsup.database.entity.user.ShiroUser;

@Repository
public interface ShiroUserRepository{

  	int deleteByPrimaryKey(Long id);
	
	ShiroUser selectByPrimaryKey(Long id);
	
	    
    int updateByPrimaryKey(ShiroUser shiroUser);

    int updateByPrimaryKeySelective(ShiroUser shiroUser);

  	int insert(ShiroUser shiroUser);
  	
	int insertSelective(ShiroUser shiroUser);


    int selectCount(ShiroUser shiroUser);

    List<ShiroUser> selectPage(@Param("shiroUser") ShiroUser shiroUser, @Param("pageable") Pageable pageable);
	
}