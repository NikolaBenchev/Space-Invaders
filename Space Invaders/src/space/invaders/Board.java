/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author kolio
 */
public class Board extends JFrame{
    private JPanel panel = new JPanel(); 
    public void run(){
        this.setSize(800, 800);
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