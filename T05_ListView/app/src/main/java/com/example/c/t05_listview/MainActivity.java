package com.example.c.t05_listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] str_array_datalist = {
            "hello","world","oracle","java",
            "hello","world","oracle","java",
            "hello","world","oracle","java" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView lv_main = (ListView)findViewById(R.id.lv_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,str_array_datalist);
        lv_main.setAdapter(adapter);

        lv_main.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str_selected_item = str_array_datalist[position];
                Toast.makeText(MainActivity.this, "selected item is " + str_selected_item, Toast.LENGTH_SHORT).show();
            }
        });


    }
}
