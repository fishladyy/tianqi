package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter//之前listview用的
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class Tianqi(val name: String,val imageId:Int)
//   定义一个实体类天气
 class TianqiAdapter(val tianqiList: List<Tianqi>):RecyclerView.Adapter<TianqiAdapter.ViewHolder>() {

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val tianqiImage: ImageView =view.findViewById(R.id.tianqiImage)
            val tianqiName: TextView =view.findViewById(R.id.tianqiName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.tianqi_item,parent,false)
        return  ViewHolder(view)
    }//创建viewholder实例，并把加载出来的布局传入构造函数中，最后将实例返回

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tianqi=tianqiList[position]
        holder.tianqiImage.setImageResource(tianqi.imageId)
        holder.tianqiName.text=tianqi.name
    }// onBindViewHolder方法用于对RecyclerView子项的数据进行赋值，会在每个子项被滚动到屏幕内的时候执行
    //通过position参数得到当前项的Tianqi实例，然后再将数据设置到ViewHolder的ImageView和TextView当中

    override fun getItemCount()=tianqiList.size
//    getItemCount()方法是告诉RecyclerView一共有多少子项，直接返回数据源长度

}




//以下是listview的适配器
//class Tianqi(val name: String,val imageId:Int)
    //   定义一个实体类天气
    //Tianqi是类，TianqiAdapter是下面写的另一个类，tianqiList是装天气的列表

//        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
////            val view : View
//            if (convertView==null){
//                view= LayoutInflater.from(context).inflate(resourceID,parent,false)
//            }
//            else{
//                view=convertView
//            }
//            //在getview（）方法中进行了判断：如果convertview为null，则用
//            //LayoutInflater去加载布局；如果不为null，则可以对convertview进行重用，能提高ListView的运行效率
//            //在快速滚动的时候可以表现出更好的性能
//            val tianqiImage: ImageView =view.findViewById(R.id.tianqiImage)
//            val tianqiName: TextView =view.findViewById(R.id.tianqiName)
//            val tianqi =getItem(position)
//            //获取当前项的Tianqi实例
//            if (tianqi!=null)
//            {
//                tianqiImage.setImageResource(tianqi.imageId)
//                tianqiName.text=tianqi.name
//            }
//
//            return view
//        }
//
//    }
//
//}