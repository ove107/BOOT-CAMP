package com.example.notificationchannel;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


import static com.example.notificationchannel.App.CHANNEL_1_ID;
import static com.example.notificationchannel.App.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {
    private EditText editTextTitle;
    private EditText editTextMessage;
    AlarmManager alarmManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SendNotification(View v) {
        editTextTitle = findViewById(R.id.edit_text_title);
        editTextMessage = findViewById(R.id.edit_text_message);
        Intent i = new Intent(this,MyReciever.class);
        i.putExtra("Title",editTextTitle.getText().toString());
        i.putExtra("Message",editTextMessage.getText().toString());
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(), 234324243, i, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                + ( 1000), pendingIntent);
    }
    public void Stop(View view) {
        Intent intent = new Intent();
        intent.setAction("SOME ACTION");
        intent.addCategory("android.intent.category.DEFAULT");
        PendingIntent p1 = PendingIntent.getBroadcast(MainActivity.this,0,intent,0);
        alarmManager.cancel(p1);

    }

}