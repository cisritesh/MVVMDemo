package com.practice.movieapp.repository


import androidx.lifecycle.MutableLiveData

import com.practice.movieapp.model.GenreList
import com.practice.movieapp.model.MovieDetails
import com.practice.movieapp.model.MovieList

import com.practice.movieapp.network.RetrofitService
import com.practice.movieapp.network.TmdbApiServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TmdbRepository {

    private val tmdbApiServices: TmdbApiServices

    init {
        tmdbApiServices = RetrofitService.createService(TmdbApiServices::class.java)
    }

    fun getGenres(key: String): MutableLiveData<GenreList> {
        val genreData = MutableLiveData<GenreList>()
        tmdbApiServices.getGenres(key).enqueue(object : Callback<GenreList> {
            override fun onResponse(
                call: Call<GenreList>,
                response: Response<GenreList>
            ) {
                if (response.isSuccessful()) {
                    genreData.setValue(response.body())
                }

            }


            override fun onFailure(call: Call<GenreList>, t: Throwable) {
                genreData.setValue(null)
            }
        })
        return genreData
    }


    fun getMoviesFromGenre(key: String, genreId: String): MutableLiveData<MovieList> {
        val movieData = MutableLiveData<MovieList>()
        tmdbApiServices.getMoviesFromGenre(key, genreId).enqueue(object : Callback<MovieList> {
            override fun onResponse(
                call: Call<MovieList>,
                response: Response<MovieList>
            ) {
                if (response.isSuccessful()) {
                    movieData.setValue(response.body())
                }

            }


            override fun onFailure(call: Call<MovieList>, t: Throwable) {
                movieData.setValue(null)
            }
        })
        return movieData
    }


    fun getMoviesDetails(movieID: String, key: String): MutableLiveData<MovieDetails> {
        val movieData = MutableLiveData<MovieDetails>()
        tmdbApiServices.getMovieDetails(movieID, key).enqueue(object : Callback<MovieDetails> {
            override fun onResponse(
                call: Call<MovieDetails>,
                response: Response<MovieDetails>
            ) {
                if (response.isSuccessful()) {
                    movieData.setValue(response.body())
                }

            }


            override fun onFailure(call: Call<MovieDetails>, t: Throwable) {
                movieData.setValue(null)
            }
        })
        return movieData
    }

    companion object {

        private var tmdbRepository: TmdbRepository? = null

        val instance: TmdbRepository
            get() {
                if (tmdbRepository == null) {
                    tmdbRepository = TmdbRepository()
                }
                return tmdbRepository!!
            }
    }
}