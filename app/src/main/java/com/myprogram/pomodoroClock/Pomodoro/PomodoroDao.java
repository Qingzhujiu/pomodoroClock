package com.myprogram.pomodoroClock.Pomodoro;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PomodoroDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Pomodoro pomodoro);

    @Query("DELETE FROM pomodoro_table")
    void deleteAll();

    @Query("SELECT * FROM pomodoro_table ORDER BY pomodoro_id ASC")
    LiveData<List<Pomodoro>> getPomodoros();

}
