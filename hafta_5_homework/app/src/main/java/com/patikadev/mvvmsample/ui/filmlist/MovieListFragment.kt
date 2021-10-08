package com.patikadev.mvvmsample.ui.filmlist

import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayoutMediator
import com.pakt_games.myapplication.viewpager.MainViewPagerAdapter
import com.patikadev.mvvmsample.R
import com.patikadev.mvvmsample.base.BaseFragment
import com.patikadev.mvvmsample.database.MovieTable
import com.patikadev.mvvmsample.databinding.FragmentMovieListBinding
import com.patikadev.mvvmsample.ui.filmlist.adapter.MovieListAdapter
import com.patikadev.mvvmsample.ui.filmlist.model.Clicklistener
import com.patikadev.mvvmsample.util.ViewPagerFragmentDirections
import com.patikadev.mvvmsample.util.navigateToNextFragment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MovieListFragment : BaseFragment<MovieListViewModel, FragmentMovieListBinding> (),Clicklistener {
    override var viewModel: MovieListViewModel?= null


    override fun getLayoutID() = R.layout.fragment_movie_list


    override fun navigation() {

    }

    override fun prepareViewModel() {
        viewModel = ViewModelProvider(this).get(MovieListViewModel::class.java)

    }

    override fun onClickk(id : Long, title : String) {
        Toast.makeText(context,id.toString(),Toast.LENGTH_SHORT).show()
        findNavController().navigate(ViewPagerFragmentDirections.actionViewPagerFragmentToMovieDetailFragment(id,title))
    }

    override fun observeLiveData() {
      viewModel?.moviesResponse?.observe(this, {

          dataBinding.movieListResponse = it
          dataBinding.executePendingBindings()

          dataBinding.recyclerView.adapter = MovieListAdapter(it.getList(), this, database)
      })

    }

    override fun getArgument() {



    }

    override fun viewpager() {

    }


}