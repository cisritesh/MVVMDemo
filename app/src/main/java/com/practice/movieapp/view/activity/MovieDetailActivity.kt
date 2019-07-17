package com.practice.movieapp.view.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.practice.movieapp.R
import com.practice.movieapp.model.MovieDetails
import com.practice.movieapp.model.Result
import com.practice.movieapp.viewmodel.MovieDetailsViewModel
import com.practice.movieapp.viewmodel.MovieListViewModel
import com.squareup.picasso.Picasso

class MovieDetailActivity : AppCompatActivity() {

    lateinit var poster : ImageView
    lateinit var title: TextView
    lateinit var movieRating: TextView
    lateinit var releaseDate: TextView
    lateinit var overview: TextView
    lateinit var trailerList: RecyclerView
    lateinit var reviewList: RecyclerView
    lateinit var favoriteButton : Button
    lateinit var unfavoriteButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_details)

        val movieId = intent.getStringExtra("id")
        Log.d("TMDB", movieId);

        poster = findViewById(R.id.movie_poster)
        title = findViewById(R.id.movie_title)
        movieRating = findViewById(R.id.movie_user_rating)
        releaseDate = findViewById(R.id.movie_release_date)
        overview = findViewById(R.id.movie_overview)
     /*   trailerList = findViewById(R.id.trailer_list)
        reviewList = findViewById(R.id.review_list)*/
        favoriteButton = findViewById(R.id.button_mark_as_favorite)
        unfavoriteButton = findViewById(R.id.button_remove_from_favorites)

        val movieDetailsViewModel: MovieDetailsViewModel
        movieDetailsViewModel = ViewModelProviders.of(this).get(MovieDetailsViewModel::class.java!!)
        movieDetailsViewModel.init(movieId)
        movieDetailsViewModel.getMoviesDetails()?.observe(this, Observer {
            var movieDetails: MovieDetails = it!!
            Log.d("TMDB", movieDetails.toString())

            Picasso.get().load(movieDetails.poster_path).into(poster)
            title.text = movieDetails.title
            movieRating.text = movieDetails.vote_average.toString()
            releaseDate.text = movieDetails.release_date
            overview.text = movieDetails.overview



        })

    }

}