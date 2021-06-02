package space.invaders;

public class Position {
    private int x;
    private int y;
    public Position(int x, int y){
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        if(this.x < 0 || this.x > Main.WINDOW_WIDTH)
            return;
        this.x = x;
    }

    public void setY(int y) {
        if(y < 0 || y > Main.WINDOW_HEIGHT)
        this.y = y;
    }
}
