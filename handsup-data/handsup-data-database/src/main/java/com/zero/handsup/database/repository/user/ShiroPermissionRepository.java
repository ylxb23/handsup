package com.zero.handsup.database.repository.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.zero.handsup.database.entity.user.ShiroPermission;

@Repository
public interface ShiroPermissionRepository{

  	int deleteByPrimaryKey(Integer id);
	
	ShiroPermission selectByPrimaryKey(Integer id);
	
	    
    int updateByPrimaryKey(ShiroPermission shiroPermission);

    int updateByPrimaryKeySelective(ShiroPermission shiroPermission);

  	int insert(ShiroPermission shiroPermission);
  	
	int insertSelective(ShiroPermission shiroPermission);


    int selectCount(ShiroPermission shiroPermission);

    List<ShiroPermission> selectPage(@Param("shiroPermission") ShiroPermission shiroPermission, @Param("pageable") Pageable pageable);
	
}