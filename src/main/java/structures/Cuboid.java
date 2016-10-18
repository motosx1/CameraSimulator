package structures;

import algorithms.DisplayAlgorithms;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cuboid {

    private InitialCuboidData initialData;
    @Getter
    private Map<Integer, Point3D> points3D = new HashMap<Integer, Point3D>();
    @Getter
    private Map<Integer, Point2D> points2D = new HashMap<Integer, Point2D>();
    private static final int INITIAL_VIEWER_DISTANCE = 600;
    @Getter
    private double viewerDistance = INITIAL_VIEWER_DISTANCE;
    public static final Integer HORIZON_POINT = 8;


    public Cuboid(){
        initialData = new InitialCuboidData(new Point3D(-230, -130, -100), 150, 200, 200);
        points3D = getInitialPoints3D();
        points2D = getTransformedPointsTo2D();
    }

    public Cuboid(InitialCuboidData initialData){
        this.initialData = initialData;
        points3D = getInitialPoints3D();
        points2D = getTransformedPointsTo2D();
    }

    private Map<Integer, Point3D> getInitialPoints3D() {
        Map<Integer, Point3D> initialPoints = new HashMap<Integer, Point3D>();

        double x = initialData.getInitPoint().getX();
        double y = initialData.getInitPoint().getY();
        double z = initialData.getInitPoint().getZ();
        int width = initialData.getWidth();
        int height = initialData.getHeight();
        int depth = initialData.getDepth();

        initialPoints.put( 0, new Point3D(x, y, z) );
        initialPoints.put( 1, new Point3D(x+width, y, z) );
        initialPoints.put( 2, new Point3D(x+width, y, z+depth) );
        initialPoints.put( 3, new Point3D(x, y, z+depth) );
        initialPoints.put( 4, new Point3D(x, y+height, z) );
        initialPoints.put( 5, new Point3D(x+width, y+height, z) );
        initialPoints.put( 6, new Point3D(x+width, y+height, z+depth) );
        initialPoints.put( 7, new Point3D(x, y+height, z+depth) );
        initialPoints.put(HORIZON_POINT, new Point3D(0,0,-(Double.MAX_VALUE/1000000000)) );
        return initialPoints;
    }

    private Map<Integer, Point2D> getTransformedPointsTo2D(){
        Map<Integer, Point2D> transformedPoints = new HashMap<Integer, Point2D>();

        for (Map.Entry<Integer, Point3D> cuboidPoint : points3D.entrySet()){
            Integer id = cuboidPoint.getKey();
            Point2D transformedPoint = DisplayAlgorithms.transformPointTo2D(cuboidPoint.getValue(), viewerDistance);

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

    public List<Line3DWrapper> getLines3D(){
        ArrayList<Line3DWrapper> tmpLines = new ArrayList<Line3DWrapper>();

        tmpLines.add(new Line3DWrapper(points3D.get(0), points3D.get(1)));
        tmpLines.add(new Line3DWrapper(points3D.get(0), points3D.get(3)));
        tmpLines.add(new Line3DWrapper(points3D.get(0), points3D.get(4)));
        tmpLines.add(new Line3DWrapper(points3D.get(4), points3D.get(5)));
        tmpLines.add(new Line3DWrapper(points3D.get(4), points3D.get(7)));
        tmpLines.add(new Line3DWrapper(points3D.get(1), points3D.get(5)));
        tmpLines.add(new Line3DWrapper(points3D.get(7), points3D.get(3)));
        tmpLines.add(new Line3DWrapper(points3D.get(7), points3D.get(6)));
        tmpLines.add(new Line3DWrapper(points3D.get(6), points3D.get(5)));
        tmpLines.add(new Line3DWrapper(points3D.get(3), points3D.get(2)));
        tmpLines.add(new Line3DWrapper(points3D.get(2), points3D.get(1)));
        tmpLines.add(new Line3DWrapper(points3D.get(6), points3D.get(2)));

        return tmpLines;
    }

    public void setPoints3D(Map<Integer, Point3D> points3D) {
        this.points3D = points3D;
        points2D = getTransformedPointsTo2D();
    }

    public void setViewerDistance(double viewerDistance){
        this.viewerDistance = viewerDistance;
        points2D = getTransformedPointsTo2D();
    }

    public List<LineWrapper> getLines() {
        return getLinesWrapper();
    }

    public void reset(){
        this.viewerDistance = INITIAL_VIEWER_DISTANCE;
        setPoints3D(getInitialPoints3D());
    }
}
