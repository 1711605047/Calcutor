package com.example.l.calcutor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_main_0, btn_main_1, btn_main_2, btn_main_3, btn_main_4, btn_main_5, btn_main_6, btn_main_7, btn_main_8, btn_main_9, btn_main_pt;
    Button btn_main_mul, btn_main_div, btn_main_add, btn_main_sub;
    Button btn_main_clr, btn_main_del, btn_main_eq;
    EditText edit_main_input;
    boolean clr_flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_main_0 = (Button) findViewById(R.id.btn_main_0);
        btn_main_1 = (Button) findViewById(R.id.btn_main_1);
        btn_main_2 = (Button) findViewById(R.id.btn_main_2);
        btn_main_3 = (Button) findViewById(R.id.btn_main_3);
        btn_main_4 = (Button) findViewById(R.id.btn_main_4);
        btn_main_5 = (Button) findViewById(R.id.btn_main_5);
        btn_main_6 = (Button) findViewById(R.id.btn_main_6);
        btn_main_7 = (Button) findViewById(R.id.btn_main_7);
        btn_main_8 = (Button) findViewById(R.id.btn_main_8);
        btn_main_9 = (Button) findViewById(R.id.btn_main_9);
        btn_main_pt = (Button) findViewById(R.id.btn_main_pt);
        btn_main_add = (Button) findViewById(R.id.btn_main_add);
        btn_main_sub = (Button) findViewById(R.id.btn_main_sub);
        btn_main_mul = (Button) findViewById(R.id.btn_main_mul);
        btn_main_div = (Button) findViewById(R.id.btn_main_div);
        btn_main_clr = (Button) findViewById(R.id.btn_main_clr);
        btn_main_del = (Button) findViewById(R.id.btn_main_del);
        btn_main_eq = (Button) findViewById(R.id.btn_main_eq);
        edit_main_input = (EditText) findViewById(R.id.edit_main_input);

        btn_main_0.setOnClickListener(this);
        btn_main_1.setOnClickListener(this);
        btn_main_2.setOnClickListener(this);
        btn_main_3.setOnClickListener(this);
        btn_main_4.setOnClickListener(this);
        btn_main_5.setOnClickListener(this);
        btn_main_6.setOnClickListener(this);
        btn_main_7.setOnClickListener(this);
        btn_main_8.setOnClickListener(this);
        btn_main_9.setOnClickListener(this);
        btn_main_pt.setOnClickListener(this);
        btn_main_add.setOnClickListener(this);
        btn_main_sub.setOnClickListener(this);
        btn_main_mul.setOnClickListener(this);
        btn_main_div.setOnClickListener(this);
        btn_main_clr.setOnClickListener(this);
        btn_main_del.setOnClickListener(this);
        btn_main_eq.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String str = edit_main_input.getText().toString();
        switch (v.getId()) {
            case R.id.btn_main_0:
            case R.id.btn_main_1:
            case R.id.btn_main_2:
            case R.id.btn_main_3:
            case R.id.btn_main_4:
            case R.id.btn_main_5:
            case R.id.btn_main_6:
            case R.id.btn_main_7:
            case R.id.btn_main_8:
            case R.id.btn_main_9:
            case R.id.btn_main_pt:
                if (clr_flag) {
                    clr_flag = false;
                    str = "";
                    edit_main_input.setText("");

                }
                edit_main_input.setText(str + ((Button) v).getText());
                break;
          case R.id.btn_main_sub:
            case R.id.btn_main_add:

                case R.id.btn_main_mul:
            case R.id.btn_main_div:
                if(clr_flag){
                    clr_flag=false;
                    str="";
                    edit_main_input.setText("");
                }
                if(str.contains("+")||str.contains("-")||str.contains("*")||str.contains("÷")) {
                    str=str.substring(0,str.indexOf(" "));
                }
                edit_main_input.setText(str+" "+((Button)v).getText()+" ");
                break;
            case R.id.btn_main_clr:
                if(clr_flag)
                    clr_flag=false;
                str="";
                edit_main_input.setText("");
                break;
            case R.id.btn_main_del: //判断是否为空，然后在进行删除
                if(clr_flag){
                    clr_flag=false;
                    str="";
                    edit_main_input.setText("");
                }
                else if(str!=null&&!str.equals("")){
                    edit_main_input.setText(str.substring(0,str.length()-1));
                }
                break;
            case R.id.btn_main_eq:
                 getResult();
                break;


        }
    }
    private void getResult() {
        String exp = edit_main_input.getText().toString();
        if (exp == null || exp.equals("")) return;
        //因为没有运算符所以不用运算
        if (!exp.contains(" ")) {
            return;

        }
        if(clr_flag) {
            clr_flag = false;
            return;
            }
        clr_flag=true;
        String s1=exp.substring(0,exp.indexOf(" "));
        String op=exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);
        String s2=exp.substring(exp.indexOf(" ")+3);
        double cnt=0;
        if(!s1.equals("")&&!s2.equals("")) {
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            if (op.equals("+")) {
                cnt = d1 + d2;
            }
            if (op.equals("-")) {
                cnt = d1 - d2;
            }
            if (op.equals("*")) {
                cnt = d1 * d2;
            }
            if (op.equals("÷")) {
                if (d2 == 0) cnt = 0;
                else cnt = d1 / d2;
            }
            if(!s1.contains(".")&&!s2.contains(".")&&!op.equals("÷")) {
                int res = (int) cnt;
                edit_main_input.setText(res+"");
            }else {
                edit_main_input.setText(cnt+"");}
        }
        else if(!s1.equals("")&&s2.equals("")){
            double d1=Double.parseDouble(s1);
            if(op.equals("+")){
                cnt=d1;
            }
            if(op.equals("-")){
                cnt=d1;
            }
            if(op.equals("*")){
                cnt=0;
            }
            if(op.equals("÷")){
                cnt=0;
            }
            if(!s1.contains(".")) {
                int res = (int) cnt;
                edit_main_input.setText(res+"");
            }else {
                edit_main_input.setText(cnt+"");}
                }
        else if(s1.equals("")&&!s2.equals("")){
            double d2=Double.parseDouble(s2);
            if(op.equals("+")){
                cnt=d2;
            }
            if(op.equals("-")){
                cnt=0-d2;
            }
            if(op.equals("*")){
                cnt=0;
            }
            if(op.equals("÷")){
                cnt=0;
            }
            if(!s2.contains(".")) {
                int res = (int) cnt;
                edit_main_input.setText(res+"");
            }else {
                edit_main_input.setText(cnt+"");}
        }
        else {
            edit_main_input.setText("");
        }

        }


    }
