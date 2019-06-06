package com.example.movie;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.movie.Model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView movieRecyclerView;
    private MovieAdapter movieAdapter;
    private MainActivityViewModel viewModel;

    private List<Movie> movieList = new ArrayList<>();
    private EditText yearText;
    private Button submit;
    private ImageView posterImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initObservers();
        initRecyclerView();

    }
    private void initViews(){
        posterImage = findViewById(R.id.posterImage);
        yearText = findViewById(R.id.yearTextView);
        submit = findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getMovieYear(yearText.getText().toString());
            }
        });
    }

    private void initRecyclerView(){
        movieAdapter = new MovieAdapter(this, movieList);
        movieRecyclerView = findViewById(R.id.movieRV);
        movieRecyclerView.setAdapter(movieAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2,
                LinearLayoutManager.VERTICAL, false);
        movieRecyclerView.setLayoutManager(gridLayoutManager);
    }

    private void initObservers(){
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        viewModel.getError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Toast.makeText(MainActivity.this, "Data has changed", Toast.LENGTH_LONG);
            }
        });

        viewModel.getMovie().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(@Nullable List<Movie> movies) {
                movieList = movies;
                updateUI();
            }
        });
    }

    private void updateUI(){
        if (movieAdapter == null) {
            movieAdapter = new MovieAdapter(this, movieList);
            movieRecyclerView.setAdapter(movieAdapter);
        } else {
            movieAdapter.swapList(movieList);
        }
    }
}
