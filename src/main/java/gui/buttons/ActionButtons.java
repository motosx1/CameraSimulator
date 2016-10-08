package gui.buttons;

import algorithms.Vectors;
import gui.panels.CanvasPanel;
import lombok.Getter;
import structures.Cuboid;

public class ActionButtons {
    @Getter
    TransformationButton moveLeftButton = null;

    public ActionButtons(CanvasPanel canvas, Cuboid cuboid) {
        this.moveLeftButton = new TransformationButton(canvas, cuboid, Vectors.TRANSLATION_LEFT, " LEFT ");
    }
}
