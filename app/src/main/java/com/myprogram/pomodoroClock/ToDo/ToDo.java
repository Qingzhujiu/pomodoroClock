package com.myprogram.pomodoroClock.ToDo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "todo_table")

public class ToDo {
    static class IdAlloctor {
        static public long getID() {
            return System.currentTimeMillis();
        }
    }

    @PrimaryKey
    @ColumnInfo(name = "todo_id")
    private long mId;

    @NonNull
    @ColumnInfo(name = "name")
    private String mName;

    @ColumnInfo(name = "isFinished")
    private boolean isFinished;

    public long getId() {
        return mId;
    }

    public void setId(long mId) {
        this.mId = mId;
    }

    public void setName(@NonNull String mName) {
        this.mName = mName;
    }

    @NonNull
    public String getName() {
        return mName;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public ToDo() {
        this.mId = -1;
        this.mName = "untitled";
        this.isFinished = false;
    }

    public ToDo(@NonNull String _Name, boolean _IsDone) {
        this.mId = IdAlloctor.getID();
        this.mName = _Name;
        this.isFinished = _IsDone;
    }

    public ToDo(@NonNull String _Name) {
        this.mId = IdAlloctor.getID();
        this.mName = _Name;
        this.isFinished = false;
    }

    @NonNull
    @Override
    public String toString() {
        return "ToDo{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", isDone=" + isFinished +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDo toDo = (ToDo) o;
        return mId == toDo.mId && isFinished == toDo.isFinished && mName.equals(toDo.mName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mName, isFinished);
    }
}
