package com.lee.glidedemo.network;

import okhttp3.Call;

/**
 * Created by android on 2016/12/21.
 */
public abstract class RequestCallback {

    private Call call;

    public void setCall(Call call) {
        this.call = call;
    }

    /**
     * 请求结果回调
     *
     * @param res
     */
    public abstract void _RequestCallback(ResponseEntity res);

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

}
