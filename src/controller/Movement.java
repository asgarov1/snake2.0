package controller;

public class Movement {
    private int x, y;
    private int width, height;

    Movement() {
        x=y=150;
        width=height=15;
    }

    Movement(int x, int y) {
        this.x=x;
        this.y=y;
        width=height=15;
    }

    Movement(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    Movement(Movement movement) {
        this.x = movement.getX();
        this.y = movement.getY();
        this.width = movement.getWidth();
        this.height = movement.getHeight();
    }

    public void moveUp(int max){
        this.y-=15;

        if(y<-15)
            this.y=max;
    }
    public void moveDown(int max){
        if(y>=max)
            this.y=0;
        else
            this.y+=15;
    }
    public void moveLeft(int max){
        if(x<=0)
            this.x=max-width;
        else
            this.x-=15;

    }
    public void moveRight(int max){
        if(x>=max-width)
            this.x=0;
        else
            this.x+=15;

    }

    protected int getX() {
        return x;

    }

    protected int getY() {
        return y;
    }

    protected int getHeight() {
        return height;
    }

    protected int getWidth() {
        return width;
    }

    public void setWidth (int width) { this.width = width; }
    public void setHeight (int height) { this.height = height; }

    protected void setX(int x) {
        this.x = x;
    }

    protected void setY(int y) {
        this.y = y;
    }
}

