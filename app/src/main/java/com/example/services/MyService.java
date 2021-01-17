package com.example.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service start" , Toast.LENGTH_LONG).show();
    return START_STICKY;
    }



    @Override
    public void onDestroy() {
        Toast.makeText(this , "Service killed" , Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

}
