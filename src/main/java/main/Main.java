package main;

import gui.panels.MainFrame;
import structures.Cuboid;
import structures.InitialCuboidData;
import structures.Point3D;

import java.awt.*;
import java.util.ArrayList;

public class Main  {
    private Main(){}
    public static void main(String[] args) {
        final ArrayList<Cuboid> cuboids = generateCuboids();

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame(cuboids);
            }
        });
    }

    private static ArrayList<Cuboid> generateCuboids() {
        final Cuboid cuboid1 = new Cuboid(new InitialCuboidData(new Point3D(200, 130, 100), 150, 200, 200));
        final Cuboid cuboid2 = new Cuboid(new InitialCuboidData(new Point3D(200, 130, 450), 150, 200, 200));

        final Cuboid cuboid3 = new Cuboid(new InitialCuboidData(new Point3D(-400, 130, 100), 150, 200, 200));
        final Cuboid cuboid4 = new Cuboid(new InitialCuboidData(new Point3D(-400, 130, 450), 150, 200, 200));

        final ArrayList<Cuboid> cuboids = new ArrayList<Cuboid>();
        cuboids.add(cuboid1);
        cuboids.add(cuboid2);
        cuboids.add(cuboid3);
        cuboids.add(cuboid4);
        return cuboids;
    }
}

