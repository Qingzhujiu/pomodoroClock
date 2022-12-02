package com.myprogram.pomodoroClock.pojo;

public class Pomodora {
    String clockName;  //番茄钟名称
    long clockID;
    int clockType;  //番茄钟种类（待定）
    int time;   //番茄钟时长
    int count;      //番茄钟使用次数
    int background;  //番茄钟背景
    int sound;      //番茄钟音乐 （待定）
    int duration;   //番茄钟总使用时长

    public Pomodora() {
    }

    public Pomodora(String clockName, long clockID, int clockType, int time, int count, int background, int sound, int duration) {
        this.clockName = clockName;
        this.clockID = clockID;
        this.clockType = clockType;
        this.time = time;
        this.count = count;
        this.background = background;
        this.sound = sound;
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

    public int getClockType() {
        return clockType;
    }

    public void setClockType(int clockType) {
        this.clockType = clockType;
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

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
