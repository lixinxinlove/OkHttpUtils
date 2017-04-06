package com.lee.glidedemo.http;

import okhttp3.Call;

public abstract class EventRequestCallback {

	private Call mCall;
	/**
	 * 请求结果回调
	 * 
	 * @param res
	 */
	public abstract void _RequestCallback(EventResponseEntity res);

	/**
	 * 请求取消
	 */
	public void _onCancelled() {
	}

	/**
	 * 请求加载中
	 * 
	 * @param total
	 * @param current
	 * @param isUploading
	 */
	public void _onLoading(long total, long current, boolean isUploading) {

	}

	/**
	 * 请求开始
	 */
	public void _onStart() {

	}

	public Call getmCall() {
		return mCall;
	}

	public void setmCall(Call mCall) {
		this.mCall = mCall;
	}
}
