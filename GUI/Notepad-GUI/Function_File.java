package com.notepad;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Function_File {

    GUI gui;
    String fileName, fileAdress;



    public  Function_File(GUI gui){
        this.gui = gui;
    }

    public void newFile(){
        gui.textArea.setText("");
        gui.window.setTitle("New");
        fileName=null;
        fileAdress=null;
    }

    public void openFile(){
        FileDialog fd = new FileDialog(gui.window ,"Open", FileDialog.LOAD);
        fd.setVisible(true);

        if(fd.getFile()!=null){
            fileName = fd.getFile();
            fileAdress = fd.getDirectory();
            gui.window.setTitle(fileName);

            System.out.println("File adress and name :"+ fileAdress+fileName);
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileAdress + fileName)); // You need a address to read a file
            gui.textArea.setText(""); //czyscimy wszystko co bylo wczesniej

            String line = null;


            while ((line = br.readLine())!=null){
                gui.textArea.append(line+"\n");
            }

            br.close();



        }catch (Exception e){
            System.out.println("FILE NOT OPENED!");
        }



    }

    public void saveFile(){
        if(fileName==null){saveAsFile();}else{


            try {
                  FileWriter fw = new FileWriter(fileAdress+fileName); //w ten sposob pokazujemy gdzie to ma zapisac to coś
                  fw.write(gui.textArea.getText());
                  fw.close();
            }
            catch (Exception e)
            {
                System.out.println("SOMETHING WRONG!");
            }
        }

    }

    public void saveAsFile(){
       FileDialog fd = new FileDialog(gui.window, "Save As", FileDialog.SAVE);
       fd.setVisible(true);


       if((fd.getFile())!=null){
           fileName =fd.getFile();
           fileAdress = fd.getDirectory();
           gui.window.setTitle(fileName);
       }

       try{
           FileWriter  fw = new FileWriter(fileAdress+fileName);
           fw.write(gui.textArea.getText());
           fw.close();
       }catch (Exception e){
           System.out.println("SOMETHING WRONG!");

       }
    }

    public void exitFile(){
        System.exit(0);

    }
}
