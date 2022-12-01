package com.example.assign1.models

import com.squareup.moshi.Json


data class ForecastTemp(
    @Json(name = "min") val dailyMin: Float,
    @Json(name = "max") val dailyMax: Float,
)

data class ForecastConditionsData(
    @Json(name = "dt") val date: Long,
    @Json(name = "sunrise") val sunrise: Long,
    @Json(name = "sunset") val sunset: Long,
    @Json(name = "temp") val forecastTemp: ForecastTemp,
    @Json(name = "weather") val weatherData: List<WeatherData>,


    )

data class ForecastConditions(
    @Json(name = "list") val forecastData: List<ForecastConditionsData>,
    )