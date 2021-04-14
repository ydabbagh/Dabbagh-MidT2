package com.example.dabbagh_midt2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.Calendar;

public class Splash extends AppCompatActivity {
    TextView countdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        countdown= (TextView) findViewById(R.id.txtCountDown);

    }
    CountDownTimer s = new CountDownTimer(6000, 1000) { //6 seconds
        public void onTick(long millisUntilFinished) {
            countdown.setText("Seconds remaining: " + millisUntilFinished / 1000);
        }
        public void onFinish() {
            startActivity(new Intent(Splash.this, MainActivity.class));
        }
    }.start();
}