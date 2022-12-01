package com.myprogram.pomodoroClock.Record;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Date;
import java.util.Objects;

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
        RecordIDAlloctor recordIdAlloctor = RecordIDAlloctor.getINSTANCE();
        this.mId = recordIdAlloctor.getID();
        this.mSqlDate = new Date(System.currentTimeMillis());
        this.mType = "default";
        this.mName = "untitled";
        this.mDuration = 0;
        this.mTimes = 0;
    }

    public Record(@NonNull Date _SqlDate, @NonNull String _Type, @NonNull String _Name,
                  int _Duration, int _Times) {
        RecordIDAlloctor recordIdAlloctor = RecordIDAlloctor.getINSTANCE();
        this.mId = recordIdAlloctor.getID();
        this.mSqlDate = _SqlDate;
        this.mType = _Type;
        this.mName = _Name;
        this.mDuration = _Duration;
        this.mTimes = _Times;
    }

    public Record(long _SqlDate, @NonNull String _Type, @NonNull String _Name,
                  int _Duration, int _Times) {
        RecordIDAlloctor recordIdAlloctor = RecordIDAlloctor.getINSTANCE();
        this.mId = recordIdAlloctor.getID();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return mId == record.mId && mDuration == record.mDuration && mTimes == record.mTimes && mSqlDate.equals(record.mSqlDate) && mType.equals(record.mType) && mName.equals(record.mName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mSqlDate, mType, mName, mDuration, mTimes);
    }
}
