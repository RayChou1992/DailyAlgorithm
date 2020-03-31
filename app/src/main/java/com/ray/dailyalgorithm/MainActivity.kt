package com.ray.dailyalgorithm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private var values = arrayOf(29, 10, 14, 37, 13)
    var changeFlag = false;
    var Count = values.size;
    var handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showText()

        bt_reset.setOnClickListener {
            values = arrayOf(30, 14, 29, 44, 28, 34, 23, 45, 3, 1, 4, 2, 5)
            showText()
        }

        bt_bubbling.setOnClickListener {
            Toast.makeText(this@MainActivity, "冒泡排序", Toast.LENGTH_SHORT).show()
            Thread { bubblingSorting() }.start()
        }

        bt_select.setOnClickListener {
            Thread { selectSorting() }.start()
        }
    }

    /**
     * @date 2020/3/26
     * @author ray
     * @desc 选择排序
     */
    private fun selectSorting() {
        //选择第一个数为初始最小值
        var target = 0;
        var temp: Int = 0

        for (i in values.indices) {
            temp = values[i]
            for (j in i + 1 until values.size) {
                if (temp > values[j]) {
                    temp = values[j]
                    target = j
                }
            }
            values[target] = values[i]
            values[i] = temp
            handler.post {
                showText()
            }
            Thread.sleep(1000)
        }
    }

    private fun showText() {
        var str = ""
        values.forEach {
            str += "$it,"
        }
        textView.text = str
    }

    /**
     * @date 2020/3/26
     * @author ray
     * @desc 冒泡排序
     */
    private fun bubblingSorting() {
        do {
            for (i in 0 until values.size - 1) {
                if (values[i] > (values[i + 1])) {
                    var tempInt = values[i + 1]
                    values[i + 1] = values[i]
                    values[i] = tempInt
                }

            }
            Log.e("tag", "11")
            handler.post {
                showText()
            }
            Thread.sleep(1000)
            Count -= 1

        } while (Count > 1)
    }
}
