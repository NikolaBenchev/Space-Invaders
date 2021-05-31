package space.invaders;

public abstract class Unit {
    private Position position;
    private int hp;

    Unit(Position position, int hp){
        setPosition(position);
        setHp(hp);
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
    
    public boolean collide(Unit unit){
        return (this.getPosition().getX() == unit.getPosition().getX() && 
                this.getPosition().getY() == unit.getPosition().getY());
    }
    
}
