package com.example.myfirstandroidkotlingame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game_screen.*

class GameScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_screen)

        val story = Story(this);
        //to sposob jak laczymy obiekty

        button1.setOnClickListener {
            story.selectPosition(story.nextPosition1)
        }
        button2.setOnClickListener {
            story.selectPosition(story.nextPosition2)}
        button3.setOnClickListener {
            story.selectPosition(story.nextPosition3)}
        button4.setOnClickListener {
            story.selectPosition(story.nextPosition4)}


        story.startingPoint()
    }

    fun resetGame(){
        val resetG = Intent(this, TitleScreen::class.java)
        startActivity(resetG)
    }
}