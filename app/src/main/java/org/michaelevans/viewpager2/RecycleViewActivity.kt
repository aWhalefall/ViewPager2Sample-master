package org.michaelevans.viewpager2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycle_view.*

class RecycleViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)

        val linerlayout = LinearLayoutManager(this)
        linerlayout.orientation = RecyclerView.VERTICAL
        recycle.layoutManager = linerlayout


        var simpleRecycle = SimpleRecycle(this)
        recycle.adapter = simpleRecycle

//        var mScrollEventAdapter = ScrollEventAdapter(linerlayout)
//        recycle.addOnScrollListener(mScrollEventAdapter)
        recycle.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                //滚动方向
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                Log.d("recycle","newState ="+newState)
                //0 ,1,2 停止状态，开始滑动，滑动释放
            }
        })
    }


}
