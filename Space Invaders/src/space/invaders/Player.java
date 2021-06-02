package space.invaders;

import java.awt.Graphics;

public class Player extends Unit{
    private int score;
    
    Player(Position position, int Hp, int speed, String name){
        super(position, Hp, speed, name);
        this.score = 0;
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