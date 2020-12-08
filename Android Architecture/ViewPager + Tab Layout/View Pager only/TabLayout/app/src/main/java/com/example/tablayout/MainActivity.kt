package com.example.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var text : Array<String> = emptyArray()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        text = resources.getStringArray(R.array.tabs_texts)

        val adapter = ViewPagerAdapter(text)
        view_pager.adapter=adapter
        view_pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

/*
        //Samo przesuwa bez wciskania
        view_pager.beginFakeDrag()
        view_pager.fakeDragBy(-5f)
        view_pager.endFakeDrag()

 */

    }
}