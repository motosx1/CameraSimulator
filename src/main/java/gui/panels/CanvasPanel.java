package gui.panels;

import structures.Cuboid;
import structures.Point2D;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

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

        Map<Integer, Point2D> cuboidPoints = cuboid.getTransformedPointsTo2D();

        for (Map.Entry<Integer, Point2D> point : cuboidPoints.entrySet()) {
            g2.drawOval((int)point.getValue().getX(), (int)point.getValue().getY(), 5,5);
        }
    }

}
