package com.example.movie;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.movie.Model.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private String baseImageURL = "https://image.tmdb.org/t/p/w500";
    private List<Movie> movieList;
    private Context context;

    public MovieAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.movie_item, viewGroup, false);
        return new MovieAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        Glide.with(context)
                .load(baseImageURL + movieList.get(viewHolder.getAdapterPosition()).getPosterImage())
                .centerCrop()
                .transition(new DrawableTransitionOptions().crossFade())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.posterImage);
        viewHolder.movieNumber.setText(String.valueOf(viewHolder.getAdapterPosition() + 1));

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void swapList (List<Movie> newList) {
        movieList = newList;
        if (newList != null) {
            this.notifyDataSetChanged();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView posterImage;
        private TextView movieNumber;
        private ConstraintLayout movieCell;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            posterImage = itemView.findViewById(R.id.posterImage);
            movieNumber = itemView.findViewById(R.id.movieNumber);
            movieCell = itemView.findViewById(R.id.movieCell);
        }
    }
}
