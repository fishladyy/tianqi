package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout

class TitleLayout(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {
    init {
        LayoutInflater.from(context).inflate(R.layout.title, this,true)
//或者
//LayoutInflater.from(context).inflate(R.layout.title, this,true)
        val back: Button = findViewById(R.id.back)
        //给back键注册点击事件，当点击Back按钮时销毁当前Activity
        back.setOnClickListener {
            val activity = context as Activity
            //context参数接受的是Activity实例用as关键字强制类型转换成Activity类型，再调用finish()方法销毁当前的Activity
            activity.finish()

        }
    }

}