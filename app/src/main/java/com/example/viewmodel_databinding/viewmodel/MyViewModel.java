package com.example.viewmodel_databinding.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.viewmodel_databinding.model.User;

public class MyViewModel extends ViewModel {


    private MutableLiveData<String> number ;
    private MutableLiveData<User> userMutableLiveData ;

    public MutableLiveData<String> getNumber() {
        if(number == null){
            number = new MutableLiveData<>();
            number.setValue("");
        }
        return number;
    }

    public MutableLiveData<User> getUserMutableLiveData() {
        if(userMutableLiveData == null){
            userMutableLiveData = new MutableLiveData<>();
        }
        return  userMutableLiveData;
    }
}
