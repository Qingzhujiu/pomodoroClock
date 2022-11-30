package com.myprogram.pomodoroClock.dialog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.myprogram.pomodoroClock.R;

public class tomato_clock_add_dialog extends Dialog implements View.OnClickListener {

    EditText tomato_clock_dialog_et;
    Button tomato_clock_dialog_bt_yes;
    Button tomato_clock_dialog_bt_no;
    RadioGroup tomato_clock_dialog_rg;


    public tomato_clock_add_dialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomato_clock_add_dialog);

        tomato_clock_dialog_et = findViewById(R.id.tomato_clock_dialog_et);
        tomato_clock_dialog_bt_no = findViewById(R.id.tomato_clock_dialog_bt_no);
        tomato_clock_dialog_bt_yes = findViewById(R.id.tomato_clock_dialog_bt_no);
        tomato_clock_dialog_rg = findViewById(R.id.tomato_clock_dialog_rg);

        tomato_clock_dialog_bt_no.setOnClickListener(this);
        tomato_clock_dialog_bt_yes.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (R.id.tomato_clock_dialog_bt_yes == view.getId()){
            //点击确认按钮


        }else if (R.id.tomato_clock_dialog_bt_yes == view.getId()){
            //点击取消按钮



        }
    }
}