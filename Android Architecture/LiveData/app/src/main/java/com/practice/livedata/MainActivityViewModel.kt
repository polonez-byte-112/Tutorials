package com.practice.livedata

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
// lateinit pomaga jakby bylo null
    private lateinit var timer : CountDownTimer
    var timerValue = MutableLiveData<Long>()
    var finished =MutableLiveData<Boolean>()
 private   var isRunning = MutableLiveData<Boolean>()


// mutable -zmienne . Ogolnie mozna seconds przypisywac wiele razy w porownaniu do zwyklego live date
    private val _seconds = MutableLiveData<Int>()
    // nie dostaniemy tych _seconds bo jest priv dlatego :

    // kazde mutablelivedata powinno byc prywatne i zeby publiczne livedata pobieralo z tego
    fun seconds(): LiveData<Int>{
        return _seconds
    }

    fun isRun(): LiveData<Boolean>{
        return isRunning
    }

    fun setRun(boolean: Boolean){
        isRunning.value = boolean
    }






    fun startTimer(){

        timer = object : CountDownTimer(timerValue.value!!.toLong(),1000){
            override fun onFinish() {
            finished.value=true
                isRunning.value=false
            }

            override fun onTick(millisUntilFinished: Long) {
                val timeLeft = millisUntilFinished/1000
                isRunning.value=true
                //tak przypisujemy livedata
                _seconds.value=  timeLeft.toInt()
            }

        }.start()
    }


    fun stopTimer(){
        timer.cancel()
    }
}