package com.yty.intentbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by 1090 on 2017/4/28.
 */

public class Other extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        String value = intent.getStringExtra("a");
        Log.e("IntentReceiver --> test" ,value);
    }

}
