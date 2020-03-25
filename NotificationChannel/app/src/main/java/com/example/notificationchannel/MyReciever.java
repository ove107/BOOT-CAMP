package com.example.notificationchannel;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.EditText;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import static com.example.notificationchannel.App.CHANNEL_1_ID;
import static com.example.notificationchannel.App.CHANNEL_2_ID;

public class MyReciever extends BroadcastReceiver {
    private NotificationManagerCompat notificationManager;
    private EditText editTextTitle;


    @Override
    public void onReceive(Context context, Intent intent) {


        notificationManager = NotificationManagerCompat.from(context);



        String title = intent.getStringExtra("Title");

        String message = intent.getStringExtra("Message");
        long[] pattern = {1000,2000,1000};

        Notification notification = new NotificationCompat.Builder(context, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_one)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH).setVibrate(pattern)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManager.notify(1, notification);




        Notification notificatio = new NotificationCompat.Builder(context, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_two)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();

        notificationManager.notify(2, notificatio);
    }
}
