package gui.panels;

import algorithms.DisplayAlgorithms;
import structures.*;

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

        if(!cuboids.isEmpty()) {
            markCanvasCenter(g2, cuboids.get(0));
        }

        for (Cuboid cuboid : cuboids) {
            drawCuboid(g2, cuboid);
        }

    }

    private void drawCuboid(Graphics2D g2, Cuboid cuboid) {
        Map<Integer, Point2D> cuboidPoints = cuboid.getPoints2D();
//        for (Map.Entry<Integer, Point2D> point : cuboidPoints.entrySet()) {
//            g2.drawString(String.valueOf(point.getKey()), (int)point.getValue().getX()+3, (int)point.getValue().getY()-3);
//        }

        List<Line3DWrapper> cuboidLines = cuboid.getLines3D();
        for (Line3DWrapper line : cuboidLines) {
            if( isLineVisible(line) ) {
                LineWrapper line2D = DisplayAlgorithms.get2DLine(line, cuboid.getViewerDistance());
                g2.drawLine((int) line2D.getStartPoint().getX(), (int) line2D.getStartPoint().getY(), (int) line2D.getEndPoint().getX(), (int) line2D.getEndPoint().getY());
            }
        }
    }

    private boolean isLineVisible(Line3DWrapper line) {

        Point3D startPoint = line.getStartPoint();
        Point3D endPoint = line.getEndPoint();

        return startPoint.getZ() > 0 && endPoint.getZ() > 0;

    }

    private void setCanvasCenter(Graphics2D g2) {
        AffineTransform tx = new AffineTransform();
        tx.translate(MainFrame.getCanvasPanelSize().getWidth()/(double)2,MainFrame.getCanvasPanelSize().getHeight()/(double)3);
        g2.setTransform(tx);
    }

    private void markCanvasCenter(Graphics2D g2, Cuboid cuboid) {
        Point2D horizonPoint = cuboid.getPoints2D().get(Cuboid.HORIZON_POINT);
        g2.fillOval((int)horizonPoint.getX()-3,(int)horizonPoint.getY()-3,6,6);
    }



}
