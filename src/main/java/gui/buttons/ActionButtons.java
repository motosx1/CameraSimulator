package gui.buttons;

import algorithms.Vectors;
import gui.panels.CanvasPanel;
import structures.Cuboid;

import java.util.ArrayList;
import java.util.List;

public class ActionButtons {
    private ArrayList<Button> transformationButtons = new ArrayList<Button>();

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
        this.moveLeftButton = new VectorTransformationButton(canvas, cuboids, Vectors.getTranslationLeft(), " LEFT ");
        this.moveRightButton = new VectorTransformationButton(canvas, cuboids, Vectors.getTranslationRight(), " RIGHT ");
        this.moveUpButton = new VectorTransformationButton(canvas, cuboids, Vectors.getTranslationUp(), " UP ");
        this.moveDownButton = new VectorTransformationButton(canvas, cuboids, Vectors.getTranslationDown(), " DOWN ");
        this.rotateXButton = new VectorTransformationButton(canvas, cuboids, Vectors.getRotateX(), " ROTATE X ");
        this.rotateMinusXButton = new VectorTransformationButton(canvas, cuboids, Vectors.getRotateMinusX(), " ROTATE -X ");
        this.rotateYButton = new VectorTransformationButton(canvas, cuboids, Vectors.getRotateY(), " ROTATE Y ");
        this.rotateMinusYButton = new VectorTransformationButton(canvas, cuboids, Vectors.getRotateMinusY(), " ROTATE -Y ");
        this.rotateZButton = new VectorTransformationButton(canvas, cuboids, Vectors.getRotateZ(), " ROTATE Z ");
        this.rotateMinusZButton = new VectorTransformationButton(canvas, cuboids, Vectors.getRotateMinusZ(), " ROTATE -Z ");
        this.moveForward = new VectorTransformationButton(canvas, cuboids, Vectors.getTranslationForward(), " FORWARD ");
        this.moveBackward = new VectorTransformationButton(canvas, cuboids, Vectors.getTranslationBackward(), " BACKWARD ");
        this.zoomIn = new ViewerDistanceButton(canvas, cuboids, Vectors.getZoomInStep(), " ZOOM IN ");
        this.zoomOut = new ViewerDistanceButton(canvas, cuboids, Vectors.getZoomOutStep(), " ZOOM OUT ");
    }

    public List<Button> getAllTransformationButtons(){
        transformationButtons.add(moveLeftButton);
        transformationButtons.add(moveRightButton);
        transformationButtons.add(moveUpButton);
        transformationButtons.add(moveDownButton);
        transformationButtons.add(rotateXButton);
        transformationButtons.add(rotateMinusXButton);
        transformationButtons.add(rotateYButton);
        transformationButtons.add(rotateMinusYButton);
        transformationButtons.add(rotateZButton);
        transformationButtons.add(rotateMinusZButton);
        transformationButtons.add(moveForward);
        transformationButtons.add(moveBackward);
        transformationButtons.add(zoomIn);
        transformationButtons.add(zoomOut);

        return transformationButtons;
    }
}
