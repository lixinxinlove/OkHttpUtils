package com.lee.glidedemo.http;

import java.io.Serializable;

public class EventResponseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 102L;
	/**
	 * 返回错误code
	 */
	public String code;
	/**
	 * 返回错误信息
	 */
	public String message;
	/**
	 * 返回的数据
	 */
	public String data;

	@Override
	public String toString() {
		return "MarketingResponseEntity [code=" + code + ", message=" + message + ", data=" + data + "]";
	}

}
