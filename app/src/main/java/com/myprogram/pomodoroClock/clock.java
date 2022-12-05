package com.myprogram.pomodoroClock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class clock extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);

        TextView clock_tx = findViewById(R.id.clock_tx);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        int time = extras.getInt("time");
        Button clock_bt = findViewById(R.id.clock_bt);
        clock_bt.setOnClickListener(this);

        CountDownTimer countDownTimer = new CountDownTimer(time * 60000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                long second;
                long minute;
                second = millisUntilFinished / 60000;
                minute = millisUntilFinished / 1000 % 60;

                clock_tx.setText(second + " 分钟" + minute + " 秒");
            }

            @Override
            public void onFinish() {
                clock_tx.setText("done!");
            }
        };

        countDownTimer.start();

    }


    @Override
    public void onClick(View view) {
        this.finish();
    }
}