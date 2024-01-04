package com.example.bulbapp.di

import com.example.bulbapp.di.modules.AppBindsModule
import com.example.bulbapp.di.modules.NetworkModule
import com.example.bulbapp.di.modules.ViewModelModule
import dagger.Module

@Module(
    includes = [
        NetworkModule::class,
        AppBindsModule::class,
        ViewModelModule::class,
    ]
)
class AppModule