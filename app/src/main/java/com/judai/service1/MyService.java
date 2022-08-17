package com.judai.service1;

import static com.judai.service1.MyApplication.CHANNEL_ID;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class MyService extends Service {


    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("Service","My Serivce onCreate");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String dataintent = intent.getStringExtra("text");
        sendNotification(dataintent);
        return START_STICKY;
    }

    private void sendNotification(String dataintent) {

        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("APP TEST")
                .setContentText(dataintent)
                .setSmallIcon(R.drawable.icon)
                .setContentIntent(pendingIntent)
                .build();

        startForeground(1,notification);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("Service","My Serivce onDestroy");
    }
}
