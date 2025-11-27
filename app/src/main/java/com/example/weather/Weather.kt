package com.example.weather

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    val status: String,
    val count: String,
    val info: String,
    val infocode: String,
    val forecasts: List<Forecast>
)

data class Forecast(
    val city: String,
    val adcode: String,
    val province: String,
    val reporttime: String,
    val casts: List<Cast>
)

data class Cast(
    val date: String,
    val week: String,
    val dayweather: String,
    val nightweather: String,
    val daytemp: String,
    val nighttemp: String,
    @SerializedName("daywind") val dayWind: String,
    @SerializedName("nightwind") val nightWind: String,
    @SerializedName("daypower") val dayPower: String,
    @SerializedName("nightpower") val nightPower: String
)

