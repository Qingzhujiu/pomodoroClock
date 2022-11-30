package com.myprogram.pomodoroClock.Record;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

// 还是包装……
public class RecordRepository {
    private RecordDao mRecordDao;
    private LiveData<List<Record>> mAllRecords;

    RecordRepository(Application application) {
        RecordRoomDatabase db = RecordRoomDatabase.getDatabase(application);
        mRecordDao = db.RecordDao();
        mAllRecords = mRecordDao.getRecords();
    }

    LiveData<List<Record>> getAllRecords() {
        return mAllRecords;
    }

    void insert(Record record) {
        RecordRoomDatabase.databaseWriteExecutor.execute(() -> {
            mRecordDao.insert(record);
        });
    }
}
