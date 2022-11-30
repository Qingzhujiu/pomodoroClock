package com.myprogram.pomodoroClock.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.myprogram.pomodoroClock.R;
import com.myprogram.pomodoroClock.dialog.todo_insert_dialog;
import com.myprogram.pomodoroClock.dialog.tomato_clock_add_dialog;


public class tomatoClockFragment extends Fragment implements View.OnClickListener {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_tomato_clock, container, false);

        ImageButton fragment_tomato_clock_bt = view.findViewById(R.id.fragment_tomato_clock_bt);
        fragment_tomato_clock_bt.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.fragment_tomato_clock_bt){
            showDialog();
        }
    }


    private void showDialog(){
        tomato_clock_add_dialog tomato_clock_add_dialog = new tomato_clock_add_dialog(view.getContext());
        tomato_clock_add_dialog.show();

    }

}