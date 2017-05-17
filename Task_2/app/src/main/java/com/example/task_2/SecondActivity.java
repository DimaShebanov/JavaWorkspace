package com.example.task_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Дима on 31.12.2016.
 */

public class SecondActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView tvres = (TextView) findViewById(R.id.tv_second_result);

        Intent intent = getIntent();
        Bundle Bres = intent.getExtras();
        int res = Bres.getInt("result");
        String rres = res + "";
        tvres.setText(rres);
    }
}
