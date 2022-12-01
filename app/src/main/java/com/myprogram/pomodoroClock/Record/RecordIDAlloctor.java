package com.myprogram.pomodoroClock.Record;

public class RecordIDAlloctor {
    private static long IDcnt;
    private static volatile RecordIDAlloctor INSTANCE;

    private RecordIDAlloctor() {
        IDcnt = 0;
    }

    public static RecordIDAlloctor getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new RecordIDAlloctor();
        }
        return INSTANCE;
    }

    public long getID() {
        IDcnt++;
        return IDcnt;
    }
}
