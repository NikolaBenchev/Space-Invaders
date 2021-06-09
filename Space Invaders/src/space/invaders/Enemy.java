package com.company;

public class Enemy extends Unit{
    private int score;
    Enemy(Position position, int hp, int speed, int score, String name){
        super(position, hp, speed, name);
        this.setScore(score);
    }

    public void setScore(int value){
        this.score = value;
    }

    public int getScore(){
        return this.score;
    }

    public Bullet shoot(){
        Bullet bullet = new Bullet(this.getPosition(), 5, 100, "enemyBullet");
        return bullet;
    }
}
