package com.practice.movieapp.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.practice.movieapp.R
import com.practice.movieapp.viewmodel.GenreListViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView;
import com.practice.movieapp.model.Genre
import com.practice.movieapp.view.adapter.GenreListAdapter
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager





class GenreListActivity : AppCompatActivity() {

    var listOfGenre: ArrayList<Genre> = ArrayList()
    var genreListAdapter: GenreListAdapter? = null
    var rvGenre: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.genre_list)

        rvGenre = findViewById(R.id.rvGenres)


        val genreListViewModel: GenreListViewModel
        genreListViewModel = ViewModelProviders.of(this).get(GenreListViewModel::class.java!!)
        genreListViewModel.init()
        genreListViewModel.getGenresRepository()?.observe(this, Observer {
            var genre: List<Genre>? = it?.genres
            if (genre != null) {
                listOfGenre.addAll(genre)
            }
            genreListAdapter?.notifyDataSetChanged()

        })
        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        if (genreListAdapter == null) {
            genreListAdapter = GenreListAdapter(this@GenreListActivity, listOfGenre)
            rvGenre?.setLayoutManager(LinearLayoutManager(this))
            rvGenre?.setAdapter(genreListAdapter)
            rvGenre?.setItemAnimator(DefaultItemAnimator())
            rvGenre?.setNestedScrollingEnabled(true)
        } else {
            genreListAdapter?.notifyDataSetChanged()
        }
    }
}
