package com.example.weather

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v3/weather/weatherInfo")
    fun getWeather(
        @Query("city") city: String,
        @Query("key") apiKey: String,
        @Query("extensions") extensions: String = "all"
    ): Call<WeatherResponse>
}

