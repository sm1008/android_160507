package com.example.c.t14_camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private int PHOTO = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onTakeClicked(View view){
        String path = Environment.getExternalStorageDirectory()+"/t14.jpg";

        //암시적Intent
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(path)));
        startActivityForResult(intent,PHOTO);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==PHOTO){
            if(resultCode==RESULT_OK){
                String path = Environment.getExternalStorageDirectory()+"/t14.jpg";
                Bitmap bitmap;

                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize=4;  //size축소 sample pixel단위를 4로함(4pixel단 한개씩 가져옴-> 사이즈가 1/4로 줄어듬)

                bitmap=BitmapFactory.decodeFile(path,options);

                ImageView imageView = (ImageView)findViewById(R.id.imageView);
                imageView.setImageBitmap(bitmap);
            }
        }
    }
}
