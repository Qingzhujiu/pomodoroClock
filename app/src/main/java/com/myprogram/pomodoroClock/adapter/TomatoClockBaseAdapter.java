package com.myprogram.pomodoroClock.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.myprogram.pomodoroClock.MainActivity;
import com.myprogram.pomodoroClock.R;
import com.myprogram.pomodoroClock.clock;
import com.myprogram.pomodoroClock.pojo.Pomodora;

import java.net.URL;
import java.util.List;

public class TomatoClockBaseAdapter extends BaseAdapter implements View.OnClickListener  {
    private Context mContext;
    private List<Pomodora> mItemList;


    public TomatoClockBaseAdapter(Context mContext, List<Pomodora> mItemList) {
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
        tomato_clock_item_start.setOnClickListener(this);
        Pomodora pomodora = mItemList.get(i);
        tomato_clock_item_name.setText(pomodora.getClockName());

        //因为存取的数据是int型的，但setText方法为Sting所以需要先转为Sting类型
        //int类型会被识别为 id为xxx的资源文件 因此会报错
        Integer time = pomodora.getTime();
        String s = time.toString()+"分钟";
        tomato_clock_item_time.setText(s);
        return mview;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(),clock.class);
        view.getContext().startActivity(intent);
    }

}
