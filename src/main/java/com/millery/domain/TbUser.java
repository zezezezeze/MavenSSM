package com.millery.domain;

import java.io.Serializable;

/**
 * @author Jack 
 * 用户实体类 
 * 2017-11-27 22:12
 */
@SuppressWarnings("serial")
public class TbUser implements Serializable {
	private Long id;
	private String userName;
	private String realName;
	private String password;
	private Integer roleId;
	private String groupId;
	public TbUser() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
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

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	@Override
	public String toString() {
		return "TbUser [id=" + id + ", userName=" + userName + ", realName="
				+ realName + ", password=" + password + ", roleId=" + roleId
				+ ", groupId=" + groupId + "]";
	}

	
}
