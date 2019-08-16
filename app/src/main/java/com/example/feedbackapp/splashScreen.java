package com.example.feedbackapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.feedbackapp.ui.login.LoginActivity;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread splashscr = new Thread() {
            public void run() {
                try {
                    Thread.sleep(4000);

                    Intent i = new Intent(getBaseContext(), LoginActivity.class);
                    startActivity(i);

                    finish();

                } catch (Exception ex) {

                }


            }
        };

        splashscr.start();


    }
}
