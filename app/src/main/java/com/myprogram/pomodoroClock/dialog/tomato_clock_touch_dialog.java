package com.myprogram.pomodoroClock.dialog;

import androidx.annotation.NonNull;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.myprogram.pomodoroClock.Pomodoro.Pomodoro;
import com.myprogram.pomodoroClock.Pomodoro.PomodoroViewModel;
import com.myprogram.pomodoroClock.R;


public class tomato_clock_touch_dialog extends Dialog implements View.OnClickListener {

    Button tomato_clock_touch_dialog_edit;
    Button tomato_clock_touch_dialog_del;
    TextView tomato_clock_touch_dialog_duration;
    TextView tomato_clock_touch_dialog_count;
    TextView tomato_clock_touch_dialog_name;
    Pomodoro pomodoro;

    PomodoroViewModel pomodoroViewModel;
    public tomato_clock_touch_dialog(@NonNull Context context, Pomodoro pomodoro, PomodoroViewModel pomodoroViewModel) {
        super(context);
        this.pomodoro = pomodoro;
        this.pomodoroViewModel = pomodoroViewModel;
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

        tomato_clock_touch_dialog_name.setText(pomodoro.getName());
        tomato_clock_touch_dialog_count.setText(String.valueOf(pomodoro.getCount())+"次");
        tomato_clock_touch_dialog_duration.setText(String.valueOf(pomodoro.getDuration()+"分钟"));

        tomato_clock_touch_dialog_edit.setOnClickListener(this);
        tomato_clock_touch_dialog_del.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        if (R.id.tomato_clock_touch_dialog_del == view.getId()){
            //删除按钮
            pomodoroViewModel.delete(pomodoro);
            this.cancel();

        }else if (R.id.tomato_clock_touch_dialog_edit == view.getId()){
            //编辑按钮
            tomato_clock_touch_edit_dialog tomato_clock_touch_edit_dialog = new tomato_clock_touch_edit_dialog(view.getContext(),pomodoroViewModel,pomodoro);
            tomato_clock_touch_edit_dialog.show();
            this.cancel();
        }
    }
}