package com.myprogram.pomodoroClock.Record;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

// Data Access Object
// 提供与sql交互的方法
@Dao
public interface RecordDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Record record);

    @Query("DELETE FROM record_table")
    void deleteAll();

    @Query("SELECT * FROM record_table ORDER BY date ASC")
    LiveData<List<Record>> getRecords();
}
