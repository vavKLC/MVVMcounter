package com.example.mvvmcounter;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CounterViewModel extends ViewModel {
    int _amount = 0;
    public MutableLiveData<String> amount = new MutableLiveData<>();

    public void increment(){
        amount.setValue(String.valueOf(++_amount));
    }

    public void decrement(){
        amount.postValue(String.valueOf(--_amount));
    }
}
