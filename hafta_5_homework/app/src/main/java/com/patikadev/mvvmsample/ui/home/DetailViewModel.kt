package com.patikadev.mvvmsample.ui.home

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.patikadev.mvvmsample.database.MovieDetail
import com.patikadev.mvvmsample.repository.FilmRepository
import com.patikadev.mvvmsample.util.API_KEY
import kotlin.properties.Delegates

class DetailViewModel(id: Long) : ViewModel() {


    val detailresponse = MediatorLiveData<MovieDetail>()
    val filmRepository = FilmRepository()


    init {

        filmRepository.getMovieDetail(API_KEY, id)

        detailresponse.addSource(filmRepository.movieDetail) {
            detailresponse.value=it
        }
    }


}