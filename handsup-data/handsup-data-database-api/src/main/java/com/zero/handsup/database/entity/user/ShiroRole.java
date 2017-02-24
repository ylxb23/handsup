package com.zero.handsup.database.entity.user;
import java.io.Serializable;
import java.util.Date;

public class ShiroRole implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String roleCode;
	private String roleName;
	private Integer roleGrade;
	private String roleDescription;
	private Date roleValidity;
	private Byte roleStatus;
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
		
	public void setRoleName(String roleName){
		this.roleName = roleName;
	}
	
	public String getRoleName(){
		return this.roleName;
	}
		
	public void setRoleGrade(Integer roleGrade){
		this.roleGrade = roleGrade;
	}
	
	public Integer getRoleGrade(){
		return this.roleGrade;
	}
		
	public void setRoleDescription(String roleDescription){
		this.roleDescription = roleDescription;
	}
	
	public String getRoleDescription(){
		return this.roleDescription;
	}
		
	public void setRoleValidity(Date roleValidity){
		this.roleValidity = roleValidity;
	}
	
	public Date getRoleValidity(){
		return this.roleValidity;
	}
		
	public void setRoleStatus(Byte roleStatus){
		this.roleStatus = roleStatus;
	}
	
	public Byte getRoleStatus(){
		return this.roleStatus;
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