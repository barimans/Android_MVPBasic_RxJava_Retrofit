package com.example.brizz.mvpfilm.network;

import com.example.brizz.mvpfilm.model.MovieResponse;

import io.reactivex.Observable;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkInterface {

    @GET("movie/now_playing")
    Observable<MovieResponse> getMovies(@Query("api_key") String api_key);
}
