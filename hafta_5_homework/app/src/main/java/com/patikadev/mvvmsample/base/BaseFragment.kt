package com.patikadev.mvvmsample.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.patikadev.mvvmsample.database.MovieDatabase
import com.patikadev.mvvmsample.database.MovieDatabaseDao
import com.patikadev.mvvmsample.ui.filmlist.model.Clicklistener
import com.patikadev.mvvmsample.util.showToast

abstract class BaseFragment<VM : ViewModel?, DB : ViewDataBinding> : Fragment(), FragmentActions {

    abstract var viewModel: VM?
    protected lateinit var dataBinding: DB
    lateinit var database : MovieDatabaseDao
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(inflater, getLayoutID(), container, false)
        navigation()
        viewpager()

        val application = requireNotNull(this.activity).application

         database = MovieDatabase.getInstance(application).movieDatabaseDao


        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeLiveData()

        showToast(shouldCheckInternetConnection().toString())
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getArgument()
        prepareViewModel()
    }



    abstract fun getLayoutID(): Int
    abstract fun observeLiveData()
    abstract fun navigation()
    abstract fun prepareViewModel()
    abstract fun getArgument()
    override fun shouldCheckInternetConnection() = true
    abstract fun viewpager()

}