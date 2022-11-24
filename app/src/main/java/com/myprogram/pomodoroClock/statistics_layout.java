package com.myprogram.pomodoroClock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class statistics_layout extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics_layout);
        Button listButton = findViewById(R.id.list_button);
        Button settingButton = findViewById(R.id.setting_button);
        listButton.setOnClickListener(this);
        settingButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.list_button){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        }else if(view.getId()==R.id.setting_button){
            Intent intent = new Intent(this,setting_layout.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        }
    }
}