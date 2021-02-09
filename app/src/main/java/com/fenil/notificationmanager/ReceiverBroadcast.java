package com.fenil.notificationmanager;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class ReceiverBroadcast extends BroadcastReceiver {

    String title;
    String message;
    @Override
    public void onReceive(Context context, Intent intent) {
        title = intent.getStringExtra("title");
        message = intent.getStringExtra("message");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, MainActivity.channelID)
                .setSmallIcon(R.drawable.ic_baseline_alarm_24)
                .setContentText(message)
                .setContentTitle(title)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        notificationManager.notify(MainActivity.uniqueID,builder.build());
        Log.v("BROADCAST","SET");

    }
}
