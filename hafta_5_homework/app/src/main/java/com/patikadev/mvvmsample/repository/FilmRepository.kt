package com.patikadev.mvvmsample.repository

import androidx.lifecycle.MutableLiveData
import com.patikadev.deneme1.service.ServiceConnector
import com.patikadev.mvvmsample.database.MovieDetail
import com.patikadev.mvvmsample.network.BaseCallBack
import com.patikadev.mvvmsample.network.response.MovieListResponse

class FilmRepository {

    val onMoviesFetched = MutableLiveData<MovieListResponse>()
    val movieDetail = MutableLiveData<MovieDetail>()

    fun getAllMovies(apiKey : String){

        ServiceConnector.restInterface.getTopRatedMovies(apiKey).enqueue(object  : BaseCallBack<MovieListResponse>(){
            override fun onSuccess(data: MovieListResponse) {
               onMoviesFetched.postValue(data)
    }
})
    }

    fun getMovieDetail(apiKey : String , id :Long){

        ServiceConnector.restInterface.getDetail(id,apiKey).enqueue(object  : BaseCallBack<MovieDetail>(){
            override fun onSuccess(data: MovieDetail) {
                movieDetail.postValue(data)
            }
        })
    }

}