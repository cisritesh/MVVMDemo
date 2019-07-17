package com.practice.movieapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.practice.movieapp.model.MovieDetails
import com.practice.movieapp.repository.TmdbRepository

private var mutableLiveData: MutableLiveData<MovieDetails>? = null
private var tmdbRepository: TmdbRepository? = null

class MovieDetailsViewModel: ViewModel()  {

fun init(movieId: String) {
    if (mutableLiveData != null) {
        return
    }
    tmdbRepository = TmdbRepository()
    mutableLiveData = tmdbRepository!!.getMoviesDetails(movieId,  "b381f84922261c826ae55b2d3b4f392d")

}

fun getMoviesDetails(): LiveData<MovieDetails>? {
    return mutableLiveData
}

}