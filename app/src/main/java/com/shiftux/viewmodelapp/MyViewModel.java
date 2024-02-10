package com.shiftux.viewmodelapp;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

//    int count=0;
    private MutableLiveData<Integer>  count= new MutableLiveData<>();
    public void increaseCounter(View view){
        int curVal= count.getValue() != null ? count.getValue():0;

        count.setValue(curVal+1);
    }

    public LiveData<Integer> getCount() {
        return count;
    }

}
