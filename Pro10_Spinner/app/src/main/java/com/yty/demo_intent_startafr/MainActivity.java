package com.yty.demo_intent_startafr;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String[] countriesStr ={ "广州", "汕头", "汕尾", "深圳" };
    private TextView myTextView;
    private Spinner mySpinner;
    private ArrayAdapter adapter;
    Animation myAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTextView = (TextView)findViewById(R.id.myTextView);
        mySpinner = (Spinner)findViewById(R.id.mySpinner);
        adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,countriesStr);

        adapter.setDropDownViewResource(R.layout.myspinner_dropdown);
        mySpinner.setAdapter(adapter);

        mySpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            @Override
            public void onNothingSelected(AdapterView adapterView) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onItemSelected(AdapterView arg0, View arg1,int arg2,long arg3)
            {
                myTextView.setText("选择的是: " + countriesStr[arg2]);
                arg0.setVisibility(View.VISIBLE);
            }
        });
        myAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_main);
        mySpinner.setOnTouchListener(new Spinner.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                v.startAnimation(myAnimation);
                v.setVisibility(View.INVISIBLE);
                return false;
            }
        });
        mySpinner.setOnFocusChangeListener(new Spinner.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v,boolean hasFocus)
            {
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
}
