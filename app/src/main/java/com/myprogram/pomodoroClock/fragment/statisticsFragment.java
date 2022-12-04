package com.myprogram.pomodoroClock.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GestureDetectorCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.myprogram.pomodoroClock.R;
import com.myprogram.pomodoroClock.Record.Record;
import com.myprogram.pomodoroClock.Record.RecordDialog;
import com.myprogram.pomodoroClock.Record.RecordListAdapter;
import com.myprogram.pomodoroClock.Record.RecordViewModel;

import java.util.Calendar;
import java.util.Date;
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
        TextView daySumDurationTV = view.findViewById(R.id.statistics_fragment_dayConcentration_textView_perDuration_value);
        RecyclerView recyclerView = view.findViewById(R.id.statistics_recyclerView);
        CalendarView calendarView = view.findViewById(R.id.statistics_fragment_calendar_chooser);
        FloatingActionButton fab = view.findViewById(R.id.fab);
        // 获取viewModel对象，用于操作数据
        mRecordViewModel = new ViewModelProvider(this).get(RecordViewModel.class);
        //
        final RecordListAdapter adapter = new RecordListAdapter(new RecordListAdapter.RecordDiff());
        adapter.setFm(getParentFragmentManager());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        // 绑定数据
        mRecordViewModel.getSumDuration().observe(getViewLifecycleOwner(), integer -> {
            // 显示总时长
            totalDurationTV.setText(integerToTime(integer));
            mRecordViewModel.getSumTimes().observe(getViewLifecycleOwner(), times -> {
                // 显示总次数
                try {
                    totalTimesTV.setText(times.toString());
                } catch (Exception e) {
                    totalTimesTV.setText("0");
                    e.printStackTrace();
                }
                // 显示平均每次时长
                totalPerDurationTV.setText(integerToTime(integer / times));
            });
        });


        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.clear();
        calendar1.set(calendar2.get(Calendar.YEAR), calendar2.get(Calendar.MONTH),
                calendar2.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        long begin = calendar1.getTimeInMillis();
        calendar1.clear();
        calendar1.set(calendar2.get(Calendar.YEAR), calendar2.get(Calendar.MONTH),
                calendar2.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        long end = calendar1.getTimeInMillis();
        mRecordViewModel.getDayRecords(begin, end).observe(getViewLifecycleOwner(), adapter::submitList);
        mRecordViewModel.getDaySumDuration(begin, end).observe(getViewLifecycleOwner(), integer -> {
            daySumDurationTV.setText(integerToTime(integer));
        });
        mRecordViewModel.getDaySumTimes(begin, end).observe(getViewLifecycleOwner(), times -> {
            try {
                dayTimesTV.setText(times.toString());
            } catch (Exception e) {
                dayTimesTV.setText("0");
                e.printStackTrace();
            }
        });
        // 绑定监听器
        calendarView.setOnDateChangeListener((view1, year, month, dayOfMonth) -> {
            Calendar calendar = Calendar.getInstance();
            calendar.clear();
            calendar.set(year, month, dayOfMonth, 0, 0, 0);
            long begin1 = calendar.getTimeInMillis();
            calendar.clear();
            calendar.set(year, month, dayOfMonth, 23, 59, 59);
            long end1 = calendar.getTimeInMillis();
            mRecordViewModel.getDayRecords(begin1, end1).observe(getViewLifecycleOwner(), adapter::submitList);
            mRecordViewModel.getDaySumDuration(begin1, end1).observe(getViewLifecycleOwner(), integer -> {
                daySumDurationTV.setText(
                        integerToTime(integer));
            });
            mRecordViewModel.getDaySumTimes(begin1, end1).observe(getViewLifecycleOwner(), times -> {
                try {
                    dayTimesTV.setText(times.toString());
                } catch (Exception e) {
                    dayTimesTV.setText("0");
                    e.printStackTrace();
                }
            });
        });

        fab.setOnClickListener(nView -> {
            long date = System.currentTimeMillis();
            int duration = random.nextInt(100);
            int times = random.nextInt(10);
            String type = "TestType" + random.nextInt(100);
            String name = "TestName" + (random.nextInt(200) - 100);
            Record record = new Record(date, type, name, duration, times);
            mRecordViewModel.insert(record);
//            Toast.makeText(
//                    this.getContext().getApplicationContext(),
//                    R.string.empty_not_saved,
//                    Toast.LENGTH_LONG).show();
        });
        return view;
    }

    String integerToTime(Integer integer) {
        String str = "";
        if (integer == null)
            integer = 0;
        int t = integer;
        int h = t / 60, m = t % 60;
        if (h != 0)
            str = h + "时";
        str += m + "分";
        return str;
    }

    public void RecordDelete(Record record) {
        mRecordViewModel.delete(record);
    }
}