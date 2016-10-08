package gui.panels;

import structures.Cuboid;
import structures.LineWrapper;
import structures.Point2D;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class CanvasPanel extends JPanel {

    transient Cuboid cuboid = new Cuboid();

    public CanvasPanel(int width, int height) {
        super();
        setPreferredSize(new Dimension(width,height));
        setBackground(Color.WHITE);

        drawRect();
    }

    private void drawRect() {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        Map<Integer, Point2D> cuboidPoints = cuboid.getPoints2D();

        for (Map.Entry<Integer, Point2D> point : cuboidPoints.entrySet()) {
            g2.drawOval((int)point.getValue().getX()-3, (int)point.getValue().getY()-3, 6,6);
            g2.drawString(String.valueOf(point.getKey()), (int)point.getValue().getX()-6, (int)point.getValue().getY()-6);
        }

        java.util.List<LineWrapper> cuboidLines = cuboid.getLines();
        for (LineWrapper line : cuboidLines) {
            g2.drawLine((int)line.getStartPoint().getX(), (int)line.getStartPoint().getY(), (int)line.getEndPoint().getX(), (int)line.getEndPoint().getY());
        }


    }

}
