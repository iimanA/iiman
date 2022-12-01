package com.example.assign1.ui

import androidx.lifecycle.ViewModel
import com.example.assign1.models.ForecastConditions
import com.example.assign1.models.LatitudeLongitude
import com.example.assign1.service.OpenWeatherMapApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(private val api: OpenWeatherMapApi):
    ViewModel() {
    private val _forecastConditions = Channel<ForecastConditions>()

     val forecastConditions: Flow<ForecastConditions> = _forecastConditions.receiveAsFlow()

    fun fetchData() = runBlocking {
        val forecastConditions = api.getForecastConditions("55404")
        _forecastConditions.trySend(forecastConditions)
    }
    fun fetchForecastLocationData(latitudeLongitude: LatitudeLongitude)= runBlocking {
        val forecastConditions = api.getForecastConditions(latitudeLongitude.latitude, latitudeLongitude.longitude)
        _forecastConditions.trySend(forecastConditions)
    }
}