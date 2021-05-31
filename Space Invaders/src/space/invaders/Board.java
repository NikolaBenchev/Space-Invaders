/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.invaders;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
    
    public Board(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
        player = new Player(new Position(240, 360), 3, 50);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        switch(e.getKeyCode()){
            case 87: // W 
            case 38:
                player.move(0, -1);
                break;
            case 65: // A
            case 37:
                player.move(-1, 0);
                break;
            case 83: // S
            case 40:
                player.move(0, 1);
                break;
            case 68: // D
            case 39:
                player.move(1, 0);
                break;
            case 32: // Space (shoot)
                //player.shoot(); 
                break;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        player.draw(g);
    }
}
