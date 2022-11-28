package com.myprogram.pomodoroClock;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.myprogram.pomodoroClock.adapter.ItemBaseAdapter;
import com.myprogram.pomodoroClock.bean.Item;

import java.util.List;

public class todo_layout extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_layout);
        ListView todo_list = findViewById(R.id.todo_list);
        ImageButton todo_layout_bt = findViewById(R.id.todo_layout_bt);

        todo_layout_bt.setOnClickListener(this);

        //获取数据
        List<Item> todoInfo = Item.getTodoInfo();
        //构造一个适配器
        ItemBaseAdapter itemBaseAdapter = new ItemBaseAdapter(this,todoInfo);
        todo_list.setAdapter(itemBaseAdapter);
        todo_list.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.todo_layout_bt){
            showDialog();
        }
    }

    private void showDialog(){
        todo_insert_dialog todo_insert_dialog = new todo_insert_dialog(todo_layout.this);
        todo_insert_dialog.show();

    }

}