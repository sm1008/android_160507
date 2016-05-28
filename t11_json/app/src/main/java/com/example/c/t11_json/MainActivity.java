package com.example.c.t11_json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String str = "[ {'name':'kim', 'tel':'010-1111-1111','age':'20'},"+
                    "{'name':'park','tel':'010-2222-2222','age':'21'},"+
                    "{'name':'lee', 'tel':'010-3333-3333','age':'22'}]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            JSONArray array = new JSONArray(str);
            for(int i=0;i<array.length();i++){
                JSONObject obj = array.getJSONObject(i);
                String name = obj.getString("name");
                String tel  = obj.getString("tel");
                int age     = obj.getInt("age");

                Log.d("JSON","name:"+name+" tel:"+tel+" age:"+age);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
