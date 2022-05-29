package com.pro.moviescollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.pro.moviescollection.databinding.ActivityMainScreenBinding;

import java.util.ArrayList;
import java.util.List;

public class MainScreen extends AppCompatActivity {

    private ActivityMainScreenBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.floatingActionButton.setOnClickListener((View v)->{

            // get the user input
            String name = binding.name.getText().toString();
            // declare the intent variable .
            Intent intent = new Intent(MainScreen.this, MoviesActivity.class);
            intent.putExtra("name", name);
            startActivity(intent);
        });

        binding.floatingActionButton2.setOnClickListener((View v)->{
            FragmentManager bf = getSupportFragmentManager();
            BackgroundFragment backgroundFragment = new BackgroundFragment();
            backgroundFragment.show(bf, "Sample Fragment");
        });
    }
}