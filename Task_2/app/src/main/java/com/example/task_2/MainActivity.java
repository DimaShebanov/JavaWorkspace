package com.example.task_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    int val;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn0;
    Button btndiv;
    Button btnmult;
    Button btnadd;
    Button btnminus;
    Button btneq;
    Button btnclear;
    EditText Textfield;
    EditText InvTextField;
    String oper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn_one);
        btn1.setOnClickListener(this);

        btn2 = (Button) findViewById(R.id.btn_two);
        btn2.setOnClickListener(this);

        btn3 = (Button) findViewById(R.id.btn_three);
        btn3.setOnClickListener(this);

        btn4 = (Button) findViewById(R.id.btn_four);
        btn4.setOnClickListener(this);

        btn5 = (Button) findViewById(R.id.btn_five);
        btn5.setOnClickListener(this);

        btn6 = (Button) findViewById(R.id.btn_six);
        btn6.setOnClickListener(this);

        btn7 = (Button) findViewById(R.id.btn_seven);
        btn7.setOnClickListener(this);

        btn8 = (Button) findViewById(R.id.btn_eight);
        btn8.setOnClickListener(this);

        btn9 = (Button) findViewById(R.id.btn_nine);
        btn9.setOnClickListener(this);

        btn0 = (Button) findViewById(R.id.btn_zero);
        btn0.setOnClickListener(this);

        btndiv = (Button) findViewById(R.id.btn_divide);
        btndiv.setOnClickListener(this);


        btnmult = (Button) findViewById(R.id.btn_multiply);
        btnmult.setOnClickListener(this);

        btnadd = (Button) findViewById(R.id.btn_add);
        btnadd.setOnClickListener(this);

        btnminus = (Button) findViewById(R.id.btn_minus);
        btnminus.setOnClickListener(this);

        btneq = (Button) findViewById(R.id.btn_calculate);
        btneq.setOnClickListener(this);

        btnclear = (Button) findViewById(R.id.btn_clear);
        btnclear.setOnClickListener(this);

        Textfield = (EditText) findViewById(R.id.edit_text_display);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_one: Textfield.setText(Textfield.getText() + "1"); break;
            case R.id.btn_two: Textfield.setText(Textfield.getText() + "2"); break;
            case R.id.btn_three: Textfield.setText(Textfield.getText() + "3"); break;
            case R.id.btn_four: Textfield.setText(Textfield.getText() + "4"); break;
            case R.id.btn_five: Textfield.setText(Textfield.getText() + "5"); break;
            case R.id.btn_six: Textfield.setText(Textfield.getText() + "6"); break;
            case R.id.btn_seven: Textfield.setText(Textfield.getText() + "7"); break;
            case R.id.btn_eight: Textfield.setText(Textfield.getText() + "8"); break;
            case R.id.btn_nine: Textfield.setText(Textfield.getText() + "9"); break;
            case R.id.btn_zero: Textfield.setText(Textfield.getText() + "0"); break;


            case R.id.btn_minus:
                val = Integer.valueOf(String.valueOf(Textfield.getText()));
                Textfield.setText("");
                oper = "-";
                break;

            case R.id.btn_multiply:
                val = Integer.valueOf(String.valueOf(Textfield.getText()));
                Textfield.setText("");
                oper = "*";
                break;

            case R.id.btn_add:
                val = Integer.valueOf(String.valueOf(Textfield.getText()));
                Textfield.setText("");
                oper = "+";
                break;

            case R.id.btn_divide:
                val = Integer.valueOf(String.valueOf(Textfield.getText()));
                Textfield.setText("");
                oper = "/";
                break;

            case R.id.btn_clear: Textfield.setText(""); break;

            case R.id.btn_calculate:
                int valsec = Integer.valueOf(String.valueOf(Textfield.getText()));
                int res = 0;
                if(oper.equals("+"))
                {
                    res = val + valsec;
                }
                if(oper.equals("-"))
                {
                    res = val - valsec;
                }
                if(oper.equals("*"))
                {
                    res = val * valsec;
                }
                if(oper.equals("/"))
                {
                    res = val / valsec;
                }
                Textfield.setText(String.valueOf(res));
                Intent Intent = new Intent(MainActivity.this, SecondActivity.class);
                Intent.putExtra("result", res);
                startActivity(Intent);
                break;

            default:break;
        }


    }
}
