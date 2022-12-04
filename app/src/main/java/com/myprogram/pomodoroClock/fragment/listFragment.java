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
import androidx.lifecycle.ViewModelProvider;

import com.myprogram.pomodoroClock.R;
import com.myprogram.pomodoroClock.Record.RecordViewModel;
import com.myprogram.pomodoroClock.adapter.ItemBaseAdapter;
import com.myprogram.pomodoroClock.bean.ToDoListGenerator;
import com.myprogram.pomodoroClock.dialog.todo_insert_dialog;
import com.myprogram.pomodoroClock.pojo.ToDo;

import java.util.List;

public class listFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    View view;
    RecordViewModel recordViewModel;
    List<ToDo> todoInfo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, container, false);
        Bundle bundle = getArguments();

        //
        recordViewModel = new ViewModelProvider(this).get(RecordViewModel.class);
        //

        ListView todo_list_lv = view.findViewById(R.id.todo_list_lv);
        ImageButton todo_layout_bt = view.findViewById(R.id.todo_layout_bt);

        todo_layout_bt.setOnClickListener(this);

        //获取数据
        todoInfo = ToDoListGenerator.getTodoInfo();
        //构造一个适配器
        ItemBaseAdapter itemBaseAdapter = new ItemBaseAdapter(view.getContext(),todoInfo);
        todo_list_lv.setAdapter(itemBaseAdapter);
        todo_list_lv.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.todo_layout_bt){
            showDialog(null);
        }
    }

    private void showDialog(ToDo toDo){
        todo_insert_dialog todo_insert_dialog = new todo_insert_dialog(view.getContext(), recordViewModel,toDo);
        todo_insert_dialog.show();

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        showDialog(todoInfo.get(i));
    }
}