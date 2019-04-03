import controller.MoverTimer;
import view.MainFrame;

import java.util.Timer;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Timer timer = new Timer(true);
        new MainFrame();

        MoverTimer moverTimer = new MoverTimer();
        timer.scheduleAtFixedRate(moverTimer, 0,200);


    }
}
