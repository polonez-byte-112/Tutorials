  package com.example.tablayoutfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import com.example.tablayoutfragments.adapters.ViewPagerAdapter
import com.example.tablayoutfragments.fragments.FavoriteFragment
import com.example.tablayoutfragments.fragments.HomeFragment
import com.example.tablayoutfragments.fragments.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*

  class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpTabs()
    }

    private fun setUpTabs() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment(), "")
        adapter.addFragment(FavoriteFragment(), "")
        adapter.addFragment(SettingsFragment(), "")
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)


        //dodanie ikonek

        tabLayout.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_home_24)
        tabLayout.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_favorite_24)
        tabLayout.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_settings_24)

    }
}