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
public class Bullet extends Unit{
    private int speed;

    Bullet(Position position, int speed){
        super(position, 0);
        setSpeed(speed);
    }

    public void setSpeed(int value){
        this.speed = value;
    }

    public int getSpeed(){
        return this.speed;
    }

    public void move() {
        Position newPos = this.getPosition();
        newPos.y += this.speed;

        this.setPosition(newPos);
    }
}
