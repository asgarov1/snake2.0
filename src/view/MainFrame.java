package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainFrame {
    public static JFrame frame;
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



    private void createView() {
        frame = new JFrame("My Snake");
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);

        Spanel panelControl = new Spanel();

        panelControl.getTopPanel().add(panelControl.getLivesPanel(), BorderLayout.EAST);
        panelControl.getTopPanel().add(Label.getScoreLabel(), BorderLayout.WEST);
        frame.add(panelControl.getTopPanel(), BorderLayout.NORTH);
        updateFrame();
    }

    private static void createField() {

    }

    public void updateFrame() {
        MainFrame.frame.invalidate();
        MainFrame.frame.validate();
    }

}
