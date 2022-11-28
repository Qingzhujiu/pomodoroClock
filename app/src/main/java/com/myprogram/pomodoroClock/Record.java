package com.myprogram.pomodoroClock;

import java.sql.Date;
public class Record {
    private java.sql.Date mSqlDate;
    private String mType;
    private String mName;
    private long mSeconds;
    private int mDone;

    public Record(java.sql.Date _Date, String _Type, String _Name,
                  long _Seconds, int _Done){
        mSqlDate = _Date;
        mType = _Type;
        mName = _Name;
        mSeconds = _Seconds;
        mDone = _Done;
    }

    public void setSqlDate(Date mSqlDate) {
        this.mSqlDate = mSqlDate;
    }

    public Date getSqlDate() {
        return mSqlDate;
    }

    public void setType(String mType) {
        this.mType = mType;
    }

    public String getType() {
        return mType;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getName() {
        return mName;
    }

    public void setSeconds(long mSeconds) {
        this.mSeconds = mSeconds;
    }

    public long getSeconds() {
        return mSeconds;
    }

    public void setDone(int mDone) {
        this.mDone = mDone;
    }

    public int getDone() {
        return mDone;
    }
}
