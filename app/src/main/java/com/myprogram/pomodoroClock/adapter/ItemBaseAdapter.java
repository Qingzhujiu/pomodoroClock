package com.myprogram.pomodoroClock.adapter;

import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.myprogram.pomodoroClock.R;
import com.myprogram.pomodoroClock.bean.Item;

import java.util.List;

public class ItemBaseAdapter extends BaseAdapter {
    private Context mContext;
    private List<Item> mItemList;

    public ItemBaseAdapter(Context mContext, List<Item> mItem) {
        this.mContext = mContext;
        this.mItemList = mItem;
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
        TextView todo_items_text = mview.findViewById(R.id.todo_items_text);
        CheckBox todo_items_ck = mview.findViewById(R.id.todo_items_ck);
        Item item = mItemList.get(i);
        todo_items_text.setText(item.getContent());
        todo_items_ck.setChecked(item.getIsFinished());
        return mview;
    }
}
