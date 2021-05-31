package space.invaders;

import java.awt.Graphics;

public class Player extends Unit{
    private int score;
    
    Player(Position position, int Hp, int speed){
        super(position, Hp, speed);
        this.score = 0;
    }
    
    public void addScore(int value){
        this.score += value;
    }
    
    public int getScore(){
        return score;
    }
    
    public void draw(Graphics g){
        g.drawRect(this.getPosition().getX(), this.getPosition().getY(), Main.SIZE, Main.SIZE);
    }
}