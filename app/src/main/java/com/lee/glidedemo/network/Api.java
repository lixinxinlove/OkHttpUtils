package com.lee.glidedemo.network;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
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


    //上传单个文件
    public void postFile(RequestCallback requestCallback, String filepath) {

        MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");

        File file = new File(filepath);
        Request request = new Request.Builder()
                .url("https://api.github.com/markdown/raw")
                .post(RequestBody.create(MEDIA_TYPE_MARKDOWN, file))
                .build();

        RequestCallbackImpl callback = new RequestCallbackImpl(requestCallback);
        Call call = client.newCall(request);
        requestCallback.setCall(call);
        call.enqueue(callback);
    }


    /**
     * 图文上传
     *
     * @param requestCallback
     * @param file
     */
    public void postMultipart(RequestCallback requestCallback, File file) {
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);

        builder.addPart(Headers.of("Content-Disposition", "form-data; name=\"file\";filename=\"file.jpg\""),
                RequestBody.create(MediaType.parse("image/png"), file)).build();

        builder.addFormDataPart("name", "lee");
        builder.addFormDataPart("title", "title");
        RequestBody body = builder.build();

        Request request = new Request.Builder().url("http://www.baidu.com").post(body).build();
        Call call = client.newCall(request);
        requestCallback.setCall(call);

        RequestCallbackImpl callback = new RequestCallbackImpl(requestCallback);
        call.enqueue(callback);

    }

    /**
     * 下载文件
     */
    public void downFile(final RequestCallback requestCallback, String url) {

        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) {
                InputStream inputStream = response.body().byteStream();
                FileOutputStream fileOutputStream = null;

                String fileName= System.currentTimeMillis()+"lee.jpg";

                try {
                    fileOutputStream = new FileOutputStream(new File("/sdcard/"+fileName));
                    byte[] buffer = new byte[2048];
                    int len = 0;
                    while ((len = inputStream.read(buffer)) != -1) {
                        fileOutputStream.write(buffer, 0, len);
                    }
                    fileOutputStream.flush();
                } catch (IOException e) {
                    Log.i("wangshu", "IOException");
                    e.printStackTrace();
                }


                final ResponseEntity entity = new ResponseEntity();
                entity.data="文件下载成功";
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        requestCallback._RequestCallback(entity);
                    }
                });

                Log.d("wangshu", "文件下载成功");
            }
        });
    }


//============================================================================//

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