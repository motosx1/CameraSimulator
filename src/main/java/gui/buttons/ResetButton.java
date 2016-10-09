package gui.buttons;

import gui.panels.CanvasPanel;
import structures.Cuboid;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class ResetButton extends JButton{
    transient List<Cuboid> cuboids;
    CanvasPanel canvas = null;


    public ResetButton(CanvasPanel canvas, java.util.List<Cuboid> cuboids) {
        super(" RESET ");

        this.canvas = canvas;
        this.cuboids = cuboids;

        addActionListener(new OnClickAction());
    }

    private class OnClickAction implements java.awt.event.ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Cuboid cuboid : cuboids) {
                cuboid.resetPoints3D();
            }
            canvas.repaint();
        }
    }
}
