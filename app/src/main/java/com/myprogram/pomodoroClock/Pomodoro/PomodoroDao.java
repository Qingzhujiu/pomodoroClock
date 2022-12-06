package com.myprogram.pomodoroClock.Pomodoro;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PomodoroDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Pomodoro pomodoro);

    @Query("DELETE FROM pomodoro_table")
    void deleteAll();

    @Delete
    void delete(Pomodoro pomodoro);

    @Query("SELECT * FROM pomodoro_table ORDER BY pomodoro_id ASC")
    LiveData<List<Pomodoro>> getPomodoros();

    @Query("UPDATE pomodoro_table SET name = :nName WHERE pomodoro_id = :id")
    void updateName(long id, String nName);

    @Query("UPDATE pomodoro_table SET duration = :nDuration WHERE pomodoro_id = :id")
    void updateDuration(long id, int nDuration);
    @Query("UPDATE pomodoro_table SET time = :nTime WHERE pomodoro_id = :id")
    void updateTime(long id, int nTime);
    @Query("UPDATE pomodoro_table SET  count = :nCount WHERE pomodoro_id = :id")
    void updateCount(long id, int nCount);
}
