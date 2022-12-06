package com.myprogram.pomodoroClock.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;


import com.myprogram.pomodoroClock.R;
import com.myprogram.pomodoroClock.ToDo.ToDo;
import com.myprogram.pomodoroClock.ToDo.ToDoViewModel;

import java.util.List;

public class ItemBaseAdapter extends BaseAdapter {
    private Context mContext;
    private List<ToDo> mItemList;
    ToDoViewModel toDoViewModel;
    TextView todo_items_text;

    public ItemBaseAdapter(Context mContext, List<ToDo> mItem,ToDoViewModel toDoViewModel) {
        this.mContext = mContext;
        this.mItemList = mItem;
        this.toDoViewModel = toDoViewModel;
    }

    @Override
    public int getCount() {
        return mItemList.size();
    }

    @Override
    public Object getItem(int i) {
        return mItemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //根据布局文件生成转换视图对象

        //先获取该视图
        View mview = LayoutInflater.from(mContext).inflate(R.layout.activity_todo_items, null);
        ToDo item = mItemList.get(i);
        todo_items_text = mview.findViewById(R.id.todo_items_text);
        if (item.isFinished()){
            todo_items_text.setTextColor(0x4B9EB3C3);
        }

        mOnCheckedChangeListener mOnCheckedChangeListener = new mOnCheckedChangeListener(item);

        CheckBox todo_items_ck = mview.findViewById(R.id.todo_items_ck);
        todo_items_text.setText(item.getContent());
        todo_items_ck.setChecked(item.isFinished());
        todo_items_ck.setOnCheckedChangeListener(mOnCheckedChangeListener);
        return mview;
    }

    private class mOnCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {
        ToDo todo;

        public mOnCheckedChangeListener(ToDo todo) {
            this.todo = todo;
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            toDoViewModel.updateToDo(todo.getId(),b);
        }
    }

}
