package com.example.mvpdemo.view;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.mvcdemo.R;

public class SecondActivity extends AppCompatActivity {

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        linearLayout = (LinearLayout) findViewById(R.id.ll_container);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showLoginView();
            }
        },2000);
    }

    public void refresh(View view) {
        Toast.makeText(this,"刷新",Toast.LENGTH_SHORT).show();
    }

    public void showLoginView(){
        //xml方式
        Animator animator = AnimatorInflater.loadAnimator(this,R.animator.login_anim);
        animator.setTarget(linearLayout);
        animator.start();
        //代码方式
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(linearLayout, "translationY", 0f, 100f);
        objectAnimator.setDuration(500);
        objectAnimator.start();
    }
}
