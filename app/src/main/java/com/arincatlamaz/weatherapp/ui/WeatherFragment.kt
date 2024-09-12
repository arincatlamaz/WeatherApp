package com.arincatlamaz.weatherapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.viewModels
import com.arincatlamaz.weatherapp.R
import com.arincatlamaz.weatherapp.utils.TimeUtils
import com.arincatlamaz.weatherapp.vm.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherFragment : Fragment(R.layout.fragment_weather) {

    private val viewModel: WeatherViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cityNameInput = view.findViewById<EditText>(R.id.cityNameInput)
        val searchButton = view.findViewById<Button>(R.id.searchButton)
        val weatherTextView = view.findViewById<TextView>(R.id.weatherTextView)
        val timeTextView = view.findViewById<TextView>(R.id.timeTextView)

        searchButton.setOnClickListener {
            val city = cityNameInput.text.toString()
            if (city.isNotEmpty()) {
                viewModel.fetchWeather(city)
            }
        }

        viewModel.weather.observe(viewLifecycleOwner) { weatherResponse ->
            val temp = weatherResponse.main.temp
            val weatherDescription = weatherResponse.weather[0].description
            weatherTextView.text = "Temperature: ${weatherResponse.main.temp}°C, Weather: ${weatherDescription}"

            val localTime = TimeUtils.unixToLocalTime(weatherResponse.dt, weatherResponse.timezone)
            timeTextView.text = "Local Time: $localTime"
        }
    }


}