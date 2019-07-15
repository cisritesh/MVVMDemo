package com.practice.movieapp.repository

import androidx.lifecycle.LiveData
import com.practice.movieapp.model.GenreList
import com.practice.movieapp.network.TmdbApiServices

class TmdbRepository(val tmdbApiServices: TmdbApiServices) {

  /*  var HTTPS_API_GITHUB_URL = "https://api.themoviedb.org/3/"*/


    fun getGenres(): LiveData<GenreList> {

    }

}