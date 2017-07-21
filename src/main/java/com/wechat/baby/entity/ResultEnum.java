package com.wechat.baby.entity;

/**
 * Entity - 错误码信息
 * @author lianghao 
 * 2017年3月2日
 */
public enum ResultEnum {
    SUCCESS(000000, "操作成功"),
	// 数据库操作异常
	DB_INSERT_ERROR(100001, "db insert error"), 
	DB_UPDATE_ERROR(100002, "db update error"), 
	DB_DELETE_ERROR(100003, "db delete error"),
	DB_QUERY_ERROR(100004, "db query error"),

	// 系统异常
	INNER_ERROR(200001, "系统错误"), 
	TOKEN_IS_ILLICIT(200002, "Token验证非法"), 
	SESSION_IS_OUT_TIME(200003, "会话超时"),

	// 用户相关异常
	INVALID_USER(300001, "无效用户");

	/** 错误码 */
	private int code;
	/** 错误信息描述 */
	private String msg;

	private ResultEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
