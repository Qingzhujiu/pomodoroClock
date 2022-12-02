package com.myprogram.pomodoroClock.Record;

import androidx.room.TypeConverter;

import java.util.Date;

public class RecordConverters {
    @TypeConverter
    public static Date fromTimestamp(Long dateLong) {
        return dateLong == null ? null : new Date(dateLong);
    }

    @TypeConverter
    public static long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
