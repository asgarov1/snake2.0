package view;

import controller.Field;
import model.Bonus;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    public static JFrame frame;
    private static int width, height;

    public MainFrame() {
        width=600;
        height=466;

        createView();
        createField();



        updateFrame();
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
    }

    private static void createField() {
        Field field = new Field(width, height);
        frame.add(field.getCanvas());
        field.getCanvas().update(field.getCanvas().getGraphics());

        field.drawCanvas();
    }

    public void updateFrame() {
        MainFrame.frame.invalidate();
        MainFrame.frame.validate();
    }

}
