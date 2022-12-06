package com.myprogram.pomodoroClock.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.myprogram.pomodoroClock.Pomodoro.Pomodoro;
import com.myprogram.pomodoroClock.Pomodoro.PomodoroViewModel;
import com.myprogram.pomodoroClock.R;
import com.myprogram.pomodoroClock.ToDo.ToDo;
import com.myprogram.pomodoroClock.adapter.TomatoClockBaseAdapter;
import com.myprogram.pomodoroClock.dialog.tomato_clock_add_dialog;
import com.myprogram.pomodoroClock.dialog.tomato_clock_touch_dialog;

import java.util.List;


public class tomatoClockFragment extends Fragment implements View.OnClickListener {
    View mview;
    PomodoroViewModel pomodoroViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mview =inflater.inflate(R.layout.fragment_tomato_clock, container, false);
        ImageButton fragment_tomato_clock_bt = mview.findViewById(R.id.fragment_tomato_clock_bt);
        fragment_tomato_clock_bt.setOnClickListener(this);

        pomodoroViewModel = new ViewModelProvider(this).get(PomodoroViewModel.class);

        ListView tomato_clock_lv = mview.findViewById(R.id.tomato_clock_lv);

        this.pomodoroViewModel.getAllRecords().observe(this.getViewLifecycleOwner(), new Observer<List<Pomodoro>>() {

            @Override
            public void onChanged(List<Pomodoro> pomodoros) {
                TomatoClockBaseAdapter tomatoClockBaseAdapter = new TomatoClockBaseAdapter(mview.getContext(), pomodoros);
                mOnItemClickListener mOnItemClickListener = new mOnItemClickListener(pomodoros);
                tomato_clock_lv.setAdapter(tomatoClockBaseAdapter);
                tomato_clock_lv.setOnItemClickListener(mOnItemClickListener);
            }

            class mOnItemClickListener implements AdapterView.OnItemClickListener{

                List<Pomodoro> pomodoros;

                public mOnItemClickListener(List<Pomodoro> pomodoros) {
                    this.pomodoros = pomodoros;
                }

                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    tomato_clock_touch_dialog tomato_clock_touch_dialog = new tomato_clock_touch_dialog(mview.getContext(), pomodoros.get(i),pomodoroViewModel);
                    tomato_clock_touch_dialog.show();
                }
            }

        });

        return mview;

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.fragment_tomato_clock_bt){
            showDialog();
        }
    }


    private void showDialog(){
        tomato_clock_add_dialog tomato_clock_add_dialog = new tomato_clock_add_dialog(mview.getContext(),pomodoroViewModel);
        tomato_clock_add_dialog.show();

    }

}