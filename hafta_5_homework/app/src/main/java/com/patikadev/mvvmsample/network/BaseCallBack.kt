package com.patikadev.mvvmsample.network

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class BaseCallBack<T> : Callback<T> {
    override fun onResponse(call: Call<T>, response: Response<T>) {

        if(response.isSuccessful){

            /*if(response.body() != null){

            } else {

            }*/
            response.body()?.let {
                onSuccess(it)
            } ?: run {
                onFailure()
            }
        } else{
            onFailure()
        }

    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        onFailure()
    }

    abstract fun onSuccess(data: T)

    open fun onFailure() {
    }


}