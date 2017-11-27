package com.millery.domain;

import java.io.Serializable;
/**
 * @author Jack
 *  角色实体类
 *  2017-11-27 22:21
 */
@SuppressWarnings("serial")
public class TbRole implements Serializable{
	private Integer id;
	private String roleName;
	private Integer roleGrade;
	
	public TbRole() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getRoleGrade() {
		return roleGrade;
	}

	public void setRoleGrade(Integer roleGrade) {
		this.roleGrade = roleGrade;
	}

	@Override
	public String toString() {
		return "TbRole [id=" + id + ", roleName=" + roleName + ", roleGrade="
				+ roleGrade + "]";
	}
	
	
}
