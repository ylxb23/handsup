package com.zero.handsup.database.service.impl.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.zero.handsup.common.enums.EffectiveEnums.FieldStatusEnum;
import com.zero.handsup.database.entity.user.ShiroUser;
import com.zero.handsup.database.repository.user.ShiroUserRepository;
import com.zero.handsup.database.service.user.ShiroUserService;

@Service
public class ShiroUserServiceImpl implements ShiroUserService {

	@Autowired
	private ShiroUserRepository shiroUserRepo;
	

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int deleteByPrimaryKey(Long id) {
		return shiroUserRepo.deleteByPrimaryKey(id);
	}
	

    /*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public ShiroUser findByPrimaryKey(Long id) {
		return shiroUserRepo.selectByPrimaryKey(id);
	}
	
	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int updateByPrimaryKey(ShiroUser shiroUserModel) {
		return shiroUserRepo.updateByPrimaryKey(shiroUserModel);
	}
	
	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int updateByPrimaryKeySelective(ShiroUser shiroUserModel) {
		return shiroUserRepo.updateByPrimaryKeySelective(shiroUserModel);
	}
	

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int create(ShiroUser shiroUserModel) {
		return shiroUserRepo.insert(shiroUserModel);
	}

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int createSelective(ShiroUser shiroUserModel) {
		return shiroUserRepo.insertSelective(shiroUserModel);
	}

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int selectCount(ShiroUser shiroUserModel) {
		return shiroUserRepo.selectCount(shiroUserModel);
	}
	
	public ShiroUser queryShiroUserByUserLoginName(String username) {
		ShiroUser shiroUser = new ShiroUser();
		shiroUser.setUserLoginname(username);
		shiroUser.setIsDeleted((byte) 0);
		shiroUser.setUserStatus(FieldStatusEnum.VALID.getValue());
		List<ShiroUser> list = shiroUserRepo.selectPage(shiroUser, new PageRequest(0, 1));
		if(CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}
	
}
