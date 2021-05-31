package space.invaders;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Window extends JFrame{
    
    private Board board = new Board();
    
    public Window(){
        this.setSize(20*Main.SIZE, 15*Main.SIZE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(board);
        
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }   
}


/*
    file -> list
    list.add(newScore)
    list.sort();
*/