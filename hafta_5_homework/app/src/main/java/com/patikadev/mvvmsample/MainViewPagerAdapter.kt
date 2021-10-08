package com.pakt_games.myapplication.viewpager

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

import com.patikadev.mvvmsample.ui.filmlist.MovieListFragment
import com.patikadev.mvvmsample.ui.home.FavoriMovieFragment

class MainViewPagerAdapter(fragmentManager : FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = 2


    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> return MovieListFragment()
            1 -> return FavoriMovieFragment()
            else -> return MovieListFragment()
        }
    }

}