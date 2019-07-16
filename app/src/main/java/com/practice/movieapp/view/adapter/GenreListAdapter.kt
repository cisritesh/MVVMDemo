package com.practice.movieapp.view.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.practice.movieapp.R
import com.practice.movieapp.model.Genre


import java.util.ArrayList

class GenreListAdapter(internal var context: Context, internal var articles: ArrayList<Genre>) :
    RecyclerView.Adapter<GenreListAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreListAdapter.NewsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.genre_item, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: GenreListAdapter.NewsViewHolder, position: Int) {
        holder.tvName.setText(articles[position].id.toString())
        holder.tvDesCription.setText(articles[position].name.toString())

    }

    override fun getItemCount(): Int {
        return articles.size
    }

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var tvName: TextView
        internal var tvDesCription: TextView


        init {

            tvName = itemView.findViewById(R.id.genreID)
            tvDesCription = itemView.findViewById(R.id.genreName)


        }
    }
}