/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.invaders;

/**
 *
 * @author kolio
 */
public class Bullet{
    
    public void move(){
        this.y += this.speed;
        if(collides(this, enemy))
            player.score += enemy.score;
        
    }
}
