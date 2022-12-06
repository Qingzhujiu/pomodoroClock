package com.myprogram.pomodoroClock.ToDo;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.io.Serializable;
import java.util.List;


public class ToDoViewModel extends AndroidViewModel {
    private ToDoRepository mRepository;
    private final LiveData<List<ToDo>> mAllToDos;

    public ToDoViewModel(@NonNull Application application) {
        super(application);
        mRepository = new ToDoRepository(application);
        mAllToDos = mRepository.getAllToDos();
    }



    public LiveData<List<ToDo>> getAllToDos() {
        return mAllToDos;
    }


    public void insert(ToDo toDo) {
        mRepository.insert(toDo);
    }

    public void delete(ToDo toDo) {
        mRepository.delete(toDo);
    }

    public void updateToDo(long id, String nContent, boolean nisFinished) {
        mRepository.updateToDo(id, nContent, nisFinished);
    }

    public void updateToDo(long id, String nContent) {
        mRepository.updateToDo(id, nContent);
    }

    public void updateToDo(long id, boolean nisFinished) {
        mRepository.updateToDo(id, nisFinished);
    }
}
