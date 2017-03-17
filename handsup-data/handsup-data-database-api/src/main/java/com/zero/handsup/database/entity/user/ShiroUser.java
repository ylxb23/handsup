package com.zero.handsup.database.entity.user;
import java.io.Serializable;
import java.util.Date;

public class ShiroUser implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String userNameEn;
	private String userName;
	private String userLoginname;
	private String userPassword;
	private String userLastloginip;
	private Date userLastlogintime;
	private String userAlias;
	private Byte userStatus;
	private String createUser;
	private Date createTime;
	private Date updateTime;
	private Byte isDeleted;
		
	public void setId(Long id){
		this.id = id;
	}
	
	public Long getId(){
		return this.id;
	}
		
	public void setUserNameEn(String userNameEn){
		this.userNameEn = userNameEn;
	}
	
	public String getUserNameEn(){
		return this.userNameEn;
	}
		
	public void setUserName(String userName){
		this.userName = userName;
	}
	
	public String getUserName(){
		return this.userName;
	}
		
	public void setUserLoginname(String userLoginname){
		this.userLoginname = userLoginname;
	}
	
	public String getUserLoginname(){
		return this.userLoginname;
	}
		
	public void setUserPassword(String userPassword){
		this.userPassword = userPassword;
	}
	
	public String getUserPassword(){
		return this.userPassword;
	}
		
	public void setUserLastloginip(String userLastloginip){
		this.userLastloginip = userLastloginip;
	}
	
	public String getUserLastloginip(){
		return this.userLastloginip;
	}
		
	public void setUserLastlogintime(Date userLastlogintime){
		this.userLastlogintime = userLastlogintime;
	}
	
	public Date getUserLastlogintime(){
		return this.userLastlogintime;
	}
		
	public void setUserAlias(String userAlias){
		this.userAlias = userAlias;
	}
	
	public String getUserAlias(){
		return this.userAlias;
	}
		
	public void setUserStatus(Byte userStatus){
		this.userStatus = userStatus;
	}
	
	public Byte getUserStatus(){
		return this.userStatus;
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