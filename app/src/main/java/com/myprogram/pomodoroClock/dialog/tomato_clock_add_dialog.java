package com.myprogram.pomodoroClock.dialog;

import androidx.annotation.NonNull;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.myprogram.pomodoroClock.Pomodoro.Pomodoro;
import com.myprogram.pomodoroClock.Pomodoro.PomodoroViewModel;
import com.myprogram.pomodoroClock.R;

public class tomato_clock_add_dialog extends Dialog implements View.OnClickListener {

    EditText tomato_clock_dialog_et;
    Button tomato_clock_dialog_bt_yes;
    Button tomato_clock_dialog_bt_no;
    RadioGroup tomato_clock_dialog_rg;
    PomodoroViewModel pomodoroViewModel;


    public tomato_clock_add_dialog(@NonNull Context context, PomodoroViewModel pomodoroViewModel) {
        super(context);
        this.pomodoroViewModel=pomodoroViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomato_clock_add_dialog);

        tomato_clock_dialog_et = findViewById(R.id.tomato_clock_dialog_et);
        tomato_clock_dialog_bt_no = findViewById(R.id.tomato_clock_dialog_bt_no);
        tomato_clock_dialog_bt_yes = findViewById(R.id.tomato_clock_dialog_bt_yes);
        tomato_clock_dialog_rg = findViewById(R.id.tomato_clock_dialog_rg);

        tomato_clock_dialog_bt_no.setOnClickListener(this);
        tomato_clock_dialog_bt_yes.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (R.id.tomato_clock_dialog_bt_yes == view.getId()){
            //点击确认按钮
            int clockTime =0;
            String clockName = tomato_clock_dialog_et.getText().toString();

            int checkedRadioButtonId = tomato_clock_dialog_rg.getCheckedRadioButtonId();
            if (checkedRadioButtonId==R.id.tomato_clock_dialog_rb15){
                clockTime = 15;
            }else if (checkedRadioButtonId==R.id.tomato_clock_dialog_rb20){
                clockTime = 20;
            }else if (checkedRadioButtonId==R.id.tomato_clock_dialog_rb25){
                clockTime = 25;
            }else if (checkedRadioButtonId==R.id.tomato_clock_dialog_rb30){
                clockTime = 30;
            }
            Pomodoro pomodoro = new Pomodoro(clockName, 0, clockTime, 0);
            pomodoroViewModel.insert(pomodoro);
            this.cancel();

        }else if (R.id.tomato_clock_dialog_bt_no == view.getId()){
            //点击取消按钮
            this.cancel();
        }
    }
}