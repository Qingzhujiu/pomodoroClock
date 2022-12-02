package com.myprogram.pomodoroClock.items;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.myprogram.pomodoroClock.R;

public class tomato_clock_items extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomato_clock_items);
        Button tomato_clock_item_start = findViewById(R.id.tomato_clock_item_start);
        tomato_clock_item_start.setText("不用");
        tomato_clock_item_start.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        System.out.println("hhhhhhhh");
    }


}