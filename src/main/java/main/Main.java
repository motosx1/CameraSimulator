package main;

import gui.panels.MainFrame;

import java.awt.*;

public class Main  {
    private Main(){}
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });
    }
}

