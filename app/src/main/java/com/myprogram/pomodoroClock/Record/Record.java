package com.myprogram.pomodoroClock.Record;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;

// 实体
@Entity(tableName = "record_table")
public class Record {
    @PrimaryKey
    @ColumnInfo(name = "record_id")
    private long mId;

    @NonNull
    @ColumnInfo(name = "date")
    private Date mSqlDate;

    @NonNull
    @ColumnInfo(name = "type")
    private String mType;

    @NonNull
    @ColumnInfo(name = "name")
    private String mName;

    @ColumnInfo(name = "duration")
    private int mDuration;

    @ColumnInfo(name = "times")
    private int mTimes;

    public Record() {
        IDAlloctor idAlloctor = IDAlloctor.getINSTANCE();
        this.mId = idAlloctor.getID();
        this.mSqlDate = null;
        this.mType = "default";
        this.mName = "untitled";
        this.mDuration = 0;
        this.mTimes = 0;
    }

    public Record(@NonNull Date _SqlDate, @NonNull String _Type, @NonNull String _Name,
                  int _Duration, int _Times) {
        IDAlloctor idAlloctor = IDAlloctor.getINSTANCE();
        this.mId = idAlloctor.getID();
        this.mSqlDate = _SqlDate;
        this.mType = _Type;
        this.mName = _Name;
        this.mDuration = _Duration;
        this.mTimes = _Times;
    }

    public Record(long _SqlDate, @NonNull String _Type, @NonNull String _Name,
                  int _Duration, int _Times) {
        IDAlloctor idAlloctor = IDAlloctor.getINSTANCE();
        this.mId = idAlloctor.getID();
        this.mSqlDate = new Date(_SqlDate);
        this.mType = _Type;
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
    public Date getSqlDate() {
        return mSqlDate;
    }

    public void setSqlDate(@NonNull Date _SqlDate) {
        this.mSqlDate = _SqlDate;
    }

    @NonNull
    public String getType() {
        return mType;
    }

    public void setType(@NonNull String _Type) {
        this.mType = _Type;
    }

    @NonNull
    public String getName() {
        return mName;
    }

    public void setName(@NonNull String _Name) {
        this.mName = _Name;
    }

    public int getDuration() {
        return mDuration;
    }

    public void setDuration(int _Duration) {
        this.mDuration = _Duration;
    }

    public int getTimes() {
        return mTimes;
    }

    public void setTimes(int _Times) {
        this.mTimes = _Times;
    }

    @Override
    public String toString() {
        return "Record{" +
                "mId=" + mId +
                ", mSqlDate=" + mSqlDate +
                ", mType='" + mType + '\'' +
                ", mName='" + mName + '\'' +
                ", mDuration=" + mDuration +
                ", mTimes=" + mTimes +
                '}';
    }
}
