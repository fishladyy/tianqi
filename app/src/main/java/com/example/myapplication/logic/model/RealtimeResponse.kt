package com.example.myapplication.logic.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class RealtimeResponse(val status: String, val result: Result) {
    data class Result(val realtime: Realtime)
    data class Realtime(val skycon: String, val temperature: Float,
                        @SerializedName("air_quality") val airQuality: AirQuality)
    data class Skycon(val value: String, val date: Date)
    data class AirQuality(val aqi: AQI)
    data class AQI(val chn: Float)
}