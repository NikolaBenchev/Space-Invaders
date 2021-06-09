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
        if(x < 0 || x > Main.WINDOW_WIDTH - Main.SIZE)
            return;
        this.x = x;
    }

    public void setY(int y) {
        if(y < -Main.SIZE || y > Main.WINDOW_HEIGHT)
            return;
        this.y = y;
    }
}
