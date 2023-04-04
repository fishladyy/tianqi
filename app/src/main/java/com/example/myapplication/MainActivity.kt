package com.example.myapplication

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         val decorView=window.decorView
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val bt1: Button = findViewById(R.id.bt1)//kotlin不用findviewbyid方法,再看viewBlinding
        val bt2: Button = findViewById(R.id.bt2)
        val bt3: Button=findViewById(R.id.bt3)
        val yunyun:ImageButton=findViewById(R.id.yunyun)


        bt1.setOnClickListener {
            Toast.makeText(this,"切换城市",Toast.LENGTH_SHORT).show()
            //makeText接受三个参数，第一个是context上下文因为activity本身就是一个context对象所以直接传入this
        // 第二个是Toast显示的文本内容，第三个是Toast显示的时长
            val intent=Intent(this,MainActivity2::class.java)
            startActivity(intent)//启动第AC2
        }

        bt2.setOnClickListener{
            val intent=Intent(this,MainActivity3::class.java)
            startActivity(intent)//启动AC3
        }
        bt3.setOnClickListener{

            val intent =Intent(this,MainActivity4::class.java)
            startActivity(intent)//启动AC4
        }
        yunyun.setOnClickListener{
            val intent=Intent(this,MainActivity5::class.java)
            startActivity(intent)//启动AC5
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)//kotlin语法糖直接得到menuInflater对象，
        // inflate（）方法
        // 来给当前activity创建菜单，
        // 接受两个参数，第一个参数指定通过哪个资源文件来创建菜单，第二个参数指定菜单项添加到哪个Menu对象中
        return true//允许创建的菜单显示，如果是false则没法显示
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.share_item -> Toast.makeText(this,"分享QWQ",Toast.LENGTH_SHORT).show()
            R.id.fankui_item -> Toast.makeText(this,"反馈QWQ",Toast.LENGTH_SHORT).show()
        }
        return true
    }
}