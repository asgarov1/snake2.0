package model;

import controller.MoverTimer;
import view.MainFrame;
import java.util.Timer;

public class Main {
    private static Timer timer = new Timer(true);

    public static void main(String[] args) {
        new MainFrame();

        MoverTimer moverTimer = new MoverTimer();
        timer.scheduleAtFixedRate(moverTimer, 0,220);
    }
}
