package gui.buttons;

import algorithms.DisplayAlgorithms;
import gui.panels.CanvasPanel;
import structures.Cuboid;
import structures.Point3D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TransformationButton extends JButton {
    transient List<Cuboid> cuboids = new ArrayList<Cuboid>();
    transient double[][] vector = null;
    CanvasPanel canvas = null;

    protected TransformationButton(CanvasPanel canvas, java.util.List<Cuboid> cuboids, double[][] vector, String title) {
        super(title);
        setAlignmentX(Component.CENTER_ALIGNMENT);
        addActionListener(new OnClickAction());

        this.cuboids = cuboids;
        this.canvas = canvas;
        this.vector = vector;
    }

    private class OnClickAction implements java.awt.event.ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Cuboid cuboid : cuboids) {
                Map<Integer, Point3D> points = cuboid.getPoints3D();
                Map<Integer, Point3D> translatedPoints = DisplayAlgorithms.translation(points, vector);

                cuboid.setPoints3D(translatedPoints);
            }
            canvas.repaint();
        }
    }
}
