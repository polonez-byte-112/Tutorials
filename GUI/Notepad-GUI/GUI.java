package com.notepad;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    int size=8;

    Boolean wordWrapOn=false;
    String  state;
    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor,
          fontFormat, fontSizeFormat;
    JMenuItem newFile, openFile, saveFile, saveAsFile, exitFile,
              undoEdit, redoEdit,
              wordWrapFormat, iFontArial, iFontComicSans, iFontTimeNewRoman,
                i8,i12,i16,i20,i24,i28,
                whiteColor, blackColor, blueColor, greyColor;


    Function_File file= new Function_File(this);
    Function_Edit edit = new Function_Edit(this);
    Function_Format format = new Function_Format(this);
    UndoManager um = new UndoManager();





    public static void main(String[] args)  {
	new GUI();
    }

    public GUI(){
 createWindow();
 createTextArea();
 createMenuBar();
 createFileItems();
 createEditItems();
 createFormatItems();
 fontFormat();
 fontSizeFormat();
 createColorItems();

 format.selectedFont="Arial";
 format.fontFormat(16);
 format.wordWrap();
 window.setVisible(true);
    }

    public void createWindow(){
        window = new JFrame("Notepad");
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void createTextArea(){
        textArea = new JTextArea();
        textArea.setText("");

        textArea.getDocument().addUndoableEditListener(
                new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                um.addEdit(e.getEdit()); //w ten dziwny sposob dodajemy undo i redo funkcje do tekstu
            }
        }
        );

        scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder()); // to usuwa linie dodatkowa z obramowania ktore sie dodaje z suwakami
         window.add(scrollPane);
         // nie musimy dodawac text area do window bo to dodaje sie wraz z scrollPane

    }
    public void createMenuBar(){
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar); // to dodaje  panel menu nie w  panelach itd

        /*
        Dodać File Edit Format Color
         */

        menuFile = new JMenu("File");
        menuBar.add(menuFile);



        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColor = new JMenu("Color");
        menuBar.add(menuColor);

        /*


             Edit
              -Undo
              -Redo

          Format
              -Word wrap: On
              -Font->....
              -Font size -> ....

          Colors
              -White
              -Black
              -Blue
              -Grey
         */
    }
    public void createFileItems(){

        newFile= new JMenuItem("New");
        newFile.addActionListener(this); // poniewaz to this to jest GUI
        newFile.setActionCommand("New");
        menuFile.add(newFile);

        openFile= new JMenuItem("Open");
        openFile.addActionListener(this); //
        openFile.setActionCommand("Open");
        menuFile.add(openFile);

        saveFile= new JMenuItem("Save");
        saveFile.addActionListener(this);
        saveFile.setActionCommand("Save");
        menuFile.add(saveFile);

        saveAsFile= new JMenuItem("Save As");
        saveAsFile.addActionListener(this);
        saveAsFile.setActionCommand("Save As");
        menuFile.add(saveAsFile);

        exitFile= new JMenuItem("Exit");
        exitFile.addActionListener(this);
        exitFile.setActionCommand("Exit");
        menuFile.add(exitFile);


    }
    public void createEditItems(){
        undoEdit = new JMenuItem("Undo");
        undoEdit.addActionListener(this);
        undoEdit.setActionCommand("Undo");
        menuEdit.add(undoEdit);

        redoEdit= new JMenuItem("Redo");
        redoEdit.addActionListener(this);
        redoEdit.setActionCommand("Redo");
        menuEdit.add(redoEdit);
    }
    public void createFormatItems(){




        wordWrapFormat= new JMenuItem("Word Wrap : Off");
        wordWrapFormat.addActionListener(this);
        wordWrapFormat.setActionCommand("Word Wrap");
        menuFormat.add(wordWrapFormat);

        fontFormat = new JMenu("Font");
        fontFormat.addActionListener(this);
        fontFormat.setActionCommand("Font");
        menuFormat.add(fontFormat);

        fontSizeFormat=new JMenu("Font Size");
        fontSizeFormat.addActionListener(this);
        fontSizeFormat.setActionCommand("Font Size");
        menuFormat.add(fontSizeFormat);


    }
    public void createColorItems(){
        whiteColor= new JMenuItem("White");
        whiteColor.addActionListener(this);
        whiteColor.setActionCommand("White");
        menuColor.add(whiteColor);

        blackColor = new JMenuItem("Black");
        blackColor.addActionListener(this);
        blackColor.setActionCommand("Black");
        menuColor.add(blackColor);

        blueColor =  new JMenuItem("Blue");
        blueColor.addActionListener(this);
        blueColor.setActionCommand("Blue");
        menuColor.add(blueColor);

        greyColor = new JMenuItem("Grey");
        greyColor.addActionListener(this);
        greyColor.setActionCommand("Grey");
        menuColor.add(greyColor);
    }
    public void fontFormat(){

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        fontFormat.add(iFontArial);


        iFontComicSans= new JMenuItem("Comic Sans MS");
        iFontComicSans.addActionListener(this);
        iFontComicSans.setActionCommand("CSMS");
        fontFormat.add(iFontComicSans);

        iFontTimeNewRoman = new JMenuItem("Times New Roman");
        iFontTimeNewRoman.addActionListener(this);
        iFontTimeNewRoman.setActionCommand("TNR");
        fontFormat.add(iFontTimeNewRoman);

    }
    public void fontSizeFormat(){

        i8=new JMenuItem("8");
        fontSizeFormat.add(i8);
        i8.setActionCommand("8");
        i8.addActionListener(this);

        i12=new JMenuItem("12");
        fontSizeFormat.add(i12);
        i12.setActionCommand("12");
        i12.addActionListener(this);

        i16=new JMenuItem("16");
        fontSizeFormat.add(i16);
        i16.setActionCommand("16");
        i16.addActionListener(this);

        i20=new JMenuItem("20");
        fontSizeFormat.add(i20);
        i20.setActionCommand("20");
        i20.addActionListener(this);

        i24=new JMenuItem("24");
        fontSizeFormat.add(i24);
        i24.setActionCommand("24");
        i24.addActionListener(this);

        i28=new JMenuItem("28");
        fontSizeFormat.add(i28);
        i28.setActionCommand("28");
        i28.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        switch (command){
            case "New":  file.newFile(); break;
            case "Open": file.openFile(); break;
            case "Save": file.saveFile(); break;
            case "Save As": file.saveAsFile(); break;
            case "Exit": file.exitFile(); break;

            case "Undo": edit.undo();break;
            case "Redo": edit.redo();break;

            case "Word Wrap": format.wordWrap(); break;

            case "Arial": format.setsFont("Arial"); break;
            case "CSMS":format.setsFont("Comic Sans MS"); break;
            case "TNR":format.setsFont("Times New Roman"); break;



            case "8": format.fontFormat(8); break;
            case "12": format.fontFormat(12); break;
            case "16": format.fontFormat(16); break;
            case "20": format.fontFormat(20); break;
            case "24": format.fontFormat(24); break;
            case "28": format.fontFormat(28); break;

            case "White":
                window.getContentPane().setBackground(Color.WHITE);
                textArea.setBackground(Color.WHITE);
                textArea.setForeground(Color.black);
                break;
            case "Black":
                window.getContentPane().setBackground(Color.BLACK);
                textArea.setBackground(Color.BLACK);
                textArea.setForeground(Color.white);
            break;
            case "Blue":
                window.getContentPane().setBackground(Color.BLUE);
                textArea.setBackground(Color.BLUE);
                textArea.setForeground(Color.white);
            break;
            case "Grey":
                window.getContentPane().setBackground(Color.darkGray);
                textArea.setBackground(Color.darkGray);
                textArea.setForeground(Color.white);
            break;

            //Usunałem tutaj te zbędne Function_Color itd bo to mozna tak szybko skrócić


        }

    }
}
