package space.invaders;

import java.awt.Dimension;
import javax.swing.*;

public class Board extends JFrame{
    
    private JPanel panel = new JPanel(); 
    public void run(){
        this.setSize(20*Main.SIZE, 15*Main.SIZE);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(panel);
        
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