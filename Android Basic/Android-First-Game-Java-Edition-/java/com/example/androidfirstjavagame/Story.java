package com.example.androidfirstjavagame;

import android.content.Intent;
import android.view.View;

public class Story {
  
    GameScreen gs;
    String nextPosition1, nextPosition2, nextPosition3, nextPosition4;
    boolean gotSword=false;
    public Story(GameScreen gs){
        this.gs=gs;

    }


    public void selectPosition(String position){
        switch (position){
            case "startingPoint": startingPoint(); break;
            case "sign": sign(); break;
            case "monster":  monster();break;
            case "sword": sword(); break;
            case "pipe": pipe(); break;
            case "attack": attackMonster(); break;
            case "grave": death(); break;
            case "run": startingPoint(); break;
            case "reset": gs.resetGame(); break;
            case "lookInside": piranhaPlant(); break;



        }
    }

    public void startingPoint(){
        gs.image.setImageResource(R.drawable.trail);
        gs.text.setText("You are on the road.\nThere is a wooden sign nearby.\nWhat will You do?");
        gs.b1.setText("Go North");
        gs.b2.setText("Go East");
        gs.b3.setText("Go West");
        gs.b4.setText("Read sign");


        showAllButtons();

        nextPosition1="monster";
        nextPosition2="sword";
        nextPosition3="pipe";
        nextPosition4="sign";
    }




    public void sign(){
        gs.image.setImageResource(R.drawable.sign);
        gs.text.setText("The sign says: \n\nMONSTER AHEAD!");
        gs.b1.setText("Back");
        gs.b2.setText("");
        gs.b3.setText("");
        gs.b4.setText("");


        gs.b1.setVisibility(View.VISIBLE);
        gs.b2.setVisibility(View.INVISIBLE);
        gs.b3.setVisibility(View.INVISIBLE);
        gs.b4.setVisibility(View.INVISIBLE);


        nextPosition1="startingPoint";
        nextPosition2="";
        nextPosition3="";
        nextPosition4="";
    }

    public void monster(){

        gs.image.setImageResource(R.drawable.gargoyle);
        gs.text.setText("You encounter a gargoyle!!!");
        gs.b1.setText("Attack");
        gs.b2.setText("Run");
        gs.b3.setText("");
        gs.b4.setText("");


        gs.b1.setVisibility(View.VISIBLE);
        gs.b2.setVisibility(View.VISIBLE);
        gs.b3.setVisibility(View.INVISIBLE);
        gs.b4.setVisibility(View.INVISIBLE);


        nextPosition1="attack";
        nextPosition2="run";
        nextPosition3="";
        nextPosition4="";
    }

    public void attackMonster(){
        if(gotSword==false)
        {
        gs.image.setImageResource(R.drawable.gargoyle);
        gs.text.setText("You fight well but the monster\n is too strong for You! The monster kills You");
        gs.b1.setText(">");
        gs.b2.setText("");
        gs.b3.setText("");
        gs.b4.setText("");
        gs.b1.setVisibility(View.VISIBLE);
        gs.b2.setVisibility(View.INVISIBLE);
        gs.b3.setVisibility(View.INVISIBLE);
        gs.b4.setVisibility(View.INVISIBLE);
        nextPosition1="grave";
        nextPosition2="";
        nextPosition3="";
        nextPosition4="";
        }else{
            gs.image.setImageResource(R.drawable.chest);
            gs.text.setText("With your legendary swoard and experience as a warrior the monster has no chance to win!\nTHE END");
            gs.b1.setText("Start Again");
            gs.b2.setText("");
            gs.b3.setText("");
            gs.b4.setText("");
            gs.b1.setVisibility(View.VISIBLE);
            gs.b2.setVisibility(View.INVISIBLE);
            gs.b3.setVisibility(View.INVISIBLE);
            gs.b4.setVisibility(View.INVISIBLE);

            nextPosition1="reset";
            nextPosition2="";
            nextPosition3="";
            nextPosition4="";
            gotSword=false;

        }


    }

    public void death(){
        gs.image.setImageResource(R.drawable.grave);
        gs.text.setText("You are dead.\nYour adventure ends here.\nGAME OVER");
        gs.b1.setText("Start Again");
        gs.b2.setText("");
        gs.b3.setText("");
        gs.b4.setText("");
        gs.b1.setVisibility(View.VISIBLE);
        gs.b2.setVisibility(View.INVISIBLE);
        gs.b3.setVisibility(View.INVISIBLE);
        gs.b4.setVisibility(View.INVISIBLE);
        nextPosition1="reset";
        nextPosition2="";
        nextPosition3="";
        nextPosition4="";
        gotSword=false;
    }
    public void pipe(){
        gs.image.setImageResource(R.drawable.pipe);
        gs.text.setText("You find a gigantic pipe.");
        gs.b1.setText("Look inside");
        gs.b2.setText("Go back");
        gs.b3.setText("");
        gs.b4.setText("");


        gs.b1.setVisibility(View.VISIBLE);
        gs.b2.setVisibility(View.VISIBLE);
        gs.b3.setVisibility(View.INVISIBLE);
        gs.b4.setVisibility(View.INVISIBLE);


        nextPosition1="lookInside";
        nextPosition2="run";
        nextPosition3="";
        nextPosition4="";
    }

    public void piranhaPlant(){
        gs.image.setImageResource(R.drawable.plant);
        if(gotSword==false){

        gs.text.setText("Piranha plant is inside!!!\n You are eaten by it.");
        gs.b1.setText(">");
        gs.b2.setText("");
        gs.b3.setText("");
        gs.b4.setText("");
        gs.b1.setVisibility(View.VISIBLE);
        gs.b2.setVisibility(View.INVISIBLE);
        gs.b3.setVisibility(View.INVISIBLE);
        gs.b4.setVisibility(View.INVISIBLE);
        nextPosition1="grave";
        nextPosition2="";
        nextPosition3="";
        nextPosition4="";
        }else{
            gs.text.setText("You have defeated the Piranha plant\nwith your Master Sword!!!\nYou feel much stronger now");
            gs.b1.setText("Go Back");
            gs.b2.setText("");
            gs.b3.setText("");
            gs.b4.setText("");
            gs.b1.setVisibility(View.VISIBLE);
            gs.b2.setVisibility(View.INVISIBLE);
            gs.b3.setVisibility(View.INVISIBLE);
            gs.b4.setVisibility(View.INVISIBLE);
            nextPosition1="startingPoint";
            nextPosition2="";
            nextPosition3="";
            nextPosition4="";
        }
    }
    public void sword(){
        gs.image.setImageResource(R.drawable.sword);
        gs.text.setText("Amazing! You find a Master Sword! \nYou can kill Monster!");

        gs.b1.setText("Go Back");
        gs.b2.setText("");
        gs.b3.setText("");
        gs.b4.setText("");
        gs.b1.setVisibility(View.VISIBLE);
        gs.b2.setVisibility(View.INVISIBLE);
        gs.b3.setVisibility(View.INVISIBLE);
        gs.b4.setVisibility(View.INVISIBLE);
        nextPosition1="startingPoint";
        nextPosition2="";
        nextPosition3="";
        nextPosition4="";

        gotSword=true;
    }
    public void showAllButtons(){
        gs.b1.setVisibility(View.VISIBLE);
        gs.b2.setVisibility(View.VISIBLE);
        gs.b3.setVisibility(View.VISIBLE);
        gs.b4.setVisibility(View.VISIBLE);
    }
}
