package algorithms;

import lombok.Getter;

public class Vectors {
    private static final int STEP = 10;
    private static final double ANGLE = 0.05;
    @Getter private static final double[][] translationLeft = {{1, 0, 0, STEP}, {0,1,0,0}, {0,0,1,0}, {0,0,0,1}};
    @Getter private static final double[][] translationRight = {{1, 0, 0, -STEP}, {0,1,0,0}, {0,0,1,0}, {0,0,0,1}};
    @Getter private static final double[][] translationUp = {{1, 0, 0, 0}, {0,1,0, STEP}, {0,0,1,0}, {0,0,0,1}};
    @Getter private static final double[][] translationDown = {{1, 0, 0, 0}, {0,1,0,-STEP}, {0,0,1,0}, {0,0,0,1}};

    @Getter
    private static final double[][] rotateX = {
            {1,0,0,0},
            {0,Math.cos(ANGLE),-Math.sin(ANGLE),0},
            {0,Math.sin(ANGLE),Math.cos(ANGLE),0},
            {0,0,0,1}
    };
    @Getter
    private static final double[][] rotateMinusX = {
            {1,0,0,0},
            {0,Math.cos(-ANGLE),-Math.sin(-ANGLE),0},
            {0,Math.sin(-ANGLE),Math.cos(-ANGLE),0},
            {0,0,0,1}
    };
    @Getter
    private static final double[][] rotateY = {
            {Math.cos(ANGLE),0,Math.sin(ANGLE),0},
            {0,1,0,0},
            {-Math.sin(ANGLE),0,Math.cos(ANGLE),0},
            {0,0,0,1}
    };
    @Getter
    private static final double[][] rotateMinusY = {
            {Math.cos(-ANGLE),0,Math.sin(-ANGLE),0},
            {0,1,0,0},
            {-Math.sin(-ANGLE),0,Math.cos(-ANGLE),0},
            {0,0,0,1}
    };
    @Getter
    private static final double[][] rotateZ = {
            {Math.cos(ANGLE),-Math.sin(ANGLE),0,0},
            {Math.sin(ANGLE),Math.cos(ANGLE),0,0},
            {0,0,1,0},
            {0,0,0,1}
    };
    @Getter
    private static final double[][] rotateMinusZ = {
            {Math.cos(-ANGLE),-Math.sin(-ANGLE),0,0},
            {Math.sin(-ANGLE),Math.cos(-ANGLE),0,0},
            {0,0,1,0},
            {0,0,0,1}
    };

    private Vectors(){}
}
