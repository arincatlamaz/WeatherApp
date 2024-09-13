package com.arincatlamaz.weatherapp.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arincatlamaz.data.Weather
import com.arincatlamaz.data.WeatherResponse
import com.arincatlamaz.network.WeatherRepository
import com.arincatlamaz.weatherapp.utils.TimeUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    private val _weather = MutableLiveData<WeatherResponse>()
    val weather: LiveData<WeatherResponse> get() = _weather


    fun fetchWeather(city: String) {
        viewModelScope.launch {
            try {

                val response = weatherRepository.getWeatherByCityName(city)
                _weather.value = response

                val timezoneOffset = response.timezone
                val currentTime = response.dt
                val localTime = TimeUtils.unixToLocalTime(currentTime, timezoneOffset)

            } catch (e: Exception) {

                Log.e("WeatherViewModel", "Error fetching weather data", e)
            }
        }
    }
}