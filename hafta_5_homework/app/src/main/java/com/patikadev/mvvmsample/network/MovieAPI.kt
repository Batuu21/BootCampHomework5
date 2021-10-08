package com.patikadev.mvvmsample.network

import com.patikadev.mvvmsample.database.MovieDetail
import com.patikadev.mvvmsample.network.response.MovieListResponse
import retrofit2.Call
import retrofit2.http.*

interface MovieAPI {

    @GET("popular")
    fun getTopRatedMovies(@Query("api_key") apikey : String) : Call<MovieListResponse>

    @GET("{movie_id}")
    fun getDetail(@Path("movie_id") movieId: Long, @Query("api_key") apikey: String) : Call<MovieDetail>

}