package space.invaders;

import java.util.Random;

public class Enemy extends Unit{
    private int score;
    private float moveTime = 2.5f;
    private float currentMoveTime = 0;

    Enemy(Position position, int hp, int speed, int score, String name){
        super(position, hp, speed, name);
        this.setScore(score);
        
        Random random = new Random();
        moveTime += random.nextFloat() / 2;
    }

    public void setScore(int value){
        this.score = value;
    }

    public int getScore(){
        return this.score;
    }

    public Bullet shoot(){
        Bullet bullet = new Bullet(this.getPosition(), 1, 8, "enemyBullet");
        return bullet;
    }

    public float getMoveTime() {
        return moveTime;
    }

    public void setMoveTime(float moveTime) {
        this.moveTime = moveTime;
    }

    public float getCurrentMoveTime() {
        return currentMoveTime;
    }

    public void setCurrentMoveTime(float currentMoveTime) {
        this.currentMoveTime = currentMoveTime;
    }
    
    
    
}
