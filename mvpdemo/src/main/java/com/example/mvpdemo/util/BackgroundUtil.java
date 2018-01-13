package com.example.mvpdemo.util;

import android.app.ActivityManager;
import android.content.Context;

import com.example.mvpdemo.common.MovieApplication;

import java.util.List;

/**
 * Created by Administrator on 2018/1/13.
 */
public class BackgroundUtil {
    public static boolean isAppOnForeground() {
        ActivityManager activityManager = (ActivityManager) MovieApplication.getInstance().getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        String packageName = MovieApplication.getInstance().getApplicationContext().getPackageName();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo appProcessInfo : runningAppProcesses) {
            if (appProcessInfo.processName.equals(packageName)
                    && appProcessInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return true;
            }
        }
        return false;
    }
}
