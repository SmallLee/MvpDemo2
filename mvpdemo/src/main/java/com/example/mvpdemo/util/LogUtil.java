package com.example.mvpdemo.util;

import android.content.Context;

import com.example.mvcdemo.BuildConfig;
import com.orhanobut.logger.Logger;

/**
 * Created by lixiaoniu on 2018/1/3.
 * Log工具类
 */

public class LogUtil {
    private static boolean mIsDebug;
    public static void initLog(Context context){
        Logger.init("MvpDemo")
        .methodCount(0);
        mIsDebug = BuildConfig.MODE_DEBUG;
    }

    public static void v(String msg,Object... obj){
        if (mIsDebug) {
            Logger.v(msg,obj);
        }
    }
    public static void w(String msg,Object... obj){
        if (mIsDebug) {
            Logger.w(msg,obj);
        }
    }
    public static void e(String msg,Object... obj){
        if (mIsDebug) {
            Logger.e(msg,obj);
        }
    }
    public static void d(String msg,Object... obj){
        if (mIsDebug) {
            Logger.d(msg,obj);
        }
    }

    public static void json(String json){
        if (mIsDebug) {
            Logger.json(json);
        }
    }

    public LogUtil init(String tag) {
        Logger.init(tag);
        return this;
    }
}
