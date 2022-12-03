package com.myprogram.pomodoroClock.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.myprogram.pomodoroClock.R;
import com.myprogram.pomodoroClock.Record.Record;
import com.myprogram.pomodoroClock.Record.RecordListAdapter;
import com.myprogram.pomodoroClock.Record.RecordViewModel;

import java.util.Random;

public class statisticsFragment extends Fragment {
    private RecordViewModel mRecordViewModel;
    public static final int NEW_RECORD_ACTIVITY_REQUEST_CODE = 1;
    public static final Random random = new Random();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);
        Bundle bundle = getArguments();
        // 获取需要修改的文本框
        TextView totalTimesTV = view.findViewById(R.id.statistics_fragment_totalConcentration_textView_times_value);
        TextView totalDurationTV = view.findViewById(R.id.statistics_fragment_totalConcentration_textView_totalDuration_value);
        TextView totalPerDurationTV = view.findViewById(R.id.statistics_fragment_totalConcentration_textView_perDuration_value);
        TextView dayTimesTV = view.findViewById(R.id.statistics_fragment_dayConcentration_textView_times_value);
        TextView dayPerDurationTV = view.findViewById(R.id.statistics_fragment_dayConcentration_textView_perDuration_value);
        RecyclerView recyclerView = view.findViewById(R.id.statistics_recyclerView);
        CalendarView calendarView = view.findViewById(R.id.statistics_fragment_calendar_chooser);
        FloatingActionButton fab = view.findViewById(R.id.fab);
        // 获取viewModel对象，用于操作数据
        mRecordViewModel = new ViewModelProvider(this).get(RecordViewModel.class);
        //
        final RecordListAdapter adapter = new RecordListAdapter(new RecordListAdapter.RecordDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        // 绑定数据
        mRecordViewModel.getAllRecords().observe(getViewLifecycleOwner(), adapter::submitList);
        mRecordViewModel.getSumDuration().observe(getViewLifecycleOwner(), integer -> {
            String str = "";
            int t = integer;
            int h = t / 60, m = t % 60;
            if (h != 0)
                str = h + "时";
            str += m + "分";
            totalDurationTV.setText(str);
            mRecordViewModel.getSumTimes().observe(getViewLifecycleOwner(), times -> {
                totalTimesTV.setText(times.toString());
                int perT = integer / times;
                String perStr = "";
                int perH = perT / 60, perM = perT % 60;
                if (perH != 0)
                    perStr = perH + "时";
                perStr += perM + "分";
                totalPerDurationTV.setText(perStr);
            });
        });
        // 绑定监听器
        calendarView.setOnDateChangeListener((view1, year, month, dayOfMonth) -> Toast.makeText(
                getContext().getApplicationContext(),
                "year: " + year + ", month: " + month + ", dayOfMonth" + dayOfMonth,
                Toast.LENGTH_LONG
        ).show());
        fab.setOnClickListener(nView -> {
            long date = System.currentTimeMillis();
            int duration = random.nextInt(100);
            int times = random.nextInt(10);
            String type = "TestType" + random.nextInt(100);
            String name = "TestName" + (random.nextInt(200) - 100);
            Record record = new Record(date, type, name, duration, times);
            mRecordViewModel.insert(record);
            Toast.makeText(
                    this.getContext().getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        });
        return view;
    }
}