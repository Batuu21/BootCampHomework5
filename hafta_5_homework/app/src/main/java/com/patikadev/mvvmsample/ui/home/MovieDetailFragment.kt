package com.patikadev.mvvmsample.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import com.pakt_games.myapplication.viewpager.MainViewPagerAdapter
import com.patikadev.mvvmsample.R
import com.patikadev.mvvmsample.base.BaseFragment
import com.patikadev.mvvmsample.database.MovieTable
import com.patikadev.mvvmsample.databinding.FragmentDetailBinding
import com.patikadev.mvvmsample.databinding.FragmentHomeBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MovieDetailFragment : BaseFragment<DetailViewModel, FragmentDetailBinding>() {
    override var viewModel: DetailViewModel? = null
    var id : Long =0
    lateinit var title : String


    override fun getLayoutID(): Int = R.layout.fragment_detail

    override fun navigation() {
        dataBinding.addfav.setOnClickListener {
            GlobalScope.launch {
             database.insert(MovieTable(id,title))
            }
        }

    }

    override fun prepareViewModel() {
        val viewModelFactory = DetailViewModelFactory(id)
         viewModel = ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)


    }

    override fun shouldCheckInternetConnection() = false


    override fun observeLiveData() {
        viewModel?.detailresponse?.observe(this, {

             dataBinding.moviedetail=it
            dataBinding.executePendingBindings()


        })
    }

    override fun getArgument() {
        var args = MovieDetailFragmentArgs.fromBundle(requireArguments())
        title=args.title
        id=args.id

    }

    override fun viewpager() {

    }

}

class DetailViewModelFactory(private val id: Long) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(id) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
