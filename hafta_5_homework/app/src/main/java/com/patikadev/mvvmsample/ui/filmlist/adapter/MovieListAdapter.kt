package com.patikadev.mvvmsample.ui.filmlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.patikadev.mvvmsample.R
import com.patikadev.mvvmsample.database.MovieDatabaseDao
import com.patikadev.mvvmsample.databinding.RowFilmBinding
import com.patikadev.mvvmsample.database.MovieTable
import com.patikadev.mvvmsample.ui.filmlist.model.Clicklistener
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MovieListAdapter(private val movieList: List<MovieTable>, private val onlick : Clicklistener, private val database : MovieDatabaseDao) : RecyclerView.Adapter<FilmViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        return FilmViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_film,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val movie = this.movieList[position]
       holder.populate(movie, onlick)

       holder.binding.movietext.setOnClickListener {
           onlick.onClickk(movie.id,movie.title)

       }


    }

    override fun getItemCount() = this.movieList.size
}


class FilmViewHolder(val binding: RowFilmBinding) : RecyclerView.ViewHolder(binding.root) {

    fun populate(movie: MovieTable, onclick : Clicklistener) {
        binding.movie = movie
        binding.onclick=onclick
        binding.executePendingBindings()
    }

}