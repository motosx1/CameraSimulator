package gui.buttons;

import algorithms.Vectors;
import gui.panels.CanvasPanel;
import structures.Cuboid;

import java.util.ArrayList;
import java.util.List;

public class ActionButtons {
    ArrayList<TransformationButton> transformationButtons = new ArrayList<TransformationButton>();

    TransformationButton moveLeftButton = null;
    TransformationButton moveRightButton = null;
    TransformationButton moveUpButton = null;
    TransformationButton moveDownButton = null;
    TransformationButton rotateXButton = null;
    TransformationButton rotateMinusXButton = null;
    TransformationButton rotateYButton = null;
    TransformationButton rotateMinusYButton = null;
    TransformationButton rotateZButton = null;
    TransformationButton rotateMinusZButton = null;

    public ActionButtons(CanvasPanel canvas, List<Cuboid> cuboids) {
        this.moveLeftButton = new TransformationButton(canvas, cuboids, Vectors.getTranslationLeft(), " LEFT ");
        this.moveRightButton = new TransformationButton(canvas, cuboids, Vectors.getTranslationRight(), " RIGHT ");
        this.moveUpButton = new TransformationButton(canvas, cuboids, Vectors.getTranslationUp(), " UP ");
        this.moveDownButton = new TransformationButton(canvas, cuboids, Vectors.getTranslationDown(), " DOWN ");
        this.rotateXButton = new TransformationButton(canvas, cuboids, Vectors.getRotateX(), " ROTATE X ");
        this.rotateMinusXButton = new TransformationButton(canvas, cuboids, Vectors.getRotateMinusX(), " ROTATE -X ");
        this.rotateYButton = new TransformationButton(canvas, cuboids, Vectors.getRotateY(), " ROTATE Y ");
        this.rotateMinusYButton = new TransformationButton(canvas, cuboids, Vectors.getRotateMinusY(), " ROTATE -Y ");
        this.rotateZButton = new TransformationButton(canvas, cuboids, Vectors.getRotateZ(), " ROTATE Z ");
        this.rotateMinusZButton = new TransformationButton(canvas, cuboids, Vectors.getRotateMinusZ(), " ROTATE -Z ");
    }

    public List<TransformationButton> getAllTransformationButtons(){
        transformationButtons.add(moveLeftButton);
        transformationButtons.add(moveRightButton);
        transformationButtons.add(moveUpButton);
        transformationButtons.add(moveDownButton);
        transformationButtons.add(rotateXButton);
        transformationButtons.add(rotateMinusXButton);
        transformationButtons.add(rotateYButton);
        transformationButtons.add(rotateMinusYButton);

        return transformationButtons;
    }
}
