package com.a10903.protect_ddms;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
/**
 * Created by 1090 on 2017/3/31.
 */

public class SecondActivity extends AppCompatActivity {
    private static final String activitykey ="LogActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(SecondActivity.activitykey,"SecondActivity--->onCreate");
        super.onCreate(savedInstanceState);
    }
    @Override
    protected void onDestroy() {
        Log.v(SecondActivity.activitykey,"SecondActivity--->onCreate");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.v(SecondActivity.activitykey,"SecondActivity--->onPause");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        Log.v(SecondActivity.activitykey,"SecondActivity--->onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.v(SecondActivity.activitykey,"SecondActivity--->onResume");
        super.onResume();
    }

    @Override
    protected void onStart() {
        Log.v(SecondActivity.activitykey,"SecondActivity--->onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.v(SecondActivity.activitykey,"SecondActivity--->onStop");
        super.onStop();
    }
}
