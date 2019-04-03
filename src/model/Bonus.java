package model;

import java.util.Random;

public class Bonus {
    private int x;
    private int y;
    private boolean isEaten;

    public Bonus(int width, int height){
        generateRandomPos(width, height);
        this.isEaten = false;
    }

    public void generateRandomPos(int width, int height){
        System.out.println(width + " " + height);
        this.x = new Random().nextInt(((width-40)/15));
        this.x *= 15;
        this.y = new Random().nextInt(((height-40)/15));
        this.y *= 15;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public boolean isEaten() { return isEaten; }

    public void setEaten() {
        isEaten = true;
    }

}
