package view;

import javax.swing.*;
import java.awt.*;

public class Spanel extends JPanel {
    private static JPanel topPanel = new JPanel(new BorderLayout());
    private static JPanel livesPanel;

    Spanel() {
        livesPanel = new JPanel();
        livesPanel.add(new JLabel(new ImageIcon(MainFrame.class.getResource("heart.png"))), BorderLayout.NORTH);
        livesPanel.add(new JLabel(new ImageIcon(MainFrame.class.getResource("heart.png"))), BorderLayout.NORTH);
        livesPanel.add(new JLabel(new ImageIcon(MainFrame.class.getResource("heart.png"))), BorderLayout.NORTH);
    }

    static JPanel getTopPanel() {
        return topPanel;
    }

    public static JPanel getLivesPanel() {
        return livesPanel;
    }




}
