package com.example.assign1.service

import com.example.assign1.models.CurrentConditions
import com.example.assign1.models.ForecastConditions
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherMapApi {
    @GET("data/2.5/weather")
    suspend fun getCurrentConditions(
        @Query("zip") zip: String,
        @Query("appid") apiKey: String = "6d070596809201aded0bb7967637cdd7",
        @Query("units") units: String = "imperial",
    ) :CurrentConditions

    @GET("data/2.5/weather")
    suspend fun getCurrentConditions(
        @Query("lat") latitude: Float,
        @Query("lon") longitude: Float,
        @Query("appid") apiKey: String = "6d070596809201aded0bb7967637cdd7",
        @Query("units") units: String = "imperial",

        ) :CurrentConditions

    @GET("data/2.5/forecast/daily")
    suspend fun getForecastConditions(
        @Query("zip") zip: String,
        @Query("appid") apiKey: String = "6d070596809201aded0bb7967637cdd7",
        @Query("units") units: String = "imperial",
    ):ForecastConditions
}