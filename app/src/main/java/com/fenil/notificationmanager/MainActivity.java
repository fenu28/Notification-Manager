package com.fenil.notificationmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText title;
    private EditText message;
    private Button bt;
    private Button bm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.title_edittext);
        message = findViewById(R.id.message_edittext);
        bt = findViewById(R.id.title_button);
        bm = findViewById(R.id.message_button);

        bt.setOnClickListener(this);
        bm.setOnClickListener(this);
    }
    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.title_button:
            {
                if(checkString())
                {

                }
            }
                break;
            case R.id.message_button:
            {
                if(checkString())
                {

                }
            }
        }
    }
    public boolean checkString()
    {
        String s = title.getText().toString();
        String q = message.getText().toString();

        if(TextUtils.isEmpty(s) || TextUtils.isEmpty(q)) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}