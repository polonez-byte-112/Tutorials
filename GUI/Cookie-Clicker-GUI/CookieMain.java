package com.cookies;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CookieMain {


    CookieHandler cookieHandler = new CookieHandler();
    MouseHandler mouseHandler = new MouseHandler();
    JLabel counterLabel, perSecLabel;
    JTextArea descriptionTextArea;
    JButton button1, button2, button3,button4;
    boolean timerOn, grammaUnlocked, farmUnlocked, factoryUnlocked;
    double perSecond;
    Timer timer, unlockedTimer;
    int cookieCounter, timerSpeed;
    Font font1, font2;

    int cursorPrice, cursorNumbers,
        grammaPrice, grammaNumbers,
        farmPrice,  farmNumbers,
        factoryPrice, factoryNumbers;

    public static void main(String[] args) {
        new CookieMain();

    }

    public CookieMain(){
        cursorPrice=10;
        cursorNumbers=0;
        grammaPrice=100;
        grammaNumbers=0;
        farmPrice=500;
        farmNumbers=0;
        factoryPrice=1000;
        factoryNumbers=0;
        perSecond=0;
        timerSpeed=0;
        grammaUnlocked=false; farmUnlocked=false; factoryUnlocked = false;
        timerOn=false;
        cookieCounter=0;
        createFont();
        createUi();
        setUnlockedTimer();
        unlockedTimer.start();


    }

    public void createFont(){

        font1 = new Font("Comic Sans MS",Font.PLAIN, 32);
        font2= new Font("Comic Sans MS",Font.PLAIN, 15);

    }
    public void createUi(){
        JFrame window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setTitle("Cookie Clicker");
        window.setLayout(null);

        Container con = window.getContentPane();

        JPanel cookiePanel = new JPanel();
        cookiePanel.setBounds(100,200,200,200);
        cookiePanel.setBackground(Color.black);

     //   ImageIcon image = new ImageIcon(".//res/cookie.png");
        ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("cookie.png"));

        JButton cookieButton = new JButton();
        cookieButton.addActionListener(cookieHandler);
        cookieButton.setActionCommand("cookie");
        cookieButton.setFocusPainted(false);
        cookieButton.setBackground(Color.black);
        cookieButton.setBorder(null);
        cookieButton.setIcon(image);
        cookiePanel.add(cookieButton);
        con.add(cookiePanel);


        JPanel counterPanel = new JPanel();
        counterPanel.setBounds(100,100,200,100);
        counterPanel.setBackground(Color.black);
        counterPanel.setLayout(new GridLayout(2,1));
        con.add(counterPanel);

        counterLabel = new JLabel(cookieCounter+ " cookies");
        counterLabel.setFont(font1);
        counterLabel.setForeground(Color.white);
        counterPanel.add(counterLabel);

        perSecLabel = new JLabel();
        perSecLabel.setForeground(Color.white);
        perSecLabel.setFont(font2);
        counterPanel.add(perSecLabel);


        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBounds(500,170,250,250);
        buttonsPanel.setLayout(new GridLayout(4,1));

         button1 = new JButton("Cursor ("+cursorNumbers+")");
        button1.setFont(font1);
        button1.setFocusPainted(false);
        button1.addActionListener(cookieHandler);
        button1.addMouseListener(mouseHandler);
        button1.setActionCommand("button1");
        buttonsPanel.add(button1);
         button2 = new JButton("?");
        button2.setFont(font1);
        button2.setFocusPainted(false);
        button2.addActionListener(cookieHandler);
        button2.addMouseListener(mouseHandler);
        button2.setActionCommand("button2");
        buttonsPanel.add(button2);
         button3 = new JButton("?");
        button3.setFont(font1);
        button3.setFocusPainted(false);
        button3.addActionListener(cookieHandler);
        button3.addMouseListener(mouseHandler);
        button3.setActionCommand("button3");
        buttonsPanel.add(button3);
         button4 = new JButton("?");
        button4.setFont(font1);
        button4.setFocusPainted(false);
        button4.addActionListener(cookieHandler);
        button4.addMouseListener(mouseHandler);
        button4.setActionCommand("button4");
        buttonsPanel.add(button4);
        con.add(buttonsPanel);

        JPanel descriptionPanel = new JPanel();
        descriptionPanel.setBounds(500,70,250,150);
        descriptionPanel.setBackground(Color.BLACK);

        descriptionTextArea = new JTextArea("");
        descriptionTextArea.setBounds(500,70,250,150);
        descriptionTextArea.setFont(font2);
        descriptionTextArea.setWrapStyleWord(true);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setBackground(Color.BLACK);
        descriptionTextArea.setForeground(Color.white);


        descriptionPanel.add(descriptionTextArea);

        con.add(descriptionPanel);




        window.setVisible(true);
    }

    public  void setTimer(){
        timer =new Timer(timerSpeed, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cookieCounter++;
                counterLabel.setText(cookieCounter+" cookies");



            }
        });
    }

    public void updateTimer(){

        if(timerOn==false){timerOn=true;}else if(timerOn==true){ timer.stop();}else{}



        double speed =1/perSecond*1000;
        timerSpeed=(int)Math.round(speed);
        String fixedPerSecond =String.format("%.1f", perSecond);

        perSecLabel.setText("Per second : "+fixedPerSecond+" cookie");


                setTimer();
                timer.start();

    }

    public void setUnlockedTimer(){
        unlockedTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(grammaUnlocked==false && cookieCounter>=100){
                    grammaUnlocked=true;
                    button2.setText("Gramma ("+ grammaNumbers+")");

                }

                if(farmUnlocked==false&& cookieCounter>=500){
                    farmUnlocked=true;
                    button3.setText("Farm ("+farmNumbers+")");
                }

                if(factoryUnlocked==false&& cookieCounter>=1000){
                    factoryUnlocked=true;
                    button4.setText("Factory ("+factoryNumbers+")");
                }
            }
        });
    }


    public class CookieHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            String command = e.getActionCommand();
            switch (command){
                case "cookie":
                    cookieCounter=cookieCounter+1;
                    counterLabel.setText(cookieCounter+" cookies");
                    break;

                case "button1":
                    if(cookieCounter>=cursorPrice){
                        cookieCounter=cookieCounter-cursorPrice;
                        cursorPrice=cursorPrice+2;

                        cursorNumbers++;
                        perSecond=perSecond+0.1;
                        descriptionTextArea.setText("Cursor\n[Price: "+cursorPrice+"]\nAutoclicks every 10 seconds.");
                        button1.setText("Cursors ("+cursorNumbers+")");
                        counterLabel.setText(cookieCounter+" cookies");
                        updateTimer();
                    }else{descriptionTextArea.setText("You dont have enough money!");}


                    break;

                case "button2":

                    if(cookieCounter>=grammaPrice){
                        cookieCounter=cookieCounter-grammaPrice;
                        grammaPrice=grammaPrice+20;
                        grammaNumbers++;
                        descriptionTextArea.setText("Gramma\n[Price: "+grammaPrice+"]\nAutoclicks every second");
                        button2.setText("Gramma ("+grammaNumbers+")");
                        perSecond=perSecond+1;
                        counterLabel.setText(cookieCounter+" cookies");
                        updateTimer();
                    }else{descriptionTextArea.setText("You dont have enough money!");}

                    break;

                case "button3":

                    if(cookieCounter>=farmPrice){
                        cookieCounter=cookieCounter-farmPrice;
                        farmPrice=farmPrice+100;
                        farmNumbers++;
                        descriptionTextArea.setText("Farm\n[Price:"+farmPrice+"]\nAuto clicks every 0.2 second");
                        button3.setText("Farm ("+farmNumbers+")");
                        perSecond= perSecond+5;
                        counterLabel.setText(cookieCounter+" cookies");
                        updateTimer();
                    }else{descriptionTextArea.setText("You dont have enough money!");}

                    break;

                case "button4":

                    if(cookieCounter>=factoryPrice){
                        cookieCounter=cookieCounter-factoryPrice;
                        perSecond=perSecond+10;
                        factoryPrice=factoryPrice+200;
                        factoryNumbers++;
                        counterLabel.setText(cookieCounter+" cookies");
                        button4.setText("Factory ("+factoryNumbers+")");
                        descriptionTextArea.setText("Factory\n[Price:"+factoryPrice+"]\nAuto clicks every 0.1 second");
                        updateTimer();
                    }else{descriptionTextArea.setText("You dont have enough money!");}


                    break;

            }

        }
    }

    public class MouseHandler implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

JButton button= (JButton)e.getSource(); //tak bierzemy ktory przycisk zostal najechany

            if(button==button1){descriptionTextArea.setText("Cursor\n[Price: "+cursorPrice+"]\nAutoclicks every 10 seconds.");}
            else if(button==button2){
                if(grammaUnlocked==false) {descriptionTextArea.setText("Item is currently locked");}else{
                    descriptionTextArea.setText("Gramma\n[Price: "+grammaPrice+"]\nAuto clicks every second");

                }
            }
            else if(button==button3){
                if(farmUnlocked==false){descriptionTextArea.setText("Item is currently locked");}
                else{
                    descriptionTextArea.setText("Farm\n[Price:"+farmPrice+"]\nAuto clicks every 0.2 second");
                }
                }
            else {
                if(factoryUnlocked==false){descriptionTextArea.setText("Item is currently locked");}else{
                    descriptionTextArea.setText("Factory\n[Price:"+factoryPrice+"]\nAuto clicks every 0.1 second");
                }
                }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            descriptionTextArea.setText("");
        }
    }
}
