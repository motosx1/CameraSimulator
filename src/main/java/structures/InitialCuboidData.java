package structures;

import lombok.Data;

@Data
public class InitialCuboidData {
    private final Point3D initPoint;
    private final int height;
    private final int width;
    private final int depth;
}
