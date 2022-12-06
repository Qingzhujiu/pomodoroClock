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

public class tomato_clock_touch_edit_dialog extends Dialog implements View.OnClickListener {

    EditText tomato_clock_dialog_et;
    Button tomato_clock_dialog_bt_yes;
    Button tomato_clock_dialog_bt_no;
    RadioGroup tomato_clock_dialog_rg;
    PomodoroViewModel pomodoroViewModel;
    Pomodoro updatePomodoro;

    public tomato_clock_touch_edit_dialog(@NonNull Context context, PomodoroViewModel pomodoroViewModel,Pomodoro updatePomodoro) {
        super(context);
        this.updatePomodoro = updatePomodoro;
        this.pomodoroViewModel =pomodoroViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomato_clock_touch_edit_dialog);

        tomato_clock_dialog_et = findViewById(R.id.tomato_clock_dialog_et);
        tomato_clock_dialog_bt_no = findViewById(R.id.tomato_clock_dialog_bt_no);
        tomato_clock_dialog_bt_yes = findViewById(R.id.tomato_clock_dialog_bt_yes);
        tomato_clock_dialog_rg = findViewById(R.id.tomato_clock_dialog_rg);

        int originClockTime = updatePomodoro.getTime();
        int checkRbId =0 ;
        if (originClockTime==15){
            checkRbId = R.id.tomato_clock_dialog_rb15;
        }else if (originClockTime == 20){
            checkRbId = R.id.tomato_clock_dialog_rb20;
        }else if(originClockTime == 25){
            checkRbId = R.id.tomato_clock_dialog_rb25;
        }else if (originClockTime == 30){
            checkRbId = R.id.tomato_clock_dialog_rb30;
        }

        tomato_clock_dialog_et.setText(updatePomodoro.getName());
        tomato_clock_dialog_rg.check(checkRbId);

        tomato_clock_dialog_bt_no.setOnClickListener(this);
        tomato_clock_dialog_bt_yes.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        if (R.id.tomato_clock_dialog_bt_yes == view.getId()){
            //点击确认按钮
            int updateClockTime =0;
            long updatePomororoId = updatePomodoro.getId();

            String clockName = tomato_clock_dialog_et.getText().toString();

            int checkedRadioButtonId = tomato_clock_dialog_rg.getCheckedRadioButtonId();
            if (checkedRadioButtonId==R.id.tomato_clock_dialog_rb15){
                updateClockTime = 15;
            }else if (checkedRadioButtonId==R.id.tomato_clock_dialog_rb20){
                updateClockTime = 20;
            }else if (checkedRadioButtonId==R.id.tomato_clock_dialog_rb25){
                updateClockTime = 25;
            }else if (checkedRadioButtonId==R.id.tomato_clock_dialog_rb30){
                updateClockTime = 30;
            }

            pomodoroViewModel.updateName(updatePomororoId,clockName);
            pomodoroViewModel.updateTime(updatePomororoId,updateClockTime);
            this.cancel();

        }else if (R.id.tomato_clock_dialog_bt_no == view.getId()){
            //点击取消按钮
            this.cancel();
        }
    }


}