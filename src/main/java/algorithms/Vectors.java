package algorithms;

import lombok.Getter;

public class Vectors {
    private static final int STEP = 4;
    @Getter private static final double[][] translationLeft = {{1, 0, 0, STEP}, {0,1,0,0}, {0,0,1,0}, {0,0,0,1}};
    @Getter private static final double[][] translationRight = {{1, 0, 0, -STEP}, {0,1,0,0}, {0,0,1,0}, {0,0,0,1}};
    @Getter private static final double[][] translationUp = {{1, 0, 0, 0}, {0,1,0, STEP}, {0,0,1,0}, {0,0,0,1}};
    @Getter private static final double[][] translationDown = {{1, 0, 0, 0}, {0,1,0,-STEP}, {0,0,1,0}, {0,0,0,1}};

    private Vectors(){}
}
