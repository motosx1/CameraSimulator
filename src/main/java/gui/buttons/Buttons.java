package gui.buttons;

import gui.panels.CanvasPanel;
import lombok.Getter;
import structures.Cuboid;

public class Buttons {
    @Getter
    MoveLeftButton moveLeftButton = null;

    public Buttons(CanvasPanel canvas, Cuboid cuboid) {
        this.moveLeftButton = new MoveLeftButton(canvas, cuboid);
    }
}
