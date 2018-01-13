package com.example.mvpdemo.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_base);
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
