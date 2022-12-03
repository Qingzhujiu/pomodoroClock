package com.myprogram.pomodoroClock.Record;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import kotlin.ParameterName;

// Data Access Object
// 提供与sql交互的方法
@Dao
public interface RecordDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Record record);

    @Query("DELETE FROM record_table")
    void deleteAll();

    @Query("SELECT * FROM record_table ORDER BY record_id ASC")
    LiveData<List<Record>> getRecordsLD();

    @Query("SELECT * FROM record_table WHERE date >= :begin AND date <= :end ORDER BY record_id ASC")
    LiveData<List<Record>> getRecordsLD(long begin, long end);

    @Query("SELECT SUM(times) FROM record_table")
    LiveData<Integer> getSumTimes();

    @Query("SELECT SUM(duration) FROM record_table")
    LiveData<Integer> getSumDuration();

    @Query("SELECT SUM(times) FROM record_table WHERE date >= :begin AND date <= :end")
    LiveData<Integer> getSumTimes(long begin, long end);

    @Query("SELECT SUM(duration) FROM record_table WHERE date >= :begin AND date <= :end")
    LiveData<Integer> getSumDuration(long begin, long end);

}
