package com.myprogram.pomodoroClock.ToDo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ToDoRepository {
    private ToDoDao mToDoDao;
    private LiveData<List<ToDo>> mAllToDos;

    ToDoRepository(Application application) {
        ToDoRoomDatabase db = ToDoRoomDatabase.getDatabase(application);
        mToDoDao = db.ToDoDao();
        mAllToDos = mToDoDao.getToDos();
    }

    LiveData<List<ToDo>> getAllToDos() {
        return mAllToDos;
    }

    void insert(ToDo toDo) {
        ToDoRoomDatabase.databaseWriteExecutor.execute(() -> {
            mToDoDao.insert(toDo);
        });
    }

}
