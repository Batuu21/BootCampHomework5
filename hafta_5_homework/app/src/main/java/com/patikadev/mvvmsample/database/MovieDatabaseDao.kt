package com.patikadev.mvvmsample.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MovieDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(movie: MovieTable)

    @Query("DELETE  FROM favorite_movies WHERE id = :key")
    suspend fun delete(key: Long)

    @Query("SELECT * FROM favorite_movies ORDER BY id DESC")
    fun getallmovies(): LiveData<List<MovieTable>>

    @Query("SELECT * from favorite_movies WHERE id = :key")
    suspend fun getMovie(key: Long): MovieTable?


}

