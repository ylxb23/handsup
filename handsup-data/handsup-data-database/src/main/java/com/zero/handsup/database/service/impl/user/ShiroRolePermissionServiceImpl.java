package com.zero.handsup.database.service.impl.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.zero.handsup.common.enums.EffectiveEnums.FieldStatusEnum;
import com.zero.handsup.database.entity.user.ShiroRolePermission;
import com.zero.handsup.database.repository.user.ShiroRolePermissionRepository;
import com.zero.handsup.database.service.user.ShiroRolePermissionService;

@Service
public class ShiroRolePermissionServiceImpl implements ShiroRolePermissionService {

	@Autowired
	private ShiroRolePermissionRepository shiroRolePermissionRepo;
	

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return shiroRolePermissionRepo.deleteByPrimaryKey(id);
	}
	

    /*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public ShiroRolePermission findByPrimaryKey(Integer id) {
		return shiroRolePermissionRepo.selectByPrimaryKey(id);
	}
	
	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int updateByPrimaryKey(ShiroRolePermission shiroRolePermissionModel) {
		return shiroRolePermissionRepo.updateByPrimaryKey(shiroRolePermissionModel);
	}
	
	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int updateByPrimaryKeySelective(ShiroRolePermission shiroRolePermissionModel) {
		return shiroRolePermissionRepo.updateByPrimaryKeySelective(shiroRolePermissionModel);
	}
	

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int create(ShiroRolePermission shiroRolePermissionModel) {
		return shiroRolePermissionRepo.insert(shiroRolePermissionModel);
	}

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int createSelective(ShiroRolePermission shiroRolePermissionModel) {
		return shiroRolePermissionRepo.insertSelective(shiroRolePermissionModel);
	}

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int selectCount(ShiroRolePermission shiroRolePermissionModel) {
		return shiroRolePermissionRepo.selectCount(shiroRolePermissionModel);
	}


	@Override
	public List<String> getPermissionByRole(String roleCode) {
		ShiroRolePermission shiroRolePermission = new ShiroRolePermission();
		shiroRolePermission.setIsDeleted((byte) 0);
		shiroRolePermission.setRolePermissionStatus(FieldStatusEnum.VALID.getValue());
		shiroRolePermission.setRoleCode(roleCode);
		List<ShiroRolePermission> rolePermissionList = shiroRolePermissionRepo.selectPage(shiroRolePermission, new PageRequest(0, Integer.MAX_VALUE));
		if(CollectionUtils.isEmpty(rolePermissionList)) {
			return null;
		}
		List<String> list = new ArrayList<>();
		for(ShiroRolePermission rolePermission : rolePermissionList) {
			list.add(rolePermission.getPermissionCode());
		}
		return list;
	}



}
