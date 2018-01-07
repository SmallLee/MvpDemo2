package com.example.mvpdemo.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mvcdemo.R;

public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        detachView();
    }
    public abstract void initPresenter();
    public abstract void detachView();
}
