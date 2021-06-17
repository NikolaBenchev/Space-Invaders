package space.invaders;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
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
    private float enemyShootTime = 3f;
    private Random random = new Random();
    private float currentEnemyShootTime = 0;
    private boolean gameOver = false;
    private float flashTime = 2f;
    
    public Board(){
        // setup the board
        setup();

        // start the timer that updates the game and add 3 shields
        timer = new Timer(delay, this);
        timer.start();
        shields.add(spawner.spawnShield());
        shields.add(spawner.spawnShield());
        shields.add(spawner.spawnShield());
        
        
        enemyShootTime += random.nextFloat();
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
        player.addToCurrentAttackTime(0.01f);
        spawner.addToCurrentEnemySpawnTime(0.01f);
        spawner.addToCurrentShieldSpawnTime(0.01f);
        flashTime += 0.005f;
        
        if(flashTime < 0.05f)
            this.setBackground(Color.red);
        else
            this.setBackground(Color.black);
        
        if (enemies.size() > 0)
        {
            currentEnemyShootTime += 0.005f;
        }
        
        if (currentEnemyShootTime > enemyShootTime)
        {
            int index = random.nextInt(enemies.size());
            Bullet bullet = enemies.get(index).shoot();
            bullets.add(bullet); 
            currentEnemyShootTime = 0;
            enemyShootTime += random.nextFloat() - 0.5f;
        } 

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
                    if(bullets.get(i).collide(enemies.get(j)) && bullets.get(i).getSpeed() < 0){
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
            if(!isBulletRemoved && bullets.get(i).collide(player)) {
                flashTime = 0f;
                player.lowerHp();
                bullets.remove(i);
            }
        }
        
        

        for (int i = 0; i < enemies.size(); i++) {
            enemies.get(i).setCurrentMoveTime(enemies.get(i).getCurrentMoveTime() + 0.005f);            
                
            if (enemies.get(i).getCurrentMoveTime() > enemies.get(i).getMoveTime()){
                int dir = random.nextInt(3);
                System.out.println(dir);
                if(dir == 2 ) dir=-1;
                enemies.get(i).move(dir, 1);               
                float index = enemies.get(i).getPosition().getX() * 2 / Main.SIZE;                        
                spawner.freeEnemySpawnPoint((int)index);
                enemies.get(i).setCurrentMoveTime(0);
            }
            
            for (int j = 0; j < shields.size(); j++) {
                if (enemies.get(i).collide(shields.get(j)))
                {
                    shields.get(j).lowerHp();
                    enemies.remove(i);
                    if (shields.get(j).getHp() == 0)
                    {
                        shields.remove(j);
                    }                  
                }
            }
            
            if(enemies.get(i).getPosition().getY() >= Main.WINDOW_HEIGHT - Main.SIZE){
                flashTime = 0f;
                player.lowerHp();
                enemies.remove(i);
            }
        }
       
        if (player.getHp() == 0) {
            gameOver = true;
        }
        
        if (gameOver){
            Main.addScore(player.getScore());
            player = new Player(new Position(0, Main.WINDOW_HEIGHT - Main.SIZE), 3, Main.SIZE / 2, "player");
            gameOver = false;
            Menu menu = new Menu();
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.dispose();
        } else {
            repaint();
        }
        // updates the graphics
    }

    // draws everything
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        BufferedImage img;
        try {                
            //System.out.println("Space Invaders/src/img/" + name + ".png");
            img = ImageIO.read(new File("img/Heart.png"));
            for(int i = 0; i< player.getHp(); i++){
                g.drawImage(img, -28 + Main.SIZE*i/2, -28, Main.SIZE, Main.SIZE, this);
            }
           
       } catch (IOException ex) {
            System.out.println("not found");
       }
        
        
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
