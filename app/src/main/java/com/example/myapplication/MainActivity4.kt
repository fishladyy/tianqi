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

class MainActivity4 : AppCompatActivity() {

    private  val data = listOf("Yesterday","Today","Tomorrow","Monday","Tuesday","Wednesday","Thursday",
    "Friday","Saturday","Sunday")
    class Tianqi(val name: String,val imageId:Int)
    //   定义一个实体类天气
     private val tianqiList=ArrayList<Tianqi>()
    //创建天气列表
    //Tianqi是类，TianqiAdapter是下面写的另一个类，tianqiList是装天气的列表
    class TianqiAdapter(activity:MainActivity4,val resourceID :Int,data:List<Tianqi>):

        ArrayAdapter<Tianqi>(activity,resourceID,data){

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

            val view :View
            if (convertView==null){
                view=LayoutInflater.from(context).inflate(resourceID,parent,false)
            }
            else{
                view=convertView
            }
            //在getview（）方法中进行了判断：如果convertview为null，则用
            //LayoutInflater去加载布局；如果不为null，则可以对convertview进行重用，能提高ListView的运行效率
            //在快速滚动的时候可以表现出更好的性能
            val tianqiImage:ImageView=view.findViewById(R.id.tianqiImage)
            val tianqiName:TextView=view.findViewById(R.id.tianqiName)
            val tianqi =getItem(position)
            //获取当前项的Tianqi实例
            if (tianqi!=null)
            {
                tianqiImage.setImageResource(tianqi.imageId)
                tianqiName.text=tianqi.name
            }

            return view
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        val list1 :ListView =findViewById(R.id.list1)
        val  adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data)
        list1.adapter=adapter
       //用ArrAdapter适配器把data中的数据传入list1中
        initTianqis()
        val adapter2=TianqiAdapter(this,R.layout.tianqi_item,tianqiList)
        list1.adapter=adapter2



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