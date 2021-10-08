package com.patikadev.mvvmsample.ui.filmlist.model

import com.patikadev.mvvmsample.database.MovieTable

interface Clicklistener {
    fun onClickk(id: Long, title : String)
}