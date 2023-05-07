package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class SunnyWeatherApplication : Application() {
        companion object {
            @SuppressLint("StaticFieldLeak")
            lateinit var context: Context
            const val TOKEN ="uaHz96oXnVYarISZ"
            //申请的令牌
        }
        override fun onCreate() {
            super.onCreate()
            context = applicationContext
        }
    }
