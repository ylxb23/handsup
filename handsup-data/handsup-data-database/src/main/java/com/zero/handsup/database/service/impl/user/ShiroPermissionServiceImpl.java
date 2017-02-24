package com.zero.handsup.database.service.impl.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.zero.handsup.common.enums.EffectiveEnums.FieldStatusEnum;
import com.zero.handsup.database.entity.user.ShiroPermission;
import com.zero.handsup.database.repository.user.ShiroPermissionRepository;
import com.zero.handsup.database.service.user.ShiroPermissionService;


@Service
public class ShiroPermissionServiceImpl implements ShiroPermissionService {

	@Autowired
	private ShiroPermissionRepository shiroPermissionRepo;
	

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return shiroPermissionRepo.deleteByPrimaryKey(id);
	}
	

    /*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public ShiroPermission findByPrimaryKey(Integer id) {
		ShiroPermission shiroPermission = shiroPermissionRepo.selectByPrimaryKey(id);
		return shiroPermission;
	}
	
	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int updateByPrimaryKey(ShiroPermission shiroPermissionModel) {
		return shiroPermissionRepo.updateByPrimaryKey(shiroPermissionModel);
	}
	
	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int updateByPrimaryKeySelective(ShiroPermission shiroPermissionModel) {
		return shiroPermissionRepo.updateByPrimaryKeySelective(shiroPermissionModel);
	}
	

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int create(ShiroPermission shiroPermissionModel) {
		return shiroPermissionRepo.insert(shiroPermissionModel);
	}

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int createSelective(ShiroPermission shiroPermissionModel) {
		return shiroPermissionRepo.insertSelective(shiroPermissionModel);
	}

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int selectCount(ShiroPermission shiroPermissionModel) {
		return shiroPermissionRepo.selectCount(shiroPermissionModel);
	}


	@Override
	public ShiroPermission getPermissionByPermissionCode(String permissionCode) {
		ShiroPermission shiroPermission = new ShiroPermission();
		shiroPermission.setIsDeleted((byte) 0);
		shiroPermission.setPermissionCode(permissionCode);
		shiroPermission.setPermissionStatus(FieldStatusEnum.VALID.getValue());
		List<ShiroPermission> list = shiroPermissionRepo.selectPage(shiroPermission, new PageRequest(0, 1));
		if(CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}



}
