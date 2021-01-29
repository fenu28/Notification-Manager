package com.fenil.notificationmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText title;
    private EditText message;
    private Button notification;
    private NotificationUtils notificationUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationUtils = new NotificationUtils(this);
        title = findViewById(R.id.title_edittext);
        message = findViewById(R.id.message_edittext);
        notification = findViewById(R.id.button_create_notification);

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(title.getText().toString()) ||  TextUtils.isEmpty(message.getText().toString()))
                    Toast.makeText(getApplicationContext(),"All fields are required",Toast.LENGTH_SHORT).show();
                else
                {
                    notificationUtils.createChannel();
                    notificationUtils.createIntent(title.getText().toString(),message.getText().toString());
                    Notification.Builder builder = notificationUtils.createNotification(title.getText().toString(),message.getText().toString());
                    notificationUtils.getNotificationManager().notify(101,builder.build());
                }
            }
        });
    }

}