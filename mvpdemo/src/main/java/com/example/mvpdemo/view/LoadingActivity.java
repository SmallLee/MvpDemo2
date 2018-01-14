package com.example.mvpdemo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.example.mvcdemo.R;
import com.example.mvpdemo.util.BackgroundUtil;
import com.example.mvpdemo.util.LogUtil;

import java.util.Timer;
import java.util.TimerTask;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
//        StatusBarUtil.setColor(this,getResources().getColor(R.color.ee68e1));
//        StatusBarUtil.setTransparent(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                LogUtil.d("isAppOnForeground: "+BackgroundUtil.isAppOnForeground());
                if (BackgroundUtil.isAppOnForeground()) {
                    Intent intent = new Intent(LoadingActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },1000);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        LogUtil.e("onBackPressed");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return keyCode == KeyEvent.KEYCODE_BACK || super.onKeyDown(keyCode, event);
    }
}
