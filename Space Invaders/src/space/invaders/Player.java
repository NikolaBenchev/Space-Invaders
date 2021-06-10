package space.invaders;

import java.awt.Graphics;

public class Player extends Unit{
    private int score;
    private float currentAttackTime;   
    private float attackSpeed = 0.5f;
    private boolean movingLeft = false;
    private boolean movingRight = false;

    public boolean isMovingLeft() {
        return movingLeft;
    }

    public void setMovingLeft(boolean movingLeft) {
        this.movingLeft = movingLeft;
    }

    public boolean isMovingRight() {
        return movingRight;
    }

    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }
    
    Player(Position position, int Hp, int speed, String name, int size){
        super(position, Hp, speed, name, size);
        this.score = 0;
        this.currentAttackTime = 0.5f;
    }   
    
    public Bullet shoot(){
        Bullet bullet = new Bullet(this.getPosition(), 1, -8, "playerBullet", Main.SIZE);
        return bullet;
    }
    
    public void addScore(int value){
        this.score += value;
    }
    
    public int getScore(){
        return score;
    }
    
    public float getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(float attackSpeed) {
        this.attackSpeed = attackSpeed;
    }
    
    public float getCurrentAttackTime() {
        return this.currentAttackTime;
    }

    public void addToCurrentAttackTime(float value){
        this.currentAttackTime += value;
    }
    
    public void setCurrentAttackTime(float value) {
        this.currentAttackTime = value;
    }
}