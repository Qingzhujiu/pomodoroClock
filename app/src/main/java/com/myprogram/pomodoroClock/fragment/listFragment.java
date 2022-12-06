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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.myprogram.pomodoroClock.R;
import com.myprogram.pomodoroClock.ToDo.ToDo;
import com.myprogram.pomodoroClock.ToDo.ToDoViewModel;
import com.myprogram.pomodoroClock.adapter.ItemBaseAdapter;
import com.myprogram.pomodoroClock.dialog.todo_edit_dialog;
import com.myprogram.pomodoroClock.dialog.todo_insert_dialog;


import java.util.List;

public class listFragment extends Fragment implements View.OnClickListener {
    View view;
    ToDoViewModel toDoViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, container, false);
        Bundle bundle = getArguments();

        //
        toDoViewModel =new ViewModelProvider(this).get(ToDoViewModel.class);
        //

        ListView todo_list_lv = view.findViewById(R.id.todo_list_lv);
        ImageButton todo_layout_bt = view.findViewById(R.id.todo_layout_bt);

        todo_layout_bt.setOnClickListener(this);

        toDoViewModel.getAllToDos().observe(this.getViewLifecycleOwner(), new Observer<List<ToDo>>() {
            @Override
            public void onChanged(List<ToDo> toDos) {
                ItemBaseAdapter itemBaseAdapter = new ItemBaseAdapter(view.getContext(),toDos,toDoViewModel);
                mOnItemClickListener mOnItemClickListener = new mOnItemClickListener(toDos);
                todo_list_lv.setAdapter(itemBaseAdapter);
                todo_list_lv.setOnItemClickListener(mOnItemClickListener);
            }

            class mOnItemClickListener implements AdapterView.OnItemClickListener{

                List<ToDo> toDos;

                public mOnItemClickListener(List<ToDo> toDos) {
                    this.toDos = toDos;
                }

                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    todo_edit_dialog todo_edit_dialog = new todo_edit_dialog(view.getContext(),toDoViewModel,toDos.get(i));
                    todo_edit_dialog.show();
                }
            }
        });

        return view;
    }


    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.todo_layout_bt){
            todo_insert_dialog todo_insert_dialog = new todo_insert_dialog(view.getContext(), toDoViewModel);
            todo_insert_dialog.show();
        }
    }


}