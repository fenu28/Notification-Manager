package com.fenil.notificationmanager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class NotificationReceiver extends AppCompatActivity {

    private TextView title;
    private TextView message;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_receiver);

        title = findViewById(R.id.notification_title);
        message = findViewById(R.id.notification_message);
        intent = getIntent();

        String title = intent.getStringExtra("title");
        String message = intent.getStringExtra("message");
        this.title.setText(title);
        this.message.setText(message);
    }
}
