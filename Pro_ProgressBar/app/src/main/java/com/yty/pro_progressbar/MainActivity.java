package com.yty.pro_progressbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar firstbar = null;
    private ProgressBar secondbar = null;
    private Button mybutton = null;
    private int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstbar = (ProgressBar)findViewById(R.id.firstbar);
        secondbar = (ProgressBar)findViewById(R.id.secondbar);
        mybutton =(Button)findViewById(R.id.mybotton);
        mybutton.setOnClickListener(new ButtonListener());
    }

    class ButtonListener implements OnClickListener {
        @Override
        public void onClick(View v)
        {
            if(i == 0 )
            {
                firstbar.setVisibility(View.VISIBLE);
                secondbar.setVisibility(View.VISIBLE);
                firstbar.setMax(200);
            }
            else if ( i <firstbar.getMax())
            {
                firstbar.setProgress(i);
                firstbar.setSecondaryProgress(i+10);
            }
            else
            {
                firstbar.setVisibility(View.GONE);
                secondbar.setVisibility(View.GONE);
            }
            i = i+10;
        }
    }
}
