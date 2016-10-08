package structures;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class Cuboid {

    @Getter
    private final Map<Integer, Point3D> points = new HashMap<Integer, Point3D>();
    @Getter
    private static final double INITIAL_VIEWER_DISTANCE = 600;


    public Cuboid(){
        points.put( 0, new Point3D(300, 0, 100) );
        points.put( 1, new Point3D(500, 0, 100) );
        points.put( 2, new Point3D(500, 0, 300) );
        points.put( 3, new Point3D(300, 0, 300) );
        points.put( 4, new Point3D(300, 150, 100) );
        points.put( 5, new Point3D(500, 150, 100) );
        points.put( 6, new Point3D(500, 150, 300) );
        points.put( 7, new Point3D(300, 150, 300) );
    }

    public Map<Integer, Point2D> getTransformedPointsTo2D(){
        Map<Integer, Point2D> transformedPoints = new HashMap<Integer, Point2D>();
        Map<Integer, Point3D> points3D = getPoints();

        for (Map.Entry<Integer, Point3D> cuboidPoint : points3D.entrySet())
        {
            Integer id = cuboidPoint.getKey();
            double x = cuboidPoint.getValue().getX();
            double y = cuboidPoint.getValue().getY();
            double z = cuboidPoint.getValue().getZ();

            transformedPoints.put(id, transformPointTo2D(x,y,z,INITIAL_VIEWER_DISTANCE));
        }

        return transformedPoints;
    }

    private Point2D transformPointTo2D(double x, double y, double z, double d) {
        double newX = (x * d)/(z + d);
        double newY = (y * d)/(z + d);

        return new Point2D(newX, newY);
    }

}
