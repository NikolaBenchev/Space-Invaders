package com.company;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
public class Board extends JPanel implements KeyListener, ActionListener{

    private Timer timer;
    private int delay = 3;
    private Player player = new Player(new Position(0, Main.WINDOW_HEIGHT - Main.SIZE), 3, Main.SIZE / 2, "player");
    private LinkedList<Bullet> bullets = new LinkedList<>();
    private LinkedList<Enemy> enemies = new LinkedList<>();
    private LinkedList<Shield> shields = new LinkedList<>();
    private Spawner spawner = new Spawner();
    private JLabel scoreLabel = new JLabel("0");
    
    public Board(){
        // setup the board
        setup();

        // start the timer that updates the game and add 3 shields
        timer = new Timer(delay, this);
        timer.start();
        shields.add(spawner.spawnShield());
        shields.add(spawner.spawnShield());
        shields.add(spawner.spawnShield());
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // checks for button presses (A, D, <-, ->, SPACE)
        switch(e.getKeyCode()){
            case 65: // A
            case 37:
                player.move(-1, 0);
                break;
            case 68: // D
            case 39:
                player.move(1, 0);
                break;
            case 32: // Space (shoot)
                if(player.getCurrentAttackTime() < player.getAttackSpeed())
                    break;
                Bullet newBullet = player.shoot();
                bullets.add(newBullet);
                player.setCurrentAttackTime(0f);
                break;
        } 
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    // updates the game (gets called every 3 milliseconds)
    @Override
    public void actionPerformed(ActionEvent e) {
        // add 0.005 to every timer
        player.addToCurrentAttackTime(0.005f);
        spawner.addToCurrentEnemySpawnTime(0.005f);
        spawner.addToCurrentShieldSpawnTime(0.005f);

        // spawn the enemy
        if(spawner.getCurrentEnemySpawnTime() > spawner.getSpawnEnemyTime()){
            Enemy newEnemy = spawner.spawnEnemy();
            if(newEnemy != null){
                // add the enemy to an array
                enemies.add(newEnemy);
                // reset the timer for the enemy
                spawner.setCurrentEnemySpawnTime(0);
            } else
                spawner.setCurrentEnemySpawnTime(0);                                        
        }

        // if there are no shields spawn new ones
        if (shields.size() == 0){
            if(spawner.getCurrentShieldSpawnTime() > spawner.getSpawnShieldTime()){
                Shield newShield = spawner.spawnShield();
                if(newShield != null){
                    shields.add(newShield);
                    spawner.setCurrentShieldSpawnTime(0);
                } else
                    spawner.setCurrentShieldSpawnTime(0);                                        
            }
        } else 
            spawner.setCurrentShieldSpawnTime(0);
         


        // go through all the bullets and check collision with the enemies, player and shields
        for(int i = 0; i < bullets.size(); i++){
            // move the bullets
            bullets.get(i).move(0, 1);

            // checks if the bullet has hit something already
            boolean isBulletRemoved = false;
            // if the bullets gets off the screen it gets removed
            if(bullets.get(i).getPosition().getY() < 0 || bullets.get(i).getPosition().getY() > Main.WINDOW_HEIGHT - Main.SIZE){
                bullets.remove(i);
                isBulletRemoved = true;
            }

            // if it has not been removed check collision with all the shields
            if(!isBulletRemoved){
                for (int j = 0; j < shields.size(); j++) {
                    // if a shield and a bullet collide lower the hp of the shield and removed the bullet
                    if(bullets.get(i).collide(shields.get(j))){
                        bullets.remove(i);    
                        isBulletRemoved = true;
                        
                        shields.get(j).lowerHp();
                        // if the shield has 0 hp remove the shield
                        if (shields.get(j).getHp() == 0) {
                            int index = shields.get(j).getPosition().getX() / Main.SIZE / 3;
                            spawner.freeShieldSpawnPoint(index);
                            shields.remove(j);
                        }
                        break;
                    }
                }
            }

            // if it has not been removed check collision with all the enemies
            if(!isBulletRemoved){
                for (int j = 0; j < enemies.size(); j++) {
                    if(bullets.get(i).collide(enemies.get(j))){
                        bullets.remove(i);
                        
                        player.addScore(enemies.get(j).getScore());
                        scoreLabel.setText(String.valueOf(player.getScore()));
                        
                        float index = enemies.get(j).getPosition().getX() * 2 / Main.SIZE;
                        
                        System.out.println(index);
                        spawner.freeEnemySpawnPoint((int)index);
                        enemies.remove(j);
                        
                        isBulletRemoved = true;
                        break;
                    }
                }
            }
        }

        // updates the graphics
        repaint();
    }

    // draws everything
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        for(int i = 0; i < bullets.size(); i++) {
            bullets.get(i).draw(g, this);
        }
        
        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).draw(g, this);
        }
        
        for (int i = 0; i < shields.size(); i++) {
            shields.get(i).draw(g, this);
        }
        
        player.draw(g, this);
    }

    // sets the size, background etc.
    private void setup(){
        this.setBackground(Color.black);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        scoreLabel.setForeground(Color.green);
        this.add(scoreLabel);
    }
}
