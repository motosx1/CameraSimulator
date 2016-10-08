package gui.buttons;

import algorithms.Vectors;
import gui.panels.CanvasPanel;
import lombok.Getter;
import structures.Cuboid;

public class ActionButtons {
    @Getter
    TransformationButton moveLeftButton = null;
    @Getter
    TransformationButton moveRightButton = null;
    @Getter
    TransformationButton moveUpButton = null;
    @Getter
    TransformationButton moveDownButton = null;

    public ActionButtons(CanvasPanel canvas, Cuboid cuboid) {
        this.moveLeftButton = new TransformationButton(canvas, cuboid, Vectors.TRANSLATION_LEFT, " LEFT ");
        this.moveRightButton = new TransformationButton(canvas, cuboid, Vectors.TRANSLATION_RIGHT, " RIGHT ");
        this.moveUpButton = new TransformationButton(canvas, cuboid, Vectors.TRANSLATION_UP, " UP ");
        this.moveDownButton = new TransformationButton(canvas, cuboid, Vectors.TRANSLATION_DOWN, " DOWN ");
    }
}
