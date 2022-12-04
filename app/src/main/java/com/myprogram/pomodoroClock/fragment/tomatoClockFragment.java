package com.myprogram.pomodoroClock.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.myprogram.pomodoroClock.R;
import com.myprogram.pomodoroClock.adapter.TomatoClockBaseAdapter;
import com.myprogram.pomodoroClock.bean.PomodoraListGenerator;
import com.myprogram.pomodoroClock.dialog.tomato_clock_add_dialog;
import com.myprogram.pomodoroClock.dialog.tomato_clock_touch_dialog;
import com.myprogram.pomodoroClock.pojo.Pomodora;

import java.util.List;


public class tomatoClockFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    View mview;
    List<Pomodora> pomodaraInfo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mview =inflater.inflate(R.layout.fragment_tomato_clock, container, false);
        ImageButton fragment_tomato_clock_bt = mview.findViewById(R.id.fragment_tomato_clock_bt);
        fragment_tomato_clock_bt.setOnClickListener(this);


        ListView tomato_clock_lv = mview.findViewById(R.id.tomato_clock_lv);

        pomodaraInfo = PomodoraListGenerator.getPomodaraInfo();

        TomatoClockBaseAdapter tomatoClockBaseAdapter = new TomatoClockBaseAdapter(mview.getContext(), pomodaraInfo);
        tomato_clock_lv.setAdapter(tomatoClockBaseAdapter);
        tomato_clock_lv.setOnItemClickListener(this);

        return mview;

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.fragment_tomato_clock_bt){
            showDialog();
        }
    }


    private void showDialog(){
        tomato_clock_add_dialog tomato_clock_add_dialog = new tomato_clock_add_dialog(mview.getContext());
        tomato_clock_add_dialog.show();

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        tomato_clock_touch_dialog tomato_clock_touch_dialog = new tomato_clock_touch_dialog(mview.getContext(),pomodaraInfo.get(i));
        tomato_clock_touch_dialog.show();
    }
}