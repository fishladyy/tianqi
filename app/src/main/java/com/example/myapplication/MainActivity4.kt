package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.Activity15riBinding

class MainActivity4 : AppCompatActivity() {
private lateinit var binding: Activity15riBinding//viewbinding绑定视图4
    private  val data = listOf("Yesterday","Today","Tomorrow","Monday","Tuesday","Wednesday","Thursday",
        "Friday","Saturday","Sunday")
    private val tianqiList=ArrayList<Tianqi>()
    //创建天气列表
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= Activity15riBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        initTianqis()
        val layoutManager=LinearLayoutManager(this)

        binding.list1.layoutManager=layoutManager
        val adapter_tianqi=TianqiAdapter(tianqiList)
        binding.list1.adapter=adapter_tianqi

//        val list1 :ListView =findViewById(R.id.list1)
//        val  adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data)
//        list1.adapter=adapter
//       //用ArrayAdapter适配器把data中的数据传入list1中
//        initTianqis()
//        val adapter2=TianqiAdapter(this,R.layout.tianqi_item,tianqiList)
//        list1.adapter=adapter2


    }
    private  fun initTianqis(){
        repeat(2){
            tianqiList.add(Tianqi("Yesterday",R.drawable.daxue))
            tianqiList.add(Tianqi("Today",R.drawable.dayu))
            tianqiList.add(Tianqi("Tomorrow",R.drawable.dongyu))
            tianqiList.add(Tianqi("Monday",R.drawable.leidian))
            tianqiList.add(Tianqi("Tuesday",R.drawable.lieri))
            tianqiList.add(Tianqi("Wednesday",R.drawable.nongyun))
            tianqiList.add(Tianqi("Thursday",R.drawable.shachenbao))
            tianqiList.add(Tianqi("Friday",R.drawable.wuqi))
            tianqiList.add(Tianqi("Saturday",R.drawable.xiaoyu))
            tianqiList.add(Tianqi("Sunday",R.drawable.yujiaxue))
            //把创建好的对象添加到列表中，repeat函数把所有水果的数据添加了两遍
        }

    }


}