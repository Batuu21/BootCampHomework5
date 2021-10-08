package com.patikadev.mvvmsample.database

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey


data class MovieDetail(val title: String, var overview: String)
