package com.lee.glidedemo;

import android.util.Log;
import android.webkit.JavascriptInterface;

/**
 * Created by lixinxin on 2016/4/20.
 */
public class JJavaScriptInterface {

    @JavascriptInterface
    public void getContentHeight(String value) {
        if (value != null) {
            int webViewContentHeight = Integer.parseInt(value);

            Log.e("lxx",webViewContentHeight+"");
        }
    }
}
