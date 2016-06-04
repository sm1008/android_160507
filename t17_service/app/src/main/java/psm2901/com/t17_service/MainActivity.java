package psm2901.com.t17_service;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnStartClick(View view){
        Intent intent = new Intent(this,MyService.class);
        startService(intent);
    }


    public void onBtnStopClick(View view){
        Intent intent = new Intent(this,MyService.class);
        stopService(intent);
    }

}
