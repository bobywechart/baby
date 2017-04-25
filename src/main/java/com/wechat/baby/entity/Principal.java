package com.wechat.baby.entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 身份信息
 * @author lianghao
 * 2017年3月17日
 */
public class Principal implements Serializable {

	private static final long serialVersionUID = -4235082777825781877L;

	/** ID */
	private Long id;

	/** 用户名 */
	private String username;

	/**
	 * @param id
	 *            ID
	 * @param username
	 *            用户名
	 */
	public Principal(Long id, String username) {
		this.id = id;
		this.username = username;
	}

	/**
	 * 获取ID
	 * 
	 * @return ID
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置ID
	 * 
	 * @param id
	 *            ID
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取用户名
	 * 
	 * @return 用户名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置用户名
	 * 
	 * @param username
	 *            用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}