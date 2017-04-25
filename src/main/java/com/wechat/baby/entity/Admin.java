package com.wechat.baby.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Pattern;

/**
 * Entity - 管理员
 * @author lianghao
 * 2017年3月2日
 */
public class Admin extends BaseEntity{
	
	private static final long serialVersionUID = 1859917939867733708L;
	
	/** "登录令牌"Cookie名称 */
	public static final String LOGIN_TOKEN_COOKIE_NAME = "adminLoginToken";
	
	/** 用户名 */
	private String username;

	/** 密码 */
	private String password;

	/** E-mail */
	private String email;

	/** 姓名 */
	private String realName;
	
	/** 联系方式 */
	private String mobile;
	
	/** 公司*/
	private String company;

	/** 部门 */
	private String department;

	/** 是否启用 */
	private Boolean isEnabled;

	/** 是否锁定 */
	private Boolean isLocked;

	/** 连续登录失败次数 */
	private Integer loginFailureCount;

	/** 锁定日期 */
	private Date lockedDate;

	/** 最后登录IP */
	private String loginIp;

	/** 角色 */
	private Set<Role> roles = new HashSet<Role>();
	
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

	/**
	 * 获取联系方式
	 * 
	 * @return 联系方式
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 设置联系方式
	 * 
	 * @param mobile
	 *        联系方式
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 获取密码
	 * 
	 * @return 密码
	 */
	@Pattern(regexp = "^[^\\s&\"<>]+$")
	public String getPassword() {
		return password;
	}

	/**
	 * 设置密码
	 * 
	 * @param password
	 *            密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取E-mail
	 * 
	 * @return E-mail
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置E-mail
	 * 
	 * @param email
	 *            E-mail
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 获取姓名
	 * 
	 * @return 姓名
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * 设置姓名
	 * 
	 * @param realName
	 *            姓名
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}

	/**
	 * 获取公司
	 * 
	 * @return 公司
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * 设置公司
	 * 
	 * @param company
	 *        公司
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	
	/**
	 * 获取部门
	 * 
	 * @return 部门
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * 设置部门
	 * 
	 * @param department
	 *            部门
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * 获取是否启用
	 * 
	 * @return 是否启用
	 */
	public Boolean getIsEnabled() {
		return isEnabled;
	}

	/**
	 * 设置是否启用
	 * 
	 * @param isEnabled
	 *            是否启用
	 */
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	/**
	 * 获取是否锁定
	 * 
	 * @return 是否锁定
	 */
	public Boolean getIsLocked() {
		return isLocked;
	}

	/**
	 * 设置是否锁定
	 * 
	 * @param isLocked
	 *            是否锁定
	 */
	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}

	/**
	 * 获取连续登录失败次数
	 * 
	 * @return 连续登录失败次数
	 */
	public Integer getLoginFailureCount() {
		return loginFailureCount;
	}

	/**
	 * 设置连续登录失败次数
	 * 
	 * @param loginFailureCount
	 *            连续登录失败次数
	 */
	public void setLoginFailureCount(Integer loginFailureCount) {
		this.loginFailureCount = loginFailureCount;
	}

	/**
	 * 获取锁定日期
	 * 
	 * @return 锁定日期
	 */
	public Date getLockedDate() {
		return lockedDate;
	}

	/**
	 * 设置锁定日期
	 * 
	 * @param lockedDate
	 *            锁定日期
	 */
	public void setLockedDate(Date lockedDate) {
		this.lockedDate = lockedDate;
	}

	/**
	 * 获取最后登录IP
	 * 
	 * @return 最后登录IP
	 */
	public String getLoginIp() {
		return loginIp;
	}

	/**
	 * 设置最后登录IP
	 * 
	 * @param loginIp
	 *            最后登录IP
	 */
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	/**
	 * 获取角色
	 * 
	 * @return 角色
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * 设置角色
	 * 
	 * @param roles
	 *            角色
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
