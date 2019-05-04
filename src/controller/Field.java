package controller;

import view.Label;
import view.MainFrame;
import view.Spanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static controller.Snake.snake;

public class Field extends Canvas {
        private static int canvasWidth = 600, canvasHeight=466;
        protected static Field canvas = new Field(canvasWidth,canvasHeight);
        public static char lastKeyTyped='d';
        private static byte lives = 3;
        private static byte indexOfLivesIcon = 1;


    public Field(int x, int y) {
            canvasHeight = y;
            canvasWidth = x;
        }


    static {
        snake.add(new Movement());
        snake.add(new Movement(snake.get(snake.size()-1).getX()-15, snake.get(snake.size()-1).getY()));
        snake.add(new Movement(snake.get(snake.size()-1).getX()-15, snake.get(snake.size()-1).getY()));
        snake.add(new Movement(snake.get(snake.size()-1).getX()-15, snake.get(snake.size()-1).getY()));
        snake.add(new Movement(snake.get(snake.size()-1).getX()-15, snake.get(snake.size()-1).getY()));
    }

    public static void drawCanvas(){
        String message = "Snake can't move backwards";
        canvas.addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            switch (e.getKeyChar()) {
                case 'w': {
                    if (MoverTimer.lastMovement != 's') {
                        Label.getCenterLabel().setText("");
                        lastKeyTyped = 'w';
                    } else {
                        Label.getCenterLabel().setText(message);
                    }
                    break;
                }
                case 's': {
                    if (MoverTimer.lastMovement != 'w') {
                        Label.getCenterLabel().setText("");
                        lastKeyTyped = 's';
                    } else {
                        Label.getCenterLabel().setText(message);
                    }
                    break;
                }
                case 'a': {
                    if (MoverTimer.lastMovement != 'd' && snake.get(0).getY()!=420) { //!=420 is necessary in order to prevent the snake to stay inbetween the walls
                        Label.getCenterLabel().setText("");
                        lastKeyTyped = 'a';
                    } else {
                        Label.getCenterLabel().setText(message);
                    }
                    break;
                }
                case 'd': {
                    if (MoverTimer.lastMovement != 'a' && snake.get(0).getY()!=420) {
                        Label.getCenterLabel().setText("");
                        lastKeyTyped = 'd';
                    } else {
                        Label.getCenterLabel().setText(message);
                    }
                    break;
                }
                default:
                    break;
            }
                ifLost();

        }
        @Override
        public void keyPressed(KeyEvent e) {
        }
        @Override
        public void keyReleased(KeyEvent e) {
        }
    });
}

    public void paint(Graphics graphics) {
        //painting the bonus
        graphics.setColor(Color.GREEN);
        graphics.fillRoundRect(Bonus.getB().getX(), Bonus.getB().getY(), 15, 15, 10, 10);

        //painting the snake
        graphics.setColor(Color.black);
        for (int i = 0; i < snake.size(); i++) {
            graphics.fillRoundRect(snake.get(i).getX(), snake.get(i).getY(), snake.get(i).getWidth(), snake.get(i).getHeight(), 7, 7);
        }

        //painting the border
        graphics.setColor(Color.white);
        graphics.draw3DRect(1,1,canvas.getWidth()-2, canvas.getHeight()-2, true);

    }

    public Canvas getCanvas() {
        return canvas;
    }

    private static void paintHead(Graphics g, String color){
        if(color.equals("red"))
            g.setColor(Color.red);
        else
            g.setColor(Color.black);
        g.fillRoundRect(snake.get(0).getX(), snake.get(0).getY(), snake.get(0).getWidth(), snake.get(0).getHeight(), 2, 8);
    }

    public static boolean ifLost() {
        for (int i = 1; i < snake.size(); i++) {
            if (snake.get(0).getX() == snake.get(i).getX() && snake.get(0).getY() == snake.get(i).getY()) {
                try {
                    if (lives == 1) {
                        paintHead(canvas.getGraphics(), "red");
                        Thread.sleep(400);
                        paintHead(canvas.getGraphics(), "black");
                        Thread.sleep(400);
                        paintHead(canvas.getGraphics(), "red");
                        Thread.sleep(400);
                        paintHead(canvas.getGraphics(), "black");
                        Thread.sleep(400);
                        paintHead(canvas.getGraphics(), "red");
                        JOptionPane.showMessageDialog(MainFrame.frame, "Your snake ate itself :(\nYour score was " + Label.getScore(), "Game Over", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(Label.class.getResource("Snake40.png")));
                        System.exit(0);
                    }

                    paintHead(canvas.getGraphics(), "red");
                    Thread.sleep(400);
                    paintHead(canvas.getGraphics(), "black");
                    Thread.sleep(400);
                    paintHead(canvas.getGraphics(), "red");
                    Thread.sleep(400);
                    paintHead(canvas.getGraphics(), "black");
                    Spanel.getLivesPanel().getComponent(indexOfLivesIcon++).setVisible(false);
                    lives--;
                    snakePositionUpdate();
                    frameUpdate();
                    break;
                } catch (InterruptedException exc) {
                    System.out.println("Interrupted exception" + exc);
                    Thread.currentThread().interrupt();
                }
            }
        }
        return false;
    }

    private static void snakePositionUpdate() {
        switch(MoverTimer.lastMovement) {
            case 'w': {
                for (int i = 0; i < snake.size(); i++) {
                    snake.get(i).setY(snake.get(i).getY()+45);
                }
                break;
            }
            case 'a': {
                for (int i = 0; i < snake.size(); i++) {
                    snake.get(i).setX(snake.get(i).getX()+45);
                }
                break;
            }
            case 's': {
                for (int i = 0; i < snake.size(); i++) {
                    snake.get(i).setY(snake.get(i).getY()-45);
                }
                break;
            }
            case 'd': {
                for (int i = 0; i < snake.size(); i++) {
                    snake.get(i).setX(snake.get(i).getX()-45);
                }
                break;
            }
        }
    }

    private static void frameUpdate() {
        MainFrame.frame.getContentPane().invalidate();
        MainFrame.frame.getContentPane().validate();
    }
}
