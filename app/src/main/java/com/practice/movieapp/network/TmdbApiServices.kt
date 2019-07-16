package com.practice.movieapp.network


import androidx.lifecycle.LiveData
import com.practice.movieapp.model.GenreList
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


public interface TmdbApiServices {



    @GET("genre/movie/list")
    fun getGenres(@Query ("api_key") api_key: String): Call<GenreList>




}