package com.yty.caculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
            btn_6, btn_7, btn_8, btn_9, btn_equal,
            btn_point, btn_clean, btn_del, btn_zf,
            btn_reduce, btn_multiply, btn_divide,btn_add,btn_mod;
    TextView et_input;
    double temp1,temp2;
    int temp,temp4;
    String s1,s2,s3;
    int flag = 0;
    int flag1 = 0;
    int flag2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_point = (Button) findViewById(R.id.btn_point);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        btn_clean = (Button) findViewById(R.id.btn_clean);
        btn_zf = (Button) findViewById(R.id.btn_zf);
        btn_del = (Button) findViewById(R.id.btn_del);
        btn_divide = (Button) findViewById(R.id.btn_divide);
        btn_multiply = (Button) findViewById(R.id.btn_multiplay);
        btn_mod = (Button) findViewById(R.id.btn_mod);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_reduce = (Button) findViewById(R.id.btn_reduce);

        et_input = (TextView) findViewById(R.id.textshow);


        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_clean.setOnClickListener(this);
        btn_zf.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_reduce.setOnClickListener(this);
        et_input.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String str = et_input.getText().toString();
        str.replace(" ","");
        switch (v.getId()) {
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.btn_point:
                if(((Button) v).getText().equals("."))
                {
                    flag1 = 1;
                }
                if(str.indexOf("0") == 1) {
                    et_input.setText(((Button) v).getText());
                }
                else
                    et_input.setText(str + ((Button) v).getText());
                break;
            case R.id.btn_add:
            case R.id.btn_reduce:
            case R.id.btn_multiplay:
            case R.id.btn_divide:
                if(flag == 0) {
                    if ((temp = str.indexOf("*")) != -1 && (s1 = str.substring(0, temp)) != null && (s2 = str.substring(temp + 1)) != null) {
                        temp1 = Double.parseDouble(s1);
                        temp2 = Double.parseDouble(s2);
                        temp1 = temp1 * temp2;
                        if (flag1 == 0) {
                            int b = (int) temp1;
                            String a = Integer.toString(b);
                            et_input.setText(a + ((Button) v).getText());
                            flag1 = 0;
                        } else {
                            String a = Double.toString(temp1);
                            et_input.setText(a + ((Button) v).getText());
                        }
                        break;
                    }
                    if ((temp = str.indexOf("/")) != -1 && (s1 = str.substring(0, temp)) != null && (s2 = str.substring(temp + 1)) != null) {
                        temp1 = Double.parseDouble(s1);
                        temp2 = Double.parseDouble(s2);
                        temp1 = temp1 / temp2;
                        if (flag1 == 0) {
                            int b = (int) temp1;
                            String a = Integer.toString(b);
                            et_input.setText(a + ((Button) v).getText());
                            flag1 = 0;
                        } else {
                            String a = Double.toString(temp1);
                            et_input.setText(a + ((Button) v).getText());
                        }
                    }
                    if ((temp = str.indexOf("+")) != -1 && (s1 = str.substring(0, temp)) != null && (s2 = str.substring(temp + 1)) != null) {
                        if (((Button) v).getText().equals("*") || ((Button) v).getText().equals("/")) {
                            et_input.setText(str + ((Button) v).getText());
                            flag = temp;
                        } else {
                            temp1 = Double.parseDouble(s1);
                            temp2 = Double.parseDouble(s2);
                            temp1 = temp1 + temp2;
                            if (flag1 == 0) {
                                int b = (int) temp1;
                                String a = Integer.toString(b);
                                et_input.setText(a + ((Button) v).getText());
                                flag1 = 0;
                            } else {
                                String a = Double.toString(temp1);
                                et_input.setText(a + ((Button) v).getText());
                            }
                        }
                        break;
                    }

                    if ((temp = str.indexOf("-")) != -1 && (s1 = str.substring(0, temp)) != null && (s2 = str.substring(temp + 1)) != null) {
                        if (((Button) v).getText().equals("*") || ((Button) v).getText().equals("/")) {
                            et_input.setText(str + ((Button) v).getText());
                            flag = temp;
                        } else {
                            temp1 = Double.parseDouble(s1);
                            temp2 = Double.parseDouble(s2);
                            temp1 = temp1 - temp2;
                            if (flag1 == 0) {
                                int b = (int) temp1;
                                String a = Integer.toString(b);
                                et_input.setText(a + ((Button) v).getText());
                                flag1 = 0;
                            } else {
                                String a = Double.toString(temp1);
                                et_input.setText(a + ((Button) v).getText());
                            }
                            break;
                        }
                        break;
                    }
                    et_input.setText(str + ((Button) v).getText());
                    break;
                }
                else //当存在两位操作符时 第三位操作符来临
                {
                    String s5 = str.substring(0,flag+1);
                    if((temp=str.indexOf("*",flag+1))!= -1 && (s2 = str.substring(temp+1))!= null)
                    {
                        temp1=Double.parseDouble(s1);
                        temp2=Double.parseDouble(s2);
                        temp1 = temp1 * temp2;
                        if(flag1 == 0)
                        {
                            int b = (int)temp1;
                            String a = Integer.toString(b);
                            et_input.setText(s5 + a + ((Button) v).getText());

                        }
                        else {
                            String a = Double.toString(temp1);
                            et_input.setText(s5 + a + ((Button) v).getText());
                            flag1 = 0;
                        }
                        break;
                    }
                    if((temp = str.indexOf("/",flag+1))!= -1 && (s2 = str.substring(flag+temp))!= null)
                    {
                        temp1=Double.parseDouble(s1);
                        temp2=Double.parseDouble(s2);
                        if(temp2 == 0)
                        {
                            et_input.setText(s5 + ((Button) v).getText());
                        }
                        temp1 = temp1 / temp2;
                        if(flag1 == 0)
                        {
                            int b = (int)temp1;
                            String a = Integer.toString(b);
                            et_input.setText(s5 + a + ((Button) v).getText());
                        }
                        else {
                            String a = Double.toString(temp1);
                            et_input.setText(s5 + a + ((Button) v).getText());
                            flag1 = 0;
                        }
                        break;
                    }
                    flag = 0 ;
                    break;
                }

            case R.id.btn_zf:

                if(str.equals(""))
                    et_input.setText("-");
                else {
                    if (str.substring(str.length() - 1, str.length()).equals("-"))
                        et_input.setText(str.substring(0, str.length() - 1));
                    else
                        et_input.setText(str + ((Button) v).getText());
                }
                break;
            case R.id.btn_clean:
                et_input.setText("");
                break;

            case R.id.btn_del:
                if (str != null) {
                    et_input.setText(str.substring(0, str.length() - 1));
                }
                break;
            case R.id.btn_equal:
                getResult(str);
                break;
            default:
                break;
        }
    }

    // 获取结果

    public void getResult(String str)
    {
        //第一位为乘法时
        if((temp = str.indexOf("*"))!= -1 && (s1 = str.substring(0,temp))!= null && (s2 = str.substring(temp+1))!= null)
        {
            if((temp4 = s2.indexOf("*"))!= -1 )
            {
                if(s2.substring(temp4+1) == null) {
                    str = str.substring(0,str.length()-1);
                    s2 = str.substring(temp+1);
                    temp1 = Double.parseDouble(s1);
                    temp2 = Double.parseDouble(s2);
                    temp1 = temp1 * temp2;
                }
                else{
                    s3 = str.substring(temp+1,temp4);
                    s2 = str.substring(temp4+1);
                    temp1=Double.parseDouble(s3);
                    temp2=Double.parseDouble(s2);
                    temp1 = temp1 * temp2;
                    temp2=Double.parseDouble(s1);
                    temp1 = temp2 * temp1;
                }
            }
            else if((temp4 = s2.indexOf("/"))!= -1 )
            {
                if(s2.substring(temp4+1) == null) {
                    str = str.substring(0, str.length() - 1);
                    s2 = str.substring(temp+1);
                    temp1 = Double.parseDouble(s1);
                    temp2 = Double.parseDouble(s2);
                    temp1 = temp1 / temp2;
                }
                else{
                    s3 = str.substring(temp+1,temp4);
                    s2 = str.substring(temp4+1);
                    temp1=Double.parseDouble(s3);
                    temp2=Double.parseDouble(s2);
                    temp1 = temp1 / temp2;
                    if(temp1 == 0)
                        temp1 = 0;
                    temp2=Double.parseDouble(s1);
                    temp1 = temp2 * temp1;
                }
            }
            else if((temp4 = s2.indexOf("+"))!= -1 )
            {
                if(s2.substring(temp4+1) == null) {
                    str = str.substring(0, str.length() - 1);
                    s2 = str.substring(temp+1);
                    temp1 = Double.parseDouble(s1);
                    temp2 = Double.parseDouble(s2);
                    temp1 = temp1 * temp2;
                }
                else{
                    s3 = str.substring(temp+1,temp4);
                    s2 = str.substring(temp4+1);
                    temp1=Double.parseDouble(s1);
                    temp2=Double.parseDouble(s2);
                    temp1 = temp1 * temp2;
                    temp2=Double.parseDouble(s3);
                    temp1 = temp2 + temp1;
                }
            }
            else if((temp4 = s2.indexOf("-"))!= -1 )
            {
                if(s2.substring(temp4+1) == null) {
                    str = str.substring(0, str.length() - 1);
                    s2 = str.substring(temp+1);
                    temp1 = Double.parseDouble(s1);
                    temp2 = Double.parseDouble(s2);
                    temp1 = temp1 * temp2;
                }
                else{
                    s3 = str.substring(temp+1,temp4);
                    s2 = str.substring(temp4+1);
                    temp1=Double.parseDouble(s3);
                    temp2=Double.parseDouble(s2);
                    temp1 = temp1 * temp2;
                    temp2=Double.parseDouble(s1);
                    temp1 = temp2 - temp1;
                }
            }
            else
            {
                temp1 = Double.parseDouble(s1);
                temp2 = Double.parseDouble(s2);
                temp1 = temp1 * temp2;
            }
        }



        //第一位为除法



        else if((temp = str.indexOf("/"))!= -1 && (s1 = str.substring(0,temp))!= null && (s2 = str.substring(temp+1))!= null)
        {
            if((temp4 = s2.indexOf("/"))!= -1 )
            {
                if(s2.substring(temp4+1) == null) {
                    str = str.substring(0, str.length() - 1);
                    s2 = str.substring(temp+1);
                    temp1 = Double.parseDouble(s1);
                    temp2 = Double.parseDouble(s2);
                    temp1 = temp1 * temp2;
                }
                else{
                    s3 = str.substring(temp+1,temp4);
                    s2 = str.substring(temp4+1);
                    temp1=Double.parseDouble(s3);
                    temp2=Double.parseDouble(s2);
                    temp1 = temp1 * temp2;
                    temp2=Double.parseDouble(s1);
                    temp1 = temp2 * temp1;
                }
            }
            else if((temp4 = s2.indexOf("/"))!= -1 )
            {
                if(s2.substring(temp4+1) == null) {
                    str = str.substring(0, str.length() - 1);
                    s2 = str.substring(temp+1);
                    temp1 = Double.parseDouble(s1);
                    temp2 = Double.parseDouble(s2);
                    if(temp2 == 0){
                        temp1 = 0;
                    }
                    else
                        temp1 = temp1 / temp2;
                }
                else{
                    s3 = str.substring(temp+1,temp4);
                    s2 = str.substring(temp4+1);
                    temp1=Double.parseDouble(s3);
                    temp2=Double.parseDouble(s2);
                    temp1 = temp1 / temp2;
                    if(temp1 == 0)
                        temp1 = 0;
                    temp2=Double.parseDouble(s1);
                    if(temp2 == 0){
                        temp1 = 0;
                    }
                    else
                        temp1 = temp1 / temp2;
                }
            }
            else if((temp4 = s2.indexOf("+"))!= -1 )
            {
                if(s2.substring(temp4+1) == null) {
                    str = str.substring(0, str.length() - 1);
                    s2 = str.substring(temp+1);
                    temp1 = Double.parseDouble(s1);
                    temp2 = Double.parseDouble(s2);
                    temp1 = temp1 / temp2;
                }
                else{
                    s3 = str.substring(temp+1,temp4);
                    s2 = str.substring(temp4+1);
                    temp1=Double.parseDouble(s1);
                    temp2=Double.parseDouble(s2);
                    temp1 = temp1 / temp2;
                    temp2=Double.parseDouble(s3);
                    temp1 = temp2 + temp1;
                }
            }
            else if((temp4 = s2.indexOf("-"))!= -1 )
            {
                if(s2.substring(temp4+1) == null) {
                    str = str.substring(0, str.length() - 1);
                    s2 = str.substring(temp+1);
                    temp1 = Double.parseDouble(s1);
                    temp2 = Double.parseDouble(s2);
                    temp1 = temp1 / temp2;
                }
                else{
                    s3 = str.substring(temp+1,temp4);
                    s2 = str.substring(temp4+1);
                    temp1=Double.parseDouble(s1);
                    temp2=Double.parseDouble(s2);
                    temp1 = temp1 / temp2;
                    temp2=Double.parseDouble(s3);
                    temp1 = temp2 - temp1;
                }
            }
            else
            {
                temp1 = Double.parseDouble(s1);
                temp2 = Double.parseDouble(s2);
                temp1 = temp1 / temp2;
            }
        }



        //第一位减法时



        else if((temp = str.indexOf("-"))!= -1 && (s1 = str.substring(0,temp))!= null && (s2 = str.substring(temp+1))!= null) {
            if ((temp4 = s2.indexOf("*")) != -1) {
                if (s2.substring(temp4 + 1) == null) {
                    str = str.substring(0, str.length() - 1);
                    s2 = str.substring(temp + 1);
                    temp1 = Double.parseDouble(s1);
                    temp2 = Double.parseDouble(s2);
                    temp1 = temp1 - temp2;
                } else {
                    s3 = s2.substring(0, temp4);
                    s2 = s2.substring(temp4 + 1);
                    temp1 = Double.parseDouble(s3);
                    temp2 = Double.parseDouble(s2);
                    temp1 = temp1 * temp2;
                    temp2 = Double.parseDouble(s1);
                    temp1 = temp2 - temp1;
                }
            } else if ((temp4 = s2.indexOf("/")) != -1) {
                if (s2.substring(temp4 + 1) == null) {
                    str = str.substring(0, str.length() - 1);
                    s2 = str.substring(temp + 1);
                    temp1 = Double.parseDouble(s1);
                    temp2 = Double.parseDouble(s2);
                    temp1 = temp1 - temp2;
                } else {
                    s3 = s2.substring(0, temp4);
                    s2 = s2.substring(temp4 + 1);
                    temp1 = Double.parseDouble(s3);
                    temp2 = Double.parseDouble(s2);
                    temp1 = temp1 / temp2;
                    if (temp2 == 0)
                        temp1 = 0;
                    temp2 = Double.parseDouble(s1);
                    temp1 = temp2 - temp1;
                }
            } else if ((temp4 = s2.indexOf("+")) != -1) {
                if (s2.substring(temp4 + 1) == null) {
                    str = str.substring(0, str.length() - 1);
                    s2 = str.substring(temp + 1);
                    temp1 = Double.parseDouble(s1);
                    temp2 = Double.parseDouble(s2);
                    temp1 = temp1 - temp2;
                } else {
                    s3 = s2.substring(0, temp4);
                    s2 = s2.substring(temp4 + 1);
                    temp1 = Double.parseDouble(s1);
                    temp2 = Double.parseDouble(s2);
                    temp1 = temp1 - temp2;
                    temp2 = Double.parseDouble(s3);
                    temp1 = temp2 + temp1;
                }
            } else if ((temp4 = s2.indexOf("-")) != -1) {
                if (s2.substring(temp4 + 1) == null) {
                    str = str.substring(0, str.length() - 1);
                    s2 = str.substring(temp + 1);
                    temp1 = Double.parseDouble(s1);
                    temp2 = Double.parseDouble(s2);
                    temp1 = temp1 - temp2;
                }
                else {
                    s3 = s2.substring(0, temp4);
                    s2 = s2.substring(temp4 + 1);
                    temp1 = Double.parseDouble(s3);
                    temp2 = Double.parseDouble(s2);
                    temp1 = temp1 - temp2;
                    temp2 = Double.parseDouble(s1);
                    temp1 = temp2 - temp1;
                }
            }
            else
            {
                temp1 = Double.parseDouble(s1);
                temp2 = Double.parseDouble(s2);
                temp1 = temp1 - temp2;
            }
        }

        //第一位为加法

        else if((temp = str.indexOf("+"))!= -1 && (s1 = str.substring(0,temp))!= null && (s2 = str.substring(temp+1))!= null){
            if ((temp4 = s2.indexOf("*")) != -1) {
                if (s2.substring(temp4 + 1) == null) {
                    str = str.substring(0, str.length() - 1);
                    s2 = str.substring(temp + 1);
                    temp1 = Double.parseDouble(s1);
                    temp2 = Double.parseDouble(s2);
                    temp1 = temp1 - temp2;
                } else {
                    s3 = s2.substring(0, temp4);
                    s2 = s2.substring(temp4 + 1);
                    temp1 = Double.parseDouble(s3);
                    temp2 = Double.parseDouble(s2);
                    temp1 = temp1 * temp2;
                    temp2 = Double.parseDouble(s1);
                    temp1 = temp2 + temp1;
                }
            } else if ((temp4 = s2.indexOf("/")) != -1) {
                if (s2.substring(temp4 + 1) == null) {
                    str = str.substring(0, str.length() - 1);
                    s2 = str.substring(temp + 1);
                    temp1 = Double.parseDouble(s1);
                    temp2 = Double.parseDouble(s2);
                    temp1 = temp1 - temp2;
                } else {
                    s3 = s2.substring(0, temp4);
                    s2 = s2.substring(temp4 + 1);
                    temp1 = Double.parseDouble(s3);
                    temp2 = Double.parseDouble(s2);
                    temp1 = temp1 / temp2;
                    if (temp2 == 0)
                        temp1 = 0;
                    temp2 = Double.parseDouble(s1);
                    temp1 = temp2 + temp1;
                }
            } else if ((temp4 = s2.indexOf("+")) != -1) {
                if (s2.substring(temp4 + 1) ==  null) {
                    str = str.substring(0, str.length() - 1);
                    s2 = str.substring(temp + 1);
                    temp1 = Double.parseDouble(s1);
                    temp2 = Double.parseDouble(s2);
                    temp1 = temp1 + temp2;
                } else {
                    s3 = s2.substring(0, temp4);
                    s2 = s2.substring(temp4 + 1);
                    temp1 = Double.parseDouble(s1);
                    temp2 = Double.parseDouble(s2);
                    temp1 = temp1 + temp2;
                    temp2 = Double.parseDouble(s3);
                    temp1 = temp2 + temp1;
                }
            } else if ((temp4 = s2.indexOf("-")) != -1) {
                if (s2.substring(temp4 + 1) == null) {
                    str = str.substring(0, str.length() - 1);
                    s2 = str.substring(temp + 1);
                    temp1 = Double.parseDouble(s1);
                    temp2 = Double.parseDouble(s2);
                    temp1 = temp1 + temp2;
                }
                else {
                    s3 = s2.substring(0, temp4);
                    s2 = s2.substring(temp4 + 1);
                    temp1 = Double.parseDouble(s3);
                    temp2 = Double.parseDouble(s2);
                    temp1 = temp1 + temp2;
                    temp2 = Double.parseDouble(s1);
                    temp1 = temp2 - temp1;
                }
            }
            else
            {
                temp1 = Double.parseDouble(s1);
                temp2 = Double.parseDouble(s2);
                temp1 = temp1 + temp2;
            }
        }
        else
            temp1 = 0;

        if(flag1 == 0)
        {
            int b = (int)temp1;
            String a = Integer.toString(b);
            et_input.setText(a);
            flag1 = 0;
        }
        else {
            String a = Double.toString(temp1);
            et_input.setText(a);
        }
    }
}
