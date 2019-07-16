package com.practice.movieapp.view.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.practice.movieapp.R
import com.practice.movieapp.model.Genre
import com.practice.movieapp.model.Result
import com.practice.movieapp.view.adapter.GenreListAdapter
import com.practice.movieapp.view.adapter.MovieListAdapter
import com.practice.movieapp.viewmodel.GenreListViewModel
import com.practice.movieapp.viewmodel.MovieListViewModel

class MovieListActivity : AppCompatActivity() {

    var listOfMovie: ArrayList<Result> = ArrayList()
    var movieListAdapter: MovieListAdapter? = null
    var rvMovie: RecyclerView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_list)
        val id = intent.getStringExtra("id")
        Log.d("TMDB", id);

        rvMovie = findViewById(R.id.rvMovies)
        val movieListViewModel: MovieListViewModel
        movieListViewModel = ViewModelProviders.of(this).get(MovieListViewModel::class.java!!)
        movieListViewModel.init(id)
        movieListViewModel.getMoviesFromGenre()?.observe(this, Observer {
            var movies: List<Result> = it!!.results
            listOfMovie.addAll(movies)
            movieListAdapter?.notifyDataSetChanged()

        })
        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        if (movieListAdapter == null) {
            movieListAdapter = MovieListAdapter(this@MovieListActivity, listOfMovie)
            rvMovie?.setLayoutManager(LinearLayoutManager(this))
            rvMovie?.setAdapter(movieListAdapter)
            rvMovie?.setItemAnimator(DefaultItemAnimator())
            rvMovie?.setNestedScrollingEnabled(true)
        } else {
            movieListAdapter?.notifyDataSetChanged()
        }
    }
}