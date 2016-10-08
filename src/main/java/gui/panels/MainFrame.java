package gui.panels;

import gui.buttons.Buttons;
import gui.buttons.MoveLeftButton;
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
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setLocation(((int)screenSize.getWidth() - FRAME_WIDTH)/2,100);
        setLayout(new BorderLayout());
    }

    private void addButtons(JPanel buttonsPanel) {
        Buttons buttons = new Buttons(canvas, cuboid);
        MoveLeftButton moveLeftButton = buttons.getMoveLeftButton();

        JButton button2 = new JButton("Przycisk 2");
        JButton button3 = new JButton("Przycisk 3");
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        button3.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonsPanel.add(moveLeftButton);
        buttonsPanel.add(button2);
        buttonsPanel.add(button3);
    }

    public static Dimension getCanvasPanelSize(){
        return new Dimension(FRAME_WIDTH-BUTTONS_PANEL_WIDTH, FRAME_HEIGHT);
    }
}
