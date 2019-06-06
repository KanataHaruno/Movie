package com.example.movie.Retrofit;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesApi {

    private static final String BASE_URL = "https://api.themoviedb.org/3/discover/";

    public static MoviesApiService create(){

        // Create an OkHttpClient to be able to make a log of the network traffic

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();


        // Create an instance of Retrofit
        Retrofit moviesApi = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Return the Retrofit MoviesApiService
        return moviesApi.create(MoviesApiService.class);
    }

}
