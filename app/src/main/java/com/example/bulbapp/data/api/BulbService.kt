package com.example.bulbapp.data.api

import com.example.bulbapp.data.repository.model.BulbBrightnessLevel
import com.example.bulbapp.data.repository.model.Color
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface BulbService {

    @POST("state/on")
    suspend fun turnOn(): Response<Boolean>

    @POST("state/off")
    suspend fun turnOff(): Response<Boolean>

    @GET("state/")
    suspend fun getState(): Response<Boolean>

    @GET("color/names_only")
    suspend fun getColors(): Response<List<String>>

    @GET("color/current")
    suspend fun getCurrentColor(): Response<Color>

    @POST("color/")
    suspend fun setColor(@Query("color") color: String): Response<Boolean>

    @GET("brightness/")
    suspend fun getBrightnessLevelInfo(): Response<BulbBrightnessLevel>

    @POST("brightness/")
    suspend fun setBrightnessLevel(@Query("level") level: Int): Response<Boolean>

    @GET("brightness/current")
    suspend fun getCurrentBrightnessLevel(): Response<Int>

}