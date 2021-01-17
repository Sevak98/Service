package com.example.services;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button start;
    private Button stop;
    Intent service = null;
    EditText text1 ;
    public final static String FILE_NAME = "filename";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);

        text1 = findViewById(R.id.text1);


        Intent intent = getIntent();
        String fileName = intent.getStringExtra(FILE_NAME);
        if (!TextUtils.isEmpty(fileName)){
            text1.setText(fileName);
    }

       // service =  new Intent(this , MyService.class);
        service =  new Intent(this , ForegroundService.class);


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View v) {
        if (v.equals(start)){
 //           startService(service)
            ContextCompat.startForegroundService(this , service);
            startForegroundService(new Intent(this , ForegroundService.class));
        }else if (v.equals(stop)) {
            stopService(service);
        }
    }
}