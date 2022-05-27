package com.pro.moviescollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.pro.moviescollection.databinding.ActivityMoviesBinding;

public class MoviesActivity extends AppCompatActivity {

    public static final String TAG = MoviesActivity.class.getSimpleName();
    private ActivityMoviesBinding binding;

    private String[] movies = new String[] {"The Oval", "24",
            "24 Ligacy", "The brigherton", "Maria", "The games of the throne",
            "The spartacus", "Conflict of the Ages", "Step to Christ", "The great controversy",
            "Adventist Home", "Call to stand apart", "Blood sisters",
            "The Jurry", "Subway"};

    private String[] Dates = new String[] {"May 23rd 2012", "January 23rd 2010",
            "March 23rd 2022", "February 23rd 1990", "May 23rd 2000", "May 3rd 2012", "May 2nd 2010",
            "May 23rd 1899", "May 23rd 2012", "March 23rd 2002", "August 2nd 2000", "May 23rd 2012", "June 4th 2002",
            "May 23rd 2012", "January 23rd 1994", "November 23rd 2000" };

    private String[] actors = new String[] {"Johnes Gray", "Coppy Wans",
            "Cellia Prinstons", "Laureen Johns", "Lupita Nyongo", "Jonh Calvinces", "Ellen Glens",
            "Mark Otis", "Jacky Orendo", "Kamelas Sans", "Clean August", "clotheings mune", "Rose Jackton",
            "Petronella Johnes", "Jacky Johnes", "Romenale kolly" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMoviesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MoviesActivityArrayAdapter arrayAdapter = new MoviesActivityArrayAdapter(this, android.R.layout.simple_list_item_1, movies, Dates, actors);
        binding.listView.setAdapter(arrayAdapter);

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = ((TextView)view).getText().toString();
                Toast.makeText(MoviesActivity.this, name, Toast.LENGTH_SHORT).show();
            }
        });

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        binding.textView3.setText(name + "Movies list");
    }
}