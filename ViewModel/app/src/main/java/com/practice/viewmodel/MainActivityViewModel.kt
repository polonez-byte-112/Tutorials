package com.practice.viewmodel

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    var number=0
    val firstFragment = BlankFragment()
    val secondFragment = BlankSecondFragment()
    var currentFrag=1

    fun addNum(){
        number++
    }


}