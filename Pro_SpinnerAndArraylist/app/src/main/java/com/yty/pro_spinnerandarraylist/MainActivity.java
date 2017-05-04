package com.yty.pro_spinnerandarraylist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String[] countries = {"1","2","a","b"};
    private TextView myTextView;
    private EditText myEditext;
    private Button myButton_add;
    private Button myButton_delete;
    private Spinner mySpinner;
    private ArrayAdapter adapter;
    private List allCountries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i = 0 ;i < countries.length ;i++)
        {
            allCountries.add(countries[i]);
        }
        adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,allCountries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        myTextView = (TextView)findViewById(R.id.myTextView);
        myEditext = (EditText)findViewById(R.id.myEditText);
        myButton_add = (Button) findViewById(R.id.myButton_add);
        myButton_delete = (Button) findViewById(R.id.myButton_remove);
        mySpinner = (Spinner) findViewById(R.id.mySpinner);

        mySpinner.setAdapter(adapter);
        myButton_add.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public  void onClick(View v)
            {
                String newCountry = myEditext.getText().toString();
                for(int i = 0 ; i < adapter.getCount() ; i++)
                {
                    if(newCountry.equals(adapter.getItem(i)));
                    {
                        return;
                    }
                }
                if(!newCountry.equals(""))
                {
                    adapter.add(newCountry);
                    int position = adapter.getPosition(newCountry);
                    mySpinner.setSelection(position);
                    myEditext.setText("");
                }
            }
        });

        myButton_delete.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(mySpinner.getSelectedItem() != null)
                {
                    adapter.remove(mySpinner.getSelectedItem().toString());
                    myEditext.setText("");
                    if(adapter.getCount() == 0 )
                    {
                        myTextView.setText("");
                    }
                }
            }
        });

        mySpinner.setOnItemClickListener(new Spinner.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView a,View b,int c,long d)
            {
                myTextView.setText(a.getSelectedItem().toString());
            }
            @Override
            public void onMothingSelected(AdapterView a)
            {
            }
        });
    }
    @Override
    public  boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return  true;
    }

}
