package psm2901.com.t17_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("service","onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("service","onDestory");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("service","onStartCommand");
//        return super.onStartCommand(intent, flags, startId);
        return START_STICKY;   //START_STICKY, START_NOT_STICKY, START_REDELIVERY_INTENT(실행될때까지 계속start)
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
