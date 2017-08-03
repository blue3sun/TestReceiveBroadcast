package com.android.monkey.testreceivebroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Description:自定义广播接收器
 * Author: monkey
 * Time: 2017/1/5 9:57
 */

public class MyReceiver extends BroadcastReceiver {
    private MainActivity.Callback callback;

    public void setCallback(MainActivity.Callback callback) {
        this.callback = callback;//接收到广播之后的回调
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent!=null){
            String action = intent.getAction();
            Log.e(MainActivity.TAG, "接收到的广播 action: "+action);
            if(action!=null && action.equals(MainActivity.ACTION_MY_BROADCAST)){
                String text = intent.getStringExtra("data");
                if(callback!=null){
                    callback.updateUi(text);
                }
            }
        }
    }
}