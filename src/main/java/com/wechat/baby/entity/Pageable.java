package com.wechat.baby.entity;

import java.io.Serializable;

/**
 * 分页信息
 * @author lianghao
 * 2017年4月21日
 */
public class Pageable implements Serializable {

	private static final long serialVersionUID = -3930180379790344299L;

	/** 默认页码 */
	private static final int DEFAULT_PAGE_NUMBER = 1;

	/** 默认每页记录数 */
	private static final int DEFAULT_PAGE_SIZE = 20;

	/** 最大每页记录数 */
	private static final int MAX_PAGE_SIZE = 200;

	/** 页码 */
	private int pageNumber = DEFAULT_PAGE_NUMBER;

	/** 每页记录数 */
	private int pageSize = DEFAULT_PAGE_SIZE;

	/** 搜索值 */
	private String searchValue;

	/**
	 * 初始化一个新创建的Pageable对象
	 */
	public Pageable() {
	}

	/**
	 * 初始化一个新创建的Pageable对象
	 * 
	 * @param pageNumber
	 *            页码
	 * @param pageSize
	 *            每页记录数
	 */
	public Pageable(Integer pageNumber, Integer pageSize) {
		if (pageNumber != null && pageNumber >= 1) {
			this.pageNumber = pageNumber;
		}
		if (pageSize != null && pageSize >= 1 && pageSize <= MAX_PAGE_SIZE) {
			this.pageSize = pageSize;
		}
	}

	/**
	 * 获取页码
	 * 
	 * @return 页码
	 */
	public int getPageNumber() {
		return pageNumber;
	}

	/**
	 * 设置页码
	 * 
	 * @param pageNumber
	 *            页码
	 */
	public void setPageNumber(int pageNumber) {
		if (pageNumber < 1) {
			pageNumber = DEFAULT_PAGE_NUMBER;
		}
		this.pageNumber = pageNumber;
	}

	/**
	 * 获取每页记录数
	 * 
	 * @return 每页记录数
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 设置每页记录数
	 * 
	 * @param pageSize
	 *            每页记录数
	 */
	public void setPageSize(int pageSize) {
		if (pageSize < 1 || pageSize > MAX_PAGE_SIZE) {
			pageSize = DEFAULT_PAGE_SIZE;
		}
		this.pageSize = pageSize;
	}

	/**
	 * 获取搜索值
	 * 
	 * @return 搜索值
	 */
	public String getSearchValue() {
		return searchValue;
	}

	/**
	 * 设置搜索值
	 * 
	 * @param searchValue
	 *            搜索值
	 */
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pageNumber;
		result = prime * result + pageSize;
		result = prime * result + ((searchValue == null) ? 0 : searchValue.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pageable other = (Pageable) obj;
		if (pageNumber != other.pageNumber)
			return false;
		if (pageSize != other.pageSize)
			return false;
		if (searchValue == null) {
			if (other.searchValue != null)
				return false;
		} else if (!searchValue.equals(other.searchValue))
			return false;
		return true;
	}
}