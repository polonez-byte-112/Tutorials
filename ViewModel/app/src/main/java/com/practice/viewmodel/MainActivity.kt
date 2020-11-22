package com.practice.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner

import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LifecycleOwner {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var vm = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        num.setText(vm.number.toString())

        startButton.setOnClickListener {
            vm.addNum()
            num.setText(vm.number.toString())
        }





        supportFragmentManager.beginTransaction().apply {
            if(vm.currentFrag==1){
                replace(R.id.frameLayoutFragment, vm.firstFragment)
                commit()
            }else{
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frameLayoutFragment, vm.secondFragment)
                    commit()
            }
        }}


        button1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                vm.currentFrag=1
                replace(R.id.frameLayoutFragment, vm.firstFragment)
                addToBackStack("first")
                commit()}

        }

        button2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                vm.currentFrag=2
                replace(R.id.frameLayoutFragment, vm.secondFragment)
                addToBackStack("second")
                commit()

            }
        }




    }
}