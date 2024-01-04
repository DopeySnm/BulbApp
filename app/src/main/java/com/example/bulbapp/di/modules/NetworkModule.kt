package com.example.bulbapp.di.modules

import com.example.bulbapp.data.api.BulbService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideBulbService(): BulbService =
        Retrofit.Builder()
            .baseUrl("http://195.54.14.121:8086/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BulbService::class.java)
}