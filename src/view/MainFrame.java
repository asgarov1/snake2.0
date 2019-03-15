package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    public static JFrame frame = new JFrame("My Snake");


    public MainFrame () {
        createView();
    }

    private static void createView() {
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 466);
        frame.setLocationRelativeTo(null);
    }
}
