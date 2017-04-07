package com.lee.glidedemo.http;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.lee.glidedemo.App;
import com.lee.glidedemo.utils.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DataApiForOkHttp {

    public OkHttpClient http;

    private static final String GET_METHOD = "GET";
    private static final String POST_METHOD = "POST";

    private Handler mHandler = new Handler(Looper.getMainLooper());

    public DataApiForOkHttp() {

        http = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
    }

    public void get(String url, EventRequestCallback callback) {
        Request.Builder requestBuilder = new Request.Builder().url(url);
        requestBuilder.method(GET_METHOD, null);
        Request request = requestBuilder.build();
        Call mcall = http.newCall(request);
        callback.setmCall(mcall);
        mcall.enqueue(new EventRequestCallbackImpl(callback));
    }

    public void post(FormBody body, String url, EventRequestCallback callback) {
        Request.Builder requestBuilder = new Request.Builder().url(url);
        //Builder builder = new Builder();
        //FormBody body = builder.add("", "").build();
        requestBuilder.post(body).build();
        Request request = requestBuilder.post(body).build();
        Call mcall = http.newCall(request);
        mcall.enqueue(new EventRequestCallbackImpl(callback));
    }


    public void getData(String url, EventRequestCallback callback) {
        Request.Builder requestBuilder = new Request.Builder().url(url);
        requestBuilder.method(GET_METHOD, null);
        Request request = requestBuilder.build();
        Call mcall = http.newCall(request);
        callback.setmCall(mcall);
        mcall.enqueue(new MyEventRequestCallbackImpl(callback));
    }


    /**
     * 返回结果在io线程
     *
     * @param body
     * @param url
     * @param callback
     */
    public void postAsync(FormBody body, String url, EventRequestCallback callback) {
        Request.Builder requestBuilder = new Request.Builder().url(url);
        //Builder builder = new Builder();
        //FormBody body = builder.add("", "").build();
        requestBuilder.post(body).build();
        Request request = requestBuilder.post(body).build();
        Call mcall = http.newCall(request);
        mcall.enqueue(new EventRequestCallbackAsyncImpl(callback));
    }


    /**
     * 上传文件
     *
     * @param url
     * @param callback
     */
    public void postFile(String url, File file, EventRequestCallback callback) {
        Request.Builder requestBuilder = new Request.Builder().url(url);

        RequestBody body1 = RequestBody.create(MediaType.parse("application/octet-stream"), file);
        RequestBody body2 = RequestBody.create(MediaType.parse("application/octet-stream"), file);


//        MultipartBody.Builder builder= new  MultipartBody.Builder();
//        builder.addFormDataPart("file", "filename1", body1);
//        builder.addFormDataPart("file", "filename1", body1);
//        builder.addFormDataPart("file", "filename1", body1);
//        MultipartBody mBody=builder.build();

        MultipartBody mBody = new MultipartBody.Builder("----").setType(MultipartBody.FORM)
                .addFormDataPart("key", "v")
                .addFormDataPart("file", "filename1", body1)
                .addFormDataPart("file", "filename2", body2)
                .build();

        Request request = requestBuilder
                .post(mBody)
                .build();

        Call mCall = http.newCall(request);
        mCall.enqueue(new EventRequestCallbackAsyncImpl(callback));
    }


    /**
     * 下载文件
     *
     * @param url
     * @param callback
     */
    public void downAsyncFile(String url, EventRequestCallback callback) {
        Request.Builder requestBuilder = new Request.Builder().url(url);
        requestBuilder.method(GET_METHOD, null);
        Request request = requestBuilder.build();
        Call mCall = http.newCall(request);
        callback.setmCall(mCall);
        mCall.enqueue(new EventRequestCallbackDownImpl(callback));
    }


    /**
     * 在UI线程返回
     */
    public class EventRequestCallbackImpl implements Callback {

        private EventRequestCallback mCallback;

        private EventResponseEntity resEntity = new EventResponseEntity();

        public EventRequestCallbackImpl(EventRequestCallback callback) {
            this.mCallback = callback;
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mCallback._onStart();
                }
            });
        }

        @Override
        public void onFailure(Call arg0, IOException arg1) {
            resEntity.code = Config.HTTP_REQUEST_FAILURE;
            resEntity.message = "网络异常";
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mCallback._RequestCallback(resEntity);
                }
            });
        }

        @Override
        public void onResponse(Call arg0, Response response) throws IOException {
            if (response.isSuccessful()) {
                String res = response.body().string();
                try {
                    resEntity = GsonUtils.asJSONToResponseEntity(res);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mCallback._RequestCallback(resEntity);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    resEntity.code = Config.HTTP_REQUEST_JSON_ERROR;
                    resEntity.message = "数据格式错误";
                    resEntity.data = res;
                    mHandler.post(new Runnable() {

                        @Override
                        public void run() {
                            mCallback._RequestCallback(resEntity);
                        }
                    });
                }
            }
        }
    }

    /**
     * 返回数据不解析
     */
    public class MyEventRequestCallbackImpl implements Callback {

        private EventRequestCallback mCallback;

        private EventResponseEntity resEntity = new EventResponseEntity();

        public MyEventRequestCallbackImpl(EventRequestCallback callback) {
            this.mCallback = callback;
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mCallback._onStart();
                }
            });
        }


        @Override
        public void onResponse(Call call, Response response) throws IOException {
            String res = response.body().string();
            resEntity.code = Config.HTTP_REQUEST_SUCCESS;
            resEntity.data = res;
            resEntity.message = "执行成功";

            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mCallback._RequestCallback(resEntity);
                }
            });
        }

        @Override
        public void onFailure(Call call, IOException e) {
            resEntity.code = Config.HTTP_REQUEST_FAILURE;
            resEntity.data = "";
            resEntity.message = "网络异常";
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mCallback._RequestCallback(resEntity);
                }
            });
        }
    }


    /**
     * 异步返回数据
     */
    public class EventRequestCallbackAsyncImpl implements Callback {

        private EventRequestCallback mCallback;

        private EventResponseEntity resEntity = new EventResponseEntity();

        public EventRequestCallbackAsyncImpl(EventRequestCallback callback) {
            this.mCallback = callback;
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mCallback._onStart();
                }
            });
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            if (response.isSuccessful()) {
                String res = response.body().string();
                try {
                    resEntity = GsonUtils.asJSONToResponseEntity(res);
                    mCallback._RequestCallback(resEntity);
                } catch (Exception e) {
                    e.printStackTrace();
                    resEntity.code = Config.HTTP_REQUEST_JSON_ERROR;
                    resEntity.message = "数据格式错误";
                    resEntity.data = res;
                    mCallback._RequestCallback(resEntity);
                }
            }
        }

        @Override
        public void onFailure(Call call, IOException e) {
            resEntity.code = Config.HTTP_REQUEST_FAILURE;
            resEntity.data = "";
            resEntity.message = "网络异常";
            mCallback._RequestCallback(resEntity);
        }
    }


    /**
     * 下载文件
     */
    public class EventRequestCallbackDownImpl implements Callback {

        private EventRequestCallback mCallback;

        private EventResponseEntity resEntity = new EventResponseEntity();

        private EventRequestCallbackDownImpl(EventRequestCallback mCallback) {
            this.mCallback = mCallback;
        }

        @Override
        public void onFailure(Call call, IOException e) {
            Log.i("wangshu", "下载失败");
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {

            if (response.isSuccessful()) {
                InputStream inputStream = response.body().byteStream();
                FileOutputStream fileOutputStream;
                try {
                    File cacheDir = FileUtils.getOwnCacheDirectory(App.context, "lixinxin/ImageCache");
                    File img = new File(cacheDir, "lee.jpg");
                    fileOutputStream = new FileOutputStream(img);
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = inputStream.read(buffer)) != -1) {
                        fileOutputStream.write(buffer, 0, len);
                    }
                    fileOutputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.d("wangshu", "文件下载成功");
            }
        }
    }
}
