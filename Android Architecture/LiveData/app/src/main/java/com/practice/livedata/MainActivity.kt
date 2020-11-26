package com.practice.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.setRun(false)

        viewModel.seconds().observe(this, Observer {
            titleText.text= it.toString()
        })

        viewModel.finished.observe(this , Observer {
            //tutaj it w ifie mozna rozszerzyc jako it==true. It to cos na czym to wykonujemy
            if(it){
            Toast.makeText(this, "Finished", Toast.LENGTH_LONG).show()}
        })



        start_btn.setOnClickListener {
            if(number_input.text.isEmpty() || number_input.text.length<4){
                Toast.makeText(this, "Invalid number", Toast.LENGTH_SHORT).show()
            }else{
                if(viewModel.isRun().value==false){
                viewModel.timerValue.value = number_input.text.toString().toLong()
                viewModel.startTimer()
                }
            }

        }


        stop_btn.setOnClickListener {
            titleText.text="0"
            viewModel.setRun(false)
            viewModel.stopTimer()
        }



/*
tak mozna lub w xml co bedzie tam

        var viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)


        // obserwatorem jest main activity i ustawiamy seconds ktore jest tutaj tym it na text
        viewModel.seconds().observe(this, Observer {
            titleText.text= it.toString()
        })
 */
    }
}