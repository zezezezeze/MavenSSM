package com.millery.domain;

import java.io.Serializable;

/**
 * @author Jack
 * url µÃÂ¿‡
 * 2017-11-27 22:25
 *
 */
@SuppressWarnings("serial")
public class TbMoudle implements Serializable {
	private Integer id;
	private String name;
	private String url;
	private String descripe;
	private Integer faMoudle;

	public TbMoudle() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescripe() {
		return descripe;
	}

	public void setDescripe(String descripe) {
		this.descripe = descripe;
	}

	public Integer getFaMoudle() {
		return faMoudle;
	}

	public void setFaMoudle(Integer faMoudle) {
		this.faMoudle = faMoudle;
	}

	@Override
	public String toString() {
		return "TbMoudle [id=" + id + ", name=" + name + ", url=" + url
				+ ", descripe=" + descripe + ", faMoudle=" + faMoudle + "]";
	}

}
