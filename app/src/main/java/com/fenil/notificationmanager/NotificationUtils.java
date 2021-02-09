package com.fenil.notificationmanager;

import android.app.AlarmManager;
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
    private String title;
    private String message;
    public static long delay;
    public static final String CODEFORCES_CHANNEL_ID = "CHANNEL 1";
    public static final String CODECHEF_CHANNEL_ID = "CHANNEL 2";
    public static final String HACKERRANK_CHANNEL_ID = "CHANNEL 3";
    public static final String HACKEREARTH_CHANNEL_ID = "CHANNEL 4";
    public static final String SPOJ_CHANNEL_ID = "CHANNEL 5";
    public static final String ATCODER_CHANNEL_ID = "CHANNEL 6";
    public static final String LEETCODE_CHANNEL_ID = "CHANNEL 7";
    public static final String GOOGLE_CHANNEL_ID = "CHANNEL 8";

    public static final String CODEFORCES_CHANNEL_NAME = "Codeforces";
    public static final String CODECHEF_CHANNEL_NAME = "CodeChef";
    public static final String HACKEREARTH_CHANNEL_NAME = "Hackerearth";
    public static final String HACKERRANK_CHANNEL_NAME = "Hackerrank";
    public static final String SPOJ_CHANNEL_NAME = "Spoj";
    public static final String ATCODER_CHANNEL_NAME = "Atcoder";
    public static final String LEETCODE_CHANNEL_NAME = "Leetcode";
    public static final String GOOGLE_CHANNEL_NAME = "Google";

    public NotificationUtils(Context baseContext)
    {
        super(baseContext);
        this.context = baseContext;
        createCodeforcesChannel();
        createCodechefChannel();
        createHackerearthChannel();
        createHackerrankChannel();
        createSpojChannel();
        createAtcoderChannel();
        createLeetcodeChannel();
        createGoogleChannel();
    }

    public void createCodeforcesChannel()
    {
        NotificationChannel channel = new NotificationChannel(CODEFORCES_CHANNEL_ID,CODEFORCES_CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
        channel.enableVibration(true);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        getNotificationManager().createNotificationChannel(channel);
    }
    public void createCodechefChannel()
    {
        NotificationChannel channel = new NotificationChannel(CODECHEF_CHANNEL_ID,CODECHEF_CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
        channel.enableVibration(true);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        getNotificationManager().createNotificationChannel(channel);
    }
    public void createHackerrankChannel()
    {
        NotificationChannel channel = new NotificationChannel(HACKERRANK_CHANNEL_ID,HACKERRANK_CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
        channel.enableVibration(true);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        getNotificationManager().createNotificationChannel(channel);
    }
    public void createHackerearthChannel()
    {
        NotificationChannel channel = new NotificationChannel(HACKEREARTH_CHANNEL_ID,HACKEREARTH_CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
        channel.enableVibration(true);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        getNotificationManager().createNotificationChannel(channel);
    }public void createSpojChannel()
    {
        NotificationChannel channel = new NotificationChannel(SPOJ_CHANNEL_ID,SPOJ_CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
        channel.enableVibration(true);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        getNotificationManager().createNotificationChannel(channel);
    }public void createAtcoderChannel()
    {
        NotificationChannel channel = new NotificationChannel(ATCODER_CHANNEL_ID,ATCODER_CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
        channel.enableVibration(true);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        getNotificationManager().createNotificationChannel(channel);
    }public void createLeetcodeChannel()
    {
        NotificationChannel channel = new NotificationChannel(LEETCODE_CHANNEL_ID,LEETCODE_CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
        channel.enableVibration(true);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        getNotificationManager().createNotificationChannel(channel);
    }public void createGoogleChannel()
    {
        NotificationChannel channel = new NotificationChannel(GOOGLE_CHANNEL_ID,GOOGLE_CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
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

    public void createNotification()
    {
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+delay,pendingIntent);
    }

    public void createIntent(String title, String message)
    {
        this.title = title;
        this.message = message;
        Intent intent = new Intent(context,ReceiverBroadcast.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("title",title);
        intent.putExtra("message",message);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0,intent,0);
        this.pendingIntent = pendingIntent;
    }
}
