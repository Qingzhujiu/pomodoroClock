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

    public void delete(Pomodoro pomodoro) {
        mRepository.delete(pomodoro);
    }

    public void updateName(long id, String nName) {
        mRepository.updateName(id, nName);
    }

    public void updateDuration(long id, int nDuration) {
        mRepository.updateDuration(id, nDuration);
    }

    public void updateTime(long id, int nTime) {
        mRepository.updateTime(id, nTime);
    }

    public void updateCount(long id, int nCount) {
        mRepository.updateCount(id, nCount);
    }
}
