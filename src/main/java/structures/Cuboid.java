package structures;

import lombok.Getter;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Cuboid {

    @Getter
    private final ArrayList<Point3DWrapper> points = new ArrayList<Point3DWrapper>();
    @Getter
    private static final double INITIAL_VIEWER_DISTANCE = 600;


    public Cuboid(){
        points.add( new Point3DWrapper(0, 300, 0, 100) );
        points.add( new Point3DWrapper(1, 500, 0, 100) );
        points.add( new Point3DWrapper(2, 500, 0, 300) );
        points.add( new Point3DWrapper(3, 300, 0, 300) );
        points.add( new Point3DWrapper(4, 300, 150, 100) );
        points.add( new Point3DWrapper(5, 500, 150, 100) );
        points.add( new Point3DWrapper(6, 500, 150, 300) );
        points.add( new Point3DWrapper(7, 300, 150, 300) );
    }

    public List<Point2D.Double> getTransformedPointsTo2D(){
        ArrayList<Point2D.Double> transformedPoints = new ArrayList<Point2D.Double>();

        ArrayList<Point3DWrapper> cuboidPoints = getPoints();

        for (Point3DWrapper cuboidPoint : cuboidPoints) {
            double x = cuboidPoint.getX();
            double y = cuboidPoint.getY();
            double z = cuboidPoint.getZ();

            transformedPoints.add(transformPointTo2D(x,y,z,1000));
        }

        return transformedPoints;
    }

    private Point2D.Double transformPointTo2D(double x, double y, double z, double d) {
        double newX = (x * d)/(z + d);
        double newY = (y * d)/(z + d);

        return new Point2D.Double(newX, newY);
    }

}
