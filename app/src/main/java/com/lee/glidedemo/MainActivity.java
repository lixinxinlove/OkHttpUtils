package com.lee.glidedemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lee.glidedemo.activity.RecyclerViewActivity;
import com.lee.glidedemo.http.DataApiForOkHttp;
import com.lee.glidedemo.http.EventRequestCallback;
import com.lee.glidedemo.http.EventResponseEntity;
import com.lee.glidedemo.network.RequestCallback;
import com.lee.glidedemo.network.ResponseEntity;
import com.lee.glidedemo.service.DownLoadService;
import com.lee.glidedemo.utils.FileUtils;
import com.lee.glidedemo.utils.HanziToPinyin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String DATA = "我是中国人";

    ImageView imageView;
    Button btn;

    ViewGroup.LayoutParams params;
    ValueAnimator anim;

    TextView tv;

    Button btnJS;

    Button btnOkHttp;
    Button btnPostImageText;
    Button btnDown;
    Button btnTake;
    ImageView ivTake;


    private LocalReceiver localReceiver;
    private IntentFilter intentFilter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initReceiver();

        pingYing();


        ivTake = (ImageView) findViewById(R.id.iv_take);

        btnTake = (Button) findViewById(R.id.btn_take_1);

        btnTake.setOnClickListener(this);

        imageView = (ImageView) findViewById(R.id.iv);
        tv = (TextView) findViewById(R.id.tv);

        btnJS = (Button) findViewById(R.id.btn_js);

        btnOkHttp = (Button) findViewById(R.id.btn_ok_http);
        btnPostImageText = (Button) findViewById(R.id.btn_post);
        btnDown = (Button) findViewById(R.id.btn_down);
        btnDown.setOnClickListener(this);


        btnPostImageText.setOnClickListener(this);

        btnOkHttp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // App.api.login(callback);
                App.api.userLogin(callback);

                Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                //intent.putExtra("transition", "explode");
                //intent.putExtra("transition", "slide");
                intent.putExtra("transition", "fade");
                startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this).toBundle());


            }
        });

        btnJS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, WebActivity.class));
            }
        });

        SpannableStringBuilder ssb = new SpannableStringBuilder();
        ssb.append("北京有雾霾小心了");
        BackgroundColorSpan bgCS = new BackgroundColorSpan(Color.parseColor("#FF0000"));
        ssb.setSpan(bgCS, 0, 4, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        tv.setText(ssb);

        params = imageView.getLayoutParams();

        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "alpha", 1f, 0f, 1f);
                animator.setDuration(5000);


                ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f);
                animator2.setDuration(5000);


                ObjectAnimator animator3 = ObjectAnimator.ofFloat(imageView, "scaleY", 1f, 3f, 1f);
                animator3.setDuration(5000);


                ObjectAnimator animator4 = ObjectAnimator.ofFloat(imageView, "scaleX", 1f, 4f, 1f);
                animator4.setDuration(5000);


                AnimatorSet animSet = new AnimatorSet();
                animSet.play(animator2).with(animator3).after(animator4);
                animSet.setDuration(5000);
                //animSet.start();

                //  anim.start();
                //startActivity(new Intent(MainActivity.this, TabLayoutActivity.class));

