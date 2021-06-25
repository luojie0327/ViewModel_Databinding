package com.example.viewmodel_databinding.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.viewmodel_databinding.BR;

public class User extends BaseObservable {

    private String name ;
    private String age ;

    public User(){};

    public User(String name , String age ){
        this.name = name;
        this.age = age;

    }

    @Bindable
    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setAge(String age) {
        this.age = age;
    }
}
