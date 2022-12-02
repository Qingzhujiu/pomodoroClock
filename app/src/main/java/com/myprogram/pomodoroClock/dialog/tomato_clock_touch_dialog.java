package com.myprogram.pomodoroClock.dialog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.myprogram.pomodoroClock.R;

public class tomato_clock_touch_dialog extends Dialog {

    public tomato_clock_touch_dialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomato_clock_touch_dialog);
    }
}