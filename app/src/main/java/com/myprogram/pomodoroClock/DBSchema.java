package com.myprogram.pomodoroClock;

public class DBSchema {
    public static final class RecordTable{
        public static final String NAME = "records";

        public static final class Cols{
            public static final String RCdID = "rcdID";
            public static final String DATE = "date";
            public static final String TYPE = "type";
            public static final String NAME = "name";
            public static final String DURATION = "duration";
            public static final String TIMES = "times";
        }
    }
}
