package com.example.c.p01_listview;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.VideoView;

public class PlayerActivity extends AppCompatActivity {

    MediaPlayer mp = null;
    VideoView videoView=null;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

    }


    public void onPlayClick(View view){
        Intent intent = getIntent();

        mp = new MediaPlayer();

        String path = Environment.getExternalStorageDirectory()+"/Download"+intent.getStringExtra("fileName");
        try {
            mp.setDataSource(path);
            mp.prepare();
            mp.start();




        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public void onStopClick(View view){
        if(mp!=null)
        {
            mp.stop();
            mp.release();
            mp=null;
        }
    }



}
