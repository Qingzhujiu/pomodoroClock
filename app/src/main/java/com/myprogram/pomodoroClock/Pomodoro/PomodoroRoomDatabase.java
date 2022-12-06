package com.myprogram.pomodoroClock.Pomodoro;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Pomodoro.class}, version = 1, exportSchema = false)
public abstract class PomodoroRoomDatabase extends RoomDatabase{
    public abstract PomodoroDao PomodoroDao();

    private static volatile PomodoroRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private static Callback sRoomDatabaseCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(() -> {
                PomodoroDao dao = INSTANCE.PomodoroDao();
                dao.deleteAll();
            });
        }
    };

    static PomodoroRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PomodoroRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    PomodoroRoomDatabase.class, "pomodoro_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
