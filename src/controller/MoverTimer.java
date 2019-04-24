package controller;

import java.util.TimerTask;

public class MoverTimer extends TimerTask {
    @Override
    public void run() {
        Bonus.ifEaten(Field.lastKeyTyped);
        if(Bonus.getB().isEaten()) {
            Bonus.setB(new Bonus(Field.canvas.getWidth(), Field.canvas.getHeight()));

        }
        switch (Field.lastKeyTyped) {
            case 'w':
                for (int i = Field.snake.size() - 1; i > 0; i--) {
                    Field.snake.get(i).setX(Field.snake.get(i - 1).getX());
                    Field.snake.get(i).setY(Field.snake.get(i - 1).getY());
                }
                Field.snake.get(0).moveUp(Field.canvas.getHeight());
                break;
            case 's':
                for (int i = Field.snake.size() - 1; i > 0; i--) {
                    Field.snake.get(i).setX(Field.snake.get(i - 1).getX());
                    Field.snake.get(i).setY(Field.snake.get(i - 1).getY());
                }
                Field.snake.get(0).moveDown(Field.canvas.getHeight());
                break;
            case 'a':
                for (int i = Field.snake.size() - 1; i > 0; i--) {
                    Field.snake.get(i).setX(Field.snake.get(i - 1).getX());
                    Field.snake.get(i).setY(Field.snake.get(i - 1).getY());
                }
                Field.snake.get(0).moveLeft(Field.canvas.getWidth());
                break;
            case 'd':
                for (int i = Field.snake.size() - 1; i > 0; i--) {
                    Field.snake.get(i).setX(Field.snake.get(i - 1).getX());
                    Field.snake.get(i).setY(Field.snake.get(i - 1).getY());
                }
                Field.snake.get(0).moveRight(Field.canvas.getWidth());
                break;
            default:
        }
        Field.canvas.update(Field.canvas.getGraphics());
        Field.ifLost();
    }
}
