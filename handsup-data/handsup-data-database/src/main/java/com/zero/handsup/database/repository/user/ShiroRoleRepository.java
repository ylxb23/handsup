package com.zero.handsup.database.repository.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.zero.handsup.database.entity.user.ShiroRole;

@Repository
public interface ShiroRoleRepository{

  	int deleteByPrimaryKey(Integer id);
	
	ShiroRole selectByPrimaryKey(Integer id);
	    
    int updateByPrimaryKey(ShiroRole shiroRole);

    int updateByPrimaryKeySelective(ShiroRole shiroRole);

  	int insert(ShiroRole shiroRole);
  	
	int insertSelective(ShiroRole shiroRole);


    int selectCount(ShiroRole shiroRole);

    List<ShiroRole> selectPage(@Param("shiroRole") ShiroRole shiroRole, @Param("pageable") Pageable pageable);
	
}