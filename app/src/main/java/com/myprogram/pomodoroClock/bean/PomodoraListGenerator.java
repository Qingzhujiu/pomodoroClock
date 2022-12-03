package com.myprogram.pomodoroClock.bean;

import android.support.v4.app.INotificationSideChannel;

import com.myprogram.pomodoroClock.pojo.Pomodora;
import com.myprogram.pomodoroClock.pojo.ToDo;

import java.util.ArrayList;
import java.util.List;

public class PomodoraListGenerator {





    //测试数据
    private static List<String> clockNameArray;
    private static List<Integer> clockTimeArray;
    static {
        clockNameArray = new ArrayList<>();
        clockTimeArray = new ArrayList<>();

        clockTimeArray.add(15);
        clockTimeArray.add(25);
        clockTimeArray.add(30);


        clockNameArray.add("吃饭");
        clockNameArray.add("睡觉");
        clockNameArray.add("打豆豆");
    }


    static public List<Pomodora> getPomodaraInfo(){

        List<Pomodora> list = new ArrayList<>();
        for (int i = 0; i< clockNameArray.size(); i++){
            Pomodora pomodora = new Pomodora();
            pomodora.setClockName(clockNameArray.get(i));
            pomodora.setTime(clockTimeArray.get(i));

            list.add(pomodora);
        }
        return list;
    }


}
