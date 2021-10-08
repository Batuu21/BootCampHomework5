package com.patikadev.mvvmsample.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import com.pakt_games.myapplication.viewpager.MainViewPagerAdapter
import com.patikadev.mvvmsample.R
import com.patikadev.mvvmsample.base.BaseFragment
import com.patikadev.mvvmsample.database.MovieTable
import com.patikadev.mvvmsample.databinding.FragmentDetailBinding
import com.patikadev.mvvmsample.databinding.FragmentViewpagerBinding
import com.patikadev.mvvmsample.ui.home.DetailViewModel
import com.patikadev.mvvmsample.ui.home.MovieDetailFragmentArgs
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ViewPagerFragment : BaseFragment<DetailViewModel, FragmentViewpagerBinding>() {
    override var viewModel: DetailViewModel? = null

    var tabTitle = arrayOf("FİLMLER","FAVORİ FİLMLER")

    override fun getLayoutID(): Int = R.layout.fragment_viewpager

    override fun navigation() {

}

    override fun prepareViewModel() {

    }

    override fun shouldCheckInternetConnection() = false


    override fun observeLiveData() {

    }

    override fun getArgument() {

    }

    override fun viewpager() {
        dataBinding.viewPager2.adapter = MainViewPagerAdapter(childFragmentManager , lifecycle)

        TabLayoutMediator(dataBinding.tabLayout,dataBinding.viewPager2) {
                tab, position ->
            tab.text = tabTitle[position]
        }.attach()
    }

}

