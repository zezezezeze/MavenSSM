package com.millery.domain;

import java.io.Serializable;

/**
 * @author Jack 
 * 用户实体类 
 * 2017-11-27 22:12
 */
@SuppressWarnings("serial")
public class TbUser implements Serializable {
	private Integer id;
	private String userName;
	private String realName;
	private String password;
	private Integer roleId;

	public TbUser() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "TbUser [id=" + id + ", userName=" + userName + ", realName="
				+ realName + ", password=" + password + ", roleId=" + roleId
				+ "]";
	}

}
