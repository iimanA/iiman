package com.example.assign1.ui

import androidx.lifecycle.ViewModel
import com.example.assign1.models.CurrentConditions
import com.example.assign1.service.OpenWeatherMapApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class CurrentConditionsViewModel @Inject constructor(private val api: OpenWeatherMapApi) :
    ViewModel() {
    private val _currentConditions = Channel<CurrentConditions>()

    val currentConditions: Flow<CurrentConditions> = _currentConditions.receiveAsFlow()
    fun fetchData() = runBlocking {
        val currentConditions = api.getCurrentConditions("55404")
        _currentConditions.trySend(currentConditions)

    }

}