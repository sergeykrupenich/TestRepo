package com.siarheikrupenich.testrepo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class RepoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        timberTreeForDebug()
    }

    private fun timberTreeForDebug() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}