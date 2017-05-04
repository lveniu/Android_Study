package com.yty.intent_hide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText phoneNum = (EditText) findViewById(R.id.phonenum);
        final Button bt1 = (Button) findViewById(R.id.button1);
        bt1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v){
                String call = phoneNum.getText().toString();
                if (PhoneNumberUtils.isGlobalPhoneNumber(call)) {
                    Intent intent2 = new Intent(Intent.ACTION_CALL, Uri.parse("tel://" + call));
                    startActivity(intent2);
                }
                else
                {
                    Toast.makeText(MainActivity.this,R.string.notify_incorrect_phonenum,Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
