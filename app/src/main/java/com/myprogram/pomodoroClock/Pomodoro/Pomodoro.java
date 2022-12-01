package com.myprogram.pomodoroClock.Pomodoro;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "pomodoro_table")

public class Pomodoro {
    @PrimaryKey
    @NonNull
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

    @ColumnInfo(name = "bgSound")
    private int mbgSound;

    @ColumnInfo(name = "bgImg")
    private int mbgImg;

    public Pomodoro() {
        this.mId = PomodoroIDAlloctor.getINSTANCE().getID();
        this.mName = "untitled";
        this.mDuration = 0;
        this.mTime = 0;
        this.mCount = 0;
        this.mbgSound = 0;
        this.mbgImg = 0;
    }

    public Pomodoro(@NonNull String mName, int mDuration, int mTime, int mCount, int mbgSound, int mbgImg) {
        this.mId = PomodoroIDAlloctor.getINSTANCE().getID();
        this.mName = mName;
        this.mDuration = mDuration;
        this.mTime = mTime;
        this.mCount = mCount;
        this.mbgSound = mbgSound;
        this.mbgImg = mbgImg;
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

    public int getMbgSound() {
        return mbgSound;
    }

    public void setMbgSound(int mbgSound) {
        this.mbgSound = mbgSound;
    }

    public int getMbgImg() {
        return mbgImg;
    }

    public void setMbgImg(int mbgImg) {
        this.mbgImg = mbgImg;
    }

    @Override
    public String toString() {
        return "Pomodoro{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mDuration=" + mDuration +
                ", mTimes=" + mTime +
                ", mbgSound=" + mbgSound +
                ", mbgImg=" + mbgImg +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pomodoro pomodoro = (Pomodoro) o;
        return mId == pomodoro.mId && mDuration == pomodoro.mDuration && mTime == pomodoro.mTime && mbgSound == pomodoro.mbgSound && mbgImg == pomodoro.mbgImg && mName.equals(pomodoro.mName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mName, mDuration, mTime, mbgSound, mbgImg);
    }
}
