package com.example.mvvmcounter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.mvvmcounter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    CounterViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(MainActivity.this).get(CounterViewModel.class);
        initChanged();
        initListener();
    }

    private void initChanged() {
        viewModel.amount.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvText.setText(s);
            }
        });
    }

    private void initListener() {
        binding.decrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.decrement();
            }
        });
        binding.incrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.increment();
            }
        });
    }
}