package com.myprogram.pomodoroClock.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.myprogram.pomodoroClock.R;
import com.myprogram.pomodoroClock.pojo.TodoInfo;

public class todo_insert_dialog extends Dialog implements View.OnClickListener {

    Button todo_dialog_bt;
    EditText todo_dialog_et;


   public todo_insert_dialog(Context context){
       super(context);
   }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_insert_dialog);
        todo_dialog_bt = findViewById(R.id.todo_dialog_bt);
        todo_dialog_et = findViewById(R.id.todo_dialog_et);
        todo_dialog_bt.setOnClickListener(this);
        todo_dialog_bt.setClickable(false);

        todo_dialog_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            /**
             * 对文本框进行监听，如果有输入内容，则可以点击完成，若没有文本，则无法点击完成按钮进行保存
             * @param charSequence
             * @param i
             * @param i1
             * @param i2
             */
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence!=null && !"".equals(charSequence.toString())){
                    todo_dialog_bt.setClickable(true);
                }else {
                    todo_dialog_bt.setClickable(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    @Override
    public void onClick(View view) {
        if (R.id.todo_layout_bt==view.getId()){
            TodoInfo todoInfo = new TodoInfo(false,todo_dialog_et.getText().toString());
            this.cancel();
            //将该信息存入数据库中
            //待办

        }

    }

}