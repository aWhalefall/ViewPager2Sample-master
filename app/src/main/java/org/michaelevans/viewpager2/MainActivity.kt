package org.michaelevans.viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewPager : ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.view_pager)

        viewPager.adapter = CheesePagerAdapter(Cheeses.CheeseStrings)
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        viewPager.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                txt_view.text="position =${position}"
            }
        })
    }

    class CheesePagerAdapter(private val cheeseStrings: Array<String>) : RecyclerView.Adapter<CheeseViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheeseViewHolder {
            return CheeseViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cheese_list_item, parent, false))
        }

        override fun onBindViewHolder(holder: CheeseViewHolder, position: Int) {
            holder.cheeseName.text = cheeseStrings[position]
        }

        override fun getItemCount() = cheeseStrings.size
    }

    class CheeseViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val cheeseName: TextView = view.findViewById(R.id.cheese_name)
    }
}
