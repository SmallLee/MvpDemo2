package com.example.mvpdemo.model.net;

import android.util.Log;

import rx.Subscriber;

/**
 * Created by lixiaoniu on 2018/1/3.
 */

public abstract class ResponseObserver<T> extends Subscriber<T> {
    private static final String TAG = "ResponseObserver";
    @Override
    public void onCompleted() {
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }
    public abstract void onSuccess(T t);
}
