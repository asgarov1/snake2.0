package controller;

import view.Label;
import view.MainFrame;
import java.util.Random;
import static controller.Field.snake;

public class Bonus {
    private int x;
    private int y;
    private boolean isEaten;
    private static Bonus b = new Bonus(600, 466);

    public Bonus(int width, int height){
        generateRandomPos(width, height);
        this.isEaten = false;
    }

    public void generateRandomPos(int width, int height){
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

    public static Bonus getB() {
        return b;
    }

    public static void setB(Bonus b) {
        Bonus.b = b;
    }

    public static void ifEaten(char x) {
        for (int i = 0; i < snake.size(); i++) {

            if(b.getX()==(snake.get(0).getX()) && b.getY()==(snake.get(0).getY())) {
                b.setEaten();
                MainFrame.frame.invalidate();
                MainFrame.frame.validate();
                Label.setScore(Label.getScore()+1);
                switch(x){
                    case 'w':
                        snake.add(new Movement(snake.get(snake.size()-1).getX(), snake.get(snake.size()-1).getY()-15));
                        break;
                    case 'a':
                        snake.add(new Movement(snake.get(snake.size()-1).getX(), snake.get(snake.size()-1).getY()+15));
                        break;
                    case 's':
                        snake.add(new Movement(snake.get(snake.size()-1).getX()+15, snake.get(snake.size()-1).getY()));
                        break;
                    case 'd':
                        snake.add(new Movement(snake.get(snake.size()-1).getX()-15, snake.get(snake.size()-1).getY()));
                        break;
                }
                break;
            }
        }
    }
}