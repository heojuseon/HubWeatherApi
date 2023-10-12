package com.example.hubweatherapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.hubweatherapi.databinding.ActivityMainBinding;
import com.example.hubweatherapi.model.WeatherModel;
import com.example.hubweatherapi.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private WeatherModel weatherModel;

    MainViewModel viewModel;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);
        binding.setWeather(viewModel);

        viewModel.init();   //viewModel 의 API 호출 메소드를 호출
        viewModel.getWeather();
    }
}