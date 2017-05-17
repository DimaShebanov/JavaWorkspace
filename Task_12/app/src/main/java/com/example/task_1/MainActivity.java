package com.example.task_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etFirstValue;
    private EditText etOperand;
    private EditText etSecondValue;
    private Button btnCalc;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etFirstValue = (EditText) findViewById(R.id.edit_text_first_val);
        etOperand = (EditText) findViewById(R.id.edit_text_operand);
        etSecondValue = (EditText) findViewById(R.id.edit_text_second_val);
        btnCalc = (Button) findViewById(R.id.btn_calc);
        tvResult = (TextView) findViewById(R.id.text_view_result);
        btnCalc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
      // int firstVal = Integer.valueOf(etFirstValue.getText().toString());
        //int secondVal = Integer.valueOf(etFirstValue.getText().toString());
        //char operand = Character.valueOf(etOperand.getText().toString());
        //int res = 0;
        //switch (operand)
       // {
       //     case (operand.equals("+")):

       // }

    }
}

