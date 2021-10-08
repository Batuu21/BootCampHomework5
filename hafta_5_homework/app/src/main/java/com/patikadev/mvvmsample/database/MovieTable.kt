package com.patikadev.mvvmsample.database


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "favorite_movies")
data class MovieTable (

    @PrimaryKey(autoGenerate = true)
    var id: Long ,

    @ColumnInfo(name = "title")
    var title: String

)


