package com.shiftux.viewmodelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.shiftux.viewmodelapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    MyViewModel viewModel;
    ActivityMainBinding bind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bind= DataBindingUtil.setContentView(
                this,
                R.layout.activity_main
        );

        viewModel= new ViewModelProvider(this).get(MyViewModel.class);

        bind.setModel(viewModel);

        //Observing the live data
        viewModel.getCount().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer counter) {
                bind.value.setText(""+counter);
            }
        });
    }
}