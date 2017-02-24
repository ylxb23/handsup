package com.zero.handsup.service.entity.user;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 用户登录后, 前端与后端保存在 session 中的用户相关信息, 即 shiro_user表的模型
 * @author leo.zeng
 */
@Data
public class LoginAccountEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 23L;
	
	private Long userid;
	private String username;
	private String usernameEn;
	private String userAlias;
	private String userLoginname;
	private String password;
	private String userLastLoginip;
	private String userLastLogintime;
	private String userMerchantCode;
	private String userSalesCode;
	
	private List<String> roles;
	
}
