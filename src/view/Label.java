package view;

import javax.swing.*;

public class Label extends JLabel {
    private static JLabel scoreLabel;
    private static JLabel centerLabel;
    private static int score;

    static {
        scoreLabel = new JLabel();
        scoreLabel.setText("  Score: " + score);
        centerLabel = new JLabel();
        centerLabel.setText("");
    }

    public static void setScore(int score) {
        Label.score = score;
        scoreLabel.setText("  Score: " + score);
    }

    public static int getScore() {
        return score;
    }

    static JLabel getScoreLabel() {
        return scoreLabel;
    }

    public static JLabel getCenterLabel() {
        return centerLabel;
    }

    public static void setCenterLabel(JLabel centerLabel) {
        Label.centerLabel = centerLabel;
    }


}
