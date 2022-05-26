package com.pro.moviescollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // call the handler method and assign a handler variable to new handler();
        Handler handler = new Handler();

        // use the postdelayed method to splash the activity from main to mainscreen.
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, MainScreen.class);
                startActivity(intent);
                finish();
            }
            // set the time for the splash.
        }, 3000);
    }
}