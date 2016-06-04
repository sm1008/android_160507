package com.psm2901.p02_location;

import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    LocationManager locationManager;
    LocationListener locationListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);

        String str="";
        List<String> providers = locationManager.getAllProviders();
        for(int i=0;i<providers.size();i++){
            str += "provider : "+providers.get(i) + "state:"+locationManager.isProviderEnabled(providers.get(i))+"\n";
        }

        textView.setText(str);


        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                String str = "lat:"+location.getLatitude() + "lon:"+location.getLongitude()+"alt:"+location.getAltitude()+"\n";
                textView.append(str);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };



        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locationListener);
    }


//    public void onBtnClick(View view){
//        textView = (TextView)findViewById(R.id.textView);
//        switch (view.getId()){
//            case R.id.btnStart:
//                //textView.setText("btnSTART");
//                Log.d("sss","START");
//                break;
//            case R.id.btnStop:
//                //textView.setText("btnSTOP");
//                Log.d("sss","STOP");
//                break;
//            case R.id.btnView:
//                //textView.setText("btnVIEW");
//                Log.d("sss","VIEW");
//                break;
//        }
//    }


    public void onStartClick(View view){
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,0,locationListener);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locationListener);
    }

    public void onStopClick(View view){
        locationManager.removeUpdates(locationListener);
    }

    public void onViewClick(View view){
        //textView.setText(dbHandler.showAll());
    }
}
