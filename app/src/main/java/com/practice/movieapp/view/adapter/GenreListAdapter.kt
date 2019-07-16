package com.practice.movieapp.view.adapter


import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.practice.movieapp.R
import com.practice.movieapp.model.Genre
import com.practice.movieapp.view.activity.GenreListActivity
import com.practice.movieapp.view.activity.MovieListActivity


import java.util.ArrayList

class GenreListAdapter(internal var context: Context, internal var articles: ArrayList<Genre>) :
    RecyclerView.Adapter<GenreListAdapter.GenreViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreListAdapter.GenreViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.genre_item, parent, false)
        return GenreViewHolder(view)
    }

    override fun onBindViewHolder(holder: GenreListAdapter.GenreViewHolder, position: Int) {
        holder.tvName.setText(articles[position].id.toString())
        holder.tvDesCription.setText(articles[position].name.toString())

    }

    override fun getItemCount(): Int {
        return articles.size
    }

    inner class GenreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var tvName: TextView
        internal var tvDesCription: TextView


        init {

            tvName = itemView.findViewById(R.id.genreID)
            tvDesCription = itemView.findViewById(R.id.genreName)

            itemView.setOnClickListener {

                var tv: TextView = it.findViewById(R.id.genreID)
                Log.d("TMDB", tv.text.toString());

                val intent = Intent(context, MovieListActivity::class.java)
                intent.putExtra("id",tv.text.toString())
                context.startActivity(intent)
            }


        }
    }
}