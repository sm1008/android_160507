package com.example.c.t08_thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    public static  final int THREAD_COUNT=100;


    class myThread extends  Thread{

    }

    Button btnStart;
    ProgressBar progressBar;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            if(msg.what==THREAD_COUNT){
                btnStart.setText("count :"+msg.arg1);
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = (Button) findViewById(R.id.btnStart);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
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

                    Message msg = new Message();
                    msg.what = THREAD_COUNT;
                    msg.arg1=i;
                    handler.sendMessage(msg);

                    i++;
                }
            }
        });
        th.start();

    }

}
