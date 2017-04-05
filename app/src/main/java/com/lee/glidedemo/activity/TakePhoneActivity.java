package com.lee.glidedemo.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.lee.glidedemo.R;
import com.lee.glidedemo.utils.FileUtils;

import java.io.File;

public class TakePhoneActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btn_take_phone;
    private ImageView iv_take_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_phone);

        btn_take_phone = (Button) findViewById(R.id.btn_take_phone);
        iv_take_phone = (ImageView) findViewById(R.id.iv_take_phone);

        btn_take_phone.setOnClickListener(this);


        IntentFilter intentFilter = new IntentFilter("lee");
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_take_phone:
                take();
                break;
        }
    }

    String imgPath = FileUtils.generateImgePath();
    File imgFile = new File(imgPath);
    Uri imgUri = null;

    private void take() {
        imgUri = Uri.fromFile(imgFile);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imgUri);
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            iv_take_phone.setImageBitmap(BitmapFactory.decodeFile(imgPath));
        }
    }
}
