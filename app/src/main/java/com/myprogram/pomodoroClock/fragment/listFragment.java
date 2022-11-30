package com.myprogram.pomodoroClock.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.myprogram.pomodoroClock.R;
import com.myprogram.pomodoroClock.adapter.ItemBaseAdapter;
import com.myprogram.pomodoroClock.bean.todo_Items;
import com.myprogram.pomodoroClock.dialog.todo_insert_dialog;

import java.util.List;

public class listFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, container, false);
        Bundle bundle = getArguments();


        ListView todo_list = view.findViewById(R.id.todo_list);
        ImageButton todo_layout_bt = view.findViewById(R.id.todo_layout_bt);

        todo_layout_bt.setOnClickListener(this);

        //获取数据
        List<todo_Items> todoInfo = todo_Items.getTodoInfo();
        //构造一个适配器
        ItemBaseAdapter itemBaseAdapter = new ItemBaseAdapter(view.getContext(),todoInfo);
        todo_list.setAdapter(itemBaseAdapter);
        todo_list.setOnItemSelectedListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.todo_layout_bt){
            showDialog();
        }
    }

    private void showDialog(){
        todo_insert_dialog todo_insert_dialog = new todo_insert_dialog(view.getContext());
        todo_insert_dialog.show();

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //待办 思路：复用添加时的dialog即可 替换diaglog中EditText组件的text属性即可 基本思路同添加
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}