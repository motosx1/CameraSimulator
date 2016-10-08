package gui.panels;

import structures.Cuboid;
import structures.Point2DWrapper;

import javax.swing.*;
import java.awt.*;
import java.util.List;

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

        List<Point2DWrapper> points = cuboid.getTransformedPointsTo2D();

        for (Point2DWrapper point : points) {
            g2.drawOval((int)point.getX(), (int)point.getY(), 5,5);
        }

    }

}
