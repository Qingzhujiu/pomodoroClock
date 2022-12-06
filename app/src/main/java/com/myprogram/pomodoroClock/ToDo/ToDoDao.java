package com.myprogram.pomodoroClock.ToDo;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ToDoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ToDo toDo);

    @Query("DELETE FROM todo_table")
    void deleteAll();

    @Delete
    void delete(ToDo toDo);
    @Query("SELECT * FROM todo_table ORDER BY todo_id ASC")
    LiveData<List<ToDo>> getToDos();

    @Query("UPDATE todo_table SET content = :nContent, isFinished = :nisFinished WHERE todo_id = :id")
    void updateToDo(long id, String nContent, boolean nisFinished);

    @Query("UPDATE todo_table SET content = :nContent WHERE todo_id = :id")
    void updateToDo(long id, String nContent);

    @Query("UPDATE todo_table SET isFinished = :nisFinished WHERE todo_id = :id")
    void updateToDo(long id, boolean nisFinished);
}
