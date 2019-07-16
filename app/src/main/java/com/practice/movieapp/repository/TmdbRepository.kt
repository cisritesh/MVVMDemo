package com.practice.movieapp.repository


import androidx.lifecycle.MutableLiveData

import com.practice.movieapp.model.GenreList

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