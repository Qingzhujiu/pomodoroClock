package com.myprogram.pomodoroClock.Pomodoro;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.io.Serializable;
import java.util.List;

public class PomodoroRepository{
    private PomodoroDao mPomodoroDao;
    private LiveData<List<Pomodoro>> mAllPomodoros;

    PomodoroRepository(Application application) {
        PomodoroRoomDatabase db = PomodoroRoomDatabase.getDatabase(application);
        mPomodoroDao = db.PomodoroDao();
        mAllPomodoros = mPomodoroDao.getPomodoros();
    }

    LiveData<List<Pomodoro>> getAllPomodoros() {
        return mAllPomodoros;
    }

    void insert(Pomodoro pomodoro) {
        PomodoroRoomDatabase.databaseWriteExecutor.execute(() -> {
            mPomodoroDao.insert(pomodoro);
        });
    }

    void delete(Pomodoro pomodoro) {
        PomodoroRoomDatabase.databaseWriteExecutor.execute(() -> {
            mPomodoroDao.delete(pomodoro);
        });
    }

    void updateName(long id, String nName) {
        PomodoroRoomDatabase.databaseWriteExecutor.execute(() -> {
            mPomodoroDao.updateName(id, nName);
        });
    }

    void updateDuration(long id, int nDuration) {
        PomodoroRoomDatabase.databaseWriteExecutor.execute(() -> {
            mPomodoroDao.updateDuration(id, nDuration);
        });
    }

    void updateTime(long id, int nTime) {
        PomodoroRoomDatabase.databaseWriteExecutor.execute(() -> {
            mPomodoroDao.updateTime(id, nTime);
        });
    }

    void updateCount(long id, int nCount) {
        PomodoroRoomDatabase.databaseWriteExecutor.execute(() -> {
            mPomodoroDao.updateCount(id, nCount);
        });
    }
}
