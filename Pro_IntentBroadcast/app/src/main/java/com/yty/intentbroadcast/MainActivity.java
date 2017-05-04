package com.yty.intentbroadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private final  String nobody = "who.help.me";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button bt = (Button)findViewById(R.id.myButton);
        bt.setOnClickListener(new myClickListener());
    }

    class myClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v)
        {
            Intent intent1 = new Intent(nobody);
            intent1.putExtra("a","123");
            sendBroadcast(intent1);
        }
    }
}
