package com.patikadev.mvvmsample.util

import android.widget.Toast
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController


fun Fragment.showToast(messageToShow : String){
    Toast.makeText(requireContext(), messageToShow, Toast.LENGTH_LONG).show()
}

inline fun<reified T : ViewModel> Fragment.getViewModelHolder() : T{

    return ViewModelProvider(this).get(T::class.java)
}

inline fun Fragment.navigateToNextFragment(@IdRes id: Int) {
    findNavController().navigate(id)
}
