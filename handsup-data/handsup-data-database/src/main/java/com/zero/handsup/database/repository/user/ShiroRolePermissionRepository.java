package com.zero.handsup.database.repository.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.zero.handsup.database.entity.user.ShiroRolePermission;

@Repository
public interface ShiroRolePermissionRepository{

  	int deleteByPrimaryKey(Integer id);
	
	ShiroRolePermission selectByPrimaryKey(Integer id);
	
	    
    int updateByPrimaryKey(ShiroRolePermission shiroRolePermission);

    int updateByPrimaryKeySelective(ShiroRolePermission shiroRolePermission);

  	int insert(ShiroRolePermission shiroRolePermission);
  	
	int insertSelective(ShiroRolePermission shiroRolePermission);


    int selectCount(ShiroRolePermission shiroRolePermission);

    List<ShiroRolePermission> selectPage(@Param("shiroRolePermission") ShiroRolePermission shiroRolePermission, @Param("pageable") Pageable pageable);
	
}