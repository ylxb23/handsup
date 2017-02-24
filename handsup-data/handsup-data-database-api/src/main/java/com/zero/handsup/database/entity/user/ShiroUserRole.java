package com.zero.handsup.database.entity.user;
import java.io.Serializable;
import java.util.Date;

public class ShiroUserRole implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Long userId;
	private String roleCode;
	private String userRoleDescription;
	private Byte userRoleStatus;
	private String createUser;
	private Date createTime;
	private Date updateTime;
	private Byte isDeleted;
		
	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getId(){
		return this.id;
	}
		
	public void setUserId(Long userId){
		this.userId = userId;
	}
	
	public Long getUserId(){
		return this.userId;
	}
		
	public void setRoleCode(String roleCode){
		this.roleCode = roleCode;
	}
	
	public String getRoleCode(){
		return this.roleCode;
	}
		
	public void setUserRoleDescription(String userRoleDescription){
		this.userRoleDescription = userRoleDescription;
	}
	
	public String getUserRoleDescription(){
		return this.userRoleDescription;
	}
		
	public void setUserRoleStatus(Byte userRoleStatus){
		this.userRoleStatus = userRoleStatus;
	}
	
	public Byte getUserRoleStatus(){
		return this.userRoleStatus;
	}
		
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}
	
	public String getCreateUser(){
		return this.createUser;
	}
		
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	
	public Date getCreateTime(){
		return this.createTime;
	}
		
	public void setUpdateTime(Date updateTime){
		this.updateTime = updateTime;
	}
	
	public Date getUpdateTime(){
		return this.updateTime;
	}
		
	public void setIsDeleted(Byte isDeleted){
		this.isDeleted = isDeleted;
	}
	
	public Byte getIsDeleted(){
		return this.isDeleted;
	}
		
		
}