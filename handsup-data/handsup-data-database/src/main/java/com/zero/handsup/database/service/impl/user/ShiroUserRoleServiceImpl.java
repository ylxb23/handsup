
package com.zero.handsup.database.service.impl.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zero.handsup.database.entity.user.ShiroUserRole;
import com.zero.handsup.database.repository.user.ShiroUserRoleRepository;
import com.zero.handsup.database.service.user.ShiroUserRoleService;

@Service
public class ShiroUserRoleServiceImpl implements ShiroUserRoleService {

	@Autowired
	private ShiroUserRoleRepository shiroUserRoleRepo;
	

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return shiroUserRoleRepo.deleteByPrimaryKey(id);
	}
	

    /*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public ShiroUserRole findByPrimaryKey(Integer id) {
		return shiroUserRoleRepo.selectByPrimaryKey(id);
	}
	
	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int updateByPrimaryKey(ShiroUserRole shiroUserRoleModel) {
		return shiroUserRoleRepo.updateByPrimaryKey(shiroUserRoleModel);
	}
	
	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int updateByPrimaryKeySelective(ShiroUserRole shiroUserRoleModel) {
		return shiroUserRoleRepo.updateByPrimaryKeySelective(shiroUserRoleModel);
	}
	

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int create(ShiroUserRole shiroUserRoleModel) {
		return shiroUserRoleRepo.insert(shiroUserRoleModel);
	}

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int createSelective(ShiroUserRole shiroUserRoleModel) {
		return shiroUserRoleRepo.insertSelective(shiroUserRoleModel);
	}

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int selectCount(ShiroUserRole shiroUserRoleModel) {
		return shiroUserRoleRepo.selectCount(shiroUserRoleModel);
	}

	
	@Override
	public List<ShiroUserRole> queryRolesByUserId(Long userId) {
		ShiroUserRole shiroUserRole = new ShiroUserRole();
		shiroUserRole.setUserId(userId);
		shiroUserRole.setIsDeleted((byte) 0);
		return shiroUserRoleRepo.selectPage(shiroUserRole, new PageRequest(0, Integer.MAX_VALUE));
	}



}
