package gui.panels;

import gui.buttons.ActionButtons;
import gui.buttons.TransformationButton;
import structures.Cuboid;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{

    public static final int FRAME_WIDTH = 1200;
    public static final int FRAME_HEIGHT = 800;
    public static final int BUTTONS_PANEL_WIDTH = 150;

    transient Cuboid cuboid = null;
    CanvasPanel canvas = null;

    public MainFrame(Cuboid cuboid) {
        super("Camera Simulator v1");
        this.cuboid = cuboid;
        this.canvas = new CanvasPanel(cuboid);

        setUpFrame();
        addCanvas();
        addButtonsPanel();

        pack();
        setVisible(true);
    }

    private void addButtonsPanel() {
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setPreferredSize(new Dimension(BUTTONS_PANEL_WIDTH, (int)buttonsPanel.getPreferredSize().getHeight()));
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.PAGE_AXIS));
        addButtons(buttonsPanel);

        add(buttonsPanel, BorderLayout.EAST);
    }

    private void addCanvas() {
        add(canvas,BorderLayout.CENTER);
    }

    private void setUpFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setLocation(((int)screenSize.getWidth() - FRAME_WIDTH)/2,100);
        setLayout(new BorderLayout());
    }

    private void addButtons(JPanel buttonsPanel) {
        ActionButtons actionButtons = new ActionButtons(canvas, cuboid);
        for (TransformationButton button : actionButtons.getAllTransformationButtons()) {
            buttonsPanel.add(button);
        }

    }

    public static Dimension getCanvasPanelSize(){
        return new Dimension(FRAME_WIDTH-BUTTONS_PANEL_WIDTH, FRAME_HEIGHT);
    }
}
