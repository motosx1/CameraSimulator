package gui.buttons;

import gui.panels.CanvasPanel;
import structures.Cuboid;

import java.awt.event.ActionEvent;
import java.util.List;

public class ResetButton extends Button{
    transient List<Cuboid> cuboids;
    CanvasPanel canvas = null;


    public ResetButton(CanvasPanel canvas, java.util.List<Cuboid> cuboids) {
        super(" (R) RESET ");

        this.canvas = canvas;
        this.cuboids = cuboids;

        addActionListener(new OnClickAction());
    }

    private class OnClickAction implements java.awt.event.ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Cuboid cuboid : cuboids) {
                cuboid.reset();
            }
            canvas.repaint();
        }
    }
}
