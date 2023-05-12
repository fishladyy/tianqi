package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityZhuyeBinding
import com.example.myapplication.logic.model.DailyResponse
import com.example.myapplication.logic.model.Weather
import com.example.myapplication.logic.model.getSky
import com.example.myapplication.ui.place.Weather.WeatherViewModel
import java.text.SimpleDateFormat
import java.util.*

class MainActivityZhuye : AppCompatActivity() {
    private lateinit var binding: ActivityZhuyeBinding //创建绑定

    val viewModel by lazy { ViewModelProvider(this).get(WeatherViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityZhuyeBinding.inflate(layoutInflater)//调用生成的绑定类中包含的静态inflate()方法
        //创建该绑定类的实例供Activity使用
        val view = binding.root
        //通过调用getRoot()方法或使用kotlin属性语法获取对根视图的引用
        setContentView(view)//将根视图传递到setContentView,使其成为屏幕上的活动视图

        val decorView = window.decorView

        binding.bt1.setOnClickListener {
            Toast.makeText(this, "切换城市", Toast.LENGTH_SHORT).show()
            //makeText接受三个参数，第一个是context上下文因为activity本身就是一个context对象所以直接传入this
            // 第二个是Toast显示的文本内容，第三个是Toast显示的时长
            val intent = Intent(this, MainActivitySousuo2::class.java)
            startActivity(intent)//启动第AC2
        }

        binding.bt2.setOnClickListener {
            val intent = Intent(this, MainActivitySetting3::class.java)
            startActivity(intent)//启动AC3
        }
        binding.bt3.setOnClickListener {

            val intent=Intent(this,MainActivityDailyweather4::class.java).apply {
                putExtra("location_lng",viewModel.locationLng)
                putExtra("location_lat",viewModel.locationLat)
                putExtra("place_name",viewModel.placeName)
            }
            startActivity(intent)
        }
        binding.yunyun.setOnClickListener {
            val intent = Intent(this, MainActivityLianwang5::class.java)
            startActivity(intent)//启动AC5
        }
        /////上面是按钮
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
                showWeatherInfo(weather)
            } else {
                Toast.makeText(this, "无法成功获取天气信息", Toast.LENGTH_SHORT).show()
                result.exceptionOrNull()?.printStackTrace()
            }
        })
        viewModel.refreshWeather(viewModel.locationLng, viewModel.locationLat)
    }


    private fun showWeatherInfo(weather: Weather) {
        binding.placeName.text = viewModel.placeName
        val realtime = weather.realtime
        val currentTempText = "${realtime.temperature.toInt()}℃"
        binding.currentTemp.text = currentTempText
        binding.currentSky.text = getSky(realtime.skycon).info
        val currentPM25Text = "空气指数${realtime.airQuality.aqi.chn.toInt()}"
        binding.currentAQI.text = currentPM25Text
        //把天气的具体图标绑定
        val daily=weather.daily
        val days = daily.skycon.size
        val dailyLayout = findViewById<LinearLayout>(R.id.dailyLayout)
        dailyLayout.removeAllViews()
        for (i in 0 until 3) {
            val skycon = daily.skycon[i]
            val view = LayoutInflater.from(this).inflate(R.layout.daily, dailyLayout, false)
            val SkyIcon = view.findViewById<ImageView>(R.id.SkyIcon)
            SkyIcon.setImageResource(getSky(skycon.value).icon)
            val simpleDateFormat = SimpleDateFormat("yyy-MM-dd", Locale.getDefault())
            val currentSky2 = view.findViewById<TextView>(R.id.currentSky2)
            val sky = getSky(skycon.value)
            currentSky2.text = sky.info
            val dateInfo = view.findViewById<TextView>(R.id.dateInfo)
            dateInfo.text = simpleDateFormat.format(skycon.date)
            val temperature = daily.temperature[i]
            val tempText = view.findViewById<TextView>(R.id.tempText)
            tempText.text = "${temperature.min.toInt()}~${temperature.max.toInt()}℃"
            dailyLayout.addView(view)
        }

    }



}





