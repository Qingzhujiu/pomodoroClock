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
    private LiveData<List<Record>> mDayRecords;
    private final LiveData<Integer> mSumTimes, mSumDuration;
    private LiveData<Integer> mDaySumTimes, mDaySumDuration;

    public RecordViewModel(@NonNull Application application) {
        super(application);
        mRepository = new RecordRepository(application);
        mAllRecords = mRepository.getAllRecords();
        mDayRecords = mRepository.getDayRecords(0, 0);
        mSumTimes = mRepository.getSumTimes();
        mSumDuration = mRepository.getSumDuration();
        mDaySumTimes = mRepository.getDaySumTimes(0, 0);
        mDaySumDuration = mRepository.getDaySumDuration(0, 0);
    }

    public LiveData<List<Record>> getAllRecords() {
        return mAllRecords;
    }

    public LiveData<List<Record>> getDayRecords(long begin, long end) {
        mDayRecords = mRepository.getDayRecords(begin, end);
        return mDayRecords;
    }

    public LiveData<Integer> getSumTimes() {
        return mSumTimes;
    }

    public LiveData<Integer> getSumDuration() {
        return mSumDuration;
    }

    public LiveData<Integer> getDaySumTimes(long begin, long end) {
        mDaySumTimes = mRepository.getDaySumTimes(begin, end);
        return mDaySumTimes;
    }

    public LiveData<Integer> getDaySumDuration(long begin, long end) {
        mDaySumDuration = mRepository.getDaySumDuration(begin, end);
        return mDaySumDuration;
    }

    public void insert(Record record) {
        mRepository.insert(record);
    }
}
