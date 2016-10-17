package gui.buttons;

import gui.panels.CanvasPanel;
import structures.Cuboid;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class ViewerDistanceButton extends Button{
    private transient List<Cuboid> cuboids = new ArrayList<Cuboid>();
    private transient double step;
    private CanvasPanel canvas = null;

    protected ViewerDistanceButton(CanvasPanel canvas, List<Cuboid> cuboids, double step, String title) {
        super(title);
        setAlignmentX(Component.CENTER_ALIGNMENT);
        addActionListener(new OnClickAction());

        this.cuboids = cuboids;
        this.canvas = canvas;
        this.step = step;
    }

    private class OnClickAction implements java.awt.event.ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Cuboid cuboid : cuboids) {
                cuboid.setViewerDistance(cuboid.getViewerDistance() + step);
            }
            canvas.repaint();
        }
    }
}
