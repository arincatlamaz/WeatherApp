package com.arincatlamaz.network

import com.arincatlamaz.data.WeatherResponse
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherService: WeatherService
) : WeatherRepository {

    override suspend fun getWeatherByCityName(city: String): WeatherResponse {
        return weatherService.getWeather(city, "4a0a150488c1b2517daf5851e4c3e802")
    }
}