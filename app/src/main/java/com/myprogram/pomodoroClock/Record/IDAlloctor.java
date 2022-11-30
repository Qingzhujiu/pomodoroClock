package com.myprogram.pomodoroClock.Record;

public class IDAlloctor {
    private static long IDcnt;
    private static volatile IDAlloctor INSTANCE;

    private IDAlloctor() {
        IDcnt = 0;
    }

    static IDAlloctor getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new IDAlloctor();
        }
        return INSTANCE;
    }

    public long getID() {
        IDcnt++;
        return IDcnt;
    }
}
