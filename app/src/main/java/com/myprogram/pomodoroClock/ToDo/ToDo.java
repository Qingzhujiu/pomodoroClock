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
    @ColumnInfo(name = "content")
    private String mContent;

    @ColumnInfo(name = "isFinished")
    private boolean isFinished;

    public long getId() {
        return mId;
    }

    public void setId(long mId) {
        this.mId = mId;
    }

    @NonNull
    public String getContent() {
        return mContent;
    }

    public void setContent(@NonNull String mContent) {
        this.mContent = mContent;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public ToDo() {
        this.mId = -1;
        this.mContent = "untitled";
        this.isFinished = false;
    }

    public ToDo(@NonNull String _Content, boolean _IsDone) {
        this.mId = IdAlloctor.getID();
        this.mContent = _Content;
        this.isFinished = _IsDone;
    }

    public ToDo(@NonNull String _Content) {
        this.mId = IdAlloctor.getID();
        this.mContent = _Content;
        this.isFinished = false;
    }

    @NonNull
    @Override
    public String toString() {
        return "ToDo{" +
                "mId=" + mId +
                ", mContent='" + mContent + '\'' +
                ", isDone=" + isFinished +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDo toDo = (ToDo) o;
        return mId == toDo.mId && isFinished == toDo.isFinished && mContent.equals(toDo.mContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mContent, isFinished);
    }
}
