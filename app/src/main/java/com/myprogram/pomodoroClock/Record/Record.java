package com.myprogram.pomodoroClock.Record;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

// 实体
@Entity(tableName = "record_table")
public class Record implements Serializable {
    static class IdAlloctor {
        public static long getID() {
            return System.currentTimeMillis();
        }
    }

    @PrimaryKey
    @ColumnInfo(name = "record_id")
    private long mId;

    @NonNull
    @ColumnInfo(name = "date")
    private Date mDate;

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
        this.mId = -1;
        this.mDate = new Date(System.currentTimeMillis());
        this.mType = "default";
        this.mName = "untitled";
        this.mDuration = 0;
        this.mTimes = 0;
    }

    public Record(@NonNull Date _SqlDate, @NonNull String _Type, @NonNull String _Name,
                  int _Duration, int _Times) {
        this.mId = IdAlloctor.getID();
        this.mDate = _SqlDate;// 番茄钟开始时间
        this.mType = _Type;// 番茄钟类型，随便填一个，现在废弃了
        this.mName = _Name;// 番茄钟名称
        this.mDuration = _Duration;// 持续多久
        this.mTimes = _Times;// 执行几次
    }

    public Record(long _SqlDate, @NonNull String _Type, @NonNull String _Name,
                  int _Duration, int _Times) {
        this.mId = IdAlloctor.getID();
        this.mDate = new Date(_SqlDate);
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
    public Date getDate() {
        return mDate;
    }

    public void setDate(@NonNull Date _Date) {
        this.mDate = _Date;
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

    public String getDurationStr() {
        String str = "";
        int h = this.mDuration / 60;
        if (h > 0)
            str = str + h + "时";
        int m = this.mDuration % 60;
        str = str + m + "分";
        return str;
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
                ", mSqlDate=" + mDate +
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
        return mId == record.mId && mDuration == record.mDuration && mTimes == record.mTimes && mDate.equals(record.mDate) && mType.equals(record.mType) && mName.equals(record.mName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mDate, mType, mName, mDuration, mTimes);
    }
}
