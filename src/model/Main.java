package model;

import controller.MoverTimer;
import view.MainFrame;

import java.util.Timer;

public class Main {
    public static Timer timer = new Timer(true);

    public static void main(String[] args) {
	// write your code here

        new MainFrame();

        MoverTimer moverTimer = new MoverTimer();
        timer.scheduleAtFixedRate(moverTimer, 0,200);


    }

    public static Timer getTimer() {
        return timer;
    }
}