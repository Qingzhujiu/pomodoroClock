package com.myprogram.pomodoroClock.pojo;

public class Pomodora {
    String clockName;  //番茄钟名称
    long clockID;
    int time;   //番茄钟时长
    int count;      //番茄钟使用次数
    int duration;   //番茄钟总使用时长

    public Pomodora() {
    }

    public Pomodora(String clockName, long clockID, int time, int count, int duration) {
        this.clockName = clockName;
        this.clockID = clockID;
        this.time = time;
        this.count = count;
        this.duration = duration;
    }

    public String getClockName() {
        return clockName;
    }

    public void setClockName(String clockName) {
        this.clockName = clockName;
    }

    public long getClockID() {
        return clockID;
    }

    public void setClockID(long clockID) {
        this.clockID = clockID;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
