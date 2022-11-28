package com.myprogram.pomodoroClock.bean;

import java.util.ArrayList;
import java.util.List;

public class Item {
    //任务是否完成
    private boolean isFinished;
    //任务的内容
    private String content;

    public Item(boolean isFinished, String content) {
        this.isFinished = isFinished;
        this.content = content;
    }

    public boolean getIsFinished() {
        return isFinished;
    }

    public String getContent() {
        return content;
    }

    //测试数据

    private static List<Boolean> isFinishedArray;
    private static List<String> contentArray;
    static {
        isFinishedArray = new ArrayList<>();
        contentArray = new ArrayList<>();
        isFinishedArray.add(false);
        isFinishedArray.add(false);
        isFinishedArray.add(false);
        contentArray.add("吃饭");
        contentArray.add("睡觉");
        contentArray.add("打豆豆");
    }


    static public List<Item> getTodoInfo(){
        List<Item> list = new ArrayList<>();
        for (int i=0;i<isFinishedArray.size();i++){
            Item item = new Item(isFinishedArray.get(i), contentArray.get(i));
            list.add(item);
        }
        return list;
    }


}
