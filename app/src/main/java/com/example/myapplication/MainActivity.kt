package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.myapplication.databinding.ActivityZhuyeBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityZhuyeBinding //创建绑定
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
            val intent = Intent(this, MainActivitysousuo2::class.java)
            startActivity(intent)//启动第AC2
        }

        binding.bt2.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)//启动AC3
        }
        binding.bt3.setOnClickListener {

            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)//启动AC4
        }
        binding.yunyun.setOnClickListener {
            val intent = Intent(this, MainActivity5::class.java)
            startActivity(intent)//启动AC5
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)//kotlin语法糖直接得到menuInflater对象，
        // inflate（）方法
        // 来给当前activity创建菜单，
        // 接受两个参数，第一个参数指定通过哪个资源文件来创建菜单，第二个参数指定菜单项添加到哪个Menu对象中
        return true//允许创建的菜单显示，如果是false则没法显示
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share_item -> Toast.makeText(this, "分享QWQ", Toast.LENGTH_SHORT).show()
            R.id.fankui_item -> Toast.makeText(this, "反馈QWQ", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}