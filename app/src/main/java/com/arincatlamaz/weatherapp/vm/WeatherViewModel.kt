package com.arincatlamaz.weatherapp.vm

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arincatlamaz.data.WeatherResponse
import com.arincatlamaz.network.WeatherRepository
import com.arincatlamaz.weatherapp.utils.TimeUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale
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

                val response = weatherRepository.getWeather(city)
                _weather.value = response

//                val weatherDescription = response.weather[0].description
                val timezoneOffset = response.timezone
                val currentTime = response.dt
                val localTime = TimeUtils.unixToLocalTime(currentTime, timezoneOffset)

            } catch (e: Exception) {

                Log.e("WeatherViewModel", "Error fetching weather data", e)
            }
        }
    }
}