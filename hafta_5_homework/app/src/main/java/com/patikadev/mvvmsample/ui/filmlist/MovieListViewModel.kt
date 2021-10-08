package com.patikadev.mvvmsample.ui.filmlist

import androidx.lifecycle.*
import com.patikadev.mvvmsample.repository.FilmRepository
import com.patikadev.mvvmsample.ui.filmlist.model.MovieListViewStateModel
import com.patikadev.mvvmsample.util.API_KEY

class MovieListViewModel : ViewModel() {


    val moviesResponse = MediatorLiveData<MovieListViewStateModel>()
    val filmRepository = FilmRepository()

    init {
        filmRepository.getAllMovies(API_KEY)

        moviesResponse.addSource(filmRepository.onMoviesFetched) {
            moviesResponse.value = MovieListViewStateModel(it)
        }
    }





}