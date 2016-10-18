package algorithms;


import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import structures.Line3DWrapper;
import structures.LineWrapper;
import structures.Point2D;
import structures.Point3D;

import java.util.HashMap;
import java.util.Map;

public class DisplayAlgorithms {
    private DisplayAlgorithms(){}
    private static final Double BIG_VAL = Double.MAX_VALUE / 1000000000;


    public static Point2D transformPointTo2D(Point3D point, double viewerDistance) {
        Double newX = (point.getX() * viewerDistance)/point.getZ();
        Double newY = (point.getY() * viewerDistance)/point.getZ();

        return new Point2D(newX,newY);
    }


    public static Map<Integer, Point3D> translation(Map<Integer, Point3D> points, double[][] v) {
        Map<Integer, Point3D> newPoints = new HashMap<Integer, Point3D>();

        for (Map.Entry<Integer, Point3D> point : points.entrySet()) {
            Point3D transformedPoint = translatePoint(point.getValue(), v);
            newPoints.put(point.getKey(), transformedPoint);
        }

        return newPoints;
    }

    private static Point3D translatePoint(Point3D point, double[][] v) {
        RealMatrix translationMatrix = MatrixUtils.createRealMatrix(v);
        RealMatrix oldPointMatrix = convertToMatrix(point);

        RealMatrix resultPointMatrix = translationMatrix.multiply(oldPointMatrix);

        return convertToPoint3D(resultPointMatrix);
    }

    private static Point3D convertToPoint3D(RealMatrix resultPointMatrix) {
        double[][] data = resultPointMatrix.getData();
        return new Point3D(data[0][0], data[1][0], data[2][0]);

    }

    private static RealMatrix convertToMatrix(Point3D point) {
        double[][] matrixData = new double[4][1];

        matrixData[0][0] = point.getX();
        matrixData[1][0] = point.getY();
        matrixData[2][0] = point.getZ();
        matrixData[3][0] = 1;

        return MatrixUtils.createRealMatrix(matrixData);
    }

    public static LineWrapper get2DLine(Line3DWrapper line, double viewerDistance) {
        Point2D startPoint = transformPointTo2D(line.getStartPoint(), viewerDistance);
        Point2D endPoint = transformPointTo2D(line.getEndPoint(), viewerDistance);

        return new LineWrapper(startPoint, endPoint);

    }
}
