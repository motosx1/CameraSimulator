package algorithms;


import structures.Point2D;
import structures.Point3D;

public class DisplayAlgorithms {
    private DisplayAlgorithms(){}

    public static Point2D transformPointTo2D(Point3D point, double viewerDistance) {
        double newX = (point.getX() * viewerDistance)/(point.getZ() + viewerDistance);
        double newY = (point.getY() * viewerDistance)/(point.getZ() + viewerDistance);

        return new Point2D(newX, newY);
    }
}
