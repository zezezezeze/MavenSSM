package com.millery.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TbGroup implements Serializable {
	private Integer id;
	private String classYear;
	private Integer classNum;
	private String classType;
	
	public TbGroup() {
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClassYear() {
		return classYear;
	}
	public void setClassYear(String classYear) {
		this.classYear = classYear;
	}
	public Integer getClassNum() {
		return classNum;
	}
	public void setClassNum(Integer classNum) {
		this.classNum = classNum;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	@Override
	public String toString() {
		return "TbGroup [id=" + id + ", classYear=" + classYear + ", classNum="
				+ classNum + ", classType=" + classType + "]";
	}
	
}
