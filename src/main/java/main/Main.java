package main;

import gui.panels.MainFrame;
import structures.Cuboid;

import java.awt.*;

public class Main  {
    private Main(){}
    public static void main(String[] args) {
        final Cuboid cuboid = new Cuboid();

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame(cuboid);
            }
        });
    }
}

