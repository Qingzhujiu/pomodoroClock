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
    private final LiveData<List<Record>> mDayRecords;
    private final LiveData<Integer> mSumTimes, mSumDuration, mDaySumTimes, mDaySumDuration;

    public RecordViewModel(@NonNull Application application) {
        super(application);
        mRepository = new RecordRepository(application);
        mAllRecords = mRepository.getAllRecords();
        mDayRecords = mRepository.getDayRecords();
        mSumTimes = mRepository.getSumTimes();
        mSumDuration = mRepository.getSumDuration();
        mDaySumTimes = mRepository.getDaySumTimes(0, 0);
        mDaySumDuration = mRepository.getDaySumDuration(0, 0);
    }

    public LiveData<List<Record>> getAllRecords() {
        return mAllRecords;
    }

    public LiveData<List<Record>> getDayRecords() {
        return mDayRecords;
    }

    public LiveData<Integer> getSumTimes() {
        return mSumTimes;
    }

    public LiveData<Integer> getSumDuration() {
        return mSumDuration;
    }

    public LiveData<Integer> getDaySumTimes() {
        return mDaySumTimes;
    }

    public LiveData<Integer> getDaySumDuration() {
        return mDaySumDuration;
    }

    public void insert(Record record) {
        mRepository.insert(record);
    }
}
