package com.company;

public abstract class Unit {
    private Position position;
    private int hp;

    Unit(Position position, int hp){
        setPosition(position);
        setHp(hp);
    }
    
    public void setPosition(Position value){
        this.position.x = value.x;
        this.position.y = value.y;
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
    
}
