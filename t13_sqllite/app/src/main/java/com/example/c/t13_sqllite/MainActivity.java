package com.example.c.t13_sqllite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestSqlHandler dbHandler = new TestSqlHandler(this);
        dbHandler.insert("kim",20,"seoul");
        dbHandler.insert("park",21,"incheon");
        dbHandler.insert("lee",22,"Busan");

        dbHandler.delete("lee");

        dbHandler.update("kim",23);

        dbHandler.showAll();
    }
}
