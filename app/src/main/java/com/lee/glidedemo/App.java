package com.lee.glidedemo;

import android.app.Application;
import android.content.Context;

import com.lee.glidedemo.network.Api;

/**
 * Created by android on 2016/12/21.
 */
public class App extends Application {

    public static Context context;

    public static Api api;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        api=new Api();
    }

    public static Context getApplication() {
        return context;
    }

}
