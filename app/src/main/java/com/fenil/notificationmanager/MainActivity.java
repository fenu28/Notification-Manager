package com.fenil.notificationmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.NotificationCompat;

import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText title;
    private EditText message;
    private TextView time;
    private TextView date;
    private TextView platform;
    private ImageButton timeButton;
    private ImageButton dateButton;
    private Button notification;
    private NotificationUtils notificationUtils;
    private Spinner spinner;
    public static String channelID;
    public static int uniqueID;
    private String[] platformName;
    private final Calendar calendar = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationUtils = new NotificationUtils(this);
        title = findViewById(R.id.title_edittext);
        message = findViewById(R.id.message_edittext);
        time = findViewById(R.id.time_textview);
        date = findViewById(R.id.date_textview);
        timeButton = findViewById(R.id.time_ImageButton);
        dateButton = findViewById(R.id.date_ImageButton);
        platform = findViewById(R.id.platform_textview);
        spinner = findViewById(R.id.platform_spinner);
        platformName = getResources().getStringArray(R.array.platform_name);
        notification = findViewById(R.id.button_create_notification);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.platform_name, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet (DatePicker view , int year , int monthOfYear , int dayOfMonth) {
                calendar .set(Calendar. YEAR , year) ;
                calendar .set(Calendar. MONTH , monthOfYear) ;
                calendar .set(Calendar. DAY_OF_MONTH , dayOfMonth) ;
                updateDateLabel();
                String s = calendar.get(Calendar.DATE)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.YEAR);
                date.setText(s);
            }
        };

        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                calendar.set(Calendar.MINUTE,minute);
                String t;
                if(hourOfDay == 0)
                    t = 12+":"+calendar.get(Calendar.MINUTE)+" AM";
                else if(hourOfDay == 12)
                    t = calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)+" PM";
                else if(hourOfDay<12)
                    t = calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)+" AM";
                else
                    t = calendar.get(Calendar.HOUR_OF_DAY)-12+":"+calendar.get(Calendar.MINUTE)+" PM";
                time.setText(t);
            }
        };

        dateButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this,dateSetListener,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(MainActivity.this,timeSetListener,
                        calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE),
                        false).show();
            }
        });
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(title.getText().toString()) || TextUtils.isEmpty(message.getText().toString()))
                    Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_SHORT).show();
                else {
                    long currentTimeMillis = System.currentTimeMillis();
                    long calendarTimeMillis = calendar.getTimeInMillis();
                    long delay = calendarTimeMillis - currentTimeMillis;

                    NotificationUtils.delay = delay;
                    notificationUtils.createIntent(title.getText().toString(), message.getText().toString());
                    notificationUtils.createNotification();
                }
            }
        });
    }

    private void updateDateLabel() {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position)
        {
            case 0:{
                Log.v("MainActivity","IN");
                platform.setText(platformName[0]);
                channelID = "CHANNEL 1";
                uniqueID = 1;
                break;
            }
            case 1:{
                platform.setText(platformName[1]);
                channelID = "CHANNEL 2";
                uniqueID = 2;
                break;
            }
            case 2:{
                platform.setText(platformName[2]);
                channelID = "CHANNEL 3";
                uniqueID = 3;
                break;
            }
            case 3:{
                platform.setText(platformName[3]);
                channelID = "CHANNEL 4";
                uniqueID = 4;
                break;
            }
            case 4:{
                platform.setText(platformName[4]);
                channelID = "CHANNEL 5";
                uniqueID = 5;
                break;
            }
            case 5:{
                platform.setText(platformName[5]);
                channelID = "CHANNEL 6";
                uniqueID = 6;
                break;
            }
            case 6:{
                platform.setText(platformName[6]);
                channelID = "CHANNEL 7";
                uniqueID = 7;
                break;
            }
            case 7:{
                platform.setText(platformName[7]);
                channelID = "CHANNEL 8";
                uniqueID = 8;
                break;
            }

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}