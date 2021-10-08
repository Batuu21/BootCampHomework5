package com.patikadev.mvvmsample

import android.app.Application
import com.patikadev.deneme1.service.ServiceConnector

class MvvmSampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ServiceConnector.init()

    }
}