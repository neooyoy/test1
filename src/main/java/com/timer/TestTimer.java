package com.timer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class TestTimer{
    public static void main(String[] args){
        ActionListener actionListener = new TimePriter();
        Timer timer = new Timer(3000, actionListener);


        timer.start();
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

class TimePriter implements ActionListener{
    public void actionPerformed(ActionEvent e){
        Date now = new Date();
        System.out.println("the time is " + now);

        Toolkit.getDefaultToolkit().beep();

    }
}