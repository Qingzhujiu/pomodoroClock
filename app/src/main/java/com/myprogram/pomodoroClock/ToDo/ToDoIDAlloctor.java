package com.myprogram.pomodoroClock.ToDo;

import com.myprogram.pomodoroClock.Record.RecordIDAlloctor;

public class ToDoIDAlloctor {
    private static long IDcnt;
    private static volatile ToDoIDAlloctor INSTANCE;

    private ToDoIDAlloctor() {
        IDcnt = 0;
    }

    public static ToDoIDAlloctor getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new ToDoIDAlloctor();
        }
        return INSTANCE;
    }

    public long getID() {
        IDcnt++;
        return IDcnt;
    }
}
