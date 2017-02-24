package com.zero.handsup.database.repository.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.zero.handsup.database.entity.user.ShiroUserRole;

@Repository
public interface ShiroUserRoleRepository{

  	int deleteByPrimaryKey(Integer id);
	
	ShiroUserRole selectByPrimaryKey(Integer id);
	
	    
    int updateByPrimaryKey(ShiroUserRole shiroUserRole);

    int updateByPrimaryKeySelective(ShiroUserRole shiroUserRole);

  	int insert(ShiroUserRole shiroUserRole);
  	
	int insertSelective(ShiroUserRole shiroUserRole);


    int selectCount(ShiroUserRole shiroUserRole);

    List<ShiroUserRole> selectPage(@Param("shiroUserRole") ShiroUserRole shiroUserRole, @Param("pageable") Pageable pageable);
	
}