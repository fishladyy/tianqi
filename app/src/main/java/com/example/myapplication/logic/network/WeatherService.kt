package com.example.myapplication.logic.network

import com.example.myapplication.SunnyWeatherApplication
import com.example.myapplication.logic.model.DailyResponse
import com.example.myapplication.logic.model.RealtimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {

    @GET("v2.5/${SunnyWeatherApplication.TOKEN}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(@Path("lng") lng: String, @Path("lat") lat: String): Call<RealtimeResponse>

    @GET("v2.5/${SunnyWeatherApplication.TOKEN}/{lng},{lat}/daily.json")
    fun getDailyWeather(@Path("lng") lng: String, @Path("lat") lat: String): Call<DailyResponse>
}
//两个方法的返回值分别被声明成了Call<RealtimeResponse>和Call<DailyResponse>，对应刚刚定义好的数据模型类