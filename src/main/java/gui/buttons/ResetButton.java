package gui.buttons;

import gui.panels.CanvasPanel;
import structures.Cuboid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ResetButton extends JButton{
    transient Cuboid cuboid;
    CanvasPanel canvas = null;


    public ResetButton(Cuboid cuboid, CanvasPanel canvas) {
        super(" RESET ");

        this.cuboid = cuboid;
        this.canvas = canvas;

        addActionListener(new OnClickAction());
    }

    private class OnClickAction implements java.awt.event.ActionListener {
        public void actionPerformed(ActionEvent e) {
            cuboid.resetPoints3D();
            canvas.repaint();
        }
    }
}
