package space.invaders;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

public class Window extends JFrame{
    
    private Board board = new Board();
    
    public Window(){
        this.setSize(Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(board);
        
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }   
}

