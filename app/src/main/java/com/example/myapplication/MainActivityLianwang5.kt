package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivityLianwang5 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lianwang)

   val webview_yubao:WebView=findViewById(R.id.webview_yubao)
        webview_yubao.settings.javaScriptEnabled=true
        webview_yubao.webViewClient= WebViewClient()
        webview_yubao.loadUrl("http://www.weather.com")

                    }
                }

