package com.zero.handsup.database.entity.user;
import java.io.Serializable;
import java.util.Date;

public class ShiroPermission implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String permissionCode;
	private String permissionValue;
	private String permissionName;
	private String permissionDescription;
	private Byte permissionStatus;
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
		
	public void setPermissionCode(String permissionCode){
		this.permissionCode = permissionCode;
	}
	
	public String getPermissionCode(){
		return this.permissionCode;
	}
		
	public void setPermissionValue(String permissionValue){
		this.permissionValue = permissionValue;
	}
	
	public String getPermissionValue(){
		return this.permissionValue;
	}
		
	public void setPermissionName(String permissionName){
		this.permissionName = permissionName;
	}
	
	public String getPermissionName(){
		return this.permissionName;
	}
		
	public void setPermissionDescription(String permissionDescription){
		this.permissionDescription = permissionDescription;
	}
	
	public String getPermissionDescription(){
		return this.permissionDescription;
	}
		
	public void setPermissionStatus(Byte permissionStatus){
		this.permissionStatus = permissionStatus;
	}
	
	public Byte getPermissionStatus(){
		return this.permissionStatus;
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