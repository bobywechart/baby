package com.wechat.baby.entity;

import java.io.Serializable;

/**
 * Entity - 业务处理结果封装实体
 * @author lianghao 
 * 2017年3月2日
 */
public class Result<T> implements Serializable {

	private static final long serialVersionUID = -6227698520255954335L;

	/** 是否成功标志 */
	private boolean success;
	/** 成功时返回的数据 */
	private T data;
	/** 错误信息 */
	private String error;

	public Result(boolean success, T data) {
		super();
		this.success = success;
		this.data = data;
	}

	public Result(boolean success, String error) {
		super();
		this.success = success;
		this.error = error;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
