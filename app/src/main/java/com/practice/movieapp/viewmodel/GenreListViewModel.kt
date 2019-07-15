package com.practice.movieapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.practice.movieapp.model.GenreList
import com.practice.movieapp.repository.TmdbRepository

class GenreListViewModel(val tmdbRepository: TmdbRepository) : ViewModel() {

    fun getGenres(): LiveData<GenreList> {

        return tmdbRepository.getGenres();
    }



}