package com.example.movie.Retrofit;

import com.example.movie.Model.MovieDatabase;

import retrofit2.Call;

public class MovieRepository {

    private MoviesApiService moviesApiService = MoviesApi.create();

    public Call<MovieDatabase> getAllMovies(){
        return moviesApiService.getMovie();
    }

    public Call<MovieDatabase> getMovieYear(String year){
        return moviesApiService.getMovieYear(year);
    }

}
