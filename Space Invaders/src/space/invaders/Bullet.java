package space.invaders;

public class Bullet extends Unit{

    Bullet(Position position, int hp, int speed, String name){
        super(position, hp, speed, name);
        setSpeed(speed);
    }
}
