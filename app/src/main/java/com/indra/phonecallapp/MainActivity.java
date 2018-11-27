package com.indra.phonecallapp;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Button callBtn;
    private Button callBtn2;
    private Button callBtn3;
    private Button callBtn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callBtn = (Button) findViewById(R.id.btnCall);
        callBtn2 = (Button) findViewById(R.id.btnCall2);
        callBtn3 = (Button) findViewById(R.id.btnCall3);
        callBtn4 = (Button) findViewById(R.id.btnCall4);

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = callBtn.getText().toString();
                callIt(number);
            }
        });

        callBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = callBtn2.getText().toString();
                callIt(number);
            }
        });

        callBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = callBtn3.getText().toString();
                callIt(number);
            }
        });

        callBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = callBtn4.getText().toString();
                callIt(number);
            }
        });
    }

    protected void callIt(String number){
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+number));

        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) !=
                PackageManager.PERMISSION_GRANTED){
            return;
        }
        startActivity(callIntent);
    }
}
