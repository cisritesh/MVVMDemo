package com.practice.movieapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.practice.movieapp.model.GenreList
import com.practice.movieapp.model.MovieList
import com.practice.movieapp.repository.TmdbRepository

class MovieListViewModel : ViewModel() {

    private var mutableLiveData: MutableLiveData<MovieList>? = null
    private var tmdbRepository: TmdbRepository? = null

    fun init(genreId: String) {
        if (mutableLiveData != null) {
            return
        }
        tmdbRepository = TmdbRepository()
        mutableLiveData = tmdbRepository!!.getMoviesFromGenre( "b381f84922261c826ae55b2d3b4f392d", genreId)

    }

    fun getMoviesFromGenre(): LiveData<MovieList>? {
        return mutableLiveData
    }
}