package com.practice.movieapp.util

import com.practice.movieapp.network.TmdbApiServices
import com.practice.movieapp.repository.TmdbRepository
import retrofit2.create

object RepositoryFactory {

    fun createTmdbRepository() : TmdbRepository {

        val tmdbApi = RestUtil.instance.retrofit.create(TmdbApiServices::class.java)
        return  TmdbRepository(tmdbApi)
    }
}