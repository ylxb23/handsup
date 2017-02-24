package com.zero.handsup.database.entity.user;
import java.io.Serializable;
import java.util.Date;

public class ShiroRolePermission implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String roleCode;
	private String permissionCode;
	private String rolePermissionDescription;
	private Byte rolePermissionStatus;
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
		
	public void setRoleCode(String roleCode){
		this.roleCode = roleCode;
	}
	
	public String getRoleCode(){
		return this.roleCode;
	}
		
	public void setPermissionCode(String permissionCode){
		this.permissionCode = permissionCode;
	}
	
	public String getPermissionCode(){
		return this.permissionCode;
	}
		
	public void setRolePermissionDescription(String rolePermissionDescription){
		this.rolePermissionDescription = rolePermissionDescription;
	}
	
	public String getRolePermissionDescription(){
		return this.rolePermissionDescription;
	}
		
	public void setRolePermissionStatus(Byte rolePermissionStatus){
		this.rolePermissionStatus = rolePermissionStatus;
	}
	
	public Byte getRolePermissionStatus(){
		return this.rolePermissionStatus;
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