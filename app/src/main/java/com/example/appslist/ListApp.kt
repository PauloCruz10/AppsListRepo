package com.example.appslist

import android.app.Application
import com.example.appslist.plarform.AppLogger
import com.example.shareddata.logger.Logger
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ListApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Logger.injectLogger(AppLogger())
    }
}