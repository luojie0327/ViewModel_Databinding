package com.example.viewmodel_databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.viewmodel_databinding.model.User;
import com.example.viewmodel_databinding.viewmodel.MyViewModel;

public class MainActivity extends AppCompatActivity {

    private TextView textView ;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        MyViewModel myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        myViewModel.getUserMutableLiveData().observe(this,new Observer<User>(){
            @Override
            public void onChanged(User user) {
             //   textView.setText(user.getName() + "  " +user.getAge());
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setAge("11");
                user.setName("张三");
                textView.setText(user.getName());
                //myViewModel.getUserMutableLiveData().setValue(user);

            }
        });


    }
}