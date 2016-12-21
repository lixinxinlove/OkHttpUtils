package com.lee.glidedemo.network;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by android on 2016/12/21.
 */
public class Api {

    OkHttpClient client;

    final Handler mHandler = new Handler(Looper.getMainLooper());

    public Api() {
        client = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
    }

    public void login(RequestCallback requestCallback) {
        Request.Builder requestBuilder = new Request.Builder().url("http://www.baidu.com");
        Request request = requestBuilder.build();
        Call call = client.newCall(request);
        requestCallback.setCall(call);
        RequestCallbackImpl callback = new RequestCallbackImpl(requestCallback);
        call.enqueue(callback);
    }


    public void userLogin(RequestCallback requestCallback) {
        RequestBody formBody;
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("url", "www.baidu.com");
        builder.add("desc", "10");
        builder.add("type", "ios");
        builder.add("debug", "true");
        builder.add("who", "lee");


        formBody = builder.build();

        Request request = new Request.Builder()
                .url("https://gank.io/api/add2gank")
                .post(formBody)
                .build();
        Call call = client.newCall(request);
        requestCallback.setCall(call);
        RequestCallbackImpl callback = new RequestCallbackImpl(requestCallback);
        call.enqueue(callback);

    }


    class RequestCallbackImpl implements Callback {

        private RequestCallback mCallback;

        private ResponseEntity entity = new ResponseEntity();

        public RequestCallbackImpl(RequestCallback callback) {
            this.mCallback = callback;
        }

        @Override
        public void onFailure(Call call, IOException e) {
            entity.code = "0";
            entity.data = "失败";
            entity.message = "fail";

            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mCallback._RequestCallback(entity);
                }
            });
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            String str = response.body().string();
            entity.code = "1";
            entity.data = str;
            entity.message = "ok";

            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mCallback._RequestCallback(entity);
                }
            });

        }
    }
}