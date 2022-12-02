package com.myprogram.pomodoroClock.Pomodoro;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;


public class PomodoroViewModel extends AndroidViewModel {
    private PomodoroRepository mRepository;
    private final LiveData<List<Pomodoro>> mAllPomodoros;

    public PomodoroViewModel(@NonNull Application application) {
        super(application);
        mRepository = new PomodoroRepository(application);
        mAllPomodoros = mRepository.getAllPomodoros();
    }

    public LiveData<List<Pomodoro>> getAllRecords() {
        return mAllPomodoros;
    }

    public void insert(Pomodoro pomodoro) {
        mRepository.insert(pomodoro);
    }
}
