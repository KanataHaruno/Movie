package com.example.movie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class ViewMovieActivity extends AppCompatActivity {

    private ImageView backdropImage;
    private ImageView posterImage;
    private TextView title;
    private TextView releaseDate;
    private TextView rating;
    private TextView overview;
    private Button buttonBack;
    private String baseImageURL = "https://image.tmdb.org/t/p/w500";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_movie);

        initViews();
    }

    private void initViews(){
        backdropImage = findViewById(R.id.backdropView);
        posterImage = findViewById(R.id.posterView);
        title = findViewById(R.id.title);
        releaseDate = findViewById(R.id.releaseLabelTextView);
        rating = findViewById(R.id.ratingTextView);
        overview = findViewById(R.id.overviewTextView);
        buttonBack = findViewById(R.id.backButton);


        Glide.with(this)
                .load(baseImageURL + getIntent().getStringExtra("backdropImage"))
                .centerCrop()
                .transition(new DrawableTransitionOptions().crossFade())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(backdropImage);
        Glide.with(this)
                .load(baseImageURL + getIntent().getStringExtra("posterImage"))
                .centerCrop()
                .transition(new DrawableTransitionOptions().crossFade())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(posterImage);
        title.setText(getIntent().getStringExtra("title"));
        releaseDate.setText(getIntent().getStringExtra("releaseDate"));
        rating.setText(Double.toString(getIntent().getDoubleExtra("rating", 0.0)));
        overview.setText(getIntent().getStringExtra("overview"));
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
