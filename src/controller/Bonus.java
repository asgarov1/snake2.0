package controller;

import view.Label;
import java.util.Random;
import static controller.Snake.snake;

class Bonus {
    private int x;
    private int y;
    private boolean isEaten;
    private static Bonus b = new Bonus(600, 466);

    Bonus(int width, int height) {
        generateRandomPos(width, height);
        this.isEaten = false;
    }

    private void generateRandomPos(int width, int height) {
        this.x = new Random().nextInt(((width - 40) / 15));
        this.x *= 15;
        this.y = new Random().nextInt(((height - 40) / 15));
        this.y *= 15;
    }

    int getY() {
        return y;
    }

    int getX() {
        return x;
    }

    boolean isEaten() {
        return isEaten;
    }

    private void setEaten() {
        isEaten = true;
    }

    static Bonus getB() {
        return b;
    }

    static void setB(Bonus b) {
        Bonus.b = b;
    }

    static void ifEaten(char x) {
        if (b.getX() == (snake.get(0).getX()) && b.getY() == (snake.get(0).getY())) {
            b.setEaten();
            Field.canvas.update(Field.canvas.getGraphics());
            Label.setScore(Label.getScore() + 1);
            switch (x) {
                case 'w':
                    snake.add(new Movement(snake.get(snake.size() - 1).getX(), snake.get(snake.size() - 1).getY() - 15));
                    break;
                case 'a':
                    snake.add(new Movement(snake.get(snake.size() - 1).getX(), snake.get(snake.size() - 1).getY() + 15));
                    break;
                case 's':
                    snake.add(new Movement(snake.get(snake.size() - 1).getX() + 15, snake.get(snake.size() - 1).getY()));
                    break;
                case 'd':
                    snake.add(new Movement(snake.get(snake.size() - 1).getX() - 15, snake.get(snake.size() - 1).getY()));
                    break;
                default:
            }
        }
    }
}
