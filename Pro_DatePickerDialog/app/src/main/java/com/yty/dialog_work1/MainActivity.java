package com.yty.dialog_work1;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    private TextView showdate;
    private Button setdate;
    private int year;
    private int month;
    private int day;



    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showdate = (TextView)this.findViewById(R.id.showtime);
        setdate = (Button)this.findViewById(R.id.setdate);



        Calendar C = Calendar.getInstance(Locale.CHINA);
        Date mydate = new Date();
        C.setTime(mydate);
        year =  C.get(Calendar.YEAR);
        month = C.get(Calendar.MONTH);
        day = C.get(Calendar.DAY_OF_MONTH);
        showdate.setText("当前日期:"+year+"-"+month+"-"+day);

        setdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog my_datePickDialog = new DatePickerDialog(MainActivity.this, Datelistener,year,month,day);
                my_datePickDialog.show();
            }
        });
    }
    private DatePickerDialog.OnDateSetListener Datelistener = new DatePickerDialog.OnDateSetListener()
    {
        @Override
        public void onDateSet(DatePicker v,int y,int m,int d)
        {
            Builder alert_dialog = new AlertDialog.Builder(MainActivity.this);
            alert_dialog.setTitle("警告");
            alert_dialog.setMessage("不可超过当前日期");
            alert_dialog.setPositiveButton("知道了", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Calendar C = Calendar.getInstance(Locale.CHINA);
                    Date mydate = new Date();
                    C.setTime(mydate);
                    year =  C.get(Calendar.YEAR);
                    month = C.get(Calendar.MONTH);
                    day = C.get(Calendar.DAY_OF_MONTH);

                }
            });
            alert_dialog.create();
            if( year < y ) {
                alert_dialog.show();
            }
            else if ( month < m )
            {
                alert_dialog.show();
            }
            else if ( day < d )
            {
                alert_dialog.show();
            }
            else {
                //更新日期
                year = y;
                month = m;
                day = d;
                updateDate();
            }
        }
        private void updateDate() {
            showdate.setText("当前日期:"+year+"-"+month+"-"+day);
        }
    };


}
