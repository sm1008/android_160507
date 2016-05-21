package com.example.c.t08_thread;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {




    Button btnStart;

    Handler handler =

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onStartClick(View view){
//        Thread th = new Thread();
//        th.start();

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while(i<100)
                {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.d("thread test", "count : "+i);
                    i++;
                }
            }
        });
        th.start();

    }

}
