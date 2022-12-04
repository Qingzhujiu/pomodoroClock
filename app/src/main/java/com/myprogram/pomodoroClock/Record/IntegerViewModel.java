package com.myprogram.pomodoroClock.Record;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class IntegerViewModel extends ViewModel {
    private MutableLiveData<Integer> currentValue;

    public MutableLiveData<Integer> getCurrentValue() {
        if (currentValue == null) {
            currentValue = new MutableLiveData<>();
        }
        return currentValue;
    }
}
