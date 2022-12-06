package com.myprogram.pomodoroClock.Pomodoro;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Objects;

@Entity(tableName = "pomodoro_table")

public class Pomodoro {
    static class IdAlloctor{
        static public long getID() {
            return System.currentTimeMillis();
        }
    }

    @PrimaryKey
    @ColumnInfo(name = "pomodoro_id")
    private long mId;

    @NonNull
    @ColumnInfo(name = "name")
    private String mName;

    @ColumnInfo(name = "duration")
    private int mDuration;

    @ColumnInfo(name = "time")
    private int mTime;

    @ColumnInfo(name = "count")
    private int mCount;

    public Pomodoro() {
        this.mId = -1;
        this.mName = "untitled";
        this.mDuration = 0;
        this.mTime = 0;
        this.mCount = 0;
    }

    @Ignore
    public Pomodoro(@NonNull String mName, int mDuration, int mTime, int mCount) {
        this.mId = IdAlloctor.getID();
        this.mName = mName;
        this.mDuration = mDuration;
        this.mTime = mTime;
        this.mCount = mCount;
    }

    public long getId() {
        return mId;
    }

    public void setId(long mId) {
        this.mId = mId;
    }

    @NonNull
    public String getName() {
        return mName;
    }

    public void setName(@NonNull String mName) {
        this.mName = mName;
    }

    public int getDuration() {
        return mDuration;
    }

    public void setDuration(int mDuration) {
        this.mDuration = mDuration;
    }

    public int getTime() {
        return mTime;
    }

    public void setTime(int mTimes) {
        this.mTime = mTimes;
    }

    public int getCount() {
        return mCount;
    }

    public void setCount(int mCount) {
        this.mCount = mCount;
    }

    @Override
    @NonNull
    public String toString() {
        return "Pomodoro{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mDuration=" + mDuration +
                ", mTimes=" + mTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pomodoro pomodoro = (Pomodoro) o;
        return mId == pomodoro.mId && mDuration == pomodoro.mDuration && mTime == pomodoro.mTime && mCount == pomodoro.mCount && mName.equals(pomodoro.mName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mName, mDuration, mTime, mCount);
    }
}
