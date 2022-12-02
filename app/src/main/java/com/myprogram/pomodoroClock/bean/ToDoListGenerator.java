package com.myprogram.pomodoroClock.bean;

import com.myprogram.pomodoroClock.pojo.ToDo;

import java.util.ArrayList;
import java.util.List;

public class ToDoListGenerator {

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


    static public List<ToDo> getTodoInfo(){
        List<ToDo> list = new ArrayList<>();
        for (int i=0;i<isFinishedArray.size();i++){
            ToDo todo = new ToDo(isFinishedArray.get(i), contentArray.get(i));
            list.add(todo);
        }
        return list;
    }


}
