package com.example.task_4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Дима on 08.01.2017.
 */

public class ListpersonActivity extends AppCompatActivity
{
    ListView lvPersons;
    String[] names = {"jann", "dsi"};
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listperson);


        lvPersons = (ListView) findViewById(R.id.lv_persons);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_listperson, names);

        lvPersons.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if(id == R.id.get_back)
        {
            finish();
        }


        return super.onOptionsItemSelected(item);
    }
}
