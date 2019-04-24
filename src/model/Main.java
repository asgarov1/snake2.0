package model;

import controller.MoverTimer;
import view.MainFrame;

import java.util.Timer;

public class Main {
    //BUGS
    //When eating itself - timer jump
    //There is a layer between walls where snake can move - update the borders

    public static Timer timer = new Timer(true);

    public static void main(String[] args) {
	// write your code here
        new MainFrame();

        MoverTimer moverTimer = new MoverTimer();
        timer.scheduleAtFixedRate(moverTimer, 0,200);
    }
}
