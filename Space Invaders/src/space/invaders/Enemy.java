/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

/**
 *
 * @author kolio
 */
public class Enemy extends Unit{
    private int score;
    Enemy(Position position, int hp, int score){
        super(position, hp);
        this.setScore(score);
    }

    public void setScore(int value){
        this.score = value;
    }

    public int getScore(){
        return this.score;
    }

    public Bullet shoot(){
        Bullet bullet = new Bullet(this.getPosition(), 5);
        return bullet;
    }
}
