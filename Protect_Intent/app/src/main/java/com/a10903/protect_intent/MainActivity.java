package com.a10903.protect_intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;



public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    RadioButton r1 = null;
    RadioButton r2 = null;
    RadioButton r3 = null;
    RadioButton r4 = null;
    RadioGroup radioGroup = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // »ñµÃµ¥Ñ¡°´Å¥×é
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        // »ñµÃµ¥Ñ¡°´Å¥
        r1 = (RadioButton) findViewById(R.id.a);
        r2 = (RadioButton) findViewById(R.id.b);
        r3 = (RadioButton) findViewById(R.id.c);
        r4 = (RadioButton) findViewById(R.id.d);
        r1.setClickable(true);
        // ¼àÌýµ¥Ñ¡°´Å¥
        //radioGroup.setOnCheckedChangeListener(mChangeRadio);
        Button  btn1_sure =(Button)findViewById(R.id.sure);
        Button  btn2_cancel =(Button)findViewById(R.id.cancel);
        btn1_sure .setOnClickListener(new  btn1_sure ());//ÎªButtonÉèÖÃ¼àÌýÊÂ¼þ
        btn2_cancel.setOnClickListener(new  btn2_cancel());
    }

    class btn1_sure implements OnClickListener{ //°´Å¥ÊÂ¼þ¼àÌýÆ÷Àà£¬ÊµÏÖOnClickListener½Ó¿Ú

        @Override
        public void onClick(View v) {//ÊµÏÖOnClickListener½Ó¿ÚÖÐµÄonClick·½·¨

            String ans ="";
            if(r1.isChecked()){
                ans = "on";
            }
            else if (r2.isChecked()) {

                ans = "at";
            }
            else if (r3.isChecked()) {

                ans = "of";
            }
            else if (r4.isChecked()) {

                ans = "in";
            }
			/* new Ò»¸öIntent ¶ÔÏó£¬²¢Ö¸¶¨class */
            Intent intent = new Intent();
            //ÉèÖÃIntent¶ÔÏóÒªÆô¶¯µÄActivity
            intent.setClass(MainActivity.this, otherActivity.class);
			/* new Ò»¸öBundle¶ÔÏó£¬²¢½«Òª´«µÝµÄÊý¾Ý´«Èë */
            Bundle bundle = new Bundle();
            bundle.putString("ans", ans);
			/* ½«Bundle ¶ÔÏóassign ¸øIntent */
            intent.putExtras(bundle);
            //Æô¶¯Ö¸¶¨Activity²¢µÈ´ý·µ»ØµÄ½á¹û£¬ÆäÖÐ0ÊÇÇëÇóÂë£¬ÓÃÓÚ±êÊ¶¸ÃÇëÇó
            startActivityForResult(intent , 0);


        }

    }
    class  btn2_cancel implements OnClickListener{
        /*
        (APIÖÐ²éÕÒ£¬android.widget public class RadioGroup
        void clearCheck()
        Clears the selection.

         */
        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            radioGroup.clearCheck() ;
            setTitle("");
        }

    }



    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
// TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
//µ±requestCode¡¢resultCodeÍ¬Ê±Îª0£¬Ò²¾ÍÊÇ´¦ÀíÌØ¶¨µÄ½á¹û
        if (requestCode == 0
                && resultCode == 0)
        {


/* È¡µÃÀ´×ÔActivity2 µÄÊý¾Ý£¬²¢ÏÔÊ¾ÓÚ»­ÃæÉÏ */
            Bundle bunde = data.getExtras();
            String ans = bunde.getString("ans");


        }
    }
}