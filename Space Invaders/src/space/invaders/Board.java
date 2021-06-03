/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.invaders;

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

/**
 *
 * @author 2017_stoyanio
 */
public class Board extends JPanel implements KeyListener, ActionListener{

    private int delay = 3;
    private Timer timer;
    private Player player;
    private LinkedList<Bullet> bullets = new LinkedList<>();
    private LinkedList<Enemy> enemies = new LinkedList<>();
    private LinkedList<Shield> shields = new LinkedList<>();
    private float attackTime = 0;   
    private float currentSpawnTime = 0;
    private Spawner spawner = new Spawner();
    private JLabel scoreLabel = new JLabel("0");
    
    public Board(){
        this.setBackground(Color.black);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        scoreLabel.setForeground(Color.green);
        this.add(scoreLabel);
        timer = new Timer(delay, this);
        timer.start();
        player = new Player(new Position(0, Main.WINDOW_HEIGHT - Main.SIZE), 3, Main.SIZE / 2, "player");
        attackTime = player.getAttackSpeed();
        spawner = new Spawner();

        
//        for(int i = 0; i < 15; i++){
//            Enemy newEnemy = spawner.spawnEnemy(new Position(i * Main.SIZE / 2, Main.SIZE));
//            enemies.add(newEnemy);
//        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(player.getPosition().getX());
        switch(e.getKeyCode()){
//            case 87: // W 
//            case 38:
//                player.move(0, -1);
//                break;
            case 65: // A
            case 37:
                player.move(-1, 0);
                break;
//            case 83: // S
//            case 40:
//                player.move(0, 1);
//                break;
            case 68: // D
            case 39:
                player.move(1, 0);
                break;
            case 32: // Space (shoot)
                if(attackTime < player.getAttackSpeed())
                    break;
                Bullet newBullet = player.shoot();
                bullets.add(newBullet);
                attackTime = 0;
                break;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        attackTime += 0.005;
        currentSpawnTime += 0.005;
        
        if(currentSpawnTime > spawner.getSpawnTime()){
            Enemy newEnemy = spawner.spawnEnemy();
            enemies.add(newEnemy);
            currentSpawnTime = 0;
        }
        
        Shield newShield = spawner.spawnShield();
        shields.add(newShield);
        
        for(int i = 0; i < bullets.size(); i++){
            bullets.get(i).move(0, 1);
            
            if(bullets.get(i).getPosition().getY() < 0 || bullets.get(i).getPosition().getY() > Main.WINDOW_HEIGHT - Main.SIZE){
                bullets.remove(i);
                break;
            }
            
            for (int j = 0; j < enemies.size(); j++) {
                if(bullets.get(i).collide(enemies.get(j))){
                    bullets.remove(i);
                    player.addScore(enemies.get(j).getScore());
                    enemies.remove(j);
                    scoreLabel.setText(String.valueOf(player.getScore()));
                    break;
                }
            }
            
            for (int j = 0; j < shields.size(); j++) {
                if(bullets.get(i).collide(shields.get(j))){
                    System.out.println("collision");
                    bullets.remove(i);                   
                    shields.get(j).lowerHp();
                    System.out.println(shields.get(j).getHp());
                    if (shields.get(j).getHp() == 0)
                    {
                        System.out.println("test");
                        shields.remove(j);
                    }
                    break;
                }
            }
            
        }
        
        
        repaint();
    }
    
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
}
