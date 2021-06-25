package com.example.viewmodel_databinding;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.viewmodel_databinding.databinding.ActivityDatabindingBinding;
import com.example.viewmodel_databinding.model.User;
import com.example.viewmodel_databinding.model.User_2;
import com.example.viewmodel_databinding.viewmodel.MyViewModel;

public class DatabingActivity  extends AppCompatActivity {

     User user;
    User_2 user_2 ;
    ObservableField<String> name;
    ObservableField<String> age;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_databinding);
       ActivityDatabindingBinding  activityDatabindingBinding =  DataBindingUtil.setContentView(this,R.layout.activity_databinding);
        // init1(activityDatabindingBinding);
        // init2(activityDatabindingBinding);
        //init3(activityDatabindingBinding);
        //init4(activityDatabindingBinding);

        MyViewModel myViewModel  = new ViewModelProvider(this).get(MyViewModel.class);
        myViewModel.getUserMutableLiveData().setValue(new User("张三","12"));
        myViewModel.getUserMutableLiveData().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                activityDatabindingBinding.setViewmodle(myViewModel);
            }
        });
        activityDatabindingBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.getUserMutableLiveData().setValue(new User("李四","20"));
            }
        });

    }

    private void init4(com.example.viewmodel_databinding.databinding.ActivityDatabindingBinding activityDatabindingBinding) {
        MyViewModel myViewModel  = new ViewModelProvider(this).get(MyViewModel.class);
        myViewModel.getNumber().setValue("李四");
        activityDatabindingBinding.setViewmodle(myViewModel);
    }

    private void init3(com.example.viewmodel_databinding.databinding.ActivityDatabindingBinding activityDatabindingBinding) {
        name = new ObservableField<>();
        age = new ObservableField<>();

        name.set("张三");
        age.set("11");
        activityDatabindingBinding.setName(name);
        activityDatabindingBinding.setAge(age);

        activityDatabindingBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.set("李四");
                age.set("20");
            }
        });
    }

    private void init2(com.example.viewmodel_databinding.databinding.ActivityDatabindingBinding activityDatabindingBinding) {
        user_2 = new User_2();
        user_2.name.set("张三");
        user_2.age.set("11");
        activityDatabindingBinding.setUser2(user_2);
        activityDatabindingBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_2.name.set("李四");
                user_2.age.set("20");
            }
        });
    }

    private void init1(com.example.viewmodel_databinding.databinding.ActivityDatabindingBinding activityDatabindingBinding) {
        user = new User("张三","11");
        activityDatabindingBinding.setUser(user);

        activityDatabindingBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setName("李四");
                user.setAge("20");
            }
        });
    }
}