//                Intent intent = new Intent();
//                intent.setAction("com.lee.glidedemo.ScrollingActivity");
//                Bundle bundle = new Bundle();
//                bundle.putString("id", "lixinxin");
//                intent.putExtras(bundle);
//                startActivity(intent);


                imageView.animate().x(500).y(1000).setDuration(5000).setInterpolator(new BounceInterpolator());


            }
        });


        anim = ValueAnimator.ofInt(0, 500);
        //anim.setInterpolator(new AccelerateInterpolator(2f));
        anim.setInterpolator(new BounceInterpolator());
        anim.setDuration(3000);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentValue = (int) animation.getAnimatedValue();
                params.width = currentValue;
                params.height = currentValue;
                imageView.setLayoutParams(params);
            }
        });


        Glide.with(this)
                .load("http://ww2.sinaimg.cn/large/610dc034gw1farbzjliclj20u00u076w.jpg")
                .thumbnail(0.1f)
                .dontAnimate()
                .centerCrop()
                .into(imageView);


        // initStatus();


        ivTake.setOnClickListener(this);


    }

    private void initReceiver() {

        localReceiver = new LocalReceiver();
        intentFilter = new IntentFilter();
        intentFilter.addAction("lee");

        LocalBroadcastManager.getInstance(this).registerReceiver(localReceiver, intentFilter);


    }

    private void pingYing() {

        ArrayList<HanziToPinyin.Token> tokens = HanziToPinyin.getInstance().get(DATA);
        for (HanziToPinyin.Token token : tokens) {
            Log.e("lee", "sourec" + token.source);
            Log.e("lee", "sourec" + token.type);
            Log.e("lee", "sourec" + token.target);
        }

    }

    private void initStatus() {

        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.component);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.mipmap.component_filling);

        Drawable mFocusedDrawable = new BitmapDrawable(getResources(), bitmap2);
        Drawable mDefaultDrawable = new BitmapDrawable(getResources(), bitmap1);
        Drawable mEnabledPressedDrawable = new BitmapDrawable(getResources(), bitmap2);
        StateListDrawable drawable = new StateListDrawable();

        drawable.addState(new int[]{android.R.attr.state_focused}, mFocusedDrawable);
        drawable.addState(new int[]{android.R.attr.state_enabled, android.R.attr.state_pressed}, mEnabledPressedDrawable);
        drawable.addState(new int[0], mDefaultDrawable);

        drawable.setBounds(0, 0, 64, 64);

        ivTake.setImageDrawable(drawable);


        DataApiForOkHttp http = new DataApiForOkHttp();
        http.downAsyncFile("http://ww2.sinaimg.cn/large/610dc034gw1farbzjliclj20u00u076w.jpg", mCallback);

        String url = "http://ww2.sinaimg.cn/large/610dc034gw1farbzjliclj20u00u076w.jpg";


        File cacheDir = FileUtils.getOwnCacheDirectory(App.context, "lee/ImageCache");
        File img = new File(cacheDir, "lee.jpg");

//       DownloadTask task = new DownloadTask(new DownloadListener() {
//            @Override
//            public void onProgress(int progress) {
//
//                Log.e("progress=", "--" + progress);
//            }
//
//            @Override
//            public void onSuccess() {
//
//            }
//
//            @Override
//            public void onFailed() {
//
//            }
//
//            @Override
//            public void onPaused() {
//
//            }
//
//            @Override
//            public void onCanceled() {
//
//            }
//        }, img);
//
//
//        task.execute(url);


        Intent i = new Intent(this, DownLoadService.class);
        i.setAction("lee");
        startService(i);


    }


    EventRequestCallback mCallback = new EventRequestCallback() {
        @Override
        public void _RequestCallback(EventResponseEntity res) {

        }
    };


    RequestCallback callback = new RequestCallback() {
        @Override
        public void _RequestCallback(ResponseEntity res) {
            Toast.makeText(MainActivity.this, res.data, Toast.LENGTH_LONG).show();
            Log.e("lee", res.data);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        callback._onCancelled();
        Log.e("", "callback");
        LocalBroadcastManager.getInstance(this).unregisterReceiver(localReceiver);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_post:

                String filePath = getCacheDir().getPath();
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                File dirFile = new File(filePath);
                if (!dirFile.exists()) {
                    dirFile.mkdir();
                }
                File myCaptureFile = new File(filePath + "lee.png");
                BufferedOutputStream bos = null;
                try {
                    bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bos);
                try {
                    bos.flush();
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                File file = new File(filePath + "lee.png");
                App.api.postMultipart(callback, file);
                break;
            case R.id.btn_down:
                // App.api.downFile(requestCallback, "http://ohhic2rt3.bkt.clouddn.com/lee0.jpg-CSDN");
                App.api.login(callback);

                break;

            case R.id.btn_take_1:
                initStatus();
                // startActivity(new Intent(this, TakePhoneActivity.class));
                break;
        }
    }


    RequestCallback requestCallback = new RequestCallback() {
        @Override
        public void _RequestCallback(ResponseEntity res) {

            Toast.makeText(MainActivity.this, res.data, Toast.LENGTH_SHORT).show();
        }
    };


    class LocalReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("lee")) {
                Toast.makeText(MainActivity.this, "收到广播", Toast.LENGTH_LONG).show();
            }
        }
    }


}









