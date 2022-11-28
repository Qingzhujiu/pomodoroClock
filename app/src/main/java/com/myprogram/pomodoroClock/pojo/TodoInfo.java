package com.myprogram.pomodoroClock.pojo;

public class TodoInfo {
    //任务是否完成
    private boolean isFinished;
    //任务的内容
    private String content;

    public TodoInfo(boolean isFinished, String content) {
        this.isFinished = isFinished;
        this.content = content;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
