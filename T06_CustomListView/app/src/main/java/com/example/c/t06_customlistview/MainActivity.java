package com.example.c.t06_customlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    class MyData{
        int image;
        String title;
        String content;
    }

    ArrayList<MyData> list = new ArrayList<MyData>();

    private void initData(){
        for(int i=0;i<30;i++){
            MyData data = new MyData();
            data.title = "title" + i;
            data.content="content"+i;

         switch (i%4){
             case 0:
                 data.image=android.R.drawable.ic_menu_report_image;
                 break;
             case 1:
                 data.image=android.R.drawable.ic_dialog_map;
                 break;
             case 2:
                 data.image=android.R.drawable.ic_lock_idle_charging;
                 break;
             case 3:
                 data.image=android.R.drawable.ic_media_play;
                 break;
         }
         list.add(data);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        ListView listView = (ListView)findViewById(R.id.listView);
        MyAdapter adapter = new  MyAdapter();
        listView.setAdapter(adapter);

    }



    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null){
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.item_view,null);
            }
            MyData data = list.get(position);
            TextView textTitle = (TextView) convertView.findViewById(R.id.textTitle);
            TextView textContent = (TextView) convertView.findViewById(R.id.textContent);
            textTitle.setText(data.title);
            textContent.setText(data.content);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
            imageView.setImageResource(data.image);

            return convertView;
        }
    }



}
