package gui.buttons;

import algorithms.Vectors;
import gui.panels.CanvasPanel;
import structures.Cuboid;

import java.util.ArrayList;
import java.util.List;

public class ActionButtons {
    ArrayList<Button> transformationButtons = new ArrayList<Button>();

    VectorTransformationButton moveLeftButton = null;
    VectorTransformationButton moveRightButton = null;
    VectorTransformationButton moveUpButton = null;
    VectorTransformationButton moveDownButton = null;
    VectorTransformationButton rotateXButton = null;
    VectorTransformationButton rotateMinusXButton = null;
    VectorTransformationButton rotateYButton = null;
    VectorTransformationButton rotateMinusYButton = null;
    VectorTransformationButton rotateZButton = null;
    VectorTransformationButton rotateMinusZButton = null;
    VectorTransformationButton moveForward = null;
    VectorTransformationButton moveBackward = null;

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
        transformationButtons.add(moveForward);
        transformationButtons.add(moveBackward);

        return transformationButtons;
    }
}
