package com.example.dimitris.falldetector.ui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dimitris.falldetector.R;

import static android.Manifest.permission.CALL_PHONE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int PERMISSION_REQUEST_CODE = 200;

    private void requestPermission() {

        ActivityCompat.requestPermissions(this, new String[]{CALL_PHONE}, PERMISSION_REQUEST_CODE);

    }

    private void checkPermission(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                //Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                  //      Uri.parse("package:"+getPackageName()));
                //startActivity(intent);
                //finish();
                requestPermission();
            }
        }
    }

    public static final String TAG = "MainActivity";

    private Button btnSet;
    private Button btnStart;
    private Button btnHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkPermission();
        btnSet = (Button) findViewById(R.id.btn_set);
        btnSet.setOnClickListener(this);

        btnStart = (Button) findViewById(R.id.btn_start);
        btnStart.setOnClickListener(this);

        btnHistory = (Button) findViewById(R.id.btn_history);
        btnHistory.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btn_set:
                intent = new Intent(this, SetActivity.class);
                startActivity(intent);
                return;
            case R.id.btn_start:
                intent = new Intent(this, StartActivity.class);
                startActivity(intent);
                return;
            case R.id.btn_history:
                intent = new Intent(this, HistoryActivity.class);
                startActivity(intent);
                return;
        }
    }

}
