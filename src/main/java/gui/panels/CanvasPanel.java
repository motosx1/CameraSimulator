package gui.panels;

import structures.Cuboid;
import structures.LineWrapper;
import structures.Point2D;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CanvasPanel extends JPanel {

    transient List<Cuboid> cuboids = new ArrayList<Cuboid>();

    public CanvasPanel(List<Cuboid> cuboids) {
        super();
        this.cuboids = cuboids;
        setBackground(Color.WHITE);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        setCanvasCenter(g2);
        markCanvasCenter(g2);

        for (Cuboid cuboid : cuboids) {
            Map<Integer, Point2D> cuboidPoints = cuboid.getPoints2D();
            for (Map.Entry<Integer, Point2D> point : cuboidPoints.entrySet()) {
                g2.drawString(String.valueOf(point.getKey()), (int)point.getValue().getX()+3, (int)point.getValue().getY()-3);
            }

            java.util.List<LineWrapper> cuboidLines = cuboid.getLines();
            for (LineWrapper line : cuboidLines) {
                g2.drawLine((int)line.getStartPoint().getX(), (int)line.getStartPoint().getY(), (int)line.getEndPoint().getX(), (int)line.getEndPoint().getY());
            }
        }

    }

    private void setCanvasCenter(Graphics2D g2) {
        AffineTransform tx = new AffineTransform();
        tx.translate(MainFrame.getCanvasPanelSize().getWidth()/(double)2,MainFrame.getCanvasPanelSize().getHeight()/(double)3);
        g2.setTransform(tx);
    }

    private void markCanvasCenter(Graphics2D g2) {
        g2.fillOval(0,0,6,6);
    }

}
