package com.myprogram.pomodoroClock.Pomodoro;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
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

    @ColumnInfo(name = "times")
    private int mTimes;

    @ColumnInfo(name = "bgSound")
    private int mbgSound;

    @ColumnInfo(name = "bgImg")
    private int mbgImg;

    public Pomodoro() {
        this.mId = PomodoroIDAlloctor.getINSTANCE().getID();
        this.mName = "untitled";
        this.mDuration = 0;
        this.mTimes = 0;
    }

    public Pomodoro(@NonNull String _Name, int _Duration, int _Times) {
        this.mId = PomodoroIDAlloctor.getINSTANCE().getID();
        this.mName = _Name;
        this.mDuration = _Duration;
        this.mTimes = _Times;
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

    public int getTimes() {
        return mTimes;
    }

    public void setTimes(int mTimes) {
        this.mTimes = mTimes;
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
                ", mTimes=" + mTimes +
                ", mbgSound=" + mbgSound +
                ", mbgImg=" + mbgImg +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pomodoro pomodoro = (Pomodoro) o;
        return mId == pomodoro.mId && mDuration == pomodoro.mDuration && mTimes == pomodoro.mTimes && mbgSound == pomodoro.mbgSound && mbgImg == pomodoro.mbgImg && mName.equals(pomodoro.mName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mName, mDuration, mTimes, mbgSound, mbgImg);
    }
}
