package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private static JFrame frame;
    private static int width, height;

    public MainFrame() {
        width=600;
        height=466;
        createView();
    }

    public MainFrame(int x, int y) {
        width=x;
        height=y;
        createView();
    }



    private static void createView() {
        frame = new JFrame("My Snake");
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);

        Panel panelControl = new Panel();
        frame.add(panelControl.getTopPanel());

        createField();
        frame.update(frame.getGraphics());
    }

    private static void createField() {
        Field canvas = new Field(width, height);
        canvas.paint(frame.getGraphics());
        frame.add(canvas);
    }
}
