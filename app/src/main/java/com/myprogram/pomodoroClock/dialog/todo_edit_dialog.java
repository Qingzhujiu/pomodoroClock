package com.myprogram.pomodoroClock.dialog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.myprogram.pomodoroClock.R;
import com.myprogram.pomodoroClock.ToDo.ToDo;
import com.myprogram.pomodoroClock.ToDo.ToDoViewModel;

public class todo_edit_dialog extends Dialog implements View.OnClickListener {

    Button todo_edit_dialog_change;
    Button todo_edit_dialog_del;
    EditText todo_dialog_et;
    ToDoViewModel mtoDoViewModel;
    ToDo toDo;

    public todo_edit_dialog(@NonNull Context context,ToDoViewModel mtoDoViewModel,ToDo toDo) {
        super(context);
        this.mtoDoViewModel = mtoDoViewModel;
        this.toDo = toDo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_edit_dialog);
        todo_edit_dialog_change = findViewById(R.id.todo_edit_dialog_change);
        todo_edit_dialog_del = findViewById(R.id.todo_edit_dialog_del);
        todo_dialog_et = findViewById(R.id.todo_dialog_et);

        todo_edit_dialog_change.setOnClickListener(this);
        todo_edit_dialog_del.setOnClickListener(this);
        todo_dialog_et.setText (toDo.getContent());
        todo_edit_dialog_change.setClickable(true);

        todo_dialog_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence!=null && !"".equals(charSequence.toString())){
                    todo_edit_dialog_change.setClickable(true);
                }else {
                    todo_edit_dialog_change.setClickable(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });




    }

    @Override
    public void onClick(View view) {
        if (R.id.todo_edit_dialog_change == view.getId()){

            mtoDoViewModel.updateToDo(toDo.getId(),todo_dialog_et.getText().toString(),toDo.isFinished());
            this.cancel();

        }else if (R.id.todo_edit_dialog_del == view.getId()){

            mtoDoViewModel.delete(toDo);
            this.cancel();
        }
    }
}