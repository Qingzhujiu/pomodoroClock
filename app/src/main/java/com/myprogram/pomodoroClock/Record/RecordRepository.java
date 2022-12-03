package com.myprogram.pomodoroClock.Record;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

// 还是包装……
public class RecordRepository {
    private final RecordDao mRecordDao;
    private final LiveData<List<Record>> mAllRecords;
    private final LiveData<List<Record>> mDayRecords;
    private final LiveData<Integer> mSumTimes, mSumDuration;
    private LiveData<Integer> mDaySumTimes, mDaySumDuration;

    RecordRepository(Application application) {
        RecordRoomDatabase db = RecordRoomDatabase.getDatabase(application);
        mRecordDao = db.RecordDao();
        mAllRecords = mRecordDao.getRecordsLD();
        mDayRecords = mRecordDao.getRecordsLD(0, 0);
        mSumTimes = mRecordDao.getSumTimes();
        mSumDuration = mRecordDao.getSumDuration();
        mDaySumTimes = mRecordDao.getSumTimes(0, 0);
        mDaySumDuration = mRecordDao.getSumDuration(0, 0);
    }

    public LiveData<Integer> getSumTimes() {
        return mSumTimes;
    }

    public LiveData<Integer> getSumDuration() {
        return mSumDuration;
    }

    public LiveData<Integer> getDaySumTimes(long begin, long end) {
        mDaySumTimes = mRecordDao.getSumTimes(begin, end);
        return mDaySumTimes;
    }

    public LiveData<Integer> getDaySumDuration(long begin, long end) {
        mDaySumDuration = mRecordDao.getSumDuration(begin, end);
        return mDaySumDuration;
    }

    LiveData<List<Record>> getAllRecords() {
        return mAllRecords;
    }

    LiveData<List<Record>> getDayRecords() {
        return mDayRecords;
    }

    void insert(Record record) {
        RecordRoomDatabase.databaseWriteExecutor.execute(() -> {
            mRecordDao.insert(record);
        });
    }
}
