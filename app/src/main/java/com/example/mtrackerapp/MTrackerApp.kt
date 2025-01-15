package com.example.mtrackerapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MTrackerApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}