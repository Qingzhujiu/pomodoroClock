package com.myprogram.pomodoroClock.Pomodoro;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class PomodoroRepository {
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

}
