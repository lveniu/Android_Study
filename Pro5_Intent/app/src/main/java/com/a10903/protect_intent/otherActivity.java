package com.a10903.protect_intent;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class otherActivity extends Activity{
    private Intent intent;
    private Bundle bunde;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other);
		/* È¡µÃIntent ÖÐµÄBundle ¶ÔÏó */
        Bundle bunde = this.getIntent().getExtras();
		/* È¡µÃBundle ¶ÔÏóÖÐµÄÊý¾Ý */
        String ans = bunde.getString("ans");
		/* ÅÐ¶ÏËùÑ¡´ð°¸*/
        String sexText = "";
        if (ans.equals("in")) {
            sexText = "ÕýÈ·";
        } else {
            sexText = "´íÎó";
        }
        TextView tv1 = (TextView) findViewById(R.id.text1);
        tv1.setText("ÄúÑ¡ÔñµÄ´ð°¸ÊÇ£º" + sexText);

		/* ÒÔfindViewById()È¡µÃButton ¶ÔÏó£¬²¢Ìí¼ÓonClickListener */
        Button btn3_back = (Button) findViewById(R.id.button_back);
        btn3_back.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
			/* ·µ»Øresult »ØÉÏÒ»¸öactivity */
                otherActivity.this.setResult(RESULT_OK, intent);
			/* ½áÊøÕâ¸öactivity */
                otherActivity.this.finish();
            }
        });
    }

}




