package com.arincatlamaz.data

data class WeatherResponse(
    val main: Main,
    val weather: List<Weather>,
    val timezone: Int,
    val dt: Long
)

data class Main(
    val temp: Double
)

data class Weather(
    val description: String
)
