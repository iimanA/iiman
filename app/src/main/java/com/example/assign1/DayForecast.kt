package com.example.assign1

data class DayForecast(
    val date: Int,
    val sunrise: Long,
    val sunset: Long,
    val temp: ForecastTemp,
    val pressure: Float,
    val humidity: Int,
)
