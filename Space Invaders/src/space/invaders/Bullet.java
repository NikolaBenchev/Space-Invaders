package space.invaders;

public class Bullet extends Unit{
    private int speed;

    Bullet(Position position, int speed){
        super(position, 0);
        setSpeed(speed);
    }

    public void setSpeed(int value){
        this.speed = value;
    }

    public int getSpeed(){
        return this.speed;
    }

    public void move() {
        Position newPos = this.getPosition();
        newPos.setY(newPos.getY() + this.speed);

        this.setPosition(newPos);
    }
}
