package space.invaders;

import java.awt.Graphics;

public class Player extends Unit{
    private int score;
    private float attackSpeed = 0.5f;
    
    Player(Position position, int Hp, int speed, String name){
        super(position, Hp, speed, name);
        this.score = 0;
    }

    public float getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(float attackSpeed) {
        this.attackSpeed = attackSpeed;
    }
    
    public void addScore(int value){
        this.score += value;
    }
    
    public int getScore(){
        return score;
    }
    
    public Bullet shoot(){
        Bullet bullet = new Bullet(this.getPosition(), 1, -8, "playerBullet");
        return bullet;
    }
}