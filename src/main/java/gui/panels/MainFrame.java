package gui.panels;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{

    public static final int FRAME_WIDTH = 1200;
    public static final int FRAME_HEIGHT = 800;

    public MainFrame() {
        super("Camera Simulator v1");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setUpFrame();
        addCanvas();
        addButtons();

        pack();
        setVisible(true);
    }

    private void addCanvas() {
        CanvasPanel canvas = new CanvasPanel(FRAME_WIDTH,FRAME_HEIGHT-100);
        add(canvas);
    }

    private void setUpFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setLocation(((int)screenSize.getWidth() - FRAME_WIDTH)/2,100);
        setLayout(new FlowLayout());
    }

    private void addButtons() {
        add(new JButton("Przycisk 1"));
        add(new JButton("Przycisk 2"));
        add(new JButton("Przycisk 3"));
    }
}
