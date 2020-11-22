package com.example.androidfirstjavagame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity {

    ImageView image;
    TextView text;
    Button b1,b2,b3,b4;

    Story story = new Story(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        image = (ImageView) findViewById(R.id.GameImageView);
        text =  (TextView) findViewById(R.id.StoryTextView);

        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);

        b1.setTransformationMethod(null);
        b2.setTransformationMethod(null);
        b3.setTransformationMethod(null);
        b4.setTransformationMethod(null);
        story.startingPoint();

    }

    public void button1(View view){
        story.selectPosition(story.nextPosition1);
    }


    public void button2(View view){
        story.selectPosition(story.nextPosition2);
    }


    public void button3(View view){
        story.selectPosition(story.nextPosition3);
    }


    public void button4(View view){
        story.selectPosition(story.nextPosition4);
    }


    public void resetGame(){
        Intent resetGame = new Intent(this, TitleScreen.class);
        startActivity(resetGame);
    }


}
