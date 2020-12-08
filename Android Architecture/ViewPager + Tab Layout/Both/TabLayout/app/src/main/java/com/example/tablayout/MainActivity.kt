package com.example.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var text : Array<String> = emptyArray()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        text = resources.getStringArray(R.array.tabs_texts)

        val adapter = ViewPagerAdapter(text)
        view_pager.adapter=adapter

        /*

          view_pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
                 //Samo przesuwa bez wciskania
                 view_pager.beginFakeDrag()
                 view_pager.fakeDragBy(-5f)
                 view_pager.endFakeDrag()

          */

        //Connection to tab layout
        //Uzywany mediatora bo tu jest wersja 2.0 view pagera

        //Parametrem jest obecny tab i pozycja
        TabLayoutMediator(tab_layout,view_pager){ tab, position ->
            tab.text = "Tab ${position+1}"

            //Mozna dodac powiadomienia lub jak ikone typu ile jest nowych wiadomosci etc
        }.attach()


        //Tylko to trzeba do zrobienia tego tab layout XDD


        //Tutaj dodatek do tego
        //Slowo object pozwala zrobienie obiektu klasy bez przypisywania do val etc .Mozna to  nizej porównac do new View.onClickListener{...}

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "Reselected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "Unselected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "Selected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }
            
        })

    }
}