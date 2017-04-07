package com.lee.glidedemo.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;


/**
 * 完成一次下载任务
 */
public class DownLoadService extends IntentService {


    public DownLoadService() {
        super("DownLoadService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (action.equals("lee")) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Intent intent1 = new Intent("lee");

            LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent1);
        }
    }
}
