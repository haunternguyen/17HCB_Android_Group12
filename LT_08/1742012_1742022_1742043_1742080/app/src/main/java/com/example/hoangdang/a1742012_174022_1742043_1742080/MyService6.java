package com.example.hoangdang.a1742012_174022_1742043_1742080;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

public class MyService6 extends Service {
    String GPS_FILTER = "matos.action.GPSFIX";
    Thread serviceThread;
    LocationManager lm;
    GPSListener myLocationListener;
    boolean isRunning = true;

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        //Log.e("<<MyGpsService-onStart>>", "I am alive-GPS!");
        serviceThread = new Thread(new Runnable() {
            public void run() {
                getGPSFix_Version2(); // uses GPS chip provider
            }// run
        });
        serviceThread.start();
    }// onStart

    public void getGPSFix_Version2() {
        try {
            while (isRunning) {
                Looper.prepare();
                Log.e("Vong lap:", "----------");

                lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                myLocationListener = new GPSListener();
                long minTime = 20; // 2 seconds
                float minDistance = 5; // 5 meter
                lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, myLocationListener);
                Looper.loop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Log.e("<<MyGpsService-onDestroy>>", "I am dead-GPS");
        try {
            lm.removeUpdates(myLocationListener);
            isRunning = false;
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), 1).show();
        }
    }// onDestroy

    private class GPSListener implements LocationListener {
        public void onLocationChanged(Location location) {
// capture location data sent by current provider
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
// assemble data bundle to be broadcasted
            Intent myFilteredResponse = new Intent(GPS_FILTER);
            myFilteredResponse.putExtra("latitude", latitude);
            myFilteredResponse.putExtra("longitude", longitude);
            myFilteredResponse.putExtra("provider", location.getProvider());
            Log.e(">>GPS_Service<<", "Lat:" + latitude + " lon:" + longitude);
// send the location data out
            sendBroadcast(myFilteredResponse);
        }

        public void onProviderDisabled(String provider) {
        }

        public void onProviderEnabled(String provider) {
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

    }

    ;// GPSListener class
}
