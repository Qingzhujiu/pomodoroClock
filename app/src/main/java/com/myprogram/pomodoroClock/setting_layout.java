package com.myprogram.pomodoroClock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class setting_layout extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_layout);
        Button listButton = (Button) findViewById(R.id.list_button);
        Button statisticsButton = (Button)findViewById(R.id.statistics_button);
        listButton.setOnClickListener(this);
        statisticsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.list_button){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        }else if(view.getId()==R.id.statistics_button){
            Intent intent = new Intent(this,statistics_layout.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        }
    }
}