package com.example.bulbapp.presenter

import android.app.Application
import com.example.bulbapp.di.AppComponent
import com.example.bulbapp.di.DaggerAppComponent


class MainApp : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}