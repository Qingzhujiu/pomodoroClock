package com.myprogram.pomodoroClock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.myprogram.pomodoroClock.Pomodoro.PomodoroViewModel;
import com.myprogram.pomodoroClock.Record.Record;
import com.myprogram.pomodoroClock.Record.RecordViewModel;


public class clock extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);

        TextView clock_tx = findViewById(R.id.clock_tx);

        PomodoroViewModel pomodoroViewModel = new ViewModelProvider(this).get(PomodoroViewModel.class);
        RecordViewModel recordViewModel = new ViewModelProvider(this).get(RecordViewModel.class);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        int time = extras.getInt("time");
        long clockId = extras.getLong("clockId");
        int count = extras.getInt("count");
        int duration = extras.getInt("duration");


        Button clock_bt = findViewById(R.id.clock_bt);
        clock_bt.setOnClickListener(this);

        CountDownTimer countDownTimer = new CountDownTimer(time * 60000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                long second;
                long minute;
                second = millisUntilFinished / 60000;
                minute = millisUntilFinished / 1000 % 60;

                clock_tx.setText(second + " 分钟 " + minute + " 秒");
            }

            @Override
            public void onFinish() {
                clock_tx.setText("恭喜你完成了本次番茄钟任务！");
                pomodoroViewModel.updateCount(clockId,count+1);
                pomodoroViewModel.updateDuration(clockId,duration+time);

                Record record = new Record();
                recordViewModel.insert(record);


                finish();
            }
        };

        countDownTimer.start();

    }


    @Override
    public void onClick(View view) {
        this.finish();
    }
}