package com.lee.glidedemo;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.lee.glidedemo.network.Api;

/**
 * Created by android on 2016/12/21.
 */
public class App extends Application {

    public static Context context;

    public static Api api;
    private static final String TAG = App.class.getSimpleName();
    private static Context mContext;
    private static Thread mMainThread;
    private static long mMainThreadId;
    private static Looper mMainLooper;
    private static Handler mHandler;

    public static Context getContext() {
        return mContext;
    }

    public static Thread getMainThread() {
        return mMainThread;
    }

    public static long getMainThreadId() {
        return mMainThreadId;
    }

    public static Looper getMainThreadLooper() {
        return mMainLooper;
    }

    public static Handler getHandler() {
        return mHandler;
    }

    @Override
    public void onCreate() {
        // 初始化一些，常用的属性，然后放到盒子里面来
        // 上下文
        mContext = getApplicationContext();

        // 主线程
        mMainThread = Thread.currentThread();

        // 主线程id
        mMainThreadId = Process.myTid();

        // tid thread
        // uid user
        // pid process

        mMainLooper = getMainLooper();

        mHandler = new Handler();
        super.onCreate();
        context = this;
        api = new Api();
    }

    public static Context getApplication() {
        return context;
    }

}
