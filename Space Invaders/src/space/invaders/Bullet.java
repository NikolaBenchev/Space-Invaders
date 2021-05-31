package space.invaders;

public class Bullet extends Unit{

    Bullet(Position position, int hp, int speed){
        super(position, hp, speed);
        setSpeed(speed);
    }
}
