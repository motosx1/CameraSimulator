package structures;

import algorithms.DisplayAlgorithms;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cuboid {

    @Getter
    private final Map<Integer, Point3D> points3D = new HashMap<Integer, Point3D>();
    @Getter
    private Map<Integer, Point2D> points2D = new HashMap<Integer, Point2D>();
    @Getter
    private List<LineWrapper> lines = new ArrayList<LineWrapper>();
    private static final double INITIAL_VIEWER_DISTANCE = 600;


    public Cuboid(){
        points3D.put( 0, new Point3D(300-70, 200-70, 100) );
        points3D.put( 1, new Point3D(500-70, 200-70, 100) );
        points3D.put( 2, new Point3D(500-70, 200-70, 300) );
        points3D.put( 3, new Point3D(300-70, 200-70, 300) );
        points3D.put( 4, new Point3D(300-70, 350-70, 100) );
        points3D.put( 5, new Point3D(500-70, 350-70, 100) );
        points3D.put( 6, new Point3D(500-70, 350-70, 300) );
        points3D.put( 7, new Point3D(300-70, 350-70, 300) );

        points2D = getTransformedPointsTo2D();
        lines = getLinesWrapper();
    }

    private Map<Integer, Point2D> getTransformedPointsTo2D(){
        Map<Integer, Point2D> transformedPoints = new HashMap<Integer, Point2D>();

        for (Map.Entry<Integer, Point3D> cuboidPoint : points3D.entrySet()){
            Integer id = cuboidPoint.getKey();
            Point2D transformedPoint = DisplayAlgorithms.transformPointTo2D(cuboidPoint.getValue(), INITIAL_VIEWER_DISTANCE);

            transformedPoints.put(id, transformedPoint);
        }

        return transformedPoints;
    }

    private List<LineWrapper> getLinesWrapper(){
        ArrayList<LineWrapper> tmpLines = new ArrayList<LineWrapper>();

        tmpLines.add(new LineWrapper(points2D.get(0), points2D.get(1)));
        tmpLines.add(new LineWrapper(points2D.get(0), points2D.get(3)));
        tmpLines.add(new LineWrapper(points2D.get(0), points2D.get(4)));
        tmpLines.add(new LineWrapper(points2D.get(4), points2D.get(5)));
        tmpLines.add(new LineWrapper(points2D.get(4), points2D.get(7)));
        tmpLines.add(new LineWrapper(points2D.get(1), points2D.get(5)));
        tmpLines.add(new LineWrapper(points2D.get(7), points2D.get(3)));
        tmpLines.add(new LineWrapper(points2D.get(7), points2D.get(6)));
        tmpLines.add(new LineWrapper(points2D.get(6), points2D.get(5)));
        tmpLines.add(new LineWrapper(points2D.get(3), points2D.get(2)));
        tmpLines.add(new LineWrapper(points2D.get(2), points2D.get(1)));
        tmpLines.add(new LineWrapper(points2D.get(6), points2D.get(2)));

        return tmpLines;
    }

}
