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
        setup();
        timer = new Timer(delay, this);
        timer.start();
        shields.add(spawner.spawnShield());
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(player.getPosition().getX());
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

    @Override
    public void actionPerformed(ActionEvent e) {
        player.addToCurrentAttackTime(0.005f);
        spawner.addToCurrentSpawnTime(0.005f);
        
        if(spawner.getCurrentSpawnTime() > spawner.getSpawnTime()){
            Enemy newEnemy = spawner.spawnEnemy();
            if(newEnemy != null){
                enemies.add(newEnemy);
                spawner.setCurrentSpawnTime(0);
            }
        }
        

        
        for(int i = 0; i < bullets.size(); i++){
            bullets.get(i).move(0, 1);
            
            boolean isBulletRemoved = false;
            if(bullets.get(i).getPosition().getY() < 0 || bullets.get(i).getPosition().getY() > Main.WINDOW_HEIGHT - Main.SIZE){
                bullets.remove(i);
                isBulletRemoved = true;
            }
            
            if(!isBulletRemoved){
                for (int j = 0; j < shields.size(); j++) {
                    if(bullets.get(i).collide(shields.get(j))){
                        bullets.remove(i);    
                        isBulletRemoved = true;
                        
                        shields.get(j).lowerHp();
                        if (shields.get(j).getHp() == 0)
                            shields.remove(j);
                    }
                }
            }
            
            if(!isBulletRemoved){
                for (int j = 0; j < enemies.size(); j++) {
                    if(bullets.get(i).collide(enemies.get(j))){
                        bullets.remove(i);
                        
                        player.addScore(enemies.get(j).getScore());
                        scoreLabel.setText(String.valueOf(player.getScore()));
                        
                        spawner.freeSpawnPoint(enemies.get(j).getPosition().getX() / Main.SIZE * 2);
                        enemies.remove(j);
                        
                        isBulletRemoved = true;
                        break;
                    }
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
    
    private void setup(){
        this.setBackground(Color.black);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        scoreLabel.setForeground(Color.green);
        this.add(scoreLabel);
    }
}
