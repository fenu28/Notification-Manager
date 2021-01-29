package com.fenil.notificationmanager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;

public class NotificationUtils extends ContextWrapper {
    private NotificationManager notificationManager;
    private Context context;
    private PendingIntent pendingIntent;
    public static final String ANDROID_CHANNEL_ID = "CHANNEL 1";
    public static final String ANDROID_CHANNEL_NAME = "FENIL";

    public NotificationUtils(Context baseContext)
    {
        super(baseContext);
        this.context = baseContext;
    }

    public void createChannel()
    {
        NotificationChannel channel = new NotificationChannel(ANDROID_CHANNEL_ID,ANDROID_CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
        channel.enableVibration(true);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        getNotificationManager().createNotificationChannel(channel);
    }

    public NotificationManager getNotificationManager()
    {
        if(notificationManager==null)
            return (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        return notificationManager;
    }

    public Notification.Builder createNotification(String title, String message)
    {
        return new Notification.Builder(getApplicationContext(),ANDROID_CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(message)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_baseline_alarm_24)
                .setAutoCancel(true);
    }

    public void createIntent(String title, String message)
    {
        Intent intent = new Intent(context,NotificationReceiver.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("title",title);
        intent.putExtra("message",message);

        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        this.pendingIntent = pendingIntent;
    }
}
