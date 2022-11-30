package com.myprogram.pomodoroClock.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        RecyclerView recyclerView = view.findViewById(R.id.statistics_recyclerView);
        mRecordViewModel = new ViewModelProvider(this).get(RecordViewModel.class);
        final RecordListAdapter adapter = new RecordListAdapter(new RecordListAdapter.RecordDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        mRecordViewModel.getAllRecords().observe(getViewLifecycleOwner(), records -> {
            adapter.submitList(records);
        });
        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(nView -> {
            long date = System.currentTimeMillis();
            int duration = random.nextInt(100);
            int times = random.nextInt(10);
            String type = "TestType" + Integer.toString(random.nextInt(100));
            String name = "TestName" + Integer.toString(random.nextInt(200) - 100);
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