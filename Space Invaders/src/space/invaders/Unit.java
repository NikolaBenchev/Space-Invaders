package space.invaders;

public abstract class Unit {
    private Position position;
    private int hp;
    private int speed;

    Unit(Position position, int hp, int speed){
        this.position = new Position(position.getX(), position.getY());
        setHp(hp);
        setSpeed(speed);
    }
    
    public void setPosition(Position value){
        this.position.setX(value.getX());
        this.position.setY(value.getY());
    }

    public Position getPosition(){
        return this.position;
    }
    
    public void lowerHp(){
        this.hp -= 1;
    }

    public void setHp(int value){
        this.hp = value;
    }

    public int getHp(){
        return this.hp;
    }
    
    public void setSpeed(int value){
        this.speed = value;
    }
    
    public int getSpeed(){
        return this.speed;
    }
    
    public void move(int x, int y){
        this.position.setX(this.getPosition().getX() + x * this.speed);
        this.position.setY(this.getPosition().getY() + y * this.speed);
    }
    
    public boolean collide(Unit unit){
        return (this.getPosition().getX() == unit.getPosition().getX() && 
                this.getPosition().getY() == unit.getPosition().getY());
    }
    
}
