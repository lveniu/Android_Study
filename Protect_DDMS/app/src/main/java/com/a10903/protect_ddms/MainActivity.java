package com.a10903.protect_ddms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String ActivityKey = "LogActivity";
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.v(MainActivity.ActivityKey, "FirstAcvity ---> onCreate");

        bt = (Button)findViewById(R.id.fbotton);
        bt.setText("open second activity");
        bt.setOnClickListener(new ButtonOnClickListener());
    }

    private class ButtonOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,SecondActivity.class);
            MainActivity.this.startActivity(intent);
        }
    }
    @Override
    protected void onDestroy() {
        Log.v(MainActivity.ActivityKey, "FirstAcvity --->onDestory");
        super.onDestroy();
    }
    @Override
    protected void onPause() {
        Log.v(MainActivity.ActivityKey, "FirstAcvity --->onPause");
        super.onPause();
    }
    @Override
    protected void onRestart() {
        Log.v(MainActivity.ActivityKey, "FirstAcvity --->onRestart");
        super.onRestart();
    }
    @Override
    protected void onStart() {
        Log.v(MainActivity.ActivityKey, "FirstAcvity --->onStart");
        super.onStart();
    }
    @Override
    protected void onStop() {
        Log.v(MainActivity.ActivityKey, "FirstAcvity --->onStop");
        super.onStop();
    }
}
