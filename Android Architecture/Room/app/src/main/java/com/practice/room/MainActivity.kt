package com.practice.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupActionBarWithNavController(findNavController(R.id.fragment))
    }


    //by naprawic cofanie dodajemy to

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment)
        return  navController.navigateUp() ||  super.onSupportNavigateUp()
    }
}