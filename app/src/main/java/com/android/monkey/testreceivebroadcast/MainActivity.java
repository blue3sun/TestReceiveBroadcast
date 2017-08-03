package com.android.monkey.testreceivebroadcast;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public final static String TAG = "receiver";

    public final static String ACTION_MY_BROADCAST = "android.intent.action.MY_BROADCAST";
    private TextView mTvText;
    private MyReceiver mMyReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "MainActivity onCreate 执行...");
        setContentView(R.layout.activity_main);
        initView();
        //registReceiver();
    }

    private void registReceiver() {
        mMyReceiver = new MyReceiver();
        mMyReceiver.setCallback(new Callback() {
            @Override
            public void updateUi(String text) {
                if(mTvText!=null&& !TextUtils.isEmpty(text)){
                    mTvText.setText(text);
                }
            }
        });
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_MY_BROADCAST);
        registerReceiver(mMyReceiver,filter);
    }


    private void initView() {
        mTvText = (TextView)findViewById(R.id.tv_text);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //unregisterReceiver();
    }

    private void unregisterReceiver() {
        unregisterReceiver(mMyReceiver);
    }

    public interface Callback{
        void updateUi(String text);
    }
}
