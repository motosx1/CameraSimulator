package gui.buttons;

import algorithms.Vectors;
import gui.panels.CanvasPanel;
import main.Dict;
import structures.Cuboid;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ActionButtons {
    private Map<String, Button> transformationButtons = new LinkedHashMap<String, Button>();

    private ResetButton resetButton = null;
    private VectorTransformationButton moveLeftButton = null;
    private VectorTransformationButton moveRightButton = null;
    private VectorTransformationButton moveUpButton = null;
    private VectorTransformationButton moveDownButton = null;
    private VectorTransformationButton rotateXButton = null;
    private VectorTransformationButton rotateMinusXButton = null;
    private VectorTransformationButton rotateYButton = null;
    private VectorTransformationButton rotateMinusYButton = null;
    private VectorTransformationButton rotateZButton = null;
    private VectorTransformationButton rotateMinusZButton = null;
    private VectorTransformationButton moveForward = null;
    private VectorTransformationButton moveBackward = null;
    private ViewerDistanceButton zoomIn = null;
    private ViewerDistanceButton zoomOut = null;

    public ActionButtons(CanvasPanel canvas, List<Cuboid> cuboids) {
        this.resetButton = new ResetButton(canvas, cuboids);
        this.moveLeftButton = new VectorTransformationButton(canvas, cuboids, Vectors.getTranslationLeft(), " (<-) LEFT ");
        this.moveRightButton = new VectorTransformationButton(canvas, cuboids, Vectors.getTranslationRight(), " (->) RIGHT ");
        this.moveUpButton = new VectorTransformationButton(canvas, cuboids, Vectors.getTranslationUp(), " UP ");
        this.moveDownButton = new VectorTransformationButton(canvas, cuboids, Vectors.getTranslationDown(), " DOWN ");
        this.rotateXButton = new VectorTransformationButton(canvas, cuboids, Vectors.getRotateX(), " (W) ROTATE X ");
        this.rotateMinusXButton = new VectorTransformationButton(canvas, cuboids, Vectors.getRotateMinusX(), " (S) ROTATE -X ");
        this.rotateYButton = new VectorTransformationButton(canvas, cuboids, Vectors.getRotateY(), " (A) ROTATE Y ");
        this.rotateMinusYButton = new VectorTransformationButton(canvas, cuboids, Vectors.getRotateMinusY(), " (D) ROTATE -Y ");
        this.rotateZButton = new VectorTransformationButton(canvas, cuboids, Vectors.getRotateZ(), " ROTATE Z ");
        this.rotateMinusZButton = new VectorTransformationButton(canvas, cuboids, Vectors.getRotateMinusZ(), " ROTATE -Z ");
        this.moveForward = new VectorTransformationButton(canvas, cuboids, Vectors.getTranslationForward(), " (ARROW_UP) FORWARD ");
        this.moveBackward = new VectorTransformationButton(canvas, cuboids, Vectors.getTranslationBackward(), " (ARROW_DOWN) BACKWARD ");
        this.zoomIn = new ViewerDistanceButton(canvas, cuboids, Vectors.getZoomInStep(), " (Q) ZOOM IN ");
        this.zoomOut = new ViewerDistanceButton(canvas, cuboids, Vectors.getZoomOutStep(), " (E) ZOOM OUT ");
    }

    public Map<String, Button> getAllTransformationButtons(){
        transformationButtons.put(Dict.RESET, resetButton);
        transformationButtons.put(Dict.MOVE_LEFT, moveLeftButton);
        transformationButtons.put(Dict.MOVE_RIGHT, moveRightButton);
        transformationButtons.put(Dict.MOVE_UP, moveUpButton);
        transformationButtons.put(Dict.MOVE_DOWN, moveDownButton);
        transformationButtons.put(Dict.ROTATE_X, rotateXButton);
        transformationButtons.put(Dict.ROTATE_MINUSX, rotateMinusXButton);
        transformationButtons.put(Dict.ROTATE_Y, rotateYButton);
        transformationButtons.put(Dict.ROTATE_MINUSY, rotateMinusYButton);
        transformationButtons.put(Dict.ROTATE_Z, rotateZButton);
        transformationButtons.put(Dict.ROTATE_MINUSZ, rotateMinusZButton);
        transformationButtons.put(Dict.MOVE_FORWARD, moveForward);
        transformationButtons.put(Dict.MOVE_BACKWARD, moveBackward);
        transformationButtons.put(Dict.ZOOM_IN, zoomIn);
        transformationButtons.put(Dict.ZOOM_OUT, zoomOut);

        return transformationButtons;
    }
}
