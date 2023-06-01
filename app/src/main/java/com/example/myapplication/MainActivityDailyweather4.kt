package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.Activity15riBinding
import com.example.myapplication.logic.model.Weather
import com.example.myapplication.logic.model.getSky
import com.example.myapplication.ui.place.Weather.WeatherViewModel
import java.text.SimpleDateFormat
import java.util.*

class MainActivityDailyweather4 : AppCompatActivity() {
    val viewModel by lazy { ViewModelProvider(this).get(WeatherViewModel::class.java) }
    private lateinit var binding: Activity15riBinding//viewbinding绑定视图4
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity15riBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        if (viewModel.locationLng.isEmpty()) {
            viewModel.locationLng = intent.getStringExtra("location_lng") ?: ""
        }
        if (viewModel.locationLat.isEmpty()) {
            viewModel.locationLat = intent.getStringExtra("location_lat") ?: ""
        }
        if (viewModel.placeName.isEmpty()) {
            viewModel.placeName = intent.getStringExtra("place_name") ?: ""
        }
        viewModel.weatherLiveData.observe(this, Observer { result ->
            val weather = result.getOrNull()
            if (weather != null) {
                showDailyWeatherInfo(weather)
            } else {
                Toast.makeText(this, "无法成功获取天气信息", Toast.LENGTH_SHORT).show()
                result.exceptionOrNull()?.printStackTrace()
            }
        })
        viewModel.refreshWeather(viewModel.locationLng, viewModel.locationLat)
    }

    private fun showDailyWeatherInfo(weather: Weather) {
        val daily=weather.daily
        val forecastLayout = findViewById<LinearLayout>(R.id.forecastLayout)
        forecastLayout.removeAllViews()
        for (i in 0 until daily.skycon.size) {
            val skycon = daily.skycon[i]
            val view = LayoutInflater.from(this).inflate(R.layout.daily, forecastLayout, false)
            val SkyIcon = view.findViewById<ImageView>(R.id.SkyIcon)
            SkyIcon.setImageResource(getSky(skycon.value).icon)
            val simpleDateFormat = SimpleDateFormat("yyy-MM-dd", Locale.getDefault())
            val currentSky2 = view.findViewById<TextView>(R.id.currentSky2)
            val sky= getSky(skycon.value)
            currentSky2.text = sky.info
            val dateInfo = view.findViewById<TextView>(R.id.dateInfo)
            dateInfo.text = simpleDateFormat.format(skycon.date)
            val temperature = daily.temperature[i]
            val tempText = view.findViewById<TextView>(R.id.tempText)
            tempText.text = "${temperature.min.toInt()}~${temperature.max.toInt()}℃"
            forecastLayout.addView(view)
        }

    }


    }





