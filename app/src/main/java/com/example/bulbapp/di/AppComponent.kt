package com.example.bulbapp.di

import com.example.bulbapp.presenter.bulb.BulbFragment
import dagger.Component

@Component(
    modules = [ AppModule::class ]
)
interface AppComponent {
    fun inject(fragment: BulbFragment)
}