package com.practice.movieapp.network


import androidx.lifecycle.LiveData
import com.practice.movieapp.model.GenreList
import retrofit2.Call
import retrofit2.http.GET





public interface TmdbApiServices {



    @GET("genre/movie/list")
    fun getGenres(): LiveData<GenreList>


}