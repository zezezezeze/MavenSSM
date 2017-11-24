package com.millery.domain;

import java.io.Serializable;

/**
 * 用户信息
 */
@SuppressWarnings("serial")
public class User implements Serializable{
    // 成员变量
	private String u_Id;
	private String u_Name;
	private String u_Sex;
	private String u_Age;
	private String u_phone;
	private String u_password;

    // 构造函数
    public User() {
       
    }

	public User(String u_Id, String u_Name, String u_Sex, String u_Age,
			String u_phone, String u_password) {
		super();
		this.u_Id = u_Id;
		this.u_Name = u_Name;
		this.u_Sex = u_Sex;
		this.u_Age = u_Age;
		this.u_phone = u_phone;
		this.u_password = u_password;
	}

	public String getU_Id() {
		return u_Id;
	}

	public void setU_Id(String u_Id) {
		this.u_Id = u_Id;
	}

	public String getU_Name() {
		return u_Name;
	}

	public void setU_Name(String u_Name) {
		this.u_Name = u_Name;
	}

	public String getU_Sex() {
		return u_Sex;
	}

	public void setU_Sex(String u_Sex) {
		this.u_Sex = u_Sex;
	}

	public String getU_Age() {
		return u_Age;
	}

	public void setU_Age(String u_Age) {
		this.u_Age = u_Age;
	}

	public String getU_phone() {
		return u_phone;
	}

	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	@Override
	public String toString() {
		return "User [u_Id=" + u_Id + ", u_Name=" + u_Name + ", u_Sex=" + u_Sex
				+ ", u_Age=" + u_Age + ", u_phone=" + u_phone + ", u_password="
				+ u_password + "]";
	}
    
}