package com.patikadev.mvvmsample.ui.home

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.patikadev.mvvmsample.R
import com.patikadev.mvvmsample.base.BaseFragment
import com.patikadev.mvvmsample.database.MovieTable
import com.patikadev.mvvmsample.databinding.FragmentHomeBinding
import com.patikadev.mvvmsample.ui.filmlist.adapter.MovieFavAdapter
import com.patikadev.mvvmsample.ui.filmlist.adapter.MovieListAdapter
import com.patikadev.mvvmsample.ui.filmlist.model.Clicklistener
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FavoriMovieFragment : BaseFragment<HomeViewModel,  FragmentHomeBinding>(), Clicklistener {
    override var viewModel: HomeViewModel? = null

    override fun getLayoutID(): Int = R.layout.fragment_home

    override fun navigation() {

    }

    override fun prepareViewModel() {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun shouldCheckInternetConnection() = false


    override fun observeLiveData() {


       database.getallmovies().observe(this, Observer {

           dataBinding.recyclerViewfav.adapter=MovieFavAdapter(it,this,database)
           dataBinding.executePendingBindings()


       })
    }

    override fun getArgument() {
    }

    override fun onClickk(id: Long, title : String) {
        GlobalScope.launch {
            database.delete(id)
        }
    }

    override fun viewpager() {

    }


}