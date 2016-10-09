package gui.buttons;

import algorithms.DisplayAlgorithms;
import gui.panels.CanvasPanel;
import structures.Cuboid;
import structures.Point3D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Map;

public class TransformationButton extends JButton {
    transient Cuboid cuboid = null;
    transient double[][] vector = null;
    CanvasPanel canvas = null;

    protected TransformationButton(CanvasPanel canvas, Cuboid cuboid, double[][] vector, String title) {
        super(title);
        setAlignmentX(Component.CENTER_ALIGNMENT);
        addActionListener(new OnClickAction());

        this.cuboid = cuboid;
        this.canvas = canvas;
        this.vector = vector;
    }

    private class OnClickAction implements java.awt.event.ActionListener {
        public void actionPerformed(ActionEvent e) {
            Map<Integer, Point3D> points = cuboid.getPoints3D();
            Map<Integer, Point3D> translatedPoints = DisplayAlgorithms.translation(points, vector);

            cuboid.setPoints3D(translatedPoints);
            canvas.repaint();
        }
    }
}
