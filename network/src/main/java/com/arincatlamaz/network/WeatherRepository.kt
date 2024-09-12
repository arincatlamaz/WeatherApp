package com.arincatlamaz.network

import com.arincatlamaz.data.WeatherResponse

interface WeatherRepository {
    suspend fun getWeather(city: String): WeatherResponse
}