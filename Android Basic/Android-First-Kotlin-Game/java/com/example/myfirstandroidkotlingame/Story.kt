package com.example.myfirstandroidkotlingame

import android.view.View
import kotlinx.android.synthetic.main.activity_game_screen.*

class Story (val gs: GameScreen){
    // to wyzej to jak łaczymy obiekty
    //var - zmienna
    // val -  tworzymy dla czegos co sie nie zmienia
    // fun - function

    /*
        var number = 1;
    var text = "This is text without writing String before name"
     */
    var nextPosition1=""
    var nextPosition2=""
    var nextPosition3=""
    var nextPosition4=""

    var gotSword=false





     fun selectPosition(position: String?){
        when (position){
            "startingPoint"-> startingPoint();
             "sign"-> sign()
             "monster"->  monster()
             "sword"-> sword()
             "pipe"-> pipe()
             "attack"-> attackMonster()
             "grave"-> death()
             "run"-> startingPoint()
            "reset"->gs.resetGame()
             "lookInside"-> piranhaPlant()



        }
    }

     fun startingPoint(){
        gs.GameImageView.setImageResource(R.drawable.trail);
        gs.StoryTextView.setText("You are on the road.\nThere is a wooden sign nearby.\nWhat will You do?");
        gs.button1.setText("Go North");
        gs.button2.setText("Go East");
        gs.button3.setText("Go West");
        gs.button4.setText("Read sign");


        showAllButtons();

        nextPosition1="monster";
        nextPosition2="sword";
        nextPosition3="pipe";
        nextPosition4="sign";
    }




     fun sign(){


         gs.GameImageView.setImageResource(R.drawable.sign);
         gs.StoryTextView.setText("The sign says: \n\nMONSTER AHEAD!");
         gs.button1.setText("Back");
         gs.button2.setText("");
         gs.button3.setText("");
         gs.button4.setText("");


        gs.button1.setVisibility(View.VISIBLE);
        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);


        nextPosition1="startingPoint";
        nextPosition2="";
        nextPosition3="";
        nextPosition4="";
    }

     fun monster(){


         gs.GameImageView.setImageResource(R.drawable.gargoyle);
         gs.StoryTextView.setText("You encounter a gargoyle!!!");
         gs.button1.setText("Attack");
         gs.button2.setText("Run");
         gs.button3.setText("");
         gs.button4.setText("");


         gs.button1.setVisibility(View.VISIBLE);
         gs.button2.setVisibility(View.VISIBLE);
         gs.button3.setVisibility(View.INVISIBLE);
         gs.button4.setVisibility(View.INVISIBLE);




        nextPosition1="attack";
        nextPosition2="run";
        nextPosition3="";
        nextPosition4="";
    }

     fun attackMonster(){
        if(gotSword==false)
        {

            nextPosition1="grave";
            nextPosition2="";
            nextPosition3="";
            nextPosition4="";

            gs.GameImageView.setImageResource(R.drawable.gargoyle);
            gs.StoryTextView.setText("You fight well but the monster\n" + " is too strong for You! The monster kills You");
            gs.button1.setText(">");
            gs.button2.setText("");
            gs.button3.setText("");
            gs.button4.setText("");


            gs.button1.setVisibility(View.VISIBLE);
            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);



        }else{
            gs.GameImageView.setImageResource(R.drawable.chest);


            nextPosition1="reset";
            nextPosition2="";
            nextPosition3="";
            nextPosition4="";
            gotSword=false;




            gs.StoryTextView.setText("With your legendary swoard and experience as a warrior the monster has no chance to win!\n" + "THE END");
            gs.button1.setText("Start Again");
            gs.button2.setText("");
            gs.button3.setText("");
            gs.button4.setText("");


            gs.button1.setVisibility(View.VISIBLE);
            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);

        }


    }

     fun death(){
        gs.GameImageView.setImageResource(R.drawable.grave);
        gs.StoryTextView.setText("You are dead.\nYour adventure ends here.\nGAME OVER");
        gs.button1.setText("Start Again");
        gs.button2.setText("");
        gs.button3.setText("");
        gs.button4.setText("");
        gs.button1.setVisibility(View.VISIBLE);
        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);
        nextPosition1="reset";
        nextPosition2="";
        nextPosition3="";
        nextPosition4="";
        gotSword=false;


    }
     fun pipe(){
        gs.GameImageView.setImageResource(R.drawable.pipe);
        gs.StoryTextView.setText("You find a gigantic pipe.");
        gs.button1.setText("Look inside");
        gs.button2.setText("Go back");
        gs.button3.setText("");
        gs.button4.setText("");


        gs.button1.setVisibility(View.VISIBLE);
        gs.button2.setVisibility(View.VISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);


        nextPosition1="lookInside";
        nextPosition2="run";
        nextPosition3="";
        nextPosition4="";
    }

     fun piranhaPlant(){
        gs.GameImageView.setImageResource(R.drawable.plant);
        if(gotSword==false){

            gs.StoryTextView.setText("Piranha plant is inside!!!\n You are eaten by it.");
            gs.button1.setText(">");
            gs.button2.setText("");
            gs.button3.setText("");
            gs.button4.setText("");
            gs.button1.setVisibility(View.VISIBLE);
            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);
            nextPosition1="grave";
            nextPosition2="";
            nextPosition3="";
            nextPosition4="";
        }else{
            gs.StoryTextView.setText("You have defeated the Piranha plant\nwith your Master Sword!!!\nYou feel much stronger now");
            gs.button1.setText("Go Back");
            gs.button2.setText("");
            gs.button3.setText("");
            gs.button4.setText("");
            gs.button1.setVisibility(View.VISIBLE);
            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);
            nextPosition1="startingPoint";
            nextPosition2="";
            nextPosition3="";
            nextPosition4="";
        }
    }
     fun sword(){
        gs.GameImageView.setImageResource(R.drawable.sword);
        gs.StoryTextView.setText("Amazing! You find a Master Sword! \nYou can kill Monster!");

        gs.button1.setText("Go Back");
        gs.button2.setText("");
        gs.button3.setText("");
        gs.button4.setText("");
        gs.button1.setVisibility(View.VISIBLE);
        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);
        nextPosition1="startingPoint";
        nextPosition2="";
        nextPosition3="";
        nextPosition4="";

        gotSword=true;
    }
     fun showAllButtons(){
        gs.button1.setVisibility(View.VISIBLE);
        gs.button2.setVisibility(View.VISIBLE);
        gs.button3.setVisibility(View.VISIBLE);
        gs.button4.setVisibility(View.VISIBLE);
    }
}


