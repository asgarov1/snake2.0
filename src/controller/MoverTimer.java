package controller;

import java.util.TimerTask;

public class MoverTimer extends TimerTask {
    public static char lastMovement = Field.lastKeyTyped;

    @Override
    public void run() {
        Bonus.ifEaten(Field.lastKeyTyped);
        if(Bonus.getB().isEaten()) {
            Bonus.setB(new Bonus(Field.canvas.getWidth(), Field.canvas.getHeight()));

        }
        switch (Field.lastKeyTyped) {
            case 'w':
                for (int i = Snake.snake.size() - 1; i > 0; i--) {
                    Snake.snake.get(i).setX(Snake.snake.get(i - 1).getX());
                    Snake.snake.get(i).setY(Snake.snake.get(i - 1).getY());
                }
                Snake.snake.get(0).moveUp(Field.canvas.getHeight());
                lastMovement='w';
                break;
            case 's':
                for (int i = Snake.snake.size() - 1; i > 0; i--) {
                    Snake.snake.get(i).setX(Snake.snake.get(i - 1).getX());
                    Snake.snake.get(i).setY(Snake.snake.get(i - 1).getY());
                }
                Snake.snake.get(0).moveDown(Field.canvas.getHeight());
                lastMovement='s';
                break;
            case 'a':
                    for (int i = Snake.snake.size() - 1; i > 0; i--) {
                        Snake.snake.get(i).setX(Snake.snake.get(i - 1).getX());
                        Snake.snake.get(i).setY(Snake.snake.get(i - 1).getY());
                    }
                    Snake.snake.get(0).moveLeft(Field.canvas.getWidth());
                    lastMovement = 'a';
                break;
            case 'd':
                    for (int i = Snake.snake.size() - 1; i > 0; i--) {
                        Snake.snake.get(i).setX(Snake.snake.get(i - 1).getX());
                        Snake.snake.get(i).setY(Snake.snake.get(i - 1).getY());
                    }
                    Snake.snake.get(0).moveRight(Field.canvas.getWidth());
                    lastMovement = 'd';
                break;
            default:
        }
        Field.canvas.update(Field.canvas.getGraphics());
        Field.ifLost();
    }
}
