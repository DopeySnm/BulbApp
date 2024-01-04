package com.example.bulbapp.di

import android.content.Context
import com.example.bulbapp.presenter.MainApp

val Context.appComponent: AppComponent
    get() = when(this) {
        is MainApp -> appComponent
        else -> this.applicationContext.appComponent
    }