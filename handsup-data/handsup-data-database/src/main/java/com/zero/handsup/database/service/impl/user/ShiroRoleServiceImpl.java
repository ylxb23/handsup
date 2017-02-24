package com.zero.handsup.database.service.impl.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zero.handsup.database.entity.user.ShiroRole;
import com.zero.handsup.database.repository.user.ShiroRoleRepository;
import com.zero.handsup.database.service.user.ShiroRoleService;


@Service
public class ShiroRoleServiceImpl implements ShiroRoleService {


	@Autowired
	private ShiroRoleRepository shiroRoleRepo;
	

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return shiroRoleRepo.deleteByPrimaryKey(id);
	}
	

    /*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public ShiroRole findByPrimaryKey(Integer id) {
		return shiroRoleRepo.selectByPrimaryKey(id);
	}
	
	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int updateByPrimaryKey(ShiroRole shiroRoleModel) {
		return shiroRoleRepo.updateByPrimaryKey(shiroRoleModel);
	}
	
	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int updateByPrimaryKeySelective(ShiroRole shiroRoleModel) {
		return shiroRoleRepo.updateByPrimaryKeySelective(shiroRoleModel);
	}
	

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int create(ShiroRole shiroRoleModel) {
		return shiroRoleRepo.insert(shiroRoleModel);
	}

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int createSelective(ShiroRole shiroRoleModel) {
		return shiroRoleRepo.insertSelective(shiroRoleModel);
	}

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int selectCount(ShiroRole shiroRoleModel) {
		return shiroRoleRepo.selectCount(shiroRoleModel);
	}



}
