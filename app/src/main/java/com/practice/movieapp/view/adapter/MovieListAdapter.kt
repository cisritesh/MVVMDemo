package com.practice.movieapp.view.adapter


import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.practice.movieapp.R
import com.practice.movieapp.model.Result
import com.practice.movieapp.view.activity.MovieListActivity
import com.squareup.picasso.Picasso


import kotlinx.android.synthetic.main.movie_item.view.*


import java.util.ArrayList

import android.widget.ImageView
import com.practice.movieapp.view.activity.MovieDetailActivity
import com.squareup.picasso.Callback
import java.lang.Exception


class MovieListAdapter(internal var context: Context, internal var articles: ArrayList<Result>) :
    RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListAdapter.MovieListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false)
        return MovieListViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieListAdapter.MovieListViewHolder, position: Int) {

        val img = ImageView(context)
        holder.tvName.setText(articles[position].id.toString())
        holder.tvDesCription.setText(articles[position].title.toString())

        Log.d("TMDB", "http://image.tmdb.org/t/p/w185"+articles[position].poster_path)
        Picasso.get()
            .load("http://image.tmdb.org/t/p/w185"+articles[position].poster_path)
            .fit()
            .centerCrop()
            .into(img, object : Callback {
                override fun onError(e: Exception?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onSuccess() {

                    holder.backgroundImage.setBackgroundDrawable(img.drawable)
                }

            })




    }

    override fun getItemCount(): Int {
        return articles.size
    }


    inner class MovieListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var tvName: TextView
        internal var tvDesCription: TextView
        internal var backgroundImage: LinearLayout


        init {

            tvName = itemView.findViewById(R.id.movieID)
            tvDesCription = itemView.findViewById(R.id.movieTitle)
            backgroundImage = itemView.findViewById(R.id.background)



            itemView.setOnClickListener {

                var tv: TextView = it.findViewById(R.id.movieID)
                Log.d("TMDB", tvName.text.toString());

                val intent = Intent(context.applicationContext, MovieDetailActivity::class.java)
                intent.putExtra("id",tvName.text.toString())
                context.startActivity(intent)
            }


        }
    }
}