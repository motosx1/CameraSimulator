package gui.buttons;

import algorithms.DisplayAlgorithms;
import gui.panels.CanvasPanel;
import structures.Cuboid;
import structures.Point3D;
import structures.Vector3D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Map;

public class MoveLeftButton extends JButton {
    transient Cuboid cuboid = null;
    CanvasPanel canvas = null;

    protected MoveLeftButton(CanvasPanel canvas, Cuboid cuboid) {
        super("left");
        setAlignmentX(Component.CENTER_ALIGNMENT);
        addActionListener(new OnClickAction());

        this.cuboid = cuboid;
        this.canvas = canvas;
    }

    private class OnClickAction implements java.awt.event.ActionListener {

        public void actionPerformed(ActionEvent e) {
            Vector3D v = new Vector3D(4,0,0);

            Map<Integer, Point3D> points = cuboid.getPoints3D();
            Map<Integer, Point3D> translatedPoints = DisplayAlgorithms.translation(points, v);

            cuboid.setPoints3D(translatedPoints);
            canvas.repaint();
        }

    }
}
