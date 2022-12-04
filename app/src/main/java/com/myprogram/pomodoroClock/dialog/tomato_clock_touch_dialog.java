package com.myprogram.pomodoroClock.dialog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.myprogram.pomodoroClock.R;
import com.myprogram.pomodoroClock.pojo.Pomodora;

public class tomato_clock_touch_dialog extends Dialog implements View.OnClickListener {

    Button tomato_clock_touch_dialog_edit;
    Button tomato_clock_touch_dialog_del;
    TextView tomato_clock_touch_dialog_duration;
    TextView tomato_clock_touch_dialog_count;
    TextView tomato_clock_touch_dialog_name;
    Pomodora pomodora;
    public tomato_clock_touch_dialog(@NonNull Context context, Pomodora pomodora) {
        super(context);
        this.pomodora=pomodora;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomato_clock_touch_dialog);

        tomato_clock_touch_dialog_name = findViewById(R.id.tomato_clock_touch_dialog_name);
        tomato_clock_touch_dialog_count = findViewById(R.id.tomato_clock_touch_dialog_count);
        tomato_clock_touch_dialog_del = findViewById(R.id.tomato_clock_touch_dialog_del);
        tomato_clock_touch_dialog_duration = findViewById(R.id.tomato_clock_touch_dialog_duration);
        tomato_clock_touch_dialog_edit = findViewById(R.id.tomato_clock_touch_dialog_edit);

        tomato_clock_touch_dialog_name.setText(pomodora.getClockName());
        tomato_clock_touch_dialog_count.setText(String.valueOf(pomodora.getCount())+"次");
        tomato_clock_touch_dialog_duration.setText(String.valueOf(pomodora.getDuration()+"分钟"));

        tomato_clock_touch_dialog_edit.setOnClickListener(this);
        tomato_clock_touch_dialog_del.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

    }
}