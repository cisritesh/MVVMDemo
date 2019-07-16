package com.practice.movieapp.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.practice.movieapp.model.GenreList
import com.practice.movieapp.repository.TmdbRepository


class GenreListViewModel : ViewModel() {

    private var mutableLiveData: MutableLiveData<GenreList>? = null
    private var tmdbRepository: TmdbRepository? = null

    fun init() {
        if (mutableLiveData != null) {
            return
        }
        tmdbRepository = TmdbRepository()
        mutableLiveData = tmdbRepository!!.getGenres( "b381f84922261c826ae55b2d3b4f392d")

    }

    fun getGenresRepository(): LiveData<GenreList>? {
        return mutableLiveData
    }

}