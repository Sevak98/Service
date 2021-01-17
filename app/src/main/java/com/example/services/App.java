package com.example.services;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class App extends Application {

    private final String CHANNEL_ID = "ForegroundServiceNotification";

    @Override
    public void onCreate() {
        super.onCreate();
    }

   @RequiresApi(api = Build.VERSION_CODES.O)
   private void createNotificationChannel(){
       NotificationChannel serviceChannel = new NotificationChannel(CHANNEL_ID,"Example for foreground service " , NotificationManager.IMPORTANCE_DEFAULT);
       NotificationManager notificationManager = getSystemService(NotificationManager.class);
       notificationManager.createNotificationChannel(serviceChannel);
    }
}
