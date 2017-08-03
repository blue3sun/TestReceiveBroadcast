package com.android.monkey.testreceivebroadcast;

import android.app.Application;
import android.util.Log;

/**
 * Description:
 * Author: monkey
 * Time: 2017/1/4 18:03
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(MainActivity.TAG, "MyApplication onCreate执行...");
    }
}
