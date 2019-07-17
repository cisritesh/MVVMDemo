package com.practice.movieapp.network


import androidx.lifecycle.LiveData
import com.practice.movieapp.model.GenreList
import com.practice.movieapp.model.MovieDetails
import com.practice.movieapp.model.MovieList
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


public interface TmdbApiServices {



    @GET("genre/movie/list")
    fun getGenres(@Query ("api_key") api_key: String): Call<GenreList>


    @GET("discover/movie")
    fun getMoviesFromGenre(@Query ("api_key") api_key: String, @Query ("with_genres") genreId: String): Call<MovieList>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") movieId: String, @Query("api_key") apiKey: String): Call<MovieDetails>

}