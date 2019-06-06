package com.example.movie.Retrofit;
import com.example.movie.BuildConfig;
import com.example.movie.Model.MovieDatabase;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesApiService {

    // Use Api key after base URL from MoviesApi, then add filter after the key
    String apiKey = BuildConfig.apiKey;

    @GET("movie/?api_key=" + apiKey + "&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=true&with_original_language=en")
    Call<MovieDatabase> getMovie();

    @GET("movie/?api_key=" + apiKey + "&language=en-US&sort_by=popularity.desc&with_original_language=en")
    Call<MovieDatabase> getMovieYear(@Query("year") String year);

}
