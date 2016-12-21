package com.lee.glidedemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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
import com.lee.glidedemo.network.RequestCallback;
import com.lee.glidedemo.network.ResponseEntity;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button btn;

    ViewGroup.LayoutParams params;
    ValueAnimator anim;

    TextView tv;

    Button btnJS;


    Button btnOkHttp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageView = (ImageView) findViewById(R.id.iv);
        tv = (TextView) findViewById(R.id.tv);

        btnJS = (Button) findViewById(R.id.btn_js);

        btnOkHttp = (Button) findViewById(R.id.btn_ok_http);

        btnOkHttp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // App.api.login(callback);
                App.api.userLogin(callback);
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
    }


    RequestCallback callback = new RequestCallback() {
        @Override
        public void _RequestCallback(ResponseEntity res) {
            Toast.makeText(MainActivity.this, res.data, Toast.LENGTH_LONG).show();
            Log.e("lee",res.data);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        callback._onCancelled();
        Log.e("","callback");
    }
}









