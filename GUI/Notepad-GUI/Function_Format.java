package com.notepad;

import javax.swing.*;
import java.awt.*;

public class Function_Format {
    GUI gui;
    Font arial, comicSansMS, timesNewRoman;
    String selectedFont;

    public Function_Format(GUI gui){
        this.gui = gui;
    }

    public void wordWrap(){

        if(gui.wordWrapOn==false){
            gui.wordWrapOn=true;
             gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true); // nie przerywa lini podczas zdania tylko miedzy nimi
          gui.wordWrapFormat.setText("Word Wrap: On");
        }
        else if(gui.wordWrapOn==true){
            gui.wordWrapOn=false;
            gui.textArea.setLineWrap(false); gui.textArea.setWrapStyleWord(false); gui.wordWrapFormat.setText("Word Wrap: Off");}else{}




    }

    public void fontFormat(int fontSize){



        arial= new Font("Arial", Font.PLAIN, fontSize);
        timesNewRoman= new Font("Times New Roman", Font.PLAIN, fontSize);
        comicSansMS= new Font("Comic Sans MS", Font.PLAIN, fontSize);

           setsFont(selectedFont);
    }

    public void setsFont(String font){
        selectedFont=font;

         switch (selectedFont){
             case "Arial": gui.textArea.setFont(arial); break;
             case "Comic Sans MS": gui.textArea.setFont(comicSansMS);  break;
             case "Times New Roman": gui.textArea.setFont(timesNewRoman);  break;
             default: break;
         }

    }





}
