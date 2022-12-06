package com.myprogram.pomodoroClock.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.myprogram.pomodoroClock.Pomodoro.PomodoroViewModel;
import com.myprogram.pomodoroClock.R;
import com.myprogram.pomodoroClock.clock;
import com.myprogram.pomodoroClock.Pomodoro.Pomodoro;

import java.time.Duration;
import java.util.List;

public class TomatoClockBaseAdapter extends BaseAdapter{
    private Context mContext;
    private List<Pomodoro> mItemList;
    Pomodoro pomodoro;

    public TomatoClockBaseAdapter(Context mContext, List<Pomodoro> mItemList) {
        this.mContext = mContext;
        this.mItemList = mItemList;

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

    /**
     * 根据布局文件生成转换视图对象
     * @param i
     * @param view
     * @param viewGroup
     * @return
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //先获取该视图
        View mview = LayoutInflater.from(mContext).inflate(R.layout.activity_tomato_clock_items, null);
        TextView tomato_clock_item_name = mview.findViewById(R.id.tomato_clock_item_name);
        TextView tomato_clock_item_time = mview.findViewById(R.id.tomato_clock_item_time);
        Button tomato_clock_item_start = mview.findViewById(R.id.tomato_clock_item_start);

        pomodoro = mItemList.get(i);

        myOnClickListener myOnClickListener = new myOnClickListener();
        tomato_clock_item_start.setOnClickListener(myOnClickListener);

        tomato_clock_item_name.setText(pomodoro.getName());

        //因为存取的数据是int型的，但setText方法为Sting所以需要先转为Sting类型
        //int类型会被识别为 id为xxx的资源文件 因此会报错
        Integer time = pomodoro.getTime();
        String s = time.toString()+"分钟";
        tomato_clock_item_time.setText(s);
        return mview;
    }

    private class myOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(),clock.class);
            Bundle bundle = new Bundle();
            bundle.putInt("time",pomodoro.getTime());
            bundle.putLong("clockId",pomodoro.getId());
            bundle.putInt("count",pomodoro.getCount());
            bundle.putInt("duration", pomodoro.getDuration());
            intent.putExtras(bundle);
            view.getContext().startActivity(intent);
        }


    }

}
