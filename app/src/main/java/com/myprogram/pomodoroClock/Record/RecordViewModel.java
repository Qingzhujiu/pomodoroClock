package com.myprogram.pomodoroClock.Record;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

// 控制数据
public class RecordViewModel extends AndroidViewModel {

    private RecordRepository mRepository;
    private final LiveData<List<Record>> mAllRecords;

    public RecordViewModel(@NonNull Application application) {
        super(application);
        mRepository = new RecordRepository(application);
        mAllRecords = mRepository.getAllRecords();
    }

    public LiveData<List<Record>> getAllRecords() {
        return mAllRecords;
    }

    public void insert(Record record) {
        mRepository.insert(record);
    }
}
