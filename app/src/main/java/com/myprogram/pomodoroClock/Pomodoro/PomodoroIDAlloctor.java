package com.myprogram.pomodoroClock.Pomodoro;

public class PomodoroIDAlloctor {
    private static long IDcnt;
    private static volatile PomodoroIDAlloctor INSTANCE;

    private PomodoroIDAlloctor() {
        IDcnt = 0;
    }

    public static PomodoroIDAlloctor getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new PomodoroIDAlloctor();
        }
        return INSTANCE;
    }

    public long getID() {
        IDcnt++;
        return IDcnt;
    }
}
